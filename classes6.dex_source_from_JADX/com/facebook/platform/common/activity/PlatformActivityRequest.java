package com.facebook.platform.common.activity;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.platform.common.action.PlatformAppCall;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: stream_disk_recording_video_height */
public abstract class PlatformActivityRequest {
    public PlatformAppCall f4036a;
    public Bundle f4037b;

    /* compiled from: stream_disk_recording_video_height */
    public interface Setter<T> {
        void mo1177a(T t);
    }

    protected abstract boolean mo1178a(Intent intent);

    protected abstract boolean mo1179a(Bundle bundle);

    public final PlatformAppCall m5931a() {
        return this.f4036a;
    }

    public final Bundle m5939b() {
        return this.f4037b;
    }

    private void m5929b(Bundle bundle) {
        this.f4037b = bundle;
    }

    public final boolean m5938a(PlatformAppCall platformAppCall, Intent intent) {
        this.f4036a = platformAppCall;
        Bundle extras = intent.getExtras();
        if (platformAppCall.f4012c) {
            if (!mo1179a(extras.getBundle("com.facebook.platform.protocol.METHOD_ARGS"))) {
                return false;
            }
        } else if (!mo1178a(intent)) {
            return false;
        }
        if (extras.containsKey("com.facebook.platform.protocol.PROTOCOL_VALIDATE")) {
            Object obj = extras.get("com.facebook.platform.protocol.PROTOCOL_VALIDATE");
            if (!(obj instanceof Boolean)) {
                m5928a("com.facebook.platform.protocol.PROTOCOL_VALIDATE", Boolean.class, obj);
                return false;
            } else if (((Boolean) obj).booleanValue()) {
                extras = new Bundle();
                extras.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", 20121101);
                extras.putBoolean("com.facebook.platform.protocol.PROTOCOL_VALIDATED", true);
                this.f4037b = extras;
                return false;
            }
        }
        return true;
    }

    protected final boolean m5933a(Intent intent, String str, boolean z, Setter<ArrayList<String>> setter) {
        return m5936a(intent.getExtras(), str, z, (Setter) setter);
    }

    protected final boolean m5936a(Bundle bundle, String str, boolean z, Setter<ArrayList<String>> setter) {
        return m5937a(bundle, str, z, String.class, (Setter) setter);
    }

    protected final <TExtra> boolean m5934a(Intent intent, String str, boolean z, Class<TExtra> cls, Setter<ArrayList<TExtra>> setter) {
        return m5937a(intent.getExtras(), str, z, (Class) cls, (Setter) setter);
    }

    protected final <TExtra> boolean m5937a(Bundle bundle, String str, boolean z, Class<TExtra> cls, Setter<ArrayList<TExtra>> setter) {
        Object obj = bundle.get(str);
        if (obj == null) {
            obj = bundle.get(str.toUpperCase());
        }
        if (obj == null) {
            if (z) {
                setter.mo1177a(new ArrayList());
                return z;
            }
            m5928a(str, ArrayList.class, obj);
            return z;
        } else if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                if (cls.isAssignableFrom(obj2.getClass())) {
                    i++;
                } else {
                    m5930b(str, cls, obj2);
                    return false;
                }
            }
            setter.mo1177a((ArrayList) obj);
            return true;
        } else {
            m5928a(str, ArrayList.class, obj);
            return false;
        }
    }

    protected final <TExtra> boolean m5940b(Intent intent, String str, boolean z, Class<TExtra> cls, Setter<TExtra> setter) {
        return m5941b(intent.getExtras(), str, z, (Class) cls, (Setter) setter);
    }

    protected final <TExtra> boolean m5941b(Bundle bundle, String str, boolean z, Class<TExtra> cls, Setter<TExtra> setter) {
        Object obj = bundle.get(str);
        if (obj == null) {
            obj = bundle.get(str.toUpperCase(Locale.ROOT));
        }
        if (obj == null) {
            if (z) {
                setter.mo1177a(null);
                return z;
            }
            m5928a(str, cls, obj);
            return z;
        } else if (cls.isAssignableFrom(obj.getClass())) {
            setter.mo1177a(obj);
            return true;
        } else {
            m5928a(str, cls, obj);
            return false;
        }
    }

    private void m5928a(String str, Class<?> cls, Object obj) {
        this.f4037b = PlatformActivityErrorBundleBuilder.m5923a(str, cls, obj).f4035a;
    }

    private void m5930b(String str, Class<?> cls, Object obj) {
        this.f4037b = PlatformActivityErrorBundleBuilder.m5925b(str, cls, obj).f4035a;
    }
}
