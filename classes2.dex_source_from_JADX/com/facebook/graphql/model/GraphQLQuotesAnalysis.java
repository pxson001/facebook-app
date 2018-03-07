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
/* compiled from: liger_recent_hosts */
public final class GraphQLQuotesAnalysis extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLQuotesAnalysis> CREATOR = new 1();
    @Nullable
    public GraphQLQuotesAnalysisItemsConnection f17552d;

    @FieldOffset
    @Nullable
    public final GraphQLQuotesAnalysisItemsConnection m24713a() {
        this.f17552d = (GraphQLQuotesAnalysisItemsConnection) super.m9947a(this.f17552d, 0, GraphQLQuotesAnalysisItemsConnection.class);
        return this.f17552d;
    }

    public final int jK_() {
        return 154701203;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24713a() != null) {
            GraphQLQuotesAnalysisItemsConnection graphQLQuotesAnalysisItemsConnection = (GraphQLQuotesAnalysisItemsConnection) graphQLModelMutatingVisitor.mo2928b(m24713a());
            if (m24713a() != graphQLQuotesAnalysisItemsConnection) {
                graphQLVisitableModel = (GraphQLQuotesAnalysis) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17552d = graphQLQuotesAnalysisItemsConnection;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLQuotesAnalysis() {
        super(2);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m24713a());
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLQuotesAnalysis(Parcel parcel) {
        super(2);
        this.f17552d = (GraphQLQuotesAnalysisItemsConnection) parcel.readValue(GraphQLQuotesAnalysisItemsConnection.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m24713a());
    }
}
