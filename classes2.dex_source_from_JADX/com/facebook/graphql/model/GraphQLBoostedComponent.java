package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLBoostedComponentBudgetType;
import com.facebook.graphql.enums.GraphQLBoostedComponentStatus;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: like_count */
public final class GraphQLBoostedComponent extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLBoostedComponent> CREATOR = new 1();
    @Nullable
    GraphQLAdAccount f17519d;
    GraphQLBoostedComponentStatus f17520e;
    @Nullable
    GraphQLCurrencyQuantity f17521f;
    GraphQLBoostedComponentBudgetType f17522g;
    @Nullable
    FeedUnit f17523h;
    @Nullable
    GraphQLBoostedComponentMessage f17524i;
    @Nullable
    GraphQLTextWithEntities f17525j;
    @Nullable
    GraphQLCurrencyQuantity f17526k;
    long f17527l;
    long f17528m;
    List<GraphQLBoostedComponentMessage> f17529n;
    @Nullable
    GraphQLAYMTChannel f17530o;

    @FieldOffset
    @Nullable
    public final GraphQLAdAccount m24663a() {
        this.f17519d = (GraphQLAdAccount) super.m9947a(this.f17519d, 0, GraphQLAdAccount.class);
        return this.f17519d;
    }

    @FieldOffset
    public final GraphQLBoostedComponentStatus m24666j() {
        this.f17520e = (GraphQLBoostedComponentStatus) super.m9945a(this.f17520e, 2, GraphQLBoostedComponentStatus.class, GraphQLBoostedComponentStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17520e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLCurrencyQuantity m24667k() {
        this.f17521f = (GraphQLCurrencyQuantity) super.m9947a(this.f17521f, 3, GraphQLCurrencyQuantity.class);
        return this.f17521f;
    }

    @FieldOffset
    public final GraphQLBoostedComponentBudgetType m24668l() {
        this.f17522g = (GraphQLBoostedComponentBudgetType) super.m9945a(this.f17522g, 4, GraphQLBoostedComponentBudgetType.class, GraphQLBoostedComponentBudgetType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17522g;
    }

    @FieldOffset
    @Nullable
    public final FeedUnit m24669m() {
        this.f17523h = (FeedUnit) super.m9946a(this.f17523h, 5, VirtualFlattenableResolverImpl.f15617a);
        return this.f17523h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLBoostedComponentMessage m24670n() {
        this.f17524i = (GraphQLBoostedComponentMessage) super.m9947a(this.f17524i, 6, GraphQLBoostedComponentMessage.class);
        return this.f17524i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m24671o() {
        this.f17525j = (GraphQLTextWithEntities) super.m9947a(this.f17525j, 7, GraphQLTextWithEntities.class);
        return this.f17525j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLCurrencyQuantity m24672p() {
        this.f17526k = (GraphQLCurrencyQuantity) super.m9947a(this.f17526k, 8, GraphQLCurrencyQuantity.class);
        return this.f17526k;
    }

    @FieldOffset
    public final long m24673q() {
        m9949a(1, 1);
        return this.f17527l;
    }

    @FieldOffset
    public final long m24674r() {
        m9949a(1, 2);
        return this.f17528m;
    }

    @FieldOffset
    public final ImmutableList<GraphQLBoostedComponentMessage> m24675s() {
        this.f17529n = super.m9944a(this.f17529n, 12, GraphQLBoostedComponentMessage.class);
        return (ImmutableList) this.f17529n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLAYMTChannel m24676t() {
        this.f17530o = (GraphQLAYMTChannel) super.m9947a(this.f17530o, 13, GraphQLAYMTChannel.class);
        return this.f17530o;
    }

    public final int jK_() {
        return -47218757;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLCurrencyQuantity graphQLCurrencyQuantity;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24663a() != null) {
            GraphQLAdAccount graphQLAdAccount = (GraphQLAdAccount) graphQLModelMutatingVisitor.mo2928b(m24663a());
            if (m24663a() != graphQLAdAccount) {
                graphQLVisitableModel = (GraphQLBoostedComponent) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17519d = graphQLAdAccount;
            }
        }
        if (m24676t() != null) {
            GraphQLAYMTChannel graphQLAYMTChannel = (GraphQLAYMTChannel) graphQLModelMutatingVisitor.mo2928b(m24676t());
            if (m24676t() != graphQLAYMTChannel) {
                graphQLVisitableModel = (GraphQLBoostedComponent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17530o = graphQLAYMTChannel;
            }
        }
        if (m24667k() != null) {
            graphQLCurrencyQuantity = (GraphQLCurrencyQuantity) graphQLModelMutatingVisitor.mo2928b(m24667k());
            if (m24667k() != graphQLCurrencyQuantity) {
                graphQLVisitableModel = (GraphQLBoostedComponent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17521f = graphQLCurrencyQuantity;
            }
        }
        if (m24669m() != null) {
            FeedUnit feedUnit = (FeedUnit) graphQLModelMutatingVisitor.mo2928b(m24669m());
            if (m24669m() != feedUnit) {
                graphQLVisitableModel = (GraphQLBoostedComponent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17523h = feedUnit;
            }
        }
        if (m24670n() != null) {
            GraphQLBoostedComponentMessage graphQLBoostedComponentMessage = (GraphQLBoostedComponentMessage) graphQLModelMutatingVisitor.mo2928b(m24670n());
            if (m24670n() != graphQLBoostedComponentMessage) {
                graphQLVisitableModel = (GraphQLBoostedComponent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17524i = graphQLBoostedComponentMessage;
            }
        }
        if (m24675s() != null) {
            Builder a = ModelHelper.m23097a(m24675s(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLBoostedComponent graphQLBoostedComponent = (GraphQLBoostedComponent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLBoostedComponent.f17529n = a.m1068b();
                graphQLVisitableModel = graphQLBoostedComponent;
            }
        }
        if (m24671o() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m24671o());
            if (m24671o() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLBoostedComponent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17525j = graphQLTextWithEntities;
            }
        }
        if (m24672p() != null) {
            graphQLCurrencyQuantity = (GraphQLCurrencyQuantity) graphQLModelMutatingVisitor.mo2928b(m24672p());
            if (m24672p() != graphQLCurrencyQuantity) {
                graphQLVisitableModel = (GraphQLBoostedComponent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17526k = graphQLCurrencyQuantity;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLBoostedComponent() {
        super(15);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17527l = mutableFlatBuffer.m21525a(i, 9, 0);
        this.f17528m = mutableFlatBuffer.m21525a(i, 10, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        Enum enumR = null;
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m24663a());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24667k());
        int a3 = flatBufferBuilder.m21476a(m24669m(), VirtualFlattenableResolverImpl.f15617a);
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m24670n());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m24671o());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m24672p());
        int a7 = ModelHelper.m23094a(flatBufferBuilder, m24675s());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m24676t());
        flatBufferBuilder.m21510c(14);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21496a(2, m24666j() == GraphQLBoostedComponentStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m24666j());
        flatBufferBuilder.m21507b(3, a2);
        if (m24668l() != GraphQLBoostedComponentBudgetType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            enumR = m24668l();
        }
        flatBufferBuilder.m21496a(4, enumR);
        flatBufferBuilder.m21507b(5, a3);
        flatBufferBuilder.m21507b(6, a4);
        flatBufferBuilder.m21507b(7, a5);
        flatBufferBuilder.m21507b(8, a6);
        flatBufferBuilder.m21495a(9, m24673q(), 0);
        flatBufferBuilder.m21495a(10, m24674r(), 0);
        flatBufferBuilder.m21507b(12, a7);
        flatBufferBuilder.m21507b(13, a8);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLBoostedComponent(Parcel parcel) {
        super(15);
        this.f17519d = (GraphQLAdAccount) parcel.readValue(GraphQLAdAccount.class.getClassLoader());
        this.f17530o = (GraphQLAYMTChannel) parcel.readValue(GraphQLAYMTChannel.class.getClassLoader());
        this.f17520e = GraphQLBoostedComponentStatus.fromString(parcel.readString());
        this.f17521f = (GraphQLCurrencyQuantity) parcel.readValue(GraphQLCurrencyQuantity.class.getClassLoader());
        this.f17522g = GraphQLBoostedComponentBudgetType.fromString(parcel.readString());
        this.f17523h = (FeedUnit) parcel.readValue(FeedUnit.class.getClassLoader());
        this.f17524i = (GraphQLBoostedComponentMessage) parcel.readValue(GraphQLBoostedComponentMessage.class.getClassLoader());
        this.f17529n = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLBoostedComponentMessage.class.getClassLoader()));
        this.f17525j = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f17526k = (GraphQLCurrencyQuantity) parcel.readValue(GraphQLCurrencyQuantity.class.getClassLoader());
        this.f17527l = parcel.readLong();
        this.f17528m = parcel.readLong();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m24663a());
        parcel.writeValue(m24676t());
        parcel.writeString(m24666j().name());
        parcel.writeValue(m24667k());
        parcel.writeString(m24668l().name());
        parcel.writeValue(m24669m());
        parcel.writeValue(m24670n());
        parcel.writeList(m24675s());
        parcel.writeValue(m24671o());
        parcel.writeValue(m24672p());
        parcel.writeLong(m24673q());
        parcel.writeLong(m24674r());
    }
}
