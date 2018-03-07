package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLMusicType;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: link */
public final class GraphQLOpenGraphObject extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLOpenGraphObject> CREATOR = new 1();
    @Nullable
    GraphQLOpenGraphMetadata f17438A;
    @Nullable
    GraphQLImage f17439B;
    @Nullable
    String f17440C;
    GraphQLPlaceType f17441D;
    List<GraphQLAudio> f17442E;
    @Nullable
    GraphQLImage f17443F;
    @Nullable
    GraphQLImage f17444G;
    @Nullable
    GraphQLImage f17445H;
    @Nullable
    GraphQLImage f17446I;
    @Nullable
    GraphQLImage f17447J;
    @Nullable
    GraphQLPhoto f17448K;
    @Nullable
    GraphQLImage f17449L;
    boolean f17450M;
    @Nullable
    GraphQLTimelineAppCollection f17451N;
    @Nullable
    GraphQLStreamingImage f17452O;
    @Nullable
    GraphQLImage f17453P;
    @Nullable
    GraphQLOpenGraphMetadata f17454Q;
    @Nullable
    String f17455R;
    GraphQLSavedState f17456S;
    List<GraphQLTimelineAppCollection> f17457T;
    List<GraphQLTimelineAppCollection> f17458U;
    List<String> f17459d;
    @Nullable
    GraphQLApplication f17460e;
    boolean f17461f;
    @Nullable
    GraphQLImage f17462g;
    @Nullable
    String f17463h;
    @Nullable
    String f17464i;
    long f17465j;
    @Nullable
    GraphQLImage f17466k;
    @Nullable
    GraphQLFeedback f17467l;
    @Nullable
    GraphQLExternalUrl f17468m;
    @Deprecated
    boolean f17469n;
    @Nullable
    String f17470o;
    @Nullable
    GraphQLImage f17471p;
    @Deprecated
    @Nullable
    GraphQLInlineActivitiesConnection f17472q;
    boolean f17473r;
    @Nullable
    GraphQLLocation f17474s;
    @Nullable
    GraphQLGeoRectangle f17475t;
    List<GraphQLLocation> f17476u;
    int f17477v;
    GraphQLMusicType f17478w;
    @Deprecated
    List<GraphQLOpenGraphObject> f17479x;
    @Nullable
    String f17480y;
    @Nullable
    GraphQLStoryAttachment f17481z;

    @FieldOffset
    public final ImmutableList<String> m24572j() {
        this.f17459d = super.m9943a(this.f17459d, 0);
        return (ImmutableList) this.f17459d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLApplication m24573k() {
        this.f17460e = (GraphQLApplication) super.m9947a(this.f17460e, 1, GraphQLApplication.class);
        return this.f17460e;
    }

    @FieldOffset
    public final boolean m24574l() {
        m9949a(0, 2);
        return this.f17461f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24575m() {
        this.f17462g = (GraphQLImage) super.m9947a(this.f17462g, 3, GraphQLImage.class);
        return this.f17462g;
    }

    @FieldOffset
    @Nullable
    public final String m24576n() {
        this.f17463h = super.m9948a(this.f17463h, 4);
        return this.f17463h;
    }

    @FieldOffset
    @Nullable
    public final String m24577o() {
        this.f17464i = super.m9948a(this.f17464i, 5);
        return this.f17464i;
    }

    @FieldOffset
    public final long m24578p() {
        m9949a(0, 6);
        return this.f17465j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24579q() {
        this.f17466k = (GraphQLImage) super.m9947a(this.f17466k, 8, GraphQLImage.class);
        return this.f17466k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback m24580r() {
        this.f17467l = (GraphQLFeedback) super.m9947a(this.f17467l, 9, GraphQLFeedback.class);
        return this.f17467l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLExternalUrl m24581s() {
        this.f17468m = (GraphQLExternalUrl) super.m9947a(this.f17468m, 10, GraphQLExternalUrl.class);
        return this.f17468m;
    }

    @FieldOffset
    public final boolean m24582t() {
        m9949a(1, 3);
        return this.f17469n;
    }

    @FieldOffset
    @Nullable
    public final String m24583u() {
        this.f17470o = super.m9948a(this.f17470o, 12);
        return this.f17470o;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24584v() {
        this.f17471p = (GraphQLImage) super.m9947a(this.f17471p, 13, GraphQLImage.class);
        return this.f17471p;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInlineActivitiesConnection m24585w() {
        this.f17472q = (GraphQLInlineActivitiesConnection) super.m9947a(this.f17472q, 14, GraphQLInlineActivitiesConnection.class);
        return this.f17472q;
    }

    @FieldOffset
    public final boolean m24586x() {
        m9949a(1, 7);
        return this.f17473r;
    }

    @FieldOffset
    @Nullable
    public final GraphQLLocation m24587y() {
        this.f17474s = (GraphQLLocation) super.m9947a(this.f17474s, 16, GraphQLLocation.class);
        return this.f17474s;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGeoRectangle m24588z() {
        this.f17475t = (GraphQLGeoRectangle) super.m9947a(this.f17475t, 17, GraphQLGeoRectangle.class);
        return this.f17475t;
    }

    @FieldOffset
    public final ImmutableList<GraphQLLocation> m24542A() {
        this.f17476u = super.m9944a(this.f17476u, 18, GraphQLLocation.class);
        return (ImmutableList) this.f17476u;
    }

    @FieldOffset
    public final int m24543B() {
        m9949a(2, 3);
        return this.f17477v;
    }

    @FieldOffset
    public final GraphQLMusicType m24544C() {
        this.f17478w = (GraphQLMusicType) super.m9945a(this.f17478w, 20, GraphQLMusicType.class, GraphQLMusicType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17478w;
    }

    @FieldOffset
    public final ImmutableList<GraphQLOpenGraphObject> m24545D() {
        this.f17479x = super.m9944a(this.f17479x, 21, GraphQLOpenGraphObject.class);
        return (ImmutableList) this.f17479x;
    }

    @FieldOffset
    @Nullable
    public final String m24546E() {
        this.f17480y = super.m9948a(this.f17480y, 22);
        return this.f17480y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStoryAttachment m24547F() {
        this.f17481z = (GraphQLStoryAttachment) super.m9947a(this.f17481z, 23, GraphQLStoryAttachment.class);
        return this.f17481z;
    }

    @FieldOffset
    @Nullable
    public final GraphQLOpenGraphMetadata m24548G() {
        this.f17438A = (GraphQLOpenGraphMetadata) super.m9947a(this.f17438A, 24, GraphQLOpenGraphMetadata.class);
        return this.f17438A;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24549H() {
        this.f17439B = (GraphQLImage) super.m9947a(this.f17439B, 25, GraphQLImage.class);
        return this.f17439B;
    }

    @FieldOffset
    @Nullable
    public final String m24550I() {
        this.f17440C = super.m9948a(this.f17440C, 26);
        return this.f17440C;
    }

    @FieldOffset
    public final GraphQLPlaceType m24551J() {
        this.f17441D = (GraphQLPlaceType) super.m9945a(this.f17441D, 27, GraphQLPlaceType.class, GraphQLPlaceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17441D;
    }

    @FieldOffset
    public final ImmutableList<GraphQLAudio> m24552K() {
        this.f17442E = super.m9944a(this.f17442E, 28, GraphQLAudio.class);
        return (ImmutableList) this.f17442E;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24553L() {
        this.f17443F = (GraphQLImage) super.m9947a(this.f17443F, 29, GraphQLImage.class);
        return this.f17443F;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24554M() {
        this.f17444G = (GraphQLImage) super.m9947a(this.f17444G, 30, GraphQLImage.class);
        return this.f17444G;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24555N() {
        this.f17445H = (GraphQLImage) super.m9947a(this.f17445H, 31, GraphQLImage.class);
        return this.f17445H;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24556O() {
        this.f17446I = (GraphQLImage) super.m9947a(this.f17446I, 32, GraphQLImage.class);
        return this.f17446I;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24557P() {
        this.f17447J = (GraphQLImage) super.m9947a(this.f17447J, 33, GraphQLImage.class);
        return this.f17447J;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhoto m24558Q() {
        this.f17448K = (GraphQLPhoto) super.m9947a(this.f17448K, 34, GraphQLPhoto.class);
        return this.f17448K;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24559R() {
        this.f17449L = (GraphQLImage) super.m9947a(this.f17449L, 35, GraphQLImage.class);
        return this.f17449L;
    }

    @FieldOffset
    public final boolean m24560S() {
        m9949a(4, 4);
        return this.f17450M;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTimelineAppCollection m24561T() {
        this.f17451N = (GraphQLTimelineAppCollection) super.m9947a(this.f17451N, 37, GraphQLTimelineAppCollection.class);
        return this.f17451N;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStreamingImage m24562U() {
        this.f17452O = (GraphQLStreamingImage) super.m9947a(this.f17452O, 38, GraphQLStreamingImage.class);
        return this.f17452O;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24563V() {
        this.f17453P = (GraphQLImage) super.m9947a(this.f17453P, 39, GraphQLImage.class);
        return this.f17453P;
    }

    @FieldOffset
    @Nullable
    public final GraphQLOpenGraphMetadata m24564W() {
        this.f17454Q = (GraphQLOpenGraphMetadata) super.m9947a(this.f17454Q, 40, GraphQLOpenGraphMetadata.class);
        return this.f17454Q;
    }

    @FieldOffset
    @Nullable
    public final String m24565X() {
        this.f17455R = super.m9948a(this.f17455R, 41);
        return this.f17455R;
    }

    @FieldOffset
    public final GraphQLSavedState m24566Y() {
        this.f17456S = (GraphQLSavedState) super.m9945a(this.f17456S, 42, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17456S;
    }

    @FieldOffset
    public final ImmutableList<GraphQLTimelineAppCollection> m24567Z() {
        this.f17457T = super.m9944a(this.f17457T, 43, GraphQLTimelineAppCollection.class);
        return (ImmutableList) this.f17457T;
    }

    @FieldOffset
    public final ImmutableList<GraphQLTimelineAppCollection> aa() {
        this.f17458U = super.m9944a(this.f17458U, 44, GraphQLTimelineAppCollection.class);
        return (ImmutableList) this.f17458U;
    }

    @Nullable
    public final String mo2834a() {
        return m24583u();
    }

    public final int jK_() {
        return -1304042141;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLImage graphQLImage;
        Builder a;
        GraphQLOpenGraphMetadata graphQLOpenGraphMetadata;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24573k() != null) {
            GraphQLApplication graphQLApplication = (GraphQLApplication) graphQLModelMutatingVisitor.mo2928b(m24573k());
            if (m24573k() != graphQLApplication) {
                graphQLVisitableModel = (GraphQLOpenGraphObject) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17460e = graphQLApplication;
            }
        }
        if (m24575m() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24575m());
            if (m24575m() != graphQLImage) {
                graphQLVisitableModel = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17462g = graphQLImage;
            }
        }
        if (m24579q() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24579q());
            if (m24579q() != graphQLImage) {
                graphQLVisitableModel = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17466k = graphQLImage;
            }
        }
        if (m24580r() != null) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.mo2928b(m24580r());
            if (m24580r() != graphQLFeedback) {
                graphQLVisitableModel = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17467l = graphQLFeedback;
            }
        }
        if (m24581s() != null) {
            GraphQLExternalUrl graphQLExternalUrl = (GraphQLExternalUrl) graphQLModelMutatingVisitor.mo2928b(m24581s());
            if (m24581s() != graphQLExternalUrl) {
                graphQLVisitableModel = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17468m = graphQLExternalUrl;
            }
        }
        if (m24584v() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24584v());
            if (m24584v() != graphQLImage) {
                graphQLVisitableModel = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17471p = graphQLImage;
            }
        }
        if (m24585w() != null) {
            GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection = (GraphQLInlineActivitiesConnection) graphQLModelMutatingVisitor.mo2928b(m24585w());
            if (m24585w() != graphQLInlineActivitiesConnection) {
                graphQLVisitableModel = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17472q = graphQLInlineActivitiesConnection;
            }
        }
        if (m24587y() != null) {
            GraphQLLocation graphQLLocation = (GraphQLLocation) graphQLModelMutatingVisitor.mo2928b(m24587y());
            if (m24587y() != graphQLLocation) {
                graphQLVisitableModel = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17474s = graphQLLocation;
            }
        }
        if (m24588z() != null) {
            GraphQLGeoRectangle graphQLGeoRectangle = (GraphQLGeoRectangle) graphQLModelMutatingVisitor.mo2928b(m24588z());
            if (m24588z() != graphQLGeoRectangle) {
                graphQLVisitableModel = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17475t = graphQLGeoRectangle;
            }
        }
        if (m24542A() != null) {
            a = ModelHelper.m23097a(m24542A(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLOpenGraphObject graphQLOpenGraphObject = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLOpenGraphObject.f17476u = a.m1068b();
                graphQLVisitableModel = graphQLOpenGraphObject;
            }
        }
        if (m24545D() != null) {
            a = ModelHelper.m23097a(m24545D(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLOpenGraphObject = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLOpenGraphObject.f17479x = a.m1068b();
                graphQLVisitableModel = graphQLOpenGraphObject;
            }
        }
        if (m24547F() != null) {
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) graphQLModelMutatingVisitor.mo2928b(m24547F());
            if (m24547F() != graphQLStoryAttachment) {
                graphQLVisitableModel = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17481z = graphQLStoryAttachment;
            }
        }
        if (m24548G() != null) {
            graphQLOpenGraphMetadata = (GraphQLOpenGraphMetadata) graphQLModelMutatingVisitor.mo2928b(m24548G());
            if (m24548G() != graphQLOpenGraphMetadata) {
                graphQLVisitableModel = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17438A = graphQLOpenGraphMetadata;
            }
        }
        if (m24549H() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24549H());
            if (m24549H() != graphQLImage) {
                graphQLVisitableModel = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17439B = graphQLImage;
            }
        }
        if (m24552K() != null) {
            a = ModelHelper.m23097a(m24552K(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLOpenGraphObject = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLOpenGraphObject.f17442E = a.m1068b();
                graphQLVisitableModel = graphQLOpenGraphObject;
            }
        }
        if (m24553L() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24553L());
            if (m24553L() != graphQLImage) {
                graphQLVisitableModel = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17443F = graphQLImage;
            }
        }
        if (m24554M() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24554M());
            if (m24554M() != graphQLImage) {
                graphQLVisitableModel = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17444G = graphQLImage;
            }
        }
        if (m24555N() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24555N());
            if (m24555N() != graphQLImage) {
                graphQLVisitableModel = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17445H = graphQLImage;
            }
        }
        if (m24556O() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24556O());
            if (m24556O() != graphQLImage) {
                graphQLVisitableModel = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17446I = graphQLImage;
            }
        }
        if (m24557P() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24557P());
            if (m24557P() != graphQLImage) {
                graphQLVisitableModel = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17447J = graphQLImage;
            }
        }
        if (m24558Q() != null) {
            GraphQLPhoto graphQLPhoto = (GraphQLPhoto) graphQLModelMutatingVisitor.mo2928b(m24558Q());
            if (m24558Q() != graphQLPhoto) {
                graphQLVisitableModel = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17448K = graphQLPhoto;
            }
        }
        if (m24559R() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24559R());
            if (m24559R() != graphQLImage) {
                graphQLVisitableModel = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17449L = graphQLImage;
            }
        }
        if (m24561T() != null) {
            GraphQLTimelineAppCollection graphQLTimelineAppCollection = (GraphQLTimelineAppCollection) graphQLModelMutatingVisitor.mo2928b(m24561T());
            if (m24561T() != graphQLTimelineAppCollection) {
                graphQLVisitableModel = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17451N = graphQLTimelineAppCollection;
            }
        }
        if (m24562U() != null) {
            GraphQLStreamingImage graphQLStreamingImage = (GraphQLStreamingImage) graphQLModelMutatingVisitor.mo2928b(m24562U());
            if (m24562U() != graphQLStreamingImage) {
                graphQLVisitableModel = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17452O = graphQLStreamingImage;
            }
        }
        if (m24563V() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24563V());
            if (m24563V() != graphQLImage) {
                graphQLVisitableModel = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17453P = graphQLImage;
            }
        }
        if (m24564W() != null) {
            graphQLOpenGraphMetadata = (GraphQLOpenGraphMetadata) graphQLModelMutatingVisitor.mo2928b(m24564W());
            if (m24564W() != graphQLOpenGraphMetadata) {
                graphQLVisitableModel = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17454Q = graphQLOpenGraphMetadata;
            }
        }
        if (m24567Z() != null) {
            a = ModelHelper.m23097a(m24567Z(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLOpenGraphObject = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLOpenGraphObject.f17457T = a.m1068b();
                graphQLVisitableModel = graphQLOpenGraphObject;
            }
        }
        if (aa() != null) {
            a = ModelHelper.m23097a(aa(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLOpenGraphObject = (GraphQLOpenGraphObject) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLOpenGraphObject.f17458U = a.m1068b();
                graphQLVisitableModel = graphQLOpenGraphObject;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLOpenGraphObject() {
        super(46);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17461f = mutableFlatBuffer.m21540a(i, 2);
        this.f17465j = mutableFlatBuffer.m21525a(i, 6, 0);
        this.f17469n = mutableFlatBuffer.m21540a(i, 11);
        this.f17473r = mutableFlatBuffer.m21540a(i, 15);
        this.f17477v = mutableFlatBuffer.m21524a(i, 19, 0);
        this.f17450M = mutableFlatBuffer.m21540a(i, 36);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int c = flatBufferBuilder.m21509c(m24572j());
        int a = ModelHelper.m23093a(flatBufferBuilder, m24573k());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24575m());
        int b = flatBufferBuilder.m21502b(m24576n());
        int b2 = flatBufferBuilder.m21502b(m24577o());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m24579q());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m24580r());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m24581s());
        int b3 = flatBufferBuilder.m21502b(m24583u());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m24584v());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m24585w());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m24587y());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, m24588z());
        int a10 = ModelHelper.m23094a(flatBufferBuilder, m24542A());
        int a11 = ModelHelper.m23094a(flatBufferBuilder, m24545D());
        int b4 = flatBufferBuilder.m21502b(m24546E());
        int a12 = ModelHelper.m23093a(flatBufferBuilder, m24547F());
        int a13 = ModelHelper.m23093a(flatBufferBuilder, m24548G());
        int a14 = ModelHelper.m23093a(flatBufferBuilder, m24549H());
        int b5 = flatBufferBuilder.m21502b(m24550I());
        int a15 = ModelHelper.m23094a(flatBufferBuilder, m24552K());
        int a16 = ModelHelper.m23093a(flatBufferBuilder, m24553L());
        int a17 = ModelHelper.m23093a(flatBufferBuilder, m24554M());
        int a18 = ModelHelper.m23093a(flatBufferBuilder, m24555N());
        int a19 = ModelHelper.m23093a(flatBufferBuilder, m24556O());
        int a20 = ModelHelper.m23093a(flatBufferBuilder, m24557P());
        int a21 = ModelHelper.m23093a(flatBufferBuilder, m24558Q());
        int a22 = ModelHelper.m23093a(flatBufferBuilder, m24559R());
        int a23 = ModelHelper.m23093a(flatBufferBuilder, m24561T());
        int a24 = ModelHelper.m23093a(flatBufferBuilder, m24562U());
        int a25 = ModelHelper.m23093a(flatBufferBuilder, m24563V());
        int a26 = ModelHelper.m23093a(flatBufferBuilder, m24564W());
        int b6 = flatBufferBuilder.m21502b(m24565X());
        int a27 = ModelHelper.m23094a(flatBufferBuilder, m24567Z());
        int a28 = ModelHelper.m23094a(flatBufferBuilder, aa());
        flatBufferBuilder.m21510c(45);
        flatBufferBuilder.m21507b(0, c);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21498a(2, m24574l());
        flatBufferBuilder.m21507b(3, a2);
        flatBufferBuilder.m21507b(4, b);
        flatBufferBuilder.m21507b(5, b2);
        flatBufferBuilder.m21495a(6, m24578p(), 0);
        flatBufferBuilder.m21507b(8, a3);
        flatBufferBuilder.m21507b(9, a4);
        flatBufferBuilder.m21507b(10, a5);
        flatBufferBuilder.m21498a(11, m24582t());
        flatBufferBuilder.m21507b(12, b3);
        flatBufferBuilder.m21507b(13, a6);
        flatBufferBuilder.m21507b(14, a7);
        flatBufferBuilder.m21498a(15, m24586x());
        flatBufferBuilder.m21507b(16, a8);
        flatBufferBuilder.m21507b(17, a9);
        flatBufferBuilder.m21507b(18, a10);
        flatBufferBuilder.m21494a(19, m24543B(), 0);
        flatBufferBuilder.m21496a(20, m24544C() == GraphQLMusicType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m24544C());
        flatBufferBuilder.m21507b(21, a11);
        flatBufferBuilder.m21507b(22, b4);
        flatBufferBuilder.m21507b(23, a12);
        flatBufferBuilder.m21507b(24, a13);
        flatBufferBuilder.m21507b(25, a14);
        flatBufferBuilder.m21507b(26, b5);
        flatBufferBuilder.m21496a(27, m24551J() == GraphQLPlaceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m24551J());
        flatBufferBuilder.m21507b(28, a15);
        flatBufferBuilder.m21507b(29, a16);
        flatBufferBuilder.m21507b(30, a17);
        flatBufferBuilder.m21507b(31, a18);
        flatBufferBuilder.m21507b(32, a19);
        flatBufferBuilder.m21507b(33, a20);
        flatBufferBuilder.m21507b(34, a21);
        flatBufferBuilder.m21507b(35, a22);
        flatBufferBuilder.m21498a(36, m24560S());
        flatBufferBuilder.m21507b(37, a23);
        flatBufferBuilder.m21507b(38, a24);
        flatBufferBuilder.m21507b(39, a25);
        flatBufferBuilder.m21507b(40, a26);
        flatBufferBuilder.m21507b(41, b6);
        flatBufferBuilder.m21496a(42, m24566Y() == GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m24566Y());
        flatBufferBuilder.m21507b(43, a27);
        flatBufferBuilder.m21507b(44, a28);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLOpenGraphObject(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(46);
        this.f17459d = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f17460e = (GraphQLApplication) parcel.readValue(GraphQLApplication.class.getClassLoader());
        this.f17461f = parcel.readByte() == (byte) 1;
        this.f17462g = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17463h = parcel.readString();
        this.f17464i = parcel.readString();
        this.f17465j = parcel.readLong();
        this.f17466k = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17467l = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f17468m = (GraphQLExternalUrl) parcel.readValue(GraphQLExternalUrl.class.getClassLoader());
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17469n = z;
        this.f17470o = parcel.readString();
        this.f17471p = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17472q = (GraphQLInlineActivitiesConnection) parcel.readValue(GraphQLInlineActivitiesConnection.class.getClassLoader());
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17473r = z;
        this.f17474s = (GraphQLLocation) parcel.readValue(GraphQLLocation.class.getClassLoader());
        this.f17475t = (GraphQLGeoRectangle) parcel.readValue(GraphQLGeoRectangle.class.getClassLoader());
        this.f17476u = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLLocation.class.getClassLoader()));
        this.f17477v = parcel.readInt();
        this.f17478w = GraphQLMusicType.fromString(parcel.readString());
        this.f17479x = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLOpenGraphObject.class.getClassLoader()));
        this.f17480y = parcel.readString();
        this.f17481z = (GraphQLStoryAttachment) parcel.readValue(GraphQLStoryAttachment.class.getClassLoader());
        this.f17438A = (GraphQLOpenGraphMetadata) parcel.readValue(GraphQLOpenGraphMetadata.class.getClassLoader());
        this.f17439B = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17440C = parcel.readString();
        this.f17441D = GraphQLPlaceType.fromString(parcel.readString());
        this.f17442E = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLAudio.class.getClassLoader()));
        this.f17443F = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17444G = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17445H = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17446I = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17447J = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17448K = (GraphQLPhoto) parcel.readValue(GraphQLPhoto.class.getClassLoader());
        this.f17449L = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f17450M = z2;
        this.f17451N = (GraphQLTimelineAppCollection) parcel.readValue(GraphQLTimelineAppCollection.class.getClassLoader());
        this.f17452O = (GraphQLStreamingImage) parcel.readValue(GraphQLStreamingImage.class.getClassLoader());
        this.f17453P = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17454Q = (GraphQLOpenGraphMetadata) parcel.readValue(GraphQLOpenGraphMetadata.class.getClassLoader());
        this.f17455R = parcel.readString();
        this.f17456S = GraphQLSavedState.fromString(parcel.readString());
        this.f17457T = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLTimelineAppCollection.class.getClassLoader()));
        this.f17458U = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLTimelineAppCollection.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeList(m24572j());
        parcel.writeValue(m24573k());
        parcel.writeByte((byte) (m24574l() ? 1 : 0));
        parcel.writeValue(m24575m());
        parcel.writeString(m24576n());
        parcel.writeString(m24577o());
        parcel.writeLong(m24578p());
        parcel.writeValue(m24579q());
        parcel.writeValue(m24580r());
        parcel.writeValue(m24581s());
        if (m24582t()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(m24583u());
        parcel.writeValue(m24584v());
        parcel.writeValue(m24585w());
        if (m24586x()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(m24587y());
        parcel.writeValue(m24588z());
        parcel.writeList(m24542A());
        parcel.writeInt(m24543B());
        parcel.writeString(m24544C().name());
        parcel.writeList(m24545D());
        parcel.writeString(m24546E());
        parcel.writeValue(m24547F());
        parcel.writeValue(m24548G());
        parcel.writeValue(m24549H());
        parcel.writeString(m24550I());
        parcel.writeString(m24551J().name());
        parcel.writeList(m24552K());
        parcel.writeValue(m24553L());
        parcel.writeValue(m24554M());
        parcel.writeValue(m24555N());
        parcel.writeValue(m24556O());
        parcel.writeValue(m24557P());
        parcel.writeValue(m24558Q());
        parcel.writeValue(m24559R());
        if (!m24560S()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeValue(m24561T());
        parcel.writeValue(m24562U());
        parcel.writeValue(m24563V());
        parcel.writeValue(m24564W());
        parcel.writeString(m24565X());
        parcel.writeString(m24566Y().name());
        parcel.writeList(m24567Z());
        parcel.writeList(aa());
    }
}
