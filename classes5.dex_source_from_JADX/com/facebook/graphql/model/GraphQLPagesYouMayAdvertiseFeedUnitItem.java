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
import com.facebook.graphql.deserializers.GraphQLPagesYouMayAdvertiseFeedUnitItemDeserializer;
import com.facebook.graphql.model.interfaces.HasTracking;
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
/* compiled from: eligible_for_education */
public final class GraphQLPagesYouMayAdvertiseFeedUnitItem extends BaseModel implements HasTracking, ItemListFeedUnitItem, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPagesYouMayAdvertiseFeedUnitItem> CREATOR = new C04651();
    @Nullable
    GraphQLStoryActionLink f4760d;
    @Nullable
    FeedUnit f4761e;
    @Nullable
    String f4762f;
    @Nullable
    GraphQLProfile f4763g;
    @Nullable
    String f4764h;

    /* compiled from: eligible_for_education */
    final class C04651 implements Creator<GraphQLPagesYouMayAdvertiseFeedUnitItem> {
        C04651() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPagesYouMayAdvertiseFeedUnitItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPagesYouMayAdvertiseFeedUnitItem[i];
        }
    }

    /* compiled from: eligible_for_education */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLPagesYouMayAdvertiseFeedUnitItem.class, new Deserializer());
        }

        public Object m9559a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLPagesYouMayAdvertiseFeedUnitItemDeserializer.m5540a(jsonParser, (short) 343);
            Object graphQLPagesYouMayAdvertiseFeedUnitItem = new GraphQLPagesYouMayAdvertiseFeedUnitItem();
            ((BaseModel) graphQLPagesYouMayAdvertiseFeedUnitItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLPagesYouMayAdvertiseFeedUnitItem instanceof Postprocessable) {
                return ((Postprocessable) graphQLPagesYouMayAdvertiseFeedUnitItem).a();
            }
            return graphQLPagesYouMayAdvertiseFeedUnitItem;
        }
    }

    /* compiled from: eligible_for_education */
    public final class Serializer extends JsonSerializer<GraphQLPagesYouMayAdvertiseFeedUnitItem> {
        public final void m9560a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLPagesYouMayAdvertiseFeedUnitItem graphQLPagesYouMayAdvertiseFeedUnitItem = (GraphQLPagesYouMayAdvertiseFeedUnitItem) obj;
            GraphQLPagesYouMayAdvertiseFeedUnitItemDeserializer.m5542b(graphQLPagesYouMayAdvertiseFeedUnitItem.w_(), graphQLPagesYouMayAdvertiseFeedUnitItem.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLPagesYouMayAdvertiseFeedUnitItem.class, new Serializer());
            FbSerializerProvider.a(GraphQLPagesYouMayAdvertiseFeedUnitItem.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLStoryActionLink m9562a() {
        this.f4760d = (GraphQLStoryActionLink) super.a(this.f4760d, 0, GraphQLStoryActionLink.class);
        return this.f4760d;
    }

    @FieldOffset
    @Nullable
    public final FeedUnit m9564j() {
        this.f4761e = (FeedUnit) super.a(this.f4761e, 1, VirtualFlattenableResolverImpl.a);
        return this.f4761e;
    }

    @FieldOffset
    @Nullable
    public final String m9566l() {
        this.f4762f = super.a(this.f4762f, 2);
        return this.f4762f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile m9567m() {
        this.f4763g = (GraphQLProfile) super.a(this.f4763g, 3, GraphQLProfile.class);
        return this.f4763g;
    }

    @FieldOffset
    @Nullable
    public final String m9565k() {
        this.f4764h = super.a(this.f4764h, 4);
        return this.f4764h;
    }

    public final int jK_() {
        return -1975737134;
    }

    public final GraphQLVisitableModel m9563a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m9562a() != null) {
            GraphQLStoryActionLink graphQLStoryActionLink = (GraphQLStoryActionLink) graphQLModelMutatingVisitor.b(m9562a());
            if (m9562a() != graphQLStoryActionLink) {
                graphQLVisitableModel = (GraphQLPagesYouMayAdvertiseFeedUnitItem) ModelHelper.a(null, this);
                graphQLVisitableModel.f4760d = graphQLStoryActionLink;
            }
        }
        if (m9564j() != null) {
            FeedUnit feedUnit = (FeedUnit) graphQLModelMutatingVisitor.b(m9564j());
            if (m9564j() != feedUnit) {
                graphQLVisitableModel = (GraphQLPagesYouMayAdvertiseFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4761e = feedUnit;
            }
        }
        if (m9567m() != null) {
            GraphQLProfile graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.b(m9567m());
            if (m9567m() != graphQLProfile) {
                graphQLVisitableModel = (GraphQLPagesYouMayAdvertiseFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4763g = graphQLProfile;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPagesYouMayAdvertiseFeedUnitItem() {
        super(6);
    }

    public final int m9561a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m9562a());
        int a2 = flatBufferBuilder.a(m9564j(), VirtualFlattenableResolverImpl.a);
        int b = flatBufferBuilder.b(m9566l());
        int a3 = ModelHelper.a(flatBufferBuilder, m9567m());
        int b2 = flatBufferBuilder.b(m9565k());
        flatBufferBuilder.c(5);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, b);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPagesYouMayAdvertiseFeedUnitItem(Parcel parcel) {
        super(6);
        this.f4760d = (GraphQLStoryActionLink) parcel.readValue(GraphQLStoryActionLink.class.getClassLoader());
        this.f4761e = (FeedUnit) parcel.readValue(FeedUnit.class.getClassLoader());
        this.f4762f = parcel.readString();
        this.f4763g = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
        this.f4764h = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m9562a());
        parcel.writeValue(m9564j());
        parcel.writeString(m9566l());
        parcel.writeValue(m9567m());
        parcel.writeString(m9565k());
    }
}
