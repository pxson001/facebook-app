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

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: localphototags/* */
public final class GraphQLAllShareStoriesConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLAllShareStoriesConnection> CREATOR = new 1();
    public int f16900d;

    @FieldOffset
    public final int m23864a() {
        m9949a(0, 0);
        return this.f16900d;
    }

    public final int jK_() {
        return -1051680685;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLAllShareStoriesConnection() {
        super(2);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16900d = mutableFlatBuffer.m21524a(i, 0, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21494a(0, m23864a(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLAllShareStoriesConnection(Parcel parcel) {
        super(2);
        this.f16900d = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m23864a());
    }
}
