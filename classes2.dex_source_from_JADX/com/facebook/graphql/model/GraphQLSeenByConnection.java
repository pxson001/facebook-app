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
/* compiled from: lifecycle  */
public final class GraphQLSeenByConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLSeenByConnection> CREATOR = new 1();
    public int f17623d;
    public List<GraphQLActor> f17624e;
    @Nullable
    public GraphQLPageInfo f17625f;

    @FieldOffset
    public final int m24792a() {
        m9949a(0, 0);
        return this.f17623d;
    }

    final void mo2908a(int i) {
        this.f17623d = i;
        if (this.f5823b != null && this.f5823b.f15024d) {
            this.f5823b.m21544b(this.f5824c, 0, i);
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLActor> m24797j() {
        this.f17624e = super.m9944a(this.f17624e, 1, GraphQLActor.class);
        return (ImmutableList) this.f17624e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m24798k() {
        this.f17625f = (GraphQLPageInfo) super.m9947a(this.f17625f, 2, GraphQLPageInfo.class);
        return this.f17625f;
    }

    public final int jK_() {
        return -752571184;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        m9958h();
        if (m24797j() != null) {
            Builder a = ModelHelper.m23097a(m24797j(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLSeenByConnection graphQLSeenByConnection = (GraphQLSeenByConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLSeenByConnection.f17624e = a.m1068b();
                graphQLVisitableModel = graphQLSeenByConnection;
                if (m24798k() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m24798k());
                    if (m24798k() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLSeenByConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17625f = graphQLPageInfo;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m24798k() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m24798k());
            if (m24798k() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLSeenByConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17625f = graphQLPageInfo;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLSeenByConnection() {
        super(4);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17623d = mutableFlatBuffer.m21524a(i, 0, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m24797j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24798k());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21494a(0, m24792a(), 0);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLSeenByConnection(Parcel parcel) {
        super(4);
        this.f17623d = parcel.readInt();
        this.f17624e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLActor.class.getClassLoader()));
        this.f17625f = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m24792a());
        parcel.writeList(m24797j());
        parcel.writeValue(m24798k());
    }
}
