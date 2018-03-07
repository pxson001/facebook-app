package com.facebook.graphql.querybuilder.common;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: editCommentParams */
public final class CommonGraphQLModels$DefaultImageFieldsModel$Builder {
    public int f4870a;
    @Nullable
    public String f4871b;
    public int f4872c;

    public final DefaultImageFieldsModel m9716a() {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int b = flatBufferBuilder.b(this.f4871b);
        flatBufferBuilder.c(3);
        flatBufferBuilder.a(0, this.f4870a, 0);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.a(2, this.f4872c, 0);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new DefaultImageFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }
}
