package com.facebook.tigon.tigonapi.observer;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* compiled from: nguage_switch */
public interface TigonRequestStarted extends TigonRequestAdded {
    @DoNotStrip
    int attempts();
}
