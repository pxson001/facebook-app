package com.facebook.auth.protocol;

import com.facebook.auth.protocol.LoggedInUserQueryFragmentModels.LoggedInUserQueryFragmentModel;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLParsers.FetchProductionPromptsQueryParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: suggestion_text */
public class C0152x969f479f extends JsonSerializer<LoggedInUserQueryFragmentModel> {
    public final void m3233a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        LoggedInUserQueryFragmentModel loggedInUserQueryFragmentModel = (LoggedInUserQueryFragmentModel) obj;
        if (loggedInUserQueryFragmentModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(loggedInUserQueryFragmentModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            loggedInUserQueryFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        FetchProductionPromptsQueryParser.a(loggedInUserQueryFragmentModel.w_(), loggedInUserQueryFragmentModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(LoggedInUserQueryFragmentModel.class, new C0152x969f479f());
    }
}
