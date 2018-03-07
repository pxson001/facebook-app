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
import com.facebook.graphql.deserializers.GraphQLBudgetRecommendationsEdgeDeserializer;
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
/* compiled from: is_hidden_ssid */
public final class GraphQLBudgetRecommendationsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLBudgetRecommendationsEdge> CREATOR = new C02791();
    public boolean f3407d;
    @Nullable
    public GraphQLBudgetRecommendationData f3408e;

    /* compiled from: is_hidden_ssid */
    final class C02791 implements Creator<GraphQLBudgetRecommendationsEdge> {
        C02791() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLBudgetRecommendationsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLBudgetRecommendationsEdge[i];
        }
    }

    /* compiled from: is_hidden_ssid */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLBudgetRecommendationsEdge.class, new Deserializer());
        }

        public Object m6690a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLBudgetRecommendationsEdgeDeserializer.m4625a(jsonParser, (short) 257);
            Object graphQLBudgetRecommendationsEdge = new GraphQLBudgetRecommendationsEdge();
            ((BaseModel) graphQLBudgetRecommendationsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLBudgetRecommendationsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLBudgetRecommendationsEdge).a();
            }
            return graphQLBudgetRecommendationsEdge;
        }
    }

    /* compiled from: is_hidden_ssid */
    public final class Serializer extends JsonSerializer<GraphQLBudgetRecommendationsEdge> {
        public final void m6691a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLBudgetRecommendationsEdge graphQLBudgetRecommendationsEdge = (GraphQLBudgetRecommendationsEdge) obj;
            GraphQLBudgetRecommendationsEdgeDeserializer.m4626b(graphQLBudgetRecommendationsEdge.w_(), graphQLBudgetRecommendationsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLBudgetRecommendationsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLBudgetRecommendationsEdge.class, new Serializer());
        }
    }

    @FieldOffset
    public final boolean m6695a() {
        a(0, 0);
        return this.f3407d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLBudgetRecommendationData m6696j() {
        this.f3408e = (GraphQLBudgetRecommendationData) super.a(this.f3408e, 1, GraphQLBudgetRecommendationData.class);
        return this.f3408e;
    }

    public final int jK_() {
        return -1015087854;
    }

    public final GraphQLVisitableModel m6693a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6696j() != null) {
            GraphQLBudgetRecommendationData graphQLBudgetRecommendationData = (GraphQLBudgetRecommendationData) graphQLModelMutatingVisitor.b(m6696j());
            if (m6696j() != graphQLBudgetRecommendationData) {
                graphQLVisitableModel = (GraphQLBudgetRecommendationsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f3408e = graphQLBudgetRecommendationData;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLBudgetRecommendationsEdge() {
        super(3);
    }

    public final void m6694a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3407d = mutableFlatBuffer.a(i, 0);
    }

    public final int m6692a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m6696j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.a(0, m6695a());
        flatBufferBuilder.b(1, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLBudgetRecommendationsEdge(Parcel parcel) {
        boolean z = true;
        super(3);
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f3407d = z;
        this.f3408e = (GraphQLBudgetRecommendationData) parcel.readValue(GraphQLBudgetRecommendationData.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (m6695a() ? 1 : 0));
        parcel.writeValue(m6696j());
    }
}
