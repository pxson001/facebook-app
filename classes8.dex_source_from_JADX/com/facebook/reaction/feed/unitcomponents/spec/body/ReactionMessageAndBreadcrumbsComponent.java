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
/* compiled from: _sync_failed */
public class ReactionMessageAndBreadcrumbsComponent<E extends CanLaunchReactionIntent & HasReactionSession> extends ComponentLifecycle {
    private static volatile ReactionMessageAndBreadcrumbsComponent f20297d;
    private final ReactionMessageAndBreadcrumbsComponentSpec f20298b;
    public final SynchronizedPool<Builder> f20299c = new SynchronizedPool(2);

    /* compiled from: _sync_failed */
    public class Builder extends com.facebook.components.Component.Builder<ReactionMessageAndBreadcrumbsComponent> {
        public State f20286a;
        final /* synthetic */ ReactionMessageAndBreadcrumbsComponent f20287b;
        private String[] f20288c = new String[]{"message", "breadcrumbs"};
        private int f20289d = 2;
        public BitSet f20290e = new BitSet(this.f20289d);

        public Builder(ReactionMessageAndBreadcrumbsComponent reactionMessageAndBreadcrumbsComponent) {
            this.f20287b = reactionMessageAndBreadcrumbsComponent;
        }

        public static void m24135a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f20286a = state;
            builder.f20290e.clear();
        }

        public final Component<ReactionMessageAndBreadcrumbsComponent> m24137d() {
            int i = 0;
            if (this.f20290e == null || this.f20290e.nextClearBit(0) >= this.f20289d) {
                State state = this.f20286a;
                m24136a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f20289d) {
                if (!this.f20290e.get(i)) {
                    arrayList.add(this.f20288c[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m24136a() {
            super.a();
            this.f20286a = null;
            this.f20287b.f20299c.a(this);
        }
    }

    /* compiled from: _sync_failed */
    public class State extends Component<ReactionMessageAndBreadcrumbsComponent> implements Cloneable {
        public String f20291a;
        public ImmutableList<? extends Breadcrumbs> f20292b;
        public E f20293c;
        public String f20294d;
        public String f20295e;
        final /* synthetic */ ReactionMessageAndBreadcrumbsComponent f20296f;

        public State(ReactionMessageAndBreadcrumbsComponent reactionMessageAndBreadcrumbsComponent) {
            this.f20296f = reactionMessageAndBreadcrumbsComponent;
            super(reactionMessageAndBreadcrumbsComponent);
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
            if (this.f20291a == null ? state.f20291a != null : !this.f20291a.equals(state.f20291a)) {
                return false;
            }
            if (this.f20292b == null ? state.f20292b != null : !this.f20292b.equals(state.f20292b)) {
                return false;
            }
            if (this.f20293c == null ? state.f20293c != null : !this.f20293c.equals(state.f20293c)) {
                return false;
            }
            if (this.f20294d == null ? state.f20294d != null : !this.f20294d.equals(state.f20294d)) {
                return false;
            }
            if (this.f20295e != null) {
                if (this.f20295e.equals(state.f20295e)) {
                    return true;
                }
            } else if (state.f20295e == null) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.reaction.feed.unitcomponents.spec.body.ReactionMessageAndBreadcrumbsComponent m24138a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20297d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.body.ReactionMessageAndBreadcrumbsComponent.class;
        monitor-enter(r1);
        r0 = f20297d;	 Catch:{ all -> 0x003a }
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
        r0 = m24139b(r0);	 Catch:{ all -> 0x0035 }
        f20297d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20297d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.body.ReactionMessageAndBreadcrumbsComponent.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.body.ReactionMessageAndBreadcrumbsComponent");
    }

    private static ReactionMessageAndBreadcrumbsComponent m24139b(InjectorLike injectorLike) {
        return new ReactionMessageAndBreadcrumbsComponent(ReactionMessageAndBreadcrumbsComponentSpec.m24142a(injectorLike));
    }

    @Inject
    public ReactionMessageAndBreadcrumbsComponent(ReactionMessageAndBreadcrumbsComponentSpec reactionMessageAndBreadcrumbsComponentSpec) {
        this.f20298b = reactionMessageAndBreadcrumbsComponentSpec;
    }

    protected final InternalNode m24141b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f20298b.m24144a(componentContext, state.f20291a, state.f20292b, state.f20293c, state.f20294d, state.f20295e);
    }

    public final void m24140a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ReactionMessageAndBreadcrumbsComponent f20285c;

                public void run() {
                    this.f20285c.a(eventHandler, obj);
                }
            }, -1208783937);
        }
    }
}
