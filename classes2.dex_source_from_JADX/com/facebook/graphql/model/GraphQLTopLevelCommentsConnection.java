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
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces$DefaultFeedbackFields.TopLevelComments;
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
/* compiled from: lte_mnc */
public final class GraphQLTopLevelCommentsConnection extends BaseModel implements TypeModel, TopLevelComments, GraphQLVisitableModel {
    public static final Creator<GraphQLTopLevelCommentsConnection> CREATOR = new C06811();
    int f15863d;
    List<GraphQLComment> f15864e;
    @Nullable
    GraphQLPageInfo f15865f;
    int f15866g;

    /* compiled from: lte_mnc */
    final class C06811 implements Creator<GraphQLTopLevelCommentsConnection> {
        C06811() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLTopLevelCommentsConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLTopLevelCommentsConnection[i];
        }
    }

    @FieldOffset
    public final int mo2909a() {
        m9949a(0, 0);
        return this.f15863d;
    }

    public final void mo2908a(int i) {
        this.f15863d = i;
        if (this.f5823b != null && this.f5823b.f15024d) {
            this.f5823b.m21544b(this.f5824c, 0, i);
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLComment> m22600j() {
        this.f15864e = super.m9944a(this.f15864e, 1, GraphQLComment.class);
        return (ImmutableList) this.f15864e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m22601k() {
        this.f15865f = (GraphQLPageInfo) super.m9947a(this.f15865f, 2, GraphQLPageInfo.class);
        return this.f15865f;
    }

    @FieldOffset
    public final int mo2910b() {
        m9949a(0, 3);
        return this.f15866g;
    }

    final void m22599b(int i) {
        this.f15866g = i;
        if (this.f5823b != null && this.f5823b.f15024d) {
            this.f5823b.m21544b(this.f5824c, 3, i);
        }
    }

    public final int jK_() {
        return 899897761;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        m9958h();
        if (m22600j() != null) {
            Builder a = ModelHelper.m23097a(m22600j(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLTopLevelCommentsConnection graphQLTopLevelCommentsConnection = (GraphQLTopLevelCommentsConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLTopLevelCommentsConnection.f15864e = a.m1068b();
                graphQLVisitableModel = graphQLTopLevelCommentsConnection;
                if (m22601k() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m22601k());
                    if (m22601k() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLTopLevelCommentsConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f15865f = graphQLPageInfo;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m22601k() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m22601k());
            if (m22601k() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLTopLevelCommentsConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15865f = graphQLPageInfo;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLTopLevelCommentsConnection() {
        super(5);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f15863d = mutableFlatBuffer.m21524a(i, 0, 0);
        this.f15866g = mutableFlatBuffer.m21524a(i, 3, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m22600j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m22601k());
        flatBufferBuilder.m21510c(4);
        flatBufferBuilder.m21494a(0, mo2909a(), 0);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21494a(3, mo2910b(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLTopLevelCommentsConnection(Parcel parcel) {
        super(5);
        this.f15863d = parcel.readInt();
        this.f15864e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLComment.class.getClassLoader()));
        this.f15865f = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
        this.f15866g = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mo2909a());
        parcel.writeList(m22600j());
        parcel.writeValue(m22601k());
        parcel.writeInt(mo2910b());
    }

    public GraphQLTopLevelCommentsConnection(Builder builder) {
        super(5);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f15863d = builder.d;
        this.f15864e = builder.e;
        this.f15865f = builder.f;
        this.f15866g = builder.g;
    }
}
