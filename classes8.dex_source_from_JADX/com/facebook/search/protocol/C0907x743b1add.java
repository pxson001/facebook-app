package com.facebook.search.protocol;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.search.protocol.FetchRecentSearchesGraphQLModels.FBRecentSearchesQueryModel.RecentSearchesModel.EdgesModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: network_operation */
public class C0907x743b1add extends JsonSerializer<EdgesModel> {
    public final void m8760a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        EdgesModel edgesModel = (EdgesModel) obj;
        if (edgesModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(edgesModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        C0910xd29004f9.m8776b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(EdgesModel.class, new C0907x743b1add());
    }
}
