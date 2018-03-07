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
/* compiled from: localsell_editcomposer/?storyID=%s&referralSurface=%s */
public final class GraphQLPeopleYouMayInviteFeedUnitContactsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPeopleYouMayInviteFeedUnitContactsConnection> CREATOR = new 1();
    public List<GraphQLPeopleYouMayInviteFeedUnitContactsEdge> f16894d;
    @Nullable
    public GraphQLPageInfo f16895e;

    @FieldOffset
    public final ImmutableList<GraphQLPeopleYouMayInviteFeedUnitContactsEdge> m23854a() {
        this.f16894d = super.m9944a(this.f16894d, 0, GraphQLPeopleYouMayInviteFeedUnitContactsEdge.class);
        return (ImmutableList) this.f16894d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m23855j() {
        this.f16895e = (GraphQLPageInfo) super.m9947a(this.f16895e, 1, GraphQLPageInfo.class);
        return this.f16895e;
    }

    public final int jK_() {
        return -457645615;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        m9958h();
        if (m23854a() != null) {
            Builder a = ModelHelper.m23097a(m23854a(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLPeopleYouMayInviteFeedUnitContactsConnection graphQLPeopleYouMayInviteFeedUnitContactsConnection = (GraphQLPeopleYouMayInviteFeedUnitContactsConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLPeopleYouMayInviteFeedUnitContactsConnection.f16894d = a.m1068b();
                graphQLVisitableModel = graphQLPeopleYouMayInviteFeedUnitContactsConnection;
                if (m23855j() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m23855j());
                    if (m23855j() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLPeopleYouMayInviteFeedUnitContactsConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f16895e = graphQLPageInfo;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m23855j() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m23855j());
            if (m23855j() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLPeopleYouMayInviteFeedUnitContactsConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16895e = graphQLPageInfo;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLPeopleYouMayInviteFeedUnitContactsConnection() {
        super(3);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m23854a());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23855j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPeopleYouMayInviteFeedUnitContactsConnection(Parcel parcel) {
        super(3);
        this.f16894d = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLPeopleYouMayInviteFeedUnitContactsEdge.class.getClassLoader()));
        this.f16895e = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m23854a());
        parcel.writeValue(m23855j());
    }

    public GraphQLPeopleYouMayInviteFeedUnitContactsConnection(Builder builder) {
        super(3);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16894d = builder.d;
        this.f16895e = builder.e;
    }
}
