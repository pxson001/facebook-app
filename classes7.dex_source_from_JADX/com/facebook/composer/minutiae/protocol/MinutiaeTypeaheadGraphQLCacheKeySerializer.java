package com.facebook.composer.minutiae.protocol;

import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQL.FetchTaggableObjectsQueryString;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQL.FetchTaggableSuggestionsAtPlaceQueryString;
import com.facebook.graphql.executor.GraphQLCacheKeySerializer;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.cachekey.KeyFactory;
import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.graphql.query.GraphQlQueryString;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: time_last_souvenir_prompt_dismissed */
public class MinutiaeTypeaheadGraphQLCacheKeySerializer implements GraphQLCacheKeySerializer {
    private final GraphQlQueryParamSet f1701c;
    public final GraphQlQueryString f1702d;

    public MinutiaeTypeaheadGraphQLCacheKeySerializer(GraphQlQueryString graphQlQueryString, GraphQlQueryParamSet graphQlQueryParamSet) {
        this.f1702d = graphQlQueryString;
        this.f1701c = graphQlQueryParamSet;
    }

    public final String m1695a(GraphQLRequest graphQLRequest, Class<?> cls, KeyFactory keyFactory) {
        return m1696a(cls, keyFactory);
    }

    public final String m1696a(Class<?> cls, KeyFactory keyFactory) {
        String str;
        Collection arrayList = new ArrayList(2);
        if (this.f1702d instanceof FetchTaggableObjectsQueryString) {
            str = "4";
        } else if (this.f1702d instanceof FetchTaggableSuggestionsAtPlaceQueryString) {
            str = "3";
        } else {
            str = "typeahead_session_id";
        }
        arrayList.add(str);
        if (this.f1702d instanceof FetchTaggableObjectsQueryString) {
            str = "5";
        } else if (this.f1702d instanceof FetchTaggableSuggestionsAtPlaceQueryString) {
            str = "4";
        } else {
            str = "request_id";
        }
        arrayList.add(str);
        return keyFactory.a(this.f1702d, cls, this.f1701c, arrayList);
    }
}
