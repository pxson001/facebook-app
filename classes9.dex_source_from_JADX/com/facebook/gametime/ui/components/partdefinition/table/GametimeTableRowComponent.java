package com.facebook.gametime.ui.components.partdefinition.table;

import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import android.text.Layout.Alignment;
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
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: SubscriptionManager.getSlotId failed  */
public class GametimeTableRowComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f25265b = new SynchronizedPool(2);
    private static volatile GametimeTableRowComponent f25266d;
    private final GametimeTableRowComponentSpec f25267c;

    /* compiled from: SubscriptionManager.getSlotId failed  */
    public class Builder extends com.facebook.components.Component.Builder<GametimeTableRowComponent> {
        public State f25256a;
        private String[] f25257b = new String[]{"row", "columnWidths"};
        private int f25258c = 2;
        public BitSet f25259d = new BitSet(this.f25258c);

        public static void m27192a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f25256a = state;
            builder.f25259d.clear();
        }

        public final Component<GametimeTableRowComponent> m27194d() {
            int i = 0;
            if (this.f25259d == null || this.f25259d.nextClearBit(0) >= this.f25258c) {
                State state = this.f25256a;
                m27193a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f25258c) {
                if (!this.f25259d.get(i)) {
                    arrayList.add(this.f25257b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m27193a() {
            super.a();
            this.f25256a = null;
            GametimeTableRowComponent.f25265b.a(this);
        }
    }

    /* compiled from: SubscriptionManager.getSlotId failed  */
    public class State extends Component<GametimeTableRowComponent> implements Cloneable {
        public ImmutableList<String> f25260a;
        public int[] f25261b;
        public int f25262c = GametimeTableRowComponentSpec.f25276a;
        public int f25263d = GametimeTableRowComponentSpec.f25277b;
        final /* synthetic */ GametimeTableRowComponent f25264e;

        public State(GametimeTableRowComponent gametimeTableRowComponent) {
            this.f25264e = gametimeTableRowComponent;
            super(gametimeTableRowComponent);
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
            if (this.f25260a == null ? state.f25260a != null : !this.f25260a.equals(state.f25260a)) {
                return false;
            }
            if (!Arrays.equals(this.f25261b, state.f25261b)) {
                return false;
            }
            if (this.f25262c != state.f25262c) {
                return false;
            }
            if (this.f25263d != state.f25263d) {
                return false;
            }
            return true;
        }
    }

    public static com.facebook.gametime.ui.components.partdefinition.table.GametimeTableRowComponent m27195a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f25266d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.gametime.ui.components.partdefinition.table.GametimeTableRowComponent.class;
        monitor-enter(r1);
        r0 = f25266d;	 Catch:{ all -> 0x003a }
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
        r0 = m27196b(r0);	 Catch:{ all -> 0x0035 }
        f25266d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f25266d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.ui.components.partdefinition.table.GametimeTableRowComponent.a(com.facebook.inject.InjectorLike):com.facebook.gametime.ui.components.partdefinition.table.GametimeTableRowComponent");
    }

    private static GametimeTableRowComponent m27196b(InjectorLike injectorLike) {
        return new GametimeTableRowComponent(GametimeTableRowComponentSpec.m27209a(injectorLike));
    }

    @Inject
    public GametimeTableRowComponent(GametimeTableRowComponentSpec gametimeTableRowComponentSpec) {
        this.f25267c = gametimeTableRowComponentSpec;
    }

    protected final InternalNode m27198b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        ImmutableList immutableList = state.f25260a;
        int[] iArr = state.f25261b;
        int i = state.f25262c;
        int i2 = state.f25263d;
        ContainerBuilder G = Container.a(componentContext).D(1).E(2).C(2).G(2131361920);
        for (int i3 = 0; i3 < immutableList.size(); i3++) {
            if (i3 == 0) {
                G.a(Text.a(componentContext).a((CharSequence) immutableList.get(i3)).b(true).o(i2).l(i).c().a(1.0f)).j(4, 2131434010).n(0, 2131431388);
            } else if (i3 == immutableList.size() - 1) {
                G.a(Text.a(componentContext).a((CharSequence) immutableList.get(i3)).b(true).o(i2).l(i).a(Alignment.ALIGN_CENTER).c().j(iArr[i3]).c(0, 2131434009)).n(4, 2131434010).n(2, 2131431388);
            } else {
                G.a(Text.a(componentContext).a((CharSequence) immutableList.get(i3)).b(true).o(i2).l(i).a(Alignment.ALIGN_CENTER).c().j(iArr[i3]).g(4, 2131434010).c(0, 2131434009));
            }
        }
        return G.j();
    }

    public final void m27197a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ GametimeTableRowComponent f25255c;

                public void run() {
                    this.f25255c.a(eventHandler, obj);
                }
            }, -929325906);
        }
    }
}
