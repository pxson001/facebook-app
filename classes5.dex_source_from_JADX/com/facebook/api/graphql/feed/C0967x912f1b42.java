package com.facebook.api.graphql.feed;

import com.facebook.api.graphql.feed.NewsFeedDefaultsFeedbackGraphQLParsers.NewsFeedDefaultsCompleteFeedbackParser.SeenByParser;
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
public final class C0967x912f1b42 extends BaseModel implements GraphQLVisitableModel {
    private int f9297d;

    /* compiled from: app_center_categories */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0967x912f1b42.class, new Deserializer());
        }

        public Object m15862a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(SeenByParser.m15885a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0967x912f1b42 = new C0967x912f1b42();
            ((BaseModel) c0967x912f1b42).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0967x912f1b42 instanceof Postprocessable) {
                return ((Postprocessable) c0967x912f1b42).a();
            }
            return c0967x912f1b42;
        }
    }

    /* compiled from: app_center_categories */
    public class Serializer extends JsonSerializer<C0967x912f1b42> {
        public final void m15863a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0967x912f1b42 c0967x912f1b42 = (C0967x912f1b42) obj;
            if (c0967x912f1b42.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0967x912f1b42.m15865a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0967x912f1b42.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            SeenByParser.m15886a(c0967x912f1b42.w_(), c0967x912f1b42.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C0967x912f1b42.class, new Serializer());
        }
    }

    public C0967x912f1b42() {
        super(1);
    }

    public final int m15864a() {
        a(0, 0);
        return this.f9297d;
    }

    public final void m15867a(int i) {
        this.f9297d = i;
        if (this.b != null && this.b.d) {
            this.b.b(this.c, 0, i);
        }
    }

    public final int jK_() {
        return -752571184;
    }

    public final GraphQLVisitableModel m15866a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m15865a(FlatBufferBuilder flatBufferBuilder) {
        h();
        flatBufferBuilder.c(1);
        flatBufferBuilder.a(0, this.f9297d, 0);
        i();
        return flatBufferBuilder.d();
    }

    public final void m15868a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f9297d = mutableFlatBuffer.a(i, 0, 0);
    }
}
