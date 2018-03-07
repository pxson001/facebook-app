package com.facebook.messaging.analytics.base;

import com.facebook.common.util.TriState;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.annotations.IsAnalyticsEnabled;
import com.facebook.user.model.User;
import javax.annotation.Nullable;

@InjectorModule
/* compiled from: onTouchEndCapture */
public class MessagingAnalyticsBaseModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsAnalyticsEnabled
    static TriState m9414a(@Nullable User user, Boolean bool) {
        if (user == null) {
            return TriState.UNSET;
        }
        if (bool.booleanValue()) {
            return TriState.YES;
        }
        return TriState.NO;
    }
}
