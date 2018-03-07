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
import com.facebook.graphql.deserializers.GraphQLPlacesTileResultsConnectionDeserializer;
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
/* compiled from: WASTE_MANAGEMENT */
public final class GraphQLPlacesTileResultsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPlacesTileResultsConnection> CREATOR = new C11821();
    public List<GraphQLPlacesTileResultsEdge> f12670d;

    /* compiled from: WASTE_MANAGEMENT */
    final class C11821 implements Creator<GraphQLPlacesTileResultsConnection> {
        C11821() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPlacesTileResultsConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPlacesTileResultsConnection[i];
        }
    }

    /* compiled from: WASTE_MANAGEMENT */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLPlacesTileResultsConnection.class, new Deserializer());
        }

        public Object m20924a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLPlacesTileResultsConnectionDeserializer.m5674a(jsonParser, (short) 440);
            Object graphQLPlacesTileResultsConnection = new GraphQLPlacesTileResultsConnection();
            ((BaseModel) graphQLPlacesTileResultsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLPlacesTileResultsConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLPlacesTileResultsConnection).a();
            }
            return graphQLPlacesTileResultsConnection;
        }
    }

    /* compiled from: WASTE_MANAGEMENT */
    public final class Serializer extends JsonSerializer<GraphQLPlacesTileResultsConnection> {
        public final void m20925a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLPlacesTileResultsConnection graphQLPlacesTileResultsConnection = (GraphQLPlacesTileResultsConnection) obj;
            GraphQLPlacesTileResultsConnectionDeserializer.m5675a(graphQLPlacesTileResultsConnection.w_(), graphQLPlacesTileResultsConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLPlacesTileResultsConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLPlacesTileResultsConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLPlacesTileResultsEdge> m20928a() {
        this.f12670d = super.a(this.f12670d, 0, GraphQLPlacesTileResultsEdge.class);
        return (ImmutableList) this.f12670d;
    }

    public final int jK_() {
        return 411881818;
    }

    public final GraphQLVisitableModel m20927a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m20928a() != null) {
            Builder a = ModelHelper.a(m20928a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLPlacesTileResultsConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f12670d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPlacesTileResultsConnection() {
        super(2);
    }

    public final int m20926a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m20928a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPlacesTileResultsConnection(Parcel parcel) {
        super(2);
        this.f12670d = ImmutableListHelper.a(parcel.readArrayList(GraphQLPlacesTileResultsEdge.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m20928a());
    }
}
