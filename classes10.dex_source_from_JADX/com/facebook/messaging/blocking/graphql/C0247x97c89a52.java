package com.facebook.messaging.blocking.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.messaging.blocking.graphql.GetBlockInfoForUserModels.GetBlockInfoForUserQueryModel;
import com.facebook.messaging.blocking.graphql.GetBlockInfoForUserParsers.GetBlockInfoForUserQueryParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: thread_video_view */
public class C0247x97c89a52 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GetBlockInfoForUserQueryModel.class, new C0247x97c89a52());
    }

    public Object m1462a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(GetBlockInfoForUserQueryParser.m1464a(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object getBlockInfoForUserQueryModel = new GetBlockInfoForUserQueryModel();
        ((BaseModel) getBlockInfoForUserQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (getBlockInfoForUserQueryModel instanceof Postprocessable) {
            return ((Postprocessable) getBlockInfoForUserQueryModel).a();
        }
        return getBlockInfoForUserQueryModel;
    }
}
