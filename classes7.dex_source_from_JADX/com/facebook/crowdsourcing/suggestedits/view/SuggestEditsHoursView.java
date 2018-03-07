package com.facebook.crowdsourcing.suggestedits.view;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: click_view_post_button */
public class SuggestEditsHoursView extends CustomLinearLayout {
    private TextView f17693a;
    private LinearLayout f17694b;
    private FbDraweeView f17695c;

    public SuggestEditsHoursView(Context context) {
        super(context);
        m21557c();
    }

    public SuggestEditsHoursView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21557c();
    }

    public SuggestEditsHoursView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21557c();
    }

    private void m21557c() {
        setContentView(2130907300);
        this.f17693a = (TextView) a(2131567752);
        this.f17694b = (LinearLayout) a(2131567751);
        this.f17695c = (FbDraweeView) a(2131567750);
    }

    public final void m21560a() {
        this.f17694b.removeAllViews();
        this.f17694b.setVisibility(0);
        this.f17695c.setVisibility(8);
        this.f17693a.setVisibility(8);
        setOnClickListener(null);
    }

    public void setFieldIcon(@Nullable String str) {
        if (str != null) {
            this.f17695c.setVisibility(0);
            this.f17695c.a(Uri.parse(str), CallerContext.a(getClass(), "crowdsourcing_edit"));
        }
    }

    public final SuggestEditsTextFieldView m21559a(String str, String str2) {
        SuggestEditsTextFieldView suggestEditsTextFieldView = new SuggestEditsTextFieldView(getContext());
        suggestEditsTextFieldView.setActionButtonVisible(false);
        suggestEditsTextFieldView.setFieldText(str);
        suggestEditsTextFieldView.m21594a(str2, CallerContext.a(getClass(), "crowdsourcing_edit"));
        suggestEditsTextFieldView.setIconVisible(true);
        this.f17694b.addView(suggestEditsTextFieldView);
        return suggestEditsTextFieldView;
    }

    public final void m21563b(String str, String str2) {
        SuggestEditsHoursForSingleDayView d = m21558d();
        d.setDayLabel(str);
        d.setHours(str2);
        this.f17694b.addView(d);
    }

    public final void m21561a(String str) {
        SuggestEditsHoursForSingleDayView d = m21558d();
        d.setDayLabel(str);
        d.m21556a();
        this.f17694b.addView(d);
    }

    public final void m21562b() {
        this.f17694b.setVisibility(8);
        this.f17693a.setVisibility(0);
    }

    private SuggestEditsHoursForSingleDayView m21558d() {
        return (SuggestEditsHoursForSingleDayView) LayoutInflater.from(getContext()).inflate(2130907301, this, false);
    }
}
