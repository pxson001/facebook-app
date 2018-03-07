package com.facebook.search.api;

import android.net.Uri;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.inject.InjectorLike;
import com.facebook.search.api.SearchTypeaheadResult.Type;
import com.facebook.search.api.model.SearchTypeaheadJsonResult;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;

/* compiled from: extra_percent_progress */
public class SearchTypeaheadResultsCreator {
    private static final TypeReference<List<SearchTypeaheadJsonResult>> f15532a = new C11041();

    /* compiled from: extra_percent_progress */
    final class C11041 extends TypeReference<List<SearchTypeaheadJsonResult>> {
        C11041() {
        }
    }

    public static SearchTypeaheadResultsCreator m23159a(InjectorLike injectorLike) {
        return new SearchTypeaheadResultsCreator();
    }

    private static SearchTypeaheadResult m23158a(String str, String str2, boolean z, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, ImmutableList<String> immutableList) {
        GraphQLFriendshipStatus graphQLFriendshipStatus;
        Type type;
        if (str2 == null) {
            graphQLFriendshipStatus = null;
        } else {
            try {
                graphQLFriendshipStatus = GraphQLFriendshipStatus.fromString(str2);
            } catch (IllegalArgumentException e) {
                throw new SearchTypeaheadResultParserException("FriendStatus: " + str2 + " invalid");
            }
        }
        Uri a = m23156a(str3);
        Uri a2 = m23156a(str4);
        Uri a3 = m23156a(str5);
        Uri a4 = m23156a(str6);
        if (str9 == null) {
            type = null;
        } else {
            try {
                type = Type.valueOf(str9.toUpperCase());
            } catch (IllegalArgumentException e2) {
                throw new SearchTypeaheadResultParserException("Type: " + str9 + " is invalid");
            }
        }
        return SearchTypeaheadResult.newBuilder().m23141a(str).m23136a(graphQLFriendshipStatus).m23148b(z).m23145b(a).m23149c(a2).m23135a(a3).m23151d(a4).m23147b(str7).m23154f(str8).m23138a(type).m23134a(Long.parseLong(str10)).m23142a(null).m23139a((ImmutableList) immutableList).m23132a();
    }

    private static SearchTypeaheadResult m23157a(SearchTypeaheadJsonResult searchTypeaheadJsonResult) {
        return m23158a(searchTypeaheadJsonResult.category, searchTypeaheadJsonResult.friendshipStatus, searchTypeaheadJsonResult.isVerified, searchTypeaheadJsonResult.nativeAndroidUrl, searchTypeaheadJsonResult.path, searchTypeaheadJsonResult.fallbackPath, searchTypeaheadJsonResult.photo, searchTypeaheadJsonResult.subtext, searchTypeaheadJsonResult.text, searchTypeaheadJsonResult.type, searchTypeaheadJsonResult.uid, searchTypeaheadJsonResult.matchedTokens);
    }

    private ImmutableList<SearchTypeaheadResult> m23160a(List<SearchTypeaheadJsonResult> list) {
        Preconditions.checkNotNull(list);
        Builder builder = ImmutableList.builder();
        for (SearchTypeaheadJsonResult a : list) {
            builder.c(m23157a(a));
        }
        return builder.b();
    }

    public final ImmutableList<SearchTypeaheadResult> m23163a(JsonParser jsonParser) {
        Preconditions.checkNotNull(jsonParser);
        try {
            List list = (List) jsonParser.a(f15532a);
            if (list == null) {
                throw new SearchTypeaheadResultParserException("Unable to parse uberbar search results list");
            }
            ImmutableList<SearchTypeaheadResult> a = m23160a(list);
            if (a != null) {
                return a;
            }
            throw new SearchTypeaheadResultParserException("Unable to parse uberbar search results list");
        } catch (JsonProcessingException e) {
            throw new SearchTypeaheadResultParserException("Unable to parse uberbar search results list", e);
        }
    }

    private static Uri m23156a(String str) {
        if (Strings.emptyToNull(str) == null) {
            return null;
        }
        if (str.startsWith("/")) {
            return Uri.parse("http://www.facebook.com" + str);
        }
        return Uri.parse(str);
    }

    public static List<SearchTypeaheadResult> m23161a(List<SearchTypeaheadResult> list, List<SearchTypeaheadResult> list2, List<SearchTypeaheadResult> list3) {
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        Preconditions.checkNotNull(list3);
        ImmutableMap b = m23162b(list);
        List<Object> a = Lists.a(list2);
        a.addAll(list3);
        Set a2 = Sets.a();
        Builder builder = ImmutableList.builder();
        for (Object obj : a) {
            Object obj2;
            a2.add(Long.valueOf(obj2.f15497m));
            SearchTypeaheadResult searchTypeaheadResult = (SearchTypeaheadResult) b.get(Long.valueOf(obj2.f15497m));
            if (searchTypeaheadResult != null) {
                String str;
                SearchTypeaheadResultBuilder newBuilder = SearchTypeaheadResult.newBuilder();
                if (Strings.isNullOrEmpty(obj2.f15485a)) {
                    str = searchTypeaheadResult.f15485a;
                } else {
                    str = obj2.f15485a;
                }
                newBuilder.f15509a = str;
                SearchTypeaheadResultBuilder searchTypeaheadResultBuilder = newBuilder;
                searchTypeaheadResultBuilder.f15510b = obj2.f15487c;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.f15522n = obj2.f15498n;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.f15512d = obj2.f15488d;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.f15513e = obj2.f15489e;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.f15514f = obj2.f15490f;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.f15515g = searchTypeaheadResult.f15491g;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.f15519k = obj2.f15495k;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.f15520l = obj2.f15496l;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.f15521m = obj2.f15497m;
                searchTypeaheadResultBuilder = searchTypeaheadResultBuilder;
                searchTypeaheadResultBuilder.f15525q = obj2.f15501q;
                obj2 = searchTypeaheadResultBuilder.m23132a();
            }
            builder.c(obj2);
        }
        for (SearchTypeaheadResult searchTypeaheadResult2 : list) {
            if (!a2.contains(Long.valueOf(searchTypeaheadResult2.f15497m))) {
                builder.c(searchTypeaheadResult2);
            }
        }
        return builder.b();
    }

    private static ImmutableMap<Long, SearchTypeaheadResult> m23162b(List<SearchTypeaheadResult> list) {
        ImmutableMap.Builder builder = new ImmutableMap.Builder();
        for (SearchTypeaheadResult searchTypeaheadResult : list) {
            builder.b(Long.valueOf(searchTypeaheadResult.f15497m), searchTypeaheadResult);
        }
        return builder.b();
    }
}
