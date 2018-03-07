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
import com.facebook.graphql.model.interfaces.HasTracking;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: graph-video */
public final class GraphQLSocialWifiFeedUnit extends BaseModel implements FeedUnit, ItemListFeedUnit, HasProperty, CachedFeedTrackable, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLSocialWifiFeedUnit> CREATOR = new 1();
    public GraphQLObjectType f22054d = new GraphQLObjectType(-862531932);
    @Nullable
    public String f22055e;
    @Nullable
    public String f22056f;
    public long f22057g;
    public List<GraphQLSocialWifiFeedUnitItem> f22058h;
    @Nullable
    public String f22059i;
    public List<GraphQLSocialWifiFeedUnitItem> f22060j;
    @Nullable
    public GraphQLTextWithEntities f22061k;
    @Nullable
    public GraphQLTextWithEntities f22062l;
    @Nullable
    public String f22063m;
    private SocialWifiFeedUnitExtra f22064n;
    @Nullable
    private PropertyBag f22065o = null;

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m29840s();
    }

    public final /* synthetic */ List mo2883w() {
        return m29850l();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27152a((HasTracking) this);
    }

    public final GraphQLObjectType getType() {
        return this.f22054d;
    }

    public final ImmutableList<String> mo2874d() {
        if (mo2507g() != null) {
            return ImmutableList.of(mo2507g());
        }
        return RegularImmutableList.f535a;
    }

    public final ImmutableList m29850l() {
        return ItemListFeedUnitImpl.m30154a(this);
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f22055e = super.m9948a(this.f22055e, 0);
        return this.f22055e;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f22056f = super.m9948a(this.f22056f, 1);
        return this.f22056f;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 2);
        return this.f22057g;
    }

    public final void mo2872a(long j) {
        this.f22057g = j;
    }

    @FieldOffset
    public final ImmutableList<GraphQLSocialWifiFeedUnitItem> m29852n() {
        this.f22058h = super.m9944a(this.f22058h, 3, GraphQLSocialWifiFeedUnitItem.class);
        return (ImmutableList) this.f22058h;
    }

    @FieldOffset
    @Nullable
    public final String m29853o() {
        this.f22059i = super.m9948a(this.f22059i, 4);
        return this.f22059i;
    }

    @FieldOffset
    public final ImmutableList<GraphQLSocialWifiFeedUnitItem> m29854p() {
        this.f22060j = super.m9944a(this.f22060j, 5, GraphQLSocialWifiFeedUnitItem.class);
        return (ImmutableList) this.f22060j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m29855q() {
        this.f22061k = (GraphQLTextWithEntities) super.m9947a(this.f22061k, 6, GraphQLTextWithEntities.class);
        return this.f22061k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m29856r() {
        this.f22062l = (GraphQLTextWithEntities) super.m9947a(this.f22062l, 7, GraphQLTextWithEntities.class);
        return this.f22062l;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f22063m = super.m9948a(this.f22063m, 8);
        return this.f22063m;
    }

    @Nullable
    public final String mo2834a() {
        return mo2507g();
    }

    public final int jK_() {
        return -862531932;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m29852n() != null) {
            a = ModelHelper.m23097a(m29852n(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLSocialWifiFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f22058h = a.m1068b();
            }
        }
        if (m29854p() != null) {
            a = ModelHelper.m23097a(m29854p(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLSocialWifiFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f22060j = a.m1068b();
            }
        }
        GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
        if (m29855q() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m29855q());
            if (m29855q() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLSocialWifiFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f22061k = graphQLTextWithEntities;
            }
        }
        if (m29856r() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m29856r());
            if (m29856r() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLSocialWifiFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f22062l = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
    }

    public GraphQLSocialWifiFeedUnit() {
        super(10);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f22057g = mutableFlatBuffer.m21525a(i, 2, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int a = ModelHelper.m23094a(flatBufferBuilder, m29852n());
        int b3 = flatBufferBuilder.m21502b(m29853o());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m29854p());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m29855q());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m29856r());
        int b4 = flatBufferBuilder.m21502b(mo2877k());
        flatBufferBuilder.m21510c(9);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21495a(2, T_(), 0);
        flatBufferBuilder.m21507b(3, a);
        flatBufferBuilder.m21507b(4, b3);
        flatBufferBuilder.m21507b(5, a2);
        flatBufferBuilder.m21507b(6, a3);
        flatBufferBuilder.m21507b(7, a4);
        flatBufferBuilder.m21507b(8, b4);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLSocialWifiFeedUnit(Parcel parcel) {
        super(10);
        this.f22055e = parcel.readString();
        this.f22056f = parcel.readString();
        this.f22057g = parcel.readLong();
        this.f22058h = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLSocialWifiFeedUnitItem.class.getClassLoader()));
        this.f22059i = parcel.readString();
        this.f22060j = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLSocialWifiFeedUnitItem.class.getClassLoader()));
        this.f22061k = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f22062l = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f22063m = parcel.readString();
        this.f22064n = (SocialWifiFeedUnitExtra) ParcelUtil.b(parcel, SocialWifiFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo2507g());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeList(m29852n());
        parcel.writeString(m29853o());
        parcel.writeList(m29854p());
        parcel.writeValue(m29855q());
        parcel.writeValue(m29856r());
        parcel.writeString(mo2877k());
        parcel.writeParcelable(m29840s(), i);
    }

    public final GraphQLTextWithEntities mo2878m() {
        return m29855q();
    }

    private SocialWifiFeedUnitExtra m29840s() {
        if (this.f22064n == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f22064n = new SocialWifiFeedUnitExtra();
            } else {
                this.f22064n = (SocialWifiFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, SocialWifiFeedUnitExtra.class);
            }
        }
        return this.f22064n;
    }

    public final PropertyBag U_() {
        if (this.f22065o == null) {
            this.f22065o = new PropertyBag();
        }
        return this.f22065o;
    }
}
