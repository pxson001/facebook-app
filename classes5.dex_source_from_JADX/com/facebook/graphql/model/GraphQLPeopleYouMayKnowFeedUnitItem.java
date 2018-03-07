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
import com.facebook.graphql.deserializers.GraphQLPeopleYouMayKnowFeedUnitItemDeserializer;
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
/* compiled from: WORK */
public final class GraphQLPeopleYouMayKnowFeedUnitItem extends BaseModel implements PeopleYouMayKnowFeedUnitItem, HasProperty, HasTracking, ItemListFeedUnitItem, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPeopleYouMayKnowFeedUnitItem> CREATOR = new C11671();
    @Nullable
    GraphQLUser f12479d;
    @Nullable
    GraphQLTextWithEntities f12480e;
    @Nullable
    String f12481f;
    @Nullable
    private PropertyBag f12482g = null;

    /* compiled from: WORK */
    final class C11671 implements Creator<GraphQLPeopleYouMayKnowFeedUnitItem> {
        C11671() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPeopleYouMayKnowFeedUnitItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPeopleYouMayKnowFeedUnitItem[i];
        }
    }

    /* compiled from: WORK */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLPeopleYouMayKnowFeedUnitItem.class, new Deserializer());
        }

        public Object m20676a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLPeopleYouMayKnowFeedUnitItemDeserializer.m5588a(jsonParser, (short) 320);
            Object graphQLPeopleYouMayKnowFeedUnitItem = new GraphQLPeopleYouMayKnowFeedUnitItem();
            ((BaseModel) graphQLPeopleYouMayKnowFeedUnitItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLPeopleYouMayKnowFeedUnitItem instanceof Postprocessable) {
                return ((Postprocessable) graphQLPeopleYouMayKnowFeedUnitItem).a();
            }
            return graphQLPeopleYouMayKnowFeedUnitItem;
        }
    }

    /* compiled from: WORK */
    public final class Serializer extends JsonSerializer<GraphQLPeopleYouMayKnowFeedUnitItem> {
        public final void m20677a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLPeopleYouMayKnowFeedUnitItem graphQLPeopleYouMayKnowFeedUnitItem = (GraphQLPeopleYouMayKnowFeedUnitItem) obj;
            GraphQLPeopleYouMayKnowFeedUnitItemDeserializer.m5591b(graphQLPeopleYouMayKnowFeedUnitItem.w_(), graphQLPeopleYouMayKnowFeedUnitItem.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLPeopleYouMayKnowFeedUnitItem.class, new Serializer());
            FbSerializerProvider.a(GraphQLPeopleYouMayKnowFeedUnitItem.class, new Serializer());
        }
    }

    public final String m20681l() {
        return m20682m().P();
    }

    @FieldOffset
    @Nullable
    public final GraphQLUser m20682m() {
        this.f12479d = (GraphQLUser) super.a(this.f12479d, 0, GraphQLUser.class);
        return this.f12479d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m20683n() {
        this.f12480e = (GraphQLTextWithEntities) super.a(this.f12480e, 1, GraphQLTextWithEntities.class);
        return this.f12480e;
    }

    @FieldOffset
    @Nullable
    public final String m20680k() {
        this.f12481f = super.a(this.f12481f, 2);
        return this.f12481f;
    }

    public final int jK_() {
        return 1031295765;
    }

    public final GraphQLVisitableModel m20679a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m20682m() != null) {
            GraphQLUser graphQLUser = (GraphQLUser) graphQLModelMutatingVisitor.b(m20682m());
            if (m20682m() != graphQLUser) {
                graphQLVisitableModel = (GraphQLPeopleYouMayKnowFeedUnitItem) ModelHelper.a(null, this);
                graphQLVisitableModel.f12479d = graphQLUser;
            }
        }
        if (m20683n() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m20683n());
            if (m20683n() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLPeopleYouMayKnowFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12480e = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPeopleYouMayKnowFeedUnitItem() {
        super(4);
    }

    public final int m20678a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m20682m());
        int a2 = ModelHelper.a(flatBufferBuilder, m20683n());
        int b = flatBufferBuilder.b(m20680k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPeopleYouMayKnowFeedUnitItem(Parcel parcel) {
        super(4);
        this.f12479d = (GraphQLUser) parcel.readValue(GraphQLUser.class.getClassLoader());
        this.f12480e = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f12481f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m20682m());
        parcel.writeValue(m20683n());
        parcel.writeString(m20680k());
    }

    public final PropertyBag U_() {
        if (this.f12482g == null) {
            this.f12482g = new PropertyBag();
        }
        return this.f12482g;
    }
}
