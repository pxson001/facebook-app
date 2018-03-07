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
import com.facebook.graphql.deserializers.GraphQLEventInviteesEdgeDeserializer;
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
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: info_fields */
public final class GraphQLEventInviteesEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEventInviteesEdge> CREATOR = new C03111();
    @Nullable
    GraphQLActor f3634d;
    GraphQLEventSeenState f3635e;

    /* compiled from: info_fields */
    final class C03111 implements Creator<GraphQLEventInviteesEdge> {
        C03111() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEventInviteesEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEventInviteesEdge[i];
        }
    }

    /* compiled from: info_fields */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLEventInviteesEdge.class, new Deserializer());
        }

        public Object m7209a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLEventInviteesEdgeDeserializer.m4807a(jsonParser, (short) 311);
            Object graphQLEventInviteesEdge = new GraphQLEventInviteesEdge();
            ((BaseModel) graphQLEventInviteesEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLEventInviteesEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLEventInviteesEdge).a();
            }
            return graphQLEventInviteesEdge;
        }
    }

    /* compiled from: info_fields */
    public final class Serializer extends JsonSerializer<GraphQLEventInviteesEdge> {
        public final void m7210a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLEventInviteesEdge graphQLEventInviteesEdge = (GraphQLEventInviteesEdge) obj;
            GraphQLEventInviteesEdgeDeserializer.m4809b(graphQLEventInviteesEdge.w_(), graphQLEventInviteesEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLEventInviteesEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLEventInviteesEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor m7212a() {
        this.f3634d = (GraphQLActor) super.a(this.f3634d, 0, GraphQLActor.class);
        return this.f3634d;
    }

    @FieldOffset
    public final GraphQLEventSeenState m7214j() {
        this.f3635e = (GraphQLEventSeenState) super.a(this.f3635e, 1, GraphQLEventSeenState.class, GraphQLEventSeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f3635e;
    }

    public final int jK_() {
        return -2067342482;
    }

    public final GraphQLVisitableModel m7213a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7212a() != null) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.b(m7212a());
            if (m7212a() != graphQLActor) {
                graphQLVisitableModel = (GraphQLEventInviteesEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f3634d = graphQLActor;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEventInviteesEdge() {
        super(3);
    }

    public final int m7211a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7212a());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.a(1, m7214j() == GraphQLEventSeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m7214j());
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLEventInviteesEdge(Parcel parcel) {
        super(3);
        this.f3634d = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
        this.f3635e = GraphQLEventSeenState.fromString(parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m7212a());
        parcel.writeString(m7214j().name());
    }
}
