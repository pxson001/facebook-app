package com.facebook.ui.media.attachments;

import android.content.ContentResolver;
import com.facebook.common.time.Clock;
import com.facebook.http.entity.mime.apache.content.AbstractContentBody;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.google.common.io.ByteStreams;
import com.google.common.io.Closeables;
import com.google.common.io.Files;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: search_photo_results_page */
public class MediaResourceBody extends AbstractContentBody {
    private static final Class<?> f5192b = MediaResourceBody.class;
    private final ContentResolver f5193c;
    private final MediaResource f5194d;
    private final String f5195e;

    /* compiled from: search_photo_results_page */
    /* synthetic */ class C03121 {
        static final /* synthetic */ int[] f5190a = new int[MediaResourceScheme.values().length];
        static final /* synthetic */ int[] f5191b = new int[Type.values().length];

        static {
            try {
                f5191b[Type.PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5191b[Type.ENT_PHOTO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5191b[Type.VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5191b[Type.AUDIO.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5191b[Type.OTHER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f5191b[Type.ENCRYPTED_PHOTO.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f5190a[MediaResourceScheme.FILE.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f5190a[MediaResourceScheme.CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    public MediaResourceBody(ContentResolver contentResolver, Clock clock, MediaResource mediaResource) {
        super(m7892a(contentResolver, mediaResource));
        this.f5193c = contentResolver;
        this.f5194d = mediaResource;
        this.f5195e = m7893a(clock, mediaResource);
    }

    public final String m7894a() {
        return this.f5195e;
    }

    public final void m7895a(OutputStream outputStream) {
        switch (C03121.f5190a[MediaResourceScheme.from(this.f5194d).ordinal()]) {
            case 1:
                Files.a(new File(this.f5194d.f5166c.getPath())).a(outputStream);
                return;
            case 2:
                InputStream openInputStream = this.f5193c.openInputStream(this.f5194d.f5166c);
                try {
                    ByteStreams.a(openInputStream, outputStream);
                    return;
                } finally {
                    Closeables.a(openInputStream);
                }
            default:
                throw new IllegalArgumentException("Unsupported scheme");
        }
    }

    public final String m7896b() {
        return null;
    }

    public final String m7897c() {
        return "binary";
    }

    public final long m7898d() {
        switch (C03121.f5190a[MediaResourceScheme.from(this.f5194d).ordinal()]) {
            case 1:
                return new File(this.f5194d.f5166c.getPath()).length();
            default:
                return -1;
        }
    }

    private static String m7892a(ContentResolver contentResolver, MediaResource mediaResource) {
        if (mediaResource.f5178o != null) {
            return mediaResource.f5178o;
        }
        String type = contentResolver.getType(mediaResource.f5166c);
        if (type != null) {
            return type;
        }
        switch (C03121.f5191b[mediaResource.f5167d.ordinal()]) {
            case 1:
            case 2:
                return "image/jpeg";
            case 3:
                return "video/mp4";
            case 4:
                return "audio/MPEG";
            default:
                throw new IllegalArgumentException("Unexpected attachment type");
        }
    }

    private static String m7893a(Clock clock, MediaResource mediaResource) {
        switch (C03121.f5191b[mediaResource.f5167d.ordinal()]) {
            case 1:
            case 2:
                return mediaResource.f5166c.getLastPathSegment();
            case 3:
                return mediaResource.f5166c.getLastPathSegment();
            case 4:
                return "audioclip-" + (clock.a() + "-" + mediaResource.f5172i) + ".mp4";
            case 5:
                return mediaResource.f5166c.getLastPathSegment();
            case 6:
                return mediaResource.f5166c.getLastPathSegment();
            default:
                throw new IllegalArgumentException("Unexpected attachment type");
        }
    }
}
