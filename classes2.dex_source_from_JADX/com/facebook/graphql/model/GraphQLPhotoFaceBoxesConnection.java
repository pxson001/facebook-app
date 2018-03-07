package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: installation_failure */
public final class GraphQLPhotoFaceBoxesConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPhotoFaceBoxesConnection> CREATOR = new C07861();
    public List<GraphQLFaceBox> f19809d;

    /* compiled from: installation_failure */
    final class C07861 implements Creator<GraphQLPhotoFaceBoxesConnection> {
        C07861() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPhotoFaceBoxesConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPhotoFaceBoxesConnection[i];
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLFaceBox> m27520a() {
        this.f19809d = super.m9944a(this.f19809d, 0, GraphQLFaceBox.class);
        return (ImmutableList) this.f19809d;
    }

    public final int jK_() {
        return 1623495656;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m27520a() != null) {
            Builder a = ModelHelper.m23097a(m27520a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLPhotoFaceBoxesConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19809d = a.m1068b();
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPhotoFaceBoxesConnection() {
        super(2);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m27520a());
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPhotoFaceBoxesConnection(Parcel parcel) {
        super(2);
        this.f19809d = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLFaceBox.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m27520a());
    }

    public GraphQLPhotoFaceBoxesConnection(Builder builder) {
        super(2);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f19809d = builder.d;
    }
}
