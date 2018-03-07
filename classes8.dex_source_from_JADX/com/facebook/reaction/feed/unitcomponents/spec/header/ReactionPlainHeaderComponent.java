package com.facebook.reaction.feed.unitcomponents.spec.header;

import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.Container;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.widget.Text;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: \| */
public class ReactionPlainHeaderComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f20491b = new SynchronizedPool(2);
    private static volatile ReactionPlainHeaderComponent f20492d;
    private final ReactionPlainHeaderComponentSpec f20493c;

    /* compiled from: \| */
    public class Builder extends com.facebook.components.Component.Builder<ReactionPlainHeaderComponent> {
        public State f20485a;
        private String[] f20486b = new String[]{"title"};
        private int f20487c = 1;
        public BitSet f20488d = new BitSet(this.f20487c);

        public static void m24252a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f20485a = state;
            builder.f20488d.clear();
        }

        public final Component<ReactionPlainHeaderComponent> m24254d() {
            int i = 0;
            if (this.f20488d == null || this.f20488d.nextClearBit(0) >= this.f20487c) {
                State state = this.f20485a;
                m24253a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f20487c) {
                if (!this.f20488d.get(i)) {
                    arrayList.add(this.f20486b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m24253a() {
            super.a();
            this.f20485a = null;
            ReactionPlainHeaderComponent.f20491b.a(this);
        }
    }

    /* compiled from: \| */
    public class State extends Component<ReactionPlainHeaderComponent> implements Cloneable {
        public String f20489a;
        final /* synthetic */ ReactionPlainHeaderComponent f20490b;

        public State(ReactionPlainHeaderComponent reactionPlainHeaderComponent) {
            this.f20490b = reactionPlainHeaderComponent;
            super(reactionPlainHeaderComponent);
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
            if (this.f20489a != null) {
                if (this.f20489a.equals(state.f20489a)) {
                    return true;
                }
            } else if (state.f20489a == null) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.reaction.feed.unitcomponents.spec.header.ReactionPlainHeaderComponent m24255a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20492d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.header.ReactionPlainHeaderComponent.class;
        monitor-enter(r1);
        r0 = f20492d;	 Catch:{ all -> 0x003a }
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
        r0 = m24256b(r0);	 Catch:{ all -> 0x0035 }
        f20492d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20492d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.header.ReactionPlainHeaderComponent.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.header.ReactionPlainHeaderComponent");
    }

    private static ReactionPlainHeaderComponent m24256b(InjectorLike injectorLike) {
        return new ReactionPlainHeaderComponent(ReactionPlainHeaderComponentSpec.m24260a(injectorLike));
    }

    @Inject
    public ReactionPlainHeaderComponent(ReactionPlainHeaderComponentSpec reactionPlainHeaderComponentSpec) {
        this.f20493c = reactionPlainHeaderComponentSpec;
    }

    protected final InternalNode m24258b(ComponentContext componentContext, Component component) {
        return Container.a(componentContext).C(2).i(5, 2130773575).F(2130773596).a(Text.a(componentContext).o(2131427402).a(((State) component).f20489a).c().a(1.0f).f(5, 2130773572).g(4, 2131431365).a(2)).j();
    }

    public final void m24257a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ReactionPlainHeaderComponent f20484c;

                public void run() {
                    this.f20484c.a(eventHandler, obj);
                }
            }, -986692225);
        }
    }
}
