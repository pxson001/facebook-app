package com.facebook.reaction.feed.unitcomponents.spec.body;

import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.Container;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.widget.Text;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: a21f4aa6b9805eb807544171390b05cd */
public class ReactionCenteredParagraphUnitComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f20241b = new SynchronizedPool(2);
    private static volatile ReactionCenteredParagraphUnitComponent f20242d;
    private final ReactionCenteredParagraphUnitComponentSpec f20243c;

    /* compiled from: a21f4aa6b9805eb807544171390b05cd */
    public class Builder extends com.facebook.components.Component.Builder<ReactionCenteredParagraphUnitComponent> {
        State f20234a;
        private String[] f20235b = new String[]{"message"};
        private int f20236c = 1;
        private BitSet f20237d = new BitSet(this.f20236c);

        public static void m24086a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f20234a = state;
            builder.f20237d.clear();
        }

        public final Builder m24087a(SpannableStringBuilder spannableStringBuilder) {
            this.f20234a.f20238a = spannableStringBuilder;
            this.f20237d.set(0);
            return this;
        }

        public final Builder m24088a(GraphQLReactionUnitComponentStyle graphQLReactionUnitComponentStyle) {
            this.f20234a.f20239b = graphQLReactionUnitComponentStyle;
            return this;
        }

        public final Component<ReactionCenteredParagraphUnitComponent> m24090d() {
            int i = 0;
            if (this.f20237d == null || this.f20237d.nextClearBit(0) >= this.f20236c) {
                State state = this.f20234a;
                m24089a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f20236c) {
                if (!this.f20237d.get(i)) {
                    arrayList.add(this.f20235b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m24089a() {
            super.a();
            this.f20234a = null;
            ReactionCenteredParagraphUnitComponent.f20241b.a(this);
        }
    }

    /* compiled from: a21f4aa6b9805eb807544171390b05cd */
    public class State extends Component<ReactionCenteredParagraphUnitComponent> implements Cloneable {
        SpannableStringBuilder f20238a;
        GraphQLReactionUnitComponentStyle f20239b;
        final /* synthetic */ ReactionCenteredParagraphUnitComponent f20240c;

        public State(ReactionCenteredParagraphUnitComponent reactionCenteredParagraphUnitComponent) {
            this.f20240c = reactionCenteredParagraphUnitComponent;
            super(reactionCenteredParagraphUnitComponent);
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
            if (this.f20238a == null ? state.f20238a != null : !this.f20238a.equals(state.f20238a)) {
                return false;
            }
            if (this.f20239b != null) {
                if (this.f20239b.equals(state.f20239b)) {
                    return true;
                }
            } else if (state.f20239b == null) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.reaction.feed.unitcomponents.spec.body.ReactionCenteredParagraphUnitComponent m24091a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20242d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.body.ReactionCenteredParagraphUnitComponent.class;
        monitor-enter(r1);
        r0 = f20242d;	 Catch:{ all -> 0x003a }
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
        r0 = m24092b(r0);	 Catch:{ all -> 0x0035 }
        f20242d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20242d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.body.ReactionCenteredParagraphUnitComponent.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.body.ReactionCenteredParagraphUnitComponent");
    }

    private static ReactionCenteredParagraphUnitComponent m24092b(InjectorLike injectorLike) {
        return new ReactionCenteredParagraphUnitComponent(ReactionCenteredParagraphUnitComponentSpec.m24097a(injectorLike));
    }

    @Inject
    public ReactionCenteredParagraphUnitComponent(ReactionCenteredParagraphUnitComponentSpec reactionCenteredParagraphUnitComponentSpec) {
        this.f20243c = reactionCenteredParagraphUnitComponentSpec;
    }

    public final Builder m24093a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) f20241b.a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m24086a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode m24095b(ComponentContext componentContext, Component component) {
        int i;
        State state = (State) component;
        CharSequence charSequence = state.f20238a;
        GraphQLReactionUnitComponentStyle graphQLReactionUnitComponentStyle = state.f20239b;
        if (graphQLReactionUnitComponentStyle == null || graphQLReactionUnitComponentStyle != GraphQLReactionUnitComponentStyle.LEFT_DARK_PARAGRAPH_LONG_TRUNCATION) {
            i = 2131361974;
        } else {
            i = 2131361972;
        }
        int i2 = i;
        if (graphQLReactionUnitComponentStyle == null || graphQLReactionUnitComponentStyle != GraphQLReactionUnitComponentStyle.LEFT_DARK_PARAGRAPH_LONG_TRUNCATION) {
            i = 2131427400;
        } else {
            i = 2131427402;
        }
        return Container.a(componentContext).C(2).E(1).D(1).F(2130773596).a(Text.a(componentContext).d(1.25f).o(i).l(i2).a(Alignment.ALIGN_NORMAL).a(charSequence).c().a(1.0f).c(4, 2131431413).b(5, 2130773575).g(5, 2131431413)).j();
    }

    public final void m24094a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ReactionCenteredParagraphUnitComponent f20233c;

                public void run() {
                    this.f20233c.a(eventHandler, obj);
                }
            }, 181347409);
        }
    }
}
