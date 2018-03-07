package com.facebook.feedplugins.pymk.rows.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.components.feed.ComponentPartHelper;
import com.facebook.feed.environment.CanFriendPerson;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feed.rows.qe.ExperimentsForMultiRowQEModule;
import com.facebook.feedplugins.pymk.rows.PeopleYouMayKnowHScrollPartDefinition.HScrollProps;
import com.facebook.feedplugins.pymk.rows.components.PeopleYouMayKnowHScrollComponent.Builder;
import com.facebook.feedplugins.pymk.rows.components.PeopleYouMayKnowHScrollComponent.State;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: THREAD_ID */
public class PeopleYouMayKnowHScrollComponentPartDefinition<E extends CanFriendPerson & HasContext & HasFeedListType & HasInvalidate & HasIsAsync & HasPersistentState & HasPrefetcher & HasRowKey> extends ComponentPartDefinition<HScrollProps, E> {
    private static PeopleYouMayKnowHScrollComponentPartDefinition f24906e;
    private static final Object f24907f = new Object();
    private final AndroidComponentsExperimentHelper f24908c;
    private final PeopleYouMayKnowHScrollComponent f24909d;

    private static PeopleYouMayKnowHScrollComponentPartDefinition m26680b(InjectorLike injectorLike) {
        return new PeopleYouMayKnowHScrollComponentPartDefinition((Context) injectorLike.getInstance(Context.class), AndroidComponentsExperimentHelper.a(injectorLike), PeopleYouMayKnowHScrollComponent.m26674a(injectorLike));
    }

    public final CacheableEntity m26684b(Object obj) {
        return ComponentPartHelper.a(((HScrollProps) obj).m26624f());
    }

    @Inject
    public PeopleYouMayKnowHScrollComponentPartDefinition(Context context, AndroidComponentsExperimentHelper androidComponentsExperimentHelper, PeopleYouMayKnowHScrollComponent peopleYouMayKnowHScrollComponent) {
        super(context);
        this.f24908c = androidComponentsExperimentHelper;
        this.f24909d = peopleYouMayKnowHScrollComponent;
    }

    private Component<?> m26678a(ComponentContext componentContext, HScrollProps hScrollProps, E e) {
        PeopleYouMayKnowHScrollComponent peopleYouMayKnowHScrollComponent = this.f24909d;
        State state = new State(peopleYouMayKnowHScrollComponent);
        Builder builder = (Builder) peopleYouMayKnowHScrollComponent.f24905c.a();
        if (builder == null) {
            builder = new Builder(peopleYouMayKnowHScrollComponent);
        }
        Builder.m26671a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.f24894a.f24899a = (HasContext) e;
        builder2.f24898e.set(0);
        builder2 = builder2;
        builder2.f24894a.f24900b = hScrollProps;
        builder2.f24898e.set(1);
        return builder2.d();
    }

    public static PeopleYouMayKnowHScrollComponentPartDefinition m26679a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouMayKnowHScrollComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24907f) {
                PeopleYouMayKnowHScrollComponentPartDefinition peopleYouMayKnowHScrollComponentPartDefinition;
                if (a2 != null) {
                    peopleYouMayKnowHScrollComponentPartDefinition = (PeopleYouMayKnowHScrollComponentPartDefinition) a2.a(f24907f);
                } else {
                    peopleYouMayKnowHScrollComponentPartDefinition = f24906e;
                }
                if (peopleYouMayKnowHScrollComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26680b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24907f, b3);
                        } else {
                            f24906e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouMayKnowHScrollComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m26683a(Object obj) {
        AndroidComponentsExperimentHelper androidComponentsExperimentHelper = this.f24908c;
        boolean z = false;
        if (androidComponentsExperimentHelper.k == null) {
            androidComponentsExperimentHelper.k = Boolean.valueOf(AndroidComponentsExperimentHelper.a(androidComponentsExperimentHelper.a.a(ExperimentsForMultiRowQEModule.f, 0)));
        }
        if (androidComponentsExperimentHelper.k.booleanValue() || androidComponentsExperimentHelper.s()) {
            z = true;
        }
        return z;
    }
}
