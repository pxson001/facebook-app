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
import com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackFriendListConnectionDeserializer;
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
/* compiled from: glyph */
public final class GraphQLGoodwillThrowbackFriendListConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGoodwillThrowbackFriendListConnection> CREATOR = new C03541();
    public List<GraphQLGoodwillThrowbackFriendListEdge> f3989d;

    /* compiled from: glyph */
    final class C03541 implements Creator<GraphQLGoodwillThrowbackFriendListConnection> {
        C03541() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGoodwillThrowbackFriendListConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGoodwillThrowbackFriendListConnection[i];
        }
    }

    /* compiled from: glyph */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackFriendListConnection.class, new Deserializer());
        }

        public Object m7994a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGoodwillThrowbackFriendListConnectionDeserializer.m5036a(jsonParser, (short) 399);
            Object graphQLGoodwillThrowbackFriendListConnection = new GraphQLGoodwillThrowbackFriendListConnection();
            ((BaseModel) graphQLGoodwillThrowbackFriendListConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGoodwillThrowbackFriendListConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLGoodwillThrowbackFriendListConnection).a();
            }
            return graphQLGoodwillThrowbackFriendListConnection;
        }
    }

    /* compiled from: glyph */
    public final class Serializer extends JsonSerializer<GraphQLGoodwillThrowbackFriendListConnection> {
        public final void m7995a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGoodwillThrowbackFriendListConnection graphQLGoodwillThrowbackFriendListConnection = (GraphQLGoodwillThrowbackFriendListConnection) obj;
            GraphQLGoodwillThrowbackFriendListConnectionDeserializer.m5037a(graphQLGoodwillThrowbackFriendListConnection.w_(), graphQLGoodwillThrowbackFriendListConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGoodwillThrowbackFriendListConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLGoodwillThrowbackFriendListConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLGoodwillThrowbackFriendListEdge> m7998a() {
        this.f3989d = super.a(this.f3989d, 0, GraphQLGoodwillThrowbackFriendListEdge.class);
        return (ImmutableList) this.f3989d;
    }

    public final int jK_() {
        return 1298374872;
    }

    public final GraphQLVisitableModel m7997a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7998a() != null) {
            Builder a = ModelHelper.a(m7998a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFriendListConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f3989d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGoodwillThrowbackFriendListConnection() {
        super(2);
    }

    public final int m7996a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7998a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGoodwillThrowbackFriendListConnection(Parcel parcel) {
        super(2);
        this.f3989d = ImmutableListHelper.a(parcel.readArrayList(GraphQLGoodwillThrowbackFriendListEdge.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m7998a());
    }
}
