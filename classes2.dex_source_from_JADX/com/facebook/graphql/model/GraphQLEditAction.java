package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: fetch_zero_interstitial_content */
public final class GraphQLEditAction extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLEditAction> CREATOR = new 1();
    @Nullable
    String f23818d;
    @Nullable
    GraphQLTextWithEntities f23819e;
    long f23820f;
    @Nullable
    String f23821g;

    @FieldOffset
    @Nullable
    public final String m32213j() {
        this.f23818d = super.m9948a(this.f23818d, 0);
        return this.f23818d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m32214k() {
        this.f23819e = (GraphQLTextWithEntities) super.m9947a(this.f23819e, 1, GraphQLTextWithEntities.class);
        return this.f23819e;
    }

    @FieldOffset
    public final long m32215l() {
        m9949a(0, 2);
        return this.f23820f;
    }

    @FieldOffset
    @Nullable
    public final String m32216m() {
        this.f23821g = super.m9948a(this.f23821g, 3);
        return this.f23821g;
    }

    @Nullable
    public final String mo2834a() {
        return m32213j();
    }

    public final int jK_() {
        return -892762880;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m32214k() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m32214k());
            if (m32214k() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLEditAction) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f23819e = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEditAction() {
        super(5);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f23820f = mutableFlatBuffer.m21525a(i, 2, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m32213j());
        int a = ModelHelper.m23093a(flatBufferBuilder, m32214k());
        int b2 = flatBufferBuilder.m21502b(m32216m());
        flatBufferBuilder.m21510c(4);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21495a(2, m32215l(), 0);
        flatBufferBuilder.m21507b(3, b2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLEditAction(Parcel parcel) {
        super(5);
        this.f23818d = parcel.readString();
        this.f23819e = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f23820f = parcel.readLong();
        this.f23821g = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m32213j());
        parcel.writeValue(m32214k());
        parcel.writeLong(m32215l());
        parcel.writeString(m32216m());
    }
}
