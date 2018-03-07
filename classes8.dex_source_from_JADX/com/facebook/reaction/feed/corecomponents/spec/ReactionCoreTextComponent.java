package com.facebook.reaction.feed.corecomponents.spec;

import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.protocol.corecomponents.ReactionCoreComponentsGraphQLInterfaces.ReactionCoreComponentTextFields;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: base_on_gridline */
public class ReactionCoreTextComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f19085b = new SynchronizedPool(2);
    private static volatile ReactionCoreTextComponent f19086d;
    private final ReactionCoreTextComponentSpec f19087c;

    /* compiled from: base_on_gridline */
    public class Builder extends com.facebook.components.Component.Builder<ReactionCoreTextComponent> {
        State f19079a;
        private String[] f19080b = new String[]{"coreComponentTextFields"};
        private int f19081c = 1;
        private BitSet f19082d = new BitSet(this.f19081c);

        public static void m23105a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f19079a = state;
            builder.f19082d.clear();
        }

        public final Builder m23106a(ReactionCoreComponentTextFields reactionCoreComponentTextFields) {
            this.f19079a.f19083a = reactionCoreComponentTextFields;
            this.f19082d.set(0);
            return this;
        }

        public final Component<ReactionCoreTextComponent> m23108d() {
            int i = 0;
            if (this.f19082d == null || this.f19082d.nextClearBit(0) >= this.f19081c) {
                State state = this.f19079a;
                m23107a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f19081c) {
                if (!this.f19082d.get(i)) {
                    arrayList.add(this.f19080b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m23107a() {
            super.a();
            this.f19079a = null;
            ReactionCoreTextComponent.f19085b.a(this);
        }
    }

    /* compiled from: base_on_gridline */
    public class State extends Component<ReactionCoreTextComponent> implements Cloneable {
        ReactionCoreComponentTextFields f19083a;
        final /* synthetic */ ReactionCoreTextComponent f19084b;

        public State(ReactionCoreTextComponent reactionCoreTextComponent) {
            this.f19084b = reactionCoreTextComponent;
            super(reactionCoreTextComponent);
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
            if (this.f19083a != null) {
                if (this.f19083a.equals(state.f19083a)) {
                    return true;
                }
            } else if (state.f19083a == null) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.reaction.feed.corecomponents.spec.ReactionCoreTextComponent m23109a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19086d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.corecomponents.spec.ReactionCoreTextComponent.class;
        monitor-enter(r1);
        r0 = f19086d;	 Catch:{ all -> 0x003a }
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
        r0 = m23110b(r0);	 Catch:{ all -> 0x0035 }
        f19086d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19086d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.corecomponents.spec.ReactionCoreTextComponent.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.corecomponents.spec.ReactionCoreTextComponent");
    }

    private static ReactionCoreTextComponent m23110b(InjectorLike injectorLike) {
        return new ReactionCoreTextComponent(ReactionCoreTextComponentSpec.m23124a(injectorLike));
    }

    @Inject
    public ReactionCoreTextComponent(ReactionCoreTextComponentSpec reactionCoreTextComponentSpec) {
        this.f19087c = reactionCoreTextComponentSpec;
    }

    public final Builder m23111a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) f19085b.a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m23105a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode m23113b(ComponentContext componentContext, Component component) {
        return this.f19087c.m23127a(componentContext, ((State) component).f19083a);
    }

    public final void m23112a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ReactionCoreTextComponent f19078c;

                public void run() {
                    this.f19078c.a(eventHandler, obj);
                }
            }, -1672114853);
        }
    }
}
