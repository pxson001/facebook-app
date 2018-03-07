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
import com.facebook.graphql.deserializers.GraphQLHashtagFeedConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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
/* compiled from: format_version */
public final class GraphQLHashtagFeedConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLHashtagFeedConnection> CREATOR = new C04111();
    @Nullable
    public GraphQLPageInfo f4272d;

    /* compiled from: format_version */
    final class C04111 implements Creator<GraphQLHashtagFeedConnection> {
        C04111() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLHashtagFeedConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLHashtagFeedConnection[i];
        }
    }

    /* compiled from: format_version */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLHashtagFeedConnection.class, new Deserializer());
        }

        public Object m8594a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLHashtagFeedConnectionDeserializer.m5214a(jsonParser, (short) 330);
            Object graphQLHashtagFeedConnection = new GraphQLHashtagFeedConnection();
            ((BaseModel) graphQLHashtagFeedConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLHashtagFeedConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLHashtagFeedConnection).a();
            }
            return graphQLHashtagFeedConnection;
        }
    }

    /* compiled from: format_version */
    public final class Serializer extends JsonSerializer<GraphQLHashtagFeedConnection> {
        public final void m8595a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLHashtagFeedConnection graphQLHashtagFeedConnection = (GraphQLHashtagFeedConnection) obj;
            GraphQLHashtagFeedConnectionDeserializer.m5215a(graphQLHashtagFeedConnection.w_(), graphQLHashtagFeedConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLHashtagFeedConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLHashtagFeedConnection.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m8597a() {
        this.f4272d = (GraphQLPageInfo) super.a(this.f4272d, 0, GraphQLPageInfo.class);
        return this.f4272d;
    }

    public final int jK_() {
        return 302224872;
    }

    public final GraphQLVisitableModel m8598a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8597a() != null) {
            GraphQLPageInfo graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m8597a());
            if (m8597a() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLHashtagFeedConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f4272d = graphQLPageInfo;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLHashtagFeedConnection() {
        super(2);
    }

    public final int m8596a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8597a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLHashtagFeedConnection(Parcel parcel) {
        super(2);
        this.f4272d = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m8597a());
    }
}
