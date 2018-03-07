package com.facebook.messaging.quickpromotion;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.quickpromotion.asset.QuickPromotionImageFetcher;
import com.facebook.quickpromotion.asset.QuickPromotionImageFetcher.ImageType;
import com.facebook.quickpromotion.logger.QuickPromotionLogger.LayoutInfo;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ImageParameters;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.TemplateType;
import com.facebook.quickpromotion.ui.QuickPromotionFragment;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.text.TextViewUtils;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: registration_account_creation_success */
public class NeueStyleQuickPromotionInterstitialFragment extends QuickPromotionFragment {
    private static final CallerContext f3738d = CallerContext.a(NeueStyleQuickPromotionInterstitialFragment.class, "messenger");
    @Inject
    public QuickPromotionImageFetcher f3739a;
    private ControllerListener al;
    @Inject
    public AnalyticsTagger f3740b;
    private Button f3741e;
    private Button f3742f;
    private TextView f3743g;
    private TextView f3744h;
    private FbDraweeView f3745i;

    /* compiled from: registration_account_creation_success */
    class C05761 extends BaseControllerListener {
        final /* synthetic */ NeueStyleQuickPromotionInterstitialFragment f3735a;

        C05761(NeueStyleQuickPromotionInterstitialFragment neueStyleQuickPromotionInterstitialFragment) {
            this.f3735a = neueStyleQuickPromotionInterstitialFragment;
        }

        public final void m3547a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    }

    /* compiled from: registration_account_creation_success */
    class C05772 implements OnClickListener {
        final /* synthetic */ NeueStyleQuickPromotionInterstitialFragment f3736a;

        C05772(NeueStyleQuickPromotionInterstitialFragment neueStyleQuickPromotionInterstitialFragment) {
            this.f3736a = neueStyleQuickPromotionInterstitialFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2050390619);
            this.f3736a.as();
            Logger.a(2, EntryType.UI_INPUT_END, -382525125, a);
        }
    }

    /* compiled from: registration_account_creation_success */
    class C05783 implements OnClickListener {
        final /* synthetic */ NeueStyleQuickPromotionInterstitialFragment f3737a;

        C05783(NeueStyleQuickPromotionInterstitialFragment neueStyleQuickPromotionInterstitialFragment) {
            this.f3737a = neueStyleQuickPromotionInterstitialFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1098618507);
            this.f3737a.au();
            Logger.a(2, EntryType.UI_INPUT_END, 629535598, a);
        }
    }

    public static void m3548a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        NeueStyleQuickPromotionInterstitialFragment neueStyleQuickPromotionInterstitialFragment = (NeueStyleQuickPromotionInterstitialFragment) obj;
        QuickPromotionImageFetcher a = QuickPromotionImageFetcher.a(fbInjector);
        AnalyticsTagger a2 = AnalyticsTagger.a(fbInjector);
        neueStyleQuickPromotionInterstitialFragment.f3739a = a;
        neueStyleQuickPromotionInterstitialFragment.f3740b = a2;
    }

    public final void m3551c(Bundle bundle) {
        super.c(bundle);
        Class cls = NeueStyleQuickPromotionInterstitialFragment.class;
        m3548a(this, getContext());
    }

    public final View m3549a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2004142120);
        View inflate = layoutInflater.inflate(2130906531, viewGroup, false);
        this.f3741e = (Button) FindViewUtil.b(inflate, 2131562530);
        this.f3742f = (Button) FindViewUtil.b(inflate, 2131559664);
        this.f3743g = (TextView) FindViewUtil.b(inflate, 2131558927);
        this.f3744h = (TextView) FindViewUtil.b(inflate, 2131561061);
        this.f3745i = (FbDraweeView) FindViewUtil.b(inflate, 2131559119);
        this.al = new C05761(this);
        this.f3740b.a(inflate, "quick_promotion_interstitial", this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1231974593, a);
        return inflate;
    }

    public final void m3552d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 78797428);
        super.d(bundle);
        QuickPromotionDefinition quickPromotionDefinition = this.a;
        this.f3743g.setText(quickPromotionDefinition.title);
        if (TextUtils.isEmpty(quickPromotionDefinition.content)) {
            this.f3744h.setVisibility(8);
        } else {
            this.f3744h.setText(quickPromotionDefinition.content);
        }
        if (this.f3739a.a(this.f3745i, quickPromotionDefinition.c(), f3738d, this.al)) {
            QuickPromotionImageFetcher.a(quickPromotionDefinition.c(), this.f3745i);
            if (TemplateType.MESSENGER_CARD.equals(quickPromotionDefinition.c().template)) {
                ((GenericDraweeHierarchy) this.f3745i.getHierarchy()).a(ScaleType.g);
            } else {
                ((GenericDraweeHierarchy) this.f3745i.getHierarchy()).a(ScaleType.f);
            }
            ImageParameters b = QuickPromotionImageFetcher.b(quickPromotionDefinition.c(), ImageType.ANY);
            int a2 = this.f3739a.a(b, quickPromotionDefinition.c());
            int b2 = this.f3739a.b(b, quickPromotionDefinition.c());
            LayoutParams layoutParams = this.f3745i.getLayoutParams();
            layoutParams.width = a2;
            layoutParams.height = b2;
            this.f3745i.setLayoutParams(layoutParams);
            this.f3743g.setMaxLines(3);
            this.f3744h.setMaxLines(6);
            this.f3745i.setVisibility(0);
        } else {
            this.f3743g.setMaxLines(6);
            this.f3743g.setMaxLines(12);
            this.f3745i.setVisibility(8);
        }
        this.f3741e.setText(quickPromotionDefinition.primaryAction.title);
        this.f3741e.setOnClickListener(new C05772(this));
        if (quickPromotionDefinition.secondaryAction == null || TextUtils.isEmpty(quickPromotionDefinition.secondaryAction.title)) {
            this.f3742f.setVisibility(8);
        } else {
            this.f3742f.setText(quickPromotionDefinition.secondaryAction.title);
            this.f3742f.setOnClickListener(new C05783(this));
        }
        LogUtils.f(2127209245, a);
    }

    protected final LayoutInfo m3550b() {
        LayoutInfo layoutInfo = new LayoutInfo();
        layoutInfo.a = TextViewUtils.b(this.f3743g);
        layoutInfo = layoutInfo;
        layoutInfo.b = TextViewUtils.b(this.f3744h);
        layoutInfo = layoutInfo;
        layoutInfo.c = TextViewUtils.b(this.f3741e);
        layoutInfo = layoutInfo;
        layoutInfo.d = TextViewUtils.b(this.f3742f);
        return layoutInfo;
    }
}
