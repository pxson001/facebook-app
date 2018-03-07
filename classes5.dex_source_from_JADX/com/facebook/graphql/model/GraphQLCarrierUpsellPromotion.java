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
import com.facebook.graphql.deserializers.GraphQLCarrierUpsellPromotionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
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
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: is_eligible_for_page_verification */
public final class GraphQLCarrierUpsellPromotion extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLCarrierUpsellPromotion> CREATOR = new C02801();
    @Nullable
    public String f3409d;
    @Nullable
    public String f3410e;
    @Nullable
    public GraphQLImage f3411f;
    public double f3412g;
    @Nullable
    public String f3413h;
    @Nullable
    public GraphQLImage f3414i;
    @Deprecated
    @Nullable
    public GraphQLInlineActivitiesConnection f3415j;
    public boolean f3416k;
    @Nullable
    public String f3417l;
    @Nullable
    public GraphQLImage f3418m;
    @Nullable
    public GraphQLImage f3419n;
    @Nullable
    public GraphQLImage f3420o;
    @Nullable
    public GraphQLImage f3421p;
    @Nullable
    public GraphQLImage f3422q;
    @Nullable
    public GraphQLPhoto f3423r;
    @Nullable
    public GraphQLImage f3424s;
    public boolean f3425t;
    @Nullable
    public GraphQLStreamingImage f3426u;
    @Nullable
    public GraphQLImage f3427v;
    @Nullable
    public GraphQLTextWithEntities f3428w;
    @Nullable
    public GraphQLTextWithEntities f3429x;
    @Nullable
    public String f3430y;

    /* compiled from: is_eligible_for_page_verification */
    final class C02801 implements Creator<GraphQLCarrierUpsellPromotion> {
        C02801() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLCarrierUpsellPromotion(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLCarrierUpsellPromotion[i];
        }
    }

    /* compiled from: is_eligible_for_page_verification */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLCarrierUpsellPromotion.class, new Deserializer());
        }

        public Object m6713a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLCarrierUpsellPromotionDeserializer.m4638a(jsonParser, (short) 107);
            Object graphQLCarrierUpsellPromotion = new GraphQLCarrierUpsellPromotion();
            ((BaseModel) graphQLCarrierUpsellPromotion).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLCarrierUpsellPromotion instanceof Postprocessable) {
                return ((Postprocessable) graphQLCarrierUpsellPromotion).a();
            }
            return graphQLCarrierUpsellPromotion;
        }
    }

    /* compiled from: is_eligible_for_page_verification */
    public final class Serializer extends JsonSerializer<GraphQLCarrierUpsellPromotion> {
        public final void m6714a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLCarrierUpsellPromotion graphQLCarrierUpsellPromotion = (GraphQLCarrierUpsellPromotion) obj;
            GraphQLCarrierUpsellPromotionDeserializer.m4639a(graphQLCarrierUpsellPromotion.w_(), graphQLCarrierUpsellPromotion.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLCarrierUpsellPromotion.class, new Serializer());
            FbSerializerProvider.a(GraphQLCarrierUpsellPromotion.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m6724j() {
        this.f3409d = super.a(this.f3409d, 0);
        return this.f3409d;
    }

    @FieldOffset
    @Nullable
    public final String m6725k() {
        this.f3410e = super.a(this.f3410e, 1);
        return this.f3410e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m6726l() {
        this.f3411f = (GraphQLImage) super.a(this.f3411f, 2, GraphQLImage.class);
        return this.f3411f;
    }

    @FieldOffset
    public final double m6727m() {
        a(0, 3);
        return this.f3412g;
    }

    @FieldOffset
    @Nullable
    public final String m6728n() {
        this.f3413h = super.a(this.f3413h, 4);
        return this.f3413h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m6729o() {
        this.f3414i = (GraphQLImage) super.a(this.f3414i, 5, GraphQLImage.class);
        return this.f3414i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInlineActivitiesConnection m6730p() {
        this.f3415j = (GraphQLInlineActivitiesConnection) super.a(this.f3415j, 6, GraphQLInlineActivitiesConnection.class);
        return this.f3415j;
    }

    @FieldOffset
    public final boolean m6731q() {
        a(0, 7);
        return this.f3416k;
    }

    @FieldOffset
    @Nullable
    public final String m6732r() {
        this.f3417l = super.a(this.f3417l, 8);
        return this.f3417l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m6733s() {
        this.f3418m = (GraphQLImage) super.a(this.f3418m, 9, GraphQLImage.class);
        return this.f3418m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m6734t() {
        this.f3419n = (GraphQLImage) super.a(this.f3419n, 10, GraphQLImage.class);
        return this.f3419n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m6735u() {
        this.f3420o = (GraphQLImage) super.a(this.f3420o, 11, GraphQLImage.class);
        return this.f3420o;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m6736v() {
        this.f3421p = (GraphQLImage) super.a(this.f3421p, 12, GraphQLImage.class);
        return this.f3421p;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m6737w() {
        this.f3422q = (GraphQLImage) super.a(this.f3422q, 13, GraphQLImage.class);
        return this.f3422q;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhoto m6738x() {
        this.f3423r = (GraphQLPhoto) super.a(this.f3423r, 14, GraphQLPhoto.class);
        return this.f3423r;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m6739y() {
        this.f3424s = (GraphQLImage) super.a(this.f3424s, 15, GraphQLImage.class);
        return this.f3424s;
    }

    @FieldOffset
    public final boolean m6740z() {
        a(2, 0);
        return this.f3425t;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStreamingImage m6715A() {
        this.f3426u = (GraphQLStreamingImage) super.a(this.f3426u, 18, GraphQLStreamingImage.class);
        return this.f3426u;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m6716B() {
        this.f3427v = (GraphQLImage) super.a(this.f3427v, 19, GraphQLImage.class);
        return this.f3427v;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m6717C() {
        this.f3428w = (GraphQLTextWithEntities) super.a(this.f3428w, 20, GraphQLTextWithEntities.class);
        return this.f3428w;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m6718D() {
        this.f3429x = (GraphQLTextWithEntities) super.a(this.f3429x, 21, GraphQLTextWithEntities.class);
        return this.f3429x;
    }

    @FieldOffset
    @Nullable
    public final String m6719E() {
        this.f3430y = super.a(this.f3430y, 22);
        return this.f3430y;
    }

    @Nullable
    public final String m6722a() {
        return m6728n();
    }

    public final int jK_() {
        return -1731205954;
    }

    public final GraphQLVisitableModel m6721a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLImage graphQLImage;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6726l() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m6726l());
            if (m6726l() != graphQLImage) {
                graphQLVisitableModel = (GraphQLCarrierUpsellPromotion) ModelHelper.a(null, this);
                graphQLVisitableModel.f3411f = graphQLImage;
            }
        }
        if (m6729o() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m6729o());
            if (m6729o() != graphQLImage) {
                graphQLVisitableModel = (GraphQLCarrierUpsellPromotion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3414i = graphQLImage;
            }
        }
        if (m6730p() != null) {
            GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection = (GraphQLInlineActivitiesConnection) graphQLModelMutatingVisitor.b(m6730p());
            if (m6730p() != graphQLInlineActivitiesConnection) {
                graphQLVisitableModel = (GraphQLCarrierUpsellPromotion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3415j = graphQLInlineActivitiesConnection;
            }
        }
        if (m6733s() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m6733s());
            if (m6733s() != graphQLImage) {
                graphQLVisitableModel = (GraphQLCarrierUpsellPromotion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3418m = graphQLImage;
            }
        }
        if (m6734t() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m6734t());
            if (m6734t() != graphQLImage) {
                graphQLVisitableModel = (GraphQLCarrierUpsellPromotion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3419n = graphQLImage;
            }
        }
        if (m6735u() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m6735u());
            if (m6735u() != graphQLImage) {
                graphQLVisitableModel = (GraphQLCarrierUpsellPromotion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3420o = graphQLImage;
            }
        }
        if (m6736v() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m6736v());
            if (m6736v() != graphQLImage) {
                graphQLVisitableModel = (GraphQLCarrierUpsellPromotion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3421p = graphQLImage;
            }
        }
        if (m6737w() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m6737w());
            if (m6737w() != graphQLImage) {
                graphQLVisitableModel = (GraphQLCarrierUpsellPromotion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3422q = graphQLImage;
            }
        }
        if (m6738x() != null) {
            GraphQLPhoto graphQLPhoto = (GraphQLPhoto) graphQLModelMutatingVisitor.b(m6738x());
            if (m6738x() != graphQLPhoto) {
                graphQLVisitableModel = (GraphQLCarrierUpsellPromotion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3423r = graphQLPhoto;
            }
        }
        if (m6739y() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m6739y());
            if (m6739y() != graphQLImage) {
                graphQLVisitableModel = (GraphQLCarrierUpsellPromotion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3424s = graphQLImage;
            }
        }
        if (m6715A() != null) {
            GraphQLStreamingImage graphQLStreamingImage = (GraphQLStreamingImage) graphQLModelMutatingVisitor.b(m6715A());
            if (m6715A() != graphQLStreamingImage) {
                graphQLVisitableModel = (GraphQLCarrierUpsellPromotion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3426u = graphQLStreamingImage;
            }
        }
        if (m6716B() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m6716B());
            if (m6716B() != graphQLImage) {
                graphQLVisitableModel = (GraphQLCarrierUpsellPromotion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3427v = graphQLImage;
            }
        }
        if (m6717C() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m6717C());
            if (m6717C() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLCarrierUpsellPromotion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3428w = graphQLTextWithEntities;
            }
        }
        if (m6718D() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m6718D());
            if (m6718D() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLCarrierUpsellPromotion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3429x = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLCarrierUpsellPromotion() {
        super(24);
    }

    public final void m6723a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3412g = mutableFlatBuffer.a(i, 3, 0.0d);
        this.f3416k = mutableFlatBuffer.a(i, 7);
        this.f3425t = mutableFlatBuffer.a(i, 16);
    }

    public final int m6720a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m6724j());
        int b2 = flatBufferBuilder.b(m6725k());
        int a = ModelHelper.a(flatBufferBuilder, m6726l());
        int b3 = flatBufferBuilder.b(m6728n());
        int a2 = ModelHelper.a(flatBufferBuilder, m6729o());
        int a3 = ModelHelper.a(flatBufferBuilder, m6730p());
        int b4 = flatBufferBuilder.b(m6732r());
        int a4 = ModelHelper.a(flatBufferBuilder, m6733s());
        int a5 = ModelHelper.a(flatBufferBuilder, m6734t());
        int a6 = ModelHelper.a(flatBufferBuilder, m6735u());
        int a7 = ModelHelper.a(flatBufferBuilder, m6736v());
        int a8 = ModelHelper.a(flatBufferBuilder, m6737w());
        int a9 = ModelHelper.a(flatBufferBuilder, m6738x());
        int a10 = ModelHelper.a(flatBufferBuilder, m6739y());
        int a11 = ModelHelper.a(flatBufferBuilder, m6715A());
        int a12 = ModelHelper.a(flatBufferBuilder, m6716B());
        int a13 = ModelHelper.a(flatBufferBuilder, m6717C());
        int a14 = ModelHelper.a(flatBufferBuilder, m6718D());
        int b5 = flatBufferBuilder.b(m6719E());
        flatBufferBuilder.c(23);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, a);
        flatBufferBuilder.a(3, m6727m(), 0.0d);
        flatBufferBuilder.b(4, b3);
        flatBufferBuilder.b(5, a2);
        flatBufferBuilder.b(6, a3);
        flatBufferBuilder.a(7, m6731q());
        flatBufferBuilder.b(8, b4);
        flatBufferBuilder.b(9, a4);
        flatBufferBuilder.b(10, a5);
        flatBufferBuilder.b(11, a6);
        flatBufferBuilder.b(12, a7);
        flatBufferBuilder.b(13, a8);
        flatBufferBuilder.b(14, a9);
        flatBufferBuilder.b(15, a10);
        flatBufferBuilder.a(16, m6740z());
        flatBufferBuilder.b(18, a11);
        flatBufferBuilder.b(19, a12);
        flatBufferBuilder.b(20, a13);
        flatBufferBuilder.b(21, a14);
        flatBufferBuilder.b(22, b5);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLCarrierUpsellPromotion(Parcel parcel) {
        boolean z = true;
        super(24);
        this.f3409d = parcel.readString();
        this.f3410e = parcel.readString();
        this.f3411f = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3412g = parcel.readDouble();
        this.f3413h = parcel.readString();
        this.f3414i = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3415j = (GraphQLInlineActivitiesConnection) parcel.readValue(GraphQLInlineActivitiesConnection.class.getClassLoader());
        this.f3416k = parcel.readByte() == (byte) 1;
        this.f3417l = parcel.readString();
        this.f3418m = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3419n = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3420o = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3421p = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3422q = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3423r = (GraphQLPhoto) parcel.readValue(GraphQLPhoto.class.getClassLoader());
        this.f3424s = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f3425t = z;
        this.f3426u = (GraphQLStreamingImage) parcel.readValue(GraphQLStreamingImage.class.getClassLoader());
        this.f3427v = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3428w = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3429x = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3430y = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(m6724j());
        parcel.writeString(m6725k());
        parcel.writeValue(m6726l());
        parcel.writeDouble(m6727m());
        parcel.writeString(m6728n());
        parcel.writeValue(m6729o());
        parcel.writeValue(m6730p());
        parcel.writeByte((byte) (m6731q() ? 1 : 0));
        parcel.writeString(m6732r());
        parcel.writeValue(m6733s());
        parcel.writeValue(m6734t());
        parcel.writeValue(m6735u());
        parcel.writeValue(m6736v());
        parcel.writeValue(m6737w());
        parcel.writeValue(m6738x());
        parcel.writeValue(m6739y());
        if (!m6740z()) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(m6715A());
        parcel.writeValue(m6716B());
        parcel.writeValue(m6717C());
        parcel.writeValue(m6718D());
        parcel.writeString(m6719E());
    }
}
