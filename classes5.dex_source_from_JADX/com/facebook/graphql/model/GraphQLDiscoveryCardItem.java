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
import com.facebook.graphql.deserializers.GraphQLDiscoveryCardItemDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
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
/* compiled from: ios_place_picker_context_menu_suggest_edits */
public final class GraphQLDiscoveryCardItem extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLDiscoveryCardItem> CREATOR = new C02941();
    @Nullable
    public String f3513d;

    /* compiled from: ios_place_picker_context_menu_suggest_edits */
    final class C02941 implements Creator<GraphQLDiscoveryCardItem> {
        C02941() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLDiscoveryCardItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLDiscoveryCardItem[i];
        }
    }

    /* compiled from: ios_place_picker_context_menu_suggest_edits */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLDiscoveryCardItem.class, new Deserializer());
        }

        public Object m6942a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLDiscoveryCardItemDeserializer.m4713a(jsonParser, (short) 17);
            Object graphQLDiscoveryCardItem = new GraphQLDiscoveryCardItem();
            ((BaseModel) graphQLDiscoveryCardItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLDiscoveryCardItem instanceof Postprocessable) {
                return ((Postprocessable) graphQLDiscoveryCardItem).a();
            }
            return graphQLDiscoveryCardItem;
        }
    }

    /* compiled from: ios_place_picker_context_menu_suggest_edits */
    public final class Serializer extends JsonSerializer<GraphQLDiscoveryCardItem> {
        public final void m6943a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLDiscoveryCardItem graphQLDiscoveryCardItem = (GraphQLDiscoveryCardItem) obj;
            GraphQLDiscoveryCardItemDeserializer.m4714a(graphQLDiscoveryCardItem.w_(), graphQLDiscoveryCardItem.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLDiscoveryCardItem.class, new Serializer());
            FbSerializerProvider.a(GraphQLDiscoveryCardItem.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m6947j() {
        this.f3513d = super.a(this.f3513d, 0);
        return this.f3513d;
    }

    @Nullable
    public final String m6946a() {
        return m6947j();
    }

    public final int jK_() {
        return 1033493491;
    }

    public final GraphQLVisitableModel m6945a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLDiscoveryCardItem() {
        super(2);
    }

    public final int m6944a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m6947j());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLDiscoveryCardItem(Parcel parcel) {
        super(2);
        this.f3513d = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m6947j());
    }
}
