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
import com.facebook.graphql.deserializers.GraphQLPageStoriesYouMissedFeedUnitStoriesEdgeDeserializer;
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
/* compiled from: employee_location_history_voting */
public final class GraphQLPageStoriesYouMissedFeedUnitStoriesEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPageStoriesYouMissedFeedUnitStoriesEdge> CREATOR = new C04621();
    @Nullable
    public GraphQLStory f4758d;

    /* compiled from: employee_location_history_voting */
    final class C04621 implements Creator<GraphQLPageStoriesYouMissedFeedUnitStoriesEdge> {
        C04621() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPageStoriesYouMissedFeedUnitStoriesEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPageStoriesYouMissedFeedUnitStoriesEdge[i];
        }
    }

    /* compiled from: employee_location_history_voting */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLPageStoriesYouMissedFeedUnitStoriesEdge.class, new Deserializer());
        }

        public Object m9537a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLPageStoriesYouMissedFeedUnitStoriesEdgeDeserializer.m5531a(jsonParser, (short) 564);
            Object graphQLPageStoriesYouMissedFeedUnitStoriesEdge = new GraphQLPageStoriesYouMissedFeedUnitStoriesEdge();
            ((BaseModel) graphQLPageStoriesYouMissedFeedUnitStoriesEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLPageStoriesYouMissedFeedUnitStoriesEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLPageStoriesYouMissedFeedUnitStoriesEdge).a();
            }
            return graphQLPageStoriesYouMissedFeedUnitStoriesEdge;
        }
    }

    /* compiled from: employee_location_history_voting */
    public final class Serializer extends JsonSerializer<GraphQLPageStoriesYouMissedFeedUnitStoriesEdge> {
        public final void m9538a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLPageStoriesYouMissedFeedUnitStoriesEdge graphQLPageStoriesYouMissedFeedUnitStoriesEdge = (GraphQLPageStoriesYouMissedFeedUnitStoriesEdge) obj;
            GraphQLPageStoriesYouMissedFeedUnitStoriesEdgeDeserializer.m5532b(graphQLPageStoriesYouMissedFeedUnitStoriesEdge.w_(), graphQLPageStoriesYouMissedFeedUnitStoriesEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLPageStoriesYouMissedFeedUnitStoriesEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLPageStoriesYouMissedFeedUnitStoriesEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory m9540a() {
        this.f4758d = (GraphQLStory) super.a(this.f4758d, 0, GraphQLStory.class);
        return this.f4758d;
    }

    public final int jK_() {
        return -1281324584;
    }

    public final GraphQLVisitableModel m9541a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m9540a() != null) {
            GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m9540a());
            if (m9540a() != graphQLStory) {
                graphQLVisitableModel = (GraphQLPageStoriesYouMissedFeedUnitStoriesEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f4758d = graphQLStory;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPageStoriesYouMissedFeedUnitStoriesEdge() {
        super(2);
    }

    public final int m9539a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m9540a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPageStoriesYouMissedFeedUnitStoriesEdge(Parcel parcel) {
        super(2);
        this.f4758d = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m9540a());
    }
}
