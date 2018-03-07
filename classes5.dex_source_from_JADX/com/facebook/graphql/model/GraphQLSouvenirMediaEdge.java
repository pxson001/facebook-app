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
import com.facebook.graphql.deserializers.GraphQLSouvenirMediaEdgeDeserializer;
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
/* compiled from: UploadJobHandlerManager- */
public final class GraphQLSouvenirMediaEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLSouvenirMediaEdge> CREATOR = new C12291();
    @Nullable
    public GraphQLSouvenirMediaElement f13034d;

    /* compiled from: UploadJobHandlerManager- */
    final class C12291 implements Creator<GraphQLSouvenirMediaEdge> {
        C12291() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSouvenirMediaEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSouvenirMediaEdge[i];
        }
    }

    /* compiled from: UploadJobHandlerManager- */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLSouvenirMediaEdge.class, new Deserializer());
        }

        public Object m21708a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLSouvenirMediaEdgeDeserializer.m5910a(jsonParser, (short) 228);
            Object graphQLSouvenirMediaEdge = new GraphQLSouvenirMediaEdge();
            ((BaseModel) graphQLSouvenirMediaEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLSouvenirMediaEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLSouvenirMediaEdge).a();
            }
            return graphQLSouvenirMediaEdge;
        }
    }

    /* compiled from: UploadJobHandlerManager- */
    public final class Serializer extends JsonSerializer<GraphQLSouvenirMediaEdge> {
        public final void m21709a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLSouvenirMediaEdge graphQLSouvenirMediaEdge = (GraphQLSouvenirMediaEdge) obj;
            GraphQLSouvenirMediaEdgeDeserializer.m5911b(graphQLSouvenirMediaEdge.w_(), graphQLSouvenirMediaEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLSouvenirMediaEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLSouvenirMediaEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLSouvenirMediaElement m21711a() {
        this.f13034d = (GraphQLSouvenirMediaElement) super.a(this.f13034d, 0, GraphQLSouvenirMediaElement.class);
        return this.f13034d;
    }

    public final int jK_() {
        return 1549589842;
    }

    public final GraphQLVisitableModel m21712a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21711a() != null) {
            GraphQLSouvenirMediaElement graphQLSouvenirMediaElement = (GraphQLSouvenirMediaElement) graphQLModelMutatingVisitor.b(m21711a());
            if (m21711a() != graphQLSouvenirMediaElement) {
                graphQLVisitableModel = (GraphQLSouvenirMediaEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f13034d = graphQLSouvenirMediaElement;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLSouvenirMediaEdge() {
        super(2);
    }

    public final int m21710a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21711a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLSouvenirMediaEdge(Parcel parcel) {
        super(2);
        this.f13034d = (GraphQLSouvenirMediaElement) parcel.readValue(GraphQLSouvenirMediaElement.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m21711a());
    }
}
