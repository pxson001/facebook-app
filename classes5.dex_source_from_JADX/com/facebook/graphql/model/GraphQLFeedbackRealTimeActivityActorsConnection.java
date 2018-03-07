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
import com.facebook.graphql.deserializers.GraphQLFeedbackRealTimeActivityActorsConnectionDeserializer;
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
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: hintScreenTimeout */
public final class GraphQLFeedbackRealTimeActivityActorsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLFeedbackRealTimeActivityActorsConnection> CREATOR = new C03231();
    public List<GraphQLActor> f3768d;

    /* compiled from: hintScreenTimeout */
    final class C03231 implements Creator<GraphQLFeedbackRealTimeActivityActorsConnection> {
        C03231() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLFeedbackRealTimeActivityActorsConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLFeedbackRealTimeActivityActorsConnection[i];
        }
    }

    /* compiled from: hintScreenTimeout */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        public ImmutableList<GraphQLActor> f3767d;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }
    }

    /* compiled from: hintScreenTimeout */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLFeedbackRealTimeActivityActorsConnection.class, new Deserializer());
        }

        public Object m7492a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLFeedbackRealTimeActivityActorsConnectionDeserializer.m4905a(jsonParser, (short) 213);
            Object graphQLFeedbackRealTimeActivityActorsConnection = new GraphQLFeedbackRealTimeActivityActorsConnection();
            ((BaseModel) graphQLFeedbackRealTimeActivityActorsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLFeedbackRealTimeActivityActorsConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLFeedbackRealTimeActivityActorsConnection).a();
            }
            return graphQLFeedbackRealTimeActivityActorsConnection;
        }
    }

    /* compiled from: hintScreenTimeout */
    public final class Serializer extends JsonSerializer<GraphQLFeedbackRealTimeActivityActorsConnection> {
        public final void m7493a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLFeedbackRealTimeActivityActorsConnection graphQLFeedbackRealTimeActivityActorsConnection = (GraphQLFeedbackRealTimeActivityActorsConnection) obj;
            GraphQLFeedbackRealTimeActivityActorsConnectionDeserializer.m4906a(graphQLFeedbackRealTimeActivityActorsConnection.w_(), graphQLFeedbackRealTimeActivityActorsConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLFeedbackRealTimeActivityActorsConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLFeedbackRealTimeActivityActorsConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLActor> m7496a() {
        this.f3768d = super.a(this.f3768d, 0, GraphQLActor.class);
        return (ImmutableList) this.f3768d;
    }

    public final int jK_() {
        return 1841524795;
    }

    public final GraphQLVisitableModel m7495a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7496a() != null) {
            com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m7496a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLFeedbackRealTimeActivityActorsConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f3768d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLFeedbackRealTimeActivityActorsConnection() {
        super(2);
    }

    public final int m7494a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7496a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLFeedbackRealTimeActivityActorsConnection(Parcel parcel) {
        super(2);
        this.f3768d = ImmutableListHelper.a(parcel.readArrayList(GraphQLActor.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m7496a());
    }

    public GraphQLFeedbackRealTimeActivityActorsConnection(Builder builder) {
        super(2);
        this.b = builder.a;
        this.c = builder.b;
        this.f3768d = builder.f3767d;
    }
}
