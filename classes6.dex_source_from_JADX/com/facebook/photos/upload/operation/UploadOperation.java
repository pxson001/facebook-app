package com.facebook.photos.upload.operation;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.commerce.publishing.graphql.CommerceProductItemMutateParams;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.time.SystemClock;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.lifeevent.protocol.ComposerLifeEventParam;
import com.facebook.composer.protocol.PostReviewParams;
import com.facebook.composer.publish.common.EditPostParams;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLBudgetRecommendationData;
import com.facebook.ipc.composer.model.MinutiaeTag;
import com.facebook.ipc.composer.model.ProductItemAttachment;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.photos.base.analytics.LoggingTypes.UploadType;
import com.facebook.photos.tagging.store.FaceBoxStoreCopy;
import com.facebook.photos.tagging.store.TagStoreCopy;
import com.facebook.photos.upload.protocol.PhotoUploadPrivacy;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.share.model.ComposerAppAttribution;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: global_search */
public class UploadOperation implements Parcelable {
    public static final Creator<UploadOperation> CREATOR = new C08851();
    public final ComposerAppAttribution f13752A;
    public final boolean f13753B;
    public final boolean f13754C;
    public final UploadOperationCounters f13755D;
    public UploadInterruptionCause f13756E;
    public UploadRecords f13757F;
    private final int f13758G;
    public final GraphQLBudgetRecommendationData f13759H;
    public final ProductItemAttachment f13760I;
    public final long f13761J;
    public final List<Long> f13762K;
    public final String f13763L;
    public final int f13764M;
    public final int f13765N;
    private boolean f13766O;
    public boolean f13767P;
    public int f13768Q;
    public boolean f13769R;
    public boolean f13770S;
    public final int f13771T;
    public int f13772U;
    public int f13773V;
    private TagStoreCopy f13774W;
    private FaceBoxStoreCopy f13775X;
    public final String f13776Y;
    public boolean f13777Z;
    public final ImmutableList<MediaItem> f13778a;
    @Nullable
    public final String aa;
    @Nullable
    private final String ab;
    private final long ac;
    @Nullable
    public final String ad;
    private final boolean ae;
    public final CommerceProductItemMutateParams af;
    @Nullable
    public final String ag;
    @Nullable
    public final EditPostParams ah;
    @Nullable
    public final PromptAnalytics ai;
    @Nullable
    public final ImmutableList<String> aj;
    public final boolean ak;
    @Nullable
    public final String al;
    public boolean am;
    public final ImmutableList<Bundle> f13779b;
    public final ImmutableList<Long> f13780c;
    public final String f13781d;
    public final MinutiaeTag f13782e;
    public final long f13783f;
    public final String f13784g;
    public final PhotoUploadPrivacy f13785h;
    public final long f13786i;
    @Nullable
    public final String f13787j;
    public final boolean f13788k;
    public final RedSpaceValue f13789l;
    public final boolean f13790m;
    @Nullable
    public final String f13791n;
    public final PublishMethod f13792o;
    public final String f13793p;
    public final String f13794q;
    public final Type f13795r;
    public final ViewerContext f13796s;
    public final long f13797t;
    public final boolean f13798u;
    public final PostReviewParams f13799v;
    public final ComposerLifeEventParam f13800w;
    public final long f13801x;
    public final PublishMode f13802y;
    public final long f13803z;

    /* compiled from: global_search */
    final class C08851 implements Creator<UploadOperation> {
        C08851() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UploadOperation(parcel);
        }

