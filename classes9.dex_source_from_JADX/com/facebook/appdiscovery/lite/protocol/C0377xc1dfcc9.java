package com.facebook.appdiscovery.lite.protocol;

import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLParsers.PlatformApplicationFragmentParser.SocialUsageSentenceWithNamesParser;
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
public final class C0377xc1dfcc9 extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private String f4061d;

    /* compiled from: sendInstantly */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0377xc1dfcc9.class, new Deserializer());
        }

        public Object m3962a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(SocialUsageSentenceWithNamesParser.m4029a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0377xc1dfcc9 = new C0377xc1dfcc9();
            ((BaseModel) c0377xc1dfcc9).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0377xc1dfcc9 instanceof Postprocessable) {
                return ((Postprocessable) c0377xc1dfcc9).a();
            }
            return c0377xc1dfcc9;
        }
    }

    /* compiled from: sendInstantly */
    public class Serializer extends JsonSerializer<C0377xc1dfcc9> {
        public final void m3963a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0377xc1dfcc9 c0377xc1dfcc9 = (C0377xc1dfcc9) obj;
            if (c0377xc1dfcc9.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0377xc1dfcc9.m3965a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0377xc1dfcc9.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            SocialUsageSentenceWithNamesParser.m4030a(c0377xc1dfcc9.w_(), c0377xc1dfcc9.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C0377xc1dfcc9.class, new Serializer());
        }
    }

    public C0377xc1dfcc9() {
        super(1);
    }

    @Nullable
    private String m3964a() {
        this.f4061d = super.a(this.f4061d, 0);
        return this.f4061d;
    }

    public final int jK_() {
        return -1919764332;
    }

    public final GraphQLVisitableModel m3966a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m3965a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m3964a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        i();
        return flatBufferBuilder.d();
    }
}
