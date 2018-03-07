package com.facebook.messaging.audio.playback;

import android.net.Uri;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: orca_upload_resize_failure */
public class FetchAudioParams {
    public final Uri f8089a;

    public FetchAudioParams(Uri uri) {
        Preconditions.checkNotNull(uri);
        Preconditions.checkArgument(uri.isAbsolute());
        this.f8089a = uri;
    }

    public final Uri m8340a() {
        return this.f8089a;
    }

    public final AudioCacheKey m8341b() {
        return new AudioCacheKey(this.f8089a);
    }
}
