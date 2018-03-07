package com.facebook.feedplugins.musicstory.providers;

import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feedplugins.musicstory.SingleSongData;
import com.facebook.feedplugins.musicstory.SingleSongPartDefinition.PersistentState;
import com.facebook.feedplugins.musicstory.utils.MusicStoryLogger;

/* compiled from: com.onavo.android.onavoid */
public interface MusicProviderBuilder {
    MusicProvider mo244a(SingleSongData singleSongData, MusicStoryLogger musicStoryLogger, HasInvalidate hasInvalidate, PersistentState persistentState);

    String mo245a();

    String mo246b();
}
