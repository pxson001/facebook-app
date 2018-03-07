package com.facebook.components.fb.widget;

import android.net.Uri;
import android.os.Looper;
import android.support.annotation.DimenRes;
import android.support.annotation.IntegerRes;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.ComponentsPools;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.Output;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: creativecam_capture_photo */
public class FbFacepileComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f16610b = new SynchronizedPool(2);
    private static volatile FbFacepileComponent f16611d;
    private final FbFacepileComponentSpec f16612c;

    /* compiled from: creativecam_capture_photo */
    public class Builder extends com.facebook.components.Component.Builder<FbFacepileComponent> {
        State f16600a;

        public static void m20656a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f16600a = state;
        }

        public final Builder m20657a(CallerContext callerContext) {
            this.f16600a.f16601a = callerContext;
            return this;
        }

        public final Builder m20661h(@DimenRes int i) {
            this.f16600a.f16602b = e(i);
            return this;
        }

        public final Builder m20662i(@DimenRes int i) {
            this.f16600a.f16605e = f(i);
            return this;
        }

        public final Builder m20658a(List<Uri> list) {
            this.f16600a.f16607g = list;
            return this;
        }

        public final Builder m20663j(@IntegerRes int i) {
            int intValue;
            State state = this.f16600a;
            if (i != 0) {
                Integer num = (Integer) this.d.a(i);
                if (num != null) {
                    intValue = num.intValue();
                } else {
                    intValue = this.b.getInteger(i);
                    this.d.a(i, Integer.valueOf(intValue));
                }
            } else {
                intValue = 0;
            }
            state.f16608h = intValue;
            return this;
        }

        public final Component<FbFacepileComponent> m20660d() {
            State state = this.f16600a;
            m20659a();
            return state;
        }

        protected final void m20659a() {
            super.a();
            this.f16600a = null;
            FbFacepileComponent.f16610b.a(this);
        }
    }

    /* compiled from: creativecam_capture_photo */
    public class State extends Component<FbFacepileComponent> implements Cloneable {
        CallerContext f16601a;
        int f16602b = Integer.MIN_VALUE;
        int f16603c = Integer.MIN_VALUE;
        int f16604d = Integer.MIN_VALUE;
        int f16605e = Integer.MIN_VALUE;
        boolean f16606f = true;
        List<Uri> f16607g = FbFacepileComponentSpec.f16613a;
        int f16608h = Integer.MIN_VALUE;
        final /* synthetic */ FbFacepileComponent f16609i;

        public State(FbFacepileComponent fbFacepileComponent) {
            this.f16609i = fbFacepileComponent;
            super(fbFacepileComponent);
        }

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
            if (this.f16601a == null ? state.f16601a != null : !this.f16601a.equals(state.f16601a)) {
                return false;
            }
            if (this.f16602b != state.f16602b) {
                return false;
            }
            if (this.f16603c != state.f16603c) {
                return false;
            }
            if (this.f16604d != state.f16604d) {
                return false;
            }
            if (this.f16605e != state.f16605e) {
                return false;
            }
            if (this.f16606f != state.f16606f) {
                return false;
            }
            if (this.f16607g == null ? state.f16607g != null : !this.f16607g.equals(state.f16607g)) {
                return false;
            }
            if (this.f16608h != state.f16608h) {
                return false;
            }
            return true;
        }
    }

    public static com.facebook.components.fb.widget.FbFacepileComponent m20664a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16611d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.components.fb.widget.FbFacepileComponent.class;
        monitor-enter(r1);
        r0 = f16611d;	 Catch:{ all -> 0x003a }
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
        r0 = m20665b(r0);	 Catch:{ all -> 0x0035 }
        f16611d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16611d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.components.fb.widget.FbFacepileComponent.a(com.facebook.inject.InjectorLike):com.facebook.components.fb.widget.FbFacepileComponent");
    }

    private static FbFacepileComponent m20665b(InjectorLike injectorLike) {
        return new FbFacepileComponent(FbFacepileComponentSpec.m20670a(injectorLike));
    }

    @Inject
    public FbFacepileComponent(FbFacepileComponentSpec fbFacepileComponentSpec) {
        this.f16612c = fbFacepileComponentSpec;
    }

    public final Builder m20666a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) f16610b.a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m20656a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode m20668b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f16612c.m20673a(componentContext, state.f16601a, state.f16602b, state.f16603c, state.f16604d, state.f16605e, state.f16606f, state.f16607g, state.f16608h);
    }

    protected final void m20669d(ComponentContext componentContext, Component<?> component) {
        Output c = ComponentsPools.c();
        Output c2 = ComponentsPools.c();
        Output c3 = ComponentsPools.c();
        Output c4 = ComponentsPools.c();
        Output c5 = ComponentsPools.c();
        Output c6 = ComponentsPools.c();
        FbFacepileComponentSpec.m20671a(componentContext, c, c2, c3, c4, c5, c6);
        State state = (State) component;
        if (c.a != null) {
            state.f16602b = ((Integer) c.a).intValue();
        }
        ComponentsPools.a(c);
        if (c2.a != null) {
            state.f16603c = ((Integer) c2.a).intValue();
        }
        ComponentsPools.a(c2);
        if (c3.a != null) {
            state.f16604d = ((Integer) c3.a).intValue();
        }
        ComponentsPools.a(c3);
        if (c4.a != null) {
            state.f16605e = ((Integer) c4.a).intValue();
        }
        ComponentsPools.a(c4);
        if (c5.a != null) {
            state.f16606f = ((Boolean) c5.a).booleanValue();
        }
        ComponentsPools.a(c5);
        if (c6.a != null) {
            state.f16608h = ((Integer) c6.a).intValue();
        }
        ComponentsPools.a(c6);
    }

    public final void m20667a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ FbFacepileComponent f16599c;

                public void run() {
                    this.f16599c.a(eventHandler, obj);
                }
            }, 1064313643);
        }
    }
}
