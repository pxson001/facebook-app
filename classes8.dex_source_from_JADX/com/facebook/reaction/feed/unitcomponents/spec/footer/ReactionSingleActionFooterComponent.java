package com.facebook.reaction.feed.unitcomponents.spec.footer;

import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout.ContainerBuilder;
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
/* compiled from: ^5[0-5] */
public class ReactionSingleActionFooterComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f20452b = new SynchronizedPool(2);
    private static volatile ReactionSingleActionFooterComponent f20453d;
    private final ReactionSingleActionFooterComponentSpec f20454c;

    /* compiled from: ^5[0-5] */
    public class Builder extends com.facebook.components.Component.Builder<ReactionSingleActionFooterComponent> {
        public State f20445a;
        private String[] f20446b = new String[]{"message", "isCenterFooter"};
        private int f20447c = 2;
        public BitSet f20448d = new BitSet(this.f20447c);

        public static void m24227a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f20445a = state;
            builder.f20448d.clear();
        }

        public final Component<ReactionSingleActionFooterComponent> m24229d() {
            int i = 0;
            if (this.f20448d == null || this.f20448d.nextClearBit(0) >= this.f20447c) {
                State state = this.f20445a;
                m24228a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f20447c) {
                if (!this.f20448d.get(i)) {
                    arrayList.add(this.f20446b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m24228a() {
            super.a();
            this.f20445a = null;
            ReactionSingleActionFooterComponent.f20452b.a(this);
        }
    }

    /* compiled from: ^5[0-5] */
    public class State extends Component<ReactionSingleActionFooterComponent> implements Cloneable {
        public String f20449a;
        public boolean f20450b;
        final /* synthetic */ ReactionSingleActionFooterComponent f20451c;

        public State(ReactionSingleActionFooterComponent reactionSingleActionFooterComponent) {
            this.f20451c = reactionSingleActionFooterComponent;
            super(reactionSingleActionFooterComponent);
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
            if (this.f20449a == null ? state.f20449a != null : !this.f20449a.equals(state.f20449a)) {
                return false;
            }
            if (this.f20450b != state.f20450b) {
                return false;
            }
            return true;
        }
    }

    public static com.facebook.reaction.feed.unitcomponents.spec.footer.ReactionSingleActionFooterComponent m24230a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20453d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.footer.ReactionSingleActionFooterComponent.class;
        monitor-enter(r1);
        r0 = f20453d;	 Catch:{ all -> 0x003a }
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
        r0 = m24231b(r0);	 Catch:{ all -> 0x0035 }
        f20453d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20453d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.footer.ReactionSingleActionFooterComponent.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.footer.ReactionSingleActionFooterComponent");
    }

    private static ReactionSingleActionFooterComponent m24231b(InjectorLike injectorLike) {
        return new ReactionSingleActionFooterComponent(ReactionSingleActionFooterComponentSpec.m24235a(injectorLike));
    }

    @Inject
    public ReactionSingleActionFooterComponent(ReactionSingleActionFooterComponentSpec reactionSingleActionFooterComponentSpec) {
        this.f20454c = reactionSingleActionFooterComponentSpec;
    }

    protected final InternalNode m24233b(ComponentContext componentContext, Component component) {
        int i;
        State state = (State) component;
        CharSequence charSequence = state.f20449a;
        boolean z = state.f20450b;
        ContainerBuilder E = Container.a(componentContext).C(2).b(1.0f).E(2);
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        E = E.D(i).i(5, 2130773575).b(true).F(2130773596);
        com.facebook.components.widget.Text.Builder a = Text.a(componentContext);
        a.a.n = a.b(2130773579, 0);
        return E.a(a.l(2131364140).a(charSequence).c().a(z ? 0.0f : 1.0f).g(8, 2131431413).a(true)).j();
    }

    public final void m24232a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ReactionSingleActionFooterComponent f20444c;

                public void run() {
                    this.f20444c.a(eventHandler, obj);
                }
            }, -1777563428);
        }
    }
}
