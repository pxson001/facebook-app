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
/* compiled from: shipping_method */
public final class GraphQLGreetingCard extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLGreetingCard> CREATOR = new 1();
    @Nullable
    GraphQLGreetingCardTemplate f2224d;
    @Nullable
    String f2225e;
    @Nullable
    GraphQLImage f2226f;
    @Nullable
    GraphQLGreetingCardSlidesConnection f2227g;
    @Nullable
    String f2228h;
    @Nullable
    String f2229i;

    @FieldOffset
    @Nullable
    public final GraphQLGreetingCardTemplate m2420j() {
        this.f2224d = (GraphQLGreetingCardTemplate) super.a(this.f2224d, 0, GraphQLGreetingCardTemplate.class);
        return this.f2224d;
    }

    @FieldOffset
    @Nullable
    public final String m2421k() {
        this.f2225e = super.a(this.f2225e, 1);
        return this.f2225e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m2422l() {
        this.f2226f = (GraphQLImage) super.a(this.f2226f, 2, GraphQLImage.class);
        return this.f2226f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGreetingCardSlidesConnection m2423m() {
        this.f2227g = (GraphQLGreetingCardSlidesConnection) super.a(this.f2227g, 3, GraphQLGreetingCardSlidesConnection.class);
        return this.f2227g;
    }

    @FieldOffset
    @Nullable
    public final String m2424n() {
        this.f2228h = super.a(this.f2228h, 4);
        return this.f2228h;
    }

    @FieldOffset
    @Nullable
    public final String m2425o() {
        this.f2229i = super.a(this.f2229i, 5);
        return this.f2229i;
    }

    @Nullable
    public final String m2419a() {
        return m2421k();
    }

    public final int jK_() {
        return -703791351;
    }

    public final GraphQLVisitableModel m2418a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m2420j() != null) {
            GraphQLGreetingCardTemplate graphQLGreetingCardTemplate = (GraphQLGreetingCardTemplate) graphQLModelMutatingVisitor.b(m2420j());
            if (m2420j() != graphQLGreetingCardTemplate) {
                graphQLVisitableModel = (GraphQLGreetingCard) ModelHelper.a(null, this);
                graphQLVisitableModel.f2224d = graphQLGreetingCardTemplate;
            }
        }
        if (m2422l() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m2422l());
            if (m2422l() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGreetingCard) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f2226f = graphQLImage;
            }
        }
        if (m2423m() != null) {
            GraphQLGreetingCardSlidesConnection graphQLGreetingCardSlidesConnection = (GraphQLGreetingCardSlidesConnection) graphQLModelMutatingVisitor.b(m2423m());
            if (m2423m() != graphQLGreetingCardSlidesConnection) {
                graphQLVisitableModel = (GraphQLGreetingCard) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f2227g = graphQLGreetingCardSlidesConnection;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGreetingCard() {
        super(7);
    }

    public final int m2417a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m2420j());
        int b = flatBufferBuilder.b(m2421k());
        int a2 = ModelHelper.a(flatBufferBuilder, m2422l());
        int a3 = ModelHelper.a(flatBufferBuilder, m2423m());
        int b2 = flatBufferBuilder.b(m2424n());
        int b3 = flatBufferBuilder.b(m2425o());
        flatBufferBuilder.c(6);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, b2);
        flatBufferBuilder.b(5, b3);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGreetingCard(Parcel parcel) {
        super(7);
        this.f2224d = (GraphQLGreetingCardTemplate) parcel.readValue(GraphQLGreetingCardTemplate.class.getClassLoader());
        this.f2225e = parcel.readString();
        this.f2226f = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f2227g = (GraphQLGreetingCardSlidesConnection) parcel.readValue(GraphQLGreetingCardSlidesConnection.class.getClassLoader());
        this.f2228h = parcel.readString();
        this.f2229i = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m2420j());
        parcel.writeString(m2421k());
        parcel.writeValue(m2422l());
        parcel.writeValue(m2423m());
        parcel.writeString(m2424n());
        parcel.writeString(m2425o());
    }

    public GraphQLGreetingCard(Builder builder) {
        super(7);
        this.b = builder.a;
        this.c = builder.b;
        this.f2224d = builder.d;
        this.f2225e = builder.e;
        this.f2226f = builder.f;
        this.f2227g = builder.g;
        this.f2228h = builder.h;
        this.f2229i = builder.i;
    }
}
