package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fd_info */
public class GraphQLLinkOpenActionLinkSerializer extends JsonSerializer<GraphQLLinkOpenActionLink> {
    public final void m8942a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLLinkOpenActionLink graphQLLinkOpenActionLink = (GraphQLLinkOpenActionLink) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        jsonGenerator.a("can_watch_and_browse", graphQLLinkOpenActionLink.m8925a());
        if (graphQLLinkOpenActionLink.m8926j() != null) {
            jsonGenerator.a("destination_type", graphQLLinkOpenActionLink.m8926j().toString());
        }
        if (graphQLLinkOpenActionLink.m8927k() != null) {
            jsonGenerator.a("link_description", graphQLLinkOpenActionLink.m8927k());
        }
        if (graphQLLinkOpenActionLink.m8928l() != null) {
            jsonGenerator.a("link_display", graphQLLinkOpenActionLink.m8928l());
        }
        if (graphQLLinkOpenActionLink.m8929m() != null) {
            jsonGenerator.a("link_icon_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLLinkOpenActionLink.m8929m(), true);
        }
        if (graphQLLinkOpenActionLink.m8930n() != null) {
            jsonGenerator.a("link_style", graphQLLinkOpenActionLink.m8930n().toString());
        }
        if (graphQLLinkOpenActionLink.m8931o() != null) {
            jsonGenerator.a("link_target_store_data");
            GraphQLLinkTargetStoreData__JsonHelper.m8948a(jsonGenerator, graphQLLinkOpenActionLink.m8931o(), true);
        }
        if (graphQLLinkOpenActionLink.m8932p() != null) {
            jsonGenerator.a("link_title", graphQLLinkOpenActionLink.m8932p());
        }
        if (graphQLLinkOpenActionLink.m8933q() != null) {
            jsonGenerator.a("link_type", graphQLLinkOpenActionLink.m8933q().toString());
        }
        if (graphQLLinkOpenActionLink.m8934r() != null) {
            jsonGenerator.a("link_video_endscreen_icon");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLLinkOpenActionLink.m8934r(), true);
        }
        if (graphQLLinkOpenActionLink.m8935s() != null) {
            jsonGenerator.a("stateful_title", graphQLLinkOpenActionLink.m8935s());
        }
        if (graphQLLinkOpenActionLink.m8936t() != null) {
            jsonGenerator.a("title", graphQLLinkOpenActionLink.m8936t());
        }
        if (graphQLLinkOpenActionLink.m8937u() != null) {
            jsonGenerator.a("url", graphQLLinkOpenActionLink.m8937u());
        }
        jsonGenerator.a("video_annotations");
        if (graphQLLinkOpenActionLink.m8938v() != null) {
            jsonGenerator.d();
            for (GraphQLVideoAnnotation graphQLVideoAnnotation : graphQLLinkOpenActionLink.m8938v()) {
                if (graphQLVideoAnnotation != null) {
                    GraphQLVideoAnnotation__JsonHelper.m22430a(jsonGenerator, graphQLVideoAnnotation, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLLinkOpenActionLink.m8939w() != null) {
            jsonGenerator.a("header_color", graphQLLinkOpenActionLink.m8939w());
        }
        if (graphQLLinkOpenActionLink.m8940x() != null) {
            jsonGenerator.a("logo_uri", graphQLLinkOpenActionLink.m8940x());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLLinkOpenActionLink.class, new GraphQLLinkOpenActionLinkSerializer());
    }
}
