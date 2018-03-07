package com.facebook.richdocument.logging;

import android.content.Context;
import com.facebook.common.util.StringUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Singleton;

@Singleton
/* compiled from: place_list */
public class RichDocumentSessionTracker {
    private static volatile RichDocumentSessionTracker f5563d;
    public String f5564a;
    public double f5565b;
    private final List<WeakReference<Context>> f5566c = new ArrayList();

    public static com.facebook.richdocument.logging.RichDocumentSessionTracker m5403a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f5563d;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.richdocument.logging.RichDocumentSessionTracker.class;
        monitor-enter(r1);
        r0 = f5563d;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m5404d();	 Catch:{ all -> 0x0034 }
        f5563d = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f5563d;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.logging.RichDocumentSessionTracker.a(com.facebook.inject.InjectorLike):com.facebook.richdocument.logging.RichDocumentSessionTracker");
    }

    private static RichDocumentSessionTracker m5404d() {
        return new RichDocumentSessionTracker();
    }

    public final void m5406a(Context context) {
        for (WeakReference weakReference : this.f5566c) {
            if (weakReference.get() == context) {
                return;
            }
        }
        this.f5566c.add(new WeakReference(context));
    }

    public final void m5408b(Context context) {
        int size = this.f5566c.size();
        for (int i = 0; i < size; i++) {
            if (((WeakReference) this.f5566c.get(i)).get() == context) {
                this.f5566c.remove(i);
                return;
            }
        }
    }

    public final int m5409c(Context context) {
        int i = 0;
        int size = this.f5566c.size();
        while (i < size) {
            int i2;
            WeakReference weakReference = (WeakReference) this.f5566c.get(i);
            if (weakReference.get() == null) {
                this.f5566c.remove(i);
                i2 = size - 1;
                size = i - 1;
            } else if (weakReference.get() == context) {
                return i;
            } else {
                i2 = size;
                size = i;
            }
            i = size + 1;
            size = i2;
        }
        return -1;
    }

    public final Map<String, String> m5407b() {
        Map<String, String> hashMap = new HashMap();
        if (!StringUtil.c(this.f5564a)) {
            hashMap.put("article_chaining_ID", this.f5564a);
        }
        hashMap.put("session_aggregate_view_time", Double.toString(this.f5565b / 1000.0d));
        return hashMap;
    }

    public final void m5405a(double d) {
        this.f5565b += d;
    }
}
