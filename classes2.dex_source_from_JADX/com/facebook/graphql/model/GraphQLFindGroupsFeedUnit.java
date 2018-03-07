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
/* compiled from: last_enabled */
public final class GraphQLFindGroupsFeedUnit extends BaseModel implements FeedUnit, HasProperty, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLFindGroupsFeedUnit> CREATOR = new 1();
    public GraphQLObjectType f18038d = new GraphQLObjectType(-1935350673);
    public long f18039e;
    private FindGroupsFeedUnitExtra f18040f;
    @Nullable
    private PropertyBag f18041g = null;

    public final String mo2507g() {
        return null;
    }

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m25313k();
    }

    public final GraphQLObjectType getType() {
        return this.f18038d;
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
    public final long T_() {
        m9949a(0, 0);
        return this.f18039e;
    }

    public final void mo2872a(long j) {
        this.f18039e = j;
    }

    public final int jK_() {
        return -1935350673;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLFindGroupsFeedUnit() {
        super(2);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18039e = mutableFlatBuffer.m21525a(i, 0, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21495a(0, T_(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLFindGroupsFeedUnit(Parcel parcel) {
        super(2);
        this.f18039e = parcel.readLong();
        this.f18040f = (FindGroupsFeedUnitExtra) ParcelUtil.b(parcel, FindGroupsFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(T_());
        parcel.writeParcelable(m25313k(), i);
    }

    private FindGroupsFeedUnitExtra m25313k() {
        if (this.f18040f == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18040f = new FindGroupsFeedUnitExtra();
            } else {
                this.f18040f = (FindGroupsFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, FindGroupsFeedUnitExtra.class);
            }
        }
        return this.f18040f;
    }

    public final PropertyBag U_() {
        if (this.f18041g == null) {
            this.f18041g = new PropertyBag();
        }
        return this.f18041g;
    }
}
