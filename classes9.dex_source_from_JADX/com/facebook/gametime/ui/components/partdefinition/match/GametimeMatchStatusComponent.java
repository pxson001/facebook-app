package com.facebook.gametime.ui.components.partdefinition.match;

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
/* compiled from: SuggestionsFragment.onHiddenChanged */
public class GametimeMatchStatusComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f25228b = new SynchronizedPool(2);
    private static volatile GametimeMatchStatusComponent f25229d;
    private final GametimeMatchStatusComponentSpec f25230c;

    /* compiled from: SuggestionsFragment.onHiddenChanged */
    public class Builder extends com.facebook.components.Component.Builder<GametimeMatchStatusComponent> {
        public State f25222a;
        private String[] f25223b = new String[]{"statuses"};
        private int f25224c = 1;
        public BitSet f25225d = new BitSet(this.f25224c);

        public static void m27164a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f25222a = state;
            builder.f25225d.clear();
        }

        public final Component<GametimeMatchStatusComponent> m27166d() {
            int i = 0;
            if (this.f25225d == null || this.f25225d.nextClearBit(0) >= this.f25224c) {
                State state = this.f25222a;
                m27165a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f25224c) {
                if (!this.f25225d.get(i)) {
                    arrayList.add(this.f25223b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m27165a() {
            super.a();
            this.f25222a = null;
            GametimeMatchStatusComponent.f25228b.a(this);
        }
    }

    /* compiled from: SuggestionsFragment.onHiddenChanged */
    public class State extends Component<GametimeMatchStatusComponent> implements Cloneable {
        public ImmutableList<String> f25226a;
        final /* synthetic */ GametimeMatchStatusComponent f25227b;

        public State(GametimeMatchStatusComponent gametimeMatchStatusComponent) {
            this.f25227b = gametimeMatchStatusComponent;
            super(gametimeMatchStatusComponent);
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
            if (this.f25226a != null) {
                if (this.f25226a.equals(state.f25226a)) {
                    return true;
                }
            } else if (state.f25226a == null) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchStatusComponent m27167a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f25229d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchStatusComponent.class;
        monitor-enter(r1);
        r0 = f25229d;	 Catch:{ all -> 0x003a }
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
        r0 = m27168b(r0);	 Catch:{ all -> 0x0035 }
        f25229d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f25229d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchStatusComponent.a(com.facebook.inject.InjectorLike):com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchStatusComponent");
    }

    private static GametimeMatchStatusComponent m27168b(InjectorLike injectorLike) {
        return new GametimeMatchStatusComponent(GametimeMatchStatusComponentSpec.m27172a(injectorLike));
    }

    @Inject
    public GametimeMatchStatusComponent(GametimeMatchStatusComponentSpec gametimeMatchStatusComponentSpec) {
        this.f25230c = gametimeMatchStatusComponentSpec;
    }

    protected final InternalNode m27170b(ComponentContext componentContext, Component component) {
        ImmutableList immutableList = ((State) component).f25226a;
        ContainerBuilder E = Container.a(componentContext).C(0).D(1).E(3);
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            E.a(Text.a(componentContext).a((String) immutableList.get(i)).a(Alignment.ALIGN_OPPOSITE).o(2131427402));
        }
        return E.j();
    }

    public final void m27169a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ GametimeMatchStatusComponent f25221c;

                public void run() {
                    this.f25221c.a(eventHandler, obj);
                }
            }, 1174570889);
        }
    }
}
