package com.facebook.privacy.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.privacy.protocol.FetchComposerPostPrivacyFollowUpInfoModels.ComposerInlinePrivacySurveyFieldsModel;
import com.facebook.privacy.protocol.FetchComposerPostPrivacyFollowUpInfoParsers.ComposerInlinePrivacySurveyFieldsParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: sticker_selected */
public class C0235xde3d255e extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(ComposerInlinePrivacySurveyFieldsModel.class, new C0235xde3d255e());
    }

    public Object m6048a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(ComposerInlinePrivacySurveyFieldsParser.a(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object composerInlinePrivacySurveyFieldsModel = new ComposerInlinePrivacySurveyFieldsModel();
        ((BaseModel) composerInlinePrivacySurveyFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (composerInlinePrivacySurveyFieldsModel instanceof Postprocessable) {
            return ((Postprocessable) composerInlinePrivacySurveyFieldsModel).a();
        }
        return composerInlinePrivacySurveyFieldsModel;
    }
}
