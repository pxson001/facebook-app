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
/* compiled from: fetch_news_feed */
public final class GraphQLReshareEducationInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLReshareEducationInfo> CREATOR = new C09811();
    @Nullable
    public String f23997d;
    public boolean f23998e;
    public boolean f23999f;

    /* compiled from: fetch_news_feed */
    final class C09811 implements Creator<GraphQLReshareEducationInfo> {
        C09811() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLReshareEducationInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLReshareEducationInfo[i];
        }
    }

    @FieldOffset
    @Nullable
    public final String m32411a() {
        this.f23997d = super.m9948a(this.f23997d, 0);
        return this.f23997d;
    }

    @FieldOffset
    public final boolean m32413j() {
        m9949a(0, 1);
        return this.f23998e;
    }

    @FieldOffset
    public final boolean m32414k() {
        m9949a(0, 2);
        return this.f23999f;
    }

    public final int jK_() {
        return -2034873750;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLReshareEducationInfo() {
        super(4);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f23998e = mutableFlatBuffer.m21540a(i, 1);
        this.f23999f = mutableFlatBuffer.m21540a(i, 2);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m32411a());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21498a(1, m32413j());
        flatBufferBuilder.m21498a(2, m32414k());
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLReshareEducationInfo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(4);
        this.f23997d = parcel.readString();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f23998e = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f23999f = z2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(m32411a());
        if (m32413j()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!m32414k()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
    }
}
