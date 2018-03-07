package com.facebook.rtc.helpers;

import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.rtc.fbwebrtc.WebrtcConfigHandler;
import com.facebook.rtc.fbwebrtc.WebrtcSignalingSender;
import com.facebook.rtc.helpers.RtcSignalingHandler.SignalingWakelockListener;
import com.facebook.rtc.logging.WebrtcLoggingHandler;
import com.facebook.webrtc.WebrtcManager;
import javax.inject.Provider;

/* compiled from: server_action */
public class RtcSignalingHandlerProvider extends AbstractAssistedProvider<RtcSignalingHandler> {
    public final RtcSignalingHandler m2857a(Provider<Boolean> provider, SignalingWakelockListener signalingWakelockListener) {
        RtcSignalingHandler rtcSignalingHandler = new RtcSignalingHandler(provider, signalingWakelockListener);
        rtcSignalingHandler.m2867a(WebrtcManager.m9858a((InjectorLike) this), IdBasedSingletonScopeProvider.b(this, 1271), IdBasedLazy.a(this, 393), IdBasedLazy.a(this, 3208), IdBasedLazy.a(this, 517), WebrtcSignalingSender.m2872a((InjectorLike) this), IdBasedSingletonScopeProvider.b(this, 572), WebrtcLoggingHandler.m9451a((InjectorLike) this), WebrtcConfigHandler.m2887a(this), IdBasedProvider.a(this, 10375), Random_InsecureRandomMethodAutoProvider.a(this));
        return rtcSignalingHandler;
    }
}
