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
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLParsers.GetFeedStoryAttachmentFbLinkGraphQLParser.SchoolClassParser;
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
public final class C1133x65db667d extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    @Nullable
    private String f12377d;

    /* compiled from: WWW_ACTIVATE */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C1133x65db667d.class, new Deserializer());
        }

        public Object m20471a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(SchoolClassParser.m20528a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c1133x65db667d = new C1133x65db667d();
            ((BaseModel) c1133x65db667d).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c1133x65db667d instanceof Postprocessable) {
                return ((Postprocessable) c1133x65db667d).a();
            }
            return c1133x65db667d;
        }
    }

    /* compiled from: WWW_ACTIVATE */
    public class Serializer extends JsonSerializer<C1133x65db667d> {
        public final void m20472a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C1133x65db667d c1133x65db667d = (C1133x65db667d) obj;
            if (c1133x65db667d.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c1133x65db667d.m20473a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c1133x65db667d.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            SchoolClassParser.m20529a(c1133x65db667d.w_(), c1133x65db667d.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C1133x65db667d.class, new Serializer());
        }
    }

    public C1133x65db667d() {
        super(1);
    }

    public final void m20476a(String str, ConsistencyTuple consistencyTuple) {
        consistencyTuple.a();
    }

    public final void m20477a(String str, Object obj, boolean z) {
    }

    @Nullable
    public final String m20478b() {
        this.f12377d = super.a(this.f12377d, 0);
        return this.f12377d;
    }

    @Nullable
    public final String m20475a() {
        return m20478b();
    }

    public final int jK_() {
        return 2479791;
    }

    public final GraphQLVisitableModel m20474a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m20473a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m20478b());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        i();
        return flatBufferBuilder.d();
    }
}
