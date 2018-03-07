package com.facebook.selfupdate;

import com.facebook.appupdate.AppUpdateOperationFactory;
import com.facebook.inject.AbstractProvider;

/* compiled from: hide_cancel_button */
public class AppUpdateOperationFactoryMethodAutoProvider extends AbstractProvider<AppUpdateOperationFactory> {
    public Object get() {
        return SelfUpdateModule.b(AppUpdateInjectorMethodAutoProvider.a(this));
    }
}
