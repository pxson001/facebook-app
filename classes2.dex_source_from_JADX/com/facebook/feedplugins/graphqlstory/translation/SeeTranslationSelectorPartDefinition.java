package com.facebook.feedplugins.graphqlstory.translation;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLTranslatabilityType;
import com.facebook.graphql.model.GraphQLStory;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: holder */
public class SeeTranslationSelectorPartDefinition<E extends HasContext & HasInvalidate & HasIsAsync & HasPersistentState & HasPositionInformation> extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, E> {
    private static SeeTranslationSelectorPartDefinition f20984c;
    private static final Object f20985d = new Object();
    private final Lazy<SeeTranslationComponentPartDefinition<E>> f20986a;
    private final Lazy<SeeTranslationPartDefinition<E>> f20987b;

    private static SeeTranslationSelectorPartDefinition m28708b(InjectorLike injectorLike) {
        return new SeeTranslationSelectorPartDefinition(IdBasedLazy.m1808a(injectorLike, 1898), IdBasedLazy.m1808a(injectorLike, 1900));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (FeedProps) obj;
        SubPartsSelector.m19115a(baseMultiRowSubParts, this.f20986a, obj).m19119a(this.f20987b, obj);
        return null;
    }

    public final boolean mo2536a(Object obj) {
        return m28707a((FeedProps) obj);
    }

    @Inject
    public SeeTranslationSelectorPartDefinition(Lazy<SeeTranslationComponentPartDefinition> lazy, Lazy<SeeTranslationPartDefinition> lazy2) {
        this.f20986a = lazy;
        this.f20987b = lazy2;
    }

    public static boolean m28707a(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        if (graphQLStory.aL() == null) {
            return false;
        }
        GraphQLTranslatabilityType a = m28706a(graphQLStory);
        return a == GraphQLTranslatabilityType.SEE_TRANSLATION || a == GraphQLTranslatabilityType.SEE_CONVERSION;
    }

    public static SeeTranslationSelectorPartDefinition m28705a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SeeTranslationSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20985d) {
                SeeTranslationSelectorPartDefinition seeTranslationSelectorPartDefinition;
                if (a2 != null) {
                    seeTranslationSelectorPartDefinition = (SeeTranslationSelectorPartDefinition) a2.mo818a(f20985d);
                } else {
                    seeTranslationSelectorPartDefinition = f20984c;
                }
                if (seeTranslationSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28708b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20985d, b3);
                        } else {
                            f20984c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = seeTranslationSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public static GraphQLTranslatabilityType m28706a(GraphQLStory graphQLStory) {
        if (graphQLStory.aL() == null) {
            return GraphQLTranslatabilityType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        return graphQLStory.aL().m24912o();
    }
}
