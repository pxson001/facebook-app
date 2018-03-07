package com.facebook.photos.upload.module;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.photo.FbAndroidUnifiedUploadNotificationConfiguration;
import com.facebook.katana.photo.FbAndroidUploadNotificationConfiguration;
import com.facebook.photos.upload.manager.DefaultUploadNotificationConfiguration;
import com.facebook.photos.upload.manager.UnifiedUploadNotificationConfiguration;
import com.facebook.photos.upload.manager.UploadNotificationConfiguration;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: google */
public class UploadNotificationConfigurationMethodAutoProvider extends AbstractProvider<UploadNotificationConfiguration> {
    public static DefaultUploadNotificationConfiguration m21437b(InjectorLike injectorLike) {
        return PhotosUploadModule.m21429a((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (DefaultUploadNotificationConfiguration) FbAndroidUploadNotificationConfiguration.a(injectorLike), (UnifiedUploadNotificationConfiguration) FbAndroidUnifiedUploadNotificationConfiguration.a(injectorLike));
    }

    public Object get() {
        return PhotosUploadModule.m21429a((QeAccessor) QeInternalImplMethodAutoProvider.a(this), (DefaultUploadNotificationConfiguration) FbAndroidUploadNotificationConfiguration.a(this), (UnifiedUploadNotificationConfiguration) FbAndroidUnifiedUploadNotificationConfiguration.a(this));
    }

    public static DefaultUploadNotificationConfiguration m21436a(InjectorLike injectorLike) {
        return m21437b(injectorLike);
    }
}
