package com.facebook.feed.util.story;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.AttachedStoryParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
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
@ModelWithFlatBufferFormatHash(a = 1801334754)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: TQUERY_CONSTRUCTION_PARAM; */
public final class C1947x548deaa2 extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    @Nullable
    private String f22504d;

    /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C1947x548deaa2.class, new Deserializer());
        }

        public Object m25139a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(AttachedStoryParser.m25201a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c1947x548deaa2 = new C1947x548deaa2();
            ((BaseModel) c1947x548deaa2).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c1947x548deaa2 instanceof Postprocessable) {
                return ((Postprocessable) c1947x548deaa2).a();
            }
            return c1947x548deaa2;
        }
    }

    /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
    public class Serializer extends JsonSerializer<C1947x548deaa2> {
        public final void m25140a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C1947x548deaa2 c1947x548deaa2 = (C1947x548deaa2) obj;
            if (c1947x548deaa2.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c1947x548deaa2.m25142a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c1947x548deaa2.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            AttachedStoryParser.m25202a(c1947x548deaa2.w_(), c1947x548deaa2.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C1947x548deaa2.class, new Serializer());
        }
    }

    public C1947x548deaa2() {
        super(1);
    }

    public final void m25145a(String str, ConsistencyTuple consistencyTuple) {
        consistencyTuple.a();
    }

    public final void m25146a(String str, Object obj, boolean z) {
    }

    @Nullable
    private String m25141j() {
        this.f22504d = super.a(this.f22504d, 0);
        return this.f22504d;
    }

    @Nullable
    public final String m25144a() {
        return m25141j();
    }

    public final int jK_() {
        return 80218325;
    }

    public final GraphQLVisitableModel m25143a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m25142a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m25141j());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        i();
        return flatBufferBuilder.d();
    }
}