        public final Object[] newArray(int i) {
            return new UploadOperation[i];
        }
    }

    /* compiled from: global_search */
    public class Builder {
        public PublishMode f13700A = PublishMode.NORMAL;
        private long f13701B = 0;
        private GraphQLBudgetRecommendationData f13702C = null;
        private ProductItemAttachment f13703D = null;
        private long f13704E = 0;
        private List<Long> f13705F = new ArrayList();
        public boolean f13706G = false;
        public String f13707H;
        @Nullable
        private String f13708I;
        @Nullable
        private String f13709J;
        private long f13710K = 0;
        @Nullable
        private String f13711L;
        private boolean f13712M = false;
        private int f13713N = 0;
        @Nullable
        public CommerceProductItemMutateParams f13714O;
        @Nullable
        private String f13715P;
        private int f13716Q;
        private int f13717R;
        @Nullable
        public String f13718S;
        @Nullable
        public EditPostParams f13719T;
        public int f13720U = -1;
        @Nullable
        private String f13721V;
        @Nullable
        public PromptAnalytics f13722W;
        @Nullable
        private ImmutableList<String> f13723X;
        private boolean f13724Y;
        public String f13725Z;
        public String f13726a = null;
        public boolean aa;
        public ImmutableList<MediaItem> f13727b = RegularImmutableList.a;
        public ImmutableList<Bundle> f13728c = null;
        public ImmutableList<Long> f13729d = RegularImmutableList.a;
        public String f13730e = null;
        private MinutiaeTag f13731f = MinutiaeTag.a;
        public long f13732g = 0;
        public String f13733h = null;
        public long f13734i = -1;
        private String f13735j = null;
        public boolean f13736k = false;
        public RedSpaceValue f13737l = RedSpaceValue.POST_TO_NEWSFEED;
        private boolean f13738m = false;
        @Nullable
        private String f13739n;
        public PhotoUploadPrivacy f13740o = null;
        public PublishMethod f13741p = null;
        public Type f13742q = null;
        public ViewerContext f13743r = null;
        private long f13744s = -1;
        public boolean f13745t = false;
        public PostReviewParams f13746u = null;
        public ComposerLifeEventParam f13747v = null;
        public long f13748w = 0;
        private ComposerAppAttribution f13749x = null;
        public boolean f13750y = false;
        public boolean f13751z = false;

        public final Builder m21465a(String str) {
            this.f13726a = str;
            return this;
        }

        public final Builder m21471b(String str) {
            this.f13715P = str;
            return this;
        }

        public final Builder m21452a(int i) {
            this.f13716Q = i;
            return this;
        }

        public final Builder m21468b(int i) {
            this.f13717R = i;
            return this;
        }

        public final Builder m21473c(int i) {
            this.f13720U = i;
            return this;
        }

        public final Builder m21464a(ImmutableList<MediaItem> immutableList) {
            this.f13727b = immutableList;
            return this;
        }

        public final Builder m21470b(ImmutableList<Bundle> immutableList) {
            this.f13728c = immutableList;
            return this;
        }

        public final Builder m21475c(ImmutableList<Long> immutableList) {
            this.f13729d = immutableList;
            return this;
        }

        public final Builder m21476c(String str) {
            this.f13730e = str;
            return this;
        }

        public final Builder m21456a(MinutiaeTag minutiaeTag) {
            if (this.f13731f == null) {
                this.f13731f = MinutiaeTag.a;
            } else {
                this.f13731f = minutiaeTag;
            }
            return this;
        }

        public final Builder m21453a(long j) {
            this.f13732g = j;
            return this;
        }

        public final Builder m21480d(String str) {
            this.f13733h = str;
            return this;
        }

        public final Builder m21469b(long j) {
            this.f13734i = j;
            return this;
        }

        public final Builder m21483e(String str) {
            this.f13735j = str;
            return this;
        }

        public final Builder m21466a(boolean z) {
            this.f13736k = z;
            return this;
        }

        public final Builder m21459a(RedSpaceValue redSpaceValue) {
            this.f13737l = redSpaceValue;
            return this;
        }

        public final Builder m21472b(boolean z) {
            this.f13738m = z;
            return this;
        }

        public final Builder m21486f(String str) {
            this.f13739n = str;
            return this;
        }

        public final Builder m21462a(PhotoUploadPrivacy photoUploadPrivacy) {
            this.f13740o = photoUploadPrivacy;
            return this;
        }

        public final Builder m21460a(PublishMethod publishMethod) {
            this.f13741p = publishMethod;
            return this;
        }

        public final Builder m21461a(Type type) {
            this.f13742q = type;
            return this;
        }

        public final Builder m21454a(ViewerContext viewerContext) {
            this.f13743r = viewerContext;
            return this;
        }

        public final Builder m21474c(long j) {
            this.f13744s = j;
            return this;
        }

        public final Builder m21478d(long j) {
            this.f13748w = j;
            return this;
        }

        public final Builder m21463a(ComposerAppAttribution composerAppAttribution) {
            this.f13749x = composerAppAttribution;
            return this;
        }

        public final Builder m21481d(boolean z) {
            this.f13750y = z;
            return this;
        }

        public final Builder m21484e(boolean z) {
            this.f13751z = z;
            return this;
        }

        public final Builder m21458a(PublishMode publishMode) {
            this.f13700A = publishMode;
            return this;
        }

        public final Builder m21482e(long j) {
            this.f13701B = j;
            return this;
        }

        public final Builder m21455a(GraphQLBudgetRecommendationData graphQLBudgetRecommendationData) {
            this.f13702C = graphQLBudgetRecommendationData;
            return this;
        }

        public final Builder m21457a(ProductItemAttachment productItemAttachment) {
            this.f13703D = productItemAttachment;
            return this;
        }

        public final Builder m21485f(long j) {
            this.f13704E = j;
            return this;
        }

        public final Builder m21489g(String str) {
            this.f13707H = str;
            return this;
        }

        public final Builder m21491h(String str) {
            this.f13708I = str;
            return this;
        }

        public final Builder m21492i(String str) {
            this.f13709J = str;
            return this;
        }

        public final Builder m21488g(long j) {
            this.f13710K = j;
            return this;
        }

        public final Builder m21493j(String str) {
            this.f13711L = str;
            return this;
        }

        public final Builder m21487f(boolean z) {
            this.f13712M = z;
            return this;
        }

        public final Builder m21477d(int i) {
            if (i >= 0 && i <= 100) {
                this.f13713N = i;
            }
            return this;
        }

        public final Builder m21479d(@Nullable ImmutableList<String> immutableList) {
            this.f13723X = immutableList;
            return this;
        }

        public final Builder m21490g(boolean z) {
            this.f13724Y = z;
            return this;
        }

        public Builder(UploadOperation uploadOperation) {
            this.f13726a = uploadOperation.f13793p;
            this.f13727b = uploadOperation.f13778a;
            this.f13728c = uploadOperation.f13779b;
            this.f13729d = uploadOperation.f13780c;
            this.f13730e = uploadOperation.f13781d;
            this.f13731f = uploadOperation.f13782e;
            this.f13732g = uploadOperation.f13783f;
            this.f13733h = uploadOperation.f13784g;
            this.f13734i = uploadOperation.f13786i;
            this.f13735j = uploadOperation.f13787j;
            this.f13736k = uploadOperation.f13788k;
            this.f13737l = uploadOperation.f13789l;
            this.f13738m = uploadOperation.f13790m;
            this.f13739n = uploadOperation.f13791n;
            this.f13740o = uploadOperation.f13785h;
            this.f13741p = uploadOperation.f13792o;
            this.f13742q = uploadOperation.f13795r;
            this.f13743r = uploadOperation.f13796s;
            this.f13744s = uploadOperation.f13797t;
            this.f13745t = uploadOperation.f13798u;
            this.f13746u = uploadOperation.f13799v;
            this.f13747v = uploadOperation.f13800w;
            this.f13748w = uploadOperation.f13801x;
            this.f13749x = uploadOperation.f13752A;
            this.f13750y = uploadOperation.f13753B;
            this.f13751z = uploadOperation.f13754C;
            this.f13700A = uploadOperation.f13802y;
            this.f13701B = uploadOperation.f13803z;
            this.f13702C = uploadOperation.f13759H;
            this.f13703D = uploadOperation.f13760I;
            this.f13704E = uploadOperation.f13761J;
            this.f13705F = uploadOperation.f13762K;
            this.f13706G = uploadOperation.f13777Z;
            this.f13707H = uploadOperation.f13794q;
            this.f13708I = uploadOperation.aa;
            this.f13711L = uploadOperation.ad;
            this.f13713N = uploadOperation.f13771T;
            this.f13714O = uploadOperation.af;
            this.f13715P = uploadOperation.f13763L;
            this.f13716Q = uploadOperation.f13764M;
            this.f13717R = uploadOperation.f13765N;
            this.f13718S = uploadOperation.ag;
            this.f13719T = uploadOperation.ah;
            this.f13721V = uploadOperation.f13776Y;
            this.f13722W = uploadOperation.ai;
            this.f13723X = uploadOperation.aj;
            this.f13724Y = uploadOperation.ak;
            this.f13725Z = uploadOperation.al;
            this.aa = uploadOperation.am;
        }

        public final UploadOperation m21467a() {
            return new UploadOperation(this.f13726a, this.f13727b, this.f13728c, this.f13729d, this.f13730e, this.f13731f, this.f13732g, this.f13733h, this.f13734i, this.f13735j, this.f13736k, this.f13737l, this.f13738m, this.f13739n, this.f13740o, this.f13741p, this.f13742q, this.f13743r, this.f13744s, this.f13745t, this.f13746u, this.f13747v, this.f13748w, this.f13749x, this.f13750y, this.f13751z, this.f13700A, this.f13701B, this.f13702C, this.f13703D, this.f13704E, this.f13705F, this.f13706G, this.f13707H, this.f13708I, this.f13709J, this.f13710K, this.f13711L, this.f13712M, this.f13713N, this.f13714O, this.f13715P, this.f13716Q, this.f13717R, this.f13718S, this.f13719T, this.f13720U, this.f13721V, this.f13722W, this.f13723X, this.f13724Y, this.f13725Z, this.aa);
        }
    }

    /* compiled from: global_search */
    public enum PublishMethod {
        SINGLE_PHOTO,
        STATUS,
        TARGET,
        PHOTO_REVIEW,
        LIFE_EVENT,
        PROFILE_PIC,
        PROFILE_VIDEO,
        COVER_PHOTO,
        VIDEO_STATUS,
        VIDEO_TARGET,
        PLACE_PHOTO,
        MENU_PHOTO,
        PRODUCT_IMAGE,
        MULTIMEDIA,
        EDIT_POST,
        BACKSTAGE_VIDEO_POST,
        SLIDESHOW
    }

    /* compiled from: global_search */
    public enum Type {
        ALBUM,
        OWN_TIMELINE,
        TARGET,
        VIDEO,
        PHOTO_REVIEW,
        LIFE_EVENT,
        PROFILE_PIC,
        PROFILE_VIDEO,
        COVER_PHOTO,
        PLACE_PHOTO,
        MENU_PHOTO,
        PRODUCT_IMAGE,
        MULTIMEDIA,
        MOMENTS_VIDEO,
        COMMENT_VIDEO,
        LIVE_VIDEO
    }

    private UploadOperation(String str, ImmutableList<MediaItem> immutableList, @Nullable ImmutableList<Bundle> immutableList2, ImmutableList<Long> immutableList3, String str2, MinutiaeTag minutiaeTag, long j, String str3, long j2, String str4, boolean z, RedSpaceValue redSpaceValue, boolean z2, @Nullable String str5, PhotoUploadPrivacy photoUploadPrivacy, PublishMethod publishMethod, Type type, @Nullable ViewerContext viewerContext, long j3, boolean z3, @Nullable PostReviewParams postReviewParams, @Nullable ComposerLifeEventParam composerLifeEventParam, long j4, @Nullable ComposerAppAttribution composerAppAttribution, boolean z4, boolean z5, PublishMode publishMode, long j5, @Nullable GraphQLBudgetRecommendationData graphQLBudgetRecommendationData, @Nullable ProductItemAttachment productItemAttachment, long j6, List<Long> list, boolean z6, String str6, @Nullable String str7, @Nullable String str8, long j7, @Nullable String str9, boolean z7, int i, @Nullable CommerceProductItemMutateParams commerceProductItemMutateParams, @Nullable String str10, int i2, int i3, @Nullable String str11, @Nullable EditPostParams editPostParams, int i4, @Nullable String str12, @Nullable PromptAnalytics promptAnalytics, ImmutableList<String> immutableList4, boolean z8, @Nullable String str13, boolean z9) {
        this.f13774W = TagStoreCopy.f13469a;
        this.f13775X = FaceBoxStoreCopy.f13422a;
        boolean z10 = immutableList2 == null || immutableList2.size() == immutableList.size();
        Preconditions.checkArgument(z10);
        Preconditions.checkArgument(j4 != 0);
        this.f13778a = (ImmutableList) Preconditions.checkNotNull(immutableList);
        this.f13779b = immutableList2;
        this.f13780c = (ImmutableList) Preconditions.checkNotNull(immutableList3);
        this.f13781d = str2;
        this.f13782e = (MinutiaeTag) Preconditions.checkNotNull(minutiaeTag);
        this.f13783f = j;
        this.f13784g = (String) Preconditions.checkNotNull(str3);
        this.f13786i = j2;
        this.f13787j = str4;
        this.f13788k = z;
        this.f13789l = redSpaceValue;
        this.f13790m = z2;
        this.f13791n = str5;
        this.f13785h = (PhotoUploadPrivacy) Preconditions.checkNotNull(photoUploadPrivacy);
        this.f13792o = (PublishMethod) Preconditions.checkNotNull(publishMethod);
        this.f13793p = (String) Preconditions.checkNotNull(str);
        this.f13795r = (Type) Preconditions.checkNotNull(type);
        this.f13796s = viewerContext;
        this.f13797t = j3;
        this.f13798u = z3;
        this.f13799v = postReviewParams;
        this.f13800w = composerLifeEventParam;
        this.f13801x = j4;
        this.f13752A = composerAppAttribution;
        this.f13753B = z4;
        this.f13754C = z5;
        this.f13802y = (PublishMode) Preconditions.checkNotNull(publishMode);
        this.f13803z = j5;
        this.f13759H = graphQLBudgetRecommendationData;
        this.f13771T = i;
        this.f13755D = new UploadOperationCounters(SystemClock.b().a());
        this.f13756E = null;
        this.f13757F = null;
        this.f13758G = -1412567278;
        this.f13760I = productItemAttachment;
        this.f13761J = j6;
        if (list == null || list.isEmpty()) {
            list = Arrays.asList(new Long[]{Long.valueOf(r2)});
        }
        this.f13762K = list;
        this.f13766O = false;
        this.f13767P = false;
        this.f13769R = false;
        this.f13770S = false;
        this.f13777Z = z6;
        this.f13794q = str6;
        this.aa = str7;
        this.ab = str8;
        this.ac = j7;
        this.ad = str9;
        this.ae = z7;
        this.f13772U = 0;
        this.f13773V = 0;
        this.af = commerceProductItemMutateParams;
        this.f13763L = str10;
        this.f13764M = i2;
        this.f13765N = i3;
        this.ag = str11;
        this.ah = editPostParams;
        this.f13768Q = i4;
        this.f13776Y = str12;
        this.ai = promptAnalytics;
        this.aj = immutableList4;
        this.ak = z8;
        this.al = str13;
        this.am = z9;
    }

    public final int m21532c() {
        return this.f13778a.size();
    }

    public final int m21535d() {
        return this.f13755D.f13813h + this.f13755D.f13812g;
    }

    public final int m21537e() {
        return this.f13755D.f13811f;
    }

    public final int m21538f() {
        return this.f13755D.f13810e + this.f13755D.f13809d;
    }

    public final long m21543n() {
        return this.f13755D.f13808c;
    }

    public final boolean m21540h() {
        return this.f13756E != null && this.f13756E.f13692b;
    }

    public final boolean m21541i() {
        return this.f13756E != null && this.f13756E.f13691a;
    }

    public final void m21544s() {
        UploadOperationCounters uploadOperationCounters = this.f13755D;
        uploadOperationCounters.f13814i++;
    }

    public final void m21525a(@Nullable UploadInterruptionCause uploadInterruptionCause) {
        boolean z;
        this.f13756E = uploadInterruptionCause;
        UploadOperationCounters uploadOperationCounters = this.f13755D;
        if (this.f13756E == null || this.f13756E.f13692b) {
            z = true;
        } else {
            z = false;
        }
        uploadOperationCounters.f13815j = z;
    }

    @Nullable
    public final UploadInterruptionCause m21545t() {
        return this.f13756E;
    }

    public final void m21526a(UploadRecords uploadRecords) {
        this.f13757F = uploadRecords;
    }

    @Nullable
    public final UploadRecords m21546u() {
        return this.f13757F;
    }

    @Nullable
    public final ProductItemAttachment m21547v() {
        return this.f13760I;
    }

    public final boolean m21542k() {
        return this.f13755D.f13815j;
    }

    public final ImmutableList<MediaItem> m21548x() {
        return this.f13778a;
    }

    @Nullable
    public final ImmutableList<Bundle> m21549y() {
        return this.f13779b;
    }

    @Nullable
    public final Bundle m21550z() {
        if (this.f13779b == null || this.f13779b.isEmpty()) {
            return null;
        }
        return (Bundle) this.f13779b.get(0);
    }

    public final String m21496A() {
        return this.f13781d;
    }

    public final long m21497B() {
        return this.f13783f;
    }

    public final PhotoUploadPrivacy m21498C() {
        return this.f13785h;
    }

    public final long m21499D() {
        return this.f13786i;
    }

    public final String m21500E() {
        return this.f13787j;
    }

    public final boolean m21501F() {
        return this.f13788k;
    }

    public final RedSpaceValue m21502G() {
        return this.f13789l;
    }

    public final boolean m21503H() {
        return this.f13790m;
    }

    @Nullable
    public final String m21504I() {
        return this.f13791n;
    }

    public final PublishMethod m21505J() {
        return this.f13792o;
    }

    public final PostReviewParams m21506K() {
        return this.f13799v;
    }

    public final ComposerLifeEventParam m21507L() {
        return this.f13800w;
    }

    public final ImmutableList<Long> m21508M() {
        return this.f13780c;
    }

    public final String m21509N() {
        return this.f13793p;
    }

    public final Type m21510O() {
        return this.f13795r;
    }

    public final String m21511P() {
        if (this.f13778a.isEmpty() || ((MediaItem) this.f13778a.get(0)).m() != MediaType.VIDEO) {
            return null;
        }
        if (MediaItem.a.equals(((MediaItem) this.f13778a.get(0)).i())) {
            return "ANIMATED_GIFS";
        }
        return "CORE_VIDEOS";
    }

    public final Boolean m21512Q() {
        return Boolean.valueOf(MediaItem.a.equals(((MediaItem) this.f13778a.get(0)).i()));
    }

    public final UploadType m21522a() {
        return m21520Y() ? UploadType.VIDEO : UploadType.PHOTO;
    }

    @Nullable
    public final String m21513R() {
        return this.ag;
    }

    @Nullable
    public final EditPostParams m21514S() {
        return this.ah;
    }

    public final String m21529b() {
        return this.f13784g;
    }

    @Nullable
    public final ViewerContext m21515T() {
        return this.f13796s;
    }

    public final long m21516U() {
        return this.f13797t;
    }

    public final ComposerAppAttribution m21517V() {
        return this.f13752A;
    }

    public final boolean m21518W() {
        return this.f13753B;
    }

    public final boolean m21519X() {
        return this.f13754C;
    }

    public final boolean m21520Y() {
        return this.f13795r == Type.VIDEO || this.f13795r == Type.PROFILE_VIDEO || this.f13795r == Type.MOMENTS_VIDEO || this.f13795r == Type.COMMENT_VIDEO || this.f13795r == Type.LIVE_VIDEO;
    }

    public final boolean m21521Z() {
        return this.f13792o == PublishMethod.MULTIMEDIA;
    }

    public final boolean aa() {
        return this.f13792o == PublishMethod.SLIDESHOW;
    }

    public final MinutiaeTag ac() {
        return this.f13782e;
    }

    public final int m21539g() {
        return this.f13755D.f13812g;
    }

    public final long ad() {
        return this.f13801x;
    }

    public final void m21523a(long j) {
        UploadOperationCounters uploadOperationCounters = this.f13755D;
        uploadOperationCounters.f13806a = j;
        uploadOperationCounters.f13807b = j;
        uploadOperationCounters.f13808c = j;
        boolean z = uploadOperationCounters.f13809d == 0 && uploadOperationCounters.f13810e == 0 && uploadOperationCounters.f13811f == 0 && uploadOperationCounters.f13812g == 0 && uploadOperationCounters.f13813h == 0;
        Preconditions.checkArgument(z);
    }

    public final long ae() {
        return this.f13755D.f13806a;
    }

    public final void m21530b(long j) {
        UploadOperationCounters uploadOperationCounters = this.f13755D;
        uploadOperationCounters.f13808c = j;
        uploadOperationCounters.f13812g++;
    }

    public final void m21533c(long j) {
        this.f13755D.f13808c = j;
    }

    public final void m21536d(long j) {
        UploadOperationCounters uploadOperationCounters = this.f13755D;
        uploadOperationCounters.f13811f++;
        uploadOperationCounters.f13813h += uploadOperationCounters.f13812g;
        uploadOperationCounters.f13812g = 0;
        uploadOperationCounters.m21554a();
        uploadOperationCounters.f13807b = j;
        uploadOperationCounters.f13808c = j;
        uploadOperationCounters.f13814i = 0;
        uploadOperationCounters.f13815j = true;
    }

    public final void af() {
        this.f13755D.m21554a();
    }

    public final PublishMode ah() {
        return this.f13802y;
    }

    public final long ai() {
        return this.f13803z;
    }

    public final void m21531b(boolean z) {
        this.f13766O = z;
    }

    public final boolean ak() {
        return this.am;
    }

    public final void m21534c(boolean z) {
        this.f13767P = z;
    }

    public final boolean an() {
        return this.f13770S;
    }

    public final TagStoreCopy ap() {
        return this.f13774W;
    }

    public final FaceBoxStoreCopy aq() {
        return this.f13775X;
    }

    public final void m21524a(TagStoreCopy tagStoreCopy, FaceBoxStoreCopy faceBoxStoreCopy) {
        this.f13774W = tagStoreCopy;
        this.f13775X = faceBoxStoreCopy;
    }

    public final boolean ar() {
        return this.f13777Z;
    }

    public final String as() {
        return this.f13794q;
    }

    @Nullable
    public final String at() {
        return this.aa;
    }

    @Nullable
    public final String au() {
        return this.ab;
    }

    public final long av() {
        return this.ac;
    }

    @Nullable
    public final String aw() {
        return this.ad;
    }

    public final boolean ax() {
        return this.ae;
    }

    public final boolean aA() {
        return !StringUtil.a(this.f13776Y);
    }

    @Nullable
    public final String aB() {
        return this.f13776Y;
    }

    @Nullable
    public final PromptAnalytics aC() {
        return this.ai;
    }

    public final ImmutableList<String> aD() {
        return this.aj;
    }

    public final boolean aE() {
        return this.ak;
    }

    @Nullable
    public final String aF() {
        return this.al;
    }

    public UploadOperation(Parcel parcel) {
        Collection a;
        this.f13774W = TagStoreCopy.f13469a;
        this.f13775X = FaceBoxStoreCopy.f13422a;
        this.f13778a = ImmutableList.copyOf(parcel.readArrayList(MediaItem.class.getClassLoader()));
        if (ParcelUtil.a(parcel)) {
            a = Lists.a();
            parcel.readTypedList(a, Bundle.CREATOR);
            this.f13779b = ImmutableList.copyOf(a);
        } else {
            this.f13779b = null;
        }
        this.f13781d = parcel.readString();
        this.f13782e = (MinutiaeTag) parcel.readParcelable(MinutiaeTag.class.getClassLoader());
        this.f13783f = parcel.readLong();
        this.f13784g = parcel.readString();
        this.f13786i = parcel.readLong();
        this.f13787j = parcel.readString();
        this.f13788k = ParcelUtil.a(parcel);
        this.f13789l = (RedSpaceValue) parcel.readSerializable();
        this.f13790m = ParcelUtil.a(parcel);
        this.f13791n = parcel.readString();
        this.f13785h = (PhotoUploadPrivacy) parcel.readParcelable(PhotoUploadPrivacy.class.getClassLoader());
        this.f13792o = (PublishMethod) parcel.readSerializable();
        a = parcel.readArrayList(Long.class.getClassLoader());
        this.f13780c = a != null ? ImmutableList.copyOf(a) : null;
        this.f13793p = parcel.readString();
        this.f13795r = (Type) parcel.readSerializable();
        this.f13796s = (ViewerContext) parcel.readParcelable(ViewerContext.class.getClassLoader());
        this.f13797t = parcel.readLong();
        this.f13798u = ParcelUtil.a(parcel);
        this.f13799v = (PostReviewParams) parcel.readParcelable(PostReviewParams.class.getClassLoader());
        this.f13800w = (ComposerLifeEventParam) parcel.readParcelable(ComposerLifeEventParam.class.getClassLoader());
        this.f13801x = parcel.readLong();
        this.f13752A = (ComposerAppAttribution) parcel.readParcelable(ComposerAppAttribution.class.getClassLoader());
        this.f13754C = ParcelUtil.a(parcel);
        this.f13753B = ParcelUtil.a(parcel);
        this.f13802y = (PublishMode) parcel.readSerializable();
        this.f13803z = parcel.readLong();
        this.f13759H = (GraphQLBudgetRecommendationData) FlatBufferModelHelper.a(parcel);
        this.f13771T = parcel.readInt();
        this.f13772U = parcel.readInt();
        this.f13773V = parcel.readInt();
        this.f13755D = new UploadOperationCounters(parcel);
        this.f13756E = (UploadInterruptionCause) parcel.readParcelable(UploadInterruptionCause.class.getClassLoader());
        this.f13757F = (UploadRecords) parcel.readParcelable(UploadRecords.class.getClassLoader());
        this.f13758G = parcel.readInt();
        this.f13760I = (ProductItemAttachment) parcel.readParcelable(ProductItemAttachment.class.getClassLoader());
        this.f13761J = parcel.readLong();
        this.f13766O = ParcelUtil.a(parcel);
        this.f13769R = ParcelUtil.a(parcel);
        this.f13770S = ParcelUtil.a(parcel);
        this.f13762K = parcel.readArrayList(Long.class.getClassLoader());
        this.f13767P = ParcelUtil.a(parcel);
        this.f13777Z = ParcelUtil.a(parcel);
        this.f13794q = parcel.readString();
        this.aa = parcel.readString();
        this.ab = parcel.readString();
        this.ac = parcel.readLong();
        this.ad = parcel.readString();
        this.ae = ParcelUtil.a(parcel);
        this.af = (CommerceProductItemMutateParams) parcel.readParcelable(CommerceProductItemMutateParams.class.getClassLoader());
        this.f13763L = parcel.readString();
        this.f13764M = parcel.readInt();
        this.f13765N = parcel.readInt();
        this.ag = parcel.readString();
        this.ah = (EditPostParams) parcel.readParcelable(EditPostParams.class.getClassLoader());
        this.f13768Q = parcel.readInt();
        this.f13776Y = parcel.readString();
        this.ai = (PromptAnalytics) parcel.readParcelable(PromptAnalytics.class.getClassLoader());
        this.aj = ParcelUtil.j(parcel);
        this.ak = ParcelUtil.a(parcel);
        this.al = parcel.readString();
        this.am = ParcelUtil.a(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f13778a);
        ParcelUtil.a(parcel, this.f13779b != null);
        if (this.f13779b != null) {
            parcel.writeTypedList(this.f13779b);
        }
        parcel.writeString(this.f13781d);
        parcel.writeParcelable(this.f13782e, i);
        parcel.writeLong(this.f13783f);
        parcel.writeString(this.f13784g);
        parcel.writeLong(this.f13786i);
        parcel.writeString(this.f13787j);
        ParcelUtil.a(parcel, this.f13788k);
        parcel.writeSerializable(this.f13789l);
        ParcelUtil.a(parcel, this.f13790m);
        parcel.writeString(this.f13791n);
        parcel.writeParcelable(this.f13785h, i);
        parcel.writeSerializable(this.f13792o);
        parcel.writeList(this.f13780c);
        parcel.writeString(this.f13793p);
        parcel.writeSerializable(this.f13795r);
        parcel.writeParcelable(this.f13796s, i);
        parcel.writeLong(this.f13797t);
        ParcelUtil.a(parcel, this.f13798u);
        parcel.writeParcelable(this.f13799v, i);
        parcel.writeParcelable(this.f13800w, i);
        parcel.writeLong(this.f13801x);
        parcel.writeParcelable(this.f13752A, i);
        ParcelUtil.a(parcel, this.f13754C);
        ParcelUtil.a(parcel, this.f13753B);
        parcel.writeSerializable(this.f13802y);
        parcel.writeLong(this.f13803z);
        FlatBufferModelHelper.a(parcel, this.f13759H);
        parcel.writeInt(this.f13771T);
        parcel.writeInt(this.f13772U);
        parcel.writeInt(this.f13773V);
        UploadOperationCounters uploadOperationCounters = this.f13755D;
        parcel.writeLong(uploadOperationCounters.f13806a);
        parcel.writeLong(uploadOperationCounters.f13807b);
        parcel.writeLong(uploadOperationCounters.f13808c);
        parcel.writeInt(uploadOperationCounters.f13809d);
        parcel.writeInt(uploadOperationCounters.f13810e);
        parcel.writeInt(uploadOperationCounters.f13811f);
        parcel.writeInt(uploadOperationCounters.f13812g);
        parcel.writeInt(uploadOperationCounters.f13813h);
        parcel.writeInt(uploadOperationCounters.f13814i);
        ParcelUtil.a(parcel, uploadOperationCounters.f13815j);
        parcel.writeParcelable(this.f13756E, i);
        parcel.writeParcelable(this.f13757F, i);
        parcel.writeInt(this.f13758G);
        parcel.writeParcelable(this.f13760I, i);
        parcel.writeLong(this.f13761J);
        ParcelUtil.a(parcel, this.f13766O);
        ParcelUtil.a(parcel, this.f13769R);
        ParcelUtil.a(parcel, this.f13770S);
        parcel.writeList(this.f13762K);
        ParcelUtil.a(parcel, this.f13767P);
        ParcelUtil.a(parcel, this.f13777Z);
        parcel.writeString(this.f13794q);
        parcel.writeString(this.aa);
        parcel.writeString(this.ab);
        parcel.writeLong(this.ac);
        parcel.writeString(this.ad);
        ParcelUtil.a(parcel, this.ae);
        parcel.writeParcelable(this.af, i);
        parcel.writeString(this.f13763L);
        parcel.writeInt(this.f13764M);
        parcel.writeInt(this.f13765N);
        parcel.writeString(this.ag);
        parcel.writeParcelable(this.ah, i);
        parcel.writeInt(this.f13768Q);
        parcel.writeString(this.f13776Y);
        parcel.writeParcelable(this.ai, i);
        ParcelUtil.a(parcel, this.aj);
        ParcelUtil.a(parcel, this.ak);
        parcel.writeString(this.al);
        ParcelUtil.a(parcel, this.am);
    }

    public int describeContents() {
        return 0;
    }

    public final boolean m21528a(File file) {
        FileOutputStream fileOutputStream;
        int i;
        boolean z;
        Throwable th;
        int i2 = 0;
        Parcel obtain = Parcel.obtain();
        writeToParcel(obtain, 0);
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(obtain.marshall());
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                    i = 0;
                } catch (IOException e) {
                    z = true;
                }
                if (i != 0) {
                    file.delete();
                }
                obtain.recycle();
            } catch (IOException e2) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                file.delete();
                obtain.recycle();
                z = true;
                if (i == 0) {
                    return true;
                }
                return false;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                fileOutputStream2 = fileOutputStream;
                th = th3;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e4) {
                        i2 = 1;
                    }
                }
                if (i2 != 0) {
                    file.delete();
                }
                obtain.recycle();
                throw th;
            }
        } catch (IOException e5) {
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            file.delete();
            obtain.recycle();
            z = true;
            if (i == 0) {
                return false;
            }
            return true;
        } catch (Throwable th4) {
            th = th4;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            if (i2 != 0) {
                file.delete();
            }
            obtain.recycle();
            throw th;
        }
        if (i == 0) {
            return true;
        }
        return false;
    }

    public final void m21527a(DataOutput dataOutput) {
        Parcel obtain = Parcel.obtain();
        try {
            writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            dataOutput.writeInt(marshall.length);
            dataOutput.write(marshall);
        } finally {
            obtain.recycle();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.photos.upload.operation.UploadOperation m21495b(java.io.File r10) {
        /*
        r1 = 0;
        r4 = r10.length();
        r2 = 0;
        r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x007a;
    L_0x000b:
        r2 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;
        r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r0 >= 0) goto L_0x007a;
    L_0x0012:
        r3 = android.os.Parcel.obtain();
        r0 = (int) r4;
        r0 = new byte[r0];
        r2 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0053, all -> 0x005e }
        r2.<init>(r10);	 Catch:{ IOException -> 0x0053, all -> 0x005e }
        r6 = r2.read(r0);	 Catch:{ IOException -> 0x0071, all -> 0x006f }
        r8 = (long) r6;	 Catch:{ IOException -> 0x0071, all -> 0x006f }
        r4 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r4 != 0) goto L_0x0078;
    L_0x0027:
        r4 = 0;
        r3.unmarshall(r0, r4, r6);	 Catch:{ IOException -> 0x0071, all -> 0x006f }
        r0 = 0;
        r3.setDataPosition(r0);	 Catch:{ IOException -> 0x0071, all -> 0x006f }
        r0 = CREATOR;	 Catch:{ IOException -> 0x0071, all -> 0x006f }
        r0 = r0.createFromParcel(r3);	 Catch:{ IOException -> 0x0071, all -> 0x006f }
        r0 = (com.facebook.photos.upload.operation.UploadOperation) r0;	 Catch:{ IOException -> 0x0071, all -> 0x006f }
        r4 = r0.f13762K;	 Catch:{ IOException -> 0x0075, all -> 0x006f }
        r6 = android.os.SystemClock.elapsedRealtime();	 Catch:{ IOException -> 0x0075, all -> 0x006f }
        r5 = java.lang.Long.valueOf(r6);	 Catch:{ IOException -> 0x0075, all -> 0x006f }
        r4.add(r5);	 Catch:{ IOException -> 0x0075, all -> 0x006f }
        r4 = r0.f13758G;	 Catch:{ IOException -> 0x0075, all -> 0x006f }
        r5 = -1412567278; // 0xffffffffabcdef12 float:-1.4632481E-12 double:NaN;
        if (r4 == r5) goto L_0x004c;
    L_0x004b:
        r0 = r1;
    L_0x004c:
        r2.close();	 Catch:{ IOException -> 0x0069 }
    L_0x004f:
        r3.recycle();
    L_0x0052:
        return r0;
    L_0x0053:
        r0 = move-exception;
        r0 = r1;
    L_0x0055:
        if (r1 == 0) goto L_0x005a;
    L_0x0057:
        r1.close();	 Catch:{ IOException -> 0x006b }
    L_0x005a:
        r3.recycle();
        goto L_0x0052;
    L_0x005e:
        r0 = move-exception;
        r2 = r1;
    L_0x0060:
        if (r2 == 0) goto L_0x0065;
    L_0x0062:
        r2.close();	 Catch:{ IOException -> 0x006d }
    L_0x0065:
        r3.recycle();
        throw r0;
    L_0x0069:
        r1 = move-exception;
        goto L_0x004f;
    L_0x006b:
        r1 = move-exception;
        goto L_0x005a;
    L_0x006d:
        r1 = move-exception;
        goto L_0x0065;
    L_0x006f:
        r0 = move-exception;
        goto L_0x0060;
    L_0x0071:
        r0 = move-exception;
        r0 = r1;
        r1 = r2;
        goto L_0x0055;
    L_0x0075:
        r1 = move-exception;
        r1 = r2;
        goto L_0x0055;
    L_0x0078:
        r0 = r1;
        goto L_0x004c;
    L_0x007a:
        r0 = r1;
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.upload.operation.UploadOperation.b(java.io.File):com.facebook.photos.upload.operation.UploadOperation");
    }

    public static UploadOperation m21494a(DataInput dataInput) {
        Parcel obtain = Parcel.obtain();
        try {
            int readInt = dataInput.readInt();
            if (readInt <= 0 || readInt > 1048576) {
                throw new IOException("invalid operation size");
            }
            byte[] bArr = new byte[readInt];
            dataInput.readFully(bArr);
            obtain.unmarshall(bArr, 0, readInt);
            obtain.setDataPosition(0);
            UploadOperation uploadOperation = (UploadOperation) CREATOR.createFromParcel(obtain);
            uploadOperation.f13762K.add(Long.valueOf(android.os.SystemClock.elapsedRealtime()));
            if (uploadOperation.f13758G == -1412567278) {
                return uploadOperation;
            }
            throw new IOException("invalid operation");
        } finally {
            obtain.recycle();
        }
    }
}
