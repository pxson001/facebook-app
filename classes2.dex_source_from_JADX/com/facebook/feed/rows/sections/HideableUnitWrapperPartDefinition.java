package com.facebook.feed.rows.sections;

import android.content.Context;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.traversal.GroupPartHolder;
import com.facebook.feed.rows.sections.hidden.FeedUnitVisibilityKey;
import com.facebook.feed.rows.sections.hidden.FeedUnitVisibilityState;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.HideableUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;

@ContextScoped
/* compiled from: last_notif_time */
public class HideableUnitWrapperPartDefinition<E extends HasPersistentState, P extends HideableUnit> extends BaseMultiRowGroupPartDefinition<Props<E, P>, State, E> {
    private static HideableUnitWrapperPartDefinition f17940a;
    private static final Object f17941b = new Object();

    /* compiled from: last_notif_time */
    public class Props<E extends HasPersistentState, P extends HideableUnit> {
        public final Callbacks<E, P> f18979a;
        public final P f18980b;

        public Props(Callbacks<E, P> callbacks, P p) {
            this.f18979a = callbacks;
            this.f18980b = p;
        }
    }

    @VisibleForTesting
    /* compiled from: last_notif_time */
    public class State {
        public final FeedUnitVisibilityState f18984a;

        public State(FeedUnitVisibilityState feedUnitVisibilityState) {
            this.f18984a = feedUnitVisibilityState;
        }
    }

    private static HideableUnitWrapperPartDefinition m25164b() {
        return new HideableUnitWrapperPartDefinition();
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasPersistentState hasPersistentState = (HasPersistentState) anyEnvironment;
        baseMultiRowSubParts.m19112a(props.f18979a.f18977a, FeedProps.m19802c(props.f18980b));
        return new State((FeedUnitVisibilityState) hasPersistentState.mo2425a(new FeedUnitVisibilityKey(props.f18980b), props.f18980b));
    }

    public final void mo2537a(Object obj, Object obj2, AnyEnvironment anyEnvironment, GroupPartHolder groupPartHolder) {
        ((State) obj2).f18984a.m26683b();
    }

    public final void mo2538b(Object obj, Object obj2, AnyEnvironment anyEnvironment, GroupPartHolder groupPartHolder) {
        State state = (State) obj2;
        if (((Props) obj).f18980b.mo2879o() == StoryVisibility.CONTRACTING) {
            FeedUnitVisibilityState feedUnitVisibilityState = state.f18984a;
            feedUnitVisibilityState.f18983a += groupPartHolder.m19104a().getHeight();
        }
    }

    public static HideableUnitWrapperPartDefinition m25163a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HideableUnitWrapperPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f17941b) {
                HideableUnitWrapperPartDefinition hideableUnitWrapperPartDefinition;
                if (a2 != null) {
                    hideableUnitWrapperPartDefinition = (HideableUnitWrapperPartDefinition) a2.mo818a(f17941b);
                } else {
                    hideableUnitWrapperPartDefinition = f17940a;
                }
                if (hideableUnitWrapperPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        b3 = m25164b();
                        if (a2 != null) {
                            a2.mo822a(f17941b, b3);
                        } else {
                            f17940a = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = hideableUnitWrapperPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final boolean mo2536a(Object obj) {
        return true;
    }
}
