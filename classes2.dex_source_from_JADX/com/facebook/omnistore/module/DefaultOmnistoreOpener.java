package com.facebook.omnistore.module;

import android.content.Context;
import com.facebook.auth.module.String_ViewerContextUserIdMethodAutoProvider;
import com.facebook.config.application.FbAppType;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.omnistore.MqttProtocolProvider;
import com.facebook.omnistore.Omnistore;
import com.facebook.omnistore.OmnistoreErrorReporter;
import com.facebook.omnistore.logger.FbOmnistoreErrorReporter;
import com.facebook.omnistore.mqtt.MqttProtocolProviderMethodAutoProvider;
import com.facebook.omnistore.util.DeviceIdUtil;
import com.facebook.xanalytics.XAnalyticsProvider;
import com.facebook.xanalytics.provider.DefaultXAnalyticsProvider;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: mName= */
public class DefaultOmnistoreOpener {
    private final Context mContext;
    private final Provider<Boolean> mDontDeleteDbOnOpenError;
    private final FbAppType mFbAppType;
    private final Provider<Boolean> mIsConnectMessageSubscriptions;
    private final Provider<Boolean> mIsOmnistoreIntegrityEnabled;
    private final MqttProtocolProvider mMqttProtocolProvider;
    private final OmnistoreErrorReporter mOmnistoreErrorReporter;
    private final String mViewerContextUserId;
    private final DefaultXAnalyticsProvider mXAnalyticsProvider;

    public static DefaultOmnistoreOpener m22131xed2aa177(InjectorLike injectorLike) {
        return new DefaultOmnistoreOpener(MqttProtocolProviderMethodAutoProvider.m22133xfe16c43b(injectorLike), FbOmnistoreErrorReporter.m22402x8d6f1acc(injectorLike), DefaultXAnalyticsProvider.m22403a(injectorLike), (Context) injectorLike.getInstance(Context.class), (FbAppType) injectorLike.getInstance(FbAppType.class), String_ViewerContextUserIdMethodAutoProvider.m5004b(injectorLike), IdBasedProvider.m1811a(injectorLike, 4231), IdBasedProvider.m1811a(injectorLike, 4230), IdBasedProvider.m1811a(injectorLike, 4229));
    }

    @Inject
    public DefaultOmnistoreOpener(MqttProtocolProvider mqttProtocolProvider, OmnistoreErrorReporter omnistoreErrorReporter, XAnalyticsProvider xAnalyticsProvider, Context context, FbAppType fbAppType, String str, Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3) {
        this.mMqttProtocolProvider = mqttProtocolProvider;
        this.mOmnistoreErrorReporter = omnistoreErrorReporter;
        this.mXAnalyticsProvider = xAnalyticsProvider;
        this.mContext = context;
        this.mFbAppType = fbAppType;
        this.mViewerContextUserId = str;
        this.mDontDeleteDbOnOpenError = provider;
        this.mIsOmnistoreIntegrityEnabled = provider2;
        this.mIsConnectMessageSubscriptions = provider3;
    }

    public Omnistore openOmnistoreInstance() {
        String file = new File(this.mContext.getDir("omnistore", 0), "omnistore_" + this.mViewerContextUserId + "_v01.db").toString();
        String deviceId = DeviceIdUtil.getDeviceId(this.mContext, Long.valueOf(Long.parseLong(this.mFbAppType.c())));
        if (deviceId == null) {
            deviceId = "";
        }
        return Omnistore.open(file, deviceId, this.mMqttProtocolProvider, this.mOmnistoreErrorReporter, this.mXAnalyticsProvider.f15720c, !((Boolean) this.mDontDeleteDbOnOpenError.get()).booleanValue(), ((Boolean) this.mIsOmnistoreIntegrityEnabled.get()).booleanValue(), ((Boolean) this.mIsConnectMessageSubscriptions.get()).booleanValue());
    }
}
