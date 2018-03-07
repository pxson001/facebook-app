package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
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
/* compiled from: lead_gen_continued_flow_text */
public final class GraphQLTrendingTopicData extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLTrendingTopicData> CREATOR = new 1();
    @Nullable
    public String f17715d;
    @Nullable
    public String f17716e;
    @Nullable
    public GraphQLImage f17717f;
    @Nullable
    public String f17718g;
    @Nullable
    public String f17719h;
    @Nullable
    public String f17720i;
    @Nullable
    public String f17721j;
    @Nullable
    public String f17722k;
    @Nullable
    public GraphQLImage f17723l;
    @Nullable
    public GraphQLImage f17724m;

    @FieldOffset
    @Nullable
    public final String m24921j() {
        this.f17715d = super.m9948a(this.f17715d, 0);
        return this.f17715d;
    }

    @FieldOffset
    @Nullable
    public final String m24922k() {
        this.f17716e = super.m9948a(this.f17716e, 1);
        return this.f17716e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24923l() {
        this.f17717f = (GraphQLImage) super.m9947a(this.f17717f, 2, GraphQLImage.class);
        return this.f17717f;
    }

    @FieldOffset
    @Nullable
    public final String m24924m() {
        this.f17718g = super.m9948a(this.f17718g, 3);
        return this.f17718g;
    }

    @FieldOffset
    @Nullable
    public final String m24925n() {
        this.f17719h = super.m9948a(this.f17719h, 4);
        return this.f17719h;
    }

    @FieldOffset
    @Nullable
    public final String m24926o() {
        this.f17720i = super.m9948a(this.f17720i, 5);
        return this.f17720i;
    }

    @FieldOffset
    @Nullable
    public final String m24927p() {
        this.f17721j = super.m9948a(this.f17721j, 6);
        return this.f17721j;
    }

    @FieldOffset
    @Nullable
    public final String m24928q() {
        this.f17722k = super.m9948a(this.f17722k, 7);
        return this.f17722k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24929r() {
        this.f17723l = (GraphQLImage) super.m9947a(this.f17723l, 8, GraphQLImage.class);
        return this.f17723l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24930s() {
        this.f17724m = (GraphQLImage) super.m9947a(this.f17724m, 9, GraphQLImage.class);
        return this.f17724m;
    }

    @Nullable
    public final String mo2834a() {
        return m24925n();
    }

    public final int jK_() {
        return -1862466124;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLImage graphQLImage;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24923l() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24923l());
            if (m24923l() != graphQLImage) {
                graphQLVisitableModel = (GraphQLTrendingTopicData) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17717f = graphQLImage;
            }
        }
        if (m24929r() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24929r());
            if (m24929r() != graphQLImage) {
                graphQLVisitableModel = (GraphQLTrendingTopicData) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17723l = graphQLImage;
            }
        }
        if (m24930s() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24930s());
            if (m24930s() != graphQLImage) {
                graphQLVisitableModel = (GraphQLTrendingTopicData) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17724m = graphQLImage;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLTrendingTopicData() {
        super(11);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m24921j());
        int b2 = flatBufferBuilder.m21502b(m24922k());
        int a = ModelHelper.m23093a(flatBufferBuilder, m24923l());
        int b3 = flatBufferBuilder.m21502b(m24924m());
        int b4 = flatBufferBuilder.m21502b(m24925n());
        int b5 = flatBufferBuilder.m21502b(m24926o());
        int b6 = flatBufferBuilder.m21502b(m24927p());
        int b7 = flatBufferBuilder.m21502b(m24928q());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24929r());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m24930s());
        flatBufferBuilder.m21510c(10);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21507b(2, a);
        flatBufferBuilder.m21507b(3, b3);
        flatBufferBuilder.m21507b(4, b4);
        flatBufferBuilder.m21507b(5, b5);
        flatBufferBuilder.m21507b(6, b6);
        flatBufferBuilder.m21507b(7, b7);
        flatBufferBuilder.m21507b(8, a2);
        flatBufferBuilder.m21507b(9, a3);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLTrendingTopicData(Parcel parcel) {
        super(11);
        this.f17715d = parcel.readString();
        this.f17716e = parcel.readString();
        this.f17717f = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17723l = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17724m = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17718g = parcel.readString();
        this.f17719h = parcel.readString();
        this.f17720i = parcel.readString();
        this.f17721j = parcel.readString();
        this.f17722k = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m24921j());
        parcel.writeString(m24922k());
        parcel.writeValue(m24923l());
        parcel.writeValue(m24929r());
        parcel.writeValue(m24930s());
        parcel.writeString(m24924m());
        parcel.writeString(m24925n());
        parcel.writeString(m24926o());
        parcel.writeString(m24927p());
        parcel.writeString(m24928q());
    }
}
