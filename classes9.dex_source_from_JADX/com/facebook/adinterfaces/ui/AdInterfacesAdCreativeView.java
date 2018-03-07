package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.net.Uri;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.text.BadgeTextView;
import com.facebook.resources.ui.FbButton;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterEditTextView;
import javax.annotation.Nullable;

/* compiled from: VOICE_MESSAGE */
public class AdInterfacesAdCreativeView extends CustomLinearLayout {
    private static final CallerContext f22502a = CallerContext.a(AdInterfacesAdCreativeView.class);
    public int f22503b;
    private BadgeTextView f22504c;
    private View f22505d;
    private BetterEditTextView f22506e;
    private BetterEditTextView f22507f;
    private View f22508g;
    private View f22509h;
    private FbDraweeView f22510i;
    private int f22511j = 0;
    private CustomLinearLayout f22512k;
    private FbButton f22513l;

    public AdInterfacesAdCreativeView(Context context) {
        super(context);
        m24371d();
    }

    public AdInterfacesAdCreativeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m24371d();
    }

    public AdInterfacesAdCreativeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24371d();
    }

    private void m24371d() {
        setContentView(2130903112);
        setOrientation(1);
        this.f22503b = getResources().getInteger(2131492891);
        this.f22504c = (BadgeTextView) a(2131559269);
        this.f22507f = (BetterEditTextView) a(2131559270);
        this.f22507f.setSingleLine(true);
        this.f22505d = a(2131559271);
        this.f22506e = (BetterEditTextView) a(2131559273);
        this.f22506e.setSingleLine(true);
        this.f22506e.setHorizontallyScrolling(false);
        this.f22506e.setMaxLines(getResources().getInteger(2131492892));
        this.f22508g = a(2131559275);
        this.f22504c.setBadgeText(String.valueOf(this.f22503b));
        this.f22510i = (FbDraweeView) a(2131559276);
        this.f22512k = (CustomLinearLayout) a(2131559277);
        this.f22513l = (FbButton) a(2131559278);
        this.f22509h = a(2131559274);
    }

    public final void m24374a() {
        this.f22504c.setVisibility(8);
        this.f22507f.setVisibility(8);
        this.f22505d.setVisibility(8);
    }

    public final void m24377b() {
        this.f22508g.setVisibility(8);
        this.f22509h.setVisibility(8);
    }

    public final void m24379c() {
        this.f22512k.setVisibility(0);
        this.f22513l.setVisibility(0);
    }

    public void setAdImageThumbnail(String str) {
        this.f22510i.a(Uri.parse(str), f22502a);
    }

    public void setHeadlineRemainingCharacters(int i) {
        this.f22504c.setBadgeText(String.valueOf(i));
    }

    public final void m24375a(TextWatcher textWatcher) {
        this.f22507f.addTextChangedListener(textWatcher);
    }

    public final void m24378b(TextWatcher textWatcher) {
        this.f22506e.addTextChangedListener(textWatcher);
    }

    public final void m24380c(TextWatcher textWatcher) {
        this.f22507f.removeTextChangedListener(textWatcher);
    }

    public final void m24381d(TextWatcher textWatcher) {
        this.f22506e.removeTextChangedListener(textWatcher);
    }

    public void setDescriptionText(CharSequence charSequence) {
        this.f22506e.setText(charSequence);
    }

    public void setOnImagePickerButtonClick(OnClickListener onClickListener) {
        this.f22508g.setOnClickListener(onClickListener);
    }

    public void setHeadlineText(CharSequence charSequence) {
        this.f22507f.setText(charSequence);
    }

    public int getMaxHeadlineLength() {
        return this.f22503b;
    }

    public void setAddAttachmentListener(OnClickListener onClickListener) {
        this.f22513l.setOnClickListener(onClickListener);
    }

    private void m24372e() {
        this.f22513l.setVisibility(this.f22511j == 5 ? 8 : 0);
    }

    public final AdInterfacesCreativeAttachmentView m24373a(String str, int i) {
        AdInterfacesCreativeAttachmentView adInterfacesCreativeAttachmentView = new AdInterfacesCreativeAttachmentView(getContext());
        adInterfacesCreativeAttachmentView.m24596a(str, i);
        this.f22512k.addView(adInterfacesCreativeAttachmentView);
        this.f22511j++;
        m24372e();
        return adInterfacesCreativeAttachmentView;
    }

    public final void m24376a(AdInterfacesCreativeAttachmentView adInterfacesCreativeAttachmentView) {
        this.f22511j--;
        m24372e();
        this.f22512k.removeView(adInterfacesCreativeAttachmentView);
    }
}
