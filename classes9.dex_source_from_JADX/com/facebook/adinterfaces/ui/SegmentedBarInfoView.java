package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.adinterfaces.model.AdInterfacesInsightsViewModel;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;

/* compiled from: Unknown or missing payload in accept packet */
public class SegmentedBarInfoView extends CustomLinearLayout {
    private BetterTextView f23162a;
    private BetterTextView f23163b;
    private BetterTextView f23164c;
    private BetterTextView f23165d;
    private BetterTextView f23166e;
    private BetterTextView f23167f;
    private BetterTextView f23168g;
    private BetterTextView f23169h;
    private View f23170i;
    private View f23171j;
    private View f23172k;

    public void setViewModel(AdInterfacesInsightsViewModel adInterfacesInsightsViewModel) {
        if (adInterfacesInsightsViewModel.f21704a == 2) {
            ((LinearLayout) findViewById(2131559298)).setVisibility(8);
        }
        setColors(adInterfacesInsightsViewModel.f21710g);
        setLabels(adInterfacesInsightsViewModel.f21708e);
        setBarWeights(adInterfacesInsightsViewModel.f21709f);
        setDataText(adInterfacesInsightsViewModel.f21707d);
        m25140a(adInterfacesInsightsViewModel.f21705b, adInterfacesInsightsViewModel.f21706c);
    }

    public SegmentedBarInfoView(Context context) {
        this(context, null);
        m25139a();
    }

    public SegmentedBarInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25139a();
    }

    public SegmentedBarInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m25139a();
    }

    private void m25139a() {
        setContentView(2130907052);
        this.f23163b = (BetterTextView) a(2131567388);
        this.f23164c = (BetterTextView) a(2131559294);
        this.f23165d = (BetterTextView) a(2131559296);
        this.f23166e = (BetterTextView) a(2131559299);
        this.f23162a = (BetterTextView) a(2131567387);
        this.f23167f = (BetterTextView) a(2131559295);
        this.f23168g = (BetterTextView) a(2131559297);
        this.f23169h = (BetterTextView) a(2131559300);
        this.f23170i = a(2131567389);
        this.f23171j = a(2131567390);
        this.f23172k = a(2131567391);
    }

    private void setColors(ImmutableList<Integer> immutableList) {
        this.f23170i.setBackgroundDrawable(new ColorDrawable(((Integer) immutableList.get(0)).intValue()));
        this.f23164c.setTextColor(((Integer) immutableList.get(0)).intValue());
        this.f23171j.setBackgroundDrawable(new ColorDrawable(((Integer) immutableList.get(1)).intValue()));
        this.f23165d.setTextColor(((Integer) immutableList.get(1)).intValue());
        if (immutableList.size() == 3) {
            this.f23172k.setBackgroundDrawable(new ColorDrawable(((Integer) immutableList.get(2)).intValue()));
            this.f23166e.setTextColor(((Integer) immutableList.get(2)).intValue());
        }
    }

    private void setLabels(ImmutableList<String> immutableList) {
        this.f23167f.setText((CharSequence) immutableList.get(0));
        this.f23168g.setText((CharSequence) immutableList.get(1));
        if (immutableList.size() == 3) {
            this.f23169h.setText((CharSequence) immutableList.get(2));
        }
    }

    private void setBarWeights(ImmutableList<Float> immutableList) {
        this.f23170i.setLayoutParams(m25138a(((Float) immutableList.get(0)).floatValue()));
        this.f23171j.setLayoutParams(m25138a(((Float) immutableList.get(1)).floatValue()));
        if (immutableList.size() == 3) {
            this.f23172k.setLayoutParams(m25138a(((Float) immutableList.get(2)).floatValue()));
        }
    }

    private void setDataText(ImmutableList<String> immutableList) {
        this.f23164c.setText((CharSequence) immutableList.get(0));
        this.f23165d.setText((CharSequence) immutableList.get(1));
        if (immutableList.size() == 3) {
            this.f23166e.setText((CharSequence) immutableList.get(2));
        }
    }

    private void m25140a(String str, String str2) {
        this.f23163b.setText(str);
        this.f23162a.setText(str2);
    }

    private static LayoutParams m25138a(float f) {
        return new LayoutParams(0, -1, f);
    }
}
