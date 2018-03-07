package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: inspired.facebook.com */
public final class GraphQLTopReactionsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLTopReactionsEdge> CREATOR = new C07921();
    @Nullable
    GraphQLFeedbackReactionInfo f19823d;
    int f19824e;

    /* compiled from: inspired.facebook.com */
    final class C07921 implements Creator<GraphQLTopReactionsEdge> {
        C07921() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLTopReactionsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLTopReactionsEdge[i];
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedbackReactionInfo m27550a() {
        this.f19823d = (GraphQLFeedbackReactionInfo) super.m9947a(this.f19823d, 0, GraphQLFeedbackReactionInfo.class);
        return this.f19823d;
    }

    @FieldOffset
    public final int m27553j() {
        m9949a(0, 1);
        return this.f19824e;
    }

    public final int jK_() {
        return -1719612142;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m27550a() != null) {
            GraphQLFeedbackReactionInfo graphQLFeedbackReactionInfo = (GraphQLFeedbackReactionInfo) graphQLModelMutatingVisitor.mo2928b(m27550a());
            if (m27550a() != graphQLFeedbackReactionInfo) {
                graphQLVisitableModel = (GraphQLTopReactionsEdge) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19823d = graphQLFeedbackReactionInfo;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLTopReactionsEdge() {
        super(3);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f19824e = mutableFlatBuffer.m21524a(i, 1, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m27550a());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21494a(1, m27553j(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLTopReactionsEdge(Parcel parcel) {
        super(3);
        this.f19823d = (GraphQLFeedbackReactionInfo) parcel.readValue(GraphQLFeedbackReactionInfo.class.getClassLoader());
        this.f19824e = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m27550a());
        parcel.writeInt(m27553j());
    }

    public GraphQLTopReactionsEdge(Builder builder) {
        super(3);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f19823d = builder.d;
        this.f19824e = builder.e;
    }
}
