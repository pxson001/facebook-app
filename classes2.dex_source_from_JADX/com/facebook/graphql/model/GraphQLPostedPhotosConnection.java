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
/* compiled from: like_comment */
public final class GraphQLPostedPhotosConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPostedPhotosConnection> CREATOR = new 1();
    public List<GraphQLPhoto> f17531d;
    @Nullable
    public GraphQLPageInfo f17532e;

    @FieldOffset
    public final ImmutableList<GraphQLPhoto> m24679a() {
        this.f17531d = super.m9944a(this.f17531d, 0, GraphQLPhoto.class);
        return (ImmutableList) this.f17531d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m24680j() {
        this.f17532e = (GraphQLPageInfo) super.m9947a(this.f17532e, 1, GraphQLPageInfo.class);
        return this.f17532e;
    }

    public final int jK_() {
        return 1367901630;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        m9958h();
        if (m24679a() != null) {
            Builder a = ModelHelper.m23097a(m24679a(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLPostedPhotosConnection graphQLPostedPhotosConnection = (GraphQLPostedPhotosConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLPostedPhotosConnection.f17531d = a.m1068b();
                graphQLVisitableModel = graphQLPostedPhotosConnection;
                if (m24680j() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m24680j());
                    if (m24680j() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLPostedPhotosConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17532e = graphQLPageInfo;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m24680j() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m24680j());
            if (m24680j() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLPostedPhotosConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17532e = graphQLPageInfo;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLPostedPhotosConnection() {
        super(3);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m24679a());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24680j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPostedPhotosConnection(Parcel parcel) {
        super(3);
        this.f17531d = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLPhoto.class.getClassLoader()));
        this.f17532e = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m24679a());
        parcel.writeValue(m24680j());
    }
}
