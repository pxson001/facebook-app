package com.facebook.components.fb.widget;

import android.net.Uri;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: creative_tool_applied_main_filter_ */
public class FbImageBlockComponent extends ComponentLifecycle {
    private static final SynchronizedPool<Object> f16642b = new SynchronizedPool(2);
    private static volatile FbImageBlockComponent f16643d;
    private final FbImageBlockComponentSpec f16644c;

    /* compiled from: creative_tool_applied_main_filter_ */
    class State extends Component<FbImageBlockComponent> implements Cloneable {
        Uri f16633a;
        CharSequence f16634b;
        CharSequence f16635c;
        EventHandler f16636d;
        EventHandler f16637e;
        int f16638f;
        CallerContext f16639g;
        RoundingParams f16640h;
        Uri f16641i;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            State state = (State) obj;
            if (this.b == state.b) {
                return true;
            }
            if (this.f16633a == null ? state.f16633a != null : !this.f16633a.equals(state.f16633a)) {
                return false;
            }
            if (this.f16634b == null ? state.f16634b != null : !this.f16634b.equals(state.f16634b)) {
                return false;
            }
            if (this.f16635c == null ? state.f16635c != null : !this.f16635c.equals(state.f16635c)) {
                return false;
            }
            if (this.f16636d == null ? state.f16636d != null : !this.f16636d.equals(state.f16636d)) {
                return false;
            }
            if (this.f16637e == null ? state.f16637e != null : !this.f16637e.equals(state.f16637e)) {
                return false;
            }
            if (this.f16638f != state.f16638f) {
                return false;
            }
            if (this.f16639g == null ? state.f16639g != null : !this.f16639g.equals(state.f16639g)) {
                return false;
            }
            if (this.f16640h == null ? state.f16640h != null : !this.f16640h.equals(state.f16640h)) {
                return false;
            }
            if (this.f16641i != null) {
                if (this.f16641i.equals(state.f16641i)) {
                    return true;
                }
            } else if (state.f16641i == null) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.components.fb.widget.FbImageBlockComponent m20685a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16643d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.components.fb.widget.FbImageBlockComponent.class;
        monitor-enter(r1);
        r0 = f16643d;	 Catch:{ all -> 0x003a }
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
        r0 = m20686b(r0);	 Catch:{ all -> 0x0035 }
        f16643d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16643d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.components.fb.widget.FbImageBlockComponent.a(com.facebook.inject.InjectorLike):com.facebook.components.fb.widget.FbImageBlockComponent");
    }

    private static FbImageBlockComponent m20686b(InjectorLike injectorLike) {
        return new FbImageBlockComponent(FbImageBlockComponentSpec.m20689a(injectorLike));
    }

    @Inject
    public FbImageBlockComponent(FbImageBlockComponentSpec fbImageBlockComponentSpec) {
        this.f16644c = fbImageBlockComponentSpec;
    }

    protected final InternalNode m20688b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f16644c.m20691a(componentContext, state.f16633a, state.f16634b, state.f16635c, state.f16636d, state.f16637e, state.f16638f, state.f16639g, state.f16640h, state.f16641i);
    }

    public final void m20687a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ FbImageBlockComponent f16632c;

                public void run() {
                    this.f16632c.a(eventHandler, obj);
                }
            }, -337403316);
        }
    }
}
