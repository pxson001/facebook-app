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
import com.facebook.graphql.deserializers.GraphQLSavedCollectionFeedUnitItemDeserializer;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.interfaces.HasTracking;
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
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: VERTICAL_COMPONENT_LIST_W_AUX_ACTION */
public final class GraphQLSavedCollectionFeedUnitItem extends BaseModel implements HasProperty, HasTracking, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLSavedCollectionFeedUnitItem> CREATOR = new C12171();
    List<GraphQLStoryActionLink> f12980d;
    @Nullable
    GraphQLTextWithEntities f12981e;
    @Nullable
    String f12982f;
    @Nullable
    GraphQLProfile f12983g;
    @Nullable
    GraphQLTextWithEntities f12984h;
    @Nullable
    GraphQLTextWithEntities f12985i;
    @Nullable
    String f12986j;
    @Nullable
    private PropertyBag f12987k = null;

    /* compiled from: VERTICAL_COMPONENT_LIST_W_AUX_ACTION */
    final class C12171 implements Creator<GraphQLSavedCollectionFeedUnitItem> {
        C12171() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSavedCollectionFeedUnitItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSavedCollectionFeedUnitItem[i];
        }
    }

    /* compiled from: VERTICAL_COMPONENT_LIST_W_AUX_ACTION */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        public ImmutableList<GraphQLStoryActionLink> f12972d;
        @Nullable
        public GraphQLTextWithEntities f12973e;
        @Nullable
        public String f12974f;
        @Nullable
        public GraphQLProfile f12975g;
        @Nullable
        public GraphQLTextWithEntities f12976h;
        @Nullable
        public GraphQLTextWithEntities f12977i;
        @Nullable
        public String f12978j;
        @Nullable
        public PropertyBag f12979k = null;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }
    }

    /* compiled from: VERTICAL_COMPONENT_LIST_W_AUX_ACTION */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLSavedCollectionFeedUnitItem.class, new Deserializer());
        }

        public Object m21535a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLSavedCollectionFeedUnitItemDeserializer.m5855a(jsonParser, (short) 351);
            Object graphQLSavedCollectionFeedUnitItem = new GraphQLSavedCollectionFeedUnitItem();
            ((BaseModel) graphQLSavedCollectionFeedUnitItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLSavedCollectionFeedUnitItem instanceof Postprocessable) {
                return ((Postprocessable) graphQLSavedCollectionFeedUnitItem).a();
            }
            return graphQLSavedCollectionFeedUnitItem;
        }
    }

    /* compiled from: VERTICAL_COMPONENT_LIST_W_AUX_ACTION */
    public final class Serializer extends JsonSerializer<GraphQLSavedCollectionFeedUnitItem> {
        public final void m21536a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLSavedCollectionFeedUnitItem graphQLSavedCollectionFeedUnitItem = (GraphQLSavedCollectionFeedUnitItem) obj;
            GraphQLSavedCollectionFeedUnitItemDeserializer.m5858b(graphQLSavedCollectionFeedUnitItem.w_(), graphQLSavedCollectionFeedUnitItem.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLSavedCollectionFeedUnitItem.class, new Serializer());
            FbSerializerProvider.a(GraphQLSavedCollectionFeedUnitItem.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryActionLink> m21539j() {
        this.f12980d = super.a(this.f12980d, 0, GraphQLStoryActionLink.class);
        return (ImmutableList) this.f12980d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m21541l() {
        this.f12981e = (GraphQLTextWithEntities) super.a(this.f12981e, 1, GraphQLTextWithEntities.class);
        return this.f12981e;
    }

    @FieldOffset
    @Nullable
    public final String m21542m() {
        this.f12982f = super.a(this.f12982f, 2);
        return this.f12982f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile m21543n() {
        this.f12983g = (GraphQLProfile) super.a(this.f12983g, 3, GraphQLProfile.class);
        return this.f12983g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m21544o() {
        this.f12984h = (GraphQLTextWithEntities) super.a(this.f12984h, 4, GraphQLTextWithEntities.class);
        return this.f12984h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m21545p() {
        this.f12985i = (GraphQLTextWithEntities) super.a(this.f12985i, 5, GraphQLTextWithEntities.class);
        return this.f12985i;
    }

    @FieldOffset
    @Nullable
    public final String m21540k() {
        this.f12986j = super.a(this.f12986j, 6);
        return this.f12986j;
    }

    public final int jK_() {
        return 420449146;
    }

    public final GraphQLVisitableModel m21538a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLProfile graphQLProfile;
        h();
        if (m21539j() != null) {
            com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m21539j(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLSavedCollectionFeedUnitItem graphQLSavedCollectionFeedUnitItem = (GraphQLSavedCollectionFeedUnitItem) ModelHelper.a(null, this);
                graphQLSavedCollectionFeedUnitItem.f12980d = a.b();
                graphQLVisitableModel = graphQLSavedCollectionFeedUnitItem;
                if (m21541l() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m21541l());
                    if (m21541l() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLSavedCollectionFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12981e = graphQLTextWithEntities;
                    }
                }
                if (m21543n() != null) {
                    graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.b(m21543n());
                    if (m21543n() != graphQLProfile) {
                        graphQLVisitableModel = (GraphQLSavedCollectionFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12983g = graphQLProfile;
                    }
                }
                if (m21544o() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m21544o());
                    if (m21544o() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLSavedCollectionFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12984h = graphQLTextWithEntities;
                    }
                }
                if (m21545p() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m21545p());
                    if (m21545p() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLSavedCollectionFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12985i = graphQLTextWithEntities;
                    }
                }
                i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m21541l() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m21541l());
            if (m21541l() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLSavedCollectionFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12981e = graphQLTextWithEntities;
            }
        }
        if (m21543n() != null) {
            graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.b(m21543n());
            if (m21543n() != graphQLProfile) {
                graphQLVisitableModel = (GraphQLSavedCollectionFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12983g = graphQLProfile;
            }
        }
        if (m21544o() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m21544o());
            if (m21544o() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLSavedCollectionFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12984h = graphQLTextWithEntities;
            }
        }
        if (m21545p() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m21545p());
            if (m21545p() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLSavedCollectionFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12985i = graphQLTextWithEntities;
            }
        }
        i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLSavedCollectionFeedUnitItem() {
        super(8);
    }

    public final int m21537a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21539j());
        int a2 = ModelHelper.a(flatBufferBuilder, m21541l());
        int b = flatBufferBuilder.b(m21542m());
        int a3 = ModelHelper.a(flatBufferBuilder, m21543n());
        int a4 = ModelHelper.a(flatBufferBuilder, m21544o());
        int a5 = ModelHelper.a(flatBufferBuilder, m21545p());
        int b2 = flatBufferBuilder.b(m21540k());
        flatBufferBuilder.c(7);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, b);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, a4);
        flatBufferBuilder.b(5, a5);
        flatBufferBuilder.b(6, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLSavedCollectionFeedUnitItem(Parcel parcel) {
        super(8);
        this.f12980d = ImmutableListHelper.a(parcel.readArrayList(GraphQLStoryActionLink.class.getClassLoader()));
        this.f12981e = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f12982f = parcel.readString();
        this.f12983g = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
        this.f12984h = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f12985i = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f12986j = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m21539j());
        parcel.writeValue(m21541l());
        parcel.writeString(m21542m());
        parcel.writeValue(m21543n());
        parcel.writeValue(m21544o());
        parcel.writeValue(m21545p());
        parcel.writeString(m21540k());
    }

    public GraphQLSavedCollectionFeedUnitItem(Builder builder) {
        super(8);
        this.b = builder.a;
        this.c = builder.b;
        this.f12980d = builder.f12972d;
        this.f12981e = builder.f12973e;
        this.f12982f = builder.f12974f;
        this.f12983g = builder.f12975g;
        this.f12984h = builder.f12976h;
        this.f12985i = builder.f12977i;
        this.f12986j = builder.f12978j;
        this.f12987k = builder.f12979k;
    }

    public final PropertyBag U_() {
        if (this.f12987k == null) {
            this.f12987k = new PropertyBag();
        }
        return this.f12987k;
    }
}
