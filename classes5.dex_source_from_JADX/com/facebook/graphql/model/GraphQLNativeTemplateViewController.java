package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLNativeTemplateViewControllerDeserializer;
import com.facebook.graphql.enums.GraphQLObjectType;
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
/* compiled from: extended_base_hash */
public final class GraphQLNativeTemplateViewController extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLNativeTemplateViewController> CREATOR = new C04421();
    @Nullable
    public GraphQLObjectType f4531d;
    @Nullable
    public String f4532e;
    @Nullable
    public String f4533f;
    public boolean f4534g;
    @Nullable
    public String f4535h;
    @Nullable
    public GraphQLNativeTemplateView f4536i;

    /* compiled from: extended_base_hash */
    final class C04421 implements Creator<GraphQLNativeTemplateViewController> {
        C04421() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLNativeTemplateViewController(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLNativeTemplateViewController[i];
        }
    }

    /* compiled from: extended_base_hash */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLNativeTemplateViewController.class, new Deserializer());
        }

        public Object m9182a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLNativeTemplateViewControllerDeserializer.m5398a(jsonParser, (short) 573);
            Object graphQLNativeTemplateViewController = new GraphQLNativeTemplateViewController();
            ((BaseModel) graphQLNativeTemplateViewController).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLNativeTemplateViewController instanceof Postprocessable) {
                return ((Postprocessable) graphQLNativeTemplateViewController).a();
            }
            return graphQLNativeTemplateViewController;
        }
    }

    /* compiled from: extended_base_hash */
    public final class Serializer extends JsonSerializer<GraphQLNativeTemplateViewController> {
        public final void m9183a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLNativeTemplateViewController graphQLNativeTemplateViewController = (GraphQLNativeTemplateViewController) obj;
            GraphQLNativeTemplateViewControllerDeserializer.m5399a(graphQLNativeTemplateViewController.w_(), graphQLNativeTemplateViewController.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLNativeTemplateViewController.class, new Serializer());
            FbSerializerProvider.a(GraphQLNativeTemplateViewController.class, new Serializer());
        }
    }

    @Nullable
    public final GraphQLObjectType m9185a() {
        if (this.b != null && this.f4531d == null) {
            this.f4531d = new GraphQLObjectType(this.b.b(this.c, 0));
        }
        if (this.f4531d == null || this.f4531d.g() != 0) {
            return this.f4531d;
        }
        return null;
    }

    @FieldOffset
    @Nullable
    public final String m9188j() {
        this.f4532e = super.a(this.f4532e, 1);
        return this.f4532e;
    }

    @FieldOffset
    @Nullable
    public final String m9189k() {
        this.f4533f = super.a(this.f4533f, 2);
        return this.f4533f;
    }

    @FieldOffset
    public final boolean m9190l() {
        a(0, 3);
        return this.f4534g;
    }

    @FieldOffset
    @Nullable
    public final String m9191m() {
        this.f4535h = super.a(this.f4535h, 4);
        return this.f4535h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNativeTemplateView m9192n() {
        this.f4536i = (GraphQLNativeTemplateView) super.a(this.f4536i, 5, GraphQLNativeTemplateView.class);
        return this.f4536i;
    }

    public final int jK_() {
        return 44974162;
    }

    public final GraphQLVisitableModel m9186a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m9192n() != null) {
            GraphQLNativeTemplateView graphQLNativeTemplateView = (GraphQLNativeTemplateView) graphQLModelMutatingVisitor.b(m9192n());
            if (m9192n() != graphQLNativeTemplateView) {
                graphQLVisitableModel = (GraphQLNativeTemplateViewController) ModelHelper.a(null, this);
                graphQLVisitableModel.f4536i = graphQLNativeTemplateView;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLNativeTemplateViewController() {
        super(7);
    }

    public final void m9187a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f4534g = mutableFlatBuffer.a(i, 3);
    }

    public final int m9184a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = flatBufferBuilder.a(m9185a() != null ? m9185a().e() : null);
        int b = flatBufferBuilder.b(m9188j());
        int b2 = flatBufferBuilder.b(m9189k());
        int b3 = flatBufferBuilder.b(m9191m());
        int a2 = ModelHelper.a(flatBufferBuilder, m9192n());
        flatBufferBuilder.c(6);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        flatBufferBuilder.a(3, m9190l());
        flatBufferBuilder.b(4, b3);
        flatBufferBuilder.b(5, a2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLNativeTemplateViewController(Parcel parcel) {
        boolean z = true;
        super(7);
        this.f4532e = parcel.readString();
        this.f4533f = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f4534g = z;
        this.f4535h = parcel.readString();
        this.f4536i = (GraphQLNativeTemplateView) parcel.readValue(GraphQLNativeTemplateView.class.getClassLoader());
        this.f4531d = (GraphQLObjectType) ParcelUtil.m3828b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m9188j());
        parcel.writeString(m9189k());
        parcel.writeByte((byte) (m9190l() ? 1 : 0));
        parcel.writeString(m9191m());
        parcel.writeValue(m9192n());
        parcel.writeParcelable(this.f4531d, i);
    }
}
