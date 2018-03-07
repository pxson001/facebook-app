package com.facebook.friendsharing.souvenirs.layout;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Reactors list init needs valid reactors count map */
public class SouvenirEditorModelSerializer extends JsonSerializer<SouvenirEditorModel> {
    public final void m26148a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        SouvenirEditorModel souvenirEditorModel = (SouvenirEditorModel) obj;
        if (souvenirEditorModel == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m26147b(souvenirEditorModel, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(SouvenirEditorModel.class, new SouvenirEditorModelSerializer());
    }

    private static void m26147b(SouvenirEditorModel souvenirEditorModel, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "metadata", souvenirEditorModel.mMetadata);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "rows", souvenirEditorModel.mRows);
    }
}
