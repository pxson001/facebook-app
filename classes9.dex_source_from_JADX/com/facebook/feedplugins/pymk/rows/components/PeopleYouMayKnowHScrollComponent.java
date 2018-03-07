package com.facebook.feedplugins.pymk.rows.components;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.feed.FeedPager;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feedplugins.pymk.rows.PeopleYouMayKnowHScrollPartDefinition.HScrollProps;
import com.facebook.graphql.model.GraphQLPaginatedPeopleYouMayKnowFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: THREAD_KEY */
public class PeopleYouMayKnowHScrollComponent<E extends HasContext & HasFeedListType & HasIsAsync & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> extends ComponentLifecycle {
    private static PeopleYouMayKnowHScrollComponent f24902d;
    private static final Object f24903e = new Object();
    private final PeopleYouMayKnowHScrollComponentSpec f24904b;
    public final SynchronizedPool<Builder> f24905c = new SynchronizedPool(2);

    /* compiled from: THREAD_KEY */
    public class Builder extends com.facebook.components.Component.Builder<PeopleYouMayKnowHScrollComponent> {
        public State f24894a;
        final /* synthetic */ PeopleYouMayKnowHScrollComponent f24895b;
        private String[] f24896c = new String[]{"environment", "pages"};
        private int f24897d = 2;
        public BitSet f24898e = new BitSet(this.f24897d);

        public Builder(PeopleYouMayKnowHScrollComponent peopleYouMayKnowHScrollComponent) {
            this.f24895b = peopleYouMayKnowHScrollComponent;
        }

        public static void m26671a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f24894a = state;
            builder.f24898e.clear();
        }

        public final Component<PeopleYouMayKnowHScrollComponent> m26673d() {
            int i = 0;
            if (this.f24898e == null || this.f24898e.nextClearBit(0) >= this.f24897d) {
                State state = this.f24894a;
                m26672a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f24897d) {
                if (!this.f24898e.get(i)) {
                    arrayList.add(this.f24896c[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m26672a() {
            super.a();
            this.f24894a = null;
            this.f24895b.f24905c.a(this);
        }
    }

    /* compiled from: THREAD_KEY */
    public class State extends Component<PeopleYouMayKnowHScrollComponent> implements Cloneable {
        public E f24899a;
        public HScrollProps f24900b;
        final /* synthetic */ PeopleYouMayKnowHScrollComponent f24901c;

        public State(PeopleYouMayKnowHScrollComponent peopleYouMayKnowHScrollComponent) {
            this.f24901c = peopleYouMayKnowHScrollComponent;
            super(peopleYouMayKnowHScrollComponent);
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
            if (this.f24899a == null ? state.f24899a != null : !this.f24899a.equals(state.f24899a)) {
                return false;
            }
            if (this.f24900b != null) {
                if (this.f24900b.equals(state.f24900b)) {
                    return true;
                }
            } else if (state.f24900b == null) {
                return true;
            }
            return false;
        }
    }

    private static PeopleYouMayKnowHScrollComponent m26675b(InjectorLike injectorLike) {
        return new PeopleYouMayKnowHScrollComponent(PeopleYouMayKnowHScrollComponentSpec.m26686a(injectorLike));
    }

    @Inject
    public PeopleYouMayKnowHScrollComponent(PeopleYouMayKnowHScrollComponentSpec peopleYouMayKnowHScrollComponentSpec) {
        this.f24904b = peopleYouMayKnowHScrollComponentSpec;
    }

    public static PeopleYouMayKnowHScrollComponent m26674a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouMayKnowHScrollComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24903e) {
                PeopleYouMayKnowHScrollComponent peopleYouMayKnowHScrollComponent;
                if (a2 != null) {
                    peopleYouMayKnowHScrollComponent = (PeopleYouMayKnowHScrollComponent) a2.a(f24903e);
                } else {
                    peopleYouMayKnowHScrollComponent = f24902d;
                }
                if (peopleYouMayKnowHScrollComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26675b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24903e, b3);
                        } else {
                            f24902d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouMayKnowHScrollComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final InternalNode m26677b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        HasContext hasContext = state.f24899a;
        HScrollProps hScrollProps = state.f24900b;
        return FeedPager.a(componentContext).a(new PeopleYouMayKnowComponentPagerBinder(componentContext, ((GraphQLPaginatedPeopleYouMayKnowFeedUnit) hScrollProps.m26624f().a).ac_(), 1.0f, hScrollProps, hasContext)).c().h(4, 2).j();
    }

    public final void m26676a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ PeopleYouMayKnowHScrollComponent f24893c;

                public void run() {
                    this.f24893c.a(eventHandler, obj);
                }
            }, 203619667);
        }
    }
}
