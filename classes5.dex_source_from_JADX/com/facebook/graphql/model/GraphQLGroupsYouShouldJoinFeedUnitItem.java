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
import com.facebook.graphql.deserializers.GraphQLGroupsYouShouldJoinFeedUnitItemDeserializer;
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
/* compiled from: formatting_string */
public final class GraphQLGroupsYouShouldJoinFeedUnitItem extends BaseModel implements GroupsYouShouldJoinFeedUnitItem, HasProperty, HasTracking, ItemListFeedUnitItem, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGroupsYouShouldJoinFeedUnitItem> CREATOR = new C04091();
    @Nullable
    GraphQLTextWithEntities f4241d;
    @Nullable
    GraphQLGroup f4242e;
    @Nullable
    String f4243f;
    @Nullable
    private PropertyBag f4244g = null;

    /* compiled from: formatting_string */
    final class C04091 implements Creator<GraphQLGroupsYouShouldJoinFeedUnitItem> {
        C04091() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGroupsYouShouldJoinFeedUnitItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGroupsYouShouldJoinFeedUnitItem[i];
        }
    }

    /* compiled from: formatting_string */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGroupsYouShouldJoinFeedUnitItem.class, new Deserializer());
        }

        public Object m8546a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGroupsYouShouldJoinFeedUnitItemDeserializer.m5206a(jsonParser, (short) 347);
            Object graphQLGroupsYouShouldJoinFeedUnitItem = new GraphQLGroupsYouShouldJoinFeedUnitItem();
            ((BaseModel) graphQLGroupsYouShouldJoinFeedUnitItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGroupsYouShouldJoinFeedUnitItem instanceof Postprocessable) {
                return ((Postprocessable) graphQLGroupsYouShouldJoinFeedUnitItem).a();
            }
            return graphQLGroupsYouShouldJoinFeedUnitItem;
        }
    }

    /* compiled from: formatting_string */
    public final class Serializer extends JsonSerializer<GraphQLGroupsYouShouldJoinFeedUnitItem> {
        public final void m8547a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGroupsYouShouldJoinFeedUnitItem graphQLGroupsYouShouldJoinFeedUnitItem = (GraphQLGroupsYouShouldJoinFeedUnitItem) obj;
            GraphQLGroupsYouShouldJoinFeedUnitItemDeserializer.m5209b(graphQLGroupsYouShouldJoinFeedUnitItem.w_(), graphQLGroupsYouShouldJoinFeedUnitItem.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGroupsYouShouldJoinFeedUnitItem.class, new Serializer());
            FbSerializerProvider.a(GraphQLGroupsYouShouldJoinFeedUnitItem.class, new Serializer());
        }
    }

    public final GraphQLGroup mo612j() {
        return m8553m();
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m8552l() {
        this.f4241d = (GraphQLTextWithEntities) super.a(this.f4241d, 0, GraphQLTextWithEntities.class);
        return this.f4241d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGroup m8553m() {
        this.f4242e = (GraphQLGroup) super.a(this.f4242e, 1, GraphQLGroup.class);
        return this.f4242e;
    }

    @FieldOffset
    @Nullable
    public final String m8551k() {
        this.f4243f = super.a(this.f4243f, 2);
        return this.f4243f;
    }

    public final int jK_() {
        return 398658557;
    }

    public final GraphQLVisitableModel m8549a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8552l() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m8552l());
            if (m8552l() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGroupsYouShouldJoinFeedUnitItem) ModelHelper.a(null, this);
                graphQLVisitableModel.f4241d = graphQLTextWithEntities;
            }
        }
        if (m8553m() != null) {
            GraphQLGroup graphQLGroup = (GraphQLGroup) graphQLModelMutatingVisitor.b(m8553m());
            if (m8553m() != graphQLGroup) {
                graphQLVisitableModel = (GraphQLGroupsYouShouldJoinFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4242e = graphQLGroup;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGroupsYouShouldJoinFeedUnitItem() {
        super(4);
    }

    public final int m8548a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8552l());
        int a2 = ModelHelper.a(flatBufferBuilder, m8553m());
        int b = flatBufferBuilder.b(m8551k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGroupsYouShouldJoinFeedUnitItem(Parcel parcel) {
        super(4);
        this.f4241d = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f4242e = (GraphQLGroup) parcel.readValue(GraphQLGroup.class.getClassLoader());
        this.f4243f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m8552l());
        parcel.writeValue(m8553m());
        parcel.writeString(m8551k());
    }

    public final PropertyBag U_() {
        if (this.f4244g == null) {
            this.f4244g = new PropertyBag();
        }
        return this.f4244g;
    }
}
