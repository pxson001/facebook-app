package com.facebook.storyteller;

import android.database.Cursor;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.SupportedMediaType;
import com.facebook.ipc.media.data.MediaData.Type;
import com.facebook.ipc.media.data.MimeType;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.photos.local.LocalMediaCursor;
import com.facebook.storyteller.models.Location;
import com.facebook.storyteller.models.Photo;
import com.facebook.storyteller.models.StoryTellerItem;
import com.facebook.storyteller.models.Video;
import com.google.flatbuffers.FlatBufferBuilder;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: mediaItem path is null */
public class AssetProviderUtil {

    /* compiled from: mediaItem path is null */
    /* synthetic */ class C09321 {
        static final /* synthetic */ int[] f9018a = new int[Type.values().length];

        static {
            try {
                f9018a[Type.Photo.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9018a[Type.Video.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    @Nullable
    public static List<MediaItem> m10743a(LocalMediaCursor localMediaCursor, long j, int i) {
        List<MediaItem> list = null;
        Cursor a = localMediaCursor.a(SupportedMediaType.ALL, null, "datetaken > " + j, "datetaken");
        if (a != null) {
            try {
                list = localMediaCursor.a(a, i);
            } finally {
                a.close();
            }
        }
        return list;
    }

    public static int m10742a(FlatBufferBuilder flatBufferBuilder, MediaItem mediaItem) {
        int a;
        byte b;
        int a2 = flatBufferBuilder.a(mediaItem.b().mId);
        switch (C09321.f9018a[mediaItem.b().mType.ordinal()]) {
            case 1:
                a = m10741a(mediaItem, flatBufferBuilder);
                b = (byte) 1;
                break;
            case 2:
                a = m10744b(mediaItem, flatBufferBuilder);
                b = (byte) 2;
                break;
            default:
                throw new UnsupportedOperationException("Unknown media: " + mediaItem.toString());
        }
        StoryTellerItem.a(flatBufferBuilder);
        flatBufferBuilder.c(0, a2, 0);
        flatBufferBuilder.a(1, ((double) mediaItem.j()) / 1000.0d, 0.0d);
        StoryTellerItem.b(flatBufferBuilder, Location.m10767a(flatBufferBuilder, mediaItem.b().j(), mediaItem.b().k()));
        StoryTellerItem.a(flatBufferBuilder, b);
        StoryTellerItem.c(flatBufferBuilder, a);
        return StoryTellerItem.b(flatBufferBuilder);
    }

    private static int m10741a(MediaItem mediaItem, FlatBufferBuilder flatBufferBuilder) {
        byte b;
        if (MimeType.a.equals(mediaItem.b().mMimeType)) {
            b = (byte) 0;
        } else if (MimeType.c.equals(mediaItem.b().mMimeType)) {
            b = (byte) 1;
        } else {
            b = (byte) 2;
        }
        return Photo.m10768a(flatBufferBuilder, mediaItem.b().mWidth, mediaItem.b().mHeight, mediaItem.b().mOrientation, b, flatBufferBuilder.a(""), false, flatBufferBuilder.a(mediaItem.b().mUri.getPath()));
    }

    private static int m10744b(MediaItem mediaItem, FlatBufferBuilder flatBufferBuilder) {
        return Video.m10791a(flatBufferBuilder, mediaItem.b().mWidth, mediaItem.b().mHeight, ((float) ((VideoItem) mediaItem).d) / 1000.0f, flatBufferBuilder.a(""), false, flatBufferBuilder.a(mediaItem.b().mUri.getPath()));
    }
}
