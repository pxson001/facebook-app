package com.facebook.appinvites.ui;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.RecyclableView;
import javax.inject.Inject;

/* compiled from: num_signatures */
public class AppInviteContentView extends CustomViewGroup implements RecyclableView {
    private static final CallerContext f6542b = CallerContext.a(AppInviteContentView.class, "unknown");
    @Inject
    public TimeFormatUtil f6543a;
    private TextView f6544c;
    private TextView f6545d;
    private ImageBlockLayout f6546e;
    private FbDraweeView f6547f;
    private TextView f6548g;
    public FbDraweeView f6549h;
    public AppInvitePromotionDetailsView f6550i;
    public boolean f6551j;

    private static <T extends View> void m6965a(Class<T> cls, T t) {
        m6966a((Object) t, t.getContext());
    }

    private static void m6966a(Object obj, Context context) {
        ((AppInviteContentView) obj).f6543a = (TimeFormatUtil) DefaultTimeFormatUtil.a(FbInjector.get(context));
    }

    public AppInviteContentView(Context context) {
        super(context);
        m6967b();
    }

    public AppInviteContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6967b();
    }

    private void m6967b() {
        m6965a(AppInviteContentView.class, (View) this);
        setContentView(2130903280);
        this.f6544c = (TextView) getView(2131559672);
        this.f6545d = (TextView) getView(2131559673);
        this.f6546e = (ImageBlockLayout) getView(2131559670);
        this.f6547f = (FbDraweeView) getView(2131559671);
        this.f6548g = (TextView) getView(2131559674);
        this.f6549h = (FbDraweeView) getView(2131559675);
        this.f6549h.getViewTreeObserver().addOnGlobalLayoutListener(new 1(this));
        this.f6550i = (AppInvitePromotionDetailsView) getView(2131559676);
    }

    public void setSenderImageOnClickListener(OnClickListener onClickListener) {
        this.f6547f.setOnClickListener(onClickListener);
    }

    public void setMessageOnClickListener(OnClickListener onClickListener) {
        this.f6548g.setOnClickListener(onClickListener);
    }

    public void setPreviewImageOnClickListener(OnClickListener onClickListener) {
        this.f6549h.setOnClickListener(onClickListener);
    }

    public void setSenderName(String str) {
        this.f6544c.setText(str);
    }

    public void setTimestamp(long j) {
        this.f6545d.setText(this.f6543a.a(TimeFormatStyle.STREAM_RELATIVE_STYLE, 1000 * j));
    }

    public void setPreviewImageUri(Uri uri) {
        this.f6549h.a(uri, f6542b);
    }

    public void setSenderImageURI(Uri uri) {
        this.f6547f.a(uri, f6542b);
    }

    public void setMessage(String str) {
        this.f6548g.setText(str);
    }

    public void setMessageMaxLines(int i) {
        this.f6548g.setMaxLines(i);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -972194683);
        super.onAttachedToWindow();
        this.f6551j = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -261256999, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2087625823);
        super.onDetachedFromWindow();
        this.f6551j = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -643946189, a);
    }

    public void setHasBeenAttached(boolean z) {
        this.f6551j = z;
    }

    public final boolean mo569a() {
        return this.f6551j;
    }

    public AppInvitePromotionDetailsView getPromotionDetailsView() {
        return this.f6550i;
    }

    private void m6964a(TimeFormatUtil timeFormatUtil) {
        this.f6543a = timeFormatUtil;
    }
}
