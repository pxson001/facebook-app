package com.facebook.fbui.textcachewarmer;

import android.annotation.SuppressLint;
import android.graphics.Picture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.Layout;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.common.executors.ThreadPriority;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: http_proxy */
public class FbTextLayoutCacheWarmer {
    private static volatile FbTextLayoutCacheWarmer f20714c;
    private FbHandlerThreadFactory f20715a;
    private WarmHandler f20716b;

    /* compiled from: http_proxy */
    class WarmHandler extends Handler {
        private final Picture f21857a = new Picture();

        public WarmHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            Layout layout = (Layout) message.obj;
            try {
                layout.draw(this.f21857a.beginRecording(layout.getWidth(), layout.getHeight()));
                this.f21857a.endRecording();
            } catch (Exception e) {
            }
        }

        public void finalize() {
            getLooper().quit();
            super.finalize();
        }
    }

    public static com.facebook.fbui.textcachewarmer.FbTextLayoutCacheWarmer m28443a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f20714c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.fbui.textcachewarmer.FbTextLayoutCacheWarmer.class;
        monitor-enter(r1);
        r0 = f20714c;	 Catch:{ all -> 0x003a }
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
        r0 = m28444b(r0);	 Catch:{ all -> 0x0035 }
        f20714c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20714c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbui.textcachewarmer.FbTextLayoutCacheWarmer.a(com.facebook.inject.InjectorLike):com.facebook.fbui.textcachewarmer.FbTextLayoutCacheWarmer");
    }

    private static FbTextLayoutCacheWarmer m28444b(InjectorLike injectorLike) {
        return new FbTextLayoutCacheWarmer(FbHandlerThreadFactory.m3575a(injectorLike));
    }

    @Inject
    public FbTextLayoutCacheWarmer(FbHandlerThreadFactory fbHandlerThreadFactory) {
        this.f20715a = fbHandlerThreadFactory;
    }

    @SuppressLint({"BadMethodUse-java.lang.Thread.start"})
    public final void m28445a(Layout layout) {
        if (this.f20716b == null) {
            HandlerThread a = this.f20715a.m3581a("FbTextLayoutCacheWarmer", ThreadPriority.NORMAL, false);
            a.start();
            this.f20716b = new WarmHandler(a.getLooper());
        }
        this.f20716b.sendMessage(this.f20716b.obtainMessage(1, layout));
    }
}
