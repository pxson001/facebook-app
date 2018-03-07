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
import com.facebook.graphql.deserializers.GraphQLResearchPollMultipleChoiceQuestionDeserializer;
import com.facebook.graphql.enums.GraphQLResearchPollQuestionType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: VIDEO_HOME_HIGHLIGHTED */
public final class GraphQLResearchPollMultipleChoiceQuestion extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLResearchPollMultipleChoiceQuestion> CREATOR = new C12071();
    public boolean f12915d;
    @Nullable
    public String f12916e;
    @Nullable
    public GraphQLResearchPollMultipleChoiceQuestion f12917f;
    @Nullable
    public GraphQLResearchPollQuestionRespondersConnection f12918g;
    public GraphQLResearchPollQuestionType f12919h;
    @Nullable
    public String f12920i;
    @Nullable
    public GraphQLResearchPollQuestionResponsesConnection f12921j;
    @Nullable
    public String f12922k;

    /* compiled from: VIDEO_HOME_HIGHLIGHTED */
    final class C12071 implements Creator<GraphQLResearchPollMultipleChoiceQuestion> {
        C12071() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLResearchPollMultipleChoiceQuestion(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLResearchPollMultipleChoiceQuestion[i];
        }
    }

    /* compiled from: VIDEO_HOME_HIGHLIGHTED */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLResearchPollMultipleChoiceQuestion.class, new Deserializer());
        }

        public Object m21404a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLResearchPollMultipleChoiceQuestionDeserializer.m5814a(jsonParser, (short) 8);
            Object graphQLResearchPollMultipleChoiceQuestion = new GraphQLResearchPollMultipleChoiceQuestion();
            ((BaseModel) graphQLResearchPollMultipleChoiceQuestion).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLResearchPollMultipleChoiceQuestion instanceof Postprocessable) {
                return ((Postprocessable) graphQLResearchPollMultipleChoiceQuestion).a();
            }
            return graphQLResearchPollMultipleChoiceQuestion;
        }
    }

    /* compiled from: VIDEO_HOME_HIGHLIGHTED */
    public final class Serializer extends JsonSerializer<GraphQLResearchPollMultipleChoiceQuestion> {
        public final void m21405a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLResearchPollMultipleChoiceQuestion graphQLResearchPollMultipleChoiceQuestion = (GraphQLResearchPollMultipleChoiceQuestion) obj;
            GraphQLResearchPollMultipleChoiceQuestionDeserializer.m5817b(graphQLResearchPollMultipleChoiceQuestion.w_(), graphQLResearchPollMultipleChoiceQuestion.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLResearchPollMultipleChoiceQuestion.class, new Serializer());
            FbSerializerProvider.a(GraphQLResearchPollMultipleChoiceQuestion.class, new Serializer());
        }
    }

    @FieldOffset
    public final boolean m21410j() {
        a(0, 0);
        return this.f12915d;
    }

    @FieldOffset
    @Nullable
    public final String m21411k() {
        this.f12916e = super.a(this.f12916e, 1);
        return this.f12916e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLResearchPollMultipleChoiceQuestion m21412l() {
        this.f12917f = (GraphQLResearchPollMultipleChoiceQuestion) super.a(this.f12917f, 2, GraphQLResearchPollMultipleChoiceQuestion.class);
        return this.f12917f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLResearchPollQuestionRespondersConnection m21413m() {
        this.f12918g = (GraphQLResearchPollQuestionRespondersConnection) super.a(this.f12918g, 3, GraphQLResearchPollQuestionRespondersConnection.class);
        return this.f12918g;
    }

    @FieldOffset
    public final GraphQLResearchPollQuestionType m21414n() {
        this.f12919h = (GraphQLResearchPollQuestionType) super.a(this.f12919h, 4, GraphQLResearchPollQuestionType.class, GraphQLResearchPollQuestionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f12919h;
    }

    @FieldOffset
    @Nullable
    public final String m21415o() {
        this.f12920i = super.a(this.f12920i, 5);
        return this.f12920i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLResearchPollQuestionResponsesConnection m21416p() {
        this.f12921j = (GraphQLResearchPollQuestionResponsesConnection) super.a(this.f12921j, 6, GraphQLResearchPollQuestionResponsesConnection.class);
        return this.f12921j;
    }

    @FieldOffset
    @Nullable
    public final String m21417q() {
        this.f12922k = super.a(this.f12922k, 7);
        return this.f12922k;
    }

    @Nullable
    public final String m21408a() {
        return m21411k();
    }

    public final int jK_() {
        return 62815121;
    }

    public final GraphQLVisitableModel m21407a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21412l() != null) {
            GraphQLResearchPollMultipleChoiceQuestion graphQLResearchPollMultipleChoiceQuestion = (GraphQLResearchPollMultipleChoiceQuestion) graphQLModelMutatingVisitor.b(m21412l());
            if (m21412l() != graphQLResearchPollMultipleChoiceQuestion) {
                graphQLVisitableModel = (GraphQLResearchPollMultipleChoiceQuestion) ModelHelper.a(null, this);
                graphQLVisitableModel.f12917f = graphQLResearchPollMultipleChoiceQuestion;
            }
        }
        if (m21413m() != null) {
            GraphQLResearchPollQuestionRespondersConnection graphQLResearchPollQuestionRespondersConnection = (GraphQLResearchPollQuestionRespondersConnection) graphQLModelMutatingVisitor.b(m21413m());
            if (m21413m() != graphQLResearchPollQuestionRespondersConnection) {
                graphQLVisitableModel = (GraphQLResearchPollMultipleChoiceQuestion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12918g = graphQLResearchPollQuestionRespondersConnection;
            }
        }
        if (m21416p() != null) {
            GraphQLResearchPollQuestionResponsesConnection graphQLResearchPollQuestionResponsesConnection = (GraphQLResearchPollQuestionResponsesConnection) graphQLModelMutatingVisitor.b(m21416p());
            if (m21416p() != graphQLResearchPollQuestionResponsesConnection) {
                graphQLVisitableModel = (GraphQLResearchPollMultipleChoiceQuestion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12921j = graphQLResearchPollQuestionResponsesConnection;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLResearchPollMultipleChoiceQuestion() {
        super(9);
    }

    public final void m21409a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f12915d = mutableFlatBuffer.a(i, 0);
    }

    public final int m21406a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m21411k());
        int a = ModelHelper.a(flatBufferBuilder, m21412l());
        int a2 = ModelHelper.a(flatBufferBuilder, m21413m());
        int b2 = flatBufferBuilder.b(m21415o());
        int a3 = ModelHelper.a(flatBufferBuilder, m21416p());
        int b3 = flatBufferBuilder.b(m21417q());
        flatBufferBuilder.c(8);
        flatBufferBuilder.a(0, m21410j());
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, a);
        flatBufferBuilder.b(3, a2);
        flatBufferBuilder.a(4, m21414n() == GraphQLResearchPollQuestionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m21414n());
        flatBufferBuilder.b(5, b2);
        flatBufferBuilder.b(6, a3);
        flatBufferBuilder.b(7, b3);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLResearchPollMultipleChoiceQuestion(Parcel parcel) {
        boolean z = true;
        super(9);
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f12915d = z;
        this.f12916e = parcel.readString();
        this.f12917f = (GraphQLResearchPollMultipleChoiceQuestion) parcel.readValue(GraphQLResearchPollMultipleChoiceQuestion.class.getClassLoader());
        this.f12918g = (GraphQLResearchPollQuestionRespondersConnection) parcel.readValue(GraphQLResearchPollQuestionRespondersConnection.class.getClassLoader());
        this.f12919h = GraphQLResearchPollQuestionType.fromString(parcel.readString());
        this.f12920i = parcel.readString();
        this.f12921j = (GraphQLResearchPollQuestionResponsesConnection) parcel.readValue(GraphQLResearchPollQuestionResponsesConnection.class.getClassLoader());
        this.f12922k = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (m21410j() ? 1 : 0));
        parcel.writeString(m21411k());
        parcel.writeValue(m21412l());
        parcel.writeValue(m21413m());
        parcel.writeString(m21414n().name());
        parcel.writeString(m21415o());
        parcel.writeValue(m21416p());
        parcel.writeString(m21417q());
    }
}
