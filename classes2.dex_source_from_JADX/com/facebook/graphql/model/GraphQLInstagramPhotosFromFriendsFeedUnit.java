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
/* compiled from: large_media_attachment */
public final class GraphQLInstagramPhotosFromFriendsFeedUnit extends BaseModel implements FeedUnit, HasProperty, ScrollableItemListFeedUnit, CachedFeedTrackable, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLInstagramPhotosFromFriendsFeedUnit> CREATOR = new 1();
    public GraphQLObjectType f18229d = new GraphQLObjectType(-491890118);
    @Nullable
    public String f18230e;
    @Nullable
    public String f18231f;
    public long f18232g;
    public List<GraphQLInstagramPhotosFromFriendsFeedUnitItem> f18233h;
    public List<GraphQLInstagramPhotosFromFriendsFeedUnitItem> f18234i;
    @Nullable
    public String f18235j;
    @Nullable
    public GraphQLTextWithEntities f18236k;
    @Nullable
    public String f18237l;
    private InstagramPhotosFromFriendsFeedUnitExtra f18238m;
    @Nullable
    private PropertyBag f18239n = null;

    public final List mo2883w() {
        return ImmutableList.copyOf(m25560o());
    }

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m25548t();
    }

    public final /* synthetic */ List mo2882v() {
        return m25558l();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27152a((HasTracking) this);
    }

    public final GraphQLObjectType getType() {
        return this.f18229d;
    }

    public final ImmutableList<String> mo2874d() {
        if (mo2507g() != null) {
            return ImmutableList.of(mo2507g());
        }
        return RegularImmutableList.f535a;
    }

    public final int ac_() {
        return VisibleItemHelper.m26976a((ScrollableItemListFeedUnit) this);
    }

    public final ImmutableList m25558l() {
        return ScrollableItemListFeedUnitImpl.a(this);
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f18230e = super.m9948a(this.f18230e, 0);
        return this.f18230e;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f18231f = super.m9948a(this.f18231f, 1);
        return this.f18231f;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 2);
        return this.f18232g;
    }

    public final void mo2872a(long j) {
        this.f18232g = j;
    }

    @FieldOffset
    public final ImmutableList<GraphQLInstagramPhotosFromFriendsFeedUnitItem> m25560o() {
        this.f18233h = super.m9944a(this.f18233h, 3, GraphQLInstagramPhotosFromFriendsFeedUnitItem.class);
        return (ImmutableList) this.f18233h;
    }

    @FieldOffset
    public final ImmutableList<GraphQLInstagramPhotosFromFriendsFeedUnitItem> m25561p() {
        this.f18234i = super.m9944a(this.f18234i, 4, GraphQLInstagramPhotosFromFriendsFeedUnitItem.class);
        return (ImmutableList) this.f18234i;
    }

    @FieldOffset
    @Nullable
    public final String m25562q() {
        this.f18235j = super.m9948a(this.f18235j, 5);
        return this.f18235j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25563r() {
        this.f18236k = (GraphQLTextWithEntities) super.m9947a(this.f18236k, 6, GraphQLTextWithEntities.class);
        return this.f18236k;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f18237l = super.m9948a(this.f18237l, 7);
        return this.f18237l;
    }

    @Nullable
    public final String mo2834a() {
        return mo2507g();
    }

    public final int jK_() {
        return -491890118;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m25560o() != null) {
            a = ModelHelper.m23097a(m25560o(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLInstagramPhotosFromFriendsFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18233h = a.m1068b();
            }
        }
        if (m25561p() != null) {
            a = ModelHelper.m23097a(m25561p(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLInstagramPhotosFromFriendsFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18234i = a.m1068b();
            }
        }
        GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
        if (m25563r() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25563r());
            if (m25563r() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLInstagramPhotosFromFriendsFeedUnit) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18236k = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
    }

    public GraphQLInstagramPhotosFromFriendsFeedUnit() {
        super(9);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18232g = mutableFlatBuffer.m21525a(i, 2, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int a = ModelHelper.m23094a(flatBufferBuilder, m25560o());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m25561p());
        int b3 = flatBufferBuilder.m21502b(m25562q());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m25563r());
        int b4 = flatBufferBuilder.m21502b(mo2877k());
        flatBufferBuilder.m21510c(8);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21495a(2, T_(), 0);
        flatBufferBuilder.m21507b(3, a);
        flatBufferBuilder.m21507b(4, a2);
        flatBufferBuilder.m21507b(5, b3);
        flatBufferBuilder.m21507b(6, a3);
        flatBufferBuilder.m21507b(7, b4);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public final GraphQLTextWithEntities mo2878m() {
        return null;
    }

    public GraphQLInstagramPhotosFromFriendsFeedUnit(Parcel parcel) {
        super(9);
        this.f18230e = parcel.readString();
        this.f18231f = parcel.readString();
        this.f18232g = parcel.readLong();
        this.f18233h = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLInstagramPhotosFromFriendsFeedUnitItem.class.getClassLoader()));
        this.f18234i = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLInstagramPhotosFromFriendsFeedUnitItem.class.getClassLoader()));
        this.f18235j = parcel.readString();
        this.f18236k = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18237l = parcel.readString();
        this.f18238m = (InstagramPhotosFromFriendsFeedUnitExtra) ParcelUtil.b(parcel, InstagramPhotosFromFriendsFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo2507g());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeList(m25560o());
        parcel.writeList(m25561p());
        parcel.writeString(m25562q());
        parcel.writeValue(m25563r());
        parcel.writeString(mo2877k());
        parcel.writeParcelable(m25548t(), i);
    }

    private InstagramPhotosFromFriendsFeedUnitExtra m25548t() {
        if (this.f18238m == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18238m = new InstagramPhotosFromFriendsFeedUnitExtra();
            } else {
                this.f18238m = (InstagramPhotosFromFriendsFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, InstagramPhotosFromFriendsFeedUnitExtra.class);
            }
        }
        return this.f18238m;
    }

    public final PropertyBag U_() {
        if (this.f18239n == null) {
            this.f18239n = new PropertyBag();
        }
        return this.f18239n;
    }
}
