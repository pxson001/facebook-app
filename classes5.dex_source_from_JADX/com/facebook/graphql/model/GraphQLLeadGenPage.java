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
import com.facebook.graphql.deserializers.GraphQLLeadGenPageDeserializer;
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
/* compiled from: feed_inline */
public final class GraphQLLeadGenPage extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLLeadGenPage> CREATOR = new C04251();
    public List<GraphQLLeadGenInfoFieldData> f4389d;
    public List<GraphQLLeadGenPrivacyNode> f4390e;

    /* compiled from: feed_inline */
    final class C04251 implements Creator<GraphQLLeadGenPage> {
        C04251() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLLeadGenPage(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLLeadGenPage[i];
        }
    }

    /* compiled from: feed_inline */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLLeadGenPage.class, new Deserializer());
        }

        public Object m8884a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLLeadGenPageDeserializer.m5306a(jsonParser, (short) 170);
            Object graphQLLeadGenPage = new GraphQLLeadGenPage();
            ((BaseModel) graphQLLeadGenPage).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLLeadGenPage instanceof Postprocessable) {
                return ((Postprocessable) graphQLLeadGenPage).a();
            }
            return graphQLLeadGenPage;
        }
    }

    /* compiled from: feed_inline */
    public final class Serializer extends JsonSerializer<GraphQLLeadGenPage> {
        public final void m8885a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLLeadGenPage graphQLLeadGenPage = (GraphQLLeadGenPage) obj;
            GraphQLLeadGenPageDeserializer.m5308b(graphQLLeadGenPage.w_(), graphQLLeadGenPage.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLLeadGenPage.class, new Serializer());
            FbSerializerProvider.a(GraphQLLeadGenPage.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLLeadGenInfoFieldData> m8888a() {
        this.f4389d = super.a(this.f4389d, 0, GraphQLLeadGenInfoFieldData.class);
        return (ImmutableList) this.f4389d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLLeadGenPrivacyNode> m8889j() {
        this.f4390e = super.a(this.f4390e, 1, GraphQLLeadGenPrivacyNode.class);
        return (ImmutableList) this.f4390e;
    }

    public final int jK_() {
        return -1255530781;
    }

    public final GraphQLVisitableModel m8887a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8888a() != null) {
            a = ModelHelper.a(m8888a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLLeadGenPage) ModelHelper.a(null, this);
                graphQLVisitableModel.f4389d = a.b();
            }
        }
        if (m8889j() != null) {
            a = ModelHelper.a(m8889j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLLeadGenPage) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4390e = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLLeadGenPage() {
        super(3);
    }

    public final int m8886a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8888a());
        int a2 = ModelHelper.a(flatBufferBuilder, m8889j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLLeadGenPage(Parcel parcel) {
        super(3);
        this.f4389d = ImmutableListHelper.a(parcel.readArrayList(GraphQLLeadGenInfoFieldData.class.getClassLoader()));
        this.f4390e = ImmutableListHelper.a(parcel.readArrayList(GraphQLLeadGenPrivacyNode.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m8888a());
        parcel.writeList(m8889j());
    }
}
