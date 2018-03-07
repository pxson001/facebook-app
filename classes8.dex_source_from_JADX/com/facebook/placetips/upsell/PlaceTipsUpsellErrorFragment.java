package com.facebook.placetips.upsell;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: can_see_new_cta */
public class PlaceTipsUpsellErrorFragment extends FbFragment {
    @Inject
    public PlaceTipsUpsellAnalyticsLogger f18511a;

    /* compiled from: can_see_new_cta */
    class C20421 implements OnClickListener {
        final /* synthetic */ PlaceTipsUpsellErrorFragment f18509a;

        C20421(PlaceTipsUpsellErrorFragment placeTipsUpsellErrorFragment) {
            this.f18509a = placeTipsUpsellErrorFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -377408730);
            this.f18509a.f18511a.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_ERROR_TRY_AGAIN_TAPPED);
            this.f18509a.m22436b().au();
            Logger.a(2, EntryType.UI_INPUT_END, 1911709717, a);
        }
    }

    /* compiled from: can_see_new_cta */
    class C20432 implements OnClickListener {
        final /* synthetic */ PlaceTipsUpsellErrorFragment f18510a;

        C20432(PlaceTipsUpsellErrorFragment placeTipsUpsellErrorFragment) {
            this.f18510a = placeTipsUpsellErrorFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 389667860);
            this.f18510a.f18511a.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_ERROR_NOT_NOW_TAPPED);
            this.f18510a.m22436b().as();
            Logger.a(2, EntryType.UI_INPUT_END, -104947444, a);
        }
    }

    public static void m22433a(Object obj, Context context) {
        ((PlaceTipsUpsellErrorFragment) obj).f18511a = PlaceTipsUpsellAnalyticsLogger.a(FbInjector.get(context));
    }

    public final void m22437c(Bundle bundle) {
        Class cls = PlaceTipsUpsellErrorFragment.class;
        m22433a((Object) this, getContext());
        super.c(bundle);
        this.f18511a.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_ERROR_PAGE_IMPRESSION);
    }

    public final View m22434a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1215606152);
        super.a(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(2130906288, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -42625693, a);
        return inflate;
    }

    public final void m22435a(View view, @Nullable Bundle bundle) {
        FbButton fbButton = (FbButton) e(2131566069);
        FbButton fbButton2 = (FbButton) e(2131566066);
        fbButton.setText(2131239603);
        fbButton2.setText(2131239602);
        fbButton.setOnClickListener(new C20421(this));
        fbButton2.setOnClickListener(new C20432(this));
        super.a(view, bundle);
    }

    protected final PlaceTipsUpsellController m22436b() {
        return (PlaceTipsUpsellController) Preconditions.checkNotNull(a(PlaceTipsUpsellController.class));
    }
}
