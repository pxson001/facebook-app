package com.facebook.reaction.feed.unitcomponents.spec.body;

import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
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
/* compiled from: _buttons */
public class ReactionSectionHeaderComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f20404b = new SynchronizedPool(2);
    private static volatile ReactionSectionHeaderComponent f20405d;
    private final ReactionSectionHeaderComponentSpec f20406c;

    /* compiled from: _buttons */
    public class Builder extends com.facebook.components.Component.Builder<ReactionSectionHeaderComponent> {
        public State f20398a;
        private String[] f20399b = new String[]{"message"};
        private int f20400c = 1;
        public BitSet f20401d = new BitSet(this.f20400c);

        public static void m24197a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f20398a = state;
            builder.f20401d.clear();
        }

        public final Component<ReactionSectionHeaderComponent> m24199d() {
            int i = 0;
            if (this.f20401d == null || this.f20401d.nextClearBit(0) >= this.f20400c) {
                State state = this.f20398a;
                m24198a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f20400c) {
                if (!this.f20401d.get(i)) {
                    arrayList.add(this.f20399b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m24198a() {
            super.a();
            this.f20398a = null;
            ReactionSectionHeaderComponent.f20404b.a(this);
        }
    }

    /* compiled from: _buttons */
    public class State extends Component<ReactionSectionHeaderComponent> implements Cloneable {
        public String f20402a;
        final /* synthetic */ ReactionSectionHeaderComponent f20403b;

        public State(ReactionSectionHeaderComponent reactionSectionHeaderComponent) {
            this.f20403b = reactionSectionHeaderComponent;
            super(reactionSectionHeaderComponent);
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
            if (this.f20402a != null) {
                if (this.f20402a.equals(state.f20402a)) {
                    return true;
                }
            } else if (state.f20402a == null) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.reaction.feed.unitcomponents.spec.body.ReactionSectionHeaderComponent m24200a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20405d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.body.ReactionSectionHeaderComponent.class;
        monitor-enter(r1);
        r0 = f20405d;	 Catch:{ all -> 0x003a }
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
        r0 = m24201b(r0);	 Catch:{ all -> 0x0035 }
        f20405d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20405d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.body.ReactionSectionHeaderComponent.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.body.ReactionSectionHeaderComponent");
    }

    private static ReactionSectionHeaderComponent m24201b(InjectorLike injectorLike) {
        return new ReactionSectionHeaderComponent(ReactionSectionHeaderComponentSpec.m24205a(injectorLike));
    }

    @Inject
    public ReactionSectionHeaderComponent(ReactionSectionHeaderComponentSpec reactionSectionHeaderComponentSpec) {
        this.f20406c = reactionSectionHeaderComponentSpec;
    }

    protected final InternalNode m24203b(ComponentContext componentContext, Component component) {
        return Text.a(componentContext).a(((State) component).f20402a).l(2131361973).o(2131427402).c().a(1.0f).f(5, 2130773576).g(1, 2131431414).j();
    }

    public final void m24202a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ReactionSectionHeaderComponent f20397c;

                public void run() {
                    this.f20397c.a(eventHandler, obj);
                }
            }, -1900776424);
        }
    }
}
