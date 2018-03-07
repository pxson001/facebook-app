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
import com.facebook.graphql.deserializers.GraphQLStructuredSurveyQuestionsConnectionDeserializer;
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
/* compiled from: URL */
public final class GraphQLStructuredSurveyQuestionsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLStructuredSurveyQuestionsConnection> CREATOR = new C12441();
    public List<GraphQLStructuredSurveyQuestion> f13223d;

    /* compiled from: URL */
    final class C12441 implements Creator<GraphQLStructuredSurveyQuestionsConnection> {
        C12441() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLStructuredSurveyQuestionsConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLStructuredSurveyQuestionsConnection[i];
        }
    }

    /* compiled from: URL */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLStructuredSurveyQuestionsConnection.class, new Deserializer());
        }

        public Object m21975a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLStructuredSurveyQuestionsConnectionDeserializer.m6007a(jsonParser, (short) 354);
            Object graphQLStructuredSurveyQuestionsConnection = new GraphQLStructuredSurveyQuestionsConnection();
            ((BaseModel) graphQLStructuredSurveyQuestionsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLStructuredSurveyQuestionsConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLStructuredSurveyQuestionsConnection).a();
            }
            return graphQLStructuredSurveyQuestionsConnection;
        }
    }

    /* compiled from: URL */
    public final class Serializer extends JsonSerializer<GraphQLStructuredSurveyQuestionsConnection> {
        public final void m21976a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLStructuredSurveyQuestionsConnection graphQLStructuredSurveyQuestionsConnection = (GraphQLStructuredSurveyQuestionsConnection) obj;
            GraphQLStructuredSurveyQuestionsConnectionDeserializer.m6008a(graphQLStructuredSurveyQuestionsConnection.w_(), graphQLStructuredSurveyQuestionsConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLStructuredSurveyQuestionsConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLStructuredSurveyQuestionsConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLStructuredSurveyQuestion> m21979a() {
        this.f13223d = super.a(this.f13223d, 0, GraphQLStructuredSurveyQuestion.class);
        return (ImmutableList) this.f13223d;
    }

    public final int jK_() {
        return 74617312;
    }

    public final GraphQLVisitableModel m21978a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21979a() != null) {
            Builder a = ModelHelper.a(m21979a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLStructuredSurveyQuestionsConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f13223d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLStructuredSurveyQuestionsConnection() {
        super(2);
    }

    public final int m21977a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21979a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLStructuredSurveyQuestionsConnection(Parcel parcel) {
        super(2);
        this.f13223d = ImmutableListHelper.a(parcel.readArrayList(GraphQLStructuredSurveyQuestion.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m21979a());
    }
}
