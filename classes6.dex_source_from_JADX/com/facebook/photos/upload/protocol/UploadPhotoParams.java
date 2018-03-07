package com.facebook.photos.upload.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.bitmaps.Dimension;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.calls.StoryCreateInputData.PostChannelFeedbackState;
import com.facebook.ipc.composer.model.MinutiaeTag;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.photos.base.tagging.Tag;
import com.facebook.photos.creativeediting.model.CreativeEditingUploadParams;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.share.model.ComposerAppAttribution;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;
import javax.annotation.Nullable;

/* compiled from: geofencingRequest can't be null. */
public class UploadPhotoParams implements Parcelable {
    public static final Creator<UploadPhotoParams> CREATOR = new C09161();
    private boolean f14083A;
    public long f14084B;
    public boolean f14085C;
    public int f14086D;
    public long f14087E;
    public float f14088F;
    public float f14089G;
    public PublishMode f14090H;
    public long f14091I;
    @Nullable
    public final String f14092J;
    @Nullable
    public final String f14093K;
    @Nullable
    public final PostChannelFeedbackState f14094L;
    public final ImmutableList<Long> f14095M;
    public final String f14096N;
    public final String f14097O;
    @Nullable
    public final String f14098P;
    @Nullable
    public final String f14099Q;
    private final long f14100R;
    @Nullable
    public final String f14101S;
    public final boolean f14102T;
    @Nullable
    public final PromptAnalytics f14103U;
    @Nullable
    public final ImmutableList<String> f14104V;
    @Nullable
    private final String f14105W;
    public final boolean f14106X;
    private final UploadPhotoSource f14107a;
    private final long f14108b;
    private final long f14109c;
    private final long f14110d;
    @Nullable
    public final String f14111e;
    public final boolean f14112f;
    public final RedSpaceValue f14113g;
    private final boolean f14114h;
    @Nullable
    private final String f14115i;
    public final PhotoUploadPrivacy f14116j;
    public final String f14117k;
    public final boolean f14118l;
    public final ImmutableList<Long> f14119m;
    public final ImmutableList<Tag> f14120n;
    public final MinutiaeTag f14121o;
    public final String f14122p;
    public final String f14123q;
    public final int f14124r;
    private final Dimension f14125s;
    private final ViewerContext f14126t;
    public final boolean f14127u;
    public final ComposerAppAttribution f14128v;
    public final boolean f14129w;
    public final boolean f14130x;
    @Nullable
    public final CreativeEditingUploadParams f14131y;
    public String f14132z;

