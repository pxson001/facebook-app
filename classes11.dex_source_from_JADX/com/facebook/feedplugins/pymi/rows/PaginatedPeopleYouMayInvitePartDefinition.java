package com.facebook.feedplugins.pymi.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.pymi.abtest.ExperimentsForPymiModule;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: clientOpen */
public class PaginatedPeopleYouMayInvitePartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLPeopleYouMayInviteFeedUnit>, Void, FeedEnvironment> {
    private static PaginatedPeopleYouMayInvitePartDefinition f8764f;
    private static final Object f8765g = new Object();
    private final Lazy<FutureFriendingHeaderPartDefinition> f8766a;
    private final Lazy<FutureFriendingHScrollPartDefinition> f8767b;
    private final Lazy<PeopleYouMayInviteHeaderPartDefinition> f8768c;
    private final Lazy<PeopleYouMayInvitePagerPartDefinition> f8769d;
    private final QeAccessor f8770e;

    private static PaginatedPeopleYouMayInvitePartDefinition m9547b(InjectorLike injectorLike) {
        return new PaginatedPeopleYouMayInvitePartDefinition(IdBasedLazy.a(injectorLike, 6452), IdBasedLazy.a(injectorLike, 6451), IdBasedLazy.a(injectorLike, 6454), IdBasedLazy.a(injectorLike, 6455), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m9548a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        if (this.f8770e.a(ExperimentsForPymiModule.f8671a, false)) {
            baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f8766a.get(), feedProps);
            baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f8767b.get(), feedProps);
        } else {
            baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f8768c.get(), feedProps);
            baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f8769d.get(), feedProps);
        }
        return null;
    }

    public final boolean m9549a(Object obj) {
        return !((GraphQLPeopleYouMayInviteFeedUnit) ((FeedProps) obj).a).r().isEmpty();
    }

    @Inject
    public PaginatedPeopleYouMayInvitePartDefinition(Lazy<FutureFriendingHeaderPartDefinition> lazy, Lazy<FutureFriendingHScrollPartDefinition> lazy2, Lazy<PeopleYouMayInviteHeaderPartDefinition> lazy3, Lazy<PeopleYouMayInvitePagerPartDefinition> lazy4, QeAccessor qeAccessor) {
        this.f8766a = lazy;
        this.f8767b = lazy2;
        this.f8768c = lazy3;
        this.f8769d = lazy4;
        this.f8770e = qeAccessor;
    }

    public static PaginatedPeopleYouMayInvitePartDefinition m9546a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PaginatedPeopleYouMayInvitePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8765g) {
                PaginatedPeopleYouMayInvitePartDefinition paginatedPeopleYouMayInvitePartDefinition;
                if (a2 != null) {
                    paginatedPeopleYouMayInvitePartDefinition = (PaginatedPeopleYouMayInvitePartDefinition) a2.a(f8765g);
                } else {
                    paginatedPeopleYouMayInvitePartDefinition = f8764f;
                }
                if (paginatedPeopleYouMayInvitePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9547b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8765g, b3);
                        } else {
                            f8764f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = paginatedPeopleYouMayInvitePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
