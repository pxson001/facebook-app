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
import com.facebook.graphql.deserializers.GraphQLPlaceListItemDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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
/* compiled from: WEBSITE_URL */
public final class GraphQLPlaceListItem extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLPlaceListItem> CREATOR = new C11781();
    @Nullable
    String f12646d;
    @Nullable
    GraphQLPage f12647e;
    @Nullable
    String f12648f;
    @Nullable
    GraphQLPlaceListItemToRecommendingCommentsConnection f12649g;

    /* compiled from: WEBSITE_URL */
    final class C11781 implements Creator<GraphQLPlaceListItem> {
        C11781() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPlaceListItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPlaceListItem[i];
        }
    }

    /* compiled from: WEBSITE_URL */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        @Nullable
        public String f12642d;
        @Nullable
        public GraphQLPage f12643e;
        @Nullable
        public GraphQLPlaceListItemToRecommendingCommentsConnection f12644f;
        @Nullable
        public String f12645g;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }

        public static Builder m20849a(GraphQLPlaceListItem graphQLPlaceListItem) {
            Builder builder = new Builder();
            graphQLPlaceListItem.h();
            builder.f12642d = graphQLPlaceListItem.m20856j();
            builder.f12643e = graphQLPlaceListItem.m20857k();
            builder.f12644f = graphQLPlaceListItem.m20859m();
            builder.f12645g = graphQLPlaceListItem.m20858l();
            com.facebook.graphql.modelutil.BaseModel.Builder.a(builder, graphQLPlaceListItem);
            return builder;
        }

        public final GraphQLPlaceListItem m20850a() {
            return new GraphQLPlaceListItem(this);
        }
    }

    /* compiled from: WEBSITE_URL */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLPlaceListItem.class, new Deserializer());
        }

        public Object m20851a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLPlaceListItemDeserializer.m5645a(jsonParser, (short) 86);
            Object graphQLPlaceListItem = new GraphQLPlaceListItem();
            ((BaseModel) graphQLPlaceListItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLPlaceListItem instanceof Postprocessable) {
                return ((Postprocessable) graphQLPlaceListItem).a();
            }
            return graphQLPlaceListItem;
        }
    }

    /* compiled from: WEBSITE_URL */
    public final class Serializer extends JsonSerializer<GraphQLPlaceListItem> {
        public final void m20852a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLPlaceListItem graphQLPlaceListItem = (GraphQLPlaceListItem) obj;
            GraphQLPlaceListItemDeserializer.m5648b(graphQLPlaceListItem.w_(), graphQLPlaceListItem.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLPlaceListItem.class, new Serializer());
            FbSerializerProvider.a(GraphQLPlaceListItem.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m20856j() {
        this.f12646d = super.a(this.f12646d, 0);
        return this.f12646d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m20857k() {
        this.f12647e = (GraphQLPage) super.a(this.f12647e, 1, GraphQLPage.class);
        return this.f12647e;
    }

    @FieldOffset
    @Nullable
    public final String m20858l() {
        this.f12648f = super.a(this.f12648f, 2);
        return this.f12648f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPlaceListItemToRecommendingCommentsConnection m20859m() {
        this.f12649g = (GraphQLPlaceListItemToRecommendingCommentsConnection) super.a(this.f12649g, 3, GraphQLPlaceListItemToRecommendingCommentsConnection.class);
        return this.f12649g;
    }

    @Nullable
    public final String m20855a() {
        return m20856j();
    }

    public final int jK_() {
        return 2113705688;
    }

    public final GraphQLVisitableModel m20854a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m20857k() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.b(m20857k());
            if (m20857k() != graphQLPage) {
                graphQLVisitableModel = (GraphQLPlaceListItem) ModelHelper.a(null, this);
                graphQLVisitableModel.f12647e = graphQLPage;
            }
        }
        if (m20859m() != null) {
            GraphQLPlaceListItemToRecommendingCommentsConnection graphQLPlaceListItemToRecommendingCommentsConnection = (GraphQLPlaceListItemToRecommendingCommentsConnection) graphQLModelMutatingVisitor.b(m20859m());
            if (m20859m() != graphQLPlaceListItemToRecommendingCommentsConnection) {
                graphQLVisitableModel = (GraphQLPlaceListItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12649g = graphQLPlaceListItemToRecommendingCommentsConnection;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPlaceListItem() {
        super(5);
    }

    public final int m20853a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m20856j());
        int a = ModelHelper.a(flatBufferBuilder, m20857k());
        int b2 = flatBufferBuilder.b(m20858l());
        int a2 = ModelHelper.a(flatBufferBuilder, m20859m());
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, b2);
        flatBufferBuilder.b(3, a2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPlaceListItem(Parcel parcel) {
        super(5);
        this.f12646d = parcel.readString();
        this.f12647e = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f12649g = (GraphQLPlaceListItemToRecommendingCommentsConnection) parcel.readValue(GraphQLPlaceListItemToRecommendingCommentsConnection.class.getClassLoader());
        this.f12648f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m20856j());
        parcel.writeValue(m20857k());
        parcel.writeValue(m20859m());
        parcel.writeString(m20858l());
    }

    public GraphQLPlaceListItem(Builder builder) {
        super(5);
        this.b = builder.a;
        this.c = builder.b;
        this.f12646d = builder.f12642d;
        this.f12647e = builder.f12643e;
        this.f12649g = builder.f12644f;
        this.f12648f = builder.f12645g;
    }
}
