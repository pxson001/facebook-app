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
import com.facebook.graphql.deserializers.GraphQLGroupTopStoriesFeedUnitStoriesConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: friendEventMaybes */
public final class GraphQLGroupTopStoriesFeedUnitStoriesConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGroupTopStoriesFeedUnitStoriesConnection> CREATOR = new C04021();
    public List<GraphQLGroupTopStoriesFeedUnitStoriesEdge> f4208d;
    @Nullable
    public GraphQLPageInfo f4209e;

    /* compiled from: friendEventMaybes */
    final class C04021 implements Creator<GraphQLGroupTopStoriesFeedUnitStoriesConnection> {
        C04021() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGroupTopStoriesFeedUnitStoriesConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGroupTopStoriesFeedUnitStoriesConnection[i];
        }
    }

    /* compiled from: friendEventMaybes */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGroupTopStoriesFeedUnitStoriesConnection.class, new Deserializer());
        }

        public Object m8498a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGroupTopStoriesFeedUnitStoriesConnectionDeserializer.m5189a(jsonParser, (short) 550);
            Object graphQLGroupTopStoriesFeedUnitStoriesConnection = new GraphQLGroupTopStoriesFeedUnitStoriesConnection();
            ((BaseModel) graphQLGroupTopStoriesFeedUnitStoriesConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGroupTopStoriesFeedUnitStoriesConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLGroupTopStoriesFeedUnitStoriesConnection).a();
            }
            return graphQLGroupTopStoriesFeedUnitStoriesConnection;
        }
    }

    /* compiled from: friendEventMaybes */
    public final class Serializer extends JsonSerializer<GraphQLGroupTopStoriesFeedUnitStoriesConnection> {
        public final void m8499a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGroupTopStoriesFeedUnitStoriesConnection graphQLGroupTopStoriesFeedUnitStoriesConnection = (GraphQLGroupTopStoriesFeedUnitStoriesConnection) obj;
            GraphQLGroupTopStoriesFeedUnitStoriesConnectionDeserializer.m5190a(graphQLGroupTopStoriesFeedUnitStoriesConnection.w_(), graphQLGroupTopStoriesFeedUnitStoriesConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGroupTopStoriesFeedUnitStoriesConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLGroupTopStoriesFeedUnitStoriesConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLGroupTopStoriesFeedUnitStoriesEdge> m8502a() {
        this.f4208d = super.a(this.f4208d, 0, GraphQLGroupTopStoriesFeedUnitStoriesEdge.class);
        return (ImmutableList) this.f4208d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m8503j() {
        this.f4209e = (GraphQLPageInfo) super.a(this.f4209e, 1, GraphQLPageInfo.class);
        return this.f4209e;
    }

    public final int jK_() {
        return 71620850;
    }

    public final GraphQLVisitableModel m8501a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        h();
        if (m8502a() != null) {
            Builder a = ModelHelper.a(m8502a(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLGroupTopStoriesFeedUnitStoriesConnection graphQLGroupTopStoriesFeedUnitStoriesConnection = (GraphQLGroupTopStoriesFeedUnitStoriesConnection) ModelHelper.a(null, this);
                graphQLGroupTopStoriesFeedUnitStoriesConnection.f4208d = a.b();
                graphQLVisitableModel = graphQLGroupTopStoriesFeedUnitStoriesConnection;
                if (m8503j() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m8503j());
                    if (m8503j() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLGroupTopStoriesFeedUnitStoriesConnection) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4209e = graphQLPageInfo;
                    }
                }
                i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m8503j() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m8503j());
            if (m8503j() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLGroupTopStoriesFeedUnitStoriesConnection) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4209e = graphQLPageInfo;
            }
        }
        i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLGroupTopStoriesFeedUnitStoriesConnection() {
        super(3);
    }

    public final int m8500a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8502a());
        int a2 = ModelHelper.a(flatBufferBuilder, m8503j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGroupTopStoriesFeedUnitStoriesConnection(Parcel parcel) {
        super(3);
        this.f4208d = ImmutableListHelper.a(parcel.readArrayList(GraphQLGroupTopStoriesFeedUnitStoriesEdge.class.getClassLoader()));
        this.f4209e = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m8502a());
        parcel.writeValue(m8503j());
    }
}
