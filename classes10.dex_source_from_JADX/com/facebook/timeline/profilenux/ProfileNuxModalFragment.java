package com.facebook.timeline.profilenux;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.FindViewUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.timeline.header.ProfileNuxEntryViewBinder;
import com.facebook.timeline.refresher.launcher.ProfileRefresherConfiguration;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: feed_filter_status */
public class ProfileNuxModalFragment extends FbFragment {
    @Inject
    public Provider<ProfileNuxEntryViewBinder> f12083a;
    private FbTextView f12084b;
    private FbTextView f12085c;
    private FbButton f12086d;
    private FbButton f12087e;

    public static void m12089a(Object obj, Context context) {
        ((ProfileNuxModalFragment) obj).f12083a = IdBasedProvider.a(FbInjector.get(context), 11245);
    }

    public final void m12091c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = ProfileNuxModalFragment.class;
        m12089a(this, getContext());
    }

    public final View m12090a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1496234472);
        View inflate = layoutInflater.inflate(2130906449, viewGroup, false);
        this.f12084b = (FbTextView) FindViewUtil.b(inflate, 2131566370);
        this.f12085c = (FbTextView) FindViewUtil.b(inflate, 2131566371);
        this.f12086d = (FbButton) FindViewUtil.b(inflate, 2131566372);
        this.f12087e = (FbButton) FindViewUtil.b(inflate, 2131566373);
        ((ProfileNuxEntryViewBinder) this.f12083a.get()).m11398a((ProfileRefresherConfiguration) mt_().getParcelable("refresher_configuration"), mt_().getString("profile_id"), this.f12087e, this.f12086d, this.f12084b, this.f12085c, mt_().getString("nux_modal_title"), mt_().getString("nux_modal_text"), null, ao());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 707522966, a);
        return inflate;
    }
}
