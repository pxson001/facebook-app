package com.facebook.privacy.protocol;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.privacy.protocol.FetchComposerPostPrivacyFollowUpInfoModels.ComposerInlinePrivacySurveyFieldsModel;
import com.facebook.privacy.protocol.FetchComposerPostPrivacyFollowUpInfoParsers.ComposerInlinePrivacySurveyFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: sticker_selected */
public class C0236xde8eacdd extends JsonSerializer<ComposerInlinePrivacySurveyFieldsModel> {
    public final void m6049a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ComposerInlinePrivacySurveyFieldsModel composerInlinePrivacySurveyFieldsModel = (ComposerInlinePrivacySurveyFieldsModel) obj;
        if (composerInlinePrivacySurveyFieldsModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(composerInlinePrivacySurveyFieldsModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            composerInlinePrivacySurveyFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        ComposerInlinePrivacySurveyFieldsParser.a(composerInlinePrivacySurveyFieldsModel.w_(), composerInlinePrivacySurveyFieldsModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(ComposerInlinePrivacySurveyFieldsModel.class, new C0236xde8eacdd());
    }
}
