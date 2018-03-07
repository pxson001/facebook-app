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
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces$DefaultFeedbackFields.Likers;
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
/* compiled from: lowMemoryOptimizationThresholdMb */
public final class GraphQLLikersOfContentConnection extends BaseModel implements TypeModel, Likers, GraphQLVisitableModel {
    public static final Creator<GraphQLLikersOfContentConnection> CREATOR = new C06901();
    public int f15923d;
    public List<GraphQLActor> f15924e;
    @Nullable
    public GraphQLPageInfo f15925f;

    /* compiled from: lowMemoryOptimizationThresholdMb */
    final class C06901 implements Creator<GraphQLLikersOfContentConnection> {
        C06901() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLLikersOfContentConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLLikersOfContentConnection[i];
        }
    }

    @FieldOffset
    public final int mo2914a() {
        m9949a(0, 0);
        return this.f15923d;
    }

    public final void mo2908a(int i) {
        this.f15923d = i;
        if (this.f5823b != null && this.f5823b.f15024d) {
            this.f5823b.m21544b(this.f5824c, 0, i);
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLActor> m22668j() {
        this.f15924e = super.m9944a(this.f15924e, 1, GraphQLActor.class);
        return (ImmutableList) this.f15924e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m22669k() {
        this.f15925f = (GraphQLPageInfo) super.m9947a(this.f15925f, 2, GraphQLPageInfo.class);
        return this.f15925f;
    }

    public final int jK_() {
        return 733369288;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        m9958h();
        if (m22668j() != null) {
            Builder a = ModelHelper.m23097a(m22668j(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLLikersOfContentConnection graphQLLikersOfContentConnection = (GraphQLLikersOfContentConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLLikersOfContentConnection.f15924e = a.m1068b();
                graphQLVisitableModel = graphQLLikersOfContentConnection;
                if (m22669k() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m22669k());
                    if (m22669k() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLLikersOfContentConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f15925f = graphQLPageInfo;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m22669k() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m22669k());
            if (m22669k() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLLikersOfContentConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15925f = graphQLPageInfo;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLLikersOfContentConnection() {
        super(4);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f15923d = mutableFlatBuffer.m21524a(i, 0, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m22668j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m22669k());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21494a(0, mo2914a(), 0);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLLikersOfContentConnection(Parcel parcel) {
        super(4);
        this.f15923d = parcel.readInt();
        this.f15924e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLActor.class.getClassLoader()));
        this.f15925f = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mo2914a());
        parcel.writeList(m22668j());
        parcel.writeValue(m22669k());
    }

    public GraphQLLikersOfContentConnection(Builder builder) {
        super(4);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f15923d = builder.d;
        this.f15924e = builder.e;
        this.f15925f = builder.f;
    }
}
