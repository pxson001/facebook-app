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
import com.facebook.graphql.deserializers.GraphQLMobilePageAdminPanelFeedUnitItemDeserializer;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.interfaces.HasTracking;
import com.facebook.graphql.model.interfaces.ItemListFeedUnitItem;
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
/* compiled from: facepile_text */
public final class GraphQLMobilePageAdminPanelFeedUnitItem extends BaseModel implements HasProperty, HasTracking, ItemListFeedUnitItem, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLMobilePageAdminPanelFeedUnitItem> CREATOR = new C04381();
    @Deprecated
    @Nullable
    GraphQLImage f4509d;
    @Deprecated
    @Nullable
    String f4510e;
    @Nullable
    GraphQLAYMTChannel f4511f;
    List<GraphQLEntityCardContextItem> f4512g;
    @Nullable
    GraphQLPage f4513h;
    @Nullable
    String f4514i;
    @Nullable
    private PropertyBag f4515j = null;

    /* compiled from: facepile_text */
    final class C04381 implements Creator<GraphQLMobilePageAdminPanelFeedUnitItem> {
        C04381() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLMobilePageAdminPanelFeedUnitItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLMobilePageAdminPanelFeedUnitItem[i];
        }
    }

    /* compiled from: facepile_text */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLMobilePageAdminPanelFeedUnitItem.class, new Deserializer());
        }

        public Object m9118a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLMobilePageAdminPanelFeedUnitItemDeserializer.m5374a(jsonParser, (short) 372);
            Object graphQLMobilePageAdminPanelFeedUnitItem = new GraphQLMobilePageAdminPanelFeedUnitItem();
            ((BaseModel) graphQLMobilePageAdminPanelFeedUnitItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLMobilePageAdminPanelFeedUnitItem instanceof Postprocessable) {
                return ((Postprocessable) graphQLMobilePageAdminPanelFeedUnitItem).a();
            }
            return graphQLMobilePageAdminPanelFeedUnitItem;
        }
    }

    /* compiled from: facepile_text */
    public final class Serializer extends JsonSerializer<GraphQLMobilePageAdminPanelFeedUnitItem> {
        public final void m9119a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLMobilePageAdminPanelFeedUnitItem graphQLMobilePageAdminPanelFeedUnitItem = (GraphQLMobilePageAdminPanelFeedUnitItem) obj;
            GraphQLMobilePageAdminPanelFeedUnitItemDeserializer.m5376b(graphQLMobilePageAdminPanelFeedUnitItem.w_(), graphQLMobilePageAdminPanelFeedUnitItem.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLMobilePageAdminPanelFeedUnitItem.class, new Serializer());
            FbSerializerProvider.a(GraphQLMobilePageAdminPanelFeedUnitItem.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m9122j() {
        this.f4509d = (GraphQLImage) super.a(this.f4509d, 0, GraphQLImage.class);
        return this.f4509d;
    }

    @FieldOffset
    @Nullable
    public final String m9124l() {
        this.f4510e = super.a(this.f4510e, 1);
        return this.f4510e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLAYMTChannel m9125m() {
        this.f4511f = (GraphQLAYMTChannel) super.a(this.f4511f, 2, GraphQLAYMTChannel.class);
        return this.f4511f;
    }

    @FieldOffset
    public final ImmutableList<GraphQLEntityCardContextItem> m9126n() {
        this.f4512g = super.a(this.f4512g, 3, GraphQLEntityCardContextItem.class);
        return (ImmutableList) this.f4512g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m9127o() {
        this.f4513h = (GraphQLPage) super.a(this.f4513h, 4, GraphQLPage.class);
        return this.f4513h;
    }

    @FieldOffset
    @Nullable
    public final String m9123k() {
        this.f4514i = super.a(this.f4514i, 5);
        return this.f4514i;
    }

    public final int jK_() {
        return 1717699291;
    }

    public final GraphQLVisitableModel m9121a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m9122j() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m9122j());
            if (m9122j() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMobilePageAdminPanelFeedUnitItem) ModelHelper.a(null, this);
                graphQLVisitableModel.f4509d = graphQLImage;
            }
        }
        if (m9125m() != null) {
            GraphQLAYMTChannel graphQLAYMTChannel = (GraphQLAYMTChannel) graphQLModelMutatingVisitor.b(m9125m());
            if (m9125m() != graphQLAYMTChannel) {
                graphQLVisitableModel = (GraphQLMobilePageAdminPanelFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4511f = graphQLAYMTChannel;
            }
        }
        if (m9126n() != null) {
            Builder a = ModelHelper.a(m9126n(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLMobilePageAdminPanelFeedUnitItem graphQLMobilePageAdminPanelFeedUnitItem = (GraphQLMobilePageAdminPanelFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLMobilePageAdminPanelFeedUnitItem.f4512g = a.b();
                graphQLVisitableModel = graphQLMobilePageAdminPanelFeedUnitItem;
            }
        }
        if (m9127o() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.b(m9127o());
            if (m9127o() != graphQLPage) {
                graphQLVisitableModel = (GraphQLMobilePageAdminPanelFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4513h = graphQLPage;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLMobilePageAdminPanelFeedUnitItem() {
        super(7);
    }

    public final int m9120a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m9122j());
        int b = flatBufferBuilder.b(m9124l());
        int a2 = ModelHelper.a(flatBufferBuilder, m9125m());
        int a3 = ModelHelper.a(flatBufferBuilder, m9126n());
        int a4 = ModelHelper.a(flatBufferBuilder, m9127o());
        int b2 = flatBufferBuilder.b(m9123k());
        flatBufferBuilder.c(6);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, a4);
        flatBufferBuilder.b(5, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLMobilePageAdminPanelFeedUnitItem(Parcel parcel) {
        super(7);
        this.f4509d = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4510e = parcel.readString();
        this.f4511f = (GraphQLAYMTChannel) parcel.readValue(GraphQLAYMTChannel.class.getClassLoader());
        this.f4512g = ImmutableListHelper.a(parcel.readArrayList(GraphQLEntityCardContextItem.class.getClassLoader()));
        this.f4513h = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f4514i = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m9122j());
        parcel.writeString(m9124l());
        parcel.writeValue(m9125m());
        parcel.writeList(m9126n());
        parcel.writeValue(m9127o());
        parcel.writeString(m9123k());
    }

    public final PropertyBag U_() {
        if (this.f4515j == null) {
            this.f4515j = new PropertyBag();
        }
        return this.f4515j;
    }
}
