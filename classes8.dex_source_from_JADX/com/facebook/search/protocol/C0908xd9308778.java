package com.facebook.search.protocol;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.search.protocol.FetchRecentSearchesGraphQLModels.FBRecentSearchesQueryModel.RecentSearchesModel;
import com.facebook.search.protocol.FetchRecentSearchesGraphQLParsers.FBRecentSearchesQueryParser.RecentSearchesParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: network_operation */
public class C0908xd9308778 extends JsonSerializer<RecentSearchesModel> {
    public final void m8761a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        RecentSearchesModel recentSearchesModel = (RecentSearchesModel) obj;
        if (recentSearchesModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(recentSearchesModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            recentSearchesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        RecentSearchesParser.a(recentSearchesModel.w_(), recentSearchesModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(RecentSearchesModel.class, new C0908xd9308778());
    }
}
