package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.enums.GraphQLPlaceOpenStatusType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: inline_video_cover_image */
public final class GraphQLPlaceOpenStatusFormat extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPlaceOpenStatusFormat> CREATOR = new 1();
    GraphQLPlaceOpenStatusType f19876d;
    @Nullable
    GraphQLTimeRange f19877e;
    List<Long> f19878f;

    @FieldOffset
    public final GraphQLPlaceOpenStatusType m27633a() {
        this.f19876d = (GraphQLPlaceOpenStatusType) super.m9945a(this.f19876d, 0, GraphQLPlaceOpenStatusType.class, GraphQLPlaceOpenStatusType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f19876d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTimeRange m27635j() {
        this.f19877e = (GraphQLTimeRange) super.m9947a(this.f19877e, 1, GraphQLTimeRange.class);
        return this.f19877e;
    }

    @FieldOffset
    public final ImmutableList<Long> m27636k() {
        this.f19878f = super.m9955c(this.f19878f, 2);
        return (ImmutableList) this.f19878f;
    }

    public final int jK_() {
        return 1644908794;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m27635j() != null) {
            GraphQLTimeRange graphQLTimeRange = (GraphQLTimeRange) graphQLModelMutatingVisitor.mo2928b(m27635j());
            if (m27635j() != graphQLTimeRange) {
                graphQLVisitableModel = (GraphQLPlaceOpenStatusFormat) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19877e = graphQLTimeRange;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPlaceOpenStatusFormat() {
        super(4);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m27635j());
        int b = flatBufferBuilder.m21503b(m27636k());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21496a(0, m27633a() == GraphQLPlaceOpenStatusType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m27633a());
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, b);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPlaceOpenStatusFormat(Parcel parcel) {
        super(4);
        this.f19876d = GraphQLPlaceOpenStatusType.fromString(parcel.readString());
        this.f19877e = (GraphQLTimeRange) parcel.readValue(GraphQLTimeRange.class.getClassLoader());
        this.f19878f = ImmutableListHelper.m21625a(parcel.readArrayList(Long.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m27633a().name());
        parcel.writeValue(m27635j());
        parcel.writeList(m27636k());
    }
}
