package com.facebook.api.feedcache.memory.pendingstory;

import com.facebook.api.feed.util.FeedEdgeComparator;
import com.facebook.api.feed.util.FeedUtils;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.common.collect.MapWithSecondaryOrdering;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.Feedbackable;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLFeedUnitEdge.Builder;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: send_error */
public class PendingStoryCache {
    private final Comparator<FeedEdge> f5644a = new C02631(this);
    public final MapWithSecondaryOrdering<String, FeedEdge> f5645b = new MapWithSecondaryOrdering(this.f5644a);
    private final OptimisticStoryStateCache f5646c;

    /* compiled from: send_error */
    class C02631 implements Comparator<FeedEdge> {
        final /* synthetic */ PendingStoryCache f5649a;

        C02631(PendingStoryCache pendingStoryCache) {
            this.f5649a = pendingStoryCache;
        }

        public int compare(Object obj, Object obj2) {
            GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) obj2;
            FeedUnit c = ((GraphQLFeedUnitEdge) obj).mo2540c();
            FeedUnit c2 = graphQLFeedUnitEdge.mo2540c();
            if ((c instanceof GraphQLStory) && (c2 instanceof GraphQLStory)) {
                return Long.valueOf(((GraphQLStory) c2).m22336V()).compareTo(Long.valueOf(((GraphQLStory) c).m22336V()));
            }
            return 1;
        }
    }

    public static PendingStoryCache m9709b(InjectorLike injectorLike) {
        return new PendingStoryCache(OptimisticStoryStateCache.m9726a(injectorLike));
    }

    @Inject
    public PendingStoryCache(OptimisticStoryStateCache optimisticStoryStateCache) {
        this.f5646c = optimisticStoryStateCache;
    }

    public final void m9715a(String str) {
        if (str != null) {
            this.f5645b.remove(str);
        }
    }

    public final boolean m9718b(String str) {
        if (Strings.isNullOrEmpty(str)) {
            return false;
        }
        m9715a(m9710g(str));
        return true;
    }

    public final boolean m9720c(String str) {
        if (Strings.isNullOrEmpty(str)) {
            return false;
        }
        String str2;
        for (Entry entry : this.f5645b.entrySet()) {
            if ((((GraphQLFeedUnitEdge) entry.getValue()).mo2540c() instanceof GraphQLStory) && str.equals(((GraphQLStory) ((GraphQLFeedUnitEdge) entry.getValue()).mo2540c()).m22350c())) {
                str2 = (String) entry.getKey();
                break;
            }
        }
        str2 = null;
        String str3 = str2;
        if (Strings.isNullOrEmpty(str3)) {
            return false;
        }
        m9715a(str3);
        return true;
    }

    public final int m9711a(List<? extends FeedEdge> list) {
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) it.next();
            for (Entry value : this.f5645b.entrySet()) {
                boolean z;
                GraphQLFeedUnitEdge graphQLFeedUnitEdge2 = (GraphQLFeedUnitEdge) value.getValue();
                if (graphQLFeedUnitEdge2 == null || graphQLFeedUnitEdge == null || !(graphQLFeedUnitEdge2.mo2540c() instanceof Feedbackable) || !(graphQLFeedUnitEdge.mo2540c() instanceof Feedbackable)) {
                    z = false;
                } else {
                    z = FeedUtils.m11183a(graphQLFeedUnitEdge2.mo2540c(), graphQLFeedUnitEdge.mo2540c());
                }
                if (z) {
                    i++;
                    break;
                }
            }
        }
        return i;
    }

    public final void m9716a(String str, GraphQLStory graphQLStory) {
        Preconditions.checkNotNull(graphQLStory);
        Preconditions.checkNotNull(str);
        this.f5645b.remove(str);
        MapWithSecondaryOrdering mapWithSecondaryOrdering = this.f5645b;
        Builder builder = new Builder();
        builder.f15732i = graphQLStory;
        builder = builder;
        builder.f15729f = null;
        builder = builder;
        builder.f15734k = FeedEdgeComparator.f5642b;
        builder = builder;
        builder.f15728e = "synthetic_cursor";
        mapWithSecondaryOrdering.put(str, builder.m22415a());
    }

    public final boolean m9722d(String str) {
        if (str == null) {
            return false;
        }
        return this.f5645b.containsKey(str);
    }

    public final List<FeedEdge> m9713a() {
        return this.f5645b.f5654e;
    }

    public final int m9719c() {
        return this.f5645b.size();
    }

    public final boolean m9717a(GraphQLStory graphQLStory) {
        String nullToEmpty = Strings.nullToEmpty(graphQLStory.ai());
        if (Strings.isNullOrEmpty(nullToEmpty) && graphQLStory.mo2890l() != null) {
            nullToEmpty = graphQLStory.mo2890l().mo2933j();
        }
        nullToEmpty = m9710g(nullToEmpty);
        if (nullToEmpty == null) {
            return false;
        }
        m9716a(nullToEmpty, graphQLStory);
        return true;
    }

    @Nullable
    public final GraphQLStory m9712a(String str, String str2) {
        GraphQLStory f = m9724f(str);
        return f != null ? f : m9723e(str2);
    }

    public final GraphQLStory m9723e(String str) {
        String g = m9710g(str);
        if (g != null) {
            return (GraphQLStory) ((GraphQLFeedUnitEdge) this.f5645b.get(g)).mo2540c();
        }
        return null;
    }

    public final GraphQLStory m9724f(String str) {
        GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) this.f5645b.get(str);
        if (graphQLFeedUnitEdge == null) {
            return null;
        }
        return (GraphQLStory) graphQLFeedUnitEdge.mo2540c();
    }

    private String m9710g(String str) {
        if (Strings.isNullOrEmpty(str)) {
            return null;
        }
        for (Entry entry : this.f5645b.entrySet()) {
            if (((GraphQLFeedUnitEdge) entry.getValue()).mo2540c() instanceof GraphQLStory) {
                GraphQLStory graphQLStory = (GraphQLStory) ((GraphQLFeedUnitEdge) entry.getValue()).mo2540c();
                if (Objects.equal(str, graphQLStory.ai()) || (graphQLStory.mo2890l() != null && Objects.equal(graphQLStory.mo2890l().mo2933j(), str))) {
                    return (String) entry.getKey();
                }
            }
        }
        return null;
    }

    public final void m9721d() {
        this.f5645b.clear();
    }

    public final void m9714a(GraphQLFeedOptimisticPublishState graphQLFeedOptimisticPublishState) {
        List<String> a = Lists.m1296a();
        for (Entry entry : this.f5645b.entrySet()) {
            FeedUnit c = ((GraphQLFeedUnitEdge) entry.getValue()).mo2540c();
            if ((c instanceof GraphQLStory) && this.f5646c.m9728a((GraphQLStory) c) == graphQLFeedOptimisticPublishState) {
                a.add(entry.getKey());
            }
        }
        for (String a2 : a) {
            m9715a(a2);
        }
    }
}
