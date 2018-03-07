package com.facebook.messaging.photoreminders.omnistore;

import com.facebook.auth.component.LoginComponent;
import com.facebook.common.init.INeedInit;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: mProjectName */
public class PhotoRemindersOmnistoreSubscriptionInitializer implements LoginComponent, INeedInit {
    private final PhotoRemindersOmnistoreUtil f8593a;

    public static PhotoRemindersOmnistoreSubscriptionInitializer m8845b(InjectorLike injectorLike) {
        return new PhotoRemindersOmnistoreSubscriptionInitializer(PhotoRemindersOmnistoreUtil.m8840b(injectorLike));
    }

    @Inject
    public PhotoRemindersOmnistoreSubscriptionInitializer(PhotoRemindersOmnistoreUtil photoRemindersOmnistoreUtil) {
        this.f8593a = photoRemindersOmnistoreUtil;
    }

    public final BatchComponent mo143a() {
        this.f8593a.m8841a();
        return null;
    }

    public void init() {
        this.f8593a.m8841a();
    }
}
