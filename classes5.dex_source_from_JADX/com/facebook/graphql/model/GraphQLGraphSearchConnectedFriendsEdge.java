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
import com.facebook.graphql.deserializers.GraphQLGraphSearchConnectedFriendsEdgeDeserializer;
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
/* compiled from: getFBAccessToken */
public final class GraphQLGraphSearchConnectedFriendsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGraphSearchConnectedFriendsEdge> CREATOR = new C03721();
    @Nullable
    public GraphQLUser f4049d;

    /* compiled from: getFBAccessToken */
    final class C03721 implements Creator<GraphQLGraphSearchConnectedFriendsEdge> {
        C03721() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGraphSearchConnectedFriendsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGraphSearchConnectedFriendsEdge[i];
        }
    }

    /* compiled from: getFBAccessToken */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchConnectedFriendsEdge.class, new Deserializer());
        }

        public Object m8148a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGraphSearchConnectedFriendsEdgeDeserializer.m5078a(jsonParser, (short) 439);
            Object graphQLGraphSearchConnectedFriendsEdge = new GraphQLGraphSearchConnectedFriendsEdge();
            ((BaseModel) graphQLGraphSearchConnectedFriendsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGraphSearchConnectedFriendsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLGraphSearchConnectedFriendsEdge).a();
            }
            return graphQLGraphSearchConnectedFriendsEdge;
        }
    }

    /* compiled from: getFBAccessToken */
    public final class Serializer extends JsonSerializer<GraphQLGraphSearchConnectedFriendsEdge> {
        public final void m8149a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGraphSearchConnectedFriendsEdge graphQLGraphSearchConnectedFriendsEdge = (GraphQLGraphSearchConnectedFriendsEdge) obj;
            GraphQLGraphSearchConnectedFriendsEdgeDeserializer.m5079b(graphQLGraphSearchConnectedFriendsEdge.w_(), graphQLGraphSearchConnectedFriendsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGraphSearchConnectedFriendsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLGraphSearchConnectedFriendsEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLUser m8151a() {
        this.f4049d = (GraphQLUser) super.a(this.f4049d, 0, GraphQLUser.class);
        return this.f4049d;
    }

    public final int jK_() {
        return -1522965569;
    }

    public final GraphQLVisitableModel m8152a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8151a() != null) {
            GraphQLUser graphQLUser = (GraphQLUser) graphQLModelMutatingVisitor.b(m8151a());
            if (m8151a() != graphQLUser) {
                graphQLVisitableModel = (GraphQLGraphSearchConnectedFriendsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f4049d = graphQLUser;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGraphSearchConnectedFriendsEdge() {
        super(2);
    }

    public final int m8150a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8151a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGraphSearchConnectedFriendsEdge(Parcel parcel) {
        super(2);
        this.f4049d = (GraphQLUser) parcel.readValue(GraphQLUser.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m8151a());
    }
}
