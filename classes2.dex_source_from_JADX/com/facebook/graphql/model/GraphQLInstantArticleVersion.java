package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLDocumentFeedbackOptions;
import com.facebook.graphql.enums.GraphQLDocumentFormatVersion;
import com.facebook.graphql.enums.GraphQLDocumentTextDirectionEnum;
import com.facebook.graphql.enums.GraphQLInstantArticlePublishStatus;
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
/* compiled from: live_android_whoswatching */
public final class GraphQLInstantArticleVersion extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLInstantArticleVersion> CREATOR = new 1();
    @Nullable
    public String f17329d;
    public int f17330e;
    public long f17331f;
    @Nullable
    public GraphQLProfile f17332g;
    @Nullable
    public GraphQLStoryAttachment f17333h;
    @Nullable
    public GraphQLFeedback f17334i;
    public GraphQLDocumentFeedbackOptions f17335j;
    public GraphQLDocumentFormatVersion f17336k;
    @Nullable
    public String f17337l;
    public long f17338m;
    public GraphQLInstantArticlePublishStatus f17339n;
    public long f17340o;
    public GraphQLDocumentTextDirectionEnum f17341p;
    @Nullable
    public String f17342q;
    @Nullable
    public GraphQLDocumentElement f17343r;

    @FieldOffset
    @Nullable
    public final String m24407j() {
        this.f17329d = super.m9948a(this.f17329d, 0);
        return this.f17329d;
    }

    @FieldOffset
    public final int m24408k() {
        m9949a(0, 1);
        return this.f17330e;
    }

    @FieldOffset
    public final long m24409l() {
        m9949a(0, 2);
        return this.f17331f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile m24410m() {
        this.f17332g = (GraphQLProfile) super.m9947a(this.f17332g, 3, GraphQLProfile.class);
        return this.f17332g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStoryAttachment m24411n() {
        this.f17333h = (GraphQLStoryAttachment) super.m9947a(this.f17333h, 4, GraphQLStoryAttachment.class);
        return this.f17333h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback m24412o() {
        this.f17334i = (GraphQLFeedback) super.m9947a(this.f17334i, 6, GraphQLFeedback.class);
        return this.f17334i;
    }

    @FieldOffset
    public final GraphQLDocumentFeedbackOptions m24413p() {
        this.f17335j = (GraphQLDocumentFeedbackOptions) super.m9945a(this.f17335j, 7, GraphQLDocumentFeedbackOptions.class, GraphQLDocumentFeedbackOptions.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17335j;
    }

    @FieldOffset
    public final GraphQLDocumentFormatVersion m24414q() {
        this.f17336k = (GraphQLDocumentFormatVersion) super.m9945a(this.f17336k, 8, GraphQLDocumentFormatVersion.class, GraphQLDocumentFormatVersion.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17336k;
    }

    @FieldOffset
    @Nullable
    public final String m24415r() {
        this.f17337l = super.m9948a(this.f17337l, 9);
        return this.f17337l;
    }

    @FieldOffset
    public final long m24416s() {
        m9949a(1, 2);
        return this.f17338m;
    }

    @FieldOffset
    public final GraphQLInstantArticlePublishStatus m24417t() {
        this.f17339n = (GraphQLInstantArticlePublishStatus) super.m9945a(this.f17339n, 11, GraphQLInstantArticlePublishStatus.class, GraphQLInstantArticlePublishStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17339n;
    }

    @FieldOffset
    public final long m24418u() {
        m9949a(1, 4);
        return this.f17340o;
    }

    @FieldOffset
    public final GraphQLDocumentTextDirectionEnum m24419v() {
        this.f17341p = (GraphQLDocumentTextDirectionEnum) super.m9945a(this.f17341p, 13, GraphQLDocumentTextDirectionEnum.class, GraphQLDocumentTextDirectionEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17341p;
    }

    @FieldOffset
    @Nullable
    public final String m24420w() {
        this.f17342q = super.m9948a(this.f17342q, 14);
        return this.f17342q;
    }

    @FieldOffset
    @Nullable
    public final GraphQLDocumentElement m24421x() {
        this.f17343r = (GraphQLDocumentElement) super.m9947a(this.f17343r, 15, GraphQLDocumentElement.class);
        return this.f17343r;
    }

    @Nullable
    public final String mo2834a() {
        return m24415r();
    }

    public final int jK_() {
        return 1619159843;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24421x() != null) {
            GraphQLDocumentElement graphQLDocumentElement = (GraphQLDocumentElement) graphQLModelMutatingVisitor.mo2928b(m24421x());
            if (m24421x() != graphQLDocumentElement) {
                graphQLVisitableModel = (GraphQLInstantArticleVersion) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17343r = graphQLDocumentElement;
            }
        }
        if (m24410m() != null) {
            GraphQLProfile graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.mo2928b(m24410m());
            if (m24410m() != graphQLProfile) {
                graphQLVisitableModel = (GraphQLInstantArticleVersion) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17332g = graphQLProfile;
            }
        }
        if (m24411n() != null) {
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) graphQLModelMutatingVisitor.mo2928b(m24411n());
            if (m24411n() != graphQLStoryAttachment) {
                graphQLVisitableModel = (GraphQLInstantArticleVersion) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17333h = graphQLStoryAttachment;
            }
        }
        if (m24412o() != null) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.mo2928b(m24412o());
            if (m24412o() != graphQLFeedback) {
                graphQLVisitableModel = (GraphQLInstantArticleVersion) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17334i = graphQLFeedback;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLInstantArticleVersion() {
        super(17);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17330e = mutableFlatBuffer.m21524a(i, 1, 0);
        this.f17331f = mutableFlatBuffer.m21525a(i, 2, 0);
        this.f17338m = mutableFlatBuffer.m21525a(i, 10, 0);
        this.f17340o = mutableFlatBuffer.m21525a(i, 12, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        Enum enumR = null;
        m9958h();
        int b = flatBufferBuilder.m21502b(m24407j());
        int a = ModelHelper.m23093a(flatBufferBuilder, m24410m());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24411n());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m24412o());
        int b2 = flatBufferBuilder.m21502b(m24415r());
        int b3 = flatBufferBuilder.m21502b(m24420w());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m24421x());
        flatBufferBuilder.m21510c(16);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21494a(1, m24408k(), 0);
        flatBufferBuilder.m21495a(2, m24409l(), 0);
        flatBufferBuilder.m21507b(3, a);
        flatBufferBuilder.m21507b(4, a2);
        flatBufferBuilder.m21507b(6, a3);
        flatBufferBuilder.m21496a(7, m24413p() == GraphQLDocumentFeedbackOptions.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m24413p());
        flatBufferBuilder.m21496a(8, m24414q() == GraphQLDocumentFormatVersion.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m24414q());
        flatBufferBuilder.m21507b(9, b2);
        flatBufferBuilder.m21495a(10, m24416s(), 0);
        flatBufferBuilder.m21496a(11, m24417t() == GraphQLInstantArticlePublishStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m24417t());
        flatBufferBuilder.m21495a(12, m24418u(), 0);
        if (m24419v() != GraphQLDocumentTextDirectionEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            enumR = m24419v();
        }
        flatBufferBuilder.m21496a(13, enumR);
        flatBufferBuilder.m21507b(14, b3);
        flatBufferBuilder.m21507b(15, a4);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLInstantArticleVersion(Parcel parcel) {
        super(17);
        this.f17329d = parcel.readString();
        this.f17330e = parcel.readInt();
        this.f17343r = (GraphQLDocumentElement) parcel.readValue(GraphQLDocumentElement.class.getClassLoader());
        this.f17331f = parcel.readLong();
        this.f17332g = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
        this.f17333h = (GraphQLStoryAttachment) parcel.readValue(GraphQLStoryAttachment.class.getClassLoader());
        this.f17334i = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f17335j = GraphQLDocumentFeedbackOptions.fromString(parcel.readString());
        this.f17336k = GraphQLDocumentFormatVersion.fromString(parcel.readString());
        this.f17337l = parcel.readString();
        this.f17338m = parcel.readLong();
        this.f17339n = GraphQLInstantArticlePublishStatus.fromString(parcel.readString());
        this.f17340o = parcel.readLong();
        this.f17341p = GraphQLDocumentTextDirectionEnum.fromString(parcel.readString());
        this.f17342q = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m24407j());
        parcel.writeInt(m24408k());
        parcel.writeValue(m24421x());
        parcel.writeLong(m24409l());
        parcel.writeValue(m24410m());
        parcel.writeValue(m24411n());
        parcel.writeValue(m24412o());
        parcel.writeString(m24413p().name());
        parcel.writeString(m24414q().name());
        parcel.writeString(m24415r());
        parcel.writeLong(m24416s());
        parcel.writeString(m24417t().name());
        parcel.writeLong(m24418u());
        parcel.writeString(m24419v().name());
        parcel.writeString(m24420w());
    }
}
