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
import com.facebook.graphql.deserializers.GraphQLGraphSearchResultsConnectionDeserializer;
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
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: fullindex_education_info */
public final class GraphQLGraphSearchResultsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGraphSearchResultsConnection> CREATOR = new C03801();
    public int f4110d;
    public List<GraphQLGraphSearchResultsEdge> f4111e;
    public List<GraphQLNode> f4112f;
    @Nullable
    public GraphQLPageInfo f4113g;

    /* compiled from: fullindex_education_info */
    final class C03801 implements Creator<GraphQLGraphSearchResultsConnection> {
        C03801() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGraphSearchResultsConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGraphSearchResultsConnection[i];
        }
    }

    /* compiled from: fullindex_education_info */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchResultsConnection.class, new Deserializer());
        }

        public Object m8286a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGraphSearchResultsConnectionDeserializer.m5110a(jsonParser, (short) 467);
            Object graphQLGraphSearchResultsConnection = new GraphQLGraphSearchResultsConnection();
            ((BaseModel) graphQLGraphSearchResultsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGraphSearchResultsConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLGraphSearchResultsConnection).a();
            }
            return graphQLGraphSearchResultsConnection;
        }
    }

    /* compiled from: fullindex_education_info */
    public final class Serializer extends JsonSerializer<GraphQLGraphSearchResultsConnection> {
        public final void m8287a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGraphSearchResultsConnection graphQLGraphSearchResultsConnection = (GraphQLGraphSearchResultsConnection) obj;
            GraphQLGraphSearchResultsConnectionDeserializer.m5111a(graphQLGraphSearchResultsConnection.w_(), graphQLGraphSearchResultsConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGraphSearchResultsConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLGraphSearchResultsConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final int m8288a() {
        a(0, 0);
        return this.f4110d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLGraphSearchResultsEdge> m8292j() {
        this.f4111e = super.a(this.f4111e, 1, GraphQLGraphSearchResultsEdge.class);
        return (ImmutableList) this.f4111e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLNode> m8293k() {
        this.f4112f = super.a(this.f4112f, 2, GraphQLNode.class);
        return (ImmutableList) this.f4112f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m8294l() {
        this.f4113g = (GraphQLPageInfo) super.a(this.f4113g, 3, GraphQLPageInfo.class);
        return this.f4113g;
    }

    public final int jK_() {
        return 1580207518;
    }

    public final GraphQLVisitableModel m8290a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8292j() != null) {
            a = ModelHelper.a(m8292j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLGraphSearchResultsConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f4111e = a.b();
            }
        }
        if (m8293k() != null) {
            a = ModelHelper.a(m8293k(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLGraphSearchResultsConnection) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4112f = a.b();
            }
        }
        GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
        if (m8294l() != null) {
            GraphQLPageInfo graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m8294l());
            if (m8294l() != graphQLPageInfo) {
                graphQLVisitableModel2 = (GraphQLGraphSearchResultsConnection) ModelHelper.a(graphQLVisitableModel2, this);
                graphQLVisitableModel2.f4113g = graphQLPageInfo;
            }
        }
        i();
        return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
    }

    public GraphQLGraphSearchResultsConnection() {
        super(5);
    }

    public final void m8291a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f4110d = mutableFlatBuffer.a(i, 0, 0);
    }

    public final int m8289a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8292j());
        int a2 = ModelHelper.a(flatBufferBuilder, m8293k());
        int a3 = ModelHelper.a(flatBufferBuilder, m8294l());
        flatBufferBuilder.c(4);
        flatBufferBuilder.a(0, m8288a(), 0);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, a3);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGraphSearchResultsConnection(Parcel parcel) {
        super(5);
        this.f4110d = parcel.readInt();
        this.f4111e = ImmutableListHelper.a(parcel.readArrayList(GraphQLGraphSearchResultsEdge.class.getClassLoader()));
        this.f4112f = ImmutableListHelper.a(parcel.readArrayList(GraphQLNode.class.getClassLoader()));
        this.f4113g = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m8288a());
        parcel.writeList(m8292j());
        parcel.writeList(m8293k());
        parcel.writeValue(m8294l());
    }
}
