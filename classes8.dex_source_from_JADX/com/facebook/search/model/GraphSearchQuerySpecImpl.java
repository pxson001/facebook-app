package com.facebook.search.model;

import android.os.Parcelable;
import com.facebook.graphql.calls.ExactMatchInputExactMatch;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: TURN_ON_NOTIFICATIONS_LS */
public class GraphSearchQuerySpecImpl implements GraphSearchQuerySpec {
    private final String f22072a;
    private final String f22073b;
    private final String f22074c;
    private final String f22075d;
    private final ExactMatchInputExactMatch f22076e;
    private final ImmutableList<GraphQLGraphSearchResultsDisplayStyle> f22077f;
    private final ImmutableMap<String, Parcelable> f22078g;
    private final ReactionSearchData f22079h;
    private final String f22080i;
    private final String f22081j;
    private final ScopedEntityType f22082k;

    /* compiled from: TURN_ON_NOTIFICATIONS_LS */
    public class Builder {
        public String f22061a;
        public String f22062b;
        public String f22063c;
        public String f22064d;
        public ExactMatchInputExactMatch f22065e;
        public ImmutableList<GraphQLGraphSearchResultsDisplayStyle> f22066f;
        public ImmutableMap<String, Parcelable> f22067g;
        public ReactionSearchData f22068h;
        public String f22069i;
        public String f22070j;
        public ScopedEntityType f22071k;

        public final GraphSearchQuerySpecImpl m25632i() {
            return new GraphSearchQuerySpecImpl(this);
        }
    }

    public GraphSearchQuerySpecImpl(Builder builder) {
        this.f22072a = (String) Preconditions.checkNotNull(builder.f22061a);
        this.f22073b = (String) Preconditions.checkNotNull(builder.f22062b);
        this.f22074c = builder.f22063c;
        this.f22075d = builder.f22064d;
        this.f22076e = builder.f22065e;
        this.f22077f = (ImmutableList) Preconditions.checkNotNull(builder.f22066f);
        this.f22078g = (ImmutableMap) Preconditions.checkNotNull(builder.f22067g);
        Preconditions.checkState(!this.f22077f.isEmpty());
        this.f22079h = builder.f22068h;
        this.f22080i = builder.f22069i;
        this.f22081j = builder.f22070j;
        this.f22082k = builder.f22071k;
    }

    @Nonnull
    public final String mo1211a() {
        return this.f22072a;
    }

    @Nonnull
    public final String mo1212b() {
        return this.f22073b;
    }

    public final String mo1213c() {
        return this.f22074c;
    }

    public final String jH_() {
        return this.f22075d;
    }

    public final ExactMatchInputExactMatch mo1214e() {
        return this.f22076e;
    }

    @Nonnull
    public final ImmutableList<GraphQLGraphSearchResultsDisplayStyle> mo1215f() {
        return this.f22077f;
    }

    public final ImmutableMap<String, Parcelable> jJ_() {
        return this.f22078g;
    }

    @Nullable
    public final ReactionSearchData mo1221m() {
        return this.f22079h;
    }

    public int hashCode() {
        return this.f22072a.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof GraphSearchQuerySpecImpl) {
            return ((GraphSearchQuerySpecImpl) obj).f22072a.equals(this.f22072a);
        }
        return false;
    }

    public final String mo1216h() {
        return this.f22080i;
    }

    public final String mo1217i() {
        return this.f22081j;
    }

    public final ScopedEntityType jI_() {
        return this.f22082k;
    }
}
