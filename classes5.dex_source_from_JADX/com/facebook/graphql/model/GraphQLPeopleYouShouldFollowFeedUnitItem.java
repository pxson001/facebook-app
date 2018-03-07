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
import com.facebook.graphql.deserializers.GraphQLPeopleYouShouldFollowFeedUnitItemDeserializer;
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
import com.google.common.base.Preconditions;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: WIZARD_IMPORTERS */
public final class GraphQLPeopleYouShouldFollowFeedUnitItem extends BaseModel implements HasProperty, HasTracking, ItemListFeedUnitItem, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPeopleYouShouldFollowFeedUnitItem> CREATOR = new C11701();
    @Nullable
    GraphQLTextWithEntities f12499d;
    @Nullable
    GraphQLTextWithEntities f12500e;
    @Nullable
    String f12501f;
    @Nullable
    GraphQLUser f12502g;
    @Nullable
    private PropertyBag f12503h = null;

    /* compiled from: WIZARD_IMPORTERS */
    final class C11701 implements Creator<GraphQLPeopleYouShouldFollowFeedUnitItem> {
        C11701() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPeopleYouShouldFollowFeedUnitItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPeopleYouShouldFollowFeedUnitItem[i];
        }
    }

    /* compiled from: WIZARD_IMPORTERS */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        @Nullable
        public GraphQLTextWithEntities f12494d;
        @Nullable
        public GraphQLTextWithEntities f12495e;
        @Nullable
        public String f12496f;
        @Nullable
        public GraphQLUser f12497g;
        @Nullable
        public PropertyBag f12498h = null;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }
    }

    /* compiled from: WIZARD_IMPORTERS */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLPeopleYouShouldFollowFeedUnitItem.class, new Deserializer());
        }

        public Object m20695a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLPeopleYouShouldFollowFeedUnitItemDeserializer.m5596a(jsonParser, (short) 342);
            Object graphQLPeopleYouShouldFollowFeedUnitItem = new GraphQLPeopleYouShouldFollowFeedUnitItem();
            ((BaseModel) graphQLPeopleYouShouldFollowFeedUnitItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLPeopleYouShouldFollowFeedUnitItem instanceof Postprocessable) {
                return ((Postprocessable) graphQLPeopleYouShouldFollowFeedUnitItem).a();
            }
            return graphQLPeopleYouShouldFollowFeedUnitItem;
        }
    }

    /* compiled from: WIZARD_IMPORTERS */
    public final class Serializer extends JsonSerializer<GraphQLPeopleYouShouldFollowFeedUnitItem> {
        public final void m20696a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLPeopleYouShouldFollowFeedUnitItem graphQLPeopleYouShouldFollowFeedUnitItem = (GraphQLPeopleYouShouldFollowFeedUnitItem) obj;
            GraphQLPeopleYouShouldFollowFeedUnitItemDeserializer.m5597b(graphQLPeopleYouShouldFollowFeedUnitItem.w_(), graphQLPeopleYouShouldFollowFeedUnitItem.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLPeopleYouShouldFollowFeedUnitItem.class, new Serializer());
            FbSerializerProvider.a(GraphQLPeopleYouShouldFollowFeedUnitItem.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m20699j() {
        this.f12499d = (GraphQLTextWithEntities) super.a(this.f12499d, 0, GraphQLTextWithEntities.class);
        return this.f12499d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m20701l() {
        this.f12500e = (GraphQLTextWithEntities) super.a(this.f12500e, 1, GraphQLTextWithEntities.class);
        return this.f12500e;
    }

    @FieldOffset
    @Nullable
    public final String m20700k() {
        this.f12501f = super.a(this.f12501f, 2);
        return this.f12501f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLUser m20702m() {
        this.f12502g = (GraphQLUser) super.a(this.f12502g, 3, GraphQLUser.class);
        return this.f12502g;
    }

    public final int jK_() {
        return -1382675735;
    }

    public final GraphQLVisitableModel m20698a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m20699j() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m20699j());
            if (m20699j() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLPeopleYouShouldFollowFeedUnitItem) ModelHelper.a(null, this);
                graphQLVisitableModel.f12499d = graphQLTextWithEntities;
            }
        }
        if (m20701l() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m20701l());
            if (m20701l() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLPeopleYouShouldFollowFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12500e = graphQLTextWithEntities;
            }
        }
        if (m20702m() != null) {
            GraphQLUser graphQLUser = (GraphQLUser) graphQLModelMutatingVisitor.b(m20702m());
            if (m20702m() != graphQLUser) {
                graphQLVisitableModel = (GraphQLPeopleYouShouldFollowFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12502g = graphQLUser;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPeopleYouShouldFollowFeedUnitItem() {
        super(5);
    }

    public final int m20697a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m20699j());
        int a2 = ModelHelper.a(flatBufferBuilder, m20701l());
        int b = flatBufferBuilder.b(m20700k());
        int a3 = ModelHelper.a(flatBufferBuilder, m20702m());
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, b);
        flatBufferBuilder.b(3, a3);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPeopleYouShouldFollowFeedUnitItem(Parcel parcel) {
        super(5);
        this.f12499d = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f12500e = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f12501f = parcel.readString();
        this.f12502g = (GraphQLUser) parcel.readValue(GraphQLUser.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m20699j());
        parcel.writeValue(m20701l());
        parcel.writeString(m20700k());
        parcel.writeValue(m20702m());
    }

    public GraphQLPeopleYouShouldFollowFeedUnitItem(Builder builder) {
        super(5);
        this.b = builder.a;
        this.c = builder.b;
        this.f12499d = builder.f12494d;
        this.f12500e = builder.f12495e;
        this.f12501f = builder.f12496f;
        this.f12502g = builder.f12497g;
        this.f12503h = builder.f12498h;
    }

    public final PropertyBag U_() {
        if (this.f12503h == null) {
            this.f12503h = new PropertyBag();
        }
        return this.f12503h;
    }
}
