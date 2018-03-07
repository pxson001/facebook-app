package com.facebook.photos.upload.module;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.upload.abtest.ImmediateRetryTimingQEConfig;
import com.facebook.photos.upload.retry.ImmediateRetryPolicy;
import com.facebook.photos.upload.uploaders.WakeLockHandler;

/* compiled from: graphObjectCouponClaim */
public class ImmediateRetryPolicyMethodAutoProvider extends AbstractProvider<ImmediateRetryPolicy> {
    public static ImmediateRetryPolicy m21428b(InjectorLike injectorLike) {
        return PhotosUploadModule.m21430a(ImmediateRetryTimingQEConfig.m21204a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), FbNetworkManager.a(injectorLike), WakeLockHandler.m22168a(injectorLike));
    }

    public Object get() {
        return PhotosUploadModule.m21430a(ImmediateRetryTimingQEConfig.m21204a(this), DefaultAndroidThreadUtil.b(this), FbNetworkManager.a(this), WakeLockHandler.m22168a(this));
    }
}
