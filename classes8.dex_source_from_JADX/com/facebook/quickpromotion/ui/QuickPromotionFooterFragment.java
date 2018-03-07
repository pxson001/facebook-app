package com.facebook.quickpromotion.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.quickpromotion.asset.QuickPromotionImageFetcher;
import com.facebook.quickpromotion.logger.QuickPromotionLogger$LayoutInfo;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Creative;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.text.TextViewUtils;
import javax.inject.Inject;

/* compiled from: reactTag */
public class QuickPromotionFooterFragment extends QuickPromotionFragment {
    private static final CallerContext f4803d = CallerContext.a(QuickPromotionFooterFragment.class, "quick_promotion_interstitial");
    @Inject
    public QuickPromotionImageFetcher f4804a;
    private ControllerListener al;
    private Creative am;
    @Inject
    public GlyphColorizer f4805b;
    private TextView f4806e;
    private ImageView f4807f;
    private TextView f4808g;
    private TextView f4809h;
    private FbDraweeView f4810i;

    /* compiled from: reactTag */
    class C06371 implements OnTouchListener {
        final /* synthetic */ QuickPromotionFooterFragment f4791a;

        C06371(QuickPromotionFooterFragment quickPromotionFooterFragment) {
            this.f4791a = quickPromotionFooterFragment;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* compiled from: reactTag */
    class C06382 implements OnClickListener {
        final /* synthetic */ QuickPromotionFooterFragment f4792a;

        C06382(QuickPromotionFooterFragment quickPromotionFooterFragment) {
            this.f4792a = quickPromotionFooterFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1717306677);
            this.f4792a.as();
            Logger.a(2, EntryType.UI_INPUT_END, 39049645, a);
        }
    }

    /* compiled from: reactTag */
    class C06393 implements OnClickListener {
        final /* synthetic */ QuickPromotionFooterFragment f4793a;

        C06393(QuickPromotionFooterFragment quickPromotionFooterFragment) {
            this.f4793a = quickPromotionFooterFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1613977118);
            this.f4793a.aw();
            Logger.a(2, EntryType.UI_INPUT_END, 1008452696, a);
        }
    }

    /* compiled from: reactTag */
    public enum ActionButtonTheme {
        PRIMARY(2130842833, 2131361917),
        SPECIAL(2130842834, 2131361920);
        
        public final int backgroundResId;
        public final int textColorResId;

        private ActionButtonTheme(int i, int i2) {
            this.backgroundResId = i;
            this.textColorResId = i2;
        }
    }

    public static void m4674a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        QuickPromotionFooterFragment quickPromotionFooterFragment = (QuickPromotionFooterFragment) obj;
        QuickPromotionImageFetcher a = QuickPromotionImageFetcher.a(fbInjector);
        GlyphColorizer a2 = GlyphColorizer.a(fbInjector);
        quickPromotionFooterFragment.f4804a = a;
        quickPromotionFooterFragment.f4805b = a2;
    }

    public final void mo226c(Bundle bundle) {
        super.mo226c(bundle);
        Class cls = QuickPromotionFooterFragment.class;
        m4674a(this, getContext());
        this.am = this.f4795b;
    }

    public final View m4675a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ActionButtonTheme actionButtonTheme;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2010441320);
        View inflate = layoutInflater.inflate(2130906546, viewGroup, false);
        this.f4808g = (TextView) FindViewUtil.b(inflate, 2131558927);
        this.f4809h = (TextView) FindViewUtil.b(inflate, 2131561061);
        this.f4806e = (TextView) FindViewUtil.b(inflate, 2131558610);
        this.f4807f = (ImageView) FindViewUtil.b(inflate, 2131559781);
        this.f4810i = (FbDraweeView) FindViewUtil.b(inflate, 2131559119);
        this.al = this.f4804a.a();
        Bundle bundle2 = this.s;
        if (bundle2 == null) {
            actionButtonTheme = ActionButtonTheme.PRIMARY;
        } else {
            actionButtonTheme = (ActionButtonTheme) bundle2.getSerializable("ACTION_BUTTON_THEME_ARG");
            if (actionButtonTheme == null) {
                actionButtonTheme = ActionButtonTheme.PRIMARY;
            }
        }
        ActionButtonTheme actionButtonTheme2 = actionButtonTheme;
        this.f4806e.setBackgroundResource(actionButtonTheme2.backgroundResId);
        this.f4806e.setTextColor(jW_().getColor(actionButtonTheme2.textColorResId));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 339610982, a);
        return inflate;
    }

    public final void mo227d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -869525552);
        super.mo227d(bundle);
        View view = this.T;
        if (view != null) {
            view.setOnTouchListener(new C06371(this));
        }
        this.f4808g.setText(this.am.title);
        if (TextUtils.isEmpty(this.am.content)) {
            this.f4809h.setVisibility(8);
            this.f4808g.setMaxLines(2);
        } else {
            this.f4809h.setText(this.am.content);
        }
        this.f4806e.setText(this.am.primaryAction.title);
        this.f4806e.setOnClickListener(new C06382(this));
        if (this.am.dismissAction != null) {
            this.f4807f.setImageDrawable(this.f4805b.a(2130842830, -7235677));
            this.f4807f.setVisibility(0);
            this.f4807f.setOnClickListener(new C06393(this));
        }
        if (this.f4804a.a(this.f4810i, this.am, f4803d, this.al)) {
            QuickPromotionImageFetcher.a(this.am, this.f4810i);
            this.f4810i.setVisibility(0);
        } else {
            this.f4810i.setVisibility(8);
        }
        LogUtils.f(-1689355256, a);
    }

    protected final QuickPromotionLogger$LayoutInfo mo225b() {
        QuickPromotionLogger$LayoutInfo quickPromotionLogger$LayoutInfo = new QuickPromotionLogger$LayoutInfo();
        quickPromotionLogger$LayoutInfo.f4746a = TextViewUtils.b(this.f4808g);
        quickPromotionLogger$LayoutInfo = quickPromotionLogger$LayoutInfo;
        quickPromotionLogger$LayoutInfo.f4747b = TextViewUtils.b(this.f4809h);
        quickPromotionLogger$LayoutInfo = quickPromotionLogger$LayoutInfo;
        quickPromotionLogger$LayoutInfo.f4748c = TextViewUtils.b(this.f4806e);
        return quickPromotionLogger$LayoutInfo;
    }
}
