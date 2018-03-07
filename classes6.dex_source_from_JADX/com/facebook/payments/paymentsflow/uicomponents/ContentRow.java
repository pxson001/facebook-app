package com.facebook.payments.paymentsflow.uicomponents;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: iosBundleId */
public class ContentRow extends CustomRelativeLayout {
    private static final CallerContext f12293a = CallerContext.a(ContentRow.class);
    private FbDraweeView f12294b;
    private FbTextView f12295c;
    private FbTextView f12296d;
    private FbTextView f12297e;
    private ImageView f12298f;
    private ProgressBar f12299g;

    /* compiled from: iosBundleId */
    public enum AccessoryTextViewMode {
        ACTIVE,
        INACTIVE
    }

    public ContentRow(Context context) {
        this(context, null);
    }

    public ContentRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19194a();
    }

    public ContentRow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19194a();
    }

    private void m19194a() {
        setContentView(2130905948);
        this.f12294b = (FbDraweeView) a(2131565304);
        this.f12295c = (FbTextView) a(2131565307);
        this.f12296d = (FbTextView) a(2131565308);
        this.f12297e = (FbTextView) a(2131565306);
        this.f12298f = (ImageView) a(2131565305);
        this.f12299g = (ProgressBar) a(2131565309);
        setAccessoryTextViewMode(AccessoryTextViewMode.INACTIVE);
        setAccessoryImageViewVisibility(8);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), getResources().getDimensionPixelSize(2131430691));
    }

    public void setTitleText(String str) {
        this.f12295c.setText(str);
    }

    public void setSubtitleText(String str) {
        this.f12296d.setText(str);
    }

    public void setAccessoryText(String str) {
        this.f12297e.setText(str);
    }

    public void setAccessoryTextVisibility(int i) {
        this.f12297e.setVisibility(i);
    }

    public void setAccessoryTextViewMode(AccessoryTextViewMode accessoryTextViewMode) {
        int i = 2131363181;
        if (accessoryTextViewMode == AccessoryTextViewMode.INACTIVE) {
            i = 2131363180;
        }
        this.f12297e.setTextColor(getResources().getColor(i));
    }

    public void setAccessoryImageViewVisibility(int i) {
        this.f12298f.setVisibility(i);
    }

    public void setAccessoryTextViewOnClickListener(OnClickListener onClickListener) {
        this.f12297e.setOnClickListener(onClickListener);
    }

    public void setAccessoryImageOnClickListener(OnClickListener onClickListener) {
        this.f12298f.setOnClickListener(onClickListener);
    }

    public void setProgressBarVisibility(int i) {
        this.f12299g.setVisibility(i);
    }

    public void setProgressBarIndeterminate(boolean z) {
        this.f12299g.setIndeterminate(z);
    }

    public void setProgress(int i) {
        this.f12299g.setIndeterminate(false);
        this.f12299g.setProgress(i);
    }

    public void setImageUri(Uri uri) {
        this.f12294b.a(uri, f12293a);
    }

    public void setImageResource(Drawable drawable) {
        this.f12294b.setImageDrawable(drawable);
    }
}
