package com.facebook.search.protocol;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.search.protocol.FetchRecentSearchesGraphQLModels.FBRecentSearchesQueryModel;
import com.facebook.search.protocol.FetchRecentSearchesGraphQLParsers.FBRecentSearchesQueryParser.RecentSearchesParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: network_operation */
public class C0909x2fa59e0c extends JsonSerializer<FBRecentSearchesQueryModel> {
    public final void m8762a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        FBRecentSearchesQueryModel fBRecentSearchesQueryModel = (FBRecentSearchesQueryModel) obj;
        if (fBRecentSearchesQueryModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(fBRecentSearchesQueryModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            fBRecentSearchesQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = fBRecentSearchesQueryModel.w_();
        int u_ = fBRecentSearchesQueryModel.u_();
        jsonGenerator.f();
        boolean a = mutableFlatBuffer.a(u_, 0);
        if (a) {
            jsonGenerator.a("has_editable_search_history");
            jsonGenerator.a(a);
        }
        int g = mutableFlatBuffer.g(u_, 1);
        if (g != 0) {
            jsonGenerator.a("recent_searches");
            RecentSearchesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(FBRecentSearchesQueryModel.class, new C0909x2fa59e0c());
    }
}
