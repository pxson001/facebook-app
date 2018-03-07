package com.facebook.feedplugins.graphqlstory.translation;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLTranslatabilityType;
import com.facebook.graphql.model.GraphQLPostTranslatability;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: hprof_id */
public class AutoTranslateSelectorPartDefinition<E extends HasContext & HasIsAsync & HasPersistentState & HasPositionInformation> extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, E> {
    private static AutoTranslateSelectorPartDefinition f20828d;
    private static final Object f20829e = new Object();
    private final Lazy<AutoTranslateComponentPartDefinition<E>> f20830a;
    private final Lazy<AutoTranslatePartDefinition> f20831b;
    private final boolean f20832c;

    private static AutoTranslateSelectorPartDefinition m28556b(InjectorLike injectorLike) {
        return new AutoTranslateSelectorPartDefinition(IdBasedLazy.m1808a(injectorLike, 6312), IdBasedLazy.m1808a(injectorLike, 6313), IdBasedProvider.m1811a(injectorLike, 3977));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (FeedProps) obj;
        SubPartsSelector.m19115a(baseMultiRowSubParts, this.f20830a, obj).m19119a(this.f20831b, obj);
        return null;
    }

    public final boolean mo2536a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        if (!this.f20832c) {
            return false;
        }
        GraphQLPostTranslatability aL = ((GraphQLStory) feedProps.f13444a).aL();
        if (aL == null) {
            return false;
        }
        return aL.m24912o() == GraphQLTranslatabilityType.AUTO_TRANSLATION && aL.m24905a() != null;
    }

    @Inject
    public AutoTranslateSelectorPartDefinition(Lazy<AutoTranslateComponentPartDefinition> lazy, Lazy<AutoTranslatePartDefinition> lazy2, Provider<Boolean> provider) {
        this.f20830a = lazy;
        this.f20831b = lazy2;
        this.f20832c = ((Boolean) provider.get()).booleanValue();
    }

    public static AutoTranslateSelectorPartDefinition m28555a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AutoTranslateSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20829e) {
                AutoTranslateSelectorPartDefinition autoTranslateSelectorPartDefinition;
                if (a2 != null) {
                    autoTranslateSelectorPartDefinition = (AutoTranslateSelectorPartDefinition) a2.mo818a(f20829e);
                } else {
                    autoTranslateSelectorPartDefinition = f20828d;
                }
                if (autoTranslateSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28556b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20829e, b3);
                        } else {
                            f20828d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = autoTranslateSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
