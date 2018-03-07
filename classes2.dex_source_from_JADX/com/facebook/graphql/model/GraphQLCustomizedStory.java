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
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.enums.GraphQLSubstoriesGroupingReason;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.extras.FeedUnitExtra;
import com.facebook.graphql.model.interfaces.CachedFeedTrackable;
import com.facebook.graphql.model.interfaces.HasTracking;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
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
/* compiled from: last_fire_timestamp */
public final class GraphQLCustomizedStory extends BaseModel implements FeedUnit, HasHideableToken, HasNegativeFeedbackActions, HideableUnit, NegativeFeedbackActionsUnit, HasProperty, CachedFeedTrackable, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLCustomizedStory> CREATOR = new 1();
    List<GraphQLSubstoriesGroupingReason> f17973A;
    @Nullable
    GraphQLTextWithEntities f17974B;
    @Nullable
    GraphQLTextWithEntities f17975C;
    @Nullable
    GraphQLTextWithEntities f17976D;
    @Nullable
    String f17977E;
    @Nullable
    String f17978F;
    @Nullable
    public String f17979G;
    @Nullable
    public String f17980H;
    public int f17981I;
    private CustomizedStoryExtra f17982J;
    @Nullable
    private PropertyBag f17983K = null;
    GraphQLObjectType f17984d = new GraphQLObjectType(-768185132);
    List<GraphQLStoryActionLink> f17985e;
    List<GraphQLActor> f17986f;
    @Nullable
    GraphQLImage f17987g;
    List<GraphQLStoryAttachment> f17988h;
    @Nullable
    String f17989i;
    long f17990j;
    @Nullable
    String f17991k;
    @Nullable
    GraphQLFeedback f17992l;
    @Nullable
    GraphQLFeedbackContext f17993m;
    long f17994n;
    @Nullable
    String f17995o;
    @Nullable
    String f17996p;
    @Nullable
    GraphQLTextWithEntities f17997q;
    List<GraphQLStoryAttachment> f17998r;
    @Nullable
    GraphQLNegativeFeedbackActionsConnection f17999s;
    @Nullable
    GraphQLPrivacyScope f18000t;
    GraphQLStorySeenState f18001u;
    @Nullable
    GraphQLEntity f18002v;
    @Nullable
    String f18003w;
    @Deprecated
    @Nullable
    GraphQLTextWithEntities f18004x;
    @Nullable
    GraphQLStoryHeader f18005y;
    @Deprecated
    @Nullable
    GraphQLTextWithEntities f18006z;

    public final String mo2892r() {
        return m25265z();
    }

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m25221S();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27152a((HasTracking) this);
    }

    public final GraphQLObjectType getType() {
        return this.f17984d;
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

    public final String mo2881q() {
        return HideableUnitUtil.m26320a((HasHideableToken) this);
    }

    public final GraphQLNegativeFeedbackActionType mo2893s() {
        return NegativeFeedbackActionsUnitImpl.m29497a((NegativeFeedbackActionsUnit) this);
    }

    public final GraphQLNegativeFeedbackActionsConnection mo2894t() {
        return NegativeFeedbackActionsUnitImpl.m29498a((HasNegativeFeedbackActions) this);
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryActionLink> m25251l() {
        this.f17985e = super.m9944a(this.f17985e, 0, GraphQLStoryActionLink.class);
        return (ImmutableList) this.f17985e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLActor> m25252m() {
        this.f17986f = super.m9944a(this.f17986f, 1, GraphQLActor.class);
        return (ImmutableList) this.f17986f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m25253n() {
        this.f17987g = (GraphQLImage) super.m9947a(this.f17987g, 2, GraphQLImage.class);
        return this.f17987g;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachment> m25260u() {
        this.f17988h = super.m9944a(this.f17988h, 3, GraphQLStoryAttachment.class);
        return (ImmutableList) this.f17988h;
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f17989i = super.m9948a(this.f17989i, 4);
        return this.f17989i;
    }

    @FieldOffset
    public final long m25261v() {
        m9949a(0, 5);
        return this.f17990j;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f17991k = super.m9948a(this.f17991k, 6);
        return this.f17991k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback m25262w() {
        this.f17992l = (GraphQLFeedback) super.m9947a(this.f17992l, 7, GraphQLFeedback.class);
        return this.f17992l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedbackContext m25263x() {
        this.f17993m = (GraphQLFeedbackContext) super.m9947a(this.f17993m, 8, GraphQLFeedbackContext.class);
        return this.f17993m;
    }

    @FieldOffset
    public final long T_() {
        m9949a(1, 1);
        return this.f17994n;
    }

    public final void mo2872a(long j) {
        this.f17994n = j;
    }

    @FieldOffset
    @Nullable
    public final String mo2896y() {
        this.f17995o = super.m9948a(this.f17995o, 10);
        return this.f17995o;
    }

    @FieldOffset
    @Nullable
    public final String m25265z() {
        this.f17996p = super.m9948a(this.f17996p, 11);
        return this.f17996p;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25222A() {
        this.f17997q = (GraphQLTextWithEntities) super.m9947a(this.f17997q, 12, GraphQLTextWithEntities.class);
        return this.f17997q;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachment> m25223B() {
        this.f17998r = super.m9944a(this.f17998r, 13, GraphQLStoryAttachment.class);
        return (ImmutableList) this.f17998r;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNegativeFeedbackActionsConnection mo2885C() {
        this.f17999s = (GraphQLNegativeFeedbackActionsConnection) super.m9947a(this.f17999s, 14, GraphQLNegativeFeedbackActionsConnection.class);
        return this.f17999s;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyScope m25225D() {
        this.f18000t = (GraphQLPrivacyScope) super.m9947a(this.f18000t, 15, GraphQLPrivacyScope.class);
        return this.f18000t;
    }

    @FieldOffset
    public final GraphQLStorySeenState m25226E() {
        this.f18001u = (GraphQLStorySeenState) super.m9945a(this.f18001u, 16, GraphQLStorySeenState.class, GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f18001u;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEntity m25227F() {
        this.f18002v = (GraphQLEntity) super.m9947a(this.f18002v, 17, GraphQLEntity.class);
        return this.f18002v;
    }

    @FieldOffset
    @Nullable
    public final String m25228G() {
        this.f18003w = super.m9948a(this.f18003w, 19);
        return this.f18003w;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25229H() {
        this.f18004x = (GraphQLTextWithEntities) super.m9947a(this.f18004x, 20, GraphQLTextWithEntities.class);
        return this.f18004x;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStoryHeader m25230I() {
        this.f18005y = (GraphQLStoryHeader) super.m9947a(this.f18005y, 22, GraphQLStoryHeader.class);
        return this.f18005y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25231J() {
        this.f18006z = (GraphQLTextWithEntities) super.m9947a(this.f18006z, 23, GraphQLTextWithEntities.class);
        return this.f18006z;
    }

    @FieldOffset
    public final ImmutableList<GraphQLSubstoriesGroupingReason> m25232K() {
        this.f17973A = super.m9953b(this.f17973A, 24, GraphQLSubstoriesGroupingReason.class);
        return (ImmutableList) this.f17973A;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25233L() {
        this.f17974B = (GraphQLTextWithEntities) super.m9947a(this.f17974B, 25, GraphQLTextWithEntities.class);
        return this.f17974B;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25234M() {
        this.f17975C = (GraphQLTextWithEntities) super.m9947a(this.f17975C, 26, GraphQLTextWithEntities.class);
        return this.f17975C;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25235N() {
        this.f17976D = (GraphQLTextWithEntities) super.m9947a(this.f17976D, 27, GraphQLTextWithEntities.class);
        return this.f17976D;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f17977E = super.m9948a(this.f17977E, 28);
        return this.f17977E;
    }

    @FieldOffset
    @Nullable
    public final String m25236O() {
        this.f17978F = super.m9948a(this.f17978F, 29);
        return this.f17978F;
    }

    @FieldOffset
    @Nullable
    public final String m25237P() {
        this.f17979G = super.m9948a(this.f17979G, 30);
        return this.f17979G;
    }

    @FieldOffset
    @Nullable
    public final String m25238Q() {
        this.f17980H = super.m9948a(this.f17980H, 31);
        return this.f17980H;
    }

    @FieldOffset
    public final int m25239R() {
        m9949a(4, 0);
        return this.f17981I;
    }

    @Nullable
    public final String mo2834a() {
        return m25265z();
    }

    public final int jK_() {
        return -768185132;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        Builder a2;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m25251l() != null) {
            a = ModelHelper.m23097a(m25251l(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLCustomizedStory) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17985e = a.m1068b();
            }
        }
        if (m25252m() != null) {
            a = ModelHelper.m23097a(m25252m(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLCustomizedStory) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17986f = a.m1068b();
            }
        }
        GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
        if (m25253n() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m25253n());
            if (m25253n() != graphQLImage) {
                graphQLVisitableModel2 = (GraphQLCustomizedStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f17987g = graphQLImage;
            }
        }
        if (m25260u() != null) {
            a2 = ModelHelper.m23097a(m25260u(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                GraphQLCustomizedStory graphQLCustomizedStory = (GraphQLCustomizedStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLCustomizedStory.f17988h = a2.m1068b();
                graphQLVisitableModel2 = graphQLCustomizedStory;
            }
        }
        if (m25262w() != null) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.mo2928b(m25262w());
            if (m25262w() != graphQLFeedback) {
                graphQLVisitableModel2 = (GraphQLCustomizedStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f17992l = graphQLFeedback;
            }
        }
        if (m25263x() != null) {
            GraphQLFeedbackContext graphQLFeedbackContext = (GraphQLFeedbackContext) graphQLModelMutatingVisitor.mo2928b(m25263x());
            if (m25263x() != graphQLFeedbackContext) {
                graphQLVisitableModel2 = (GraphQLCustomizedStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f17993m = graphQLFeedbackContext;
            }
        }
        if (m25222A() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25222A());
            if (m25222A() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLCustomizedStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f17997q = graphQLTextWithEntities;
            }
        }
        if (m25223B() != null) {
            a2 = ModelHelper.m23097a(m25223B(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                graphQLCustomizedStory = (GraphQLCustomizedStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLCustomizedStory.f17998r = a2.m1068b();
                graphQLVisitableModel2 = graphQLCustomizedStory;
            }
        }
        if (mo2885C() != null) {
            GraphQLNegativeFeedbackActionsConnection graphQLNegativeFeedbackActionsConnection = (GraphQLNegativeFeedbackActionsConnection) graphQLModelMutatingVisitor.mo2928b(mo2885C());
            if (mo2885C() != graphQLNegativeFeedbackActionsConnection) {
                graphQLVisitableModel2 = (GraphQLCustomizedStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f17999s = graphQLNegativeFeedbackActionsConnection;
            }
        }
        if (m25225D() != null) {
            GraphQLPrivacyScope graphQLPrivacyScope = (GraphQLPrivacyScope) graphQLModelMutatingVisitor.mo2928b(m25225D());
            if (m25225D() != graphQLPrivacyScope) {
                graphQLVisitableModel2 = (GraphQLCustomizedStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18000t = graphQLPrivacyScope;
            }
        }
        if (m25227F() != null) {
            GraphQLEntity graphQLEntity = (GraphQLEntity) graphQLModelMutatingVisitor.mo2928b(m25227F());
            if (m25227F() != graphQLEntity) {
                graphQLVisitableModel2 = (GraphQLCustomizedStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18002v = graphQLEntity;
            }
        }
        if (m25229H() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25229H());
            if (m25229H() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLCustomizedStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18004x = graphQLTextWithEntities;
            }
        }
        if (m25230I() != null) {
            GraphQLStoryHeader graphQLStoryHeader = (GraphQLStoryHeader) graphQLModelMutatingVisitor.mo2928b(m25230I());
            if (m25230I() != graphQLStoryHeader) {
                graphQLVisitableModel2 = (GraphQLCustomizedStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18005y = graphQLStoryHeader;
            }
        }
        if (m25231J() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25231J());
            if (m25231J() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLCustomizedStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18006z = graphQLTextWithEntities;
            }
        }
        if (m25233L() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25233L());
            if (m25233L() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLCustomizedStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f17974B = graphQLTextWithEntities;
            }
        }
        if (m25234M() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25234M());
            if (m25234M() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLCustomizedStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f17975C = graphQLTextWithEntities;
            }
        }
        if (m25235N() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25235N());
            if (m25235N() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLCustomizedStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f17976D = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("local_last_negative_feedback_action_type".equals(str)) {
            consistencyTuple.f18727a = m25237P();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 30;
        } else if ("local_story_visibility".equals(str)) {
            consistencyTuple.f18727a = m25238Q();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 31;
        } else if ("local_story_visible_height".equals(str)) {
            consistencyTuple.f18727a = Integer.valueOf(m25239R());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 32;
        } else {
            consistencyTuple.m26322a();
        }
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        String str2;
        if ("local_last_negative_feedback_action_type".equals(str)) {
            str2 = (String) obj;
            this.f17979G = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 30, str2);
            }
        } else if ("local_story_visibility".equals(str)) {
            str2 = (String) obj;
            this.f17980H = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 31, str2);
            }
        } else if ("local_story_visible_height".equals(str)) {
            int intValue = ((Integer) obj).intValue();
            this.f17981I = intValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21544b(this.f5824c, 32, intValue);
            }
        }
    }

    public GraphQLCustomizedStory() {
        super(34);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17990j = mutableFlatBuffer.m21525a(i, 5, 0);
        this.f17994n = mutableFlatBuffer.m21525a(i, 9, 0);
        this.f17981I = mutableFlatBuffer.m21524a(i, 32, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m25251l());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m25252m());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m25253n());
        int a4 = ModelHelper.m23094a(flatBufferBuilder, m25260u());
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m25262w());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m25263x());
        int b3 = flatBufferBuilder.m21502b(mo2896y());
        int b4 = flatBufferBuilder.m21502b(m25265z());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m25222A());
        int a8 = ModelHelper.m23094a(flatBufferBuilder, m25223B());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, mo2885C());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, m25225D());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, m25227F());
        int b5 = flatBufferBuilder.m21502b(m25228G());
        int a12 = ModelHelper.m23093a(flatBufferBuilder, m25229H());
        int a13 = ModelHelper.m23093a(flatBufferBuilder, m25230I());
        int a14 = ModelHelper.m23093a(flatBufferBuilder, m25231J());
        int e = flatBufferBuilder.m21514e(m25232K());
        int a15 = ModelHelper.m23093a(flatBufferBuilder, m25233L());
        int a16 = ModelHelper.m23093a(flatBufferBuilder, m25234M());
        int a17 = ModelHelper.m23093a(flatBufferBuilder, m25235N());
        int b6 = flatBufferBuilder.m21502b(mo2877k());
        int b7 = flatBufferBuilder.m21502b(m25236O());
        int b8 = flatBufferBuilder.m21502b(m25237P());
        int b9 = flatBufferBuilder.m21502b(m25238Q());
        flatBufferBuilder.m21510c(33);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(2, a3);
        flatBufferBuilder.m21507b(3, a4);
        flatBufferBuilder.m21507b(4, b);
        flatBufferBuilder.m21495a(5, m25261v(), 0);
        flatBufferBuilder.m21507b(6, b2);
        flatBufferBuilder.m21507b(7, a5);
        flatBufferBuilder.m21507b(8, a6);
        flatBufferBuilder.m21495a(9, T_(), 0);
        flatBufferBuilder.m21507b(10, b3);
        flatBufferBuilder.m21507b(11, b4);
        flatBufferBuilder.m21507b(12, a7);
        flatBufferBuilder.m21507b(13, a8);
        flatBufferBuilder.m21507b(14, a9);
        flatBufferBuilder.m21507b(15, a10);
        flatBufferBuilder.m21496a(16, m25226E() == GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m25226E());
        flatBufferBuilder.m21507b(17, a11);
        flatBufferBuilder.m21507b(19, b5);
        flatBufferBuilder.m21507b(20, a12);
        flatBufferBuilder.m21507b(22, a13);
        flatBufferBuilder.m21507b(23, a14);
        flatBufferBuilder.m21507b(24, e);
        flatBufferBuilder.m21507b(25, a15);
        flatBufferBuilder.m21507b(26, a16);
        flatBufferBuilder.m21507b(27, a17);
        flatBufferBuilder.m21507b(28, b6);
        flatBufferBuilder.m21507b(29, b7);
        flatBufferBuilder.m21507b(30, b8);
        flatBufferBuilder.m21507b(31, b9);
        flatBufferBuilder.m21494a(32, m25239R(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLCustomizedStory(Parcel parcel) {
        super(34);
        this.f17985e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryActionLink.class.getClassLoader()));
        this.f17986f = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLActor.class.getClassLoader()));
        this.f17987g = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17988h = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryAttachment.class.getClassLoader()));
        this.f17989i = parcel.readString();
        this.f17990j = parcel.readLong();
        this.f17991k = parcel.readString();
        this.f17992l = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f17993m = (GraphQLFeedbackContext) parcel.readValue(GraphQLFeedbackContext.class.getClassLoader());
        this.f17994n = parcel.readLong();
        this.f17995o = parcel.readString();
        this.f17996p = parcel.readString();
        this.f17979G = parcel.readString();
        this.f17980H = parcel.readString();
        this.f17981I = parcel.readInt();
        this.f17997q = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f17998r = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryAttachment.class.getClassLoader()));
        this.f17999s = (GraphQLNegativeFeedbackActionsConnection) parcel.readValue(GraphQLNegativeFeedbackActionsConnection.class.getClassLoader());
        this.f18000t = (GraphQLPrivacyScope) parcel.readValue(GraphQLPrivacyScope.class.getClassLoader());
        this.f18001u = GraphQLStorySeenState.fromString(parcel.readString());
        this.f18002v = (GraphQLEntity) parcel.readValue(GraphQLEntity.class.getClassLoader());
        this.f18003w = parcel.readString();
        this.f18004x = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18005y = (GraphQLStoryHeader) parcel.readValue(GraphQLStoryHeader.class.getClassLoader());
        this.f18006z = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f17973A = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLSubstoriesGroupingReason.class.getClassLoader()));
        this.f17974B = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f17975C = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f17976D = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f17977E = parcel.readString();
        this.f17978F = parcel.readString();
        this.f17982J = (CustomizedStoryExtra) ParcelUtil.b(parcel, CustomizedStoryExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m25251l());
        parcel.writeList(m25252m());
        parcel.writeValue(m25253n());
        parcel.writeList(m25260u());
        parcel.writeString(mo2507g());
        parcel.writeLong(m25261v());
        parcel.writeString(S_());
        parcel.writeValue(m25262w());
        parcel.writeValue(m25263x());
        parcel.writeLong(T_());
        parcel.writeString(mo2896y());
        parcel.writeString(m25265z());
        parcel.writeString(m25237P());
        parcel.writeString(m25238Q());
        parcel.writeInt(m25239R());
        parcel.writeValue(m25222A());
        parcel.writeList(m25223B());
        parcel.writeValue(mo2885C());
        parcel.writeValue(m25225D());
        parcel.writeString(m25226E().name());
        parcel.writeValue(m25227F());
        parcel.writeString(m25228G());
        parcel.writeValue(m25229H());
        parcel.writeValue(m25230I());
        parcel.writeValue(m25231J());
        parcel.writeList(m25232K());
        parcel.writeValue(m25233L());
        parcel.writeValue(m25234M());
        parcel.writeValue(m25235N());
        parcel.writeString(mo2877k());
        parcel.writeString(m25236O());
        parcel.writeParcelable(m25221S(), i);
    }

    private CustomizedStoryExtra m25221S() {
        if (this.f17982J == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f17982J = new CustomizedStoryExtra();
            } else {
                this.f17982J = (CustomizedStoryExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, CustomizedStoryExtra.class);
            }
        }
        return this.f17982J;
    }

    public final PropertyBag U_() {
        if (this.f17983K == null) {
            this.f17983K = new PropertyBag();
        }
        return this.f17983K;
    }
}
