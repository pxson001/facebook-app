package com.facebook.placetips.upsell;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.FbResources;
import com.facebook.resources.impl.DownloadedFbResources;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: candidate_results_id */
public class PlaceTipsSaveUpsellIntroFragment extends FbFragment {
    @Inject
    public FbResources f18491a;
    @Inject
    public FbUriIntentHandler f18492b;
    @Inject
    public PlaceTipsUpsellAnalyticsLogger f18493c;

    /* compiled from: candidate_results_id */
    class C20372 implements OnClickListener {
        final /* synthetic */ PlaceTipsSaveUpsellIntroFragment f18489a;

        C20372(PlaceTipsSaveUpsellIntroFragment placeTipsSaveUpsellIntroFragment) {
            this.f18489a = placeTipsSaveUpsellIntroFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2129264865);
            this.f18489a.f18493c.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_PLACE_SAVE_INTRO_GET_STARTED_TAPPED);
            this.f18489a.m22416b().aq();
            Logger.a(2, EntryType.UI_INPUT_END, 1848229064, a);
        }
    }

    /* compiled from: candidate_results_id */
    class C20383 implements OnClickListener {
        final /* synthetic */ PlaceTipsSaveUpsellIntroFragment f18490a;

        C20383(PlaceTipsSaveUpsellIntroFragment placeTipsSaveUpsellIntroFragment) {
            this.f18490a = placeTipsSaveUpsellIntroFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 411789018);
            this.f18490a.f18493c.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_PLACE_SAVE_INTRO_NOT_NOW_TAPPED);
            this.f18490a.m22416b().as();
            Logger.a(2, EntryType.UI_INPUT_END, -1086780067, a);
        }
    }

    public static void m22413a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PlaceTipsSaveUpsellIntroFragment placeTipsSaveUpsellIntroFragment = (PlaceTipsSaveUpsellIntroFragment) obj;
        FbResources fbResources = (FbResources) DownloadedFbResources.a(fbInjector);
        FbUriIntentHandler a = FbUriIntentHandler.a(fbInjector);
        PlaceTipsUpsellAnalyticsLogger a2 = PlaceTipsUpsellAnalyticsLogger.a(fbInjector);
        placeTipsSaveUpsellIntroFragment.f18491a = fbResources;
        placeTipsSaveUpsellIntroFragment.f18492b = a;
        placeTipsSaveUpsellIntroFragment.f18493c = a2;
    }

    public final void m22417c(Bundle bundle) {
        Class cls = PlaceTipsSaveUpsellIntroFragment.class;
        m22413a((Object) this, getContext());
        super.c(bundle);
        if (bundle == null) {
            this.f18493c.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_PLACE_SAVE_INTRO);
        }
    }

    public final View m22414a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 210959914);
        super.a(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(2130906283, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1701127614, a);
        return inflate;
    }

    public final void m22415a(View view, @Nullable Bundle bundle) {
        ImageView imageView = (ImageView) e(2131566048);
        FbTextView fbTextView = (FbTextView) e(2131566050);
        FbTextView fbTextView2 = (FbTextView) e(2131566051);
        FbButton fbButton = (FbButton) e(2131566052);
        FbButton fbButton2 = (FbButton) e(2131566069);
        FbButton fbButton3 = (FbButton) e(2131566066);
        String string = this.s.getString("place_name");
        final UpsellPageConfig av = m22416b().av();
        fbTextView.setText(StringLocaleUtil.a(av.f18546b, new Object[]{string}));
        fbTextView2.setText(av.f18547c);
        fbButton.setText(av.f18550f);
        fbButton2.setText(av.f18549e);
        fbButton3.setText(av.f18548d);
        imageView.setImageDrawable(this.f18491a.getDrawable(2130839628));
        fbButton.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PlaceTipsSaveUpsellIntroFragment f18488b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -2107707275);
                if (av.f18551g == null) {
                    Logger.a(2, EntryType.UI_INPUT_END, 1171130473, a);
                    return;
                }
                this.f18488b.f18493c.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_PLACE_SAVE_INTRO_LEARN_MORE_TAPPED);
                this.f18488b.f18492b.a(this.f18488b.getContext(), av.f18551g);
                LogUtils.a(-1583799148, a);
            }
        });
        fbButton2.setOnClickListener(new C20372(this));
        fbButton3.setOnClickListener(new C20383(this));
        super.a(view, bundle);
    }

    protected final PlaceTipsUpsellController m22416b() {
        return (PlaceTipsUpsellController) Preconditions.checkNotNull(a(PlaceTipsUpsellController.class));
    }
}
