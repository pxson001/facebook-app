package com.facebook.messaging.payment.prefs.receipts.footer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.util.Pair;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: go_to_profile_enabled */
public class ReceiptFooterInfoView extends CustomLinearLayout {
    public SecureContextHelper f14081a;
    private final BetterTextView f14082b;
    private final BetterTextView f14083c;
    private final BetterTextView f14084d;
    private final BetterTextView f14085e;
    private ReceiptFooterInfoViewParams f14086f;

    private static <T extends View> void m14561a(Class<T> cls, T t) {
        m14562a((Object) t, t.getContext());
    }

    private static void m14562a(Object obj, Context context) {
        ((ReceiptFooterInfoView) obj).f14081a = (SecureContextHelper) DefaultSecureContextHelper.a(FbInjector.get(context));
    }

    public ReceiptFooterInfoView(Context context) {
        this(context, null);
    }

    public ReceiptFooterInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected ReceiptFooterInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14561a(ReceiptFooterInfoView.class, (View) this);
        setContentView(2130906735);
        this.f14082b = (BetterTextView) a(2131566814);
        this.f14083c = (BetterTextView) a(2131566816);
        this.f14084d = (BetterTextView) a(2131566817);
        this.f14085e = (BetterTextView) a(2131566818);
    }

    @Inject
    private void m14559a(SecureContextHelper secureContextHelper) {
        this.f14081a = secureContextHelper;
    }

    public void setViewParams(ReceiptFooterInfoViewParams receiptFooterInfoViewParams) {
        this.f14086f = receiptFooterInfoViewParams;
        m14558a();
    }

    private void m14558a() {
        this.f14082b.setText(getResources().getString(2131240338, new Object[]{this.f14086f.f14091a}));
        m14563b();
    }

    private void m14563b() {
        Pair pair;
        switch (this.f14086f.f14092b.size()) {
            case 0:
                this.f14083c.setVisibility(8);
                this.f14084d.setVisibility(8);
                this.f14085e.setVisibility(8);
                return;
            case 1:
                pair = (Pair) this.f14086f.f14092b.get(0);
                this.f14083c.setText(((Integer) pair.a).intValue());
                m14560a(this.f14083c, (String) pair.b);
                this.f14083c.setVisibility(0);
                this.f14084d.setVisibility(8);
                this.f14085e.setVisibility(8);
                return;
            case 2:
                pair = (Pair) this.f14086f.f14092b.get(0);
                this.f14083c.setText(((Integer) pair.a).intValue());
                m14560a(this.f14083c, (String) pair.b);
                this.f14084d.setText("·");
                pair = (Pair) this.f14086f.f14092b.get(1);
                this.f14085e.setText(((Integer) pair.a).intValue());
                m14560a(this.f14085e, (String) pair.b);
                this.f14083c.setVisibility(0);
                this.f14084d.setVisibility(0);
                this.f14085e.setVisibility(0);
                return;
            default:
                throw new IllegalArgumentException("Invalid number of links provides " + this.f14086f.f14092b.size());
        }
    }

    private void m14560a(BetterTextView betterTextView, final String str) {
        betterTextView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ReceiptFooterInfoView f14080b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1468859030);
                if (StringUtil.a(str)) {
                    Logger.a(2, EntryType.UI_INPUT_END, -715011772, a);
                    return;
                }
                this.f14080b.f14081a.b(new Intent("android.intent.action.VIEW").setData(Uri.parse(str).buildUpon().build()), this.f14080b.getContext());
                LogUtils.a(-731304512, a);
            }
        });
    }
}
