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
/* compiled from: onSurfaceTextureDestroyed wasn't called */
public final class GraphQLCreativePagesYouMayLikeFeedUnitItem extends BaseModel implements HasCachedSponsoredImpression, HasSponsoredData, HasProperty, SuggestedPageUnitItem, HasTracking, ItemListFeedUnitItem, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLCreativePagesYouMayLikeFeedUnitItem> CREATOR = new C02681();
    @Nullable
    GraphQLImage f6099d;
    @Nullable
    String f6100e;
    @Nullable
    String f6101f;
    @Nullable
    String f6102g;
    @Nullable
    GraphQLTextWithEntities f6103h;
    @Nullable
    GraphQLNegativeFeedbackActionsConnection f6104i;
    @Nullable
    GraphQLPage f6105j;
    @Nullable
    GraphQLTextWithEntities f6106k;
    @Nullable
    GraphQLSponsoredData f6107l;
    @Nullable
    String f6108m;
    @Nullable
    private PropertyBag f6109n = null;

    /* compiled from: onSurfaceTextureDestroyed wasn't called */
    final class C02681 implements Creator<GraphQLCreativePagesYouMayLikeFeedUnitItem> {
        C02681() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLCreativePagesYouMayLikeFeedUnitItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLCreativePagesYouMayLikeFeedUnitItem[i];
        }
    }

    public final GraphQLImage mo547a(int i) {
        return null;
    }

    public final GraphQLVect2 mo551p() {
        return null;
    }

    public final GraphQLPagesYouMayLikeFeedUnitItemContentConnection mo552q() {
        return null;
    }

    public final boolean mo553r() {
        return false;
    }

    public final GraphQLPage mo548m() {
        return m6562y();
    }

    public final String mo549n() {
        return m6557t();
    }

    public final GraphQLImage mo550o() {
        return m6556s();
    }

    public final SponsoredImpression Z_() {
        return ImpressionUtil.a(this);
    }

    @Nullable
    public final SponsoredImpression ab_() {
        return ImpressionUtil.a(this);
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m6556s() {
        this.f6099d = (GraphQLImage) super.a(this.f6099d, 0, GraphQLImage.class);
        return this.f6099d;
    }

    @FieldOffset
    @Nullable
    public final String m6557t() {
        this.f6100e = super.a(this.f6100e, 1);
        return this.f6100e;
    }

    @FieldOffset
    @Nullable
    public final String m6558u() {
        this.f6101f = super.a(this.f6101f, 2);
        return this.f6101f;
    }

    @FieldOffset
    @Nullable
    public final String m6559v() {
        this.f6102g = super.a(this.f6102g, 3);
        return this.f6102g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities mo554w() {
        this.f6103h = (GraphQLTextWithEntities) super.a(this.f6103h, 4, GraphQLTextWithEntities.class);
        return this.f6103h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNegativeFeedbackActionsConnection m6561x() {
        this.f6104i = (GraphQLNegativeFeedbackActionsConnection) super.a(this.f6104i, 5, GraphQLNegativeFeedbackActionsConnection.class);
        return this.f6104i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m6562y() {
        this.f6105j = (GraphQLPage) super.a(this.f6105j, 6, GraphQLPage.class);
        return this.f6105j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities mo555z() {
        this.f6106k = (GraphQLTextWithEntities) super.a(this.f6106k, 7, GraphQLTextWithEntities.class);
        return this.f6106k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLSponsoredData mo546A() {
        this.f6107l = (GraphQLSponsoredData) super.a(this.f6107l, 8, GraphQLSponsoredData.class);
        return this.f6107l;
    }

    @FieldOffset
    @Nullable
    public final String m6549k() {
        this.f6108m = super.a(this.f6108m, 9);
        return this.f6108m;
    }

    public final int jK_() {
        return -1207021529;
    }

    public final GraphQLVisitableModel m6548a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6556s() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m6556s());
            if (m6556s() != graphQLImage) {
                graphQLVisitableModel = (GraphQLCreativePagesYouMayLikeFeedUnitItem) ModelHelper.a(null, this);
                graphQLVisitableModel.f6099d = graphQLImage;
            }
        }
        if (mo554w() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(mo554w());
            if (mo554w() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLCreativePagesYouMayLikeFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f6103h = graphQLTextWithEntities;
            }
        }
        if (m6561x() != null) {
            GraphQLNegativeFeedbackActionsConnection graphQLNegativeFeedbackActionsConnection = (GraphQLNegativeFeedbackActionsConnection) graphQLModelMutatingVisitor.b(m6561x());
            if (m6561x() != graphQLNegativeFeedbackActionsConnection) {
                graphQLVisitableModel = (GraphQLCreativePagesYouMayLikeFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f6104i = graphQLNegativeFeedbackActionsConnection;
            }
        }
        if (m6562y() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.b(m6562y());
            if (m6562y() != graphQLPage) {
                graphQLVisitableModel = (GraphQLCreativePagesYouMayLikeFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f6105j = graphQLPage;
            }
        }
        if (mo555z() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(mo555z());
            if (mo555z() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLCreativePagesYouMayLikeFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f6106k = graphQLTextWithEntities;
            }
        }
        if (mo546A() != null) {
            GraphQLSponsoredData graphQLSponsoredData = (GraphQLSponsoredData) graphQLModelMutatingVisitor.b(mo546A());
            if (mo546A() != graphQLSponsoredData) {
                graphQLVisitableModel = (GraphQLCreativePagesYouMayLikeFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f6107l = graphQLSponsoredData;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLCreativePagesYouMayLikeFeedUnitItem() {
        super(11);
    }

    public final int m6546a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m6556s());
        int b = flatBufferBuilder.b(m6557t());
        int b2 = flatBufferBuilder.b(m6558u());
        int b3 = flatBufferBuilder.b(m6559v());
        int a2 = ModelHelper.a(flatBufferBuilder, mo554w());
        int a3 = ModelHelper.a(flatBufferBuilder, m6561x());
        int a4 = ModelHelper.a(flatBufferBuilder, m6562y());
        int a5 = ModelHelper.a(flatBufferBuilder, mo555z());
        int a6 = ModelHelper.a(flatBufferBuilder, mo546A());
        int b4 = flatBufferBuilder.b(m6549k());
        flatBufferBuilder.c(10);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        flatBufferBuilder.b(3, b3);
        flatBufferBuilder.b(4, a2);
        flatBufferBuilder.b(5, a3);
        flatBufferBuilder.b(6, a4);
        flatBufferBuilder.b(7, a5);
        flatBufferBuilder.b(8, a6);
        flatBufferBuilder.b(9, b4);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLCreativePagesYouMayLikeFeedUnitItem(Parcel parcel) {
        super(11);
        this.f6099d = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f6100e = parcel.readString();
        this.f6101f = parcel.readString();
        this.f6102g = parcel.readString();
        this.f6103h = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f6104i = (GraphQLNegativeFeedbackActionsConnection) parcel.readValue(GraphQLNegativeFeedbackActionsConnection.class.getClassLoader());
        this.f6105j = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f6106k = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f6107l = (GraphQLSponsoredData) parcel.readValue(GraphQLSponsoredData.class.getClassLoader());
        this.f6108m = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m6556s());
        parcel.writeString(m6557t());
        parcel.writeString(m6558u());
        parcel.writeString(m6559v());
        parcel.writeValue(mo554w());
        parcel.writeValue(m6561x());
        parcel.writeValue(m6562y());
        parcel.writeValue(mo555z());
        parcel.writeValue(mo546A());
        parcel.writeString(m6549k());
    }

    public final PropertyBag U_() {
        if (this.f6109n == null) {
            this.f6109n = new PropertyBag();
        }
        return this.f6109n;
    }
}
