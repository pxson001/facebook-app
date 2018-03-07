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
import com.facebook.graphql.deserializers.GraphQLPlaceListItemToRecommendingCommentsConnectionDeserializer;
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
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: WEBSITE_BLOGS */
public final class GraphQLPlaceListItemToRecommendingCommentsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPlaceListItemToRecommendingCommentsConnection> CREATOR = new C11791();
    public List<GraphQLComment> f12651d;

    /* compiled from: WEBSITE_BLOGS */
    final class C11791 implements Creator<GraphQLPlaceListItemToRecommendingCommentsConnection> {
        C11791() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPlaceListItemToRecommendingCommentsConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPlaceListItemToRecommendingCommentsConnection[i];
        }
    }

    /* compiled from: WEBSITE_BLOGS */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        public ImmutableList<GraphQLComment> f12650d;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }

        public final GraphQLPlaceListItemToRecommendingCommentsConnection m20862a() {
            return new GraphQLPlaceListItemToRecommendingCommentsConnection(this);
        }
    }

    /* compiled from: WEBSITE_BLOGS */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLPlaceListItemToRecommendingCommentsConnection.class, new Deserializer());
        }

        public Object m20863a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLPlaceListItemToRecommendingCommentsConnectionDeserializer.m5650a(jsonParser, (short) 566);
            Object graphQLPlaceListItemToRecommendingCommentsConnection = new GraphQLPlaceListItemToRecommendingCommentsConnection();
            ((BaseModel) graphQLPlaceListItemToRecommendingCommentsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLPlaceListItemToRecommendingCommentsConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLPlaceListItemToRecommendingCommentsConnection).a();
            }
            return graphQLPlaceListItemToRecommendingCommentsConnection;
        }
    }

    /* compiled from: WEBSITE_BLOGS */
    public final class Serializer extends JsonSerializer<GraphQLPlaceListItemToRecommendingCommentsConnection> {
        public final void m20864a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLPlaceListItemToRecommendingCommentsConnection graphQLPlaceListItemToRecommendingCommentsConnection = (GraphQLPlaceListItemToRecommendingCommentsConnection) obj;
            GraphQLPlaceListItemToRecommendingCommentsConnectionDeserializer.m5651a(graphQLPlaceListItemToRecommendingCommentsConnection.w_(), graphQLPlaceListItemToRecommendingCommentsConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLPlaceListItemToRecommendingCommentsConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLPlaceListItemToRecommendingCommentsConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLComment> m20867a() {
        this.f12651d = super.a(this.f12651d, 0, GraphQLComment.class);
        return (ImmutableList) this.f12651d;
    }

    public final int jK_() {
        return -1143816053;
    }

    public final GraphQLVisitableModel m20866a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m20867a() != null) {
            com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m20867a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLPlaceListItemToRecommendingCommentsConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f12651d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPlaceListItemToRecommendingCommentsConnection() {
        super(2);
    }

    public final int m20865a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m20867a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPlaceListItemToRecommendingCommentsConnection(Parcel parcel) {
        super(2);
        this.f12651d = ImmutableListHelper.a(parcel.readArrayList(GraphQLComment.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m20867a());
    }

    public GraphQLPlaceListItemToRecommendingCommentsConnection(Builder builder) {
        super(2);
        this.b = builder.a;
        this.c = builder.b;
        this.f12651d = builder.f12650d;
    }
}
