package com.facebook.search.api;

import android.net.Uri;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLPageVerificationBadge;
import com.facebook.search.api.SearchTypeaheadResult.Type;
import com.facebook.search.api.model.GraphSearchQueryFragment;
import com.facebook.search.api.model.GraphSearchTypeaheadJsonResult;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.List;

/* compiled from: extra_request_id */
public class GraphSearchTypeaheadResultsCreator {
    public static ImmutableList<SearchTypeaheadResult> m23110a(List<GraphSearchTypeaheadJsonResult> list) {
        Builder builder = new Builder();
        for (GraphSearchTypeaheadJsonResult graphSearchTypeaheadJsonResult : list) {
            if (graphSearchTypeaheadJsonResult.externalUrl == null) {
                SearchTypeaheadResult a;
                if (graphSearchTypeaheadJsonResult.resultType == null || !graphSearchTypeaheadJsonResult.resultType.equals("keywords_v2")) {
                    a = graphSearchTypeaheadJsonResult.externalUrl != null ? SearchTypeaheadResult.newBuilder().m23132a() : m23111c(graphSearchTypeaheadJsonResult);
                } else {
                    String str;
                    int i;
                    int i2 = 0;
                    Uri parse = Strings.isNullOrEmpty(graphSearchTypeaheadJsonResult.photoUri) ? Uri.EMPTY : Uri.parse(graphSearchTypeaheadJsonResult.photoUri);
                    SearchTypeaheadResultBuilder newBuilder = SearchTypeaheadResult.newBuilder();
                    newBuilder.f15509a = graphSearchTypeaheadJsonResult.category;
                    newBuilder = newBuilder;
                    newBuilder.f15510b = GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                    newBuilder = newBuilder;
                    newBuilder.f15522n = false;
                    newBuilder = newBuilder;
                    newBuilder.f15523o = GraphQLPageVerificationBadge.NOT_VERIFIED;
                    SearchTypeaheadResultBuilder searchTypeaheadResultBuilder = newBuilder;
                    if (graphSearchTypeaheadJsonResult.fragments == null || graphSearchTypeaheadJsonResult.fragments.size() <= 0) {
                        str = graphSearchTypeaheadJsonResult.text;
                    } else {
                        List<GraphSearchQueryFragment> list2 = graphSearchTypeaheadJsonResult.fragments;
                        StringBuilder stringBuilder = new StringBuilder();
                        for (GraphSearchQueryFragment graphSearchQueryFragment : list2) {
                            stringBuilder.append(graphSearchQueryFragment.text);
                        }
                        str = stringBuilder.toString();
                    }
                    searchTypeaheadResultBuilder.f15519k = str;
                    newBuilder = searchTypeaheadResultBuilder;
                    newBuilder.f15515g = graphSearchTypeaheadJsonResult.subtext;
                    newBuilder = newBuilder;
                    newBuilder.f15516h = graphSearchTypeaheadJsonResult.boldedSubtext;
                    newBuilder = newBuilder;
                    newBuilder.f15517i = graphSearchTypeaheadJsonResult.keywordType;
                    newBuilder = newBuilder;
                    newBuilder.f15518j = graphSearchTypeaheadJsonResult.keywordSource;
                    newBuilder = newBuilder;
                    newBuilder.f15520l = Type.KEYWORD_SUGGESTION;
                    newBuilder = newBuilder;
                    newBuilder.f15527s = graphSearchTypeaheadJsonResult.semantic;
                    newBuilder = newBuilder;
                    newBuilder.f15514f = parse;
                    newBuilder = newBuilder.m23140a(Boolean.valueOf(graphSearchTypeaheadJsonResult.isScoped));
                    if (Strings.isNullOrEmpty(graphSearchTypeaheadJsonResult.matchedPos)) {
                        i = 0;
                    } else {
                        i = Integer.parseInt(graphSearchTypeaheadJsonResult.matchedPos);
                    }
                    newBuilder.f15529u = i;
                    SearchTypeaheadResultBuilder searchTypeaheadResultBuilder2 = newBuilder;
                    if (!Strings.isNullOrEmpty(graphSearchTypeaheadJsonResult.matchedLength)) {
                        i2 = Integer.parseInt(graphSearchTypeaheadJsonResult.matchedLength);
                    }
                    searchTypeaheadResultBuilder2.f15530v = i2;
                    searchTypeaheadResultBuilder2 = searchTypeaheadResultBuilder2;
                    searchTypeaheadResultBuilder2.f15531w = graphSearchTypeaheadJsonResult.isLive;
                    a = searchTypeaheadResultBuilder2.m23132a();
                }
                builder.c(a);
            }
        }
        return builder.b();
    }

