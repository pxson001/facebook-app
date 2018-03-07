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
import com.facebook.graphql.deserializers.GraphQLWorkCommunityTrendingFeedUnitItemDeserializer;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.interfaces.ItemListFeedUnitItem;
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
/* compiled from: TaggableActivityIcon */
public final class GraphQLWorkCommunityTrendingFeedUnitItem extends BaseModel implements HasProperty, ItemListFeedUnitItem, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLWorkCommunityTrendingFeedUnitItem> CREATOR = new C12761();
    @Nullable
    GraphQLStory f13457d;
    @Nullable
    String f13458e;
    @Nullable
    private PropertyBag f13459f = null;

    /* compiled from: TaggableActivityIcon */
    final class C12761 implements Creator<GraphQLWorkCommunityTrendingFeedUnitItem> {
        C12761() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLWorkCommunityTrendingFeedUnitItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLWorkCommunityTrendingFeedUnitItem[i];
        }
    }

    /* compiled from: TaggableActivityIcon */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLWorkCommunityTrendingFeedUnitItem.class, new Deserializer());
        }

        public Object m22505a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLWorkCommunityTrendingFeedUnitItemDeserializer.m6212a(jsonParser, (short) 547);
            Object graphQLWorkCommunityTrendingFeedUnitItem = new GraphQLWorkCommunityTrendingFeedUnitItem();
            ((BaseModel) graphQLWorkCommunityTrendingFeedUnitItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLWorkCommunityTrendingFeedUnitItem instanceof Postprocessable) {
                return ((Postprocessable) graphQLWorkCommunityTrendingFeedUnitItem).a();
            }
            return graphQLWorkCommunityTrendingFeedUnitItem;
        }
    }

    /* compiled from: TaggableActivityIcon */
    public final class Serializer extends JsonSerializer<GraphQLWorkCommunityTrendingFeedUnitItem> {
        public final void m22506a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLWorkCommunityTrendingFeedUnitItem graphQLWorkCommunityTrendingFeedUnitItem = (GraphQLWorkCommunityTrendingFeedUnitItem) obj;
            GraphQLWorkCommunityTrendingFeedUnitItemDeserializer.m6214b(graphQLWorkCommunityTrendingFeedUnitItem.w_(), graphQLWorkCommunityTrendingFeedUnitItem.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLWorkCommunityTrendingFeedUnitItem.class, new Serializer());
            FbSerializerProvider.a(GraphQLWorkCommunityTrendingFeedUnitItem.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory m22509j() {
        this.f13457d = (GraphQLStory) super.a(this.f13457d, 0, GraphQLStory.class);
        return this.f13457d;
    }

    @FieldOffset
    @Nullable
    public final String m22510k() {
        this.f13458e = super.a(this.f13458e, 1);
        return this.f13458e;
    }

    public final int jK_() {
        return -1089630190;
    }

    public final GraphQLVisitableModel m22508a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m22509j() != null) {
            GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m22509j());
            if (m22509j() != graphQLStory) {
                graphQLVisitableModel = (GraphQLWorkCommunityTrendingFeedUnitItem) ModelHelper.a(null, this);
                graphQLVisitableModel.f13457d = graphQLStory;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLWorkCommunityTrendingFeedUnitItem() {
        super(3);
    }

    public final int m22507a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m22509j());
        int b = flatBufferBuilder.b(m22510k());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLWorkCommunityTrendingFeedUnitItem(Parcel parcel) {
        super(3);
        this.f13457d = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
        this.f13458e = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m22509j());
        parcel.writeString(m22510k());
    }

    public final PropertyBag U_() {
        if (this.f13459f == null) {
            this.f13459f = new PropertyBag();
        }
        return this.f13459f;
    }
}
