package com.facebook.graphql.story.util;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLParsers.ShouldDisplaySubStoryGalleryGraphQLParser.ActorsParser;
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
@ModelWithFlatBufferFormatHash(a = -1787905591)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: TRIGHT;TKEY;>; */
public final class C1284xf774de14 extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    @Nullable
    private GraphQLObjectType f13505d;
    @Nullable
    private String f13506e;

    /* compiled from: TRIGHT;TKEY;>; */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C1284xf774de14.class, new Deserializer());
        }

        public Object m22666a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(ActorsParser.m22700b(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c1284xf774de14 = new C1284xf774de14();
            ((BaseModel) c1284xf774de14).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c1284xf774de14 instanceof Postprocessable) {
                return ((Postprocessable) c1284xf774de14).a();
            }
            return c1284xf774de14;
        }
    }

    /* compiled from: TRIGHT;TKEY;>; */
    public class Serializer extends JsonSerializer<C1284xf774de14> {
        public final void m22667a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C1284xf774de14 c1284xf774de14 = (C1284xf774de14) obj;
            if (c1284xf774de14.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c1284xf774de14.m22670a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c1284xf774de14.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            ActorsParser.m22699a(c1284xf774de14.w_(), c1284xf774de14.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C1284xf774de14.class, new Serializer());
        }
    }

    public C1284xf774de14() {
        super(2);
    }

    public final void m22673a(String str, ConsistencyTuple consistencyTuple) {
        consistencyTuple.a();
    }

    public final void m22674a(String str, Object obj, boolean z) {
    }

    @Nullable
    private GraphQLObjectType m22668j() {
        if (this.b != null && this.f13505d == null) {
            this.f13505d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
        }
        return this.f13505d;
    }

    @Nullable
    private String m22669k() {
        this.f13506e = super.a(this.f13506e, 1);
        return this.f13506e;
    }

    @Nullable
    public final String m22672a() {
        return m22669k();
    }

    public final int jK_() {
        return 63093205;
    }

    public final GraphQLVisitableModel m22671a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m22670a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m22668j());
        int b = flatBufferBuilder.b(m22669k());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        i();
        return flatBufferBuilder.d();
    }
}
