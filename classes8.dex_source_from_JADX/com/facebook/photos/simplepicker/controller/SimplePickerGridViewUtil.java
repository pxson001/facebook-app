package com.facebook.photos.simplepicker.controller;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.device.ScreenUtil;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: share_event_tap */
public class SimplePickerGridViewUtil {
    private static volatile SimplePickerGridViewUtil f3136e;
    private final ScreenUtil f3137a;
    private final double f3138b;
    private final double f3139c;
    private final double f3140d;

    public static com.facebook.photos.simplepicker.controller.SimplePickerGridViewUtil m3142a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f3136e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.simplepicker.controller.SimplePickerGridViewUtil.class;
        monitor-enter(r1);
        r0 = f3136e;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m3143b(r0);	 Catch:{ all -> 0x0035 }
        f3136e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3136e;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.simplepicker.controller.SimplePickerGridViewUtil.a(com.facebook.inject.InjectorLike):com.facebook.photos.simplepicker.controller.SimplePickerGridViewUtil");
    }

    private static SimplePickerGridViewUtil m3143b(InjectorLike injectorLike) {
        return new SimplePickerGridViewUtil((Context) injectorLike.getInstance(Context.class), ScreenUtil.a(injectorLike));
    }

    @Inject
    public SimplePickerGridViewUtil(Context context, ScreenUtil screenUtil) {
        Resources resources = context.getResources();
        this.f3138b = (double) resources.getDimensionPixelSize(2131429470);
        this.f3139c = (double) resources.getDimensionPixelSize(2131429468);
        this.f3140d = (double) resources.getDimensionPixelSize(2131429461);
        this.f3137a = screenUtil;
    }

    public final int m3144a() {
        int c = this.f3137a.c();
        int i = (int) ((((double) c) + this.f3139c) / (this.f3138b + this.f3139c));
        return ((int) Math.ceil((((double) this.f3137a.d()) - this.f3140d) / ((((double) c) + this.f3139c) / ((double) i)))) * i;
    }
}
