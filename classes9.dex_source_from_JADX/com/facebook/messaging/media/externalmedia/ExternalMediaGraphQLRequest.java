package com.facebook.messaging.media.externalmedia;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: mCountry */
public class ExternalMediaGraphQLRequest {
    public final QueryType f11598a;
    public final String f11599b;
    public final ImmutableList<ResultType> f11600c;
    public final GroupByType f11601d;
    public final int f11602e;
    public final ImmutableList<MediaParams> f11603f;
    public final ImmutableList<MediaParams> f11604g;
    public final ImmutableList<AppFbidFilter> f11605h;

    /* compiled from: mCountry */
    public enum AppFbidFilter {
        INTERNAL_STICKERS("237759909591655");
        
        public final String value;

        private AppFbidFilter(String str) {
            this.value = str;
        }

        public static ArrayNode toJsonNode(List<AppFbidFilter> list) {
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            for (AppFbidFilter appFbidFilter : list) {
                arrayNode.h(appFbidFilter.value);
            }
            return arrayNode;
        }
    }

    /* compiled from: mCountry */
    public enum GroupByType {
        UNGROUPED("UNGROUPED"),
        RESULT_TYPE("RESULT_TYPE"),
        PLATFORM_FBID("PLATFORM_FBID");
        
        public final String jsonValue;

        private GroupByType(String str) {
            this.jsonValue = str;
        }
    }

    /* compiled from: mCountry */
    public enum QueryType {
        SEARCH("SEARCH"),
        MEDIAFY("MEDIAFY"),
        TRENDING("TRENDING"),
        SAMPLE("SAMPLE");
        
        public final String jsonValue;

        private QueryType(String str) {
            this.jsonValue = str;
        }
    }

    /* compiled from: mCountry */
    public enum ResultType {
        PHOTO("PHOTO"),
        ANIMATION("ANIMATION"),
        VIDEO("VIDEO"),
        STICKER("STICKER");
        
        public final String jsonValue;

        private ResultType(String str) {
            this.jsonValue = str;
        }

        public static ArrayNode toJsonNode(ImmutableList<ResultType> immutableList) {
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                arrayNode.h(((ResultType) immutableList.get(i)).jsonValue);
            }
            return arrayNode;
        }
    }

    public ExternalMediaGraphQLRequest(QueryType queryType, String str, ImmutableList<ResultType> immutableList, GroupByType groupByType, int i, ImmutableList<MediaParams> immutableList2, ImmutableList<MediaParams> immutableList3, @Nullable ImmutableList<AppFbidFilter> immutableList4) {
        this.f11598a = queryType;
        this.f11599b = str;
        this.f11600c = immutableList;
        this.f11601d = groupByType;
        this.f11602e = i;
        this.f11603f = immutableList2;
        this.f11604g = immutableList3;
        this.f11605h = immutableList4;
    }
}
