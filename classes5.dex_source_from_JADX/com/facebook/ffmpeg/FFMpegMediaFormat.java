package com.facebook.ffmpeg;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.ImmutableMap;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.concurrent.NotThreadSafe;

@DoNotStrip
@NotThreadSafe
/* compiled from: WWW_REGISTER_THROUGH_PHONE_CONFIRMATION */
public class FFMpegMediaFormat {
    public static final ImmutableMap<String, Class<?>> f12283a;
    private final Map<String, Object> f12284b = new HashMap();

    static {
        Map hashMap = new HashMap();
        hashMap.put("mime", String.class);
        hashMap.put("language", String.class);
        hashMap.put("sample-rate", Integer.class);
        hashMap.put("channel-count", Integer.class);
        hashMap.put("width", Integer.class);
        hashMap.put("height", Integer.class);
        hashMap.put("max-width", Integer.class);
        hashMap.put("max-height", Integer.class);
        hashMap.put("max-input-size", Integer.class);
        hashMap.put("bitrate", Integer.class);
        hashMap.put("color-format", Integer.class);
        hashMap.put("frame-rate", Integer.class);
        hashMap.put("i-frame-interval", Integer.class);
        hashMap.put("stride", Integer.class);
        hashMap.put("slice-height", Integer.class);
        hashMap.put("repeat-previous-frame-after", Long.class);
        hashMap.put("push-blank-buffers-on-shutdown", Integer.class);
        hashMap.put("durationUs", Long.class);
        hashMap.put("is-adts", Integer.class);
        hashMap.put("channel-mask", Integer.class);
        hashMap.put("aac-profile", Integer.class);
        hashMap.put("flac-compression-level", Integer.class);
        hashMap.put("is-autoselect", Integer.class);
        hashMap.put("is-default", Integer.class);
        hashMap.put("is-forced-subtitle", Integer.class);
        f12283a = ImmutableMap.a(hashMap);
    }

    @DoNotStrip
    public final boolean containsKey(String str) {
        return this.f12284b.containsKey(str);
    }

    @DoNotStrip
    public final int getInteger(String str) {
        return ((Integer) this.f12284b.get(str)).intValue();
    }

    @DoNotStrip
    public final int getInteger(String str, int i) {
        try {
            i = getInteger(str);
        } catch (NullPointerException e) {
        } catch (ClassCastException e2) {
        }
        return i;
    }

    @DoNotStrip
    public final long getLong(String str) {
        return ((Long) this.f12284b.get(str)).longValue();
    }

    @DoNotStrip
    public final long getLong(String str, long j) {
        try {
            j = getLong(str);
        } catch (NullPointerException e) {
        } catch (ClassCastException e2) {
        }
        return j;
    }

    @DoNotStrip
    public final float getFloat(String str) {
        return ((Float) this.f12284b.get(str)).floatValue();
    }

    @DoNotStrip
    public final String getString(String str) {
        return (String) this.f12284b.get(str);
    }

    @DoNotStrip
    public final ByteBuffer getByteBuffer(String str) {
        return (ByteBuffer) this.f12284b.get(str);
    }

    @DoNotStrip
    public final void setInteger(String str, int i) {
        this.f12284b.put(str, new Integer(i));
    }

    @DoNotStrip
    public final void setLong(String str, long j) {
        this.f12284b.put(str, new Long(j));
    }

    @DoNotStrip
    public final void setFloat(String str, float f) {
        this.f12284b.put(str, new Float(f));
    }

    @DoNotStrip
    public final void setString(String str, String str2) {
        this.f12284b.put(str, str2);
    }

    @DoNotStrip
    public final void setByteBuffer(String str, ByteBuffer byteBuffer) {
        this.f12284b.put(str, byteBuffer);
    }

    @TargetApi(16)
    public static FFMpegMediaFormat m20345a(MediaFormat mediaFormat) {
        FFMpegMediaFormat fFMpegMediaFormat = new FFMpegMediaFormat();
        for (Entry entry : f12283a.entrySet()) {
            String str = (String) entry.getKey();
            Class cls = (Class) entry.getValue();
            if (mediaFormat.containsKey(str)) {
                if (cls == String.class) {
                    fFMpegMediaFormat.setString(str, mediaFormat.getString(str));
                } else if (cls == Integer.class) {
                    fFMpegMediaFormat.setInteger(str, mediaFormat.getInteger(str));
                } else if (cls == Long.class) {
                    fFMpegMediaFormat.setLong(str, mediaFormat.getLong(str));
                } else if (cls == Float.class) {
                    fFMpegMediaFormat.setFloat(str, mediaFormat.getFloat(str));
                }
            }
        }
        return fFMpegMediaFormat;
    }

    public String toString() {
        return this.f12284b.toString();
    }
}
