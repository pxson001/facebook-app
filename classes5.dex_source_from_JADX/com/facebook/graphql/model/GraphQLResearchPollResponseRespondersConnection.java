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
import com.facebook.graphql.deserializers.GraphQLResearchPollResponseRespondersConnectionDeserializer;
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
/* compiled from: VIDEO_CHANNEL_SQUARE */
public final class GraphQLResearchPollResponseRespondersConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLResearchPollResponseRespondersConnection> CREATOR = new C12111();
    public int f12930d;

    /* compiled from: VIDEO_CHANNEL_SQUARE */
    final class C12111 implements Creator<GraphQLResearchPollResponseRespondersConnection> {
        C12111() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLResearchPollResponseRespondersConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLResearchPollResponseRespondersConnection[i];
        }
    }

    /* compiled from: VIDEO_CHANNEL_SQUARE */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLResearchPollResponseRespondersConnection.class, new Deserializer());
        }

        public Object m21455a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLResearchPollResponseRespondersConnectionDeserializer.m5828a(jsonParser, (short) 358);
            Object graphQLResearchPollResponseRespondersConnection = new GraphQLResearchPollResponseRespondersConnection();
            ((BaseModel) graphQLResearchPollResponseRespondersConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLResearchPollResponseRespondersConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLResearchPollResponseRespondersConnection).a();
            }
            return graphQLResearchPollResponseRespondersConnection;
        }
    }

    /* compiled from: VIDEO_CHANNEL_SQUARE */
    public final class Serializer extends JsonSerializer<GraphQLResearchPollResponseRespondersConnection> {
        public final void m21456a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLResearchPollResponseRespondersConnection graphQLResearchPollResponseRespondersConnection = (GraphQLResearchPollResponseRespondersConnection) obj;
            GraphQLResearchPollResponseRespondersConnectionDeserializer.m5829a(graphQLResearchPollResponseRespondersConnection.w_(), graphQLResearchPollResponseRespondersConnection.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLResearchPollResponseRespondersConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLResearchPollResponseRespondersConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final int m21457a() {
        a(0, 0);
        return this.f12930d;
    }

    public final int jK_() {
        return -611386998;
    }

    public final GraphQLVisitableModel m21459a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLResearchPollResponseRespondersConnection() {
        super(2);
    }

    public final void m21460a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f12930d = mutableFlatBuffer.a(i, 0, 0);
    }

    public final int m21458a(FlatBufferBuilder flatBufferBuilder) {
        h();
        flatBufferBuilder.c(1);
        flatBufferBuilder.a(0, m21457a(), 0);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLResearchPollResponseRespondersConnection(Parcel parcel) {
        super(2);
        this.f12930d = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m21457a());
    }
}
