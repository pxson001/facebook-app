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
import com.facebook.graphql.deserializers.GraphQLNoteDeserializer;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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
/* compiled from: event_member */
public final class GraphQLNote extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLNote> CREATOR = new C04501();
    @Nullable
    GraphQLStreamingImage f4614A;
    @Nullable
    GraphQLImage f4615B;
    GraphQLSavedState f4616C;
    @Nullable
    GraphQLFocusedPhoto f4617d;
    @Nullable
    GraphQLFocusedPhoto f4618e;
    long f4619f;
    @Nullable
    GraphQLFeedback f4620g;
    @Nullable
    String f4621h;
    @Nullable
    String f4622i;
    @Nullable
    GraphQLPrivacyScope f4623j;
    @Nullable
    GraphQLComposedDocument f4624k;
    @Nullable
    String f4625l;
    @Nullable
    String f4626m;
    @Nullable
    GraphQLActor f4627n;
    @Nullable
    GraphQLImage f4628o;
    @Nullable
    GraphQLImage f4629p;
    @Deprecated
    @Nullable
    GraphQLInlineActivitiesConnection f4630q;
    @Nullable
    String f4631r;
    @Nullable
    GraphQLImage f4632s;
    @Nullable
    GraphQLImage f4633t;
    @Nullable
    GraphQLImage f4634u;
    @Nullable
    GraphQLImage f4635v;
    @Nullable
    GraphQLImage f4636w;
    @Nullable
    GraphQLPhoto f4637x;
    @Nullable
    GraphQLImage f4638y;
    boolean f4639z;

    /* compiled from: event_member */
    final class C04501 implements Creator<GraphQLNote> {
        C04501() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLNote(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLNote[i];
        }
    }

    /* compiled from: event_member */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLNote.class, new Deserializer());
        }

        public Object m9295a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLNoteDeserializer.m5442a(jsonParser, (short) 74);
            Object graphQLNote = new GraphQLNote();
            ((BaseModel) graphQLNote).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLNote instanceof Postprocessable) {
                return ((Postprocessable) graphQLNote).a();
            }
            return graphQLNote;
        }
    }

    /* compiled from: event_member */
    public final class Serializer extends JsonSerializer<GraphQLNote> {
        public final void m9296a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLNote graphQLNote = (GraphQLNote) obj;
            GraphQLNoteDeserializer.m5443a(graphQLNote.w_(), graphQLNote.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLNote.class, new Serializer());
            FbSerializerProvider.a(GraphQLNote.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLFocusedPhoto m9310j() {
        this.f4617d = (GraphQLFocusedPhoto) super.a(this.f4617d, 0, GraphQLFocusedPhoto.class);
        return this.f4617d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFocusedPhoto m9311k() {
        this.f4618e = (GraphQLFocusedPhoto) super.a(this.f4618e, 1, GraphQLFocusedPhoto.class);
        return this.f4618e;
    }

    @FieldOffset
    public final long m9312l() {
        a(0, 2);
        return this.f4619f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback m9313m() {
        this.f4620g = (GraphQLFeedback) super.a(this.f4620g, 3, GraphQLFeedback.class);
        return this.f4620g;
    }

    @FieldOffset
    @Nullable
    public final String m9314n() {
        this.f4621h = super.a(this.f4621h, 4);
        return this.f4621h;
    }

    @FieldOffset
    @Nullable
    public final String m9315o() {
        this.f4622i = super.a(this.f4622i, 5);
        return this.f4622i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyScope m9316p() {
        this.f4623j = (GraphQLPrivacyScope) super.a(this.f4623j, 6, GraphQLPrivacyScope.class);
        return this.f4623j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLComposedDocument m9317q() {
        this.f4624k = (GraphQLComposedDocument) super.a(this.f4624k, 7, GraphQLComposedDocument.class);
        return this.f4624k;
    }

    @FieldOffset
    @Nullable
    public final String m9318r() {
        this.f4625l = super.a(this.f4625l, 8);
        return this.f4625l;
    }

    @FieldOffset
    @Nullable
    public final String m9319s() {
        this.f4626m = super.a(this.f4626m, 9);
        return this.f4626m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor m9320t() {
        this.f4627n = (GraphQLActor) super.a(this.f4627n, 10, GraphQLActor.class);
        return this.f4627n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m9321u() {
        this.f4628o = (GraphQLImage) super.a(this.f4628o, 11, GraphQLImage.class);
        return this.f4628o;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m9322v() {
        this.f4629p = (GraphQLImage) super.a(this.f4629p, 12, GraphQLImage.class);
        return this.f4629p;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInlineActivitiesConnection m9323w() {
        this.f4630q = (GraphQLInlineActivitiesConnection) super.a(this.f4630q, 13, GraphQLInlineActivitiesConnection.class);
        return this.f4630q;
    }

    @FieldOffset
    @Nullable
    public final String m9324x() {
        this.f4631r = super.a(this.f4631r, 14);
        return this.f4631r;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m9325y() {
        this.f4632s = (GraphQLImage) super.a(this.f4632s, 15, GraphQLImage.class);
        return this.f4632s;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m9326z() {
        this.f4633t = (GraphQLImage) super.a(this.f4633t, 16, GraphQLImage.class);
        return this.f4633t;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m9297A() {
        this.f4634u = (GraphQLImage) super.a(this.f4634u, 17, GraphQLImage.class);
        return this.f4634u;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m9298B() {
        this.f4635v = (GraphQLImage) super.a(this.f4635v, 18, GraphQLImage.class);
        return this.f4635v;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m9299C() {
        this.f4636w = (GraphQLImage) super.a(this.f4636w, 19, GraphQLImage.class);
        return this.f4636w;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhoto m9300D() {
        this.f4637x = (GraphQLPhoto) super.a(this.f4637x, 20, GraphQLPhoto.class);
        return this.f4637x;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m9301E() {
        this.f4638y = (GraphQLImage) super.a(this.f4638y, 21, GraphQLImage.class);
        return this.f4638y;
    }

    @FieldOffset
    public final boolean m9302F() {
        a(2, 6);
        return this.f4639z;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStreamingImage m9303G() {
        this.f4614A = (GraphQLStreamingImage) super.a(this.f4614A, 23, GraphQLStreamingImage.class);
        return this.f4614A;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m9304H() {
        this.f4615B = (GraphQLImage) super.a(this.f4615B, 24, GraphQLImage.class);
        return this.f4615B;
    }

    @FieldOffset
    public final GraphQLSavedState m9305I() {
        this.f4616C = (GraphQLSavedState) super.a(this.f4616C, 25, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f4616C;
    }

    @Nullable
    public final String m9308a() {
        return m9314n();
    }

    public final int jK_() {
        return 2434066;
    }

    public final GraphQLVisitableModel m9307a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLFocusedPhoto graphQLFocusedPhoto;
        GraphQLImage graphQLImage;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m9310j() != null) {
            graphQLFocusedPhoto = (GraphQLFocusedPhoto) graphQLModelMutatingVisitor.b(m9310j());
            if (m9310j() != graphQLFocusedPhoto) {
                graphQLVisitableModel = (GraphQLNote) ModelHelper.a(null, this);
                graphQLVisitableModel.f4617d = graphQLFocusedPhoto;
            }
        }
        if (m9311k() != null) {
            graphQLFocusedPhoto = (GraphQLFocusedPhoto) graphQLModelMutatingVisitor.b(m9311k());
            if (m9311k() != graphQLFocusedPhoto) {
                graphQLVisitableModel = (GraphQLNote) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4618e = graphQLFocusedPhoto;
            }
        }
        if (m9321u() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m9321u());
            if (m9321u() != graphQLImage) {
                graphQLVisitableModel = (GraphQLNote) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4628o = graphQLImage;
            }
        }
        if (m9313m() != null) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.b(m9313m());
            if (m9313m() != graphQLFeedback) {
                graphQLVisitableModel = (GraphQLNote) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4620g = graphQLFeedback;
            }
        }
        if (m9320t() != null) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.b(m9320t());
            if (m9320t() != graphQLActor) {
                graphQLVisitableModel = (GraphQLNote) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4627n = graphQLActor;
            }
        }
        if (m9322v() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m9322v());
            if (m9322v() != graphQLImage) {
                graphQLVisitableModel = (GraphQLNote) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4629p = graphQLImage;
            }
        }
        if (m9323w() != null) {
            GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection = (GraphQLInlineActivitiesConnection) graphQLModelMutatingVisitor.b(m9323w());
            if (m9323w() != graphQLInlineActivitiesConnection) {
                graphQLVisitableModel = (GraphQLNote) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4630q = graphQLInlineActivitiesConnection;
            }
        }
        if (m9316p() != null) {
            GraphQLPrivacyScope graphQLPrivacyScope = (GraphQLPrivacyScope) graphQLModelMutatingVisitor.b(m9316p());
            if (m9316p() != graphQLPrivacyScope) {
                graphQLVisitableModel = (GraphQLNote) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4623j = graphQLPrivacyScope;
            }
        }
        if (m9325y() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m9325y());
            if (m9325y() != graphQLImage) {
                graphQLVisitableModel = (GraphQLNote) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4632s = graphQLImage;
            }
        }
        if (m9326z() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m9326z());
            if (m9326z() != graphQLImage) {
                graphQLVisitableModel = (GraphQLNote) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4633t = graphQLImage;
            }
        }
        if (m9297A() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m9297A());
            if (m9297A() != graphQLImage) {
                graphQLVisitableModel = (GraphQLNote) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4634u = graphQLImage;
            }
        }
        if (m9298B() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m9298B());
            if (m9298B() != graphQLImage) {
                graphQLVisitableModel = (GraphQLNote) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4635v = graphQLImage;
            }
        }
        if (m9299C() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m9299C());
            if (m9299C() != graphQLImage) {
                graphQLVisitableModel = (GraphQLNote) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4636w = graphQLImage;
            }
        }
        if (m9300D() != null) {
            GraphQLPhoto graphQLPhoto = (GraphQLPhoto) graphQLModelMutatingVisitor.b(m9300D());
            if (m9300D() != graphQLPhoto) {
                graphQLVisitableModel = (GraphQLNote) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4637x = graphQLPhoto;
            }
        }
        if (m9301E() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m9301E());
            if (m9301E() != graphQLImage) {
                graphQLVisitableModel = (GraphQLNote) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4638y = graphQLImage;
            }
        }
        if (m9317q() != null) {
            GraphQLComposedDocument graphQLComposedDocument = (GraphQLComposedDocument) graphQLModelMutatingVisitor.b(m9317q());
            if (m9317q() != graphQLComposedDocument) {
                graphQLVisitableModel = (GraphQLNote) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4624k = graphQLComposedDocument;
            }
        }
        if (m9303G() != null) {
            GraphQLStreamingImage graphQLStreamingImage = (GraphQLStreamingImage) graphQLModelMutatingVisitor.b(m9303G());
            if (m9303G() != graphQLStreamingImage) {
                graphQLVisitableModel = (GraphQLNote) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4614A = graphQLStreamingImage;
            }
        }
        if (m9304H() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m9304H());
            if (m9304H() != graphQLImage) {
                graphQLVisitableModel = (GraphQLNote) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4615B = graphQLImage;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLNote() {
        super(27);
    }

    public final void m9309a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f4619f = mutableFlatBuffer.a(i, 2, 0);
        this.f4639z = mutableFlatBuffer.a(i, 22);
    }

    public final int m9306a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m9310j());
        int a2 = ModelHelper.a(flatBufferBuilder, m9311k());
        int a3 = ModelHelper.a(flatBufferBuilder, m9313m());
        int b = flatBufferBuilder.b(m9314n());
        int b2 = flatBufferBuilder.b(m9315o());
        int a4 = ModelHelper.a(flatBufferBuilder, m9316p());
        int a5 = ModelHelper.a(flatBufferBuilder, m9317q());
        int b3 = flatBufferBuilder.b(m9318r());
        int b4 = flatBufferBuilder.b(m9319s());
        int a6 = ModelHelper.a(flatBufferBuilder, m9320t());
        int a7 = ModelHelper.a(flatBufferBuilder, m9321u());
        int a8 = ModelHelper.a(flatBufferBuilder, m9322v());
        int a9 = ModelHelper.a(flatBufferBuilder, m9323w());
        int b5 = flatBufferBuilder.b(m9324x());
        int a10 = ModelHelper.a(flatBufferBuilder, m9325y());
        int a11 = ModelHelper.a(flatBufferBuilder, m9326z());
        int a12 = ModelHelper.a(flatBufferBuilder, m9297A());
        int a13 = ModelHelper.a(flatBufferBuilder, m9298B());
        int a14 = ModelHelper.a(flatBufferBuilder, m9299C());
        int a15 = ModelHelper.a(flatBufferBuilder, m9300D());
        int a16 = ModelHelper.a(flatBufferBuilder, m9301E());
        int a17 = ModelHelper.a(flatBufferBuilder, m9303G());
        int a18 = ModelHelper.a(flatBufferBuilder, m9304H());
        flatBufferBuilder.c(26);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.a(2, m9312l(), 0);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, b);
        flatBufferBuilder.b(5, b2);
        flatBufferBuilder.b(6, a4);
        flatBufferBuilder.b(7, a5);
        flatBufferBuilder.b(8, b3);
        flatBufferBuilder.b(9, b4);
        flatBufferBuilder.b(10, a6);
        flatBufferBuilder.b(11, a7);
        flatBufferBuilder.b(12, a8);
        flatBufferBuilder.b(13, a9);
        flatBufferBuilder.b(14, b5);
        flatBufferBuilder.b(15, a10);
        flatBufferBuilder.b(16, a11);
        flatBufferBuilder.b(17, a12);
        flatBufferBuilder.b(18, a13);
        flatBufferBuilder.b(19, a14);
        flatBufferBuilder.b(20, a15);
        flatBufferBuilder.b(21, a16);
        flatBufferBuilder.a(22, m9302F());
        flatBufferBuilder.b(23, a17);
        flatBufferBuilder.b(24, a18);
        flatBufferBuilder.a(25, m9305I() == GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m9305I());
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLNote(Parcel parcel) {
        super(27);
        this.f4617d = (GraphQLFocusedPhoto) parcel.readValue(GraphQLFocusedPhoto.class.getClassLoader());
        this.f4618e = (GraphQLFocusedPhoto) parcel.readValue(GraphQLFocusedPhoto.class.getClassLoader());
        this.f4619f = parcel.readLong();
        this.f4628o = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4620g = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f4627n = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
        this.f4621h = parcel.readString();
        this.f4629p = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4630q = (GraphQLInlineActivitiesConnection) parcel.readValue(GraphQLInlineActivitiesConnection.class.getClassLoader());
        this.f4631r = parcel.readString();
        this.f4622i = parcel.readString();
        this.f4623j = (GraphQLPrivacyScope) parcel.readValue(GraphQLPrivacyScope.class.getClassLoader());
        this.f4632s = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4633t = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4634u = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4635v = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4636w = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4637x = (GraphQLPhoto) parcel.readValue(GraphQLPhoto.class.getClassLoader());
        this.f4638y = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4639z = parcel.readByte() == (byte) 1;
        this.f4624k = (GraphQLComposedDocument) parcel.readValue(GraphQLComposedDocument.class.getClassLoader());
        this.f4614A = (GraphQLStreamingImage) parcel.readValue(GraphQLStreamingImage.class.getClassLoader());
        this.f4625l = parcel.readString();
        this.f4615B = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4626m = parcel.readString();
        this.f4616C = GraphQLSavedState.fromString(parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m9310j());
        parcel.writeValue(m9311k());
        parcel.writeLong(m9312l());
        parcel.writeValue(m9321u());
        parcel.writeValue(m9313m());
        parcel.writeValue(m9320t());
        parcel.writeString(m9314n());
        parcel.writeValue(m9322v());
        parcel.writeValue(m9323w());
        parcel.writeString(m9324x());
        parcel.writeString(m9315o());
        parcel.writeValue(m9316p());
        parcel.writeValue(m9325y());
        parcel.writeValue(m9326z());
        parcel.writeValue(m9297A());
        parcel.writeValue(m9298B());
        parcel.writeValue(m9299C());
        parcel.writeValue(m9300D());
        parcel.writeValue(m9301E());
        parcel.writeByte((byte) (m9302F() ? 1 : 0));
        parcel.writeValue(m9317q());
        parcel.writeValue(m9303G());
        parcel.writeString(m9318r());
        parcel.writeValue(m9304H());
        parcel.writeString(m9319s());
        parcel.writeString(m9305I().name());
    }
}
