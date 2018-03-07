package com.facebook.heisman.protocol.conversion;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLImageOverlay;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import java.nio.ByteBuffer;

/* compiled from: platformads/ */
public final class ImageOverlayConversionHelper {
    public static ImageOverlayFieldsModel m8017a(GraphQLImageOverlay graphQLImageOverlay) {
        if (graphQLImageOverlay == null) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int i = 0;
        if (graphQLImageOverlay != null) {
            int a = flatBufferBuilder.a(graphQLImageOverlay.j());
            int b = flatBufferBuilder.b(graphQLImageOverlay.l());
            GraphQLImage m = graphQLImageOverlay.m();
            int i2 = 0;
            if (m != null) {
                int b2 = flatBufferBuilder.b(m.b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b2);
                i2 = flatBufferBuilder.d();
                flatBufferBuilder.d(i2);
            }
            int i3 = i2;
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, i3);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i4 = i;
        if (i4 == 0) {
            return null;
        }
        flatBufferBuilder.d(i4);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new ImageOverlayFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }
}
