package com.facebook.search.model;

import android.os.Parcelable;
import com.facebook.graphql.calls.ExactMatchInputExactMatch;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.model.SuggestionGroup.Type;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: TID; */
public class TrendingTypeaheadUnit extends TypeaheadUnit implements GraphSearchQuerySpec {
    public final String f22295a;
    public final String f22296b;
    public final String f22297c;
    public final String f22298d;
    private final String f22299e;
    private final ExactMatchInputExactMatch f22300f;
    public final String f22301g;
    public final String f22302h;
    public final String f22303i;
    public final String f22304j;
    private final ImmutableMap<String, Parcelable> f22305k;
    public final String f22306l;
    public final String f22307m;
    public final ScopedEntityType f22308n;
    @Nullable
    public final String f22309o;

    @Nullable
    public final ReactionSearchData mo1221m() {
        return null;
    }

    public final boolean m25769u() {
        return this.f22304j != null;
    }

    @Nonnull
    public final String mo1211a() {
        return this.f22297c;
    }

    @Nonnull
    public final String mo1212b() {
        return this.f22298d;
    }

    public final String jH_() {
        return this.f22299e;
    }

    public final ExactMatchInputExactMatch mo1214e() {
        return this.f22300f;
    }

    public final String mo1213c() {
        return this.f22295a;
    }

    @Nonnull
    public final ImmutableList<GraphQLGraphSearchResultsDisplayStyle> mo1215f() {
        return ImmutableList.of(GraphQLGraphSearchResultsDisplayStyle.BLENDED);
    }

    public final ImmutableMap<String, Parcelable> jJ_() {
        return this.f22305k;
    }

    public final <T> T m25757a(TypeaheadSuggestionVisitorWithReturn<T> typeaheadSuggestionVisitorWithReturn) {
        return typeaheadSuggestionVisitorWithReturn.mo1234a(this);
    }

    public final void m25759a(TypeaheadSuggestionVisitor typeaheadSuggestionVisitor) {
        typeaheadSuggestionVisitor.m25780a(this);
    }

    public final Type m25766k() {
        return Type.TRENDING;
    }

    public final String mo1216h() {
        return this.f22306l;
    }

    public final String mo1217i() {
        return this.f22307m;
    }

    public final ScopedEntityType jI_() {
        return this.f22308n;
    }

    public final boolean m25767l() {
        return true;
    }

    public String toString() {
        return "TrendingTypeaheadUnit(" + mo1211a() + ") {, invalidated:" + x() + "}";
    }
}
