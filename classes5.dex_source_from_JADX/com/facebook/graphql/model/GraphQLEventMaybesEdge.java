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
import com.facebook.graphql.deserializers.GraphQLEventMaybesEdgeDeserializer;
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
/* compiled from: inapp_browser_prefetch_vpv_duration_threshold_wifi */
public final class GraphQLEventMaybesEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEventMaybesEdge> CREATOR = new C03121();
    @Nullable
    GraphQLActor f3644d;
    long f3645e;
    GraphQLEventSeenState f3646f;

    /* compiled from: inapp_browser_prefetch_vpv_duration_threshold_wifi */
    final class C03121 implements Creator<GraphQLEventMaybesEdge> {
        C03121() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEventMaybesEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEventMaybesEdge[i];
        }
    }

    /* compiled from: inapp_browser_prefetch_vpv_duration_threshold_wifi */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        @Nullable
        public GraphQLActor f3641d;
        public long f3642e;
        public GraphQLEventSeenState f3643f = GraphQLEventSeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }
    }

    /* compiled from: inapp_browser_prefetch_vpv_duration_threshold_wifi */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLEventMaybesEdge.class, new Deserializer());
        }

        public Object m7227a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLEventMaybesEdgeDeserializer.m4814a(jsonParser, (short) 308);
            Object graphQLEventMaybesEdge = new GraphQLEventMaybesEdge();
            ((BaseModel) graphQLEventMaybesEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLEventMaybesEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLEventMaybesEdge).a();
            }
            return graphQLEventMaybesEdge;
        }
    }

    /* compiled from: inapp_browser_prefetch_vpv_duration_threshold_wifi */
    public final class Serializer extends JsonSerializer<GraphQLEventMaybesEdge> {
        public final void m7228a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLEventMaybesEdge graphQLEventMaybesEdge = (GraphQLEventMaybesEdge) obj;
            GraphQLEventMaybesEdgeDeserializer.m4816b(graphQLEventMaybesEdge.w_(), graphQLEventMaybesEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLEventMaybesEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLEventMaybesEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor m7230a() {
        this.f3644d = (GraphQLActor) super.a(this.f3644d, 0, GraphQLActor.class);
        return this.f3644d;
    }

    @FieldOffset
    public final long m7233j() {
        a(0, 1);
        return this.f3645e;
    }

    @FieldOffset
    public final GraphQLEventSeenState m7234k() {
        this.f3646f = (GraphQLEventSeenState) super.a(this.f3646f, 2, GraphQLEventSeenState.class, GraphQLEventSeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f3646f;
    }

    public final int jK_() {
        return -395635838;
    }

    public final GraphQLVisitableModel m7231a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7230a() != null) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.b(m7230a());
            if (m7230a() != graphQLActor) {
                graphQLVisitableModel = (GraphQLEventMaybesEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f3644d = graphQLActor;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEventMaybesEdge() {
        super(4);
    }

    public final void m7232a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3645e = mutableFlatBuffer.a(i, 1, 0);
    }

    public final int m7229a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7230a());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.a(1, m7233j(), 0);
        flatBufferBuilder.a(2, m7234k() == GraphQLEventSeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m7234k());
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLEventMaybesEdge(Parcel parcel) {
        super(4);
        this.f3644d = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
        this.f3645e = parcel.readLong();
        this.f3646f = GraphQLEventSeenState.fromString(parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m7230a());
        parcel.writeLong(m7233j());
        parcel.writeString(m7234k().name());
    }

    public GraphQLEventMaybesEdge(Builder builder) {
        super(4);
        this.b = builder.a;
        this.c = builder.b;
        this.f3644d = builder.f3641d;
        this.f3645e = builder.f3642e;
        this.f3646f = builder.f3643f;
    }
}
