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
import com.facebook.graphql.deserializers.GraphQLSaleGroupsNearYouFeedUnitGroupsEdgeDeserializer;
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
/* compiled from: VIDEOS_MIXED */
public final class GraphQLSaleGroupsNearYouFeedUnitGroupsEdge extends BaseModel implements HasProperty, HasTracking, ItemListFeedUnitItem, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLSaleGroupsNearYouFeedUnitGroupsEdge> CREATOR = new C12151();
    @Nullable
    GraphQLGroup f12953d;
    @Nullable
    String f12954e;
    @Nullable
    private PropertyBag f12955f = null;

    /* compiled from: VIDEOS_MIXED */
    final class C12151 implements Creator<GraphQLSaleGroupsNearYouFeedUnitGroupsEdge> {
        C12151() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSaleGroupsNearYouFeedUnitGroupsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSaleGroupsNearYouFeedUnitGroupsEdge[i];
        }
    }

    /* compiled from: VIDEOS_MIXED */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLSaleGroupsNearYouFeedUnitGroupsEdge.class, new Deserializer());
        }

        public Object m21519a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLSaleGroupsNearYouFeedUnitGroupsEdgeDeserializer.m5849a(jsonParser, (short) 515);
            Object graphQLSaleGroupsNearYouFeedUnitGroupsEdge = new GraphQLSaleGroupsNearYouFeedUnitGroupsEdge();
            ((BaseModel) graphQLSaleGroupsNearYouFeedUnitGroupsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLSaleGroupsNearYouFeedUnitGroupsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLSaleGroupsNearYouFeedUnitGroupsEdge).a();
            }
            return graphQLSaleGroupsNearYouFeedUnitGroupsEdge;
        }
    }

    /* compiled from: VIDEOS_MIXED */
    public final class Serializer extends JsonSerializer<GraphQLSaleGroupsNearYouFeedUnitGroupsEdge> {
        public final void m21520a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLSaleGroupsNearYouFeedUnitGroupsEdge graphQLSaleGroupsNearYouFeedUnitGroupsEdge = (GraphQLSaleGroupsNearYouFeedUnitGroupsEdge) obj;
            GraphQLSaleGroupsNearYouFeedUnitGroupsEdgeDeserializer.m5850b(graphQLSaleGroupsNearYouFeedUnitGroupsEdge.w_(), graphQLSaleGroupsNearYouFeedUnitGroupsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLSaleGroupsNearYouFeedUnitGroupsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLSaleGroupsNearYouFeedUnitGroupsEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLGroup m21523j() {
        this.f12953d = (GraphQLGroup) super.a(this.f12953d, 0, GraphQLGroup.class);
        return this.f12953d;
    }

    @FieldOffset
    @Nullable
    public final String m21524k() {
        this.f12954e = super.a(this.f12954e, 1);
        return this.f12954e;
    }

    public final int jK_() {
        return 1591321071;
    }

    public final GraphQLVisitableModel m21522a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21523j() != null) {
            GraphQLGroup graphQLGroup = (GraphQLGroup) graphQLModelMutatingVisitor.b(m21523j());
            if (m21523j() != graphQLGroup) {
                graphQLVisitableModel = (GraphQLSaleGroupsNearYouFeedUnitGroupsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f12953d = graphQLGroup;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLSaleGroupsNearYouFeedUnitGroupsEdge() {
        super(3);
    }

    public final int m21521a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21523j());
        int b = flatBufferBuilder.b(m21524k());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLSaleGroupsNearYouFeedUnitGroupsEdge(Parcel parcel) {
        super(3);
        this.f12953d = (GraphQLGroup) parcel.readValue(GraphQLGroup.class.getClassLoader());
        this.f12954e = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m21523j());
        parcel.writeString(m21524k());
    }

    public final PropertyBag U_() {
        if (this.f12955f == null) {
            this.f12955f = new PropertyBag();
        }
        return this.f12955f;
    }
}
