package com.facebook.friendsharing.souvenirs.mediaitems;

import com.facebook.friendsharing.souvenirs.models.SouvenirItem.Type;
import com.facebook.friendsharing.souvenirs.models.SouvenirModel;
import com.facebook.friendsharing.souvenirs.models.SouvenirPhotoItem;
import com.facebook.friendsharing.souvenirs.models.SouvenirUriItem;
import com.facebook.friendsharing.souvenirs.models.SouvenirVideoItem;
import com.facebook.friendsharing.souvenirs.util.SouvenirModelHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.data.HasLocalMediaData;
import com.facebook.ipc.media.data.LocalMediaData;
import com.facebook.photos.base.media.MediaItemFactory.PhotoItemBuilder;
import com.facebook.photos.base.media.MediaItemFactory.VideoItemBuilder;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.photos.local.LocalMediaCursor;
import com.facebook.photos.local.LocalMediaCursorImp;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.UnmodifiableIterator;
import javax.inject.Inject;

/* compiled from: gravity */
public class SouvenirsMediaItemsHelper {
    private final Lazy<LocalMediaCursor> f10989a;

    public static SouvenirsMediaItemsHelper m11437b(InjectorLike injectorLike) {
        return new SouvenirsMediaItemsHelper(IdBasedLazy.a(injectorLike, 9341));
    }

    @Inject
    public SouvenirsMediaItemsHelper(Lazy<LocalMediaCursor> lazy) {
        this.f10989a = lazy;
    }

    public final ImmutableList<MediaItem> m11439a(SouvenirModel souvenirModel) {
        return m11436a(SouvenirModelHelper.a(souvenirModel));
    }

    private ImmutableList<MediaItem> m11436a(UnmodifiableIterator<SouvenirUriItem> unmodifiableIterator) {
        Builder builder = new Builder();
        while (unmodifiableIterator.hasNext()) {
            builder.c(m11435a((SouvenirUriItem) unmodifiableIterator.next()));
        }
        return builder.b();
    }

    private MediaItem m11435a(SouvenirUriItem souvenirUriItem) {
        LocalMediaData localMediaData;
        boolean z = true;
        if (souvenirUriItem instanceof HasLocalMediaData) {
            LocalMediaData a = ((HasLocalMediaData) souvenirUriItem).a();
            MediaItem a2 = ((LocalMediaCursorImp) this.f10989a.get()).a(a.mMediaStoreId);
            if (a2 != null && souvenirUriItem.c().equals(a2.d().toString())) {
                return a2;
            }
            localMediaData = a;
        } else {
            localMediaData = new LocalMediaData.Builder().a(souvenirUriItem.b()).a();
        }
        if (souvenirUriItem.hw_() == Type.Photo) {
            PhotoItemBuilder photoItemBuilder = new PhotoItemBuilder();
            photoItemBuilder.f = localMediaData;
            return photoItemBuilder.a();
        } else if (souvenirUriItem instanceof SouvenirVideoItem) {
            Preconditions.checkArgument(souvenirUriItem.hw_() == Type.Video);
            r1 = new VideoItemBuilder();
            r1.e = localMediaData;
            VideoItemBuilder videoItemBuilder = r1;
            videoItemBuilder.d = ((SouvenirVideoItem) souvenirUriItem).d();
            return videoItemBuilder.a();
        } else {
            if (souvenirUriItem.hw_() != Type.Video) {
                z = false;
            }
            Preconditions.checkArgument(z);
            r1 = new VideoItemBuilder();
            r1.e = localMediaData;
            return r1.a();
        }
    }

    private static SouvenirUriItem m11434a(MediaItem mediaItem) {
        switch (1.a[mediaItem.m().ordinal()]) {
            case 1:
                return new SouvenirPhotoItem(((PhotoItem) mediaItem).c);
            case 2:
                VideoItem videoItem = (VideoItem) mediaItem;
                return new SouvenirVideoItem(videoItem.c, videoItem.d);
            default:
                throw new IllegalArgumentException("SouvenirsMediaItemsHelper.createUriItem: unknown type <" + mediaItem.m().toString() + ">.  MimeType = " + mediaItem.i());
        }
    }

    public final SouvenirUriItem m11438a(long j) {
        return m11434a((MediaItem) Preconditions.checkNotNull(((LocalMediaCursorImp) this.f10989a.get()).a(j)));
    }
}
