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
import com.facebook.graphql.deserializers.GraphQLNativeTemplateDefaultViewControllerDeserializer;
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
/* compiled from: external_url */
public final class GraphQLNativeTemplateDefaultViewController extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLNativeTemplateDefaultViewController> CREATOR = new C04401();
    @Nullable
    public String f4525d;
    @Nullable
    public String f4526e;
    public boolean f4527f;
    @Nullable
    public String f4528g;
    @Nullable
    public GraphQLNativeTemplateView f4529h;

    /* compiled from: external_url */
    final class C04401 implements Creator<GraphQLNativeTemplateDefaultViewController> {
        C04401() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLNativeTemplateDefaultViewController(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLNativeTemplateDefaultViewController[i];
        }
    }

    /* compiled from: external_url */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLNativeTemplateDefaultViewController.class, new Deserializer());
        }

        public Object m9165a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLNativeTemplateDefaultViewControllerDeserializer.m5395a(jsonParser, (short) 571);
            Object graphQLNativeTemplateDefaultViewController = new GraphQLNativeTemplateDefaultViewController();
            ((BaseModel) graphQLNativeTemplateDefaultViewController).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLNativeTemplateDefaultViewController instanceof Postprocessable) {
                return ((Postprocessable) graphQLNativeTemplateDefaultViewController).a();
            }
            return graphQLNativeTemplateDefaultViewController;
        }
    }

    /* compiled from: external_url */
    public final class Serializer extends JsonSerializer<GraphQLNativeTemplateDefaultViewController> {
        public final void m9166a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLNativeTemplateDefaultViewController graphQLNativeTemplateDefaultViewController = (GraphQLNativeTemplateDefaultViewController) obj;
            GraphQLNativeTemplateDefaultViewControllerDeserializer.m5396a(graphQLNativeTemplateDefaultViewController.w_(), graphQLNativeTemplateDefaultViewController.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLNativeTemplateDefaultViewController.class, new Serializer());
            FbSerializerProvider.a(GraphQLNativeTemplateDefaultViewController.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m9169a() {
        this.f4525d = super.a(this.f4525d, 0);
        return this.f4525d;
    }

    @FieldOffset
    @Nullable
    public final String m9171j() {
        this.f4526e = super.a(this.f4526e, 1);
        return this.f4526e;
    }

    @FieldOffset
    public final boolean m9172k() {
        a(0, 2);
        return this.f4527f;
    }

    @FieldOffset
    @Nullable
    public final String m9173l() {
        this.f4528g = super.a(this.f4528g, 3);
        return this.f4528g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNativeTemplateView m9174m() {
        this.f4529h = (GraphQLNativeTemplateView) super.a(this.f4529h, 4, GraphQLNativeTemplateView.class);
        return this.f4529h;
    }

    public final int jK_() {
        return 2033701745;
    }

    public final GraphQLVisitableModel m9168a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m9174m() != null) {
            GraphQLNativeTemplateView graphQLNativeTemplateView = (GraphQLNativeTemplateView) graphQLModelMutatingVisitor.b(m9174m());
            if (m9174m() != graphQLNativeTemplateView) {
                graphQLVisitableModel = (GraphQLNativeTemplateDefaultViewController) ModelHelper.a(null, this);
                graphQLVisitableModel.f4529h = graphQLNativeTemplateView;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLNativeTemplateDefaultViewController() {
        super(6);
    }

    public final void m9170a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f4527f = mutableFlatBuffer.a(i, 2);
    }

    public final int m9167a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m9169a());
        int b2 = flatBufferBuilder.b(m9171j());
        int b3 = flatBufferBuilder.b(m9173l());
        int a = ModelHelper.a(flatBufferBuilder, m9174m());
        flatBufferBuilder.c(5);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.a(2, m9172k());
        flatBufferBuilder.b(3, b3);
        flatBufferBuilder.b(4, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLNativeTemplateDefaultViewController(Parcel parcel) {
        boolean z = true;
        super(6);
        this.f4525d = parcel.readString();
        this.f4526e = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f4527f = z;
        this.f4528g = parcel.readString();
        this.f4529h = (GraphQLNativeTemplateView) parcel.readValue(GraphQLNativeTemplateView.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m9169a());
        parcel.writeString(m9171j());
        parcel.writeByte((byte) (m9172k() ? 1 : 0));
        parcel.writeString(m9173l());
        parcel.writeValue(m9174m());
    }
}
