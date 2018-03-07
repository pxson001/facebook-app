package com.facebook.imagepipeline.listener;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: onthisday?<q$1> */
public class ForwardingRequestListener implements RequestListener {
    private final List<RequestListener> f11032a;

    public ForwardingRequestListener(Set<RequestListener> set) {
        this.f11032a = new ArrayList(set.size());
        for (RequestListener add : set) {
            this.f11032a.add(add);
        }
    }

    public final void mo2103a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        int size = this.f11032a.size();
        for (int i = 0; i < size; i++) {
            try {
                ((RequestListener) this.f11032a.get(i)).mo2103a(imageRequest, obj, str, z);
            } catch (Throwable e) {
                m16352a("InternalListener exception in onRequestStart", e);
            }
        }
    }

    public final void mo2106a(String str, String str2) {
        int size = this.f11032a.size();
        for (int i = 0; i < size; i++) {
            try {
                ((RequestListener) this.f11032a.get(i)).mo2106a(str, str2);
            } catch (Throwable e) {
                m16352a("InternalListener exception in onProducerStart", e);
            }
        }
    }

    public final void mo2109a(String str, String str2, @Nullable Map<String, String> map) {
        int size = this.f11032a.size();
        for (int i = 0; i < size; i++) {
            try {
                ((RequestListener) this.f11032a.get(i)).mo2109a(str, str2, (Map) map);
            } catch (Throwable e) {
                m16352a("InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    public final void mo2108a(String str, String str2, Throwable th, @Nullable Map<String, String> map) {
        int size = this.f11032a.size();
        for (int i = 0; i < size; i++) {
            try {
                ((RequestListener) this.f11032a.get(i)).mo2108a(str, str2, th, map);
            } catch (Throwable e) {
                m16352a("InternalListener exception in onProducerFinishWithFailure", e);
            }
        }
    }

    public final void mo2112b(String str, String str2, @Nullable Map<String, String> map) {
        int size = this.f11032a.size();
        for (int i = 0; i < size; i++) {
            try {
                ((RequestListener) this.f11032a.get(i)).mo2112b(str, str2, map);
            } catch (Throwable e) {
                m16352a("InternalListener exception in onProducerFinishWithCancellation", e);
            }
        }
    }

    public final void mo2107a(String str, String str2, String str3) {
        int size = this.f11032a.size();
        for (int i = 0; i < size; i++) {
            try {
                ((RequestListener) this.f11032a.get(i)).mo2107a(str, str2, str3);
            } catch (Throwable e) {
                m16352a("InternalListener exception in onIntermediateChunkStart", e);
            }
        }
    }

    public final void mo2105a(ImageRequest imageRequest, String str, boolean z) {
        int size = this.f11032a.size();
        for (int i = 0; i < size; i++) {
            try {
                ((RequestListener) this.f11032a.get(i)).mo2105a(imageRequest, str, z);
            } catch (Throwable e) {
                m16352a("InternalListener exception in onRequestSuccess", e);
            }
        }
    }

    public final void mo2104a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        int size = this.f11032a.size();
        for (int i = 0; i < size; i++) {
            try {
                ((RequestListener) this.f11032a.get(i)).mo2104a(imageRequest, str, th, z);
            } catch (Throwable e) {
                m16352a("InternalListener exception in onRequestFailure", e);
            }
        }
    }

    public final void mo2111b(String str) {
        int size = this.f11032a.size();
        for (int i = 0; i < size; i++) {
            try {
                ((RequestListener) this.f11032a.get(i)).mo2111b(str);
            } catch (Throwable e) {
                m16352a("InternalListener exception in onRequestCancellation", e);
            }
        }
    }

    public final boolean mo2110a(String str) {
        int size = this.f11032a.size();
        for (int i = 0; i < size; i++) {
            if (((RequestListener) this.f11032a.get(i)).mo2110a(str)) {
                return true;
            }
        }
        return false;
    }

    private static void m16352a(String str, Throwable th) {
        FLog.b("ForwardingRequestListener", str, th);
    }
}
