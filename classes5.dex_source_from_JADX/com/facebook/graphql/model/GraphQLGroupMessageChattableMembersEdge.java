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
import com.facebook.graphql.deserializers.GraphQLGroupMessageChattableMembersEdgeDeserializer;
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
/* compiled from: friend_browser_nux */
public final class GraphQLGroupMessageChattableMembersEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGroupMessageChattableMembersEdge> CREATOR = new C04001();
    @Nullable
    public GraphQLActor f4207d;

    /* compiled from: friend_browser_nux */
    final class C04001 implements Creator<GraphQLGroupMessageChattableMembersEdge> {
        C04001() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGroupMessageChattableMembersEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGroupMessageChattableMembersEdge[i];
        }
    }

    /* compiled from: friend_browser_nux */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGroupMessageChattableMembersEdge.class, new Deserializer());
        }

        public Object m8477a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGroupMessageChattableMembersEdgeDeserializer.m5180a(jsonParser, (short) 419);
            Object graphQLGroupMessageChattableMembersEdge = new GraphQLGroupMessageChattableMembersEdge();
            ((BaseModel) graphQLGroupMessageChattableMembersEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGroupMessageChattableMembersEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLGroupMessageChattableMembersEdge).a();
            }
            return graphQLGroupMessageChattableMembersEdge;
        }
    }

    /* compiled from: friend_browser_nux */
    public final class Serializer extends JsonSerializer<GraphQLGroupMessageChattableMembersEdge> {
        public final void m8478a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGroupMessageChattableMembersEdge graphQLGroupMessageChattableMembersEdge = (GraphQLGroupMessageChattableMembersEdge) obj;
            GraphQLGroupMessageChattableMembersEdgeDeserializer.m5181b(graphQLGroupMessageChattableMembersEdge.w_(), graphQLGroupMessageChattableMembersEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGroupMessageChattableMembersEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLGroupMessageChattableMembersEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor m8480a() {
        this.f4207d = (GraphQLActor) super.a(this.f4207d, 0, GraphQLActor.class);
        return this.f4207d;
    }

    public final int jK_() {
        return -1382628888;
    }

    public final GraphQLVisitableModel m8481a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8480a() != null) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.b(m8480a());
            if (m8480a() != graphQLActor) {
                graphQLVisitableModel = (GraphQLGroupMessageChattableMembersEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f4207d = graphQLActor;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGroupMessageChattableMembersEdge() {
        super(2);
    }

    public final int m8479a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8480a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGroupMessageChattableMembersEdge(Parcel parcel) {
        super(2);
        this.f4207d = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m8480a());
    }
}
