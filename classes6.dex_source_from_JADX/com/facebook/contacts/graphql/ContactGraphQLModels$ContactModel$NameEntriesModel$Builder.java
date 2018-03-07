package com.facebook.contacts.graphql;

import com.facebook.contacts.graphql.ContactGraphQLModels.ContactModel.NameEntriesModel;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.ModelHelper;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: photo_ */
public final class ContactGraphQLModels$ContactModel$NameEntriesModel$Builder {
    @Nullable
    public C0498x332b405b f8168a;

    public final NameEntriesModel m11798a() {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = ModelHelper.a(flatBufferBuilder, this.f8168a);
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new NameEntriesModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }
}
