package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
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
/* compiled from: location_settings */
public final class GraphQLInstantArticle extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLInstantArticle> CREATOR = new 1();
    @Nullable
    GraphQLFeedback f16503d;
    @Nullable
    GraphQLInstantArticleVersion f16504e;
    @Nullable
    GraphQLExternalUrl f16505f;
    @Nullable
    String f16506g;
    @Nullable
    GraphQLInstantArticleVersion f16507h;
    @Nullable
    String f16508i;
    @Nullable
    GraphQLInstantArticleVersion f16509j;
    @Nullable
    String f16510k;
    @Nullable
    GraphQLInstantArticleVersion f16511l;
    @Nullable
    GraphQLMessengerContentSubscriptionOption f16512m;

    @FieldOffset
    @Nullable
    public final GraphQLFeedback m23346j() {
        this.f16503d = (GraphQLFeedback) super.m9947a(this.f16503d, 0, GraphQLFeedback.class);
        return this.f16503d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInstantArticleVersion m23347k() {
        this.f16504e = (GraphQLInstantArticleVersion) super.m9947a(this.f16504e, 1, GraphQLInstantArticleVersion.class);
        return this.f16504e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLExternalUrl m23348l() {
        this.f16505f = (GraphQLExternalUrl) super.m9947a(this.f16505f, 2, GraphQLExternalUrl.class);
        return this.f16505f;
    }

    @FieldOffset
    @Nullable
    public final String m23349m() {
        this.f16506g = super.m9948a(this.f16506g, 3);
        return this.f16506g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInstantArticleVersion m23350n() {
        this.f16507h = (GraphQLInstantArticleVersion) super.m9947a(this.f16507h, 4, GraphQLInstantArticleVersion.class);
        return this.f16507h;
    }

    @FieldOffset
    @Nullable
    public final String m23351o() {
        this.f16508i = super.m9948a(this.f16508i, 5);
        return this.f16508i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInstantArticleVersion m23352p() {
        this.f16509j = (GraphQLInstantArticleVersion) super.m9947a(this.f16509j, 6, GraphQLInstantArticleVersion.class);
        return this.f16509j;
    }

    @FieldOffset
    @Nullable
    public final String m23353q() {
        this.f16510k = super.m9948a(this.f16510k, 7);
        return this.f16510k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInstantArticleVersion m23354r() {
        this.f16511l = (GraphQLInstantArticleVersion) super.m9947a(this.f16511l, 8, GraphQLInstantArticleVersion.class);
        return this.f16511l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLMessengerContentSubscriptionOption m23355s() {
        this.f16512m = (GraphQLMessengerContentSubscriptionOption) super.m9947a(this.f16512m, 9, GraphQLMessengerContentSubscriptionOption.class);
        return this.f16512m;
    }

    @Nullable
    public final String mo2834a() {
        return m23349m();
    }

    public final int jK_() {
        return 1607392245;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLInstantArticleVersion graphQLInstantArticleVersion;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23346j() != null) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.mo2928b(m23346j());
            if (m23346j() != graphQLFeedback) {
                graphQLVisitableModel = (GraphQLInstantArticle) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16503d = graphQLFeedback;
            }
        }
        if (m23347k() != null) {
            graphQLInstantArticleVersion = (GraphQLInstantArticleVersion) graphQLModelMutatingVisitor.mo2928b(m23347k());
            if (m23347k() != graphQLInstantArticleVersion) {
                graphQLVisitableModel = (GraphQLInstantArticle) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16504e = graphQLInstantArticleVersion;
            }
        }
        if (m23348l() != null) {
            GraphQLExternalUrl graphQLExternalUrl = (GraphQLExternalUrl) graphQLModelMutatingVisitor.mo2928b(m23348l());
            if (m23348l() != graphQLExternalUrl) {
                graphQLVisitableModel = (GraphQLInstantArticle) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16505f = graphQLExternalUrl;
            }
        }
        if (m23350n() != null) {
            graphQLInstantArticleVersion = (GraphQLInstantArticleVersion) graphQLModelMutatingVisitor.mo2928b(m23350n());
            if (m23350n() != graphQLInstantArticleVersion) {
                graphQLVisitableModel = (GraphQLInstantArticle) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16507h = graphQLInstantArticleVersion;
            }
        }
        if (m23355s() != null) {
            GraphQLMessengerContentSubscriptionOption graphQLMessengerContentSubscriptionOption = (GraphQLMessengerContentSubscriptionOption) graphQLModelMutatingVisitor.mo2928b(m23355s());
            if (m23355s() != graphQLMessengerContentSubscriptionOption) {
                graphQLVisitableModel = (GraphQLInstantArticle) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16512m = graphQLMessengerContentSubscriptionOption;
            }
        }
        if (m23354r() != null) {
            graphQLInstantArticleVersion = (GraphQLInstantArticleVersion) graphQLModelMutatingVisitor.mo2928b(m23354r());
            if (m23354r() != graphQLInstantArticleVersion) {
                graphQLVisitableModel = (GraphQLInstantArticle) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16511l = graphQLInstantArticleVersion;
            }
        }
        if (m23352p() != null) {
            graphQLInstantArticleVersion = (GraphQLInstantArticleVersion) graphQLModelMutatingVisitor.mo2928b(m23352p());
            if (m23352p() != graphQLInstantArticleVersion) {
                graphQLVisitableModel = (GraphQLInstantArticle) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16509j = graphQLInstantArticleVersion;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLInstantArticle() {
        super(11);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m23346j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23347k());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m23348l());
        int b = flatBufferBuilder.m21502b(m23349m());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m23350n());
        int b2 = flatBufferBuilder.m21502b(m23351o());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m23352p());
        int b3 = flatBufferBuilder.m21502b(m23353q());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m23354r());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m23355s());
        flatBufferBuilder.m21510c(10);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(2, a3);
        flatBufferBuilder.m21507b(3, b);
        flatBufferBuilder.m21507b(4, a4);
        flatBufferBuilder.m21507b(5, b2);
        flatBufferBuilder.m21507b(6, a5);
        flatBufferBuilder.m21507b(7, b3);
        flatBufferBuilder.m21507b(8, a6);
        flatBufferBuilder.m21507b(9, a7);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLInstantArticle(Parcel parcel) {
        super(11);
        this.f16503d = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f16504e = (GraphQLInstantArticleVersion) parcel.readValue(GraphQLInstantArticleVersion.class.getClassLoader());
        this.f16505f = (GraphQLExternalUrl) parcel.readValue(GraphQLExternalUrl.class.getClassLoader());
        this.f16506g = parcel.readString();
        this.f16507h = (GraphQLInstantArticleVersion) parcel.readValue(GraphQLInstantArticleVersion.class.getClassLoader());
        this.f16512m = (GraphQLMessengerContentSubscriptionOption) parcel.readValue(GraphQLMessengerContentSubscriptionOption.class.getClassLoader());
        this.f16508i = parcel.readString();
        this.f16511l = (GraphQLInstantArticleVersion) parcel.readValue(GraphQLInstantArticleVersion.class.getClassLoader());
        this.f16509j = (GraphQLInstantArticleVersion) parcel.readValue(GraphQLInstantArticleVersion.class.getClassLoader());
        this.f16510k = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m23346j());
        parcel.writeValue(m23347k());
        parcel.writeValue(m23348l());
        parcel.writeString(m23349m());
        parcel.writeValue(m23350n());
        parcel.writeValue(m23355s());
        parcel.writeString(m23351o());
        parcel.writeValue(m23354r());
        parcel.writeValue(m23352p());
        parcel.writeString(m23353q());
    }
}
