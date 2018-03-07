package com.facebook.feed.rows.sections.attachments;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.ImageUtil;

/* compiled from: ZZZZI */
public class ImageShareUtil {
    private static final CallerContext f20608a = CallerContext.a(ImageShareUtil.class, "newsfeed_image_share_view", "static_image", "native_newsfeed");

    public static GraphQLImage m23646a(GraphQLStoryAttachment graphQLStoryAttachment) {
        GraphQLMedia r = graphQLStoryAttachment.r();
        return r != null ? r.T() : null;
    }

    public static float m23644a(GraphQLImage graphQLImage) {
        if (graphQLImage.a() == 0) {
            return 1.3333334f;
        }
        float c = ((float) graphQLImage.c()) / ((float) graphQLImage.a());
        if (c > 2.0f) {
            return 2.0f;
        }
        if (c < 0.6666667f) {
            return 0.6666667f;
        }
        return c;
    }

    public static DraweeController m23645a(FbDraweeControllerBuilder fbDraweeControllerBuilder, GraphQLImage graphQLImage) {
        return fbDraweeControllerBuilder.p().a(f20608a).b(ImageUtil.a(graphQLImage)).r().s();
    }

    public static GraphQLImage m23647b(GraphQLStoryAttachment graphQLStoryAttachment) {
        return graphQLStoryAttachment.r().m();
    }
}
