package com.facebook.reaction.feed.unitcomponents.spec.body;

import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import android.text.TextUtils.TruncateAt;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.Container;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.widget.Text;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.feed.unitcomponents.util.ReactionSpannableStringUtil;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.PlaceInfoBlurbFieldsModel;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: _display */
public class ReactionPlaceWithMetadataComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f20390b = new SynchronizedPool(2);
    private static volatile ReactionPlaceWithMetadataComponent f20391d;
    private final ReactionPlaceWithMetadataComponentSpec f20392c;

    /* compiled from: _display */
    public class Builder extends com.facebook.components.Component.Builder<ReactionPlaceWithMetadataComponent> {
        public State f20382a;
        private String[] f20383b = new String[]{"message", "placeInfoBlurbFields"};
        private int f20384c = 2;
        public BitSet f20385d = new BitSet(this.f20384c);

        public static void m24188a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f20382a = state;
            builder.f20385d.clear();
        }

        public final Component<ReactionPlaceWithMetadataComponent> m24190d() {
            int i = 0;
            if (this.f20385d == null || this.f20385d.nextClearBit(0) >= this.f20384c) {
                State state = this.f20382a;
                m24189a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f20384c) {
                if (!this.f20385d.get(i)) {
                    arrayList.add(this.f20383b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m24189a() {
            super.a();
            this.f20382a = null;
            ReactionPlaceWithMetadataComponent.f20390b.a(this);
        }
    }

    /* compiled from: _display */
    public class State extends Component<ReactionPlaceWithMetadataComponent> implements Cloneable {
        public String f20386a;
        public PlaceInfoBlurbFieldsModel f20387b;
        String f20388c;
        final /* synthetic */ ReactionPlaceWithMetadataComponent f20389d;

        public State(ReactionPlaceWithMetadataComponent reactionPlaceWithMetadataComponent) {
            this.f20389d = reactionPlaceWithMetadataComponent;
            super(reactionPlaceWithMetadataComponent);
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
            if (this.f20386a == null ? state.f20386a != null : !this.f20386a.equals(state.f20386a)) {
                return false;
            }
            if (this.f20387b == null ? state.f20387b != null : !this.f20387b.equals(state.f20387b)) {
                return false;
            }
            if (this.f20388c != null) {
                if (this.f20388c.equals(state.f20388c)) {
                    return true;
                }
            } else if (state.f20388c == null) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceWithMetadataComponent m24191a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20391d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceWithMetadataComponent.class;
        monitor-enter(r1);
        r0 = f20391d;	 Catch:{ all -> 0x003a }
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
        r0 = m24192b(r0);	 Catch:{ all -> 0x0035 }
        f20391d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20391d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceWithMetadataComponent.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceWithMetadataComponent");
    }

    private static ReactionPlaceWithMetadataComponent m24192b(InjectorLike injectorLike) {
        return new ReactionPlaceWithMetadataComponent(ReactionPlaceWithMetadataComponentSpec.m24195a(injectorLike));
    }

    @Inject
    public ReactionPlaceWithMetadataComponent(ReactionPlaceWithMetadataComponentSpec reactionPlaceWithMetadataComponentSpec) {
        this.f20392c = reactionPlaceWithMetadataComponentSpec;
    }

    protected final InternalNode m24194b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        ReactionPlaceWithMetadataComponentSpec reactionPlaceWithMetadataComponentSpec = this.f20392c;
        String str = state.f20386a;
        PlaceInfoBlurbFieldsModel placeInfoBlurbFieldsModel = state.f20387b;
        return Container.a(componentContext).C(0).E(1).D(1).n(8, 2131431413).a(Text.a(componentContext).a(TruncateAt.END).b(true).o(2131427402).l(2131361972).a(placeInfoBlurbFieldsModel.eD_())).a(Text.a(componentContext).o(2131427400).l(2131361974).d(1.25f).a(TruncateAt.END).j(2).a(ReactionSpannableStringUtil.m24371a(reactionPlaceWithMetadataComponentSpec.f20394a, componentContext, state.f20388c, str, placeInfoBlurbFieldsModel)).c().d(1, 4).q(32)).j();
    }

    public final void m24193a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ReactionPlaceWithMetadataComponent f20381c;

                public void run() {
                    this.f20381c.a(eventHandler, obj);
                }
            }, -1622058143);
        }
    }
}
