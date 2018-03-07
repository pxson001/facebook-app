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
import com.facebook.graphql.deserializers.GraphQLBudgetRecommendationsConnectionDeserializer;
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
/* compiled from: is_in_low_engagement_block */
public final class GraphQLBudgetRecommendationsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLBudgetRecommendationsConnection> CREATOR = new C02781();
    public int f3405d;
    public List<GraphQLBudgetRecommendationsEdge> f3406e;

    /* compiled from: is_in_low_engagement_block */
    final class C02781 implements Creator<GraphQLBudgetRecommendationsConnection> {
        C02781() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLBudgetRecommendationsConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLBudgetRecommendationsConnection[i];
        }
    }

    /* compiled from: is_in_low_engagement_block */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLBudgetRecommendationsConnection.class, new Deserializer());
        }

        public Object m6679a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLBudgetRecommendationsConnectionDeserializer.m4622a(jsonParser, (short) 256);
            Object graphQLBudgetRecommendationsConnection = new GraphQLBudgetRecommendationsConnection();
            ((BaseModel) graphQLBudgetRecommendationsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLBudgetRecommendationsConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLBudgetRecommendationsConnection).a();
            }
            return graphQLBudgetRecommendationsConnection;
        }
    }

    /* compiled from: is_in_low_engagement_block */
    public final class Serializer extends JsonSerializer<GraphQLBudgetRecommendationsConnection> {
        public final void m6680a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLBudgetRecommendationsConnection graphQLBudgetRecommendationsConnection = (GraphQLBudgetRecommendationsConnection) obj;
            GraphQLBudgetRecommendationsConnectionDeserializer.m4623a(graphQLBudgetRecommendationsConnection.w_(), graphQLBudgetRecommendationsConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLBudgetRecommendationsConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLBudgetRecommendationsConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final int m6681a() {
        a(0, 0);
        return this.f3405d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLBudgetRecommendationsEdge> m6685j() {
        this.f3406e = super.a(this.f3406e, 1, GraphQLBudgetRecommendationsEdge.class);
        return (ImmutableList) this.f3406e;
    }

    public final int jK_() {
        return -916555149;
    }

    public final GraphQLVisitableModel m6683a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6685j() != null) {
            Builder a = ModelHelper.a(m6685j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLBudgetRecommendationsConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f3406e = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLBudgetRecommendationsConnection() {
        super(3);
    }

    public final void m6684a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3405d = mutableFlatBuffer.a(i, 0, 0);
    }

    public final int m6682a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m6685j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.a(0, m6681a(), 0);
        flatBufferBuilder.b(1, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLBudgetRecommendationsConnection(Parcel parcel) {
        super(3);
        this.f3405d = parcel.readInt();
        this.f3406e = ImmutableListHelper.a(parcel.readArrayList(GraphQLBudgetRecommendationsEdge.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m6681a());
        parcel.writeList(m6685j());
    }
}
