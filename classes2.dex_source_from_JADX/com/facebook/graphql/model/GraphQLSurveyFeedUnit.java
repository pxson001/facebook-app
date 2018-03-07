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
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: journal_size_limit */
public final class GraphQLSurveyFeedUnit extends BaseModel implements FeedUnit, HasHideableToken, HideableUnit, HasProperty, Sponsorable, CachedFeedTrackable, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLSurveyFeedUnit> CREATOR = new 1();
    public GraphQLObjectType f18582d = new GraphQLObjectType(-1190325796);
    @Nullable
    public String f18583e;
    @Nullable
    public String f18584f;
    public long f18585g;
    @Nullable
    public String f18586h;
    @Nullable
    public String f18587i;
    @Nullable
    public GraphQLSponsoredData f18588j;
    @Nullable
    public GraphQLActor f18589k;
    @Nullable
    public GraphQLStructuredSurvey f18590l;
    @Nullable
    public String f18591m;
    @Nullable
    public String f18592n;
    @Nullable
    public GraphQLSponsoredData f18593o;
    @Nullable
    public GraphQLTextWithEntities f18594p;
    @Nullable
    public String f18595q;
    @Nullable
    public GraphQLTextWithEntities f18596r;
    @Nullable
    public String f18597s;
    @Nullable
    public String f18598t;
    @Nullable
    public String f18599u;
    public int f18600v;
    private SurveyFeedUnitExtra f18601w;
    @Nullable
    private PropertyBag f18602x = null;

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m26062E();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27152a((HasTracking) this);
    }

    public final GraphQLObjectType getType() {
        return this.f18582d;
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

    public final boolean mo2895u() {
        return ImpressionUtil.m29324a((Sponsorable) this);
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f18583e = super.m9948a(this.f18583e, 0);
        return this.f18583e;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f18584f = super.m9948a(this.f18584f, 1);
        return this.f18584f;
    }

    @Nullable
    public final SponsoredImpression ab_() {
        return SponsoredImpression.m29328a(m26075n());
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 2);
        return this.f18585g;
    }

    public final void mo2872a(long j) {
        this.f18585g = j;
    }

    @FieldOffset
    @Nullable
    public final String mo2896y() {
        this.f18586h = super.m9948a(this.f18586h, 3);
        return this.f18586h;
    }

    @FieldOffset
    @Nullable
    public final String m26074m() {
        this.f18587i = super.m9948a(this.f18587i, 4);
        return this.f18587i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLSponsoredData m26075n() {
        this.f18588j = (GraphQLSponsoredData) super.m9947a(this.f18588j, 5, GraphQLSponsoredData.class);
        return this.f18588j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor m26079r() {
        this.f18589k = (GraphQLActor) super.m9947a(this.f18589k, 6, GraphQLActor.class);
        return this.f18589k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStructuredSurvey m26080s() {
        this.f18590l = (GraphQLStructuredSurvey) super.m9947a(this.f18590l, 7, GraphQLStructuredSurvey.class);
        return this.f18590l;
    }

    @FieldOffset
    @Nullable
    public final String m26081t() {
        this.f18591m = super.m9948a(this.f18591m, 8);
        return this.f18591m;
    }

    @FieldOffset
    @Nullable
    public final String m26083v() {
        this.f18592n = super.m9948a(this.f18592n, 9);
        return this.f18592n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLSponsoredData m26084w() {
        this.f18593o = (GraphQLSponsoredData) super.m9947a(this.f18593o, 10, GraphQLSponsoredData.class);
        return this.f18593o;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m26085x() {
        this.f18594p = (GraphQLTextWithEntities) super.m9947a(this.f18594p, 11, GraphQLTextWithEntities.class);
        return this.f18594p;
    }

    @FieldOffset
    @Nullable
    public final String m26087z() {
        this.f18595q = super.m9948a(this.f18595q, 12);
        return this.f18595q;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m26058A() {
        this.f18596r = (GraphQLTextWithEntities) super.m9947a(this.f18596r, 13, GraphQLTextWithEntities.class);
        return this.f18596r;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f18597s = super.m9948a(this.f18597s, 14);
        return this.f18597s;
    }

    @FieldOffset
    @Nullable
    public final String m26059B() {
        this.f18598t = super.m9948a(this.f18598t, 15);
        return this.f18598t;
    }

    @FieldOffset
    @Nullable
    public final String m26060C() {
        this.f18599u = super.m9948a(this.f18599u, 16);
        return this.f18599u;
    }

    @FieldOffset
    public final int m26061D() {
        m9949a(2, 1);
        return this.f18600v;
    }

    @Nullable
    public final String mo2834a() {
        return mo2507g();
    }

    public final int jK_() {
        return -1190325796;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLSponsoredData graphQLSponsoredData;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m26075n() != null) {
            graphQLSponsoredData = (GraphQLSponsoredData) graphQLModelMutatingVisitor.mo2928b(m26075n());
            if (m26075n() != graphQLSponsoredData) {
                graphQLVisitableModel = (GraphQLSurveyFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18588j = graphQLSponsoredData;
            }
        }
        if (m26079r() != null) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.mo2928b(m26079r());
            if (m26079r() != graphQLActor) {
                graphQLVisitableModel = (GraphQLSurveyFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18589k = graphQLActor;
            }
        }
        if (m26080s() != null) {
            GraphQLStructuredSurvey graphQLStructuredSurvey = (GraphQLStructuredSurvey) graphQLModelMutatingVisitor.mo2928b(m26080s());
            if (m26080s() != graphQLStructuredSurvey) {
                graphQLVisitableModel = (GraphQLSurveyFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18590l = graphQLStructuredSurvey;
            }
        }
        if (m26084w() != null) {
            graphQLSponsoredData = (GraphQLSponsoredData) graphQLModelMutatingVisitor.mo2928b(m26084w());
            if (m26084w() != graphQLSponsoredData) {
                graphQLVisitableModel = (GraphQLSurveyFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18593o = graphQLSponsoredData;
            }
        }
        if (m26085x() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m26085x());
            if (m26085x() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLSurveyFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18594p = graphQLTextWithEntities;
            }
        }
        if (m26058A() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m26058A());
            if (m26058A() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLSurveyFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18596r = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("local_last_negative_feedback_action_type".equals(str)) {
            consistencyTuple.f18727a = m26059B();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 15;
        } else if ("local_story_visibility".equals(str)) {
            consistencyTuple.f18727a = m26060C();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 16;
        } else if ("local_story_visible_height".equals(str)) {
            consistencyTuple.f18727a = Integer.valueOf(m26061D());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 17;
        } else {
            consistencyTuple.m26322a();
        }
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        String str2;
        if ("local_last_negative_feedback_action_type".equals(str)) {
            str2 = (String) obj;
            this.f18598t = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 15, str2);
            }
        } else if ("local_story_visibility".equals(str)) {
            str2 = (String) obj;
            this.f18599u = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 16, str2);
            }
        } else if ("local_story_visible_height".equals(str)) {
            int intValue = ((Integer) obj).intValue();
            this.f18600v = intValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21544b(this.f5824c, 17, intValue);
            }
        }
    }

    public GraphQLSurveyFeedUnit() {
        super(19);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18585g = mutableFlatBuffer.m21525a(i, 2, 0);
        this.f18600v = mutableFlatBuffer.m21524a(i, 17, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int b3 = flatBufferBuilder.m21502b(mo2896y());
        int b4 = flatBufferBuilder.m21502b(m26074m());
        int a = ModelHelper.m23093a(flatBufferBuilder, m26075n());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m26079r());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m26080s());
        int b5 = flatBufferBuilder.m21502b(m26081t());
        int b6 = flatBufferBuilder.m21502b(m26083v());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m26084w());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m26085x());
        int b7 = flatBufferBuilder.m21502b(m26087z());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m26058A());
        int b8 = flatBufferBuilder.m21502b(mo2877k());
        int b9 = flatBufferBuilder.m21502b(m26059B());
        int b10 = flatBufferBuilder.m21502b(m26060C());
        flatBufferBuilder.m21510c(18);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21495a(2, T_(), 0);
        flatBufferBuilder.m21507b(3, b3);
        flatBufferBuilder.m21507b(4, b4);
        flatBufferBuilder.m21507b(5, a);
        flatBufferBuilder.m21507b(6, a2);
        flatBufferBuilder.m21507b(7, a3);
        flatBufferBuilder.m21507b(8, b5);
        flatBufferBuilder.m21507b(9, b6);
        flatBufferBuilder.m21507b(10, a4);
        flatBufferBuilder.m21507b(11, a5);
        flatBufferBuilder.m21507b(12, b7);
        flatBufferBuilder.m21507b(13, a6);
        flatBufferBuilder.m21507b(14, b8);
        flatBufferBuilder.m21507b(15, b9);
        flatBufferBuilder.m21507b(16, b10);
        flatBufferBuilder.m21494a(17, m26061D(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLSurveyFeedUnit(Parcel parcel) {
        super(19);
        this.f18583e = parcel.readString();
        this.f18584f = parcel.readString();
        this.f18585g = parcel.readLong();
        this.f18586h = parcel.readString();
        this.f18598t = parcel.readString();
        this.f18599u = parcel.readString();
        this.f18600v = parcel.readInt();
        this.f18587i = parcel.readString();
        this.f18588j = (GraphQLSponsoredData) parcel.readValue(GraphQLSponsoredData.class.getClassLoader());
        this.f18589k = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
        this.f18590l = (GraphQLStructuredSurvey) parcel.readValue(GraphQLStructuredSurvey.class.getClassLoader());
        this.f18591m = parcel.readString();
        this.f18592n = parcel.readString();
        this.f18593o = (GraphQLSponsoredData) parcel.readValue(GraphQLSponsoredData.class.getClassLoader());
        this.f18594p = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18595q = parcel.readString();
        this.f18596r = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18597s = parcel.readString();
        this.f18601w = (SurveyFeedUnitExtra) ParcelUtil.b(parcel, SurveyFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo2507g());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeString(mo2896y());
        parcel.writeString(m26059B());
        parcel.writeString(m26060C());
        parcel.writeInt(m26061D());
        parcel.writeString(m26074m());
        parcel.writeValue(m26075n());
        parcel.writeValue(m26079r());
        parcel.writeValue(m26080s());
        parcel.writeString(m26081t());
        parcel.writeString(m26083v());
        parcel.writeValue(m26084w());
        parcel.writeValue(m26085x());
        parcel.writeString(m26087z());
        parcel.writeValue(m26058A());
        parcel.writeString(mo2877k());
        parcel.writeParcelable(m26062E(), i);
    }

    public final SurveyFeedUnitExtra m26062E() {
        if (this.f18601w == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18601w = new SurveyFeedUnitExtra();
            } else {
                this.f18601w = (SurveyFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, SurveyFeedUnitExtra.class);
            }
        }
        return this.f18601w;
    }

    public final PropertyBag U_() {
        if (this.f18602x == null) {
            this.f18602x = new PropertyBag();
        }
        return this.f18602x;
    }
}
