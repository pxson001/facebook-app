package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.enums.GraphQLFeedbackRealTimeActivityType;
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
/* compiled from: instagram_tag_interactions */
public final class GraphQLFeedbackRealTimeActivityInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLFeedbackRealTimeActivityInfo> CREATOR = new 1();
    @Nullable
    GraphQLFeedbackRealTimeActivityActorsConnection f19820d;
    @Nullable
    GraphQLTextWithEntities f19821e;
    GraphQLFeedbackRealTimeActivityType f19822f;

    @FieldOffset
    @Nullable
    public final /* synthetic */ GraphQLFeedbackRealTimeActivityActorsConnection m27544a() {
        return m27546j();
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedbackRealTimeActivityActorsConnection m27546j() {
        this.f19820d = (GraphQLFeedbackRealTimeActivityActorsConnection) super.m9947a(this.f19820d, 0, GraphQLFeedbackRealTimeActivityActorsConnection.class);
        return this.f19820d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m27547k() {
        this.f19821e = (GraphQLTextWithEntities) super.m9947a(this.f19821e, 1, GraphQLTextWithEntities.class);
        return this.f19821e;
    }

    @FieldOffset
    public final GraphQLFeedbackRealTimeActivityType m27548l() {
        this.f19822f = (GraphQLFeedbackRealTimeActivityType) super.m9945a(this.f19822f, 2, GraphQLFeedbackRealTimeActivityType.class, GraphQLFeedbackRealTimeActivityType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f19822f;
    }

    public final int jK_() {
        return 446720205;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m27546j() != null) {
            GraphQLFeedbackRealTimeActivityActorsConnection graphQLFeedbackRealTimeActivityActorsConnection = (GraphQLFeedbackRealTimeActivityActorsConnection) graphQLModelMutatingVisitor.mo2928b(m27546j());
            if (m27546j() != graphQLFeedbackRealTimeActivityActorsConnection) {
                graphQLVisitableModel = (GraphQLFeedbackRealTimeActivityInfo) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19820d = graphQLFeedbackRealTimeActivityActorsConnection;
            }
        }
        if (m27547k() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m27547k());
            if (m27547k() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLFeedbackRealTimeActivityInfo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19821e = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLFeedbackRealTimeActivityInfo() {
        super(4);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m27546j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m27547k());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21496a(2, m27548l() == GraphQLFeedbackRealTimeActivityType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m27548l());
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLFeedbackRealTimeActivityInfo(Parcel parcel) {
        super(4);
        this.f19820d = (GraphQLFeedbackRealTimeActivityActorsConnection) parcel.readValue(GraphQLFeedbackRealTimeActivityActorsConnection.class.getClassLoader());
        this.f19821e = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f19822f = GraphQLFeedbackRealTimeActivityType.fromString(parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m27546j());
        parcel.writeValue(m27547k());
        parcel.writeString(m27548l().name());
    }

    public GraphQLFeedbackRealTimeActivityInfo(Builder builder) {
        super(4);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f19820d = builder.d;
        this.f19821e = builder.e;
        this.f19822f = builder.f;
    }
}
