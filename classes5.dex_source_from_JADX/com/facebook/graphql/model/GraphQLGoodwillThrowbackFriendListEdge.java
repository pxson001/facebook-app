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
import com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackFriendListEdgeDeserializer;
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
/* compiled from: global_share */
public final class GraphQLGoodwillThrowbackFriendListEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGoodwillThrowbackFriendListEdge> CREATOR = new C03551();
    @Nullable
    public GraphQLUser f3990d;
    @Nullable
    public GraphQLTextWithEntities f3991e;

    /* compiled from: global_share */
    final class C03551 implements Creator<GraphQLGoodwillThrowbackFriendListEdge> {
        C03551() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGoodwillThrowbackFriendListEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGoodwillThrowbackFriendListEdge[i];
        }
    }

    /* compiled from: global_share */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackFriendListEdge.class, new Deserializer());
        }

        public Object m8003a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGoodwillThrowbackFriendListEdgeDeserializer.m5039a(jsonParser, (short) 400);
            Object graphQLGoodwillThrowbackFriendListEdge = new GraphQLGoodwillThrowbackFriendListEdge();
            ((BaseModel) graphQLGoodwillThrowbackFriendListEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGoodwillThrowbackFriendListEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLGoodwillThrowbackFriendListEdge).a();
            }
            return graphQLGoodwillThrowbackFriendListEdge;
        }
    }

    /* compiled from: global_share */
    public final class Serializer extends JsonSerializer<GraphQLGoodwillThrowbackFriendListEdge> {
        public final void m8004a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGoodwillThrowbackFriendListEdge graphQLGoodwillThrowbackFriendListEdge = (GraphQLGoodwillThrowbackFriendListEdge) obj;
            GraphQLGoodwillThrowbackFriendListEdgeDeserializer.m5040b(graphQLGoodwillThrowbackFriendListEdge.w_(), graphQLGoodwillThrowbackFriendListEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGoodwillThrowbackFriendListEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLGoodwillThrowbackFriendListEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLUser m8006a() {
        this.f3990d = (GraphQLUser) super.a(this.f3990d, 0, GraphQLUser.class);
        return this.f3990d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m8008j() {
        this.f3991e = (GraphQLTextWithEntities) super.a(this.f3991e, 1, GraphQLTextWithEntities.class);
        return this.f3991e;
    }

    public final int jK_() {
        return -496626889;
    }

    public final GraphQLVisitableModel m8007a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8008j() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m8008j());
            if (m8008j() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFriendListEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f3991e = graphQLTextWithEntities;
            }
        }
        if (m8006a() != null) {
            GraphQLUser graphQLUser = (GraphQLUser) graphQLModelMutatingVisitor.b(m8006a());
            if (m8006a() != graphQLUser) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFriendListEdge) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3990d = graphQLUser;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGoodwillThrowbackFriendListEdge() {
        super(3);
    }

    public final int m8005a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8006a());
        int a2 = ModelHelper.a(flatBufferBuilder, m8008j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGoodwillThrowbackFriendListEdge(Parcel parcel) {
        super(3);
        this.f3991e = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3990d = (GraphQLUser) parcel.readValue(GraphQLUser.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m8008j());
        parcel.writeValue(m8006a());
    }
}
