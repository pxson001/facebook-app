package com.facebook.feed.util.render;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.common.util.SizeUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.tablet.abtest.TabletColumnLayoutManager;
import com.facebook.tablet.abtest.TabletExperimentConfiguration;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: platform_open_graph_share_upload */
public class FeedRenderUtils {
    public static int f9599a = -1;
    private static volatile FeedRenderUtils f9600f;
    public final Display f9601b;
    private final TabletExperimentConfiguration f9602c;
    private final TabletColumnLayoutManager f9603d;
    public final Point f9604e = new Point();

    public static com.facebook.feed.util.render.FeedRenderUtils m14652a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9600f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.util.render.FeedRenderUtils.class;
        monitor-enter(r1);
        r0 = f9600f;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m14653b(r0);	 Catch:{ all -> 0x0035 }
        f9600f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9600f;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.render.FeedRenderUtils.a(com.facebook.inject.InjectorLike):com.facebook.feed.util.render.FeedRenderUtils");
    }

    private static FeedRenderUtils m14653b(InjectorLike injectorLike) {
        return new FeedRenderUtils(WindowManagerMethodAutoProvider.m8708b(injectorLike), TabletExperimentConfiguration.m7856a(injectorLike), TabletColumnLayoutManager.m8710a(injectorLike));
    }

    @Inject
    public FeedRenderUtils(WindowManager windowManager, TabletExperimentConfiguration tabletExperimentConfiguration, TabletColumnLayoutManager tabletColumnLayoutManager) {
        this.f9601b = windowManager.getDefaultDisplay();
        this.f9602c = tabletExperimentConfiguration;
        this.f9603d = tabletColumnLayoutManager;
    }

    public final int m14657a(Context context, int i) {
        Resources resources = context.getResources();
        if (f9599a == -1) {
            f9599a = resources.getDimensionPixelSize(2131428854);
        }
        return (i + 1) * f9599a;
    }

    public final int m14656a(Context context, float f) {
        return m14654a() - SizeUtil.m19191a(context, 2.0f * f);
    }

    public final int m14655a(Context context) {
        return SizeUtil.m19198c(context, ((float) m14654a()) * 0.88f) - 20;
    }

    public final int m14654a() {
        if (this.f9602c.m7858a()) {
            return this.f9603d.m8719c();
        }
        int i;
        if (VERSION.SDK_INT >= 13) {
            this.f9601b.getSize(this.f9604e);
            i = this.f9604e.x;
        } else {
            i = this.f9601b.getWidth();
        }
        return i;
    }

    public final int m14658b() {
        this.f9601b.getSize(this.f9604e);
        return Math.abs(this.f9604e.x - this.f9604e.y);
    }
}
