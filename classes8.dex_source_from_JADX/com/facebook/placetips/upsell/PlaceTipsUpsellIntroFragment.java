package com.facebook.placetips.upsell;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.uri.FbUriIntentHandler;
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

/* compiled from: can_invite */
public class PlaceTipsUpsellIntroFragment extends FbFragment {
    @Inject
    public FbResources f18516a;
    @Inject
    public FbUriIntentHandler f18517b;
    @Inject
    public PlaceTipsUpsellAnalyticsLogger f18518c;

    /* compiled from: can_invite */
    class C20452 implements OnClickListener {
        final /* synthetic */ PlaceTipsUpsellIntroFragment f18514a;

        C20452(PlaceTipsUpsellIntroFragment placeTipsUpsellIntroFragment) {
            this.f18514a = placeTipsUpsellIntroFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -290793328);
            this.f18514a.f18518c.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_INTRO_GET_STARTED_TAPPED);
            this.f18514a.m22441b().aq();
            Logger.a(2, EntryType.UI_INPUT_END, 843430826, a);
        }
    }

    /* compiled from: can_invite */
    class C20463 implements OnClickListener {
        final /* synthetic */ PlaceTipsUpsellIntroFragment f18515a;

        C20463(PlaceTipsUpsellIntroFragment placeTipsUpsellIntroFragment) {
            this.f18515a = placeTipsUpsellIntroFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1479382334);
            this.f18515a.f18518c.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_INTRO_NOT_NOW_TAPPED);
            this.f18515a.m22441b().as();
            Logger.a(2, EntryType.UI_INPUT_END, -232472738, a);
        }
    }

    public static void m22438a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PlaceTipsUpsellIntroFragment placeTipsUpsellIntroFragment = (PlaceTipsUpsellIntroFragment) obj;
        FbResources fbResources = (FbResources) DownloadedFbResources.a(fbInjector);
        FbUriIntentHandler a = FbUriIntentHandler.a(fbInjector);
        PlaceTipsUpsellAnalyticsLogger a2 = PlaceTipsUpsellAnalyticsLogger.a(fbInjector);
        placeTipsUpsellIntroFragment.f18516a = fbResources;
        placeTipsUpsellIntroFragment.f18517b = a;
        placeTipsUpsellIntroFragment.f18518c = a2;
    }

    public final void m22442c(Bundle bundle) {
        Class cls = PlaceTipsUpsellIntroFragment.class;
        m22438a((Object) this, getContext());
        super.c(bundle);
        this.f18518c.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_INTRO_PAGE_IMPRESSION);
    }

    public final View m22439a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 159926573);
        super.a(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(2130906290, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -801173450, a);
        return inflate;
    }

    public final void m22440a(View view, @Nullable Bundle bundle) {
        ImageView imageView = (ImageView) e(2131566048);
        FbTextView fbTextView = (FbTextView) e(2131566050);
        FbTextView fbTextView2 = (FbTextView) e(2131566051);
        FbButton fbButton = (FbButton) e(2131566052);
        FbButton fbButton2 = (FbButton) e(2131566069);
        FbButton fbButton3 = (FbButton) e(2131566066);
        final UpsellPageConfig av = m22441b().av();
        fbTextView.setText(av.f18546b);
        fbTextView2.setText(av.f18547c);
        fbButton2.setText(av.f18549e);
        fbButton3.setText(av.f18548d);
        fbButton.setText(av.f18550f);
        Drawable drawable = this.f18516a.getDrawable(2130839627);
        imageView.setScaleType(ScaleType.CENTER_CROP);
        imageView.setImageDrawable(drawable);
        fbButton.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PlaceTipsUpsellIntroFragment f18513b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 893724933);
                if (av.f18551g == null) {
                    Logger.a(2, EntryType.UI_INPUT_END, 1476659486, a);
                    return;
                }
                this.f18513b.f18518c.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_INTRO_LEARN_MORE_TAPPED);
                this.f18513b.f18517b.a(this.f18513b.getContext(), av.f18551g);
                LogUtils.a(220084744, a);
            }
        });
        fbButton2.setOnClickListener(new C20452(this));
        fbButton3.setOnClickListener(new C20463(this));
        super.a(view, bundle);
    }

    protected final PlaceTipsUpsellController m22441b() {
        return (PlaceTipsUpsellController) Preconditions.checkNotNull(a(PlaceTipsUpsellController.class));
    }
}
