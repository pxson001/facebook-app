package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: link_type */
public final class GraphQLContact extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLContact> CREATOR = new 1();
    @Nullable
    GraphQLImage f17406A;
    @Nullable
    String f17407B;
    long f17408d;
    @Nullable
    GraphQLImage f17409e;
    @Nullable
    GraphQLImage f17410f;
    @Nullable
    String f17411g;
    @Nullable
    GraphQLImage f17412h;
    @Nullable
    String f17413i;
    @Nullable
    GraphQLImage f17414j;
    @Deprecated
    @Nullable
    GraphQLInlineActivitiesConnection f17415k;
    boolean f17416l;
    @Nullable
    String f17417m;
    @Nullable
    GraphQLName f17418n;
    @Nullable
    GraphQLImage f17419o;
    @Nullable
    GraphQLImage f17420p;
    @Nullable
    GraphQLImage f17421q;
    @Nullable
    GraphQLImage f17422r;
    @Nullable
    GraphQLImage f17423s;
    @Nullable
    GraphQLPhoto f17424t;
    @Nullable
    GraphQLImage f17425u;
    boolean f17426v;
    @Nullable
    GraphQLActor f17427w;
    @Nullable
    GraphQLImage f17428x;
    @Nullable
    GraphQLStreamingImage f17429y;
    @Nullable
    GraphQLName f17430z;

    @FieldOffset
    public final long m24509j() {
        m9949a(0, 0);
        return this.f17408d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24510k() {
        this.f17409e = (GraphQLImage) super.m9947a(this.f17409e, 1, GraphQLImage.class);
        return this.f17409e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24511l() {
        this.f17410f = (GraphQLImage) super.m9947a(this.f17410f, 2, GraphQLImage.class);
        return this.f17410f;
    }

    @FieldOffset
    @Nullable
    public final String m24512m() {
        this.f17411g = super.m9948a(this.f17411g, 3);
        return this.f17411g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24513n() {
        this.f17412h = (GraphQLImage) super.m9947a(this.f17412h, 4, GraphQLImage.class);
        return this.f17412h;
    }

    @FieldOffset
    @Nullable
    public final String m24514o() {
        this.f17413i = super.m9948a(this.f17413i, 5);
        return this.f17413i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24515p() {
        this.f17414j = (GraphQLImage) super.m9947a(this.f17414j, 6, GraphQLImage.class);
        return this.f17414j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInlineActivitiesConnection m24516q() {
        this.f17415k = (GraphQLInlineActivitiesConnection) super.m9947a(this.f17415k, 7, GraphQLInlineActivitiesConnection.class);
        return this.f17415k;
    }

    @FieldOffset
    public final boolean m24517r() {
        m9949a(1, 0);
        return this.f17416l;
    }

    @FieldOffset
    @Nullable
    public final String m24518s() {
        this.f17417m = super.m9948a(this.f17417m, 9);
        return this.f17417m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLName m24519t() {
        this.f17418n = (GraphQLName) super.m9947a(this.f17418n, 10, GraphQLName.class);
        return this.f17418n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24520u() {
        this.f17419o = (GraphQLImage) super.m9947a(this.f17419o, 11, GraphQLImage.class);
        return this.f17419o;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24521v() {
        this.f17420p = (GraphQLImage) super.m9947a(this.f17420p, 12, GraphQLImage.class);
        return this.f17420p;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24522w() {
        this.f17421q = (GraphQLImage) super.m9947a(this.f17421q, 13, GraphQLImage.class);
        return this.f17421q;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24523x() {
        this.f17422r = (GraphQLImage) super.m9947a(this.f17422r, 14, GraphQLImage.class);
        return this.f17422r;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24524y() {
        this.f17423s = (GraphQLImage) super.m9947a(this.f17423s, 15, GraphQLImage.class);
        return this.f17423s;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhoto m24525z() {
        this.f17424t = (GraphQLPhoto) super.m9947a(this.f17424t, 16, GraphQLPhoto.class);
        return this.f17424t;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24497A() {
        this.f17425u = (GraphQLImage) super.m9947a(this.f17425u, 17, GraphQLImage.class);
        return this.f17425u;
    }

    @FieldOffset
    public final boolean m24498B() {
        m9949a(2, 2);
        return this.f17426v;
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor m24499C() {
        this.f17427w = (GraphQLActor) super.m9947a(this.f17427w, 19, GraphQLActor.class);
        return this.f17427w;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24500D() {
        this.f17428x = (GraphQLImage) super.m9947a(this.f17428x, 20, GraphQLImage.class);
        return this.f17428x;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStreamingImage m24501E() {
        this.f17429y = (GraphQLStreamingImage) super.m9947a(this.f17429y, 21, GraphQLStreamingImage.class);
        return this.f17429y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLName m24502F() {
        this.f17430z = (GraphQLName) super.m9947a(this.f17430z, 22, GraphQLName.class);
        return this.f17430z;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24503G() {
        this.f17406A = (GraphQLImage) super.m9947a(this.f17406A, 23, GraphQLImage.class);
        return this.f17406A;
    }

    @FieldOffset
    @Nullable
    public final String m24504H() {
        this.f17407B = super.m9948a(this.f17407B, 24);
        return this.f17407B;
    }

    @Nullable
    public final String mo2834a() {
        return m24514o();
    }

    public final int jK_() {
        return -1678787584;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLImage graphQLImage;
        GraphQLName graphQLName;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24510k() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24510k());
            if (m24510k() != graphQLImage) {
                graphQLVisitableModel = (GraphQLContact) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17409e = graphQLImage;
            }
        }
        if (m24511l() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24511l());
            if (m24511l() != graphQLImage) {
                graphQLVisitableModel = (GraphQLContact) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17410f = graphQLImage;
            }
        }
        if (m24513n() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24513n());
            if (m24513n() != graphQLImage) {
                graphQLVisitableModel = (GraphQLContact) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17412h = graphQLImage;
            }
        }
        if (m24515p() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24515p());
            if (m24515p() != graphQLImage) {
                graphQLVisitableModel = (GraphQLContact) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17414j = graphQLImage;
            }
        }
        if (m24516q() != null) {
            GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection = (GraphQLInlineActivitiesConnection) graphQLModelMutatingVisitor.mo2928b(m24516q());
            if (m24516q() != graphQLInlineActivitiesConnection) {
                graphQLVisitableModel = (GraphQLContact) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17415k = graphQLInlineActivitiesConnection;
            }
        }
        if (m24519t() != null) {
            graphQLName = (GraphQLName) graphQLModelMutatingVisitor.mo2928b(m24519t());
            if (m24519t() != graphQLName) {
                graphQLVisitableModel = (GraphQLContact) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17418n = graphQLName;
            }
        }
        if (m24520u() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24520u());
            if (m24520u() != graphQLImage) {
                graphQLVisitableModel = (GraphQLContact) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17419o = graphQLImage;
            }
        }
        if (m24521v() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24521v());
            if (m24521v() != graphQLImage) {
                graphQLVisitableModel = (GraphQLContact) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17420p = graphQLImage;
            }
        }
        if (m24522w() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24522w());
            if (m24522w() != graphQLImage) {
                graphQLVisitableModel = (GraphQLContact) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17421q = graphQLImage;
            }
        }
        if (m24523x() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24523x());
            if (m24523x() != graphQLImage) {
                graphQLVisitableModel = (GraphQLContact) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17422r = graphQLImage;
            }
        }
        if (m24524y() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24524y());
            if (m24524y() != graphQLImage) {
                graphQLVisitableModel = (GraphQLContact) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17423s = graphQLImage;
            }
        }
        if (m24525z() != null) {
            GraphQLPhoto graphQLPhoto = (GraphQLPhoto) graphQLModelMutatingVisitor.mo2928b(m24525z());
            if (m24525z() != graphQLPhoto) {
                graphQLVisitableModel = (GraphQLContact) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17424t = graphQLPhoto;
            }
        }
        if (m24497A() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24497A());
            if (m24497A() != graphQLImage) {
                graphQLVisitableModel = (GraphQLContact) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17425u = graphQLImage;
            }
        }
        if (m24499C() != null) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.mo2928b(m24499C());
            if (m24499C() != graphQLActor) {
                graphQLVisitableModel = (GraphQLContact) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17427w = graphQLActor;
            }
        }
        if (m24500D() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24500D());
            if (m24500D() != graphQLImage) {
                graphQLVisitableModel = (GraphQLContact) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17428x = graphQLImage;
            }
        }
        if (m24501E() != null) {
            GraphQLStreamingImage graphQLStreamingImage = (GraphQLStreamingImage) graphQLModelMutatingVisitor.mo2928b(m24501E());
            if (m24501E() != graphQLStreamingImage) {
                graphQLVisitableModel = (GraphQLContact) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17429y = graphQLStreamingImage;
            }
        }
        if (m24502F() != null) {
            graphQLName = (GraphQLName) graphQLModelMutatingVisitor.mo2928b(m24502F());
            if (m24502F() != graphQLName) {
                graphQLVisitableModel = (GraphQLContact) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17430z = graphQLName;
            }
        }
        if (m24503G() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24503G());
            if (m24503G() != graphQLImage) {
                graphQLVisitableModel = (GraphQLContact) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17406A = graphQLImage;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLContact() {
        super(26);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17408d = mutableFlatBuffer.m21525a(i, 0, 0);
        this.f17416l = mutableFlatBuffer.m21540a(i, 8);
        this.f17426v = mutableFlatBuffer.m21540a(i, 18);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m24510k());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24511l());
        int b = flatBufferBuilder.m21502b(m24512m());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m24513n());
        int b2 = flatBufferBuilder.m21502b(m24514o());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m24515p());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m24516q());
        int b3 = flatBufferBuilder.m21502b(m24518s());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m24519t());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m24520u());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m24521v());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, m24522w());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, m24523x());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, m24524y());
        int a12 = ModelHelper.m23093a(flatBufferBuilder, m24525z());
        int a13 = ModelHelper.m23093a(flatBufferBuilder, m24497A());
        int a14 = ModelHelper.m23093a(flatBufferBuilder, m24499C());
        int a15 = ModelHelper.m23093a(flatBufferBuilder, m24500D());
        int a16 = ModelHelper.m23093a(flatBufferBuilder, m24501E());
        int a17 = ModelHelper.m23093a(flatBufferBuilder, m24502F());
        int a18 = ModelHelper.m23093a(flatBufferBuilder, m24503G());
        int b4 = flatBufferBuilder.m21502b(m24504H());
        flatBufferBuilder.m21510c(25);
        flatBufferBuilder.m21495a(0, m24509j(), 0);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21507b(3, b);
        flatBufferBuilder.m21507b(4, a3);
        flatBufferBuilder.m21507b(5, b2);
        flatBufferBuilder.m21507b(6, a4);
        flatBufferBuilder.m21507b(7, a5);
        flatBufferBuilder.m21498a(8, m24517r());
        flatBufferBuilder.m21507b(9, b3);
        flatBufferBuilder.m21507b(10, a6);
        flatBufferBuilder.m21507b(11, a7);
        flatBufferBuilder.m21507b(12, a8);
        flatBufferBuilder.m21507b(13, a9);
        flatBufferBuilder.m21507b(14, a10);
        flatBufferBuilder.m21507b(15, a11);
        flatBufferBuilder.m21507b(16, a12);
        flatBufferBuilder.m21507b(17, a13);
        flatBufferBuilder.m21498a(18, m24498B());
        flatBufferBuilder.m21507b(19, a14);
        flatBufferBuilder.m21507b(20, a15);
        flatBufferBuilder.m21507b(21, a16);
        flatBufferBuilder.m21507b(22, a17);
        flatBufferBuilder.m21507b(23, a18);
        flatBufferBuilder.m21507b(24, b4);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLContact(Parcel parcel) {
        boolean z = true;
        super(26);
        this.f17408d = parcel.readLong();
        this.f17409e = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17410f = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17411g = parcel.readString();
        this.f17412h = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17413i = parcel.readString();
        this.f17414j = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17415k = (GraphQLInlineActivitiesConnection) parcel.readValue(GraphQLInlineActivitiesConnection.class.getClassLoader());
        this.f17416l = parcel.readByte() == (byte) 1;
        this.f17417m = parcel.readString();
        this.f17418n = (GraphQLName) parcel.readValue(GraphQLName.class.getClassLoader());
        this.f17419o = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17420p = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17421q = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17422r = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17423s = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17424t = (GraphQLPhoto) parcel.readValue(GraphQLPhoto.class.getClassLoader());
        this.f17425u = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f17426v = z;
        this.f17427w = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
        this.f17428x = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17429y = (GraphQLStreamingImage) parcel.readValue(GraphQLStreamingImage.class.getClassLoader());
        this.f17430z = (GraphQLName) parcel.readValue(GraphQLName.class.getClassLoader());
        this.f17406A = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17407B = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeLong(m24509j());
        parcel.writeValue(m24510k());
        parcel.writeValue(m24511l());
        parcel.writeString(m24512m());
        parcel.writeValue(m24513n());
        parcel.writeString(m24514o());
        parcel.writeValue(m24515p());
        parcel.writeValue(m24516q());
        parcel.writeByte((byte) (m24517r() ? 1 : 0));
        parcel.writeString(m24518s());
        parcel.writeValue(m24519t());
        parcel.writeValue(m24520u());
        parcel.writeValue(m24521v());
        parcel.writeValue(m24522w());
        parcel.writeValue(m24523x());
        parcel.writeValue(m24524y());
        parcel.writeValue(m24525z());
        parcel.writeValue(m24497A());
        if (!m24498B()) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(m24499C());
        parcel.writeValue(m24500D());
        parcel.writeValue(m24501E());
        parcel.writeValue(m24502F());
        parcel.writeValue(m24503G());
        parcel.writeString(m24504H());
    }
}
