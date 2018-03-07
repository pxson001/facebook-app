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
import com.facebook.graphql.deserializers.GraphQLGraphSearchConnectedFriendsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: getGlobalWifiRunningTime */
public final class GraphQLGraphSearchConnectedFriendsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGraphSearchConnectedFriendsConnection> CREATOR = new C03711();
    public int f4047d;
    public List<GraphQLGraphSearchConnectedFriendsEdge> f4048e;

    /* compiled from: getGlobalWifiRunningTime */
    final class C03711 implements Creator<GraphQLGraphSearchConnectedFriendsConnection> {
        C03711() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGraphSearchConnectedFriendsConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGraphSearchConnectedFriendsConnection[i];
        }
    }

    /* compiled from: getGlobalWifiRunningTime */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchConnectedFriendsConnection.class, new Deserializer());
        }

        public Object m8137a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGraphSearchConnectedFriendsConnectionDeserializer.m5075a(jsonParser, (short) 438);
            Object graphQLGraphSearchConnectedFriendsConnection = new GraphQLGraphSearchConnectedFriendsConnection();
            ((BaseModel) graphQLGraphSearchConnectedFriendsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGraphSearchConnectedFriendsConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLGraphSearchConnectedFriendsConnection).a();
            }
            return graphQLGraphSearchConnectedFriendsConnection;
        }
    }

    /* compiled from: getGlobalWifiRunningTime */
    public final class Serializer extends JsonSerializer<GraphQLGraphSearchConnectedFriendsConnection> {
        public final void m8138a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGraphSearchConnectedFriendsConnection graphQLGraphSearchConnectedFriendsConnection = (GraphQLGraphSearchConnectedFriendsConnection) obj;
            GraphQLGraphSearchConnectedFriendsConnectionDeserializer.m5076a(graphQLGraphSearchConnectedFriendsConnection.w_(), graphQLGraphSearchConnectedFriendsConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGraphSearchConnectedFriendsConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLGraphSearchConnectedFriendsConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final int m8139a() {
        a(0, 0);
        return this.f4047d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLGraphSearchConnectedFriendsEdge> m8143j() {
        this.f4048e = super.a(this.f4048e, 1, GraphQLGraphSearchConnectedFriendsEdge.class);
        return (ImmutableList) this.f4048e;
    }

    public final int jK_() {
        return 1925868384;
    }

    public final GraphQLVisitableModel m8141a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8143j() != null) {
            Builder a = ModelHelper.a(m8143j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLGraphSearchConnectedFriendsConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f4048e = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGraphSearchConnectedFriendsConnection() {
        super(3);
    }

    public final void m8142a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f4047d = mutableFlatBuffer.a(i, 0, 0);
    }

    public final int m8140a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8143j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.a(0, m8139a(), 0);
        flatBufferBuilder.b(1, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGraphSearchConnectedFriendsConnection(Parcel parcel) {
        super(3);
        this.f4047d = parcel.readInt();
        this.f4048e = ImmutableListHelper.a(parcel.readArrayList(GraphQLGraphSearchConnectedFriendsEdge.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m8139a());
        parcel.writeList(m8143j());
    }
}
