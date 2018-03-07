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
import com.facebook.graphql.deserializers.GraphQLAdditionalSuggestedPostAdItemsEdgeDeserializer;
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
/* compiled from: label */
public final class GraphQLAdditionalSuggestedPostAdItemsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLAdditionalSuggestedPostAdItemsEdge> CREATOR = new C02591();
    @Nullable
    public GraphQLStorySetItem f3306d;

    /* compiled from: label */
    final class C02591 implements Creator<GraphQLAdditionalSuggestedPostAdItemsEdge> {
        C02591() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLAdditionalSuggestedPostAdItemsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLAdditionalSuggestedPostAdItemsEdge[i];
        }
    }

    /* compiled from: label */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLAdditionalSuggestedPostAdItemsEdge.class, new Deserializer());
        }

        public Object m6455a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLAdditionalSuggestedPostAdItemsEdgeDeserializer.m4532a(jsonParser, (short) 383);
            Object graphQLAdditionalSuggestedPostAdItemsEdge = new GraphQLAdditionalSuggestedPostAdItemsEdge();
            ((BaseModel) graphQLAdditionalSuggestedPostAdItemsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLAdditionalSuggestedPostAdItemsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLAdditionalSuggestedPostAdItemsEdge).a();
            }
            return graphQLAdditionalSuggestedPostAdItemsEdge;
        }
    }

    /* compiled from: label */
    public final class Serializer extends JsonSerializer<GraphQLAdditionalSuggestedPostAdItemsEdge> {
        public final void m6456a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLAdditionalSuggestedPostAdItemsEdge graphQLAdditionalSuggestedPostAdItemsEdge = (GraphQLAdditionalSuggestedPostAdItemsEdge) obj;
            GraphQLAdditionalSuggestedPostAdItemsEdgeDeserializer.m4533b(graphQLAdditionalSuggestedPostAdItemsEdge.w_(), graphQLAdditionalSuggestedPostAdItemsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLAdditionalSuggestedPostAdItemsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLAdditionalSuggestedPostAdItemsEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLStorySetItem m6458a() {
        this.f3306d = (GraphQLStorySetItem) super.a(this.f3306d, 0, GraphQLStorySetItem.class);
        return this.f3306d;
    }

    public final int jK_() {
        return -1500662338;
    }

    public final GraphQLVisitableModel m6459a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6458a() != null) {
            GraphQLStorySetItem graphQLStorySetItem = (GraphQLStorySetItem) graphQLModelMutatingVisitor.b(m6458a());
            if (m6458a() != graphQLStorySetItem) {
                graphQLVisitableModel = (GraphQLAdditionalSuggestedPostAdItemsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f3306d = graphQLStorySetItem;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLAdditionalSuggestedPostAdItemsEdge() {
        super(2);
    }

    public final int m6457a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m6458a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLAdditionalSuggestedPostAdItemsEdge(Parcel parcel) {
        super(2);
        this.f3306d = (GraphQLStorySetItem) parcel.readValue(GraphQLStorySetItem.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m6458a());
    }
}
