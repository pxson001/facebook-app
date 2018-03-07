package com.facebook.abtest.qe.settings.widget;

import android.content.Context;
import android.graphics.Color;
import android.preference.Preference;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.abtest.qe.settings.ExperimentInfo;
import com.facebook.abtest.qe.settings.QuickExperimentNameHelper;
import com.facebook.inject.FbInjector;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import java.util.Map.Entry;

/* compiled from: tolerance */
public class QuickExperimentInfoPreference extends Preference {
    private final QuickExperimentNameHelper f1844a;
    public ExperimentInfo f1845b;
    public boolean f1846c;
    public boolean f1847d;

    /* compiled from: tolerance */
    class C01271 extends ClickableSpan {
        final /* synthetic */ QuickExperimentInfoPreference f1843a;

        C01271(QuickExperimentInfoPreference quickExperimentInfoPreference) {
            this.f1843a = quickExperimentInfoPreference;
        }

        public void onClick(View view) {
            QuickExperimentInfoPreference quickExperimentInfoPreference = this.f1843a;
            String str = this.f1843a.f1845b.f1778b;
            Iterable a = Lists.a();
            for (Entry entry : quickExperimentInfoPreference.f1845b.f1780d.entrySet()) {
                a.add(((String) entry.getKey()) + " : <i>" + ((String) entry.getValue()) + "</i>");
            }
            new FbAlertDialogBuilder(quickExperimentInfoPreference.getContext()).a("Parameters for " + QuickExperimentNameHelper.m2487a(str)).b(Html.fromHtml(Joiner.on("<br>").join(a))).a().show();
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    private QuickExperimentInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(2130906537);
        this.f1844a = QuickExperimentNameHelper.m2486a(FbInjector.get(context));
        setSelectable(false);
    }

    private QuickExperimentInfoPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public QuickExperimentInfoPreference(Context context) {
        this(context, null);
    }

    protected void onBindView(View view) {
        super.onBindView(view);
        if (this.f1845b != null) {
            int i;
            ((TextView) view.findViewById(2131566475)).setText(QuickExperimentNameHelper.m2487a(this.f1845b.f1777a));
            int parseColor = Color.parseColor(this.f1846c ? "#ED9A00" : "#009EED");
            TextView textView = (TextView) view.findViewById(2131566477);
            TextView textView2 = (TextView) view.findViewById(2131566478);
            textView.setVisibility(8);
            textView2.setVisibility(8);
            if ("local_default_group".equals(this.f1845b.f1778b)) {
                textView.setTextColor(parseColor);
                textView.setVisibility(0);
            } else {
                C01271 c01271 = new C01271(this);
                CharSequence spannableString = new SpannableString(QuickExperimentNameHelper.m2487a(this.f1845b.f1778b));
                spannableString.setSpan(c01271, 0, spannableString.length(), 33);
                spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 33);
                textView2.setText(new SpannableStringBuilder().append("Current Group: ").append(spannableString));
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
                textView2.setVisibility(0);
            }
            textView = (TextView) view.findViewById(2131566476);
            textView.setTextColor(parseColor);
            if (this.f1845b.f1779c) {
                i = 8;
            } else {
                i = 0;
            }
            textView.setVisibility(i);
            textView = (TextView) view.findViewById(2131566479);
            textView.setTextColor(parseColor);
            if (this.f1847d) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }
}
