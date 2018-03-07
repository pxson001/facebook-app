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
import com.facebook.graphql.deserializers.GraphQLSuggestedVideoConnectionDeserializer;
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

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: UPDATE */
public final class GraphQLSuggestedVideoConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLSuggestedVideoConnection> CREATOR = new C12471();
    public List<GraphQLStoryAttachment> f13232d;

    /* compiled from: UPDATE */
    final class C12471 implements Creator<GraphQLSuggestedVideoConnection> {
        C12471() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSuggestedVideoConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSuggestedVideoConnection[i];
        }
    }

    /* compiled from: UPDATE */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLSuggestedVideoConnection.class, new Deserializer());
        }

        public Object m22019a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLSuggestedVideoConnectionDeserializer.m6021a(jsonParser, (short) 322);
            Object graphQLSuggestedVideoConnection = new GraphQLSuggestedVideoConnection();
            ((BaseModel) graphQLSuggestedVideoConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLSuggestedVideoConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLSuggestedVideoConnection).a();
            }
            return graphQLSuggestedVideoConnection;
        }
    }

    /* compiled from: UPDATE */
    public final class Serializer extends JsonSerializer<GraphQLSuggestedVideoConnection> {
        public final void m22020a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLSuggestedVideoConnection graphQLSuggestedVideoConnection = (GraphQLSuggestedVideoConnection) obj;
            GraphQLSuggestedVideoConnectionDeserializer.m6022a(graphQLSuggestedVideoConnection.w_(), graphQLSuggestedVideoConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLSuggestedVideoConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLSuggestedVideoConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachment> m22023a() {
        this.f13232d = super.a(this.f13232d, 0, GraphQLStoryAttachment.class);
        return (ImmutableList) this.f13232d;
    }

    public final int jK_() {
        return 1991538742;
    }

    public final GraphQLVisitableModel m22022a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m22023a() != null) {
            Builder a = ModelHelper.a(m22023a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLSuggestedVideoConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f13232d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLSuggestedVideoConnection() {
        super(2);
    }

    public final int m22021a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m22023a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLSuggestedVideoConnection(Parcel parcel) {
        super(2);
        this.f13232d = ImmutableListHelper.a(parcel.readArrayList(GraphQLStoryAttachment.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m22023a());
    }
}
