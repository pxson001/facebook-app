package com.facebook.search.results.model.specification.matchers;

import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: Review Feed failed to load reviews */
public class MultiDisplayStyleMatcher implements DisplayStyleMatcher {
    private final ImmutableSet<GraphQLGraphSearchResultsDisplayStyle> f23448a;

    public boolean apply(@Nullable Object obj) {
        GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle = (GraphQLGraphSearchResultsDisplayStyle) obj;
        return graphQLGraphSearchResultsDisplayStyle != null && this.f23448a.contains(graphQLGraphSearchResultsDisplayStyle);
    }

    public MultiDisplayStyleMatcher(ImmutableSet<GraphQLGraphSearchResultsDisplayStyle> immutableSet) {
        boolean z;
        boolean z2 = true;
        this.f23448a = (ImmutableSet) Preconditions.checkNotNull(immutableSet);
        if (this.f23448a.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkState(z, "Must specify display styles");
        if (this.f23448a.size() <= 1) {
            z2 = false;
        }
        Preconditions.checkState(z2, "Only one display style specified. Use SingleDisplayStyleMatcher instead.");
    }

    public final boolean mo1323a(DisplayStyleMatcher displayStyleMatcher) {
        Iterator it = this.f23448a.iterator();
        while (it.hasNext()) {
            if (displayStyleMatcher.apply((GraphQLGraphSearchResultsDisplayStyle) it.next())) {
                return true;
            }
        }
        return false;
    }
}
