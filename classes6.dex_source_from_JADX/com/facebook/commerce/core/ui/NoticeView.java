package com.facebook.commerce.core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: preview_property_name */
public class NoticeView extends CustomLinearLayout {
    private static final int f7507a = NoticeLevel.NOTIFY.iconResId;
    private static final int f7508b = NoticeLevel.NOTIFY.colorResId;
    private GlyphView f7509c;
    private BetterTextView f7510d;
    private BetterTextView f7511e;
    private GradientDrawable f7512f;
    private GradientDrawable f7513g;
    private Resources f7514h;
    private int f7515i;

    /* compiled from: preview_property_name */
    public enum NoticeLevel {
        NOTIFY(2130840563, 2131361917),
        WARN(2130840562, 2131361918);
        
        int colorResId;
        int iconResId;

        private NoticeLevel(int i, int i2) {
            this.iconResId = i;
            this.colorResId = i2;
        }
    }

    public NoticeView(Context context) {
        super(context);
        m10647a();
    }

    public NoticeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m10647a();
    }

    protected NoticeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10647a();
    }

    private void m10647a() {
        setOrientation(0);
        setContentView(2130905472);
        this.f7514h = getResources();
        this.f7515i = this.f7514h.getDimensionPixelSize(2131429729);
        this.f7509c = (GlyphView) a(2131564258);
        this.f7510d = (BetterTextView) a(2131564259);
        this.f7511e = (BetterTextView) a(2131564260);
        this.f7512f = (GradientDrawable) this.f7514h.getDrawable(2130841709);
        this.f7512f.setColor(this.f7514h.getColor(f7508b));
        this.f7513g = (GradientDrawable) getResources().getDrawable(2130841708);
        this.f7513g.setStroke(this.f7515i, this.f7514h.getColor(f7508b));
        CustomViewUtils.b(this.f7509c, this.f7512f);
        this.f7509c.setImageResource(f7507a);
        CustomViewUtils.b(this, this.f7513g);
    }

    public void setLevel(NoticeLevel noticeLevel) {
        Preconditions.checkNotNull(noticeLevel);
        this.f7512f.mutate();
        this.f7512f.setColor(this.f7514h.getColor(noticeLevel.colorResId));
        this.f7513g.mutate();
        this.f7513g.setStroke(this.f7515i, this.f7514h.getColor(noticeLevel.colorResId));
        this.f7509c.setImageResource(noticeLevel.iconResId);
        invalidate();
    }

    public void setTitle(String str) {
        this.f7510d.setVisibility(StringUtil.c(str) ? 8 : 0);
        this.f7510d.setText(str);
    }

    public void setMessage(String str) {
        this.f7511e.setVisibility(StringUtil.c(str) ? 8 : 0);
        this.f7511e.setText(str);
    }
}
