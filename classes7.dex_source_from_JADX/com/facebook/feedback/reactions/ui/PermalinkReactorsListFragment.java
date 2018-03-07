package com.facebook.feedback.reactions.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.inject.FbInjector;
import com.facebook.ufiservices.flyout.ProfileListParams;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: share_attachment_url */
public class PermalinkReactorsListFragment extends TabbedReactorsListFragment {
    private static final CallerContext am = CallerContext.a(PermalinkReactorsListFragment.class, "permalink_reactors_list");
    @Inject
    public DefaultPermalinkReactorTitleHandler f3877a;
    private ProfileListParams an;

    public static void m4522a(Object obj, Context context) {
        ((PermalinkReactorsListFragment) obj).f3877a = new DefaultPermalinkReactorTitleHandler((FbTitleBarSupplier) Fb4aTitleBarSupplier.a(FbInjector.get(context)));
    }

    public final int mo180e() {
        return 2130904457;
    }

    public final void mo179c(@Nullable Bundle bundle) {
        super.mo179c(bundle);
        Class cls = PermalinkReactorsListFragment.class;
        m4522a((Object) this, getContext());
        this.an = (ProfileListParams) this.s.getParcelable("profileListParams");
    }

    public final void m4523a(View view, Bundle bundle) {
        super.a(view, bundle);
        DefaultPermalinkReactorTitleHandler defaultPermalinkReactorTitleHandler = this.f3877a;
        String str = this.an.h;
        if (defaultPermalinkReactorTitleHandler.f3863a.get() != null) {
            ((FbTitleBar) defaultPermalinkReactorTitleHandler.f3863a.get()).setTitle(str);
        }
    }

    protected final int aq() {
        return 2130904456;
    }

    public final String am_() {
        return "permalink_reactors_list";
    }

    protected final CallerContext ar() {
        return am;
    }
}
