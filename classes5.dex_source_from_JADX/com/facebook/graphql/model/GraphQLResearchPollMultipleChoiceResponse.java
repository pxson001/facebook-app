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
import com.facebook.graphql.deserializers.GraphQLResearchPollMultipleChoiceResponseDeserializer;
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
/* compiled from: VIDEO_HOME_GENERIC_FEED */
public final class GraphQLResearchPollMultipleChoiceResponse extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLResearchPollMultipleChoiceResponse> CREATOR = new C12081();
    @Nullable
    public String f12923d;
    @Nullable
    public String f12924e;
    @Nullable
    public GraphQLResearchPollMultipleChoiceQuestion f12925f;
    @Nullable
    public GraphQLResearchPollResponseRespondersConnection f12926g;
    @Nullable
    public String f12927h;

    /* compiled from: VIDEO_HOME_GENERIC_FEED */
    final class C12081 implements Creator<GraphQLResearchPollMultipleChoiceResponse> {
        C12081() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLResearchPollMultipleChoiceResponse(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLResearchPollMultipleChoiceResponse[i];
        }
    }

    /* compiled from: VIDEO_HOME_GENERIC_FEED */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLResearchPollMultipleChoiceResponse.class, new Deserializer());
        }

        public Object m21422a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLResearchPollMultipleChoiceResponseDeserializer.m5819a(jsonParser, (short) 9);
            Object graphQLResearchPollMultipleChoiceResponse = new GraphQLResearchPollMultipleChoiceResponse();
            ((BaseModel) graphQLResearchPollMultipleChoiceResponse).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLResearchPollMultipleChoiceResponse instanceof Postprocessable) {
                return ((Postprocessable) graphQLResearchPollMultipleChoiceResponse).a();
            }
            return graphQLResearchPollMultipleChoiceResponse;
        }
    }

    /* compiled from: VIDEO_HOME_GENERIC_FEED */
    public final class Serializer extends JsonSerializer<GraphQLResearchPollMultipleChoiceResponse> {
        public final void m21423a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLResearchPollMultipleChoiceResponse graphQLResearchPollMultipleChoiceResponse = (GraphQLResearchPollMultipleChoiceResponse) obj;
            GraphQLResearchPollMultipleChoiceResponseDeserializer.m5820b(graphQLResearchPollMultipleChoiceResponse.w_(), graphQLResearchPollMultipleChoiceResponse.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLResearchPollMultipleChoiceResponse.class, new Serializer());
            FbSerializerProvider.a(GraphQLResearchPollMultipleChoiceResponse.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m21427j() {
        this.f12923d = super.a(this.f12923d, 0);
        return this.f12923d;
    }

    @FieldOffset
    @Nullable
    public final String m21428k() {
        this.f12924e = super.a(this.f12924e, 1);
        return this.f12924e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLResearchPollMultipleChoiceQuestion m21429l() {
        this.f12925f = (GraphQLResearchPollMultipleChoiceQuestion) super.a(this.f12925f, 2, GraphQLResearchPollMultipleChoiceQuestion.class);
        return this.f12925f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLResearchPollResponseRespondersConnection m21430m() {
        this.f12926g = (GraphQLResearchPollResponseRespondersConnection) super.a(this.f12926g, 3, GraphQLResearchPollResponseRespondersConnection.class);
        return this.f12926g;
    }

    @FieldOffset
    @Nullable
    public final String m21431n() {
        this.f12927h = super.a(this.f12927h, 4);
        return this.f12927h;
    }

    @Nullable
    public final String m21426a() {
        return m21428k();
    }

    public final int jK_() {
        return 888361964;
    }

    public final GraphQLVisitableModel m21425a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21429l() != null) {
            GraphQLResearchPollMultipleChoiceQuestion graphQLResearchPollMultipleChoiceQuestion = (GraphQLResearchPollMultipleChoiceQuestion) graphQLModelMutatingVisitor.b(m21429l());
            if (m21429l() != graphQLResearchPollMultipleChoiceQuestion) {
                graphQLVisitableModel = (GraphQLResearchPollMultipleChoiceResponse) ModelHelper.a(null, this);
                graphQLVisitableModel.f12925f = graphQLResearchPollMultipleChoiceQuestion;
            }
        }
        if (m21430m() != null) {
            GraphQLResearchPollResponseRespondersConnection graphQLResearchPollResponseRespondersConnection = (GraphQLResearchPollResponseRespondersConnection) graphQLModelMutatingVisitor.b(m21430m());
            if (m21430m() != graphQLResearchPollResponseRespondersConnection) {
                graphQLVisitableModel = (GraphQLResearchPollMultipleChoiceResponse) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12926g = graphQLResearchPollResponseRespondersConnection;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLResearchPollMultipleChoiceResponse() {
        super(6);
    }

    public final int m21424a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m21427j());
        int b2 = flatBufferBuilder.b(m21428k());
        int a = ModelHelper.a(flatBufferBuilder, m21429l());
        int a2 = ModelHelper.a(flatBufferBuilder, m21430m());
        int b3 = flatBufferBuilder.b(m21431n());
        flatBufferBuilder.c(5);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, a);
        flatBufferBuilder.b(3, a2);
        flatBufferBuilder.b(4, b3);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLResearchPollMultipleChoiceResponse(Parcel parcel) {
        super(6);
        this.f12923d = parcel.readString();
        this.f12924e = parcel.readString();
        this.f12925f = (GraphQLResearchPollMultipleChoiceQuestion) parcel.readValue(GraphQLResearchPollMultipleChoiceQuestion.class.getClassLoader());
        this.f12926g = (GraphQLResearchPollResponseRespondersConnection) parcel.readValue(GraphQLResearchPollResponseRespondersConnection.class.getClassLoader());
        this.f12927h = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m21427j());
        parcel.writeString(m21428k());
        parcel.writeValue(m21429l());
        parcel.writeValue(m21430m());
        parcel.writeString(m21431n());
    }
}
