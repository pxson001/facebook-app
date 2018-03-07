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
import com.facebook.graphql.deserializers.GraphQLNearbyPlacesBrowsePlaceResultsConnectionDeserializer;
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
/* compiled from: expired */
public final class GraphQLNearbyPlacesBrowsePlaceResultsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLNearbyPlacesBrowsePlaceResultsConnection> CREATOR = new C04431();
    @Nullable
    GraphQLGeoRectangle f4537d;
    @Nullable
    GraphQLPageInfo f4538e;
    @Nullable
    String f4539f;

    /* compiled from: expired */
    final class C04431 implements Creator<GraphQLNearbyPlacesBrowsePlaceResultsConnection> {
        C04431() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLNearbyPlacesBrowsePlaceResultsConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLNearbyPlacesBrowsePlaceResultsConnection[i];
        }
    }

    /* compiled from: expired */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLNearbyPlacesBrowsePlaceResultsConnection.class, new Deserializer());
        }

        public Object m9199a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLNearbyPlacesBrowsePlaceResultsConnectionDeserializer.m5404a(jsonParser, (short) 447);
            Object graphQLNearbyPlacesBrowsePlaceResultsConnection = new GraphQLNearbyPlacesBrowsePlaceResultsConnection();
            ((BaseModel) graphQLNearbyPlacesBrowsePlaceResultsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLNearbyPlacesBrowsePlaceResultsConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLNearbyPlacesBrowsePlaceResultsConnection).a();
            }
            return graphQLNearbyPlacesBrowsePlaceResultsConnection;
        }
    }

    /* compiled from: expired */
    public final class Serializer extends JsonSerializer<GraphQLNearbyPlacesBrowsePlaceResultsConnection> {
        public final void m9200a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLNearbyPlacesBrowsePlaceResultsConnection graphQLNearbyPlacesBrowsePlaceResultsConnection = (GraphQLNearbyPlacesBrowsePlaceResultsConnection) obj;
            GraphQLNearbyPlacesBrowsePlaceResultsConnectionDeserializer.m5405a(graphQLNearbyPlacesBrowsePlaceResultsConnection.w_(), graphQLNearbyPlacesBrowsePlaceResultsConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLNearbyPlacesBrowsePlaceResultsConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLNearbyPlacesBrowsePlaceResultsConnection.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLGeoRectangle m9202a() {
        this.f4537d = (GraphQLGeoRectangle) super.a(this.f4537d, 0, GraphQLGeoRectangle.class);
        return this.f4537d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m9204j() {
        this.f4538e = (GraphQLPageInfo) super.a(this.f4538e, 1, GraphQLPageInfo.class);
        return this.f4538e;
    }

    @FieldOffset
    @Nullable
    public final String m9205k() {
        this.f4539f = super.a(this.f4539f, 2);
        return this.f4539f;
    }

    public final int jK_() {
        return -1988813374;
    }

    public final GraphQLVisitableModel m9203a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m9202a() != null) {
            GraphQLGeoRectangle graphQLGeoRectangle = (GraphQLGeoRectangle) graphQLModelMutatingVisitor.b(m9202a());
            if (m9202a() != graphQLGeoRectangle) {
                graphQLVisitableModel = (GraphQLNearbyPlacesBrowsePlaceResultsConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f4537d = graphQLGeoRectangle;
            }
        }
        if (m9204j() != null) {
            GraphQLPageInfo graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m9204j());
            if (m9204j() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLNearbyPlacesBrowsePlaceResultsConnection) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4538e = graphQLPageInfo;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLNearbyPlacesBrowsePlaceResultsConnection() {
        super(4);
    }

    public final int m9201a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m9202a());
        int a2 = ModelHelper.a(flatBufferBuilder, m9204j());
        int b = flatBufferBuilder.b(m9205k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLNearbyPlacesBrowsePlaceResultsConnection(Parcel parcel) {
        super(4);
        this.f4537d = (GraphQLGeoRectangle) parcel.readValue(GraphQLGeoRectangle.class.getClassLoader());
        this.f4538e = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
        this.f4539f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m9202a());
        parcel.writeValue(m9204j());
        parcel.writeString(m9205k());
    }
}
