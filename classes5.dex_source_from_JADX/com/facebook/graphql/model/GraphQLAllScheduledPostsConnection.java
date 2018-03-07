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
import com.facebook.graphql.deserializers.GraphQLAllScheduledPostsConnectionDeserializer;
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
/* compiled from: jctoolts.spsc.max.lookahead.step */
public final class GraphQLAllScheduledPostsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLAllScheduledPostsConnection> CREATOR = new C02641();
    public int f3345d;

    /* compiled from: jctoolts.spsc.max.lookahead.step */
    final class C02641 implements Creator<GraphQLAllScheduledPostsConnection> {
        C02641() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLAllScheduledPostsConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLAllScheduledPostsConnection[i];
        }
    }

    /* compiled from: jctoolts.spsc.max.lookahead.step */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLAllScheduledPostsConnection.class, new Deserializer());
        }

        public Object m6520a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLAllScheduledPostsConnectionDeserializer.m4556a(jsonParser, (short) 451);
            Object graphQLAllScheduledPostsConnection = new GraphQLAllScheduledPostsConnection();
            ((BaseModel) graphQLAllScheduledPostsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLAllScheduledPostsConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLAllScheduledPostsConnection).a();
            }
            return graphQLAllScheduledPostsConnection;
        }
    }

    /* compiled from: jctoolts.spsc.max.lookahead.step */
    public final class Serializer extends JsonSerializer<GraphQLAllScheduledPostsConnection> {
        public final void m6521a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLAllScheduledPostsConnection graphQLAllScheduledPostsConnection = (GraphQLAllScheduledPostsConnection) obj;
            GraphQLAllScheduledPostsConnectionDeserializer.m4557a(graphQLAllScheduledPostsConnection.w_(), graphQLAllScheduledPostsConnection.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLAllScheduledPostsConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLAllScheduledPostsConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final int m6522a() {
        a(0, 0);
        return this.f3345d;
    }

    public final int jK_() {
        return 1175143749;
    }

    public final GraphQLVisitableModel m6524a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLAllScheduledPostsConnection() {
        super(2);
    }

    public final void m6525a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3345d = mutableFlatBuffer.a(i, 0, 0);
    }

    public final int m6523a(FlatBufferBuilder flatBufferBuilder) {
        h();
        flatBufferBuilder.c(1);
        flatBufferBuilder.a(0, m6522a(), 0);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLAllScheduledPostsConnection(Parcel parcel) {
        super(2);
        this.f3345d = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m6522a());
    }
}
