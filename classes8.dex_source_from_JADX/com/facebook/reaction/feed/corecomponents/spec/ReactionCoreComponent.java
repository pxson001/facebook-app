package com.facebook.reaction.feed.corecomponents.spec;

import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.protocol.corecomponents.ReactionCoreComponentSpecsGraphQLModels.ReactionCoreComponentBorderSpecFieldsModel;
import com.facebook.reaction.protocol.corecomponents.ReactionCoreComponentSpecsGraphQLModels.ReactionCoreComponentMarginSpecFieldsModel;
import com.facebook.reaction.protocol.corecomponents.ReactionCoreComponentSpecsGraphQLModels.ReactionCoreComponentPaddingSpecFieldsModel;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: baselineAlignedChildIndex */
public class ReactionCoreComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f19038b = new SynchronizedPool(2);
    private static volatile ReactionCoreComponent f19039d;
    private final ReactionCoreComponentSpec f19040c;

    /* compiled from: baselineAlignedChildIndex */
    public class Builder extends com.facebook.components.Component.Builder<ReactionCoreComponent> {
        State f19028a;
        private String[] f19029b = new String[]{"content"};
        private int f19030c = 1;
        private BitSet f19031d = new BitSet(this.f19030c);

        public static void m23068a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f19028a = state;
            builder.f19031d.clear();
        }

        public final Builder m23069a(Component<?> component) {
            this.f19028a.f19032a = component;
            this.f19031d.set(0);
            return this;
        }

        public final Builder m23073a(String str) {
            this.f19028a.f19033b = str;
            return this;
        }

        public final Builder m23070a(ReactionCoreComponentBorderSpecFieldsModel reactionCoreComponentBorderSpecFieldsModel) {
            this.f19028a.f19034c = reactionCoreComponentBorderSpecFieldsModel;
            return this;
        }

        public final Builder m23071a(ReactionCoreComponentMarginSpecFieldsModel reactionCoreComponentMarginSpecFieldsModel) {
            this.f19028a.f19035d = reactionCoreComponentMarginSpecFieldsModel;
            return this;
        }

        public final Builder m23072a(ReactionCoreComponentPaddingSpecFieldsModel reactionCoreComponentPaddingSpecFieldsModel) {
            this.f19028a.f19036e = reactionCoreComponentPaddingSpecFieldsModel;
            return this;
        }

        public final Component<ReactionCoreComponent> m23075d() {
            int i = 0;
            if (this.f19031d == null || this.f19031d.nextClearBit(0) >= this.f19030c) {
                State state = this.f19028a;
                m23074a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f19030c) {
                if (!this.f19031d.get(i)) {
                    arrayList.add(this.f19029b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m23074a() {
            super.a();
            this.f19028a = null;
            ReactionCoreComponent.f19038b.a(this);
        }
    }

    /* compiled from: baselineAlignedChildIndex */
    public class State extends Component<ReactionCoreComponent> implements Cloneable {
        Component<?> f19032a;
        String f19033b;
        ReactionCoreComponentBorderSpecFieldsModel f19034c;
        ReactionCoreComponentMarginSpecFieldsModel f19035d;
        ReactionCoreComponentPaddingSpecFieldsModel f19036e;
        final /* synthetic */ ReactionCoreComponent f19037f;

        public State(ReactionCoreComponent reactionCoreComponent) {
            this.f19037f = reactionCoreComponent;
            super(reactionCoreComponent);
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
            if (this.f19032a == null ? state.f19032a != null : !this.f19032a.equals(state.f19032a)) {
                return false;
            }
            if (this.f19033b == null ? state.f19033b != null : !this.f19033b.equals(state.f19033b)) {
                return false;
            }
            if (this.f19034c == null ? state.f19034c != null : !this.f19034c.equals(state.f19034c)) {
                return false;
            }
            if (this.f19035d == null ? state.f19035d != null : !this.f19035d.equals(state.f19035d)) {
                return false;
            }
            if (this.f19036e != null) {
                if (this.f19036e.equals(state.f19036e)) {
                    return true;
                }
            } else if (state.f19036e == null) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.reaction.feed.corecomponents.spec.ReactionCoreComponent m23076a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19039d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.corecomponents.spec.ReactionCoreComponent.class;
        monitor-enter(r1);
        r0 = f19039d;	 Catch:{ all -> 0x003a }
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
        r0 = m23077b(r0);	 Catch:{ all -> 0x0035 }
        f19039d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19039d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.corecomponents.spec.ReactionCoreComponent.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.corecomponents.spec.ReactionCoreComponent");
    }

    private static ReactionCoreComponent m23077b(InjectorLike injectorLike) {
        return new ReactionCoreComponent(ReactionCoreComponentSpec.m23086a(injectorLike));
    }

    @Inject
    public ReactionCoreComponent(ReactionCoreComponentSpec reactionCoreComponentSpec) {
        this.f19040c = reactionCoreComponentSpec;
    }

    public final Builder m23078a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) f19038b.a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m23068a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode m23080b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return ReactionCoreComponentSpec.m23084a(componentContext, state.f19032a, state.f19033b, state.f19034c, state.f19035d, state.f19036e);
    }

    public final void m23079a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ReactionCoreComponent f19027c;

                public void run() {
                    this.f19027c.a(eventHandler, obj);
                }
            }, 1543915381);
        }
    }
}
