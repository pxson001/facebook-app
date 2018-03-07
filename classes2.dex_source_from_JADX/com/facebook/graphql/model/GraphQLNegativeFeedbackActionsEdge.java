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
/* compiled from: inline_composer_text_box_clicked */
public final class GraphQLNegativeFeedbackActionsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLNegativeFeedbackActionsEdge> CREATOR = new C07981();
    @Nullable
    public GraphQLNegativeFeedbackAction f19883d;

    /* compiled from: inline_composer_text_box_clicked */
    final class C07981 implements Creator<GraphQLNegativeFeedbackActionsEdge> {
        C07981() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLNegativeFeedbackActionsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLNegativeFeedbackActionsEdge[i];
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLNegativeFeedbackAction m27648a() {
        this.f19883d = (GraphQLNegativeFeedbackAction) super.m9947a(this.f19883d, 0, GraphQLNegativeFeedbackAction.class);
        return this.f19883d;
    }

    public final int jK_() {
        return -971984640;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m27648a() != null) {
            GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction = (GraphQLNegativeFeedbackAction) graphQLModelMutatingVisitor.mo2928b(m27648a());
            if (m27648a() != graphQLNegativeFeedbackAction) {
                graphQLVisitableModel = (GraphQLNegativeFeedbackActionsEdge) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19883d = graphQLNegativeFeedbackAction;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLNegativeFeedbackActionsEdge() {
        super(2);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m27648a());
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLNegativeFeedbackActionsEdge(Parcel parcel) {
        super(2);
        this.f19883d = (GraphQLNegativeFeedbackAction) parcel.readValue(GraphQLNegativeFeedbackAction.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m27648a());
    }
}
