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
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces$DefaultPageInfoFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces$DefaultPageInfoTailFields;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.base.Preconditions;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: seen_by.count */
public final class GraphQLPageInfo extends BaseModel implements TypeModel, CommonGraphQL2Interfaces$DefaultPageInfoFields, CommonGraphQL2Interfaces$DefaultPageInfoTailFields, GraphQLVisitableModel {
    public static final Creator<GraphQLPageInfo> CREATOR = new C02701();
    @Nullable
    public String f5818d;
    @Nullable
    public String f5819e;
    public boolean f5820f;
    public boolean f5821g;
    @Nullable
    public String f5822h;

    /* compiled from: seen_by.count */
    final class C02701 implements Creator<GraphQLPageInfo> {
        C02701() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPageInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPageInfo[i];
        }
    }

    /* compiled from: seen_by.count */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        @Nullable
        public String f15929d;
        @Nullable
        public String f15930e;
        public boolean f15931f;
        public boolean f15932g;
        @Nullable
        public String f15933h;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }

        public static Builder m22678a(GraphQLPageInfo graphQLPageInfo) {
            com.facebook.graphql.modelutil.BaseModel.Builder builder = new Builder();
            graphQLPageInfo.m9958h();
            builder.f15929d = graphQLPageInfo.m9937j();
            builder.f15930e = graphQLPageInfo.mo1405a();
            builder.f15931f = graphQLPageInfo.mo1407b();
            builder.f15932g = graphQLPageInfo.mo1408c();
            builder.f15933h = graphQLPageInfo.v_();
            com.facebook.graphql.modelutil.BaseModel.Builder.m22419a(builder, graphQLPageInfo);
            return builder;
        }

        public final Builder m22679a(@Nullable String str) {
            this.f15930e = str;
            return this;
        }

        public final Builder m22680a(boolean z) {
            this.f15931f = z;
            return this;
        }

        public final Builder m22683b(boolean z) {
            this.f15932g = z;
            return this;
        }

        public final Builder m22682b(@Nullable String str) {
            this.f15933h = str;
            return this;
        }

        public final GraphQLPageInfo m22681a() {
            return new GraphQLPageInfo(this);
        }
    }

    @FieldOffset
    @Nullable
    public final String m9937j() {
        this.f5818d = super.m9948a(this.f5818d, 0);
        return this.f5818d;
    }

    @FieldOffset
    @Nullable
    public final String mo1405a() {
        this.f5819e = super.m9948a(this.f5819e, 1);
        return this.f5819e;
    }

    @FieldOffset
    public final boolean mo1407b() {
        m9949a(0, 2);
        return this.f5820f;
    }

    @FieldOffset
    public final boolean mo1408c() {
        m9949a(0, 3);
        return this.f5821g;
    }

    @FieldOffset
    @Nullable
    public final String v_() {
        this.f5822h = super.m9948a(this.f5822h, 4);
        return this.f5822h;
    }

    public final int jK_() {
        return 923779069;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLPageInfo() {
        super(6);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f5820f = mutableFlatBuffer.m21540a(i, 2);
        this.f5821g = mutableFlatBuffer.m21540a(i, 3);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m9937j());
        int b2 = flatBufferBuilder.m21502b(mo1405a());
        int b3 = flatBufferBuilder.m21502b(v_());
        flatBufferBuilder.m21510c(5);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21498a(2, mo1407b());
        flatBufferBuilder.m21498a(3, mo1408c());
        flatBufferBuilder.m21507b(4, b3);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPageInfo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(6);
        this.f5818d = parcel.readString();
        this.f5819e = parcel.readString();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f5820f = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f5821g = z2;
        this.f5822h = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(m9937j());
        parcel.writeString(mo1405a());
        if (mo1407b()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!mo1408c()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(v_());
    }

    public GraphQLPageInfo(Builder builder) {
        super(6);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f5818d = builder.f15929d;
        this.f5819e = builder.f15930e;
        this.f5820f = builder.f15931f;
        this.f5821g = builder.f15932g;
        this.f5822h = builder.f15933h;
    }
}
