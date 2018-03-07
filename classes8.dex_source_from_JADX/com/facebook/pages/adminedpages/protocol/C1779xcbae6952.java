package com.facebook.pages.adminedpages.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLModels.AdminedPagesPrefetchQueryModel.AdminedPagesModel;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLModels.AdminedPagesPrefetchQueryModel.AdminedPagesModel.NodesModel;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: currentEntityId must be in initialEntityIds */
public final class C1779xcbae6952 {
    public int f16537a;
    @Nullable
    public ImmutableList<NodesModel> f16538b;

    public final C1779xcbae6952 m19488a(int i) {
        this.f16537a = i;
        return this;
    }

    public final C1779xcbae6952 m19489a(@Nullable ImmutableList<NodesModel> immutableList) {
        this.f16538b = immutableList;
        return this;
    }

    public final AdminedPagesModel m19490a() {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = ModelHelper.a(flatBufferBuilder, this.f16538b);
        flatBufferBuilder.c(2);
        flatBufferBuilder.a(0, this.f16537a, 0);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new AdminedPagesModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }
}
