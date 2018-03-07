package com.facebook.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.feed.rows.core.STATICDI_MULTIBIND_PROVIDER$RootPartsDeclaration;
import com.facebook.feed.rows.core.parts.RootPartSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.GraphQLStorySelectorPartDefinition;
import com.facebook.feed.rows.sections.HideableUnitWrapperPartDefinition;
import com.facebook.feed.rows.sections.HideableUnitWrapperPartDefinition.Props;
import com.facebook.feed.rows.sections.HoldoutUnitPartDefinition;
import com.facebook.feed.rows.sections.common.unknown.UnknownFeedUnitMultiRowGroupPartDefinition;
import com.facebook.feed.rows.sections.hidden.FeedHiddenUnitGroupPartDefinition;
import com.facebook.feed.rows.sections.hidden.HiddenUnitGroupPartDefinition;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLHoldoutAdFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.HideableUnit;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;
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
/* compiled from: last_ping_recv_time_offset */
public class NewsFeedRootGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedUnit, Void, FeedEnvironment> {
    private static NewsFeedRootGroupPartDefinition f17934e;
    private static final Object f17935f = new Object();
    private final Lazy<UnknownFeedUnitMultiRowGroupPartDefinition> f17936a;
    private final Map<Class<?>, Lazy<?>> f17937b;
    private final RootPartSelector<FeedEnvironment> f17938c;
    private final HideableUnitWrapperPartDefinition f17939d;

    private static NewsFeedRootGroupPartDefinition m25160b(InjectorLike injectorLike) {
        return new NewsFeedRootGroupPartDefinition(IdBasedLazy.m1808a(injectorLike, 1505), IdBasedLazy.m1808a(injectorLike, 1664), IdBasedLazy.m1808a(injectorLike, 1666), IdBasedLazy.m1808a(injectorLike, 5961), IdBasedLazy.m1808a(injectorLike, 6023), HideableUnitWrapperPartDefinition.m25163a(injectorLike), STATICDI_MULTIBIND_PROVIDER$RootPartsDeclaration.m25169a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (FeedUnit) obj;
        if (obj != null && !this.f17938c.m25172a(baseMultiRowSubParts, obj)) {
            for (Entry entry : this.f17937b.entrySet()) {
                if (((Class) entry.getKey()).isInstance(obj)) {
                    boolean a;
                    final MultiRowPartWithIsNeeded multiRowPartWithIsNeeded = (MultiRowPartWithIsNeeded) ((Lazy) entry.getValue()).get();
                    if (obj instanceof HideableUnit) {
                        a = baseMultiRowSubParts.m19112a(this.f17939d, new Props(new Object(this) {
                            final /* synthetic */ NewsFeedRootGroupPartDefinition f18978b;
                        }, (HideableUnit) obj));
                    } else {
                        a = baseMultiRowSubParts.m19112a(multiRowPartWithIsNeeded, FeedProps.m19802c(obj));
                    }
                    if (a) {
                        break;
                    }
                }
            }
            baseMultiRowSubParts.m19112a((MultiRowPartWithIsNeeded) this.f17936a.get(), obj);
        }
        return null;
    }

    @Inject
    public NewsFeedRootGroupPartDefinition(Lazy<GraphQLStorySelectorPartDefinition> lazy, Lazy<FeedHiddenUnitGroupPartDefinition> lazy2, Lazy<HiddenUnitGroupPartDefinition> lazy3, Lazy<HoldoutUnitPartDefinition> lazy4, Lazy<UnknownFeedUnitMultiRowGroupPartDefinition> lazy5, HideableUnitWrapperPartDefinition hideableUnitWrapperPartDefinition, Set<RootPartsDeclaration> set) {
        this.f17938c = RootPartSelector.m25170a().m25173b(NegativeFeedbackActionsUnit.class, lazy2).m25173b(HideableUnit.class, lazy3).m25171a(GraphQLHoldoutAdFeedUnit.class, (Lazy) lazy4);
        this.f17936a = lazy5;
        this.f17939d = hideableUnitWrapperPartDefinition;
        Builder builder = ImmutableMap.builder();
        builder.m609b(GraphQLStory.class, lazy);
        RootPartRegistrationController rootPartRegistrationController = new RootPartRegistrationController(builder);
        for (RootPartsDeclaration a : set) {
            a.mo2995a(rootPartRegistrationController);
        }
        this.f17937b = builder.m610b();
    }

    public static NewsFeedRootGroupPartDefinition m25159a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NewsFeedRootGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f17935f) {
                NewsFeedRootGroupPartDefinition newsFeedRootGroupPartDefinition;
                if (a2 != null) {
                    newsFeedRootGroupPartDefinition = (NewsFeedRootGroupPartDefinition) a2.mo818a(f17935f);
                } else {
                    newsFeedRootGroupPartDefinition = f17934e;
                }
                if (newsFeedRootGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25160b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f17935f, b3);
                        } else {
                            f17934e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = newsFeedRootGroupPartDefinition;
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
