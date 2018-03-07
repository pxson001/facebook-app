package com.facebook.fbui.widget.megaphone;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import com.facebook.R;
import com.facebook.fbui.facepile.FacepileView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.TextViewUtils;
import java.util.List;

/* compiled from: song_name */
public class Megaphone extends CustomFrameLayout {
    private ImageBlockLayout f3636a;
    private FbTextView f3637b;
    private FbTextView f3638c;
    private ImageBlockLayout f3639d;
    private FacepileView f3640e;
    private FbTextView f3641f;
    private ImageButton f3642g;
    private View f3643h;
    private View f3644i;
    private Button f3645j;
    private Button f3646k;
    private int f3647l;
    public OnDismissListener f3648m;
    private final OnClickListener f3649n;

    /* compiled from: song_name */
    class C03131 implements OnClickListener {
        final /* synthetic */ Megaphone f3635a;

        C03131(Megaphone megaphone) {
            this.f3635a = megaphone;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1847858671);
            if (this.f3635a.f3648m != null) {
                this.f3635a.f3648m.m4360a(this.f3635a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 475918333, a);
        }
    }

    /* compiled from: song_name */
    public interface OnDismissListener {
        void m4360a(Megaphone megaphone);
    }

    public Megaphone(Context context) {
        this(context, null);
    }

    public Megaphone(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130772618);
    }

    public Megaphone(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3649n = new C03131(this);
        m4362a(context, attributeSet, i);
    }

    private void m4362a(Context context, AttributeSet attributeSet, int i) {
        setContentView(2130904267);
        setBackgroundResource(2130839979);
        this.f3636a = (ImageBlockLayout) c(2131561837);
        this.f3637b = (FbTextView) c(2131561838);
        this.f3638c = (FbTextView) c(2131561839);
        this.f3639d = (ImageBlockLayout) c(2131561840);
        this.f3640e = (FacepileView) c(2131561841);
        this.f3641f = (FbTextView) c(2131561842);
        this.f3642g = (ImageButton) c(2131561847);
        this.f3643h = c(2131561843);
        this.f3644i = c(2131561844);
        this.f3645j = (Button) c(2131561846);
        this.f3646k = (Button) c(2131561845);
        this.f3642g.setOnClickListener(this.f3649n);
        this.f3647l = getResources().getDimensionPixelSize(2131427501);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Megaphone, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId > 0) {
            setTitle(resourceId);
        } else {
            setTitle(obtainStyledAttributes.getText(0));
        }
        resourceId = obtainStyledAttributes.getResourceId(1, 0);
        if (resourceId > 0) {
            setSubtitle(resourceId);
        } else {
            setSubtitle(obtainStyledAttributes.getText(1));
        }
        resourceId = obtainStyledAttributes.getResourceId(2, 0);
        if (resourceId > 0) {
            setPrimaryButtonText(resourceId);
        } else {
            setPrimaryButtonText(obtainStyledAttributes.getText(2));
        }
        resourceId = obtainStyledAttributes.getResourceId(3, 0);
        if (resourceId > 0) {
            setSecondaryButtonText(resourceId);
        } else {
            setSecondaryButtonText(obtainStyledAttributes.getText(3));
        }
        setImageDrawable(obtainStyledAttributes.getDrawable(4));
        obtainStyledAttributes.recycle();
    }

    public void setTitle(int i) {
        if (i != 0) {
            this.f3637b.setText(i);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f3637b.setText(charSequence);
    }

    public void setTitleMaxLines(int i) {
        this.f3637b.setMaxLines(i);
        this.f3637b.setEllipsize(TruncateAt.END);
    }

    public final boolean m4364a() {
        return TextViewUtils.a(this.f3637b);
    }

    public void setSubtitle(int i) {
        if (i != 0) {
            this.f3638c.setText(i);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f3638c.setText(charSequence);
    }

    public void setSubtitleMaxLines(int i) {
        this.f3638c.setMaxLines(i);
        this.f3638c.setEllipsize(TruncateAt.END);
    }

    public final boolean m4365b() {
        return TextViewUtils.a(this.f3638c);
    }

    public void setPrimaryButtonText(CharSequence charSequence) {
        this.f3645j.setText(charSequence);
    }

    public final boolean m4366e() {
        return TextViewUtils.a(this.f3645j);
    }

    public void setPrimaryButtonText(int i) {
        if (i != 0) {
            this.f3645j.setText(i);
        }
    }

    public void setSecondaryButtonText(CharSequence charSequence) {
        this.f3646k.setText(charSequence);
    }

    public final boolean m4367f() {
        return TextViewUtils.a(this.f3646k);
    }

    public void setSecondaryButtonText(int i) {
        if (i != 0) {
            this.f3646k.setText(i);
        }
    }

    public void setShowButtonsContainer(boolean z) {
        this.f3644i.setVisibility(z ? 0 : 8);
    }

    public void setShowPrimaryButton(boolean z) {
        this.f3645j.setVisibility(z ? 0 : 8);
    }

    public void setShowSecondaryButton(boolean z) {
        this.f3646k.setVisibility(z ? 0 : 8);
    }

    public void setShowCloseButton(boolean z) {
        this.f3642g.setVisibility(z ? 0 : 8);
    }

    public void setImageResource(int i) {
        setImageDrawable(i > 0 ? getResources().getDrawable(i) : null);
    }

    public void setImageDrawable(Drawable drawable) {
        this.f3636a.setThumbnailDrawable(drawable);
        this.f3636a.setShowThumbnail(drawable != null);
    }

    public void setImageUri(Uri uri) {
        this.f3636a.setThumbnailUri(uri);
        this.f3636a.setShowThumbnail(true);
    }

    public void setImageView(View view) {
        this.f3636a.setThumbnailView(view);
        this.f3636a.setShowThumbnail(view != null);
    }

    public void setSocialContext(int i) {
        this.f3641f.setText(i);
        setShowSocialContextContainer(i > 0);
    }

    public void setSocialContext(CharSequence charSequence) {
        this.f3641f.setText(charSequence);
        setShowSocialContextContainer(!TextUtils.isEmpty(charSequence));
    }

    public void setSocialContextMaxLines(int i) {
        this.f3641f.setMaxLines(i);
        this.f3641f.setEllipsize(TruncateAt.END);
    }

    public final boolean m4368g() {
        return TextViewUtils.a(this.f3641f);
    }

    public void setFacepileUrls(List<Uri> list) {
        setShowSocialContextContainer(list != null);
        this.f3640e.setFaceSize(this.f3647l);
        this.f3640e.setFaceUrls(list);
    }

    public void setFacepileDrawables(List<Drawable> list) {
        setShowSocialContextContainer(list != null);
        this.f3640e.setFaceSize(this.f3647l);
        this.f3640e.setFaceDrawables(list);
    }

    public void setShowSocialContextContainer(boolean z) {
        this.f3639d.setVisibility(z ? 0 : 8);
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f3648m = onDismissListener;
    }

    public void setOnPrimaryButtonClickListener(OnClickListener onClickListener) {
        this.f3645j.setOnClickListener(onClickListener);
    }

    public void setOnSecondaryButtonClickListener(OnClickListener onClickListener) {
        this.f3646k.setOnClickListener(onClickListener);
    }

    public final void m4363a(int i, int i2) {
        this.f3636a.d(i, i2);
    }

    public void setDividerBackground(int i) {
        this.f3643h.setBackgroundResource(i);
    }
}
