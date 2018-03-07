package com.facebook.media.common;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.media.MediaItem.MediaType;

/* compiled from: keywords_commerce */
public class MediaLoggerProvider extends AbstractAssistedProvider<MediaLogger> {
    public final MediaLogger m18809a(MediaType mediaType, String str, String str2) {
        return new MediaLogger(mediaType, str, str2, AnalyticsLoggerMethodAutoProvider.a(this));
    }
}
