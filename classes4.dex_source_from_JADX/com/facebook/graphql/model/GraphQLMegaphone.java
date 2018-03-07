package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLMegaphoneLocation;
import com.facebook.graphql.model.PropertyBag.HasProperty;
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
/* compiled from: fbns_tokens/ */
public final class GraphQLMegaphone extends BaseModel implements HasProperty, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLMegaphone> CREATOR = new 1();
    @Nullable
    GraphQLMegaphoneAction f11958d;
    @Nullable
    String f11959e;
    @Nullable
    String f11960f;
    @Nullable
    GraphQLTextWithEntities f11961g;
    @Nullable
    GraphQLImage f11962h;
    @Nullable
    String f11963i;
    boolean f11964j;
    GraphQLMegaphoneLocation f11965k;
    @Nullable
    GraphQLTextWithEntities f11966l;
    @Nullable
    String f11967m;
    @Nullable
    String f11968n;
    @Nullable
    String f11969o;
    @Nullable
    private PropertyBag f11970p = null;

    @FieldOffset
    @Nullable
    public final GraphQLMegaphoneAction m12615j() {
        this.f11958d = (GraphQLMegaphoneAction) super.a(this.f11958d, 0, GraphQLMegaphoneAction.class);
        return this.f11958d;
    }

    @FieldOffset
    @Nullable
    public final String m12616k() {
        this.f11959e = super.a(this.f11959e, 1);
        return this.f11959e;
    }

    @FieldOffset
    @Nullable
    public final String m12617l() {
        this.f11960f = super.a(this.f11960f, 2);
        return this.f11960f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m12618m() {
        this.f11961g = (GraphQLTextWithEntities) super.a(this.f11961g, 3, GraphQLTextWithEntities.class);
        return this.f11961g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m12619n() {
        this.f11962h = (GraphQLImage) super.a(this.f11962h, 4, GraphQLImage.class);
        return this.f11962h;
    }

    @FieldOffset
    @Nullable
    public final String m12620o() {
        this.f11963i = super.a(this.f11963i, 5);
        return this.f11963i;
    }

    @FieldOffset
    public final boolean m12621p() {
        a(0, 6);
        return this.f11964j;
    }

    @FieldOffset
    public final GraphQLMegaphoneLocation m12622q() {
        this.f11965k = (GraphQLMegaphoneLocation) super.a(this.f11965k, 7, GraphQLMegaphoneLocation.class, GraphQLMegaphoneLocation.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f11965k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m12623r() {
        this.f11966l = (GraphQLTextWithEntities) super.a(this.f11966l, 8, GraphQLTextWithEntities.class);
        return this.f11966l;
    }

    @FieldOffset
    @Nullable
    public final String m12624s() {
        this.f11967m = super.a(this.f11967m, 9);
        return this.f11967m;
    }

    @FieldOffset
    @Nullable
    public final String m12625t() {
        this.f11968n = super.a(this.f11968n, 10);
        return this.f11968n;
    }

    @FieldOffset
    @Nullable
    public final String m12626u() {
        this.f11969o = super.a(this.f11969o, 11);
        return this.f11969o;
    }

    @Nullable
    public final String m12613a() {
        return m12616k();
    }

    public final int jK_() {
        return -1997586404;
    }

    public final GraphQLVisitableModel m12612a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m12615j() != null) {
            GraphQLMegaphoneAction graphQLMegaphoneAction = (GraphQLMegaphoneAction) graphQLModelMutatingVisitor.b(m12615j());
            if (m12615j() != graphQLMegaphoneAction) {
                graphQLVisitableModel = (GraphQLMegaphone) ModelHelper.a(null, this);
                graphQLVisitableModel.f11958d = graphQLMegaphoneAction;
            }
        }
        if (m12618m() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m12618m());
            if (m12618m() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLMegaphone) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f11961g = graphQLTextWithEntities;
            }
        }
        if (m12619n() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m12619n());
            if (m12619n() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMegaphone) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f11962h = graphQLImage;
            }
        }
        if (m12623r() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m12623r());
            if (m12623r() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLMegaphone) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f11966l = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLMegaphone() {
        super(13);
    }

    public final void m12614a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f11964j = mutableFlatBuffer.a(i, 6);
    }

    public final int m12611a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m12615j());
        int b = flatBufferBuilder.b(m12616k());
        int b2 = flatBufferBuilder.b(m12617l());
        int a2 = ModelHelper.a(flatBufferBuilder, m12618m());
        int a3 = ModelHelper.a(flatBufferBuilder, m12619n());
        int b3 = flatBufferBuilder.b(m12620o());
        int a4 = ModelHelper.a(flatBufferBuilder, m12623r());
        int b4 = flatBufferBuilder.b(m12624s());
        int b5 = flatBufferBuilder.b(m12625t());
        int b6 = flatBufferBuilder.b(m12626u());
        flatBufferBuilder.c(12);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        flatBufferBuilder.b(3, a2);
        flatBufferBuilder.b(4, a3);
        flatBufferBuilder.b(5, b3);
        flatBufferBuilder.a(6, m12621p());
        flatBufferBuilder.a(7, m12622q() == GraphQLMegaphoneLocation.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m12622q());
        flatBufferBuilder.b(8, a4);
        flatBufferBuilder.b(9, b4);
        flatBufferBuilder.b(10, b5);
        flatBufferBuilder.b(11, b6);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLMegaphone(Parcel parcel) {
        super(13);
        this.f11958d = (GraphQLMegaphoneAction) parcel.readValue(GraphQLMegaphoneAction.class.getClassLoader());
        this.f11959e = parcel.readString();
        this.f11960f = parcel.readString();
        this.f11961g = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f11962h = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f11963i = parcel.readString();
        this.f11964j = parcel.readByte() == (byte) 1;
        this.f11965k = GraphQLMegaphoneLocation.fromString(parcel.readString());
        this.f11966l = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f11967m = parcel.readString();
        this.f11968n = parcel.readString();
        this.f11969o = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m12615j());
        parcel.writeString(m12616k());
        parcel.writeString(m12617l());
        parcel.writeValue(m12618m());
        parcel.writeValue(m12619n());
        parcel.writeString(m12620o());
        parcel.writeByte((byte) (m12621p() ? 1 : 0));
        parcel.writeString(m12622q().name());
        parcel.writeValue(m12623r());
        parcel.writeString(m12624s());
        parcel.writeString(m12625t());
        parcel.writeString(m12626u());
    }

    public GraphQLMegaphone(Builder builder) {
        super(13);
        this.b = builder.a;
        this.c = builder.b;
        this.f11958d = builder.d;
        this.f11959e = builder.e;
        this.f11960f = builder.f;
        this.f11961g = builder.g;
        this.f11962h = builder.h;
        this.f11963i = builder.i;
        this.f11964j = builder.j;
        this.f11965k = builder.k;
        this.f11966l = builder.l;
        this.f11967m = builder.m;
        this.f11968n = builder.n;
        this.f11969o = builder.o;
        this.f11970p = builder.p;
    }

    public final PropertyBag U_() {
        if (this.f11970p == null) {
            this.f11970p = new PropertyBag();
        }
        return this.f11970p;
    }
}
