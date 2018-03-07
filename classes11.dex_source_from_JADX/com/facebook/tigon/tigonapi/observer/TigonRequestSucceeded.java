package com.facebook.tigon.tigonapi.observer;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.tigon.tigonapi.TigonSummaryImpl;

@DoNotStrip
/* compiled from: newsfeed_storyset_view */
public interface TigonRequestSucceeded extends TigonRequestResponse {
    @DoNotStrip
    TigonSummaryImpl summary();
}
