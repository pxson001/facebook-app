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
import com.facebook.graphql.deserializers.GraphQLIncomingFriendRequestFeedUnitItemDeserializer;
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
/* compiled from: flac-compression-level */
public final class GraphQLIncomingFriendRequestFeedUnitItem extends BaseModel implements HasTracking, ItemListFeedUnitItem, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLIncomingFriendRequestFeedUnitItem> CREATOR = new C04151();
    @Nullable
    GraphQLUser f4298d;
    @Nullable
    GraphQLTextWithEntities f4299e;
    @Nullable
    String f4300f;

    /* compiled from: flac-compression-level */
    final class C04151 implements Creator<GraphQLIncomingFriendRequestFeedUnitItem> {
        C04151() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLIncomingFriendRequestFeedUnitItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLIncomingFriendRequestFeedUnitItem[i];
        }
    }

    /* compiled from: flac-compression-level */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLIncomingFriendRequestFeedUnitItem.class, new Deserializer());
        }

        public Object m8661a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLIncomingFriendRequestFeedUnitItemDeserializer.m5238a(jsonParser, (short) 581);
            Object graphQLIncomingFriendRequestFeedUnitItem = new GraphQLIncomingFriendRequestFeedUnitItem();
            ((BaseModel) graphQLIncomingFriendRequestFeedUnitItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLIncomingFriendRequestFeedUnitItem instanceof Postprocessable) {
                return ((Postprocessable) graphQLIncomingFriendRequestFeedUnitItem).a();
            }
            return graphQLIncomingFriendRequestFeedUnitItem;
        }
    }

    /* compiled from: flac-compression-level */
    public final class Serializer extends JsonSerializer<GraphQLIncomingFriendRequestFeedUnitItem> {
        public final void m8662a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLIncomingFriendRequestFeedUnitItem graphQLIncomingFriendRequestFeedUnitItem = (GraphQLIncomingFriendRequestFeedUnitItem) obj;
            GraphQLIncomingFriendRequestFeedUnitItemDeserializer.m5240b(graphQLIncomingFriendRequestFeedUnitItem.w_(), graphQLIncomingFriendRequestFeedUnitItem.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLIncomingFriendRequestFeedUnitItem.class, new Serializer());
            FbSerializerProvider.a(GraphQLIncomingFriendRequestFeedUnitItem.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLUser m8664a() {
        this.f4298d = (GraphQLUser) super.a(this.f4298d, 0, GraphQLUser.class);
        return this.f4298d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m8666j() {
        this.f4299e = (GraphQLTextWithEntities) super.a(this.f4299e, 1, GraphQLTextWithEntities.class);
        return this.f4299e;
    }

    @FieldOffset
    @Nullable
    public final String m8667k() {
        this.f4300f = super.a(this.f4300f, 2);
        return this.f4300f;
    }

    public final int jK_() {
        return 2103125376;
    }

    public final GraphQLVisitableModel m8665a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8664a() != null) {
            GraphQLUser graphQLUser = (GraphQLUser) graphQLModelMutatingVisitor.b(m8664a());
            if (m8664a() != graphQLUser) {
                graphQLVisitableModel = (GraphQLIncomingFriendRequestFeedUnitItem) ModelHelper.a(null, this);
                graphQLVisitableModel.f4298d = graphQLUser;
            }
        }
        if (m8666j() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m8666j());
            if (m8666j() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLIncomingFriendRequestFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4299e = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLIncomingFriendRequestFeedUnitItem() {
        super(4);
    }

    public final int m8663a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8664a());
        int a2 = ModelHelper.a(flatBufferBuilder, m8666j());
        int b = flatBufferBuilder.b(m8667k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLIncomingFriendRequestFeedUnitItem(Parcel parcel) {
        super(4);
        this.f4298d = (GraphQLUser) parcel.readValue(GraphQLUser.class.getClassLoader());
        this.f4299e = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f4300f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m8664a());
        parcel.writeValue(m8666j());
        parcel.writeString(m8667k());
    }
}
