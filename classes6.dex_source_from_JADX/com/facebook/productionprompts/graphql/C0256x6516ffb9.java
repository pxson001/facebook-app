package com.facebook.productionprompts.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLParsers.ProductionPromptsInfoParser.PromptSurveyParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -1003904897)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: state_report_button_position */
public final class C0256x6516ffb9 extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private String f4195d;
    @Nullable
    private String f4196e;
    @Nullable
    private String f4197f;

    /* compiled from: state_report_button_position */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0256x6516ffb9.class, new Deserializer());
        }

        public Object m6142a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(PromptSurveyParser.m6226a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0256x6516ffb9 = new C0256x6516ffb9();
            ((BaseModel) c0256x6516ffb9).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0256x6516ffb9 instanceof Postprocessable) {
                return ((Postprocessable) c0256x6516ffb9).a();
            }
            return c0256x6516ffb9;
        }
    }

    /* compiled from: state_report_button_position */
    public class Serializer extends JsonSerializer<C0256x6516ffb9> {
        public final void m6143a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0256x6516ffb9 c0256x6516ffb9 = (C0256x6516ffb9) obj;
            if (c0256x6516ffb9.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0256x6516ffb9.m6144a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0256x6516ffb9.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            PromptSurveyParser.m6227a(c0256x6516ffb9.w_(), c0256x6516ffb9.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C0256x6516ffb9.class, new Serializer());
        }
    }

    public C0256x6516ffb9() {
        super(3);
    }

    @Nullable
    public final String m6146a() {
        this.f4195d = super.a(this.f4195d, 0);
        return this.f4195d;
    }

    @Nullable
    public final String m6147j() {
        this.f4196e = super.a(this.f4196e, 1);
        return this.f4196e;
    }

    @Nullable
    public final String m6148k() {
        this.f4197f = super.a(this.f4197f, 2);
        return this.f4197f;
    }

    public final int jK_() {
        return -1308428969;
    }

    public final GraphQLVisitableModel m6145a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m6144a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m6146a());
        int b2 = flatBufferBuilder.b(m6147j());
        int b3 = flatBufferBuilder.b(m6148k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, b3);
        i();
        return flatBufferBuilder.d();
    }
}
