package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLAudioAnnotationPlayMode;
import com.facebook.graphql.enums.GraphQLDocumentElementMarginStyle;
import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.graphql.enums.GraphQLDocumentFeedbackOptions;
import com.facebook.graphql.enums.GraphQLDocumentListStyle;
import com.facebook.graphql.enums.GraphQLDocumentMapStyle;
import com.facebook.graphql.enums.GraphQLDocumentMediaPresentationStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoAutoplayStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoControlStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoLoopingStyle;
import com.facebook.graphql.enums.GraphQLDocumentWebviewPresentationStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: ios_page_header_remove_action_button */
public final class GraphQLDocumentElement__JsonHelper {
    public static GraphQLDocumentElement m6954a(JsonParser jsonParser) {
        GraphQLDocumentElement graphQLDocumentElement = new GraphQLDocumentElement();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
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
                graphQLDocumentElement.d = graphQLObjectType;
                FieldAccessQueryTracker.a(jsonParser, graphQLDocumentElement, "__type__", graphQLDocumentElement.a_, 0, false);
            } else if ("audio_play_mode".equals(i)) {
                graphQLDocumentElement.e = GraphQLAudioAnnotationPlayMode.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLDocumentElement, "audio_play_mode", graphQLDocumentElement.a_, 1, false);
            } else if ("audio_url".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLDocumentElement.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLDocumentElement, "audio_url", graphQLDocumentElement.a_, 2, false);
            } else if ("base_url".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLDocumentElement.g = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLDocumentElement, "base_url", graphQLDocumentElement.a_, 3, false);
            } else if ("block_title".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLDocumentElement.h = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLDocumentElement, "block_title", graphQLDocumentElement.a_, 4, false);
            } else if ("display_height".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLDocumentElement.i = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLDocumentElement, "display_height", graphQLDocumentElement.a_, 6, false);
            } else if ("display_width".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLDocumentElement.j = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLDocumentElement, "display_width", graphQLDocumentElement.a_, 7, false);
            } else if ("document_element_type".equals(i)) {
                graphQLDocumentElement.k = GraphQLDocumentElementType.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLDocumentElement, "document_element_type", graphQLDocumentElement.a_, 8, false);
            } else if ("element_video".equals(i)) {
                GraphQLVideo graphQLVideo;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLVideo = null;
                } else {
                    graphQLVideo = GraphQLVideo__JsonHelper.m22483a(FieldAccessQueryTracker.a(jsonParser, "element_video"));
                }
                graphQLDocumentElement.l = graphQLVideo;
                FieldAccessQueryTracker.a(jsonParser, graphQLDocumentElement, "element_video", graphQLDocumentElement.a_, 9, true);
            } else if ("enable_ad_network_bridging".equals(i)) {
                boolean z;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLDocumentElement.m = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLDocumentElement, "enable_ad_network_bridging", graphQLDocumentElement.a_, 11, false);
            } else if ("feedback".equals(i)) {
                GraphQLFeedback graphQLFeedback;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLFeedback = null;
                } else {
                    graphQLFeedback = GraphQLFeedback__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback"));
                }
                graphQLDocumentElement.n = graphQLFeedback;
                FieldAccessQueryTracker.a(jsonParser, graphQLDocumentElement, "feedback", graphQLDocumentElement.a_, 12, true);
            } else if ("feedback_options".equals(i)) {
                graphQLDocumentElement.o = GraphQLDocumentFeedbackOptions.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLDocumentElement, "feedback_options", graphQLDocumentElement.a_, 13, false);
            } else if ("html_source".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLDocumentElement.p = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLDocumentElement, "html_source", graphQLDocumentElement.a_, 14, false);
            } else if ("id".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLDocumentElement.q = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLDocumentElement, "id", graphQLDocumentElement.a_, 15, false);
            } else if ("list_style".equals(i)) {
                graphQLDocumentElement.r = GraphQLDocumentListStyle.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLDocumentElement, "list_style", graphQLDocumentElement.a_, 16, false);
            } else if ("map_style".equals(i)) {
                graphQLDocumentElement.s = GraphQLDocumentMapStyle.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLDocumentElement, "map_style", graphQLDocumentElement.a_, 17, false);
            } else if ("margin_style".equals(i)) {
                graphQLDocumentElement.t = GraphQLDocumentElementMarginStyle.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLDocumentElement, "margin_style", graphQLDocumentElement.a_, 18, false);
            } else if ("photo".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "photo"));
                }
                graphQLDocumentElement.u = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLDocumentElement, "photo", graphQLDocumentElement.a_, 19, true);
            } else if ("poster_image".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "poster_image"));
                }
                graphQLDocumentElement.v = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLDocumentElement, "poster_image", graphQLDocumentElement.a_, 20, true);
            } else if ("presentation_state".equals(i)) {
                graphQLDocumentElement.w = GraphQLDocumentMediaPresentationStyle.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLDocumentElement, "presentation_state", graphQLDocumentElement.a_, 21, false);
            } else if ("text_background_color".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLDocumentElement.x = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLDocumentElement, "text_background_color", graphQLDocumentElement.a_, 22, false);
            } else if ("video_autoplay_style".equals(i)) {
                graphQLDocumentElement.y = GraphQLDocumentVideoAutoplayStyle.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLDocumentElement, "video_autoplay_style", graphQLDocumentElement.a_, 23, false);
            } else if ("video_control_style".equals(i)) {
                graphQLDocumentElement.z = GraphQLDocumentVideoControlStyle.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLDocumentElement, "video_control_style", graphQLDocumentElement.a_, 24, false);
            } else if ("video_looping_style".equals(i)) {
                graphQLDocumentElement.A = GraphQLDocumentVideoLoopingStyle.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLDocumentElement, "video_looping_style", graphQLDocumentElement.a_, 25, false);
            } else if ("webview_presentation_style".equals(i)) {
                graphQLDocumentElement.B = GraphQLDocumentWebviewPresentationStyle.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLDocumentElement, "webview_presentation_style", graphQLDocumentElement.a_, 26, false);
            }
            jsonParser.f();
        }
        return graphQLDocumentElement;
    }

    public static void m6955a(JsonGenerator jsonGenerator, GraphQLDocumentElement graphQLDocumentElement, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLDocumentElement.j() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLDocumentElement.j().e());
            jsonGenerator.g();
        }
        if (graphQLDocumentElement.k() != null) {
            jsonGenerator.a("audio_play_mode", graphQLDocumentElement.k().toString());
        }
        if (graphQLDocumentElement.l() != null) {
            jsonGenerator.a("audio_url", graphQLDocumentElement.l());
        }
        if (graphQLDocumentElement.m() != null) {
            jsonGenerator.a("base_url", graphQLDocumentElement.m());
        }
        if (graphQLDocumentElement.n() != null) {
            jsonGenerator.a("block_title", graphQLDocumentElement.n());
        }
        jsonGenerator.a("display_height", graphQLDocumentElement.o());
        jsonGenerator.a("display_width", graphQLDocumentElement.p());
        if (graphQLDocumentElement.q() != null) {
            jsonGenerator.a("document_element_type", graphQLDocumentElement.q().toString());
        }
        if (graphQLDocumentElement.r() != null) {
            jsonGenerator.a("element_video");
            GraphQLVideo__JsonHelper.m22484a(jsonGenerator, graphQLDocumentElement.r(), true);
        }
        jsonGenerator.a("enable_ad_network_bridging", graphQLDocumentElement.s());
        if (graphQLDocumentElement.t() != null) {
            jsonGenerator.a("feedback");
            GraphQLFeedback__JsonHelper.a(jsonGenerator, graphQLDocumentElement.t(), true);
        }
        if (graphQLDocumentElement.u() != null) {
            jsonGenerator.a("feedback_options", graphQLDocumentElement.u().toString());
        }
        if (graphQLDocumentElement.v() != null) {
            jsonGenerator.a("html_source", graphQLDocumentElement.v());
        }
        if (graphQLDocumentElement.w() != null) {
            jsonGenerator.a("id", graphQLDocumentElement.w());
        }
        if (graphQLDocumentElement.x() != null) {
            jsonGenerator.a("list_style", graphQLDocumentElement.x().toString());
        }
        if (graphQLDocumentElement.y() != null) {
            jsonGenerator.a("map_style", graphQLDocumentElement.y().toString());
        }
        if (graphQLDocumentElement.z() != null) {
            jsonGenerator.a("margin_style", graphQLDocumentElement.z().toString());
        }
        if (graphQLDocumentElement.A() != null) {
            jsonGenerator.a("photo");
            GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLDocumentElement.A(), true);
        }
        if (graphQLDocumentElement.B() != null) {
            jsonGenerator.a("poster_image");
            GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLDocumentElement.B(), true);
        }
        if (graphQLDocumentElement.C() != null) {
            jsonGenerator.a("presentation_state", graphQLDocumentElement.C().toString());
        }
        if (graphQLDocumentElement.D() != null) {
            jsonGenerator.a("text_background_color", graphQLDocumentElement.D());
        }
        if (graphQLDocumentElement.E() != null) {
            jsonGenerator.a("video_autoplay_style", graphQLDocumentElement.E().toString());
        }
        if (graphQLDocumentElement.F() != null) {
            jsonGenerator.a("video_control_style", graphQLDocumentElement.F().toString());
        }
        if (graphQLDocumentElement.G() != null) {
            jsonGenerator.a("video_looping_style", graphQLDocumentElement.G().toString());
        }
        if (graphQLDocumentElement.H() != null) {
            jsonGenerator.a("webview_presentation_style", graphQLDocumentElement.H().toString());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
