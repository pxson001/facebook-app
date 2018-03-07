package com.facebook.auth.module;

import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.user.model.User;

/* compiled from: supports_offline_posting */
public class User_ViewerContextUserMethodAutoProvider extends AbstractProvider<User> {
    public Object get() {
        return LoggedInUserModule.a(ViewerContextMethodAutoProvider.b(this), IdBasedProvider.a(this, 3595), ProductMethodAutoProvider.b(this));
    }
}
