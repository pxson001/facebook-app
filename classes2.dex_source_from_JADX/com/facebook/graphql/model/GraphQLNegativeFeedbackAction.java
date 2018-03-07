package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackTargetType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: inline_composer_status_button_clicked */
public final class GraphQLNegativeFeedbackAction extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLNegativeFeedbackAction> CREATOR = new C07991();
    boolean f19884d;
    @Nullable
    GraphQLTextWithEntities f19885e;
    @Nullable
    GraphQLTextWithEntities f19886f;
    @Nullable
    GraphQLTextWithEntities f19887g;
    @Nullable
    GraphQLTextWithEntities f19888h;
    @Nullable
    String f19889i;
    GraphQLNegativeFeedbackActionType f19890j;
    @Nullable
    GraphQLTextWithEntities f19891k;
    @Nullable
    GraphQLProfile f19892l;
    GraphQLNegativeFeedbackTargetType f19893m;
    @Nullable
    GraphQLTextWithEntities f19894n;
    @Nullable
    GraphQLTextWithEntities f19895o;
    @Nullable
    String f19896p;

    /* compiled from: inline_composer_status_button_clicked */
    final class C07991 implements Creator<GraphQLNegativeFeedbackAction> {
        C07991() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLNegativeFeedbackAction(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLNegativeFeedbackAction[i];
        }
    }

    @FieldOffset
    public final boolean m27655j() {
        m9949a(0, 0);
        return this.f19884d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m27656k() {
        this.f19885e = (GraphQLTextWithEntities) super.m9947a(this.f19885e, 1, GraphQLTextWithEntities.class);
        return this.f19885e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m27657l() {
        this.f19886f = (GraphQLTextWithEntities) super.m9947a(this.f19886f, 2, GraphQLTextWithEntities.class);
        return this.f19886f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m27658m() {
        this.f19887g = (GraphQLTextWithEntities) super.m9947a(this.f19887g, 3, GraphQLTextWithEntities.class);
        return this.f19887g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m27659n() {
        this.f19888h = (GraphQLTextWithEntities) super.m9947a(this.f19888h, 4, GraphQLTextWithEntities.class);
        return this.f19888h;
    }

    @FieldOffset
    @Nullable
    public final String m27660o() {
        this.f19889i = super.m9948a(this.f19889i, 5);
        return this.f19889i;
    }

    @FieldOffset
    public final GraphQLNegativeFeedbackActionType m27654b() {
        this.f19890j = (GraphQLNegativeFeedbackActionType) super.m9945a(this.f19890j, 6, GraphQLNegativeFeedbackActionType.class, GraphQLNegativeFeedbackActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f19890j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m27661p() {
        this.f19891k = (GraphQLTextWithEntities) super.m9947a(this.f19891k, 8, GraphQLTextWithEntities.class);
        return this.f19891k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile m27662q() {
        this.f19892l = (GraphQLProfile) super.m9947a(this.f19892l, 9, GraphQLProfile.class);
        return this.f19892l;
    }

    @FieldOffset
    public final GraphQLNegativeFeedbackTargetType m27663r() {
        this.f19893m = (GraphQLNegativeFeedbackTargetType) super.m9945a(this.f19893m, 10, GraphQLNegativeFeedbackTargetType.class, GraphQLNegativeFeedbackTargetType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f19893m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m27664s() {
        this.f19894n = (GraphQLTextWithEntities) super.m9947a(this.f19894n, 11, GraphQLTextWithEntities.class);
        return this.f19894n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m27665t() {
        this.f19895o = (GraphQLTextWithEntities) super.m9947a(this.f19895o, 12, GraphQLTextWithEntities.class);
        return this.f19895o;
    }

    @FieldOffset
    @Nullable
    public final String m27666u() {
        this.f19896p = super.m9948a(this.f19896p, 13);
        return this.f19896p;
    }

    @Nullable
    public final String mo2834a() {
        return m27660o();
    }

    public final int jK_() {
        return 654926288;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m27656k() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m27656k());
            if (m27656k() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLNegativeFeedbackAction) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19885e = graphQLTextWithEntities;
            }
        }
        if (m27657l() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m27657l());
            if (m27657l() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLNegativeFeedbackAction) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19886f = graphQLTextWithEntities;
            }
        }
        if (m27658m() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m27658m());
            if (m27658m() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLNegativeFeedbackAction) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19887g = graphQLTextWithEntities;
            }
        }
        if (m27659n() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m27659n());
            if (m27659n() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLNegativeFeedbackAction) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19888h = graphQLTextWithEntities;
            }
        }
        if (m27661p() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m27661p());
            if (m27661p() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLNegativeFeedbackAction) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19891k = graphQLTextWithEntities;
            }
        }
        if (m27662q() != null) {
            GraphQLProfile graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.mo2928b(m27662q());
            if (m27662q() != graphQLProfile) {
                graphQLVisitableModel = (GraphQLNegativeFeedbackAction) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19892l = graphQLProfile;
            }
        }
        if (m27664s() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m27664s());
            if (m27664s() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLNegativeFeedbackAction) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19894n = graphQLTextWithEntities;
            }
        }
        if (m27665t() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m27665t());
            if (m27665t() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLNegativeFeedbackAction) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19895o = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLNegativeFeedbackAction() {
        super(15);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f19884d = mutableFlatBuffer.m21540a(i, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        Enum enumR = null;
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m27656k());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m27657l());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m27658m());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m27659n());
        int b = flatBufferBuilder.m21502b(m27660o());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m27661p());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m27662q());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m27664s());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m27665t());
        int b2 = flatBufferBuilder.m21502b(m27666u());
        flatBufferBuilder.m21510c(14);
        flatBufferBuilder.m21498a(0, m27655j());
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21507b(3, a3);
        flatBufferBuilder.m21507b(4, a4);
        flatBufferBuilder.m21507b(5, b);
        flatBufferBuilder.m21496a(6, m27654b() == GraphQLNegativeFeedbackActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m27654b());
        flatBufferBuilder.m21507b(8, a5);
        flatBufferBuilder.m21507b(9, a6);
        if (m27663r() != GraphQLNegativeFeedbackTargetType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            enumR = m27663r();
        }
        flatBufferBuilder.m21496a(10, enumR);
        flatBufferBuilder.m21507b(11, a7);
        flatBufferBuilder.m21507b(12, a8);
        flatBufferBuilder.m21507b(13, b2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLNegativeFeedbackAction(Parcel parcel) {
        boolean z = true;
        super(15);
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f19884d = z;
        this.f19885e = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f19886f = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f19887g = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f19888h = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f19889i = parcel.readString();
        this.f19890j = GraphQLNegativeFeedbackActionType.fromString(parcel.readString());
        this.f19891k = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f19892l = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
        this.f19893m = GraphQLNegativeFeedbackTargetType.fromString(parcel.readString());
        this.f19894n = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f19895o = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f19896p = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (m27655j() ? 1 : 0));
        parcel.writeValue(m27656k());
        parcel.writeValue(m27657l());
        parcel.writeValue(m27658m());
        parcel.writeValue(m27659n());
        parcel.writeString(m27660o());
        parcel.writeString(m27654b().name());
        parcel.writeValue(m27661p());
        parcel.writeValue(m27662q());
        parcel.writeString(m27663r().name());
        parcel.writeValue(m27664s());
        parcel.writeValue(m27665t());
        parcel.writeString(m27666u());
    }

    public GraphQLNegativeFeedbackAction(Builder builder) {
        super(15);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f19884d = builder.d;
        this.f19885e = builder.e;
        this.f19886f = builder.f;
        this.f19887g = builder.g;
        this.f19888h = builder.h;
        this.f19889i = builder.i;
        this.f19890j = builder.j;
        this.f19891k = builder.k;
        this.f19892l = builder.l;
        this.f19893m = builder.m;
        this.f19894n = builder.n;
        this.f19895o = builder.o;
        this.f19896p = builder.p;
    }
}
