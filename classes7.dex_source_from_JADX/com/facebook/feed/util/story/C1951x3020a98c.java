package com.facebook.feed.util.story;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.MessageParser;
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
/* compiled from: TQUERY_CONSTRUCTION_PARAM; */
public final class C1951x3020a98c extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private String f22505d;

    /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C1951x3020a98c.class, new Deserializer());
        }

        public Object m25150a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(MessageParser.m25205a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c1951x3020a98c = new C1951x3020a98c();
            ((BaseModel) c1951x3020a98c).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c1951x3020a98c instanceof Postprocessable) {
                return ((Postprocessable) c1951x3020a98c).a();
            }
            return c1951x3020a98c;
        }
    }

    /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
    public class Serializer extends JsonSerializer<C1951x3020a98c> {
        public final void m25151a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C1951x3020a98c c1951x3020a98c = (C1951x3020a98c) obj;
            if (c1951x3020a98c.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c1951x3020a98c.m25153a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c1951x3020a98c.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            MessageParser.m25206a(c1951x3020a98c.w_(), c1951x3020a98c.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C1951x3020a98c.class, new Serializer());
        }
    }

    public C1951x3020a98c() {
        super(1);
    }

    @Nullable
    private String m25152a() {
        this.f22505d = super.a(this.f22505d, 0);
        return this.f22505d;
    }

    public final int jK_() {
        return -1919764332;
    }

    public final GraphQLVisitableModel m25154a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m25153a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m25152a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        i();
        return flatBufferBuilder.d();
    }
}
