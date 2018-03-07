package com.facebook.structuredsurvey.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.facebook.structuredsurvey.items.SurveyEditTextItem;
import com.facebook.structuredsurvey.items.SurveyItem;
import com.facebook.structuredsurvey.items.SurveyItem.ItemType;
import com.facebook.widget.text.BetterEditTextView;

/* compiled from: disambiguation_table_of_contents_post_module */
public class SurveyEditTextListItemView extends SurveyListItemView {
    private BetterEditTextView f17206b;

    public SurveyEditTextListItemView(Context context) {
        super(context);
        m24951b();
    }

    public SurveyEditTextListItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24951b();
    }

    public static SurveyEditTextListItemView m24950a(ViewGroup viewGroup) {
        SurveyEditTextListItemView surveyEditTextListItemView = (SurveyEditTextListItemView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907335, viewGroup, false);
        surveyEditTextListItemView.setTag(ItemType.EDITTEXT);
        return surveyEditTextListItemView;
    }

    private void m24951b() {
        setContentView(2130907334);
        this.f17206b = (BetterEditTextView) findViewById(2131567776);
        this.f17206b.setFocusable(true);
        this.f17206b.setFocusableInTouchMode(true);
        this.f17206b.setHint(2131236123);
    }

    public final void mo1296a(SurveyItem surveyItem) {
        this.a = surveyItem;
        this.f17206b.setText(((SurveyEditTextItem) this.f17202a).m24930c());
    }

    public final void m24952a() {
        m24954a(false);
    }

    public final void m24954a(boolean z) {
        this.f17206b.requestFocus();
        if (z) {
            ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this.f17206b, 1);
        }
    }

    public String getText() {
        return this.f17206b.getText().toString();
    }

    public void setItemOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.f17206b.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void onStartTemporaryDetach() {
        ((SurveyEditTextItem) this.f17202a).m24928a(getText());
        super.onStartTemporaryDetach();
    }
}
