package com.facebook.events.widget.eventcard;

import com.facebook.common.util.StringUtil;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLStreetAddress;
import javax.annotation.Nullable;

/* compiled from: opispx_initial_sub_codec */
public class EventAttachmentUtil {
    private EventAttachmentUtil() {
    }

    @Nullable
    public static String m6502a(GraphQLNode graphQLNode) {
        return graphQLNode.hu() != null ? graphQLNode.hu().a() : null;
    }

    public static String m6503a(@Nullable GraphQLPlace graphQLPlace) {
        if (graphQLPlace != null) {
            if (graphQLPlace.r() != null) {
                return graphQLPlace.r();
            }
            if (graphQLPlace.B() != null) {
                return graphQLPlace.B();
            }
            GraphQLStreetAddress k = graphQLPlace.k();
            if (!(k == null || StringUtil.a(k.m()))) {
                return k.m();
            }
        }
        return null;
    }

    public static String m6504b(@Nullable GraphQLPlace graphQLPlace) {
        if (graphQLPlace == null || graphQLPlace.q() == null) {
            return null;
        }
        return graphQLPlace.q().L();
    }
}
