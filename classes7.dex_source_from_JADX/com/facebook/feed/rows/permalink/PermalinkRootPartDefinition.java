package com.facebook.feed.rows.permalink;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.STATICDI_MULTIBIND_PROVIDER.RootPartsDeclaration;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.common.unknown.UnknownFeedUnitMultiRowGroupPartDefinition;
import com.facebook.graphql.model.FeedUnit;
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
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Inject;

@ContextScoped
/* compiled from: adaptive-playback */
public class PermalinkRootPartDefinition extends BaseMultiRowGroupPartDefinition<FeedUnit, Void, FeedEnvironment> {
    private static PermalinkRootPartDefinition f19929c;
    private static final Object f19930d = new Object();
    private final Map<Class<?>, Lazy<?>> f19931a;
    private final Lazy<UnknownFeedUnitMultiRowGroupPartDefinition> f19932b;

    private static PermalinkRootPartDefinition m23137b(InjectorLike injectorLike) {
        return new PermalinkRootPartDefinition(IdBasedLazy.a(injectorLike, 5911), RootPartsDeclaration.a(injectorLike), IdBasedLazy.a(injectorLike, 6023));
    }

    public final Object m23138a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedUnit feedUnit = (FeedUnit) obj;
        for (Entry entry : this.f19931a.entrySet()) {
            if (((Class) entry.getKey()).isInstance(feedUnit) && baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) ((Lazy) entry.getValue()).get(), FeedProps.c(feedUnit))) {
                break;
            }
        }
        baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f19932b.get(), feedUnit);
        return null;
    }

    @Inject
    public PermalinkRootPartDefinition(Lazy<PermalinkGraphQLStorySelectorPartDefinition> lazy, Set<com.facebook.feed.rows.core.RootPartsDeclaration> set, Lazy<UnknownFeedUnitMultiRowGroupPartDefinition> lazy2) {
        this.f19932b = lazy2;
        Builder builder = ImmutableMap.builder();
        builder.b(GraphQLStory.class, lazy);
        RootPartRegistrationController rootPartRegistrationController = new RootPartRegistrationController(builder);
        for (com.facebook.feed.rows.core.RootPartsDeclaration a : set) {
            a.a(rootPartRegistrationController);
        }
        this.f19931a = builder.b();
    }

    public final boolean m23139a(Object obj) {
        return true;
    }

    public static PermalinkRootPartDefinition m23136a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PermalinkRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19930d) {
                PermalinkRootPartDefinition permalinkRootPartDefinition;
                if (a2 != null) {
                    permalinkRootPartDefinition = (PermalinkRootPartDefinition) a2.a(f19930d);
                } else {
                    permalinkRootPartDefinition = f19929c;
                }
                if (permalinkRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23137b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19930d, b3);
                        } else {
                            f19929c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = permalinkRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
