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
/* compiled from: instant_article_an_native_ad_chevron */
public final class GraphQLEventsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEventsConnection> CREATOR = new 1();
    public List<GraphQLEvent> f19796d;
    @Nullable
    public GraphQLPageInfo f19797e;

    @FieldOffset
    public final ImmutableList<GraphQLEvent> m27495a() {
        this.f19796d = super.m9944a(this.f19796d, 0, GraphQLEvent.class);
        return (ImmutableList) this.f19796d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m27496j() {
        this.f19797e = (GraphQLPageInfo) super.m9947a(this.f19797e, 1, GraphQLPageInfo.class);
        return this.f19797e;
    }

    public final int jK_() {
        return 2014491895;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        m9958h();
        if (m27495a() != null) {
            Builder a = ModelHelper.m23097a(m27495a(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLEventsConnection graphQLEventsConnection = (GraphQLEventsConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLEventsConnection.f19796d = a.m1068b();
                graphQLVisitableModel = graphQLEventsConnection;
                if (m27496j() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m27496j());
                    if (m27496j() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLEventsConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f19797e = graphQLPageInfo;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m27496j() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m27496j());
            if (m27496j() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLEventsConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19797e = graphQLPageInfo;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLEventsConnection() {
        super(3);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m27495a());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m27496j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLEventsConnection(Parcel parcel) {
        super(3);
        this.f19796d = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLEvent.class.getClassLoader()));
        this.f19797e = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m27495a());
        parcel.writeValue(m27496j());
    }
}
