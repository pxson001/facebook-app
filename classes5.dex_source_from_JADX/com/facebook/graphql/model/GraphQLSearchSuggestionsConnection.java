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
import com.facebook.graphql.deserializers.GraphQLSearchSuggestionsConnectionDeserializer;
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
/* compiled from: VERTEX_PAGE */
public final class GraphQLSearchSuggestionsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLSearchSuggestionsConnection> CREATOR = new C12211();
    public List<GraphQLSearchSuggestionsEdge> f13016d;

    /* compiled from: VERTEX_PAGE */
    final class C12211 implements Creator<GraphQLSearchSuggestionsConnection> {
        C12211() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSearchSuggestionsConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSearchSuggestionsConnection[i];
        }
    }

    /* compiled from: VERTEX_PAGE */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLSearchSuggestionsConnection.class, new Deserializer());
        }

        public Object m21610a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLSearchSuggestionsConnectionDeserializer.m5872a(jsonParser, (short) 490);
            Object graphQLSearchSuggestionsConnection = new GraphQLSearchSuggestionsConnection();
            ((BaseModel) graphQLSearchSuggestionsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLSearchSuggestionsConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLSearchSuggestionsConnection).a();
            }
            return graphQLSearchSuggestionsConnection;
        }
    }

    /* compiled from: VERTEX_PAGE */
    public final class Serializer extends JsonSerializer<GraphQLSearchSuggestionsConnection> {
        public final void m21611a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLSearchSuggestionsConnection graphQLSearchSuggestionsConnection = (GraphQLSearchSuggestionsConnection) obj;
            GraphQLSearchSuggestionsConnectionDeserializer.m5873a(graphQLSearchSuggestionsConnection.w_(), graphQLSearchSuggestionsConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLSearchSuggestionsConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLSearchSuggestionsConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLSearchSuggestionsEdge> m21614a() {
        this.f13016d = super.a(this.f13016d, 0, GraphQLSearchSuggestionsEdge.class);
        return (ImmutableList) this.f13016d;
    }

    public final int jK_() {
        return 649829957;
    }

    public final GraphQLVisitableModel m21613a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21614a() != null) {
            Builder a = ModelHelper.a(m21614a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLSearchSuggestionsConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f13016d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLSearchSuggestionsConnection() {
        super(2);
    }

    public final int m21612a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21614a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLSearchSuggestionsConnection(Parcel parcel) {
        super(2);
        this.f13016d = ImmutableListHelper.a(parcel.readArrayList(GraphQLSearchSuggestionsEdge.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m21614a());
    }
}
