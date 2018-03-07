package com.facebook.vault.momentsupsell.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.facebook.base.fragment.FbFragment;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.vault.momentsupsell.data.MomentsAppInfoStore;
import com.facebook.vault.momentsupsell.data.MomentsAppInfoStoreListener;
import com.facebook.vault.momentsupsell.model.MomentsAppInfo;
import javax.inject.Inject;

/* compiled from: thread_list */
public class MomentsAppPromotionFragment extends FbFragment {
    @Inject
    public MomentsAppInfoStore f1811a;
    @Nullable
    private MomentsAppInfo f1812b;
    public MomentsAppInfoStoreListener f1813c;
    private MomentsAppPromotionView f1814d;
    private ProgressBar f1815e;

    /* compiled from: thread_list */
    public class C01751 implements MomentsAppInfoStoreListener {
        final /* synthetic */ MomentsAppPromotionFragment f1810a;

        public C01751(MomentsAppPromotionFragment momentsAppPromotionFragment) {
            this.f1810a = momentsAppPromotionFragment;
        }

        public final void m1905a() {
            MomentsAppPromotionFragment.m1907b(this.f1810a, this.f1810a.f1811a.m1749a());
            this.f1810a.f1811a.m1751b(this.f1810a.f1813c);
        }
    }

    public static void m1906a(Object obj, Context context) {
        ((MomentsAppPromotionFragment) obj).f1811a = MomentsAppInfoStore.m1747a(FbInjector.get(context));
    }

    public final View m1908a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 190008382);
        View inflate = layoutInflater.inflate(2130905294, viewGroup, false);
        this.f1814d = (MomentsAppPromotionView) inflate.findViewById(2131563904);
        this.f1815e = (ProgressBar) inflate.findViewById(2131559418);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2091417142, a);
        return inflate;
    }

    public final void m1910c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = MomentsAppPromotionFragment.class;
        m1906a((Object) this, getContext());
    }

    public final void m1909a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        if (this.s != null) {
            m1907b(this, (MomentsAppInfo) this.s.getParcelable("arg_moments_app_info"));
        }
        if (this.f1812b == null) {
            this.f1813c = new C01751(this);
            this.f1811a.m1750a(this.f1813c);
            MomentsAppInfo a = this.f1811a.m1749a();
            if (a != null) {
                m1907b(this, a);
                this.f1811a.m1751b(this.f1813c);
            }
        }
    }

    public static void m1907b(MomentsAppPromotionFragment momentsAppPromotionFragment, MomentsAppInfo momentsAppInfo) {
        momentsAppPromotionFragment.f1812b = momentsAppInfo;
        if (momentsAppPromotionFragment.f1812b == null || momentsAppPromotionFragment.f1812b.f1774c == null) {
            momentsAppPromotionFragment.f1815e.setVisibility(0);
            momentsAppPromotionFragment.f1814d.setVisibility(8);
            return;
        }
        momentsAppPromotionFragment.f1815e.setVisibility(8);
        momentsAppPromotionFragment.f1814d.setVisibility(0);
        momentsAppPromotionFragment.f1814d.m1915a(momentsAppPromotionFragment.f1812b);
    }
}
