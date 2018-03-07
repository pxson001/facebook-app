package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLContactFieldLabelType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: location_longitude */
public final class GraphQLContactRecommendationField extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLContactRecommendationField> CREATOR = new 1();
    long f16656d;
    @Nullable
    GraphQLActor f16657e;
    @Nullable
    GraphQLFeedback f16658f;
    @Nullable
    String f16659g;
    @Nullable
    GraphQLImage f16660h;
    @Nullable
    String f16661i;
    GraphQLContactFieldLabelType f16662j;
    int f16663k;
    List<GraphQLPhoto> f16664l;
    @Nullable
    GraphQLPrivacyScope f16665m;
    @Nullable
    GraphQLImage f16666n;
    @Nullable
    GraphQLImage f16667o;
    @Nullable
    GraphQLActor f16668p;
    @Nullable
    GraphQLStory f16669q;
    @Nullable
    String f16670r;
    @Nullable
    GraphQLTextWithEntities f16671s;

    @FieldOffset
    public final long m23527j() {
        m9949a(0, 0);
        return this.f16656d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor m23528k() {
        this.f16657e = (GraphQLActor) super.m9947a(this.f16657e, 1, GraphQLActor.class);
        return this.f16657e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback m23529l() {
        this.f16658f = (GraphQLFeedback) super.m9947a(this.f16658f, 2, GraphQLFeedback.class);
        return this.f16658f;
    }

    @FieldOffset
    @Nullable
    public final String m23530m() {
        this.f16659g = super.m9948a(this.f16659g, 3);
        return this.f16659g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23531n() {
        this.f16660h = (GraphQLImage) super.m9947a(this.f16660h, 4, GraphQLImage.class);
        return this.f16660h;
    }

    @FieldOffset
    @Nullable
    public final String m23532o() {
        this.f16661i = super.m9948a(this.f16661i, 5);
        return this.f16661i;
    }

    @FieldOffset
    public final GraphQLContactFieldLabelType m23533p() {
        this.f16662j = (GraphQLContactFieldLabelType) super.m9945a(this.f16662j, 6, GraphQLContactFieldLabelType.class, GraphQLContactFieldLabelType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16662j;
    }

    @FieldOffset
    public final int m23534q() {
        m9949a(0, 7);
        return this.f16663k;
    }

    @FieldOffset
    public final ImmutableList<GraphQLPhoto> m23535r() {
        this.f16664l = super.m9944a(this.f16664l, 8, GraphQLPhoto.class);
        return (ImmutableList) this.f16664l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyScope m23536s() {
        this.f16665m = (GraphQLPrivacyScope) super.m9947a(this.f16665m, 9, GraphQLPrivacyScope.class);
        return this.f16665m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23537t() {
        this.f16666n = (GraphQLImage) super.m9947a(this.f16666n, 10, GraphQLImage.class);
        return this.f16666n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23538u() {
        this.f16667o = (GraphQLImage) super.m9947a(this.f16667o, 11, GraphQLImage.class);
        return this.f16667o;
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor m23539v() {
        this.f16668p = (GraphQLActor) super.m9947a(this.f16668p, 12, GraphQLActor.class);
        return this.f16668p;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory m23540w() {
        this.f16669q = (GraphQLStory) super.m9947a(this.f16669q, 13, GraphQLStory.class);
        return this.f16669q;
    }

    @FieldOffset
    @Nullable
    public final String m23541x() {
        this.f16670r = super.m9948a(this.f16670r, 14);
        return this.f16670r;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23542y() {
        this.f16671s = (GraphQLTextWithEntities) super.m9947a(this.f16671s, 15, GraphQLTextWithEntities.class);
        return this.f16671s;
    }

    @Nullable
    public final String mo2834a() {
        return m23530m();
    }

    public final int jK_() {
        return -131209055;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLActor graphQLActor;
        GraphQLImage graphQLImage;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23528k() != null) {
            graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.mo2928b(m23528k());
            if (m23528k() != graphQLActor) {
                graphQLVisitableModel = (GraphQLContactRecommendationField) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16657e = graphQLActor;
            }
        }
        if (m23529l() != null) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.mo2928b(m23529l());
            if (m23529l() != graphQLFeedback) {
                graphQLVisitableModel = (GraphQLContactRecommendationField) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16658f = graphQLFeedback;
            }
        }
        if (m23531n() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23531n());
            if (m23531n() != graphQLImage) {
                graphQLVisitableModel = (GraphQLContactRecommendationField) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16660h = graphQLImage;
            }
        }
        if (m23535r() != null) {
            Builder a = ModelHelper.m23097a(m23535r(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLContactRecommendationField graphQLContactRecommendationField = (GraphQLContactRecommendationField) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLContactRecommendationField.f16664l = a.m1068b();
                graphQLVisitableModel = graphQLContactRecommendationField;
            }
        }
        if (m23536s() != null) {
            GraphQLPrivacyScope graphQLPrivacyScope = (GraphQLPrivacyScope) graphQLModelMutatingVisitor.mo2928b(m23536s());
            if (m23536s() != graphQLPrivacyScope) {
                graphQLVisitableModel = (GraphQLContactRecommendationField) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16665m = graphQLPrivacyScope;
            }
        }
        if (m23537t() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23537t());
            if (m23537t() != graphQLImage) {
                graphQLVisitableModel = (GraphQLContactRecommendationField) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16666n = graphQLImage;
            }
        }
        if (m23538u() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23538u());
            if (m23538u() != graphQLImage) {
                graphQLVisitableModel = (GraphQLContactRecommendationField) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16667o = graphQLImage;
            }
        }
        if (m23539v() != null) {
            graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.mo2928b(m23539v());
            if (m23539v() != graphQLActor) {
                graphQLVisitableModel = (GraphQLContactRecommendationField) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16668p = graphQLActor;
            }
        }
        if (m23540w() != null) {
            GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.mo2928b(m23540w());
            if (m23540w() != graphQLStory) {
                graphQLVisitableModel = (GraphQLContactRecommendationField) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16669q = graphQLStory;
            }
        }
        if (m23542y() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23542y());
            if (m23542y() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLContactRecommendationField) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16671s = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLContactRecommendationField() {
        super(17);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16656d = mutableFlatBuffer.m21525a(i, 0, 0);
        this.f16663k = mutableFlatBuffer.m21524a(i, 7, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m23528k());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23529l());
        int b = flatBufferBuilder.m21502b(m23530m());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m23531n());
        int b2 = flatBufferBuilder.m21502b(m23532o());
        int a4 = ModelHelper.m23094a(flatBufferBuilder, m23535r());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m23536s());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m23537t());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m23538u());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m23539v());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, m23540w());
        int b3 = flatBufferBuilder.m21502b(m23541x());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, m23542y());
        flatBufferBuilder.m21510c(16);
        flatBufferBuilder.m21495a(0, m23527j(), 0);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21507b(3, b);
        flatBufferBuilder.m21507b(4, a3);
        flatBufferBuilder.m21507b(5, b2);
        flatBufferBuilder.m21496a(6, m23533p() == GraphQLContactFieldLabelType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23533p());
        flatBufferBuilder.m21494a(7, m23534q(), 0);
        flatBufferBuilder.m21507b(8, a4);
        flatBufferBuilder.m21507b(9, a5);
        flatBufferBuilder.m21507b(10, a6);
        flatBufferBuilder.m21507b(11, a7);
        flatBufferBuilder.m21507b(12, a8);
        flatBufferBuilder.m21507b(13, a9);
        flatBufferBuilder.m21507b(14, b3);
        flatBufferBuilder.m21507b(15, a10);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLContactRecommendationField(Parcel parcel) {
        super(17);
        this.f16656d = parcel.readLong();
        this.f16657e = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
        this.f16658f = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f16659g = parcel.readString();
        this.f16660h = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16661i = parcel.readString();
        this.f16662j = GraphQLContactFieldLabelType.fromString(parcel.readString());
        this.f16663k = parcel.readInt();
        this.f16664l = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLPhoto.class.getClassLoader()));
        this.f16665m = (GraphQLPrivacyScope) parcel.readValue(GraphQLPrivacyScope.class.getClassLoader());
        this.f16666n = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16667o = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16668p = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
        this.f16669q = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
        this.f16670r = parcel.readString();
        this.f16671s = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(m23527j());
        parcel.writeValue(m23528k());
        parcel.writeValue(m23529l());
        parcel.writeString(m23530m());
        parcel.writeValue(m23531n());
        parcel.writeString(m23532o());
        parcel.writeString(m23533p().name());
        parcel.writeInt(m23534q());
        parcel.writeList(m23535r());
        parcel.writeValue(m23536s());
        parcel.writeValue(m23537t());
        parcel.writeValue(m23538u());
        parcel.writeValue(m23539v());
        parcel.writeValue(m23540w());
        parcel.writeString(m23541x());
        parcel.writeValue(m23542y());
    }
}
