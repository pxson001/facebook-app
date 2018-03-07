package com.facebook.feed.inlinecomposer.multirow.common.views;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.facebook.device.ScreenUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: android.media.EXTRA_VOLUME_STREAM_TYPE */
public class V2PromptFlyoutView extends CustomLinearLayout implements HasPhotoTray, HasPromptFlyout {
    @Inject
    public ScreenUtil f19308a;
    private View f19309b;
    private View f19310c;
    private boolean f19311d = false;

    public static void m22782a(Object obj, Context context) {
        ((V2PromptFlyoutView) obj).f19308a = ScreenUtil.a(FbInjector.get(context));
    }

    public V2PromptFlyoutView(Context context) {
        super(context);
        Class cls = V2PromptFlyoutView.class;
        m22782a(this, getContext());
        setContentView(2130906495);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f19309b == null || this.f19310c == null) {
            this.f19309b = findViewById(2131566428);
            this.f19310c = (View) this.f19309b.getParent();
        }
        int right = (this.f19310c.getRight() - this.f19309b.getWidth()) - (this.f19310c.getTop() + this.f19309b.getTop());
        int right2 = (getRight() - this.f19310c.getRight()) + (this.f19310c.getTop() + this.f19309b.getHeight());
        if (motionEvent.getX() >= ((float) getRight()) || motionEvent.getX() <= ((float) right) || motionEvent.getY() <= 0.0f || motionEvent.getY() >= ((float) right2)) {
            this.f19311d = false;
            return false;
        }
        this.f19309b.performClick();
        this.f19311d = true;
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1267391649);
        if (this.f19311d) {
            Logger.a(2, EntryType.UI_INPUT_END, 406052427, a);
            return true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        LogUtils.a(-1818486751, a);
        return onTouchEvent;
    }

    public View getFlyoutView() {
        return a(2131566426);
    }

    @Nullable
    public View getV2AttachmentView() {
        return getAttachmentInsertPoint().getChildAt(0);
    }

    public View getFlyoutXoutButton() {
        return a(2131566428);
    }

    public BetterTextView getPromptTitleView() {
        return (BetterTextView) a(2131565300);
    }

    public BetterTextView getPromptSubtitleView() {
        return (BetterTextView) a(2131565301);
    }

    public FrameLayout getAttachmentInsertPoint() {
        return (FrameLayout) a(2131566430);
    }

    public TextWithEntitiesView getPromptDisplayReasonView() {
        if (!m22784a()) {
            ((ViewStub) a(2131566427)).inflate();
        }
        return (TextWithEntitiesView) a(2131566431);
    }

    public final boolean m22784a() {
        return !(findViewById(2131566427) instanceof ViewStub);
    }

    public final void m22783a(boolean z) {
        View flyoutView = getFlyoutView();
        int paddingTop = flyoutView.getPaddingTop();
        int paddingLeft = flyoutView.getPaddingLeft();
        int paddingBottom = flyoutView.getPaddingBottom();
        int paddingRight = flyoutView.getPaddingRight();
        flyoutView.setBackgroundResource(z ? 2130842799 : 2130842798);
        flyoutView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public int getCollapsedHeight() {
        return 0;
    }

    public int getExpandedFlyoutHeight() {
        View flyoutView = getFlyoutView();
        int c = (this.f19308a.c() - getPaddingLeft()) - getPaddingRight();
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) getLayoutParams();
        flyoutView.measure(MeasureSpec.makeMeasureSpec(marginLayoutParams == null ? c : (c - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(0, 0));
        return flyoutView.getMeasuredHeight();
    }

    @Nullable
    public View getPhotoTray() {
        View v2AttachmentView = getV2AttachmentView();
        return v2AttachmentView instanceof HasPhotoTray ? ((HasPhotoTray) v2AttachmentView).getPhotoTray() : null;
    }
}
