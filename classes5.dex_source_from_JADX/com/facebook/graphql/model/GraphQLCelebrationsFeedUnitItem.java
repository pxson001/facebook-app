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
import com.facebook.graphql.deserializers.GraphQLCelebrationsFeedUnitItemDeserializer;
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
/* compiled from: is_disturbing */
public final class GraphQLCelebrationsFeedUnitItem extends BaseModel implements HasTracking, ItemListFeedUnitItem, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLCelebrationsFeedUnitItem> CREATOR = new C02821();
    @Nullable
    GraphQLTextWithEntities f3431d;
    @Nullable
    GraphQLUser f3432e;
    @Nullable
    String f3433f;

    /* compiled from: is_disturbing */
    final class C02821 implements Creator<GraphQLCelebrationsFeedUnitItem> {
        C02821() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLCelebrationsFeedUnitItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLCelebrationsFeedUnitItem[i];
        }
    }

    /* compiled from: is_disturbing */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLCelebrationsFeedUnitItem.class, new Deserializer());
        }

        public Object m6746a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLCelebrationsFeedUnitItemDeserializer.m4644a(jsonParser, (short) 353);
            Object graphQLCelebrationsFeedUnitItem = new GraphQLCelebrationsFeedUnitItem();
            ((BaseModel) graphQLCelebrationsFeedUnitItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLCelebrationsFeedUnitItem instanceof Postprocessable) {
                return ((Postprocessable) graphQLCelebrationsFeedUnitItem).a();
            }
            return graphQLCelebrationsFeedUnitItem;
        }
    }

    /* compiled from: is_disturbing */
    public final class Serializer extends JsonSerializer<GraphQLCelebrationsFeedUnitItem> {
        public final void m6747a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLCelebrationsFeedUnitItem graphQLCelebrationsFeedUnitItem = (GraphQLCelebrationsFeedUnitItem) obj;
            GraphQLCelebrationsFeedUnitItemDeserializer.m4647b(graphQLCelebrationsFeedUnitItem.w_(), graphQLCelebrationsFeedUnitItem.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLCelebrationsFeedUnitItem.class, new Serializer());
            FbSerializerProvider.a(GraphQLCelebrationsFeedUnitItem.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m6749a() {
        this.f3431d = (GraphQLTextWithEntities) super.a(this.f3431d, 0, GraphQLTextWithEntities.class);
        return this.f3431d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLUser m6751j() {
        this.f3432e = (GraphQLUser) super.a(this.f3432e, 1, GraphQLUser.class);
        return this.f3432e;
    }

    @FieldOffset
    @Nullable
    public final String m6752k() {
        this.f3433f = super.a(this.f3433f, 2);
        return this.f3433f;
    }

    public final int jK_() {
        return 14055422;
    }

    public final GraphQLVisitableModel m6750a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6749a() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m6749a());
            if (m6749a() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLCelebrationsFeedUnitItem) ModelHelper.a(null, this);
                graphQLVisitableModel.f3431d = graphQLTextWithEntities;
            }
        }
        if (m6751j() != null) {
            GraphQLUser graphQLUser = (GraphQLUser) graphQLModelMutatingVisitor.b(m6751j());
            if (m6751j() != graphQLUser) {
                graphQLVisitableModel = (GraphQLCelebrationsFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3432e = graphQLUser;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLCelebrationsFeedUnitItem() {
        super(4);
    }

    public final int m6748a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m6749a());
        int a2 = ModelHelper.a(flatBufferBuilder, m6751j());
        int b = flatBufferBuilder.b(m6752k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLCelebrationsFeedUnitItem(Parcel parcel) {
        super(4);
        this.f3431d = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3432e = (GraphQLUser) parcel.readValue(GraphQLUser.class.getClassLoader());
        this.f3433f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m6749a());
        parcel.writeValue(m6751j());
        parcel.writeString(m6752k());
    }
}
