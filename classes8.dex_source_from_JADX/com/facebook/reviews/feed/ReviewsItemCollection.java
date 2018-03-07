package com.facebook.reviews.feed;

import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.common.time.Clock;
import com.facebook.graphql.model.GraphQLStory;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Triggers */
public class ReviewsItemCollection implements ListItemCollection<GraphQLStory> {
    public final Clock f21606a;
    public final List<GraphQLStory> f21607b = new ArrayList();
    public final Map<String, Integer> f21608c = new HashMap();

    @Inject
    public ReviewsItemCollection(Clock clock) {
        this.f21606a = clock;
    }

    public final Object m25154a(int i) {
        return (GraphQLStory) this.f21607b.get(i);
    }

    public final int m25152a() {
        return this.f21607b.size();
    }

    @Nullable
    public final GraphQLStory m25153a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        for (GraphQLStory graphQLStory : this.f21607b) {
            if (str.equals(graphQLStory.g())) {
                return graphQLStory;
            }
        }
        return null;
    }

    public final void m25155a(GraphQLStory graphQLStory) {
        this.f21607b.add(0, graphQLStory);
        m25151c();
    }

    public final void m25156b(GraphQLStory graphQLStory) {
        boolean z = true;
        Preconditions.checkArgument(graphQLStory.c() != null, "Trying to replace a story without id");
        Integer num = (Integer) this.f21608c.get(graphQLStory.c());
        if (num != null) {
            boolean z2;
            if (num.intValue() >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkState(z2);
            if (num.intValue() >= this.f21607b.size()) {
                z = false;
            }
            Preconditions.checkState(z);
            this.f21607b.set(num.intValue(), graphQLStory);
        }
    }

    public final void m25157c(String str) {
        GraphQLStory a = m25153a(str);
        if (a != null) {
            this.f21607b.remove(a);
            m25151c();
        }
    }

    private void m25151c() {
        this.f21608c.clear();
        for (int i = 0; i < this.f21607b.size(); i++) {
            this.f21608c.put(((GraphQLStory) this.f21607b.get(i)).c(), Integer.valueOf(i));
        }
    }
}
