package com.facebook.zero.sdk.request;

import com.facebook.inject.InjectorLike;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.facebook.zero.sdk.rewrite.ZeroUrlRewriteRule;
import com.facebook.zero.sdk.token.ZeroToken;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.android.launcher.action.INSTALL_SHORTCUT */
public class ZeroRequestHandlerBase implements ZeroRequestHandler {
    public static ZeroRequestHandlerBase m10694a(InjectorLike injectorLike) {
        return new ZeroRequestHandlerBase();
    }

    public final ListenableFuture<ZeroToken> m10699a(FetchZeroTokenRequestParams fetchZeroTokenRequestParams, FutureCallback<ZeroToken> futureCallback) {
        futureCallback.onSuccess(new ZeroToken("TestCampaign", "registered", "Jack's Test Carrier", "1234", "noLogoForNow", 3600, ImmutableSet.of(ZeroFeatureKey.LEAVING_APP_INTERSTITIAL, ZeroFeatureKey.ZERO_INDICATOR, ZeroFeatureKey.EXTERNAL_URLS_INTERSTITIAL), ImmutableList.of(new ZeroUrlRewriteRule("^(https?)://(www|web|z-m-www)\\.([0-9a-zA-Z\\.-]*)?facebook\\.com(:?[0-9]{0,5})($|\\?.*$|/.*$)", "$1://web.$3facebook.com$4$5")), "unavailable", ImmutableList.of(), "TestHash", 1000, "FastTokenHash"));
        return null;
    }

    public final ListenableFuture<ZeroIndicatorData> m10695a(FetchZeroIndicatorRequestParams fetchZeroIndicatorRequestParams, FutureCallback<ZeroIndicatorData> futureCallback) {
        futureCallback.onSuccess(new ZeroIndicatorData("ZeroIndicatorData", "Zero Rating", "You are browsing for free courtesy of [carrier]", "Learn more", "http://www.facebook.com"));
        return null;
    }

    public final ListenableFuture<FetchZeroOptinContentRequestResult> m10698a(FetchZeroOptinContentRequestParams fetchZeroOptinContentRequestParams, FutureCallback<FetchZeroOptinContentRequestResult> futureCallback) {
        return null;
    }

    public final ListenableFuture<ZeroOptinResult> m10700a(ZeroOptinParams zeroOptinParams, FutureCallback<ZeroOptinResult> futureCallback) {
        return null;
    }

    public final ListenableFuture<ZeroOptoutResult> m10701a(ZeroOptoutParams zeroOptoutParams, FutureCallback<ZeroOptoutResult> futureCallback) {
        return null;
    }

    public final ListenableFuture<FetchZeroInterstitialEligibilityResult> m10697a(FetchZeroInterstitialEligibilityParams fetchZeroInterstitialEligibilityParams, FutureCallback<FetchZeroInterstitialEligibilityResult> futureCallback) {
        return null;
    }

    public final ListenableFuture<FetchZeroInterstitialContentResult> m10696a(FetchZeroInterstitialContentParams fetchZeroInterstitialContentParams, FutureCallback<FetchZeroInterstitialContentResult> futureCallback) {
        return null;
    }
}
