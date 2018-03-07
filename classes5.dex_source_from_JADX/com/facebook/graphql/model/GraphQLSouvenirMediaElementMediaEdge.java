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
import com.facebook.graphql.deserializers.GraphQLSouvenirMediaElementMediaEdgeDeserializer;
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
/* compiled from: Unsupported container type ( */
public final class GraphQLSouvenirMediaElementMediaEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLSouvenirMediaElementMediaEdge> CREATOR = new C12321();
    @Nullable
    public GraphQLMedia f13041d;

    /* compiled from: Unsupported container type ( */
    final class C12321 implements Creator<GraphQLSouvenirMediaElementMediaEdge> {
        C12321() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSouvenirMediaElementMediaEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSouvenirMediaElementMediaEdge[i];
        }
    }

    /* compiled from: Unsupported container type ( */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLSouvenirMediaElementMediaEdge.class, new Deserializer());
        }

        public Object m21738a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLSouvenirMediaElementMediaEdgeDeserializer.m5919a(jsonParser, (short) 230);
            Object graphQLSouvenirMediaElementMediaEdge = new GraphQLSouvenirMediaElementMediaEdge();
            ((BaseModel) graphQLSouvenirMediaElementMediaEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLSouvenirMediaElementMediaEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLSouvenirMediaElementMediaEdge).a();
            }
            return graphQLSouvenirMediaElementMediaEdge;
        }
    }

    /* compiled from: Unsupported container type ( */
    public final class Serializer extends JsonSerializer<GraphQLSouvenirMediaElementMediaEdge> {
        public final void m21739a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLSouvenirMediaElementMediaEdge graphQLSouvenirMediaElementMediaEdge = (GraphQLSouvenirMediaElementMediaEdge) obj;
            GraphQLSouvenirMediaElementMediaEdgeDeserializer.m5920b(graphQLSouvenirMediaElementMediaEdge.w_(), graphQLSouvenirMediaElementMediaEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLSouvenirMediaElementMediaEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLSouvenirMediaElementMediaEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLMedia m21741a() {
        this.f13041d = (GraphQLMedia) super.a(this.f13041d, 0, GraphQLMedia.class);
        return this.f13041d;
    }

    public final int jK_() {
        return 1607177274;
    }

    public final GraphQLVisitableModel m21742a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21741a() != null) {
            GraphQLMedia graphQLMedia = (GraphQLMedia) graphQLModelMutatingVisitor.b(m21741a());
            if (m21741a() != graphQLMedia) {
                graphQLVisitableModel = (GraphQLSouvenirMediaElementMediaEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f13041d = graphQLMedia;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLSouvenirMediaElementMediaEdge() {
        super(2);
    }

    public final int m21740a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21741a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLSouvenirMediaElementMediaEdge(Parcel parcel) {
        super(2);
        this.f13041d = (GraphQLMedia) parcel.readValue(GraphQLMedia.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m21741a());
    }
}
