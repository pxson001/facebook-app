package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLInlineStyle;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: locationServices */
public final class GraphQLInlineStyleAtRange extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLInlineStyleAtRange> CREATOR = new 1();
    public GraphQLInlineStyle f16705d;
    public int f16706e;
    public int f16707f;

    @FieldOffset
    public final GraphQLInlineStyle m23604a() {
        this.f16705d = (GraphQLInlineStyle) super.m9945a(this.f16705d, 0, GraphQLInlineStyle.class, GraphQLInlineStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16705d;
    }

    @FieldOffset
    public final int m23607j() {
        m9949a(0, 1);
        return this.f16706e;
    }

    @FieldOffset
    public final int m23608k() {
        m9949a(0, 2);
        return this.f16707f;
    }

    public final int jK_() {
        return 282811186;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLInlineStyleAtRange() {
        super(4);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16706e = mutableFlatBuffer.m21524a(i, 1, 0);
        this.f16707f = mutableFlatBuffer.m21524a(i, 2, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21496a(0, m23604a() == GraphQLInlineStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23604a());
        flatBufferBuilder.m21494a(1, m23607j(), 0);
        flatBufferBuilder.m21494a(2, m23608k(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLInlineStyleAtRange(Parcel parcel) {
        super(4);
        this.f16705d = GraphQLInlineStyle.fromString(parcel.readString());
        this.f16706e = parcel.readInt();
        this.f16707f = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m23604a().name());
        parcel.writeInt(m23607j());
        parcel.writeInt(m23608k());
    }
}
