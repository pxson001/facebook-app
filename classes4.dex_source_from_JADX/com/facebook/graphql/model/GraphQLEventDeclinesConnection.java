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
/* compiled from: original_cancel_requested */
public final class GraphQLEventDeclinesConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEventDeclinesConnection> CREATOR = new 1();
    int f5898d;
    List<GraphQLEventDeclinesEdge> f5899e;
    @Nullable
    GraphQLPageInfo f5900f;
    int f5901g;
    int f5902h;

    @FieldOffset
    public final int m6350a() {
        a(0, 0);
        return this.f5898d;
    }

    final void m6353a(int i) {
        this.f5898d = i;
        if (this.b != null && this.b.d) {
            this.b.b(this.c, 0, i);
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLEventDeclinesEdge> m6355j() {
        this.f5899e = super.a(this.f5899e, 1, GraphQLEventDeclinesEdge.class);
        return (ImmutableList) this.f5899e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m6356k() {
        this.f5900f = (GraphQLPageInfo) super.a(this.f5900f, 2, GraphQLPageInfo.class);
        return this.f5900f;
    }

    @FieldOffset
    public final int m6357l() {
        a(0, 3);
        return this.f5901g;
    }

    @FieldOffset
    public final int m6358m() {
        a(0, 4);
        return this.f5902h;
    }

    public final int jK_() {
        return 881148693;
    }

    public final GraphQLVisitableModel m6352a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        h();
        if (m6355j() != null) {
            Builder a = ModelHelper.a(m6355j(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLEventDeclinesConnection graphQLEventDeclinesConnection = (GraphQLEventDeclinesConnection) ModelHelper.a(null, this);
                graphQLEventDeclinesConnection.f5899e = a.b();
                graphQLVisitableModel = graphQLEventDeclinesConnection;
                if (m6356k() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m6356k());
                    if (m6356k() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLEventDeclinesConnection) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5900f = graphQLPageInfo;
                    }
                }
                i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m6356k() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m6356k());
            if (m6356k() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLEventDeclinesConnection) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f5900f = graphQLPageInfo;
            }
        }
        i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLEventDeclinesConnection() {
        super(6);
    }

    public final void m6354a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f5898d = mutableFlatBuffer.a(i, 0, 0);
        this.f5901g = mutableFlatBuffer.a(i, 3, 0);
        this.f5902h = mutableFlatBuffer.a(i, 4, 0);
    }

    public final int m6351a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m6355j());
        int a2 = ModelHelper.a(flatBufferBuilder, m6356k());
        flatBufferBuilder.c(5);
        flatBufferBuilder.a(0, m6350a(), 0);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.a(3, m6357l(), 0);
        flatBufferBuilder.a(4, m6358m(), 0);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLEventDeclinesConnection(Parcel parcel) {
        super(6);
        this.f5898d = parcel.readInt();
        this.f5899e = ImmutableListHelper.a(parcel.readArrayList(GraphQLEventDeclinesEdge.class.getClassLoader()));
        this.f5900f = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
        this.f5901g = parcel.readInt();
        this.f5902h = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m6350a());
        parcel.writeList(m6355j());
        parcel.writeValue(m6356k());
        parcel.writeInt(m6357l());
        parcel.writeInt(m6358m());
    }
}
