package com.facebook.photos.creativeediting.swipeable.common;

import android.content.Context;
import android.graphics.RectF;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.bitmaps.Dimension;
import com.facebook.common.time.SystemClock;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.creativeediting.model.Filter;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.FramePack;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel.StickerAssetsModel.NodesModel;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel.StickerAssetsModel.NodesModel.StickerModel.PreviewImageModel;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel.TextAssetsModel;
import com.facebook.photos.creativeediting.model.StickerAssetPosition;
import com.facebook.photos.creativeediting.model.StickerAssetPosition.HorizontalAlignment;
import com.facebook.photos.creativeediting.model.StickerAssetPosition.SizeDimension;
import com.facebook.photos.creativeediting.model.StickerAssetPosition.VerticalAlignment;
import com.facebook.photos.creativeediting.model.StickerParams;
import com.facebook.photos.creativeediting.model.SwipeableParams;
import com.facebook.photos.creativeediting.model.SwipeableParams.SwipeableItemType;
import com.facebook.photos.creativeediting.model.TextAssetPosition;
import com.facebook.photos.creativeediting.swipeable.common.FramesLogger.Event;
import com.facebook.photos.creativeediting.swipeable.common.FramesLogger.Extras;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: mBssid */
public class SwipeableParamsHelper {
    private final Context f9777a;
    private final FramesLogger f9778b;
    private final Provider<Boolean> f9779c;
    private FrameAssetsLoader f9780d;
    private BitmapUtils f9781e;

