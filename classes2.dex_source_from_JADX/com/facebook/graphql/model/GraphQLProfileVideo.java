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
/* compiled from: light_prefs */
public final class GraphQLProfileVideo extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLProfileVideo> CREATOR = new 1();
    @Nullable
    GraphQLVideo f17536d;
    @Nullable
    String f17537e;
    @Nullable
    String f17538f;

    @FieldOffset
    @Nullable
    public final GraphQLVideo m24691j() {
        this.f17536d = (GraphQLVideo) super.m9947a(this.f17536d, 0, GraphQLVideo.class);
        return this.f17536d;
    }

    @FieldOffset
    @Nullable
    public final String m24692k() {
        this.f17537e = super.m9948a(this.f17537e, 1);
        return this.f17537e;
    }

    @FieldOffset
    @Nullable
    public final String m24693l() {
        this.f17538f = super.m9948a(this.f17538f, 2);
        return this.f17538f;
    }

    @Nullable
    public final String mo2834a() {
        return m24692k();
    }

    public final int jK_() {
        return 1379569778;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24691j() != null) {
            GraphQLVideo graphQLVideo = (GraphQLVideo) graphQLModelMutatingVisitor.mo2928b(m24691j());
            if (m24691j() != graphQLVideo) {
                graphQLVisitableModel = (GraphQLProfileVideo) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17536d = graphQLVideo;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLProfileVideo() {
        super(4);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m24691j());
        int b = flatBufferBuilder.m21502b(m24692k());
        int b2 = flatBufferBuilder.m21502b(m24693l());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, b2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLProfileVideo(Parcel parcel) {
        super(4);
        this.f17536d = (GraphQLVideo) parcel.readValue(GraphQLVideo.class.getClassLoader());
        this.f17537e = parcel.readString();
        this.f17538f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m24691j());
        parcel.writeString(m24692k());
        parcel.writeString(m24693l());
    }
}
