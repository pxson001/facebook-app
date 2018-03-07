package com.facebook.pages.adminedpages.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLModels.AdminedPagesPrefetchQueryModel.AdminedPagesModel.NodesModel;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: currentEntityId must be in initialEntityIds */
public final class C1782x71c57bb8 {
    @Nullable
    public C1781x1fdd1cf f16541a;
    @Nullable
    public String f16542b;
    @Nullable
    public String f16543c;
    @Nullable
    public C1784x8c640db1 f16544d;
    @Nullable
    public ImmutableList<String> f16545e;

    public static C1782x71c57bb8 m19500a(NodesModel nodesModel) {
        C1782x71c57bb8 c1782x71c57bb8 = new C1782x71c57bb8();
        c1782x71c57bb8.f16541a = nodesModel.j();
        c1782x71c57bb8.f16542b = nodesModel.c();
        c1782x71c57bb8.f16543c = nodesModel.d();
        c1782x71c57bb8.f16544d = nodesModel.k();
        c1782x71c57bb8.f16545e = nodesModel.g();
        return c1782x71c57bb8;
    }

    public final C1782x71c57bb8 m19501a(@Nullable C1781x1fdd1cf c1781x1fdd1cf) {
        this.f16541a = c1781x1fdd1cf;
        return this;
    }

    public final C1782x71c57bb8 m19504a(@Nullable String str) {
        this.f16542b = str;
        return this;
    }

    public final C1782x71c57bb8 m19506b(@Nullable String str) {
        this.f16543c = str;
        return this;
    }

    public final C1782x71c57bb8 m19502a(@Nullable C1784x8c640db1 c1784x8c640db1) {
        this.f16544d = c1784x8c640db1;
        return this;
    }

    public final C1782x71c57bb8 m19503a(@Nullable ImmutableList<String> immutableList) {
        this.f16545e = immutableList;
        return this;
    }

    public final NodesModel m19505a() {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = ModelHelper.a(flatBufferBuilder, this.f16541a);
        int b = flatBufferBuilder.b(this.f16542b);
        int b2 = flatBufferBuilder.b(this.f16543c);
        int a2 = ModelHelper.a(flatBufferBuilder, this.f16544d);
        int c = flatBufferBuilder.c(this.f16545e);
        flatBufferBuilder.c(5);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        flatBufferBuilder.b(3, a2);
        flatBufferBuilder.b(4, c);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new NodesModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }
}
