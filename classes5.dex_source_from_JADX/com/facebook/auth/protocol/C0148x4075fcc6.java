package com.facebook.auth.protocol;

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
@ModelWithFlatBufferFormatHash(a = 44074500)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: suggestion_text */
public final class C0148x4075fcc6 extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private String f2356d;
    @Nullable
    private String f2357e;

    /* compiled from: suggestion_text */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0148x4075fcc6.class, new Deserializer());
        }

        public Object m3219a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(C0153x8d3154c2.m3234a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0148x4075fcc6 = new C0148x4075fcc6();
            ((BaseModel) c0148x4075fcc6).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0148x4075fcc6 instanceof Postprocessable) {
                return ((Postprocessable) c0148x4075fcc6).a();
            }
            return c0148x4075fcc6;
        }
    }

    /* compiled from: suggestion_text */
    public class Serializer extends JsonSerializer<C0148x4075fcc6> {
        public final void m3220a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0148x4075fcc6 c0148x4075fcc6 = (C0148x4075fcc6) obj;
            if (c0148x4075fcc6.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0148x4075fcc6.m3221a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0148x4075fcc6.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            C0153x8d3154c2.m3235a(c0148x4075fcc6.w_(), c0148x4075fcc6.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C0148x4075fcc6.class, new Serializer());
        }
    }

    public C0148x4075fcc6() {
        super(2);
    }

    @Nullable
    public final String m3223a() {
        this.f2356d = super.a(this.f2356d, 0);
        return this.f2356d;
    }

    @Nullable
    public final String m3224j() {
        this.f2357e = super.a(this.f2357e, 1);
        return this.f2357e;
    }

    public final int jK_() {
        return 474898999;
    }

    public final GraphQLVisitableModel m3222a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m3221a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m3223a());
        int b2 = flatBufferBuilder.b(m3224j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        i();
        return flatBufferBuilder.d();
    }
}
