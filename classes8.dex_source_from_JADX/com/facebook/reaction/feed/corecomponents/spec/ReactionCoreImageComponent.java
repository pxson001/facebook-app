package com.facebook.reaction.feed.corecomponents.spec;

import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.fb.fresco.FbFrescoComponent;
import com.facebook.components.reference.ColorDrawableReference;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionImageFields;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: baselineAlignBottom image view attribute requires honeycomb or later */
public class ReactionCoreImageComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f19052b = new SynchronizedPool(2);
    private static volatile ReactionCoreImageComponent f19053d;
    private final ReactionCoreImageComponentSpec f19054c;

    /* compiled from: baselineAlignBottom image view attribute requires honeycomb or later */
    public class Builder extends com.facebook.components.Component.Builder<ReactionCoreImageComponent> {
        public State f19045a;
        private String[] f19046b = new String[]{"image", "aspectRatio"};
        private int f19047c = 2;
        public BitSet f19048d = new BitSet(this.f19047c);

        public static void m23087a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f19045a = state;
            builder.f19048d.clear();
        }

        public final Component<ReactionCoreImageComponent> m23089d() {
            int i = 0;
            if (this.f19048d == null || this.f19048d.nextClearBit(0) >= this.f19047c) {
                State state = this.f19045a;
                m23088a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f19047c) {
                if (!this.f19048d.get(i)) {
                    arrayList.add(this.f19046b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m23088a() {
            super.a();
            this.f19045a = null;
            ReactionCoreImageComponent.f19052b.a(this);
        }
    }

    /* compiled from: baselineAlignBottom image view attribute requires honeycomb or later */
    public class State extends Component<ReactionCoreImageComponent> implements Cloneable {
        public ReactionImageFields f19049a;
        public float f19050b;
        final /* synthetic */ ReactionCoreImageComponent f19051c;

        public State(ReactionCoreImageComponent reactionCoreImageComponent) {
            this.f19051c = reactionCoreImageComponent;
            super(reactionCoreImageComponent);
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
            if (this.f19049a == null ? state.f19049a != null : !this.f19049a.equals(state.f19049a)) {
                return false;
            }
            if (Float.compare(this.f19050b, state.f19050b) != 0) {
                return false;
            }
            return true;
        }
    }

    public static com.facebook.reaction.feed.corecomponents.spec.ReactionCoreImageComponent m23090a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19053d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.corecomponents.spec.ReactionCoreImageComponent.class;
        monitor-enter(r1);
        r0 = f19053d;	 Catch:{ all -> 0x003a }
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
        r0 = m23091b(r0);	 Catch:{ all -> 0x0035 }
        f19053d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19053d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.corecomponents.spec.ReactionCoreImageComponent.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.corecomponents.spec.ReactionCoreImageComponent");
    }

    private static ReactionCoreImageComponent m23091b(InjectorLike injectorLike) {
        return new ReactionCoreImageComponent(ReactionCoreImageComponentSpec.m23094a(injectorLike));
    }

    @Inject
    public ReactionCoreImageComponent(ReactionCoreImageComponentSpec reactionCoreImageComponentSpec) {
        this.f19054c = reactionCoreImageComponentSpec;
    }

    protected final InternalNode m23093b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        ReactionCoreImageComponentSpec reactionCoreImageComponentSpec = this.f19054c;
        ReactionImageFields reactionImageFields = state.f19049a;
        return FbFrescoComponent.a(componentContext).b(state.f19050b).b(ScaleType.g).a(reactionCoreImageComponentSpec.f19057b.a(reactionImageFields.b()).a(ReactionCoreImageComponentSpec.f19055a).s()).a(ColorDrawableReference.a(componentContext).i(2131361970).b()).b();
    }

    public final void m23092a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ReactionCoreImageComponent f19044c;

                public void run() {
                    this.f19044c.a(eventHandler, obj);
                }
            }, -893184846);
        }
    }
}
