package com.facebook.backgroundlocation.reporting.graphql;

import com.facebook.backgroundlocation.reporting.graphql.BackgroundLocationReportingGraphQLModels.LocationSharingModel;
import com.facebook.backgroundlocation.reporting.graphql.BackgroundLocationReportingGraphQLParsers.LocationSharingParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: dialog_title */
public class C2082x9e41dfb9 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(LocationSharingModel.class, new C2082x9e41dfb9());
    }

    public Object m15418a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(LocationSharingParser.a(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object locationSharingModel = new LocationSharingModel();
        ((BaseModel) locationSharingModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (locationSharingModel instanceof Postprocessable) {
            return ((Postprocessable) locationSharingModel).a();
        }
        return locationSharingModel;
    }
}