    /* compiled from: mBssid */
    /* synthetic */ class C08061 {
        static final /* synthetic */ int[] f9772a = new int[HorizontalAlignment.values().length];
        static final /* synthetic */ int[] f9773b = new int[VerticalAlignment.values().length];
        static final /* synthetic */ int[] f9774c = new int[TextAssetPosition.HorizontalAlignment.values().length];
        static final /* synthetic */ int[] f9775d = new int[TextAssetPosition.VerticalAlignment.values().length];
        static final /* synthetic */ int[] f9776e = new int[Filter.values().length];

        static {
            try {
                f9776e[Filter.PassThrough.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9776e[Filter.AE08bit.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f9776e[Filter.ZebraBW.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f9776e[Filter.SummerRGB.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f9776e[Filter.SpringRGB.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f9776e[Filter.FallRGB.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f9776e[Filter.VintageRGB.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f9776e[Filter.WinterRGB.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f9775d[TextAssetPosition.VerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f9775d[TextAssetPosition.VerticalAlignment.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f9775d[TextAssetPosition.VerticalAlignment.BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f9773b[VerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f9773b[VerticalAlignment.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f9773b[VerticalAlignment.BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f9772a[HorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f9772a[HorizontalAlignment.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f9772a[HorizontalAlignment.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError e17) {
            }
        }
    }

    public static SwipeableParamsHelper m11713b(InjectorLike injectorLike) {
        return new SwipeableParamsHelper((Context) injectorLike.getInstance(Context.class), new FramesLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike)), IdBasedProvider.a(injectorLike, 4249), FrameAssetsLoader.m11662a(injectorLike), BitmapUtils.a(injectorLike));
    }

    @Inject
    public SwipeableParamsHelper(Context context, FramesLogger framesLogger, Provider<Boolean> provider, FrameAssetsLoader frameAssetsLoader, BitmapUtils bitmapUtils) {
        this.f9777a = context;
        this.f9778b = framesLogger;
        this.f9779c = provider;
        this.f9780d = frameAssetsLoader;
        this.f9781e = bitmapUtils;
    }

    public static SwipeableParamsHelper m11708a(InjectorLike injectorLike) {
        return m11713b(injectorLike);
    }

    public final ImmutableList<SwipeableParams> m11716a() {
        Builder builder = new Builder();
        if (((Boolean) this.f9779c.get()).booleanValue()) {
            for (Filter filter : Filter.values()) {
                builder.c(new SwipeableParams(RegularImmutableList.a, filter.name(), SwipeableItemType.FILTER, m11718a(filter.name())));
            }
        } else {
            builder.c(new SwipeableParams(RegularImmutableList.a, Filter.PassThrough.name(), SwipeableItemType.FILTER, m11718a(Filter.PassThrough.name())));
        }
        return builder.b();
    }

    public static boolean m11710a(long j, long j2) {
        long a = SystemClock.a.a() / 1000;
        if (j == 0 && j2 == 0) {
            return true;
        }
        if (j > a || j2 <= a) {
            return false;
        }
        return true;
    }

    private static boolean m11709a(int i, int i2) {
        if (Math.abs(i - i2) >= 8 && ((float) i) / ((float) i2) < 1.0f) {
            return true;
        }
        return false;
    }

    private static float m11711b(int i, int i2) {
        return ((float) i) / ((float) i2);
    }

    public final ImmutableList<SwipeableParams> m11717a(FramePack framePack, int i, int i2) {
        Builder builder = new Builder();
        ImmutableList c = framePack.c();
        int size = c.size();
        for (int i3 = 0; i3 < size; i3++) {
            FrameModel frameModel = (FrameModel) c.get(i3);
            SwipeableParams a = m11715a(frameModel, i, i2, framePack.bJ_());
            if (a != null) {
                builder.c(a);
            } else {
                FramesLogger framesLogger = this.f9778b;
                HoneyClientEvent b = new HoneyClientEvent(Event.FRAME_IGNORED_ASSET_MISSING.toString()).b(Extras.FRAME_ID.toString(), frameModel.c());
                b.c = "composer";
                framesLogger.f9751a.a(b);
            }
        }
        return builder.b();
    }

    @Nullable
    public final SwipeableParams m11715a(FrameModel frameModel, int i, int i2, String str) {
        int i3 = 0;
        Builder builder = new Builder();
        if (frameModel.bE_() != null) {
            ImmutableList a = frameModel.bE_().a();
            int size = a.size();
            for (int i4 = 0; i4 < size; i4++) {
                StickerAssetPosition stickerAssetPosition;
                NodesModel nodesModel = (NodesModel) a.get(i4);
                if (m11709a(i, i2)) {
                    stickerAssetPosition = new StickerAssetPosition(nodesModel.b());
                } else {
                    stickerAssetPosition = new StickerAssetPosition(nodesModel.a());
                }
                PreviewImageModel c = nodesModel.d().c();
                builder.c(m11703a(Uri.parse(c.b()), m11711b(c.c(), c.a()), (float) nodesModel.c(), stickerAssetPosition, i, i2));
            }
        }
        if (frameModel.g() != null) {
            ImmutableList a2 = frameModel.g().a();
            int size2 = a2.size();
            while (i3 < size2) {
                TextAssetPosition textAssetPosition;
                TextAssetsModel.NodesModel nodesModel2 = (TextAssetsModel.NodesModel) a2.get(i3);
                if (m11709a(i, i2)) {
                    textAssetPosition = new TextAssetPosition(nodesModel2.b());
                } else {
                    textAssetPosition = new TextAssetPosition(nodesModel2.a());
                }
                builder.c(m11704a(Uri.fromFile(this.f9780d.m11670a(nodesModel2, frameModel.c())), 0.0f, textAssetPosition, i, i2));
                i3++;
            }
        }
        return new SwipeableParams(builder.b(), frameModel.c(), SwipeableItemType.FRAME, str);
    }

    private static StickerParams m11703a(Uri uri, float f, float f2, StickerAssetPosition stickerAssetPosition, int i, int i2) {
        float b;
        float f3;
        float e;
        float f4 = 0.0f;
        if (stickerAssetPosition.a == SizeDimension.WIDTH) {
            b = stickerAssetPosition.b() / 100.0f;
            f3 = (((float) ((int) (((float) i) * b))) / f) / ((float) i2);
        } else {
            f3 = stickerAssetPosition.b() / 100.0f;
            b = (((float) ((int) (((float) i2) * f3))) * f) / ((float) i);
        }
        switch (C08061.f9772a[stickerAssetPosition.c().ordinal()]) {
            case 1:
                e = stickerAssetPosition.e() / 100.0f;
                break;
            case 2:
                e = (1.0f - b) / 2.0f;
                break;
            case 3:
                e = (1.0f - (stickerAssetPosition.e() / 100.0f)) - b;
                break;
            default:
                e = 0.0f;
                break;
        }
        switch (C08061.f9773b[stickerAssetPosition.d().ordinal()]) {
            case 1:
                f4 = stickerAssetPosition.f() / 100.0f;
                break;
            case 2:
                f4 = (1.0f - f3) / 2.0f;
                break;
            case 3:
                f4 = (1.0f - (stickerAssetPosition.f() / 100.0f)) - f3;
                break;
        }
        StickerParams.Builder builder = new StickerParams.Builder(uri, uri.getPath());
        builder.d = f2;
        builder = builder;
        builder.e = e;
        StickerParams.Builder builder2 = builder;
        builder2.f = f4;
        builder2 = builder2;
        builder2.g = b;
        StickerParams.Builder builder3 = builder2;
        builder3.h = f3;
        return builder3.a();
    }

    private StickerParams m11704a(Uri uri, float f, TextAssetPosition textAssetPosition, int i, int i2) {
        float f2;
        float f3 = textAssetPosition.b / 100.0f;
        Dimension a = BitmapUtils.a(uri.getPath());
        float f4 = (((float) a.b) * ((((float) i2) / ((float) a.a)) * f3)) / ((float) i);
        int[] iArr = C08061.f9774c;
        textAssetPosition.c.ordinal();
        float f5 = (1.0f - f4) / 2.0f;
        switch (C08061.f9775d[textAssetPosition.d.ordinal()]) {
            case 1:
                f2 = textAssetPosition.f / 100.0f;
                break;
            case 2:
                f2 = (1.0f - f3) / 2.0f;
                break;
            case 3:
                f2 = (1.0f - (textAssetPosition.f / 100.0f)) - f3;
                break;
            default:
                f2 = 0.0f;
                break;
        }
        StickerParams.Builder builder = new StickerParams.Builder(uri, uri.getPath());
        builder.d = f;
        builder = builder;
        builder.e = f5;
        StickerParams.Builder builder2 = builder;
        builder2.f = f2;
        StickerParams.Builder builder3 = builder2;
        builder3.g = f4;
        builder3 = builder3;
        builder3.h = f3;
        return builder3.a();
    }

    public final String m11718a(String str) {
        if (StringUtil.a(str)) {
            return "";
        }
        switch (C08061.f9776e[Filter.getValue(str).ordinal()]) {
            case 1:
                return this.f9777a.getResources().getString(2131234484);
            case 2:
                return this.f9777a.getResources().getString(2131234485);
            case 3:
                return this.f9777a.getResources().getString(2131234486);
            case 4:
                return this.f9777a.getResources().getString(2131234487);
            case 5:
                return this.f9777a.getResources().getString(2131234488);
            case 6:
                return this.f9777a.getResources().getString(2131234489);
            case 7:
                return this.f9777a.getResources().getString(2131234490);
            case 8:
                return this.f9777a.getResources().getString(2131234491);
            default:
                return "";
        }
    }

    @Nullable
    public static SwipeableParams m11707a(ImmutableList<SwipeableParams> immutableList, String str) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            SwipeableParams swipeableParams = (SwipeableParams) immutableList.get(i);
            if (swipeableParams.b.equals(str)) {
                return swipeableParams;
            }
        }
        if (immutableList.isEmpty()) {
            return null;
        }
        return (SwipeableParams) immutableList.get(0);
    }

    @Nullable
    public static SwipeableParams m11706a(ImmutableList<SwipeableParams> immutableList, SwipeableParams swipeableParams) {
        if (immutableList.size() < 2) {
            return null;
        }
        for (int i = 0; i < immutableList.size(); i++) {
            if (swipeableParams.b.equals(((SwipeableParams) immutableList.get(i)).b)) {
                return (SwipeableParams) immutableList.get((i + 1) % immutableList.size());
            }
        }
        return null;
    }

    @Nullable
    public static SwipeableParams m11712b(ImmutableList<SwipeableParams> immutableList, SwipeableParams swipeableParams) {
        if (immutableList.size() < 2) {
            return null;
        }
        for (int i = 0; i < immutableList.size(); i++) {
            if (swipeableParams.b.equals(((SwipeableParams) immutableList.get(i)).b)) {
                return (SwipeableParams) immutableList.get(((immutableList.size() + i) - 1) % immutableList.size());
            }
        }
        return null;
    }

    public static ImmutableList<StickerParams> m11714b(ImmutableList<SwipeableParams> immutableList, String str) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            SwipeableParams swipeableParams = (SwipeableParams) immutableList.get(i);
            if (swipeableParams.b.equals(str)) {
                return swipeableParams.a();
            }
        }
        return RegularImmutableList.a;
    }

    public static StickerParams m11705a(StickerParams stickerParams, Pair<Integer, Integer> pair) {
        float intValue = (float) ((Integer) pair.a).intValue();
        float intValue2 = (float) ((Integer) pair.b).intValue();
        RectF rectF = new RectF();
        if (intValue == intValue2) {
            return stickerParams;
        }
        float o;
        float f;
        if (intValue < intValue2) {
            o = stickerParams.o();
            f = stickerParams.f();
            intValue = (intValue2 * f) / intValue;
            if ((1.0f - o) - f == 0.0f) {
                intValue2 = 1.0f - intValue;
            } else {
                intValue2 = ((1.0f - intValue) * o) / (1.0f - f);
            }
            rectF.set(stickerParams.n(), intValue2, stickerParams.e() + stickerParams.n(), intValue + intValue2);
        } else {
            o = stickerParams.n();
            f = stickerParams.e();
            intValue = (intValue * f) / intValue2;
            intValue2 = (1.0f - o) - f == 0.0f ? 1.0f - intValue : ((1.0f - intValue) * o) / (1.0f - f);
            rectF.set(intValue2, stickerParams.o(), intValue + intValue2, stickerParams.f() + stickerParams.o());
        }
        return (StickerParams) stickerParams.a(rectF, stickerParams.b(), stickerParams.c());
    }
}
