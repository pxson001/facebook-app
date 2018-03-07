package com.facebook.reaction.feed.corecomponents.spec;

import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.Container;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.fb.fresco.FbFrescoComponent;
import com.facebook.components.reference.ColorDrawableReference;
import com.facebook.graphql.enums.GraphQLReactionCoreImageTextImageSize;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.feed.corecomponents.util.ReactionCoreComponentsUtil;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionImageFields;
import com.facebook.reaction.protocol.corecomponents.ReactionCoreComponentsGraphQLInterfaces.ReactionCoreComponentTextFields;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: baseline image view attribute requires honeycomb or later */
public class ReactionCoreImageTextComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f19069b = new SynchronizedPool(2);
    private static volatile ReactionCoreImageTextComponent f19070d;
    private final ReactionCoreImageTextComponentSpec f19071c;

    /* compiled from: baseline image view attribute requires honeycomb or later */
    public class Builder extends com.facebook.components.Component.Builder<ReactionCoreImageTextComponent> {
        public State f19061a;
        private String[] f19062b = new String[]{"image", "textFields"};
        private int f19063c = 2;
        public BitSet f19064d = new BitSet(this.f19063c);

        public static void m23096a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f19061a = state;
            builder.f19064d.clear();
        }

        public final Component<ReactionCoreImageTextComponent> m23098d() {
            int i = 0;
            if (this.f19064d == null || this.f19064d.nextClearBit(0) >= this.f19063c) {
                State state = this.f19061a;
                m23097a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f19063c) {
                if (!this.f19064d.get(i)) {
                    arrayList.add(this.f19062b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m23097a() {
            super.a();
            this.f19061a = null;
            ReactionCoreImageTextComponent.f19069b.a(this);
        }
    }

    /* compiled from: baseline image view attribute requires honeycomb or later */
    public class State extends Component<ReactionCoreImageTextComponent> implements Cloneable {
        public ReactionImageFields f19065a;
        public ReactionCoreComponentTextFields f19066b;
        public GraphQLReactionCoreImageTextImageSize f19067c;
        final /* synthetic */ ReactionCoreImageTextComponent f19068d;

        public State(ReactionCoreImageTextComponent reactionCoreImageTextComponent) {
            this.f19068d = reactionCoreImageTextComponent;
            super(reactionCoreImageTextComponent);
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
            if (this.f19065a == null ? state.f19065a != null : !this.f19065a.equals(state.f19065a)) {
                return false;
            }
            if (this.f19066b == null ? state.f19066b != null : !this.f19066b.equals(state.f19066b)) {
                return false;
            }
            if (this.f19067c != null) {
                if (this.f19067c.equals(state.f19067c)) {
                    return true;
                }
            } else if (state.f19067c == null) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.reaction.feed.corecomponents.spec.ReactionCoreImageTextComponent m23099a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19070d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.corecomponents.spec.ReactionCoreImageTextComponent.class;
        monitor-enter(r1);
        r0 = f19070d;	 Catch:{ all -> 0x003a }
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
        r0 = m23100b(r0);	 Catch:{ all -> 0x0035 }
        f19070d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19070d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.corecomponents.spec.ReactionCoreImageTextComponent.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.corecomponents.spec.ReactionCoreImageTextComponent");
    }

    private static ReactionCoreImageTextComponent m23100b(InjectorLike injectorLike) {
        return new ReactionCoreImageTextComponent(ReactionCoreImageTextComponentSpec.m23103a(injectorLike));
    }

    @Inject
    public ReactionCoreImageTextComponent(ReactionCoreImageTextComponentSpec reactionCoreImageTextComponentSpec) {
        this.f19071c = reactionCoreImageTextComponentSpec;
    }

    protected final InternalNode m23102b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        ReactionCoreImageTextComponentSpec reactionCoreImageTextComponentSpec = this.f19071c;
        ReactionImageFields reactionImageFields = state.f19065a;
        ReactionCoreComponentTextFields reactionCoreComponentTextFields = state.f19066b;
        GraphQLReactionCoreImageTextImageSize graphQLReactionCoreImageTextImageSize = state.f19067c;
        return Container.a(componentContext).E(2).C(2).a(FbFrescoComponent.a(componentContext).a(reactionCoreImageTextComponentSpec.f19075c.a(reactionImageFields.b()).a(ReactionCoreImageTextComponentSpec.f19072a).s()).a(ColorDrawableReference.a(componentContext).i(2131361970).b()).c().c(2, 2131431416).p(ReactionCoreComponentsUtil.m4767a(graphQLReactionCoreImageTextImageSize)).l(ReactionCoreComponentsUtil.m4767a(graphQLReactionCoreImageTextImageSize))).a(reactionCoreImageTextComponentSpec.f19074b.m23111a(componentContext).m23106a(reactionCoreComponentTextFields).c().a(1.0f)).j();
    }

    public final void m23101a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ReactionCoreImageTextComponent f19060c;

                public void run() {
                    this.f19060c.a(eventHandler, obj);
                }
            }, -1693065160);
        }
    }
}
