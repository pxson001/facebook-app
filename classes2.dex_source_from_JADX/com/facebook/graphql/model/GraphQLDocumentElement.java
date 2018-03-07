package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLAudioAnnotationPlayMode;
import com.facebook.graphql.enums.GraphQLDocumentElementMarginStyle;
import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.graphql.enums.GraphQLDocumentFeedbackOptions;
import com.facebook.graphql.enums.GraphQLDocumentListStyle;
import com.facebook.graphql.enums.GraphQLDocumentMapStyle;
import com.facebook.graphql.enums.GraphQLDocumentMediaPresentationStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoAutoplayStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoControlStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoLoopingStyle;
import com.facebook.graphql.enums.GraphQLDocumentWebviewPresentationStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
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
/* compiled from: logVideoPausedEvent */
public final class GraphQLDocumentElement extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLDocumentElement> CREATOR = new 1();
    public GraphQLDocumentVideoLoopingStyle f16342A;
    public GraphQLDocumentWebviewPresentationStyle f16343B;
    @Nullable
    public GraphQLObjectType f16344d;
    public GraphQLAudioAnnotationPlayMode f16345e;
    @Nullable
    public String f16346f;
    @Deprecated
    @Nullable
    public String f16347g;
    @Nullable
    public String f16348h;
    public int f16349i;
    public int f16350j;
    public GraphQLDocumentElementType f16351k;
    @Nullable
    public GraphQLVideo f16352l;
    public boolean f16353m;
    @Nullable
    public GraphQLFeedback f16354n;
    public GraphQLDocumentFeedbackOptions f16355o;
    @Nullable
    public String f16356p;
    @Nullable
    public String f16357q;
    public GraphQLDocumentListStyle f16358r;
    public GraphQLDocumentMapStyle f16359s;
    public GraphQLDocumentElementMarginStyle f16360t;
    @Nullable
    public GraphQLPhoto f16361u;
    @Nullable
    public GraphQLPhoto f16362v;
    public GraphQLDocumentMediaPresentationStyle f16363w;
    @Nullable
    public String f16364x;
    public GraphQLDocumentVideoAutoplayStyle f16365y;
    public GraphQLDocumentVideoControlStyle f16366z;

    @Nullable
    public final GraphQLObjectType m23190j() {
        if (this.f5823b != null && this.f16344d == null) {
            this.f16344d = new GraphQLObjectType(this.f5823b.m21542b(this.f5824c, 0));
        }
        if (this.f16344d == null || this.f16344d.m22301g() != 0) {
            return this.f16344d;
        }
        return null;
    }

    @FieldOffset
    public final GraphQLAudioAnnotationPlayMode m23191k() {
        this.f16345e = (GraphQLAudioAnnotationPlayMode) super.m9945a(this.f16345e, 1, GraphQLAudioAnnotationPlayMode.class, GraphQLAudioAnnotationPlayMode.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16345e;
    }

    @FieldOffset
    @Nullable
    public final String m23192l() {
        this.f16346f = super.m9948a(this.f16346f, 2);
        return this.f16346f;
    }

    @FieldOffset
    @Nullable
    public final String m23193m() {
        this.f16347g = super.m9948a(this.f16347g, 3);
        return this.f16347g;
    }

    @FieldOffset
    @Nullable
    public final String m23194n() {
        this.f16348h = super.m9948a(this.f16348h, 4);
        return this.f16348h;
    }

    @FieldOffset
    public final int m23195o() {
        m9949a(0, 6);
        return this.f16349i;
    }

    @FieldOffset
    public final int m23196p() {
        m9949a(0, 7);
        return this.f16350j;
    }

    @FieldOffset
    public final GraphQLDocumentElementType m23197q() {
        this.f16351k = (GraphQLDocumentElementType) super.m9945a(this.f16351k, 8, GraphQLDocumentElementType.class, GraphQLDocumentElementType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16351k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLVideo m23198r() {
        this.f16352l = (GraphQLVideo) super.m9947a(this.f16352l, 9, GraphQLVideo.class);
        return this.f16352l;
    }

    @FieldOffset
    public final boolean m23199s() {
        m9949a(1, 3);
        return this.f16353m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback m23200t() {
        this.f16354n = (GraphQLFeedback) super.m9947a(this.f16354n, 12, GraphQLFeedback.class);
        return this.f16354n;
    }

    @FieldOffset
    public final GraphQLDocumentFeedbackOptions m23201u() {
        this.f16355o = (GraphQLDocumentFeedbackOptions) super.m9945a(this.f16355o, 13, GraphQLDocumentFeedbackOptions.class, GraphQLDocumentFeedbackOptions.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16355o;
    }

    @FieldOffset
    @Nullable
    public final String m23202v() {
        this.f16356p = super.m9948a(this.f16356p, 14);
        return this.f16356p;
    }

    @FieldOffset
    @Nullable
    public final String m23203w() {
        this.f16357q = super.m9948a(this.f16357q, 15);
        return this.f16357q;
    }

    @FieldOffset
    public final GraphQLDocumentListStyle m23204x() {
        this.f16358r = (GraphQLDocumentListStyle) super.m9945a(this.f16358r, 16, GraphQLDocumentListStyle.class, GraphQLDocumentListStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16358r;
    }

    @FieldOffset
    public final GraphQLDocumentMapStyle m23205y() {
        this.f16359s = (GraphQLDocumentMapStyle) super.m9945a(this.f16359s, 17, GraphQLDocumentMapStyle.class, GraphQLDocumentMapStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16359s;
    }

    @FieldOffset
    public final GraphQLDocumentElementMarginStyle m23206z() {
        this.f16360t = (GraphQLDocumentElementMarginStyle) super.m9945a(this.f16360t, 18, GraphQLDocumentElementMarginStyle.class, GraphQLDocumentElementMarginStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16360t;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhoto m23178A() {
        this.f16361u = (GraphQLPhoto) super.m9947a(this.f16361u, 19, GraphQLPhoto.class);
        return this.f16361u;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhoto m23179B() {
        this.f16362v = (GraphQLPhoto) super.m9947a(this.f16362v, 20, GraphQLPhoto.class);
        return this.f16362v;
    }

    @FieldOffset
    public final GraphQLDocumentMediaPresentationStyle m23180C() {
        this.f16363w = (GraphQLDocumentMediaPresentationStyle) super.m9945a(this.f16363w, 21, GraphQLDocumentMediaPresentationStyle.class, GraphQLDocumentMediaPresentationStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16363w;
    }

    @FieldOffset
    @Nullable
    public final String m23181D() {
        this.f16364x = super.m9948a(this.f16364x, 22);
        return this.f16364x;
    }

    @FieldOffset
    public final GraphQLDocumentVideoAutoplayStyle m23182E() {
        this.f16365y = (GraphQLDocumentVideoAutoplayStyle) super.m9945a(this.f16365y, 23, GraphQLDocumentVideoAutoplayStyle.class, GraphQLDocumentVideoAutoplayStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16365y;
    }

    @FieldOffset
    public final GraphQLDocumentVideoControlStyle m23183F() {
        this.f16366z = (GraphQLDocumentVideoControlStyle) super.m9945a(this.f16366z, 24, GraphQLDocumentVideoControlStyle.class, GraphQLDocumentVideoControlStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16366z;
    }

    @FieldOffset
    public final GraphQLDocumentVideoLoopingStyle m23184G() {
        this.f16342A = (GraphQLDocumentVideoLoopingStyle) super.m9945a(this.f16342A, 25, GraphQLDocumentVideoLoopingStyle.class, GraphQLDocumentVideoLoopingStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16342A;
    }

    @FieldOffset
    public final GraphQLDocumentWebviewPresentationStyle m23185H() {
        this.f16343B = (GraphQLDocumentWebviewPresentationStyle) super.m9945a(this.f16343B, 26, GraphQLDocumentWebviewPresentationStyle.class, GraphQLDocumentWebviewPresentationStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16343B;
    }

    @Nullable
    public final String mo2834a() {
        return m23203w();
    }

    public final int jK_() {
        return 473184577;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLPhoto graphQLPhoto;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23198r() != null) {
            GraphQLVideo graphQLVideo = (GraphQLVideo) graphQLModelMutatingVisitor.mo2928b(m23198r());
            if (m23198r() != graphQLVideo) {
                graphQLVisitableModel = (GraphQLDocumentElement) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16352l = graphQLVideo;
            }
        }
        if (m23200t() != null) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.mo2928b(m23200t());
            if (m23200t() != graphQLFeedback) {
                graphQLVisitableModel = (GraphQLDocumentElement) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16354n = graphQLFeedback;
            }
        }
        if (m23178A() != null) {
            graphQLPhoto = (GraphQLPhoto) graphQLModelMutatingVisitor.mo2928b(m23178A());
            if (m23178A() != graphQLPhoto) {
                graphQLVisitableModel = (GraphQLDocumentElement) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16361u = graphQLPhoto;
            }
        }
        if (m23179B() != null) {
            graphQLPhoto = (GraphQLPhoto) graphQLModelMutatingVisitor.mo2928b(m23179B());
            if (m23179B() != graphQLPhoto) {
                graphQLVisitableModel = (GraphQLDocumentElement) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16362v = graphQLPhoto;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLDocumentElement() {
        super(28);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16349i = mutableFlatBuffer.m21524a(i, 6, 0);
        this.f16350j = mutableFlatBuffer.m21524a(i, 7, 0);
        this.f16353m = mutableFlatBuffer.m21540a(i, 11);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = flatBufferBuilder.m21479a(m23190j() != null ? m23190j().m22299e() : null);
        int b = flatBufferBuilder.m21502b(m23192l());
        int b2 = flatBufferBuilder.m21502b(m23193m());
        int b3 = flatBufferBuilder.m21502b(m23194n());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23198r());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m23200t());
        int b4 = flatBufferBuilder.m21502b(m23202v());
        int b5 = flatBufferBuilder.m21502b(m23203w());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m23178A());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m23179B());
        int b6 = flatBufferBuilder.m21502b(m23181D());
        flatBufferBuilder.m21510c(27);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21496a(1, m23191k() == GraphQLAudioAnnotationPlayMode.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23191k());
        flatBufferBuilder.m21507b(2, b);
        flatBufferBuilder.m21507b(3, b2);
        flatBufferBuilder.m21507b(4, b3);
        flatBufferBuilder.m21494a(6, m23195o(), 0);
        flatBufferBuilder.m21494a(7, m23196p(), 0);
        flatBufferBuilder.m21496a(8, m23197q() == GraphQLDocumentElementType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23197q());
        flatBufferBuilder.m21507b(9, a2);
        flatBufferBuilder.m21498a(11, m23199s());
        flatBufferBuilder.m21507b(12, a3);
        flatBufferBuilder.m21496a(13, m23201u() == GraphQLDocumentFeedbackOptions.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23201u());
        flatBufferBuilder.m21507b(14, b4);
        flatBufferBuilder.m21507b(15, b5);
        flatBufferBuilder.m21496a(16, m23204x() == GraphQLDocumentListStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23204x());
        flatBufferBuilder.m21496a(17, m23205y() == GraphQLDocumentMapStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23205y());
        flatBufferBuilder.m21496a(18, m23206z() == GraphQLDocumentElementMarginStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23206z());
        flatBufferBuilder.m21507b(19, a4);
        flatBufferBuilder.m21507b(20, a5);
        flatBufferBuilder.m21496a(21, m23180C() == GraphQLDocumentMediaPresentationStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23180C());
        flatBufferBuilder.m21507b(22, b6);
        flatBufferBuilder.m21496a(23, m23182E() == GraphQLDocumentVideoAutoplayStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23182E());
        flatBufferBuilder.m21496a(24, m23183F() == GraphQLDocumentVideoControlStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23183F());
        flatBufferBuilder.m21496a(25, m23184G() == GraphQLDocumentVideoLoopingStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23184G());
        flatBufferBuilder.m21496a(26, m23185H() == GraphQLDocumentWebviewPresentationStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23185H());
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLDocumentElement(Parcel parcel) {
        super(28);
        this.f16345e = GraphQLAudioAnnotationPlayMode.fromString(parcel.readString());
        this.f16346f = parcel.readString();
        this.f16347g = parcel.readString();
        this.f16348h = parcel.readString();
        this.f16349i = parcel.readInt();
        this.f16350j = parcel.readInt();
        this.f16351k = GraphQLDocumentElementType.fromString(parcel.readString());
        this.f16352l = (GraphQLVideo) parcel.readValue(GraphQLVideo.class.getClassLoader());
        this.f16353m = parcel.readByte() == (byte) 1;
        this.f16354n = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f16355o = GraphQLDocumentFeedbackOptions.fromString(parcel.readString());
        this.f16356p = parcel.readString();
        this.f16357q = parcel.readString();
        this.f16358r = GraphQLDocumentListStyle.fromString(parcel.readString());
        this.f16359s = GraphQLDocumentMapStyle.fromString(parcel.readString());
        this.f16360t = GraphQLDocumentElementMarginStyle.fromString(parcel.readString());
        this.f16361u = (GraphQLPhoto) parcel.readValue(GraphQLPhoto.class.getClassLoader());
        this.f16362v = (GraphQLPhoto) parcel.readValue(GraphQLPhoto.class.getClassLoader());
        this.f16363w = GraphQLDocumentMediaPresentationStyle.fromString(parcel.readString());
        this.f16364x = parcel.readString();
        this.f16365y = GraphQLDocumentVideoAutoplayStyle.fromString(parcel.readString());
        this.f16366z = GraphQLDocumentVideoControlStyle.fromString(parcel.readString());
        this.f16342A = GraphQLDocumentVideoLoopingStyle.fromString(parcel.readString());
        this.f16343B = GraphQLDocumentWebviewPresentationStyle.fromString(parcel.readString());
        this.f16344d = (GraphQLObjectType) ParcelUtil.b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m23191k().name());
        parcel.writeString(m23192l());
        parcel.writeString(m23193m());
        parcel.writeString(m23194n());
        parcel.writeInt(m23195o());
        parcel.writeInt(m23196p());
        parcel.writeString(m23197q().name());
        parcel.writeValue(m23198r());
        parcel.writeByte((byte) (m23199s() ? 1 : 0));
        parcel.writeValue(m23200t());
        parcel.writeString(m23201u().name());
        parcel.writeString(m23202v());
        parcel.writeString(m23203w());
        parcel.writeString(m23204x().name());
        parcel.writeString(m23205y().name());
        parcel.writeString(m23206z().name());
        parcel.writeValue(m23178A());
        parcel.writeValue(m23179B());
        parcel.writeString(m23180C().name());
        parcel.writeString(m23181D());
        parcel.writeString(m23182E().name());
        parcel.writeString(m23183F().name());
        parcel.writeString(m23184G().name());
        parcel.writeString(m23185H().name());
        parcel.writeParcelable(this.f16344d, i);
    }
}
