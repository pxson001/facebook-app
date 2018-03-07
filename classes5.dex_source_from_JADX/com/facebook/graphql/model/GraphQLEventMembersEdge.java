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
import com.facebook.graphql.deserializers.GraphQLEventMembersEdgeDeserializer;
import com.facebook.graphql.enums.GraphQLEventSeenState;
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
import com.google.common.base.Preconditions;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: impression */
public final class GraphQLEventMembersEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEventMembersEdge> CREATOR = new C03131();
    @Nullable
    GraphQLActor f3656d;
    long f3657e;
    GraphQLEventSeenState f3658f;

    /* compiled from: impression */
    final class C03131 implements Creator<GraphQLEventMembersEdge> {
        C03131() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEventMembersEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEventMembersEdge[i];
        }
    }

    /* compiled from: impression */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        @Nullable
        public GraphQLActor f3653d;
        public long f3654e;
        public GraphQLEventSeenState f3655f = GraphQLEventSeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }
    }

    /* compiled from: impression */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLEventMembersEdge.class, new Deserializer());
        }

        public Object m7248a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLEventMembersEdgeDeserializer.m4821a(jsonParser, (short) 309);
            Object graphQLEventMembersEdge = new GraphQLEventMembersEdge();
            ((BaseModel) graphQLEventMembersEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLEventMembersEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLEventMembersEdge).a();
            }
            return graphQLEventMembersEdge;
        }
    }

    /* compiled from: impression */
    public final class Serializer extends JsonSerializer<GraphQLEventMembersEdge> {
        public final void m7249a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLEventMembersEdge graphQLEventMembersEdge = (GraphQLEventMembersEdge) obj;
            GraphQLEventMembersEdgeDeserializer.m4823b(graphQLEventMembersEdge.w_(), graphQLEventMembersEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLEventMembersEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLEventMembersEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor m7251a() {
        this.f3656d = (GraphQLActor) super.a(this.f3656d, 0, GraphQLActor.class);
        return this.f3656d;
    }

    @FieldOffset
    public final long m7254j() {
        a(0, 1);
        return this.f3657e;
    }

    @FieldOffset
    public final GraphQLEventSeenState m7255k() {
        this.f3658f = (GraphQLEventSeenState) super.a(this.f3658f, 2, GraphQLEventSeenState.class, GraphQLEventSeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f3658f;
    }

    public final int jK_() {
        return 61680540;
    }

    public final GraphQLVisitableModel m7252a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7251a() != null) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.b(m7251a());
            if (m7251a() != graphQLActor) {
                graphQLVisitableModel = (GraphQLEventMembersEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f3656d = graphQLActor;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEventMembersEdge() {
        super(4);
    }

    public final void m7253a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3657e = mutableFlatBuffer.a(i, 1, 0);
    }

    public final int m7250a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7251a());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.a(1, m7254j(), 0);
        flatBufferBuilder.a(2, m7255k() == GraphQLEventSeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m7255k());
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLEventMembersEdge(Parcel parcel) {
        super(4);
        this.f3656d = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
        this.f3657e = parcel.readLong();
        this.f3658f = GraphQLEventSeenState.fromString(parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m7251a());
        parcel.writeLong(m7254j());
        parcel.writeString(m7255k().name());
    }

    public GraphQLEventMembersEdge(Builder builder) {
        super(4);
        this.b = builder.a;
        this.c = builder.b;
        this.f3656d = builder.f3653d;
        this.f3657e = builder.f3654e;
        this.f3658f = builder.f3655f;
    }
}
