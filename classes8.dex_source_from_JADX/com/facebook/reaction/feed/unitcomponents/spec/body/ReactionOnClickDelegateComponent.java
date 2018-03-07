package com.facebook.reaction.feed.unitcomponents.spec.body;

import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.components.ClickEvent;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.Layout;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: _s */
public class ReactionOnClickDelegateComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f20312b = new SynchronizedPool(2);
    private static volatile ReactionOnClickDelegateComponent f20313d;
    private final ReactionOnClickDelegateComponentSpec f20314c;

    /* compiled from: _s */
    public class Builder extends com.facebook.components.Component.Builder<ReactionOnClickDelegateComponent> {
        public State f20305a;
        private String[] f20306b = new String[]{"delegate", "onClickListener"};
        private int f20307c = 2;
        public BitSet f20308d = new BitSet(this.f20307c);

        public static void m24145a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f20305a = state;
            builder.f20308d.clear();
        }

        public final Builder m24146a(com.facebook.components.Component.Builder<?> builder) {
            this.f20305a.f20309a = builder.d();
            this.f20308d.set(0);
            return this;
        }

        public final Component<ReactionOnClickDelegateComponent> m24148d() {
            int i = 0;
            if (this.f20308d == null || this.f20308d.nextClearBit(0) >= this.f20307c) {
                State state = this.f20305a;
                m24147a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f20307c) {
                if (!this.f20308d.get(i)) {
                    arrayList.add(this.f20306b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m24147a() {
            super.a();
            this.f20305a = null;
            ReactionOnClickDelegateComponent.f20312b.a(this);
        }
    }

    /* compiled from: _s */
    public class State extends Component<ReactionOnClickDelegateComponent> implements Cloneable {
        public Component<?> f20309a;
        public OnClickListener f20310b;
        final /* synthetic */ ReactionOnClickDelegateComponent f20311c;

        public State(ReactionOnClickDelegateComponent reactionOnClickDelegateComponent) {
            this.f20311c = reactionOnClickDelegateComponent;
            super(reactionOnClickDelegateComponent);
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
            if (this.f20309a == null ? state.f20309a != null : !this.f20309a.equals(state.f20309a)) {
                return false;
            }
            if (this.f20310b != null) {
                if (this.f20310b.equals(state.f20310b)) {
                    return true;
                }
            } else if (state.f20310b == null) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.reaction.feed.unitcomponents.spec.body.ReactionOnClickDelegateComponent m24149a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20313d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.body.ReactionOnClickDelegateComponent.class;
        monitor-enter(r1);
        r0 = f20313d;	 Catch:{ all -> 0x003a }
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
        r0 = m24151b(r0);	 Catch:{ all -> 0x0035 }
        f20313d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20313d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.body.ReactionOnClickDelegateComponent.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.body.ReactionOnClickDelegateComponent");
    }

    private static ReactionOnClickDelegateComponent m24151b(InjectorLike injectorLike) {
        return new ReactionOnClickDelegateComponent(ReactionOnClickDelegateComponentSpec.m24155a(injectorLike));
    }

    @Inject
    public ReactionOnClickDelegateComponent(ReactionOnClickDelegateComponentSpec reactionOnClickDelegateComponentSpec) {
        this.f20314c = reactionOnClickDelegateComponentSpec;
    }

    protected final InternalNode m24153b(ComponentContext componentContext, Component component) {
        return Layout.a(componentContext, ((State) component).f20309a).a(ComponentLifecycle.a(componentContext, 1755232876, null)).j();
    }

    private void m24150a(View view, Component component) {
        ((State) component).f20310b.onClick(view);
    }

    public final void m24152a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ReactionOnClickDelegateComponent f20304c;

                public void run() {
                    this.f20304c.a(eventHandler, obj);
                }
            }, -550085088);
            return;
        }
        switch (eventHandler.b) {
            case 1755232876:
                m24150a(((ClickEvent) obj).a, eventHandler.a);
                return;
            default:
                return;
        }
    }
}
