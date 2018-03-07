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
/* compiled from: insertion_item */
public final class GraphQLTimelineSectionsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLTimelineSectionsConnection> CREATOR = new 1();
    public List<GraphQLTimelineSection> f19836d;
    @Nullable
    public GraphQLPageInfo f19837e;

    @FieldOffset
    public final ImmutableList<GraphQLTimelineSection> m27574a() {
        this.f19836d = super.m9944a(this.f19836d, 0, GraphQLTimelineSection.class);
        return (ImmutableList) this.f19836d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m27575j() {
        this.f19837e = (GraphQLPageInfo) super.m9947a(this.f19837e, 1, GraphQLPageInfo.class);
        return this.f19837e;
    }

    public final int jK_() {
        return 98129389;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        m9958h();
        if (m27574a() != null) {
            Builder a = ModelHelper.m23097a(m27574a(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLTimelineSectionsConnection graphQLTimelineSectionsConnection = (GraphQLTimelineSectionsConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLTimelineSectionsConnection.f19836d = a.m1068b();
                graphQLVisitableModel = graphQLTimelineSectionsConnection;
                if (m27575j() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m27575j());
                    if (m27575j() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLTimelineSectionsConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f19837e = graphQLPageInfo;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m27575j() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m27575j());
            if (m27575j() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLTimelineSectionsConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19837e = graphQLPageInfo;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLTimelineSectionsConnection() {
        super(3);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m27574a());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m27575j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLTimelineSectionsConnection(Parcel parcel) {
        super(3);
        this.f19836d = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLTimelineSection.class.getClassLoader()));
        this.f19837e = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m27574a());
        parcel.writeValue(m27575j());
    }

    public GraphQLTimelineSectionsConnection(Builder builder) {
        super(3);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f19836d = builder.d;
        this.f19837e = builder.e;
    }
}
