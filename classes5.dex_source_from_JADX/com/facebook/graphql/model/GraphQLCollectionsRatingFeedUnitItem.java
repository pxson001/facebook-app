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
import com.facebook.graphql.deserializers.GraphQLCollectionsRatingFeedUnitItemDeserializer;
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
/* compiled from: is_category_optional */
public final class GraphQLCollectionsRatingFeedUnitItem extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLCollectionsRatingFeedUnitItem> CREATOR = new C02861();
    @Nullable
    GraphQLProfile f3447d;
    @Nullable
    String f3448e;

    /* compiled from: is_category_optional */
    final class C02861 implements Creator<GraphQLCollectionsRatingFeedUnitItem> {
        C02861() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLCollectionsRatingFeedUnitItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLCollectionsRatingFeedUnitItem[i];
        }
    }

    /* compiled from: is_category_optional */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLCollectionsRatingFeedUnitItem.class, new Deserializer());
        }

        public Object m6790a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLCollectionsRatingFeedUnitItemDeserializer.m4655a(jsonParser, (short) 420);
            Object graphQLCollectionsRatingFeedUnitItem = new GraphQLCollectionsRatingFeedUnitItem();
            ((BaseModel) graphQLCollectionsRatingFeedUnitItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLCollectionsRatingFeedUnitItem instanceof Postprocessable) {
                return ((Postprocessable) graphQLCollectionsRatingFeedUnitItem).a();
            }
            return graphQLCollectionsRatingFeedUnitItem;
        }
    }

    /* compiled from: is_category_optional */
    public final class Serializer extends JsonSerializer<GraphQLCollectionsRatingFeedUnitItem> {
        public final void m6791a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLCollectionsRatingFeedUnitItem graphQLCollectionsRatingFeedUnitItem = (GraphQLCollectionsRatingFeedUnitItem) obj;
            GraphQLCollectionsRatingFeedUnitItemDeserializer.m4656a(graphQLCollectionsRatingFeedUnitItem.w_(), graphQLCollectionsRatingFeedUnitItem.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLCollectionsRatingFeedUnitItem.class, new Serializer());
            FbSerializerProvider.a(GraphQLCollectionsRatingFeedUnitItem.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile m6793a() {
        this.f3447d = (GraphQLProfile) super.a(this.f3447d, 0, GraphQLProfile.class);
        return this.f3447d;
    }

    @FieldOffset
    @Nullable
    public final String m6795j() {
        this.f3448e = super.a(this.f3448e, 1);
        return this.f3448e;
    }

    public final int jK_() {
        return -1410815225;
    }

    public final GraphQLVisitableModel m6794a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6793a() != null) {
            GraphQLProfile graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.b(m6793a());
            if (m6793a() != graphQLProfile) {
                graphQLVisitableModel = (GraphQLCollectionsRatingFeedUnitItem) ModelHelper.a(null, this);
                graphQLVisitableModel.f3447d = graphQLProfile;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLCollectionsRatingFeedUnitItem() {
        super(3);
    }

    public final int m6792a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m6793a());
        int b = flatBufferBuilder.b(m6795j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLCollectionsRatingFeedUnitItem(Parcel parcel) {
        super(3);
        this.f3447d = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
        this.f3448e = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m6793a());
        parcel.writeString(m6795j());
    }
}
