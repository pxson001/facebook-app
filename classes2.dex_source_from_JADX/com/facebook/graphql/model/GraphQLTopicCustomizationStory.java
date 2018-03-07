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
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.enums.GraphQLSubstoriesGroupingReason;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.extras.FeedUnitExtra;
import com.facebook.graphql.model.interfaces.HasTracking;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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
/* compiled from: jewels/ */
public final class GraphQLTopicCustomizationStory extends BaseModel implements FeedUnit, HasProperty, ScrollableItemListFeedUnit, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLTopicCustomizationStory> CREATOR = new 1();
    @Nullable
    GraphQLTextWithEntities f18606A;
    @Nullable
    GraphQLTextWithEntities f18607B;
    @Nullable
    String f18608C;
    @Nullable
    String f18609D;
    @Nullable
    GraphQLExploreFeed f18610E;
    private TopicCustomizationStoryExtra f18611F;
    @Nullable
    private PropertyBag f18612G = null;
    GraphQLObjectType f18613d = new GraphQLObjectType(-1182375855);
    List<GraphQLStoryActionLink> f18614e;
    List<GraphQLActor> f18615f;
    @Nullable
    GraphQLImage f18616g;
    List<GraphQLStoryAttachment> f18617h;
    @Nullable
    String f18618i;
    long f18619j;
    @Nullable
    String f18620k;
    @Nullable
    GraphQLFeedback f18621l;
    @Nullable
    GraphQLFeedbackContext f18622m;
    long f18623n;
    @Nullable
    String f18624o;
    @Nullable
    String f18625p;
    @Nullable
    GraphQLTextWithEntities f18626q;
    List<GraphQLStoryAttachment> f18627r;
    @Nullable
    GraphQLNegativeFeedbackActionsConnection f18628s;
    @Nullable
    GraphQLPrivacyScope f18629t;
    GraphQLStorySeenState f18630u;
    @Nullable
    GraphQLEntity f18631v;
    @Nullable
    String f18632w;
    @Nullable
    GraphQLStoryHeader f18633x;
    List<GraphQLSubstoriesGroupingReason> f18634y;
    @Nullable
    GraphQLTrueTopicFeedOptionsConnection f18635z;

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m26092O();
    }

    public final /* synthetic */ List mo2882v() {
        return m26118o();
    }

    public final /* synthetic */ List mo2883w() {
        return m26116l();
    }

    public final GraphQLObjectType getType() {
        return this.f18613d;
    }

    public final ImmutableList<String> mo2874d() {
        if (mo2507g() != null) {
            return ImmutableList.of(mo2507g());
        }
        return RegularImmutableList.f535a;
    }

    public final ImmutableList m26116l() {
        return ItemListFeedUnitImpl.m30155a(this);
    }

    public final int ac_() {
        return VisibleItemHelper.m26976a((ScrollableItemListFeedUnit) this);
    }

    public final ImmutableList m26118o() {
        return ItemListFeedUnitImpl.m30155a(this);
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryActionLink> m26119p() {
        this.f18614e = super.m9944a(this.f18614e, 0, GraphQLStoryActionLink.class);
        return (ImmutableList) this.f18614e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLActor> m26120q() {
        this.f18615f = super.m9944a(this.f18615f, 1, GraphQLActor.class);
        return (ImmutableList) this.f18615f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m26121r() {
        this.f18616g = (GraphQLImage) super.m9947a(this.f18616g, 2, GraphQLImage.class);
        return this.f18616g;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachment> m26122s() {
        this.f18617h = super.m9944a(this.f18617h, 3, GraphQLStoryAttachment.class);
        return (ImmutableList) this.f18617h;
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f18618i = super.m9948a(this.f18618i, 4);
        return this.f18618i;
    }

    @FieldOffset
    public final long m26123t() {
        m9949a(0, 5);
        return this.f18619j;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f18620k = super.m9948a(this.f18620k, 6);
        return this.f18620k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback m26124u() {
        this.f18621l = (GraphQLFeedback) super.m9947a(this.f18621l, 7, GraphQLFeedback.class);
        return this.f18621l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedbackContext m26127x() {
        this.f18622m = (GraphQLFeedbackContext) super.m9947a(this.f18622m, 8, GraphQLFeedbackContext.class);
        return this.f18622m;
    }

    @FieldOffset
    public final long T_() {
        m9949a(1, 1);
        return this.f18623n;
    }

    public final void mo2872a(long j) {
        this.f18623n = j;
    }

    @FieldOffset
    @Nullable
    public final String m26128y() {
        this.f18624o = super.m9948a(this.f18624o, 10);
        return this.f18624o;
    }

    @FieldOffset
    @Nullable
    public final String m26129z() {
        this.f18625p = super.m9948a(this.f18625p, 11);
        return this.f18625p;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m26093A() {
        this.f18626q = (GraphQLTextWithEntities) super.m9947a(this.f18626q, 12, GraphQLTextWithEntities.class);
        return this.f18626q;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachment> m26094B() {
        this.f18627r = super.m9944a(this.f18627r, 13, GraphQLStoryAttachment.class);
        return (ImmutableList) this.f18627r;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNegativeFeedbackActionsConnection m26095C() {
        this.f18628s = (GraphQLNegativeFeedbackActionsConnection) super.m9947a(this.f18628s, 14, GraphQLNegativeFeedbackActionsConnection.class);
        return this.f18628s;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyScope m26096D() {
        this.f18629t = (GraphQLPrivacyScope) super.m9947a(this.f18629t, 15, GraphQLPrivacyScope.class);
        return this.f18629t;
    }

    @FieldOffset
    public final GraphQLStorySeenState m26097E() {
        this.f18630u = (GraphQLStorySeenState) super.m9945a(this.f18630u, 16, GraphQLStorySeenState.class, GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f18630u;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEntity m26098F() {
        this.f18631v = (GraphQLEntity) super.m9947a(this.f18631v, 17, GraphQLEntity.class);
        return this.f18631v;
    }

    @FieldOffset
    @Nullable
    public final String m26099G() {
        this.f18632w = super.m9948a(this.f18632w, 19);
        return this.f18632w;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStoryHeader m26100H() {
        this.f18633x = (GraphQLStoryHeader) super.m9947a(this.f18633x, 21, GraphQLStoryHeader.class);
        return this.f18633x;
    }

    @FieldOffset
    public final ImmutableList<GraphQLSubstoriesGroupingReason> m26101I() {
        this.f18634y = super.m9953b(this.f18634y, 22, GraphQLSubstoriesGroupingReason.class);
        return (ImmutableList) this.f18634y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTrueTopicFeedOptionsConnection m26102J() {
        this.f18635z = (GraphQLTrueTopicFeedOptionsConnection) super.m9947a(this.f18635z, 24, GraphQLTrueTopicFeedOptionsConnection.class);
        return this.f18635z;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m26103K() {
        this.f18606A = (GraphQLTextWithEntities) super.m9947a(this.f18606A, 25, GraphQLTextWithEntities.class);
        return this.f18606A;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m26104L() {
        this.f18607B = (GraphQLTextWithEntities) super.m9947a(this.f18607B, 26, GraphQLTextWithEntities.class);
        return this.f18607B;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f18608C = super.m9948a(this.f18608C, 27);
        return this.f18608C;
    }

    @FieldOffset
    @Nullable
    public final String m26105M() {
        this.f18609D = super.m9948a(this.f18609D, 28);
        return this.f18609D;
    }

    @FieldOffset
    @Nullable
    public final GraphQLExploreFeed m26106N() {
        this.f18610E = (GraphQLExploreFeed) super.m9947a(this.f18610E, 29, GraphQLExploreFeed.class);
        return this.f18610E;
    }

    @Nullable
    public final String mo2834a() {
        return m26129z();
    }

    public final GraphQLTextWithEntities mo2878m() {
        return m26103K();
    }

    public final int jK_() {
        return -1182375855;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        Builder a2;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m26119p() != null) {
            a = ModelHelper.m23097a(m26119p(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLTopicCustomizationStory) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18614e = a.m1068b();
            }
        }
        if (m26120q() != null) {
            a = ModelHelper.m23097a(m26120q(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLTopicCustomizationStory) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18615f = a.m1068b();
            }
        }
        GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
        if (m26121r() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m26121r());
            if (m26121r() != graphQLImage) {
                graphQLVisitableModel2 = (GraphQLTopicCustomizationStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18616g = graphQLImage;
            }
        }
        if (m26122s() != null) {
            a2 = ModelHelper.m23097a(m26122s(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                GraphQLTopicCustomizationStory graphQLTopicCustomizationStory = (GraphQLTopicCustomizationStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLTopicCustomizationStory.f18617h = a2.m1068b();
                graphQLVisitableModel2 = graphQLTopicCustomizationStory;
            }
        }
        if (m26124u() != null) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.mo2928b(m26124u());
            if (m26124u() != graphQLFeedback) {
                graphQLVisitableModel2 = (GraphQLTopicCustomizationStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18621l = graphQLFeedback;
            }
        }
        if (m26127x() != null) {
            GraphQLFeedbackContext graphQLFeedbackContext = (GraphQLFeedbackContext) graphQLModelMutatingVisitor.mo2928b(m26127x());
            if (m26127x() != graphQLFeedbackContext) {
                graphQLVisitableModel2 = (GraphQLTopicCustomizationStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18622m = graphQLFeedbackContext;
            }
        }
        if (m26093A() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m26093A());
            if (m26093A() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLTopicCustomizationStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18626q = graphQLTextWithEntities;
            }
        }
        if (m26094B() != null) {
            a2 = ModelHelper.m23097a(m26094B(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                graphQLTopicCustomizationStory = (GraphQLTopicCustomizationStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLTopicCustomizationStory.f18627r = a2.m1068b();
                graphQLVisitableModel2 = graphQLTopicCustomizationStory;
            }
        }
        if (m26095C() != null) {
            GraphQLNegativeFeedbackActionsConnection graphQLNegativeFeedbackActionsConnection = (GraphQLNegativeFeedbackActionsConnection) graphQLModelMutatingVisitor.mo2928b(m26095C());
            if (m26095C() != graphQLNegativeFeedbackActionsConnection) {
                graphQLVisitableModel2 = (GraphQLTopicCustomizationStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18628s = graphQLNegativeFeedbackActionsConnection;
            }
        }
        if (m26096D() != null) {
            GraphQLPrivacyScope graphQLPrivacyScope = (GraphQLPrivacyScope) graphQLModelMutatingVisitor.mo2928b(m26096D());
            if (m26096D() != graphQLPrivacyScope) {
                graphQLVisitableModel2 = (GraphQLTopicCustomizationStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18629t = graphQLPrivacyScope;
            }
        }
        if (m26098F() != null) {
            GraphQLEntity graphQLEntity = (GraphQLEntity) graphQLModelMutatingVisitor.mo2928b(m26098F());
            if (m26098F() != graphQLEntity) {
                graphQLVisitableModel2 = (GraphQLTopicCustomizationStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18631v = graphQLEntity;
            }
        }
        if (m26100H() != null) {
            GraphQLStoryHeader graphQLStoryHeader = (GraphQLStoryHeader) graphQLModelMutatingVisitor.mo2928b(m26100H());
            if (m26100H() != graphQLStoryHeader) {
                graphQLVisitableModel2 = (GraphQLTopicCustomizationStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18633x = graphQLStoryHeader;
            }
        }
        if (m26102J() != null) {
            GraphQLTrueTopicFeedOptionsConnection graphQLTrueTopicFeedOptionsConnection = (GraphQLTrueTopicFeedOptionsConnection) graphQLModelMutatingVisitor.mo2928b(m26102J());
            if (m26102J() != graphQLTrueTopicFeedOptionsConnection) {
                graphQLVisitableModel2 = (GraphQLTopicCustomizationStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18635z = graphQLTrueTopicFeedOptionsConnection;
            }
        }
        if (m26103K() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m26103K());
            if (m26103K() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLTopicCustomizationStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18606A = graphQLTextWithEntities;
            }
        }
        if (m26104L() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m26104L());
            if (m26104L() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLTopicCustomizationStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18607B = graphQLTextWithEntities;
            }
        }
        if (m26106N() != null) {
            GraphQLExploreFeed graphQLExploreFeed = (GraphQLExploreFeed) graphQLModelMutatingVisitor.mo2928b(m26106N());
            if (m26106N() != graphQLExploreFeed) {
                graphQLVisitableModel2 = (GraphQLTopicCustomizationStory) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f18610E = graphQLExploreFeed;
            }
        }
        m9959i();
        return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
    }

    public GraphQLTopicCustomizationStory() {
        super(31);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18619j = mutableFlatBuffer.m21525a(i, 5, 0);
        this.f18623n = mutableFlatBuffer.m21525a(i, 9, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m26119p());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m26120q());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m26121r());
        int a4 = ModelHelper.m23094a(flatBufferBuilder, m26122s());
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m26124u());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m26127x());
        int b3 = flatBufferBuilder.m21502b(m26128y());
        int b4 = flatBufferBuilder.m21502b(m26129z());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m26093A());
        int a8 = ModelHelper.m23094a(flatBufferBuilder, m26094B());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, m26095C());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, m26096D());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, m26098F());
        int b5 = flatBufferBuilder.m21502b(m26099G());
        int a12 = ModelHelper.m23093a(flatBufferBuilder, m26100H());
        int e = flatBufferBuilder.m21514e(m26101I());
        int a13 = ModelHelper.m23093a(flatBufferBuilder, m26102J());
        int a14 = ModelHelper.m23093a(flatBufferBuilder, m26103K());
        int a15 = ModelHelper.m23093a(flatBufferBuilder, m26104L());
        int b6 = flatBufferBuilder.m21502b(mo2877k());
        int b7 = flatBufferBuilder.m21502b(m26105M());
        int a16 = ModelHelper.m23093a(flatBufferBuilder, m26106N());
        flatBufferBuilder.m21510c(30);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(2, a3);
        flatBufferBuilder.m21507b(3, a4);
        flatBufferBuilder.m21507b(4, b);
        flatBufferBuilder.m21495a(5, m26123t(), 0);
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
        flatBufferBuilder.m21496a(16, m26097E() == GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m26097E());
        flatBufferBuilder.m21507b(17, a11);
        flatBufferBuilder.m21507b(19, b5);
        flatBufferBuilder.m21507b(21, a12);
        flatBufferBuilder.m21507b(22, e);
        flatBufferBuilder.m21507b(24, a13);
        flatBufferBuilder.m21507b(25, a14);
        flatBufferBuilder.m21507b(26, a15);
        flatBufferBuilder.m21507b(27, b6);
        flatBufferBuilder.m21507b(28, b7);
        flatBufferBuilder.m21507b(29, a16);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLTopicCustomizationStory(Parcel parcel) {
        super(31);
        this.f18614e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryActionLink.class.getClassLoader()));
        this.f18615f = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLActor.class.getClassLoader()));
        this.f18616g = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f18617h = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryAttachment.class.getClassLoader()));
        this.f18618i = parcel.readString();
        this.f18619j = parcel.readLong();
        this.f18620k = parcel.readString();
        this.f18621l = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f18622m = (GraphQLFeedbackContext) parcel.readValue(GraphQLFeedbackContext.class.getClassLoader());
        this.f18623n = parcel.readLong();
        this.f18624o = parcel.readString();
        this.f18625p = parcel.readString();
        this.f18626q = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18627r = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryAttachment.class.getClassLoader()));
        this.f18628s = (GraphQLNegativeFeedbackActionsConnection) parcel.readValue(GraphQLNegativeFeedbackActionsConnection.class.getClassLoader());
        this.f18629t = (GraphQLPrivacyScope) parcel.readValue(GraphQLPrivacyScope.class.getClassLoader());
        this.f18630u = GraphQLStorySeenState.fromString(parcel.readString());
        this.f18631v = (GraphQLEntity) parcel.readValue(GraphQLEntity.class.getClassLoader());
        this.f18632w = parcel.readString();
        this.f18633x = (GraphQLStoryHeader) parcel.readValue(GraphQLStoryHeader.class.getClassLoader());
        this.f18634y = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLSubstoriesGroupingReason.class.getClassLoader()));
        this.f18635z = (GraphQLTrueTopicFeedOptionsConnection) parcel.readValue(GraphQLTrueTopicFeedOptionsConnection.class.getClassLoader());
        this.f18606A = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18607B = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18610E = (GraphQLExploreFeed) parcel.readValue(GraphQLExploreFeed.class.getClassLoader());
        this.f18608C = parcel.readString();
        this.f18609D = parcel.readString();
        this.f18611F = (TopicCustomizationStoryExtra) ParcelUtil.b(parcel, TopicCustomizationStoryExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m26119p());
        parcel.writeList(m26120q());
        parcel.writeValue(m26121r());
        parcel.writeList(m26122s());
        parcel.writeString(mo2507g());
        parcel.writeLong(m26123t());
        parcel.writeString(S_());
        parcel.writeValue(m26124u());
        parcel.writeValue(m26127x());
        parcel.writeLong(T_());
        parcel.writeString(m26128y());
        parcel.writeString(m26129z());
        parcel.writeValue(m26093A());
        parcel.writeList(m26094B());
        parcel.writeValue(m26095C());
        parcel.writeValue(m26096D());
        parcel.writeString(m26097E().name());
        parcel.writeValue(m26098F());
        parcel.writeString(m26099G());
        parcel.writeValue(m26100H());
        parcel.writeList(m26101I());
        parcel.writeValue(m26102J());
        parcel.writeValue(m26103K());
        parcel.writeValue(m26104L());
        parcel.writeValue(m26106N());
        parcel.writeString(mo2877k());
        parcel.writeString(m26105M());
        parcel.writeParcelable(m26092O(), i);
    }

    private TopicCustomizationStoryExtra m26092O() {
        if (this.f18611F == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18611F = new TopicCustomizationStoryExtra();
            } else {
                this.f18611F = (TopicCustomizationStoryExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, TopicCustomizationStoryExtra.class);
            }
        }
        return this.f18611F;
    }

    public final PropertyBag U_() {
        if (this.f18612G == null) {
            this.f18612G = new PropertyBag();
        }
        return this.f18612G;
    }
}
