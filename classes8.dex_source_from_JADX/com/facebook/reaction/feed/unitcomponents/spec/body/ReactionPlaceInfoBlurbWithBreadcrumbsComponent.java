package com.facebook.reaction.feed.unitcomponents.spec.body;

import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.feed.environment.HasContext;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultTimeRangeFields;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitPlaceInfoBlurbWithBreadcrumbsComponentFragment.PlaceInfoBlurbBreadcrumbs;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: _onClick */
public class ReactionPlaceInfoBlurbWithBreadcrumbsComponent<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends ComponentLifecycle {
    private static volatile ReactionPlaceInfoBlurbWithBreadcrumbsComponent f20355d;
    private final ReactionPlaceInfoBlurbWithBreadcrumbsComponentSpec f20356b;
    public final SynchronizedPool<Builder> f20357c = new SynchronizedPool(2);

    /* compiled from: _onClick */
    public class Builder extends com.facebook.components.Component.Builder<ReactionPlaceInfoBlurbWithBreadcrumbsComponent> {
        public State f20339a;
        final /* synthetic */ ReactionPlaceInfoBlurbWithBreadcrumbsComponent f20340b;
        private String[] f20341c = new String[]{"breadcrumbs", "placeCategory", "placeHourRanges", "placePriceRange", "placeRating", "placeRatingCount", "placeTimeZone", "environment", "unitId", "unitTypeToken"};
        private int f20342d = 10;
        public BitSet f20343e = new BitSet(this.f20342d);

        public Builder(ReactionPlaceInfoBlurbWithBreadcrumbsComponent reactionPlaceInfoBlurbWithBreadcrumbsComponent) {
            this.f20340b = reactionPlaceInfoBlurbWithBreadcrumbsComponent;
        }

        public static void m24166a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f20339a = state;
            builder.f20343e.clear();
        }

        public final Component<ReactionPlaceInfoBlurbWithBreadcrumbsComponent> m24168d() {
            int i = 0;
            if (this.f20343e == null || this.f20343e.nextClearBit(0) >= this.f20342d) {
                State state = this.f20339a;
                m24167a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f20342d) {
                if (!this.f20343e.get(i)) {
                    arrayList.add(this.f20341c[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m24167a() {
            super.a();
            this.f20339a = null;
            this.f20340b.f20357c.a(this);
        }
    }

    /* compiled from: _onClick */
    public class State extends Component<ReactionPlaceInfoBlurbWithBreadcrumbsComponent> implements Cloneable {
        public ImmutableList<PlaceInfoBlurbBreadcrumbs> f20344a;
        public String f20345b;
        public ImmutableList<? extends DefaultTimeRangeFields> f20346c;
        public String f20347d;
        public double f20348e;
        public double f20349f;
        public String f20350g;
        public E f20351h;
        public String f20352i;
        public String f20353j;
        final /* synthetic */ ReactionPlaceInfoBlurbWithBreadcrumbsComponent f20354k;

        public State(ReactionPlaceInfoBlurbWithBreadcrumbsComponent reactionPlaceInfoBlurbWithBreadcrumbsComponent) {
            this.f20354k = reactionPlaceInfoBlurbWithBreadcrumbsComponent;
            super(reactionPlaceInfoBlurbWithBreadcrumbsComponent);
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
            if (this.f20344a == null ? state.f20344a != null : !this.f20344a.equals(state.f20344a)) {
                return false;
            }
            if (this.f20345b == null ? state.f20345b != null : !this.f20345b.equals(state.f20345b)) {
                return false;
            }
            if (this.f20346c == null ? state.f20346c != null : !this.f20346c.equals(state.f20346c)) {
                return false;
            }
            if (this.f20347d == null ? state.f20347d != null : !this.f20347d.equals(state.f20347d)) {
                return false;
            }
            if (Double.compare(this.f20348e, state.f20348e) != 0) {
                return false;
            }
            if (Double.compare(this.f20349f, state.f20349f) != 0) {
                return false;
            }
            if (this.f20350g == null ? state.f20350g != null : !this.f20350g.equals(state.f20350g)) {
                return false;
            }
            if (this.f20351h == null ? state.f20351h != null : !this.f20351h.equals(state.f20351h)) {
                return false;
            }
            if (this.f20352i == null ? state.f20352i != null : !this.f20352i.equals(state.f20352i)) {
                return false;
            }
            if (this.f20353j != null) {
                if (this.f20353j.equals(state.f20353j)) {
                    return true;
                }
            } else if (state.f20353j == null) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceInfoBlurbWithBreadcrumbsComponent m24169a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20355d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceInfoBlurbWithBreadcrumbsComponent.class;
        monitor-enter(r1);
        r0 = f20355d;	 Catch:{ all -> 0x003a }
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
        r0 = m24170b(r0);	 Catch:{ all -> 0x0035 }
        f20355d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20355d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceInfoBlurbWithBreadcrumbsComponent.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceInfoBlurbWithBreadcrumbsComponent");
    }

    private static ReactionPlaceInfoBlurbWithBreadcrumbsComponent m24170b(InjectorLike injectorLike) {
        return new ReactionPlaceInfoBlurbWithBreadcrumbsComponent(ReactionPlaceInfoBlurbWithBreadcrumbsComponentSpec.m24174a(injectorLike));
    }

    @Inject
    public ReactionPlaceInfoBlurbWithBreadcrumbsComponent(ReactionPlaceInfoBlurbWithBreadcrumbsComponentSpec reactionPlaceInfoBlurbWithBreadcrumbsComponentSpec) {
        this.f20356b = reactionPlaceInfoBlurbWithBreadcrumbsComponentSpec;
    }

    protected final InternalNode m24172b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f20356b.m24177a(componentContext, state.f20344a, state.f20345b, state.f20346c, state.f20347d, state.f20348e, state.f20349f, state.f20350g, state.f20351h, state.f20352i, state.f20353j);
    }

    public final void m24171a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ReactionPlaceInfoBlurbWithBreadcrumbsComponent f20338c;

                public void run() {
                    this.f20338c.a(eventHandler, obj);
                }
            }, 1217424938);
        }
    }
}
