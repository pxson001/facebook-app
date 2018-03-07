package com.facebook.tigon.tigonapi.observer;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.tigon.tigonapi.TigonError;

@DoNotStrip
/* compiled from: newsfeed_music_story_view */
public interface TigonRequestErrored extends TigonRequestSucceeded {
    @DoNotStrip
    TigonError error();
}
