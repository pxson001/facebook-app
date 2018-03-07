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
/* compiled from: mFragmentManager= */
public final class GraphQLNewsFeedConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLNewsFeedConnection> CREATOR = new C06711();
    @Nullable
    String f15583d;
    List<GraphQLNewsFeedEdge> f15584e;
    boolean f15585f;
    @Nullable
    GraphQLPageInfo f15586g;

    /* compiled from: mFragmentManager= */
    final class C06711 implements Creator<GraphQLNewsFeedConnection> {
        C06711() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLNewsFeedConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLNewsFeedConnection[i];
        }
    }

    @FieldOffset
    @Nullable
    public final String m22214a() {
        this.f15583d = super.m9948a(this.f15583d, 0);
        return this.f15583d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLNewsFeedEdge> m22216j() {
        this.f15584e = super.m9944a(this.f15584e, 1, GraphQLNewsFeedEdge.class);
        return (ImmutableList) this.f15584e;
    }

    @FieldOffset
    public final boolean m22217k() {
        m9949a(0, 2);
        return this.f15585f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m22218l() {
        this.f15586g = (GraphQLPageInfo) super.m9947a(this.f15586g, 3, GraphQLPageInfo.class);
        return this.f15586g;
    }

    public final int jK_() {
        return 1194293487;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        m9958h();
        if (m22216j() != null) {
            Builder a = ModelHelper.m23097a(m22216j(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLNewsFeedConnection graphQLNewsFeedConnection = (GraphQLNewsFeedConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLNewsFeedConnection.f15584e = a.m1068b();
                graphQLVisitableModel = graphQLNewsFeedConnection;
                if (m22218l() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m22218l());
                    if (m22218l() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLNewsFeedConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f15586g = graphQLPageInfo;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m22218l() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m22218l());
            if (m22218l() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLNewsFeedConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15586g = graphQLPageInfo;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLNewsFeedConnection() {
        super(5);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f15585f = mutableFlatBuffer.m21540a(i, 2);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m22214a());
        int a = ModelHelper.m23094a(flatBufferBuilder, m22216j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m22218l());
        flatBufferBuilder.m21510c(4);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21498a(2, m22217k());
        flatBufferBuilder.m21507b(3, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLNewsFeedConnection(Parcel parcel) {
        boolean z = true;
        super(5);
        this.f15583d = parcel.readString();
        this.f15584e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLNewsFeedEdge.class.getClassLoader()));
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f15585f = z;
        this.f15586g = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m22214a());
        parcel.writeList(m22216j());
        parcel.writeByte((byte) (m22217k() ? 1 : 0));
        parcel.writeValue(m22218l());
    }
}
