package com.facebook.ipc.media;

import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.common.stringformat.StringFormatUtil;

/* compiled from: THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED */
public class MediaCursorHelper {

    /* compiled from: THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED */
    /* synthetic */ class C13481 {
        static final /* synthetic */ int[] f14078a = new int[SupportedMediaType.values().length];

        static {
            try {
                f14078a[SupportedMediaType.PHOTO_ONLY_EXCLUDING_GIFS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14078a[SupportedMediaType.PHOTO_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f14078a[SupportedMediaType.VIDEO_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static String m23448a(SupportedMediaType supportedMediaType) {
        switch (C13481.f14078a[supportedMediaType.ordinal()]) {
            case 1:
                return StringFormatUtil.a("(%s = %s AND %s != '%s')", new Object[]{"media_type", Integer.valueOf(1), "mime_type", MediaItem.f14082a});
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return StringFormatUtil.a("%s = %s", new Object[]{"media_type", Integer.valueOf(1)});
            case 3:
                return StringFormatUtil.a("%s = %s", new Object[]{"media_type", Integer.valueOf(3)});
            default:
                return StringFormatUtil.a("%s in (%s, %s)", new Object[]{"media_type", Integer.valueOf(1), Integer.valueOf(3)});
        }
    }
}
