package com.facebook.graphql.linkutil;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLParsers.GetFeedStoryAttachmentFbLinkGraphQLParser.WorkProjectParser;
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
/* compiled from: WWW_ACTIVATE */
public final class C1136xf0cf3499 extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    @Nullable
    private String f12379d;

    /* compiled from: WWW_ACTIVATE */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C1136xf0cf3499.class, new Deserializer());
        }

        public Object m20488a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(WorkProjectParser.m20532a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c1136xf0cf3499 = new C1136xf0cf3499();
            ((BaseModel) c1136xf0cf3499).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c1136xf0cf3499 instanceof Postprocessable) {
                return ((Postprocessable) c1136xf0cf3499).a();
            }
            return c1136xf0cf3499;
        }
    }

    /* compiled from: WWW_ACTIVATE */
    public class Serializer extends JsonSerializer<C1136xf0cf3499> {
        public final void m20489a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C1136xf0cf3499 c1136xf0cf3499 = (C1136xf0cf3499) obj;
            if (c1136xf0cf3499.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c1136xf0cf3499.m20490a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c1136xf0cf3499.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            WorkProjectParser.m20533a(c1136xf0cf3499.w_(), c1136xf0cf3499.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C1136xf0cf3499.class, new Serializer());
        }
    }

    public C1136xf0cf3499() {
        super(1);
    }

    public final void m20493a(String str, ConsistencyTuple consistencyTuple) {
        consistencyTuple.a();
    }

    public final void m20494a(String str, Object obj, boolean z) {
    }

    @Nullable
    public final String m20495b() {
        this.f12379d = super.a(this.f12379d, 0);
        return this.f12379d;
    }

    @Nullable
    public final String m20492a() {
        return m20495b();
    }

    public final int jK_() {
        return 2479791;
    }

    public final GraphQLVisitableModel m20491a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m20490a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m20495b());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        i();
        return flatBufferBuilder.d();
    }
}
