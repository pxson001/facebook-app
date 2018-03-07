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
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLStorySetCollectionType;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.extras.FeedUnitExtra;
import com.facebook.graphql.model.interfaces.AutoScrollableItemListFeedUnit;
import com.facebook.graphql.model.interfaces.FollowUpFeedUnit;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
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
/* compiled from: login_screen */
public final class GraphQLStorySet extends BaseModel implements FeedUnit, HideableUnit, NegativeFeedbackActionsUnit, HasProperty, ScrollableItemListFeedUnit, Sponsorable, AutoScrollableItemListFeedUnit, FollowUpFeedUnit, TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLStorySet> CREATOR = new 1();
    GraphQLObjectType f15966d = new GraphQLObjectType(1782386509);
    List<GraphQLStoryActionLink> f15967e;
    @Nullable
    GraphQLStorySetStoriesConnection f15968f;
    @Nullable
    String f15969g;
    @Nullable
    String f15970h;
    @Deprecated
    @Nullable
    String f15971i;
    long f15972j;
    @Nullable
    String f15973k;
    @Nullable
    String f15974l;
    @Nullable
    GraphQLTextWithEntities f15975m;
    @Nullable
    GraphQLTextWithEntities f15976n;
    @Nullable
    String f15977o;
    @Nullable
    String f15978p;
    List<GraphQLStorySetCollectionType> f15979q;
    @Nullable
    String f15980r;
    @Nullable
    GraphQLNegativeFeedbackActionsConnection f15981s;
    @Nullable
    public String f15982t;
    @Nullable
    public String f15983u;
    public int f15984v;
    @Nullable
    GraphQLImage f15985w;
    private StorySetExtra f15986x;
    @Nullable
    private PropertyBag f15987y = null;

    public final String mo2892r() {
        return null;
    }

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m22751O();
    }

    public final /* synthetic */ List mo2882v() {
        return m22786x();
    }

    public final GraphQLObjectType getType() {
        return this.f15966d;
    }

    public final ImmutableList<String> mo2874d() {
        if (mo2507g() != null) {
            return ImmutableList.of(mo2507g());
        }
        return RegularImmutableList.f535a;
    }

    @Nullable
    public final SponsoredImpression ab_() {
        return VisibleItemHelper.m26981b(this);
    }

    public final GraphQLNegativeFeedbackActionsConnection mo2894t() {
        GraphQLNegativeFeedbackActionsConnection C;
        GraphQLStory a = StorySetHelper.a(this);
        if (a != null) {
            C = a.mo2885C();
        } else {
            C = null;
        }
        return C;
    }

    public final StoryVisibility mo2879o() {
        return HideableUnitUtil.m26319a((HideableUnit) this);
    }

    public final int mo2880p() {
        return HideableUnitUtil.m26321b(this);
    }

    public final List mo2883w() {
        return StorySetHelper.b(this);
    }

    public final String mo2881q() {
        GraphQLStory a = StorySetHelper.a(this);
        String H = (!mo2895u() || a == null) ? m22759H() : a.mo2896y();
        return H;
    }

    public final GraphQLNegativeFeedbackActionType mo2893s() {
        return NegativeFeedbackActionsUnitImpl.m29497a((NegativeFeedbackActionsUnit) this);
    }

    public final int ac_() {
        return VisibleItemHelper.m26976a((ScrollableItemListFeedUnit) this);
    }

    public final ImmutableList m22786x() {
        return StorySetHelper.b(this);
    }

    public final boolean mo2895u() {
        boolean z;
        ImmutableList b = StorySetHelper.b(this);
        int size = b.size();
        for (int i = 0; i < size; i++) {
            if (((GraphQLStory) b.get(i)).mo2895u()) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryActionLink> m22787y() {
        this.f15967e = super.m9944a(this.f15967e, 0, GraphQLStoryActionLink.class);
        return (ImmutableList) this.f15967e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStorySetStoriesConnection m22788z() {
        this.f15968f = (GraphQLStorySetStoriesConnection) super.m9947a(this.f15968f, 1, GraphQLStorySetStoriesConnection.class);
        return this.f15968f;
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f15969g = super.m9948a(this.f15969g, 2);
        return this.f15969g;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f15970h = super.m9948a(this.f15970h, 3);
        return this.f15970h;
    }

    @FieldOffset
    @Nullable
    public final String m22752A() {
        this.f15971i = super.m9948a(this.f15971i, 4);
        return this.f15971i;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 5);
        return this.f15972j;
    }

    public final void mo2872a(long j) {
        this.f15972j = j;
    }

    @FieldOffset
    @Nullable
    public final String m22753B() {
        this.f15973k = super.m9948a(this.f15973k, 6);
        return this.f15973k;
    }

    @FieldOffset
    @Nullable
    public final String m22754C() {
        this.f15974l = super.m9948a(this.f15974l, 8);
        return this.f15974l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m22755D() {
        this.f15975m = (GraphQLTextWithEntities) super.m9947a(this.f15975m, 9, GraphQLTextWithEntities.class);
        return this.f15975m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m22756E() {
        this.f15976n = (GraphQLTextWithEntities) super.m9947a(this.f15976n, 10, GraphQLTextWithEntities.class);
        return this.f15976n;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f15977o = super.m9948a(this.f15977o, 11);
        return this.f15977o;
    }

    @FieldOffset
    @Nullable
    public final String m22757F() {
        this.f15978p = super.m9948a(this.f15978p, 12);
        return this.f15978p;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStorySetCollectionType> m22758G() {
        this.f15979q = super.m9953b(this.f15979q, 13, GraphQLStorySetCollectionType.class);
        return (ImmutableList) this.f15979q;
    }

    @FieldOffset
    @Nullable
    public final String m22759H() {
        this.f15980r = super.m9948a(this.f15980r, 14);
        return this.f15980r;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNegativeFeedbackActionsConnection m22760I() {
        this.f15981s = (GraphQLNegativeFeedbackActionsConnection) super.m9947a(this.f15981s, 15, GraphQLNegativeFeedbackActionsConnection.class);
        return this.f15981s;
    }

    @FieldOffset
    @Nullable
    public final String m22761J() {
        this.f15982t = super.m9948a(this.f15982t, 16);
        return this.f15982t;
    }

    @FieldOffset
    @Nullable
    public final String m22762K() {
        this.f15983u = super.m9948a(this.f15983u, 17);
        return this.f15983u;
    }

    @FieldOffset
    public final int m22763L() {
        m9949a(2, 2);
        return this.f15984v;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m22764M() {
        this.f15985w = (GraphQLImage) super.m9947a(this.f15985w, 19, GraphQLImage.class);
        return this.f15985w;
    }

    @Nullable
    public final String mo2834a() {
        return m22753B();
    }

    public final GraphQLTextWithEntities mo2878m() {
        return m22755D();
    }

    public final int jK_() {
        return 1782386509;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLStorySetStoriesConnection graphQLStorySetStoriesConnection;
        GraphQLNegativeFeedbackActionsConnection graphQLNegativeFeedbackActionsConnection;
        GraphQLImage graphQLImage;
        GraphQLTextWithEntities graphQLTextWithEntities;
        m9958h();
        if (m22787y() != null) {
            Builder a = ModelHelper.m23097a(m22787y(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLStorySet graphQLStorySet = (GraphQLStorySet) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLStorySet.f15967e = a.m1068b();
                graphQLVisitableModel = graphQLStorySet;
                if (m22788z() != null) {
                    graphQLStorySetStoriesConnection = (GraphQLStorySetStoriesConnection) graphQLModelMutatingVisitor.mo2928b(m22788z());
                    if (m22788z() != graphQLStorySetStoriesConnection) {
                        graphQLVisitableModel = (GraphQLStorySet) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f15968f = graphQLStorySetStoriesConnection;
                    }
                }
                if (m22760I() != null) {
                    graphQLNegativeFeedbackActionsConnection = (GraphQLNegativeFeedbackActionsConnection) graphQLModelMutatingVisitor.mo2928b(m22760I());
                    if (m22760I() != graphQLNegativeFeedbackActionsConnection) {
                        graphQLVisitableModel = (GraphQLStorySet) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f15981s = graphQLNegativeFeedbackActionsConnection;
                    }
                }
                if (m22764M() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m22764M());
                    if (m22764M() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLStorySet) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f15985w = graphQLImage;
                    }
                }
                if (m22755D() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m22755D());
                    if (m22755D() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLStorySet) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f15975m = graphQLTextWithEntities;
                    }
                }
                if (m22756E() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m22756E());
                    if (m22756E() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLStorySet) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f15976n = graphQLTextWithEntities;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m22788z() != null) {
            graphQLStorySetStoriesConnection = (GraphQLStorySetStoriesConnection) graphQLModelMutatingVisitor.mo2928b(m22788z());
            if (m22788z() != graphQLStorySetStoriesConnection) {
                graphQLVisitableModel = (GraphQLStorySet) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15968f = graphQLStorySetStoriesConnection;
            }
        }
        if (m22760I() != null) {
            graphQLNegativeFeedbackActionsConnection = (GraphQLNegativeFeedbackActionsConnection) graphQLModelMutatingVisitor.mo2928b(m22760I());
            if (m22760I() != graphQLNegativeFeedbackActionsConnection) {
                graphQLVisitableModel = (GraphQLStorySet) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15981s = graphQLNegativeFeedbackActionsConnection;
            }
        }
        if (m22764M() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m22764M());
            if (m22764M() != graphQLImage) {
                graphQLVisitableModel = (GraphQLStorySet) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15985w = graphQLImage;
            }
        }
        if (m22755D() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m22755D());
            if (m22755D() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLStorySet) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15975m = graphQLTextWithEntities;
            }
        }
        if (m22756E() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m22756E());
            if (m22756E() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLStorySet) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15976n = graphQLTextWithEntities;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("local_last_negative_feedback_action_type".equals(str)) {
            consistencyTuple.f18727a = m22761J();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 16;
        } else if ("local_story_visibility".equals(str)) {
            consistencyTuple.f18727a = m22762K();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 17;
        } else if ("local_story_visible_height".equals(str)) {
            consistencyTuple.f18727a = Integer.valueOf(m22763L());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 18;
        } else {
            consistencyTuple.m26322a();
        }
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        String str2;
        if ("local_last_negative_feedback_action_type".equals(str)) {
            str2 = (String) obj;
            this.f15982t = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 16, str2);
            }
        } else if ("local_story_visibility".equals(str)) {
            str2 = (String) obj;
            this.f15983u = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 17, str2);
            }
        } else if ("local_story_visible_height".equals(str)) {
            int intValue = ((Integer) obj).intValue();
            this.f15984v = intValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21544b(this.f5824c, 18, intValue);
            }
        }
    }

    public GraphQLStorySet() {
        super(21);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f15972j = mutableFlatBuffer.m21525a(i, 5, 0);
        this.f15984v = mutableFlatBuffer.m21524a(i, 18, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m22787y());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m22788z());
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int b3 = flatBufferBuilder.m21502b(m22752A());
        int b4 = flatBufferBuilder.m21502b(m22753B());
        int b5 = flatBufferBuilder.m21502b(m22754C());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m22755D());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m22756E());
        int b6 = flatBufferBuilder.m21502b(mo2877k());
        int b7 = flatBufferBuilder.m21502b(m22757F());
        int e = flatBufferBuilder.m21514e(m22758G());
        int b8 = flatBufferBuilder.m21502b(m22759H());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m22760I());
        int b9 = flatBufferBuilder.m21502b(m22761J());
        int b10 = flatBufferBuilder.m21502b(m22762K());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m22764M());
        flatBufferBuilder.m21510c(20);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(2, b);
        flatBufferBuilder.m21507b(3, b2);
        flatBufferBuilder.m21507b(4, b3);
        flatBufferBuilder.m21495a(5, T_(), 0);
        flatBufferBuilder.m21507b(6, b4);
        flatBufferBuilder.m21507b(8, b5);
        flatBufferBuilder.m21507b(9, a3);
        flatBufferBuilder.m21507b(10, a4);
        flatBufferBuilder.m21507b(11, b6);
        flatBufferBuilder.m21507b(12, b7);
        flatBufferBuilder.m21507b(13, e);
        flatBufferBuilder.m21507b(14, b8);
        flatBufferBuilder.m21507b(15, a5);
        flatBufferBuilder.m21507b(16, b9);
        flatBufferBuilder.m21507b(17, b10);
        flatBufferBuilder.m21494a(18, m22763L(), 0);
        flatBufferBuilder.m21507b(19, a6);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLStorySet(Parcel parcel) {
        super(21);
        this.f15967e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryActionLink.class.getClassLoader()));
        this.f15968f = (GraphQLStorySetStoriesConnection) parcel.readValue(GraphQLStorySetStoriesConnection.class.getClassLoader());
        this.f15969g = parcel.readString();
        this.f15979q = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStorySetCollectionType.class.getClassLoader()));
        this.f15970h = parcel.readString();
        this.f15971i = parcel.readString();
        this.f15972j = parcel.readLong();
        this.f15980r = parcel.readString();
        this.f15973k = parcel.readString();
        this.f15982t = parcel.readString();
        this.f15983u = parcel.readString();
        this.f15984v = parcel.readInt();
        this.f15981s = (GraphQLNegativeFeedbackActionsConnection) parcel.readValue(GraphQLNegativeFeedbackActionsConnection.class.getClassLoader());
        this.f15985w = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f15974l = parcel.readString();
        this.f15975m = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f15976n = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f15977o = parcel.readString();
        this.f15978p = parcel.readString();
        this.f15986x = (StorySetExtra) ParcelUtil.b(parcel, StorySetExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m22787y());
        parcel.writeValue(m22788z());
        parcel.writeString(mo2507g());
        parcel.writeList(m22758G());
        parcel.writeString(S_());
        parcel.writeString(m22752A());
        parcel.writeLong(T_());
        parcel.writeString(m22759H());
        parcel.writeString(m22753B());
        parcel.writeString(m22761J());
        parcel.writeString(m22762K());
        parcel.writeInt(m22763L());
        parcel.writeValue(m22760I());
        parcel.writeValue(m22764M());
        parcel.writeString(m22754C());
        parcel.writeValue(m22755D());
        parcel.writeValue(m22756E());
        parcel.writeString(mo2877k());
        parcel.writeString(m22757F());
        parcel.writeParcelable(m22751O(), i);
    }

    public GraphQLStorySet(Builder builder) {
        super(21);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f15967e = builder.d;
        this.f15968f = builder.e;
        this.f15969g = builder.f;
        this.f15979q = builder.g;
        this.f15970h = builder.h;
        this.f15971i = builder.i;
        this.f15972j = builder.j;
        this.f15980r = builder.k;
        this.f15973k = builder.l;
        this.f15982t = builder.m;
        this.f15983u = builder.n;
        this.f15984v = builder.o;
        this.f15981s = builder.p;
        this.f15985w = builder.q;
        this.f15974l = builder.r;
        this.f15975m = builder.s;
        this.f15976n = builder.t;
        this.f15977o = builder.u;
        this.f15978p = builder.v;
        this.f15987y = builder.w;
    }

    private StorySetExtra m22751O() {
        if (this.f15986x == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f15986x = new StorySetExtra();
            } else {
                this.f15986x = (StorySetExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, StorySetExtra.class);
            }
        }
        return this.f15986x;
    }

    public final PropertyBag U_() {
        if (this.f15987y == null) {
            this.f15987y = new PropertyBag();
        }
        return this.f15987y;
    }
}
