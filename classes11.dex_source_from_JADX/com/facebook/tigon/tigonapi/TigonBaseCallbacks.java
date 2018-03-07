package com.facebook.tigon.tigonapi;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.tigon.iface.TigonRequest;

@DoNotStrip
/* compiled from: notif_readness */
public interface TigonBaseCallbacks {
    @DoNotStrip
    void onEOM(TigonSummaryImpl tigonSummaryImpl);

    @DoNotStrip
    void onError(TigonError tigonError, TigonSummaryImpl tigonSummaryImpl);

    @DoNotStrip
    void onResponse(TigonResponse tigonResponse);

    @DoNotStrip
    void onStarted(TigonRequest tigonRequest);

    @DoNotStrip
    void onUploadProgress(long j, long j2);

    @DoNotStrip
    void onWillRetry(TigonError tigonError, TigonSummaryImpl tigonSummaryImpl);
}
