package com.facebook.search.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.search.protocol.FetchRecentSearchesGraphQLModels.FBRecentSearchesQueryModel.RecentSearchesModel;
import com.facebook.search.protocol.FetchRecentSearchesGraphQLParsers.FBRecentSearchesQueryParser.RecentSearchesParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: network_operation */
public class C0903xb7d2c539 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(RecentSearchesModel.class, new C0903xb7d2c539());
    }

    public Object m8713a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(RecentSearchesParser.a(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object recentSearchesModel = new RecentSearchesModel();
        ((BaseModel) recentSearchesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (recentSearchesModel instanceof Postprocessable) {
            return ((Postprocessable) recentSearchesModel).a();
        }
        return recentSearchesModel;
    }
}
