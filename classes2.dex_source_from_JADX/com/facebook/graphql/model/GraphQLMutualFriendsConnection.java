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
/* compiled from: linear_composer_next_button_nux */
public final class GraphQLMutualFriendsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLMutualFriendsConnection> CREATOR = new 1();
    public int f17482d;
    public List<GraphQLUser> f17483e;
    @Nullable
    public GraphQLPageInfo f17484f;

    @FieldOffset
    public final int m24589a() {
        m9949a(0, 0);
        return this.f17482d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLUser> m24593j() {
        this.f17483e = super.m9944a(this.f17483e, 1, GraphQLUser.class);
        return (ImmutableList) this.f17483e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m24594k() {
        this.f17484f = (GraphQLPageInfo) super.m9947a(this.f17484f, 2, GraphQLPageInfo.class);
        return this.f17484f;
    }

    public final int jK_() {
        return 1532278911;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        m9958h();
        if (m24593j() != null) {
            Builder a = ModelHelper.m23097a(m24593j(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLMutualFriendsConnection graphQLMutualFriendsConnection = (GraphQLMutualFriendsConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLMutualFriendsConnection.f17483e = a.m1068b();
                graphQLVisitableModel = graphQLMutualFriendsConnection;
                if (m24594k() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m24594k());
                    if (m24594k() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLMutualFriendsConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17484f = graphQLPageInfo;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m24594k() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m24594k());
            if (m24594k() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLMutualFriendsConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17484f = graphQLPageInfo;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLMutualFriendsConnection() {
        super(4);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17482d = mutableFlatBuffer.m21524a(i, 0, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m24593j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24594k());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21494a(0, m24589a(), 0);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLMutualFriendsConnection(Parcel parcel) {
        super(4);
        this.f17482d = parcel.readInt();
        this.f17483e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLUser.class.getClassLoader()));
        this.f17484f = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m24589a());
        parcel.writeList(m24593j());
        parcel.writeValue(m24594k());
    }

    public GraphQLMutualFriendsConnection(Builder builder) {
        super(4);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f17482d = builder.d;
        this.f17483e = builder.e;
        this.f17484f = builder.f;
    }
}
