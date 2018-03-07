package com.facebook.katana.webview;

import android.content.Context;
import com.facebook.common.util.Tuple;
import com.facebook.debug.asserts.Assert;
import com.facebook.katana.webview.FacewebComponentsStoreCache.Key;
import com.facebook.katana.webview.FacewebComponentsStoreCache.Listener;
import com.facebook.katana.webview.FacewebComponentsStoreCache.LoadError;
import com.facebook.katana.webview.FacewebComponentsStoreCache.Value;
import com.facebook.manageddatastore.ManagedDataStore;
import com.facebook.manageddatastore.ManagedDataStore.Mode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: timeline_optimistic_post_failed */
public class FacewebComponentsStoreMDS extends ManagedDataStore<Key, Value> {
    protected Map<Key, List<Listener>> f1261l = new HashMap();

    public FacewebComponentsStoreMDS(Context context) {
        super(new FacewebComponentsStoreCacheClient(context), Mode.SINGLE_REQUEST_BY_KEY, context);
    }

    public final Object m1307a(Object obj) {
        throw new UnsupportedOperationException("Don't call me directly");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.facebook.katana.webview.FacewebComponentsStoreCache.Value m1306a(com.facebook.katana.webview.FacewebComponentsStoreCache.Key r4, com.facebook.katana.webview.FacewebComponentsStoreCache.Listener r5) {
        /*
        r3 = this;
        r1 = 0;
        monitor-enter(r3);
        r0 = r3.f1261l;	 Catch:{ all -> 0x0043 }
        r0 = r0.get(r4);	 Catch:{ all -> 0x0043 }
        r0 = (java.util.List) r0;	 Catch:{ all -> 0x0043 }
        if (r0 == 0) goto L_0x0012;
    L_0x000c:
        r0.add(r5);	 Catch:{ all -> 0x0043 }
        monitor-exit(r3);	 Catch:{ all -> 0x0043 }
        r0 = r1;
    L_0x0011:
        return r0;
    L_0x0012:
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x0043 }
        r0.<init>();	 Catch:{ all -> 0x0043 }
        r0.add(r5);	 Catch:{ all -> 0x0043 }
        r2 = r3.f1261l;	 Catch:{ all -> 0x0043 }
        r2.put(r4, r0);	 Catch:{ all -> 0x0043 }
        r0 = super.a(r4);	 Catch:{ all -> 0x0043 }
        r0 = (com.facebook.katana.webview.FacewebComponentsStoreCache.Value) r0;	 Catch:{ all -> 0x0043 }
        if (r0 == 0) goto L_0x0046;
    L_0x0027:
        r1 = r3.f1261l;	 Catch:{ all -> 0x0043 }
        r1.remove(r4);	 Catch:{ all -> 0x0043 }
        r1 = r0.m1295c();	 Catch:{ all -> 0x0043 }
        if (r1 == 0) goto L_0x0041;
    L_0x0032:
        r1 = r0.m1293a();	 Catch:{ all -> 0x0043 }
        r1 = r1.a;	 Catch:{ all -> 0x0043 }
        r2 = com.facebook.katana.webview.FacewebComponentsStoreCache.LoadError.DESERIALIZATION_ERROR;	 Catch:{ all -> 0x0043 }
        if (r1 != r2) goto L_0x0041;
    L_0x003c:
        r1 = com.facebook.manageddatastore.ManagedDataStore$ClearType.CLEAR_DISK;	 Catch:{ all -> 0x0043 }
        super.a(r1);	 Catch:{ all -> 0x0043 }
    L_0x0041:
        monitor-exit(r3);	 Catch:{ all -> 0x0043 }
        goto L_0x0011;
    L_0x0043:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0043 }
        throw r0;
    L_0x0046:
        monitor-exit(r3);	 Catch:{  }
        r0 = r1;
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.webview.FacewebComponentsStoreMDS.a(com.facebook.katana.webview.FacewebComponentsStoreCache$Key, com.facebook.katana.webview.FacewebComponentsStoreCache$Listener):com.facebook.katana.webview.FacewebComponentsStoreCache$Value");
    }

    public final void m1308a(Context context, boolean z, Key key, String str, Value value) {
        Object obj = null;
        if (z) {
            Assert.a(value);
            Assert.a(value.m1294b());
            obj = new Key(key.m1289a(), value.m1294b().a());
            MFacewebVersion.m1349a(context, obj.m1290b());
        }
        super.a(context, z, obj, str, value);
        synchronized (this) {
            List<Listener> list = (List) this.f1261l.remove(key);
        }
        if (list != null) {
            for (Listener listener : list) {
                if (z) {
                    listener.mo51a(value.m1294b());
                } else {
                    Tuple a = value.m1293a();
                    listener.mo52a((LoadError) a.a, (String) a.b);
                }
            }
        }
    }
}
