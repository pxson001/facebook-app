package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.extras.FeedUnitExtra;
import com.facebook.graphql.model.interfaces.CachedFeedTrackable;
import com.facebook.graphql.model.interfaces.FollowUpFeedUnit;
import com.facebook.graphql.model.interfaces.HasTracking;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: invalid_data */
public final class GraphQLArticleChainingFeedUnit extends BaseModel implements FeedAttachable, FeedUnit, HasProperty, ScrollableItemListFeedUnit, CachedFeedTrackable, FollowUpFeedUnit, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLArticleChainingFeedUnit> CREATOR = new 1();
    GraphQLObjectType f19568d = new GraphQLObjectType(-1459322407);
    @Nullable
    GraphQLTextWithEntities f19569e;
    @Nullable
    String f19570f;
    @Nullable
    String f19571g;
    long f19572h;
    @Nullable
    String f19573i;
    @Nullable
    String f19574j;
    @Nullable
    GraphQLSuggestedContentConnection f19575k;
    @Nullable
    GraphQLTextWithEntities f19576l;
    @Nullable
    GraphQLTextWithEntities f19577m;
    @Nullable
    String f19578n;
    @Nullable
    String f19579o;
    private ArticleChainingFeedUnitExtra f19580p;
    @Nullable
    private PropertyBag f19581q = null;

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m27264y();
    }

    public final /* synthetic */ List mo2883w() {
        return m27274l();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27152a((HasTracking) this);
    }

    public final GraphQLObjectType getType() {
        return this.f19568d;
    }

    public final ImmutableList<String> mo2874d() {
        if (mo2507g() != null) {
            return ImmutableList.of(mo2507g());
        }
        return RegularImmutableList.f535a;
    }

    public final ImmutableList m27274l() {
        return ItemListFeedUnitImpl.m30137a(this);
    }

    public final int ac_() {
        return VisibleItemHelper.m26976a((ScrollableItemListFeedUnit) this);
    }

    public final List mo2882v() {
        return ItemListFeedUnitImpl.m30137a(this);
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m27276o() {
        this.f19569e = (GraphQLTextWithEntities) super.m9947a(this.f19569e, 0, GraphQLTextWithEntities.class);
        return this.f19569e;
    }

    @FieldOffset
    @Nullable
    public final String mo2507g() {
        this.f19570f = super.m9948a(this.f19570f, 1);
        return this.f19570f;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f19571g = super.m9948a(this.f19571g, 2);
        return this.f19571g;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 3);
        return this.f19572h;
    }

    public final void mo2872a(long j) {
        this.f19572h = j;
    }

    @FieldOffset
    @Nullable
    public final String m27277p() {
        this.f19573i = super.m9948a(this.f19573i, 4);
        return this.f19573i;
    }

    @FieldOffset
    @Nullable
    public final String m27278q() {
        this.f19574j = super.m9948a(this.f19574j, 6);
        return this.f19574j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLSuggestedContentConnection m27279r() {
        this.f19575k = (GraphQLSuggestedContentConnection) super.m9947a(this.f19575k, 7, GraphQLSuggestedContentConnection.class);
        return this.f19575k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m27280s() {
        this.f19576l = (GraphQLTextWithEntities) super.m9947a(this.f19576l, 8, GraphQLTextWithEntities.class);
        return this.f19576l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m27281t() {
        this.f19577m = (GraphQLTextWithEntities) super.m9947a(this.f19577m, 9, GraphQLTextWithEntities.class);
        return this.f19577m;
    }

    @FieldOffset
    @Nullable
    public final String mo2877k() {
        this.f19578n = super.m9948a(this.f19578n, 10);
        return this.f19578n;
    }

    @FieldOffset
    @Nullable
    public final String m27282u() {
        this.f19579o = super.m9948a(this.f19579o, 11);
        return this.f19579o;
    }

    @Nullable
    public final String mo2834a() {
        return m27277p();
    }

    public final int jK_() {
        return -1459322407;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m27276o() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m27276o());
            if (m27276o() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLArticleChainingFeedUnit) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19569e = graphQLTextWithEntities;
            }
        }
        if (m27279r() != null) {
            GraphQLSuggestedContentConnection graphQLSuggestedContentConnection = (GraphQLSuggestedContentConnection) graphQLModelMutatingVisitor.mo2928b(m27279r());
            if (m27279r() != graphQLSuggestedContentConnection) {
                graphQLVisitableModel = (GraphQLArticleChainingFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19575k = graphQLSuggestedContentConnection;
            }
        }
        if (m27280s() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m27280s());
            if (m27280s() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLArticleChainingFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19576l = graphQLTextWithEntities;
            }
        }
        if (m27281t() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m27281t());
            if (m27281t() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLArticleChainingFeedUnit) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19577m = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final GraphQLTextWithEntities mo2878m() {
        return m27276o();
    }

    public GraphQLArticleChainingFeedUnit() {
        super(13);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f19572h = mutableFlatBuffer.m21525a(i, 3, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m27276o());
        int b = flatBufferBuilder.m21502b(mo2507g());
        int b2 = flatBufferBuilder.m21502b(S_());
        int b3 = flatBufferBuilder.m21502b(m27277p());
        int b4 = flatBufferBuilder.m21502b(m27278q());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m27279r());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m27280s());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m27281t());
        int b5 = flatBufferBuilder.m21502b(mo2877k());
        int b6 = flatBufferBuilder.m21502b(m27282u());
        flatBufferBuilder.m21510c(12);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, b2);
        flatBufferBuilder.m21495a(3, T_(), 0);
        flatBufferBuilder.m21507b(4, b3);
        flatBufferBuilder.m21507b(6, b4);
        flatBufferBuilder.m21507b(7, a2);
        flatBufferBuilder.m21507b(8, a3);
        flatBufferBuilder.m21507b(9, a4);
        flatBufferBuilder.m21507b(10, b5);
        flatBufferBuilder.m21507b(11, b6);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLArticleChainingFeedUnit(Parcel parcel) {
        super(13);
        this.f19569e = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f19570f = parcel.readString();
        this.f19571g = parcel.readString();
        this.f19572h = parcel.readLong();
        this.f19573i = parcel.readString();
        this.f19574j = parcel.readString();
        this.f19575k = (GraphQLSuggestedContentConnection) parcel.readValue(GraphQLSuggestedContentConnection.class.getClassLoader());
        this.f19576l = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f19577m = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f19578n = parcel.readString();
        this.f19579o = parcel.readString();
        this.f19580p = (ArticleChainingFeedUnitExtra) ParcelUtil.b(parcel, ArticleChainingFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m27276o());
        parcel.writeString(mo2507g());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeString(m27277p());
        parcel.writeString(m27278q());
        parcel.writeValue(m27279r());
        parcel.writeValue(m27280s());
        parcel.writeValue(m27281t());
        parcel.writeString(mo2877k());
        parcel.writeString(m27282u());
        parcel.writeParcelable(m27264y(), i);
    }

    private ArticleChainingFeedUnitExtra m27264y() {
        if (this.f19580p == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f19580p = new ArticleChainingFeedUnitExtra();
            } else {
                this.f19580p = (ArticleChainingFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, ArticleChainingFeedUnitExtra.class);
            }
        }
        return this.f19580p;
    }

    public final PropertyBag U_() {
        if (this.f19581q == null) {
            this.f19581q = new PropertyBag();
        }
        return this.f19581q;
    }
}
