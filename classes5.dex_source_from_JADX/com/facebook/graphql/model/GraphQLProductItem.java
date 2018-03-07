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
import com.facebook.graphql.deserializers.GraphQLProductItemDeserializer;
import com.facebook.graphql.enums.GraphQLCommerceCheckoutStyle;
import com.facebook.graphql.enums.GraphQLCommerceProductVisibility;
import com.facebook.graphql.enums.GraphQLProductAvailability;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: VOTERS_FOR_POLL_OPTION_ID */
public final class GraphQLProductItem extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLProductItem> CREATOR = new C11851();
    @Nullable
    public String f12721A;
    @Nullable
    public GraphQLPage f12722B;
    @Nullable
    public GraphQLStory f12723C;
    public List<GraphQLImage> f12724D;
    @Deprecated
    @Nullable
    public GraphQLImage f12725E;
    @Deprecated
    @Nullable
    public GraphQLImage f12726F;
    @Nullable
    public GraphQLImage f12727G;
    @Nullable
    public GraphQLImage f12728H;
    @Nullable
    public GraphQLImage f12729I;
    @Nullable
    public GraphQLImage f12730J;
    @Nullable
    public GraphQLImage f12731K;
    @Nullable
    public GraphQLPhoto f12732L;
    @Nullable
    public GraphQLImage f12733M;
    public boolean f12734N;
    @Nullable
    public String f12735O;
    @Deprecated
    @Nullable
    public GraphQLCurrencyQuantity f12736P;
    @Nullable
    public GraphQLActor f12737Q;
    @Nullable
    public GraphQLStreamingImage f12738R;
    @Nullable
    public GraphQLImage f12739S;
    @Nullable
    public String f12740T;
    public List<String> f12741U;
    public GraphQLSavedState f12742V;
    public double f12743W;
    public double f12744X;
    @Nullable
    public String f12745d;
    public GraphQLCommerceCheckoutStyle f12746e;
    public boolean f12747f;
    public int f12748g;
    public GraphQLCommerceProductVisibility f12749h;
    public long f12750i;
    @Deprecated
    @Nullable
    public GraphQLCurrencyQuantity f12751j;
    @Nullable
    public String f12752k;
    @Nullable
    public String f12753l;
    @Nullable
    public String f12754m;
    @Nullable
    public GraphQLImage f12755n;
    @Nullable
    public GraphQLFeedback f12756o;
    @Deprecated
    @Nullable
    public GraphQLImage f12757p;
    @Nullable
    public String f12758q;
    @Deprecated
    @Nullable
    public GraphQLImage f12759r;
    @Nullable
    public GraphQLImage f12760s;
    @Deprecated
    public List<GraphQLImage> f12761t;
    @Deprecated
    @Nullable
    public GraphQLInlineActivitiesConnection f12762u;
    public boolean f12763v;
    public GraphQLProductAvailability f12764w;
    public List<String> f12765x;
    @Deprecated
    @Nullable
    public GraphQLCurrencyQuantity f12766y;
    @Nullable
    public GraphQLImage f12767z;

    /* compiled from: VOTERS_FOR_POLL_OPTION_ID */
    final class C11851 implements Creator<GraphQLProductItem> {
        C11851() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLProductItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLProductItem[i];
        }
    }

    /* compiled from: VOTERS_FOR_POLL_OPTION_ID */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLProductItem.class, new Deserializer());
        }

        public Object m21042a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLProductItemDeserializer.m5712a(jsonParser, (short) 525);
            Object graphQLProductItem = new GraphQLProductItem();
            ((BaseModel) graphQLProductItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLProductItem instanceof Postprocessable) {
                return ((Postprocessable) graphQLProductItem).a();
            }
            return graphQLProductItem;
        }
    }

    /* compiled from: VOTERS_FOR_POLL_OPTION_ID */
    public final class Serializer extends JsonSerializer<GraphQLProductItem> {
        public final void m21043a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLProductItem graphQLProductItem = (GraphQLProductItem) obj;
            GraphQLProductItemDeserializer.m5713a(graphQLProductItem.w_(), graphQLProductItem.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLProductItem.class, new Serializer());
            FbSerializerProvider.a(GraphQLProductItem.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m21074j() {
        this.f12745d = super.a(this.f12745d, 0);
        return this.f12745d;
    }

    @FieldOffset
    public final GraphQLCommerceCheckoutStyle m21075k() {
        this.f12746e = (GraphQLCommerceCheckoutStyle) super.a(this.f12746e, 1, GraphQLCommerceCheckoutStyle.class, GraphQLCommerceCheckoutStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f12746e;
    }

    @FieldOffset
    public final boolean m21076l() {
        a(0, 2);
        return this.f12747f;
    }

    @FieldOffset
    public final int m21077m() {
        a(0, 3);
        return this.f12748g;
    }

    @FieldOffset
    public final GraphQLCommerceProductVisibility m21078n() {
        this.f12749h = (GraphQLCommerceProductVisibility) super.a(this.f12749h, 4, GraphQLCommerceProductVisibility.class, GraphQLCommerceProductVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f12749h;
    }

    @FieldOffset
    public final long m21079o() {
        a(0, 5);
        return this.f12750i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLCurrencyQuantity m21080p() {
        this.f12751j = (GraphQLCurrencyQuantity) super.a(this.f12751j, 6, GraphQLCurrencyQuantity.class);
        return this.f12751j;
    }

    @FieldOffset
    @Nullable
    public final String m21081q() {
        this.f12752k = super.a(this.f12752k, 7);
        return this.f12752k;
    }

    @FieldOffset
    @Nullable
    public final String m21082r() {
        this.f12753l = super.a(this.f12753l, 8);
        return this.f12753l;
    }

    @FieldOffset
    @Nullable
    public final String m21083s() {
        this.f12754m = super.a(this.f12754m, 9);
        return this.f12754m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m21084t() {
        this.f12755n = (GraphQLImage) super.a(this.f12755n, 10, GraphQLImage.class);
        return this.f12755n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback m21085u() {
        this.f12756o = (GraphQLFeedback) super.a(this.f12756o, 11, GraphQLFeedback.class);
        return this.f12756o;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m21086v() {
        this.f12757p = (GraphQLImage) super.a(this.f12757p, 12, GraphQLImage.class);
        return this.f12757p;
    }

    @FieldOffset
    @Nullable
    public final String m21087w() {
        this.f12758q = super.a(this.f12758q, 13);
        return this.f12758q;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m21088x() {
        this.f12759r = (GraphQLImage) super.a(this.f12759r, 14, GraphQLImage.class);
        return this.f12759r;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m21089y() {
        this.f12760s = (GraphQLImage) super.a(this.f12760s, 15, GraphQLImage.class);
        return this.f12760s;
    }

    @FieldOffset
    public final ImmutableList<GraphQLImage> m21090z() {
        this.f12761t = super.a(this.f12761t, 16, GraphQLImage.class);
        return (ImmutableList) this.f12761t;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInlineActivitiesConnection m21044A() {
        this.f12762u = (GraphQLInlineActivitiesConnection) super.a(this.f12762u, 17, GraphQLInlineActivitiesConnection.class);
        return this.f12762u;
    }

    @FieldOffset
    public final boolean m21045B() {
        a(2, 2);
        return this.f12763v;
    }

    @FieldOffset
    public final GraphQLProductAvailability m21046C() {
        this.f12764w = (GraphQLProductAvailability) super.a(this.f12764w, 19, GraphQLProductAvailability.class, GraphQLProductAvailability.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f12764w;
    }

    @FieldOffset
    public final ImmutableList<String> m21047D() {
        this.f12765x = super.a(this.f12765x, 20);
        return (ImmutableList) this.f12765x;
    }

    @FieldOffset
    @Nullable
    public final GraphQLCurrencyQuantity m21048E() {
        this.f12766y = (GraphQLCurrencyQuantity) super.a(this.f12766y, 21, GraphQLCurrencyQuantity.class);
        return this.f12766y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m21049F() {
        this.f12767z = (GraphQLImage) super.a(this.f12767z, 22, GraphQLImage.class);
        return this.f12767z;
    }

    @FieldOffset
    @Nullable
    public final String m21050G() {
        this.f12721A = super.a(this.f12721A, 23);
        return this.f12721A;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m21051H() {
        this.f12722B = (GraphQLPage) super.a(this.f12722B, 24, GraphQLPage.class);
        return this.f12722B;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory m21052I() {
        this.f12723C = (GraphQLStory) super.a(this.f12723C, 25, GraphQLStory.class);
        return this.f12723C;
    }

    @FieldOffset
    public final ImmutableList<GraphQLImage> m21053J() {
        this.f12724D = super.a(this.f12724D, 26, GraphQLImage.class);
        return (ImmutableList) this.f12724D;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m21054K() {
        this.f12725E = (GraphQLImage) super.a(this.f12725E, 27, GraphQLImage.class);
        return this.f12725E;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m21055L() {
        this.f12726F = (GraphQLImage) super.a(this.f12726F, 28, GraphQLImage.class);
        return this.f12726F;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m21056M() {
        this.f12727G = (GraphQLImage) super.a(this.f12727G, 29, GraphQLImage.class);
        return this.f12727G;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m21057N() {
        this.f12728H = (GraphQLImage) super.a(this.f12728H, 30, GraphQLImage.class);
        return this.f12728H;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m21058O() {
        this.f12729I = (GraphQLImage) super.a(this.f12729I, 31, GraphQLImage.class);
        return this.f12729I;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m21059P() {
        this.f12730J = (GraphQLImage) super.a(this.f12730J, 32, GraphQLImage.class);
        return this.f12730J;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m21060Q() {
        this.f12731K = (GraphQLImage) super.a(this.f12731K, 33, GraphQLImage.class);
        return this.f12731K;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhoto m21061R() {
        this.f12732L = (GraphQLPhoto) super.a(this.f12732L, 34, GraphQLPhoto.class);
        return this.f12732L;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m21062S() {
        this.f12733M = (GraphQLImage) super.a(this.f12733M, 35, GraphQLImage.class);
        return this.f12733M;
    }

    @FieldOffset
    public final boolean m21063T() {
        a(4, 4);
        return this.f12734N;
    }

    @FieldOffset
    @Nullable
    public final String m21064U() {
        this.f12735O = super.a(this.f12735O, 37);
        return this.f12735O;
    }

    @FieldOffset
    @Nullable
    public final GraphQLCurrencyQuantity m21065V() {
        this.f12736P = (GraphQLCurrencyQuantity) super.a(this.f12736P, 38, GraphQLCurrencyQuantity.class);
        return this.f12736P;
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor m21066W() {
        this.f12737Q = (GraphQLActor) super.a(this.f12737Q, 39, GraphQLActor.class);
        return this.f12737Q;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStreamingImage m21067X() {
        this.f12738R = (GraphQLStreamingImage) super.a(this.f12738R, 40, GraphQLStreamingImage.class);
        return this.f12738R;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m21068Y() {
        this.f12739S = (GraphQLImage) super.a(this.f12739S, 41, GraphQLImage.class);
        return this.f12739S;
    }

    @FieldOffset
    @Nullable
    public final String m21069Z() {
        this.f12740T = super.a(this.f12740T, 42);
        return this.f12740T;
    }

    @FieldOffset
    public final ImmutableList<String> aa() {
        this.f12741U = super.a(this.f12741U, 43);
        return (ImmutableList) this.f12741U;
    }

    @FieldOffset
    public final GraphQLSavedState ab() {
        this.f12742V = (GraphQLSavedState) super.a(this.f12742V, 44, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f12742V;
    }

    @FieldOffset
    public final double ac() {
        a(5, 5);
        return this.f12743W;
    }

    @FieldOffset
    public final double ad() {
        a(5, 6);
        return this.f12744X;
    }

    @Nullable
    public final String m21072a() {
        return m21087w();
    }

    public final int jK_() {
        return 175920258;
    }

    public final GraphQLVisitableModel m21071a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLCurrencyQuantity graphQLCurrencyQuantity;
        GraphQLImage graphQLImage;
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21080p() != null) {
            graphQLCurrencyQuantity = (GraphQLCurrencyQuantity) graphQLModelMutatingVisitor.b(m21080p());
            if (m21080p() != graphQLCurrencyQuantity) {
                graphQLVisitableModel = (GraphQLProductItem) ModelHelper.a(null, this);
                graphQLVisitableModel.f12751j = graphQLCurrencyQuantity;
            }
        }
        if (m21084t() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m21084t());
            if (m21084t() != graphQLImage) {
                graphQLVisitableModel = (GraphQLProductItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12755n = graphQLImage;
            }
        }
        if (m21085u() != null) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.b(m21085u());
            if (m21085u() != graphQLFeedback) {
                graphQLVisitableModel = (GraphQLProductItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12756o = graphQLFeedback;
            }
        }
        if (m21086v() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m21086v());
            if (m21086v() != graphQLImage) {
                graphQLVisitableModel = (GraphQLProductItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12757p = graphQLImage;
            }
        }
        if (m21088x() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m21088x());
            if (m21088x() != graphQLImage) {
                graphQLVisitableModel = (GraphQLProductItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12759r = graphQLImage;
            }
        }
        if (m21089y() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m21089y());
            if (m21089y() != graphQLImage) {
                graphQLVisitableModel = (GraphQLProductItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12760s = graphQLImage;
            }
        }
        if (m21090z() != null) {
            a = ModelHelper.a(m21090z(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLProductItem graphQLProductItem = (GraphQLProductItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLProductItem.f12761t = a.b();
                graphQLVisitableModel = graphQLProductItem;
            }
        }
        if (m21044A() != null) {
            GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection = (GraphQLInlineActivitiesConnection) graphQLModelMutatingVisitor.b(m21044A());
            if (m21044A() != graphQLInlineActivitiesConnection) {
                graphQLVisitableModel = (GraphQLProductItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12762u = graphQLInlineActivitiesConnection;
            }
        }
        if (m21048E() != null) {
            graphQLCurrencyQuantity = (GraphQLCurrencyQuantity) graphQLModelMutatingVisitor.b(m21048E());
            if (m21048E() != graphQLCurrencyQuantity) {
                graphQLVisitableModel = (GraphQLProductItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12766y = graphQLCurrencyQuantity;
            }
        }
        if (m21049F() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m21049F());
            if (m21049F() != graphQLImage) {
                graphQLVisitableModel = (GraphQLProductItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12767z = graphQLImage;
            }
        }
        if (m21051H() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.b(m21051H());
            if (m21051H() != graphQLPage) {
                graphQLVisitableModel = (GraphQLProductItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12722B = graphQLPage;
            }
        }
        if (m21052I() != null) {
            GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m21052I());
            if (m21052I() != graphQLStory) {
                graphQLVisitableModel = (GraphQLProductItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12723C = graphQLStory;
            }
        }
        if (m21053J() != null) {
            a = ModelHelper.a(m21053J(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLProductItem = (GraphQLProductItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLProductItem.f12724D = a.b();
                graphQLVisitableModel = graphQLProductItem;
            }
        }
        if (m21054K() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m21054K());
            if (m21054K() != graphQLImage) {
                graphQLVisitableModel = (GraphQLProductItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12725E = graphQLImage;
            }
        }
        if (m21055L() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m21055L());
            if (m21055L() != graphQLImage) {
                graphQLVisitableModel = (GraphQLProductItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12726F = graphQLImage;
            }
        }
        if (m21056M() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m21056M());
            if (m21056M() != graphQLImage) {
                graphQLVisitableModel = (GraphQLProductItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12727G = graphQLImage;
            }
        }
        if (m21057N() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m21057N());
            if (m21057N() != graphQLImage) {
                graphQLVisitableModel = (GraphQLProductItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12728H = graphQLImage;
            }
        }
        if (m21058O() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m21058O());
            if (m21058O() != graphQLImage) {
                graphQLVisitableModel = (GraphQLProductItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12729I = graphQLImage;
            }
        }
        if (m21059P() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m21059P());
            if (m21059P() != graphQLImage) {
                graphQLVisitableModel = (GraphQLProductItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12730J = graphQLImage;
            }
        }
        if (m21060Q() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m21060Q());
            if (m21060Q() != graphQLImage) {
                graphQLVisitableModel = (GraphQLProductItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12731K = graphQLImage;
            }
        }
        if (m21061R() != null) {
            GraphQLPhoto graphQLPhoto = (GraphQLPhoto) graphQLModelMutatingVisitor.b(m21061R());
            if (m21061R() != graphQLPhoto) {
                graphQLVisitableModel = (GraphQLProductItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12732L = graphQLPhoto;
            }
        }
        if (m21062S() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m21062S());
            if (m21062S() != graphQLImage) {
                graphQLVisitableModel = (GraphQLProductItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12733M = graphQLImage;
            }
        }
        if (m21065V() != null) {
            graphQLCurrencyQuantity = (GraphQLCurrencyQuantity) graphQLModelMutatingVisitor.b(m21065V());
            if (m21065V() != graphQLCurrencyQuantity) {
                graphQLVisitableModel = (GraphQLProductItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12736P = graphQLCurrencyQuantity;
            }
        }
        if (m21066W() != null) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.b(m21066W());
            if (m21066W() != graphQLActor) {
                graphQLVisitableModel = (GraphQLProductItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12737Q = graphQLActor;
            }
        }
        if (m21067X() != null) {
            GraphQLStreamingImage graphQLStreamingImage = (GraphQLStreamingImage) graphQLModelMutatingVisitor.b(m21067X());
            if (m21067X() != graphQLStreamingImage) {
                graphQLVisitableModel = (GraphQLProductItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12738R = graphQLStreamingImage;
            }
        }
        if (m21068Y() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m21068Y());
            if (m21068Y() != graphQLImage) {
                graphQLVisitableModel = (GraphQLProductItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12739S = graphQLImage;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLProductItem() {
        super(48);
    }

    public final void m21073a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f12747f = mutableFlatBuffer.a(i, 2);
        this.f12748g = mutableFlatBuffer.a(i, 3, 0);
        this.f12750i = mutableFlatBuffer.a(i, 5, 0);
        this.f12763v = mutableFlatBuffer.a(i, 18);
        this.f12734N = mutableFlatBuffer.a(i, 36);
        this.f12743W = mutableFlatBuffer.a(i, 45, 0.0d);
        this.f12744X = mutableFlatBuffer.a(i, 46, 0.0d);
    }

    public final int m21070a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m21074j());
        int a = ModelHelper.a(flatBufferBuilder, m21080p());
        int b2 = flatBufferBuilder.b(m21081q());
        int b3 = flatBufferBuilder.b(m21082r());
        int b4 = flatBufferBuilder.b(m21083s());
        int a2 = ModelHelper.a(flatBufferBuilder, m21084t());
        int a3 = ModelHelper.a(flatBufferBuilder, m21085u());
        int a4 = ModelHelper.a(flatBufferBuilder, m21086v());
        int b5 = flatBufferBuilder.b(m21087w());
        int a5 = ModelHelper.a(flatBufferBuilder, m21088x());
        int a6 = ModelHelper.a(flatBufferBuilder, m21089y());
        int a7 = ModelHelper.a(flatBufferBuilder, m21090z());
        int a8 = ModelHelper.a(flatBufferBuilder, m21044A());
        int c = flatBufferBuilder.c(m21047D());
        int a9 = ModelHelper.a(flatBufferBuilder, m21048E());
        int a10 = ModelHelper.a(flatBufferBuilder, m21049F());
        int b6 = flatBufferBuilder.b(m21050G());
        int a11 = ModelHelper.a(flatBufferBuilder, m21051H());
        int a12 = ModelHelper.a(flatBufferBuilder, m21052I());
        int a13 = ModelHelper.a(flatBufferBuilder, m21053J());
        int a14 = ModelHelper.a(flatBufferBuilder, m21054K());
        int a15 = ModelHelper.a(flatBufferBuilder, m21055L());
        int a16 = ModelHelper.a(flatBufferBuilder, m21056M());
        int a17 = ModelHelper.a(flatBufferBuilder, m21057N());
        int a18 = ModelHelper.a(flatBufferBuilder, m21058O());
        int a19 = ModelHelper.a(flatBufferBuilder, m21059P());
        int a20 = ModelHelper.a(flatBufferBuilder, m21060Q());
        int a21 = ModelHelper.a(flatBufferBuilder, m21061R());
        int a22 = ModelHelper.a(flatBufferBuilder, m21062S());
        int b7 = flatBufferBuilder.b(m21064U());
        int a23 = ModelHelper.a(flatBufferBuilder, m21065V());
        int a24 = ModelHelper.a(flatBufferBuilder, m21066W());
        int a25 = ModelHelper.a(flatBufferBuilder, m21067X());
        int a26 = ModelHelper.a(flatBufferBuilder, m21068Y());
        int b8 = flatBufferBuilder.b(m21069Z());
        int c2 = flatBufferBuilder.c(aa());
        flatBufferBuilder.c(47);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.a(1, m21075k() == GraphQLCommerceCheckoutStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m21075k());
        flatBufferBuilder.a(2, m21076l());
        flatBufferBuilder.a(3, m21077m(), 0);
        flatBufferBuilder.a(4, m21078n() == GraphQLCommerceProductVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m21078n());
        flatBufferBuilder.a(5, m21079o(), 0);
        flatBufferBuilder.b(6, a);
        flatBufferBuilder.b(7, b2);
        flatBufferBuilder.b(8, b3);
        flatBufferBuilder.b(9, b4);
        flatBufferBuilder.b(10, a2);
        flatBufferBuilder.b(11, a3);
        flatBufferBuilder.b(12, a4);
        flatBufferBuilder.b(13, b5);
        flatBufferBuilder.b(14, a5);
        flatBufferBuilder.b(15, a6);
        flatBufferBuilder.b(16, a7);
        flatBufferBuilder.b(17, a8);
        flatBufferBuilder.a(18, m21045B());
        flatBufferBuilder.a(19, m21046C() == GraphQLProductAvailability.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m21046C());
        flatBufferBuilder.b(20, c);
        flatBufferBuilder.b(21, a9);
        flatBufferBuilder.b(22, a10);
        flatBufferBuilder.b(23, b6);
        flatBufferBuilder.b(24, a11);
        flatBufferBuilder.b(25, a12);
        flatBufferBuilder.b(26, a13);
        flatBufferBuilder.b(27, a14);
        flatBufferBuilder.b(28, a15);
        flatBufferBuilder.b(29, a16);
        flatBufferBuilder.b(30, a17);
        flatBufferBuilder.b(31, a18);
        flatBufferBuilder.b(32, a19);
        flatBufferBuilder.b(33, a20);
        flatBufferBuilder.b(34, a21);
        flatBufferBuilder.b(35, a22);
        flatBufferBuilder.a(36, m21063T());
        flatBufferBuilder.b(37, b7);
        flatBufferBuilder.b(38, a23);
        flatBufferBuilder.b(39, a24);
        flatBufferBuilder.b(40, a25);
        flatBufferBuilder.b(41, a26);
        flatBufferBuilder.b(42, b8);
        flatBufferBuilder.b(43, c2);
        flatBufferBuilder.a(44, ab() == GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : ab());
        flatBufferBuilder.a(45, ac(), 0.0d);
        flatBufferBuilder.a(46, ad(), 0.0d);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLProductItem(Parcel parcel) {
        boolean z = true;
        super(48);
        this.f12745d = parcel.readString();
        this.f12746e = GraphQLCommerceCheckoutStyle.fromString(parcel.readString());
        this.f12747f = parcel.readByte() == (byte) 1;
        this.f12748g = parcel.readInt();
        this.f12749h = GraphQLCommerceProductVisibility.fromString(parcel.readString());
        this.f12750i = parcel.readLong();
        this.f12751j = (GraphQLCurrencyQuantity) parcel.readValue(GraphQLCurrencyQuantity.class.getClassLoader());
        this.f12752k = parcel.readString();
        this.f12753l = parcel.readString();
        this.f12754m = parcel.readString();
        this.f12755n = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f12756o = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f12757p = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f12758q = parcel.readString();
        this.f12759r = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f12760s = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f12761t = ImmutableListHelper.a(parcel.readArrayList(GraphQLImage.class.getClassLoader()));
        this.f12762u = (GraphQLInlineActivitiesConnection) parcel.readValue(GraphQLInlineActivitiesConnection.class.getClassLoader());
        this.f12763v = parcel.readByte() == (byte) 1;
        this.f12764w = GraphQLProductAvailability.fromString(parcel.readString());
        this.f12765x = ImmutableListHelper.a(parcel.readArrayList(String.class.getClassLoader()));
        this.f12766y = (GraphQLCurrencyQuantity) parcel.readValue(GraphQLCurrencyQuantity.class.getClassLoader());
        this.f12767z = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f12721A = parcel.readString();
        this.f12722B = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f12723C = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
        this.f12724D = ImmutableListHelper.a(parcel.readArrayList(GraphQLImage.class.getClassLoader()));
        this.f12725E = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f12726F = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f12743W = parcel.readDouble();
        this.f12744X = parcel.readDouble();
        this.f12727G = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f12728H = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f12729I = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f12730J = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f12731K = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f12732L = (GraphQLPhoto) parcel.readValue(GraphQLPhoto.class.getClassLoader());
        this.f12733M = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f12734N = z;
        this.f12735O = parcel.readString();
        this.f12736P = (GraphQLCurrencyQuantity) parcel.readValue(GraphQLCurrencyQuantity.class.getClassLoader());
        this.f12737Q = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
        this.f12738R = (GraphQLStreamingImage) parcel.readValue(GraphQLStreamingImage.class.getClassLoader());
        this.f12739S = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f12740T = parcel.readString();
        this.f12741U = ImmutableListHelper.a(parcel.readArrayList(String.class.getClassLoader()));
        this.f12742V = GraphQLSavedState.fromString(parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(m21074j());
        parcel.writeString(m21075k().name());
        parcel.writeByte((byte) (m21076l() ? 1 : 0));
        parcel.writeInt(m21077m());
        parcel.writeString(m21078n().name());
        parcel.writeLong(m21079o());
        parcel.writeValue(m21080p());
        parcel.writeString(m21081q());
        parcel.writeString(m21082r());
        parcel.writeString(m21083s());
        parcel.writeValue(m21084t());
        parcel.writeValue(m21085u());
        parcel.writeValue(m21086v());
        parcel.writeString(m21087w());
        parcel.writeValue(m21088x());
        parcel.writeValue(m21089y());
        parcel.writeList(m21090z());
        parcel.writeValue(m21044A());
        parcel.writeByte((byte) (m21045B() ? 1 : 0));
        parcel.writeString(m21046C().name());
        parcel.writeList(m21047D());
        parcel.writeValue(m21048E());
        parcel.writeValue(m21049F());
        parcel.writeString(m21050G());
        parcel.writeValue(m21051H());
        parcel.writeValue(m21052I());
        parcel.writeList(m21053J());
        parcel.writeValue(m21054K());
        parcel.writeValue(m21055L());
        parcel.writeDouble(ac());
        parcel.writeDouble(ad());
        parcel.writeValue(m21056M());
        parcel.writeValue(m21057N());
        parcel.writeValue(m21058O());
        parcel.writeValue(m21059P());
        parcel.writeValue(m21060Q());
        parcel.writeValue(m21061R());
        parcel.writeValue(m21062S());
        if (!m21063T()) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(m21064U());
        parcel.writeValue(m21065V());
        parcel.writeValue(m21066W());
        parcel.writeValue(m21067X());
        parcel.writeValue(m21068Y());
        parcel.writeString(m21069Z());
        parcel.writeList(aa());
        parcel.writeString(ab().name());
    }
}
