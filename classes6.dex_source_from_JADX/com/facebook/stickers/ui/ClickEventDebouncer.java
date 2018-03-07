package com.facebook.stickers.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: e092afe675568fc8be3eef1f655198ed */
public class ClickEventDebouncer {
    private static volatile ClickEventDebouncer f17025b;
    public MonotonicClock f17026a;

    /* compiled from: e092afe675568fc8be3eef1f655198ed */
    public class OnItemClickListenerWrapper implements OnItemClickListener {
        final /* synthetic */ ClickEventDebouncer f17022a;
        private long f17023b;
        private OnItemClickListener f17024c;

        public OnItemClickListenerWrapper(ClickEventDebouncer clickEventDebouncer, OnItemClickListener onItemClickListener) {
            this.f17022a = clickEventDebouncer;
            this.f17024c = onItemClickListener;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            long now = this.f17022a.f17026a.now();
            if (now - this.f17023b > 600 && this.f17024c != null) {
                this.f17023b = now;
                this.f17024c.onItemClick(adapterView, view, i, j);
            }
        }
    }

    public static com.facebook.stickers.ui.ClickEventDebouncer m24734a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17025b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.stickers.ui.ClickEventDebouncer.class;
        monitor-enter(r1);
        r0 = f17025b;	 Catch:{ all -> 0x003a }
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
        r0 = m24735b(r0);	 Catch:{ all -> 0x0035 }
        f17025b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17025b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stickers.ui.ClickEventDebouncer.a(com.facebook.inject.InjectorLike):com.facebook.stickers.ui.ClickEventDebouncer");
    }

    private static ClickEventDebouncer m24735b(InjectorLike injectorLike) {
        return new ClickEventDebouncer((MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ClickEventDebouncer(MonotonicClock monotonicClock) {
        this.f17026a = monotonicClock;
    }
}
