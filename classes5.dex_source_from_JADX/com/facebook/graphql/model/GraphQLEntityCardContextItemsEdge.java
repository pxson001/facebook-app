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
import com.facebook.graphql.deserializers.GraphQLEntityCardContextItemsEdgeDeserializer;
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
/* compiled from: interceptAcceptButtonLabel */
public final class GraphQLEntityCardContextItemsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEntityCardContextItemsEdge> CREATOR = new C03031();
    @Nullable
    public GraphQLEntityCardContextItem f3548d;

    /* compiled from: interceptAcceptButtonLabel */
    final class C03031 implements Creator<GraphQLEntityCardContextItemsEdge> {
        C03031() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEntityCardContextItemsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEntityCardContextItemsEdge[i];
        }
    }

    /* compiled from: interceptAcceptButtonLabel */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLEntityCardContextItemsEdge.class, new Deserializer());
        }

        public Object m7086a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLEntityCardContextItemsEdgeDeserializer.m4761a(jsonParser, (short) 293);
            Object graphQLEntityCardContextItemsEdge = new GraphQLEntityCardContextItemsEdge();
            ((BaseModel) graphQLEntityCardContextItemsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLEntityCardContextItemsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLEntityCardContextItemsEdge).a();
            }
            return graphQLEntityCardContextItemsEdge;
        }
    }

    /* compiled from: interceptAcceptButtonLabel */
    public final class Serializer extends JsonSerializer<GraphQLEntityCardContextItemsEdge> {
        public final void m7087a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLEntityCardContextItemsEdge graphQLEntityCardContextItemsEdge = (GraphQLEntityCardContextItemsEdge) obj;
            GraphQLEntityCardContextItemsEdgeDeserializer.m4762a(graphQLEntityCardContextItemsEdge.w_(), graphQLEntityCardContextItemsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLEntityCardContextItemsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLEntityCardContextItemsEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLEntityCardContextItem m7089a() {
        this.f3548d = (GraphQLEntityCardContextItem) super.a(this.f3548d, 0, GraphQLEntityCardContextItem.class);
        return this.f3548d;
    }

    public final int jK_() {
        return 182799489;
    }

    public final GraphQLVisitableModel m7090a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7089a() != null) {
            GraphQLEntityCardContextItem graphQLEntityCardContextItem = (GraphQLEntityCardContextItem) graphQLModelMutatingVisitor.b(m7089a());
            if (m7089a() != graphQLEntityCardContextItem) {
                graphQLVisitableModel = (GraphQLEntityCardContextItemsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f3548d = graphQLEntityCardContextItem;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEntityCardContextItemsEdge() {
        super(2);
    }

    public final int m7088a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7089a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLEntityCardContextItemsEdge(Parcel parcel) {
        super(2);
        this.f3548d = (GraphQLEntityCardContextItem) parcel.readValue(GraphQLEntityCardContextItem.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m7089a());
    }
}
