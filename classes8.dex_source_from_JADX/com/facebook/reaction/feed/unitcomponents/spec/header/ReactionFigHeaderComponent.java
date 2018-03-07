package com.facebook.reaction.feed.unitcomponents.spec.header;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.Container;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.widget.Text;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: ^3[47] */
public class ReactionFigHeaderComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f20465b = new SynchronizedPool(2);
    private static volatile ReactionFigHeaderComponent f20466d;
    private final ReactionFigHeaderComponentSpec f20467c;

    /* compiled from: ^3[47] */
    public class Builder extends com.facebook.components.Component.Builder<ReactionFigHeaderComponent> {
        public State f20459a;
        private String[] f20460b = new String[]{"title"};
        private int f20461c = 1;
        public BitSet f20462d = new BitSet(this.f20461c);

        public static void m24236a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f20459a = state;
            builder.f20462d.clear();
        }

        public final Component<ReactionFigHeaderComponent> m24238d() {
            int i = 0;
            if (this.f20462d == null || this.f20462d.nextClearBit(0) >= this.f20461c) {
                State state = this.f20459a;
                m24237a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f20461c) {
                if (!this.f20462d.get(i)) {
                    arrayList.add(this.f20460b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m24237a() {
            super.a();
            this.f20459a = null;
            ReactionFigHeaderComponent.f20465b.a(this);
        }
    }

    /* compiled from: ^3[47] */
    public class State extends Component<ReactionFigHeaderComponent> implements Cloneable {
        public String f20463a;
        final /* synthetic */ ReactionFigHeaderComponent f20464b;

        public State(ReactionFigHeaderComponent reactionFigHeaderComponent) {
            this.f20464b = reactionFigHeaderComponent;
            super(reactionFigHeaderComponent);
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
            if (this.f20463a != null) {
                if (this.f20463a.equals(state.f20463a)) {
                    return true;
                }
            } else if (state.f20463a == null) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.reaction.feed.unitcomponents.spec.header.ReactionFigHeaderComponent m24239a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20466d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.header.ReactionFigHeaderComponent.class;
        monitor-enter(r1);
        r0 = f20466d;	 Catch:{ all -> 0x003a }
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
        r0 = m24240b(r0);	 Catch:{ all -> 0x0035 }
        f20466d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20466d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.header.ReactionFigHeaderComponent.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.header.ReactionFigHeaderComponent");
    }

    private static ReactionFigHeaderComponent m24240b(InjectorLike injectorLike) {
        return new ReactionFigHeaderComponent(ReactionFigHeaderComponentSpec.m24245a(injectorLike));
    }

    @Inject
    public ReactionFigHeaderComponent(ReactionFigHeaderComponentSpec reactionFigHeaderComponentSpec) {
        this.f20467c = reactionFigHeaderComponentSpec;
    }

    protected final InternalNode m24242b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        ReactionFigHeaderComponentSpec reactionFigHeaderComponentSpec = this.f20467c;
        return Container.a(componentContext).F(2130773596).a(Text.a(componentContext).l(2131362113).o(2131427402).a(state.f20463a).a(ReactionFigHeaderComponentSpec.m24243a((Context) componentContext)).c().a(1).f(5, 2130773576).g(4, 2131431413)).j();
    }

    public final void m24241a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ReactionFigHeaderComponent f20458c;

                public void run() {
                    this.f20458c.a(eventHandler, obj);
                }
            }, 1579308689);
        }
    }
}
