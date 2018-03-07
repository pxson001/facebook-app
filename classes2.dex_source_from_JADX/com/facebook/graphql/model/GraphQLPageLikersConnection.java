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
/* compiled from: likers.count */
public final class GraphQLPageLikersConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPageLikersConnection> CREATOR = new C09221();
    public int f17508d;
    public int f17509e;
    public List<GraphQLUser> f17510f;

    /* compiled from: likers.count */
    final class C09221 implements Creator<GraphQLPageLikersConnection> {
        C09221() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPageLikersConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPageLikersConnection[i];
        }
    }

    @FieldOffset
    public final int m24631a() {
        m9949a(0, 0);
        return this.f17508d;
    }

    @FieldOffset
    public final int m24635j() {
        m9949a(0, 1);
        return this.f17509e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLUser> m24636k() {
        this.f17510f = super.m9944a(this.f17510f, 2, GraphQLUser.class);
        return (ImmutableList) this.f17510f;
    }

    public final int jK_() {
        return 637021669;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24636k() != null) {
            Builder a = ModelHelper.m23097a(m24636k(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLPageLikersConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17510f = a.m1068b();
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPageLikersConnection() {
        super(4);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17508d = mutableFlatBuffer.m21524a(i, 0, 0);
        this.f17509e = mutableFlatBuffer.m21524a(i, 1, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m24636k());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21494a(0, m24631a(), 0);
        flatBufferBuilder.m21494a(1, m24635j(), 0);
        flatBufferBuilder.m21507b(2, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPageLikersConnection(Parcel parcel) {
        super(4);
        this.f17508d = parcel.readInt();
        this.f17509e = parcel.readInt();
        this.f17510f = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLUser.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m24631a());
        parcel.writeInt(m24635j());
        parcel.writeList(m24636k());
    }
}
