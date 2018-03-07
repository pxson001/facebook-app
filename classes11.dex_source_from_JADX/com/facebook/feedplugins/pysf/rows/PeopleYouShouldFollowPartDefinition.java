package com.facebook.feedplugins.pysf.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLPeopleYouShouldFollowFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: checkup_cancel */
public class PeopleYouShouldFollowPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLPeopleYouShouldFollowFeedUnit>, Void, FeedEnvironment> {
    private static PeopleYouShouldFollowPartDefinition f8820d;
    private static final Object f8821e = new Object();
    private final GatekeeperStoreImpl f8822a;
    private final PeopleYouShouldFollowHeaderPartDefinition f8823b;
    private final PeopleYouShouldFollowRecyclerViewPartDefinition f8824c;

    private static PeopleYouShouldFollowPartDefinition m9582b(InjectorLike injectorLike) {
        return new PeopleYouShouldFollowPartDefinition(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), PeopleYouShouldFollowHeaderPartDefinition.m9576a(injectorLike), PeopleYouShouldFollowRecyclerViewPartDefinition.m9587a(injectorLike));
    }

    public final Object m9583a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f8823b, feedProps);
        baseMultiRowSubParts.a(this.f8824c, feedProps);
        return null;
    }

    @Inject
    public PeopleYouShouldFollowPartDefinition(GatekeeperStoreImpl gatekeeperStoreImpl, PeopleYouShouldFollowHeaderPartDefinition peopleYouShouldFollowHeaderPartDefinition, PeopleYouShouldFollowRecyclerViewPartDefinition peopleYouShouldFollowRecyclerViewPartDefinition) {
        this.f8822a = gatekeeperStoreImpl;
        this.f8823b = peopleYouShouldFollowHeaderPartDefinition;
        this.f8824c = peopleYouShouldFollowRecyclerViewPartDefinition;
    }

    public final boolean m9584a(Object obj) {
        return this.f8822a.a(661, false);
    }

    public static PeopleYouShouldFollowPartDefinition m9581a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouShouldFollowPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8821e) {
                PeopleYouShouldFollowPartDefinition peopleYouShouldFollowPartDefinition;
                if (a2 != null) {
                    peopleYouShouldFollowPartDefinition = (PeopleYouShouldFollowPartDefinition) a2.a(f8821e);
                } else {
                    peopleYouShouldFollowPartDefinition = f8820d;
                }
                if (peopleYouShouldFollowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9582b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8821e, b3);
                        } else {
                            f8820d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouShouldFollowPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
