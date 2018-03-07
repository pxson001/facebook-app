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
import com.facebook.components.fb.fresco.FbFrescoComponent;
import com.facebook.components.reference.ColorDrawableReference;
import com.facebook.graphql.enums.GraphQLReactionCoreButtonGlyphAlignment;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.feed.corecomponents.spec.ReactionCoreButtonComponentSpec.C20851;
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
/* compiled from: bcd745f65dca7a67cf57ab2aff7e2cd7 */
public class ReactionCoreButtonComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f19017b = new SynchronizedPool(2);
    private static volatile ReactionCoreButtonComponent f19018d;
    private final ReactionCoreButtonComponentSpec f19019c;

    /* compiled from: bcd745f65dca7a67cf57ab2aff7e2cd7 */
    public class Builder extends com.facebook.components.Component.Builder<ReactionCoreButtonComponent> {
        public State f19009a;
        private String[] f19010b = new String[]{"textFields"};
        private int f19011c = 1;
        public BitSet f19012d = new BitSet(this.f19011c);

        public static void m23059a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f19009a = state;
            builder.f19012d.clear();
        }

        public final Component<ReactionCoreButtonComponent> m23061d() {
            int i = 0;
            if (this.f19012d == null || this.f19012d.nextClearBit(0) >= this.f19011c) {
                State state = this.f19009a;
                m23060a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f19011c) {
                if (!this.f19012d.get(i)) {
                    arrayList.add(this.f19010b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m23060a() {
            super.a();
            this.f19009a = null;
            ReactionCoreButtonComponent.f19017b.a(this);
        }
    }

    /* compiled from: bcd745f65dca7a67cf57ab2aff7e2cd7 */
    public class State extends Component<ReactionCoreButtonComponent> implements Cloneable {
        public ReactionCoreComponentTextFields f19013a;
        public GraphQLReactionCoreButtonGlyphAlignment f19014b;
        public ReactionImageFields f19015c;
        final /* synthetic */ ReactionCoreButtonComponent f19016d;

        public State(ReactionCoreButtonComponent reactionCoreButtonComponent) {
            this.f19016d = reactionCoreButtonComponent;
            super(reactionCoreButtonComponent);
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
            if (this.f19013a == null ? state.f19013a != null : !this.f19013a.equals(state.f19013a)) {
                return false;
            }
            if (this.f19014b == null ? state.f19014b != null : !this.f19014b.equals(state.f19014b)) {
                return false;
            }
            if (this.f19015c != null) {
                if (this.f19015c.equals(state.f19015c)) {
                    return true;
                }
            } else if (state.f19015c == null) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.reaction.feed.corecomponents.spec.ReactionCoreButtonComponent m23062a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19018d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.corecomponents.spec.ReactionCoreButtonComponent.class;
        monitor-enter(r1);
        r0 = f19018d;	 Catch:{ all -> 0x003a }
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
        r0 = m23063b(r0);	 Catch:{ all -> 0x0035 }
        f19018d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19018d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.corecomponents.spec.ReactionCoreButtonComponent.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.corecomponents.spec.ReactionCoreButtonComponent");
    }

    private static ReactionCoreButtonComponent m23063b(InjectorLike injectorLike) {
        return new ReactionCoreButtonComponent(ReactionCoreButtonComponentSpec.m23066a(injectorLike));
    }

    @Inject
    public ReactionCoreButtonComponent(ReactionCoreButtonComponentSpec reactionCoreButtonComponentSpec) {
        this.f19019c = reactionCoreButtonComponentSpec;
    }

    protected final InternalNode m23065b(ComponentContext componentContext, Component component) {
        com.facebook.components.ComponentLayout.Builder builder;
        State state = (State) component;
        ReactionCoreButtonComponentSpec reactionCoreButtonComponentSpec = this.f19019c;
        ReactionCoreComponentTextFields reactionCoreComponentTextFields = state.f19013a;
        GraphQLReactionCoreButtonGlyphAlignment graphQLReactionCoreButtonGlyphAlignment = state.f19014b;
        ReactionImageFields reactionImageFields = state.f19015c;
        ContainerBuilder E = Container.a(componentContext).E(2);
        int i = 2;
        if (graphQLReactionCoreButtonGlyphAlignment != null) {
            switch (C20851.f19020a[graphQLReactionCoreButtonGlyphAlignment.ordinal()]) {
                case 1:
                    i = 0;
                    break;
                case 2:
                    i = 1;
                    break;
                case 3:
                    break;
                case 4:
                    i = 3;
                    break;
                default:
                    break;
            }
        }
        ContainerBuilder C = E.C(i);
        if (reactionImageFields == null) {
            builder = null;
        } else {
            builder = FbFrescoComponent.a(componentContext).a(reactionCoreButtonComponentSpec.f19024c.a(reactionImageFields.b()).a(ReactionCoreButtonComponentSpec.f19021a).s()).a(ColorDrawableReference.a(componentContext).i(2131361970).b()).c();
            i = 7;
            if (graphQLReactionCoreButtonGlyphAlignment != null) {
                switch (C20851.f19020a[graphQLReactionCoreButtonGlyphAlignment.ordinal()]) {
                    case 1:
                        i = 3;
                        break;
                    case 2:
                        i = 1;
                        break;
                    case 3:
                        break;
                    case 4:
                        i = 6;
                        break;
                    default:
                        break;
                }
            }
            i = 2;
            builder = builder.c(i, 2131431416).p(2131431405).l(2131431405);
        }
        return C.a(builder).a(reactionCoreButtonComponentSpec.f19023b.m23111a(componentContext).m23106a(reactionCoreComponentTextFields).c().a(1.0f)).j();
    }

    public final void m23064a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ReactionCoreButtonComponent f19008c;

                public void run() {
                    this.f19008c.a(eventHandler, obj);
                }
            }, -204111085);
        }
    }
}
