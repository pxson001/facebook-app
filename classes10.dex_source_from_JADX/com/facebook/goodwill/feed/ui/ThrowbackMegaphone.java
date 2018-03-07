package com.facebook.goodwill.feed.ui;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: VIEW_ALL */
public class ThrowbackMegaphone extends CustomFrameLayout {
    private FbDraweeView f21228a;
    private FbTextView f21229b;
    private FbTextView f21230c;
    private ImageButton f21231d;
    private FbButton f21232e;
    private DefaultImageFields f21233f;
    public OnDismissListener f21234g;
    private final OnClickListener f21235h;

    /* compiled from: VIEW_ALL */
    public interface OnDismissListener {
        void mo952a();
    }

    /* compiled from: VIEW_ALL */
    class C30191 implements OnClickListener {
        final /* synthetic */ ThrowbackMegaphone f21227a;

        C30191(ThrowbackMegaphone throwbackMegaphone) {
            this.f21227a = throwbackMegaphone;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1095966034);
            if (this.f21227a.f21234g != null) {
                this.f21227a.f21234g.mo952a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -123915032, a);
        }
    }

    public ThrowbackMegaphone(Context context) {
        this(context, null);
    }

    public ThrowbackMegaphone(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThrowbackMegaphone(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21235h = new C30191(this);
        setContentView(2130907413);
        this.f21228a = (FbDraweeView) c(2131567882);
        this.f21229b = (FbTextView) c(2131567879);
        this.f21230c = (FbTextView) c(2131567880);
        this.f21231d = (ImageButton) c(2131567883);
        this.f21232e = (FbButton) c(2131567881);
        this.f21231d.setOnClickListener(this.f21235h);
    }

    public void setTitle(CharSequence charSequence) {
        this.f21229b.setText(charSequence);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f21230c.setText(charSequence);
    }

    public void setPrimaryButtonText(CharSequence charSequence) {
        this.f21232e.setText(charSequence);
    }

    public void setImage(DefaultImageFields defaultImageFields) {
        this.f21233f = defaultImageFields;
        this.f21228a.a(ImageUtil.a(this.f21233f), CallerContext.a(ThrowbackMegaphone.class, "goodwill_throwback"));
        this.f21228a.setVisibility(0);
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f21234g = onDismissListener;
    }

    public void setOnPrimaryButtonClickListener(OnClickListener onClickListener) {
        this.f21232e.setOnClickListener(onClickListener);
    }

    public final void m22154a(int i, int i2) {
        this.f21229b.setTextColor(i);
        Drawable background = this.f21232e.getBackground();
        background.setColorFilter(i2, Mode.SRC_IN);
        this.f21232e.setBackgroundDrawable(background);
    }
}
