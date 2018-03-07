package com.facebook.feedplugins.pyma.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.pyma.PYMAAnalyticsHelper;
import com.facebook.feedplugins.pyma.PYMADataModelHelper;
import com.facebook.feedplugins.pyma.rows.objectives.PYMAGraphQLObjectivesPartDefinition;
import com.facebook.feedplugins.pyma.rows.objectives.PYMAPageLikeObjectiveBodyComponentPartDefinition;
import com.facebook.feedplugins.pyma.rows.objectives.PYMAPageLikeObjectiveBodyPartDefinition;
import com.facebook.graphql.enums.GraphQLPYMACategory;
import com.facebook.graphql.model.GraphQLPagesYouMayAdvertiseFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: collections_after */
public class PagesYouMayAdvertiseBodyPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLPagesYouMayAdvertiseFeedUnit>, Void, FeedEnvironment> {
    private static PagesYouMayAdvertiseBodyPartDefinition f8628f;
    private static final Object f8629g = new Object();
    private final Provider<PYMAPageLikeObjectiveBodyPartDefinition> f8630a;
    private final Provider<PYMAPageLikeObjectiveBodyComponentPartDefinition> f8631b;
    private final Provider<PYMAGraphQLObjectivesPartDefinition> f8632c;
    private final PYMAAnalyticsHelper f8633d;
    private final PYMADataModelHelper f8634e;

    /* compiled from: collections_after */
    /* synthetic */ class C10601 {
        static final /* synthetic */ int[] f8627a = new int[GraphQLPYMACategory.values().length];

        static {
            try {
                f8627a[GraphQLPYMACategory.PROMOTE_PAGE_LIKE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8627a[GraphQLPYMACategory.PROMOTE_WEBSITE_CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8627a[GraphQLPYMACategory.PROMOTE_LOCAL_AWARENESS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f8627a[GraphQLPYMACategory.BOOSTED_EVENT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f8627a[GraphQLPYMACategory.BOOSTED_POST.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f8627a[GraphQLPYMACategory.PROMOTE_PAGE_CTA.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    private static PagesYouMayAdvertiseBodyPartDefinition m9470b(InjectorLike injectorLike) {
        return new PagesYouMayAdvertiseBodyPartDefinition(IdBasedProvider.a(injectorLike, 6445), IdBasedProvider.a(injectorLike, 6444), IdBasedProvider.a(injectorLike, 6443), PYMAAnalyticsHelper.m9456a(injectorLike), PYMADataModelHelper.m9459a(injectorLike));
    }

    public final Object m9472a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(m9471b(feedProps), feedProps);
        return null;
    }

    @Inject
    public PagesYouMayAdvertiseBodyPartDefinition(Provider<PYMAPageLikeObjectiveBodyPartDefinition> provider, Provider<PYMAPageLikeObjectiveBodyComponentPartDefinition> provider2, Provider<PYMAGraphQLObjectivesPartDefinition> provider3, PYMAAnalyticsHelper pYMAAnalyticsHelper, PYMADataModelHelper pYMADataModelHelper) {
        this.f8630a = provider;
        this.f8631b = provider2;
        this.f8632c = provider3;
        this.f8633d = pYMAAnalyticsHelper;
        this.f8634e = pYMADataModelHelper;
    }

    public final boolean m9473a(FeedProps<GraphQLPagesYouMayAdvertiseFeedUnit> feedProps) {
        MultiRowPartWithIsNeeded b = m9471b((FeedProps) feedProps);
        if (b != null) {
            return b.a(feedProps);
        }
        GraphQLPagesYouMayAdvertiseFeedUnit graphQLPagesYouMayAdvertiseFeedUnit = (GraphQLPagesYouMayAdvertiseFeedUnit) feedProps.a;
        this.f8633d.m9458a(graphQLPagesYouMayAdvertiseFeedUnit, "Unsupported PYMA objective: " + graphQLPagesYouMayAdvertiseFeedUnit.r());
        return false;
    }

    public static PagesYouMayAdvertiseBodyPartDefinition m9469a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesYouMayAdvertiseBodyPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8629g) {
                PagesYouMayAdvertiseBodyPartDefinition pagesYouMayAdvertiseBodyPartDefinition;
                if (a2 != null) {
                    pagesYouMayAdvertiseBodyPartDefinition = (PagesYouMayAdvertiseBodyPartDefinition) a2.a(f8629g);
                } else {
                    pagesYouMayAdvertiseBodyPartDefinition = f8628f;
                }
                if (pagesYouMayAdvertiseBodyPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9470b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8629g, b3);
                        } else {
                            f8628f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagesYouMayAdvertiseBodyPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Nullable
    private MultiRowPartWithIsNeeded<FeedProps<GraphQLPagesYouMayAdvertiseFeedUnit>, ? super FeedEnvironment> m9471b(FeedProps<GraphQLPagesYouMayAdvertiseFeedUnit> feedProps) {
        GraphQLPYMACategory r = ((GraphQLPagesYouMayAdvertiseFeedUnit) feedProps.a).r();
        if (r == null) {
            return null;
        }
        switch (C10601.f8627a[r.ordinal()]) {
            case 1:
                PYMAPageLikeObjectiveBodyComponentPartDefinition pYMAPageLikeObjectiveBodyComponentPartDefinition = (PYMAPageLikeObjectiveBodyComponentPartDefinition) this.f8631b.get();
                if (pYMAPageLikeObjectiveBodyComponentPartDefinition.m9496b()) {
                    return pYMAPageLikeObjectiveBodyComponentPartDefinition;
                }
                return (MultiRowPartWithIsNeeded) this.f8630a.get();
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return (MultiRowPartWithIsNeeded) this.f8632c.get();
            default:
                if (this.f8634e.m9464b(feedProps, false) != null) {
                    return (MultiRowPartWithIsNeeded) this.f8632c.get();
                }
                return null;
        }
    }
}
