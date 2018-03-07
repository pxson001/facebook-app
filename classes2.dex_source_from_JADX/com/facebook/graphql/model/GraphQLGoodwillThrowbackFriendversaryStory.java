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
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: java_reflection */
public final class GraphQLGoodwillThrowbackFriendversaryStory extends BaseModel implements FeedUnit, HasProperty, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGoodwillThrowbackFriendversaryStory> CREATOR = new 1();
    GraphQLObjectType f18663d = new GraphQLObjectType(341326393);
    @Nullable
    GraphQLImage f18664e;
    long f18665f;
    @Nullable
    GraphQLGoodwillThrowbackFriendListConnection f18666g;
    @Nullable
    GraphQLTextWithEntities f18667h;
    @Nullable
    String f18668i;
    @Nullable
    GraphQLGoodwillThrowbackSection f18669j;
    private GoodwillThrowbackFriendversaryStoryExtra f18670k;
    @Nullable
    private PropertyBag f18671l = null;

    public final String mo2507g() {
        return null;
    }

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m26169p();
    }

    public final GraphQLObjectType getType() {
        return this.f18663d;
    }

    public final String S_() {
        return null;
    }

    public final ImmutableList<String> mo2874d() {
        if (mo2507g() != null) {
            return ImmutableList.of(mo2507g());
        }
        return RegularImmutableList.f535a;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m26177k() {
        this.f18664e = (GraphQLImage) super.m9947a(this.f18664e, 0, GraphQLImage.class);
        return this.f18664e;
    }

    @FieldOffset
    public final long T_() {
        m9949a(0, 1);
        return this.f18665f;
    }

    public final void mo2872a(long j) {
        this.f18665f = j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGoodwillThrowbackFriendListConnection m26178l() {
        this.f18666g = (GraphQLGoodwillThrowbackFriendListConnection) super.m9947a(this.f18666g, 2, GraphQLGoodwillThrowbackFriendListConnection.class);
        return this.f18666g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m26179m() {
        this.f18667h = (GraphQLTextWithEntities) super.m9947a(this.f18667h, 3, GraphQLTextWithEntities.class);
        return this.f18667h;
    }

    @FieldOffset
    @Nullable
    public final String m26180n() {
        this.f18668i = super.m9948a(this.f18668i, 4);
        return this.f18668i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGoodwillThrowbackSection m26181o() {
        this.f18669j = (GraphQLGoodwillThrowbackSection) super.m9947a(this.f18669j, 5, GraphQLGoodwillThrowbackSection.class);
        return this.f18669j;
    }

    public final int jK_() {
        return 341326393;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m26177k() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m26177k());
            if (m26177k() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFriendversaryStory) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18664e = graphQLImage;
            }
        }
        if (m26178l() != null) {
            GraphQLGoodwillThrowbackFriendListConnection graphQLGoodwillThrowbackFriendListConnection = (GraphQLGoodwillThrowbackFriendListConnection) graphQLModelMutatingVisitor.mo2928b(m26178l());
            if (m26178l() != graphQLGoodwillThrowbackFriendListConnection) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFriendversaryStory) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18666g = graphQLGoodwillThrowbackFriendListConnection;
            }
        }
        if (m26181o() != null) {
            GraphQLGoodwillThrowbackSection graphQLGoodwillThrowbackSection = (GraphQLGoodwillThrowbackSection) graphQLModelMutatingVisitor.mo2928b(m26181o());
            if (m26181o() != graphQLGoodwillThrowbackSection) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFriendversaryStory) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18669j = graphQLGoodwillThrowbackSection;
            }
        }
        if (m26179m() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m26179m());
            if (m26179m() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFriendversaryStory) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f18667h = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGoodwillThrowbackFriendversaryStory() {
        super(7);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18665f = mutableFlatBuffer.m21525a(i, 1, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m26177k());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m26178l());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m26179m());
        int b = flatBufferBuilder.m21502b(m26180n());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m26181o());
        flatBufferBuilder.m21510c(6);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21495a(1, T_(), 0);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21507b(3, a3);
        flatBufferBuilder.m21507b(4, b);
        flatBufferBuilder.m21507b(5, a4);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLGoodwillThrowbackFriendversaryStory(Parcel parcel) {
        super(7);
        this.f18664e = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f18665f = parcel.readLong();
        this.f18666g = (GraphQLGoodwillThrowbackFriendListConnection) parcel.readValue(GraphQLGoodwillThrowbackFriendListConnection.class.getClassLoader());
        this.f18668i = parcel.readString();
        this.f18669j = (GraphQLGoodwillThrowbackSection) parcel.readValue(GraphQLGoodwillThrowbackSection.class.getClassLoader());
        this.f18667h = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f18670k = (GoodwillThrowbackFriendversaryStoryExtra) ParcelUtil.b(parcel, GoodwillThrowbackFriendversaryStoryExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m26177k());
        parcel.writeLong(T_());
        parcel.writeValue(m26178l());
        parcel.writeString(m26180n());
        parcel.writeValue(m26181o());
        parcel.writeValue(m26179m());
        parcel.writeParcelable(m26169p(), i);
    }

    public GraphQLGoodwillThrowbackFriendversaryStory(Builder builder) {
        super(7);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f18664e = builder.d;
        this.f18665f = builder.e;
        this.f18666g = builder.f;
        this.f18668i = builder.g;
        this.f18669j = builder.h;
        this.f18667h = builder.i;
        this.f18671l = builder.j;
    }

    private GoodwillThrowbackFriendversaryStoryExtra m26169p() {
        if (this.f18670k == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18670k = new GoodwillThrowbackFriendversaryStoryExtra();
            } else {
                this.f18670k = (GoodwillThrowbackFriendversaryStoryExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, GoodwillThrowbackFriendversaryStoryExtra.class);
            }
        }
        return this.f18670k;
    }

    public final PropertyBag U_() {
        if (this.f18671l == null) {
            this.f18671l = new PropertyBag();
        }
        return this.f18671l;
    }
}
