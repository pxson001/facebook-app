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
import com.facebook.graphql.deserializers.GraphQLGoodwillHappyBirthdayStoriesEdgeDeserializer;
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
/* compiled from: graph_editor_report_place_link */
public final class GraphQLGoodwillHappyBirthdayStoriesEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGoodwillHappyBirthdayStoriesEdge> CREATOR = new C03491();
    @Nullable
    public GraphQLStory f3923d;

    /* compiled from: graph_editor_report_place_link */
    final class C03491 implements Creator<GraphQLGoodwillHappyBirthdayStoriesEdge> {
        C03491() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGoodwillHappyBirthdayStoriesEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGoodwillHappyBirthdayStoriesEdge[i];
        }
    }

    /* compiled from: graph_editor_report_place_link */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGoodwillHappyBirthdayStoriesEdge.class, new Deserializer());
        }

        public Object m7900a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGoodwillHappyBirthdayStoriesEdgeDeserializer.m5021a(jsonParser, (short) 397);
            Object graphQLGoodwillHappyBirthdayStoriesEdge = new GraphQLGoodwillHappyBirthdayStoriesEdge();
            ((BaseModel) graphQLGoodwillHappyBirthdayStoriesEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGoodwillHappyBirthdayStoriesEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLGoodwillHappyBirthdayStoriesEdge).a();
            }
            return graphQLGoodwillHappyBirthdayStoriesEdge;
        }
    }

    /* compiled from: graph_editor_report_place_link */
    public final class Serializer extends JsonSerializer<GraphQLGoodwillHappyBirthdayStoriesEdge> {
        public final void m7901a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGoodwillHappyBirthdayStoriesEdge graphQLGoodwillHappyBirthdayStoriesEdge = (GraphQLGoodwillHappyBirthdayStoriesEdge) obj;
            GraphQLGoodwillHappyBirthdayStoriesEdgeDeserializer.m5022b(graphQLGoodwillHappyBirthdayStoriesEdge.w_(), graphQLGoodwillHappyBirthdayStoriesEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGoodwillHappyBirthdayStoriesEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLGoodwillHappyBirthdayStoriesEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory m7903a() {
        this.f3923d = (GraphQLStory) super.a(this.f3923d, 0, GraphQLStory.class);
        return this.f3923d;
    }

    public final int jK_() {
        return -2004606910;
    }

    public final GraphQLVisitableModel m7904a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7903a() != null) {
            GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m7903a());
            if (m7903a() != graphQLStory) {
                graphQLVisitableModel = (GraphQLGoodwillHappyBirthdayStoriesEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f3923d = graphQLStory;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGoodwillHappyBirthdayStoriesEdge() {
        super(2);
    }

    public final int m7902a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7903a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGoodwillHappyBirthdayStoriesEdge(Parcel parcel) {
        super(2);
        this.f3923d = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m7903a());
    }
}
