package com.facebook.attachments.photos;

import com.facebook.attachments.photos.PhotoAttachmentInfo.Builder;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* compiled from: graph_search_log_selected_suggestion_to_activity_log */
public final class GraphQLMediaRequestHelper {
    static ImageRequest m29770a(GraphQLMedia graphQLMedia, GraphQLImage graphQLImage, Builder builder) {
        return m29771a(graphQLMedia, graphQLImage, builder, null, null);
    }

    public static ImageRequest m29772a(GraphQLMedia graphQLMedia, GraphQLImage graphQLImage, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        return m29771a(graphQLMedia, graphQLImage, null, fbDraweeControllerBuilder, null);
    }

    public static ImageRequest m29771a(GraphQLMedia graphQLMedia, GraphQLImage graphQLImage, Builder builder, FbDraweeControllerBuilder fbDraweeControllerBuilder, Postprocessor postprocessor) {
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(4);
        if (graphQLImage == graphQLMedia.m24440S() || graphQLMedia.m24441T() == null) {
            arrayList2.add(graphQLMedia.m24440S());
        }
        arrayList2.add(graphQLMedia.m24441T());
        arrayList2.add(graphQLMedia.m24447Z());
        arrayList2.add(graphQLMedia.m24446Y());
        if (graphQLImage != arrayList2.get(0)) {
            m29774b(arrayList, graphQLImage, postprocessor);
        }
        int size = arrayList2.size();
        int i = 0;
        ImageRequest imageRequest = null;
        ImageRequest imageRequest2 = null;
        while (i < size) {
            ImageRequest a;
            GraphQLImage graphQLImage2 = (GraphQLImage) arrayList2.get(i);
            if (imageRequest != null && imageRequest2 == null) {
                imageRequest2 = m29769a(graphQLImage2, postprocessor);
            }
            if (graphQLImage2 == graphQLImage) {
                a = m29773a(arrayList, graphQLImage2, postprocessor);
            } else {
                m29774b(arrayList, graphQLImage2, postprocessor);
                a = imageRequest;
            }
            i++;
            imageRequest = a;
        }
        if (imageRequest == null) {
            throw new IllegalArgumentException("desired image was not found in graphql media");
        }
        Object[] objArr = new ImageRequest[arrayList.size()];
        arrayList.toArray(objArr);
        if (fbDraweeControllerBuilder != null) {
            ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) fbDraweeControllerBuilder.m19452c(null)).m19443a(objArr, false)).m19456d(imageRequest2);
        }
        if (builder != null) {
            builder.f21989g = imageRequest;
            Builder builder2 = builder;
            builder2.f21988f = objArr;
            builder2.f21990h = imageRequest2;
        }
        return imageRequest;
    }

    private static void m29774b(ArrayList<ImageRequest> arrayList, @Nullable GraphQLImage graphQLImage, @Nullable Postprocessor postprocessor) {
        ImageRequest a = m29769a(graphQLImage, postprocessor);
        if (a != null) {
            arrayList.add(a);
        }
    }

    @Nullable
    private static ImageRequest m29769a(@Nullable GraphQLImage graphQLImage, @Nullable Postprocessor postprocessor) {
        if (graphQLImage == null || graphQLImage.mo2924b() == null) {
            return null;
        }
        ImageRequestBuilder a = ImageRequestBuilder.m18776a(ImageUtil.m26990a(graphQLImage));
        a.f12718b = RequestLevel.DISK_CACHE;
        a = a;
        a.f12726j = postprocessor;
        return a.m18785m();
    }

    private static ImageRequest m29773a(ArrayList<ImageRequest> arrayList, @Nullable GraphQLImage graphQLImage, @Nullable Postprocessor postprocessor) {
        ImageRequest imageRequest;
        if (graphQLImage == null || graphQLImage.mo2924b() == null) {
            imageRequest = null;
        } else {
            ImageRequestBuilder a = ImageRequestBuilder.m18776a(ImageUtil.m26990a(graphQLImage));
            a.f12718b = RequestLevel.FULL_FETCH;
            a = a;
            a.f12726j = postprocessor;
            imageRequest = a.m18785m();
        }
        ImageRequest imageRequest2 = imageRequest;
        if (imageRequest2 == null) {
            return null;
        }
        arrayList.add(imageRequest2);
        return imageRequest2;
    }
}
