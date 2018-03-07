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
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: location_manager_exception_type */
public final class GraphQLPrivacyScope extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPrivacyScope> CREATOR = new C08001();
    public boolean f16645d;
    @Nullable
    public String f16646e;
    @Nullable
    public GraphQLPrivacyEducationInfo f16647f;
    @Deprecated
    @Nullable
    public GraphQLIcon f16648g;
    @Nullable
    public GraphQLImage f16649h;
    @Nullable
    public String f16650i;
    @Deprecated
    @Nullable
    public String f16651j;
    @Nullable
    public GraphQLPrivacyOptionsContentConnection f16652k;
    @Nullable
    public GraphQLPrivacyOptionsContentConnection f16653l;
    public boolean f16654m;
    @Deprecated
    @Nullable
    public String f16655n;

    /* compiled from: location_manager_exception_type */
    final class C08001 implements Creator<GraphQLPrivacyScope> {
        C08001() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPrivacyScope(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPrivacyScope[i];
        }
    }

    @FieldOffset
    public final boolean m23512a() {
        m9949a(0, 0);
        return this.f16645d;
    }

    @FieldOffset
    @Nullable
    public final String m23513j() {
        this.f16646e = super.m9948a(this.f16646e, 1);
        return this.f16646e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyEducationInfo m23514k() {
        this.f16647f = (GraphQLPrivacyEducationInfo) super.m9947a(this.f16647f, 2, GraphQLPrivacyEducationInfo.class);
        return this.f16647f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLIcon m23515l() {
        this.f16648g = (GraphQLIcon) super.m9947a(this.f16648g, 3, GraphQLIcon.class);
        return this.f16648g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23516m() {
        this.f16649h = (GraphQLImage) super.m9947a(this.f16649h, 4, GraphQLImage.class);
        return this.f16649h;
    }

    @FieldOffset
    @Nullable
    public final String m23517n() {
        this.f16650i = super.m9948a(this.f16650i, 5);
        return this.f16650i;
    }

    @FieldOffset
    @Nullable
    public final String m23518o() {
        this.f16651j = super.m9948a(this.f16651j, 6);
        return this.f16651j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyOptionsContentConnection m23519p() {
        this.f16652k = (GraphQLPrivacyOptionsContentConnection) super.m9947a(this.f16652k, 7, GraphQLPrivacyOptionsContentConnection.class);
        return this.f16652k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyOptionsContentConnection m23520q() {
        this.f16653l = (GraphQLPrivacyOptionsContentConnection) super.m9947a(this.f16653l, 8, GraphQLPrivacyOptionsContentConnection.class);
        return this.f16653l;
    }

    @FieldOffset
    public final boolean m23521r() {
        m9949a(1, 1);
        return this.f16654m;
    }

    @FieldOffset
    @Nullable
    public final String m23522s() {
        this.f16655n = super.m9948a(this.f16655n, 10);
        return this.f16655n;
    }

    final void m23511a(@Nullable String str) {
        this.f16655n = str;
        if (this.f5823b != null && this.f5823b.f15024d) {
            this.f5823b.m21537a(this.f5824c, 10, str);
        }
    }

    public final int jK_() {
        return -476351540;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLPrivacyOptionsContentConnection graphQLPrivacyOptionsContentConnection;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23514k() != null) {
            GraphQLPrivacyEducationInfo graphQLPrivacyEducationInfo = (GraphQLPrivacyEducationInfo) graphQLModelMutatingVisitor.mo2928b(m23514k());
            if (m23514k() != graphQLPrivacyEducationInfo) {
                graphQLVisitableModel = (GraphQLPrivacyScope) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16647f = graphQLPrivacyEducationInfo;
            }
        }
        if (m23515l() != null) {
            GraphQLIcon graphQLIcon = (GraphQLIcon) graphQLModelMutatingVisitor.mo2928b(m23515l());
            if (m23515l() != graphQLIcon) {
                graphQLVisitableModel = (GraphQLPrivacyScope) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16648g = graphQLIcon;
            }
        }
        if (m23516m() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23516m());
            if (m23516m() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPrivacyScope) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16649h = graphQLImage;
            }
        }
        if (m23519p() != null) {
            graphQLPrivacyOptionsContentConnection = (GraphQLPrivacyOptionsContentConnection) graphQLModelMutatingVisitor.mo2928b(m23519p());
            if (m23519p() != graphQLPrivacyOptionsContentConnection) {
                graphQLVisitableModel = (GraphQLPrivacyScope) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16652k = graphQLPrivacyOptionsContentConnection;
            }
        }
        if (m23520q() != null) {
            graphQLPrivacyOptionsContentConnection = (GraphQLPrivacyOptionsContentConnection) graphQLModelMutatingVisitor.mo2928b(m23520q());
            if (m23520q() != graphQLPrivacyOptionsContentConnection) {
                graphQLVisitableModel = (GraphQLPrivacyScope) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16653l = graphQLPrivacyOptionsContentConnection;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPrivacyScope() {
        super(12);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16645d = mutableFlatBuffer.m21540a(i, 0);
        this.f16654m = mutableFlatBuffer.m21540a(i, 9);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m23513j());
        int a = ModelHelper.m23093a(flatBufferBuilder, m23514k());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23515l());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m23516m());
        int b2 = flatBufferBuilder.m21502b(m23517n());
        int b3 = flatBufferBuilder.m21502b(m23518o());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m23519p());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m23520q());
        int b4 = flatBufferBuilder.m21502b(m23522s());
        flatBufferBuilder.m21510c(11);
        flatBufferBuilder.m21498a(0, m23512a());
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, a);
        flatBufferBuilder.m21507b(3, a2);
        flatBufferBuilder.m21507b(4, a3);
        flatBufferBuilder.m21507b(5, b2);
        flatBufferBuilder.m21507b(6, b3);
        flatBufferBuilder.m21507b(7, a4);
        flatBufferBuilder.m21507b(8, a5);
        flatBufferBuilder.m21498a(9, m23521r());
        flatBufferBuilder.m21507b(10, b4);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPrivacyScope(Parcel parcel) {
        boolean z = true;
        super(12);
        this.f16645d = parcel.readByte() == (byte) 1;
        this.f16646e = parcel.readString();
        this.f16647f = (GraphQLPrivacyEducationInfo) parcel.readValue(GraphQLPrivacyEducationInfo.class.getClassLoader());
        this.f16648g = (GraphQLIcon) parcel.readValue(GraphQLIcon.class.getClassLoader());
        this.f16649h = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16650i = parcel.readString();
        this.f16651j = parcel.readString();
        this.f16652k = (GraphQLPrivacyOptionsContentConnection) parcel.readValue(GraphQLPrivacyOptionsContentConnection.class.getClassLoader());
        this.f16653l = (GraphQLPrivacyOptionsContentConnection) parcel.readValue(GraphQLPrivacyOptionsContentConnection.class.getClassLoader());
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f16654m = z;
        this.f16655n = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeByte((byte) (m23512a() ? 1 : 0));
        parcel.writeString(m23513j());
        parcel.writeValue(m23514k());
        parcel.writeValue(m23515l());
        parcel.writeValue(m23516m());
        parcel.writeString(m23517n());
        parcel.writeString(m23518o());
        parcel.writeValue(m23519p());
        parcel.writeValue(m23520q());
        if (!m23521r()) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(m23522s());
    }

    public GraphQLPrivacyScope(Builder builder) {
        super(12);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16645d = builder.d;
        this.f16646e = builder.e;
        this.f16647f = builder.f;
        this.f16648g = builder.g;
        this.f16649h = builder.h;
        this.f16650i = builder.i;
        this.f16651j = builder.j;
        this.f16652k = builder.k;
        this.f16653l = builder.l;
        this.f16654m = builder.m;
        this.f16655n = builder.n;
    }
}
