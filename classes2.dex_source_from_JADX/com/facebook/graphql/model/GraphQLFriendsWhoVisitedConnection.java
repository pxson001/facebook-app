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
/* compiled from: getSsoUserMethod */
public final class GraphQLFriendsWhoVisitedConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLFriendsWhoVisitedConnection> CREATOR = new 1();
    public int f22519d;
    public List<GraphQLFriendsWhoVisitedEdge> f22520e;
    public List<GraphQLUser> f22521f;
    @Nullable
    public GraphQLTextWithEntities f22522g;

    @FieldOffset
    public final int m30395a() {
        m9949a(0, 0);
        return this.f22519d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLFriendsWhoVisitedEdge> m30399j() {
        this.f22520e = super.m9944a(this.f22520e, 1, GraphQLFriendsWhoVisitedEdge.class);
        return (ImmutableList) this.f22520e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLUser> m30400k() {
        this.f22521f = super.m9944a(this.f22521f, 2, GraphQLUser.class);
        return (ImmutableList) this.f22521f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m30401l() {
        this.f22522g = (GraphQLTextWithEntities) super.m9947a(this.f22522g, 3, GraphQLTextWithEntities.class);
        return this.f22522g;
    }

    public final int jK_() {
        return -404188513;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m30399j() != null) {
            a = ModelHelper.m23097a(m30399j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLFriendsWhoVisitedConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f22520e = a.m1068b();
            }
        }
        if (m30400k() != null) {
            a = ModelHelper.m23097a(m30400k(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLFriendsWhoVisitedConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f22521f = a.m1068b();
            }
        }
        GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
        if (m30401l() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m30401l());
            if (m30401l() != graphQLTextWithEntities) {
                graphQLVisitableModel2 = (GraphQLFriendsWhoVisitedConnection) ModelHelper.m23095a(graphQLVisitableModel2, (GraphQLVisitableModel) this);
                graphQLVisitableModel2.f22522g = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
    }

    public GraphQLFriendsWhoVisitedConnection() {
        super(5);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f22519d = mutableFlatBuffer.m21524a(i, 0, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m30399j());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m30400k());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m30401l());
        flatBufferBuilder.m21510c(4);
        flatBufferBuilder.m21494a(0, m30395a(), 0);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21507b(3, a3);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLFriendsWhoVisitedConnection(Parcel parcel) {
        super(5);
        this.f22519d = parcel.readInt();
        this.f22520e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLFriendsWhoVisitedEdge.class.getClassLoader()));
        this.f22521f = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLUser.class.getClassLoader()));
        this.f22522g = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m30395a());
        parcel.writeList(m30399j());
        parcel.writeList(m30400k());
        parcel.writeValue(m30401l());
    }
}
