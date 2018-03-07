package com.facebook.reaction.feed.unitcomponents.spec.body;

import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitMessageAndBreadcrumbsComponentFragment.Breadcrumbs;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: a5d7d2d0c783aa93aabf5e944eafce6c */
public class ReactionBreadcrumbsComponent<E extends CanLaunchReactionIntent & HasReactionSession> extends ComponentLifecycle {
    private static volatile ReactionBreadcrumbsComponent f20226d;
    private final ReactionBreadcrumbsComponentSpec f20227b;
    public final SynchronizedPool<Builder> f20228c = new SynchronizedPool(2);

    /* compiled from: a5d7d2d0c783aa93aabf5e944eafce6c */
    public class Builder extends com.facebook.components.Component.Builder<ReactionBreadcrumbsComponent> {
        State f20216a;
        final /* synthetic */ ReactionBreadcrumbsComponent f20217b;
        private String[] f20218c = new String[]{"breadcrumbs"};
        private int f20219d = 1;
        private BitSet f20220e = new BitSet(this.f20219d);

        public Builder(ReactionBreadcrumbsComponent reactionBreadcrumbsComponent) {
            this.f20217b = reactionBreadcrumbsComponent;
        }

        public static void m24072a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f20216a = state;
            builder.f20220e.clear();
        }

        public final Builder m24074a(ImmutableList<? extends Breadcrumbs> immutableList) {
            this.f20216a.f20221a = immutableList;
            this.f20220e.set(0);
            return this;
        }

        public final Builder m24073a(E e) {
            this.f20216a.f20222b = e;
            return this;
        }

        public final Builder m24075a(String str) {
            this.f20216a.f20223c = str;
            return this;
        }

        public final Builder m24077b(String str) {
            this.f20216a.f20224d = str;
            return this;
        }

        public final Component<ReactionBreadcrumbsComponent> m24078d() {
            int i = 0;
            if (this.f20220e == null || this.f20220e.nextClearBit(0) >= this.f20219d) {
                State state = this.f20216a;
                m24076a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f20219d) {
                if (!this.f20220e.get(i)) {
                    arrayList.add(this.f20218c[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m24076a() {
            super.a();
            this.f20216a = null;
            this.f20217b.f20228c.a(this);
        }
    }

    /* compiled from: a5d7d2d0c783aa93aabf5e944eafce6c */
    public class State extends Component<ReactionBreadcrumbsComponent> implements Cloneable {
        ImmutableList<? extends Breadcrumbs> f20221a;
        E f20222b;
        String f20223c;
        String f20224d;
        final /* synthetic */ ReactionBreadcrumbsComponent f20225e;

        public State(ReactionBreadcrumbsComponent reactionBreadcrumbsComponent) {
            this.f20225e = reactionBreadcrumbsComponent;
            super(reactionBreadcrumbsComponent);
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
            if (this.f20221a == null ? state.f20221a != null : !this.f20221a.equals(state.f20221a)) {
                return false;
            }
            if (this.f20222b == null ? state.f20222b != null : !this.f20222b.equals(state.f20222b)) {
                return false;
            }
            if (this.f20223c == null ? state.f20223c != null : !this.f20223c.equals(state.f20223c)) {
                return false;
            }
            if (this.f20224d != null) {
                if (this.f20224d.equals(state.f20224d)) {
                    return true;
                }
            } else if (state.f20224d == null) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.reaction.feed.unitcomponents.spec.body.ReactionBreadcrumbsComponent m24079a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20226d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.body.ReactionBreadcrumbsComponent.class;
        monitor-enter(r1);
        r0 = f20226d;	 Catch:{ all -> 0x003a }
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
        r0 = m24080b(r0);	 Catch:{ all -> 0x0035 }
        f20226d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20226d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.body.ReactionBreadcrumbsComponent.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.body.ReactionBreadcrumbsComponent");
    }

    private static ReactionBreadcrumbsComponent m24080b(InjectorLike injectorLike) {
        return new ReactionBreadcrumbsComponent(ReactionBreadcrumbsComponentSpec.m24083a(injectorLike));
    }

    @Inject
    public ReactionBreadcrumbsComponent(ReactionBreadcrumbsComponentSpec reactionBreadcrumbsComponentSpec) {
        this.f20227b = reactionBreadcrumbsComponentSpec;
    }

    protected final InternalNode m24082b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f20227b.m24085a(componentContext, state.f20221a, state.f20222b, state.f20223c, state.f20224d);
    }

    public final void m24081a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ReactionBreadcrumbsComponent f20215c;

                public void run() {
                    this.f20215c.a(eventHandler, obj);
                }
            }, -268977341);
        }
    }
}
