package com.facebook.payments.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: subtitle_description */
public class PaymentsSecurityInfoView extends PaymentsComponentLinearLayout {
    private BetterTextView f1955a;
    private BetterTextView f1956b;

    public PaymentsSecurityInfoView(Context context) {
        super(context);
        m2186a();
    }

    public PaymentsSecurityInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m2186a();
    }

    public PaymentsSecurityInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2186a();
    }

    private void m2186a() {
        setContentView(2130906161);
        setOrientation(1);
        this.f1955a = (BetterTextView) a(2131558966);
        this.f1956b = (BetterTextView) a(2131562644);
    }

    public void setText(@StringRes int i) {
        this.f1955a.setText(i);
    }

    public void setText(String str) {
        this.f1955a.setText(str);
    }

    public void setTextSize(float f) {
        this.f1955a.setTextSize(f);
    }

    public void setLearnMoreUri(final Uri uri) {
        if (uri != null) {
            this.f1956b.setVisibility(0);
            this.f1956b.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ PaymentsSecurityInfoView f1986b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -867489279);
                    this.f1986b.f1954a.mo82b(new Intent("android.intent.action.VIEW").setData(uri));
                    Logger.a(2, EntryType.UI_INPUT_END, 1213438882, a);
                }
            });
        }
    }
}
