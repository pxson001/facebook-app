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
/* compiled from: inline_feed_survey_enabled */
public final class GraphQLRelevantReactorsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLRelevantReactorsConnection> CREATOR = new 1();
    public int f19881d;
    public List<GraphQLRelevantReactorsEdge> f19882e;

    @FieldOffset
    public final int m27642a() {
        m9949a(0, 0);
        return this.f19881d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLRelevantReactorsEdge> m27646j() {
        this.f19882e = super.m9944a(this.f19882e, 1, GraphQLRelevantReactorsEdge.class);
        return (ImmutableList) this.f19882e;
    }

    public final int jK_() {
        return 853006444;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m27646j() != null) {
            Builder a = ModelHelper.m23097a(m27646j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLRelevantReactorsConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19882e = a.m1068b();
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLRelevantReactorsConnection() {
        super(3);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f19881d = mutableFlatBuffer.m21524a(i, 0, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m27646j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21494a(0, m27642a(), 0);
        flatBufferBuilder.m21507b(1, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLRelevantReactorsConnection(Parcel parcel) {
        super(3);
        this.f19881d = parcel.readInt();
        this.f19882e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLRelevantReactorsEdge.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m27642a());
        parcel.writeList(m27646j());
    }
}
