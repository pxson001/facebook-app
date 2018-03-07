package com.facebook.photos.upload.module;

import com.facebook.bitmaps.ImageResizingMode;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.compost.abtest.ExperimentsForCompostAbTestModule;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.photos.base.analytics.upload.PhotoUploadResizeScheme;
import com.facebook.photos.prefs.PhotosPrefKeys;
import com.facebook.photos.upload.abtest.ImmediateRetryTimingQEConfig;
import com.facebook.photos.upload.abtest.ImmediateRetryTimingQuickExperiment.Config;
import com.facebook.photos.upload.annotation.PhotosHighDefUploadSettingValue;
import com.facebook.photos.upload.annotation.VideoUploadForceRawTranscodingBitrateEnabled;
import com.facebook.photos.upload.manager.DefaultUploadNotificationConfiguration;
import com.facebook.photos.upload.manager.UnifiedUploadNotificationConfiguration;
import com.facebook.photos.upload.operation.UploadOperationUuid;
import com.facebook.photos.upload.retry.ImmediateRetryPolicy;
import com.facebook.photos.upload.retry.UploaderImmediateRetryPolicy;
import com.facebook.photos.upload.uploaders.WakeLockHandler;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.qe.api.QeAccessor;

@InjectorModule
/* compiled from: graphObjectComments */
public class PhotosUploadModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @PhotoUploadResizeScheme
    public static String m21433a(ImageResizingMode imageResizingMode) {
        return imageResizingMode.toString() + "_exact";
    }

    @ProviderMethod
    @UploadOperationUuid
    static String m21432a() {
        return SafeUUIDGenerator.a().toString();
    }

    @ProviderMethod
    @VideoUploadForceRawTranscodingBitrateEnabled
    public static Boolean m21434b() {
        return Boolean.valueOf(false);
    }

    @ProviderMethod
    @PhotosHighDefUploadSettingValue
    public static Boolean m21431a(FbSharedPreferences fbSharedPreferences) {
        boolean z = false;
        if (fbSharedPreferences.a() && fbSharedPreferences.a(PhotosPrefKeys.j, false)) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @ProviderMethod
    static DefaultUploadNotificationConfiguration m21429a(QeAccessor qeAccessor, DefaultUploadNotificationConfiguration defaultUploadNotificationConfiguration, UnifiedUploadNotificationConfiguration unifiedUploadNotificationConfiguration) {
        return qeAccessor.a(ExperimentsForCompostAbTestModule.f8107z, false) ? unifiedUploadNotificationConfiguration : defaultUploadNotificationConfiguration;
    }

    @ProviderMethod
    static ImmediateRetryPolicy m21430a(ImmediateRetryTimingQEConfig immediateRetryTimingQEConfig, DefaultAndroidThreadUtil defaultAndroidThreadUtil, FbNetworkManager fbNetworkManager, WakeLockHandler wakeLockHandler) {
        return new UploaderImmediateRetryPolicy(defaultAndroidThreadUtil, ((Config) immediateRetryTimingQEConfig.f13522a).f13525a, immediateRetryTimingQEConfig.m21207c(), fbNetworkManager, wakeLockHandler);
    }
}
