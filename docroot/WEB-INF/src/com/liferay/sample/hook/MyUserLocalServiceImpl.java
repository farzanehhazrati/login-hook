package com.liferay.sample.hook;

import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserLocalServiceWrapper;

public class MyUserLocalServiceImpl extends UserLocalServiceWrapper {
	
	public MyUserLocalServiceImpl(UserLocalService userLocalService) {
		super(userLocalService);
		// TODO Auto-generated constructor stub
	}
	@Override

	public com.liferay.portal.model.User addUser(
			com.liferay.portal.model.User user)
			throws com.liferay.portal.kernel.exception.SystemException {
		
		System.out.println("MyUserLocalServiceImpl  addUser1");
			return super.addUser(user);
		}
 @Override
		public com.liferay.portal.model.User addUser(long creatorUserId,
				long companyId, boolean autoPassword, java.lang.String password1,
				java.lang.String password2, boolean autoScreenName,
				java.lang.String screenName, java.lang.String emailAddress,
				long facebookId, java.lang.String openId, java.util.Locale locale,
				java.lang.String firstName, java.lang.String middleName,
				java.lang.String lastName, int prefixId, int suffixId, boolean male,
				int birthdayMonth, int birthdayDay, int birthdayYear,
				java.lang.String jobTitle, long[] groupIds, long[] organizationIds,
				long[] roleIds, long[] userGroupIds, boolean sendEmail,
				com.liferay.portal.service.ServiceContext serviceContext)
				throws com.liferay.portal.kernel.exception.PortalException,
					com.liferay.portal.kernel.exception.SystemException {
	    	
	    	System.out.println("MyUserLocalServiceImpl  addUser");
				return super.addUser(creatorUserId, companyId,
					autoPassword, password1, password2, autoScreenName, screenName,
					emailAddress, facebookId, openId, locale, firstName, middleName,
					lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay,
					birthdayYear, jobTitle, groupIds, organizationIds, roleIds,
					userGroupIds, sendEmail, serviceContext);
			}
}
