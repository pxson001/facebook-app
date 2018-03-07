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
import com.facebook.graphql.deserializers.GraphQLPagesYouMayLikeFeedUnitItemDeserializer;
import com.facebook.graphql.model.PropertyBag.HasProperty;
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
/* compiled from: WRITE_UPDATE_FILE_NOT_FOUND */
public final class GraphQLPagesYouMayLikeFeedUnitItem extends BaseModel implements HasCachedSponsoredImpression, HasSponsoredData, HasProperty, SuggestedPageUnitItem, HasTracking, ItemListFeedUnitItem, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPagesYouMayLikeFeedUnitItem> CREATOR = new C11411();
    @Nullable
    GraphQLPagesYouMayLikeFeedUnitItemContentConnection f12399d;
    @Nullable
    String f12400e;
    @Nullable
    GraphQLTextWithEntities f12401f;
    @Nullable
    GraphQLPage f12402g;
    @Nullable
    GraphQLTextWithEntities f12403h;
    @Nullable
    GraphQLSponsoredData f12404i;
    @Nullable
    String f12405j;
    @Nullable
    private PropertyBag f12406k = null;

    /* compiled from: WRITE_UPDATE_FILE_NOT_FOUND */
    final class C11411 implements Creator<GraphQLPagesYouMayLikeFeedUnitItem> {
        C11411() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPagesYouMayLikeFeedUnitItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPagesYouMayLikeFeedUnitItem[i];
        }
    }

    /* compiled from: WRITE_UPDATE_FILE_NOT_FOUND */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLPagesYouMayLikeFeedUnitItem.class, new Deserializer());
        }

        public Object m20550a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLPagesYouMayLikeFeedUnitItemDeserializer.m5550a(jsonParser, (short) 318);
            Object graphQLPagesYouMayLikeFeedUnitItem = new GraphQLPagesYouMayLikeFeedUnitItem();
            ((BaseModel) graphQLPagesYouMayLikeFeedUnitItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLPagesYouMayLikeFeedUnitItem instanceof Postprocessable) {
                return ((Postprocessable) graphQLPagesYouMayLikeFeedUnitItem).a();
            }
            return graphQLPagesYouMayLikeFeedUnitItem;
        }
    }

    /* compiled from: WRITE_UPDATE_FILE_NOT_FOUND */
    public final class Serializer extends JsonSerializer<GraphQLPagesYouMayLikeFeedUnitItem> {
        public final void m20551a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLPagesYouMayLikeFeedUnitItem graphQLPagesYouMayLikeFeedUnitItem = (GraphQLPagesYouMayLikeFeedUnitItem) obj;
            GraphQLPagesYouMayLikeFeedUnitItemDeserializer.m5553b(graphQLPagesYouMayLikeFeedUnitItem.w_(), graphQLPagesYouMayLikeFeedUnitItem.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLPagesYouMayLikeFeedUnitItem.class, new Serializer());
            FbSerializerProvider.a(GraphQLPagesYouMayLikeFeedUnitItem.class, new Serializer());
        }
    }

    public final String m20558n() {
        return null;
    }

    public final GraphQLImage m20559o() {
        return null;
    }

    public final GraphQLImage m20554a(int i) {
        return null;
    }

    public final GraphQLVect2 m20560p() {
        return null;
    }

    public final boolean m20562r() {
        return false;
    }

    public final SponsoredImpression Z_() {
        return ImpressionUtil.a(this);
    }

    @Nullable
    public final SponsoredImpression ab_() {
        return ImpressionUtil.a(this);
    }

    public final GraphQLPage m20557m() {
        return m20565u();
    }

    public final GraphQLPagesYouMayLikeFeedUnitItemContentConnection m20561q() {
        return m20563s();
    }

    @FieldOffset
    @Nullable
    public final GraphQLPagesYouMayLikeFeedUnitItemContentConnection m20563s() {
        this.f12399d = (GraphQLPagesYouMayLikeFeedUnitItemContentConnection) super.a(this.f12399d, 0, GraphQLPagesYouMayLikeFeedUnitItemContentConnection.class);
        return this.f12399d;
    }

    @FieldOffset
    @Nullable
    public final String m20564t() {
        this.f12400e = super.a(this.f12400e, 1);
        return this.f12400e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m20566w() {
        this.f12401f = (GraphQLTextWithEntities) super.a(this.f12401f, 2, GraphQLTextWithEntities.class);
        return this.f12401f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m20565u() {
        this.f12402g = (GraphQLPage) super.a(this.f12402g, 3, GraphQLPage.class);
        return this.f12402g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m20567z() {
        this.f12403h = (GraphQLTextWithEntities) super.a(this.f12403h, 4, GraphQLTextWithEntities.class);
        return this.f12403h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLSponsoredData m20552A() {
        this.f12404i = (GraphQLSponsoredData) super.a(this.f12404i, 5, GraphQLSponsoredData.class);
        return this.f12404i;
    }

    @FieldOffset
    @Nullable
    public final String m20556k() {
        this.f12405j = super.a(this.f12405j, 6);
        return this.f12405j;
    }

    public final int jK_() {
        return -2026828458;
    }

    public final GraphQLVisitableModel m20555a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m20563s() != null) {
            GraphQLPagesYouMayLikeFeedUnitItemContentConnection graphQLPagesYouMayLikeFeedUnitItemContentConnection = (GraphQLPagesYouMayLikeFeedUnitItemContentConnection) graphQLModelMutatingVisitor.b(m20563s());
            if (m20563s() != graphQLPagesYouMayLikeFeedUnitItemContentConnection) {
                graphQLVisitableModel = (GraphQLPagesYouMayLikeFeedUnitItem) ModelHelper.a(null, this);
                graphQLVisitableModel.f12399d = graphQLPagesYouMayLikeFeedUnitItemContentConnection;
            }
        }
        if (m20566w() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m20566w());
            if (m20566w() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLPagesYouMayLikeFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12401f = graphQLTextWithEntities;
            }
        }
        if (m20565u() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.b(m20565u());
            if (m20565u() != graphQLPage) {
                graphQLVisitableModel = (GraphQLPagesYouMayLikeFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12402g = graphQLPage;
            }
        }
        if (m20567z() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m20567z());
            if (m20567z() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLPagesYouMayLikeFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12403h = graphQLTextWithEntities;
            }
        }
        if (m20552A() != null) {
            GraphQLSponsoredData graphQLSponsoredData = (GraphQLSponsoredData) graphQLModelMutatingVisitor.b(m20552A());
            if (m20552A() != graphQLSponsoredData) {
                graphQLVisitableModel = (GraphQLPagesYouMayLikeFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12404i = graphQLSponsoredData;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPagesYouMayLikeFeedUnitItem() {
        super(8);
    }

    public final int m20553a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m20563s());
        int b = flatBufferBuilder.b(m20564t());
        int a2 = ModelHelper.a(flatBufferBuilder, m20566w());
        int a3 = ModelHelper.a(flatBufferBuilder, m20565u());
        int a4 = ModelHelper.a(flatBufferBuilder, m20567z());
        int a5 = ModelHelper.a(flatBufferBuilder, m20552A());
        int b2 = flatBufferBuilder.b(m20556k());
        flatBufferBuilder.c(7);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, a4);
        flatBufferBuilder.b(5, a5);
        flatBufferBuilder.b(6, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPagesYouMayLikeFeedUnitItem(Parcel parcel) {
        super(8);
        this.f12399d = (GraphQLPagesYouMayLikeFeedUnitItemContentConnection) parcel.readValue(GraphQLPagesYouMayLikeFeedUnitItemContentConnection.class.getClassLoader());
        this.f12400e = parcel.readString();
        this.f12401f = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f12402g = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f12403h = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f12404i = (GraphQLSponsoredData) parcel.readValue(GraphQLSponsoredData.class.getClassLoader());
        this.f12405j = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m20563s());
        parcel.writeString(m20564t());
        parcel.writeValue(m20566w());
        parcel.writeValue(m20565u());
        parcel.writeValue(m20567z());
        parcel.writeValue(m20552A());
        parcel.writeString(m20556k());
    }

    public final PropertyBag U_() {
        if (this.f12406k == null) {
            this.f12406k = new PropertyBag();
        }
        return this.f12406k;
    }
}
