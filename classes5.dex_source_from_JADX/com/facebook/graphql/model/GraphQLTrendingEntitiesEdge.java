package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLTrendingEntitiesEdgeDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: True */
public final class GraphQLTrendingEntitiesEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLTrendingEntitiesEdge> CREATOR = new C12601();
    @Nullable
    GraphQLProfile f13362d;
    @Nullable
    String f13363e;
    @Nullable
    GraphQLGraphSearchQuery f13364f;
    @Nullable
    String f13365g;

    /* compiled from: True */
    final class C12601 implements Creator<GraphQLTrendingEntitiesEdge> {
        C12601() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLTrendingEntitiesEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLTrendingEntitiesEdge[i];
        }
    }

    /* compiled from: True */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLTrendingEntitiesEdge.class, new Deserializer());
        }

        public Object m22286a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLTrendingEntitiesEdgeDeserializer.m6125a(jsonParser, (short) 489);
            Object graphQLTrendingEntitiesEdge = new GraphQLTrendingEntitiesEdge();
            ((BaseModel) graphQLTrendingEntitiesEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLTrendingEntitiesEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLTrendingEntitiesEdge).a();
            }
            return graphQLTrendingEntitiesEdge;
        }
    }

    /* compiled from: True */
    public final class Serializer extends JsonSerializer<GraphQLTrendingEntitiesEdge> {
        public final void m22287a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLTrendingEntitiesEdge graphQLTrendingEntitiesEdge = (GraphQLTrendingEntitiesEdge) obj;
            GraphQLTrendingEntitiesEdgeDeserializer.m6126a(graphQLTrendingEntitiesEdge.w_(), graphQLTrendingEntitiesEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLTrendingEntitiesEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLTrendingEntitiesEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile m22289a() {
        this.f13362d = (GraphQLProfile) super.a(this.f13362d, 0, GraphQLProfile.class);
        return this.f13362d;
    }

    @FieldOffset
    @Nullable
    public final String m22291j() {
        this.f13363e = super.a(this.f13363e, 1);
        return this.f13363e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGraphSearchQuery m22292k() {
        this.f13364f = (GraphQLGraphSearchQuery) super.a(this.f13364f, 2, GraphQLGraphSearchQuery.class);
        return this.f13364f;
    }

    @FieldOffset
    @Nullable
    public final String m22293l() {
        this.f13365g = super.a(this.f13365g, 3);
        return this.f13365g;
    }

    public final int jK_() {
        return -817385725;
    }

    public final GraphQLVisitableModel m22290a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m22289a() != null) {
            GraphQLProfile graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.b(m22289a());
            if (m22289a() != graphQLProfile) {
                graphQLVisitableModel = (GraphQLTrendingEntitiesEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f13362d = graphQLProfile;
            }
        }
        if (m22292k() != null) {
            GraphQLGraphSearchQuery graphQLGraphSearchQuery = (GraphQLGraphSearchQuery) graphQLModelMutatingVisitor.b(m22292k());
            if (m22292k() != graphQLGraphSearchQuery) {
                graphQLVisitableModel = (GraphQLTrendingEntitiesEdge) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13364f = graphQLGraphSearchQuery;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLTrendingEntitiesEdge() {
        super(5);
    }

    public final int m22288a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m22289a());
        int b = flatBufferBuilder.b(m22291j());
        int a2 = ModelHelper.a(flatBufferBuilder, m22292k());
        int b2 = flatBufferBuilder.b(m22293l());
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLTrendingEntitiesEdge(Parcel parcel) {
        super(5);
        this.f13362d = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
        this.f13363e = parcel.readString();
        this.f13364f = (GraphQLGraphSearchQuery) parcel.readValue(GraphQLGraphSearchQuery.class.getClassLoader());
        this.f13365g = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m22289a());
        parcel.writeString(m22291j());
        parcel.writeValue(m22292k());
        parcel.writeString(m22293l());
    }
}
