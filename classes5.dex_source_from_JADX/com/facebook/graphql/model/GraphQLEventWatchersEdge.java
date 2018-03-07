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
import com.facebook.graphql.deserializers.GraphQLEventWatchersEdgeDeserializer;
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
import com.google.common.base.Preconditions;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: imageMedres */
public final class GraphQLEventWatchersEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEventWatchersEdge> CREATOR = new C03181();
    @Nullable
    public GraphQLActor f3684d;

    /* compiled from: imageMedres */
    final class C03181 implements Creator<GraphQLEventWatchersEdge> {
        C03181() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEventWatchersEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEventWatchersEdge[i];
        }
    }

    /* compiled from: imageMedres */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        @Nullable
        public GraphQLActor f3683d;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }
    }

    /* compiled from: imageMedres */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLEventWatchersEdge.class, new Deserializer());
        }

        public Object m7335a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLEventWatchersEdgeDeserializer.m4849a(jsonParser, (short) 306);
            Object graphQLEventWatchersEdge = new GraphQLEventWatchersEdge();
            ((BaseModel) graphQLEventWatchersEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLEventWatchersEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLEventWatchersEdge).a();
            }
            return graphQLEventWatchersEdge;
        }
    }

    /* compiled from: imageMedres */
    public final class Serializer extends JsonSerializer<GraphQLEventWatchersEdge> {
        public final void m7336a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLEventWatchersEdge graphQLEventWatchersEdge = (GraphQLEventWatchersEdge) obj;
            GraphQLEventWatchersEdgeDeserializer.m4851b(graphQLEventWatchersEdge.w_(), graphQLEventWatchersEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLEventWatchersEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLEventWatchersEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor m7338a() {
        this.f3684d = (GraphQLActor) super.a(this.f3684d, 0, GraphQLActor.class);
        return this.f3684d;
    }

    public final int jK_() {
        return 911490094;
    }

    public final GraphQLVisitableModel m7339a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7338a() != null) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.b(m7338a());
            if (m7338a() != graphQLActor) {
                graphQLVisitableModel = (GraphQLEventWatchersEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f3684d = graphQLActor;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEventWatchersEdge() {
        super(2);
    }

    public final int m7337a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7338a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLEventWatchersEdge(Parcel parcel) {
        super(2);
        this.f3684d = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m7338a());
    }

    public GraphQLEventWatchersEdge(Builder builder) {
        super(2);
        this.b = builder.a;
        this.c = builder.b;
        this.f3684d = builder.f3683d;
    }
}
