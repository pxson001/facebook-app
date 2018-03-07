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
import com.facebook.graphql.deserializers.GraphQLNotificationStoriesDeltaDeserializer;
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
/* compiled from: event_creator */
public final class GraphQLNotificationStoriesDelta extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLNotificationStoriesDelta> CREATOR = new C04531();
    @Nullable
    GraphQLNotificationStoriesEdge f4656d;
    @Nullable
    String f4657e;
    @Nullable
    String f4658f;

    /* compiled from: event_creator */
    final class C04531 implements Creator<GraphQLNotificationStoriesDelta> {
        C04531() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLNotificationStoriesDelta(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLNotificationStoriesDelta[i];
        }
    }

    /* compiled from: event_creator */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLNotificationStoriesDelta.class, new Deserializer());
        }

        public Object m9361a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLNotificationStoriesDeltaDeserializer.m5452a(jsonParser, (short) 450);
            Object graphQLNotificationStoriesDelta = new GraphQLNotificationStoriesDelta();
            ((BaseModel) graphQLNotificationStoriesDelta).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLNotificationStoriesDelta instanceof Postprocessable) {
                return ((Postprocessable) graphQLNotificationStoriesDelta).a();
            }
            return graphQLNotificationStoriesDelta;
        }
    }

    /* compiled from: event_creator */
    public final class Serializer extends JsonSerializer<GraphQLNotificationStoriesDelta> {
        public final void m9362a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLNotificationStoriesDelta graphQLNotificationStoriesDelta = (GraphQLNotificationStoriesDelta) obj;
            GraphQLNotificationStoriesDeltaDeserializer.m5453a(graphQLNotificationStoriesDelta.w_(), graphQLNotificationStoriesDelta.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLNotificationStoriesDelta.class, new Serializer());
            FbSerializerProvider.a(GraphQLNotificationStoriesDelta.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLNotificationStoriesEdge m9364a() {
        this.f4656d = (GraphQLNotificationStoriesEdge) super.a(this.f4656d, 0, GraphQLNotificationStoriesEdge.class);
        return this.f4656d;
    }

    @FieldOffset
    @Nullable
    public final String m9366j() {
        this.f4657e = super.a(this.f4657e, 1);
        return this.f4657e;
    }

    @FieldOffset
    @Nullable
    public final String m9367k() {
        this.f4658f = super.a(this.f4658f, 2);
        return this.f4658f;
    }

    public final int jK_() {
        return -185950256;
    }

    public final GraphQLVisitableModel m9365a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m9364a() != null) {
            GraphQLNotificationStoriesEdge graphQLNotificationStoriesEdge = (GraphQLNotificationStoriesEdge) graphQLModelMutatingVisitor.b(m9364a());
            if (m9364a() != graphQLNotificationStoriesEdge) {
                graphQLVisitableModel = (GraphQLNotificationStoriesDelta) ModelHelper.a(null, this);
                graphQLVisitableModel.f4656d = graphQLNotificationStoriesEdge;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLNotificationStoriesDelta() {
        super(4);
    }

    public final int m9363a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m9364a());
        int b = flatBufferBuilder.b(m9366j());
        int b2 = flatBufferBuilder.b(m9367k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLNotificationStoriesDelta(Parcel parcel) {
        super(4);
        this.f4656d = (GraphQLNotificationStoriesEdge) parcel.readValue(GraphQLNotificationStoriesEdge.class.getClassLoader());
        this.f4657e = parcel.readString();
        this.f4658f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m9364a());
        parcel.writeString(m9366j());
        parcel.writeString(m9367k());
    }
}
