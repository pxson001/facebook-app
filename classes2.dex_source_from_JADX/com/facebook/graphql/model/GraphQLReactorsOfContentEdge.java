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
/* compiled from: install */
public final class GraphQLReactorsOfContentEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLReactorsOfContentEdge> CREATOR = new 1();
    @Nullable
    public GraphQLFeedbackReactionInfo f19818d;
    @Nullable
    public GraphQLActor f19819e;

    @FieldOffset
    @Nullable
    public final GraphQLFeedbackReactionInfo m27540a() {
        this.f19818d = (GraphQLFeedbackReactionInfo) super.m9947a(this.f19818d, 0, GraphQLFeedbackReactionInfo.class);
        return this.f19818d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor m27542j() {
        this.f19819e = (GraphQLActor) super.m9947a(this.f19819e, 1, GraphQLActor.class);
        return this.f19819e;
    }

    public final int jK_() {
        return 717758926;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m27540a() != null) {
            GraphQLFeedbackReactionInfo graphQLFeedbackReactionInfo = (GraphQLFeedbackReactionInfo) graphQLModelMutatingVisitor.mo2928b(m27540a());
            if (m27540a() != graphQLFeedbackReactionInfo) {
                graphQLVisitableModel = (GraphQLReactorsOfContentEdge) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19818d = graphQLFeedbackReactionInfo;
            }
        }
        if (m27542j() != null) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.mo2928b(m27542j());
            if (m27542j() != graphQLActor) {
                graphQLVisitableModel = (GraphQLReactorsOfContentEdge) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19819e = graphQLActor;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLReactorsOfContentEdge() {
        super(3);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m27540a());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m27542j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLReactorsOfContentEdge(Parcel parcel) {
        super(3);
        this.f19818d = (GraphQLFeedbackReactionInfo) parcel.readValue(GraphQLFeedbackReactionInfo.class.getClassLoader());
        this.f19819e = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m27540a());
        parcel.writeValue(m27542j());
    }

    public GraphQLReactorsOfContentEdge(Builder builder) {
        super(3);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f19818d = builder.d;
        this.f19819e = builder.e;
    }
}
