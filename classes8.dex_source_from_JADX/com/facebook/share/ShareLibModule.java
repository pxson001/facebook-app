package com.facebook.share;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.share.annotations.ShouldOpenLinkInExternalActivity;

@InjectorModule
/* compiled from: media_set_display_activity_titlebard_label_resource_id_extra */
public class ShareLibModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @ShouldOpenLinkInExternalActivity
    static Boolean m10695a() {
        return Boolean.valueOf(false);
    }
}
