package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
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

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: like_link */
public final class GraphQLPlaceRecommendationPostInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPlaceRecommendationPostInfo> CREATOR = new 1();
    public double f17517d;
    public List<GraphQLPage> f17518e;

    @FieldOffset
    public final double m24657a() {
        m9949a(0, 0);
        return this.f17517d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLPage> m24661j() {
        this.f17518e = super.m9944a(this.f17518e, 1, GraphQLPage.class);
        return (ImmutableList) this.f17518e;
    }

    public final int jK_() {
        return -248522226;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24661j() != null) {
            Builder a = ModelHelper.m23097a(m24661j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLPlaceRecommendationPostInfo) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17518e = a.m1068b();
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPlaceRecommendationPostInfo() {
        super(3);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17517d = mutableFlatBuffer.m21523a(i, 0, 0.0d);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m24661j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21492a(0, m24657a(), 0.0d);
        flatBufferBuilder.m21507b(1, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPlaceRecommendationPostInfo(Parcel parcel) {
        super(3);
        this.f17517d = parcel.readDouble();
        this.f17518e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLPage.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(m24657a());
        parcel.writeList(m24661j());
    }
}
