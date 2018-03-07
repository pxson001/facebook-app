package com.facebook.tigon.tigonapi.observer;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.tigon.iface.TigonRequest;

@DoNotStrip
/* compiled from: no_amount_raised */
public interface TigonRequestAdded {
    @DoNotStrip
    long requestId();

    @DoNotStrip
    TigonRequest submittedRequest();
}
