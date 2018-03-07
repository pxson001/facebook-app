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
import com.facebook.graphql.deserializers.GraphQLFriendsWhoVisitedEdgeDeserializer;
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
/* compiled from: gysjItems */
public final class GraphQLFriendsWhoVisitedEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLFriendsWhoVisitedEdge> CREATOR = new C03341();
    @Nullable
    public GraphQLUser f3798d;

    /* compiled from: gysjItems */
    final class C03341 implements Creator<GraphQLFriendsWhoVisitedEdge> {
        C03341() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLFriendsWhoVisitedEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLFriendsWhoVisitedEdge[i];
        }
    }

    /* compiled from: gysjItems */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLFriendsWhoVisitedEdge.class, new Deserializer());
        }

        public Object m7649a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLFriendsWhoVisitedEdgeDeserializer.m4966a(jsonParser, (short) 446);
            Object graphQLFriendsWhoVisitedEdge = new GraphQLFriendsWhoVisitedEdge();
            ((BaseModel) graphQLFriendsWhoVisitedEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLFriendsWhoVisitedEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLFriendsWhoVisitedEdge).a();
            }
            return graphQLFriendsWhoVisitedEdge;
        }
    }

    /* compiled from: gysjItems */
    public final class Serializer extends JsonSerializer<GraphQLFriendsWhoVisitedEdge> {
        public final void m7650a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLFriendsWhoVisitedEdge graphQLFriendsWhoVisitedEdge = (GraphQLFriendsWhoVisitedEdge) obj;
            GraphQLFriendsWhoVisitedEdgeDeserializer.m4968b(graphQLFriendsWhoVisitedEdge.w_(), graphQLFriendsWhoVisitedEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLFriendsWhoVisitedEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLFriendsWhoVisitedEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLUser m7652a() {
        this.f3798d = (GraphQLUser) super.a(this.f3798d, 0, GraphQLUser.class);
        return this.f3798d;
    }

    public final int jK_() {
        return -1193695682;
    }

    public final GraphQLVisitableModel m7653a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7652a() != null) {
            GraphQLUser graphQLUser = (GraphQLUser) graphQLModelMutatingVisitor.b(m7652a());
            if (m7652a() != graphQLUser) {
                graphQLVisitableModel = (GraphQLFriendsWhoVisitedEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f3798d = graphQLUser;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLFriendsWhoVisitedEdge() {
        super(2);
    }

    public final int m7651a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7652a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLFriendsWhoVisitedEdge(Parcel parcel) {
        super(2);
        this.f3798d = (GraphQLUser) parcel.readValue(GraphQLUser.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m7652a());
    }
}
