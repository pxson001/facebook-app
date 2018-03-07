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
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLParsers.GetFeedStoryAttachmentFbLinkGraphQLParser.SchoolParser;
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
public final class C1134x434d9dbd extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    @Nullable
    private String f12378d;

    /* compiled from: WWW_ACTIVATE */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C1134x434d9dbd.class, new Deserializer());
        }

        public Object m20479a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(SchoolParser.m20530a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c1134x434d9dbd = new C1134x434d9dbd();
            ((BaseModel) c1134x434d9dbd).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c1134x434d9dbd instanceof Postprocessable) {
                return ((Postprocessable) c1134x434d9dbd).a();
            }
            return c1134x434d9dbd;
        }
    }

    /* compiled from: WWW_ACTIVATE */
    public class Serializer extends JsonSerializer<C1134x434d9dbd> {
        public final void m20480a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C1134x434d9dbd c1134x434d9dbd = (C1134x434d9dbd) obj;
            if (c1134x434d9dbd.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c1134x434d9dbd.m20481a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c1134x434d9dbd.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            SchoolParser.m20531a(c1134x434d9dbd.w_(), c1134x434d9dbd.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C1134x434d9dbd.class, new Serializer());
        }
    }

    public C1134x434d9dbd() {
        super(1);
    }

    public final void m20484a(String str, ConsistencyTuple consistencyTuple) {
        consistencyTuple.a();
    }

    public final void m20485a(String str, Object obj, boolean z) {
    }

    @Nullable
    public final String m20486b() {
        this.f12378d = super.a(this.f12378d, 0);
        return this.f12378d;
    }

    @Nullable
    public final String m20483a() {
        return m20486b();
    }

    public final int jK_() {
        return 2479791;
    }

    public final GraphQLVisitableModel m20482a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m20481a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m20486b());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        i();
        return flatBufferBuilder.d();
    }
}
