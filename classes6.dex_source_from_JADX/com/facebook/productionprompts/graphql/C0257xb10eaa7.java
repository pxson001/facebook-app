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
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLParsers.ProductionPromptsInfoParser.PromptTitleParser;
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
@ModelWithFlatBufferFormatHash(a = -1352864475)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: state_report_button_position */
public final class C0257xb10eaa7 extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private String f4198d;

    /* compiled from: state_report_button_position */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0257xb10eaa7.class, new Deserializer());
        }

        public Object m6149a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(PromptTitleParser.m6228a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0257xb10eaa7 = new C0257xb10eaa7();
            ((BaseModel) c0257xb10eaa7).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0257xb10eaa7 instanceof Postprocessable) {
                return ((Postprocessable) c0257xb10eaa7).a();
            }
            return c0257xb10eaa7;
        }
    }

    /* compiled from: state_report_button_position */
    public class Serializer extends JsonSerializer<C0257xb10eaa7> {
        public final void m6150a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0257xb10eaa7 c0257xb10eaa7 = (C0257xb10eaa7) obj;
            if (c0257xb10eaa7.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0257xb10eaa7.m6151a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0257xb10eaa7.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            PromptTitleParser.m6229a(c0257xb10eaa7.w_(), c0257xb10eaa7.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C0257xb10eaa7.class, new Serializer());
        }
    }

    public C0257xb10eaa7() {
        super(1);
    }

    @Nullable
    public final String m6153a() {
        this.f4198d = super.a(this.f4198d, 0);
        return this.f4198d;
    }

    public final int jK_() {
        return -1919764332;
    }

    public final GraphQLVisitableModel m6152a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m6151a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m6153a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        i();
        return flatBufferBuilder.d();
    }
}
