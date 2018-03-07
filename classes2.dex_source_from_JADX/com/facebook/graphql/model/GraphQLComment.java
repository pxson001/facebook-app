package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.parser.GraphQlIdParserUtil;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: iorg_background_external_url_status */
public final class GraphQLComment extends BaseModel implements FeedAttachable, Feedbackable, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLComment> CREATOR = new C08101();
    @Nullable
    GraphQLTextWithEntities f19461A;
    @Nullable
    String f19462B;
    int f19463C;
    boolean f19464D;
    @Nullable
    GraphQLFeedback f19465E;
    @Nullable
    GraphQLTextWithEntities f19466F;
    int f19467d;
    @Nullable
    GraphQLStory f19468e;
    List<GraphQLStoryAttachment> f19469f;
    @Nullable
    GraphQLActor f19470g;
    @Nullable
    GraphQLTextWithEntities f19471h;
    boolean f19472i;
    boolean f19473j;
    @Nullable
    GraphQLComment f19474k;
    long f19475l;
    @Nullable
    GraphQLEditHistoryConnection f19476m;
    @Nullable
    GraphQLFeedback f19477n;
    @Nullable
    String f19478o;
    @Nullable
    GraphQLInterestingRepliesConnection f19479p;
    boolean f19480q;
    @Deprecated
    boolean f19481r;
    boolean f19482s;
    List<GraphQLStoryAttachment> f19483t;
    @Nullable
    GraphQLTextWithEntities f19484u;
    @Nullable
    GraphQLPrivacyScope f19485v;
    @Nullable
    GraphQLPrivateReplyContext f19486w;
    @Nullable
    String f19487x;
    int f19488y;
    @Nullable
    GraphQLPostTranslatability f19489z;

    /* compiled from: iorg_background_external_url_status */
    final class C08101 implements Creator<GraphQLComment> {
        C08101() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLComment(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLComment[i];
        }
    }

    public final String mo2507g() {
        return null;
    }

    public final List<GraphQLStoryAttachment> m27178j() {
        return m27184q();
    }

    public final boolean m27179k() {
        return FeedbackableUtil.m29216c(this);
    }

    public final int aa_() {
        return FeedbackableUtil.m29217d(this);
    }

    public final int mo2891n() {
        return FeedbackableUtil.m29218e(this);
    }

    public final int hashCode() {
        int i = 0;
        if (mo2890l() != null) {
            i = Objects.hashCode(GraphQlIdParserUtil.a(mo2890l().mo2933j()));
        }
        return i;
    }

    public final boolean equals(Object obj) {
        return HashCodeEqualsUtil.a(this, obj);
    }

    @FieldOffset
    public final int m27182o() {
        m9949a(0, 0);
        return this.f19467d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory m27183p() {
        this.f19468e = (GraphQLStory) super.m9947a(this.f19468e, 1, GraphQLStory.class);
        return this.f19468e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachment> m27184q() {
        this.f19469f = super.m9944a(this.f19469f, 2, GraphQLStoryAttachment.class);
        return (ImmutableList) this.f19469f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor m27185r() {
        this.f19470g = (GraphQLActor) super.m9947a(this.f19470g, 3, GraphQLActor.class);
        return this.f19470g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m27186s() {
        this.f19471h = (GraphQLTextWithEntities) super.m9947a(this.f19471h, 4, GraphQLTextWithEntities.class);
        return this.f19471h;
    }

    @FieldOffset
    public final boolean m27187t() {
        m9949a(0, 5);
        return this.f19472i;
    }

    @FieldOffset
    public final boolean m27188u() {
        m9949a(0, 6);
        return this.f19473j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLComment m27189v() {
        this.f19474k = (GraphQLComment) super.m9947a(this.f19474k, 7, GraphQLComment.class);
        return this.f19474k;
    }

    @FieldOffset
    public final long m27190w() {
        m9949a(1, 0);
        return this.f19475l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEditHistoryConnection m27191x() {
        this.f19476m = (GraphQLEditHistoryConnection) super.m9947a(this.f19476m, 9, GraphQLEditHistoryConnection.class);
        return this.f19476m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback mo2890l() {
        this.f19477n = (GraphQLFeedback) super.m9947a(this.f19477n, 10, GraphQLFeedback.class);
        return this.f19477n;
    }

    @FieldOffset
    @Nullable
    public final String m27192y() {
        this.f19478o = super.m9948a(this.f19478o, 11);
        return this.f19478o;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInterestingRepliesConnection m27193z() {
        this.f19479p = (GraphQLInterestingRepliesConnection) super.m9947a(this.f19479p, 12, GraphQLInterestingRepliesConnection.class);
        return this.f19479p;
    }

    @FieldOffset
    public final boolean m27157A() {
        m9949a(1, 5);
        return this.f19480q;
    }

    @FieldOffset
    public final boolean m27158B() {
        m9949a(1, 6);
        return this.f19481r;
    }

    @FieldOffset
    public final boolean m27159C() {
        m9949a(1, 7);
        return this.f19482s;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachment> m27160D() {
        this.f19483t = super.m9944a(this.f19483t, 16, GraphQLStoryAttachment.class);
        return (ImmutableList) this.f19483t;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m27161E() {
        this.f19484u = (GraphQLTextWithEntities) super.m9947a(this.f19484u, 17, GraphQLTextWithEntities.class);
        return this.f19484u;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyScope m27162F() {
        this.f19485v = (GraphQLPrivacyScope) super.m9947a(this.f19485v, 18, GraphQLPrivacyScope.class);
        return this.f19485v;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivateReplyContext m27163G() {
        this.f19486w = (GraphQLPrivateReplyContext) super.m9947a(this.f19486w, 19, GraphQLPrivateReplyContext.class);
        return this.f19486w;
    }

    @FieldOffset
    @Nullable
    public final String m27164H() {
        this.f19487x = super.m9948a(this.f19487x, 20);
        return this.f19487x;
    }

    @FieldOffset
    public final int m27165I() {
        m9949a(2, 5);
        return this.f19488y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPostTranslatability m27166J() {
        this.f19489z = (GraphQLPostTranslatability) super.m9947a(this.f19489z, 22, GraphQLPostTranslatability.class);
        return this.f19489z;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m27167K() {
        this.f19461A = (GraphQLTextWithEntities) super.m9947a(this.f19461A, 23, GraphQLTextWithEntities.class);
        return this.f19461A;
    }

    @FieldOffset
    @Nullable
    public final String m27168L() {
        this.f19462B = super.m9948a(this.f19462B, 24);
        return this.f19462B;
    }

    @FieldOffset
    public final int m27169M() {
        m9949a(3, 1);
        return this.f19463C;
    }

    @FieldOffset
    public final boolean m27170N() {
        m9949a(3, 2);
        return this.f19464D;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback m27171O() {
        this.f19465E = (GraphQLFeedback) super.m9947a(this.f19465E, 27, GraphQLFeedback.class);
        return this.f19465E;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m27172P() {
        this.f19466F = (GraphQLTextWithEntities) super.m9947a(this.f19466F, 28, GraphQLTextWithEntities.class);
        return this.f19466F;
    }

    @Nullable
    public final String mo2834a() {
        return m27192y();
    }

    public final int jK_() {
        return -1679915457;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLFeedback graphQLFeedback;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m27183p() != null) {
            GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.mo2928b(m27183p());
            if (m27183p() != graphQLStory) {
                graphQLVisitableModel = (GraphQLComment) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19468e = graphQLStory;
            }
        }
        if (m27184q() != null) {
            a = ModelHelper.m23097a(m27184q(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLComment graphQLComment = (GraphQLComment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLComment.f19469f = a.m1068b();
                graphQLVisitableModel = graphQLComment;
            }
        }
        if (m27185r() != null) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.mo2928b(m27185r());
            if (m27185r() != graphQLActor) {
                graphQLVisitableModel = (GraphQLComment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19470g = graphQLActor;
            }
        }
        if (m27186s() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m27186s());
            if (m27186s() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLComment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19471h = graphQLTextWithEntities;
            }
        }
        if (m27172P() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m27172P());
            if (m27172P() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLComment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19466F = graphQLTextWithEntities;
            }
        }
        if (m27189v() != null) {
            graphQLComment = (GraphQLComment) graphQLModelMutatingVisitor.mo2928b(m27189v());
            if (m27189v() != graphQLComment) {
                graphQLVisitableModel = (GraphQLComment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19474k = graphQLComment;
            }
        }
        if (m27191x() != null) {
            GraphQLEditHistoryConnection graphQLEditHistoryConnection = (GraphQLEditHistoryConnection) graphQLModelMutatingVisitor.mo2928b(m27191x());
            if (m27191x() != graphQLEditHistoryConnection) {
                graphQLVisitableModel = (GraphQLComment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19476m = graphQLEditHistoryConnection;
            }
        }
        if (mo2890l() != null) {
            graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.mo2928b(mo2890l());
            if (mo2890l() != graphQLFeedback) {
                graphQLVisitableModel = (GraphQLComment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19477n = graphQLFeedback;
            }
        }
        if (m27193z() != null) {
            GraphQLInterestingRepliesConnection graphQLInterestingRepliesConnection = (GraphQLInterestingRepliesConnection) graphQLModelMutatingVisitor.mo2928b(m27193z());
            if (m27193z() != graphQLInterestingRepliesConnection) {
                graphQLVisitableModel = (GraphQLComment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19479p = graphQLInterestingRepliesConnection;
            }
        }
        if (m27160D() != null) {
            a = ModelHelper.m23097a(m27160D(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLComment = (GraphQLComment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLComment.f19483t = a.m1068b();
                graphQLVisitableModel = graphQLComment;
            }
        }
        if (m27171O() != null) {
            graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.mo2928b(m27171O());
            if (m27171O() != graphQLFeedback) {
                graphQLVisitableModel = (GraphQLComment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19465E = graphQLFeedback;
            }
        }
        if (m27161E() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m27161E());
            if (m27161E() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLComment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19484u = graphQLTextWithEntities;
            }
        }
        if (m27162F() != null) {
            GraphQLPrivacyScope graphQLPrivacyScope = (GraphQLPrivacyScope) graphQLModelMutatingVisitor.mo2928b(m27162F());
            if (m27162F() != graphQLPrivacyScope) {
                graphQLVisitableModel = (GraphQLComment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19485v = graphQLPrivacyScope;
            }
        }
        if (m27163G() != null) {
            GraphQLPrivateReplyContext graphQLPrivateReplyContext = (GraphQLPrivateReplyContext) graphQLModelMutatingVisitor.mo2928b(m27163G());
            if (m27163G() != graphQLPrivateReplyContext) {
                graphQLVisitableModel = (GraphQLComment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19486w = graphQLPrivateReplyContext;
            }
        }
        if (m27166J() != null) {
            GraphQLPostTranslatability graphQLPostTranslatability = (GraphQLPostTranslatability) graphQLModelMutatingVisitor.mo2928b(m27166J());
            if (m27166J() != graphQLPostTranslatability) {
                graphQLVisitableModel = (GraphQLComment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19489z = graphQLPostTranslatability;
            }
        }
        if (m27167K() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m27167K());
            if (m27167K() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLComment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19461A = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLComment() {
        super(30);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f19467d = mutableFlatBuffer.m21524a(i, 0, 0);
        this.f19472i = mutableFlatBuffer.m21540a(i, 5);
        this.f19473j = mutableFlatBuffer.m21540a(i, 6);
        this.f19475l = mutableFlatBuffer.m21525a(i, 8, 0);
        this.f19480q = mutableFlatBuffer.m21540a(i, 13);
        this.f19481r = mutableFlatBuffer.m21540a(i, 14);
        this.f19482s = mutableFlatBuffer.m21540a(i, 15);
        this.f19488y = mutableFlatBuffer.m21524a(i, 21, 0);
        this.f19463C = mutableFlatBuffer.m21524a(i, 25, 0);
        this.f19464D = mutableFlatBuffer.m21540a(i, 26);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m27183p());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m27184q());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m27185r());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m27186s());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m27189v());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m27191x());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, mo2890l());
        int b = flatBufferBuilder.m21502b(m27192y());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m27193z());
        int a9 = ModelHelper.m23094a(flatBufferBuilder, m27160D());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, m27161E());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, m27162F());
        int a12 = ModelHelper.m23093a(flatBufferBuilder, m27163G());
        int b2 = flatBufferBuilder.m21502b(m27164H());
        int a13 = ModelHelper.m23093a(flatBufferBuilder, m27166J());
        int a14 = ModelHelper.m23093a(flatBufferBuilder, m27167K());
        int b3 = flatBufferBuilder.m21502b(m27168L());
        int a15 = ModelHelper.m23093a(flatBufferBuilder, m27171O());
        int a16 = ModelHelper.m23093a(flatBufferBuilder, m27172P());
        flatBufferBuilder.m21510c(29);
        flatBufferBuilder.m21494a(0, m27182o(), 0);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21507b(3, a3);
        flatBufferBuilder.m21507b(4, a4);
        flatBufferBuilder.m21498a(5, m27187t());
        flatBufferBuilder.m21498a(6, m27188u());
        flatBufferBuilder.m21507b(7, a5);
        flatBufferBuilder.m21495a(8, m27190w(), 0);
        flatBufferBuilder.m21507b(9, a6);
        flatBufferBuilder.m21507b(10, a7);
        flatBufferBuilder.m21507b(11, b);
        flatBufferBuilder.m21507b(12, a8);
        flatBufferBuilder.m21498a(13, m27157A());
        flatBufferBuilder.m21498a(14, m27158B());
        flatBufferBuilder.m21498a(15, m27159C());
        flatBufferBuilder.m21507b(16, a9);
        flatBufferBuilder.m21507b(17, a10);
        flatBufferBuilder.m21507b(18, a11);
        flatBufferBuilder.m21507b(19, a12);
        flatBufferBuilder.m21507b(20, b2);
        flatBufferBuilder.m21494a(21, m27165I(), 0);
        flatBufferBuilder.m21507b(22, a13);
        flatBufferBuilder.m21507b(23, a14);
        flatBufferBuilder.m21507b(24, b3);
        flatBufferBuilder.m21494a(25, m27169M(), 0);
        flatBufferBuilder.m21498a(26, m27170N());
        flatBufferBuilder.m21507b(27, a15);
        flatBufferBuilder.m21507b(28, a16);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLComment(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(30);
        this.f19467d = parcel.readInt();
        this.f19468e = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
        this.f19469f = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryAttachment.class.getClassLoader()));
        this.f19470g = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
        this.f19471h = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f19466F = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f19472i = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f19473j = z;
        this.f19474k = (GraphQLComment) parcel.readValue(GraphQLComment.class.getClassLoader());
        this.f19475l = parcel.readLong();
        this.f19476m = (GraphQLEditHistoryConnection) parcel.readValue(GraphQLEditHistoryConnection.class.getClassLoader());
        this.f19477n = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f19478o = parcel.readString();
        this.f19479p = (GraphQLInterestingRepliesConnection) parcel.readValue(GraphQLInterestingRepliesConnection.class.getClassLoader());
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f19480q = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f19481r = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f19482s = z;
        this.f19483t = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryAttachment.class.getClassLoader()));
        this.f19465E = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f19484u = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f19485v = (GraphQLPrivacyScope) parcel.readValue(GraphQLPrivacyScope.class.getClassLoader());
        this.f19486w = (GraphQLPrivateReplyContext) parcel.readValue(GraphQLPrivateReplyContext.class.getClassLoader());
        this.f19487x = parcel.readString();
        this.f19488y = parcel.readInt();
        this.f19463C = parcel.readInt();
        this.f19489z = (GraphQLPostTranslatability) parcel.readValue(GraphQLPostTranslatability.class.getClassLoader());
        this.f19461A = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f19462B = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f19464D = z2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeInt(m27182o());
        parcel.writeValue(m27183p());
        parcel.writeList(m27184q());
        parcel.writeValue(m27185r());
        parcel.writeValue(m27186s());
        parcel.writeValue(m27172P());
        parcel.writeByte((byte) (m27187t() ? 1 : 0));
        if (m27188u()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(m27189v());
        parcel.writeLong(m27190w());
        parcel.writeValue(m27191x());
        parcel.writeValue(mo2890l());
        parcel.writeString(m27192y());
        parcel.writeValue(m27193z());
        if (m27157A()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m27158B()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m27159C()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeList(m27160D());
        parcel.writeValue(m27171O());
        parcel.writeValue(m27161E());
        parcel.writeValue(m27162F());
        parcel.writeValue(m27163G());
        parcel.writeString(m27164H());
        parcel.writeInt(m27165I());
        parcel.writeInt(m27169M());
        parcel.writeValue(m27166J());
        parcel.writeValue(m27167K());
        parcel.writeString(m27168L());
        if (!m27170N()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
    }

    public GraphQLComment(Builder builder) {
        super(30);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f19467d = builder.d;
        this.f19468e = builder.e;
        this.f19469f = builder.f;
        this.f19470g = builder.g;
        this.f19471h = builder.h;
        this.f19466F = builder.i;
        this.f19472i = builder.j;
        this.f19473j = builder.k;
        this.f19474k = builder.l;
        this.f19475l = builder.m;
        this.f19476m = builder.n;
        this.f19477n = builder.o;
        this.f19478o = builder.p;
        this.f19479p = builder.q;
        this.f19480q = builder.r;
        this.f19481r = builder.s;
        this.f19482s = builder.t;
        this.f19483t = builder.u;
        this.f19465E = builder.v;
        this.f19484u = builder.w;
        this.f19485v = builder.x;
        this.f19486w = builder.y;
        this.f19487x = builder.z;
        this.f19488y = builder.A;
        this.f19463C = builder.B;
        this.f19489z = builder.C;
        this.f19461A = builder.D;
        this.f19462B = builder.E;
        this.f19464D = builder.F;
    }
}
