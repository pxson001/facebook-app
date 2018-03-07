package com.facebook.feed.rows.sections.inlinesurvey;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.facebook.common.util.SizeUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;

/* compiled from: Unable to connect to  */
public class InlineSurveyQuestionView extends CustomLinearLayout {
    public RadioGroup f21519a;
    public ImageView f21520b;
    public Context f21521c;
    public FbTextView f21522d;
    public FbTextView f21523e;
    public FbTextView f21524f;
    public int f21525g;
    public int f21526h;
    public int f21527i;

    public InlineSurveyQuestionView(Context context) {
        this(context, null);
    }

    private InlineSurveyQuestionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21521c = context;
        setOrientation(1);
        setContentView(2130904919);
        this.f21522d = (FbTextView) a(2131563175);
        this.f21519a = (RadioGroup) a(2131563179);
        this.f21520b = (ImageView) a(2131563176);
        this.f21520b.setImageDrawable(new GlyphColorizer(getResources()).a(getResources().getDrawable(2130839818), -4341303));
        this.f21523e = (FbTextView) a(2131563177);
        this.f21524f = (FbTextView) a(2131563178);
        this.f21525g = SizeUtil.a(this.f21521c, 40.0f);
        this.f21526h = SizeUtil.a(this.f21521c, 12.0f);
        this.f21527i = SizeUtil.a(this.f21521c, 5.0f);
        LayoutParams layoutParams = new RadioGroup.LayoutParams(-2, -1, 1.0f);
        for (int i = 0; i < 5; i++) {
            View radioButton = new RadioButton(getContext());
            radioButton.setId(i);
            if (i == 4) {
                layoutParams = new RadioGroup.LayoutParams(-2, -1);
            }
            radioButton.setLayoutParams(layoutParams);
            radioButton.setButtonDrawable(2130840069);
            this.f21519a.addView(radioButton);
        }
    }

    public void setAnswerButtonTexts(ImmutableList<String> immutableList) {
        this.f21523e.setText((CharSequence) immutableList.get(0));
        this.f21524f.setText((CharSequence) immutableList.get(4));
        this.f21523e.setPadding(m24156a(this.f21523e), 0, 0, 0);
        this.f21524f.setPadding(0, 0, m24156a(this.f21524f), 0);
    }

    public void setAnswerClickListener(OnClickListener onClickListener) {
        int childCount = this.f21519a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((RadioButton) this.f21519a.getChildAt(i)).setOnClickListener(onClickListener);
        }
    }

    public final void m24157a(boolean z, OnClickListener onClickListener) {
        this.f21520b.setOnClickListener(onClickListener);
        this.f21520b.setVisibility(z ? 0 : 8);
    }

    private int m24156a(FbTextView fbTextView) {
        return Math.max(this.f21525g - ((fbTextView.getText().length() / 2) * this.f21527i), this.f21526h);
    }
}
