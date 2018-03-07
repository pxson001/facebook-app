package com.facebook.reaction.feed.unitcomponents.spec.body;

import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import android.view.View;
import com.facebook.components.ClickEvent;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.Layout;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionStoryAttachmentActionFragment;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: a_place_for */
public class ReactionActionDelegateComponent<E extends CanLaunchReactionIntent & HasReactionAnalyticsParams & HasReactionSession> extends ComponentLifecycle {
    private static volatile ReactionActionDelegateComponent f20208d;
    private final ReactionActionDelegateComponentSpec f20209b;
    public final SynchronizedPool<Builder> f20210c = new SynchronizedPool(2);

    /* compiled from: a_place_for */
    public class Builder extends com.facebook.components.Component.Builder<ReactionActionDelegateComponent> {
        public State f20196a;
        final /* synthetic */ ReactionActionDelegateComponent f20197b;
        private String[] f20198c = new String[]{"delegate"};
        private int f20199d = 1;
        private BitSet f20200e = new BitSet(this.f20199d);

        public Builder(ReactionActionDelegateComponent reactionActionDelegateComponent) {
            this.f20197b = reactionActionDelegateComponent;
        }

        public static void m24054a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f20196a = state;
            builder.f20200e.clear();
        }

        public final Builder m24056a(Component<?> component) {
            this.f20196a.f20201a = component;
            this.f20200e.set(0);
            return this;
        }

        public final Builder m24055a(com.facebook.components.Component.Builder<?> builder) {
            return m24056a(builder.d());
        }

        public final Builder m24058a(ReactionStoryAttachmentActionFragment reactionStoryAttachmentActionFragment) {
            this.f20196a.f20202b = reactionStoryAttachmentActionFragment;
            return this;
        }

        public final Builder m24057a(E e) {
            this.f20196a.f20204d = e;
            return this;
        }

        public final Builder m24060b(String str) {
            this.f20196a.f20205e = str;
            return this;
        }

        public final Builder m24061c(String str) {
            this.f20196a.f20206f = str;
            return this;
        }

        public final Component<ReactionActionDelegateComponent> m24062d() {
            int i = 0;
            if (this.f20200e == null || this.f20200e.nextClearBit(0) >= this.f20199d) {
                State state = this.f20196a;
                m24059a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f20199d) {
                if (!this.f20200e.get(i)) {
                    arrayList.add(this.f20198c[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m24059a() {
            super.a();
            this.f20196a = null;
            this.f20197b.f20210c.a(this);
        }
    }

    /* compiled from: a_place_for */
    public class State extends Component<ReactionActionDelegateComponent> implements Cloneable {
        Component<?> f20201a;
        ReactionStoryAttachmentActionFragmentModel f20202b;
        public String f20203c;
        E f20204d;
        String f20205e;
        String f20206f;
        final /* synthetic */ ReactionActionDelegateComponent f20207g;

        public State(ReactionActionDelegateComponent reactionActionDelegateComponent) {
            this.f20207g = reactionActionDelegateComponent;
            super(reactionActionDelegateComponent);
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
            if (this.f20201a == null ? state.f20201a != null : !this.f20201a.equals(state.f20201a)) {
                return false;
            }
            if (this.f20202b == null ? state.f20202b != null : !this.f20202b.equals(state.f20202b)) {
                return false;
            }
            if (this.f20203c == null ? state.f20203c != null : !this.f20203c.equals(state.f20203c)) {
                return false;
            }
            if (this.f20204d == null ? state.f20204d != null : !this.f20204d.equals(state.f20204d)) {
                return false;
            }
            if (this.f20205e == null ? state.f20205e != null : !this.f20205e.equals(state.f20205e)) {
                return false;
            }
            if (this.f20206f != null) {
                if (this.f20206f.equals(state.f20206f)) {
                    return true;
                }
            } else if (state.f20206f == null) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.reaction.feed.unitcomponents.spec.body.ReactionActionDelegateComponent m24063a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20208d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.body.ReactionActionDelegateComponent.class;
        monitor-enter(r1);
        r0 = f20208d;	 Catch:{ all -> 0x003a }
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
        r0 = m24065b(r0);	 Catch:{ all -> 0x0035 }
        f20208d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20208d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.body.ReactionActionDelegateComponent.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.body.ReactionActionDelegateComponent");
    }

    private static ReactionActionDelegateComponent m24065b(InjectorLike injectorLike) {
        return new ReactionActionDelegateComponent(ReactionActionDelegateComponentSpec.m24069a(injectorLike));
    }

    @Inject
    public ReactionActionDelegateComponent(ReactionActionDelegateComponentSpec reactionActionDelegateComponentSpec) {
        this.f20209b = reactionActionDelegateComponentSpec;
    }

    public final Builder m24066a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) this.f20210c.a();
        if (builder == null) {
            builder = new Builder(this);
        }
        Builder.m24054a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode m24068b(ComponentContext componentContext, Component component) {
        return Layout.a(componentContext, ((State) component).f20201a).a(ComponentLifecycle.a(componentContext, 844392921, null)).j();
    }

    private void m24064a(View view, Component component) {
        State state = (State) component;
        this.f20209b.m24071a(view, state.f20202b, state.f20203c, state.f20204d, state.f20205e, state.f20206f);
    }

    public final void m24067a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ReactionActionDelegateComponent f20195c;

                public void run() {
                    this.f20195c.a(eventHandler, obj);
                }
            }, 1111610557);
            return;
        }
        switch (eventHandler.b) {
            case 844392921:
                m24064a(((ClickEvent) obj).a, eventHandler.a);
                return;
            default:
                return;
        }
    }
}
