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
import com.facebook.graphql.deserializers.GraphQLVideoTimestampedCommentsEdgeDeserializer;
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
/* compiled from: TestHash */
public final class GraphQLVideoTimestampedCommentsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLVideoTimestampedCommentsEdge> CREATOR = new C12731();
    @Nullable
    public GraphQLComment f13454d;

    /* compiled from: TestHash */
    final class C12731 implements Creator<GraphQLVideoTimestampedCommentsEdge> {
        C12731() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLVideoTimestampedCommentsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLVideoTimestampedCommentsEdge[i];
        }
    }

    /* compiled from: TestHash */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLVideoTimestampedCommentsEdge.class, new Deserializer());
        }

        public Object m22474a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLVideoTimestampedCommentsEdgeDeserializer.m6197a(jsonParser, (short) 520);
            Object graphQLVideoTimestampedCommentsEdge = new GraphQLVideoTimestampedCommentsEdge();
            ((BaseModel) graphQLVideoTimestampedCommentsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLVideoTimestampedCommentsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLVideoTimestampedCommentsEdge).a();
            }
            return graphQLVideoTimestampedCommentsEdge;
        }
    }

    /* compiled from: TestHash */
    public final class Serializer extends JsonSerializer<GraphQLVideoTimestampedCommentsEdge> {
        public final void m22475a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLVideoTimestampedCommentsEdge graphQLVideoTimestampedCommentsEdge = (GraphQLVideoTimestampedCommentsEdge) obj;
            GraphQLVideoTimestampedCommentsEdgeDeserializer.m6198b(graphQLVideoTimestampedCommentsEdge.w_(), graphQLVideoTimestampedCommentsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLVideoTimestampedCommentsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLVideoTimestampedCommentsEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLComment m22477a() {
        this.f13454d = (GraphQLComment) super.a(this.f13454d, 0, GraphQLComment.class);
        return this.f13454d;
    }

    public final int jK_() {
        return -1254582325;
    }

    public final GraphQLVisitableModel m22478a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m22477a() != null) {
            GraphQLComment graphQLComment = (GraphQLComment) graphQLModelMutatingVisitor.b(m22477a());
            if (m22477a() != graphQLComment) {
                graphQLVisitableModel = (GraphQLVideoTimestampedCommentsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f13454d = graphQLComment;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLVideoTimestampedCommentsEdge() {
        super(2);
    }

    public final int m22476a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m22477a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLVideoTimestampedCommentsEdge(Parcel parcel) {
        super(2);
        this.f13454d = (GraphQLComment) parcel.readValue(GraphQLComment.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m22477a());
    }
}
