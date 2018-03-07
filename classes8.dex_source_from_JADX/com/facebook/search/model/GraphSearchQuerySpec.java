package com.facebook.search.model;

import android.os.Parcelable;
import com.facebook.graphql.calls.ExactMatchInputExactMatch;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;

/* compiled from: TVH;>; */
public interface GraphSearchQuerySpec {
    String mo1211a();

    String mo1212b();

    String mo1213c();

    ExactMatchInputExactMatch mo1214e();

    ImmutableList<GraphQLGraphSearchResultsDisplayStyle> mo1215f();

    String mo1216h();

    String mo1217i();

    String jH_();

    ScopedEntityType jI_();

    ImmutableMap<String, Parcelable> jJ_();

    @Nullable
    ReactionSearchData mo1221m();
}
