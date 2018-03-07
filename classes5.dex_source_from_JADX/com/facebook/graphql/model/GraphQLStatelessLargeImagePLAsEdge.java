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
import com.facebook.graphql.deserializers.GraphQLStatelessLargeImagePLAsEdgeDeserializer;
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
/* compiled from: Unexpected icon size. Use getLauncherIconSize() to get the proper size of an icon */
public final class GraphQLStatelessLargeImagePLAsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLStatelessLargeImagePLAsEdge> CREATOR = new C12371();
    @Nullable
    public GraphQLPYMLWithLargeImageFeedUnitItem f13075d;

    /* compiled from: Unexpected icon size. Use getLauncherIconSize() to get the proper size of an icon */
    final class C12371 implements Creator<GraphQLStatelessLargeImagePLAsEdge> {
        C12371() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLStatelessLargeImagePLAsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLStatelessLargeImagePLAsEdge[i];
        }
    }

    /* compiled from: Unexpected icon size. Use getLauncherIconSize() to get the proper size of an icon */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLStatelessLargeImagePLAsEdge.class, new Deserializer());
        }

        public Object m21823a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLStatelessLargeImagePLAsEdgeDeserializer.m5943a(jsonParser, (short) 381);
            Object graphQLStatelessLargeImagePLAsEdge = new GraphQLStatelessLargeImagePLAsEdge();
            ((BaseModel) graphQLStatelessLargeImagePLAsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLStatelessLargeImagePLAsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLStatelessLargeImagePLAsEdge).a();
            }
            return graphQLStatelessLargeImagePLAsEdge;
        }
    }

    /* compiled from: Unexpected icon size. Use getLauncherIconSize() to get the proper size of an icon */
    public final class Serializer extends JsonSerializer<GraphQLStatelessLargeImagePLAsEdge> {
        public final void m21824a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLStatelessLargeImagePLAsEdge graphQLStatelessLargeImagePLAsEdge = (GraphQLStatelessLargeImagePLAsEdge) obj;
            GraphQLStatelessLargeImagePLAsEdgeDeserializer.m5944b(graphQLStatelessLargeImagePLAsEdge.w_(), graphQLStatelessLargeImagePLAsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLStatelessLargeImagePLAsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLStatelessLargeImagePLAsEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLPYMLWithLargeImageFeedUnitItem m21826a() {
        this.f13075d = (GraphQLPYMLWithLargeImageFeedUnitItem) super.a(this.f13075d, 0, GraphQLPYMLWithLargeImageFeedUnitItem.class);
        return this.f13075d;
    }

    public final int jK_() {
        return -502531019;
    }

    public final GraphQLVisitableModel m21827a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21826a() != null) {
            GraphQLPYMLWithLargeImageFeedUnitItem graphQLPYMLWithLargeImageFeedUnitItem = (GraphQLPYMLWithLargeImageFeedUnitItem) graphQLModelMutatingVisitor.b(m21826a());
            if (m21826a() != graphQLPYMLWithLargeImageFeedUnitItem) {
                graphQLVisitableModel = (GraphQLStatelessLargeImagePLAsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f13075d = graphQLPYMLWithLargeImageFeedUnitItem;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLStatelessLargeImagePLAsEdge() {
        super(2);
    }

    public final int m21825a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21826a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLStatelessLargeImagePLAsEdge(Parcel parcel) {
        super(2);
        this.f13075d = (GraphQLPYMLWithLargeImageFeedUnitItem) parcel.readValue(GraphQLPYMLWithLargeImageFeedUnitItem.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m21826a());
    }
}
