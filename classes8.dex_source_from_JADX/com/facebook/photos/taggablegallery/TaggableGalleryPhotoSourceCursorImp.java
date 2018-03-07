package com.facebook.photos.taggablegallery;

import android.database.Cursor;
import com.facebook.inject.Assisted;
import com.facebook.ipc.media.MediaIdKey;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.local.LocalMediaCursorImp;
import com.facebook.photos.local.MediaCursorUtil;
import com.facebook.photos.taggablegallery.PhotoGalleryContent.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: selected_place_id */
public class TaggableGalleryPhotoSourceCursorImp implements TaggableGalleryPhotoSource {
    private Cursor f3423a;
    private MediaCursorUtil f3424b;
    private LocalMediaCursorImp f3425c;

    @Inject
    public TaggableGalleryPhotoSourceCursorImp(@Assisted Cursor cursor, MediaCursorUtil mediaCursorUtil, LocalMediaCursorImp localMediaCursorImp) {
        this.f3423a = cursor;
        this.f3424b = mediaCursorUtil;
        this.f3425c = localMediaCursorImp;
    }

    public final PhotoGalleryContent mo185a(int i) {
        PhotoItem photoItem;
        this.f3423a.moveToPosition(i);
        long j = this.f3423a.getLong(0);
        MediaItem a = this.f3425c.a(j);
        if (a != null) {
            photoItem = (PhotoItem) a;
        } else {
            photoItem = (PhotoItem) this.f3425c.a(j, this.f3423a, i, 5);
        }
        return Builder.m3368a(photoItem).m3370a();
    }

    @Nullable
    public final Integer mo186a(MediaIdKey mediaIdKey) {
        this.f3423a.moveToPosition(-1);
        while (this.f3423a.moveToNext()) {
            Cursor cursor = this.f3423a;
            if (cursor.getLong(cursor.getColumnIndex("_id")) == mediaIdKey.b) {
                return Integer.valueOf(this.f3423a.getPosition());
            }
        }
        return null;
    }

    public final int mo184a() {
        if (this.f3423a.isClosed()) {
            return 0;
        }
        return this.f3423a.getCount();
    }
}
