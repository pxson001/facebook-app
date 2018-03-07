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
import com.facebook.graphql.deserializers.GraphQLNativeTemplateViewDeserializer;
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
/* compiled from: external_connect */
public final class GraphQLNativeTemplateView extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLNativeTemplateView> CREATOR = new C04411();
    public List<GraphQLNativeTemplateBundle> f4530d;

    /* compiled from: external_connect */
    final class C04411 implements Creator<GraphQLNativeTemplateView> {
        C04411() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLNativeTemplateView(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLNativeTemplateView[i];
        }
    }

    /* compiled from: external_connect */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLNativeTemplateView.class, new Deserializer());
        }

        public Object m9177a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLNativeTemplateViewDeserializer.m5401a(jsonParser, (short) 553);
            Object graphQLNativeTemplateView = new GraphQLNativeTemplateView();
            ((BaseModel) graphQLNativeTemplateView).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLNativeTemplateView instanceof Postprocessable) {
                return ((Postprocessable) graphQLNativeTemplateView).a();
            }
            return graphQLNativeTemplateView;
        }
    }

    /* compiled from: external_connect */
    public final class Serializer extends JsonSerializer<GraphQLNativeTemplateView> {
        public final void m9178a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLNativeTemplateView graphQLNativeTemplateView = (GraphQLNativeTemplateView) obj;
            GraphQLNativeTemplateViewDeserializer.m5402a(graphQLNativeTemplateView.w_(), graphQLNativeTemplateView.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLNativeTemplateView.class, new Serializer());
            FbSerializerProvider.a(GraphQLNativeTemplateView.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLNativeTemplateBundle> m9181a() {
        this.f4530d = super.a(this.f4530d, 4, GraphQLNativeTemplateBundle.class);
        return (ImmutableList) this.f4530d;
    }

    public final int jK_() {
        return -1955355626;
    }

    public final GraphQLVisitableModel m9180a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m9181a() != null) {
            Builder a = ModelHelper.a(m9181a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLNativeTemplateView) ModelHelper.a(null, this);
                graphQLVisitableModel.f4530d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLNativeTemplateView() {
        super(6);
    }

    public final int m9179a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m9181a());
        flatBufferBuilder.c(5);
        flatBufferBuilder.b(4, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLNativeTemplateView(Parcel parcel) {
        super(6);
        this.f4530d = ImmutableListHelper.a(parcel.readArrayList(GraphQLNativeTemplateBundle.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m9181a());
    }
}
