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
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.feed.persistentstate.ReactionExpandableComponentPersistentState;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: a1df980b3964fc0cbfca400fbb91ca76 */
public class ReactionExpandableActionDelegateComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f20259b = new SynchronizedPool(2);
    private static volatile ReactionExpandableActionDelegateComponent f20260d;
    private final ReactionExpandableActionDelegateComponentSpec f20261c;

    /* compiled from: a1df980b3964fc0cbfca400fbb91ca76 */
    public class Builder extends com.facebook.components.Component.Builder<ReactionExpandableActionDelegateComponent> {
        State f20248a;
        private String[] f20249b = new String[]{"delegate", "unitId", "unitTypeToken", "interactionTracker", "hasInvalidate", "expandableComponentPersistentState"};
        private int f20250c = 6;
        private BitSet f20251d = new BitSet(this.f20250c);

        public static void m24098a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f20248a = state;
            builder.f20251d.clear();
        }

        public final Builder m24099a(Component<?> component) {
            this.f20248a.f20252a = component;
            this.f20251d.set(0);
            return this;
        }

        public final Builder m24103a(String str) {
            this.f20248a.f20253b = str;
            this.f20251d.set(1);
            return this;
        }

        public final Builder m24105b(String str) {
            this.f20248a.f20254c = str;
            this.f20251d.set(2);
            return this;
        }

        public final Builder m24101a(ReactionInteractionTracker reactionInteractionTracker) {
            this.f20248a.f20255d = reactionInteractionTracker;
            this.f20251d.set(3);
            return this;
        }

        public final Builder m24100a(HasInvalidate hasInvalidate) {
            this.f20248a.f20256e = hasInvalidate;
            this.f20251d.set(4);
            return this;
        }

        public final Builder m24102a(ReactionExpandableComponentPersistentState reactionExpandableComponentPersistentState) {
            this.f20248a.f20257f = reactionExpandableComponentPersistentState;
            this.f20251d.set(5);
            return this;
        }

        public final Component<ReactionExpandableActionDelegateComponent> m24106d() {
            int i = 0;
            if (this.f20251d == null || this.f20251d.nextClearBit(0) >= this.f20250c) {
                State state = this.f20248a;
                m24104a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f20250c) {
                if (!this.f20251d.get(i)) {
                    arrayList.add(this.f20249b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m24104a() {
            super.a();
            this.f20248a = null;
            ReactionExpandableActionDelegateComponent.f20259b.a(this);
        }
    }

    /* compiled from: a1df980b3964fc0cbfca400fbb91ca76 */
    public class State extends Component<ReactionExpandableActionDelegateComponent> implements Cloneable {
        Component<?> f20252a;
        String f20253b;
        String f20254c;
        ReactionInteractionTracker f20255d;
        HasInvalidate f20256e;
        ReactionExpandableComponentPersistentState f20257f;
        final /* synthetic */ ReactionExpandableActionDelegateComponent f20258g;

        public State(ReactionExpandableActionDelegateComponent reactionExpandableActionDelegateComponent) {
            this.f20258g = reactionExpandableActionDelegateComponent;
            super(reactionExpandableActionDelegateComponent);
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
            if (this.f20252a == null ? state.f20252a != null : !this.f20252a.equals(state.f20252a)) {
                return false;
            }
            if (this.f20253b == null ? state.f20253b != null : !this.f20253b.equals(state.f20253b)) {
                return false;
            }
            if (this.f20254c == null ? state.f20254c != null : !this.f20254c.equals(state.f20254c)) {
                return false;
            }
            if (this.f20255d == null ? state.f20255d != null : !this.f20255d.equals(state.f20255d)) {
                return false;
            }
            if (this.f20256e == null ? state.f20256e != null : !this.f20256e.equals(state.f20256e)) {
                return false;
            }
            if (this.f20257f != null) {
                if (this.f20257f.equals(state.f20257f)) {
                    return true;
                }
            } else if (state.f20257f == null) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.reaction.feed.unitcomponents.spec.body.ReactionExpandableActionDelegateComponent m24107a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20260d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.body.ReactionExpandableActionDelegateComponent.class;
        monitor-enter(r1);
        r0 = f20260d;	 Catch:{ all -> 0x003a }
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
        r0 = m24109b(r0);	 Catch:{ all -> 0x0035 }
        f20260d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20260d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.body.ReactionExpandableActionDelegateComponent.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.body.ReactionExpandableActionDelegateComponent");
    }

    private static ReactionExpandableActionDelegateComponent m24109b(InjectorLike injectorLike) {
        return new ReactionExpandableActionDelegateComponent(ReactionExpandableActionDelegateComponentSpec.m24114a(injectorLike));
    }

    @Inject
    public ReactionExpandableActionDelegateComponent(ReactionExpandableActionDelegateComponentSpec reactionExpandableActionDelegateComponentSpec) {
        this.f20261c = reactionExpandableActionDelegateComponentSpec;
    }

    public final Builder m24110a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) f20259b.a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m24098a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode m24112b(ComponentContext componentContext, Component component) {
        return Layout.a(componentContext, ((State) component).f20252a).a(ComponentLifecycle.a(componentContext, 2080806192, null)).j();
    }

    private void m24108a(View view, Component component) {
        State state = (State) component;
        String str = state.f20253b;
        String str2 = state.f20254c;
        ReactionInteractionTracker reactionInteractionTracker = state.f20255d;
        HasInvalidate hasInvalidate = state.f20256e;
        state.f20257f.f19167a = true;
        reactionInteractionTracker.mo984a(str, str2, null, UnitInteractionType.INLINE_EXPANSION_TAP);
        hasInvalidate.hL_();
    }

    public final void m24111a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ReactionExpandableActionDelegateComponent f20247c;

                public void run() {
                    this.f20247c.a(eventHandler, obj);
                }
            }, -356082080);
            return;
        }
        switch (eventHandler.b) {
            case 2080806192:
                m24108a(((ClickEvent) obj).a, eventHandler.a);
                return;
            default:
                return;
        }
    }
}
