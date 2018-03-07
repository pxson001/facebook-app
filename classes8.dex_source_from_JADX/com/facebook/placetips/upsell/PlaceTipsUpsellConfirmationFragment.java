package com.facebook.placetips.upsell;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: cancel_slideshow */
public class PlaceTipsUpsellConfirmationFragment extends FbFragment {
    @Inject
    public PlaceTipsUpsellAnalyticsLogger f18506a;

    /* compiled from: cancel_slideshow */
    class C20391 implements OnClickListener {
        final /* synthetic */ PlaceTipsUpsellConfirmationFragment f18505a;

        C20391(PlaceTipsUpsellConfirmationFragment placeTipsUpsellConfirmationFragment) {
            this.f18505a = placeTipsUpsellConfirmationFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1099640678);
            this.f18505a.f18506a.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_CONFIRMATION_X_OUT_TAPPED);
            ((PlaceTipsUpsellController) Preconditions.checkNotNull(this.f18505a.a(PlaceTipsUpsellController.class))).ar();
            Logger.a(2, EntryType.UI_INPUT_END, 564155468, a);
        }
    }

    public static void m22419a(Object obj, Context context) {
        ((PlaceTipsUpsellConfirmationFragment) obj).f18506a = PlaceTipsUpsellAnalyticsLogger.a(FbInjector.get(context));
    }

    public final void m22422c(Bundle bundle) {
        Class cls = PlaceTipsUpsellConfirmationFragment.class;
        m22419a((Object) this, getContext());
        super.c(bundle);
        this.f18506a.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_CONFIRMATION_PAGE_IMPRESSION);
    }

    public final View m22420a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -91357700);
        View inflate = layoutInflater.inflate(2130906286, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1131240498, a);
        return inflate;
    }

    public final void m22421a(View view, @Nullable Bundle bundle) {
        FbTextView fbTextView = (FbTextView) e(2131566051);
        FbTextView fbTextView2 = (FbTextView) e(2131566067);
        ImageView imageView = (ImageView) e(2131566066);
        ((FbTextView) e(2131566050)).setText("All Set to See More Around You");
        fbTextView.setText("You'll now see Place Tips on your lock screen as you explore.");
        fbTextView2.setText("See what's happening by neighborhood");
        imageView.setOnClickListener(new C20391(this));
        super.a(view, bundle);
    }
}
