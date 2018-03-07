package com.facebook.feed.rows.sections;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.story.FeedStoryUtil;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: inf_hscroll_fetch_type */
public class StoryPostFooterSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static StoryPostFooterSelectorPartDefinition f20169d;
    private static final Object f20170e = new Object();
    private final FeedStoryUtil f20171a;
    private final Lazy<StoryPromotionPartDefinition<FeedEnvironment>> f20172b;
    private final Lazy<StoryAYMTHotPostFooterPartDefinition<FeedEnvironment>> f20173c;

    private static StoryPostFooterSelectorPartDefinition m27845b(InjectorLike injectorLike) {
        return new StoryPostFooterSelectorPartDefinition(IdBasedLazy.m1808a(injectorLike, 1512), IdBasedLazy.m1808a(injectorLike, 5965), FeedStoryUtil.m18578a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (FeedProps) obj;
        baseMultiRowSubParts.m19112a((MultiRowPartWithIsNeeded) this.f20173c.get(), obj);
        baseMultiRowSubParts.m19112a((MultiRowPartWithIsNeeded) this.f20172b.get(), obj);
        return null;
    }

    public final boolean mo2536a(Object obj) {
        return this.f20171a.m18591c((GraphQLStory) ((FeedProps) obj).f13444a);
    }

    @Inject
    public StoryPostFooterSelectorPartDefinition(Lazy<StoryPromotionPartDefinition> lazy, Lazy<StoryAYMTHotPostFooterPartDefinition> lazy2, FeedStoryUtil feedStoryUtil) {
        this.f20171a = feedStoryUtil;
        this.f20172b = lazy;
        this.f20173c = lazy2;
    }

    public static StoryPostFooterSelectorPartDefinition m27844a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StoryPostFooterSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20170e) {
                StoryPostFooterSelectorPartDefinition storyPostFooterSelectorPartDefinition;
                if (a2 != null) {
                    storyPostFooterSelectorPartDefinition = (StoryPostFooterSelectorPartDefinition) a2.mo818a(f20170e);
                } else {
                    storyPostFooterSelectorPartDefinition = f20169d;
                }
                if (storyPostFooterSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27845b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20170e, b3);
                        } else {
                            f20169d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = storyPostFooterSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
