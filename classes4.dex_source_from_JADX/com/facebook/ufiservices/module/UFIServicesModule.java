package com.facebook.ufiservices.module;

import com.facebook.attachments.AttachmentStyleSupportDeclaration;
import com.facebook.attachments.AttachmentStyleUtil;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.ufiservices.ui.UfiSupportedAttachmentStyle;
import java.util.Set;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: dc_type */
public class UFIServicesModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @UfiSupportedAttachmentStyle
    @Singleton
    static AttachmentStyleUtil m14997a(Set<AttachmentStyleSupportDeclaration> set) {
        return new AttachmentStyleUtil(set);
    }
}
