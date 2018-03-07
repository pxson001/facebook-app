package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_nux */
public class GraphQLFundraiserToCharityDeserializer extends FbJsonDeserializer {
    public Object m7749a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLFundraiserToCharity graphQLFundraiserToCharity = new GraphQLFundraiserToCharity();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLFundraiserToCharity = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("__type__".equals(i)) {
                    GraphQLObjectType graphQLObjectType;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLObjectType = null;
                    } else {
                        graphQLObjectType = GraphQLObjectType.a(jsonParser);
                    }
                    graphQLFundraiserToCharity.f3832d = graphQLObjectType;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserToCharity, "__type__", graphQLFundraiserToCharity.a_, 0, false);
                } else if ("campaign_title".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLFundraiserToCharity.f3833e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserToCharity, "campaign_title", graphQLFundraiserToCharity.a_, 1, false);
                } else if ("fundraiser_for_charity_text".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "fundraiser_for_charity_text"));
                    }
                    graphQLFundraiserToCharity.f3834f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserToCharity, "fundraiser_for_charity_text", graphQLFundraiserToCharity.a_, 2, true);
                } else if ("id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLFundraiserToCharity.f3835g = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserToCharity, "id", graphQLFundraiserToCharity.a_, 3, false);
                } else if ("logo_image".equals(i)) {
                    GraphQLImage graphQLImage;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLImage = null;
                    } else {
                        graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "logo_image"));
                    }
                    graphQLFundraiserToCharity.f3836h = graphQLImage;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserToCharity, "logo_image", graphQLFundraiserToCharity.a_, 4, true);
                } else if ("mobile_donate_url".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLFundraiserToCharity.f3837i = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserToCharity, "mobile_donate_url", graphQLFundraiserToCharity.a_, 5, false);
                } else if ("charity".equals(i)) {
                    GraphQLFundraiserCharity graphQLFundraiserCharity;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLFundraiserCharity = null;
                    } else {
                        graphQLFundraiserCharity = GraphQLFundraiserCharity__JsonHelper.m7675a(FieldAccessQueryTracker.a(jsonParser, "charity"));
                    }
                    graphQLFundraiserToCharity.f3838j = graphQLFundraiserCharity;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserToCharity, "charity", graphQLFundraiserToCharity.a_, 6, true);
                } else if ("can_invite_to_campaign".equals(i)) {
                    boolean z;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        z = false;
                    } else {
                        z = jsonParser.H();
                    }
                    graphQLFundraiserToCharity.f3839k = z;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserToCharity, "can_invite_to_campaign", graphQLFundraiserToCharity.a_, 7, false);
                } else if ("fundraiser_page_subtitle".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "fundraiser_page_subtitle"));
                    }
                    graphQLFundraiserToCharity.f3840l = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserToCharity, "fundraiser_page_subtitle", graphQLFundraiserToCharity.a_, 8, true);
                } else if ("owner".equals(i)) {
                    GraphQLActor graphQLActor;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLActor = null;
                    } else {
                        graphQLActor = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "owner"));
                    }
                    graphQLFundraiserToCharity.f3841m = graphQLActor;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserToCharity, "owner", graphQLFundraiserToCharity.a_, 13, true);
                } else if ("fundraiser_detailed_progress_text".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "fundraiser_detailed_progress_text"));
                    }
                    graphQLFundraiserToCharity.f3842n = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserToCharity, "fundraiser_detailed_progress_text", graphQLFundraiserToCharity.a_, 14, true);
                }
                jsonParser.f();
            }
        }
        return graphQLFundraiserToCharity;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFundraiserToCharity.class, new GraphQLFundraiserToCharityDeserializer());
    }

    public GraphQLFundraiserToCharityDeserializer() {
        a(GraphQLFundraiserToCharity.class);
    }
}
