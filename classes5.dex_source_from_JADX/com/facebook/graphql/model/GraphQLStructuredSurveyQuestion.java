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
import com.facebook.graphql.deserializers.GraphQLStructuredSurveyQuestionDeserializer;
import com.facebook.graphql.enums.GraphQLStructuredSurveyQuestionType;
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
/* compiled from: URL cannot be null */
public final class GraphQLStructuredSurveyQuestion extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLStructuredSurveyQuestion> CREATOR = new C12431();
    @Nullable
    GraphQLTextWithEntities f13216d;
    @Nullable
    String f13217e;
    @Nullable
    GraphQLTextWithEntities f13218f;
    @Nullable
    String f13219g;
    GraphQLStructuredSurveyQuestionType f13220h;
    List<GraphQLStructuredSurveyResponseOption> f13221i;
    @Nullable
    String f13222j;

    /* compiled from: URL cannot be null */
    final class C12431 implements Creator<GraphQLStructuredSurveyQuestion> {
        C12431() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLStructuredSurveyQuestion(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLStructuredSurveyQuestion[i];
        }
    }

    /* compiled from: URL cannot be null */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLStructuredSurveyQuestion.class, new Deserializer());
        }

        public Object m21958a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLStructuredSurveyQuestionDeserializer.m6004a(jsonParser, (short) 58);
            Object graphQLStructuredSurveyQuestion = new GraphQLStructuredSurveyQuestion();
            ((BaseModel) graphQLStructuredSurveyQuestion).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLStructuredSurveyQuestion instanceof Postprocessable) {
                return ((Postprocessable) graphQLStructuredSurveyQuestion).a();
            }
            return graphQLStructuredSurveyQuestion;
        }
    }

    /* compiled from: URL cannot be null */
    public final class Serializer extends JsonSerializer<GraphQLStructuredSurveyQuestion> {
        public final void m21959a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLStructuredSurveyQuestion graphQLStructuredSurveyQuestion = (GraphQLStructuredSurveyQuestion) obj;
            GraphQLStructuredSurveyQuestionDeserializer.m6005b(graphQLStructuredSurveyQuestion.w_(), graphQLStructuredSurveyQuestion.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLStructuredSurveyQuestion.class, new Serializer());
            FbSerializerProvider.a(GraphQLStructuredSurveyQuestion.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m21963j() {
        this.f13216d = (GraphQLTextWithEntities) super.a(this.f13216d, 0, GraphQLTextWithEntities.class);
        return this.f13216d;
    }

    @FieldOffset
    @Nullable
    public final String m21964k() {
        this.f13217e = super.a(this.f13217e, 1);
        return this.f13217e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m21965l() {
        this.f13218f = (GraphQLTextWithEntities) super.a(this.f13218f, 2, GraphQLTextWithEntities.class);
        return this.f13218f;
    }

    @FieldOffset
    @Nullable
    public final String m21966m() {
        this.f13219g = super.a(this.f13219g, 3);
        return this.f13219g;
    }

    @FieldOffset
    public final GraphQLStructuredSurveyQuestionType m21967n() {
        this.f13220h = (GraphQLStructuredSurveyQuestionType) super.a(this.f13220h, 4, GraphQLStructuredSurveyQuestionType.class, GraphQLStructuredSurveyQuestionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f13220h;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStructuredSurveyResponseOption> m21968o() {
        this.f13221i = super.a(this.f13221i, 5, GraphQLStructuredSurveyResponseOption.class);
        return (ImmutableList) this.f13221i;
    }

    @FieldOffset
    @Nullable
    public final String m21969p() {
        this.f13222j = super.a(this.f13222j, 6);
        return this.f13222j;
    }

    @Nullable
    public final String m21962a() {
        return m21964k();
    }

    public final int jK_() {
        return 449617201;
    }

    public final GraphQLVisitableModel m21961a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21963j() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m21963j());
            if (m21963j() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLStructuredSurveyQuestion) ModelHelper.a(null, this);
                graphQLVisitableModel.f13216d = graphQLTextWithEntities;
            }
        }
        if (m21965l() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m21965l());
            if (m21965l() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLStructuredSurveyQuestion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13218f = graphQLTextWithEntities;
            }
        }
        if (m21968o() != null) {
            Builder a = ModelHelper.a(m21968o(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLStructuredSurveyQuestion graphQLStructuredSurveyQuestion = (GraphQLStructuredSurveyQuestion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLStructuredSurveyQuestion.f13221i = a.b();
                graphQLVisitableModel = graphQLStructuredSurveyQuestion;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLStructuredSurveyQuestion() {
        super(8);
    }

    public final int m21960a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21963j());
        int b = flatBufferBuilder.b(m21964k());
        int a2 = ModelHelper.a(flatBufferBuilder, m21965l());
        int b2 = flatBufferBuilder.b(m21966m());
        int a3 = ModelHelper.a(flatBufferBuilder, m21968o());
        int b3 = flatBufferBuilder.b(m21969p());
        flatBufferBuilder.c(7);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, b2);
        flatBufferBuilder.a(4, m21967n() == GraphQLStructuredSurveyQuestionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m21967n());
        flatBufferBuilder.b(5, a3);
        flatBufferBuilder.b(6, b3);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLStructuredSurveyQuestion(Parcel parcel) {
        super(8);
        this.f13216d = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f13217e = parcel.readString();
        this.f13218f = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f13219g = parcel.readString();
        this.f13220h = GraphQLStructuredSurveyQuestionType.fromString(parcel.readString());
        this.f13221i = ImmutableListHelper.a(parcel.readArrayList(GraphQLStructuredSurveyResponseOption.class.getClassLoader()));
        this.f13222j = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m21963j());
        parcel.writeString(m21964k());
        parcel.writeValue(m21965l());
        parcel.writeString(m21966m());
        parcel.writeString(m21967n().name());
        parcel.writeList(m21968o());
        parcel.writeString(m21969p());
    }
}
