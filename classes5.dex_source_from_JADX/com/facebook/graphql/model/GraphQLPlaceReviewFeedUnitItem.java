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
import com.facebook.graphql.deserializers.GraphQLPlaceReviewFeedUnitItemDeserializer;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.interfaces.CachedFeedTrackable;
import com.facebook.graphql.model.interfaces.HasTracking;
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
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: WATCH_VIDEO */
public final class GraphQLPlaceReviewFeedUnitItem extends BaseModel implements HasProperty, CachedFeedTrackable, HasTracking, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPlaceReviewFeedUnitItem> CREATOR = new C11811();
    @Nullable
    String f12661d;
    @Nullable
    GraphQLPage f12662e;
    @Nullable
    GraphQLTextWithEntities f12663f;
    @Nullable
    GraphQLImage f12664g;
    @Nullable
    String f12665h;
    @Nullable
    private PropertyBag f12666i = null;

    /* compiled from: WATCH_VIDEO */
    final class C11811 implements Creator<GraphQLPlaceReviewFeedUnitItem> {
        C11811() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPlaceReviewFeedUnitItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPlaceReviewFeedUnitItem[i];
        }
    }

    /* compiled from: WATCH_VIDEO */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLPlaceReviewFeedUnitItem.class, new Deserializer());
        }

        public Object m20898a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLPlaceReviewFeedUnitItemDeserializer.m5667a(jsonParser, (short) 371);
            Object graphQLPlaceReviewFeedUnitItem = new GraphQLPlaceReviewFeedUnitItem();
            ((BaseModel) graphQLPlaceReviewFeedUnitItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLPlaceReviewFeedUnitItem instanceof Postprocessable) {
                return ((Postprocessable) graphQLPlaceReviewFeedUnitItem).a();
            }
            return graphQLPlaceReviewFeedUnitItem;
        }
    }

    /* compiled from: WATCH_VIDEO */
    public final class Serializer extends JsonSerializer<GraphQLPlaceReviewFeedUnitItem> {
        public final void m20899a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLPlaceReviewFeedUnitItem graphQLPlaceReviewFeedUnitItem = (GraphQLPlaceReviewFeedUnitItem) obj;
            GraphQLPlaceReviewFeedUnitItemDeserializer.m5669b(graphQLPlaceReviewFeedUnitItem.w_(), graphQLPlaceReviewFeedUnitItem.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLPlaceReviewFeedUnitItem.class, new Serializer());
            FbSerializerProvider.a(GraphQLPlaceReviewFeedUnitItem.class, new Serializer());
        }
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.a(this);
    }

    @FieldOffset
    @Nullable
    public final String m20902j() {
        this.f12661d = super.a(this.f12661d, 0);
        return this.f12661d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m20904l() {
        this.f12662e = (GraphQLPage) super.a(this.f12662e, 1, GraphQLPage.class);
        return this.f12662e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m20905m() {
        this.f12663f = (GraphQLTextWithEntities) super.a(this.f12663f, 2, GraphQLTextWithEntities.class);
        return this.f12663f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m20906n() {
        this.f12664g = (GraphQLImage) super.a(this.f12664g, 3, GraphQLImage.class);
        return this.f12664g;
    }

    @FieldOffset
    @Nullable
    public final String m20903k() {
        this.f12665h = super.a(this.f12665h, 4);
        return this.f12665h;
    }

    public final int jK_() {
        return 502731572;
    }

    public final GraphQLVisitableModel m20901a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m20904l() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.b(m20904l());
            if (m20904l() != graphQLPage) {
                graphQLVisitableModel = (GraphQLPlaceReviewFeedUnitItem) ModelHelper.a(null, this);
                graphQLVisitableModel.f12662e = graphQLPage;
            }
        }
        if (m20905m() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m20905m());
            if (m20905m() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLPlaceReviewFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12663f = graphQLTextWithEntities;
            }
        }
        if (m20906n() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m20906n());
            if (m20906n() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPlaceReviewFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12664g = graphQLImage;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPlaceReviewFeedUnitItem() {
        super(6);
    }

    public final int m20900a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m20902j());
        int a = ModelHelper.a(flatBufferBuilder, m20904l());
        int a2 = ModelHelper.a(flatBufferBuilder, m20905m());
        int a3 = ModelHelper.a(flatBufferBuilder, m20906n());
        int b2 = flatBufferBuilder.b(m20903k());
        flatBufferBuilder.c(5);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPlaceReviewFeedUnitItem(Parcel parcel) {
        super(6);
        this.f12661d = parcel.readString();
        this.f12662e = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f12663f = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f12664g = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f12665h = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m20902j());
        parcel.writeValue(m20904l());
        parcel.writeValue(m20905m());
        parcel.writeValue(m20906n());
        parcel.writeString(m20903k());
    }

    public final PropertyBag U_() {
        if (this.f12666i == null) {
            this.f12666i = new PropertyBag();
        }
        return this.f12666i;
    }
}
