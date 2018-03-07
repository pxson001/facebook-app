package com.facebook.gametime.ui.components.partdefinition.match;

import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import android.view.View;
import com.facebook.components.ClickEvent;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout.ContainerBuilder;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.Container;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.gametime.constants.GametimeRef;
import com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchUnitComponentPartDefinition.TeamInfo;
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
/* compiled from: SystemProperties.get failed  */
public class GametimeMatchComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f25212b = new SynchronizedPool(2);
    private static volatile GametimeMatchComponent f25213d;
    private final GametimeMatchComponentSpec f25214c;

    /* compiled from: SystemProperties.get failed  */
    public class Builder extends com.facebook.components.Component.Builder<GametimeMatchComponent> {
        public State f25203a;
        private String[] f25204b = new String[]{"awayTeamInfo", "homeTeamInfo", "statuses", "pageId"};
        private int f25205c = 4;
        public BitSet f25206d = new BitSet(this.f25205c);

        public static void m27154a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f25203a = state;
            builder.f25206d.clear();
        }

        public final Component<GametimeMatchComponent> m27156d() {
            int i = 0;
            if (this.f25206d == null || this.f25206d.nextClearBit(0) >= this.f25205c) {
                State state = this.f25203a;
                m27155a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f25205c) {
                if (!this.f25206d.get(i)) {
                    arrayList.add(this.f25204b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m27155a() {
            super.a();
            this.f25203a = null;
            GametimeMatchComponent.f25212b.a(this);
        }
    }

    /* compiled from: SystemProperties.get failed  */
    public class State extends Component<GametimeMatchComponent> implements Cloneable {
        public TeamInfo f25207a;
        public TeamInfo f25208b;
        public ImmutableList<String> f25209c;
        public String f25210d;
        final /* synthetic */ GametimeMatchComponent f25211e;

        public State(GametimeMatchComponent gametimeMatchComponent) {
            this.f25211e = gametimeMatchComponent;
            super(gametimeMatchComponent);
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
            if (this.f25207a == null ? state.f25207a != null : !this.f25207a.equals(state.f25207a)) {
                return false;
            }
            if (this.f25208b == null ? state.f25208b != null : !this.f25208b.equals(state.f25208b)) {
                return false;
            }
            if (this.f25209c == null ? state.f25209c != null : !this.f25209c.equals(state.f25209c)) {
                return false;
            }
            if (this.f25210d != null) {
                if (this.f25210d.equals(state.f25210d)) {
                    return true;
                }
            } else if (state.f25210d == null) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchComponent m27157a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f25213d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchComponent.class;
        monitor-enter(r1);
        r0 = f25213d;	 Catch:{ all -> 0x003a }
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
        r0 = m27159b(r0);	 Catch:{ all -> 0x0035 }
        f25213d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f25213d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchComponent.a(com.facebook.inject.InjectorLike):com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchComponent");
    }

    private static GametimeMatchComponent m27159b(InjectorLike injectorLike) {
        return new GametimeMatchComponent(GametimeMatchComponentSpec.m27162a(injectorLike));
    }

    @Inject
    public GametimeMatchComponent(GametimeMatchComponentSpec gametimeMatchComponentSpec) {
        this.f25214c = gametimeMatchComponentSpec;
    }

    protected final InternalNode m27161b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        GametimeMatchComponentSpec gametimeMatchComponentSpec = this.f25214c;
        TeamInfo teamInfo = state.f25207a;
        TeamInfo teamInfo2 = state.f25208b;
        ImmutableList immutableList = state.f25209c;
        ContainerBuilder a = Container.a(componentContext).C(2).G(2130840536).n(8, 2131427416).b(ComponentLifecycle.a(componentContext, 2011689971, null)).a(Container.a(componentContext).C(0).a(gametimeMatchComponentSpec.f25216a.m27179a(componentContext).m27174a(teamInfo).c().g(3, 2131427418)).a(gametimeMatchComponentSpec.f25216a.m27179a(componentContext).m27174a(teamInfo2)).n(2, 2131427418).b(0.6f));
        com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchStatusComponent.State state2 = new com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchStatusComponent.State(gametimeMatchComponentSpec.f25217b);
        com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchStatusComponent.Builder builder = (com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchStatusComponent.Builder) GametimeMatchStatusComponent.f25228b.a();
        if (builder == null) {
            builder = new com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchStatusComponent.Builder();
        }
        com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchStatusComponent.Builder.m27164a(builder, componentContext, 0, state2);
        com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchStatusComponent.Builder builder2 = builder;
        builder2.f25222a.f25226a = immutableList;
        builder2.f25225d.set(0);
        return a.a(builder2.c().a(0.4f)).j();
    }

    private void m27158a(View view, Component component) {
        State state = (State) component;
        GametimeMatchComponentSpec gametimeMatchComponentSpec = this.f25214c;
        gametimeMatchComponentSpec.f25218c.a(state.f25210d, GametimeRef.DASHBOARD, view.getContext());
    }

    public final void m27160a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ GametimeMatchComponent f25202c;

                public void run() {
                    this.f25202c.a(eventHandler, obj);
                }
            }, 1327923300);
            return;
        }
        switch (eventHandler.b) {
            case 2011689971:
                m27158a(((ClickEvent) obj).a, eventHandler.a);
                return;
            default:
                return;
        }
    }
}
