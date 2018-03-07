package com.facebook.graphql.model;

import android.os.Parcel;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.extras.FeedUnitExtra;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;

/* compiled from: last_impression_timestamp_ms */
public abstract class BaseFeedUnit implements FeedUnit, HasProperty {
    public GraphQLObjectType getType() {
        return null;
    }

    public final long T_() {
        return 0;
    }

    public final void mo2872a(long j) {
    }

    public String mo2507g() {
        return null;
    }

    public final String S_() {
        return null;
    }

    public final void mo1412a(MutableFlatBuffer mutableFlatBuffer, int i) {
        throw new UnsupportedOperationException("initFromMutableFlatBuffer is not supported");
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        throw new UnsupportedOperationException("flattenToBuffer is not supported");
    }

    public final ImmutableList<String> mo2874d() {
        return RegularImmutableList.f535a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    public final FeedUnitExtra mo2876j() {
        return new FeedUnitExtra();
    }

    public final PropertyBag U_() {
        return new PropertyBag();
    }

    public MutableFlatBuffer w_() {
        throw new UnsupportedOperationException("getMutableFlatBuffer is not supported");
    }

    public final int u_() {
        throw new UnsupportedOperationException("getPositionInMutableFlatBuffer is not supported");
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        return this;
    }

    public final int jK_() {
        return -1;
    }

    public Object clone() {
        return super.clone();
    }
}
