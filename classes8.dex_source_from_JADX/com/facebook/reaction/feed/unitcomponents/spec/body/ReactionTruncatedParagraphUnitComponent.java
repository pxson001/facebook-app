package com.facebook.reaction.feed.unitcomponents.spec.body;

import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import android.text.SpannableStringBuilder;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: _access */
public class ReactionTruncatedParagraphUnitComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f20420b = new SynchronizedPool(2);
    private static volatile ReactionTruncatedParagraphUnitComponent f20421d;
    private final ReactionTruncatedParagraphUnitComponentSpec f20422c;

    /* compiled from: _access */
    public class Builder extends com.facebook.components.Component.Builder<ReactionTruncatedParagraphUnitComponent> {
        public State f20411a;
        private String[] f20412b = new String[]{"message"};
        private int f20413c = 1;
        private BitSet f20414d = new BitSet(this.f20413c);

        public static void m24206a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f20411a = state;
            builder.f20414d.clear();
        }

        public final Builder m24207a(SpannableStringBuilder spannableStringBuilder) {
            this.f20411a.f20415a = spannableStringBuilder;
            this.f20414d.set(0);
            return this;
        }

        public final Builder m24208a(DefaultTextWithEntitiesFields defaultTextWithEntitiesFields) {
            this.f20411a.f20417c = defaultTextWithEntitiesFields;
            return this;
        }

        public final Component<ReactionTruncatedParagraphUnitComponent> m24210d() {
            int i = 0;
            if (this.f20414d == null || this.f20414d.nextClearBit(0) >= this.f20413c) {
                State state = this.f20411a;
                m24209a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f20413c) {
                if (!this.f20414d.get(i)) {
                    arrayList.add(this.f20412b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m24209a() {
            super.a();
            this.f20411a = null;
            ReactionTruncatedParagraphUnitComponent.f20420b.a(this);
        }
    }

    /* compiled from: _access */
    public class State extends Component<ReactionTruncatedParagraphUnitComponent> implements Cloneable {
        SpannableStringBuilder f20415a;
        public boolean f20416b;
        DefaultTextWithEntitiesFields f20417c;
        public GraphQLReactionUnitComponentStyle f20418d;
        final /* synthetic */ ReactionTruncatedParagraphUnitComponent f20419e;

        public State(ReactionTruncatedParagraphUnitComponent reactionTruncatedParagraphUnitComponent) {
            this.f20419e = reactionTruncatedParagraphUnitComponent;
            super(reactionTruncatedParagraphUnitComponent);
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
            if (this.f20415a == null ? state.f20415a != null : !this.f20415a.equals(state.f20415a)) {
                return false;
            }
            if (this.f20416b != state.f20416b) {
                return false;
            }
            if (this.f20417c == null ? state.f20417c != null : !this.f20417c.equals(state.f20417c)) {
                return false;
            }
            if (this.f20418d != null) {
                if (this.f20418d.equals(state.f20418d)) {
                    return true;
                }
            } else if (state.f20418d == null) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.reaction.feed.unitcomponents.spec.body.ReactionTruncatedParagraphUnitComponent m24211a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20421d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.body.ReactionTruncatedParagraphUnitComponent.class;
        monitor-enter(r1);
        r0 = f20421d;	 Catch:{ all -> 0x003a }
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
        r0 = m24212b(r0);	 Catch:{ all -> 0x0035 }
        f20421d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20421d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.body.ReactionTruncatedParagraphUnitComponent.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.body.ReactionTruncatedParagraphUnitComponent");
    }

    private static ReactionTruncatedParagraphUnitComponent m24212b(InjectorLike injectorLike) {
        return new ReactionTruncatedParagraphUnitComponent(ReactionTruncatedParagraphUnitComponentSpec.m24216a(injectorLike));
    }

    @Inject
    public ReactionTruncatedParagraphUnitComponent(ReactionTruncatedParagraphUnitComponentSpec reactionTruncatedParagraphUnitComponentSpec) {
        this.f20422c = reactionTruncatedParagraphUnitComponentSpec;
    }

    public final Builder m24213a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) f20420b.a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m24206a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode m24215b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f20422c.m24218a(componentContext, state.f20415a, state.f20416b, state.f20417c, state.f20418d);
    }

    public final void m24214a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ReactionTruncatedParagraphUnitComponent f20410c;

                public void run() {
                    this.f20410c.a(eventHandler, obj);
                }
            }, -1731219652);
        }
    }
}
