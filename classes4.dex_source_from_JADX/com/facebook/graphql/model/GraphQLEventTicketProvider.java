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
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: original_analytics_tag */
public final class GraphQLEventTicketProvider extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEventTicketProvider> CREATOR = new 1();
    @Nullable
    public String f5909d;
    @Nullable
    public String f5910e;
    @Nullable
    public GraphQLTextWithEntities f5911f;
    @Nullable
    public String f5912g;
    @Nullable
    public String f5913h;
    @Nullable
    public GraphQLTextWithEntities f5914i;
    @Nullable
    public GraphQLTextWithEntities f5915j;
    @Nullable
    public String f5916k;

    @FieldOffset
    @Nullable
    public final String m6371a() {
        this.f5909d = super.a(this.f5909d, 0);
        return this.f5909d;
    }

    @FieldOffset
    @Nullable
    public final String m6372j() {
        this.f5910e = super.a(this.f5910e, 1);
        return this.f5910e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m6373k() {
        this.f5911f = (GraphQLTextWithEntities) super.a(this.f5911f, 2, GraphQLTextWithEntities.class);
        return this.f5911f;
    }

    @FieldOffset
    @Nullable
    public final String m6374l() {
        this.f5912g = super.a(this.f5912g, 3);
        return this.f5912g;
    }

    @FieldOffset
    @Nullable
    public final String m6375m() {
        this.f5913h = super.a(this.f5913h, 4);
        return this.f5913h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m6376n() {
        this.f5914i = (GraphQLTextWithEntities) super.a(this.f5914i, 5, GraphQLTextWithEntities.class);
        return this.f5914i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m6377o() {
        this.f5915j = (GraphQLTextWithEntities) super.a(this.f5915j, 6, GraphQLTextWithEntities.class);
        return this.f5915j;
    }

    @FieldOffset
    @Nullable
    public final String m6378p() {
        this.f5916k = super.a(this.f5916k, 7);
        return this.f5916k;
    }

    public final int jK_() {
        return 1079863;
    }

    public final GraphQLVisitableModel m6370a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6373k() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m6373k());
            if (m6373k() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLEventTicketProvider) ModelHelper.a(null, this);
                graphQLVisitableModel.f5911f = graphQLTextWithEntities;
            }
        }
        if (m6376n() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m6376n());
            if (m6376n() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLEventTicketProvider) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f5914i = graphQLTextWithEntities;
            }
        }
        if (m6377o() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m6377o());
            if (m6377o() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLEventTicketProvider) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f5915j = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEventTicketProvider() {
        super(9);
    }

    public final int m6369a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m6371a());
        int b2 = flatBufferBuilder.b(m6372j());
        int a = ModelHelper.a(flatBufferBuilder, m6373k());
        int b3 = flatBufferBuilder.b(m6374l());
        int b4 = flatBufferBuilder.b(m6375m());
        int a2 = ModelHelper.a(flatBufferBuilder, m6376n());
        int a3 = ModelHelper.a(flatBufferBuilder, m6377o());
        int b5 = flatBufferBuilder.b(m6378p());
        flatBufferBuilder.c(8);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, a);
        flatBufferBuilder.b(3, b3);
        flatBufferBuilder.b(4, b4);
        flatBufferBuilder.b(5, a2);
        flatBufferBuilder.b(6, a3);
        flatBufferBuilder.b(7, b5);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLEventTicketProvider(Parcel parcel) {
        super(9);
        this.f5909d = parcel.readString();
        this.f5910e = parcel.readString();
        this.f5911f = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f5912g = parcel.readString();
        this.f5913h = parcel.readString();
        this.f5914i = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f5915j = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f5916k = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m6371a());
        parcel.writeString(m6372j());
        parcel.writeValue(m6373k());
        parcel.writeString(m6374l());
        parcel.writeString(m6375m());
        parcel.writeValue(m6376n());
        parcel.writeValue(m6377o());
        parcel.writeString(m6378p());
    }
}
