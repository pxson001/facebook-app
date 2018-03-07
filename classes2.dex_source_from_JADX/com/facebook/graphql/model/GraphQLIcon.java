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
/* compiled from: live_video_ended */
public final class GraphQLIcon extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLIcon> CREATOR = new C08011();
    public int f17313d;
    @Nullable
    public String f17314e;
    @Nullable
    public String f17315f;
    public int f17316g;

    /* compiled from: live_video_ended */
    final class C08011 implements Creator<GraphQLIcon> {
        C08011() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLIcon(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLIcon[i];
        }
    }

    @FieldOffset
    public final int m24377a() {
        m9949a(0, 0);
        return this.f17313d;
    }

    @FieldOffset
    @Nullable
    public final String m24381j() {
        this.f17314e = super.m9948a(this.f17314e, 1);
        return this.f17314e;
    }

    @FieldOffset
    @Nullable
    public final String m24382k() {
        this.f17315f = super.m9948a(this.f17315f, 2);
        return this.f17315f;
    }

    @FieldOffset
    public final int m24383l() {
        m9949a(0, 3);
        return this.f17316g;
    }

    public final int jK_() {
        return 2273433;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLIcon() {
        super(5);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17313d = mutableFlatBuffer.m21524a(i, 0, 0);
        this.f17316g = mutableFlatBuffer.m21524a(i, 3, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m24381j());
        int b2 = flatBufferBuilder.m21502b(m24382k());
        flatBufferBuilder.m21510c(4);
        flatBufferBuilder.m21494a(0, m24377a(), 0);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, b2);
        flatBufferBuilder.m21494a(3, m24383l(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLIcon(Parcel parcel) {
        super(5);
        this.f17313d = parcel.readInt();
        this.f17314e = parcel.readString();
        this.f17315f = parcel.readString();
        this.f17316g = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m24377a());
        parcel.writeString(m24381j());
        parcel.writeString(m24382k());
        parcel.writeInt(m24383l());
    }

    public GraphQLIcon(Builder builder) {
        super(5);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f17313d = builder.d;
        this.f17314e = builder.e;
        this.f17315f = builder.f;
        this.f17316g = builder.g;
    }
}
