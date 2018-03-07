package com.facebook.facecast.plugin.creativetools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.facebook.debug.log.BLog;
import com.facebook.facecast.FacecastPreviewView;
import com.facebook.facecast.PreviewRenderer;
import com.facebook.facecast.plugin.FacecastAnalyticsLogger;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: batch_upload_fail */
public class CreativeToolsTray extends CustomLinearLayout {
    private static final String f18720c = CreativeToolsTray.class.getName();
    @Inject
    FacecastAnalyticsLogger f18721a;
    @Inject
    CreativeToolsBasicAdjustmentFilterTrayControllerProvider f18722b;
    private final BetterTextView f18723d;
    private final LinearLayout f18724e;
    private final FrameLayout f18725f;
    @Nullable
    private CreativeToolsPack f18726g;
    @Nullable
    private PreviewRenderer f18727h;
    @Nullable
    private FacecastPreviewView f18728i;
    @Nullable
    private CreativeToolsTrayController f18729j;
    @Nullable
    private CreativeToolsBasicAdjustmentFilterTrayController f18730k;
    @Nullable
    private CreativeToolsColorDoodleTrayController f18731l;

    private static <T extends View> void m22281a(Class<T> cls, T t) {
        m22282a((Object) t, t.getContext());
    }

    private static void m22282a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((CreativeToolsTray) obj).m22280a(FacecastAnalyticsLogger.m21959a(injectorLike), (CreativeToolsBasicAdjustmentFilterTrayControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CreativeToolsBasicAdjustmentFilterTrayControllerProvider.class));
    }

    public CreativeToolsTray(Context context) {
        this(context, null);
    }

    public CreativeToolsTray(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CreativeToolsTray(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22281a(CreativeToolsTray.class, (View) this);
        setContentView(2130904200);
        setOrientation(1);
        this.f18723d = (BetterTextView) a(2131561628);
        this.f18724e = (LinearLayout) a(2131561627);
        this.f18725f = (FrameLayout) a(2131561629);
    }

    public final void m22284a(PreviewRenderer previewRenderer, FacecastPreviewView facecastPreviewView) {
        this.f18727h = previewRenderer;
        this.f18728i = facecastPreviewView;
    }

    public void setCreativeToolsPack(CreativeToolsPack creativeToolsPack) {
        String str = null;
        if (this.f18726g != creativeToolsPack) {
            CreativeToolsTrayController creativeToolsTrayController;
            CreativeToolsPack creativeToolsPack2 = this.f18726g;
            this.f18726g = creativeToolsPack;
            this.f18723d.setText(creativeToolsPack.mo1435a());
            switch (creativeToolsPack.mo1437c()) {
                case CREATIVE_TOOLS_PACK_TYPE_BASIC_ADJUSTMENT_FILTER:
                    if (this.f18730k == null) {
                        this.f18730k = new CreativeToolsBasicAdjustmentFilterTrayController(getContext(), this.f18727h, FacecastAnalyticsLogger.m21959a(this.f18722b));
                    }
                    this.f18730k.m22243a((CreativeToolsBasicAdjustmentPack) creativeToolsPack);
                    creativeToolsTrayController = this.f18730k;
                    break;
                case CREATIVE_TOOLS_PACK_TYPE_COLOR_DOODLE:
                    if (this.f18731l == null) {
                        this.f18731l = new CreativeToolsColorDoodleTrayController(getContext());
                        this.f18731l.f18697g = this.f18727h;
                    }
                    this.f18731l.f18692b.setColorDoodlePack((CreativeToolsColorDoodlePack) creativeToolsPack);
                    creativeToolsTrayController = this.f18731l;
                    break;
                default:
                    creativeToolsTrayController = null;
                    break;
            }
            if (creativeToolsTrayController != this.f18729j) {
                if (this.f18729j != null) {
                    this.f18729j.mo1433b(this.f18728i);
                    this.f18724e.removeView(this.f18729j.mo1434c());
                    this.f18725f.removeView(this.f18729j.mo1432b());
                }
                this.f18729j = creativeToolsTrayController;
                if (creativeToolsTrayController == null) {
                    String string = getResources().getString(creativeToolsPack.mo1435a());
                    BLog.b(f18720c, "Cannot show %s pack", new Object[]{string});
                    return;
                }
                if (creativeToolsTrayController.mo1434c() != null) {
                    this.f18724e.addView(creativeToolsTrayController.mo1434c(), -2, -1);
                }
                this.f18725f.addView(creativeToolsTrayController.mo1432b(), -1, -1);
                this.f18729j.mo1430a(this.f18728i);
                FacecastAnalyticsLogger facecastAnalyticsLogger = this.f18721a;
                String d = this.f18726g.mo1438d();
                if (creativeToolsPack2 != null) {
                    str = creativeToolsPack2.mo1438d();
                }
                CreativeToolsUtil.m22286a(facecastAnalyticsLogger, d, str);
            }
        }
    }

    public final void m22283a() {
        if (this.f18727h != null) {
            this.f18727h.f18104y = true;
        }
        if (this.f18729j != null) {
            this.f18729j.mo1430a(this.f18728i);
        }
    }

    public final void m22285b() {
        if (this.f18727h != null) {
            this.f18727h.f18104y = false;
        }
        if (this.f18729j != null) {
            this.f18729j.mo1433b(this.f18728i);
        }
    }

    private void m22280a(FacecastAnalyticsLogger facecastAnalyticsLogger, CreativeToolsBasicAdjustmentFilterTrayControllerProvider creativeToolsBasicAdjustmentFilterTrayControllerProvider) {
        this.f18721a = facecastAnalyticsLogger;
        this.f18722b = creativeToolsBasicAdjustmentFilterTrayControllerProvider;
    }
}
