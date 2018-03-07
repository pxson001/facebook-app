package com.facebook.appdiscovery.lite.protocol;

import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLParsers.PlatformApplicationFragmentParser.AppCenterCategoryTextParser;
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
public final class C0370xc3687bbd extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private String f4053d;

    /* compiled from: sendInstantly */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0370xc3687bbd.class, new Deserializer());
        }

        public Object m3932a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(AppCenterCategoryTextParser.m4019a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0370xc3687bbd = new C0370xc3687bbd();
            ((BaseModel) c0370xc3687bbd).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0370xc3687bbd instanceof Postprocessable) {
                return ((Postprocessable) c0370xc3687bbd).a();
            }
            return c0370xc3687bbd;
        }
    }

    /* compiled from: sendInstantly */
    public class Serializer extends JsonSerializer<C0370xc3687bbd> {
        public final void m3933a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0370xc3687bbd c0370xc3687bbd = (C0370xc3687bbd) obj;
            if (c0370xc3687bbd.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0370xc3687bbd.m3935a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0370xc3687bbd.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            AppCenterCategoryTextParser.m4020a(c0370xc3687bbd.w_(), c0370xc3687bbd.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C0370xc3687bbd.class, new Serializer());
        }
    }

    public C0370xc3687bbd() {
        super(1);
    }

    @Nullable
    private String m3934a() {
        this.f4053d = super.a(this.f4053d, 0);
        return this.f4053d;
    }

    public final int jK_() {
        return -1919764332;
    }

    public final GraphQLVisitableModel m3936a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m3935a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m3934a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        i();
        return flatBufferBuilder.d();
    }
}
