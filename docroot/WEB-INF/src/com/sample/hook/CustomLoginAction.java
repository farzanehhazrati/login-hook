package com.sample.hook;

import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.captcha.CaptchaMaxChallengesException;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

public class CustomLoginAction extends com.liferay.portal.kernel.struts.BaseStrutsPortletAction {
	public static final String RETRY_COUNT = "_retry_count";


	@Override
	public void processAction(StrutsPortletAction originalStrutsPortletAction,
	PortletConfig portletConfig, ActionRequest actionRequest,
	ActionResponse actionResponse) throws Exception {
		
		//System.out.println(":::::::::::::::::processAction:::::::::::::::");
		Integer retryCount = (Integer)actionRequest.getPortletSession().getAttribute(RETRY_COUNT);
		try
		{
			
			if (retryCount == null)
			{
				retryCount = 0;
			}
					
			//System.out.println("before retryCount:" + retryCount);
			
			if (retryCount >= 0)
			{
				CaptchaUtil.check(actionRequest);
			}
			originalStrutsPortletAction.processAction(originalStrutsPortletAction, portletConfig, actionRequest,actionResponse);
			
		}
		catch(CaptchaTextException cause)
		{
			SessionErrors.add(actionRequest, cause.getClass());
		}
		
		if (SessionErrors.size(actionRequest) > 0) //any errors occur
		{
			retryCount ++;
			actionRequest.getPortletSession().setAttribute(RETRY_COUNT, retryCount);
			//System.out.println("after retryCount:" + retryCount);
		}
		else  //clear the retryCount attribute
		{
			actionRequest.getPortletSession().removeAttribute(RETRY_COUNT);
		}

	}


	@Override
	public String render(StrutsPortletAction originalStrutsPortletAction,
	PortletConfig portletConfig, RenderRequest renderRequest,
	RenderResponse renderResponse) throws Exception {

	return originalStrutsPortletAction.render(originalStrutsPortletAction,
	portletConfig, renderRequest, renderResponse);
	}
	
	@Override
	public void serveResource(StrutsPortletAction arg0, PortletConfig arg1,
			ResourceRequest arg2, ResourceResponse arg3) throws Exception {
		// TODO Auto-generated method stub
		 CaptchaUtil.serveImage(arg2, arg3);
	}
	
	
}
