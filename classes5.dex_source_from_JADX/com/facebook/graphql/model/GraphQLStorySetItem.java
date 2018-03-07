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
import com.facebook.graphql.deserializers.GraphQLStorySetItemDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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
/* compiled from: USE_MOBILE_APP */
public final class GraphQLStorySetItem extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLStorySetItem> CREATOR = new C12411();
    @Nullable
    String f13193d;
    @Nullable
    GraphQLStory f13194e;
    @Nullable
    String f13195f;

    /* compiled from: USE_MOBILE_APP */
    final class C12411 implements Creator<GraphQLStorySetItem> {
        C12411() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLStorySetItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLStorySetItem[i];
        }
    }

    /* compiled from: USE_MOBILE_APP */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLStorySetItem.class, new Deserializer());
        }

        public Object m21893a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLStorySetItemDeserializer.m5983a(jsonParser, (short) 31);
            Object graphQLStorySetItem = new GraphQLStorySetItem();
            ((BaseModel) graphQLStorySetItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLStorySetItem instanceof Postprocessable) {
                return ((Postprocessable) graphQLStorySetItem).a();
            }
            return graphQLStorySetItem;
        }
    }

    /* compiled from: USE_MOBILE_APP */
    public final class Serializer extends JsonSerializer<GraphQLStorySetItem> {
        public final void m21894a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLStorySetItem graphQLStorySetItem = (GraphQLStorySetItem) obj;
            GraphQLStorySetItemDeserializer.m5984a(graphQLStorySetItem.w_(), graphQLStorySetItem.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLStorySetItem.class, new Serializer());
            FbSerializerProvider.a(GraphQLStorySetItem.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m21898j() {
        this.f13193d = super.a(this.f13193d, 0);
        return this.f13193d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory m21899k() {
        this.f13194e = (GraphQLStory) super.a(this.f13194e, 1, GraphQLStory.class);
        return this.f13194e;
    }

    @FieldOffset
    @Nullable
    public final String m21900l() {
        this.f13195f = super.a(this.f13195f, 2);
        return this.f13195f;
    }

    @Nullable
    public final String m21897a() {
        return m21898j();
    }

    public final int jK_() {
        return -612528128;
    }

    public final GraphQLVisitableModel m21896a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21899k() != null) {
            GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m21899k());
            if (m21899k() != graphQLStory) {
                graphQLVisitableModel = (GraphQLStorySetItem) ModelHelper.a(null, this);
                graphQLVisitableModel.f13194e = graphQLStory;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLStorySetItem() {
        super(4);
    }

    public final int m21895a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m21898j());
        int a = ModelHelper.a(flatBufferBuilder, m21899k());
        int b2 = flatBufferBuilder.b(m21900l());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLStorySetItem(Parcel parcel) {
        super(4);
        this.f13193d = parcel.readString();
        this.f13194e = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
        this.f13195f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m21898j());
        parcel.writeValue(m21899k());
        parcel.writeString(m21900l());
    }
}
