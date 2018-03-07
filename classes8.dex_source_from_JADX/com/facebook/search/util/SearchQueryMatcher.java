package com.facebook.search.util;

import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.google.common.base.Preconditions;

/* compiled from: member_search_result_section */
public class SearchQueryMatcher {
    public final ScopedEntityType f8928a;
    public final int f8929b;
    public final boolean f8930c;

    /* compiled from: member_search_result_section */
    public class Builder {
        private ScopedEntityType f8925a;
        private int f8926b = -1;
        private boolean f8927c = false;

        public Builder(ScopedEntityType scopedEntityType) {
            this.f8925a = scopedEntityType;
        }

        public final Builder m10658a(int i) {
            Preconditions.checkState(this.f8926b == -1, "Gk already specified");
            this.f8926b = i;
            return this;
        }

        public final Builder m10657a() {
            this.f8927c = true;
            return this;
        }

        public final SearchQueryMatcher m10659b() {
            return new SearchQueryMatcher(this.f8925a, this.f8926b, this.f8927c);
        }
    }

    public SearchQueryMatcher(ScopedEntityType scopedEntityType, int i, boolean z) {
        this.f8928a = scopedEntityType;
        this.f8929b = i;
        this.f8930c = z;
    }

    public static Builder m10660a(ScopedEntityType scopedEntityType) {
        return new Builder(scopedEntityType);
    }
}
