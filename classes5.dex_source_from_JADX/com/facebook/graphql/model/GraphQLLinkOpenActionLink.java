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
import com.facebook.graphql.deserializers.GraphQLLinkOpenActionLinkDeserializer;
import com.facebook.graphql.enums.GraphQLCallToActionStyle;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.graphql.enums.GraphQLStoryActionLinkDestinationType;
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
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: featured_instant_article_element */
public final class GraphQLLinkOpenActionLink extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLLinkOpenActionLink> CREATOR = new C04271();
    public boolean f4393d;
    public GraphQLStoryActionLinkDestinationType f4394e;
    @Nullable
    public String f4395f;
    @Nullable
    public String f4396g;
    @Nullable
    public GraphQLImage f4397h;
    public GraphQLCallToActionStyle f4398i;
    @Nullable
    public GraphQLLinkTargetStoreData f4399j;
    @Nullable
    public String f4400k;
    public GraphQLCallToActionType f4401l;
    @Nullable
    public GraphQLImage f4402m;
    @Nullable
    public String f4403n;
    @Nullable
    public String f4404o;
    @Nullable
    public String f4405p;
    public List<GraphQLVideoAnnotation> f4406q;
    @Nullable
    public String f4407r;
    @Nullable
    public String f4408s;

    /* compiled from: featured_instant_article_element */
    final class C04271 implements Creator<GraphQLLinkOpenActionLink> {
        C04271() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLLinkOpenActionLink(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLLinkOpenActionLink[i];
        }
    }

    /* compiled from: featured_instant_article_element */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLLinkOpenActionLink.class, new Deserializer());
        }

        public Object m8920a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLLinkOpenActionLinkDeserializer.m5322a(jsonParser, (short) 187);
            Object graphQLLinkOpenActionLink = new GraphQLLinkOpenActionLink();
            ((BaseModel) graphQLLinkOpenActionLink).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLLinkOpenActionLink instanceof Postprocessable) {
                return ((Postprocessable) graphQLLinkOpenActionLink).a();
            }
            return graphQLLinkOpenActionLink;
        }
    }

    /* compiled from: featured_instant_article_element */
    public final class Serializer extends JsonSerializer<GraphQLLinkOpenActionLink> {
        public final void m8921a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLLinkOpenActionLink graphQLLinkOpenActionLink = (GraphQLLinkOpenActionLink) obj;
            GraphQLLinkOpenActionLinkDeserializer.m5323a(graphQLLinkOpenActionLink.w_(), graphQLLinkOpenActionLink.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLLinkOpenActionLink.class, new Serializer());
            FbSerializerProvider.a(GraphQLLinkOpenActionLink.class, new Serializer());
        }
    }

    @FieldOffset
    public final boolean m8925a() {
        a(0, 0);
        return this.f4393d;
    }

    @FieldOffset
    public final GraphQLStoryActionLinkDestinationType m8926j() {
        this.f4394e = (GraphQLStoryActionLinkDestinationType) super.a(this.f4394e, 1, GraphQLStoryActionLinkDestinationType.class, GraphQLStoryActionLinkDestinationType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f4394e;
    }

    @FieldOffset
    @Nullable
    public final String m8927k() {
        this.f4395f = super.a(this.f4395f, 2);
        return this.f4395f;
    }

    @FieldOffset
    @Nullable
    public final String m8928l() {
        this.f4396g = super.a(this.f4396g, 3);
        return this.f4396g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m8929m() {
        this.f4397h = (GraphQLImage) super.a(this.f4397h, 4, GraphQLImage.class);
        return this.f4397h;
    }

    @FieldOffset
    public final GraphQLCallToActionStyle m8930n() {
        this.f4398i = (GraphQLCallToActionStyle) super.a(this.f4398i, 5, GraphQLCallToActionStyle.class, GraphQLCallToActionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f4398i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLLinkTargetStoreData m8931o() {
        this.f4399j = (GraphQLLinkTargetStoreData) super.a(this.f4399j, 6, GraphQLLinkTargetStoreData.class);
        return this.f4399j;
    }

    @FieldOffset
    @Nullable
    public final String m8932p() {
        this.f4400k = super.a(this.f4400k, 7);
        return this.f4400k;
    }

    @FieldOffset
    public final GraphQLCallToActionType m8933q() {
        this.f4401l = (GraphQLCallToActionType) super.a(this.f4401l, 8, GraphQLCallToActionType.class, GraphQLCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f4401l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m8934r() {
        this.f4402m = (GraphQLImage) super.a(this.f4402m, 9, GraphQLImage.class);
        return this.f4402m;
    }

    @FieldOffset
    @Nullable
    public final String m8935s() {
        this.f4403n = super.a(this.f4403n, 10);
        return this.f4403n;
    }

    @FieldOffset
    @Nullable
    public final String m8936t() {
        this.f4404o = super.a(this.f4404o, 11);
        return this.f4404o;
    }

    @FieldOffset
    @Nullable
    public final String m8937u() {
        this.f4405p = super.a(this.f4405p, 12);
        return this.f4405p;
    }

    @FieldOffset
    public final ImmutableList<GraphQLVideoAnnotation> m8938v() {
        this.f4406q = super.a(this.f4406q, 13, GraphQLVideoAnnotation.class);
        return (ImmutableList) this.f4406q;
    }

    @FieldOffset
    @Nullable
    public final String m8939w() {
        this.f4407r = super.a(this.f4407r, 14);
        return this.f4407r;
    }

    @FieldOffset
    @Nullable
    public final String m8940x() {
        this.f4408s = super.a(this.f4408s, 15);
        return this.f4408s;
    }

    public final int jK_() {
        return -508788748;
    }

    public final GraphQLVisitableModel m8923a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLImage graphQLImage;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8929m() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m8929m());
            if (m8929m() != graphQLImage) {
                graphQLVisitableModel = (GraphQLLinkOpenActionLink) ModelHelper.a(null, this);
                graphQLVisitableModel.f4397h = graphQLImage;
            }
        }
        if (m8931o() != null) {
            GraphQLLinkTargetStoreData graphQLLinkTargetStoreData = (GraphQLLinkTargetStoreData) graphQLModelMutatingVisitor.b(m8931o());
            if (m8931o() != graphQLLinkTargetStoreData) {
                graphQLVisitableModel = (GraphQLLinkOpenActionLink) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4399j = graphQLLinkTargetStoreData;
            }
        }
        if (m8934r() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m8934r());
            if (m8934r() != graphQLImage) {
                graphQLVisitableModel = (GraphQLLinkOpenActionLink) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4402m = graphQLImage;
            }
        }
        if (m8938v() != null) {
            Builder a = ModelHelper.a(m8938v(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLLinkOpenActionLink graphQLLinkOpenActionLink = (GraphQLLinkOpenActionLink) ModelHelper.a(graphQLVisitableModel, this);
                graphQLLinkOpenActionLink.f4406q = a.b();
                graphQLVisitableModel = graphQLLinkOpenActionLink;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLLinkOpenActionLink() {
        super(17);
    }

    public final void m8924a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f4393d = mutableFlatBuffer.a(i, 0);
    }

    public final int m8922a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m8927k());
        int b2 = flatBufferBuilder.b(m8928l());
        int a = ModelHelper.a(flatBufferBuilder, m8929m());
        int a2 = ModelHelper.a(flatBufferBuilder, m8931o());
        int b3 = flatBufferBuilder.b(m8932p());
        int a3 = ModelHelper.a(flatBufferBuilder, m8934r());
        int b4 = flatBufferBuilder.b(m8935s());
        int b5 = flatBufferBuilder.b(m8936t());
        int b6 = flatBufferBuilder.b(m8937u());
        int a4 = ModelHelper.a(flatBufferBuilder, m8938v());
        int b7 = flatBufferBuilder.b(m8939w());
        int b8 = flatBufferBuilder.b(m8940x());
        flatBufferBuilder.c(16);
        flatBufferBuilder.a(0, m8925a());
        flatBufferBuilder.a(1, m8926j() == GraphQLStoryActionLinkDestinationType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m8926j());
        flatBufferBuilder.b(2, b);
        flatBufferBuilder.b(3, b2);
        flatBufferBuilder.b(4, a);
        flatBufferBuilder.a(5, m8930n() == GraphQLCallToActionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m8930n());
        flatBufferBuilder.b(6, a2);
        flatBufferBuilder.b(7, b3);
        flatBufferBuilder.a(8, m8933q() == GraphQLCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m8933q());
        flatBufferBuilder.b(9, a3);
        flatBufferBuilder.b(10, b4);
        flatBufferBuilder.b(11, b5);
        flatBufferBuilder.b(12, b6);
        flatBufferBuilder.b(13, a4);
        flatBufferBuilder.b(14, b7);
        flatBufferBuilder.b(15, b8);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLLinkOpenActionLink(Parcel parcel) {
        boolean z = true;
        super(17);
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f4393d = z;
        this.f4394e = GraphQLStoryActionLinkDestinationType.fromString(parcel.readString());
        this.f4407r = parcel.readString();
        this.f4395f = parcel.readString();
        this.f4396g = parcel.readString();
        this.f4397h = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4398i = GraphQLCallToActionStyle.fromString(parcel.readString());
        this.f4399j = (GraphQLLinkTargetStoreData) parcel.readValue(GraphQLLinkTargetStoreData.class.getClassLoader());
        this.f4400k = parcel.readString();
        this.f4401l = GraphQLCallToActionType.fromString(parcel.readString());
        this.f4402m = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4408s = parcel.readString();
        this.f4403n = parcel.readString();
        this.f4404o = parcel.readString();
        this.f4405p = parcel.readString();
        this.f4406q = ImmutableListHelper.a(parcel.readArrayList(GraphQLVideoAnnotation.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (m8925a() ? 1 : 0));
        parcel.writeString(m8926j().name());
        parcel.writeString(m8939w());
        parcel.writeString(m8927k());
        parcel.writeString(m8928l());
        parcel.writeValue(m8929m());
        parcel.writeString(m8930n().name());
        parcel.writeValue(m8931o());
        parcel.writeString(m8932p());
        parcel.writeString(m8933q().name());
        parcel.writeValue(m8934r());
        parcel.writeString(m8940x());
        parcel.writeString(m8935s());
        parcel.writeString(m8936t());
        parcel.writeString(m8937u());
        parcel.writeList(m8938v());
    }
}
