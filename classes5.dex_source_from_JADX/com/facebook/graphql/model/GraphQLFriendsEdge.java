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
import com.facebook.graphql.deserializers.GraphQLFriendsEdgeDeserializer;
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
/* compiled from: has_match_started */
public final class GraphQLFriendsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLFriendsEdge> CREATOR = new C03311();
    @Nullable
    public String f3794d;
    @Nullable
    public GraphQLUser f3795e;

    /* compiled from: has_match_started */
    final class C03311 implements Creator<GraphQLFriendsEdge> {
        C03311() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLFriendsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLFriendsEdge[i];
        }
    }

    /* compiled from: has_match_started */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLFriendsEdge.class, new Deserializer());
        }

        public Object m7611a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLFriendsEdgeDeserializer.m4949a(jsonParser, (short) 289);
            Object graphQLFriendsEdge = new GraphQLFriendsEdge();
            ((BaseModel) graphQLFriendsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLFriendsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLFriendsEdge).a();
            }
            return graphQLFriendsEdge;
        }
    }

    /* compiled from: has_match_started */
    public final class Serializer extends JsonSerializer<GraphQLFriendsEdge> {
        public final void m7612a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLFriendsEdge graphQLFriendsEdge = (GraphQLFriendsEdge) obj;
            GraphQLFriendsEdgeDeserializer.m4951b(graphQLFriendsEdge.w_(), graphQLFriendsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLFriendsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLFriendsEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m7615a() {
        this.f3794d = super.a(this.f3794d, 0);
        return this.f3794d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLUser m7616j() {
        this.f3795e = (GraphQLUser) super.a(this.f3795e, 1, GraphQLUser.class);
        return this.f3795e;
    }

    public final int jK_() {
        return -1221787438;
    }

    public final GraphQLVisitableModel m7614a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7616j() != null) {
            GraphQLUser graphQLUser = (GraphQLUser) graphQLModelMutatingVisitor.b(m7616j());
            if (m7616j() != graphQLUser) {
                graphQLVisitableModel = (GraphQLFriendsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f3795e = graphQLUser;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLFriendsEdge() {
        super(3);
    }

    public final int m7613a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m7615a());
        int a = ModelHelper.a(flatBufferBuilder, m7616j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLFriendsEdge(Parcel parcel) {
        super(3);
        this.f3794d = parcel.readString();
        this.f3795e = (GraphQLUser) parcel.readValue(GraphQLUser.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m7615a());
        parcel.writeValue(m7616j());
    }
}
