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
import com.facebook.graphql.deserializers.GraphQLSocialWifiFeedUnitItemDeserializer;
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
/* compiled from: UserEducationExperiencesConnection */
public final class GraphQLSocialWifiFeedUnitItem extends BaseModel implements HasTracking, ItemListFeedUnitItem, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLSocialWifiFeedUnitItem> CREATOR = new C12271();
    @Nullable
    GraphQLPage f13024d;
    @Nullable
    String f13025e;

    /* compiled from: UserEducationExperiencesConnection */
    final class C12271 implements Creator<GraphQLSocialWifiFeedUnitItem> {
        C12271() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSocialWifiFeedUnitItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSocialWifiFeedUnitItem[i];
        }
    }

    /* compiled from: UserEducationExperiencesConnection */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLSocialWifiFeedUnitItem.class, new Deserializer());
        }

        public Object m21676a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLSocialWifiFeedUnitItemDeserializer.m5899a(jsonParser, (short) 352);
            Object graphQLSocialWifiFeedUnitItem = new GraphQLSocialWifiFeedUnitItem();
            ((BaseModel) graphQLSocialWifiFeedUnitItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLSocialWifiFeedUnitItem instanceof Postprocessable) {
                return ((Postprocessable) graphQLSocialWifiFeedUnitItem).a();
            }
            return graphQLSocialWifiFeedUnitItem;
        }
    }

    /* compiled from: UserEducationExperiencesConnection */
    public final class Serializer extends JsonSerializer<GraphQLSocialWifiFeedUnitItem> {
        public final void m21677a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLSocialWifiFeedUnitItem graphQLSocialWifiFeedUnitItem = (GraphQLSocialWifiFeedUnitItem) obj;
            GraphQLSocialWifiFeedUnitItemDeserializer.m5902b(graphQLSocialWifiFeedUnitItem.w_(), graphQLSocialWifiFeedUnitItem.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLSocialWifiFeedUnitItem.class, new Serializer());
            FbSerializerProvider.a(GraphQLSocialWifiFeedUnitItem.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m21679a() {
        this.f13024d = (GraphQLPage) super.a(this.f13024d, 0, GraphQLPage.class);
        return this.f13024d;
    }

    @FieldOffset
    @Nullable
    public final String m21681k() {
        this.f13025e = super.a(this.f13025e, 1);
        return this.f13025e;
    }

    public final int jK_() {
        return -240530473;
    }

    public final GraphQLVisitableModel m21680a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21679a() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.b(m21679a());
            if (m21679a() != graphQLPage) {
                graphQLVisitableModel = (GraphQLSocialWifiFeedUnitItem) ModelHelper.a(null, this);
                graphQLVisitableModel.f13024d = graphQLPage;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLSocialWifiFeedUnitItem() {
        super(3);
    }

    public final int m21678a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21679a());
        int b = flatBufferBuilder.b(m21681k());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLSocialWifiFeedUnitItem(Parcel parcel) {
        super(3);
        this.f13024d = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f13025e = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m21679a());
        parcel.writeString(m21681k());
    }
}
