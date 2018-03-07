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
import com.facebook.graphql.deserializers.GraphQLResearchPollSurveyDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: VIDEO_CHANNEL_RECOMMENDATION */
public final class GraphQLResearchPollSurvey extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLResearchPollSurvey> CREATOR = new C12121();
    @Nullable
    GraphQLActor f12931d;
    @Nullable
    GraphQLResearchPollMultipleChoiceQuestion f12932e;
    @Nullable
    String f12933f;
    List<GraphQLResearchPollMultipleChoiceQuestion> f12934g;
    long f12935h;
    @Nullable
    String f12936i;
    @Nullable
    GraphQLResearchPollSurveyQuestionHistoryConnection f12937j;

    /* compiled from: VIDEO_CHANNEL_RECOMMENDATION */
    final class C12121 implements Creator<GraphQLResearchPollSurvey> {
        C12121() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLResearchPollSurvey(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLResearchPollSurvey[i];
        }
    }

    /* compiled from: VIDEO_CHANNEL_RECOMMENDATION */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLResearchPollSurvey.class, new Deserializer());
        }

        public Object m21465a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLResearchPollSurveyDeserializer.m5831a(jsonParser, (short) 10);
            Object graphQLResearchPollSurvey = new GraphQLResearchPollSurvey();
            ((BaseModel) graphQLResearchPollSurvey).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLResearchPollSurvey instanceof Postprocessable) {
                return ((Postprocessable) graphQLResearchPollSurvey).a();
            }
            return graphQLResearchPollSurvey;
        }
    }

    /* compiled from: VIDEO_CHANNEL_RECOMMENDATION */
    public final class Serializer extends JsonSerializer<GraphQLResearchPollSurvey> {
        public final void m21466a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLResearchPollSurvey graphQLResearchPollSurvey = (GraphQLResearchPollSurvey) obj;
            GraphQLResearchPollSurveyDeserializer.m5832a(graphQLResearchPollSurvey.w_(), graphQLResearchPollSurvey.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLResearchPollSurvey.class, new Serializer());
            FbSerializerProvider.a(GraphQLResearchPollSurvey.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor m21471j() {
        this.f12931d = (GraphQLActor) super.a(this.f12931d, 0, GraphQLActor.class);
        return this.f12931d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLResearchPollMultipleChoiceQuestion m21472k() {
        this.f12932e = (GraphQLResearchPollMultipleChoiceQuestion) super.a(this.f12932e, 1, GraphQLResearchPollMultipleChoiceQuestion.class);
        return this.f12932e;
    }

    @FieldOffset
    @Nullable
    public final String m21473l() {
        this.f12933f = super.a(this.f12933f, 2);
        return this.f12933f;
    }

    @FieldOffset
    public final ImmutableList<GraphQLResearchPollMultipleChoiceQuestion> m21474m() {
        this.f12934g = super.a(this.f12934g, 3, GraphQLResearchPollMultipleChoiceQuestion.class);
        return (ImmutableList) this.f12934g;
    }

    @FieldOffset
    public final long m21475n() {
        a(0, 4);
        return this.f12935h;
    }

    @FieldOffset
    @Nullable
    public final String m21476o() {
        this.f12936i = super.a(this.f12936i, 5);
        return this.f12936i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLResearchPollSurveyQuestionHistoryConnection m21477p() {
        this.f12937j = (GraphQLResearchPollSurveyQuestionHistoryConnection) super.a(this.f12937j, 6, GraphQLResearchPollSurveyQuestionHistoryConnection.class);
        return this.f12937j;
    }

    @Nullable
    public final String m21469a() {
        return m21473l();
    }

    public final int jK_() {
        return 752645140;
    }

    public final GraphQLVisitableModel m21468a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21471j() != null) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.b(m21471j());
            if (m21471j() != graphQLActor) {
                graphQLVisitableModel = (GraphQLResearchPollSurvey) ModelHelper.a(null, this);
                graphQLVisitableModel.f12931d = graphQLActor;
            }
        }
        if (m21472k() != null) {
            GraphQLResearchPollMultipleChoiceQuestion graphQLResearchPollMultipleChoiceQuestion = (GraphQLResearchPollMultipleChoiceQuestion) graphQLModelMutatingVisitor.b(m21472k());
            if (m21472k() != graphQLResearchPollMultipleChoiceQuestion) {
                graphQLVisitableModel = (GraphQLResearchPollSurvey) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12932e = graphQLResearchPollMultipleChoiceQuestion;
            }
        }
        if (m21474m() != null) {
            Builder a = ModelHelper.a(m21474m(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLResearchPollSurvey graphQLResearchPollSurvey = (GraphQLResearchPollSurvey) ModelHelper.a(graphQLVisitableModel, this);
                graphQLResearchPollSurvey.f12934g = a.b();
                graphQLVisitableModel = graphQLResearchPollSurvey;
            }
        }
        if (m21477p() != null) {
            GraphQLResearchPollSurveyQuestionHistoryConnection graphQLResearchPollSurveyQuestionHistoryConnection = (GraphQLResearchPollSurveyQuestionHistoryConnection) graphQLModelMutatingVisitor.b(m21477p());
            if (m21477p() != graphQLResearchPollSurveyQuestionHistoryConnection) {
                graphQLVisitableModel = (GraphQLResearchPollSurvey) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12937j = graphQLResearchPollSurveyQuestionHistoryConnection;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLResearchPollSurvey() {
        super(8);
    }

    public final void m21470a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f12935h = mutableFlatBuffer.a(i, 4, 0);
    }

    public final int m21467a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21471j());
        int a2 = ModelHelper.a(flatBufferBuilder, m21472k());
        int b = flatBufferBuilder.b(m21473l());
        int a3 = ModelHelper.a(flatBufferBuilder, m21474m());
        int b2 = flatBufferBuilder.b(m21476o());
        int a4 = ModelHelper.a(flatBufferBuilder, m21477p());
        flatBufferBuilder.c(7);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, b);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.a(4, m21475n(), 0);
        flatBufferBuilder.b(5, b2);
        flatBufferBuilder.b(6, a4);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLResearchPollSurvey(Parcel parcel) {
        super(8);
        this.f12931d = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
        this.f12932e = (GraphQLResearchPollMultipleChoiceQuestion) parcel.readValue(GraphQLResearchPollMultipleChoiceQuestion.class.getClassLoader());
        this.f12933f = parcel.readString();
        this.f12934g = ImmutableListHelper.a(parcel.readArrayList(GraphQLResearchPollMultipleChoiceQuestion.class.getClassLoader()));
        this.f12935h = parcel.readLong();
        this.f12936i = parcel.readString();
        this.f12937j = (GraphQLResearchPollSurveyQuestionHistoryConnection) parcel.readValue(GraphQLResearchPollSurveyQuestionHistoryConnection.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m21471j());
        parcel.writeValue(m21472k());
        parcel.writeString(m21473l());
        parcel.writeList(m21474m());
        parcel.writeLong(m21475n());
        parcel.writeString(m21476o());
        parcel.writeValue(m21477p());
    }
}
