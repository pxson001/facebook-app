package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
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
/* compiled from: inline_composer_photo_button_clicked */
public final class GraphQLMobileStoreObject extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLMobileStoreObject> CREATOR = new 1();
    @Nullable
    public String f19903d;
    @Nullable
    public String f19904e;
    @Nullable
    public String f19905f;
    @Nullable
    public GraphQLRating f19906g;
    @Nullable
    public String f19907h;

    @FieldOffset
    @Nullable
    public final String m27680j() {
        this.f19903d = super.m9948a(this.f19903d, 0);
        return this.f19903d;
    }

    @FieldOffset
    @Nullable
    public final String m27681k() {
        this.f19904e = super.m9948a(this.f19904e, 1);
        return this.f19904e;
    }

    @FieldOffset
    @Nullable
    public final String m27682l() {
        this.f19905f = super.m9948a(this.f19905f, 2);
        return this.f19905f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLRating m27683m() {
        this.f19906g = (GraphQLRating) super.m9947a(this.f19906g, 3, GraphQLRating.class);
        return this.f19906g;
    }

    @FieldOffset
    @Nullable
    public final String m27684n() {
        this.f19907h = super.m9948a(this.f19907h, 4);
        return this.f19907h;
    }

    @Nullable
    public final String mo2834a() {
        return m27680j();
    }

    public final int jK_() {
        return -1304127138;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m27683m() != null) {
            GraphQLRating graphQLRating = (GraphQLRating) graphQLModelMutatingVisitor.mo2928b(m27683m());
            if (m27683m() != graphQLRating) {
                graphQLVisitableModel = (GraphQLMobileStoreObject) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19906g = graphQLRating;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLMobileStoreObject() {
        super(6);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m27680j());
        int b2 = flatBufferBuilder.m21502b(m27681k());
        int b3 = flatBufferBuilder.m21502b(m27682l());
        int a = ModelHelper.m23093a(flatBufferBuilder, m27683m());
        int b4 = flatBufferBuilder.m21502b(m27684n());
        flatBufferBuilder.m21510c(5);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21507b(2, b3);
        flatBufferBuilder.m21507b(3, a);
        flatBufferBuilder.m21507b(4, b4);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLMobileStoreObject(Parcel parcel) {
        super(6);
        this.f19903d = parcel.readString();
        this.f19904e = parcel.readString();
        this.f19905f = parcel.readString();
        this.f19906g = (GraphQLRating) parcel.readValue(GraphQLRating.class.getClassLoader());
        this.f19907h = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m27680j());
        parcel.writeString(m27681k());
        parcel.writeString(m27682l());
        parcel.writeValue(m27683m());
        parcel.writeString(m27684n());
    }

    public GraphQLMobileStoreObject(Builder builder) {
        super(6);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f19903d = builder.d;
        this.f19904e = builder.e;
        this.f19905f = builder.f;
        this.f19906g = builder.g;
        this.f19907h = builder.h;
    }
}
