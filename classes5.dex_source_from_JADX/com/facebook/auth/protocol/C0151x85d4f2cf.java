package com.facebook.auth.protocol;

import com.facebook.auth.protocol.LoggedInUserQueryFragmentParsers.LoggedInUserQueryFragmentParser.MessagingGeoParser;
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
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLParsers.FetchProductionPromptsQueryParser;
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
@ModelWithFlatBufferFormatHash(a = 588213278)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: suggestion_text */
public final class C0151x85d4f2cf extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private String f2358d;
    @Nullable
    private String f2359e;

    /* compiled from: suggestion_text */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0151x85d4f2cf.class, new Deserializer());
        }

        public Object m3227a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(MessagingGeoParser.a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0151x85d4f2cf = new C0151x85d4f2cf();
            ((BaseModel) c0151x85d4f2cf).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0151x85d4f2cf instanceof Postprocessable) {
                return ((Postprocessable) c0151x85d4f2cf).a();
            }
            return c0151x85d4f2cf;
        }
    }

    /* compiled from: suggestion_text */
    public class Serializer extends JsonSerializer<C0151x85d4f2cf> {
        public final void m3228a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0151x85d4f2cf c0151x85d4f2cf = (C0151x85d4f2cf) obj;
            if (c0151x85d4f2cf.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0151x85d4f2cf.m3231a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0151x85d4f2cf.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            FetchProductionPromptsQueryParser.a(c0151x85d4f2cf.w_(), c0151x85d4f2cf.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C0151x85d4f2cf.class, new Serializer());
        }
    }

    public C0151x85d4f2cf() {
        super(2);
    }

    @Nullable
    private String m3229a() {
        this.f2358d = super.a(this.f2358d, 0);
        return this.f2358d;
    }

    @Nullable
    private String m3230j() {
        this.f2359e = super.a(this.f2359e, 1);
        return this.f2359e;
    }

    public final int jK_() {
        return -993810995;
    }

    public final GraphQLVisitableModel m3232a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m3231a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m3229a());
        int b2 = flatBufferBuilder.b(m3230j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        i();
        return flatBufferBuilder.d();
    }
}
