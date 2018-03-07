package com.facebook.quickpromotion.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.quickpromotion.asset.QuickPromotionImageFetcher;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Creative;
import javax.inject.Inject;

/* compiled from: query_success */
public class QuickPromotionToastFooterFragment extends QuickPromotionFragment {
    private static final CallerContext f4843d = CallerContext.a(QuickPromotionToastFooterFragment.class, "quick_promotion_interstitial");
    @Inject
    public QuickPromotionImageFetcher f4844a;
    @Inject
    public GlyphColorizer f4845b;
    private Creative f4846e;

    /* compiled from: query_success */
    class C06481 implements OnClickListener {
        final /* synthetic */ QuickPromotionToastFooterFragment f4841a;

        C06481(QuickPromotionToastFooterFragment quickPromotionToastFooterFragment) {
            this.f4841a = quickPromotionToastFooterFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -173231639);
            this.f4841a.as();
            Logger.a(2, EntryType.UI_INPUT_END, 194522687, a);
        }
    }

    /* compiled from: query_success */
    class C06492 implements OnClickListener {
        final /* synthetic */ QuickPromotionToastFooterFragment f4842a;

        C06492(QuickPromotionToastFooterFragment quickPromotionToastFooterFragment) {
            this.f4842a = quickPromotionToastFooterFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1575835714);
            this.f4842a.aw();
            Logger.a(2, EntryType.UI_INPUT_END, -1233281802, a);
        }
    }

    public static void m4718a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        QuickPromotionToastFooterFragment quickPromotionToastFooterFragment = (QuickPromotionToastFooterFragment) obj;
        QuickPromotionImageFetcher a = QuickPromotionImageFetcher.a(fbInjector);
        GlyphColorizer a2 = GlyphColorizer.a(fbInjector);
        quickPromotionToastFooterFragment.f4844a = a;
        quickPromotionToastFooterFragment.f4845b = a2;
    }

    public final void mo226c(Bundle bundle) {
        super.mo226c(bundle);
        Class cls = QuickPromotionToastFooterFragment.class;
        m4718a((Object) this, getContext());
        this.f4846e = this.f4795b;
    }

    public final View m4719a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1399377129);
        View inflate = layoutInflater.inflate(2130906555, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2018221211, a);
        return inflate;
    }

    public final void m4720a(View view, Bundle bundle) {
        super.a(view, bundle);
        FbDraweeView fbDraweeView = (FbDraweeView) e(2131566511);
        TextView textView = (TextView) e(2131566513);
        ImageView imageView = (ImageView) e(2131566514);
        ((TextView) e(2131566512)).setText(this.f4846e.title);
        textView.setText(this.f4846e.content);
        view.setOnClickListener(new C06481(this));
        if (this.f4846e.dismissAction != null) {
            imageView.setImageDrawable(this.f4845b.a(2130842830, -1));
            imageView.setOnClickListener(new C06492(this));
            imageView.setVisibility(0);
        }
        if (this.f4844a.a(fbDraweeView, this.f4846e, f4843d, this.f4844a.a())) {
            QuickPromotionImageFetcher.a(this.f4846e, fbDraweeView);
            fbDraweeView.setVisibility(0);
        }
    }
}
