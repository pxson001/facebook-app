package com.facebook.spherical.photo;

import com.facebook.graphql.model.GraphQLPhotoEncoding;
import com.facebook.graphql.model.GraphQLPhotosphereMetadata;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.google.common.collect.ImmutableList;

/* compiled from: error_io */
public class PartialPanoUtil {

    /* compiled from: error_io */
    public class PanoBounds {
        public final float f16219a;
        public final float f16220b;
        public final float f16221c;
        public final float f16222d;

        public PanoBounds(float f, float f2, float f3, float f4) {
            this.f16219a = f;
            this.f16220b = f2;
            this.f16221c = f3;
            this.f16222d = f4;
        }
    }

    public static PanoBounds m23772a(GraphQLStoryAttachment graphQLStoryAttachment) {
        ImmutableList aI = graphQLStoryAttachment.r().aI();
        int size = aI.size();
        for (int i = 0; i < size; i++) {
            GraphQLPhotoEncoding graphQLPhotoEncoding = (GraphQLPhotoEncoding) aI.get(i);
            if ("cubestrip".equals(graphQLPhotoEncoding.l())) {
                GraphQLPhotosphereMetadata m = graphQLPhotoEncoding.m();
                float j = (float) m.j();
                float a = (float) m.a();
                j = (((j / 2.0f) - ((float) m.q())) * 360.0f) / j;
                a = (((a / 2.0f) - ((float) m.r())) * 180.0f) / a;
                return new PanoBounds(j, ((((float) m.l()) / j) * 360.0f) - j, a, ((((float) m.k()) / a) * 180.0f) - a);
            }
        }
        return null;
    }
}
