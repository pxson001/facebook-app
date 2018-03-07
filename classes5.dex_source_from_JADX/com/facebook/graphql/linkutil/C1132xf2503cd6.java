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
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLParsers.GetFeedStoryAttachmentFbLinkGraphQLParser.EmployerParser;
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
public final class C1132xf2503cd6 extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    @Nullable
    private String f12376d;

    /* compiled from: WWW_ACTIVATE */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C1132xf2503cd6.class, new Deserializer());
        }

        public Object m20463a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(EmployerParser.m20526a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c1132xf2503cd6 = new C1132xf2503cd6();
            ((BaseModel) c1132xf2503cd6).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c1132xf2503cd6 instanceof Postprocessable) {
                return ((Postprocessable) c1132xf2503cd6).a();
            }
            return c1132xf2503cd6;
        }
    }

    /* compiled from: WWW_ACTIVATE */
    public class Serializer extends JsonSerializer<C1132xf2503cd6> {
        public final void m20464a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C1132xf2503cd6 c1132xf2503cd6 = (C1132xf2503cd6) obj;
            if (c1132xf2503cd6.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c1132xf2503cd6.m20465a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c1132xf2503cd6.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            EmployerParser.m20527a(c1132xf2503cd6.w_(), c1132xf2503cd6.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C1132xf2503cd6.class, new Serializer());
        }
    }

    public C1132xf2503cd6() {
        super(1);
    }

    public final void m20468a(String str, ConsistencyTuple consistencyTuple) {
        consistencyTuple.a();
    }

    public final void m20469a(String str, Object obj, boolean z) {
    }

    @Nullable
    public final String m20470b() {
        this.f12376d = super.a(this.f12376d, 0);
        return this.f12376d;
    }

    @Nullable
    public final String m20467a() {
        return m20470b();
    }

    public final int jK_() {
        return 2479791;
    }

    public final GraphQLVisitableModel m20466a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m20465a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m20470b());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        i();
        return flatBufferBuilder.d();
    }
}
