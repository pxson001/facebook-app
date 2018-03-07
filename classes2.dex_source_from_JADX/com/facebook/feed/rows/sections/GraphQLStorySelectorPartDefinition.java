package com.facebook.feed.rows.sections;

import android.content.Context;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.sections.offline.OfflineStoryPartDefinition;
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
/* compiled from: inline_android */
public class GraphQLStorySelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static GraphQLStorySelectorPartDefinition f19939i;
    private static final Object f19940j = new Object();
    private final Lazy<PersonalHighlightStoryGroupPartDefinition> f19941a;
    private final Lazy<OfflineStoryPartDefinition> f19942b;
    private final Lazy<SharedStoryPartDefinition> f19943c;
    private final Lazy<AggregatedStoryGroupPartDefinition> f19944d;
    private final Lazy<EdgeStoryGroupPartDefinition> f19945e;
    private final Lazy<BasicGroupPartDefinition> f19946f;
    private final FeedStoryUtil f19947g;
    private final OptimisticStoryStateCache f19948h;

    private static GraphQLStorySelectorPartDefinition m27725b(InjectorLike injectorLike) {
        return new GraphQLStorySelectorPartDefinition(IdBasedLazy.m1808a(injectorLike, 1502), IdBasedLazy.m1808a(injectorLike, 1503), IdBasedLazy.m1808a(injectorLike, 1500), IdBasedLazy.m1808a(injectorLike, 1510), IdBasedLazy.m1808a(injectorLike, 1680), IdBasedLazy.m1808a(injectorLike, 1509), FeedStoryUtil.m18578a(injectorLike), OptimisticStoryStateCache.m9726a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (FeedProps) obj;
        if (PersonalHighlightStoryGroupPartDefinition.m27729a(obj, this.f19947g)) {
            baseMultiRowSubParts.m19112a((MultiRowPartWithIsNeeded) this.f19941a.get(), obj);
        } else if (OfflineStoryPartDefinition.m27734a(obj, this.f19948h)) {
            baseMultiRowSubParts.m19112a((MultiRowPartWithIsNeeded) this.f19942b.get(), obj);
        } else if (StoryProps.m27464m(obj)) {
            baseMultiRowSubParts.m19112a((MultiRowPartWithIsNeeded) this.f19945e.get(), obj);
        } else if (AggregatedStoryGroupPartDefinition.m27739a((FeedProps) obj)) {
            baseMultiRowSubParts.m19112a((MultiRowPartWithIsNeeded) this.f19944d.get(), obj);
        } else if (SharedStoryPartDefinition.m27744a((FeedProps) obj)) {
            baseMultiRowSubParts.m19112a((MultiRowPartWithIsNeeded) this.f19943c.get(), obj);
        } else {
            baseMultiRowSubParts.m19112a((MultiRowPartWithIsNeeded) this.f19946f.get(), obj);
        }
        return null;
    }

    @Inject
    public GraphQLStorySelectorPartDefinition(Lazy<BasicGroupPartDefinition> lazy, Lazy<EdgeStoryGroupPartDefinition> lazy2, Lazy<AggregatedStoryGroupPartDefinition> lazy3, Lazy<SharedStoryPartDefinition> lazy4, Lazy<OfflineStoryPartDefinition> lazy5, Lazy<PersonalHighlightStoryGroupPartDefinition> lazy6, FeedStoryUtil feedStoryUtil, OptimisticStoryStateCache optimisticStoryStateCache) {
        this.f19941a = lazy6;
        this.f19942b = lazy5;
        this.f19943c = lazy4;
        this.f19944d = lazy3;
        this.f19945e = lazy2;
        this.f19946f = lazy;
        this.f19947g = feedStoryUtil;
        this.f19948h = optimisticStoryStateCache;
    }

    public final boolean mo2536a(Object obj) {
        return true;
    }

    public static GraphQLStorySelectorPartDefinition m27724a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GraphQLStorySelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f19940j) {
                GraphQLStorySelectorPartDefinition graphQLStorySelectorPartDefinition;
                if (a2 != null) {
                    graphQLStorySelectorPartDefinition = (GraphQLStorySelectorPartDefinition) a2.mo818a(f19940j);
                } else {
                    graphQLStorySelectorPartDefinition = f19939i;
                }
                if (graphQLStorySelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27725b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f19940j, b3);
                        } else {
                            f19939i = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = graphQLStorySelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
