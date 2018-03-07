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
/* compiled from: input_params */
public final class GraphQLPhotoEncoding extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLPhotoEncoding> CREATOR = new 1();
    @Nullable
    public String f19843d;
    @Nullable
    public String f19844e;
    @Nullable
    public String f19845f;
    @Nullable
    public GraphQLPhotosphereMetadata f19846g;
    @Nullable
    public String f19847h;
    public int f19848i;

    @FieldOffset
    @Nullable
    public final String m27591j() {
        this.f19843d = super.m9948a(this.f19843d, 0);
        return this.f19843d;
    }

    @FieldOffset
    @Nullable
    public final String m27592k() {
        this.f19844e = super.m9948a(this.f19844e, 1);
        return this.f19844e;
    }

    @FieldOffset
    @Nullable
    public final String m27593l() {
        this.f19845f = super.m9948a(this.f19845f, 2);
        return this.f19845f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhotosphereMetadata m27594m() {
        this.f19846g = (GraphQLPhotosphereMetadata) super.m9947a(this.f19846g, 3, GraphQLPhotosphereMetadata.class);
        return this.f19846g;
    }

    @FieldOffset
    @Nullable
    public final String m27595n() {
        this.f19847h = super.m9948a(this.f19847h, 4);
        return this.f19847h;
    }

    @FieldOffset
    public final int m27596o() {
        m9949a(0, 5);
        return this.f19848i;
    }

    @Nullable
    public final String mo2834a() {
        return m27592k();
    }

    public final int jK_() {
        return -1659654779;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m27594m() != null) {
            GraphQLPhotosphereMetadata graphQLPhotosphereMetadata = (GraphQLPhotosphereMetadata) graphQLModelMutatingVisitor.mo2928b(m27594m());
            if (m27594m() != graphQLPhotosphereMetadata) {
                graphQLVisitableModel = (GraphQLPhotoEncoding) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19846g = graphQLPhotosphereMetadata;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPhotoEncoding() {
        super(7);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f19848i = mutableFlatBuffer.m21524a(i, 5, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m27591j());
        int b2 = flatBufferBuilder.m21502b(m27592k());
        int b3 = flatBufferBuilder.m21502b(m27593l());
        int a = ModelHelper.m23093a(flatBufferBuilder, m27594m());
        int b4 = flatBufferBuilder.m21502b(m27595n());
        flatBufferBuilder.m21510c(6);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21507b(2, b3);
        flatBufferBuilder.m21507b(3, a);
        flatBufferBuilder.m21507b(4, b4);
        flatBufferBuilder.m21494a(5, m27596o(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPhotoEncoding(Parcel parcel) {
        super(7);
        this.f19843d = parcel.readString();
        this.f19844e = parcel.readString();
        this.f19845f = parcel.readString();
        this.f19846g = (GraphQLPhotosphereMetadata) parcel.readValue(GraphQLPhotosphereMetadata.class.getClassLoader());
        this.f19847h = parcel.readString();
        this.f19848i = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m27591j());
        parcel.writeString(m27592k());
        parcel.writeString(m27593l());
        parcel.writeValue(m27594m());
        parcel.writeString(m27595n());
        parcel.writeInt(m27596o());
    }
}
