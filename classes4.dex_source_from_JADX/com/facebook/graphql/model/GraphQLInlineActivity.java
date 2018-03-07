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
/* compiled from: userSearch */
public final class GraphQLInlineActivity extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLInlineActivity> CREATOR = new C00411();
    @Nullable
    String f411d;
    @Nullable
    GraphQLNode f412e;
    @Nullable
    GraphQLTaggableActivity f413f;
    @Nullable
    GraphQLTaggableActivityIcon f414g;
    @Nullable
    String f415h;

    /* compiled from: userSearch */
    final class C00411 implements Creator<GraphQLInlineActivity> {
        C00411() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLInlineActivity(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLInlineActivity[i];
        }
    }

    @FieldOffset
    @Nullable
    public final String m702j() {
        this.f411d = super.a(this.f411d, 0);
        return this.f411d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNode m703k() {
        this.f412e = (GraphQLNode) super.a(this.f412e, 1, GraphQLNode.class);
        return this.f412e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTaggableActivity m704l() {
        this.f413f = (GraphQLTaggableActivity) super.a(this.f413f, 2, GraphQLTaggableActivity.class);
        return this.f413f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTaggableActivityIcon m705m() {
        this.f414g = (GraphQLTaggableActivityIcon) super.a(this.f414g, 3, GraphQLTaggableActivityIcon.class);
        return this.f414g;
    }

    @FieldOffset
    @Nullable
    public final String m706n() {
        this.f415h = super.a(this.f415h, 4);
        return this.f415h;
    }

    @Nullable
    public final String m701a() {
        return m702j();
    }

    public final int jK_() {
        return 1291787496;
    }

    public final GraphQLVisitableModel m700a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m703k() != null) {
            GraphQLNode graphQLNode = (GraphQLNode) graphQLModelMutatingVisitor.b(m703k());
            if (m703k() != graphQLNode) {
                graphQLVisitableModel = (GraphQLInlineActivity) ModelHelper.a(null, this);
                graphQLVisitableModel.f412e = graphQLNode;
            }
        }
        if (m704l() != null) {
            GraphQLTaggableActivity graphQLTaggableActivity = (GraphQLTaggableActivity) graphQLModelMutatingVisitor.b(m704l());
            if (m704l() != graphQLTaggableActivity) {
                graphQLVisitableModel = (GraphQLInlineActivity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f413f = graphQLTaggableActivity;
            }
        }
        if (m705m() != null) {
            GraphQLTaggableActivityIcon graphQLTaggableActivityIcon = (GraphQLTaggableActivityIcon) graphQLModelMutatingVisitor.b(m705m());
            if (m705m() != graphQLTaggableActivityIcon) {
                graphQLVisitableModel = (GraphQLInlineActivity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f414g = graphQLTaggableActivityIcon;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLInlineActivity() {
        super(6);
    }

    public final int m699a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m702j());
        int a = ModelHelper.a(flatBufferBuilder, m703k());
        int a2 = ModelHelper.a(flatBufferBuilder, m704l());
        int a3 = ModelHelper.a(flatBufferBuilder, m705m());
        int b2 = flatBufferBuilder.b(m706n());
        flatBufferBuilder.c(5);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLInlineActivity(Parcel parcel) {
        super(6);
        this.f411d = parcel.readString();
        this.f412e = (GraphQLNode) parcel.readValue(GraphQLNode.class.getClassLoader());
        this.f413f = (GraphQLTaggableActivity) parcel.readValue(GraphQLTaggableActivity.class.getClassLoader());
        this.f414g = (GraphQLTaggableActivityIcon) parcel.readValue(GraphQLTaggableActivityIcon.class.getClassLoader());
        this.f415h = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m702j());
        parcel.writeValue(m703k());
        parcel.writeValue(m704l());
        parcel.writeValue(m705m());
        parcel.writeString(m706n());
    }

    public GraphQLInlineActivity(Builder builder) {
        super(6);
        this.b = builder.a;
        this.c = builder.b;
        this.f411d = builder.d;
        this.f412e = builder.e;
        this.f413f = builder.f;
        this.f414g = builder.g;
        this.f415h = builder.h;
    }
}
