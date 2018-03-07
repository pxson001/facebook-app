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
/* compiled from: local_group_did_approve */
public final class GraphQLEmotionalAnalysis extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEmotionalAnalysis> CREATOR = new 1();
    @Nullable
    public GraphQLEmotionalAnalysisItemsConnection f17099d;

    @FieldOffset
    @Nullable
    public final GraphQLEmotionalAnalysisItemsConnection m24106a() {
        this.f17099d = (GraphQLEmotionalAnalysisItemsConnection) super.m9947a(this.f17099d, 0, GraphQLEmotionalAnalysisItemsConnection.class);
        return this.f17099d;
    }

    public final int jK_() {
        return 520958626;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24106a() != null) {
            GraphQLEmotionalAnalysisItemsConnection graphQLEmotionalAnalysisItemsConnection = (GraphQLEmotionalAnalysisItemsConnection) graphQLModelMutatingVisitor.mo2928b(m24106a());
            if (m24106a() != graphQLEmotionalAnalysisItemsConnection) {
                graphQLVisitableModel = (GraphQLEmotionalAnalysis) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17099d = graphQLEmotionalAnalysisItemsConnection;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEmotionalAnalysis() {
        super(2);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m24106a());
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLEmotionalAnalysis(Parcel parcel) {
        super(2);
        this.f17099d = (GraphQLEmotionalAnalysisItemsConnection) parcel.readValue(GraphQLEmotionalAnalysisItemsConnection.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m24106a());
    }
}
