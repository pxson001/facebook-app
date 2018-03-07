package com.facebook.friendsharing.souvenirs.util;

import android.database.Cursor;
import com.facebook.friendsharing.souvenirs.models.SouvenirMetadata;
import com.facebook.friendsharing.souvenirs.models.SouvenirMetadata.Builder;
import com.facebook.friendsharing.souvenirs.models.SouvenirModel;
import com.facebook.friendsharing.souvenirs.models.SouvenirModel$Builder;
import com.facebook.friendsharing.souvenirs.models.SouvenirPhotoItem;
import com.facebook.friendsharing.souvenirs.models.SouvenirVideoItem;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.SupportedMediaType;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.photos.local.LocalMediaCursorImp;
import java.util.List;
import javax.inject.Inject;

/* compiled from: RATE_ON_PLAY_STORE */
public class TestSouvenirCreator {
    private static final SouvenirMetadata f24231a;
    private final LocalMediaCursorImp f24232b;

    static {
        Builder builder = new Builder();
        builder.f24063a = "";
        builder = builder;
        builder.f24064b = "Test souvenir";
        f24231a = builder.m26168a();
    }

    @Inject
    public TestSouvenirCreator(LocalMediaCursorImp localMediaCursorImp) {
        this.f24232b = localMediaCursorImp;
    }

    public final SouvenirModel m26464a() {
        Cursor a = this.f24232b.a(SupportedMediaType.ALL, null);
        try {
            List<MediaItem> a2 = this.f24232b.a(a, 20);
            SouvenirModel$Builder a3 = new SouvenirModel$Builder().m26178a(f24231a);
            for (MediaItem mediaItem : a2) {
                if (mediaItem instanceof PhotoItem) {
                    a3.m26177a(new SouvenirPhotoItem(mediaItem.a()));
                } else if (mediaItem instanceof VideoItem) {
                    a3.m26177a(new SouvenirVideoItem(mediaItem.a(), ((VideoItem) mediaItem).r()));
                }
            }
            return a3.m26179a();
        } finally {
            a.close();
        }
    }
}
