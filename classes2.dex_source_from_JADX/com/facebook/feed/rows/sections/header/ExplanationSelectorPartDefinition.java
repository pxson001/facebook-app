package com.facebook.feed.rows.sections.header;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.components.ExplanationComponentPartDefinition;
import com.facebook.feed.rows.sections.header.components.SocialContextExplanationComponentPartDefinition;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: initialArraySize */
public class ExplanationSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static ExplanationSelectorPartDefinition f20047h;
    private static final Object f20048i = new Object();
    private final FeedStoryUtil f20049a;
    private final Lazy<ThrowbackSharedStoryExplanationPartDefinition> f20050b;
    private final Lazy<ThrowbackSharedStoryHeaderExplanationPartDefinition> f20051c;
    private final Lazy<ExplanationPartDefinition<FeedEnvironment>> f20052d;
    private final Lazy<ExplanationComponentPartDefinition<FeedEnvironment>> f20053e;
    private final Lazy<SocialContextExplanationPartDefinition<FeedEnvironment>> f20054f;
    private final Lazy<SocialContextExplanationComponentPartDefinition<FeedEnvironment>> f20055g;

    private static ExplanationSelectorPartDefinition m27774b(InjectorLike injectorLike) {
        return new ExplanationSelectorPartDefinition(FeedStoryUtil.m18578a(injectorLike), IdBasedLazy.m1808a(injectorLike, 1616), IdBasedLazy.m1808a(injectorLike, 1593), IdBasedLazy.m1808a(injectorLike, 1631), IdBasedLazy.m1808a(injectorLike, 1623), IdBasedLazy.m1808a(injectorLike, 1624), IdBasedLazy.m1808a(injectorLike, 1662));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (FeedProps) obj;
        SubPartsSelector.m19115a(baseMultiRowSubParts, this.f20055g, obj).m19119a(this.f20054f, obj).m19119a(this.f20051c, obj).m19119a(this.f20050b, obj).m19119a(this.f20053e, obj).m19119a(this.f20052d, obj);
        return null;
    }

    public final boolean mo2536a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).f13444a;
        return FeedStoryUtil.m18581a(graphQLStory) || graphQLStory.aA() != null;
    }

    @Inject
    public ExplanationSelectorPartDefinition(FeedStoryUtil feedStoryUtil, Lazy<SocialContextExplanationPartDefinition> lazy, Lazy<ExplanationPartDefinition> lazy2, Lazy<ExplanationComponentPartDefinition> lazy3, Lazy<ThrowbackSharedStoryExplanationPartDefinition> lazy4, Lazy<ThrowbackSharedStoryHeaderExplanationPartDefinition> lazy5, Lazy<SocialContextExplanationComponentPartDefinition> lazy6) {
        this.f20049a = feedStoryUtil;
        this.f20050b = lazy4;
        this.f20051c = lazy5;
        this.f20052d = lazy2;
        this.f20053e = lazy3;
        this.f20054f = lazy;
        this.f20055g = lazy6;
    }

    public static ExplanationSelectorPartDefinition m27773a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ExplanationSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20048i) {
                ExplanationSelectorPartDefinition explanationSelectorPartDefinition;
                if (a2 != null) {
                    explanationSelectorPartDefinition = (ExplanationSelectorPartDefinition) a2.mo818a(f20048i);
                } else {
                    explanationSelectorPartDefinition = f20047h;
                }
                if (explanationSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27774b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20048i, b3);
                        } else {
                            f20047h = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = explanationSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
