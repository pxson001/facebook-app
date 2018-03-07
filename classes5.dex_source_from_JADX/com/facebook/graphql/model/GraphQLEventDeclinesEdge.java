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
import com.facebook.graphql.deserializers.GraphQLEventDeclinesEdgeDeserializer;
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
/* compiled from: initializeRecorder/stopPreview failed */
public final class GraphQLEventDeclinesEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEventDeclinesEdge> CREATOR = new C03091();
    boolean f3629d;
    @Nullable
    GraphQLActor f3630e;
    long f3631f;
    GraphQLEventSeenState f3632g;

    /* compiled from: initializeRecorder/stopPreview failed */
    final class C03091 implements Creator<GraphQLEventDeclinesEdge> {
        C03091() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEventDeclinesEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEventDeclinesEdge[i];
        }
    }

    /* compiled from: initializeRecorder/stopPreview failed */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLEventDeclinesEdge.class, new Deserializer());
        }

        public Object m7172a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLEventDeclinesEdgeDeserializer.m4789a(jsonParser, (short) 315);
            Object graphQLEventDeclinesEdge = new GraphQLEventDeclinesEdge();
            ((BaseModel) graphQLEventDeclinesEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLEventDeclinesEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLEventDeclinesEdge).a();
            }
            return graphQLEventDeclinesEdge;
        }
    }

    /* compiled from: initializeRecorder/stopPreview failed */
    public final class Serializer extends JsonSerializer<GraphQLEventDeclinesEdge> {
        public final void m7173a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLEventDeclinesEdge graphQLEventDeclinesEdge = (GraphQLEventDeclinesEdge) obj;
            GraphQLEventDeclinesEdgeDeserializer.m4791b(graphQLEventDeclinesEdge.w_(), graphQLEventDeclinesEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLEventDeclinesEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLEventDeclinesEdge.class, new Serializer());
        }
    }

    @FieldOffset
    public final boolean m7177a() {
        a(0, 0);
        return this.f3629d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor m7178j() {
        this.f3630e = (GraphQLActor) super.a(this.f3630e, 1, GraphQLActor.class);
        return this.f3630e;
    }

    @FieldOffset
    public final long m7179k() {
        a(0, 2);
        return this.f3631f;
    }

    @FieldOffset
    public final GraphQLEventSeenState m7180l() {
        this.f3632g = (GraphQLEventSeenState) super.a(this.f3632g, 3, GraphQLEventSeenState.class, GraphQLEventSeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f3632g;
    }

    public final int jK_() {
        return 587818804;
    }

    public final GraphQLVisitableModel m7175a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7178j() != null) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.b(m7178j());
            if (m7178j() != graphQLActor) {
                graphQLVisitableModel = (GraphQLEventDeclinesEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f3630e = graphQLActor;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEventDeclinesEdge() {
        super(5);
    }

    public final void m7176a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3629d = mutableFlatBuffer.a(i, 0);
        this.f3631f = mutableFlatBuffer.a(i, 2, 0);
    }

    public final int m7174a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7178j());
        flatBufferBuilder.c(4);
        flatBufferBuilder.a(0, m7177a());
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.a(2, m7179k(), 0);
        flatBufferBuilder.a(3, m7180l() == GraphQLEventSeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m7180l());
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLEventDeclinesEdge(Parcel parcel) {
        boolean z = true;
        super(5);
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f3629d = z;
        this.f3630e = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
        this.f3631f = parcel.readLong();
        this.f3632g = GraphQLEventSeenState.fromString(parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (m7177a() ? 1 : 0));
        parcel.writeValue(m7178j());
        parcel.writeLong(m7179k());
        parcel.writeString(m7180l().name());
    }
}
