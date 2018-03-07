package com.facebook.reaction.feed.corecomponents.spec;

import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.protocol.corecomponents.ReactionCoreComponentSpecsGraphQLModels.ReactionCoreComponentTextSpecFieldsModel;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: bar_configs */
public class ReactionCoreTextComponentMessage extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f19098b = new SynchronizedPool(2);
    private static volatile ReactionCoreTextComponentMessage f19099d;
    private final ReactionCoreTextComponentMessageSpec f19100c;

    /* compiled from: bar_configs */
    public class Builder extends com.facebook.components.Component.Builder<ReactionCoreTextComponentMessage> {
        public State f19091a;
        private String[] f19092b = new String[]{"message", "messageSpec"};
        private int f19093c = 2;
        public BitSet f19094d = new BitSet(this.f19093c);

        public static void m23114a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f19091a = state;
            builder.f19094d.clear();
        }

        public final Component<ReactionCoreTextComponentMessage> m23116d() {
            int i = 0;
            if (this.f19094d == null || this.f19094d.nextClearBit(0) >= this.f19093c) {
                State state = this.f19091a;
                m23115a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f19093c) {
                if (!this.f19094d.get(i)) {
                    arrayList.add(this.f19092b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m23115a() {
            super.a();
            this.f19091a = null;
            ReactionCoreTextComponentMessage.f19098b.a(this);
        }
    }

    /* compiled from: bar_configs */
    public class State extends Component<ReactionCoreTextComponentMessage> implements Cloneable {
        public CharSequence f19095a;
        public ReactionCoreComponentTextSpecFieldsModel f19096b;
        final /* synthetic */ ReactionCoreTextComponentMessage f19097c;

        public State(ReactionCoreTextComponentMessage reactionCoreTextComponentMessage) {
            this.f19097c = reactionCoreTextComponentMessage;
            super(reactionCoreTextComponentMessage);
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
            if (this.f19095a == null ? state.f19095a != null : !this.f19095a.equals(state.f19095a)) {
                return false;
            }
            if (this.f19096b != null) {
                if (this.f19096b.equals(state.f19096b)) {
                    return true;
                }
            } else if (state.f19096b == null) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.reaction.feed.corecomponents.spec.ReactionCoreTextComponentMessage m23117a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19099d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.corecomponents.spec.ReactionCoreTextComponentMessage.class;
        monitor-enter(r1);
        r0 = f19099d;	 Catch:{ all -> 0x003a }
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
        r0 = m23118b(r0);	 Catch:{ all -> 0x0035 }
        f19099d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19099d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.corecomponents.spec.ReactionCoreTextComponentMessage.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.corecomponents.spec.ReactionCoreTextComponentMessage");
    }

    private static ReactionCoreTextComponentMessage m23118b(InjectorLike injectorLike) {
        return new ReactionCoreTextComponentMessage(ReactionCoreTextComponentMessageSpec.m23121a(injectorLike));
    }

    @Inject
    public ReactionCoreTextComponentMessage(ReactionCoreTextComponentMessageSpec reactionCoreTextComponentMessageSpec) {
        this.f19100c = reactionCoreTextComponentMessageSpec;
    }

    protected final InternalNode m23120b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f19100c.m23123a(componentContext, state.f19095a, state.f19096b);
    }

    public final void m23119a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ReactionCoreTextComponentMessage f19090c;

                public void run() {
                    this.f19090c.a(eventHandler, obj);
                }
            }, 639961901);
        }
    }
}
