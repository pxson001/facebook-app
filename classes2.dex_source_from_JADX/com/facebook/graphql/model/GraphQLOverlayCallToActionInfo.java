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
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: location_status */
public final class GraphQLOverlayCallToActionInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLOverlayCallToActionInfo> CREATOR = new 1();
    @Nullable
    GraphQLObjectType f16500d;
    @Nullable
    GraphQLGroupCreationSuggestion f16501e;
    @Deprecated
    @Nullable
    String f16502f;

    @Nullable
    public final GraphQLObjectType m23339a() {
        if (this.f5823b != null && this.f16500d == null) {
            this.f16500d = new GraphQLObjectType(this.f5823b.m21542b(this.f5824c, 0));
        }
        if (this.f16500d == null || this.f16500d.m22301g() != 0) {
            return this.f16500d;
        }
        return null;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGroupCreationSuggestion m23341j() {
        this.f16501e = (GraphQLGroupCreationSuggestion) super.m9947a(this.f16501e, 1, GraphQLGroupCreationSuggestion.class);
        return this.f16501e;
    }

    @FieldOffset
    @Nullable
    public final String m23342k() {
        this.f16502f = super.m9948a(this.f16502f, 3);
        return this.f16502f;
    }

    public final int jK_() {
        return 1570278061;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23341j() != null) {
            GraphQLGroupCreationSuggestion graphQLGroupCreationSuggestion = (GraphQLGroupCreationSuggestion) graphQLModelMutatingVisitor.mo2928b(m23341j());
            if (m23341j() != graphQLGroupCreationSuggestion) {
                graphQLVisitableModel = (GraphQLOverlayCallToActionInfo) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16501e = graphQLGroupCreationSuggestion;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLOverlayCallToActionInfo() {
        super(5);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = flatBufferBuilder.m21479a(m23339a() != null ? m23339a().m22299e() : null);
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23341j());
        int b = flatBufferBuilder.m21502b(m23342k());
        flatBufferBuilder.m21510c(4);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(3, b);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLOverlayCallToActionInfo(Parcel parcel) {
        super(5);
        this.f16501e = (GraphQLGroupCreationSuggestion) parcel.readValue(GraphQLGroupCreationSuggestion.class.getClassLoader());
        this.f16502f = parcel.readString();
        this.f16500d = (GraphQLObjectType) ParcelUtil.b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m23341j());
        parcel.writeString(m23342k());
        parcel.writeParcelable(this.f16500d, i);
    }
}
