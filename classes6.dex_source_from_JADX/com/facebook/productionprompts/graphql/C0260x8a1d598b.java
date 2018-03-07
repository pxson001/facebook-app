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
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLParsers.ProductionPromptsInfoParser.TimeRangeParser;
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
@ModelWithFlatBufferFormatHash(a = 791947283)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: state_report_button_position */
public final class C0260x8a1d598b extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private String f4224d;
    @Nullable
    private String f4225e;
    @Nullable
    private String f4226f;

    /* compiled from: state_report_button_position */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0260x8a1d598b.class, new Deserializer());
        }

        public Object m6217a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(TimeRangeParser.m6246a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0260x8a1d598b = new C0260x8a1d598b();
            ((BaseModel) c0260x8a1d598b).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0260x8a1d598b instanceof Postprocessable) {
                return ((Postprocessable) c0260x8a1d598b).a();
            }
            return c0260x8a1d598b;
        }
    }

    /* compiled from: state_report_button_position */
    public class Serializer extends JsonSerializer<C0260x8a1d598b> {
        public final void m6218a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0260x8a1d598b c0260x8a1d598b = (C0260x8a1d598b) obj;
            if (c0260x8a1d598b.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0260x8a1d598b.m6220a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0260x8a1d598b.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            TimeRangeParser.m6247a(c0260x8a1d598b.w_(), c0260x8a1d598b.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C0260x8a1d598b.class, new Serializer());
        }
    }

    public C0260x8a1d598b() {
        super(3);
    }

    @Nullable
    public final String m6222a() {
        this.f4224d = super.a(this.f4224d, 0);
        return this.f4224d;
    }

    @Nullable
    public final String m6223j() {
        this.f4225e = super.a(this.f4225e, 1);
        return this.f4225e;
    }

    @Nullable
    private String m6219k() {
        this.f4226f = super.a(this.f4226f, 2);
        return this.f4226f;
    }

    public final int jK_() {
        return -21990122;
    }

    public final GraphQLVisitableModel m6221a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m6220a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m6222a());
        int b2 = flatBufferBuilder.b(m6223j());
        int b3 = flatBufferBuilder.b(m6219k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, b3);
        i();
        return flatBufferBuilder.d();
    }
}
