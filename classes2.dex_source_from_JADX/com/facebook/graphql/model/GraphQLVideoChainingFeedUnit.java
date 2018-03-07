package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.extras.FeedUnitExtra;
import com.facebook.graphql.model.interfaces.CachedFeedTrackable;
import com.facebook.graphql.model.interfaces.FollowUpFeedUnit;
import com.facebook.graphql.model.interfaces.HasTracking;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: invalid position  */
public final class GraphQLVideoChainingFeedUnit extends BaseModel implements FeedAttachable, FeedUnit, HasProperty, ScrollableItemListFeedUnit, CachedFeedTrackable, FollowUpFeedUnit, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLVideoChainingFeedUnit> CREATOR = new 1();
    public GraphQLObjectType f19582d = new GraphQLObjectType(88250206);
    @Nullable
    public String f19583e;
    @Nullable
    public String f19584f;
    public long f19585g;
    @Nullable
    public String f19586h;
    @Nullable
    public GraphQLVideo f19587i;
    @Nullable
    public String f19588j;
    @Nullable
    public GraphQLSuggestedVideoConnection f19589k;
    @Nullable
    public GraphQLTextWithEntities f19590l;
    @Nullable
    public GraphQLTextWithEntities f19591m;
    @Nullable
    public String f19592n;
    @Nullable
    public String f19593o;
    @Nullable
    public GraphQLTextWithEntities f19594p;
    private VideoChainingFeedUnitExtra f19595q;
    @Nullable
    private PropertyBag f19596r = null;

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m27285z();
    }

    public final /* synthetic */ List mo2883w() {
        return m27295l();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27152a((HasTracking) this);
    }

    public final GraphQLObjectType getType() {
        return this.f19582d;
    }

    public final ImmutableList<String> mo2874d() {
        if (mo2507g() != null) {
            return ImmutableList.of(mo2507g());
        }
        return RegularImmutableList.f535a;
    }

    public final ImmutableList m27295l() {
        return ItemListFeedUnitImpl.m30157a(this);
    }

    public final int ac_() {
        return VisibleItemHelper.m26976a((ScrollableItemListFeedUnit) this);
    }

    public final List mo2882v() {
        return ItemListFeedUnitImpl.m30157a(this);
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f19583e = super.m9948a(this.f19583e, 0);
        return this.f19583e;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f19584f = super.m9948a(this.f19584f, 1);
        return this.f19584f;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 2);
        return this.f19585g;
    }

    public final void mo2872a(long j) {
        this.f19585g = j;
    }

    @FieldOffset
    @Nullable
    public final String m27297o() {
        this.f19586h = super.m9948a(this.f19586h, 3);
        return this.f19586h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLVideo m27298p() {
        this.f19587i = (GraphQLVideo) super.m9947a(this.f19587i, 4, GraphQLVideo.class);
        return this.f19587i;
    }

    @FieldOffset
    @Nullable
    public final String m27299q() {
        this.f19588j = super.m9948a(this.f19588j, 6);
        return this.f19588j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLSuggestedVideoConnection m27300r() {
        this.f19589k = (GraphQLSuggestedVideoConnection) super.m9947a(this.f19589k, 7, GraphQLSuggestedVideoConnection.class);
        return this.f19589k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m27301s() {
        this.f19590l = (GraphQLTextWithEntities) super.m9947a(this.f19590l, 8, GraphQLTextWithEntities.class);
        return this.f19590l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m27302t() {
        this.f19591m = (GraphQLTextWithEntities) super.m9947a(this.f19591m, 9, GraphQLTextWithEntities.class);
        return this.f19591m;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f19592n = super.m9948a(this.f19592n, 10);
        return this.f19592n;
    }

    @FieldOffset
    @Nullable
    public final String m27303u() {
        this.f19593o = super.m9948a(this.f19593o, 11);
        return this.f19593o;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m27306x() {
        this.f19594p = (GraphQLTextWithEntities) super.m9947a(this.f19594p, 12, GraphQLTextWithEntities.class);
        return this.f19594p;
    }

    @Nullable
    public final String mo2834a() {
        return m27297o();
    }

    public final int jK_() {
        return 88250206;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m27298p() != null) {
            GraphQLVideo graphQLVideo = (GraphQLVideo) graphQLModelMutatingVisitor.mo2928b(m27298p());
            if (m27298p() != graphQLVideo) {
                graphQLVisitableModel = (GraphQLVideoChainingFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19587i = graphQLVideo;
            }
        }
        if (m27300r() != null) {
            GraphQLSuggestedVideoConnection graphQLSuggestedVideoConnection = (GraphQLSuggestedVideoConnection) graphQLModelMutatingVisitor.mo2928b(m27300r());
            if (m27300r() != graphQLSuggestedVideoConnection) {
                graphQLVisitableModel = (GraphQLVideoChainingFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19589k = graphQLSuggestedVideoConnection;
            }
        }
        if (m27301s() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m27301s());
            if (m27301s() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLVideoChainingFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19590l = graphQLTextWithEntities;
            }
        }
        if (m27302t() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m27302t());
            if (m27302t() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLVideoChainingFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19591m = graphQLTextWithEntities;
            }
        }
        if (m27306x() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m27306x());
            if (m27306x() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLVideoChainingFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19594p = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLVideoChainingFeedUnit() {
        super(14);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f19585g = mutableFlatBuffer.m21525a(i, 2, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int b3 = flatBufferBuilder.m21502b(m27297o());
        int a = ModelHelper.m23093a(flatBufferBuilder, m27298p());
        int b4 = flatBufferBuilder.m21502b(m27299q());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m27300r());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m27301s());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m27302t());
        int b5 = flatBufferBuilder.m21502b(mo2877k());
        int b6 = flatBufferBuilder.m21502b(m27303u());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m27306x());
        flatBufferBuilder.m21510c(13);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21495a(2, T_(), 0);
        flatBufferBuilder.m21507b(3, b3);
        flatBufferBuilder.m21507b(4, a);
        flatBufferBuilder.m21507b(6, b4);
        flatBufferBuilder.m21507b(7, a2);
        flatBufferBuilder.m21507b(8, a3);
        flatBufferBuilder.m21507b(9, a4);
        flatBufferBuilder.m21507b(10, b5);
        flatBufferBuilder.m21507b(11, b6);
        flatBufferBuilder.m21507b(12, a5);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public final GraphQLTextWithEntities mo2878m() {
        return m27306x();
    }

    public GraphQLVideoChainingFeedUnit(Parcel parcel) {
        super(14);
        this.f19583e = parcel.readString();
        this.f19584f = parcel.readString();
        this.f19585g = parcel.readLong();
        this.f19586h = parcel.readString();
        this.f19587i = (GraphQLVideo) parcel.readValue(GraphQLVideo.class.getClassLoader());
        this.f19588j = parcel.readString();
        this.f19589k = (GraphQLSuggestedVideoConnection) parcel.readValue(GraphQLSuggestedVideoConnection.class.getClassLoader());
        this.f19590l = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f19591m = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f19592n = parcel.readString();
        this.f19593o = parcel.readString();
        this.f19594p = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f19595q = (VideoChainingFeedUnitExtra) ParcelUtil.b(parcel, VideoChainingFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo2507g());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeString(m27297o());
        parcel.writeValue(m27298p());
        parcel.writeString(m27299q());
        parcel.writeValue(m27300r());
        parcel.writeValue(m27301s());
        parcel.writeValue(m27302t());
        parcel.writeString(mo2877k());
        parcel.writeString(m27303u());
        parcel.writeValue(m27306x());
        parcel.writeParcelable(m27285z(), i);
    }

    private VideoChainingFeedUnitExtra m27285z() {
        if (this.f19595q == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f19595q = new VideoChainingFeedUnitExtra();
            } else {
                this.f19595q = (VideoChainingFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, VideoChainingFeedUnitExtra.class);
            }
        }
        return this.f19595q;
    }

    public final PropertyBag U_() {
        if (this.f19596r == null) {
            this.f19596r = new PropertyBag();
        }
        return this.f19596r;
    }
}
