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
/* compiled from: location_latitude */
public final class GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection> CREATOR = new 1();
    public int f16676d;
    public List<GraphQLUser> f16677e;

    @FieldOffset
    public final int m23550a() {
        m9949a(0, 0);
        return this.f16676d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLUser> m23554j() {
        this.f16677e = super.m9944a(this.f16677e, 1, GraphQLUser.class);
        return (ImmutableList) this.f16677e;
    }

    public final int jK_() {
        return -262754594;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23554j() != null) {
            Builder a = ModelHelper.m23097a(m23554j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16677e = a.m1068b();
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection() {
        super(3);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16676d = mutableFlatBuffer.m21524a(i, 0, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m23554j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21494a(0, m23550a(), 0);
        flatBufferBuilder.m21507b(1, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection(Parcel parcel) {
        super(3);
        this.f16676d = parcel.readInt();
        this.f16677e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLUser.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m23550a());
        parcel.writeList(m23554j());
    }
}
