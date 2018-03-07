package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: location_data */
public final class GraphQLVideoAnnotation extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLVideoAnnotation> CREATOR = new 1();
    public int f16687d;
    @Nullable
    public String f16688e;
    @Nullable
    public String f16689f;
    @Nullable
    public String f16690g;
    @Nullable
    public String f16691h;
    @Nullable
    public String f16692i;
    public int f16693j;

    @FieldOffset
    public final int m23570a() {
        m9949a(0, 0);
        return this.f16687d;
    }

    @FieldOffset
    @Nullable
    public final String m23574j() {
        this.f16688e = super.m9948a(this.f16688e, 1);
        return this.f16688e;
    }

    @FieldOffset
    @Nullable
    public final String m23575k() {
        this.f16689f = super.m9948a(this.f16689f, 2);
        return this.f16689f;
    }

    @FieldOffset
    @Nullable
    public final String m23576l() {
        this.f16690g = super.m9948a(this.f16690g, 3);
        return this.f16690g;
    }

    @FieldOffset
    @Nullable
    public final String m23577m() {
        this.f16691h = super.m9948a(this.f16691h, 4);
        return this.f16691h;
    }

    @FieldOffset
    @Nullable
    public final String m23578n() {
        this.f16692i = super.m9948a(this.f16692i, 5);
        return this.f16692i;
    }

    @FieldOffset
    public final int m23579o() {
        m9949a(0, 6);
        return this.f16693j;
    }

    public final int jK_() {
        return -1321372182;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLVideoAnnotation() {
        super(8);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16687d = mutableFlatBuffer.m21524a(i, 0, 0);
        this.f16693j = mutableFlatBuffer.m21524a(i, 6, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m23574j());
        int b2 = flatBufferBuilder.m21502b(m23575k());
        int b3 = flatBufferBuilder.m21502b(m23576l());
        int b4 = flatBufferBuilder.m21502b(m23577m());
        int b5 = flatBufferBuilder.m21502b(m23578n());
        flatBufferBuilder.m21510c(7);
        flatBufferBuilder.m21494a(0, m23570a(), 0);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, b2);
        flatBufferBuilder.m21507b(3, b3);
        flatBufferBuilder.m21507b(4, b4);
        flatBufferBuilder.m21507b(5, b5);
        flatBufferBuilder.m21494a(6, m23579o(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLVideoAnnotation(Parcel parcel) {
        super(8);
        this.f16687d = parcel.readInt();
        this.f16688e = parcel.readString();
        this.f16689f = parcel.readString();
        this.f16690g = parcel.readString();
        this.f16691h = parcel.readString();
        this.f16692i = parcel.readString();
        this.f16693j = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m23570a());
        parcel.writeString(m23574j());
        parcel.writeString(m23575k());
        parcel.writeString(m23576l());
        parcel.writeString(m23577m());
        parcel.writeString(m23578n());
        parcel.writeInt(m23579o());
    }
}
