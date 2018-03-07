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
import com.facebook.graphql.deserializers.GraphQLEventHostsEdgeDeserializer;
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
/* compiled from: initial_card_prompt */
public final class GraphQLEventHostsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEventHostsEdge> CREATOR = new C03101();
    @Nullable
    public GraphQLActor f3633d;

    /* compiled from: initial_card_prompt */
    final class C03101 implements Creator<GraphQLEventHostsEdge> {
        C03101() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEventHostsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEventHostsEdge[i];
        }
    }

    /* compiled from: initial_card_prompt */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLEventHostsEdge.class, new Deserializer());
        }

        public Object m7193a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLEventHostsEdgeDeserializer.m4801a(jsonParser, (short) 304);
            Object graphQLEventHostsEdge = new GraphQLEventHostsEdge();
            ((BaseModel) graphQLEventHostsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLEventHostsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLEventHostsEdge).a();
            }
            return graphQLEventHostsEdge;
        }
    }

    /* compiled from: initial_card_prompt */
    public final class Serializer extends JsonSerializer<GraphQLEventHostsEdge> {
        public final void m7194a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLEventHostsEdge graphQLEventHostsEdge = (GraphQLEventHostsEdge) obj;
            GraphQLEventHostsEdgeDeserializer.m4802b(graphQLEventHostsEdge.w_(), graphQLEventHostsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLEventHostsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLEventHostsEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor m7196a() {
        this.f3633d = (GraphQLActor) super.a(this.f3633d, 0, GraphQLActor.class);
        return this.f3633d;
    }

    public final int jK_() {
        return -746288434;
    }

    public final GraphQLVisitableModel m7197a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7196a() != null) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.b(m7196a());
            if (m7196a() != graphQLActor) {
                graphQLVisitableModel = (GraphQLEventHostsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f3633d = graphQLActor;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEventHostsEdge() {
        super(2);
    }

    public final int m7195a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7196a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLEventHostsEdge(Parcel parcel) {
        super(2);
        this.f3633d = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m7196a());
    }
}
