package com.facebook.structuredsurvey.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.RadioButton;
import com.facebook.structuredsurvey.items.SurveyItem;
import com.facebook.structuredsurvey.items.SurveyItem.ItemType;
import com.facebook.structuredsurvey.items.SurveyRadioItem;
import com.facebook.widget.text.BetterTextView;

/* compiled from: disable_only_on_excellent */
public class SurveyRadioListItemView extends SurveyListItemView implements Checkable {
    protected BetterTextView f17230b;
    protected RadioButton f17231c;
    protected boolean f17232d;

    public SurveyRadioListItemView(Context context) {
        super(context);
        m24976c();
    }

    public SurveyRadioListItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24976c();
    }

    public static SurveyRadioListItemView m24974a(ViewGroup viewGroup) {
        SurveyRadioListItemView surveyRadioListItemView = (SurveyRadioListItemView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907348, viewGroup, false);
        surveyRadioListItemView.setTag(ItemType.RADIO);
        return surveyRadioListItemView;
    }

    private void m24975b() {
        setContentView(2130907347);
    }

    private void m24976c() {
        m24975b();
        this.f17230b = (BetterTextView) findViewById(2131567796);
        this.f17231c = (RadioButton) findViewById(2131567797);
    }

    public final void mo1296a(SurveyItem surveyItem) {
        this.a = surveyItem;
        this.f17230b.setText(((SurveyRadioItem) surveyItem).mo1294a().f17112c);
    }

    public boolean isChecked() {
        return this.f17232d;
    }

    public void setChecked(boolean z) {
        this.f17232d = z;
        this.f17231c.setChecked(this.f17232d);
        ((SurveyRadioItem) this.f17202a).m24932a(Boolean.valueOf(this.f17232d));
    }

    public void toggle() {
        setChecked(!this.f17232d);
    }

    public final void m24977a() {
        this.f17231c.setVisibility(8);
    }
}
