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
import com.facebook.graphql.deserializers.GraphQLGroupTopStoriesFeedUnitStoriesEdgeDeserializer;
import com.facebook.graphql.model.PropertyBag.HasProperty;
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
/* compiled from: friendEventDeclines */
public final class GraphQLGroupTopStoriesFeedUnitStoriesEdge extends BaseModel implements HasProperty, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGroupTopStoriesFeedUnitStoriesEdge> CREATOR = new C04031();
    @Nullable
    public GraphQLStory f4210d;
    @Nullable
    private PropertyBag f4211e = null;

    /* compiled from: friendEventDeclines */
    final class C04031 implements Creator<GraphQLGroupTopStoriesFeedUnitStoriesEdge> {
        C04031() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGroupTopStoriesFeedUnitStoriesEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGroupTopStoriesFeedUnitStoriesEdge[i];
        }
    }

    /* compiled from: friendEventDeclines */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGroupTopStoriesFeedUnitStoriesEdge.class, new Deserializer());
        }

        public Object m8508a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGroupTopStoriesFeedUnitStoriesEdgeDeserializer.m5192a(jsonParser, (short) 551);
            Object graphQLGroupTopStoriesFeedUnitStoriesEdge = new GraphQLGroupTopStoriesFeedUnitStoriesEdge();
            ((BaseModel) graphQLGroupTopStoriesFeedUnitStoriesEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGroupTopStoriesFeedUnitStoriesEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLGroupTopStoriesFeedUnitStoriesEdge).a();
            }
            return graphQLGroupTopStoriesFeedUnitStoriesEdge;
        }
    }

    /* compiled from: friendEventDeclines */
    public final class Serializer extends JsonSerializer<GraphQLGroupTopStoriesFeedUnitStoriesEdge> {
        public final void m8509a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGroupTopStoriesFeedUnitStoriesEdge graphQLGroupTopStoriesFeedUnitStoriesEdge = (GraphQLGroupTopStoriesFeedUnitStoriesEdge) obj;
            GraphQLGroupTopStoriesFeedUnitStoriesEdgeDeserializer.m5193b(graphQLGroupTopStoriesFeedUnitStoriesEdge.w_(), graphQLGroupTopStoriesFeedUnitStoriesEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGroupTopStoriesFeedUnitStoriesEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLGroupTopStoriesFeedUnitStoriesEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory m8512j() {
        this.f4210d = (GraphQLStory) super.a(this.f4210d, 0, GraphQLStory.class);
        return this.f4210d;
    }

    public final int jK_() {
        return -936253743;
    }

    public final GraphQLVisitableModel m8511a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8512j() != null) {
            GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m8512j());
            if (m8512j() != graphQLStory) {
                graphQLVisitableModel = (GraphQLGroupTopStoriesFeedUnitStoriesEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f4210d = graphQLStory;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGroupTopStoriesFeedUnitStoriesEdge() {
        super(2);
    }

    public final int m8510a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8512j());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGroupTopStoriesFeedUnitStoriesEdge(Parcel parcel) {
        super(2);
        this.f4210d = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m8512j());
    }

    public final PropertyBag U_() {
        if (this.f4211e == null) {
            this.f4211e = new PropertyBag();
        }
        return this.f4211e;
    }
}
