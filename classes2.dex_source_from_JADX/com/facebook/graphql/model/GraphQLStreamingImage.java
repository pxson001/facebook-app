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
/* compiled from: layout_time */
public final class GraphQLStreamingImage extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLStreamingImage> CREATOR = new 1();
    public int f17747d;
    @Nullable
    public String f17748e;
    public int f17749f;

    @FieldOffset
    public final int m24966a() {
        m9949a(0, 0);
        return this.f17747d;
    }

    @FieldOffset
    @Nullable
    public final String m24970j() {
        this.f17748e = super.m9948a(this.f17748e, 1);
        return this.f17748e;
    }

    @FieldOffset
    public final int m24971k() {
        m9949a(0, 2);
        return this.f17749f;
    }

    public final int jK_() {
        return 886594105;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLStreamingImage() {
        super(4);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17747d = mutableFlatBuffer.m21524a(i, 0, 0);
        this.f17749f = mutableFlatBuffer.m21524a(i, 2, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m24970j());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21494a(0, m24966a(), 0);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21494a(2, m24971k(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLStreamingImage(Parcel parcel) {
        super(4);
        this.f17747d = parcel.readInt();
        this.f17748e = parcel.readString();
        this.f17749f = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m24966a());
        parcel.writeString(m24970j());
        parcel.writeInt(m24971k());
    }
}
