package com.facebook.graphql.querybuilder.common;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultNameFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultNamePartFieldsModel;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: edit_page_dialog */
public final class CommonGraphQL2Models$DefaultNameFieldsModel$Builder {
    @Nullable
    public String f4815a;
    @Nullable
    public ImmutableList<DefaultNamePartFieldsModel> f4816b;
    @Nullable
    public String f4817c;

    public final DefaultNameFieldsModel m9613a() {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int b = flatBufferBuilder.b(this.f4815a);
        int a = ModelHelper.a(flatBufferBuilder, this.f4816b);
        int b2 = flatBufferBuilder.b(this.f4817c);
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, b2);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new DefaultNameFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }
}
