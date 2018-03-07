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
import com.facebook.graphql.deserializers.GraphQLBudgetRecommendationDataDeserializer;
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
/* compiled from: is_linking_verb */
public final class GraphQLBudgetRecommendationData extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLBudgetRecommendationData> CREATOR = new C02771();
    @Deprecated
    int f3402d;
    @Nullable
    GraphQLCurrencyQuantity f3403e;
    int f3404f;

    /* compiled from: is_linking_verb */
    final class C02771 implements Creator<GraphQLBudgetRecommendationData> {
        C02771() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLBudgetRecommendationData(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLBudgetRecommendationData[i];
        }
    }

    /* compiled from: is_linking_verb */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLBudgetRecommendationData.class, new Deserializer());
        }

        public Object m6666a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLBudgetRecommendationDataDeserializer.m4619a(jsonParser, (short) 258);
            Object graphQLBudgetRecommendationData = new GraphQLBudgetRecommendationData();
            ((BaseModel) graphQLBudgetRecommendationData).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLBudgetRecommendationData instanceof Postprocessable) {
                return ((Postprocessable) graphQLBudgetRecommendationData).a();
            }
            return graphQLBudgetRecommendationData;
        }
    }

    /* compiled from: is_linking_verb */
    public final class Serializer extends JsonSerializer<GraphQLBudgetRecommendationData> {
        public final void m6667a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLBudgetRecommendationData graphQLBudgetRecommendationData = (GraphQLBudgetRecommendationData) obj;
            GraphQLBudgetRecommendationDataDeserializer.m4620a(graphQLBudgetRecommendationData.w_(), graphQLBudgetRecommendationData.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLBudgetRecommendationData.class, new Serializer());
            FbSerializerProvider.a(GraphQLBudgetRecommendationData.class, new Serializer());
        }
    }

    @FieldOffset
    public final int m6668a() {
        a(0, 0);
        return this.f3402d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLCurrencyQuantity m6672j() {
        this.f3403e = (GraphQLCurrencyQuantity) super.a(this.f3403e, 1, GraphQLCurrencyQuantity.class);
        return this.f3403e;
    }

    @FieldOffset
    public final int m6673k() {
        a(0, 2);
        return this.f3404f;
    }

    public final int jK_() {
        return -311212216;
    }

    public final GraphQLVisitableModel m6670a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6672j() != null) {
            GraphQLCurrencyQuantity graphQLCurrencyQuantity = (GraphQLCurrencyQuantity) graphQLModelMutatingVisitor.b(m6672j());
            if (m6672j() != graphQLCurrencyQuantity) {
                graphQLVisitableModel = (GraphQLBudgetRecommendationData) ModelHelper.a(null, this);
                graphQLVisitableModel.f3403e = graphQLCurrencyQuantity;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLBudgetRecommendationData() {
        super(4);
    }

    public final void m6671a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3402d = mutableFlatBuffer.a(i, 0, 0);
        this.f3404f = mutableFlatBuffer.a(i, 2, 0);
    }

    public final int m6669a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m6672j());
        flatBufferBuilder.c(3);
        flatBufferBuilder.a(0, m6668a(), 0);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.a(2, m6673k(), 0);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLBudgetRecommendationData(Parcel parcel) {
        super(4);
        this.f3402d = parcel.readInt();
        this.f3403e = (GraphQLCurrencyQuantity) parcel.readValue(GraphQLCurrencyQuantity.class.getClassLoader());
        this.f3404f = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m6668a());
        parcel.writeValue(m6672j());
        parcel.writeInt(m6673k());
    }
}
