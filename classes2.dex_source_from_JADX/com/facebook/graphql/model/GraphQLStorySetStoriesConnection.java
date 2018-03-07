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
/* compiled from: localphototags */
public final class GraphQLStorySetStoriesConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLStorySetStoriesConnection> CREATOR = new 1();
    public int f16901d;
    public List<GraphQLStory> f16902e;
    @Nullable
    public GraphQLPageInfo f16903f;

    @FieldOffset
    public final int m23868a() {
        m9949a(0, 0);
        return this.f16901d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStory> m23872j() {
        this.f16902e = super.m9944a(this.f16902e, 1, GraphQLStory.class);
        return (ImmutableList) this.f16902e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m23873k() {
        this.f16903f = (GraphQLPageInfo) super.m9947a(this.f16903f, 2, GraphQLPageInfo.class);
        return this.f16903f;
    }

    public final int jK_() {
        return 1404879812;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        m9958h();
        if (m23872j() != null) {
            Builder a = ModelHelper.m23097a(m23872j(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLStorySetStoriesConnection graphQLStorySetStoriesConnection = (GraphQLStorySetStoriesConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLStorySetStoriesConnection.f16902e = a.m1068b();
                graphQLVisitableModel = graphQLStorySetStoriesConnection;
                if (m23873k() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m23873k());
                    if (m23873k() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLStorySetStoriesConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f16903f = graphQLPageInfo;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m23873k() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m23873k());
            if (m23873k() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLStorySetStoriesConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16903f = graphQLPageInfo;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLStorySetStoriesConnection() {
        super(4);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16901d = mutableFlatBuffer.m21524a(i, 0, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m23872j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23873k());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21494a(0, m23868a(), 0);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLStorySetStoriesConnection(Parcel parcel) {
        super(4);
        this.f16901d = parcel.readInt();
        this.f16902e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStory.class.getClassLoader()));
        this.f16903f = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m23868a());
        parcel.writeList(m23872j());
        parcel.writeValue(m23873k());
    }

    public GraphQLStorySetStoriesConnection(Builder builder) {
        super(4);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16901d = builder.d;
        this.f16902e = builder.e;
        this.f16903f = builder.f;
    }
}
