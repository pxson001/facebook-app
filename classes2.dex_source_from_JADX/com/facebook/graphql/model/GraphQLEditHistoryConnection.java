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
/* compiled from: ltg_translation_user_feedback_mobile */
public final class GraphQLEditHistoryConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEditHistoryConnection> CREATOR = new C06781();
    public int f15858d;
    public List<GraphQLEditAction> f15859e;

    /* compiled from: ltg_translation_user_feedback_mobile */
    final class C06781 implements Creator<GraphQLEditHistoryConnection> {
        C06781() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEditHistoryConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEditHistoryConnection[i];
        }
    }

    @FieldOffset
    public final int m22578a() {
        m9949a(0, 0);
        return this.f15858d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLEditAction> m22582j() {
        this.f15859e = super.m9944a(this.f15859e, 1, GraphQLEditAction.class);
        return (ImmutableList) this.f15859e;
    }

    public final int jK_() {
        return -1196208760;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m22582j() != null) {
            Builder a = ModelHelper.m23097a(m22582j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLEditHistoryConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15859e = a.m1068b();
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEditHistoryConnection() {
        super(3);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f15858d = mutableFlatBuffer.m21524a(i, 0, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m22582j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21494a(0, m22578a(), 0);
        flatBufferBuilder.m21507b(1, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLEditHistoryConnection(Parcel parcel) {
        super(3);
        this.f15858d = parcel.readInt();
        this.f15859e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLEditAction.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m22578a());
        parcel.writeList(m22582j());
    }

    public GraphQLEditHistoryConnection(Builder builder) {
        super(3);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f15858d = builder.d;
        this.f15859e = builder.e;
    }
}
