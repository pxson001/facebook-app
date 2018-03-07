package com.facebook.quickpromotion.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Creative;
import com.facebook.widget.viewpageindicator.CirclePageIndicator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;

/* compiled from: question_skip_tap */
public class QuickPromotionMultiPageInterstitialMainFragment extends QuickPromotionFragment {
    private QuickPromotionDefinition f4833a;
    public ImmutableList<Creative> f4834b = RegularImmutableList.a;
    public ViewPager f4835d;
    private PagerAdapter f4836e;
    public Bundle f4837f;

    /* compiled from: question_skip_tap */
    class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        final /* synthetic */ QuickPromotionMultiPageInterstitialMainFragment f4832a;

        public ScreenSlidePagerAdapter(QuickPromotionMultiPageInterstitialMainFragment quickPromotionMultiPageInterstitialMainFragment, FragmentManager fragmentManager) {
            this.f4832a = quickPromotionMultiPageInterstitialMainFragment;
            super(fragmentManager);
        }

        public final int m4705a(Object obj) {
            int indexOf = this.f4832a.f4834b.indexOf(((QuickPromotionInterstitialFragment) obj).ax);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }

        public final Fragment m4706a(int i) {
            Creative creative = (Creative) this.f4832a.f4834b.get(i);
            int size = this.f4832a.f4834b.size();
            Bundle bundle = (Bundle) this.f4832a.f4837f.clone();
            QuickPromotionInterstitialFragment quickPromotionInterstitialFragment = new QuickPromotionInterstitialFragment();
            bundle.putParcelable("qp_creative", creative);
            bundle.putInt("page_position", i);
            bundle.putInt("num_pages", size);
            bundle.putBoolean("is_multi", true);
            quickPromotionInterstitialFragment.g(bundle);
            return quickPromotionInterstitialFragment;
        }

        public final int m4707b() {
            return this.f4832a.f4834b.size();
        }
    }

    public final View m4708a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1130515987);
        View inflate = layoutInflater.inflate(2130906553, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1127068953, a);
        return inflate;
    }

    public final void mo227d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 505722076);
        super.mo227d(bundle);
        this.f4837f = this.s;
        this.f4833a = (QuickPromotionDefinition) this.f4837f.getParcelable("qp_definition");
        this.f4834b = this.f4833a.b();
        this.f4835d = (ViewPager) e(2131566507);
        this.f4836e = new ScreenSlidePagerAdapter(this, s());
        this.f4835d.setAdapter(this.f4836e);
        CirclePageIndicator circlePageIndicator = (CirclePageIndicator) e(2131566508);
        circlePageIndicator.setFillColor(jW_().getColor(2131361916));
        circlePageIndicator.setViewPager(this.f4835d);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -886455427, a);
    }
}
