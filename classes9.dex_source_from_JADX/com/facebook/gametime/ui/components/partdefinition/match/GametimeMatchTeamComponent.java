package com.facebook.gametime.ui.components.partdefinition.match;

import android.net.Uri;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.Container;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.fb.fresco.FbFrescoComponent;
import com.facebook.components.widget.Text;
import com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchUnitComponentPartDefinition.TeamInfo;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: SuggestedBotsQuery */
public class GametimeMatchTeamComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f25241b = new SynchronizedPool(2);
    private static volatile GametimeMatchTeamComponent f25242d;
    private final GametimeMatchTeamComponentSpec f25243c;

    /* compiled from: SuggestedBotsQuery */
    public class Builder extends com.facebook.components.Component.Builder<GametimeMatchTeamComponent> {
        State f25235a;
        private String[] f25236b = new String[]{"teamInfo"};
        private int f25237c = 1;
        private BitSet f25238d = new BitSet(this.f25237c);

        public static void m27173a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f25235a = state;
            builder.f25238d.clear();
        }

        public final Builder m27174a(TeamInfo teamInfo) {
            this.f25235a.f25239a = teamInfo;
            this.f25238d.set(0);
            return this;
        }

        public final Component<GametimeMatchTeamComponent> m27176d() {
            int i = 0;
            if (this.f25238d == null || this.f25238d.nextClearBit(0) >= this.f25237c) {
                State state = this.f25235a;
                m27175a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f25237c) {
                if (!this.f25238d.get(i)) {
                    arrayList.add(this.f25236b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m27175a() {
            super.a();
            this.f25235a = null;
            GametimeMatchTeamComponent.f25241b.a(this);
        }
    }

    /* compiled from: SuggestedBotsQuery */
    public class State extends Component<GametimeMatchTeamComponent> implements Cloneable {
        TeamInfo f25239a;
        final /* synthetic */ GametimeMatchTeamComponent f25240b;

        public State(GametimeMatchTeamComponent gametimeMatchTeamComponent) {
            this.f25240b = gametimeMatchTeamComponent;
            super(gametimeMatchTeamComponent);
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
            if (this.f25239a != null) {
                if (this.f25239a.equals(state.f25239a)) {
                    return true;
                }
            } else if (state.f25239a == null) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchTeamComponent m27177a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f25242d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchTeamComponent.class;
        monitor-enter(r1);
        r0 = f25242d;	 Catch:{ all -> 0x003a }
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
        r0 = m27178b(r0);	 Catch:{ all -> 0x0035 }
        f25242d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f25242d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchTeamComponent.a(com.facebook.inject.InjectorLike):com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchTeamComponent");
    }

    private static GametimeMatchTeamComponent m27178b(InjectorLike injectorLike) {
        return new GametimeMatchTeamComponent(GametimeMatchTeamComponentSpec.m27182a(injectorLike));
    }

    @Inject
    public GametimeMatchTeamComponent(GametimeMatchTeamComponentSpec gametimeMatchTeamComponentSpec) {
        this.f25243c = gametimeMatchTeamComponentSpec;
    }

    public final Builder m27179a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) f25241b.a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m27173a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode m27181b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        GametimeMatchTeamComponentSpec gametimeMatchTeamComponentSpec = this.f25243c;
        TeamInfo teamInfo = state.f25239a;
        return Container.a(componentContext).C(2).E(2).a(FbFrescoComponent.a(componentContext).a(gametimeMatchTeamComponentSpec.f25246b.b(Uri.parse(teamInfo.f25247a)).a(GametimeMatchTeamComponentSpec.f25244a).s()).c().l(2131434005).p(2131434005)).a(Text.a(componentContext).a(teamInfo.f25248b).o(2131427402).c().c(5, 2131427416).a(1.0f)).a(Text.a(componentContext).a(teamInfo.f25249c).o(2131427402)).j();
    }

    public final void m27180a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ GametimeMatchTeamComponent f25234c;

                public void run() {
                    this.f25234c.a(eventHandler, obj);
                }
            }, 341467170);
        }
    }
}
