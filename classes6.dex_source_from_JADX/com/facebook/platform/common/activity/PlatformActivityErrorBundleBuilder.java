package com.facebook.platform.common.activity;

import android.os.Bundle;
import com.facebook.common.stringformat.StringFormatUtil;

/* compiled from: stream_disk_recording_video_width */
public class PlatformActivityErrorBundleBuilder {
    public final Bundle f4035a = new Bundle();

    public PlatformActivityErrorBundleBuilder(String str, String str2) {
        this.f4035a.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", 20121101);
        this.f4035a.putString("com.facebook.platform.status.ERROR_TYPE", str);
        this.f4035a.putString("com.facebook.platform.status.ERROR_DESCRIPTION", str2);
    }

    public final Bundle m5926a() {
        return this.f4035a;
    }

    public static PlatformActivityErrorBundleBuilder m5924a(String str, Object... objArr) {
        return new PlatformActivityErrorBundleBuilder("ProtocolError", StringFormatUtil.a(str, objArr));
    }

    public static PlatformActivityErrorBundleBuilder m5923a(String str, Class<?> cls, Object obj) {
        if (obj == null) {
            return m5924a("Expected non-null '%s' extra, actual value was null.", str);
        }
        return m5924a("Expected '%s' extra to be type '%s', actual value was type '%s'.", str, cls.getSimpleName(), obj.getClass().getSimpleName());
    }

    public static PlatformActivityErrorBundleBuilder m5925b(String str, Class<?> cls, Object obj) {
        if (obj == null) {
            return m5924a("Expected non-null items in '%s' ArrayList extra, actual item was null.", str);
        }
        return m5924a("Expected '%s' ArrayList extra to contain items of type '%s', actual was type '%s'.", str, cls.getSimpleName(), obj.getClass().getSimpleName());
    }
}
