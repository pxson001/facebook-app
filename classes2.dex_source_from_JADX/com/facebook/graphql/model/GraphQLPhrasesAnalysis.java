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
/* compiled from: likeableId */
public final class GraphQLPhrasesAnalysis extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPhrasesAnalysis> CREATOR = new 1();
    @Nullable
    public GraphQLPhrasesAnalysisItemsConnection f17515d;

    @FieldOffset
    @Nullable
    public final GraphQLPhrasesAnalysisItemsConnection m24652a() {
        this.f17515d = (GraphQLPhrasesAnalysisItemsConnection) super.m9947a(this.f17515d, 0, GraphQLPhrasesAnalysisItemsConnection.class);
        return this.f17515d;
    }

    public final int jK_() {
        return -1668149834;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24652a() != null) {
            GraphQLPhrasesAnalysisItemsConnection graphQLPhrasesAnalysisItemsConnection = (GraphQLPhrasesAnalysisItemsConnection) graphQLModelMutatingVisitor.mo2928b(m24652a());
            if (m24652a() != graphQLPhrasesAnalysisItemsConnection) {
                graphQLVisitableModel = (GraphQLPhrasesAnalysis) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17515d = graphQLPhrasesAnalysisItemsConnection;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPhrasesAnalysis() {
        super(2);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m24652a());
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPhrasesAnalysis(Parcel parcel) {
        super(2);
        this.f17515d = (GraphQLPhrasesAnalysisItemsConnection) parcel.readValue(GraphQLPhrasesAnalysisItemsConnection.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m24652a());
    }
}
