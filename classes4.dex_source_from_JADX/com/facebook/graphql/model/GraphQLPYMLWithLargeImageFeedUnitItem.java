package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.interfaces.HasTracking;
import com.facebook.graphql.model.interfaces.ItemListFeedUnitItem;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: onStartBuffering */
public final class GraphQLPYMLWithLargeImageFeedUnitItem extends BaseModel implements HasCachedSponsoredImpression, HasSponsoredData, HasProperty, SuggestedPageUnitItem, HasTracking, ItemListFeedUnitItem, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPYMLWithLargeImageFeedUnitItem> CREATOR = new C02711();
    @Nullable
    GraphQLImage f6112d;
    @Nullable
    GraphQLImage f6113e;
    @Nullable
    GraphQLImage f6114f;
    @Nullable
    GraphQLImage f6115g;
    @Nullable
    GraphQLVect2 f6116h;
    @Nullable
    String f6117i;
    @Nullable
    String f6118j;
    @Nullable
    GraphQLTextWithEntities f6119k;
    @Nullable
    GraphQLNegativeFeedbackActionsConnection f6120l;
    @Nullable
    GraphQLPage f6121m;
    @Nullable
    GraphQLTextWithEntities f6122n;
    @Nullable
    GraphQLSponsoredData f6123o;
    @Nullable
    String f6124p;
    @Nullable
    private PropertyBag f6125q = null;

    /* compiled from: onStartBuffering */
    final class C02711 implements Creator<GraphQLPYMLWithLargeImageFeedUnitItem> {
        C02711() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPYMLWithLargeImageFeedUnitItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPYMLWithLargeImageFeedUnitItem[i];
        }
    }

    public final GraphQLPagesYouMayLikeFeedUnitItemContentConnection mo552q() {
        return null;
    }

    public final boolean mo553r() {
        return false;
    }

    public final GraphQLPage mo548m() {
        return m6583D();
    }

    public final String mo549n() {
        return m6600y();
    }

    public final GraphQLImage mo550o() {
        return m6597v();
    }

    public final SponsoredImpression Z_() {
        return ImpressionUtil.a(this);
    }

    @Nullable
    public final SponsoredImpression ab_() {
        return ImpressionUtil.a(this);
    }

    public final GraphQLVect2 mo551p() {
        return m6599x();
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m6594s() {
        this.f6112d = (GraphQLImage) super.a(this.f6112d, 0, GraphQLImage.class);
        return this.f6112d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m6595t() {
        this.f6113e = (GraphQLImage) super.a(this.f6113e, 1, GraphQLImage.class);
        return this.f6113e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m6596u() {
        this.f6114f = (GraphQLImage) super.a(this.f6114f, 2, GraphQLImage.class);
        return this.f6114f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m6597v() {
        this.f6115g = (GraphQLImage) super.a(this.f6115g, 3, GraphQLImage.class);
        return this.f6115g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLVect2 m6599x() {
        this.f6116h = (GraphQLVect2) super.a(this.f6116h, 4, GraphQLVect2.class);
        return this.f6116h;
    }

    @FieldOffset
    @Nullable
    public final String m6600y() {
        this.f6117i = super.a(this.f6117i, 5);
        return this.f6117i;
    }

    @FieldOffset
    @Nullable
    public final String m6581B() {
        this.f6118j = super.a(this.f6118j, 6);
        return this.f6118j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities mo554w() {
        this.f6119k = (GraphQLTextWithEntities) super.a(this.f6119k, 7, GraphQLTextWithEntities.class);
        return this.f6119k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNegativeFeedbackActionsConnection m6582C() {
        this.f6120l = (GraphQLNegativeFeedbackActionsConnection) super.a(this.f6120l, 8, GraphQLNegativeFeedbackActionsConnection.class);
        return this.f6120l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m6583D() {
        this.f6121m = (GraphQLPage) super.a(this.f6121m, 9, GraphQLPage.class);
        return this.f6121m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities mo555z() {
        this.f6122n = (GraphQLTextWithEntities) super.a(this.f6122n, 10, GraphQLTextWithEntities.class);
        return this.f6122n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLSponsoredData mo546A() {
        this.f6123o = (GraphQLSponsoredData) super.a(this.f6123o, 11, GraphQLSponsoredData.class);
        return this.f6123o;
    }

    @FieldOffset
    @Nullable
    public final String m6587k() {
        this.f6124p = super.a(this.f6124p, 12);
        return this.f6124p;
    }

    public final int jK_() {
        return -2071280285;
    }

    public final GraphQLVisitableModel m6586a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLImage graphQLImage;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6594s() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m6594s());
            if (m6594s() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPYMLWithLargeImageFeedUnitItem) ModelHelper.a(null, this);
                graphQLVisitableModel.f6112d = graphQLImage;
            }
        }
        if (m6595t() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m6595t());
            if (m6595t() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPYMLWithLargeImageFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f6113e = graphQLImage;
            }
        }
        if (m6596u() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m6596u());
            if (m6596u() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPYMLWithLargeImageFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f6114f = graphQLImage;
            }
        }
        if (m6597v() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m6597v());
            if (m6597v() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPYMLWithLargeImageFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f6115g = graphQLImage;
            }
        }
        if (m6599x() != null) {
            GraphQLVect2 graphQLVect2 = (GraphQLVect2) graphQLModelMutatingVisitor.b(m6599x());
            if (m6599x() != graphQLVect2) {
                graphQLVisitableModel = (GraphQLPYMLWithLargeImageFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f6116h = graphQLVect2;
            }
        }
        if (mo554w() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(mo554w());
            if (mo554w() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLPYMLWithLargeImageFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f6119k = graphQLTextWithEntities;
            }
        }
        if (m6582C() != null) {
            GraphQLNegativeFeedbackActionsConnection graphQLNegativeFeedbackActionsConnection = (GraphQLNegativeFeedbackActionsConnection) graphQLModelMutatingVisitor.b(m6582C());
            if (m6582C() != graphQLNegativeFeedbackActionsConnection) {
                graphQLVisitableModel = (GraphQLPYMLWithLargeImageFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f6120l = graphQLNegativeFeedbackActionsConnection;
            }
        }
        if (m6583D() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.b(m6583D());
            if (m6583D() != graphQLPage) {
                graphQLVisitableModel = (GraphQLPYMLWithLargeImageFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f6121m = graphQLPage;
            }
        }
        if (mo555z() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(mo555z());
            if (mo555z() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLPYMLWithLargeImageFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f6122n = graphQLTextWithEntities;
            }
        }
        if (mo546A() != null) {
            GraphQLSponsoredData graphQLSponsoredData = (GraphQLSponsoredData) graphQLModelMutatingVisitor.b(mo546A());
            if (mo546A() != graphQLSponsoredData) {
                graphQLVisitableModel = (GraphQLPYMLWithLargeImageFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f6123o = graphQLSponsoredData;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPYMLWithLargeImageFeedUnitItem() {
        super(14);
    }

    public final int m6584a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m6594s());
        int a2 = ModelHelper.a(flatBufferBuilder, m6595t());
        int a3 = ModelHelper.a(flatBufferBuilder, m6596u());
        int a4 = ModelHelper.a(flatBufferBuilder, m6597v());
        int a5 = ModelHelper.a(flatBufferBuilder, m6599x());
        int b = flatBufferBuilder.b(m6600y());
        int b2 = flatBufferBuilder.b(m6581B());
        int a6 = ModelHelper.a(flatBufferBuilder, mo554w());
        int a7 = ModelHelper.a(flatBufferBuilder, m6582C());
        int a8 = ModelHelper.a(flatBufferBuilder, m6583D());
        int a9 = ModelHelper.a(flatBufferBuilder, mo555z());
        int a10 = ModelHelper.a(flatBufferBuilder, mo546A());
        int b3 = flatBufferBuilder.b(m6587k());
        flatBufferBuilder.c(13);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, a3);
        flatBufferBuilder.b(3, a4);
        flatBufferBuilder.b(4, a5);
        flatBufferBuilder.b(5, b);
        flatBufferBuilder.b(6, b2);
        flatBufferBuilder.b(7, a6);
        flatBufferBuilder.b(8, a7);
        flatBufferBuilder.b(9, a8);
        flatBufferBuilder.b(10, a9);
        flatBufferBuilder.b(11, a10);
        flatBufferBuilder.b(12, b3);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPYMLWithLargeImageFeedUnitItem(Parcel parcel) {
        super(14);
        this.f6112d = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f6113e = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f6114f = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f6115g = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f6116h = (GraphQLVect2) parcel.readValue(GraphQLVect2.class.getClassLoader());
        this.f6117i = parcel.readString();
        this.f6118j = parcel.readString();
        this.f6119k = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f6120l = (GraphQLNegativeFeedbackActionsConnection) parcel.readValue(GraphQLNegativeFeedbackActionsConnection.class.getClassLoader());
        this.f6121m = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f6122n = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f6123o = (GraphQLSponsoredData) parcel.readValue(GraphQLSponsoredData.class.getClassLoader());
        this.f6124p = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m6594s());
        parcel.writeValue(m6595t());
        parcel.writeValue(m6596u());
        parcel.writeValue(m6597v());
        parcel.writeValue(m6599x());
        parcel.writeString(m6600y());
        parcel.writeString(m6581B());
        parcel.writeValue(mo554w());
        parcel.writeValue(m6582C());
        parcel.writeValue(m6583D());
        parcel.writeValue(mo555z());
        parcel.writeValue(mo546A());
        parcel.writeString(m6587k());
    }

    public final GraphQLImage mo547a(int i) {
        GraphQLImage t;
        if (m6595t() != null && m6595t().c() >= i) {
            t = m6595t();
        } else if (m6596u() != null && m6596u().c() >= i) {
            t = m6596u();
        } else if (m6594s() == null || m6594s().c() < i) {
            t = m6597v();
        } else {
            t = m6594s();
        }
        return t;
    }

    public final PropertyBag U_() {
        if (this.f6125q == null) {
            this.f6125q = new PropertyBag();
        }
        return this.f6125q;
    }
}
