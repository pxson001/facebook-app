package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: input_method */
public final class GraphQLStoryAttachmentStyleInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLStoryAttachmentStyleInfo> CREATOR = new C07951();
    @Nullable
    GraphQLObjectType f19850d;
    @Nullable
    GraphQLGeoRectangle f19851e;
    @Nullable
    String f19852f;
    @Nullable
    String f19853g;
    List<GraphQLLocation> f19854h;
    int f19855i;
    int f19856j;
    int f19857k;
    int f19858l;
    @Nullable
    GraphQLLocation f19859m;
    List<GraphQLPlaceOpenStatusFormat> f19860n;
    @Nullable
    String f19861o;
    @Nullable
    GraphQLImage f19862p;
    List<GraphQLLocation> f19863q;
    boolean f19864r;
    boolean f19865s;
    @Nullable
    String f19866t;
    @Nullable
    String f19867u;
    @Nullable
    String f19868v;
    boolean f19869w;
    @Nullable
    String f19870x;
    @Nullable
    String f19871y;

    /* compiled from: input_method */
    final class C07951 implements Creator<GraphQLStoryAttachmentStyleInfo> {
        C07951() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLStoryAttachmentStyleInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLStoryAttachmentStyleInfo[i];
        }
    }

    @Nullable
    public final GraphQLObjectType m27605a() {
        if (this.f5823b != null && this.f19850d == null) {
            this.f19850d = new GraphQLObjectType(this.f5823b.m21542b(this.f5824c, 0));
        }
        if (this.f19850d == null || this.f19850d.m22301g() != 0) {
            return this.f19850d;
        }
        return null;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGeoRectangle m27608j() {
        this.f19851e = (GraphQLGeoRectangle) super.m9947a(this.f19851e, 1, GraphQLGeoRectangle.class);
        return this.f19851e;
    }

    @FieldOffset
    @Nullable
    public final String m27609k() {
        this.f19852f = super.m9948a(this.f19852f, 2);
        return this.f19852f;
    }

    @FieldOffset
    @Nullable
    public final String m27610l() {
        this.f19853g = super.m9948a(this.f19853g, 3);
        return this.f19853g;
    }

    @FieldOffset
    public final ImmutableList<GraphQLLocation> m27611m() {
        this.f19854h = super.m9944a(this.f19854h, 4, GraphQLLocation.class);
        return (ImmutableList) this.f19854h;
    }

    @FieldOffset
    public final int m27612n() {
        m9949a(0, 5);
        return this.f19855i;
    }

    @FieldOffset
    public final int m27613o() {
        m9949a(0, 6);
        return this.f19856j;
    }

    @FieldOffset
    public final int m27614p() {
        m9949a(0, 7);
        return this.f19857k;
    }

    @FieldOffset
    public final int m27615q() {
        m9949a(1, 0);
        return this.f19858l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLLocation m27616r() {
        this.f19859m = (GraphQLLocation) super.m9947a(this.f19859m, 9, GraphQLLocation.class);
        return this.f19859m;
    }

    @FieldOffset
    public final ImmutableList<GraphQLPlaceOpenStatusFormat> m27617s() {
        this.f19860n = super.m9944a(this.f19860n, 10, GraphQLPlaceOpenStatusFormat.class);
        return (ImmutableList) this.f19860n;
    }

    @FieldOffset
    @Nullable
    public final String m27618t() {
        this.f19861o = super.m9948a(this.f19861o, 11);
        return this.f19861o;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m27619u() {
        this.f19862p = (GraphQLImage) super.m9947a(this.f19862p, 12, GraphQLImage.class);
        return this.f19862p;
    }

    @FieldOffset
    public final ImmutableList<GraphQLLocation> m27620v() {
        this.f19863q = super.m9944a(this.f19863q, 13, GraphQLLocation.class);
        return (ImmutableList) this.f19863q;
    }

    @FieldOffset
    public final boolean m27621w() {
        m9949a(1, 6);
        return this.f19864r;
    }

    @FieldOffset
    public final boolean m27622x() {
        m9949a(1, 7);
        return this.f19865s;
    }

    @FieldOffset
    @Nullable
    public final String m27623y() {
        this.f19866t = super.m9948a(this.f19866t, 16);
        return this.f19866t;
    }

    @FieldOffset
    @Nullable
    public final String m27624z() {
        this.f19867u = super.m9948a(this.f19867u, 17);
        return this.f19867u;
    }

    @FieldOffset
    @Nullable
    public final String m27600A() {
        this.f19868v = super.m9948a(this.f19868v, 18);
        return this.f19868v;
    }

    @FieldOffset
    public final boolean m27601B() {
        m9949a(2, 3);
        return this.f19869w;
    }

    @FieldOffset
    @Nullable
    public final String m27602C() {
        this.f19870x = super.m9948a(this.f19870x, 20);
        return this.f19870x;
    }

    @FieldOffset
    @Nullable
    public final String m27603D() {
        this.f19871y = super.m9948a(this.f19871y, 21);
        return this.f19871y;
    }

    public final int jK_() {
        return -1248513785;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m27608j() != null) {
            GraphQLGeoRectangle graphQLGeoRectangle = (GraphQLGeoRectangle) graphQLModelMutatingVisitor.mo2928b(m27608j());
            if (m27608j() != graphQLGeoRectangle) {
                graphQLVisitableModel = (GraphQLStoryAttachmentStyleInfo) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19851e = graphQLGeoRectangle;
            }
        }
        if (m27611m() != null) {
            a = ModelHelper.m23097a(m27611m(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLStoryAttachmentStyleInfo graphQLStoryAttachmentStyleInfo = (GraphQLStoryAttachmentStyleInfo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLStoryAttachmentStyleInfo.f19854h = a.m1068b();
                graphQLVisitableModel = graphQLStoryAttachmentStyleInfo;
            }
        }
        if (m27616r() != null) {
            GraphQLLocation graphQLLocation = (GraphQLLocation) graphQLModelMutatingVisitor.mo2928b(m27616r());
            if (m27616r() != graphQLLocation) {
                graphQLVisitableModel = (GraphQLStoryAttachmentStyleInfo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19859m = graphQLLocation;
            }
        }
        if (m27619u() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m27619u());
            if (m27619u() != graphQLImage) {
                graphQLVisitableModel = (GraphQLStoryAttachmentStyleInfo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19862p = graphQLImage;
            }
        }
        if (m27620v() != null) {
            a = ModelHelper.m23097a(m27620v(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLStoryAttachmentStyleInfo = (GraphQLStoryAttachmentStyleInfo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLStoryAttachmentStyleInfo.f19863q = a.m1068b();
                graphQLVisitableModel = graphQLStoryAttachmentStyleInfo;
            }
        }
        if (m27617s() != null) {
            a = ModelHelper.m23097a(m27617s(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLStoryAttachmentStyleInfo = (GraphQLStoryAttachmentStyleInfo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLStoryAttachmentStyleInfo.f19860n = a.m1068b();
                graphQLVisitableModel = graphQLStoryAttachmentStyleInfo;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLStoryAttachmentStyleInfo() {
        super(23);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f19855i = mutableFlatBuffer.m21524a(i, 5, 0);
        this.f19856j = mutableFlatBuffer.m21524a(i, 6, 0);
        this.f19857k = mutableFlatBuffer.m21524a(i, 7, 0);
        this.f19858l = mutableFlatBuffer.m21524a(i, 8, 0);
        this.f19864r = mutableFlatBuffer.m21540a(i, 14);
        this.f19865s = mutableFlatBuffer.m21540a(i, 15);
        this.f19869w = mutableFlatBuffer.m21540a(i, 19);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = flatBufferBuilder.m21479a(m27605a() != null ? m27605a().m22299e() : null);
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m27608j());
        int b = flatBufferBuilder.m21502b(m27609k());
        int b2 = flatBufferBuilder.m21502b(m27610l());
        int a3 = ModelHelper.m23094a(flatBufferBuilder, m27611m());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m27616r());
        int a5 = ModelHelper.m23094a(flatBufferBuilder, m27617s());
        int b3 = flatBufferBuilder.m21502b(m27618t());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m27619u());
        int a7 = ModelHelper.m23094a(flatBufferBuilder, m27620v());
        int b4 = flatBufferBuilder.m21502b(m27623y());
        int b5 = flatBufferBuilder.m21502b(m27624z());
        int b6 = flatBufferBuilder.m21502b(m27600A());
        int b7 = flatBufferBuilder.m21502b(m27602C());
        int b8 = flatBufferBuilder.m21502b(m27603D());
        flatBufferBuilder.m21510c(22);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(2, b);
        flatBufferBuilder.m21507b(3, b2);
        flatBufferBuilder.m21507b(4, a3);
        flatBufferBuilder.m21494a(5, m27612n(), 0);
        flatBufferBuilder.m21494a(6, m27613o(), 0);
        flatBufferBuilder.m21494a(7, m27614p(), 0);
        flatBufferBuilder.m21494a(8, m27615q(), 0);
        flatBufferBuilder.m21507b(9, a4);
        flatBufferBuilder.m21507b(10, a5);
        flatBufferBuilder.m21507b(11, b3);
        flatBufferBuilder.m21507b(12, a6);
        flatBufferBuilder.m21507b(13, a7);
        flatBufferBuilder.m21498a(14, m27621w());
        flatBufferBuilder.m21498a(15, m27622x());
        flatBufferBuilder.m21507b(16, b4);
        flatBufferBuilder.m21507b(17, b5);
        flatBufferBuilder.m21507b(18, b6);
        flatBufferBuilder.m21498a(19, m27601B());
        flatBufferBuilder.m21507b(20, b7);
        flatBufferBuilder.m21507b(21, b8);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLStoryAttachmentStyleInfo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(23);
        this.f19864r = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f19865s = z;
        this.f19851e = (GraphQLGeoRectangle) parcel.readValue(GraphQLGeoRectangle.class.getClassLoader());
        this.f19852f = parcel.readString();
        this.f19866t = parcel.readString();
        this.f19867u = parcel.readString();
        this.f19853g = parcel.readString();
        this.f19854h = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLLocation.class.getClassLoader()));
        this.f19855i = parcel.readInt();
        this.f19856j = parcel.readInt();
        this.f19857k = parcel.readInt();
        this.f19858l = parcel.readInt();
        this.f19859m = (GraphQLLocation) parcel.readValue(GraphQLLocation.class.getClassLoader());
        this.f19862p = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f19868v = parcel.readString();
        this.f19863q = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLLocation.class.getClassLoader()));
        this.f19860n = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLPlaceOpenStatusFormat.class.getClassLoader()));
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f19869w = z2;
        this.f19870x = parcel.readString();
        this.f19861o = parcel.readString();
        this.f19871y = parcel.readString();
        this.f19850d = (GraphQLObjectType) ParcelUtil.b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeByte((byte) (m27621w() ? 1 : 0));
        if (m27622x()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(m27608j());
        parcel.writeString(m27609k());
        parcel.writeString(m27623y());
        parcel.writeString(m27624z());
        parcel.writeString(m27610l());
        parcel.writeList(m27611m());
        parcel.writeInt(m27612n());
        parcel.writeInt(m27613o());
        parcel.writeInt(m27614p());
        parcel.writeInt(m27615q());
        parcel.writeValue(m27616r());
        parcel.writeValue(m27619u());
        parcel.writeString(m27600A());
        parcel.writeList(m27620v());
        parcel.writeList(m27617s());
        if (!m27601B()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(m27602C());
        parcel.writeString(m27618t());
        parcel.writeString(m27603D());
        parcel.writeParcelable(this.f19850d, i);
    }

    public GraphQLStoryAttachmentStyleInfo(Builder builder) {
        super(23);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f19864r = builder.d;
        this.f19865s = builder.e;
        this.f19851e = builder.f;
        this.f19852f = builder.g;
        this.f19866t = builder.h;
        this.f19867u = builder.i;
        this.f19853g = builder.j;
        this.f19854h = builder.k;
        this.f19855i = builder.l;
        this.f19856j = builder.m;
        this.f19857k = builder.n;
        this.f19858l = builder.o;
        this.f19859m = builder.p;
        this.f19862p = builder.q;
        this.f19868v = builder.r;
        this.f19863q = builder.s;
        this.f19860n = builder.t;
        this.f19869w = builder.u;
        this.f19870x = builder.v;
        this.f19861o = builder.w;
        this.f19871y = builder.x;
        this.f19850d = builder.y;
    }
}
