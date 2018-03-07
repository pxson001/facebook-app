package com.facebook.photos.base.media;

import com.facebook.ipc.media.MediaItem;

/* compiled from: initial_text */
public interface MediaItemsOperator {

    /* compiled from: initial_text */
    public enum SelectMode {
        PRESELECTED,
        SELECT,
        DESELECT
    }

    void m20112a();

    void m20113a(MediaItem mediaItem, SelectMode selectMode);

    void m20114b();
}
