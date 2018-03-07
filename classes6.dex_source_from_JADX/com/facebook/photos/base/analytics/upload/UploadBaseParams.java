package com.facebook.photos.base.analytics.upload;

import com.facebook.photos.base.analytics.LoggingTypes.SourceType;
import com.facebook.photos.base.analytics.LoggingTypes.UploadMethodType;
import com.facebook.photos.base.analytics.LoggingTypes.UploadType;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.HashMap;

/* compiled from: injected_pulse_url */
public class UploadBaseParams {
    private final String f12697a;
    private final UploadType f12698b;
    public SourceType f12699c = SourceType.UNKNOWN;
    private final String f12700d;
    private final UploadMethodType f12701e;

    /* compiled from: injected_pulse_url */
    public /* synthetic */ class C08011 {
        public static final /* synthetic */ int[] f12696a = new int[UploadType.values().length];

        static {
            try {
                f12696a[UploadType.PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f12696a[UploadType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public UploadBaseParams(String str, UploadType uploadType, UploadMethodType uploadMethodType, String str2) {
        this.f12697a = str;
        this.f12698b = uploadType;
        this.f12700d = str2;
        this.f12701e = uploadMethodType;
    }

    public final HashMap<String, String> m20077a() {
        boolean z;
        String str;
        UploadType uploadType = this.f12698b;
        if (uploadType == UploadType.PHOTO || uploadType == UploadType.VIDEO) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        HashMap<String, String> c = Maps.c();
        c.put("version", this.f12697a);
        String str2 = "media_type";
        switch (C08011.f12696a[this.f12698b.ordinal()]) {
            case 1:
                str = "photo";
                break;
            case 2:
                str = "video";
                break;
            default:
                str = null;
                break;
        }
        c.put(str2, str);
        if (this.f12699c != SourceType.UNKNOWN) {
            c.put("is_vault", this.f12699c == SourceType.VAULT ? "1" : "0");
        }
        c.put("is_native_resizing", this.f12700d);
        if (!this.f12701e.value.equals(UploadMethodType.NOT_RELEVANT.value)) {
            c.put("upload_method", this.f12701e.value);
        }
        return c;
    }
}
