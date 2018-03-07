package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: legacy_api_post_id */
public final class GraphQLFeedbackReaction extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLFeedbackReaction> CREATOR = new C07901();
    public int f17690d;

    /* compiled from: legacy_api_post_id */
    final class C07901 implements Creator<GraphQLFeedbackReaction> {
        C07901() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLFeedbackReaction(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLFeedbackReaction[i];
        }
    }

    @FieldOffset
    public final int m24885a() {
        m9949a(0, 0);
        return this.f17690d;
    }

    public final int jK_() {
        return 116529390;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public GraphQLFeedbackReaction() {
        super(2);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17690d = mutableFlatBuffer.m21524a(i, 0, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21494a(0, m24885a(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLFeedbackReaction(Parcel parcel) {
        super(2);
        this.f17690d = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m24885a());
    }

    public GraphQLFeedbackReaction(Builder builder) {
        super(2);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f17690d = builder.d;
    }
}
