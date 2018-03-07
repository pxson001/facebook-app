package com.facebook.backgroundlocation.reporting.graphql;

import com.facebook.backgroundlocation.reporting.graphql.BackgroundLocationReportingGraphQLModels.LocationSharingModel;
import com.facebook.backgroundlocation.reporting.graphql.BackgroundLocationReportingGraphQLParsers.LocationSharingParser;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: dialog_title */
public class C2083xda441f8 extends JsonSerializer<LocationSharingModel> {
    public final void m15419a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        LocationSharingModel locationSharingModel = (LocationSharingModel) obj;
        if (locationSharingModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(locationSharingModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            locationSharingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        LocationSharingParser.a(locationSharingModel.w_(), locationSharingModel.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(LocationSharingModel.class, new C2083xda441f8());
    }
}
