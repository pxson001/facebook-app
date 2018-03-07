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
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: key=' */
public final class GraphQLStoryGallerySurveyFeedUnit extends BaseModel implements FeedUnit, HideableUnit, HasProperty, TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLStoryGallerySurveyFeedUnit> CREATOR = new 1();
    GraphQLObjectType f18491d = new GraphQLObjectType(-818421799);
    @Nullable
    String f18492e;
    @Nullable
    GraphQLTextWithEntities f18493f;
    @Nullable
    GraphQLTextWithEntities f18494g;
    @Nullable
    String f18495h;
    long f18496i;
    @Nullable
    GraphQLTextWithEntities f18497j;
    @Nullable
    String f18498k;
    @Nullable
    GraphQLTextWithEntities f18499l;
    @Nullable
    String f18500m;
    @Nullable
    GraphQLTextWithEntities f18501n;
    @Nullable
    GraphQLTextWithEntities f18502o;
    @Nullable
    String f18503p;
    @Nullable
    String f18504q;
    @Nullable
    public String f18505r;
    @Nullable
    public String f18506s;
    public int f18507t;
    private StoryGallerySurveyFeedUnitExtra f18508u;
    @Nullable
    private PropertyBag f18509v = null;

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m25959A();
    }

    public final String mo2881q() {
        return null;
    }

    public final GraphQLObjectType getType() {
        return this.f18491d;
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

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f18492e = super.m9948a(this.f18492e, 0);
        return this.f18492e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25970k() {
        this.f18493f = (GraphQLTextWithEntities) super.m9947a(this.f18493f, 1, GraphQLTextWithEntities.class);
        return this.f18493f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25971l() {
        this.f18494g = (GraphQLTextWithEntities) super.m9947a(this.f18494g, 2, GraphQLTextWithEntities.class);
        return this.f18494g;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f18495h = super.m9948a(this.f18495h, 3);
        return this.f18495h;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 4);
        return this.f18496i;
    }

    public final void mo2872a(long j) {
        this.f18496i = j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25972m() {
        this.f18497j = (GraphQLTextWithEntities) super.m9947a(this.f18497j, 5, GraphQLTextWithEntities.class);
        return this.f18497j;
    }

    @FieldOffset
    @Nullable
    public final String m25973n() {
        this.f18498k = super.m9948a(this.f18498k, 6);
        return this.f18498k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25977r() {
        this.f18499l = (GraphQLTextWithEntities) super.m9947a(this.f18499l, 7, GraphQLTextWithEntities.class);
        return this.f18499l;
    }

    @FieldOffset
    @Nullable
    public final String m25978s() {
        this.f18500m = super.m9948a(this.f18500m, 9);
        return this.f18500m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25979t() {
        this.f18501n = (GraphQLTextWithEntities) super.m9947a(this.f18501n, 10, GraphQLTextWithEntities.class);
        return this.f18501n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m25980u() {
        this.f18502o = (GraphQLTextWithEntities) super.m9947a(this.f18502o, 11, GraphQLTextWithEntities.class);
        return this.f18502o;
    }

    @FieldOffset
    @Nullable
    public final String m25981v() {
        this.f18503p = super.m9948a(this.f18503p, 12);
        return this.f18503p;
    }

    @FieldOffset
    @Nullable
    public final String m25982w() {
        this.f18504q = super.m9948a(this.f18504q, 13);
        return this.f18504q;
    }

    @FieldOffset
    @Nullable
    public final String m25983x() {
        this.f18505r = super.m9948a(this.f18505r, 14);
        return this.f18505r;
    }

    @FieldOffset
    @Nullable
    public final String m25984y() {
        this.f18506s = super.m9948a(this.f18506s, 15);
        return this.f18506s;
    }

    @FieldOffset
    public final int m25985z() {
        m9949a(2, 0);
        return this.f18507t;
    }

    @Nullable
    public final String mo2834a() {
        return m25973n();
    }

    public final int jK_() {
        return -818421799;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m25970k() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25970k());
            if (m25970k() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLStoryGallerySurveyFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18493f = graphQLTextWithEntities;
            }
        }
        if (m25971l() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25971l());
            if (m25971l() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLStoryGallerySurveyFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18494g = graphQLTextWithEntities;
            }
        }
        if (m25972m() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25972m());
            if (m25972m() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLStoryGallerySurveyFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18497j = graphQLTextWithEntities;
            }
        }
        if (m25977r() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25977r());
            if (m25977r() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLStoryGallerySurveyFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18499l = graphQLTextWithEntities;
            }
        }
        if (m25979t() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25979t());
            if (m25979t() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLStoryGallerySurveyFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18501n = graphQLTextWithEntities;
            }
        }
        if (m25980u() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m25980u());
            if (m25980u() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLStoryGallerySurveyFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18502o = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("local_last_negative_feedback_action_type".equals(str)) {
            consistencyTuple.f18727a = m25983x();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 14;
        } else if ("local_story_visibility".equals(str)) {
            consistencyTuple.f18727a = m25984y();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 15;
        } else if ("local_story_visible_height".equals(str)) {
            consistencyTuple.f18727a = Integer.valueOf(m25985z());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 16;
        } else {
            consistencyTuple.m26322a();
        }
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        String str2;
        if ("local_last_negative_feedback_action_type".equals(str)) {
            str2 = (String) obj;
            this.f18505r = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 14, str2);
            }
        } else if ("local_story_visibility".equals(str)) {
            str2 = (String) obj;
            this.f18506s = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 15, str2);
            }
        } else if ("local_story_visible_height".equals(str)) {
            int intValue = ((Integer) obj).intValue();
            this.f18507t = intValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21544b(this.f5824c, 16, intValue);
            }
        }
    }

    public GraphQLStoryGallerySurveyFeedUnit() {
        super(18);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18496i = mutableFlatBuffer.m21525a(i, 4, 0);
        this.f18507t = mutableFlatBuffer.m21524a(i, 16, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(mo2507g());
        int a = ModelHelper.m23093a(flatBufferBuilder, m25970k());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m25971l());
        int b2 = flatBufferBuilder.m21502b(S_());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m25972m());
        int b3 = flatBufferBuilder.m21502b(m25973n());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m25977r());
        int b4 = flatBufferBuilder.m21502b(m25978s());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m25979t());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m25980u());
        int b5 = flatBufferBuilder.m21502b(m25981v());
        int b6 = flatBufferBuilder.m21502b(m25982w());
        int b7 = flatBufferBuilder.m21502b(m25983x());
        int b8 = flatBufferBuilder.m21502b(m25984y());
        flatBufferBuilder.m21510c(17);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21507b(3, b2);
        flatBufferBuilder.m21495a(4, T_(), 0);
        flatBufferBuilder.m21507b(5, a3);
        flatBufferBuilder.m21507b(6, b3);
        flatBufferBuilder.m21507b(7, a4);
        flatBufferBuilder.m21507b(9, b4);
        flatBufferBuilder.m21507b(10, a5);
        flatBufferBuilder.m21507b(11, a6);
        flatBufferBuilder.m21507b(12, b5);
        flatBufferBuilder.m21507b(13, b6);
        flatBufferBuilder.m21507b(14, b7);
        flatBufferBuilder.m21507b(15, b8);
        flatBufferBuilder.m21494a(16, m25985z(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLStoryGallerySurveyFeedUnit(Parcel parcel) {
        super(18);
        this.f18492e = parcel.readString();
        this.f18493f = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18494g = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18495h = parcel.readString();
        this.f18496i = parcel.readLong();
        this.f18497j = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18498k = parcel.readString();
        this.f18505r = parcel.readString();
        this.f18506s = parcel.readString();
        this.f18507t = parcel.readInt();
        this.f18499l = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18500m = parcel.readString();
        this.f18501n = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18502o = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18503p = parcel.readString();
        this.f18504q = parcel.readString();
        this.f18508u = (StoryGallerySurveyFeedUnitExtra) ParcelUtil.b(parcel, StoryGallerySurveyFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo2507g());
        parcel.writeValue(m25970k());
        parcel.writeValue(m25971l());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeValue(m25972m());
        parcel.writeString(m25973n());
        parcel.writeString(m25983x());
        parcel.writeString(m25984y());
        parcel.writeInt(m25985z());
        parcel.writeValue(m25977r());
        parcel.writeString(m25978s());
        parcel.writeValue(m25979t());
        parcel.writeValue(m25980u());
        parcel.writeString(m25981v());
        parcel.writeString(m25982w());
        parcel.writeParcelable(m25959A(), i);
    }

    private StoryGallerySurveyFeedUnitExtra m25959A() {
        if (this.f18508u == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18508u = new StoryGallerySurveyFeedUnitExtra();
            } else {
                this.f18508u = (StoryGallerySurveyFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, StoryGallerySurveyFeedUnitExtra.class);
            }
        }
        return this.f18508u;
    }

    public final PropertyBag U_() {
        if (this.f18509v == null) {
            this.f18509v = new PropertyBag();
        }
        return this.f18509v;
    }
}
