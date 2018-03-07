package com.facebook.appdiscovery.lite.protocol;

import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLParsers.PlatformApplicationFragmentParser.SocialUsageSummarySentenceParser;
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
public final class C0378xd286a19f extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private String f4062d;

    /* compiled from: sendInstantly */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0378xd286a19f.class, new Deserializer());
        }

        public Object m3967a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(SocialUsageSummarySentenceParser.m4031a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0378xd286a19f = new C0378xd286a19f();
            ((BaseModel) c0378xd286a19f).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0378xd286a19f instanceof Postprocessable) {
                return ((Postprocessable) c0378xd286a19f).a();
            }
            return c0378xd286a19f;
        }
    }

    /* compiled from: sendInstantly */
    public class Serializer extends JsonSerializer<C0378xd286a19f> {
        public final void m3968a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0378xd286a19f c0378xd286a19f = (C0378xd286a19f) obj;
            if (c0378xd286a19f.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0378xd286a19f.m3970a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0378xd286a19f.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            SocialUsageSummarySentenceParser.m4032a(c0378xd286a19f.w_(), c0378xd286a19f.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C0378xd286a19f.class, new Serializer());
        }
    }

    public C0378xd286a19f() {
        super(1);
    }

    @Nullable
    private String m3969a() {
        this.f4062d = super.a(this.f4062d, 0);
        return this.f4062d;
    }

    public final int jK_() {
        return -1919764332;
    }

    public final GraphQLVisitableModel m3971a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m3970a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m3969a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        i();
        return flatBufferBuilder.d();
    }
}
