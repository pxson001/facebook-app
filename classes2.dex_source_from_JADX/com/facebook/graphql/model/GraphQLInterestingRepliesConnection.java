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
/* compiled from: inline_composer_impression */
public final class GraphQLInterestingRepliesConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLInterestingRepliesConnection> CREATOR = new 1();
    public int f19908d;
    public List<GraphQLComment> f19909e;

    @FieldOffset
    public final int m27685a() {
        m9949a(0, 0);
        return this.f19908d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLComment> m27689j() {
        this.f19909e = super.m9944a(this.f19909e, 1, GraphQLComment.class);
        return (ImmutableList) this.f19909e;
    }

    public final int jK_() {
        return -644731762;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m27689j() != null) {
            Builder a = ModelHelper.m23097a(m27689j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLInterestingRepliesConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19909e = a.m1068b();
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLInterestingRepliesConnection() {
        super(3);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f19908d = mutableFlatBuffer.m21524a(i, 0, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m27689j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21494a(0, m27685a(), 0);
        flatBufferBuilder.m21507b(1, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLInterestingRepliesConnection(Parcel parcel) {
        super(3);
        this.f19908d = parcel.readInt();
        this.f19909e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLComment.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m27685a());
        parcel.writeList(m27689j());
    }

    public GraphQLInterestingRepliesConnection(Builder builder) {
        super(3);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f19908d = builder.d;
        this.f19909e = builder.e;
    }
}
