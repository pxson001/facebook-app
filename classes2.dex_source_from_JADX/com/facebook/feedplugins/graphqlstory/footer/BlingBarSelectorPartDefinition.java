package com.facebook.feedplugins.graphqlstory.footer;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.logging.FeedDiscoveryFunnelLoggerUtil;
import com.facebook.feedplugins.base.blingbar.BlingBarRootPartDefinition;
import com.facebook.feedplugins.graphqlstory.followup.FollowUpPersistentState;
import com.facebook.feedplugins.graphqlstory.followup.FollowUpPersistentStateKey;
import com.facebook.feedplugins.pillsblingbar.ui.PillsBlingBarPartDefinition;
import com.facebook.feedplugins.voiceswitcher.VoiceSwitcherPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
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
/* compiled from: inf_hscroll_fetch_offset */
public class BlingBarSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static BlingBarSelectorPartDefinition f20187j;
    private static final Object f20188k = new Object();
    private final GraphQLStoryUtil f20189a;
    private final Lazy<InstagramBlingBarPartDefinition> f20190b;
    private final Lazy<PillsBlingBarPartDefinition<FeedEnvironment>> f20191c;
    private final Lazy<VoiceSwitcherPartDefinition<FeedEnvironment>> f20192d;
    private final Lazy<BlingBarRootPartDefinition> f20193e;
    private final Lazy<DefaultVideoPlaysBlingBarPartDefinition> f20194f;
    private final Lazy<FeedDiscoveryDefaultBlingBarPartDefinition> f20195g;
    private final Lazy<FeedDiscoveryPillsBlingBarPartDefinition<?, FeedEnvironment>> f20196h;
    private final Lazy<FeedDiscoveryFunnelLoggerUtil> f20197i;

    private static BlingBarSelectorPartDefinition m27853b(InjectorLike injectorLike) {
        return new BlingBarSelectorPartDefinition(GraphQLStoryUtil.m9565a(injectorLike), IdBasedLazy.m1808a(injectorLike, 6303), IdBasedLazy.m1808a(injectorLike, 1949), IdBasedLazy.m1808a(injectorLike, 6626), IdBasedLazy.m1808a(injectorLike, 6197), IdBasedLazy.m1808a(injectorLike, 6301), IdBasedLazy.m1808a(injectorLike, 6302), IdBasedLazy.m1808a(injectorLike, 1868), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1771));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (FeedProps) obj;
        FeedEnvironment feedEnvironment = (FeedEnvironment) anyEnvironment;
        CacheableEntity cacheableEntity = (GraphQLStory) obj.f13444a;
        ((FeedDiscoveryFunnelLoggerUtil) this.f20197i.get()).m28898a((GraphQLStory) cacheableEntity);
        FollowUpPersistentState followUpPersistentState = (FollowUpPersistentState) feedEnvironment.mo2425a(new FollowUpPersistentStateKey(cacheableEntity), cacheableEntity);
        SubPartsSelector a = SubPartsSelector.m19115a(baseMultiRowSubParts, this.f20196h, obj).m19119a(this.f20191c, obj).m19119a(this.f20192d, obj);
        if (!followUpPersistentState.f21186a) {
            a.m19119a(this.f20190b, obj);
        }
        a.m19119a(this.f20194f, obj).m19119a(this.f20195g, obj).m19119a(this.f20193e, obj);
        return null;
    }

    public final boolean mo2536a(Object obj) {
        return GraphQLStoryUtil.m9572b((FeedProps) obj);
    }

    @Inject
    public BlingBarSelectorPartDefinition(GraphQLStoryUtil graphQLStoryUtil, Lazy<InstagramBlingBarPartDefinition> lazy, Lazy<PillsBlingBarPartDefinition> lazy2, Lazy<VoiceSwitcherPartDefinition> lazy3, Lazy<BlingBarRootPartDefinition> lazy4, Lazy<DefaultVideoPlaysBlingBarPartDefinition> lazy5, Lazy<FeedDiscoveryDefaultBlingBarPartDefinition> lazy6, Lazy<FeedDiscoveryPillsBlingBarPartDefinition> lazy7, Lazy<FeedDiscoveryFunnelLoggerUtil> lazy8) {
        this.f20190b = lazy;
        this.f20191c = lazy2;
        this.f20192d = lazy3;
        this.f20193e = lazy4;
        this.f20194f = lazy5;
        this.f20195g = lazy6;
        this.f20196h = lazy7;
        this.f20189a = graphQLStoryUtil;
        this.f20197i = lazy8;
    }

    public static BlingBarSelectorPartDefinition m27852a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BlingBarSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20188k) {
                BlingBarSelectorPartDefinition blingBarSelectorPartDefinition;
                if (a2 != null) {
                    blingBarSelectorPartDefinition = (BlingBarSelectorPartDefinition) a2.mo818a(f20188k);
                } else {
                    blingBarSelectorPartDefinition = f20187j;
                }
                if (blingBarSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27853b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20188k, b3);
                        } else {
                            f20187j = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = blingBarSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
