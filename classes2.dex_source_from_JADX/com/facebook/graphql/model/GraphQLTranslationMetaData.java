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
/* compiled from: lead_gen_continued_flow_title */
public final class GraphQLTranslationMetaData extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLTranslationMetaData> CREATOR = new 1();
    public int f17713d;
    @Nullable
    public String f17714e;

    @FieldOffset
    public final int m24913a() {
        m9949a(0, 0);
        return this.f17713d;
    }

    @FieldOffset
    @Nullable
    public final String m24917j() {
        this.f17714e = super.m9948a(this.f17714e, 1);
        return this.f17714e;
    }

    public final int jK_() {
        return -1590309632;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLTranslationMetaData() {
        super(3);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17713d = mutableFlatBuffer.m21524a(i, 0, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m24917j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21494a(0, m24913a(), 0);
        flatBufferBuilder.m21507b(1, b);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLTranslationMetaData(Parcel parcel) {
        super(3);
        this.f17713d = parcel.readInt();
        this.f17714e = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m24913a());
        parcel.writeString(m24917j());
    }
}