    public static SearchTypeaheadResult m23111c(GraphSearchTypeaheadJsonResult graphSearchTypeaheadJsonResult) {
        Type type;
        Uri uri;
        Uri uri2;
        GraphQLFriendshipStatus fromString = Strings.isNullOrEmpty(graphSearchTypeaheadJsonResult.friendshipStatus) ? null : GraphQLFriendshipStatus.fromString(graphSearchTypeaheadJsonResult.friendshipStatus);
        Uri parse = Strings.isNullOrEmpty(graphSearchTypeaheadJsonResult.photoUri) ? Uri.EMPTY : Uri.parse(graphSearchTypeaheadJsonResult.photoUri);
        if (Strings.isNullOrEmpty(graphSearchTypeaheadJsonResult.grammarType)) {
            type = null;
        } else {
            String str = graphSearchTypeaheadJsonResult.grammarType;
            type = Type.valueOf(str.substring(1, str.length() - 1).toUpperCase());
        }
        SearchTypeaheadResultBuilder newBuilder = SearchTypeaheadResult.newBuilder();
        newBuilder.f15509a = graphSearchTypeaheadJsonResult.category;
        SearchTypeaheadResultBuilder searchTypeaheadResultBuilder = newBuilder;
        if (Strings.isNullOrEmpty(graphSearchTypeaheadJsonResult.fallbackPath)) {
            uri = null;
        } else {
            uri = Uri.parse(graphSearchTypeaheadJsonResult.fallbackPath);
        }
        searchTypeaheadResultBuilder.f15511c = uri;
        newBuilder = searchTypeaheadResultBuilder;
        newBuilder.f15510b = fromString;
        SearchTypeaheadResultBuilder searchTypeaheadResultBuilder2 = newBuilder;
        searchTypeaheadResultBuilder2.f15522n = Boolean.valueOf(graphSearchTypeaheadJsonResult.isVerified).booleanValue();
        searchTypeaheadResultBuilder2 = searchTypeaheadResultBuilder2;
        searchTypeaheadResultBuilder2.f15523o = GraphQLPageVerificationBadge.fromString(graphSearchTypeaheadJsonResult.verificationStatus);
        searchTypeaheadResultBuilder2 = searchTypeaheadResultBuilder2;
        searchTypeaheadResultBuilder2.f15512d = null;
        newBuilder = searchTypeaheadResultBuilder2;
        if (Strings.isNullOrEmpty(graphSearchTypeaheadJsonResult.path)) {
            uri2 = null;
        } else {
            uri2 = Uri.parse(graphSearchTypeaheadJsonResult.path);
        }
        newBuilder.f15513e = uri2;
        searchTypeaheadResultBuilder2 = newBuilder;
        searchTypeaheadResultBuilder2.f15514f = parse;
        searchTypeaheadResultBuilder2 = searchTypeaheadResultBuilder2;
        searchTypeaheadResultBuilder2.f15515g = graphSearchTypeaheadJsonResult.subtext;
        searchTypeaheadResultBuilder2 = searchTypeaheadResultBuilder2;
        searchTypeaheadResultBuilder2.f15519k = graphSearchTypeaheadJsonResult.name;
        searchTypeaheadResultBuilder2 = searchTypeaheadResultBuilder2;
        searchTypeaheadResultBuilder2.f15520l = type;
        searchTypeaheadResultBuilder2 = searchTypeaheadResultBuilder2;
        searchTypeaheadResultBuilder2.f15521m = Long.parseLong(graphSearchTypeaheadJsonResult.semantic);
        searchTypeaheadResultBuilder2 = searchTypeaheadResultBuilder2;
        searchTypeaheadResultBuilder2.f15525q = null;
        searchTypeaheadResultBuilder2 = searchTypeaheadResultBuilder2;
        searchTypeaheadResultBuilder2.f15526r = RegularImmutableList.a;
        searchTypeaheadResultBuilder2 = searchTypeaheadResultBuilder2;
        searchTypeaheadResultBuilder2.f15527s = graphSearchTypeaheadJsonResult.semantic;
        searchTypeaheadResultBuilder2 = searchTypeaheadResultBuilder2.m23140a(Boolean.valueOf(graphSearchTypeaheadJsonResult.isScoped));
        searchTypeaheadResultBuilder2.f15531w = graphSearchTypeaheadJsonResult.isLive;
        return searchTypeaheadResultBuilder2.m23132a();
    }
}
