package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
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
/* compiled from: user/%s */
public final class GraphQLTaggableActivityAllIconsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLTaggableActivityAllIconsConnection> CREATOR = new 1();
    public int f435d;
    public List<GraphQLTaggableActivityIcon> f436e;

    @FieldOffset
    public final int m730a() {
        a(0, 0);
        return this.f435d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLTaggableActivityIcon> m734j() {
        this.f436e = super.a(this.f436e, 1, GraphQLTaggableActivityIcon.class);
        return (ImmutableList) this.f436e;
    }

    public final int jK_() {
        return -1113843827;
    }

    public final GraphQLVisitableModel m732a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m734j() != null) {
            Builder a = ModelHelper.a(m734j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLTaggableActivityAllIconsConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f436e = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLTaggableActivityAllIconsConnection() {
        super(3);
    }

    public final void m733a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f435d = mutableFlatBuffer.a(i, 0, 0);
    }

    public final int m731a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m734j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.a(0, m730a(), 0);
        flatBufferBuilder.b(1, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLTaggableActivityAllIconsConnection(Parcel parcel) {
        super(3);
        this.f435d = parcel.readInt();
        this.f436e = ImmutableListHelper.a(parcel.readArrayList(GraphQLTaggableActivityIcon.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m730a());
        parcel.writeList(m734j());
    }

    public GraphQLTaggableActivityAllIconsConnection(Builder builder) {
        super(3);
        this.b = builder.a;
        this.c = builder.b;
        this.f435d = builder.d;
        this.f436e = builder.e;
    }
}
