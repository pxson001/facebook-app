package com.facebook.pages.adminedpages.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLModels.AdminedPagesPrefetchQueryModel;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLModels.AdminedPagesPrefetchQueryModel.AdminedPagesModel;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: currentEntityId must be in initialEntityIds */
public final class C1787x3a3de683 {
    @Nullable
    public AdminedPagesModel f16548a;

    public final C1787x3a3de683 m19517a(@Nullable AdminedPagesModel adminedPagesModel) {
        this.f16548a = adminedPagesModel;
        return this;
    }

    public final AdminedPagesPrefetchQueryModel m19518a() {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = ModelHelper.a(flatBufferBuilder, this.f16548a);
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new AdminedPagesPrefetchQueryModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }
}
