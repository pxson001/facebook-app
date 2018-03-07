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
/* compiled from: insertion_time_ms */
public final class GraphQLFeedbackReactionInfo extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLFeedbackReactionInfo> CREATOR = new C07931();
    @Nullable
    public String f19825d;
    @Nullable
    public String f19826e;
    public boolean f19827f;
    public int f19828g;
    @Nullable
    public GraphQLImage f19829h;
    @Nullable
    public String f19830i;
    @Nullable
    public GraphQLImage f19831j;
    @Nullable
    public GraphQLImage f19832k;
    @Nullable
    public String f19833l;

    /* compiled from: insertion_time_ms */
    final class C07931 implements Creator<GraphQLFeedbackReactionInfo> {
        C07931() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLFeedbackReactionInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLFeedbackReactionInfo[i];
        }
    }

    @FieldOffset
    @Nullable
    public final String m27558j() {
        this.f19825d = super.m9948a(this.f19825d, 0);
        return this.f19825d;
    }

    @FieldOffset
    @Nullable
    public final String m27559k() {
        this.f19826e = super.m9948a(this.f19826e, 1);
        return this.f19826e;
    }

    @FieldOffset
    public final boolean m27560l() {
        m9949a(0, 2);
        return this.f19827f;
    }

    @FieldOffset
    public final int m27561m() {
        m9949a(0, 3);
        return this.f19828g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m27562n() {
        this.f19829h = (GraphQLImage) super.m9947a(this.f19829h, 4, GraphQLImage.class);
        return this.f19829h;
    }

    @FieldOffset
    @Nullable
    public final String m27563o() {
        this.f19830i = super.m9948a(this.f19830i, 5);
        return this.f19830i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m27564p() {
        this.f19831j = (GraphQLImage) super.m9947a(this.f19831j, 6, GraphQLImage.class);
        return this.f19831j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m27565q() {
        this.f19832k = (GraphQLImage) super.m9947a(this.f19832k, 7, GraphQLImage.class);
        return this.f19832k;
    }

    @FieldOffset
    @Nullable
    public final String m27566r() {
        this.f19833l = super.m9948a(this.f19833l, 8);
        return this.f19833l;
    }

    @Nullable
    public final String mo2834a() {
        return m27559k();
    }

    public final int jK_() {
        return -1654469956;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLImage graphQLImage;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m27562n() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m27562n());
            if (m27562n() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFeedbackReactionInfo) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19829h = graphQLImage;
            }
        }
        if (m27564p() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m27564p());
            if (m27564p() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFeedbackReactionInfo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19831j = graphQLImage;
            }
        }
        if (m27565q() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m27565q());
            if (m27565q() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFeedbackReactionInfo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19832k = graphQLImage;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLFeedbackReactionInfo() {
        super(10);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f19827f = mutableFlatBuffer.m21540a(i, 2);
        this.f19828g = mutableFlatBuffer.m21524a(i, 3, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m27558j());
        int b2 = flatBufferBuilder.m21502b(m27559k());
        int a = ModelHelper.m23093a(flatBufferBuilder, m27562n());
        int b3 = flatBufferBuilder.m21502b(m27563o());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m27564p());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m27565q());
        int b4 = flatBufferBuilder.m21502b(m27566r());
        flatBufferBuilder.m21510c(9);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21498a(2, m27560l());
        flatBufferBuilder.m21494a(3, m27561m(), 0);
        flatBufferBuilder.m21507b(4, a);
        flatBufferBuilder.m21507b(5, b3);
        flatBufferBuilder.m21507b(6, a2);
        flatBufferBuilder.m21507b(7, a3);
        flatBufferBuilder.m21507b(8, b4);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLFeedbackReactionInfo(Parcel parcel) {
        boolean z = true;
        super(10);
        this.f19825d = parcel.readString();
        this.f19826e = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f19827f = z;
        this.f19828g = parcel.readInt();
        this.f19829h = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f19830i = parcel.readString();
        this.f19831j = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f19832k = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f19833l = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m27558j());
        parcel.writeString(m27559k());
        parcel.writeByte((byte) (m27560l() ? 1 : 0));
        parcel.writeInt(m27561m());
        parcel.writeValue(m27562n());
        parcel.writeString(m27563o());
        parcel.writeValue(m27564p());
        parcel.writeValue(m27565q());
        parcel.writeString(m27566r());
    }

    public GraphQLFeedbackReactionInfo(Builder builder) {
        super(10);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f19825d = builder.d;
        this.f19826e = builder.e;
        this.f19827f = builder.f;
        this.f19828g = builder.g;
        this.f19829h = builder.h;
        this.f19830i = builder.i;
        this.f19831j = builder.j;
        this.f19832k = builder.k;
        this.f19833l = builder.l;
    }
}
