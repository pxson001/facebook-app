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
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.extras.FeedUnitExtra;
import com.facebook.graphql.model.interfaces.CachedFeedTrackable;
import com.facebook.graphql.model.interfaces.HasTracking;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
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
/* compiled from: landing */
public final class GraphQLPageStoriesYouMissedFeedUnit extends BaseModel implements FeedUnit, HideableUnit, HasProperty, ScrollableItemListFeedUnit, CachedFeedTrackable, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLPageStoriesYouMissedFeedUnit> CREATOR = new 1();
    public GraphQLObjectType f18246d = new GraphQLObjectType(-563086408);
    @Nullable
    public String f18247e;
    @Nullable
    public String f18248f;
    public long f18249g;
    @Nullable
    public GraphQLPageStoriesYouMissedFeedUnitStoriesConnection f18250h;
    @Nullable
    public String f18251i;
    @Nullable
    public GraphQLTextWithEntities f18252j;
    @Nullable
    public String f18253k;
    @Nullable
    public String f18254l;
    @Nullable
    public String f18255m;
    public int f18256n;
    private PageStoriesYouMissedFeedUnitExtra f18257o;
    @Nullable
    private PropertyBag f18258p = null;

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m25572A();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27152a((HasTracking) this);
    }

    public final GraphQLObjectType getType() {
        return this.f18246d;
    }

    public final ImmutableList<String> mo2874d() {
        if (mo2507g() != null) {
            return ImmutableList.of(mo2507g());
        }
        return RegularImmutableList.f535a;
    }

    public final StoryVisibility mo2879o() {
        return HideableUnitUtil.m26319a((HideableUnit) this);
    }

    public final int mo2880p() {
        return HideableUnitUtil.m26321b(this);
    }

    public final List mo2883w() {
        return ItemListFeedUnitImpl.m30144a(this);
    }

    public final String mo2881q() {
        return HideableUnitUtil.m26320a((HasHideableToken) ScrollableItemListFeedUnitImpl.a(this).get(ac_()));
    }

    public final int ac_() {
        return VisibleItemHelper.m26976a((ScrollableItemListFeedUnit) this);
    }

    public final List mo2882v() {
        return ScrollableItemListFeedUnitImpl.a(this);
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f18247e = super.m9948a(this.f18247e, 0);
        return this.f18247e;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f18248f = super.m9948a(this.f18248f, 1);
        return this.f18248f;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 2);
        return this.f18249g;
    }

    public final void mo2872a(long j) {
        this.f18249g = j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageStoriesYouMissedFeedUnitStoriesConnection m25584l() {
        this.f18250h = (GraphQLPageStoriesYouMissedFeedUnitStoriesConnection) super.m9947a(this.f18250h, 3, GraphQLPageStoriesYouMissedFeedUnitStoriesConnection.class);
        return this.f18250h;
    }

    @FieldOffset
    @Nullable
    public final String m25589r() {
        this.f18251i = super.m9948a(this.f18251i, 4);
        return this.f18251i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25590s() {
        this.f18252j = (GraphQLTextWithEntities) super.m9947a(this.f18252j, 5, GraphQLTextWithEntities.class);
        return this.f18252j;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f18253k = super.m9948a(this.f18253k, 6);
        return this.f18253k;
    }

    @FieldOffset
    @Nullable
    public final String m25591t() {
        this.f18254l = super.m9948a(this.f18254l, 7);
        return this.f18254l;
    }

    @FieldOffset
    @Nullable
    public final String m25592u() {
        this.f18255m = super.m9948a(this.f18255m, 8);
        return this.f18255m;
    }

    @FieldOffset
    public final int m25595x() {
        m9949a(1, 1);
        return this.f18256n;
    }

    @Nullable
    public final String mo2834a() {
        return mo2507g();
    }

    public final int jK_() {
        return -563086408;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m25584l() != null) {
            GraphQLPageStoriesYouMissedFeedUnitStoriesConnection graphQLPageStoriesYouMissedFeedUnitStoriesConnection = (GraphQLPageStoriesYouMissedFeedUnitStoriesConnection) graphQLModelMutatingVisitor.mo2928b(m25584l());
            if (m25584l() != graphQLPageStoriesYouMissedFeedUnitStoriesConnection) {
                graphQLVisitableModel = (GraphQLPageStoriesYouMissedFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18250h = graphQLPageStoriesYouMissedFeedUnitStoriesConnection;
            }
        }
        if (m25590s() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25590s());
            if (m25590s() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLPageStoriesYouMissedFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18252j = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("local_last_negative_feedback_action_type".equals(str)) {
            consistencyTuple.f18727a = m25591t();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 7;
        } else if ("local_story_visibility".equals(str)) {
            consistencyTuple.f18727a = m25592u();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 8;
        } else if ("local_story_visible_height".equals(str)) {
            consistencyTuple.f18727a = Integer.valueOf(m25595x());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 9;
        } else {
            consistencyTuple.m26322a();
        }
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        String str2;
        if ("local_last_negative_feedback_action_type".equals(str)) {
            str2 = (String) obj;
            this.f18254l = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 7, str2);
            }
        } else if ("local_story_visibility".equals(str)) {
            str2 = (String) obj;
            this.f18255m = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 8, str2);
            }
        } else if ("local_story_visible_height".equals(str)) {
            int intValue = ((Integer) obj).intValue();
            this.f18256n = intValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21544b(this.f5824c, 9, intValue);
            }
        }
    }

    public GraphQLPageStoriesYouMissedFeedUnit() {
        super(11);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18249g = mutableFlatBuffer.m21525a(i, 2, 0);
        this.f18256n = mutableFlatBuffer.m21524a(i, 9, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int a = ModelHelper.m23093a(flatBufferBuilder, m25584l());
        int b3 = flatBufferBuilder.m21502b(m25589r());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m25590s());
        int b4 = flatBufferBuilder.m21502b(mo2877k());
        int b5 = flatBufferBuilder.m21502b(m25591t());
        int b6 = flatBufferBuilder.m21502b(m25592u());
        flatBufferBuilder.m21510c(10);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21495a(2, T_(), 0);
        flatBufferBuilder.m21507b(3, a);
        flatBufferBuilder.m21507b(4, b3);
        flatBufferBuilder.m21507b(5, a2);
        flatBufferBuilder.m21507b(6, b4);
        flatBufferBuilder.m21507b(7, b5);
        flatBufferBuilder.m21507b(8, b6);
        flatBufferBuilder.m21494a(9, m25595x(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPageStoriesYouMissedFeedUnit(Parcel parcel) {
        super(11);
        this.f18247e = parcel.readString();
        this.f18248f = parcel.readString();
        this.f18249g = parcel.readLong();
        this.f18254l = parcel.readString();
        this.f18255m = parcel.readString();
        this.f18256n = parcel.readInt();
        this.f18250h = (GraphQLPageStoriesYouMissedFeedUnitStoriesConnection) parcel.readValue(GraphQLPageStoriesYouMissedFeedUnitStoriesConnection.class.getClassLoader());
        this.f18251i = parcel.readString();
        this.f18252j = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18253k = parcel.readString();
        this.f18257o = (PageStoriesYouMissedFeedUnitExtra) ParcelUtil.b(parcel, PageStoriesYouMissedFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo2507g());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeString(m25591t());
        parcel.writeString(m25592u());
        parcel.writeInt(m25595x());
        parcel.writeValue(m25584l());
        parcel.writeString(m25589r());
        parcel.writeValue(m25590s());
        parcel.writeString(mo2877k());
        parcel.writeParcelable(m25572A(), i);
    }

    public final GraphQLTextWithEntities mo2878m() {
        return m25590s();
    }

    private PageStoriesYouMissedFeedUnitExtra m25572A() {
        if (this.f18257o == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18257o = new PageStoriesYouMissedFeedUnitExtra();
            } else {
                this.f18257o = (PageStoriesYouMissedFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, PageStoriesYouMissedFeedUnitExtra.class);
            }
        }
        return this.f18257o;
    }

    public final PropertyBag U_() {
        if (this.f18258p == null) {
            this.f18258p = new PropertyBag();
        }
        return this.f18258p;
    }
}
