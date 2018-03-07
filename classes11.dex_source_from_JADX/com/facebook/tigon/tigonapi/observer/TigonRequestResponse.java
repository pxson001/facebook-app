package com.facebook.tigon.tigonapi.observer;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.tigon.tigonapi.TigonResponse;

@DoNotStrip
/* compiled from: newsfeed_video_storyset_header_icon */
public interface TigonRequestResponse extends TigonRequestStarted {
    @DoNotStrip
    TigonResponse response();
}
