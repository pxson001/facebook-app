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
import com.facebook.graphql.deserializers.GraphQLGoodwillHappyBirthdayStoriesConnectionDeserializer;
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
/* compiled from: graph_search_chevron_incorrect_name */
public final class GraphQLGoodwillHappyBirthdayStoriesConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGoodwillHappyBirthdayStoriesConnection> CREATOR = new C03481();
    public List<GraphQLGoodwillHappyBirthdayStoriesEdge> f3921d;
    @Nullable
    public GraphQLPageInfo f3922e;

    /* compiled from: graph_search_chevron_incorrect_name */
    final class C03481 implements Creator<GraphQLGoodwillHappyBirthdayStoriesConnection> {
        C03481() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGoodwillHappyBirthdayStoriesConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGoodwillHappyBirthdayStoriesConnection[i];
        }
    }

    /* compiled from: graph_search_chevron_incorrect_name */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGoodwillHappyBirthdayStoriesConnection.class, new Deserializer());
        }

        public Object m7890a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGoodwillHappyBirthdayStoriesConnectionDeserializer.m5018a(jsonParser, (short) 396);
            Object graphQLGoodwillHappyBirthdayStoriesConnection = new GraphQLGoodwillHappyBirthdayStoriesConnection();
            ((BaseModel) graphQLGoodwillHappyBirthdayStoriesConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGoodwillHappyBirthdayStoriesConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLGoodwillHappyBirthdayStoriesConnection).a();
            }
            return graphQLGoodwillHappyBirthdayStoriesConnection;
        }
    }

    /* compiled from: graph_search_chevron_incorrect_name */
    public final class Serializer extends JsonSerializer<GraphQLGoodwillHappyBirthdayStoriesConnection> {
        public final void m7891a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGoodwillHappyBirthdayStoriesConnection graphQLGoodwillHappyBirthdayStoriesConnection = (GraphQLGoodwillHappyBirthdayStoriesConnection) obj;
            GraphQLGoodwillHappyBirthdayStoriesConnectionDeserializer.m5019a(graphQLGoodwillHappyBirthdayStoriesConnection.w_(), graphQLGoodwillHappyBirthdayStoriesConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGoodwillHappyBirthdayStoriesConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLGoodwillHappyBirthdayStoriesConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLGoodwillHappyBirthdayStoriesEdge> m7894a() {
        this.f3921d = super.a(this.f3921d, 0, GraphQLGoodwillHappyBirthdayStoriesEdge.class);
        return (ImmutableList) this.f3921d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m7895j() {
        this.f3922e = (GraphQLPageInfo) super.a(this.f3922e, 1, GraphQLPageInfo.class);
        return this.f3922e;
    }

    public final int jK_() {
        return 1541962147;
    }

    public final GraphQLVisitableModel m7893a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        h();
        if (m7894a() != null) {
            Builder a = ModelHelper.a(m7894a(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLGoodwillHappyBirthdayStoriesConnection graphQLGoodwillHappyBirthdayStoriesConnection = (GraphQLGoodwillHappyBirthdayStoriesConnection) ModelHelper.a(null, this);
                graphQLGoodwillHappyBirthdayStoriesConnection.f3921d = a.b();
                graphQLVisitableModel = graphQLGoodwillHappyBirthdayStoriesConnection;
                if (m7895j() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m7895j());
                    if (m7895j() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLGoodwillHappyBirthdayStoriesConnection) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f3922e = graphQLPageInfo;
                    }
                }
                i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m7895j() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m7895j());
            if (m7895j() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLGoodwillHappyBirthdayStoriesConnection) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3922e = graphQLPageInfo;
            }
        }
        i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLGoodwillHappyBirthdayStoriesConnection() {
        super(3);
    }

    public final int m7892a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7894a());
        int a2 = ModelHelper.a(flatBufferBuilder, m7895j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGoodwillHappyBirthdayStoriesConnection(Parcel parcel) {
        super(3);
        this.f3921d = ImmutableListHelper.a(parcel.readArrayList(GraphQLGoodwillHappyBirthdayStoriesEdge.class.getClassLoader()));
        this.f3922e = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m7894a());
        parcel.writeValue(m7895j());
    }
}
