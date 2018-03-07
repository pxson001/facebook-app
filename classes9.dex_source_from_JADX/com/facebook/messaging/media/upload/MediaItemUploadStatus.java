package com.facebook.messaging.media.upload;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: local_update_timestamp */
public class MediaItemUploadStatus {
    public static final MediaItemUploadStatus f11846a = new MediaItemUploadStatus(State.NOT_ACTIVE);
    public final State f11847b;
    public final String f11848c;
    public final ListenableFuture<MediaItemUploadStatus> f11849d;
    public final Stage f11850e;
    public final Throwable f11851f;

    /* compiled from: local_update_timestamp */
    public enum Stage {
        STARTED,
        RESIZING,
        ENCRYPTING,
        UPLOADING,
        UNKNOWN
    }

    /* compiled from: local_update_timestamp */
    public enum State {
        NOT_ACTIVE,
        IN_PROGRESS,
        SUCCEEDED,
        FAILED
    }

    public static MediaItemUploadStatus m12462a(Stage stage, ListenableFuture<MediaItemUploadStatus> listenableFuture) {
        Preconditions.checkNotNull(listenableFuture);
        return new MediaItemUploadStatus(State.IN_PROGRESS, null, stage, listenableFuture, null);
    }

    public static MediaItemUploadStatus m12464a(String str) {
        return new MediaItemUploadStatus(State.SUCCEEDED, str, null, null, null);
    }

    public static MediaItemUploadStatus m12463a(Stage stage, Throwable th) {
        return new MediaItemUploadStatus(State.FAILED, null, stage, null, th);
    }

    private MediaItemUploadStatus(State state, String str, Stage stage, ListenableFuture<MediaItemUploadStatus> listenableFuture, Throwable th) {
        this.f11847b = state;
        this.f11848c = str;
        this.f11849d = listenableFuture;
        this.f11850e = stage;
        this.f11851f = th;
    }

    private MediaItemUploadStatus(State state) {
        this.f11847b = state;
        this.f11848c = null;
        this.f11851f = null;
        this.f11849d = null;
        this.f11850e = null;
    }
}
