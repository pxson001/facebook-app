package com.facebook.fbreact.goodwill;

import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.fbreact.fragment.ImmersiveReactFragmentHooks;
import com.facebook.goodwill.analytics.GoodwillAnalyticsLogger;
import com.facebook.goodwill.publish.GoodwillPublishUploadHandler;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.react.bridge.ReactApplicationContext;

/* compiled from: extra_should_show_qp_for_admin */
public class GoodwillVideoNativeModuleProvider extends AbstractAssistedProvider<GoodwillVideoNativeModule> {
    public final GoodwillVideoNativeModule m8523a(ReactApplicationContext reactApplicationContext) {
        return new GoodwillVideoNativeModule(ImmersiveReactFragmentHooks.a(this), GoodwillPublishUploadHandler.b(this), ViewerContextMethodAutoProvider.b(this), JsonPluginConfigSerializer.b(this), BitmapUtils.a(this), GoodwillAnalyticsLogger.a(this), reactApplicationContext);
    }
}
