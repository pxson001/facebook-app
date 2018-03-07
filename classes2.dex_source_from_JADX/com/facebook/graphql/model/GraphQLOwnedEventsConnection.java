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
/* compiled from: getResource */
public final class GraphQLOwnedEventsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLOwnedEventsConnection> CREATOR = new 1();
    public List<GraphQLEvent> f22523d;
    @Nullable
    public GraphQLPageInfo f22524e;

    @FieldOffset
    public final ImmutableList<GraphQLEvent> m30404a() {
        this.f22523d = super.m9944a(this.f22523d, 0, GraphQLEvent.class);
        return (ImmutableList) this.f22523d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m30405j() {
        this.f22524e = (GraphQLPageInfo) super.m9947a(this.f22524e, 1, GraphQLPageInfo.class);
        return this.f22524e;
    }

    public final int jK_() {
        return 1990200700;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        m9958h();
        if (m30404a() != null) {
            Builder a = ModelHelper.m23097a(m30404a(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLOwnedEventsConnection graphQLOwnedEventsConnection = (GraphQLOwnedEventsConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLOwnedEventsConnection.f22523d = a.m1068b();
                graphQLVisitableModel = graphQLOwnedEventsConnection;
                if (m30405j() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m30405j());
                    if (m30405j() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLOwnedEventsConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f22524e = graphQLPageInfo;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m30405j() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m30405j());
            if (m30405j() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLOwnedEventsConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f22524e = graphQLPageInfo;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLOwnedEventsConnection() {
        super(3);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m30404a());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m30405j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLOwnedEventsConnection(Parcel parcel) {
        super(3);
        this.f22523d = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLEvent.class.getClassLoader()));
        this.f22524e = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m30404a());
        parcel.writeValue(m30405j());
    }

    public GraphQLOwnedEventsConnection(Builder builder) {
        super(3);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f22523d = builder.d;
        this.f22524e = builder.e;
    }
}
