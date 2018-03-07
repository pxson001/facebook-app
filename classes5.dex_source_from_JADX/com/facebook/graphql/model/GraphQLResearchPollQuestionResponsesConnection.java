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
import com.facebook.graphql.deserializers.GraphQLResearchPollQuestionResponsesConnectionDeserializer;
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
/* compiled from: VIDEO_FLYOUT */
public final class GraphQLResearchPollQuestionResponsesConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLResearchPollQuestionResponsesConnection> CREATOR = new C12101();
    public List<GraphQLResearchPollMultipleChoiceResponse> f12929d;

    /* compiled from: VIDEO_FLYOUT */
    final class C12101 implements Creator<GraphQLResearchPollQuestionResponsesConnection> {
        C12101() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLResearchPollQuestionResponsesConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLResearchPollQuestionResponsesConnection[i];
        }
    }

    /* compiled from: VIDEO_FLYOUT */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLResearchPollQuestionResponsesConnection.class, new Deserializer());
        }

        public Object m21446a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLResearchPollQuestionResponsesConnectionDeserializer.m5825a(jsonParser, (short) 357);
            Object graphQLResearchPollQuestionResponsesConnection = new GraphQLResearchPollQuestionResponsesConnection();
            ((BaseModel) graphQLResearchPollQuestionResponsesConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLResearchPollQuestionResponsesConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLResearchPollQuestionResponsesConnection).a();
            }
            return graphQLResearchPollQuestionResponsesConnection;
        }
    }

    /* compiled from: VIDEO_FLYOUT */
    public final class Serializer extends JsonSerializer<GraphQLResearchPollQuestionResponsesConnection> {
        public final void m21447a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLResearchPollQuestionResponsesConnection graphQLResearchPollQuestionResponsesConnection = (GraphQLResearchPollQuestionResponsesConnection) obj;
            GraphQLResearchPollQuestionResponsesConnectionDeserializer.m5826a(graphQLResearchPollQuestionResponsesConnection.w_(), graphQLResearchPollQuestionResponsesConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLResearchPollQuestionResponsesConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLResearchPollQuestionResponsesConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLResearchPollMultipleChoiceResponse> m21450a() {
        this.f12929d = super.a(this.f12929d, 0, GraphQLResearchPollMultipleChoiceResponse.class);
        return (ImmutableList) this.f12929d;
    }

    public final int jK_() {
        return 1474994832;
    }

    public final GraphQLVisitableModel m21449a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21450a() != null) {
            Builder a = ModelHelper.a(m21450a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLResearchPollQuestionResponsesConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f12929d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLResearchPollQuestionResponsesConnection() {
        super(2);
    }

    public final int m21448a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21450a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLResearchPollQuestionResponsesConnection(Parcel parcel) {
        super(2);
        this.f12929d = ImmutableListHelper.a(parcel.readArrayList(GraphQLResearchPollMultipleChoiceResponse.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m21450a());
    }
}
