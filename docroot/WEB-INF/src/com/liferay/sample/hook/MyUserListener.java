package com.liferay.sample.hook;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.model.User;

public class MyUserListener extends BaseModelListener<User> {

    @Override
    public void onAfterCreate(User user) throws ModelListenerException {
        System.out.println(user.getFullName());
    }

    public void onAfterUpdate(User user) throws ModelListenerException {
        System.out.println(user.getFullName());
    }
}