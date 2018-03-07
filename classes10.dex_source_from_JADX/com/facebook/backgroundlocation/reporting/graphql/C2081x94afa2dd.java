package com.facebook.backgroundlocation.reporting.graphql;

import com.facebook.backgroundlocation.reporting.graphql.BackgroundLocationReportingGraphQLModels.FetchBackgroundLocationReportingSettingsModel;
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
public class C2081x94afa2dd extends JsonSerializer<FetchBackgroundLocationReportingSettingsModel> {
    public final void m15417a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        FetchBackgroundLocationReportingSettingsModel fetchBackgroundLocationReportingSettingsModel = (FetchBackgroundLocationReportingSettingsModel) obj;
        if (fetchBackgroundLocationReportingSettingsModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(fetchBackgroundLocationReportingSettingsModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            fetchBackgroundLocationReportingSettingsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = fetchBackgroundLocationReportingSettingsModel.w_();
        int u_ = fetchBackgroundLocationReportingSettingsModel.u_();
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(u_, 0);
        if (g != 0) {
            jsonGenerator.a("location_sharing");
            LocationSharingParser.a(mutableFlatBuffer, g, jsonGenerator);
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(FetchBackgroundLocationReportingSettingsModel.class, new C2081x94afa2dd());
    }
}
