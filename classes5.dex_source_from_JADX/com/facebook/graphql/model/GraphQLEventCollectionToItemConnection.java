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
import com.facebook.graphql.deserializers.GraphQLEventCollectionToItemConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
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
import com.google.common.collect.ImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: input_type */
public final class GraphQLEventCollectionToItemConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEventCollectionToItemConnection> CREATOR = new C03071();
    public List<GraphQLStoryAttachment> f3625d;

    /* compiled from: input_type */
    final class C03071 implements Creator<GraphQLEventCollectionToItemConnection> {
        C03071() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEventCollectionToItemConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEventCollectionToItemConnection[i];
        }
    }

    /* compiled from: input_type */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        public ImmutableList<GraphQLStoryAttachment> f3624d;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }
    }

    /* compiled from: input_type */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLEventCollectionToItemConnection.class, new Deserializer());
        }

        public Object m7146a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLEventCollectionToItemConnectionDeserializer.m4780a(jsonParser, (short) 323);
            Object graphQLEventCollectionToItemConnection = new GraphQLEventCollectionToItemConnection();
            ((BaseModel) graphQLEventCollectionToItemConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLEventCollectionToItemConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLEventCollectionToItemConnection).a();
            }
            return graphQLEventCollectionToItemConnection;
        }
    }

    /* compiled from: input_type */
    public final class Serializer extends JsonSerializer<GraphQLEventCollectionToItemConnection> {
        public final void m7147a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLEventCollectionToItemConnection graphQLEventCollectionToItemConnection = (GraphQLEventCollectionToItemConnection) obj;
            GraphQLEventCollectionToItemConnectionDeserializer.m4781a(graphQLEventCollectionToItemConnection.w_(), graphQLEventCollectionToItemConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLEventCollectionToItemConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLEventCollectionToItemConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachment> m7150a() {
        this.f3625d = super.a(this.f3625d, 0, GraphQLStoryAttachment.class);
        return (ImmutableList) this.f3625d;
    }

    public final int jK_() {
        return 1859605124;
    }

    public final GraphQLVisitableModel m7149a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7150a() != null) {
            com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m7150a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLEventCollectionToItemConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f3625d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEventCollectionToItemConnection() {
        super(2);
    }

    public final int m7148a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7150a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLEventCollectionToItemConnection(Parcel parcel) {
        super(2);
        this.f3625d = ImmutableListHelper.a(parcel.readArrayList(GraphQLStoryAttachment.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m7150a());
    }

    public GraphQLEventCollectionToItemConnection(Builder builder) {
        super(2);
        this.b = builder.a;
        this.c = builder.b;
        this.f3625d = builder.f3624d;
    }
}
