package com.facebook.appdiscovery.lite.protocol;

import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLParsers.PlatformApplicationFragmentParser.GlobalUsageSummarySentenceParser;
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
@ModelWithFlatBufferFormatHash(a = -1352864475)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: sendInstantly */
public final class C0374x2f9ebe29 extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private String f4056d;

    /* compiled from: sendInstantly */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0374x2f9ebe29.class, new Deserializer());
        }

        public Object m3948a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(GlobalUsageSummarySentenceParser.m4025a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0374x2f9ebe29 = new C0374x2f9ebe29();
            ((BaseModel) c0374x2f9ebe29).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0374x2f9ebe29 instanceof Postprocessable) {
                return ((Postprocessable) c0374x2f9ebe29).a();
            }
            return c0374x2f9ebe29;
        }
    }

    /* compiled from: sendInstantly */
    public class Serializer extends JsonSerializer<C0374x2f9ebe29> {
        public final void m3949a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0374x2f9ebe29 c0374x2f9ebe29 = (C0374x2f9ebe29) obj;
            if (c0374x2f9ebe29.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0374x2f9ebe29.m3951a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0374x2f9ebe29.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            GlobalUsageSummarySentenceParser.m4026a(c0374x2f9ebe29.w_(), c0374x2f9ebe29.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C0374x2f9ebe29.class, new Serializer());
        }
    }

    public C0374x2f9ebe29() {
        super(1);
    }

    @Nullable
    private String m3950a() {
        this.f4056d = super.a(this.f4056d, 0);
        return this.f4056d;
    }

    public final int jK_() {
        return -1919764332;
    }

    public final GraphQLVisitableModel m3952a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m3951a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m3950a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        i();
        return flatBufferBuilder.d();
    }
}
