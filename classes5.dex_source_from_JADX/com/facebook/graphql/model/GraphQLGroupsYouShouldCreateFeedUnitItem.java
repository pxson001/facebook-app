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
import com.facebook.graphql.deserializers.GraphQLGroupsYouShouldCreateFeedUnitItemDeserializer;
import com.facebook.graphql.enums.GraphQLGroupCreationSuggestionType;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
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
/* compiled from: frames */
public final class GraphQLGroupsYouShouldCreateFeedUnitItem extends BaseModel implements HasTracking, ItemListFeedUnitItem, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGroupsYouShouldCreateFeedUnitItem> CREATOR = new C04061();
    @Nullable
    String f4222d;
    @Nullable
    GraphQLGroupCreationSuggestionDefaultMembersConnection f4223e;
    GraphQLGroupVisibility f4224f;
    @Nullable
    GraphQLProfile f4225g;
    @Deprecated
    List<GraphQLUser> f4226h;
    @Nullable
    GraphQLImage f4227i;
    @Nullable
    String f4228j;
    GraphQLGroupCreationSuggestionType f4229k;
    @Nullable
    String f4230l;

    /* compiled from: frames */
    final class C04061 implements Creator<GraphQLGroupsYouShouldCreateFeedUnitItem> {
        C04061() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGroupsYouShouldCreateFeedUnitItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGroupsYouShouldCreateFeedUnitItem[i];
        }
    }

    /* compiled from: frames */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGroupsYouShouldCreateFeedUnitItem.class, new Deserializer());
        }

        public Object m8524a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGroupsYouShouldCreateFeedUnitItemDeserializer.m5198a(jsonParser, (short) 345);
            Object graphQLGroupsYouShouldCreateFeedUnitItem = new GraphQLGroupsYouShouldCreateFeedUnitItem();
            ((BaseModel) graphQLGroupsYouShouldCreateFeedUnitItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGroupsYouShouldCreateFeedUnitItem instanceof Postprocessable) {
                return ((Postprocessable) graphQLGroupsYouShouldCreateFeedUnitItem).a();
            }
            return graphQLGroupsYouShouldCreateFeedUnitItem;
        }
    }

    /* compiled from: frames */
    public final class Serializer extends JsonSerializer<GraphQLGroupsYouShouldCreateFeedUnitItem> {
        public final void m8525a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGroupsYouShouldCreateFeedUnitItem graphQLGroupsYouShouldCreateFeedUnitItem = (GraphQLGroupsYouShouldCreateFeedUnitItem) obj;
            GraphQLGroupsYouShouldCreateFeedUnitItemDeserializer.m5201b(graphQLGroupsYouShouldCreateFeedUnitItem.w_(), graphQLGroupsYouShouldCreateFeedUnitItem.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGroupsYouShouldCreateFeedUnitItem.class, new Serializer());
            FbSerializerProvider.a(GraphQLGroupsYouShouldCreateFeedUnitItem.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m8528a() {
        this.f4222d = super.a(this.f4222d, 0);
        return this.f4222d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGroupCreationSuggestionDefaultMembersConnection m8529j() {
        this.f4223e = (GraphQLGroupCreationSuggestionDefaultMembersConnection) super.a(this.f4223e, 1, GraphQLGroupCreationSuggestionDefaultMembersConnection.class);
        return this.f4223e;
    }

    @FieldOffset
    public final GraphQLGroupVisibility m8531l() {
        this.f4224f = (GraphQLGroupVisibility) super.a(this.f4224f, 2, GraphQLGroupVisibility.class, GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f4224f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile m8532m() {
        this.f4225g = (GraphQLProfile) super.a(this.f4225g, 3, GraphQLProfile.class);
        return this.f4225g;
    }

    @FieldOffset
    public final ImmutableList<GraphQLUser> m8533n() {
        this.f4226h = super.a(this.f4226h, 4, GraphQLUser.class);
        return (ImmutableList) this.f4226h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m8534o() {
        this.f4227i = (GraphQLImage) super.a(this.f4227i, 5, GraphQLImage.class);
        return this.f4227i;
    }

    @FieldOffset
    @Nullable
    public final String m8535p() {
        this.f4228j = super.a(this.f4228j, 6);
        return this.f4228j;
    }

    @FieldOffset
    public final GraphQLGroupCreationSuggestionType m8536q() {
        this.f4229k = (GraphQLGroupCreationSuggestionType) super.a(this.f4229k, 7, GraphQLGroupCreationSuggestionType.class, GraphQLGroupCreationSuggestionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f4229k;
    }

    @FieldOffset
    @Nullable
    public final String m8530k() {
        this.f4230l = super.a(this.f4230l, 8);
        return this.f4230l;
    }

    public final int jK_() {
        return 1081920847;
    }

    public final GraphQLVisitableModel m8527a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8529j() != null) {
            GraphQLGroupCreationSuggestionDefaultMembersConnection graphQLGroupCreationSuggestionDefaultMembersConnection = (GraphQLGroupCreationSuggestionDefaultMembersConnection) graphQLModelMutatingVisitor.b(m8529j());
            if (m8529j() != graphQLGroupCreationSuggestionDefaultMembersConnection) {
                graphQLVisitableModel = (GraphQLGroupsYouShouldCreateFeedUnitItem) ModelHelper.a(null, this);
                graphQLVisitableModel.f4223e = graphQLGroupCreationSuggestionDefaultMembersConnection;
            }
        }
        if (m8532m() != null) {
            GraphQLProfile graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.b(m8532m());
            if (m8532m() != graphQLProfile) {
                graphQLVisitableModel = (GraphQLGroupsYouShouldCreateFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4225g = graphQLProfile;
            }
        }
        if (m8533n() != null) {
            Builder a = ModelHelper.a(m8533n(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLGroupsYouShouldCreateFeedUnitItem graphQLGroupsYouShouldCreateFeedUnitItem = (GraphQLGroupsYouShouldCreateFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLGroupsYouShouldCreateFeedUnitItem.f4226h = a.b();
                graphQLVisitableModel = graphQLGroupsYouShouldCreateFeedUnitItem;
            }
        }
        if (m8534o() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m8534o());
            if (m8534o() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGroupsYouShouldCreateFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4227i = graphQLImage;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGroupsYouShouldCreateFeedUnitItem() {
        super(10);
    }

    public final int m8526a(FlatBufferBuilder flatBufferBuilder) {
        Enum enumR = null;
        h();
        int b = flatBufferBuilder.b(m8528a());
        int a = ModelHelper.a(flatBufferBuilder, m8529j());
        int a2 = ModelHelper.a(flatBufferBuilder, m8532m());
        int a3 = ModelHelper.a(flatBufferBuilder, m8533n());
        int a4 = ModelHelper.a(flatBufferBuilder, m8534o());
        int b2 = flatBufferBuilder.b(m8535p());
        int b3 = flatBufferBuilder.b(m8530k());
        flatBufferBuilder.c(9);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.a(2, m8531l() == GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m8531l());
        flatBufferBuilder.b(3, a2);
        flatBufferBuilder.b(4, a3);
        flatBufferBuilder.b(5, a4);
        flatBufferBuilder.b(6, b2);
        if (m8536q() != GraphQLGroupCreationSuggestionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            enumR = m8536q();
        }
        flatBufferBuilder.a(7, enumR);
        flatBufferBuilder.b(8, b3);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGroupsYouShouldCreateFeedUnitItem(Parcel parcel) {
        super(10);
        this.f4222d = parcel.readString();
        this.f4223e = (GraphQLGroupCreationSuggestionDefaultMembersConnection) parcel.readValue(GraphQLGroupCreationSuggestionDefaultMembersConnection.class.getClassLoader());
        this.f4224f = GraphQLGroupVisibility.fromString(parcel.readString());
        this.f4225g = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
        this.f4226h = ImmutableListHelper.a(parcel.readArrayList(GraphQLUser.class.getClassLoader()));
        this.f4227i = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4228j = parcel.readString();
        this.f4229k = GraphQLGroupCreationSuggestionType.fromString(parcel.readString());
        this.f4230l = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m8528a());
        parcel.writeValue(m8529j());
        parcel.writeString(m8531l().name());
        parcel.writeValue(m8532m());
        parcel.writeList(m8533n());
        parcel.writeValue(m8534o());
        parcel.writeString(m8535p());
        parcel.writeString(m8536q().name());
        parcel.writeString(m8530k());
    }
}
