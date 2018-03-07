package com.facebook.feedplugins.pyma.rows.objectives;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.BasicGroupPartDefinition;
import com.facebook.feedplugins.pyma.PYMADataModelHelper;
import com.facebook.graphql.model.GraphQLPagesYouMayAdvertiseFeedUnit;
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
/* compiled from: collection_title */
public class PYMAGraphQLObjectivesPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLPagesYouMayAdvertiseFeedUnit>, Void, FeedEnvironment> {
    private static PYMAGraphQLObjectivesPartDefinition f8645c;
    private static final Object f8646d = new Object();
    private final BasicGroupPartDefinition f8647a;
    private final PYMADataModelHelper f8648b;

    private static PYMAGraphQLObjectivesPartDefinition m9484b(InjectorLike injectorLike) {
        return new PYMAGraphQLObjectivesPartDefinition(BasicGroupPartDefinition.a(injectorLike), PYMADataModelHelper.m9459a(injectorLike));
    }

    public final Object m9485a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        baseMultiRowSubParts.a(this.f8647a, this.f8648b.m9463b((FeedProps) obj));
        return null;
    }

    public final boolean m9486a(Object obj) {
        return this.f8648b.m9463b((FeedProps) obj) != null;
    }

    @Inject
    public PYMAGraphQLObjectivesPartDefinition(BasicGroupPartDefinition basicGroupPartDefinition, PYMADataModelHelper pYMADataModelHelper) {
        this.f8647a = basicGroupPartDefinition;
        this.f8648b = pYMADataModelHelper;
    }

    public static PYMAGraphQLObjectivesPartDefinition m9483a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PYMAGraphQLObjectivesPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8646d) {
                PYMAGraphQLObjectivesPartDefinition pYMAGraphQLObjectivesPartDefinition;
                if (a2 != null) {
                    pYMAGraphQLObjectivesPartDefinition = (PYMAGraphQLObjectivesPartDefinition) a2.a(f8646d);
                } else {
                    pYMAGraphQLObjectivesPartDefinition = f8645c;
                }
                if (pYMAGraphQLObjectivesPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9484b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8646d, b3);
                        } else {
                            f8645c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pYMAGraphQLObjectivesPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
