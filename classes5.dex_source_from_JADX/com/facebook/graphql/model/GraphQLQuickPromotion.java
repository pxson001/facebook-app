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
import com.facebook.graphql.deserializers.GraphQLQuickPromotionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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
/* compiled from: VIEW_PLACE_FEED */
public final class GraphQLQuickPromotion extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLQuickPromotion> CREATOR = new C11911();
    List<GraphQLQuickPromotionCreative> f12843d;
    @Nullable
    String f12844e;
    @Nullable
    GraphQLQuickPromotionTemplate f12845f;
    @Nullable
    GraphQLTextWithEntities f12846g;

    /* compiled from: VIEW_PLACE_FEED */
    final class C11911 implements Creator<GraphQLQuickPromotion> {
        C11911() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLQuickPromotion(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLQuickPromotion[i];
        }
    }

    /* compiled from: VIEW_PLACE_FEED */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLQuickPromotion.class, new Deserializer());
        }

        public Object m21193a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLQuickPromotionDeserializer.m5750a(jsonParser, (short) 91);
            Object graphQLQuickPromotion = new GraphQLQuickPromotion();
            ((BaseModel) graphQLQuickPromotion).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLQuickPromotion instanceof Postprocessable) {
                return ((Postprocessable) graphQLQuickPromotion).a();
            }
            return graphQLQuickPromotion;
        }
    }

    /* compiled from: VIEW_PLACE_FEED */
    public final class Serializer extends JsonSerializer<GraphQLQuickPromotion> {
        public final void m21194a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLQuickPromotion graphQLQuickPromotion = (GraphQLQuickPromotion) obj;
            GraphQLQuickPromotionDeserializer.m5751a(graphQLQuickPromotion.w_(), graphQLQuickPromotion.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLQuickPromotion.class, new Serializer());
            FbSerializerProvider.a(GraphQLQuickPromotion.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLQuickPromotionCreative> m21198j() {
        this.f12843d = super.a(this.f12843d, 0, GraphQLQuickPromotionCreative.class);
        return (ImmutableList) this.f12843d;
    }

    @FieldOffset
    @Nullable
    public final String m21199k() {
        this.f12844e = super.a(this.f12844e, 1);
        return this.f12844e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLQuickPromotionTemplate m21200l() {
        this.f12845f = (GraphQLQuickPromotionTemplate) super.a(this.f12845f, 2, GraphQLQuickPromotionTemplate.class);
        return this.f12845f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m21201m() {
        this.f12846g = (GraphQLTextWithEntities) super.a(this.f12846g, 3, GraphQLTextWithEntities.class);
        return this.f12846g;
    }

    @Nullable
    public final String m21197a() {
        return m21199k();
    }

    public final int jK_() {
        return -1747051178;
    }

    public final GraphQLVisitableModel m21196a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLQuickPromotionTemplate graphQLQuickPromotionTemplate;
        GraphQLTextWithEntities graphQLTextWithEntities;
        h();
        if (m21198j() != null) {
            Builder a = ModelHelper.a(m21198j(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLQuickPromotion graphQLQuickPromotion = (GraphQLQuickPromotion) ModelHelper.a(null, this);
                graphQLQuickPromotion.f12843d = a.b();
                graphQLVisitableModel = graphQLQuickPromotion;
                if (m21200l() != null) {
                    graphQLQuickPromotionTemplate = (GraphQLQuickPromotionTemplate) graphQLModelMutatingVisitor.b(m21200l());
                    if (m21200l() != graphQLQuickPromotionTemplate) {
                        graphQLVisitableModel = (GraphQLQuickPromotion) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12845f = graphQLQuickPromotionTemplate;
                    }
                }
                if (m21201m() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m21201m());
                    if (m21201m() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLQuickPromotion) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12846g = graphQLTextWithEntities;
                    }
                }
                i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m21200l() != null) {
            graphQLQuickPromotionTemplate = (GraphQLQuickPromotionTemplate) graphQLModelMutatingVisitor.b(m21200l());
            if (m21200l() != graphQLQuickPromotionTemplate) {
                graphQLVisitableModel = (GraphQLQuickPromotion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12845f = graphQLQuickPromotionTemplate;
            }
        }
        if (m21201m() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m21201m());
            if (m21201m() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLQuickPromotion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12846g = graphQLTextWithEntities;
            }
        }
        i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLQuickPromotion() {
        super(5);
    }

    public final int m21195a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21198j());
        int b = flatBufferBuilder.b(m21199k());
        int a2 = ModelHelper.a(flatBufferBuilder, m21200l());
        int a3 = ModelHelper.a(flatBufferBuilder, m21201m());
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, a3);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLQuickPromotion(Parcel parcel) {
        super(5);
        this.f12843d = ImmutableListHelper.a(parcel.readArrayList(GraphQLQuickPromotionCreative.class.getClassLoader()));
        this.f12844e = parcel.readString();
        this.f12845f = (GraphQLQuickPromotionTemplate) parcel.readValue(GraphQLQuickPromotionTemplate.class.getClassLoader());
        this.f12846g = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m21198j());
        parcel.writeString(m21199k());
        parcel.writeValue(m21200l());
        parcel.writeValue(m21201m());
    }
}
