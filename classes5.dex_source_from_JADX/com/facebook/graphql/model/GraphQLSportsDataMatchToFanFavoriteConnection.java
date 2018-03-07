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
import com.facebook.graphql.deserializers.GraphQLSportsDataMatchToFanFavoriteConnectionDeserializer;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: Unknown image format */
public final class GraphQLSportsDataMatchToFanFavoriteConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLSportsDataMatchToFanFavoriteConnection> CREATOR = new C12351();
    public List<GraphQLSportsDataMatchToFanFavoriteEdge> f13073d;

    /* compiled from: Unknown image format */
    final class C12351 implements Creator<GraphQLSportsDataMatchToFanFavoriteConnection> {
        C12351() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSportsDataMatchToFanFavoriteConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSportsDataMatchToFanFavoriteConnection[i];
        }
    }

    /* compiled from: Unknown image format */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLSportsDataMatchToFanFavoriteConnection.class, new Deserializer());
        }

        public Object m21799a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLSportsDataMatchToFanFavoriteConnectionDeserializer.m5934a(jsonParser, (short) 390);
            Object graphQLSportsDataMatchToFanFavoriteConnection = new GraphQLSportsDataMatchToFanFavoriteConnection();
            ((BaseModel) graphQLSportsDataMatchToFanFavoriteConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLSportsDataMatchToFanFavoriteConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLSportsDataMatchToFanFavoriteConnection).a();
            }
            return graphQLSportsDataMatchToFanFavoriteConnection;
        }
    }

    /* compiled from: Unknown image format */
    public final class Serializer extends JsonSerializer<GraphQLSportsDataMatchToFanFavoriteConnection> {
        public final void m21800a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLSportsDataMatchToFanFavoriteConnection graphQLSportsDataMatchToFanFavoriteConnection = (GraphQLSportsDataMatchToFanFavoriteConnection) obj;
            GraphQLSportsDataMatchToFanFavoriteConnectionDeserializer.m5935a(graphQLSportsDataMatchToFanFavoriteConnection.w_(), graphQLSportsDataMatchToFanFavoriteConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLSportsDataMatchToFanFavoriteConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLSportsDataMatchToFanFavoriteConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLSportsDataMatchToFanFavoriteEdge> m21803a() {
        this.f13073d = super.a(this.f13073d, 0, GraphQLSportsDataMatchToFanFavoriteEdge.class);
        return (ImmutableList) this.f13073d;
    }

    public final int jK_() {
        return -1922444458;
    }

    public final GraphQLVisitableModel m21802a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21803a() != null) {
            Builder a = ModelHelper.a(m21803a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLSportsDataMatchToFanFavoriteConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f13073d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLSportsDataMatchToFanFavoriteConnection() {
        super(2);
    }

    public final int m21801a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21803a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLSportsDataMatchToFanFavoriteConnection(Parcel parcel) {
        super(2);
        this.f13073d = ImmutableListHelper.a(parcel.readArrayList(GraphQLSportsDataMatchToFanFavoriteEdge.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m21803a());
    }
}
