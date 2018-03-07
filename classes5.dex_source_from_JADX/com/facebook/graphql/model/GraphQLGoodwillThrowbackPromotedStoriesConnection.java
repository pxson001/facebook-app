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
import com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackPromotedStoriesConnectionDeserializer;
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
/* compiled from: getSoSNDTimeout */
public final class GraphQLGoodwillThrowbackPromotedStoriesConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGoodwillThrowbackPromotedStoriesConnection> CREATOR = new C03651();
    public List<GraphQLStory> f4031d;

    /* compiled from: getSoSNDTimeout */
    final class C03651 implements Creator<GraphQLGoodwillThrowbackPromotedStoriesConnection> {
        C03651() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGoodwillThrowbackPromotedStoriesConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGoodwillThrowbackPromotedStoriesConnection[i];
        }
    }

    /* compiled from: getSoSNDTimeout */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackPromotedStoriesConnection.class, new Deserializer());
        }

        public Object m8079a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGoodwillThrowbackPromotedStoriesConnectionDeserializer.m5060a(jsonParser, (short) 367);
            Object graphQLGoodwillThrowbackPromotedStoriesConnection = new GraphQLGoodwillThrowbackPromotedStoriesConnection();
            ((BaseModel) graphQLGoodwillThrowbackPromotedStoriesConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGoodwillThrowbackPromotedStoriesConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLGoodwillThrowbackPromotedStoriesConnection).a();
            }
            return graphQLGoodwillThrowbackPromotedStoriesConnection;
        }
    }

    /* compiled from: getSoSNDTimeout */
    public final class Serializer extends JsonSerializer<GraphQLGoodwillThrowbackPromotedStoriesConnection> {
        public final void m8080a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGoodwillThrowbackPromotedStoriesConnection graphQLGoodwillThrowbackPromotedStoriesConnection = (GraphQLGoodwillThrowbackPromotedStoriesConnection) obj;
            GraphQLGoodwillThrowbackPromotedStoriesConnectionDeserializer.m5061a(graphQLGoodwillThrowbackPromotedStoriesConnection.w_(), graphQLGoodwillThrowbackPromotedStoriesConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGoodwillThrowbackPromotedStoriesConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLGoodwillThrowbackPromotedStoriesConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLStory> m8083a() {
        this.f4031d = super.a(this.f4031d, 0, GraphQLStory.class);
        return (ImmutableList) this.f4031d;
    }

    public final int jK_() {
        return -2075989617;
    }

    public final GraphQLVisitableModel m8082a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8083a() != null) {
            Builder a = ModelHelper.a(m8083a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackPromotedStoriesConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f4031d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGoodwillThrowbackPromotedStoriesConnection() {
        super(2);
    }

    public final int m8081a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8083a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGoodwillThrowbackPromotedStoriesConnection(Parcel parcel) {
        super(2);
        this.f4031d = ImmutableListHelper.a(parcel.readArrayList(GraphQLStory.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m8083a());
    }
}
