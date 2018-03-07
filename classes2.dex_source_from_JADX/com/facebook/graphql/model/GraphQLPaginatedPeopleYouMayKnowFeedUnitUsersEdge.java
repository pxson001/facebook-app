package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.interfaces.HasTracking;
import com.facebook.graphql.model.interfaces.ItemListFeedUnitItem;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: fragment_title */
public final class GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge extends BaseModel implements PeopleYouMayKnowFeedUnitItem, HasProperty, HasTracking, ItemListFeedUnitItem, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge> CREATOR = new 1();
    @Nullable
    GraphQLUser f23320d;
    @Nullable
    GraphQLTextWithEntities f23321e;
    @Nullable
    String f23322f;
    @Nullable
    private PropertyBag f23323g = null;

    public final String mo3413l() {
        return m31481m().m23909P();
    }

    public final boolean m31478j() {
        return IsValidUtil.m22958a(this);
    }

    @FieldOffset
    @Nullable
    public final GraphQLUser m31481m() {
        this.f23320d = (GraphQLUser) super.m9947a(this.f23320d, 0, GraphQLUser.class);
        return this.f23320d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities mo3414n() {
        this.f23321e = (GraphQLTextWithEntities) super.m9947a(this.f23321e, 1, GraphQLTextWithEntities.class);
        return this.f23321e;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f23322f = super.m9948a(this.f23322f, 2);
        return this.f23322f;
    }

    public final int jK_() {
        return 1230339094;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m31481m() != null) {
            GraphQLUser graphQLUser = (GraphQLUser) graphQLModelMutatingVisitor.mo2928b(m31481m());
            if (m31481m() != graphQLUser) {
                graphQLVisitableModel = (GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f23320d = graphQLUser;
            }
        }
        if (mo3414n() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(mo3414n());
            if (mo3414n() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f23321e = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge() {
        super(4);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m31481m());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, mo3414n());
        int b = flatBufferBuilder.m21502b(mo2877k());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(2, b);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge(Parcel parcel) {
        super(4);
        this.f23320d = (GraphQLUser) parcel.readValue(GraphQLUser.class.getClassLoader());
        this.f23321e = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f23322f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m31481m());
        parcel.writeValue(mo3414n());
        parcel.writeString(mo2877k());
    }

    public final PropertyBag U_() {
        if (this.f23323g == null) {
            this.f23323g = new PropertyBag();
        }
        return this.f23323g;
    }
}
