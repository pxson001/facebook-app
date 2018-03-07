package com.facebook.reaction.feed.unitcomponents.spec.body;

import android.net.Uri;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
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
/* compiled from: a valid stream type must be specified */
public class ReactionImageBlockComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f20276b = new SynchronizedPool(2);
    private static volatile ReactionImageBlockComponent f20277d;
    private final ReactionImageBlockComponentSpec f20278c;

    /* compiled from: a valid stream type must be specified */
    public class Builder extends com.facebook.components.Component.Builder<ReactionImageBlockComponent> {
        State f20266a;
        private String[] f20267b = new String[]{"imageUri", "title", "unitComponentStyle"};
        private int f20268c = 3;
        private BitSet f20269d = new BitSet(this.f20268c);

        public static void m24115a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f20266a = state;
            builder.f20269d.clear();
        }

        public final Builder m24116a(Uri uri) {
            this.f20266a.f20270a = uri;
            this.f20269d.set(0);
            return this;
        }

        public final Builder m24118a(String str) {
            this.f20266a.f20271b = str;
            this.f20269d.set(1);
            return this;
        }

        public final Builder m24121b(String str) {
            this.f20266a.f20272c = str;
            return this;
        }

        public final Builder m24120b(Uri uri) {
            this.f20266a.f20273d = uri;
            return this;
        }

        public final Builder m24117a(GraphQLReactionUnitComponentStyle graphQLReactionUnitComponentStyle) {
            this.f20266a.f20274e = graphQLReactionUnitComponentStyle;
            this.f20269d.set(2);
            return this;
        }

        public final Component<ReactionImageBlockComponent> m24122d() {
            int i = 0;
            if (this.f20269d == null || this.f20269d.nextClearBit(0) >= this.f20268c) {
                State state = this.f20266a;
                m24119a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f20268c) {
                if (!this.f20269d.get(i)) {
                    arrayList.add(this.f20267b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m24119a() {
            super.a();
            this.f20266a = null;
            ReactionImageBlockComponent.f20276b.a(this);
        }
    }

    /* compiled from: a valid stream type must be specified */
    public class State extends Component<ReactionImageBlockComponent> implements Cloneable {
        Uri f20270a;
        String f20271b;
        String f20272c;
        Uri f20273d;
        GraphQLReactionUnitComponentStyle f20274e;
        final /* synthetic */ ReactionImageBlockComponent f20275f;

        public State(ReactionImageBlockComponent reactionImageBlockComponent) {
            this.f20275f = reactionImageBlockComponent;
            super(reactionImageBlockComponent);
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
            if (this.f20270a == null ? state.f20270a != null : !this.f20270a.equals(state.f20270a)) {
                return false;
            }
            if (this.f20271b == null ? state.f20271b != null : !this.f20271b.equals(state.f20271b)) {
                return false;
            }
            if (this.f20272c == null ? state.f20272c != null : !this.f20272c.equals(state.f20272c)) {
                return false;
            }
            if (this.f20273d == null ? state.f20273d != null : !this.f20273d.equals(state.f20273d)) {
                return false;
            }
            if (this.f20274e != null) {
                if (this.f20274e.equals(state.f20274e)) {
                    return true;
                }
            } else if (state.f20274e == null) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.reaction.feed.unitcomponents.spec.body.ReactionImageBlockComponent m24123a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20277d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.body.ReactionImageBlockComponent.class;
        monitor-enter(r1);
        r0 = f20277d;	 Catch:{ all -> 0x003a }
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
        r0 = m24124b(r0);	 Catch:{ all -> 0x0035 }
        f20277d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20277d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.body.ReactionImageBlockComponent.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.body.ReactionImageBlockComponent");
    }

    private static ReactionImageBlockComponent m24124b(InjectorLike injectorLike) {
        return new ReactionImageBlockComponent(ReactionImageBlockComponentSpec.m24130a(injectorLike));
    }

    @Inject
    public ReactionImageBlockComponent(ReactionImageBlockComponentSpec reactionImageBlockComponentSpec) {
        this.f20278c = reactionImageBlockComponentSpec;
    }

    public final Builder m24125a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) f20276b.a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m24115a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode m24127b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f20278c.m24134a(componentContext, state.f20270a, state.f20271b, state.f20272c, state.f20273d, state.f20274e);
    }

    public final void m24126a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ReactionImageBlockComponent f20265c;

                public void run() {
                    this.f20265c.a(eventHandler, obj);
                }
            }, 989608093);
        }
    }
}
