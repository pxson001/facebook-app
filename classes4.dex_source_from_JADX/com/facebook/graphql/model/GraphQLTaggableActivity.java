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
/* compiled from: userId is still null after AuthLoggedInEvent fired */
public final class GraphQLTaggableActivity extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLTaggableActivity> CREATOR = new C00421();
    @Nullable
    GraphQLTaggableActivityAllIconsConnection f416d;
    @Nullable
    GraphQLImage f417e;
    @Nullable
    GraphQLImage f418f;
    @Nullable
    String f419g;
    boolean f420h;
    @Nullable
    String f421i;
    int f422j;
    @Nullable
    String f423k;
    @Nullable
    GraphQLTaggableActivityPreviewTemplate f424l;
    @Nullable
    GraphQLTaggableActivityPreviewTemplate f425m;
    @Nullable
    GraphQLTaggableActivityPreviewTemplate f426n;
    @Nullable
    GraphQLTaggableActivityPreviewTemplate f427o;
    @Nullable
    GraphQLTaggableActivityPreviewTemplate f428p;
    @Nullable
    GraphQLTaggableActivityPreviewTemplate f429q;
    @Nullable
    String f430r;
    boolean f431s;
    boolean f432t;
    boolean f433u;
    @Nullable
    String f434v;

    /* compiled from: userId is still null after AuthLoggedInEvent fired */
    final class C00421 implements Creator<GraphQLTaggableActivity> {
        C00421() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLTaggableActivity(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLTaggableActivity[i];
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLTaggableActivityAllIconsConnection m713j() {
        this.f416d = (GraphQLTaggableActivityAllIconsConnection) super.a(this.f416d, 0, GraphQLTaggableActivityAllIconsConnection.class);
        return this.f416d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m714k() {
        this.f417e = (GraphQLImage) super.a(this.f417e, 1, GraphQLImage.class);
        return this.f417e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m715l() {
        this.f418f = (GraphQLImage) super.a(this.f418f, 2, GraphQLImage.class);
        return this.f418f;
    }

    @FieldOffset
    @Nullable
    public final String m716m() {
        this.f419g = super.a(this.f419g, 3);
        return this.f419g;
    }

    @FieldOffset
    public final boolean m717n() {
        a(0, 4);
        return this.f420h;
    }

    @FieldOffset
    @Nullable
    public final String m718o() {
        this.f421i = super.a(this.f421i, 5);
        return this.f421i;
    }

    @FieldOffset
    public final int m719p() {
        a(0, 6);
        return this.f422j;
    }

    @FieldOffset
    @Nullable
    public final String m720q() {
        this.f423k = super.a(this.f423k, 7);
        return this.f423k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTaggableActivityPreviewTemplate m721r() {
        this.f424l = (GraphQLTaggableActivityPreviewTemplate) super.a(this.f424l, 8, GraphQLTaggableActivityPreviewTemplate.class);
        return this.f424l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTaggableActivityPreviewTemplate m722s() {
        this.f425m = (GraphQLTaggableActivityPreviewTemplate) super.a(this.f425m, 9, GraphQLTaggableActivityPreviewTemplate.class);
        return this.f425m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTaggableActivityPreviewTemplate m723t() {
        this.f426n = (GraphQLTaggableActivityPreviewTemplate) super.a(this.f426n, 10, GraphQLTaggableActivityPreviewTemplate.class);
        return this.f426n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTaggableActivityPreviewTemplate m724u() {
        this.f427o = (GraphQLTaggableActivityPreviewTemplate) super.a(this.f427o, 11, GraphQLTaggableActivityPreviewTemplate.class);
        return this.f427o;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTaggableActivityPreviewTemplate m725v() {
        this.f428p = (GraphQLTaggableActivityPreviewTemplate) super.a(this.f428p, 12, GraphQLTaggableActivityPreviewTemplate.class);
        return this.f428p;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTaggableActivityPreviewTemplate m726w() {
        this.f429q = (GraphQLTaggableActivityPreviewTemplate) super.a(this.f429q, 13, GraphQLTaggableActivityPreviewTemplate.class);
        return this.f429q;
    }

    @FieldOffset
    @Nullable
    public final String m727x() {
        this.f430r = super.a(this.f430r, 14);
        return this.f430r;
    }

    @FieldOffset
    public final boolean m728y() {
        a(1, 7);
        return this.f431s;
    }

    @FieldOffset
    public final boolean m729z() {
        a(2, 0);
        return this.f432t;
    }

    @FieldOffset
    public final boolean m707A() {
        a(2, 1);
        return this.f433u;
    }

    @FieldOffset
    @Nullable
    public final String m708B() {
        this.f434v = super.a(this.f434v, 18);
        return this.f434v;
    }

    @Nullable
    public final String m711a() {
        return m716m();
    }

    public final int jK_() {
        return -934090;
    }

    public final GraphQLVisitableModel m710a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLImage graphQLImage;
        GraphQLTaggableActivityPreviewTemplate graphQLTaggableActivityPreviewTemplate;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m713j() != null) {
            GraphQLTaggableActivityAllIconsConnection graphQLTaggableActivityAllIconsConnection = (GraphQLTaggableActivityAllIconsConnection) graphQLModelMutatingVisitor.b(m713j());
            if (m713j() != graphQLTaggableActivityAllIconsConnection) {
                graphQLVisitableModel = (GraphQLTaggableActivity) ModelHelper.a(null, this);
                graphQLVisitableModel.f416d = graphQLTaggableActivityAllIconsConnection;
            }
        }
        if (m714k() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m714k());
            if (m714k() != graphQLImage) {
                graphQLVisitableModel = (GraphQLTaggableActivity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f417e = graphQLImage;
            }
        }
        if (m715l() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m715l());
            if (m715l() != graphQLImage) {
                graphQLVisitableModel = (GraphQLTaggableActivity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f418f = graphQLImage;
            }
        }
        if (m721r() != null) {
            graphQLTaggableActivityPreviewTemplate = (GraphQLTaggableActivityPreviewTemplate) graphQLModelMutatingVisitor.b(m721r());
            if (m721r() != graphQLTaggableActivityPreviewTemplate) {
                graphQLVisitableModel = (GraphQLTaggableActivity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f424l = graphQLTaggableActivityPreviewTemplate;
            }
        }
        if (m722s() != null) {
            graphQLTaggableActivityPreviewTemplate = (GraphQLTaggableActivityPreviewTemplate) graphQLModelMutatingVisitor.b(m722s());
            if (m722s() != graphQLTaggableActivityPreviewTemplate) {
                graphQLVisitableModel = (GraphQLTaggableActivity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f425m = graphQLTaggableActivityPreviewTemplate;
            }
        }
        if (m723t() != null) {
            graphQLTaggableActivityPreviewTemplate = (GraphQLTaggableActivityPreviewTemplate) graphQLModelMutatingVisitor.b(m723t());
            if (m723t() != graphQLTaggableActivityPreviewTemplate) {
                graphQLVisitableModel = (GraphQLTaggableActivity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f426n = graphQLTaggableActivityPreviewTemplate;
            }
        }
        if (m724u() != null) {
            graphQLTaggableActivityPreviewTemplate = (GraphQLTaggableActivityPreviewTemplate) graphQLModelMutatingVisitor.b(m724u());
            if (m724u() != graphQLTaggableActivityPreviewTemplate) {
                graphQLVisitableModel = (GraphQLTaggableActivity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f427o = graphQLTaggableActivityPreviewTemplate;
            }
        }
        if (m725v() != null) {
            graphQLTaggableActivityPreviewTemplate = (GraphQLTaggableActivityPreviewTemplate) graphQLModelMutatingVisitor.b(m725v());
            if (m725v() != graphQLTaggableActivityPreviewTemplate) {
                graphQLVisitableModel = (GraphQLTaggableActivity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f428p = graphQLTaggableActivityPreviewTemplate;
            }
        }
        if (m726w() != null) {
            graphQLTaggableActivityPreviewTemplate = (GraphQLTaggableActivityPreviewTemplate) graphQLModelMutatingVisitor.b(m726w());
            if (m726w() != graphQLTaggableActivityPreviewTemplate) {
                graphQLVisitableModel = (GraphQLTaggableActivity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f429q = graphQLTaggableActivityPreviewTemplate;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLTaggableActivity() {
        super(20);
    }

    public final void m712a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f420h = mutableFlatBuffer.a(i, 4);
        this.f422j = mutableFlatBuffer.a(i, 6, 0);
        this.f431s = mutableFlatBuffer.a(i, 15);
        this.f432t = mutableFlatBuffer.a(i, 16);
        this.f433u = mutableFlatBuffer.a(i, 17);
    }

    public final int m709a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m713j());
        int a2 = ModelHelper.a(flatBufferBuilder, m714k());
        int a3 = ModelHelper.a(flatBufferBuilder, m715l());
        int b = flatBufferBuilder.b(m716m());
        int b2 = flatBufferBuilder.b(m718o());
        int b3 = flatBufferBuilder.b(m720q());
        int a4 = ModelHelper.a(flatBufferBuilder, m721r());
        int a5 = ModelHelper.a(flatBufferBuilder, m722s());
        int a6 = ModelHelper.a(flatBufferBuilder, m723t());
        int a7 = ModelHelper.a(flatBufferBuilder, m724u());
        int a8 = ModelHelper.a(flatBufferBuilder, m725v());
        int a9 = ModelHelper.a(flatBufferBuilder, m726w());
        int b4 = flatBufferBuilder.b(m727x());
        int b5 = flatBufferBuilder.b(m708B());
        flatBufferBuilder.c(19);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, a3);
        flatBufferBuilder.b(3, b);
        flatBufferBuilder.a(4, m717n());
        flatBufferBuilder.b(5, b2);
        flatBufferBuilder.a(6, m719p(), 0);
        flatBufferBuilder.b(7, b3);
        flatBufferBuilder.b(8, a4);
        flatBufferBuilder.b(9, a5);
        flatBufferBuilder.b(10, a6);
        flatBufferBuilder.b(11, a7);
        flatBufferBuilder.b(12, a8);
        flatBufferBuilder.b(13, a9);
        flatBufferBuilder.b(14, b4);
        flatBufferBuilder.a(15, m728y());
        flatBufferBuilder.a(16, m729z());
        flatBufferBuilder.a(17, m707A());
        flatBufferBuilder.b(18, b5);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLTaggableActivity(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(20);
        this.f416d = (GraphQLTaggableActivityAllIconsConnection) parcel.readValue(GraphQLTaggableActivityAllIconsConnection.class.getClassLoader());
        this.f417e = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f418f = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f419g = parcel.readString();
        this.f420h = parcel.readByte() == (byte) 1;
        this.f421i = parcel.readString();
        this.f422j = parcel.readInt();
        this.f423k = parcel.readString();
        this.f424l = (GraphQLTaggableActivityPreviewTemplate) parcel.readValue(GraphQLTaggableActivityPreviewTemplate.class.getClassLoader());
        this.f425m = (GraphQLTaggableActivityPreviewTemplate) parcel.readValue(GraphQLTaggableActivityPreviewTemplate.class.getClassLoader());
        this.f426n = (GraphQLTaggableActivityPreviewTemplate) parcel.readValue(GraphQLTaggableActivityPreviewTemplate.class.getClassLoader());
        this.f427o = (GraphQLTaggableActivityPreviewTemplate) parcel.readValue(GraphQLTaggableActivityPreviewTemplate.class.getClassLoader());
        this.f428p = (GraphQLTaggableActivityPreviewTemplate) parcel.readValue(GraphQLTaggableActivityPreviewTemplate.class.getClassLoader());
        this.f429q = (GraphQLTaggableActivityPreviewTemplate) parcel.readValue(GraphQLTaggableActivityPreviewTemplate.class.getClassLoader());
        this.f430r = parcel.readString();
        this.f431s = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f432t = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f433u = z2;
        this.f434v = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeValue(m713j());
        parcel.writeValue(m714k());
        parcel.writeValue(m715l());
        parcel.writeString(m716m());
        parcel.writeByte((byte) (m717n() ? 1 : 0));
        parcel.writeString(m718o());
        parcel.writeInt(m719p());
        parcel.writeString(m720q());
        parcel.writeValue(m721r());
        parcel.writeValue(m722s());
        parcel.writeValue(m723t());
        parcel.writeValue(m724u());
        parcel.writeValue(m725v());
        parcel.writeValue(m726w());
        parcel.writeString(m727x());
        parcel.writeByte((byte) (m728y() ? 1 : 0));
        if (m729z()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!m707A()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(m708B());
    }

    public GraphQLTaggableActivity(Builder builder) {
        super(20);
        this.b = builder.a;
        this.c = builder.b;
        this.f416d = builder.d;
        this.f417e = builder.e;
        this.f418f = builder.f;
        this.f419g = builder.g;
        this.f420h = builder.h;
        this.f421i = builder.i;
        this.f422j = builder.j;
        this.f423k = builder.k;
        this.f424l = builder.l;
        this.f425m = builder.m;
        this.f426n = builder.n;
        this.f427o = builder.o;
        this.f428p = builder.p;
        this.f429q = builder.q;
        this.f430r = builder.r;
        this.f431s = builder.s;
        this.f432t = builder.t;
        this.f433u = builder.u;
        this.f434v = builder.v;
    }
}
