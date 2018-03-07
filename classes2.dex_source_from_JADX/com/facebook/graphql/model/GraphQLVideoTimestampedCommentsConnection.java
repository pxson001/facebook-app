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
/* compiled from: insertion_size */
public final class GraphQLVideoTimestampedCommentsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLVideoTimestampedCommentsConnection> CREATOR = new 1();
    public int f19834d;
    public List<GraphQLVideoTimestampedCommentsEdge> f19835e;

    @FieldOffset
    public final int m27567a() {
        m9949a(0, 0);
        return this.f19834d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLVideoTimestampedCommentsEdge> m27571j() {
        this.f19835e = super.m9944a(this.f19835e, 1, GraphQLVideoTimestampedCommentsEdge.class);
        return (ImmutableList) this.f19835e;
    }

    public final int jK_() {
        return -2040699284;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m27571j() != null) {
            Builder a = ModelHelper.m23097a(m27571j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLVideoTimestampedCommentsConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19835e = a.m1068b();
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLVideoTimestampedCommentsConnection() {
        super(3);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f19834d = mutableFlatBuffer.m21524a(i, 0, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m27571j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21494a(0, m27567a(), 0);
        flatBufferBuilder.m21507b(1, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLVideoTimestampedCommentsConnection(Parcel parcel) {
        super(3);
        this.f19834d = parcel.readInt();
        this.f19835e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLVideoTimestampedCommentsEdge.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m27567a());
        parcel.writeList(m27571j());
    }
}
