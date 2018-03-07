package com.facebook.video.engine;

import android.net.Uri;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.video.view.exo.PlaybackPreferences;

/* compiled from: messenger_recycler_view_tvmf_android */
public class ExoPlayerPreparerProvider extends AbstractAssistedProvider<ExoPlayerPreparer> {
    public final ExoPlayerPreparer m20202a(Uri uri, Uri uri2, String str, Uri uri3, PlaybackPreferences playbackPreferences, boolean z) {
        return new ExoPlayerPreparer(uri, uri2, str, uri3, playbackPreferences, z, ExoPlayerBuilder.b(this), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(this));
    }
}
