package com.facebook.chrome;

import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import com.facebook.analytics.tagging.AnalyticsActivityWithExtraData;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.base.activity.FbFragmentActivityDelegate;
import com.facebook.bugreporter.activity.ActivityWithDebugInfo;
import com.facebook.bugreporter.activity.FragmentWithDebugInfo;
import com.facebook.feed.ui.fullscreenvideoplayer.FullScreenVideoInflater;
import com.facebook.feed.video.FullScreenVideoPlayerHost;
import com.facebook.feed.video.ImmersiveVideoPlayer;
import com.facebook.video.channelfeed.ChannelFeedInflater;
import com.facebook.video.watchandbrowse.VideoWatchAndBrowseInflator;
import com.facebook.widget.titlebar.CanAnimateButtonSpecs;
import com.facebook.widget.titlebar.CanDisplaySearchButton;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: ranked_threads */
public abstract class FbChromeActivityDelegate extends FbFragmentActivityDelegate implements AnalyticsActivityWithExtraData, ActivityWithDebugInfo, FullScreenVideoPlayerHost, HasTitleBar {
    private ImmersiveVideoPlayer f5883a;
    private ImmersiveVideoPlayer f5884b;
    public ImmersiveVideoPlayer f5885c;
    public FullScreenVideoInflater f5886d;
    public ChannelFeedInflater f5887e;
    public VideoWatchAndBrowseInflator f5888f;
    public FbTitleBar f5889g;
    private View f5890h;

    public abstract Fragment m6116A();

    public abstract void m6117B();

    public abstract void m6118C();

    public final void m6126e(int i) {
        super.e(i);
        m6117B();
        m6118C();
    }

    protected void m6130m() {
        this.f5883a = null;
        this.f5884b = null;
        this.f5885c = null;
        if (this.f5886d != null) {
            this.f5886d.a = null;
            this.f5886d = null;
        }
        if (this.f5887e != null) {
            this.f5887e.m2308a();
            this.f5887e = null;
        }
        if (this.f5888f != null) {
            this.f5888f.f3377a = null;
            this.f5888f = null;
        }
        super.m();
    }

    public final boolean m6123b(int i, KeyEvent keyEvent) {
        if (this.f5885c != null) {
            this.f5885c.u_(i);
        }
        return super.b(i, keyEvent);
    }

    public final void a_(String str) {
        this.f5889g.setTitle(str);
    }

    public final void y_(int i) {
        this.f5889g.setTitle(i);
    }

    public void setCustomTitle(View view) {
        this.f5889g.setCustomTitleView(view);
        this.f5890h = view;
    }

    public final View lh_() {
        return this.f5890h;
    }

    public final void m6121a(@Nullable TitleBarButtonSpec titleBarButtonSpec) {
        List list;
        if (titleBarButtonSpec == null) {
            list = RegularImmutableList.a;
        } else {
            list = ImmutableList.of(titleBarButtonSpec);
        }
        this.f5889g.setButtonSpecs(list);
    }

    public final void m6122b(TitleBarButtonSpec titleBarButtonSpec) {
        List list;
        if (titleBarButtonSpec == null) {
            list = RegularImmutableList.a;
        } else {
            list = ImmutableList.of(titleBarButtonSpec);
        }
        if (this.f5889g instanceof CanAnimateButtonSpecs) {
            ((CanAnimateButtonSpecs) this.f5889g).setButtonSpecsWithAnimation(list);
        } else {
            this.f5889g.setButtonSpecs(list);
        }
    }

    public final void m6120a(@Nullable OnToolbarButtonListener onToolbarButtonListener) {
        this.f5889g.setOnToolbarButtonListener(onToolbarButtonListener);
    }

    public final void kg_() {
        this.f5889g.setButtonSpecs(RegularImmutableList.a);
        this.f5889g.setOnToolbarButtonListener(null);
    }

    public final void m6125c(boolean z) {
        if (this.f5889g instanceof CanDisplaySearchButton) {
            ((CanDisplaySearchButton) this.f5889g).setSearchButtonVisible(!z);
        }
    }

    public final boolean m6119D() {
        return this.f5885c != null;
    }

    public final boolean m6127h() {
        return this.f5885c != null && this.f5885c.a();
    }

    public final ImmersiveVideoPlayer m6128k() {
        if (this.f5883a == null && this.f5886d != null) {
            this.f5883a = this.f5886d.a(this.a);
        }
        this.f5885c = this.f5883a;
        return this.f5883a;
    }

    public final ImmersiveVideoPlayer m6129l() {
        this.f5884b = this.f5887e.m2307a(this.a);
        this.f5885c = this.f5884b;
        return this.f5884b;
    }

    public final ImmersiveVideoPlayer m6131n() {
        this.f5883a = this.f5888f.m3212a(this.a);
        this.f5885c = this.f5883a;
        return this.f5883a;
    }

    public final boolean m6132o() {
        if (this.f5885c == null || !this.f5885c.a()) {
            return false;
        }
        return this.f5885c.b();
    }

    public final String am_() {
        Fragment A = m6116A();
        if (A instanceof AnalyticsFragment) {
            return ((AnalyticsFragment) A).am_();
        }
        return "unknown";
    }

    public final Map<String, Object> m6124c() {
        Fragment A = m6116A();
        if (A instanceof AnalyticsFragmentWithExtraData) {
            return ((AnalyticsFragmentWithExtraData) A).c();
        }
        return null;
    }

    public Map<String, String> getDebugInfo() {
        Builder builder = ImmutableMap.builder();
        Fragment A = m6116A();
        if (A instanceof FragmentWithDebugInfo) {
            builder.a(((FragmentWithDebugInfo) A).getDebugInfo());
        }
        return builder.b();
    }
}
