package com.facebook.components.fb.widget;

import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout.ContainerBuilder;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.Container;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.widget.Text;
import com.facebook.components.widget.VerticalGravity;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: creative_tool_did_show */
public class FbFacepileCountComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f16626b = new SynchronizedPool(2);
    private static volatile FbFacepileCountComponent f16627d;
    private final FbFacepileCountComponentSpec f16628c;

    /* compiled from: creative_tool_did_show */
    public class Builder extends com.facebook.components.Component.Builder<FbFacepileCountComponent> {
        State f16620a;
        private String[] f16621b = new String[]{"count"};
        private int f16622c = 1;
        private BitSet f16623d = new BitSet(this.f16622c);

        public static void m20674a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f16620a = state;
            builder.f16623d.clear();
        }

        public final Builder m20677h(int i) {
            this.f16620a.f16624a = i;
            this.f16623d.set(0);
            return this;
        }

        public final Component<FbFacepileCountComponent> m20676d() {
            int i = 0;
            if (this.f16623d == null || this.f16623d.nextClearBit(0) >= this.f16622c) {
                State state = this.f16620a;
                m20675a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f16622c) {
                if (!this.f16623d.get(i)) {
                    arrayList.add(this.f16621b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m20675a() {
            super.a();
            this.f16620a = null;
            FbFacepileCountComponent.f16626b.a(this);
        }
    }

    /* compiled from: creative_tool_did_show */
    public class State extends Component<FbFacepileCountComponent> implements Cloneable {
        int f16624a;
        final /* synthetic */ FbFacepileCountComponent f16625b;

        public State(FbFacepileCountComponent fbFacepileCountComponent) {
            this.f16625b = fbFacepileCountComponent;
            super(fbFacepileCountComponent);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            State state = (State) obj;
            if (this.b == state.b || this.f16624a == state.f16624a) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.components.fb.widget.FbFacepileCountComponent m20678a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16627d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.components.fb.widget.FbFacepileCountComponent.class;
        monitor-enter(r1);
        r0 = f16627d;	 Catch:{ all -> 0x003a }
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
        r0 = m20679b(r0);	 Catch:{ all -> 0x0035 }
        f16627d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16627d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.components.fb.widget.FbFacepileCountComponent.a(com.facebook.inject.InjectorLike):com.facebook.components.fb.widget.FbFacepileCountComponent");
    }

    private static FbFacepileCountComponent m20679b(InjectorLike injectorLike) {
        return new FbFacepileCountComponent(FbFacepileCountComponentSpec.m20684a(injectorLike));
    }

    @Inject
    public FbFacepileCountComponent(FbFacepileCountComponentSpec fbFacepileCountComponentSpec) {
        this.f16628c = fbFacepileCountComponentSpec;
    }

    public final Builder m20680a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) f16626b.a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m20674a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode m20682b(ComponentContext componentContext, Component component) {
        String str;
        int i = ((State) component).f16624a;
        int dimensionPixelSize = componentContext.getResources().getDimensionPixelSize(2131431077);
        ContainerBuilder G = Container.a(componentContext).D(1).E(2).C(2).G(2130839632);
        com.facebook.components.widget.Text.Builder a = Text.a(componentContext);
        if (i > 99) {
            str = "∞";
        } else {
            str = StringFormatUtil.formatStrLocaleSafe("+%d", Integer.valueOf(i));
        }
        return G.a(a.a(str).j(1).b(true).k(-1).r(1).n(dimensionPixelSize).a(VerticalGravity.CENTER)).j();
    }

    public final void m20681a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ FbFacepileCountComponent f16619c;

                public void run() {
                    this.f16619c.a(eventHandler, obj);
                }
            }, -549534405);
        }
    }
}
