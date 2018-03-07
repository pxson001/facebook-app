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
import com.facebook.graphql.deserializers.GraphQLResearchPollQuestionRespondersConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.instagram.common.json.annotation.JsonType;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: VIDEO_GRID */
public final class GraphQLResearchPollQuestionRespondersConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLResearchPollQuestionRespondersConnection> CREATOR = new C12091();
    public int f12928d;

    /* compiled from: VIDEO_GRID */
    final class C12091 implements Creator<GraphQLResearchPollQuestionRespondersConnection> {
        C12091() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLResearchPollQuestionRespondersConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLResearchPollQuestionRespondersConnection[i];
        }
    }

    /* compiled from: VIDEO_GRID */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLResearchPollQuestionRespondersConnection.class, new Deserializer());
        }

        public Object m21436a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLResearchPollQuestionRespondersConnectionDeserializer.m5822a(jsonParser, (short) 356);
            Object graphQLResearchPollQuestionRespondersConnection = new GraphQLResearchPollQuestionRespondersConnection();
            ((BaseModel) graphQLResearchPollQuestionRespondersConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLResearchPollQuestionRespondersConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLResearchPollQuestionRespondersConnection).a();
            }
            return graphQLResearchPollQuestionRespondersConnection;
        }
    }

    /* compiled from: VIDEO_GRID */
    public final class Serializer extends JsonSerializer<GraphQLResearchPollQuestionRespondersConnection> {
        public final void m21437a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLResearchPollQuestionRespondersConnection graphQLResearchPollQuestionRespondersConnection = (GraphQLResearchPollQuestionRespondersConnection) obj;
            GraphQLResearchPollQuestionRespondersConnectionDeserializer.m5823a(graphQLResearchPollQuestionRespondersConnection.w_(), graphQLResearchPollQuestionRespondersConnection.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLResearchPollQuestionRespondersConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLResearchPollQuestionRespondersConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final int m21438a() {
        a(0, 0);
        return this.f12928d;
    }

    public final int jK_() {
        return -1026106193;
    }

    public final GraphQLVisitableModel m21440a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLResearchPollQuestionRespondersConnection() {
        super(2);
    }

    public final void m21441a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f12928d = mutableFlatBuffer.a(i, 0, 0);
    }

    public final int m21439a(FlatBufferBuilder flatBufferBuilder) {
        h();
        flatBufferBuilder.c(1);
        flatBufferBuilder.a(0, m21438a(), 0);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLResearchPollQuestionRespondersConnection(Parcel parcel) {
        super(2);
        this.f12928d = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m21438a());
    }
}
