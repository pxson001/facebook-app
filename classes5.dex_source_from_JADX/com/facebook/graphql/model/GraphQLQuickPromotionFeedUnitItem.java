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
import com.facebook.graphql.deserializers.GraphQLQuickPromotionFeedUnitItemDeserializer;
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
/* compiled from: VIEW_PAGE_MORE_MENU */
public final class GraphQLQuickPromotionFeedUnitItem extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLQuickPromotionFeedUnitItem> CREATOR = new C11951();
    @Nullable
    String f12860d;
    @Nullable
    GraphQLNegativeFeedbackActionsConnection f12861e;
    @Nullable
    GraphQLProfile f12862f;
    @Nullable
    GraphQLQuickPromotion f12863g;
    @Nullable
    String f12864h;

    /* compiled from: VIEW_PAGE_MORE_MENU */
    final class C11951 implements Creator<GraphQLQuickPromotionFeedUnitItem> {
        C11951() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLQuickPromotionFeedUnitItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLQuickPromotionFeedUnitItem[i];
        }
    }

    /* compiled from: VIEW_PAGE_MORE_MENU */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLQuickPromotionFeedUnitItem.class, new Deserializer());
        }

        public Object m21236a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLQuickPromotionFeedUnitItemDeserializer.m5756a(jsonParser, (short) 361);
            Object graphQLQuickPromotionFeedUnitItem = new GraphQLQuickPromotionFeedUnitItem();
            ((BaseModel) graphQLQuickPromotionFeedUnitItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLQuickPromotionFeedUnitItem instanceof Postprocessable) {
                return ((Postprocessable) graphQLQuickPromotionFeedUnitItem).a();
            }
            return graphQLQuickPromotionFeedUnitItem;
        }
    }

    /* compiled from: VIEW_PAGE_MORE_MENU */
    public final class Serializer extends JsonSerializer<GraphQLQuickPromotionFeedUnitItem> {
        public final void m21237a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLQuickPromotionFeedUnitItem graphQLQuickPromotionFeedUnitItem = (GraphQLQuickPromotionFeedUnitItem) obj;
            GraphQLQuickPromotionFeedUnitItemDeserializer.m5759b(graphQLQuickPromotionFeedUnitItem.w_(), graphQLQuickPromotionFeedUnitItem.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLQuickPromotionFeedUnitItem.class, new Serializer());
            FbSerializerProvider.a(GraphQLQuickPromotionFeedUnitItem.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m21240a() {
        this.f12860d = super.a(this.f12860d, 0);
        return this.f12860d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNegativeFeedbackActionsConnection m21241j() {
        this.f12861e = (GraphQLNegativeFeedbackActionsConnection) super.a(this.f12861e, 1, GraphQLNegativeFeedbackActionsConnection.class);
        return this.f12861e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile m21242k() {
        this.f12862f = (GraphQLProfile) super.a(this.f12862f, 2, GraphQLProfile.class);
        return this.f12862f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLQuickPromotion m21243l() {
        this.f12863g = (GraphQLQuickPromotion) super.a(this.f12863g, 3, GraphQLQuickPromotion.class);
        return this.f12863g;
    }

    @FieldOffset
    @Nullable
    public final String m21244m() {
        this.f12864h = super.a(this.f12864h, 4);
        return this.f12864h;
    }

    public final int jK_() {
        return -914009365;
    }

    public final GraphQLVisitableModel m21239a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21241j() != null) {
            GraphQLNegativeFeedbackActionsConnection graphQLNegativeFeedbackActionsConnection = (GraphQLNegativeFeedbackActionsConnection) graphQLModelMutatingVisitor.b(m21241j());
            if (m21241j() != graphQLNegativeFeedbackActionsConnection) {
                graphQLVisitableModel = (GraphQLQuickPromotionFeedUnitItem) ModelHelper.a(null, this);
                graphQLVisitableModel.f12861e = graphQLNegativeFeedbackActionsConnection;
            }
        }
        if (m21242k() != null) {
            GraphQLProfile graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.b(m21242k());
            if (m21242k() != graphQLProfile) {
                graphQLVisitableModel = (GraphQLQuickPromotionFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12862f = graphQLProfile;
            }
        }
        if (m21243l() != null) {
            GraphQLQuickPromotion graphQLQuickPromotion = (GraphQLQuickPromotion) graphQLModelMutatingVisitor.b(m21243l());
            if (m21243l() != graphQLQuickPromotion) {
                graphQLVisitableModel = (GraphQLQuickPromotionFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12863g = graphQLQuickPromotion;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLQuickPromotionFeedUnitItem() {
        super(6);
    }

    public final int m21238a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m21240a());
        int a = ModelHelper.a(flatBufferBuilder, m21241j());
        int a2 = ModelHelper.a(flatBufferBuilder, m21242k());
        int a3 = ModelHelper.a(flatBufferBuilder, m21243l());
        int b2 = flatBufferBuilder.b(m21244m());
        flatBufferBuilder.c(5);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLQuickPromotionFeedUnitItem(Parcel parcel) {
        super(6);
        this.f12860d = parcel.readString();
        this.f12861e = (GraphQLNegativeFeedbackActionsConnection) parcel.readValue(GraphQLNegativeFeedbackActionsConnection.class.getClassLoader());
        this.f12862f = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
        this.f12863g = (GraphQLQuickPromotion) parcel.readValue(GraphQLQuickPromotion.class.getClassLoader());
        this.f12864h = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m21240a());
        parcel.writeValue(m21241j());
        parcel.writeValue(m21242k());
        parcel.writeValue(m21243l());
        parcel.writeString(m21244m());
    }
}
