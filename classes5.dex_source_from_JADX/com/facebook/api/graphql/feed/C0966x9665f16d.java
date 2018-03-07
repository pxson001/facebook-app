package com.facebook.api.graphql.feed;

import com.facebook.api.graphql.feed.NewsFeedDefaultsFeedbackGraphQLParsers.NewsFeedDefaultsCompleteFeedbackParser.ResharesParser;
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

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -1723990064)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: app_center_categories */
public final class C0966x9665f16d extends BaseModel implements GraphQLVisitableModel {
    private int f9296d;

    /* compiled from: app_center_categories */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0966x9665f16d.class, new Deserializer());
        }

        public Object m15855a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(ResharesParser.m15883a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0966x9665f16d = new C0966x9665f16d();
            ((BaseModel) c0966x9665f16d).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0966x9665f16d instanceof Postprocessable) {
                return ((Postprocessable) c0966x9665f16d).a();
            }
            return c0966x9665f16d;
        }
    }

    /* compiled from: app_center_categories */
    public class Serializer extends JsonSerializer<C0966x9665f16d> {
        public final void m15856a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0966x9665f16d c0966x9665f16d = (C0966x9665f16d) obj;
            if (c0966x9665f16d.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0966x9665f16d.m15858a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0966x9665f16d.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            ResharesParser.m15884a(c0966x9665f16d.w_(), c0966x9665f16d.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C0966x9665f16d.class, new Serializer());
        }
    }

    public C0966x9665f16d() {
        super(1);
    }

    public final int m15857a() {
        a(0, 0);
        return this.f9296d;
    }

    public final void m15860a(int i) {
        this.f9296d = i;
        if (this.b != null && this.b.d) {
            this.b.b(this.c, 0, i);
        }
    }

    public final int jK_() {
        return -1260671207;
    }

    public final GraphQLVisitableModel m15859a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m15858a(FlatBufferBuilder flatBufferBuilder) {
        h();
        flatBufferBuilder.c(1);
        flatBufferBuilder.a(0, this.f9296d, 0);
        i();
        return flatBufferBuilder.d();
    }

    public final void m15861a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f9296d = mutableFlatBuffer.a(i, 0, 0);
    }
}
