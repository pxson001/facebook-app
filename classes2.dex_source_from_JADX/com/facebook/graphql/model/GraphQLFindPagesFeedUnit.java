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
/* compiled from: last_delete_stale */
public final class GraphQLFindPagesFeedUnit extends BaseModel implements FeedUnit, HasProperty, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLFindPagesFeedUnit> CREATOR = new 1();
    public GraphQLObjectType f18045d = new GraphQLObjectType(-1181166899);
    public long f18046e;
    private FindPagesFeedUnitExtra f18047f;
    @Nullable
    private PropertyBag f18048g = null;

    public final String mo2507g() {
        return null;
    }

    public final /* synthetic */ FeedUnitExtra mo2876j() {
        return m25325k();
    }

    public final GraphQLObjectType getType() {
        return this.f18045d;
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
        return this.f18046e;
    }

    public final void mo2872a(long j) {
        this.f18046e = j;
    }

    public final int jK_() {
        return -1181166899;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLFindPagesFeedUnit() {
        super(2);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f18046e = mutableFlatBuffer.m21525a(i, 0, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21495a(0, T_(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLFindPagesFeedUnit(Parcel parcel) {
        super(2);
        this.f18046e = parcel.readLong();
        this.f18047f = (FindPagesFeedUnitExtra) ParcelUtil.b(parcel, FindPagesFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(T_());
        parcel.writeParcelable(m25325k(), i);
    }

    private FindPagesFeedUnitExtra m25325k() {
        if (this.f18047f == null) {
            if (this.f5823b == null || !this.f5823b.f15024d) {
                this.f18047f = new FindPagesFeedUnitExtra();
            } else {
                this.f18047f = (FindPagesFeedUnitExtra) this.f5823b.m21531a(this.f5824c, (Flattenable) this, FindPagesFeedUnitExtra.class);
            }
        }
        return this.f18047f;
    }

    public final PropertyBag U_() {
        if (this.f18048g == null) {
            this.f18048g = new PropertyBag();
        }
        return this.f18048g;
    }
}
