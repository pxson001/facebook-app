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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: loadSuccessCount */
public final class GraphQLExternalUrl extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLExternalUrl> CREATOR = new 1();
    @Nullable
    String f17222A;
    @Nullable
    String f17223B;
    @Nullable
    GraphQLMessengerContentSubscriptionOption f17224C;
    @Nullable
    GraphQLExternalUrl f17225D;
    @Nullable
    GraphQLAllShareStoriesConnection f17226d;
    List<String> f17227e;
    @Nullable
    GraphQLApplication f17228f;
    @Nullable
    String f17229g;
    long f17230h;
    @Nullable
    GraphQLEmotionalAnalysis f17231i;
    @Nullable
    String f17232j;
    @Nullable
    GraphQLProfile f17233k;
    @Deprecated
    @Nullable
    GraphQLIcon f17234l;
    @Nullable
    String f17235m;
    @Nullable
    GraphQLInstantArticle f17236n;
    @Nullable
    GraphQLMedia f17237o;
    @Nullable
    String f17238p;
    List<String> f17239q;
    @Nullable
    GraphQLNode f17240r;
    @Nullable
    GraphQLPhrasesAnalysis f17241s;
    @Nullable
    GraphQLTextWithEntities f17242t;
    @Nullable
    GraphQLQuotesAnalysis f17243u;
    @Nullable
    GraphQLRating f17244v;
    @Nullable
    GraphQLTextWithEntities f17245w;
    @Nullable
    GraphQLTextWithEntities f17246x;
    @Nullable
    GraphQLTextWithEntities f17247y;
    @Nullable
    GraphQLTextWithEntities f17248z;

    @FieldOffset
    @Nullable
    public final GraphQLAllShareStoriesConnection m24281j() {
        this.f17226d = (GraphQLAllShareStoriesConnection) super.m9947a(this.f17226d, 0, GraphQLAllShareStoriesConnection.class);
        return this.f17226d;
    }

    @FieldOffset
    public final ImmutableList<String> m24282k() {
        this.f17227e = super.m9943a(this.f17227e, 1);
        return (ImmutableList) this.f17227e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLApplication m24283l() {
        this.f17228f = (GraphQLApplication) super.m9947a(this.f17228f, 2, GraphQLApplication.class);
        return this.f17228f;
    }

    @FieldOffset
    @Nullable
    public final String m24284m() {
        this.f17229g = super.m9948a(this.f17229g, 3);
        return this.f17229g;
    }

    @FieldOffset
    public final long m24285n() {
        m9949a(0, 4);
        return this.f17230h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEmotionalAnalysis m24286o() {
        this.f17231i = (GraphQLEmotionalAnalysis) super.m9947a(this.f17231i, 5, GraphQLEmotionalAnalysis.class);
        return this.f17231i;
    }

    @FieldOffset
    @Nullable
    public final String m24287p() {
        this.f17232j = super.m9948a(this.f17232j, 6);
        return this.f17232j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile m24288q() {
        this.f17233k = (GraphQLProfile) super.m9947a(this.f17233k, 7, GraphQLProfile.class);
        return this.f17233k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLIcon m24289r() {
        this.f17234l = (GraphQLIcon) super.m9947a(this.f17234l, 8, GraphQLIcon.class);
        return this.f17234l;
    }

    @FieldOffset
    @Nullable
    public final String m24290s() {
        this.f17235m = super.m9948a(this.f17235m, 9);
        return this.f17235m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInstantArticle m24291t() {
        this.f17236n = (GraphQLInstantArticle) super.m9947a(this.f17236n, 10, GraphQLInstantArticle.class);
        return this.f17236n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLMedia m24292u() {
        this.f17237o = (GraphQLMedia) super.m9947a(this.f17237o, 11, GraphQLMedia.class);
        return this.f17237o;
    }

    @FieldOffset
    @Nullable
    public final String m24293v() {
        this.f17238p = super.m9948a(this.f17238p, 12);
        return this.f17238p;
    }

    @FieldOffset
    public final ImmutableList<String> m24294w() {
        this.f17239q = super.m9943a(this.f17239q, 13);
        return (ImmutableList) this.f17239q;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNode m24295x() {
        this.f17240r = (GraphQLNode) super.m9947a(this.f17240r, 14, GraphQLNode.class);
        return this.f17240r;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhrasesAnalysis m24296y() {
        this.f17241s = (GraphQLPhrasesAnalysis) super.m9947a(this.f17241s, 15, GraphQLPhrasesAnalysis.class);
        return this.f17241s;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m24297z() {
        this.f17242t = (GraphQLTextWithEntities) super.m9947a(this.f17242t, 16, GraphQLTextWithEntities.class);
        return this.f17242t;
    }

    @FieldOffset
    @Nullable
    public final GraphQLQuotesAnalysis m24267A() {
        this.f17243u = (GraphQLQuotesAnalysis) super.m9947a(this.f17243u, 17, GraphQLQuotesAnalysis.class);
        return this.f17243u;
    }

    @FieldOffset
    @Nullable
    public final GraphQLRating m24268B() {
        this.f17244v = (GraphQLRating) super.m9947a(this.f17244v, 18, GraphQLRating.class);
        return this.f17244v;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m24269C() {
        this.f17245w = (GraphQLTextWithEntities) super.m9947a(this.f17245w, 20, GraphQLTextWithEntities.class);
        return this.f17245w;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m24270D() {
        this.f17246x = (GraphQLTextWithEntities) super.m9947a(this.f17246x, 21, GraphQLTextWithEntities.class);
        return this.f17246x;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m24271E() {
        this.f17247y = (GraphQLTextWithEntities) super.m9947a(this.f17247y, 22, GraphQLTextWithEntities.class);
        return this.f17247y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m24272F() {
        this.f17248z = (GraphQLTextWithEntities) super.m9947a(this.f17248z, 23, GraphQLTextWithEntities.class);
        return this.f17248z;
    }

    @FieldOffset
    @Nullable
    public final String m24273G() {
        this.f17222A = super.m9948a(this.f17222A, 24);
        return this.f17222A;
    }

    @FieldOffset
    @Nullable
    public final String m24274H() {
        this.f17223B = super.m9948a(this.f17223B, 25);
        return this.f17223B;
    }

    @FieldOffset
    @Nullable
    public final GraphQLMessengerContentSubscriptionOption m24275I() {
        this.f17224C = (GraphQLMessengerContentSubscriptionOption) super.m9947a(this.f17224C, 26, GraphQLMessengerContentSubscriptionOption.class);
        return this.f17224C;
    }

    @FieldOffset
    @Nullable
    public final GraphQLExternalUrl m24276J() {
        this.f17225D = (GraphQLExternalUrl) super.m9947a(this.f17225D, 27, GraphQLExternalUrl.class);
        return this.f17225D;
    }

    @Nullable
    public final String mo2834a() {
        return m24290s();
    }

    public final int jK_() {
        return 514783620;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24281j() != null) {
            GraphQLAllShareStoriesConnection graphQLAllShareStoriesConnection = (GraphQLAllShareStoriesConnection) graphQLModelMutatingVisitor.mo2928b(m24281j());
            if (m24281j() != graphQLAllShareStoriesConnection) {
                graphQLVisitableModel = (GraphQLExternalUrl) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17226d = graphQLAllShareStoriesConnection;
            }
        }
        if (m24283l() != null) {
            GraphQLApplication graphQLApplication = (GraphQLApplication) graphQLModelMutatingVisitor.mo2928b(m24283l());
            if (m24283l() != graphQLApplication) {
                graphQLVisitableModel = (GraphQLExternalUrl) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17228f = graphQLApplication;
            }
        }
        if (m24276J() != null) {
            GraphQLExternalUrl graphQLExternalUrl = (GraphQLExternalUrl) graphQLModelMutatingVisitor.mo2928b(m24276J());
            if (m24276J() != graphQLExternalUrl) {
                graphQLVisitableModel = (GraphQLExternalUrl) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17225D = graphQLExternalUrl;
            }
        }
        if (m24286o() != null) {
            GraphQLEmotionalAnalysis graphQLEmotionalAnalysis = (GraphQLEmotionalAnalysis) graphQLModelMutatingVisitor.mo2928b(m24286o());
            if (m24286o() != graphQLEmotionalAnalysis) {
                graphQLVisitableModel = (GraphQLExternalUrl) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17231i = graphQLEmotionalAnalysis;
            }
        }
        if (m24288q() != null) {
            GraphQLProfile graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.mo2928b(m24288q());
            if (m24288q() != graphQLProfile) {
                graphQLVisitableModel = (GraphQLExternalUrl) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17233k = graphQLProfile;
            }
        }
        if (m24289r() != null) {
            GraphQLIcon graphQLIcon = (GraphQLIcon) graphQLModelMutatingVisitor.mo2928b(m24289r());
            if (m24289r() != graphQLIcon) {
                graphQLVisitableModel = (GraphQLExternalUrl) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17234l = graphQLIcon;
            }
        }
        if (m24291t() != null) {
            GraphQLInstantArticle graphQLInstantArticle = (GraphQLInstantArticle) graphQLModelMutatingVisitor.mo2928b(m24291t());
            if (m24291t() != graphQLInstantArticle) {
                graphQLVisitableModel = (GraphQLExternalUrl) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17236n = graphQLInstantArticle;
            }
        }
        if (m24292u() != null) {
            GraphQLMedia graphQLMedia = (GraphQLMedia) graphQLModelMutatingVisitor.mo2928b(m24292u());
            if (m24292u() != graphQLMedia) {
                graphQLVisitableModel = (GraphQLExternalUrl) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17237o = graphQLMedia;
            }
        }
        if (m24275I() != null) {
            GraphQLMessengerContentSubscriptionOption graphQLMessengerContentSubscriptionOption = (GraphQLMessengerContentSubscriptionOption) graphQLModelMutatingVisitor.mo2928b(m24275I());
            if (m24275I() != graphQLMessengerContentSubscriptionOption) {
                graphQLVisitableModel = (GraphQLExternalUrl) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17224C = graphQLMessengerContentSubscriptionOption;
            }
        }
        if (m24295x() != null) {
            GraphQLNode graphQLNode = (GraphQLNode) graphQLModelMutatingVisitor.mo2928b(m24295x());
            if (m24295x() != graphQLNode) {
                graphQLVisitableModel = (GraphQLExternalUrl) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17240r = graphQLNode;
            }
        }
        if (m24296y() != null) {
            GraphQLPhrasesAnalysis graphQLPhrasesAnalysis = (GraphQLPhrasesAnalysis) graphQLModelMutatingVisitor.mo2928b(m24296y());
            if (m24296y() != graphQLPhrasesAnalysis) {
                graphQLVisitableModel = (GraphQLExternalUrl) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17241s = graphQLPhrasesAnalysis;
            }
        }
        if (m24297z() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m24297z());
            if (m24297z() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLExternalUrl) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17242t = graphQLTextWithEntities;
            }
        }
        if (m24267A() != null) {
            GraphQLQuotesAnalysis graphQLQuotesAnalysis = (GraphQLQuotesAnalysis) graphQLModelMutatingVisitor.mo2928b(m24267A());
            if (m24267A() != graphQLQuotesAnalysis) {
                graphQLVisitableModel = (GraphQLExternalUrl) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17243u = graphQLQuotesAnalysis;
            }
        }
        if (m24268B() != null) {
            GraphQLRating graphQLRating = (GraphQLRating) graphQLModelMutatingVisitor.mo2928b(m24268B());
            if (m24268B() != graphQLRating) {
                graphQLVisitableModel = (GraphQLExternalUrl) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17244v = graphQLRating;
            }
        }
        if (m24269C() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m24269C());
            if (m24269C() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLExternalUrl) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17245w = graphQLTextWithEntities;
            }
        }
        if (m24270D() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m24270D());
            if (m24270D() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLExternalUrl) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17246x = graphQLTextWithEntities;
            }
        }
        if (m24271E() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m24271E());
            if (m24271E() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLExternalUrl) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17247y = graphQLTextWithEntities;
            }
        }
        if (m24272F() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m24272F());
            if (m24272F() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLExternalUrl) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17248z = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLExternalUrl() {
        super(29);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17230h = mutableFlatBuffer.m21525a(i, 4, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m24281j());
        int c = flatBufferBuilder.m21509c(m24282k());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24283l());
        int b = flatBufferBuilder.m21502b(m24284m());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m24286o());
        int b2 = flatBufferBuilder.m21502b(m24287p());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m24288q());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m24289r());
        int b3 = flatBufferBuilder.m21502b(m24290s());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m24291t());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m24292u());
        int b4 = flatBufferBuilder.m21502b(m24293v());
        int c2 = flatBufferBuilder.m21509c(m24294w());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m24295x());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, m24296y());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, m24297z());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, m24267A());
        int a12 = ModelHelper.m23093a(flatBufferBuilder, m24268B());
        int a13 = ModelHelper.m23093a(flatBufferBuilder, m24269C());
        int a14 = ModelHelper.m23093a(flatBufferBuilder, m24270D());
        int a15 = ModelHelper.m23093a(flatBufferBuilder, m24271E());
        int a16 = ModelHelper.m23093a(flatBufferBuilder, m24272F());
        int b5 = flatBufferBuilder.m21502b(m24273G());
        int b6 = flatBufferBuilder.m21502b(m24274H());
        int a17 = ModelHelper.m23093a(flatBufferBuilder, m24275I());
        int a18 = ModelHelper.m23093a(flatBufferBuilder, m24276J());
        flatBufferBuilder.m21510c(28);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, c);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21507b(3, b);
        flatBufferBuilder.m21495a(4, m24285n(), 0);
        flatBufferBuilder.m21507b(5, a3);
        flatBufferBuilder.m21507b(6, b2);
        flatBufferBuilder.m21507b(7, a4);
        flatBufferBuilder.m21507b(8, a5);
        flatBufferBuilder.m21507b(9, b3);
        flatBufferBuilder.m21507b(10, a6);
        flatBufferBuilder.m21507b(11, a7);
        flatBufferBuilder.m21507b(12, b4);
        flatBufferBuilder.m21507b(13, c2);
        flatBufferBuilder.m21507b(14, a8);
        flatBufferBuilder.m21507b(15, a9);
        flatBufferBuilder.m21507b(16, a10);
        flatBufferBuilder.m21507b(17, a11);
        flatBufferBuilder.m21507b(18, a12);
        flatBufferBuilder.m21507b(20, a13);
        flatBufferBuilder.m21507b(21, a14);
        flatBufferBuilder.m21507b(22, a15);
        flatBufferBuilder.m21507b(23, a16);
        flatBufferBuilder.m21507b(24, b5);
        flatBufferBuilder.m21507b(25, b6);
        flatBufferBuilder.m21507b(26, a17);
        flatBufferBuilder.m21507b(27, a18);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLExternalUrl(Parcel parcel) {
        super(29);
        this.f17226d = (GraphQLAllShareStoriesConnection) parcel.readValue(GraphQLAllShareStoriesConnection.class.getClassLoader());
        this.f17227e = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f17228f = (GraphQLApplication) parcel.readValue(GraphQLApplication.class.getClassLoader());
        this.f17229g = parcel.readString();
        this.f17225D = (GraphQLExternalUrl) parcel.readValue(GraphQLExternalUrl.class.getClassLoader());
        this.f17230h = parcel.readLong();
        this.f17231i = (GraphQLEmotionalAnalysis) parcel.readValue(GraphQLEmotionalAnalysis.class.getClassLoader());
        this.f17232j = parcel.readString();
        this.f17233k = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
        this.f17234l = (GraphQLIcon) parcel.readValue(GraphQLIcon.class.getClassLoader());
        this.f17235m = parcel.readString();
        this.f17236n = (GraphQLInstantArticle) parcel.readValue(GraphQLInstantArticle.class.getClassLoader());
        this.f17237o = (GraphQLMedia) parcel.readValue(GraphQLMedia.class.getClassLoader());
        this.f17224C = (GraphQLMessengerContentSubscriptionOption) parcel.readValue(GraphQLMessengerContentSubscriptionOption.class.getClassLoader());
        this.f17238p = parcel.readString();
        this.f17239q = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f17240r = (GraphQLNode) parcel.readValue(GraphQLNode.class.getClassLoader());
        this.f17241s = (GraphQLPhrasesAnalysis) parcel.readValue(GraphQLPhrasesAnalysis.class.getClassLoader());
        this.f17242t = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f17243u = (GraphQLQuotesAnalysis) parcel.readValue(GraphQLQuotesAnalysis.class.getClassLoader());
        this.f17244v = (GraphQLRating) parcel.readValue(GraphQLRating.class.getClassLoader());
        this.f17245w = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f17246x = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f17247y = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f17248z = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f17222A = parcel.readString();
        this.f17223B = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m24281j());
        parcel.writeList(m24282k());
        parcel.writeValue(m24283l());
        parcel.writeString(m24284m());
        parcel.writeValue(m24276J());
        parcel.writeLong(m24285n());
        parcel.writeValue(m24286o());
        parcel.writeString(m24287p());
        parcel.writeValue(m24288q());
        parcel.writeValue(m24289r());
        parcel.writeString(m24290s());
        parcel.writeValue(m24291t());
        parcel.writeValue(m24292u());
        parcel.writeValue(m24275I());
        parcel.writeString(m24293v());
        parcel.writeList(m24294w());
        parcel.writeValue(m24295x());
        parcel.writeValue(m24296y());
        parcel.writeValue(m24297z());
        parcel.writeValue(m24267A());
        parcel.writeValue(m24268B());
        parcel.writeValue(m24269C());
        parcel.writeValue(m24270D());
        parcel.writeValue(m24271E());
        parcel.writeValue(m24272F());
        parcel.writeString(m24273G());
        parcel.writeString(m24274H());
    }
}
