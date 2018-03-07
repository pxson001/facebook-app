package com.facebook.structuredsurvey.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Checkable;
import com.facebook.structuredsurvey.items.SurveyCheckboxItem;
import com.facebook.structuredsurvey.items.SurveyItem;
import com.facebook.structuredsurvey.items.SurveyItem.ItemType;
import com.facebook.widget.text.BetterTextView;

/* compiled from: discard_cancelled */
public class SurveyCheckboxListItemView extends SurveyListItemView implements Checkable {
    private BetterTextView f17203b;
    private CheckBox f17204c;
    private boolean f17205d;

    public SurveyCheckboxListItemView(Context context) {
        super(context);
        m24946a();
    }

    public SurveyCheckboxListItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24946a();
    }

    public static SurveyCheckboxListItemView m24945a(ViewGroup viewGroup) {
        SurveyCheckboxListItemView surveyCheckboxListItemView = (SurveyCheckboxListItemView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907330, viewGroup, false);
        surveyCheckboxListItemView.setTag(ItemType.CHECKBOX);
        return surveyCheckboxListItemView;
    }

    private void m24946a() {
        setContentView(2130907329);
        this.f17203b = (BetterTextView) findViewById(2131567773);
        this.f17204c = (CheckBox) findViewById(2131567774);
    }

    public final void mo1296a(SurveyItem surveyItem) {
        this.a = surveyItem;
        this.f17203b.setText(((SurveyCheckboxItem) surveyItem).mo1294a().f17112c);
    }

    public boolean isChecked() {
        return this.f17205d;
    }

    public void setChecked(boolean z) {
        this.f17205d = z;
        this.f17204c.setChecked(this.f17205d);
        ((SurveyCheckboxItem) this.f17202a).f17168d = Boolean.valueOf(this.f17205d).booleanValue();
    }

    public void toggle() {
        setChecked(!this.f17205d);
    }
}
