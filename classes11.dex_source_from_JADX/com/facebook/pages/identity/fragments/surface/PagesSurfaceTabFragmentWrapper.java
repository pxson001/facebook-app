package com.facebook.pages.identity.fragments.surface;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.surfaceinterfaces.PagesSurfaceHeaderDataListener;
import com.facebook.pages.common.surfaceinterfaces.PagesSurfaceTabFragment;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment.C05581;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderViewWithTouchDelegate;
import com.google.common.base.Preconditions;

/* compiled from: page_timeline_invalid_meuser */
public class PagesSurfaceTabFragmentWrapper extends FbFragment implements CanHandleBackPressed, PagesSurfaceHeaderDataListener, PagesSurfaceTabFragment {
    public boolean f4127a = false;
    private boolean f4128b = false;
    public PagesSurfaceTabFragment f4129c;
    private boolean f4130d = true;

    public final View m5061a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1379891961);
        View inflate = layoutInflater.inflate(2130906084, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1725792119, a);
        return inflate;
    }

    public final void m5063a(PagesSurfaceTabFragment pagesSurfaceTabFragment) {
        Preconditions.checkNotNull(pagesSurfaceTabFragment);
        this.f4129c = pagesSurfaceTabFragment;
        ((Fragment) this.f4129c).g(this.f4130d);
        this.f4127a = true;
    }

    public final void aq() {
        if (!this.f4128b) {
            Preconditions.checkState(this.f4127a);
            s().a().b(2131565654, (FbFragment) this.f4129c).c();
            s().b();
            this.f4128b = true;
        }
    }

    public final void m5070g(boolean z) {
        if (this.f4129c == null || !((Fragment) this.f4129c).mx_()) {
            this.f4130d = z;
        } else {
            ((Fragment) this.f4129c).g(z);
        }
    }

    public final boolean m5060D() {
        if (this.f4129c == null || !((Fragment) this.f4129c).mx_()) {
            return this.f4130d;
        }
        return ((Fragment) this.f4129c).D();
    }

    public final void m5062a(Menu menu, MenuInflater menuInflater) {
        if (this.f4128b) {
            ((Fragment) this.f4129c).a(menu, menuInflater);
        } else {
            super.a(menu, menuInflater);
        }
    }

    public final void m5068e(boolean z) {
        super.e(z);
        if (this.f4129c != null) {
            ((Fragment) this.f4129c).e(z);
        }
    }

    public final void m5069f(boolean z) {
        super.f(z);
        if (this.f4129c != null) {
            ((Fragment) this.f4129c).f(z);
        }
    }

    public final void m5066a(PagesSurfaceFragment pagesSurfaceFragment) {
        this.f4129c.a(pagesSurfaceFragment);
    }

    public final void m5071j() {
        this.f4129c.j();
    }

    public final void m5067a(ReactionHeaderViewWithTouchDelegate reactionHeaderViewWithTouchDelegate) {
        this.f4129c.a(reactionHeaderViewWithTouchDelegate);
    }

    public final void D_(int i) {
        this.f4129c.D_(i);
    }

    public final void E_(int i) {
        this.f4129c.E_(i);
    }

    public final void mo52a(PageHeaderData pageHeaderData) {
        if (this.f4129c instanceof PagesSurfaceHeaderDataListener) {
            ((PagesSurfaceHeaderDataListener) this.f4129c).mo52a(pageHeaderData);
        }
    }

    public final void m5065a(C05581 c05581) {
        this.f4129c.a(c05581);
    }

    public final boolean O_() {
        if (this.f4129c instanceof CanHandleBackPressed) {
            return ((CanHandleBackPressed) this.f4129c).O_();
        }
        return false;
    }
}
