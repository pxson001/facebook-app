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
import com.facebook.graphql.deserializers.GraphQLTrueTopicFeedOptionsConnectionDeserializer;
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
/* compiled from: Transcode to Jpeg invoked when isAvailable() returns false */
public final class GraphQLTrueTopicFeedOptionsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLTrueTopicFeedOptionsConnection> CREATOR = new C12621();
    public List<GraphQLTrueTopicFeedOptionsEdge> f13372d;

    /* compiled from: Transcode to Jpeg invoked when isAvailable() returns false */
    final class C12621 implements Creator<GraphQLTrueTopicFeedOptionsConnection> {
        C12621() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLTrueTopicFeedOptionsConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLTrueTopicFeedOptionsConnection[i];
        }
    }

    /* compiled from: Transcode to Jpeg invoked when isAvailable() returns false */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLTrueTopicFeedOptionsConnection.class, new Deserializer());
        }

        public Object m22321a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLTrueTopicFeedOptionsConnectionDeserializer.m6134a(jsonParser, (short) 532);
            Object graphQLTrueTopicFeedOptionsConnection = new GraphQLTrueTopicFeedOptionsConnection();
            ((BaseModel) graphQLTrueTopicFeedOptionsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLTrueTopicFeedOptionsConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLTrueTopicFeedOptionsConnection).a();
            }
            return graphQLTrueTopicFeedOptionsConnection;
        }
    }

    /* compiled from: Transcode to Jpeg invoked when isAvailable() returns false */
    public final class Serializer extends JsonSerializer<GraphQLTrueTopicFeedOptionsConnection> {
        public final void m22322a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLTrueTopicFeedOptionsConnection graphQLTrueTopicFeedOptionsConnection = (GraphQLTrueTopicFeedOptionsConnection) obj;
            GraphQLTrueTopicFeedOptionsConnectionDeserializer.m6135a(graphQLTrueTopicFeedOptionsConnection.w_(), graphQLTrueTopicFeedOptionsConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLTrueTopicFeedOptionsConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLTrueTopicFeedOptionsConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLTrueTopicFeedOptionsEdge> m22325a() {
        this.f13372d = super.a(this.f13372d, 0, GraphQLTrueTopicFeedOptionsEdge.class);
        return (ImmutableList) this.f13372d;
    }

    public final int jK_() {
        return -2118660995;
    }

    public final GraphQLVisitableModel m22324a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m22325a() != null) {
            Builder a = ModelHelper.a(m22325a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLTrueTopicFeedOptionsConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f13372d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLTrueTopicFeedOptionsConnection() {
        super(2);
    }

    public final int m22323a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m22325a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLTrueTopicFeedOptionsConnection(Parcel parcel) {
        super(2);
        this.f13372d = ImmutableListHelper.a(parcel.readArrayList(GraphQLTrueTopicFeedOptionsEdge.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m22325a());
    }
}
