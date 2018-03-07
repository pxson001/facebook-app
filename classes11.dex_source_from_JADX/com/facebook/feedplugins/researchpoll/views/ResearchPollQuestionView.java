package com.facebook.feedplugins.researchpoll.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableMap;
import java.util.Iterator;

/* compiled from: bytecode_cache_size_on_start */
public class ResearchPollQuestionView extends CustomLinearLayout {
    private TextView f9136a;
    private TextView f9137b;
    private CustomLinearLayout f9138c;

    public ResearchPollQuestionView(Context context) {
        super(context);
        m9822a();
    }

    public ResearchPollQuestionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9822a();
    }

    public ResearchPollQuestionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9822a();
    }

    private final void m9822a() {
        setContentView(2130906830);
        this.f9136a = (TextView) a(2131566971);
        this.f9137b = (TextView) a(2131566969);
        this.f9138c = (CustomLinearLayout) a(2131566970);
    }

    public void setAnswers(ImmutableMap<String, Boolean> immutableMap) {
        this.f9138c.removeAllViews();
        Integer valueOf = Integer.valueOf(0);
        Iterator it = immutableMap.keySet().iterator();
        Integer num = valueOf;
        while (it.hasNext()) {
            String str = (String) it.next();
            View checkBox = new CheckBox(getContext());
            checkBox.setText(str);
            this.f9138c.addView(checkBox);
            checkBox.setChecked(((Boolean) immutableMap.get(str)).booleanValue());
            valueOf = Integer.valueOf(num.intValue() + 1);
            checkBox.setTag(num);
            num = valueOf;
        }
    }

    public void setQuestionText(String str) {
        this.f9136a.setText(str);
    }

    public void setQuestionHint(String str) {
        this.f9137b.setText(str);
    }

    public void setOnAnswerClickListener(OnClickListener onClickListener) {
        int childCount = this.f9138c.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.f9138c.getChildAt(i).setOnClickListener(onClickListener);
        }
    }

    public final boolean m9824c(int i) {
        return ((CheckBox) this.f9138c.getChildAt(i)).isChecked();
    }

    public final void m9823a(Integer num) {
        int childCount = this.f9138c.getChildCount();
        for (int i = 0; i < childCount; i++) {
            CheckBox checkBox = (CheckBox) this.f9138c.getChildAt(i);
            checkBox.setChecked(num.equals(checkBox.getTag()));
        }
    }
}
