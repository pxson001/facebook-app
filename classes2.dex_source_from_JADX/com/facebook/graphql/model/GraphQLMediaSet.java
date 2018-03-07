package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: localsell_saved_search_results */
public final class GraphQLMediaSet extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLMediaSet> CREATOR = new 1();
    @Nullable
    public GraphQLObjectType f16762d;
    @Nullable
    public String f16763e;
    @Nullable
    public GraphQLMediaSetMediaConnection f16764f;
    @Nullable
    public GraphQLMediaSetMediaConnection f16765g;
    @Nullable
    public GraphQLTextWithEntities f16766h;

    @Nullable
    public final GraphQLObjectType m23681j() {
        if (this.f5823b != null && this.f16762d == null) {
            this.f16762d = new GraphQLObjectType(this.f5823b.m21542b(this.f5824c, 0));
        }
        if (this.f16762d == null || this.f16762d.m22301g() != 0) {
            return this.f16762d;
        }
        return null;
    }

    @FieldOffset
    @Nullable
    public final String m23682k() {
        this.f16763e = super.m9948a(this.f16763e, 1);
        return this.f16763e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLMediaSetMediaConnection m23683l() {
        this.f16764f = (GraphQLMediaSetMediaConnection) super.m9947a(this.f16764f, 2, GraphQLMediaSetMediaConnection.class);
        return this.f16764f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLMediaSetMediaConnection m23684m() {
        this.f16765g = (GraphQLMediaSetMediaConnection) super.m9947a(this.f16765g, 3, GraphQLMediaSetMediaConnection.class);
        return this.f16765g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23685n() {
        this.f16766h = (GraphQLTextWithEntities) super.m9947a(this.f16766h, 4, GraphQLTextWithEntities.class);
        return this.f16766h;
    }

    @Nullable
    public final String mo2834a() {
        return m23682k();
    }

    public final int jK_() {
        return -836141570;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLMediaSetMediaConnection graphQLMediaSetMediaConnection;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23683l() != null) {
            graphQLMediaSetMediaConnection = (GraphQLMediaSetMediaConnection) graphQLModelMutatingVisitor.mo2928b(m23683l());
            if (m23683l() != graphQLMediaSetMediaConnection) {
                graphQLVisitableModel = (GraphQLMediaSet) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16764f = graphQLMediaSetMediaConnection;
            }
        }
        if (m23684m() != null) {
            graphQLMediaSetMediaConnection = (GraphQLMediaSetMediaConnection) graphQLModelMutatingVisitor.mo2928b(m23684m());
            if (m23684m() != graphQLMediaSetMediaConnection) {
                graphQLVisitableModel = (GraphQLMediaSet) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16765g = graphQLMediaSetMediaConnection;
            }
        }
        if (m23685n() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23685n());
            if (m23685n() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLMediaSet) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16766h = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLMediaSet() {
        super(6);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = flatBufferBuilder.m21479a(m23681j() != null ? m23681j().m22299e() : null);
        int b = flatBufferBuilder.m21502b(m23682k());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23683l());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m23684m());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m23685n());
        flatBufferBuilder.m21510c(5);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21507b(3, a3);
        flatBufferBuilder.m21507b(4, a4);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLMediaSet(Parcel parcel) {
        super(6);
        this.f16763e = parcel.readString();
        this.f16764f = (GraphQLMediaSetMediaConnection) parcel.readValue(GraphQLMediaSetMediaConnection.class.getClassLoader());
        this.f16765g = (GraphQLMediaSetMediaConnection) parcel.readValue(GraphQLMediaSetMediaConnection.class.getClassLoader());
        this.f16766h = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16762d = (GraphQLObjectType) ParcelUtil.b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m23682k());
        parcel.writeValue(m23683l());
        parcel.writeValue(m23684m());
        parcel.writeValue(m23685n());
        parcel.writeParcelable(this.f16762d, i);
    }
}
