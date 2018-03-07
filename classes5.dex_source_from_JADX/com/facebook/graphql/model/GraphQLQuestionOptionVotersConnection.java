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
import com.facebook.graphql.deserializers.GraphQLQuestionOptionVotersConnectionDeserializer;
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
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: VIEW_STORY */
public final class GraphQLQuestionOptionVotersConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLQuestionOptionVotersConnection> CREATOR = new C11901();
    public int f12839d;
    public List<GraphQLUser> f12840e;
    @Nullable
    public GraphQLPageInfo f12841f;

    /* compiled from: VIEW_STORY */
    final class C11901 implements Creator<GraphQLQuestionOptionVotersConnection> {
        C11901() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLQuestionOptionVotersConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLQuestionOptionVotersConnection[i];
        }
    }

    /* compiled from: VIEW_STORY */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        public int f12836d;
        public ImmutableList<GraphQLUser> f12837e;
        @Nullable
        public GraphQLPageInfo f12838f;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }

        public final Builder m21167a(int i) {
            this.f12836d = i;
            if (this.a != null && this.a.d) {
                this.a.b(this.b, 0, i);
            }
            return this;
        }

        public final GraphQLQuestionOptionVotersConnection m21168a() {
            return new GraphQLQuestionOptionVotersConnection(this);
        }
    }

    /* compiled from: VIEW_STORY */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLQuestionOptionVotersConnection.class, new Deserializer());
        }

        public Object m21169a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLQuestionOptionVotersConnectionDeserializer.m5738a(jsonParser, (short) 237);
            Object graphQLQuestionOptionVotersConnection = new GraphQLQuestionOptionVotersConnection();
            ((BaseModel) graphQLQuestionOptionVotersConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLQuestionOptionVotersConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLQuestionOptionVotersConnection).a();
            }
            return graphQLQuestionOptionVotersConnection;
        }
    }

    /* compiled from: VIEW_STORY */
    public final class Serializer extends JsonSerializer<GraphQLQuestionOptionVotersConnection> {
        public final void m21170a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLQuestionOptionVotersConnection graphQLQuestionOptionVotersConnection = (GraphQLQuestionOptionVotersConnection) obj;
            GraphQLQuestionOptionVotersConnectionDeserializer.m5739a(graphQLQuestionOptionVotersConnection.w_(), graphQLQuestionOptionVotersConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLQuestionOptionVotersConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLQuestionOptionVotersConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final int m21171a() {
        a(0, 0);
        return this.f12839d;
    }

    final void m21174a(int i) {
        this.f12839d = i;
        if (this.b != null && this.b.d) {
            this.b.b(this.c, 0, i);
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLUser> m21176j() {
        this.f12840e = super.a(this.f12840e, 1, GraphQLUser.class);
        return (ImmutableList) this.f12840e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m21177k() {
        this.f12841f = (GraphQLPageInfo) super.a(this.f12841f, 2, GraphQLPageInfo.class);
        return this.f12841f;
    }

    public final int jK_() {
        return 280409636;
    }

    public final GraphQLVisitableModel m21173a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        h();
        if (m21176j() != null) {
            com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m21176j(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLQuestionOptionVotersConnection graphQLQuestionOptionVotersConnection = (GraphQLQuestionOptionVotersConnection) ModelHelper.a(null, this);
                graphQLQuestionOptionVotersConnection.f12840e = a.b();
                graphQLVisitableModel = graphQLQuestionOptionVotersConnection;
                if (m21177k() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m21177k());
                    if (m21177k() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLQuestionOptionVotersConnection) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12841f = graphQLPageInfo;
                    }
                }
                i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m21177k() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m21177k());
            if (m21177k() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLQuestionOptionVotersConnection) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12841f = graphQLPageInfo;
            }
        }
        i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLQuestionOptionVotersConnection() {
        super(4);
    }

    public final void m21175a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f12839d = mutableFlatBuffer.a(i, 0, 0);
    }

    public final int m21172a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21176j());
        int a2 = ModelHelper.a(flatBufferBuilder, m21177k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.a(0, m21171a(), 0);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, a2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLQuestionOptionVotersConnection(Parcel parcel) {
        super(4);
        this.f12839d = parcel.readInt();
        this.f12840e = ImmutableListHelper.a(parcel.readArrayList(GraphQLUser.class.getClassLoader()));
        this.f12841f = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m21171a());
        parcel.writeList(m21176j());
        parcel.writeValue(m21177k());
    }

    public GraphQLQuestionOptionVotersConnection(Builder builder) {
        super(4);
        this.b = builder.a;
        this.c = builder.b;
        this.f12839d = builder.f12836d;
        this.f12840e = builder.f12837e;
        this.f12841f = builder.f12838f;
    }
}
