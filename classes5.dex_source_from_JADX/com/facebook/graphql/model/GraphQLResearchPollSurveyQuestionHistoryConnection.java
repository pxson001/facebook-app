package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLResearchPollSurveyQuestionHistoryConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: VIDEO_CHANNEL_HEADER */
public final class GraphQLResearchPollSurveyQuestionHistoryConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLResearchPollSurveyQuestionHistoryConnection> CREATOR = new C12131();
    public List<GraphQLResearchPollMultipleChoiceQuestion> f12938d;

    /* compiled from: VIDEO_CHANNEL_HEADER */
    final class C12131 implements Creator<GraphQLResearchPollSurveyQuestionHistoryConnection> {
        C12131() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLResearchPollSurveyQuestionHistoryConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLResearchPollSurveyQuestionHistoryConnection[i];
        }
    }

    /* compiled from: VIDEO_CHANNEL_HEADER */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLResearchPollSurveyQuestionHistoryConnection.class, new Deserializer());
        }

        public Object m21479a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLResearchPollSurveyQuestionHistoryConnectionDeserializer.m5834a(jsonParser, (short) 359);
            Object graphQLResearchPollSurveyQuestionHistoryConnection = new GraphQLResearchPollSurveyQuestionHistoryConnection();
            ((BaseModel) graphQLResearchPollSurveyQuestionHistoryConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLResearchPollSurveyQuestionHistoryConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLResearchPollSurveyQuestionHistoryConnection).a();
            }
            return graphQLResearchPollSurveyQuestionHistoryConnection;
        }
    }

    /* compiled from: VIDEO_CHANNEL_HEADER */
    public final class Serializer extends JsonSerializer<GraphQLResearchPollSurveyQuestionHistoryConnection> {
        public final void m21480a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLResearchPollSurveyQuestionHistoryConnection graphQLResearchPollSurveyQuestionHistoryConnection = (GraphQLResearchPollSurveyQuestionHistoryConnection) obj;
            GraphQLResearchPollSurveyQuestionHistoryConnectionDeserializer.m5835a(graphQLResearchPollSurveyQuestionHistoryConnection.w_(), graphQLResearchPollSurveyQuestionHistoryConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLResearchPollSurveyQuestionHistoryConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLResearchPollSurveyQuestionHistoryConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLResearchPollMultipleChoiceQuestion> m21483a() {
        this.f12938d = super.a(this.f12938d, 0, GraphQLResearchPollMultipleChoiceQuestion.class);
        return (ImmutableList) this.f12938d;
    }

    public final int jK_() {
        return -630190696;
    }

    public final GraphQLVisitableModel m21482a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21483a() != null) {
            Builder a = ModelHelper.a(m21483a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLResearchPollSurveyQuestionHistoryConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f12938d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLResearchPollSurveyQuestionHistoryConnection() {
        super(2);
    }

    public final int m21481a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21483a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLResearchPollSurveyQuestionHistoryConnection(Parcel parcel) {
        super(2);
        this.f12938d = ImmutableListHelper.a(parcel.readArrayList(GraphQLResearchPollMultipleChoiceQuestion.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m21483a());
    }
}
