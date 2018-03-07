package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLBrowserPrefetchType;
import com.facebook.graphql.enums.GraphQLFeedbackReadLikelihood;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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
/* compiled from: local_addr */
public final class GraphQLFeedbackContext extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLFeedbackContext> CREATOR = new C07961();
    @Nullable
    GraphQLFeedback f17173d;
    List<GraphQLComment> f17174e;
    GraphQLBrowserPrefetchType f17175f;
    int f17176g;
    List<GraphQLComment> f17177h;
    GraphQLFeedbackReadLikelihood f17178i;
    List<GraphQLComment> f17179j;
    int f17180k;
    @Nullable
    GraphQLRelevantReactorsConnection f17181l;
    List<GraphQLFeedback> f17182m;

    /* compiled from: local_addr */
    final class C07961 implements Creator<GraphQLFeedbackContext> {
        C07961() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLFeedbackContext(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLFeedbackContext[i];
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback m24197a() {
        this.f17173d = (GraphQLFeedback) super.m9947a(this.f17173d, 0, GraphQLFeedback.class);
        return this.f17173d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLComment> m24200j() {
        this.f17174e = super.m9944a(this.f17174e, 1, GraphQLComment.class);
        return (ImmutableList) this.f17174e;
    }

    @FieldOffset
    public final GraphQLBrowserPrefetchType m24201k() {
        this.f17175f = (GraphQLBrowserPrefetchType) super.m9945a(this.f17175f, 2, GraphQLBrowserPrefetchType.class, GraphQLBrowserPrefetchType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17175f;
    }

    @FieldOffset
    public final int m24202l() {
        m9949a(0, 3);
        return this.f17176g;
    }

    @FieldOffset
    public final ImmutableList<GraphQLComment> m24203m() {
        this.f17177h = super.m9944a(this.f17177h, 5, GraphQLComment.class);
        return (ImmutableList) this.f17177h;
    }

    @FieldOffset
    public final GraphQLFeedbackReadLikelihood m24204n() {
        this.f17178i = (GraphQLFeedbackReadLikelihood) super.m9945a(this.f17178i, 6, GraphQLFeedbackReadLikelihood.class, GraphQLFeedbackReadLikelihood.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17178i;
    }

    @FieldOffset
    public final ImmutableList<GraphQLComment> m24205o() {
        this.f17179j = super.m9944a(this.f17179j, 7, GraphQLComment.class);
        return (ImmutableList) this.f17179j;
    }

    @FieldOffset
    public final int m24206p() {
        m9949a(1, 0);
        return this.f17180k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLRelevantReactorsConnection m24207q() {
        this.f17181l = (GraphQLRelevantReactorsConnection) super.m9947a(this.f17181l, 9, GraphQLRelevantReactorsConnection.class);
        return this.f17181l;
    }

    @FieldOffset
    public final ImmutableList<GraphQLFeedback> m24208r() {
        this.f17182m = super.m9944a(this.f17182m, 10, GraphQLFeedback.class);
        return (ImmutableList) this.f17182m;
    }

    public final int jK_() {
        return -1233483190;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24197a() != null) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.mo2928b(m24197a());
            if (m24197a() != graphQLFeedback) {
                graphQLVisitableModel = (GraphQLFeedbackContext) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17173d = graphQLFeedback;
            }
        }
        if (m24208r() != null) {
            a = ModelHelper.m23097a(m24208r(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLFeedbackContext graphQLFeedbackContext = (GraphQLFeedbackContext) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLFeedbackContext.f17182m = a.m1068b();
                graphQLVisitableModel = graphQLFeedbackContext;
            }
        }
        if (m24200j() != null) {
            a = ModelHelper.m23097a(m24200j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLFeedbackContext = (GraphQLFeedbackContext) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLFeedbackContext.f17174e = a.m1068b();
                graphQLVisitableModel = graphQLFeedbackContext;
            }
        }
        if (m24203m() != null) {
            a = ModelHelper.m23097a(m24203m(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLFeedbackContext = (GraphQLFeedbackContext) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLFeedbackContext.f17177h = a.m1068b();
                graphQLVisitableModel = graphQLFeedbackContext;
            }
        }
        if (m24205o() != null) {
            a = ModelHelper.m23097a(m24205o(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLFeedbackContext = (GraphQLFeedbackContext) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLFeedbackContext.f17179j = a.m1068b();
                graphQLVisitableModel = graphQLFeedbackContext;
            }
        }
        if (m24207q() != null) {
            GraphQLRelevantReactorsConnection graphQLRelevantReactorsConnection = (GraphQLRelevantReactorsConnection) graphQLModelMutatingVisitor.mo2928b(m24207q());
            if (m24207q() != graphQLRelevantReactorsConnection) {
                graphQLVisitableModel = (GraphQLFeedbackContext) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17181l = graphQLRelevantReactorsConnection;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLFeedbackContext() {
        super(12);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17176g = mutableFlatBuffer.m21524a(i, 3, 0);
        this.f17180k = mutableFlatBuffer.m21524a(i, 8, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        Enum enumR = null;
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m24197a());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m24200j());
        int a3 = ModelHelper.m23094a(flatBufferBuilder, m24203m());
        int a4 = ModelHelper.m23094a(flatBufferBuilder, m24205o());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m24207q());
        int a6 = ModelHelper.m23094a(flatBufferBuilder, m24208r());
        flatBufferBuilder.m21510c(11);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21496a(2, m24201k() == GraphQLBrowserPrefetchType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m24201k());
        flatBufferBuilder.m21494a(3, m24202l(), 0);
        flatBufferBuilder.m21507b(5, a3);
        if (m24204n() != GraphQLFeedbackReadLikelihood.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            enumR = m24204n();
        }
        flatBufferBuilder.m21496a(6, enumR);
        flatBufferBuilder.m21507b(7, a4);
        flatBufferBuilder.m21494a(8, m24206p(), 0);
        flatBufferBuilder.m21507b(9, a5);
        flatBufferBuilder.m21507b(10, a6);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLFeedbackContext(Parcel parcel) {
        super(12);
        this.f17173d = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f17182m = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLFeedback.class.getClassLoader()));
        this.f17174e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLComment.class.getClassLoader()));
        this.f17175f = GraphQLBrowserPrefetchType.fromString(parcel.readString());
        this.f17176g = parcel.readInt();
        this.f17180k = parcel.readInt();
        this.f17177h = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLComment.class.getClassLoader()));
        this.f17178i = GraphQLFeedbackReadLikelihood.fromString(parcel.readString());
        this.f17179j = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLComment.class.getClassLoader()));
        this.f17181l = (GraphQLRelevantReactorsConnection) parcel.readValue(GraphQLRelevantReactorsConnection.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m24197a());
        parcel.writeList(m24208r());
        parcel.writeList(m24200j());
        parcel.writeString(m24201k().name());
        parcel.writeInt(m24202l());
        parcel.writeInt(m24206p());
        parcel.writeList(m24203m());
        parcel.writeString(m24204n().name());
        parcel.writeList(m24205o());
        parcel.writeValue(m24207q());
    }
}
