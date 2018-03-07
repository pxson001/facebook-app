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
import com.facebook.graphql.deserializers.GraphQLStructuredSurveyConfiguredQuestionDeserializer;
import com.facebook.graphql.enums.GraphQLStructuredSurveyCustomQuestionType;
import com.facebook.graphql.enums.GraphQLStructuredSurveyQuestionType;
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
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: USER */
public final class GraphQLStructuredSurveyConfiguredQuestion extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLStructuredSurveyConfiguredQuestion> CREATOR = new C12421();
    boolean f13207d;
    @Nullable
    GraphQLTextWithEntities f13208e;
    GraphQLStructuredSurveyCustomQuestionType f13209f;
    boolean f13210g;
    @Nullable
    GraphQLTextWithEntities f13211h;
    GraphQLStructuredSurveyQuestionType f13212i;
    @Nullable
    String f13213j;
    List<GraphQLStructuredSurveyResponseOption> f13214k;
    List<GraphQLTextWithEntities> f13215l;

    /* compiled from: USER */
    final class C12421 implements Creator<GraphQLStructuredSurveyConfiguredQuestion> {
        C12421() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLStructuredSurveyConfiguredQuestion(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLStructuredSurveyConfiguredQuestion[i];
        }
    }

    /* compiled from: USER */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLStructuredSurveyConfiguredQuestion.class, new Deserializer());
        }

        public Object m21940a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLStructuredSurveyConfiguredQuestionDeserializer.m5998a(jsonParser, (short) 423);
            Object graphQLStructuredSurveyConfiguredQuestion = new GraphQLStructuredSurveyConfiguredQuestion();
            ((BaseModel) graphQLStructuredSurveyConfiguredQuestion).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLStructuredSurveyConfiguredQuestion instanceof Postprocessable) {
                return ((Postprocessable) graphQLStructuredSurveyConfiguredQuestion).a();
            }
            return graphQLStructuredSurveyConfiguredQuestion;
        }
    }

    /* compiled from: USER */
    public final class Serializer extends JsonSerializer<GraphQLStructuredSurveyConfiguredQuestion> {
        public final void m21941a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLStructuredSurveyConfiguredQuestion graphQLStructuredSurveyConfiguredQuestion = (GraphQLStructuredSurveyConfiguredQuestion) obj;
            GraphQLStructuredSurveyConfiguredQuestionDeserializer.m5999a(graphQLStructuredSurveyConfiguredQuestion.w_(), graphQLStructuredSurveyConfiguredQuestion.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLStructuredSurveyConfiguredQuestion.class, new Serializer());
            FbSerializerProvider.a(GraphQLStructuredSurveyConfiguredQuestion.class, new Serializer());
        }
    }

    @FieldOffset
    public final boolean m21945a() {
        a(0, 0);
        return this.f13207d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m21946j() {
        this.f13208e = (GraphQLTextWithEntities) super.a(this.f13208e, 1, GraphQLTextWithEntities.class);
        return this.f13208e;
    }

    @FieldOffset
    public final GraphQLStructuredSurveyCustomQuestionType m21947k() {
        this.f13209f = (GraphQLStructuredSurveyCustomQuestionType) super.a(this.f13209f, 2, GraphQLStructuredSurveyCustomQuestionType.class, GraphQLStructuredSurveyCustomQuestionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f13209f;
    }

    @FieldOffset
    public final boolean m21948l() {
        a(0, 3);
        return this.f13210g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m21949m() {
        this.f13211h = (GraphQLTextWithEntities) super.a(this.f13211h, 4, GraphQLTextWithEntities.class);
        return this.f13211h;
    }

    @FieldOffset
    public final GraphQLStructuredSurveyQuestionType m21950n() {
        this.f13212i = (GraphQLStructuredSurveyQuestionType) super.a(this.f13212i, 5, GraphQLStructuredSurveyQuestionType.class, GraphQLStructuredSurveyQuestionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f13212i;
    }

    @FieldOffset
    @Nullable
    public final String m21951o() {
        this.f13213j = super.a(this.f13213j, 6);
        return this.f13213j;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStructuredSurveyResponseOption> m21952p() {
        this.f13214k = super.a(this.f13214k, 7, GraphQLStructuredSurveyResponseOption.class);
        return (ImmutableList) this.f13214k;
    }

    @FieldOffset
    public final ImmutableList<GraphQLTextWithEntities> m21953q() {
        this.f13215l = super.a(this.f13215l, 8, GraphQLTextWithEntities.class);
        return (ImmutableList) this.f13215l;
    }

    public final int jK_() {
        return -2122712113;
    }

    public final GraphQLVisitableModel m21943a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21946j() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m21946j());
            if (m21946j() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLStructuredSurveyConfiguredQuestion) ModelHelper.a(null, this);
                graphQLVisitableModel.f13208e = graphQLTextWithEntities;
            }
        }
        if (m21949m() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m21949m());
            if (m21949m() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLStructuredSurveyConfiguredQuestion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13211h = graphQLTextWithEntities;
            }
        }
        if (m21952p() != null) {
            a = ModelHelper.a(m21952p(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLStructuredSurveyConfiguredQuestion graphQLStructuredSurveyConfiguredQuestion = (GraphQLStructuredSurveyConfiguredQuestion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLStructuredSurveyConfiguredQuestion.f13214k = a.b();
                graphQLVisitableModel = graphQLStructuredSurveyConfiguredQuestion;
            }
        }
        if (m21953q() != null) {
            a = ModelHelper.a(m21953q(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLStructuredSurveyConfiguredQuestion = (GraphQLStructuredSurveyConfiguredQuestion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLStructuredSurveyConfiguredQuestion.f13215l = a.b();
                graphQLVisitableModel = graphQLStructuredSurveyConfiguredQuestion;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLStructuredSurveyConfiguredQuestion() {
        super(10);
    }

    public final void m21944a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f13207d = mutableFlatBuffer.a(i, 0);
        this.f13210g = mutableFlatBuffer.a(i, 3);
    }

    public final int m21942a(FlatBufferBuilder flatBufferBuilder) {
        Enum enumR = null;
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21946j());
        int a2 = ModelHelper.a(flatBufferBuilder, m21949m());
        int b = flatBufferBuilder.b(m21951o());
        int a3 = ModelHelper.a(flatBufferBuilder, m21952p());
        int a4 = ModelHelper.a(flatBufferBuilder, m21953q());
        flatBufferBuilder.c(9);
        flatBufferBuilder.a(0, m21945a());
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.a(2, m21947k() == GraphQLStructuredSurveyCustomQuestionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m21947k());
        flatBufferBuilder.a(3, m21948l());
        flatBufferBuilder.b(4, a2);
        if (m21950n() != GraphQLStructuredSurveyQuestionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            enumR = m21950n();
        }
        flatBufferBuilder.a(5, enumR);
        flatBufferBuilder.b(6, b);
        flatBufferBuilder.b(7, a3);
        flatBufferBuilder.b(8, a4);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLStructuredSurveyConfiguredQuestion(Parcel parcel) {
        boolean z = true;
        super(10);
        this.f13207d = parcel.readByte() == (byte) 1;
        this.f13208e = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f13209f = GraphQLStructuredSurveyCustomQuestionType.fromString(parcel.readString());
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f13210g = z;
        this.f13211h = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f13212i = GraphQLStructuredSurveyQuestionType.fromString(parcel.readString());
        this.f13213j = parcel.readString();
        this.f13214k = ImmutableListHelper.a(parcel.readArrayList(GraphQLStructuredSurveyResponseOption.class.getClassLoader()));
        this.f13215l = ImmutableListHelper.a(parcel.readArrayList(GraphQLTextWithEntities.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeByte((byte) (m21945a() ? 1 : 0));
        parcel.writeValue(m21946j());
        parcel.writeString(m21947k().name());
        if (!m21948l()) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(m21949m());
        parcel.writeString(m21950n().name());
        parcel.writeString(m21951o());
        parcel.writeList(m21952p());
        parcel.writeList(m21953q());
    }
}
