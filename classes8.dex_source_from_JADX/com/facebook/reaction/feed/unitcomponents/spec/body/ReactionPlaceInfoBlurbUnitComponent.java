package com.facebook.reaction.feed.unitcomponents.spec.body;

import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.PlaceInfoBlurbFieldsModel;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: _result */
public class ReactionPlaceInfoBlurbUnitComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f20329b = new SynchronizedPool(2);
    private static volatile ReactionPlaceInfoBlurbUnitComponent f20330d;
    private final ReactionPlaceInfoBlurbUnitComponentSpec f20331c;

    /* compiled from: _result */
    public class Builder extends com.facebook.components.Component.Builder<ReactionPlaceInfoBlurbUnitComponent> {
        public State f20319a;
        private String[] f20320b = new String[]{"message", "placeInfoBlurbFields"};
        private int f20321c = 2;
        public BitSet f20322d = new BitSet(this.f20321c);

        public static void m24156a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f20319a = state;
            builder.f20322d.clear();
        }

        public final Component<ReactionPlaceInfoBlurbUnitComponent> m24158d() {
            int i = 0;
            if (this.f20322d == null || this.f20322d.nextClearBit(0) >= this.f20321c) {
                State state = this.f20319a;
                m24157a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f20321c) {
                if (!this.f20322d.get(i)) {
                    arrayList.add(this.f20320b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m24157a() {
            super.a();
            this.f20319a = null;
            ReactionPlaceInfoBlurbUnitComponent.f20329b.a(this);
        }
    }

    /* compiled from: _result */
    public class State extends Component<ReactionPlaceInfoBlurbUnitComponent> implements Cloneable {
        public String f20323a;
        public PlaceInfoBlurbFieldsModel f20324b;
        public DefaultTextWithEntitiesFields f20325c;
        public DefaultTextWithEntitiesFields f20326d;
        public boolean f20327e;
        final /* synthetic */ ReactionPlaceInfoBlurbUnitComponent f20328f;

        public State(ReactionPlaceInfoBlurbUnitComponent reactionPlaceInfoBlurbUnitComponent) {
            this.f20328f = reactionPlaceInfoBlurbUnitComponent;
            super(reactionPlaceInfoBlurbUnitComponent);
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
            if (this.f20323a == null ? state.f20323a != null : !this.f20323a.equals(state.f20323a)) {
                return false;
            }
            if (this.f20324b == null ? state.f20324b != null : !this.f20324b.equals(state.f20324b)) {
                return false;
            }
            if (this.f20325c == null ? state.f20325c != null : !this.f20325c.equals(state.f20325c)) {
                return false;
            }
            if (this.f20326d == null ? state.f20326d != null : !this.f20326d.equals(state.f20326d)) {
                return false;
            }
            if (this.f20327e != state.f20327e) {
                return false;
            }
            return true;
        }
    }

    public static com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceInfoBlurbUnitComponent m24159a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20330d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceInfoBlurbUnitComponent.class;
        monitor-enter(r1);
        r0 = f20330d;	 Catch:{ all -> 0x003a }
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
        r0 = m24160b(r0);	 Catch:{ all -> 0x0035 }
        f20330d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20330d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceInfoBlurbUnitComponent.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceInfoBlurbUnitComponent");
    }

    private static ReactionPlaceInfoBlurbUnitComponent m24160b(InjectorLike injectorLike) {
        return new ReactionPlaceInfoBlurbUnitComponent(ReactionPlaceInfoBlurbUnitComponentSpec.m24163a(injectorLike));
    }

    @Inject
    public ReactionPlaceInfoBlurbUnitComponent(ReactionPlaceInfoBlurbUnitComponentSpec reactionPlaceInfoBlurbUnitComponentSpec) {
        this.f20331c = reactionPlaceInfoBlurbUnitComponentSpec;
    }

    protected final InternalNode m24162b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f20331c.m24165a(componentContext, state.f20323a, state.f20324b, state.f20325c, state.f20326d, state.f20327e);
    }

    public final void m24161a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ReactionPlaceInfoBlurbUnitComponent f20318c;

                public void run() {
                    this.f20318c.a(eventHandler, obj);
                }
            }, 1328622573);
        }
    }
}
