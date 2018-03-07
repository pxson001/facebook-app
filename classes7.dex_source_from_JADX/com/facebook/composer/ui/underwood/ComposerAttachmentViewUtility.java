package com.facebook.composer.ui.underwood;

import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.bitmaps.Dimension;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.photos.base.media.MediaAspectRatioUtil;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.base.media.VideoItem;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: composer/?view={live} */
public class ComposerAttachmentViewUtility {
    private final BitmapUtils f17118a;

    /* compiled from: composer/?view={live} */
    /* synthetic */ class C13941 {
        static final /* synthetic */ int[] f17117a = new int[MediaType.values().length];

        static {
            try {
                f17117a[MediaType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17117a[MediaType.PHOTO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static ComposerAttachmentViewUtility m21071b(InjectorLike injectorLike) {
        return new ComposerAttachmentViewUtility(BitmapUtils.a(injectorLike));
    }

    @Inject
    public ComposerAttachmentViewUtility(BitmapUtils bitmapUtils) {
        this.f17118a = bitmapUtils;
    }

    public final float m21073a(MediaItem mediaItem) {
        return m21069a(mediaItem.f(), mediaItem);
    }

    private float m21069a(Uri uri, MediaItem mediaItem) {
        return m21068a(uri, mediaItem.m(), mediaItem);
    }

    public final float m21072a(Uri uri, MediaType mediaType) {
        return m21068a(uri, mediaType, null);
    }

    private float m21068a(Uri uri, MediaType mediaType, MediaItem mediaItem) {
        Preconditions.checkNotNull(uri);
        float k;
        switch (C13941.f17117a[mediaType.ordinal()]) {
            case 1:
                VideoItem videoItem = (VideoItem) mediaItem;
                k = videoItem == null ? 0.0f : videoItem.k();
                if (k == Float.NaN || k <= 0.0f) {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(uri.getPath());
                    Integer a = MediaAspectRatioUtil.a(mediaMetadataRetriever.extractMetadata(19));
                    Integer a2 = MediaAspectRatioUtil.a(mediaMetadataRetriever.extractMetadata(18));
                    if (a2 == null || a == null || a2.intValue() == 0 || a.intValue() == 0) {
                        mediaMetadataRetriever.release();
                        k = 1.3333334f;
                    } else {
                        Integer a3 = MediaAspectRatioUtil.a(mediaMetadataRetriever.extractMetadata(24));
                        mediaMetadataRetriever.release();
                        k = MediaAspectRatioUtil.a(a2.intValue(), a.intValue(), a3 != null ? a3.intValue() : 0);
                    }
                }
                return k;
            case 2:
                BitmapUtils bitmapUtils = this.f17118a;
                PhotoItem photoItem = (PhotoItem) mediaItem;
                k = photoItem == null ? 0.0f : photoItem.k();
                if (k <= 0.0f || k == Float.NaN) {
                    Dimension a4 = BitmapUtils.a(uri.getPath());
                    if (a4 == null || (a4.a == 0 && a4.b == 0)) {
                        k = 1.0f;
                    } else {
                        int g = photoItem == null ? -1 : photoItem.g();
                        if (g == -1) {
                            g = BitmapUtils.b(uri.getPath());
                        }
                        k = MediaAspectRatioUtil.a(a4.b, a4.a, g);
                    }
                }
                return k;
            default:
                throw new IllegalArgumentException("ComposerAttachmentViewUtility.getMediaAspectRatio: unknown media type " + mediaType);
        }
    }

    public static ComposerAttachmentViewUtility m21070a(InjectorLike injectorLike) {
        return m21071b(injectorLike);
    }
}
