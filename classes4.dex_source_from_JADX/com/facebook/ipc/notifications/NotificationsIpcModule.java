package com.facebook.ipc.notifications;

import com.facebook.common.build.BuildConstants;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;

@InjectorModule
/* compiled from: mode */
public class NotificationsIpcModule extends AbstractLibraryModule {
    public static final String f7613a = (BuildConstants.n() + ".provider.GraphQLNotificationsProvider");

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }
}
