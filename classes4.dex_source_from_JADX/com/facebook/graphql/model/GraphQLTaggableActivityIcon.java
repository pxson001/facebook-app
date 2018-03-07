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
/* compiled from: used_value */
public final class GraphQLTaggableActivityIcon extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLTaggableActivityIcon> CREATOR = new C00441();
    @Nullable
    public String f439d;
    @Nullable
    public String f440e;
    @Nullable
    public GraphQLImage f441f;
    @Nullable
    public GraphQLImage f442g;
    @Nullable
    public GraphQLImage f443h;
    @Nullable
    public GraphQLImage f444i;
    @Nullable
    public String f445j;

    /* compiled from: used_value */
    final class C00441 implements Creator<GraphQLTaggableActivityIcon> {
        C00441() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLTaggableActivityIcon(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLTaggableActivityIcon[i];
        }
    }

    @FieldOffset
    @Nullable
    public final String m743j() {
        this.f439d = super.a(this.f439d, 0);
        return this.f439d;
    }

    @FieldOffset
    @Nullable
    public final String m744k() {
        this.f440e = super.a(this.f440e, 1);
        return this.f440e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m745l() {
        this.f441f = (GraphQLImage) super.a(this.f441f, 2, GraphQLImage.class);
        return this.f441f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m746m() {
        this.f442g = (GraphQLImage) super.a(this.f442g, 3, GraphQLImage.class);
        return this.f442g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m747n() {
        this.f443h = (GraphQLImage) super.a(this.f443h, 4, GraphQLImage.class);
        return this.f443h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m748o() {
        this.f444i = (GraphQLImage) super.a(this.f444i, 5, GraphQLImage.class);
        return this.f444i;
    }

    @FieldOffset
    @Nullable
    public final String m749p() {
        this.f445j = super.a(this.f445j, 6);
        return this.f445j;
    }

    @Nullable
    public final String m742a() {
        return m744k();
    }

    public final int jK_() {
        return 638969039;
    }

    public final GraphQLVisitableModel m741a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLImage graphQLImage;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m745l() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m745l());
            if (m745l() != graphQLImage) {
                graphQLVisitableModel = (GraphQLTaggableActivityIcon) ModelHelper.a(null, this);
                graphQLVisitableModel.f441f = graphQLImage;
            }
        }
        if (m746m() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m746m());
            if (m746m() != graphQLImage) {
                graphQLVisitableModel = (GraphQLTaggableActivityIcon) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f442g = graphQLImage;
            }
        }
        if (m747n() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m747n());
            if (m747n() != graphQLImage) {
                graphQLVisitableModel = (GraphQLTaggableActivityIcon) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f443h = graphQLImage;
            }
        }
        if (m748o() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m748o());
            if (m748o() != graphQLImage) {
                graphQLVisitableModel = (GraphQLTaggableActivityIcon) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f444i = graphQLImage;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLTaggableActivityIcon() {
        super(8);
    }

    public final int m740a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m743j());
        int b2 = flatBufferBuilder.b(m744k());
        int a = ModelHelper.a(flatBufferBuilder, m745l());
        int a2 = ModelHelper.a(flatBufferBuilder, m746m());
        int a3 = ModelHelper.a(flatBufferBuilder, m747n());
        int a4 = ModelHelper.a(flatBufferBuilder, m748o());
        int b3 = flatBufferBuilder.b(m749p());
        flatBufferBuilder.c(7);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, a);
        flatBufferBuilder.b(3, a2);
        flatBufferBuilder.b(4, a3);
        flatBufferBuilder.b(5, a4);
        flatBufferBuilder.b(6, b3);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLTaggableActivityIcon(Parcel parcel) {
        super(8);
        this.f439d = parcel.readString();
        this.f440e = parcel.readString();
        this.f441f = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f442g = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f443h = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f444i = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f445j = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m743j());
        parcel.writeString(m744k());
        parcel.writeValue(m745l());
        parcel.writeValue(m746m());
        parcel.writeValue(m747n());
        parcel.writeValue(m748o());
        parcel.writeString(m749p());
    }

    public GraphQLTaggableActivityIcon(Builder builder) {
        super(8);
        this.b = builder.a;
        this.c = builder.b;
        this.f439d = builder.d;
        this.f440e = builder.e;
        this.f441f = builder.f;
        this.f442g = builder.g;
        this.f443h = builder.h;
        this.f444i = builder.i;
        this.f445j = builder.j;
    }
}
