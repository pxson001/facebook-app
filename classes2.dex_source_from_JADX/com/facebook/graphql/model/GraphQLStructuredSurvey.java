package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.enums.GraphQLStructuredSurveyFlowType;
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
/* compiled from: legacy_check_code */
public final class GraphQLStructuredSurvey extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLStructuredSurvey> CREATOR = new 1();
    @Deprecated
    @Nullable
    GraphQLStructuredSurveyQuestionsConnection f17684d;
    @Nullable
    String f17685e;
    @Nullable
    String f17686f;
    @Deprecated
    @Nullable
    GraphQLStructuredSurveyQuestionsConnection f17687g;
    @Deprecated
    GraphQLStructuredSurveyFlowType f17688h;
    @Nullable
    String f17689i;

    @FieldOffset
    @Nullable
    public final GraphQLStructuredSurveyQuestionsConnection m24879j() {
        this.f17684d = (GraphQLStructuredSurveyQuestionsConnection) super.m9947a(this.f17684d, 0, GraphQLStructuredSurveyQuestionsConnection.class);
        return this.f17684d;
    }

    @FieldOffset
    @Nullable
    public final String m24880k() {
        this.f17685e = super.m9948a(this.f17685e, 1);
        return this.f17685e;
    }

    @FieldOffset
    @Nullable
    public final String m24881l() {
        this.f17686f = super.m9948a(this.f17686f, 2);
        return this.f17686f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStructuredSurveyQuestionsConnection m24882m() {
        this.f17687g = (GraphQLStructuredSurveyQuestionsConnection) super.m9947a(this.f17687g, 3, GraphQLStructuredSurveyQuestionsConnection.class);
        return this.f17687g;
    }

    @FieldOffset
    public final GraphQLStructuredSurveyFlowType m24883n() {
        this.f17688h = (GraphQLStructuredSurveyFlowType) super.m9945a(this.f17688h, 4, GraphQLStructuredSurveyFlowType.class, GraphQLStructuredSurveyFlowType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17688h;
    }

    @FieldOffset
    @Nullable
    public final String m24884o() {
        this.f17689i = super.m9948a(this.f17689i, 5);
        return this.f17689i;
    }

    @Nullable
    public final String mo2834a() {
        return m24880k();
    }

    public final int jK_() {
        return -943106005;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLStructuredSurveyQuestionsConnection graphQLStructuredSurveyQuestionsConnection;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24879j() != null) {
            graphQLStructuredSurveyQuestionsConnection = (GraphQLStructuredSurveyQuestionsConnection) graphQLModelMutatingVisitor.mo2928b(m24879j());
            if (m24879j() != graphQLStructuredSurveyQuestionsConnection) {
                graphQLVisitableModel = (GraphQLStructuredSurvey) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17684d = graphQLStructuredSurveyQuestionsConnection;
            }
        }
        if (m24882m() != null) {
            graphQLStructuredSurveyQuestionsConnection = (GraphQLStructuredSurveyQuestionsConnection) graphQLModelMutatingVisitor.mo2928b(m24882m());
            if (m24882m() != graphQLStructuredSurveyQuestionsConnection) {
                graphQLVisitableModel = (GraphQLStructuredSurvey) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17687g = graphQLStructuredSurveyQuestionsConnection;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLStructuredSurvey() {
        super(7);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m24879j());
        int b = flatBufferBuilder.m21502b(m24880k());
        int b2 = flatBufferBuilder.m21502b(m24881l());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24882m());
        int b3 = flatBufferBuilder.m21502b(m24884o());
        flatBufferBuilder.m21510c(6);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, b2);
        flatBufferBuilder.m21507b(3, a2);
        flatBufferBuilder.m21496a(4, m24883n() == GraphQLStructuredSurveyFlowType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m24883n());
        flatBufferBuilder.m21507b(5, b3);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLStructuredSurvey(Parcel parcel) {
        super(7);
        this.f17684d = (GraphQLStructuredSurveyQuestionsConnection) parcel.readValue(GraphQLStructuredSurveyQuestionsConnection.class.getClassLoader());
        this.f17685e = parcel.readString();
        this.f17686f = parcel.readString();
        this.f17687g = (GraphQLStructuredSurveyQuestionsConnection) parcel.readValue(GraphQLStructuredSurveyQuestionsConnection.class.getClassLoader());
        this.f17688h = GraphQLStructuredSurveyFlowType.fromString(parcel.readString());
        this.f17689i = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m24879j());
        parcel.writeString(m24880k());
        parcel.writeString(m24881l());
        parcel.writeValue(m24882m());
        parcel.writeString(m24883n().name());
        parcel.writeString(m24884o());
    }
}
