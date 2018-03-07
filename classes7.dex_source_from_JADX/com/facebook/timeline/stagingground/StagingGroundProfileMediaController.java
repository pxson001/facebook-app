package com.facebook.timeline.stagingground;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.bitmaps.Dimension;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.qe.api.QeAccessor;
import com.facebook.timeline.stagingground.StagingGroundController.C10701;
import com.facebook.timeline.tempprofilepic.ExpirationDialogController;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: failed to fetch available image from server on first query */
public abstract class StagingGroundProfileMediaController {
    protected static final CallerContext f14819e = CallerContext.a(StagingGroundProfileMediaController.class, "timeline");
    protected static final RectF f14820f = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    protected Uri f14821g;
    protected Uri f14822h;
    protected RectF f14823i = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    protected Dimension f14824j;
    protected String f14825k;
    public String f14826l;
    public String f14827m;
    public String f14828n;
    public final Context f14829o;
    protected final AbstractFbErrorReporter f14830p;
    protected final Executor f14831q;
    protected final StagingGroundAnalyticsLogger f14832r;
    protected final QeAccessor f14833s;

    public abstract OnClickListener mo1152a(FbFragmentActivity fbFragmentActivity);

    public abstract OnToolbarButtonListener mo1153a(FbFragmentActivity fbFragmentActivity, ExpirationDialogController expirationDialogController);

    public abstract void mo1154a();

    public abstract void mo1155a(Activity activity, int i, int i2, Intent intent);

    public abstract void mo1157a(View view);

    public abstract void mo1159a(C10701 c10701);

    public abstract DialogInterface.OnClickListener mo1160b(FbFragmentActivity fbFragmentActivity);

    public abstract void mo1161b();

    public abstract void mo1162b(View view);

    public abstract boolean mo1163d();

    @Nullable
    public abstract String mo1164e();

    public abstract void mo1165f();

    public abstract void mo1166g();

    @StringRes
    public abstract int mo1167h();

    public StagingGroundProfileMediaController(Context context, AbstractFbErrorReporter abstractFbErrorReporter, Executor executor, StagingGroundAnalyticsLogger stagingGroundAnalyticsLogger, QeAccessor qeAccessor) {
        this.f14829o = context;
        this.f14830p = abstractFbErrorReporter;
        this.f14831q = executor;
        this.f14832r = stagingGroundAnalyticsLogger;
        this.f14833s = qeAccessor;
    }

    public void mo1158a(FbFragmentActivity fbFragmentActivity, Bundle bundle, StagingGroundLaunchConfig stagingGroundLaunchConfig) {
        Dimension dimension = null;
        if (bundle == null || !bundle.containsKey("mediaUriKey")) {
            this.f14821g = stagingGroundLaunchConfig.f14770b;
        } else {
            this.f14821g = (Uri) bundle.get("mediaUriKey");
        }
        this.f14822h = bundle != null ? (Uri) bundle.getParcelable("unmodifiedFileSchemeUriKey") : null;
        if (bundle == null || !bundle.containsKey("mediaCropBoxKey")) {
            this.f14823i = stagingGroundLaunchConfig.f14791w;
        } else {
            this.f14823i = (RectF) bundle.get("mediaCropBoxKey");
        }
        if (bundle != null) {
            dimension = new Dimension(bundle.getInt("uncroppedMediaWidth"), bundle.getInt("uncroppedMediaHeight"));
        }
        this.f14824j = dimension;
        this.f14826l = stagingGroundLaunchConfig.f14771c;
        this.f14825k = stagingGroundLaunchConfig.f14772d;
        this.f14827m = stagingGroundLaunchConfig.f14773e;
    }

    public void mo1156a(Bundle bundle) {
        bundle.putParcelable("mediaUriKey", this.f14821g);
        bundle.putParcelable("unmodifiedFileSchemeUriKey", this.f14822h);
        bundle.putParcelable("mediaCropBoxKey", this.f14823i);
        if (this.f14824j != null) {
            bundle.putInt("uncroppedMediaWidth", this.f14824j.b);
            bundle.putInt("uncroppedMediaHeight", this.f14824j.a);
        }
    }
}
