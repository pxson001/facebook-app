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
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: installed_fb_apks */
public final class GraphQLAttachmentProperty extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLAttachmentProperty> CREATOR = new C07841();
    @Nullable
    public String f19804d;
    @Nullable
    public String f19805e;
    @Nullable
    public String f19806f;
    @Deprecated
    @Nullable
    public String f19807g;
    @Nullable
    public GraphQLTextWithEntities f19808h;

    /* compiled from: installed_fb_apks */
    final class C07841 implements Creator<GraphQLAttachmentProperty> {
        C07841() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLAttachmentProperty(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLAttachmentProperty[i];
        }
    }

    @FieldOffset
    @Nullable
    public final String m27513a() {
        this.f19804d = super.m9948a(this.f19804d, 0);
        return this.f19804d;
    }

    @FieldOffset
    @Nullable
    public final String m27514j() {
        this.f19805e = super.m9948a(this.f19805e, 1);
        return this.f19805e;
    }

    @FieldOffset
    @Nullable
    public final String m27515k() {
        this.f19806f = super.m9948a(this.f19806f, 2);
        return this.f19806f;
    }

    @FieldOffset
    @Nullable
    public final String m27516l() {
        this.f19807g = super.m9948a(this.f19807g, 3);
        return this.f19807g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m27517m() {
        this.f19808h = (GraphQLTextWithEntities) super.m9947a(this.f19808h, 4, GraphQLTextWithEntities.class);
        return this.f19808h;
    }

    public final int jK_() {
        return -363494344;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m27517m() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m27517m());
            if (m27517m() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLAttachmentProperty) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19808h = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLAttachmentProperty() {
        super(6);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m27513a());
        int b2 = flatBufferBuilder.m21502b(m27514j());
        int b3 = flatBufferBuilder.m21502b(m27515k());
        int b4 = flatBufferBuilder.m21502b(m27516l());
        int a = ModelHelper.m23093a(flatBufferBuilder, m27517m());
        flatBufferBuilder.m21510c(5);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21507b(2, b3);
        flatBufferBuilder.m21507b(3, b4);
        flatBufferBuilder.m21507b(4, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLAttachmentProperty(Parcel parcel) {
        super(6);
        this.f19804d = parcel.readString();
        this.f19805e = parcel.readString();
        this.f19806f = parcel.readString();
        this.f19807g = parcel.readString();
        this.f19808h = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m27513a());
        parcel.writeString(m27514j());
        parcel.writeString(m27515k());
        parcel.writeString(m27516l());
        parcel.writeValue(m27517m());
    }
}
