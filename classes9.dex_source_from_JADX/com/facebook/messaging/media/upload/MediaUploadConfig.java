package com.facebook.messaging.media.upload;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.upload.util.MediaHashCache;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.google.common.base.Strings;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: localID */
public class MediaUploadConfig {
    private final Provider<Boolean> f11890a;
    private final MediaHashCache f11891b;

    /* compiled from: localID */
    /* synthetic */ class C13401 {
        static final /* synthetic */ int[] f11889a = new int[Type.values().length];

        static {
            try {
                f11889a[Type.PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f11889a[Type.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f11889a[Type.AUDIO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f11889a[Type.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static MediaUploadConfig m12479b(InjectorLike injectorLike) {
        return new MediaUploadConfig(IdBasedProvider.a(injectorLike, 4167), MediaHashCache.a(injectorLike));
    }

    @Inject
    MediaUploadConfig(Provider<Boolean> provider, MediaHashCache mediaHashCache) {
        this.f11890a = provider;
        this.f11891b = mediaHashCache;
    }

    static String m12478a(MediaResource mediaResource) {
        switch (C13401.f11889a[mediaResource.d.ordinal()]) {
            case 1:
                if (mediaResource.c()) {
                    return "me/message_animated_images";
                }
                return "me/message_images";
            case 2:
                return "messagevideoattachment";
            case 3:
                return "me/message_audios";
            case 4:
                return "me/message_files";
            default:
                throw new UnsupportedOperationException("Unexpected attachment type");
        }
    }

    final boolean m12480b(MediaResource mediaResource) {
        return ((Boolean) this.f11890a.get()).booleanValue() && mediaResource.y != null && mediaResource.d == Type.PHOTO && (mediaResource.z || !Strings.isNullOrEmpty(this.f11891b.c(mediaResource)));
    }
}
