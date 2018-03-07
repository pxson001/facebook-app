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
/* compiled from: instance_log_data */
public final class GraphQLProfileBadge extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLProfileBadge> CREATOR = new 1();
    @Nullable
    GraphQLTaggableActivityIcon f19799d;
    long f19800e;
    @Nullable
    String f19801f;
    @Nullable
    String f19802g;

    @FieldOffset
    @Nullable
    public final GraphQLTaggableActivityIcon m27504j() {
        this.f19799d = (GraphQLTaggableActivityIcon) super.m9947a(this.f19799d, 0, GraphQLTaggableActivityIcon.class);
        return this.f19799d;
    }

    @FieldOffset
    public final long m27505k() {
        m9949a(0, 1);
        return this.f19800e;
    }

    @FieldOffset
    @Nullable
    public final String m27506l() {
        this.f19801f = super.m9948a(this.f19801f, 2);
        return this.f19801f;
    }

    @FieldOffset
    @Nullable
    public final String m27507m() {
        this.f19802g = super.m9948a(this.f19802g, 3);
        return this.f19802g;
    }

    @Nullable
    public final String mo2834a() {
        return m27506l();
    }

    public final int jK_() {
        return 1360861082;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m27504j() != null) {
            GraphQLTaggableActivityIcon graphQLTaggableActivityIcon = (GraphQLTaggableActivityIcon) graphQLModelMutatingVisitor.mo2928b(m27504j());
            if (m27504j() != graphQLTaggableActivityIcon) {
                graphQLVisitableModel = (GraphQLProfileBadge) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19799d = graphQLTaggableActivityIcon;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLProfileBadge() {
        super(5);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f19800e = mutableFlatBuffer.m21525a(i, 1, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m27504j());
        int b = flatBufferBuilder.m21502b(m27506l());
        int b2 = flatBufferBuilder.m21502b(m27507m());
        flatBufferBuilder.m21510c(4);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21495a(1, m27505k(), 0);
        flatBufferBuilder.m21507b(2, b);
        flatBufferBuilder.m21507b(3, b2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLProfileBadge(Parcel parcel) {
        super(5);
        this.f19799d = (GraphQLTaggableActivityIcon) parcel.readValue(GraphQLTaggableActivityIcon.class.getClassLoader());
        this.f19800e = parcel.readLong();
        this.f19801f = parcel.readString();
        this.f19802g = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m27504j());
        parcel.writeLong(m27505k());
        parcel.writeString(m27506l());
        parcel.writeString(m27507m());
    }
}
