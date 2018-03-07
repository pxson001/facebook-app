package com.facebook.reaction.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.common.util.FindViewUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.FbSwipeRefreshLayout;
import javax.annotation.Nullable;

/* compiled from: UnownedNonLocalPagePhotosQuery */
public abstract class BaseFullscreenReactionFragment extends BaseReactionFragment {
    public SwipeRefreshLayout f21121a;

    /* compiled from: UnownedNonLocalPagePhotosQuery */
    class C22311 implements OnRefreshListener {
        final /* synthetic */ BaseFullscreenReactionFragment f21120a;

        C22311(BaseFullscreenReactionFragment baseFullscreenReactionFragment) {
            this.f21120a = baseFullscreenReactionFragment;
        }

        public final void m24734a() {
            this.f21120a.f21121a.setRefreshing(true);
            this.f21120a.m24737e();
        }
    }

    public void kQ_() {
        super.kQ_();
        au();
    }

    public void kp_() {
        super.kp_();
        au();
    }

    protected int aq() {
        return 2130906671;
    }

    protected FrameLayout mo1154a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        boolean z;
        FrameLayout frameLayout = (FrameLayout) layoutInflater.inflate(aq(), viewGroup, false);
        if (this.s == null || !this.s.getBoolean("ptr_enabled", false)) {
            z = false;
        } else {
            z = true;
        }
        this.f21121a = (FbSwipeRefreshLayout) FindViewUtil.b(frameLayout, 2131561342);
        this.f21121a.e = new C22311(this);
        this.f21121a.setEnabled(z);
        return frameLayout;
    }

    public void m24736a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
    }

    protected final void ar() {
        this.f21121a.setEnabled(false);
    }

    protected final void au() {
        if (this.f21121a != null) {
            this.f21121a.setRefreshing(false);
        }
    }

    public void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1786446096);
        super.mY_();
        if (this.f21121a != null) {
            this.f21121a.e = null;
            this.f21121a = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1509852138, a);
    }

    protected void m24737e() {
        this.ao.m18950e();
        this.ao.m18952g();
        this.az = this.f10509g.now();
        this.ay = true;
        this.f10511i.m22618f(getSessionId());
    }
}
