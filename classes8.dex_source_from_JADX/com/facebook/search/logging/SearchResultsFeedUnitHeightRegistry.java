package com.facebook.search.logging;

import android.view.View;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.search.model.SearchResultsRequestType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: The log tag cannot be null or empty. */
public class SearchResultsFeedUnitHeightRegistry implements JsonSerializable {
    private SearchResultsRequestType f21943a;
    private ImmutableList<GraphQLGraphSearchResultsDisplayStyle> f21944b;
    private GraphQLGraphSearchResultRole f21945c;
    private final Map<FeedUnit, SearchResultsFeedUnitHeightData> f21946d = new HashMap();
    private int f21947e;

    /* compiled from: The log tag cannot be null or empty. */
    public class SearchResultsFeedUnitHeightData implements JsonSerializable {
        public Map<View, Integer> f21942a = new HashMap();

        public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.d();
            for (Entry entry : this.f21942a.entrySet()) {
                jsonGenerator.f();
                jsonGenerator.a("view", ((View) entry.getKey()).getClass().getSimpleName());
                jsonGenerator.a("height", ((Integer) entry.getValue()).intValue());
                jsonGenerator.g();
            }
            jsonGenerator.e();
        }

        public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
            throw new UnsupportedOperationException("Serialization infrastructure does not support type serialization.");
        }
    }

    public SearchResultsFeedUnitHeightRegistry(SearchResultsRequestType searchResultsRequestType, ImmutableList<GraphQLGraphSearchResultsDisplayStyle> immutableList, GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, int i) {
        this.f21944b = immutableList;
        this.f21945c = graphQLGraphSearchResultRole;
        this.f21943a = searchResultsRequestType;
        this.f21947e = i;
    }

    public final SearchResultsFeedUnitHeightData m25455a(FeedUnit feedUnit) {
        if (this.f21946d.containsKey(feedUnit)) {
            return (SearchResultsFeedUnitHeightData) this.f21946d.get(feedUnit);
        }
        SearchResultsFeedUnitHeightData searchResultsFeedUnitHeightData = new SearchResultsFeedUnitHeightData();
        this.f21946d.put(feedUnit, searchResultsFeedUnitHeightData);
        return searchResultsFeedUnitHeightData;
    }

    public final void m25456a(FeedUnit feedUnit, View view, int i) {
        SearchResultsFeedUnitHeightData searchResultsFeedUnitHeightData = (SearchResultsFeedUnitHeightData) this.f21946d.get(feedUnit);
        searchResultsFeedUnitHeightData.f21942a.put(view, Integer.valueOf(i));
    }

    public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        jsonGenerator.a("count", this.f21947e);
        jsonGenerator.a("request", this.f21943a.toString());
        jsonGenerator.a("role", this.f21945c.toString());
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        int size = this.f21944b.size();
        for (int i = 0; i < size; i++) {
            GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle = (GraphQLGraphSearchResultsDisplayStyle) this.f21944b.get(i);
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(',');
            }
            stringBuilder.append(graphQLGraphSearchResultsDisplayStyle.toString());
        }
        jsonGenerator.a("style", stringBuilder.toString());
        jsonGenerator.f("units");
        for (Entry entry : this.f21946d.entrySet()) {
            jsonGenerator.f();
            jsonGenerator.a("feedUnit", ((FeedUnit) entry.getKey()).getClass().getSimpleName());
            jsonGenerator.a("views", entry.getValue());
            jsonGenerator.g();
        }
        jsonGenerator.e();
        jsonGenerator.g();
    }

    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        throw new UnsupportedOperationException("Serialization infrastructure does not support type serialization.");
    }
}
