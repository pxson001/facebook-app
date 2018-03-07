package com.facebook.zero.sdk.request;

import com.facebook.zero.sdk.token.ZeroToken;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: fonts/HelveticaNeue-Medium.ttf */
public interface ZeroRequestHandler {
    ListenableFuture<ZeroIndicatorData> mo3440a(FetchZeroIndicatorRequestParams fetchZeroIndicatorRequestParams, FutureCallback<ZeroIndicatorData> futureCallback);

    ListenableFuture<FetchZeroInterstitialContentResult> mo3441a(FetchZeroInterstitialContentParams fetchZeroInterstitialContentParams, FutureCallback<FetchZeroInterstitialContentResult> futureCallback);

    ListenableFuture<FetchZeroInterstitialEligibilityResult> mo3442a(FetchZeroInterstitialEligibilityParams fetchZeroInterstitialEligibilityParams, FutureCallback<FetchZeroInterstitialEligibilityResult> futureCallback);

    ListenableFuture<FetchZeroOptinContentRequestResult> mo3443a(FetchZeroOptinContentRequestParams fetchZeroOptinContentRequestParams, FutureCallback<FetchZeroOptinContentRequestResult> futureCallback);

    ListenableFuture<ZeroToken> mo3444a(FetchZeroTokenRequestParams fetchZeroTokenRequestParams, FutureCallback<ZeroToken> futureCallback);

    ListenableFuture<ZeroOptinResult> mo3445a(ZeroOptinParams zeroOptinParams, FutureCallback<ZeroOptinResult> futureCallback);

    ListenableFuture<ZeroOptoutResult> mo3446a(ZeroOptoutParams zeroOptoutParams, FutureCallback<ZeroOptoutResult> futureCallback);
}
