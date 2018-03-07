package com.facebook.redspace.pagerindicator;

import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;
import android.os.Build.VERSION;
import com.facebook.ultralight.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: PagePastEventsQuery */
public class ArgbEvaluatorCompat implements TypeEvaluator {
    private static volatile ArgbEvaluatorCompat f12118b;
    private ArgbEvaluator f12119a;

    public static com.facebook.redspace.pagerindicator.ArgbEvaluatorCompat m12569a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f12118b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.redspace.pagerindicator.ArgbEvaluatorCompat.class;
        monitor-enter(r1);
        r0 = f12118b;	 Catch:{ all -> 0x0039 }
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
        r0 = m12568a();	 Catch:{ all -> 0x0034 }
        f12118b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f12118b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.redspace.pagerindicator.ArgbEvaluatorCompat.a(com.facebook.inject.InjectorLike):com.facebook.redspace.pagerindicator.ArgbEvaluatorCompat");
    }

    private static ArgbEvaluatorCompat m12568a() {
        return new ArgbEvaluatorCompat();
    }

    @Inject
    public ArgbEvaluatorCompat() {
        if (VERSION.SDK_INT >= 17) {
            this.f12119a = new ArgbEvaluator();
        }
    }

    public Object evaluate(float f, Object obj, Object obj2) {
        if (this.f12119a != null) {
            return this.f12119a.evaluate(f, obj, obj2);
        }
        int intValue = ((Integer) obj).intValue();
        int i = (intValue >> 24) & 255;
        int i2 = (intValue >> 16) & 255;
        int i3 = (intValue >> 8) & 255;
        intValue &= 255;
        int intValue2 = ((Integer) obj2).intValue();
        return Integer.valueOf((intValue + ((int) (((float) ((intValue2 & 255) - intValue)) * f))) | ((((i + ((int) (((float) (((intValue2 >> 24) & 255) - i)) * f))) << 24) | ((i2 + ((int) (((float) (((intValue2 >> 16) & 255) - i2)) * f))) << 16)) | ((((int) (((float) (((intValue2 >> 8) & 255) - i3)) * f)) + i3) << 8)));
    }
}
