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
/* compiled from: last_asset_flush_completion_time */
public final class GraphQLGroupTopStoriesFeedUnit extends BaseModel implements FeedUnit, HideableUnit, HasProperty, ScrollableItemListFeedUnit, CachedFeedTrackable, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLGroupTopStoriesFeedUnit> CREATOR = new 1();
    GraphQLObjectType f18161d = new GraphQLObjectType(1257701471);
    @Nullable
    GraphQLGroupTopStoriesFeedUnitStoriesConnection f18162e;
    @Nullable
    String f18163f;
    @Nullable
    String f18164g;
    long f18165h;
    @Nullable
    String f18166i;
    @Nullable
    GraphQLTextWithEntities f18167j;
    @Nullable
    String f18168k;
    @Nullable
    public String f18169l;
    @Nullable
    public String f18170m;
    public int f18171n;
    private GroupTopStoriesFeedUnitExtra f18172o;
    @Nullable
    private PropertyBag f18173p = null;

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m25472A();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27152a((HasTracking) this);
    }

    public final GraphQLObjectType getType() {
        return this.f18161d;
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
        return ItemListFeedUnitImpl.m30140a(this);
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
    public final GraphQLGroupTopStoriesFeedUnitStoriesConnection m25484l() {
        this.f18162e = (GraphQLGroupTopStoriesFeedUnitStoriesConnection) super.m9947a(this.f18162e, 0, GraphQLGroupTopStoriesFeedUnitStoriesConnection.class);
        return this.f18162e;
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f18163f = super.m9948a(this.f18163f, 1);
        return this.f18163f;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f18164g = super.m9948a(this.f18164g, 2);
        return this.f18164g;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 3);
        return this.f18165h;
    }

    public final void mo2872a(long j) {
        this.f18165h = j;
    }

    @FieldOffset
    @Nullable
    public final String m25489r() {
        this.f18166i = super.m9948a(this.f18166i, 4);
        return this.f18166i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25490s() {
        this.f18167j = (GraphQLTextWithEntities) super.m9947a(this.f18167j, 5, GraphQLTextWithEntities.class);
        return this.f18167j;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f18168k = super.m9948a(this.f18168k, 6);
        return this.f18168k;
    }

    @FieldOffset
    @Nullable
    public final String m25491t() {
        this.f18169l = super.m9948a(this.f18169l, 7);
        return this.f18169l;
    }

    @FieldOffset
    @Nullable
    public final String m25492u() {
        this.f18170m = super.m9948a(this.f18170m, 8);
        return this.f18170m;
    }

    @FieldOffset
    public final int m25495x() {
        m9949a(1, 1);
        return this.f18171n;
    }

    @Nullable
    public final String mo2834a() {
        return mo2507g();
    }

    public final GraphQLTextWithEntities mo2878m() {
        return m25490s();
    }

    public final int jK_() {
        return 1257701471;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m25484l() != null) {
            GraphQLGroupTopStoriesFeedUnitStoriesConnection graphQLGroupTopStoriesFeedUnitStoriesConnection = (GraphQLGroupTopStoriesFeedUnitStoriesConnection) graphQLModelMutatingVisitor.mo2928b(m25484l());
            if (m25484l() != graphQLGroupTopStoriesFeedUnitStoriesConnection) {
                graphQLVisitableModel = (GraphQLGroupTopStoriesFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18162e = graphQLGroupTopStoriesFeedUnitStoriesConnection;
            }
        }
        if (m25490s() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25490s());
            if (m25490s() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGroupTopStoriesFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18167j = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("local_last_negative_feedback_action_type".equals(str)) {
            consistencyTuple.f18727a = m25491t();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 7;
        } else if ("local_story_visibility".equals(str)) {
            consistencyTuple.f18727a = m25492u();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 8;
        } else if ("local_story_visible_height".equals(str)) {
            consistencyTuple.f18727a = Integer.valueOf(m25495x());
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
            this.f18169l = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 7, str2);
            }
        } else if ("local_story_visibility".equals(str)) {
            str2 = (String) obj;
            this.f18170m = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 8, str2);
            }
        } else if ("local_story_visible_height".equals(str)) {
            int intValue = ((Integer) obj).intValue();
            this.f18171n = intValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21544b(this.f5824c, 9, intValue);
            }
        }
    }

    public GraphQLGroupTopStoriesFeedUnit() {
        super(11);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18165h = mutableFlatBuffer.m21525a(i, 3, 0);
        this.f18171n = mutableFlatBuffer.m21524a(i, 9, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m25484l());
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int b3 = flatBufferBuilder.m21502b(m25489r());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m25490s());
        int b4 = flatBufferBuilder.m21502b(mo2877k());
        int b5 = flatBufferBuilder.m21502b(m25491t());
        int b6 = flatBufferBuilder.m21502b(m25492u());
        flatBufferBuilder.m21510c(10);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, b2);
        flatBufferBuilder.m21495a(3, T_(), 0);
        flatBufferBuilder.m21507b(4, b3);
        flatBufferBuilder.m21507b(5, a2);
        flatBufferBuilder.m21507b(6, b4);
        flatBufferBuilder.m21507b(7, b5);
        flatBufferBuilder.m21507b(8, b6);
        flatBufferBuilder.m21494a(9, m25495x(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLGroupTopStoriesFeedUnit(Parcel parcel) {
        super(11);
        this.f18162e = (GraphQLGroupTopStoriesFeedUnitStoriesConnection) parcel.readValue(GraphQLGroupTopStoriesFeedUnitStoriesConnection.class.getClassLoader());
        this.f18163f = parcel.readString();
        this.f18164g = parcel.readString();
        this.f18165h = parcel.readLong();
        this.f18169l = parcel.readString();
        this.f18170m = parcel.readString();
        this.f18171n = parcel.readInt();
        this.f18166i = parcel.readString();
        this.f18167j = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18168k = parcel.readString();
        this.f18172o = (GroupTopStoriesFeedUnitExtra) ParcelUtil.b(parcel, GroupTopStoriesFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m25484l());
        parcel.writeString(mo2507g());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeString(m25491t());
        parcel.writeString(m25492u());
        parcel.writeInt(m25495x());
        parcel.writeString(m25489r());
        parcel.writeValue(m25490s());
        parcel.writeString(mo2877k());
        parcel.writeParcelable(m25472A(), i);
    }

    private GroupTopStoriesFeedUnitExtra m25472A() {
        if (this.f18172o == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18172o = new GroupTopStoriesFeedUnitExtra();
            } else {
                this.f18172o = (GroupTopStoriesFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, GroupTopStoriesFeedUnitExtra.class);
            }
        }
        return this.f18172o;
    }

    public final PropertyBag U_() {
        if (this.f18173p == null) {
            this.f18173p = new PropertyBag();
        }
        return this.f18173p;
    }
}
