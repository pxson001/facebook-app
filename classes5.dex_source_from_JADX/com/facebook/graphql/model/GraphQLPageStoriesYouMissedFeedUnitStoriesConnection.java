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
import com.facebook.graphql.deserializers.GraphQLPageStoriesYouMissedFeedUnitStoriesConnectionDeserializer;
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
/* compiled from: emptySet */
public final class GraphQLPageStoriesYouMissedFeedUnitStoriesConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPageStoriesYouMissedFeedUnitStoriesConnection> CREATOR = new C04611();
    public List<GraphQLPageStoriesYouMissedFeedUnitStoriesEdge> f4756d;
    @Nullable
    public GraphQLPageInfo f4757e;

    /* compiled from: emptySet */
    final class C04611 implements Creator<GraphQLPageStoriesYouMissedFeedUnitStoriesConnection> {
        C04611() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPageStoriesYouMissedFeedUnitStoriesConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPageStoriesYouMissedFeedUnitStoriesConnection[i];
        }
    }

    /* compiled from: emptySet */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLPageStoriesYouMissedFeedUnitStoriesConnection.class, new Deserializer());
        }

        public Object m9527a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLPageStoriesYouMissedFeedUnitStoriesConnectionDeserializer.m5528a(jsonParser, (short) 563);
            Object graphQLPageStoriesYouMissedFeedUnitStoriesConnection = new GraphQLPageStoriesYouMissedFeedUnitStoriesConnection();
            ((BaseModel) graphQLPageStoriesYouMissedFeedUnitStoriesConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLPageStoriesYouMissedFeedUnitStoriesConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLPageStoriesYouMissedFeedUnitStoriesConnection).a();
            }
            return graphQLPageStoriesYouMissedFeedUnitStoriesConnection;
        }
    }

    /* compiled from: emptySet */
    public final class Serializer extends JsonSerializer<GraphQLPageStoriesYouMissedFeedUnitStoriesConnection> {
        public final void m9528a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLPageStoriesYouMissedFeedUnitStoriesConnection graphQLPageStoriesYouMissedFeedUnitStoriesConnection = (GraphQLPageStoriesYouMissedFeedUnitStoriesConnection) obj;
            GraphQLPageStoriesYouMissedFeedUnitStoriesConnectionDeserializer.m5529a(graphQLPageStoriesYouMissedFeedUnitStoriesConnection.w_(), graphQLPageStoriesYouMissedFeedUnitStoriesConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLPageStoriesYouMissedFeedUnitStoriesConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLPageStoriesYouMissedFeedUnitStoriesConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLPageStoriesYouMissedFeedUnitStoriesEdge> m9531a() {
        this.f4756d = super.a(this.f4756d, 0, GraphQLPageStoriesYouMissedFeedUnitStoriesEdge.class);
        return (ImmutableList) this.f4756d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m9532j() {
        this.f4757e = (GraphQLPageInfo) super.a(this.f4757e, 1, GraphQLPageInfo.class);
        return this.f4757e;
    }

    public final int jK_() {
        return 792255161;
    }

    public final GraphQLVisitableModel m9530a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        h();
        if (m9531a() != null) {
            Builder a = ModelHelper.a(m9531a(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLPageStoriesYouMissedFeedUnitStoriesConnection graphQLPageStoriesYouMissedFeedUnitStoriesConnection = (GraphQLPageStoriesYouMissedFeedUnitStoriesConnection) ModelHelper.a(null, this);
                graphQLPageStoriesYouMissedFeedUnitStoriesConnection.f4756d = a.b();
                graphQLVisitableModel = graphQLPageStoriesYouMissedFeedUnitStoriesConnection;
                if (m9532j() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m9532j());
                    if (m9532j() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLPageStoriesYouMissedFeedUnitStoriesConnection) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4757e = graphQLPageInfo;
                    }
                }
                i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m9532j() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m9532j());
            if (m9532j() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLPageStoriesYouMissedFeedUnitStoriesConnection) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4757e = graphQLPageInfo;
            }
        }
        i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLPageStoriesYouMissedFeedUnitStoriesConnection() {
        super(3);
    }

    public final int m9529a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m9531a());
        int a2 = ModelHelper.a(flatBufferBuilder, m9532j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPageStoriesYouMissedFeedUnitStoriesConnection(Parcel parcel) {
        super(3);
        this.f4756d = ImmutableListHelper.a(parcel.readArrayList(GraphQLPageStoriesYouMissedFeedUnitStoriesEdge.class.getClassLoader()));
        this.f4757e = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m9531a());
        parcel.writeValue(m9532j());
    }
}
