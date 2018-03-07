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
import com.facebook.graphql.deserializers.GraphQLQuotesAnalysisItemsConnectionDeserializer;
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
/* compiled from: VIEW_FUNDRAISER_SUPPORTERS */
public final class GraphQLQuotesAnalysisItemsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLQuotesAnalysisItemsConnection> CREATOR = new C12001();
    public List<GraphQLQuotesAnalysisItemsEdge> f12879d;

    /* compiled from: VIEW_FUNDRAISER_SUPPORTERS */
    final class C12001 implements Creator<GraphQLQuotesAnalysisItemsConnection> {
        C12001() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLQuotesAnalysisItemsConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLQuotesAnalysisItemsConnection[i];
        }
    }

    /* compiled from: VIEW_FUNDRAISER_SUPPORTERS */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLQuotesAnalysisItemsConnection.class, new Deserializer());
        }

        public Object m21283a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLQuotesAnalysisItemsConnectionDeserializer.m5773a(jsonParser, (short) 486);
            Object graphQLQuotesAnalysisItemsConnection = new GraphQLQuotesAnalysisItemsConnection();
            ((BaseModel) graphQLQuotesAnalysisItemsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLQuotesAnalysisItemsConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLQuotesAnalysisItemsConnection).a();
            }
            return graphQLQuotesAnalysisItemsConnection;
        }
    }

    /* compiled from: VIEW_FUNDRAISER_SUPPORTERS */
    public final class Serializer extends JsonSerializer<GraphQLQuotesAnalysisItemsConnection> {
        public final void m21284a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLQuotesAnalysisItemsConnection graphQLQuotesAnalysisItemsConnection = (GraphQLQuotesAnalysisItemsConnection) obj;
            GraphQLQuotesAnalysisItemsConnectionDeserializer.m5774a(graphQLQuotesAnalysisItemsConnection.w_(), graphQLQuotesAnalysisItemsConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLQuotesAnalysisItemsConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLQuotesAnalysisItemsConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLQuotesAnalysisItemsEdge> m21287a() {
        this.f12879d = super.a(this.f12879d, 0, GraphQLQuotesAnalysisItemsEdge.class);
        return (ImmutableList) this.f12879d;
    }

    public final int jK_() {
        return -1049197397;
    }

    public final GraphQLVisitableModel m21286a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21287a() != null) {
            Builder a = ModelHelper.a(m21287a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLQuotesAnalysisItemsConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f12879d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLQuotesAnalysisItemsConnection() {
        super(2);
    }

    public final int m21285a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21287a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLQuotesAnalysisItemsConnection(Parcel parcel) {
        super(2);
        this.f12879d = ImmutableListHelper.a(parcel.readArrayList(GraphQLQuotesAnalysisItemsEdge.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m21287a());
    }
}
