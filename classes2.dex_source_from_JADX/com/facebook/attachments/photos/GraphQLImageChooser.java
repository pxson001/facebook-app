package com.facebook.attachments.photos;

import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;

/* compiled from: high */
public class GraphQLImageChooser {
    public static GraphQLImageChooser m28750a(InjectorLike injectorLike) {
        return new GraphQLImageChooser();
    }

    public static GraphQLImage m28753a(GraphQLMedia graphQLMedia, int i) {
        return m28751a(i, m28751a(i, m28751a(i, graphQLMedia.m24440S(), graphQLMedia.m24446Y()), graphQLMedia.m24447Z()), graphQLMedia.m24441T());
    }

    private static GraphQLImage m28751a(int i, @Nullable GraphQLImage graphQLImage, @Nullable GraphQLImage graphQLImage2) {
        if (graphQLImage == null) {
            return graphQLImage2;
        }
        if (graphQLImage2 == null) {
            return graphQLImage;
        }
        if (graphQLImage.mo2925c() >= i && graphQLImage2.mo2925c() >= i) {
            return m28752a(graphQLImage, graphQLImage2);
        }
        if (graphQLImage.mo2925c() >= i) {
            return graphQLImage;
        }
        return graphQLImage2.mo2925c() < i ? m28754b(graphQLImage, graphQLImage2) : graphQLImage2;
    }

    private static GraphQLImage m28752a(GraphQLImage graphQLImage, GraphQLImage graphQLImage2) {
        return graphQLImage.mo2925c() < graphQLImage2.mo2925c() ? graphQLImage : graphQLImage2;
    }

    private static GraphQLImage m28754b(GraphQLImage graphQLImage, GraphQLImage graphQLImage2) {
        return graphQLImage.mo2925c() > graphQLImage2.mo2925c() ? graphQLImage : graphQLImage2;
    }
}
