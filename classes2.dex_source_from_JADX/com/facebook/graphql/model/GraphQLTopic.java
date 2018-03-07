package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.enums.GraphQLObjectType;
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
/* compiled from: location_implementation */
public final class GraphQLTopic extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLTopic> CREATOR = new 1();
    @Nullable
    public GraphQLObjectType f16681d;
    @Nullable
    public String f16682e;
    @Nullable
    public String f16683f;
    @Nullable
    public GraphQLImage f16684g;
    @Nullable
    public String f16685h;
    @Nullable
    public String f16686i;

    @Nullable
    public final GraphQLObjectType m23564j() {
        if (this.f5823b != null && this.f16681d == null) {
            this.f16681d = new GraphQLObjectType(this.f5823b.m21542b(this.f5824c, 0));
        }
        if (this.f16681d == null || this.f16681d.m22301g() != 0) {
            return this.f16681d;
        }
        return null;
    }

    @FieldOffset
    @Nullable
    public final String m23565k() {
        this.f16682e = super.m9948a(this.f16682e, 1);
        return this.f16682e;
    }

    @FieldOffset
    @Nullable
    public final String m23566l() {
        this.f16683f = super.m9948a(this.f16683f, 2);
        return this.f16683f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23567m() {
        this.f16684g = (GraphQLImage) super.m9947a(this.f16684g, 3, GraphQLImage.class);
        return this.f16684g;
    }

    @FieldOffset
    @Nullable
    public final String m23568n() {
        this.f16685h = super.m9948a(this.f16685h, 4);
        return this.f16685h;
    }

    @FieldOffset
    @Nullable
    public final String m23569o() {
        this.f16686i = super.m9948a(this.f16686i, 5);
        return this.f16686i;
    }

    @Nullable
    public final String mo2834a() {
        return m23565k();
    }

    public final int jK_() {
        return 80993551;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23567m() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23567m());
            if (m23567m() != graphQLImage) {
                graphQLVisitableModel = (GraphQLTopic) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16684g = graphQLImage;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLTopic() {
        super(7);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = flatBufferBuilder.m21479a(m23564j() != null ? m23564j().m22299e() : null);
        int b = flatBufferBuilder.m21502b(m23565k());
        int b2 = flatBufferBuilder.m21502b(m23566l());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23567m());
        int b3 = flatBufferBuilder.m21502b(m23568n());
        int b4 = flatBufferBuilder.m21502b(m23569o());
        flatBufferBuilder.m21510c(6);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, b2);
        flatBufferBuilder.m21507b(3, a2);
        flatBufferBuilder.m21507b(4, b3);
        flatBufferBuilder.m21507b(5, b4);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLTopic(Parcel parcel) {
        super(7);
        this.f16682e = parcel.readString();
        this.f16683f = parcel.readString();
        this.f16684g = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16685h = parcel.readString();
        this.f16686i = parcel.readString();
        this.f16681d = (GraphQLObjectType) ParcelUtil.b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m23565k());
        parcel.writeString(m23566l());
        parcel.writeValue(m23567m());
        parcel.writeString(m23568n());
        parcel.writeString(m23569o());
        parcel.writeParcelable(this.f16681d, i);
    }
}
