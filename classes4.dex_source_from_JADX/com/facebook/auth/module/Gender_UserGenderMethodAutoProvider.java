package com.facebook.auth.module;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.user.gender.Gender;

/* compiled from: websites */
public class Gender_UserGenderMethodAutoProvider extends AbstractProvider<Gender> {
    public Object get() {
        return LoggedInUserModule.a(IdBasedProvider.a(this, 3595));
    }
}
