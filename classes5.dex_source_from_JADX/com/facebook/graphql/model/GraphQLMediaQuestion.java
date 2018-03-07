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
import com.facebook.graphql.deserializers.GraphQLMediaQuestionDeserializer;
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
/* compiled from: fb4a_groups_tab_menu */
public final class GraphQLMediaQuestion extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLMediaQuestion> CREATOR = new C04321();
    @Nullable
    String f4475d;
    @Nullable
    GraphQLMediaQuestionOptionsConnection f4476e;
    List<GraphQLPhoto> f4477f;
    @Nullable
    String f4478g;
    @Nullable
    String f4479h;
    boolean f4480i;

    /* compiled from: fb4a_groups_tab_menu */
    final class C04321 implements Creator<GraphQLMediaQuestion> {
        C04321() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLMediaQuestion(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLMediaQuestion[i];
        }
    }

    /* compiled from: fb4a_groups_tab_menu */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLMediaQuestion.class, new Deserializer());
        }

        public Object m9015a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLMediaQuestionDeserializer.m5344a(jsonParser, (short) 62);
            Object graphQLMediaQuestion = new GraphQLMediaQuestion();
            ((BaseModel) graphQLMediaQuestion).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLMediaQuestion instanceof Postprocessable) {
                return ((Postprocessable) graphQLMediaQuestion).a();
            }
            return graphQLMediaQuestion;
        }
    }

    /* compiled from: fb4a_groups_tab_menu */
    public final class Serializer extends JsonSerializer<GraphQLMediaQuestion> {
        public final void m9016a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLMediaQuestion graphQLMediaQuestion = (GraphQLMediaQuestion) obj;
            GraphQLMediaQuestionDeserializer.m5345a(graphQLMediaQuestion.w_(), graphQLMediaQuestion.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLMediaQuestion.class, new Serializer());
            FbSerializerProvider.a(GraphQLMediaQuestion.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m9021j() {
        this.f4475d = super.a(this.f4475d, 0);
        return this.f4475d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLMediaQuestionOptionsConnection m9022k() {
        this.f4476e = (GraphQLMediaQuestionOptionsConnection) super.a(this.f4476e, 1, GraphQLMediaQuestionOptionsConnection.class);
        return this.f4476e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLPhoto> m9023l() {
        this.f4477f = super.a(this.f4477f, 2, GraphQLPhoto.class);
        return (ImmutableList) this.f4477f;
    }

    @FieldOffset
    @Nullable
    public final String m9024m() {
        this.f4478g = super.a(this.f4478g, 3);
        return this.f4478g;
    }

    @FieldOffset
    @Nullable
    public final String m9025n() {
        this.f4479h = super.a(this.f4479h, 4);
        return this.f4479h;
    }

    @FieldOffset
    public final boolean m9026o() {
        a(0, 5);
        return this.f4480i;
    }

    @Nullable
    public final String m9019a() {
        return m9021j();
    }

    public final int jK_() {
        return 239016906;
    }

    public final GraphQLVisitableModel m9018a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m9022k() != null) {
            GraphQLMediaQuestionOptionsConnection graphQLMediaQuestionOptionsConnection = (GraphQLMediaQuestionOptionsConnection) graphQLModelMutatingVisitor.b(m9022k());
            if (m9022k() != graphQLMediaQuestionOptionsConnection) {
                graphQLVisitableModel = (GraphQLMediaQuestion) ModelHelper.a(null, this);
                graphQLVisitableModel.f4476e = graphQLMediaQuestionOptionsConnection;
            }
        }
        if (m9023l() != null) {
            Builder a = ModelHelper.a(m9023l(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLMediaQuestion graphQLMediaQuestion = (GraphQLMediaQuestion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLMediaQuestion.f4477f = a.b();
                graphQLVisitableModel = graphQLMediaQuestion;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLMediaQuestion() {
        super(7);
    }

    public final void m9020a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f4480i = mutableFlatBuffer.a(i, 5);
    }

    public final int m9017a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m9021j());
        int a = ModelHelper.a(flatBufferBuilder, m9022k());
        int a2 = ModelHelper.a(flatBufferBuilder, m9023l());
        int b2 = flatBufferBuilder.b(m9024m());
        int b3 = flatBufferBuilder.b(m9025n());
        flatBufferBuilder.c(6);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, b2);
        flatBufferBuilder.b(4, b3);
        flatBufferBuilder.a(5, m9026o());
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLMediaQuestion(Parcel parcel) {
        super(7);
        this.f4475d = parcel.readString();
        this.f4476e = (GraphQLMediaQuestionOptionsConnection) parcel.readValue(GraphQLMediaQuestionOptionsConnection.class.getClassLoader());
        this.f4477f = ImmutableListHelper.a(parcel.readArrayList(GraphQLPhoto.class.getClassLoader()));
        this.f4478g = parcel.readString();
        this.f4479h = parcel.readString();
        this.f4480i = parcel.readByte() == (byte) 1;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m9021j());
        parcel.writeValue(m9022k());
        parcel.writeList(m9023l());
        parcel.writeString(m9024m());
        parcel.writeString(m9025n());
        parcel.writeByte((byte) (m9026o() ? 1 : 0));
    }
}
