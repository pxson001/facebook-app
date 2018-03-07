package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: ViewGroups that have less than two children are often unnecessary. Merge the important properties to neighboring Views and remove this ViewGroup. */
public final class GraphQLPrivacyEducationInfo__JsonHelper {
    public static GraphQLPrivacyEducationInfo m20987a(JsonParser jsonParser) {
        GraphQLPrivacyEducationInfo graphQLPrivacyEducationInfo = new GraphQLPrivacyEducationInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLGroupMallAdsEducationInfo graphQLGroupMallAdsEducationInfo = null;
            if ("fullindex_education_info".equals(i)) {
                GraphQLFullIndexEducationInfo a;
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    a = GraphQLFullIndexEducationInfo__JsonHelper.m7662a(FieldAccessQueryTracker.a(jsonParser, "fullindex_education_info"));
                }
                graphQLPrivacyEducationInfo.d = a;
                FieldAccessQueryTracker.a(jsonParser, graphQLPrivacyEducationInfo, "fullindex_education_info", graphQLPrivacyEducationInfo.a_, 0, true);
            } else if ("post_edit_upsell_privacy".equals(i)) {
                GraphQLPrivacyOption a2;
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    a2 = GraphQLPrivacyOption__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "post_edit_upsell_privacy"));
                }
                graphQLPrivacyEducationInfo.e = a2;
                FieldAccessQueryTracker.a(jsonParser, graphQLPrivacyEducationInfo, "post_edit_upsell_privacy", graphQLPrivacyEducationInfo.a_, 1, true);
            } else if ("reshare_education_info".equals(i)) {
                GraphQLReshareEducationInfo a3;
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    a3 = GraphQLReshareEducationInfo__JsonHelper.m21496a(FieldAccessQueryTracker.a(jsonParser, "reshare_education_info"));
                }
                graphQLPrivacyEducationInfo.f = a3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPrivacyEducationInfo, "reshare_education_info", graphQLPrivacyEducationInfo.a_, 2, true);
            } else if ("tag_expansion_education".equals(i)) {
                GraphQLTagExpansionEducationInfo a4;
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    a4 = GraphQLTagExpansionEducationInfo__JsonHelper.m22036a(FieldAccessQueryTracker.a(jsonParser, "tag_expansion_education"));
                }
                graphQLPrivacyEducationInfo.g = a4;
                FieldAccessQueryTracker.a(jsonParser, graphQLPrivacyEducationInfo, "tag_expansion_education", graphQLPrivacyEducationInfo.a_, 3, true);
            } else if ("group_mall_ads_education_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLGroupMallAdsEducationInfo = GraphQLGroupMallAdsEducationInfo__JsonHelper.m8436a(FieldAccessQueryTracker.a(jsonParser, "group_mall_ads_education_info"));
                }
                graphQLPrivacyEducationInfo.h = graphQLGroupMallAdsEducationInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLPrivacyEducationInfo, "group_mall_ads_education_info", graphQLPrivacyEducationInfo.a_, 4, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLPrivacyEducationInfo;
    }

    public static void m20988a(JsonGenerator jsonGenerator, GraphQLPrivacyEducationInfo graphQLPrivacyEducationInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPrivacyEducationInfo.a() != null) {
            jsonGenerator.a("fullindex_education_info");
            GraphQLFullIndexEducationInfo__JsonHelper.m7663a(jsonGenerator, graphQLPrivacyEducationInfo.a(), true);
        }
        if (graphQLPrivacyEducationInfo.j() != null) {
            jsonGenerator.a("post_edit_upsell_privacy");
            GraphQLPrivacyOption__JsonHelper.a(jsonGenerator, graphQLPrivacyEducationInfo.j(), true);
        }
        if (graphQLPrivacyEducationInfo.k() != null) {
            jsonGenerator.a("reshare_education_info");
            GraphQLReshareEducationInfo__JsonHelper.m21497a(jsonGenerator, graphQLPrivacyEducationInfo.k(), true);
        }
        if (graphQLPrivacyEducationInfo.l() != null) {
            jsonGenerator.a("tag_expansion_education");
            GraphQLTagExpansionEducationInfo__JsonHelper.m22037a(jsonGenerator, graphQLPrivacyEducationInfo.l(), true);
        }
        if (graphQLPrivacyEducationInfo.m() != null) {
            jsonGenerator.a("group_mall_ads_education_info");
            GraphQLGroupMallAdsEducationInfo__JsonHelper.m8437a(jsonGenerator, graphQLPrivacyEducationInfo.m(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
