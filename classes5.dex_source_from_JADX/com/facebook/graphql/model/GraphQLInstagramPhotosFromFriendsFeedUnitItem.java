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
import com.facebook.graphql.deserializers.GraphQLInstagramPhotosFromFriendsFeedUnitItemDeserializer;
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
/* compiled from: filter_values */
public final class GraphQLInstagramPhotosFromFriendsFeedUnitItem extends BaseModel implements ItemListFeedUnitItem, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLInstagramPhotosFromFriendsFeedUnitItem> CREATOR = new C04191();
    List<GraphQLPhoto> f4312d;
    @Nullable
    GraphQLProfile f4313e;
    @Nullable
    String f4314f;
    @Nullable
    String f4315g;

    /* compiled from: filter_values */
    final class C04191 implements Creator<GraphQLInstagramPhotosFromFriendsFeedUnitItem> {
        C04191() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLInstagramPhotosFromFriendsFeedUnitItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLInstagramPhotosFromFriendsFeedUnitItem[i];
        }
    }

    /* compiled from: filter_values */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLInstagramPhotosFromFriendsFeedUnitItem.class, new Deserializer());
        }

        public Object m8708a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLInstagramPhotosFromFriendsFeedUnitItemDeserializer.m5258a(jsonParser, (short) 332);
            Object graphQLInstagramPhotosFromFriendsFeedUnitItem = new GraphQLInstagramPhotosFromFriendsFeedUnitItem();
            ((BaseModel) graphQLInstagramPhotosFromFriendsFeedUnitItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLInstagramPhotosFromFriendsFeedUnitItem instanceof Postprocessable) {
                return ((Postprocessable) graphQLInstagramPhotosFromFriendsFeedUnitItem).a();
            }
            return graphQLInstagramPhotosFromFriendsFeedUnitItem;
        }
    }

    /* compiled from: filter_values */
    public final class Serializer extends JsonSerializer<GraphQLInstagramPhotosFromFriendsFeedUnitItem> {
        public final void m8709a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLInstagramPhotosFromFriendsFeedUnitItem graphQLInstagramPhotosFromFriendsFeedUnitItem = (GraphQLInstagramPhotosFromFriendsFeedUnitItem) obj;
            GraphQLInstagramPhotosFromFriendsFeedUnitItemDeserializer.m5261b(graphQLInstagramPhotosFromFriendsFeedUnitItem.w_(), graphQLInstagramPhotosFromFriendsFeedUnitItem.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLInstagramPhotosFromFriendsFeedUnitItem.class, new Serializer());
            FbSerializerProvider.a(GraphQLInstagramPhotosFromFriendsFeedUnitItem.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLPhoto> m8712a() {
        this.f4312d = super.a(this.f4312d, 0, GraphQLPhoto.class);
        return (ImmutableList) this.f4312d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile m8713j() {
        this.f4313e = (GraphQLProfile) super.a(this.f4313e, 1, GraphQLProfile.class);
        return this.f4313e;
    }

    @FieldOffset
    @Nullable
    public final String m8714k() {
        this.f4314f = super.a(this.f4314f, 2);
        return this.f4314f;
    }

    @FieldOffset
    @Nullable
    public final String m8715l() {
        this.f4315g = super.a(this.f4315g, 3);
        return this.f4315g;
    }

    public final int jK_() {
        return -750412691;
    }

    public final GraphQLVisitableModel m8711a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLProfile graphQLProfile;
        h();
        if (m8712a() != null) {
            Builder a = ModelHelper.a(m8712a(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLInstagramPhotosFromFriendsFeedUnitItem graphQLInstagramPhotosFromFriendsFeedUnitItem = (GraphQLInstagramPhotosFromFriendsFeedUnitItem) ModelHelper.a(null, this);
                graphQLInstagramPhotosFromFriendsFeedUnitItem.f4312d = a.b();
                graphQLVisitableModel = graphQLInstagramPhotosFromFriendsFeedUnitItem;
                if (m8713j() != null) {
                    graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.b(m8713j());
                    if (m8713j() != graphQLProfile) {
                        graphQLVisitableModel = (GraphQLInstagramPhotosFromFriendsFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4313e = graphQLProfile;
                    }
                }
                i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m8713j() != null) {
            graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.b(m8713j());
            if (m8713j() != graphQLProfile) {
                graphQLVisitableModel = (GraphQLInstagramPhotosFromFriendsFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4313e = graphQLProfile;
            }
        }
        i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLInstagramPhotosFromFriendsFeedUnitItem() {
        super(5);
    }

    public final int m8710a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8712a());
        int a2 = ModelHelper.a(flatBufferBuilder, m8713j());
        int b = flatBufferBuilder.b(m8714k());
        int b2 = flatBufferBuilder.b(m8715l());
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, b);
        flatBufferBuilder.b(3, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLInstagramPhotosFromFriendsFeedUnitItem(Parcel parcel) {
        super(5);
        this.f4315g = parcel.readString();
        this.f4312d = ImmutableListHelper.a(parcel.readArrayList(GraphQLPhoto.class.getClassLoader()));
        this.f4313e = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
        this.f4314f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m8715l());
        parcel.writeList(m8712a());
        parcel.writeValue(m8713j());
        parcel.writeString(m8714k());
    }
}
