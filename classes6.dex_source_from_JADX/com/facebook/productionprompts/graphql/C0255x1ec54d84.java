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
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLParsers.ProductionPromptsInfoParser.PromptImageParser;
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
@ModelWithFlatBufferFormatHash(a = 842551240)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: state_report_button_position */
public final class C0255x1ec54d84 extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private String f4194d;

    /* compiled from: state_report_button_position */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0255x1ec54d84.class, new Deserializer());
        }

        public Object m6137a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(PromptImageParser.m6224a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0255x1ec54d84 = new C0255x1ec54d84();
            ((BaseModel) c0255x1ec54d84).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0255x1ec54d84 instanceof Postprocessable) {
                return ((Postprocessable) c0255x1ec54d84).a();
            }
            return c0255x1ec54d84;
        }
    }

    /* compiled from: state_report_button_position */
    public class Serializer extends JsonSerializer<C0255x1ec54d84> {
        public final void m6138a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0255x1ec54d84 c0255x1ec54d84 = (C0255x1ec54d84) obj;
            if (c0255x1ec54d84.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0255x1ec54d84.m6139a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0255x1ec54d84.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            PromptImageParser.m6225a(c0255x1ec54d84.w_(), c0255x1ec54d84.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C0255x1ec54d84.class, new Serializer());
        }
    }

    public C0255x1ec54d84() {
        super(1);
    }

    @Nullable
    public final String m6141a() {
        this.f4194d = super.a(this.f4194d, 0);
        return this.f4194d;
    }

    public final int jK_() {
        return 70760763;
    }

    public final GraphQLVisitableModel m6140a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m6139a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m6141a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        i();
        return flatBufferBuilder.d();
    }
}
