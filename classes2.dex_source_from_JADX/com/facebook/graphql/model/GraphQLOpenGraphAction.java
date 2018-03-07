package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
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
/* compiled from: localsell_message/ */
public final class GraphQLOpenGraphAction extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLOpenGraphAction> CREATOR = new 1();
    List<String> f16786d;
    @Nullable
    GraphQLApplication f16787e;
    @Deprecated
    @Nullable
    GraphQLFeedback f16788f;
    @Nullable
    String f16789g;
    @Nullable
    GraphQLNode f16790h;
    @Nullable
    String f16791i;

    @FieldOffset
    public final ImmutableList<String> m23731j() {
        this.f16786d = super.m9943a(this.f16786d, 0);
        return (ImmutableList) this.f16786d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLApplication m23732k() {
        this.f16787e = (GraphQLApplication) super.m9947a(this.f16787e, 1, GraphQLApplication.class);
        return this.f16787e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback m23733l() {
        this.f16788f = (GraphQLFeedback) super.m9947a(this.f16788f, 2, GraphQLFeedback.class);
        return this.f16788f;
    }

    @FieldOffset
    @Nullable
    public final String m23734m() {
        this.f16789g = super.m9948a(this.f16789g, 3);
        return this.f16789g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNode m23735n() {
        this.f16790h = (GraphQLNode) super.m9947a(this.f16790h, 4, GraphQLNode.class);
        return this.f16790h;
    }

    @FieldOffset
    @Nullable
    public final String m23736o() {
        this.f16791i = super.m9948a(this.f16791i, 5);
        return this.f16791i;
    }

    @Nullable
    public final String mo2834a() {
        return m23734m();
    }

    public final int jK_() {
        return -1703624614;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23732k() != null) {
            GraphQLApplication graphQLApplication = (GraphQLApplication) graphQLModelMutatingVisitor.mo2928b(m23732k());
            if (m23732k() != graphQLApplication) {
                graphQLVisitableModel = (GraphQLOpenGraphAction) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16787e = graphQLApplication;
            }
        }
        if (m23733l() != null) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.mo2928b(m23733l());
            if (m23733l() != graphQLFeedback) {
                graphQLVisitableModel = (GraphQLOpenGraphAction) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16788f = graphQLFeedback;
            }
        }
        if (m23735n() != null) {
            GraphQLNode graphQLNode = (GraphQLNode) graphQLModelMutatingVisitor.mo2928b(m23735n());
            if (m23735n() != graphQLNode) {
                graphQLVisitableModel = (GraphQLOpenGraphAction) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16790h = graphQLNode;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLOpenGraphAction() {
        super(7);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int c = flatBufferBuilder.m21509c(m23731j());
        int a = ModelHelper.m23093a(flatBufferBuilder, m23732k());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23733l());
        int b = flatBufferBuilder.m21502b(m23734m());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m23735n());
        int b2 = flatBufferBuilder.m21502b(m23736o());
        flatBufferBuilder.m21510c(6);
        flatBufferBuilder.m21507b(0, c);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21507b(3, b);
        flatBufferBuilder.m21507b(4, a3);
        flatBufferBuilder.m21507b(5, b2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLOpenGraphAction(Parcel parcel) {
        super(7);
        this.f16786d = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f16787e = (GraphQLApplication) parcel.readValue(GraphQLApplication.class.getClassLoader());
        this.f16788f = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f16789g = parcel.readString();
        this.f16790h = (GraphQLNode) parcel.readValue(GraphQLNode.class.getClassLoader());
        this.f16791i = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m23731j());
        parcel.writeValue(m23732k());
        parcel.writeValue(m23733l());
        parcel.writeString(m23734m());
        parcel.writeValue(m23735n());
        parcel.writeString(m23736o());
    }
}
