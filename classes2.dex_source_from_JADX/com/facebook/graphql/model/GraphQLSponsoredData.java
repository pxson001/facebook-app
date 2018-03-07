package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.api.graphql.storypromotion.NewsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
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
/* compiled from: level */
public final class GraphQLSponsoredData extends BaseModel implements NewsFeedStoryPromotionGraphQLInterfaces$SponsoredDataFields, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLSponsoredData> CREATOR = new C07791();
    @Nullable
    public String f17627d;
    @Nullable
    public String f17628e;
    public boolean f17629f;
    public boolean f17630g;
    @Deprecated
    public boolean f17631h;
    public int f17632i;
    public boolean f17633j;
    public boolean f17634k;
    public boolean f17635l;
    @Nullable
    public String f17636m;
    public boolean f17637n;
    @Nullable
    public GraphQLUser f17638o;
    public boolean f17639p;
    public int f17640q;
    public int f17641r;
    public boolean f17642s;

    /* compiled from: level */
    final class C07791 implements Creator<GraphQLSponsoredData> {
        C07791() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSponsoredData(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSponsoredData[i];
        }
    }

    @FieldOffset
    @Nullable
    public final String m24812l() {
        this.f17627d = super.m9948a(this.f17627d, 0);
        return this.f17627d;
    }

    @FieldOffset
    @Nullable
    public final String mo2962a() {
        this.f17628e = super.m9948a(this.f17628e, 1);
        return this.f17628e;
    }

    @FieldOffset
    public final boolean mo2963b() {
        m9949a(0, 2);
        return this.f17629f;
    }

    @FieldOffset
    public final boolean mo2964c() {
        m9949a(0, 3);
        return this.f17630g;
    }

    @FieldOffset
    public final boolean m24813m() {
        m9949a(0, 4);
        return this.f17631h;
    }

    @FieldOffset
    public final int mo2965d() {
        m9949a(0, 5);
        return this.f17632i;
    }

    @FieldOffset
    public final boolean K_() {
        m9949a(0, 6);
        return this.f17633j;
    }

    @FieldOffset
    public final boolean mo2966g() {
        m9949a(0, 7);
        return this.f17634k;
    }

    @FieldOffset
    public final boolean m24814n() {
        m9949a(1, 0);
        return this.f17635l;
    }

    @FieldOffset
    @Nullable
    public final String m24815o() {
        this.f17636m = super.m9948a(this.f17636m, 9);
        return this.f17636m;
    }

    @FieldOffset
    public final boolean L_() {
        m9949a(1, 2);
        return this.f17637n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLUser m24816p() {
        this.f17638o = (GraphQLUser) super.m9947a(this.f17638o, 11, GraphQLUser.class);
        return this.f17638o;
    }

    @FieldOffset
    public final boolean M_() {
        m9949a(1, 4);
        return this.f17639p;
    }

    @FieldOffset
    public final int mo2967j() {
        m9949a(1, 5);
        return this.f17640q;
    }

    @FieldOffset
    public final int mo2968k() {
        m9949a(1, 6);
        return this.f17641r;
    }

    @FieldOffset
    public final boolean m24817q() {
        m9949a(1, 7);
        return this.f17642s;
    }

    public final int jK_() {
        return 516771939;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24816p() != null) {
            GraphQLUser graphQLUser = (GraphQLUser) graphQLModelMutatingVisitor.mo2928b(m24816p());
            if (m24816p() != graphQLUser) {
                graphQLVisitableModel = (GraphQLSponsoredData) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17638o = graphQLUser;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLSponsoredData() {
        super(17);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17629f = mutableFlatBuffer.m21540a(i, 2);
        this.f17630g = mutableFlatBuffer.m21540a(i, 3);
        this.f17631h = mutableFlatBuffer.m21540a(i, 4);
        this.f17632i = mutableFlatBuffer.m21524a(i, 5, 0);
        this.f17633j = mutableFlatBuffer.m21540a(i, 6);
        this.f17634k = mutableFlatBuffer.m21540a(i, 7);
        this.f17635l = mutableFlatBuffer.m21540a(i, 8);
        this.f17637n = mutableFlatBuffer.m21540a(i, 10);
        this.f17639p = mutableFlatBuffer.m21540a(i, 12);
        this.f17640q = mutableFlatBuffer.m21524a(i, 13, 0);
        this.f17641r = mutableFlatBuffer.m21524a(i, 14, 0);
        this.f17642s = mutableFlatBuffer.m21540a(i, 15);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m24812l());
        int b2 = flatBufferBuilder.m21502b(mo2962a());
        int b3 = flatBufferBuilder.m21502b(m24815o());
        int a = ModelHelper.m23093a(flatBufferBuilder, m24816p());
        flatBufferBuilder.m21510c(16);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21498a(2, mo2963b());
        flatBufferBuilder.m21498a(3, mo2964c());
        flatBufferBuilder.m21498a(4, m24813m());
        flatBufferBuilder.m21494a(5, mo2965d(), 0);
        flatBufferBuilder.m21498a(6, K_());
        flatBufferBuilder.m21498a(7, mo2966g());
        flatBufferBuilder.m21498a(8, m24814n());
        flatBufferBuilder.m21507b(9, b3);
        flatBufferBuilder.m21498a(10, L_());
        flatBufferBuilder.m21507b(11, a);
        flatBufferBuilder.m21498a(12, M_());
        flatBufferBuilder.m21494a(13, mo2967j(), 0);
        flatBufferBuilder.m21494a(14, mo2968k(), 0);
        flatBufferBuilder.m21498a(15, m24817q());
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLSponsoredData(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(17);
        this.f17627d = parcel.readString();
        this.f17628e = parcel.readString();
        this.f17629f = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17630g = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17642s = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17631h = z;
        this.f17632i = parcel.readInt();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17633j = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17634k = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17635l = z;
        this.f17636m = parcel.readString();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17637n = z;
        this.f17638o = (GraphQLUser) parcel.readValue(GraphQLUser.class.getClassLoader());
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f17639p = z2;
        this.f17640q = parcel.readInt();
        this.f17641r = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(m24812l());
        parcel.writeString(mo2962a());
        parcel.writeByte((byte) (mo2963b() ? 1 : 0));
        if (mo2964c()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24817q()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24813m()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(mo2965d());
        if (K_()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (mo2966g()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24814n()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(m24815o());
        if (L_()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(m24816p());
        if (!M_()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeInt(mo2967j());
        parcel.writeInt(mo2968k());
    }

    public GraphQLSponsoredData(Builder builder) {
        super(17);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f17627d = builder.d;
        this.f17628e = builder.e;
        this.f17629f = builder.f;
        this.f17630g = builder.g;
        this.f17642s = builder.h;
        this.f17631h = builder.i;
        this.f17632i = builder.j;
        this.f17633j = builder.k;
        this.f17634k = builder.l;
        this.f17635l = builder.m;
        this.f17636m = builder.n;
        this.f17637n = builder.o;
        this.f17638o = builder.p;
        this.f17639p = builder.q;
        this.f17640q = builder.r;
        this.f17641r = builder.s;
    }
}
