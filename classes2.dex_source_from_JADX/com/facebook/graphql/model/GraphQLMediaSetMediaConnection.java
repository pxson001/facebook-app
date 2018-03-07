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
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: list */
public final class GraphQLMediaSetMediaConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLMediaSetMediaConnection> CREATOR = new C08091();
    public int f17396d;
    public List<GraphQLMedia> f17397e;
    @Nullable
    public GraphQLPageInfo f17398f;

    /* compiled from: list */
    final class C08091 implements Creator<GraphQLMediaSetMediaConnection> {
        C08091() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLMediaSetMediaConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLMediaSetMediaConnection[i];
        }
    }

    @FieldOffset
    public final int m24477a() {
        m9949a(0, 0);
        return this.f17396d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLMedia> m24481j() {
        this.f17397e = super.m9944a(this.f17397e, 1, GraphQLMedia.class);
        return (ImmutableList) this.f17397e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m24482k() {
        this.f17398f = (GraphQLPageInfo) super.m9947a(this.f17398f, 2, GraphQLPageInfo.class);
        return this.f17398f;
    }

    public final int jK_() {
        return 747633668;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        m9958h();
        if (m24481j() != null) {
            Builder a = ModelHelper.m23097a(m24481j(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLMediaSetMediaConnection graphQLMediaSetMediaConnection = (GraphQLMediaSetMediaConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLMediaSetMediaConnection.f17397e = a.m1068b();
                graphQLVisitableModel = graphQLMediaSetMediaConnection;
                if (m24482k() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m24482k());
                    if (m24482k() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLMediaSetMediaConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17398f = graphQLPageInfo;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m24482k() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.mo2928b(m24482k());
            if (m24482k() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLMediaSetMediaConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17398f = graphQLPageInfo;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLMediaSetMediaConnection() {
        super(4);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17396d = mutableFlatBuffer.m21524a(i, 0, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m24481j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24482k());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21494a(0, m24477a(), 0);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLMediaSetMediaConnection(Parcel parcel) {
        super(4);
        this.f17396d = parcel.readInt();
        this.f17397e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLMedia.class.getClassLoader()));
        this.f17398f = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m24477a());
        parcel.writeList(m24481j());
        parcel.writeValue(m24482k());
    }

    public GraphQLMediaSetMediaConnection(Builder builder) {
        super(4);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f17396d = builder.d;
        this.f17397e = builder.e;
        this.f17398f = builder.f;
    }
}
