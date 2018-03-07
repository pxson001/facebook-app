package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLTimelineAppCollectionItemType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: UNKNOWN_ERROR */
public final class GraphQLTimelineAppCollectionItem__JsonHelper {
    public static boolean m22151a(GraphQLTimelineAppCollectionItem graphQLTimelineAppCollectionItem, String str, JsonParser jsonParser) {
        String str2 = null;
        GraphQLTextWithEntities a;
        if ("attribution_text".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "attribution_text"));
            }
            graphQLTimelineAppCollectionItem.f13303d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionItem, "attribution_text", graphQLTimelineAppCollectionItem.a_, 0, true);
            return true;
        } else if ("collection_item_type".equals(str)) {
            graphQLTimelineAppCollectionItem.f13304e = GraphQLTimelineAppCollectionItemType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionItem, "collection_item_type", graphQLTimelineAppCollectionItem.B_(), 1, false);
            return true;
        } else if ("creation_time".equals(str)) {
            graphQLTimelineAppCollectionItem.f13305f = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionItem, "creation_time", graphQLTimelineAppCollectionItem.B_(), 2, false);
            return true;
        } else if ("feedback".equals(str)) {
            GraphQLFeedback a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLFeedback__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback"));
            }
            graphQLTimelineAppCollectionItem.f13306g = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionItem, "feedback", graphQLTimelineAppCollectionItem.B_(), 3, true);
            return true;
        } else if ("global_share".equals(str)) {
            GraphQLExternalUrl a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLExternalUrl__JsonHelper.m7429a(FieldAccessQueryTracker.a(jsonParser, "global_share"));
            }
            graphQLTimelineAppCollectionItem.f13307h = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionItem, "global_share", graphQLTimelineAppCollectionItem.B_(), 4, true);
            return true;
        } else if ("icon_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "icon_image"));
            }
            graphQLTimelineAppCollectionItem.f13308i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionItem, "icon_image", graphQLTimelineAppCollectionItem.B_(), 6, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTimelineAppCollectionItem.f13309j = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionItem, "id", graphQLTimelineAppCollectionItem.B_(), 7, false);
            return true;
        } else if ("image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "image"));
            }
            graphQLTimelineAppCollectionItem.f13310k = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionItem, "image", graphQLTimelineAppCollectionItem.B_(), 8, true);
            return true;
        } else if ("listImage".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "listImage"));
            }
            graphQLTimelineAppCollectionItem.f13311l = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionItem, "listImage", graphQLTimelineAppCollectionItem.B_(), 9, true);
            return true;
        } else if ("node".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLNode__JsonHelper.m9292a(FieldAccessQueryTracker.a(jsonParser, "node"));
            }
            graphQLTimelineAppCollectionItem.f13312m = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionItem, "node", graphQLTimelineAppCollectionItem.B_(), 10, true);
            return true;
        } else if ("permalink_node".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLNode__JsonHelper.m9292a(FieldAccessQueryTracker.a(jsonParser, "permalink_node"));
            }
            graphQLTimelineAppCollectionItem.f13313n = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionItem, "permalink_node", graphQLTimelineAppCollectionItem.B_(), 11, true);
            return true;
        } else if ("privacy_scope".equals(str)) {
            GraphQLPrivacyScope a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLPrivacyScope__JsonHelper.m21033a(FieldAccessQueryTracker.a(jsonParser, "privacy_scope"));
            }
            graphQLTimelineAppCollectionItem.f13314o = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionItem, "privacy_scope", graphQLTimelineAppCollectionItem.B_(), 12, true);
            return true;
        } else if ("profileImageLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageLarge"));
            }
            graphQLTimelineAppCollectionItem.f13315p = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionItem, "profileImageLarge", graphQLTimelineAppCollectionItem.B_(), 13, true);
            return true;
        } else if ("profileImageSmall".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageSmall"));
            }
            graphQLTimelineAppCollectionItem.f13316q = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionItem, "profileImageSmall", graphQLTimelineAppCollectionItem.B_(), 14, true);
            return true;
        } else if ("rating".equals(str)) {
            GraphQLRating a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLRating__JsonHelper.m21310a(FieldAccessQueryTracker.a(jsonParser, "rating"));
            }
            graphQLTimelineAppCollectionItem.f13317r = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionItem, "rating", graphQLTimelineAppCollectionItem.B_(), 15, true);
            return true;
        } else if ("source_object".equals(str)) {
            FeedUnit a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = FeedUnitDeserializer.m6329a(FieldAccessQueryTracker.a(jsonParser, "source_object"));
            }
            graphQLTimelineAppCollectionItem.f13318s = a6;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionItem, "source_object", graphQLTimelineAppCollectionItem.B_(), 17, true);
            return true;
        } else if ("subtitle_text".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "subtitle_text"));
            }
            graphQLTimelineAppCollectionItem.f13319t = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionItem, "subtitle_text", graphQLTimelineAppCollectionItem.B_(), 18, true);
            return true;
        } else if ("tableImage".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "tableImage"));
            }
            graphQLTimelineAppCollectionItem.f13320u = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionItem, "tableImage", graphQLTimelineAppCollectionItem.B_(), 19, true);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLTimelineAppCollectionItem.f13321v = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionItem, "title", graphQLTimelineAppCollectionItem.B_(), 20, true);
            return true;
        } else if ("titleForSummary".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "titleForSummary"));
            }
            graphQLTimelineAppCollectionItem.f13322w = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionItem, "titleForSummary", graphQLTimelineAppCollectionItem.B_(), 21, true);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTimelineAppCollectionItem.f13323x = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionItem, "url", graphQLTimelineAppCollectionItem.B_(), 22, false);
            return true;
        } else if (!"locally_updated_containing_collection_id".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTimelineAppCollectionItem.f13324y = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionItem, "locally_updated_containing_collection_id", graphQLTimelineAppCollectionItem.B_(), 23, false);
            return true;
        }
    }
}