    /* compiled from: geofencingRequest can't be null. */
    final class C09161 implements Creator<UploadPhotoParams> {
        C09161() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UploadPhotoParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new UploadPhotoParams[i];
        }
    }

    /* compiled from: geofencingRequest can't be null. */
    public class Builder {
        private float f14038A;
        private PublishMode f14039B;
        private long f14040C;
        @Nullable
        private CreativeEditingUploadParams f14041D;
        @Nullable
        private String f14042E;
        @Nullable
        private String f14043F;
        @Nullable
        private PostChannelFeedbackState f14044G;
        private ImmutableList<Long> f14045H = RegularImmutableList.a;
        private String f14046I;
        private String f14047J;
        @Nullable
        private String f14048K;
        @Nullable
        private String f14049L;
        private long f14050M;
        @Nullable
        private String f14051N;
        private boolean f14052O;
        @Nullable
        private PromptAnalytics f14053P;
        @Nullable
        private ImmutableList<String> f14054Q;
        @Nullable
        private String f14055R;
        private boolean f14056S;
        private UploadPhotoSource f14057a;
        private long f14058b;
        private long f14059c;
        private long f14060d = -1;
        @Nullable
        private String f14061e;
        private boolean f14062f;
        private RedSpaceValue f14063g;
        private boolean f14064h;
        @Nullable
        private String f14065i;
        public PhotoUploadPrivacy f14066j = PhotoUploadPrivacy.f14020a;
        private String f14067k;
        private boolean f14068l;
        private ImmutableList<Long> f14069m;
        private ImmutableList<Tag> f14070n;
        private MinutiaeTag f14071o;
        private String f14072p;
        private String f14073q;
        private int f14074r;
        private Dimension f14075s;
        private ViewerContext f14076t;
        private boolean f14077u;
        private long f14078v;
        private ComposerAppAttribution f14079w;
        private boolean f14080x;
        private boolean f14081y;
        private float f14082z;

        public Builder(UploadPhotoSource uploadPhotoSource) {
            this.f14057a = uploadPhotoSource;
            this.f14071o = MinutiaeTag.a;
            this.f14068l = true;
        }

        public final Builder m21757a(long j) {
            this.f14059c = j;
            return this;
        }

        public final Builder m21772b(long j) {
            this.f14060d = j;
            return this;
        }

        public final Builder m21768a(String str) {
            this.f14061e = str;
            return this;
        }

        public final Builder m21769a(boolean z) {
            this.f14062f = z;
            return this;
        }

        public final Builder m21762a(RedSpaceValue redSpaceValue) {
            this.f14063g = redSpaceValue;
            return this;
        }

        public final Builder m21775b(boolean z) {
            this.f14064h = z;
            return this;
        }

        public final Builder m21774b(String str) {
            this.f14065i = str;
            return this;
        }

        public final Builder m21764a(PhotoUploadPrivacy photoUploadPrivacy) {
            this.f14066j = photoUploadPrivacy;
            return this;
        }

        public final Builder m21778c(String str) {
            this.f14067k = str;
            return this;
        }

        public final Builder m21779c(boolean z) {
            this.f14068l = z;
            return this;
        }

        public final Builder m21767a(ImmutableList<Long> immutableList) {
            this.f14069m = immutableList;
            return this;
        }

        public final Builder m21773b(ImmutableList<Tag> immutableList) {
            this.f14070n = immutableList;
            return this;
        }

        public final Builder m21760a(MinutiaeTag minutiaeTag) {
            this.f14071o = minutiaeTag;
            return this;
        }

        public final Builder m21781d(String str) {
            this.f14072p = str;
            return this;
        }

        public final Builder m21784e(String str) {
            this.f14073q = str;
            return this;
        }

        public final Builder m21756a(int i) {
            this.f14074r = i;
            return this;
        }

        public final Builder m21759a(Dimension dimension) {
            this.f14075s = dimension;
            return this;
        }

        public final Builder m21758a(ViewerContext viewerContext) {
            if (viewerContext != null) {
                Preconditions.checkArgument(viewerContext.mIsPageContext);
            }
            this.f14076t = viewerContext;
            return this;
        }

        public final Builder m21776c(long j) {
            this.f14078v = j;
            return this;
        }

        public final Builder m21766a(ComposerAppAttribution composerAppAttribution) {
            this.f14079w = composerAppAttribution;
            return this;
        }

        public final Builder m21782d(boolean z) {
            this.f14080x = z;
            return this;
        }

        public final Builder m21785e(boolean z) {
            this.f14081y = z;
            return this;
        }

        public final Builder m21755a(float f) {
            this.f14082z = f;
            return this;
        }

        public final Builder m21771b(float f) {
            this.f14038A = f;
            return this;
        }

        public final Builder m21761a(PublishMode publishMode) {
            this.f14039B = publishMode;
            return this;
        }

        public final Builder m21780d(long j) {
            this.f14040C = j;
            return this;
        }

        public final Builder m21763a(CreativeEditingUploadParams creativeEditingUploadParams) {
            this.f14041D = creativeEditingUploadParams;
            return this;
        }

        public final Builder m21786f(String str) {
            this.f14046I = str;
            return this;
        }

        public final Builder m21788g(String str) {
            this.f14047J = str;
            return this;
        }

        public final Builder m21790h(String str) {
            this.f14048K = str;
            return this;
        }

        public final Builder m21791i(String str) {
            this.f14049L = str;
            return this;
        }

        public final Builder m21783e(long j) {
            this.f14050M = j;
            return this;
        }

        public final Builder m21792j(String str) {
            this.f14051N = str;
            return this;
        }

        public final Builder m21787f(boolean z) {
            this.f14052O = z;
            return this;
        }

        public final Builder m21765a(@Nullable PromptAnalytics promptAnalytics) {
            this.f14053P = promptAnalytics;
            return this;
        }

        public final Builder m21777c(@Nullable ImmutableList<String> immutableList) {
            this.f14054Q = immutableList;
            return this;
        }

        public final Builder m21793k(String str) {
            this.f14055R = str;
            return this;
        }

        public final Builder m21789g(boolean z) {
            this.f14056S = z;
            return this;
        }

        public final UploadPhotoParams m21770a() {
            return new UploadPhotoParams(this.f14057a, this.f14058b, this.f14059c, this.f14060d, this.f14061e, this.f14062f, this.f14063g, this.f14064h, this.f14065i, this.f14066j, this.f14067k, this.f14068l, this.f14069m, this.f14070n, this.f14071o, this.f14072p, this.f14073q, this.f14074r, this.f14075s != null ? this.f14075s : new Dimension(1, 1), this.f14076t, this.f14077u, this.f14078v, this.f14079w, this.f14080x, this.f14081y, this.f14082z, this.f14038A, this.f14039B, this.f14040C, this.f14041D, this.f14042E, this.f14043F, this.f14044G, this.f14045H, this.f14046I, this.f14047J, this.f14048K, this.f14049L, this.f14050M, this.f14051N, this.f14052O, this.f14053P, this.f14054Q, this.f14055R, this.f14056S);
        }
    }

    private UploadPhotoParams(UploadPhotoSource uploadPhotoSource, long j, long j2, long j3, @Nullable String str, boolean z, RedSpaceValue redSpaceValue, boolean z2, @Nullable String str2, PhotoUploadPrivacy photoUploadPrivacy, @Nullable String str3, boolean z3, @Nullable ImmutableList<Long> immutableList, @Nullable ImmutableList<Tag> immutableList2, MinutiaeTag minutiaeTag, @Nullable String str4, @Nullable String str5, int i, Dimension dimension, @Nullable ViewerContext viewerContext, boolean z4, long j4, @Nullable ComposerAppAttribution composerAppAttribution, boolean z5, boolean z6, float f, float f2, PublishMode publishMode, long j5, @Nullable CreativeEditingUploadParams creativeEditingUploadParams, @Nullable String str6, @Nullable String str7, @Nullable PostChannelFeedbackState postChannelFeedbackState, ImmutableList<Long> immutableList3, String str8, String str9, @Nullable String str10, @Nullable String str11, long j6, @Nullable String str12, boolean z7, @Nullable PromptAnalytics promptAnalytics, ImmutableList<String> immutableList4, @Nullable String str13, boolean z8) {
        this.f14107a = uploadPhotoSource;
        this.f14108b = j;
        this.f14109c = j2;
        this.f14110d = j3;
        this.f14111e = str;
        this.f14112f = z;
        this.f14113g = redSpaceValue;
        this.f14114h = z2;
        this.f14115i = str2;
        this.f14125s = dimension;
        this.f14116j = (PhotoUploadPrivacy) Preconditions.checkNotNull(photoUploadPrivacy);
        this.f14117k = str3;
        this.f14118l = z3;
        this.f14132z = null;
        this.f14083A = false;
        this.f14084B = 0;
        this.f14085C = false;
        this.f14086D = -1;
        this.f14119m = immutableList;
        this.f14120n = immutableList2;
        this.f14121o = minutiaeTag;
        this.f14122p = str4;
        this.f14123q = str5;
        this.f14124r = i;
        this.f14126t = viewerContext;
        this.f14127u = z4;
        this.f14087E = j4;
        this.f14128v = composerAppAttribution;
        this.f14129w = z5;
        this.f14130x = z6;
        this.f14088F = f;
        this.f14089G = f2;
        this.f14090H = publishMode;
        this.f14091I = j5;
        this.f14131y = creativeEditingUploadParams;
        this.f14092J = str6;
        this.f14093K = str7;
        this.f14094L = postChannelFeedbackState;
        this.f14095M = immutableList3;
        this.f14096N = str8;
        this.f14097O = str9;
        this.f14098P = str10;
        this.f14099Q = str11;
        this.f14100R = j6;
        this.f14101S = str12;
        this.f14102T = z7;
        this.f14103U = promptAnalytics;
        this.f14104V = immutableList4;
        this.f14105W = str13;
        this.f14106X = z8;
    }

    public final UploadPhotoParams m21808a() {
        return new UploadPhotoParams(new UploadPhotoSource(this.f14107a.m21835a(), -1), this.f14108b, this.f14109c, this.f14110d, this.f14111e, this.f14112f, this.f14113g, this.f14114h, this.f14115i, this.f14116j, this.f14117k, this.f14118l, this.f14119m, this.f14120n, this.f14121o, this.f14122p, this.f14123q, this.f14124r, this.f14125s, this.f14126t, this.f14127u, this.f14087E, this.f14128v, this.f14129w, this.f14130x, this.f14088F, this.f14089G, this.f14090H, this.f14091I, this.f14131y, this.f14092J, this.f14093K, this.f14094L, this.f14095M, this.f14096N, this.f14097O, this.f14098P, this.f14099Q, this.f14100R, this.f14101S, this.f14102T, this.f14103U, this.f14104V, this.f14105W, this.f14106X);
    }

    @Nullable
    public final String m21812b() {
        if (StringUtil.a(this.f14132z)) {
            return null;
        }
        return this.f14132z;
    }

    public final CreativeEditingUploadParams m21814c() {
        return this.f14131y;
    }

    @Nullable
    public final String m21816e() {
        return (this.f14131y == null || this.f14131y.f3381a == null || this.f14131y.f3381a.m4452o() == null) ? null : this.f14131y.f3381a.m4452o().getPath();
    }

    public final String m21815d() {
        return this.f14107a.f14133a;
    }

    public final String m21817f() {
        if (this.f14108b <= 0) {
            return null;
        }
        return Long.toString(this.f14108b);
    }

    public final String m21818g() {
        if (this.f14109c <= 0) {
            return null;
        }
        return Long.toString(this.f14109c);
    }

    public final String m21819h() {
        if (this.f14110d < 0) {
            return null;
        }
        return Long.toString(this.f14110d);
    }

    @Nullable
    public final String m21820i() {
        return this.f14111e;
    }

    public final boolean m21821j() {
        return this.f14112f;
    }

    public final RedSpaceValue m21822k() {
        return this.f14113g;
    }

    public final boolean m21823l() {
        return this.f14114h;
    }

    @Nullable
    public final String m21824m() {
        return this.f14115i;
    }

    public final String m21825n() {
        return this.f14117k;
    }

    public final boolean m21826o() {
        return this.f14118l;
    }

    public final PhotoUploadPrivacy m21827p() {
        return this.f14116j;
    }

    public final boolean m21828q() {
        return this.f14107a.f14134b > 0;
    }

    public final String m21829r() {
        return Long.toString(this.f14107a.f14134b);
    }

    public final void m21810a(String str) {
        this.f14132z = str;
    }

    public final void m21811a(boolean z) {
        this.f14083A = z;
    }

    public final boolean m21830u() {
        return this.f14083A;
    }

    public final void m21809a(long j) {
        this.f14084B = j;
    }

    public final long m21831v() {
        return this.f14084B;
    }

    public final void m21813b(boolean z) {
        this.f14085C = z;
    }

    public final boolean m21832w() {
        return this.f14085C;
    }

    public final ImmutableList<Long> m21833y() {
        return this.f14119m;
    }

    public final ImmutableList<Tag> m21834z() {
        return this.f14120n;
    }

    public final MinutiaeTag m21794A() {
        return this.f14121o;
    }

    public final String m21795B() {
        return this.f14122p;
    }

    public final String m21796C() {
        return this.f14123q;
    }

    public final int m21797D() {
        return this.f14124r;
    }

    public final Dimension m21798E() {
        return this.f14125s;
    }

    public final ViewerContext m21799F() {
        return this.f14126t;
    }

    public final boolean m21800G() {
        return this.f14127u;
    }

    public final long m21801H() {
        return this.f14087E;
    }

    public final ComposerAppAttribution m21802I() {
        return this.f14128v;
    }

    public final boolean m21803J() {
        return this.f14129w;
    }

    public final boolean m21804K() {
        return this.f14130x;
    }

    public final String m21805N() {
        return m21815d() != null ? m21815d() : "vault:" + m21829r();
    }

    public final String m21806T() {
        return this.f14097O;
    }

    public final long m21807W() {
        return this.f14100R;
    }

    public final ImmutableList<String> aa() {
        return this.f14104V;
    }

    @Nullable
    public final String ab() {
        return this.f14105W;
    }

    public final boolean ac() {
        return m21828q() || !Strings.isNullOrEmpty(this.f14105W);
    }

    public final boolean ad() {
        return this.f14106X;
    }

    public int describeContents() {
        return 0;
    }

    public UploadPhotoParams(Parcel parcel) {
        ImmutableList immutableList = null;
        this.f14107a = (UploadPhotoSource) parcel.readParcelable(UploadPhotoSource.class.getClassLoader());
        this.f14108b = parcel.readLong();
        this.f14109c = parcel.readLong();
        this.f14110d = parcel.readLong();
        this.f14111e = parcel.readString();
        this.f14112f = ParcelUtil.a(parcel);
        this.f14113g = (RedSpaceValue) parcel.readSerializable();
        this.f14114h = ParcelUtil.a(parcel);
        this.f14115i = parcel.readString();
        this.f14116j = (PhotoUploadPrivacy) parcel.readParcelable(PhotoUploadPrivacy.class.getClassLoader());
        this.f14117k = parcel.readString();
        this.f14118l = ParcelUtil.a(parcel);
        this.f14132z = parcel.readString();
        this.f14083A = ParcelUtil.a(parcel);
        this.f14084B = parcel.readLong();
        this.f14085C = ParcelUtil.a(parcel);
        this.f14086D = parcel.readInt();
        Collection readArrayList = parcel.readArrayList(Long.class.getClassLoader());
        Collection readArrayList2 = parcel.readArrayList(Tag.class.getClassLoader());
        this.f14119m = readArrayList != null ? ImmutableList.copyOf(readArrayList) : null;
        if (readArrayList2 != null) {
            immutableList = ImmutableList.copyOf(readArrayList2);
        }
        this.f14120n = immutableList;
        this.f14121o = (MinutiaeTag) parcel.readParcelable(MinutiaeTag.class.getClassLoader());
        this.f14122p = parcel.readString();
        this.f14123q = parcel.readString();
        this.f14124r = parcel.readInt();
        this.f14125s = new Dimension(parcel.readInt(), parcel.readInt());
        this.f14126t = (ViewerContext) parcel.readParcelable(ViewerContext.class.getClassLoader());
        this.f14127u = ParcelUtil.a(parcel);
        this.f14087E = parcel.readLong();
        this.f14128v = (ComposerAppAttribution) parcel.readParcelable(ComposerAppAttribution.class.getClassLoader());
        this.f14130x = ParcelUtil.a(parcel);
        this.f14129w = ParcelUtil.a(parcel);
        this.f14088F = parcel.readFloat();
        this.f14089G = parcel.readFloat();
        this.f14090H = (PublishMode) parcel.readSerializable();
        this.f14091I = parcel.readLong();
        this.f14131y = (CreativeEditingUploadParams) parcel.readParcelable(CreativeEditingUploadParams.class.getClassLoader());
        this.f14092J = parcel.readString();
        this.f14093K = parcel.readString();
        this.f14094L = (PostChannelFeedbackState) ParcelUtil.c(parcel, PostChannelFeedbackState.class);
        this.f14095M = ImmutableList.copyOf(parcel.readArrayList(Long.class.getClassLoader()));
        this.f14096N = parcel.readString();
        this.f14097O = parcel.readString();
        this.f14098P = parcel.readString();
        this.f14099Q = parcel.readString();
        this.f14100R = parcel.readLong();
        this.f14101S = parcel.readString();
        this.f14102T = ParcelUtil.a(parcel);
        this.f14103U = (PromptAnalytics) parcel.readParcelable(PromptAnalytics.class.getClassLoader());
        this.f14104V = ParcelUtil.j(parcel);
        this.f14105W = parcel.readString();
        this.f14106X = ParcelUtil.a(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f14107a, i);
        parcel.writeLong(this.f14108b);
        parcel.writeLong(this.f14109c);
        parcel.writeLong(this.f14110d);
        parcel.writeString(this.f14111e);
        ParcelUtil.a(parcel, this.f14112f);
        parcel.writeSerializable(this.f14113g);
        ParcelUtil.a(parcel, this.f14114h);
        parcel.writeString(this.f14115i);
        parcel.writeParcelable(this.f14116j, i);
        parcel.writeString(this.f14117k);
        ParcelUtil.a(parcel, this.f14118l);
        parcel.writeString(this.f14132z);
        ParcelUtil.a(parcel, this.f14083A);
        parcel.writeLong(this.f14084B);
        ParcelUtil.a(parcel, this.f14085C);
        parcel.writeInt(this.f14086D);
        parcel.writeList(this.f14119m);
        parcel.writeList(this.f14120n);
        parcel.writeParcelable(this.f14121o, i);
        parcel.writeString(this.f14122p);
        parcel.writeString(this.f14123q);
        parcel.writeInt(this.f14124r);
        parcel.writeInt(this.f14125s.b);
        parcel.writeInt(this.f14125s.a);
        parcel.writeParcelable(this.f14126t, i);
        ParcelUtil.a(parcel, this.f14127u);
        parcel.writeLong(this.f14087E);
        parcel.writeParcelable(this.f14128v, i);
        ParcelUtil.a(parcel, this.f14130x);
        ParcelUtil.a(parcel, this.f14129w);
        parcel.writeFloat(this.f14088F);
        parcel.writeFloat(this.f14089G);
        parcel.writeSerializable(this.f14090H);
        parcel.writeLong(this.f14091I);
        parcel.writeParcelable(this.f14131y, i);
        parcel.writeString(this.f14092J);
        parcel.writeString(this.f14093K);
        ParcelUtil.a(parcel, this.f14094L);
        parcel.writeList(this.f14095M);
        parcel.writeString(this.f14096N);
        parcel.writeString(this.f14097O);
        parcel.writeString(this.f14098P);
        parcel.writeString(this.f14099Q);
        parcel.writeLong(this.f14100R);
        parcel.writeString(this.f14101S);
        ParcelUtil.a(parcel, this.f14102T);
        parcel.writeParcelable(this.f14103U, i);
        ParcelUtil.a(parcel, this.f14104V);
        parcel.writeString(this.f14105W);
        ParcelUtil.a(parcel, this.f14106X);
    }
}
