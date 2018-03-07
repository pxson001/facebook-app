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
import com.facebook.graphql.deserializers.GraphQLNearbySearchQueryDeserializer;
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
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: expirationTime */
public final class GraphQLNearbySearchQuery extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLNearbySearchQuery> CREATOR = new C04441();
    @Nullable
    GraphQLNearbyPlacesBrowsePlaceResultsConnection f4540d;
    List<String> f4541e;
    @Deprecated
    @Nullable
    String f4542f;

    /* compiled from: expirationTime */
    final class C04441 implements Creator<GraphQLNearbySearchQuery> {
        C04441() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLNearbySearchQuery(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLNearbySearchQuery[i];
        }
    }

    /* compiled from: expirationTime */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLNearbySearchQuery.class, new Deserializer());
        }

        public Object m9211a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLNearbySearchQueryDeserializer.m5407a(jsonParser, (short) 443);
            Object graphQLNearbySearchQuery = new GraphQLNearbySearchQuery();
            ((BaseModel) graphQLNearbySearchQuery).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLNearbySearchQuery instanceof Postprocessable) {
                return ((Postprocessable) graphQLNearbySearchQuery).a();
            }
            return graphQLNearbySearchQuery;
        }
    }

    /* compiled from: expirationTime */
    public final class Serializer extends JsonSerializer<GraphQLNearbySearchQuery> {
        public final void m9212a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLNearbySearchQuery graphQLNearbySearchQuery = (GraphQLNearbySearchQuery) obj;
            GraphQLNearbySearchQueryDeserializer.m5408a(graphQLNearbySearchQuery.w_(), graphQLNearbySearchQuery.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLNearbySearchQuery.class, new Serializer());
            FbSerializerProvider.a(GraphQLNearbySearchQuery.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLNearbyPlacesBrowsePlaceResultsConnection m9214a() {
        this.f4540d = (GraphQLNearbyPlacesBrowsePlaceResultsConnection) super.a(this.f4540d, 0, GraphQLNearbyPlacesBrowsePlaceResultsConnection.class);
        return this.f4540d;
    }

    @FieldOffset
    public final ImmutableList<String> m9216j() {
        this.f4541e = super.a(this.f4541e, 1);
        return (ImmutableList) this.f4541e;
    }

    @FieldOffset
    @Nullable
    public final String m9217k() {
        this.f4542f = super.a(this.f4542f, 2);
        return this.f4542f;
    }

    public final int jK_() {
        return 1725273057;
    }

    public final GraphQLVisitableModel m9215a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m9214a() != null) {
            GraphQLNearbyPlacesBrowsePlaceResultsConnection graphQLNearbyPlacesBrowsePlaceResultsConnection = (GraphQLNearbyPlacesBrowsePlaceResultsConnection) graphQLModelMutatingVisitor.b(m9214a());
            if (m9214a() != graphQLNearbyPlacesBrowsePlaceResultsConnection) {
                graphQLVisitableModel = (GraphQLNearbySearchQuery) ModelHelper.a(null, this);
                graphQLVisitableModel.f4540d = graphQLNearbyPlacesBrowsePlaceResultsConnection;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLNearbySearchQuery() {
        super(4);
    }

    public final int m9213a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m9214a());
        int c = flatBufferBuilder.c(m9216j());
        int b = flatBufferBuilder.b(m9217k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, c);
        flatBufferBuilder.b(2, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLNearbySearchQuery(Parcel parcel) {
        super(4);
        this.f4540d = (GraphQLNearbyPlacesBrowsePlaceResultsConnection) parcel.readValue(GraphQLNearbyPlacesBrowsePlaceResultsConnection.class.getClassLoader());
        this.f4541e = ImmutableListHelper.a(parcel.readArrayList(String.class.getClassLoader()));
        this.f4542f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m9214a());
        parcel.writeList(m9216j());
        parcel.writeString(m9217k());
    }
}
