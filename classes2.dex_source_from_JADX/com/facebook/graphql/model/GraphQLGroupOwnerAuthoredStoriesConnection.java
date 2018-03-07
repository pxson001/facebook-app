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
/* compiled from: live_video_subscription_status */
public final class GraphQLGroupOwnerAuthoredStoriesConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGroupOwnerAuthoredStoriesConnection> CREATOR = new 1();
    int f17257d;
    List<GraphQLStory> f17258e;
    @Nullable
    GraphQLPageInfo f17259f;
    int f17260g;

    @FieldOffset
    public final int m24312a() {
        m9949a(0, 0);
        return this.f17257d;
    }

    final void mo2908a(int i) {
        this.f17257d = i;
        if (this.f5823b != null && this.f5823b.f15024d) {
            this.f5823b.m21544b(this.f5824c, 0, i);
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLStory> m24318j() {
        this.f17258e = super.m9944a(this.f17258e, 1, GraphQLStory.class);
        return (ImmutableList) this.f17258e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m24319k() {
        this.f17259f = (GraphQLPageInfo) super.m9947a(this.f17259f, 2, GraphQLPageInfo.class);
        return this.f17259f;
    }

    @FieldOffset
    public final int m24320l() {
        m9949a(0, 3);
        return this.f17260g;
    }

    final void m24317b(int i) {
        this.f17260g = i;
        if (this.f5823b != null && this.f5823b.f15024d) {
            this.f5823b.m21544b(this.f5824c, 3, i);
        }
    }

    public final int jK_() {
        return -2125813741;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        m9958h();
        if (m24318j() != null) {
            Builder a = ModelHelper.m23097a(m24318j(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLGroupOwnerAuthoredStoriesConnection graphQLGroupOwnerAuthoredStoriesConnection = (GraphQLGroupOwnerAuthoredStoriesConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLGroupOwnerAuthoredStoriesConnection.f17258e = a.m1068b();
                graphQLVisitableModel = graphQLGroupOwnerAuthoredStoriesConnection;
                if (m24319k() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m24319k());
                    if (m24319k() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLGroupOwnerAuthoredStoriesConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17259f = graphQLPageInfo;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m24319k() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m24319k());
            if (m24319k() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLGroupOwnerAuthoredStoriesConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17259f = graphQLPageInfo;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLGroupOwnerAuthoredStoriesConnection() {
        super(5);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17257d = mutableFlatBuffer.m21524a(i, 0, 0);
        this.f17260g = mutableFlatBuffer.m21524a(i, 3, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m24318j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24319k());
        flatBufferBuilder.m21510c(4);
        flatBufferBuilder.m21494a(0, m24312a(), 0);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21494a(3, m24320l(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLGroupOwnerAuthoredStoriesConnection(Parcel parcel) {
        super(5);
        this.f17257d = parcel.readInt();
        this.f17258e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStory.class.getClassLoader()));
        this.f17259f = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
        this.f17260g = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m24312a());
        parcel.writeList(m24318j());
        parcel.writeValue(m24319k());
        parcel.writeInt(m24320l());
    }
}
