package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.enums.GraphQLPlaceSuggestionType;
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
/* compiled from: input_text */
public final class GraphQLPlaceSuggestionInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPlaceSuggestionInfo> CREATOR = new 1();
    @Nullable
    GraphQLPage f19840d;
    @Nullable
    String f19841e;
    GraphQLPlaceSuggestionType f19842f;

    @FieldOffset
    @Nullable
    public final GraphQLPage m27583a() {
        this.f19840d = (GraphQLPage) super.m9947a(this.f19840d, 0, GraphQLPage.class);
        return this.f19840d;
    }

    @FieldOffset
    @Nullable
    public final String m27585j() {
        this.f19841e = super.m9948a(this.f19841e, 1);
        return this.f19841e;
    }

    @FieldOffset
    public final GraphQLPlaceSuggestionType m27586k() {
        this.f19842f = (GraphQLPlaceSuggestionType) super.m9945a(this.f19842f, 2, GraphQLPlaceSuggestionType.class, GraphQLPlaceSuggestionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f19842f;
    }

    public final int jK_() {
        return 858887577;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m27583a() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.mo2928b(m27583a());
            if (m27583a() != graphQLPage) {
                graphQLVisitableModel = (GraphQLPlaceSuggestionInfo) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19840d = graphQLPage;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPlaceSuggestionInfo() {
        super(4);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m27583a());
        int b = flatBufferBuilder.m21502b(m27585j());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21496a(2, m27586k() == GraphQLPlaceSuggestionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m27586k());
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPlaceSuggestionInfo(Parcel parcel) {
        super(4);
        this.f19840d = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f19841e = parcel.readString();
        this.f19842f = GraphQLPlaceSuggestionType.fromString(parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m27583a());
        parcel.writeString(m27585j());
        parcel.writeString(m27586k().name());
    }

    public GraphQLPlaceSuggestionInfo(Builder builder) {
        super(4);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f19840d = builder.d;
        this.f19841e = builder.e;
        this.f19842f = builder.f;
    }
}
