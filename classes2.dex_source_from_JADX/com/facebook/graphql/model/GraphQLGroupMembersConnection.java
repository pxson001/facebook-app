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
/* compiled from: lo */
public final class GraphQLGroupMembersConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGroupMembersConnection> CREATOR = new 1();
    public int f17253d;
    public List<GraphQLGroupMembersEdge> f17254e;
    public List<GraphQLUser> f17255f;
    @Nullable
    public GraphQLPageInfo f17256g;

    @FieldOffset
    public final int m24305a() {
        m9949a(0, 0);
        return this.f17253d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLGroupMembersEdge> m24309j() {
        this.f17254e = super.m9944a(this.f17254e, 1, GraphQLGroupMembersEdge.class);
        return (ImmutableList) this.f17254e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLUser> m24310k() {
        this.f17255f = super.m9944a(this.f17255f, 2, GraphQLUser.class);
        return (ImmutableList) this.f17255f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m24311l() {
        this.f17256g = (GraphQLPageInfo) super.m9947a(this.f17256g, 3, GraphQLPageInfo.class);
        return this.f17256g;
    }

    public final int jK_() {
        return 103365688;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24309j() != null) {
            a = ModelHelper.m23097a(m24309j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLGroupMembersConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17254e = a.m1068b();
            }
        }
        if (m24310k() != null) {
            a = ModelHelper.m23097a(m24310k(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLGroupMembersConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17255f = a.m1068b();
            }
        }
        GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
        if (m24311l() != null) {
            GraphQLPageInfo graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m24311l());
            if (m24311l() != graphQLPageInfo) {
                graphQLVisitableModel2 = (GraphQLGroupMembersConnection) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f17256g = graphQLPageInfo;
            }
        }
        m9959i();
        return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
    }

    public GraphQLGroupMembersConnection() {
        super(5);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17253d = mutableFlatBuffer.m21524a(i, 0, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m24309j());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m24310k());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m24311l());
        flatBufferBuilder.m21510c(4);
        flatBufferBuilder.m21494a(0, m24305a(), 0);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21507b(3, a3);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLGroupMembersConnection(Parcel parcel) {
        super(5);
        this.f17253d = parcel.readInt();
        this.f17254e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLGroupMembersEdge.class.getClassLoader()));
        this.f17255f = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLUser.class.getClassLoader()));
        this.f17256g = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m24305a());
        parcel.writeList(m24309j());
        parcel.writeList(m24310k());
        parcel.writeValue(m24311l());
    }
}
