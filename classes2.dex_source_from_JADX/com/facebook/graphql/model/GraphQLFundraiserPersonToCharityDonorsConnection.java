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
/* compiled from: local_group_did_ignore_report */
public final class GraphQLFundraiserPersonToCharityDonorsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLFundraiserPersonToCharityDonorsConnection> CREATOR = new 1();
    public List<GraphQLUser> f17097d;
    @Nullable
    public GraphQLPageInfo f17098e;

    @FieldOffset
    public final ImmutableList<GraphQLUser> m24103a() {
        this.f17097d = super.m9944a(this.f17097d, 0, GraphQLUser.class);
        return (ImmutableList) this.f17097d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m24104j() {
        this.f17098e = (GraphQLPageInfo) super.m9947a(this.f17098e, 1, GraphQLPageInfo.class);
        return this.f17098e;
    }

    public final int jK_() {
        return -1978703416;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        m9958h();
        if (m24103a() != null) {
            Builder a = ModelHelper.m23097a(m24103a(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLFundraiserPersonToCharityDonorsConnection graphQLFundraiserPersonToCharityDonorsConnection = (GraphQLFundraiserPersonToCharityDonorsConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLFundraiserPersonToCharityDonorsConnection.f17097d = a.m1068b();
                graphQLVisitableModel = graphQLFundraiserPersonToCharityDonorsConnection;
                if (m24104j() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m24104j());
                    if (m24104j() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLFundraiserPersonToCharityDonorsConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17098e = graphQLPageInfo;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m24104j() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m24104j());
            if (m24104j() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLFundraiserPersonToCharityDonorsConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17098e = graphQLPageInfo;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLFundraiserPersonToCharityDonorsConnection() {
        super(3);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m24103a());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24104j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLFundraiserPersonToCharityDonorsConnection(Parcel parcel) {
        super(3);
        this.f17097d = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLUser.class.getClassLoader()));
        this.f17098e = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m24103a());
        parcel.writeValue(m24104j());
    }
}
