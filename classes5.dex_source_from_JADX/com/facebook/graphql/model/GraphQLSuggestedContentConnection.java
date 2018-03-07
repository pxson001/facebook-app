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
import com.facebook.graphql.deserializers.GraphQLSuggestedContentConnectionDeserializer;
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
/* compiled from: UPHOLSTERY_SERVICE */
public final class GraphQLSuggestedContentConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLSuggestedContentConnection> CREATOR = new C12461();
    public List<GraphQLStoryAttachment> f13231d;

    /* compiled from: UPHOLSTERY_SERVICE */
    final class C12461 implements Creator<GraphQLSuggestedContentConnection> {
        C12461() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSuggestedContentConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSuggestedContentConnection[i];
        }
    }

    /* compiled from: UPHOLSTERY_SERVICE */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLSuggestedContentConnection.class, new Deserializer());
        }

        public Object m22010a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLSuggestedContentConnectionDeserializer.m6018a(jsonParser, (short) 321);
            Object graphQLSuggestedContentConnection = new GraphQLSuggestedContentConnection();
            ((BaseModel) graphQLSuggestedContentConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLSuggestedContentConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLSuggestedContentConnection).a();
            }
            return graphQLSuggestedContentConnection;
        }
    }

    /* compiled from: UPHOLSTERY_SERVICE */
    public final class Serializer extends JsonSerializer<GraphQLSuggestedContentConnection> {
        public final void m22011a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLSuggestedContentConnection graphQLSuggestedContentConnection = (GraphQLSuggestedContentConnection) obj;
            GraphQLSuggestedContentConnectionDeserializer.m6019a(graphQLSuggestedContentConnection.w_(), graphQLSuggestedContentConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLSuggestedContentConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLSuggestedContentConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachment> m22014a() {
        this.f13231d = super.a(this.f13231d, 0, GraphQLStoryAttachment.class);
        return (ImmutableList) this.f13231d;
    }

    public final int jK_() {
        return -405108876;
    }

    public final GraphQLVisitableModel m22013a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m22014a() != null) {
            Builder a = ModelHelper.a(m22014a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLSuggestedContentConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f13231d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLSuggestedContentConnection() {
        super(2);
    }

    public final int m22012a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m22014a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLSuggestedContentConnection(Parcel parcel) {
        super(2);
        this.f13231d = ImmutableListHelper.a(parcel.readArrayList(GraphQLStoryAttachment.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m22014a());
    }
}
