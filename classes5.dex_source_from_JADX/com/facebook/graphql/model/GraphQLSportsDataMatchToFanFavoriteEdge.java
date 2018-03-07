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
import com.facebook.graphql.deserializers.GraphQLSportsDataMatchToFanFavoriteEdgeDeserializer;
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
/* compiled from: Unknown field out type =  */
public final class GraphQLSportsDataMatchToFanFavoriteEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLSportsDataMatchToFanFavoriteEdge> CREATOR = new C12361();
    @Nullable
    public GraphQLMediaQuestion f13074d;

    /* compiled from: Unknown field out type =  */
    final class C12361 implements Creator<GraphQLSportsDataMatchToFanFavoriteEdge> {
        C12361() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSportsDataMatchToFanFavoriteEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSportsDataMatchToFanFavoriteEdge[i];
        }
    }

    /* compiled from: Unknown field out type =  */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLSportsDataMatchToFanFavoriteEdge.class, new Deserializer());
        }

        public Object m21808a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLSportsDataMatchToFanFavoriteEdgeDeserializer.m5937a(jsonParser, (short) 391);
            Object graphQLSportsDataMatchToFanFavoriteEdge = new GraphQLSportsDataMatchToFanFavoriteEdge();
            ((BaseModel) graphQLSportsDataMatchToFanFavoriteEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLSportsDataMatchToFanFavoriteEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLSportsDataMatchToFanFavoriteEdge).a();
            }
            return graphQLSportsDataMatchToFanFavoriteEdge;
        }
    }

    /* compiled from: Unknown field out type =  */
    public final class Serializer extends JsonSerializer<GraphQLSportsDataMatchToFanFavoriteEdge> {
        public final void m21809a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLSportsDataMatchToFanFavoriteEdge graphQLSportsDataMatchToFanFavoriteEdge = (GraphQLSportsDataMatchToFanFavoriteEdge) obj;
            GraphQLSportsDataMatchToFanFavoriteEdgeDeserializer.m5938b(graphQLSportsDataMatchToFanFavoriteEdge.w_(), graphQLSportsDataMatchToFanFavoriteEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLSportsDataMatchToFanFavoriteEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLSportsDataMatchToFanFavoriteEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLMediaQuestion m21811a() {
        this.f13074d = (GraphQLMediaQuestion) super.a(this.f13074d, 0, GraphQLMediaQuestion.class);
        return this.f13074d;
    }

    public final int jK_() {
        return 1705737269;
    }

    public final GraphQLVisitableModel m21812a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21811a() != null) {
            GraphQLMediaQuestion graphQLMediaQuestion = (GraphQLMediaQuestion) graphQLModelMutatingVisitor.b(m21811a());
            if (m21811a() != graphQLMediaQuestion) {
                graphQLVisitableModel = (GraphQLSportsDataMatchToFanFavoriteEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f13074d = graphQLMediaQuestion;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLSportsDataMatchToFanFavoriteEdge() {
        super(2);
    }

    public final int m21810a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21811a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLSportsDataMatchToFanFavoriteEdge(Parcel parcel) {
        super(2);
        this.f13074d = (GraphQLMediaQuestion) parcel.readValue(GraphQLMediaQuestion.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m21811a());
    }
}
