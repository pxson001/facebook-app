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
import com.facebook.graphql.deserializers.GraphQLAppAdStoriesSideFeedConnectionDeserializer;
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
/* compiled from: jackson-databind */
public final class GraphQLAppAdStoriesSideFeedConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLAppAdStoriesSideFeedConnection> CREATOR = new C02651();
    public List<GraphQLAppAdStoriesSideFeedEdge> f3346d;

    /* compiled from: jackson-databind */
    final class C02651 implements Creator<GraphQLAppAdStoriesSideFeedConnection> {
        C02651() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLAppAdStoriesSideFeedConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLAppAdStoriesSideFeedConnection[i];
        }
    }

    /* compiled from: jackson-databind */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLAppAdStoriesSideFeedConnection.class, new Deserializer());
        }

        public Object m6542a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLAppAdStoriesSideFeedConnectionDeserializer.m4565a(jsonParser, (short) 494);
            Object graphQLAppAdStoriesSideFeedConnection = new GraphQLAppAdStoriesSideFeedConnection();
            ((BaseModel) graphQLAppAdStoriesSideFeedConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLAppAdStoriesSideFeedConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLAppAdStoriesSideFeedConnection).a();
            }
            return graphQLAppAdStoriesSideFeedConnection;
        }
    }

    /* compiled from: jackson-databind */
    public final class Serializer extends JsonSerializer<GraphQLAppAdStoriesSideFeedConnection> {
        public final void m6543a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLAppAdStoriesSideFeedConnection graphQLAppAdStoriesSideFeedConnection = (GraphQLAppAdStoriesSideFeedConnection) obj;
            GraphQLAppAdStoriesSideFeedConnectionDeserializer.m4566a(graphQLAppAdStoriesSideFeedConnection.w_(), graphQLAppAdStoriesSideFeedConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLAppAdStoriesSideFeedConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLAppAdStoriesSideFeedConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLAppAdStoriesSideFeedEdge> m6546a() {
        this.f3346d = super.a(this.f3346d, 0, GraphQLAppAdStoriesSideFeedEdge.class);
        return (ImmutableList) this.f3346d;
    }

    public final int jK_() {
        return -1440611230;
    }

    public final GraphQLVisitableModel m6545a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6546a() != null) {
            Builder a = ModelHelper.a(m6546a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLAppAdStoriesSideFeedConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f3346d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLAppAdStoriesSideFeedConnection() {
        super(2);
    }

    public final int m6544a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m6546a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLAppAdStoriesSideFeedConnection(Parcel parcel) {
        super(2);
        this.f3346d = ImmutableListHelper.a(parcel.readArrayList(GraphQLAppAdStoriesSideFeedEdge.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m6546a());
    }
}
