package com.facebook.feed.inlinecomposer;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.facebook.device.ScreenUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPromptFlyout;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPromptIcon;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.widget.ShimmerFrameLayout;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: messenger_contact_details */
public class InlineComposerV2HeaderView extends SegmentedLinearLayout implements HasPromptFlyout, HasPromptIcon {
    @Inject
    public ScreenUtil f14115a;
    @Inject
    public PromptsExperimentHelper f14116b;
    private final Context f14117c;
    private Integer f14118d;

    /* compiled from: messenger_contact_details */
    public class C05971 implements OnClickListener {
        final /* synthetic */ OnClickListener f14339a;
        final /* synthetic */ InlineComposerV2HeaderView f14340b;

        public C05971(InlineComposerV2HeaderView inlineComposerV2HeaderView, OnClickListener onClickListener) {
            this.f14340b = inlineComposerV2HeaderView;
            this.f14339a = onClickListener;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -343099343);
            this.f14339a.onClick(view);
            Logger.a(2, EntryType.UI_INPUT_END, -939917781, a);
        }
    }

    public static void m20432a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        InlineComposerV2HeaderView inlineComposerV2HeaderView = (InlineComposerV2HeaderView) obj;
        ScreenUtil a = ScreenUtil.m8695a(injectorLike);
        PromptsExperimentHelper b = PromptsExperimentHelper.m15312b(injectorLike);
        inlineComposerV2HeaderView.f14115a = a;
        inlineComposerV2HeaderView.f14116b = b;
    }

    public InlineComposerV2HeaderView(Context context) {
        super(context, null);
        Class cls = InlineComposerV2HeaderView.class;
        m20432a(this, getContext());
        this.f14117c = context;
        setContentView(2130904312);
        setOrientation(1);
        if (!this.f14116b.m15315d() && !this.f14116b.m15314c()) {
            ((ViewStub) findViewById(2131561939)).inflate().setVisibility(0);
        }
    }

    public View getFlyoutView() {
        return m8506a(2131566426);
    }

    public FbDraweeView getIconView() {
        if (!m8509b(2131566433).isPresent()) {
            ((ViewStub) m8506a(2131561937)).inflate();
        }
        return (FbDraweeView) m8506a(2131566433);
    }

    @Nullable
    public ShimmerFrameLayout getShimmerContainer() {
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) m8506a(2131566432);
        shimmerFrameLayout.setVisibility(0);
        return shimmerFrameLayout;
    }

    public View getFlyoutXoutButton() {
        return m8506a(2131566428);
    }

    public BetterTextView getPromptTitleView() {
        return (BetterTextView) m8506a(2131565300);
    }

    public BetterTextView getPromptSubtitleView() {
        return (BetterTextView) m8506a(2131565301);
    }

    public FrameLayout getAttachmentInsertPoint() {
        return (FrameLayout) m8506a(2131566430);
    }

    @Nullable
    public View getV2AttachmentView() {
        return getAttachmentInsertPoint().getChildAt(0);
    }

    public TextWithEntitiesView getPromptDisplayReasonView() {
        if (!mo2702a()) {
            ((ViewStub) m8506a(2131566427)).inflate();
        }
        return (TextWithEntitiesView) m8506a(2131566431);
    }

    public final boolean mo2702a() {
        return !(findViewById(2131566427) instanceof ViewStub);
    }

    public final void mo2701a(boolean z) {
        View flyoutView = getFlyoutView();
        int paddingTop = flyoutView.getPaddingTop();
        int paddingLeft = flyoutView.getPaddingLeft();
        int paddingBottom = flyoutView.getPaddingBottom();
        int paddingRight = flyoutView.getPaddingRight();
        flyoutView.setBackgroundResource(z ? 2130842799 : 2130842798);
        flyoutView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public int getCollapsedHeight() {
        return this.f14118d == null ? this.f14117c.getResources().getDimensionPixelSize(2131430506) : this.f14118d.intValue();
    }

    public int getExpandedFlyoutHeight() {
        View flyoutView = getFlyoutView();
        int c = (this.f14115a.m8702c() - getPaddingLeft()) - getPaddingRight();
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) getLayoutParams();
        flyoutView.measure(MeasureSpec.makeMeasureSpec(marginLayoutParams == null ? c : (c - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(0, 0));
        return flyoutView.getMeasuredHeight();
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f14118d == null) {
            this.f14118d = Integer.valueOf(getMeasuredHeight());
        }
    }
}
