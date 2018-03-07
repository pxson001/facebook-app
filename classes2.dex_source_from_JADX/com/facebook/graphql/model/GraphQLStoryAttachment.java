package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.interfaces.CachedFeedTrackable;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: local_uri */
public final class GraphQLStoryAttachment extends BaseModel implements HasProperty, CachedFeedTrackable, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLStoryAttachment> CREATOR = new C07781();
    List<GraphQLStoryActionLink> f16983d;
    @Nullable
    GraphQLAppStoreApplication f16984e;
    List<GraphQLAttachmentProperty> f16985f;
    @Nullable
    String f16986g;
    @Nullable
    GraphQLTextWithEntities f16987h;
    @Nullable
    GraphQLNode f16988i;
    boolean f16989j;
    boolean f16990k;
    @Nullable
    GraphQLMedia f16991l;
    @Nullable
    String f16992m;
    @Deprecated
    @Nullable
    String f16993n;
    @Nullable
    GraphQLTextWithEntities f16994o;
    List<GraphQLStoryAttachmentStyleInfo> f16995p;
    List<GraphQLStoryAttachmentStyle> f16996q;
    List<GraphQLStoryAttachment> f16997r;
    @Nullable
    String f16998s;
    @Nullable
    GraphQLNode f16999t;
    @Nullable
    String f17000u;
    @Nullable
    String f17001v;
    @Nullable
    String f17002w;
    @Nullable
    private PropertyBag f17003x = null;

    /* compiled from: local_uri */
    final class C07781 implements Creator<GraphQLStoryAttachment> {
        C07781() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLStoryAttachment(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLStoryAttachment[i];
        }
    }

    @FieldOffset
    @Nullable
    public final /* synthetic */ GraphQLMedia m23968a() {
        return m23979r();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.m27155c();
    }

    public final int hashCode() {
        return System.identityHashCode(this);
    }

    public final boolean equals(Object obj) {
        return HashCodeEqualsUtil.a(this, obj);
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryActionLink> m23971j() {
        this.f16983d = super.m9944a(this.f16983d, 0, GraphQLStoryActionLink.class);
        return (ImmutableList) this.f16983d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLAppStoreApplication m23972k() {
        this.f16984e = (GraphQLAppStoreApplication) super.m9947a(this.f16984e, 1, GraphQLAppStoreApplication.class);
        return this.f16984e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLAttachmentProperty> m23973l() {
        this.f16985f = super.m9944a(this.f16985f, 2, GraphQLAttachmentProperty.class);
        return (ImmutableList) this.f16985f;
    }

    @FieldOffset
    @Nullable
    public final String m23974m() {
        this.f16986g = super.m9948a(this.f16986g, 3);
        return this.f16986g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23975n() {
        this.f16987h = (GraphQLTextWithEntities) super.m9947a(this.f16987h, 4, GraphQLTextWithEntities.class);
        return this.f16987h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNode m23976o() {
        this.f16988i = (GraphQLNode) super.m9947a(this.f16988i, 5, GraphQLNode.class);
        return this.f16988i;
    }

    @FieldOffset
    public final boolean m23977p() {
        m9949a(0, 6);
        return this.f16989j;
    }

    @FieldOffset
    public final boolean m23978q() {
        m9949a(0, 7);
        return this.f16990k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLMedia m23979r() {
        this.f16991l = (GraphQLMedia) super.m9947a(this.f16991l, 8, GraphQLMedia.class);
        return this.f16991l;
    }

    @FieldOffset
    @Nullable
    public final String m23980s() {
        this.f16992m = super.m9948a(this.f16992m, 9);
        return this.f16992m;
    }

    @FieldOffset
    @Nullable
    public final String m23981t() {
        this.f16993n = super.m9948a(this.f16993n, 10);
        return this.f16993n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23982u() {
        this.f16994o = (GraphQLTextWithEntities) super.m9947a(this.f16994o, 11, GraphQLTextWithEntities.class);
        return this.f16994o;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachmentStyleInfo> m23983v() {
        this.f16995p = super.m9944a(this.f16995p, 12, GraphQLStoryAttachmentStyleInfo.class);
        return (ImmutableList) this.f16995p;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachmentStyle> m23984w() {
        this.f16996q = super.m9953b(this.f16996q, 13, GraphQLStoryAttachmentStyle.class);
        return (ImmutableList) this.f16996q;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachment> m23985x() {
        this.f16997r = super.m9944a(this.f16997r, 14, GraphQLStoryAttachment.class);
        return (ImmutableList) this.f16997r;
    }

    @FieldOffset
    @Nullable
    public final String m23986y() {
        this.f16998s = super.m9948a(this.f16998s, 15);
        return this.f16998s;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNode m23987z() {
        this.f16999t = (GraphQLNode) super.m9947a(this.f16999t, 16, GraphQLNode.class);
        return this.f16999t;
    }

    @FieldOffset
    @Nullable
    public final String m23964A() {
        this.f17000u = super.m9948a(this.f17000u, 17);
        return this.f17000u;
    }

    @FieldOffset
    @Nullable
    public final String m23965B() {
        this.f17001v = super.m9948a(this.f17001v, 18);
        return this.f17001v;
    }

    @FieldOffset
    @Nullable
    public final String m23966C() {
        this.f17002w = super.m9948a(this.f17002w, 19);
        return this.f17002w;
    }

    public final int jK_() {
        return -1267730472;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLStoryAttachment graphQLStoryAttachment;
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLAppStoreApplication graphQLAppStoreApplication;
        Builder a;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLNode graphQLNode;
        GraphQLMedia graphQLMedia;
        m9958h();
        if (m23971j() != null) {
            Builder a2 = ModelHelper.m23097a(m23971j(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                graphQLStoryAttachment = (GraphQLStoryAttachment) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLStoryAttachment.f16983d = a2.m1068b();
                graphQLVisitableModel = graphQLStoryAttachment;
                if (m23972k() != null) {
                    graphQLAppStoreApplication = (GraphQLAppStoreApplication) graphQLModelMutatingVisitor.mo2928b(m23972k());
                    if (m23972k() != graphQLAppStoreApplication) {
                        graphQLVisitableModel = (GraphQLStoryAttachment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f16984e = graphQLAppStoreApplication;
                    }
                }
                if (m23973l() != null) {
                    a = ModelHelper.m23097a(m23973l(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLStoryAttachment = (GraphQLStoryAttachment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLStoryAttachment.f16985f = a.m1068b();
                        graphQLVisitableModel = graphQLStoryAttachment;
                    }
                }
                if (m23975n() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23975n());
                    if (m23975n() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLStoryAttachment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f16987h = graphQLTextWithEntities;
                    }
                }
                if (m23976o() != null) {
                    graphQLNode = (GraphQLNode) graphQLModelMutatingVisitor.mo2928b(m23976o());
                    if (m23976o() != graphQLNode) {
                        graphQLVisitableModel = (GraphQLStoryAttachment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f16988i = graphQLNode;
                    }
                }
                if (m23979r() != null) {
                    graphQLMedia = (GraphQLMedia) graphQLModelMutatingVisitor.mo2928b(m23979r());
                    if (m23979r() != graphQLMedia) {
                        graphQLVisitableModel = (GraphQLStoryAttachment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f16991l = graphQLMedia;
                    }
                }
                if (m23982u() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23982u());
                    if (m23982u() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLStoryAttachment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f16994o = graphQLTextWithEntities;
                    }
                }
                if (m23983v() != null) {
                    a = ModelHelper.m23097a(m23983v(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLStoryAttachment = (GraphQLStoryAttachment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLStoryAttachment.f16995p = a.m1068b();
                        graphQLVisitableModel = graphQLStoryAttachment;
                    }
                }
                if (m23985x() != null) {
                    a = ModelHelper.m23097a(m23985x(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLStoryAttachment = (GraphQLStoryAttachment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLStoryAttachment.f16997r = a.m1068b();
                        graphQLVisitableModel = graphQLStoryAttachment;
                    }
                }
                if (m23987z() != null) {
                    graphQLNode = (GraphQLNode) graphQLModelMutatingVisitor.mo2928b(m23987z());
                    if (m23987z() != graphQLNode) {
                        graphQLVisitableModel = (GraphQLStoryAttachment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f16999t = graphQLNode;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m23972k() != null) {
            graphQLAppStoreApplication = (GraphQLAppStoreApplication) graphQLModelMutatingVisitor.mo2928b(m23972k());
            if (m23972k() != graphQLAppStoreApplication) {
                graphQLVisitableModel = (GraphQLStoryAttachment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16984e = graphQLAppStoreApplication;
            }
        }
        if (m23973l() != null) {
            a = ModelHelper.m23097a(m23973l(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLStoryAttachment = (GraphQLStoryAttachment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLStoryAttachment.f16985f = a.m1068b();
                graphQLVisitableModel = graphQLStoryAttachment;
            }
        }
        if (m23975n() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23975n());
            if (m23975n() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLStoryAttachment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16987h = graphQLTextWithEntities;
            }
        }
        if (m23976o() != null) {
            graphQLNode = (GraphQLNode) graphQLModelMutatingVisitor.mo2928b(m23976o());
            if (m23976o() != graphQLNode) {
                graphQLVisitableModel = (GraphQLStoryAttachment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16988i = graphQLNode;
            }
        }
        if (m23979r() != null) {
            graphQLMedia = (GraphQLMedia) graphQLModelMutatingVisitor.mo2928b(m23979r());
            if (m23979r() != graphQLMedia) {
                graphQLVisitableModel = (GraphQLStoryAttachment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16991l = graphQLMedia;
            }
        }
        if (m23982u() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23982u());
            if (m23982u() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLStoryAttachment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16994o = graphQLTextWithEntities;
            }
        }
        if (m23983v() != null) {
            a = ModelHelper.m23097a(m23983v(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLStoryAttachment = (GraphQLStoryAttachment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLStoryAttachment.f16995p = a.m1068b();
                graphQLVisitableModel = graphQLStoryAttachment;
            }
        }
        if (m23985x() != null) {
            a = ModelHelper.m23097a(m23985x(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLStoryAttachment = (GraphQLStoryAttachment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLStoryAttachment.f16997r = a.m1068b();
                graphQLVisitableModel = graphQLStoryAttachment;
            }
        }
        if (m23987z() != null) {
            graphQLNode = (GraphQLNode) graphQLModelMutatingVisitor.mo2928b(m23987z());
            if (m23987z() != graphQLNode) {
                graphQLVisitableModel = (GraphQLStoryAttachment) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16999t = graphQLNode;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLStoryAttachment() {
        super(21);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16989j = mutableFlatBuffer.m21540a(i, 6);
        this.f16990k = mutableFlatBuffer.m21540a(i, 7);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m23971j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23972k());
        int a3 = ModelHelper.m23094a(flatBufferBuilder, m23973l());
        int b = flatBufferBuilder.m21502b(m23974m());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m23975n());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m23976o());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m23979r());
        int b2 = flatBufferBuilder.m21502b(m23980s());
        int b3 = flatBufferBuilder.m21502b(m23981t());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m23982u());
        int a8 = ModelHelper.m23094a(flatBufferBuilder, m23983v());
        int e = flatBufferBuilder.m21514e(m23984w());
        int a9 = ModelHelper.m23094a(flatBufferBuilder, m23985x());
        int b4 = flatBufferBuilder.m21502b(m23986y());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23987z());
        int b5 = flatBufferBuilder.m21502b(m23964A());
        int b6 = flatBufferBuilder.m21502b(m23965B());
        int b7 = flatBufferBuilder.m21502b(m23966C());
        flatBufferBuilder.m21510c(20);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(2, a3);
        flatBufferBuilder.m21507b(3, b);
        flatBufferBuilder.m21507b(4, a4);
        flatBufferBuilder.m21507b(5, a5);
        flatBufferBuilder.m21498a(6, m23977p());
        flatBufferBuilder.m21498a(7, m23978q());
        flatBufferBuilder.m21507b(8, a6);
        flatBufferBuilder.m21507b(9, b2);
        flatBufferBuilder.m21507b(10, b3);
        flatBufferBuilder.m21507b(11, a7);
        flatBufferBuilder.m21507b(12, a8);
        flatBufferBuilder.m21507b(13, e);
        flatBufferBuilder.m21507b(14, a9);
        flatBufferBuilder.m21507b(15, b4);
        flatBufferBuilder.m21507b(16, a10);
        flatBufferBuilder.m21507b(17, b5);
        flatBufferBuilder.m21507b(18, b6);
        flatBufferBuilder.m21507b(19, b7);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLStoryAttachment(Parcel parcel) {
        boolean z = true;
        super(21);
        this.f16983d = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryActionLink.class.getClassLoader()));
        this.f16984e = (GraphQLAppStoreApplication) parcel.readValue(GraphQLAppStoreApplication.class.getClassLoader());
        this.f16985f = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLAttachmentProperty.class.getClassLoader()));
        this.f16986g = parcel.readString();
        this.f16987h = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16988i = (GraphQLNode) parcel.readValue(GraphQLNode.class.getClassLoader());
        this.f16989j = parcel.readByte() == (byte) 1;
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f16990k = z;
        this.f16991l = (GraphQLMedia) parcel.readValue(GraphQLMedia.class.getClassLoader());
        this.f16992m = parcel.readString();
        this.f16993n = parcel.readString();
        this.f16994o = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16995p = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryAttachmentStyleInfo.class.getClassLoader()));
        this.f16996q = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryAttachmentStyle.class.getClassLoader()));
        this.f16997r = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLStoryAttachment.class.getClassLoader()));
        this.f16998s = parcel.readString();
        this.f16999t = (GraphQLNode) parcel.readValue(GraphQLNode.class.getClassLoader());
        this.f17000u = parcel.readString();
        this.f17001v = parcel.readString();
        this.f17002w = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeList(m23971j());
        parcel.writeValue(m23972k());
        parcel.writeList(m23973l());
        parcel.writeString(m23974m());
        parcel.writeValue(m23975n());
        parcel.writeValue(m23976o());
        parcel.writeByte((byte) (m23977p() ? 1 : 0));
        if (!m23978q()) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(m23979r());
        parcel.writeString(m23980s());
        parcel.writeString(m23981t());
        parcel.writeValue(m23982u());
        parcel.writeList(m23983v());
        parcel.writeList(m23984w());
        parcel.writeList(m23985x());
        parcel.writeString(m23986y());
        parcel.writeValue(m23987z());
        parcel.writeString(m23964A());
        parcel.writeString(m23965B());
        parcel.writeString(m23966C());
    }

    public GraphQLStoryAttachment(Builder builder) {
        super(21);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16983d = builder.d;
        this.f16984e = builder.e;
        this.f16985f = builder.f;
        this.f16986g = builder.g;
        this.f16987h = builder.h;
        this.f16988i = builder.i;
        this.f16989j = builder.j;
        this.f16990k = builder.k;
        this.f16991l = builder.l;
        this.f16992m = builder.m;
        this.f16993n = builder.n;
        this.f16994o = builder.o;
        this.f16995p = builder.p;
        this.f16996q = builder.q;
        this.f16997r = builder.r;
        this.f16998s = builder.s;
        this.f16999t = builder.t;
        this.f17000u = builder.u;
        this.f17001v = builder.v;
        this.f17002w = builder.w;
        this.f17003x = builder.x;
    }

    public final PropertyBag U_() {
        if (this.f17003x == null) {
            this.f17003x = new PropertyBag();
        }
        return this.f17003x;
    }
}
