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
/* compiled from: lte_tac */
public final class GraphQLInteractorsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLInteractorsConnection> CREATOR = new C06791();
    public int f15860d;
    public List<GraphQLActor> f15861e;

    /* compiled from: lte_tac */
    final class C06791 implements Creator<GraphQLInteractorsConnection> {
        C06791() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLInteractorsConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLInteractorsConnection[i];
        }
    }

    @FieldOffset
    public final int m22583a() {
        m9949a(0, 0);
        return this.f15860d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLActor> m22587j() {
        this.f15861e = super.m9944a(this.f15861e, 1, GraphQLActor.class);
        return (ImmutableList) this.f15861e;
    }

    public final int jK_() {
        return 1567367000;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m22587j() != null) {
            Builder a = ModelHelper.m23097a(m22587j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLInteractorsConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15861e = a.m1068b();
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLInteractorsConnection() {
        super(3);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f15860d = mutableFlatBuffer.m21524a(i, 0, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m22587j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21494a(0, m22583a(), 0);
        flatBufferBuilder.m21507b(1, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLInteractorsConnection(Parcel parcel) {
        super(3);
        this.f15860d = parcel.readInt();
        this.f15861e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLActor.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m22583a());
        parcel.writeList(m22587j());
    }
}
