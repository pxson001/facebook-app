package com.facebook.chrome;

import android.view.View;
import com.facebook.analytics.tagging.AnalyticsActivityWithExtraData;
import com.facebook.base.activity.DelegatingFbFragmentFrameworkActivity;
import com.facebook.bugreporter.activity.ActivityWithDebugInfo;
import com.facebook.feed.video.FullScreenVideoPlayerHost;
import com.facebook.feed.video.ImmersiveVideoPlayer;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import java.util.Map;

/* compiled from: my_MM */
public abstract class FbChromeDelegatingActivity extends DelegatingFbFragmentFrameworkActivity implements AnalyticsActivityWithExtraData, ActivityWithDebugInfo, FullScreenVideoPlayerHost, HasTitleBar {
    public FbChromeActivityDelegate f13063p;

    protected FbChromeDelegatingActivity(FbChromeActivityDelegate fbChromeActivityDelegate) {
        super(fbChromeActivityDelegate);
        this.f13063p = fbChromeActivityDelegate;
    }

    public final boolean mo796h() {
        return this.f13063p.h();
    }

    public final ImmersiveVideoPlayer mo798k() {
        return this.f13063p.k();
    }

    public final ImmersiveVideoPlayer mo799l() {
        return this.f13063p.l();
    }

    public final ImmersiveVideoPlayer mo801n() {
        return this.f13063p.n();
    }

    public final boolean mo802o() {
        return this.f13063p.o();
    }

    public Map<String, String> getDebugInfo() {
        return this.f13063p.getDebugInfo();
    }

    public final String am_() {
        return this.f13063p.am_();
    }

    public final Map<String, Object> mo792c() {
        return this.f13063p.c();
    }

    public final void a_(String str) {
        this.f13063p.a_(str);
    }

    public final void y_(int i) {
        this.f13063p.y_(i);
    }

    public void setCustomTitle(View view) {
        this.f13063p.setCustomTitle(view);
    }

    public final View lh_() {
        return this.f13063p.lh_();
    }

    public final void mo2555a(TitleBarButtonSpec titleBarButtonSpec) {
        this.f13063p.a(titleBarButtonSpec);
    }

    public final void mo2557b(TitleBarButtonSpec titleBarButtonSpec) {
        this.f13063p.b(titleBarButtonSpec);
    }

    public final void mo2554a(OnToolbarButtonListener onToolbarButtonListener) {
        this.f13063p.a(onToolbarButtonListener);
    }

    public final void kg_() {
        this.f13063p.kg_();
    }

    public final void mo2558c(boolean z) {
        this.f13063p.c(z);
    }
}
