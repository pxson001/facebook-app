package com.facebook.reaction.feed.corecomponents.spec;

import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout.ContainerBuilder;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.Container;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.feed.environment.HasContext;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: badge_load_failure */
public class ReactionHorizontalListComponent<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession> extends ComponentLifecycle {
    private static volatile ReactionHorizontalListComponent f19116d;
    private final ReactionHorizontalListComponentSpec f19117b;
    public final SynchronizedPool<Builder> f19118c = new SynchronizedPool(2);

    /* compiled from: badge_load_failure */
    public class Builder extends com.facebook.components.Component.Builder<ReactionHorizontalListComponent> {
        State f19108a;
        final /* synthetic */ ReactionHorizontalListComponent f19109b;
        private String[] f19110c = new String[]{"environment", "subComponents"};
        private int f19111d = 2;
        private BitSet f19112e = new BitSet(this.f19111d);

        public Builder(ReactionHorizontalListComponent reactionHorizontalListComponent) {
            this.f19109b = reactionHorizontalListComponent;
        }

        public static void m23128a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f19108a = state;
            builder.f19112e.clear();
        }

        public final Builder m23129a(E e) {
            this.f19108a.f19113a = e;
            this.f19112e.set(0);
            return this;
        }

        public final Builder m23130a(ImmutableList<ReactionUnitComponentNode> immutableList) {
            this.f19108a.f19114b = immutableList;
            this.f19112e.set(1);
            return this;
        }

        public final Component<ReactionHorizontalListComponent> m23132d() {
            int i = 0;
            if (this.f19112e == null || this.f19112e.nextClearBit(0) >= this.f19111d) {
                State state = this.f19108a;
                m23131a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f19111d) {
                if (!this.f19112e.get(i)) {
                    arrayList.add(this.f19110c[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m23131a() {
            super.a();
            this.f19108a = null;
            this.f19109b.f19118c.a(this);
        }
    }

    /* compiled from: badge_load_failure */
    public class State extends Component<ReactionHorizontalListComponent> implements Cloneable {
        E f19113a;
        ImmutableList<ReactionUnitComponentNode> f19114b;
        final /* synthetic */ ReactionHorizontalListComponent f19115c;

        public State(ReactionHorizontalListComponent reactionHorizontalListComponent) {
            this.f19115c = reactionHorizontalListComponent;
            super(reactionHorizontalListComponent);
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
            if (this.f19113a == null ? state.f19113a != null : !this.f19113a.equals(state.f19113a)) {
                return false;
            }
            if (this.f19114b != null) {
                if (this.f19114b.equals(state.f19114b)) {
                    return true;
                }
            } else if (state.f19114b == null) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.reaction.feed.corecomponents.spec.ReactionHorizontalListComponent m23133a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19116d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.corecomponents.spec.ReactionHorizontalListComponent.class;
        monitor-enter(r1);
        r0 = f19116d;	 Catch:{ all -> 0x003a }
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
        r0 = m23134b(r0);	 Catch:{ all -> 0x0035 }
        f19116d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19116d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.corecomponents.spec.ReactionHorizontalListComponent.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.corecomponents.spec.ReactionHorizontalListComponent");
    }

    private static ReactionHorizontalListComponent m23134b(InjectorLike injectorLike) {
        return new ReactionHorizontalListComponent(ReactionHorizontalListComponentSpec.m23138a(injectorLike));
    }

    @Inject
    public ReactionHorizontalListComponent(ReactionHorizontalListComponentSpec reactionHorizontalListComponentSpec) {
        this.f19117b = reactionHorizontalListComponentSpec;
    }

    public final Builder m23135a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) this.f19118c.a();
        if (builder == null) {
            builder = new Builder(this);
        }
        Builder.m23128a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode m23137b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        ReactionHorizontalListComponentSpec reactionHorizontalListComponentSpec = this.f19117b;
        CanLaunchReactionIntent canLaunchReactionIntent = state.f19113a;
        ImmutableList immutableList = state.f19114b;
        ContainerBuilder b = Container.a(componentContext).E(2).D(4).C(2).b(1.0f);
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            b.a(reactionHorizontalListComponentSpec.f19120a.m23011a(componentContext, (ReactionUnitComponentNode) immutableList.get(i), canLaunchReactionIntent));
        }
        return b.j();
    }

    public final void m23136a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ReactionHorizontalListComponent f19107c;

                public void run() {
                    this.f19107c.a(eventHandler, obj);
                }
            }, -205539796);
        }
    }
}
