package com.facebook.messaging.payment.awareness;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: intro_reason */
public class GroupCommercePaymentAwarenessFooterView extends CustomLinearLayout {
    public SecureContextHelper f12807a;

    /* compiled from: intro_reason */
    class C14391 implements OnClickListener {
        final /* synthetic */ GroupCommercePaymentAwarenessFooterView f12806a;

        C14391(GroupCommercePaymentAwarenessFooterView groupCommercePaymentAwarenessFooterView) {
            this.f12806a = groupCommercePaymentAwarenessFooterView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1370245175);
            this.f12806a.f12807a.b(new Intent("android.intent.action.VIEW").setData(Uri.parse("https://m.facebook.com/help/messenger-app/750020781733477")), this.f12806a.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, -1962568629, a);
        }
    }

    private static <T extends View> void m13145a(Class<T> cls, T t) {
        m13146a((Object) t, t.getContext());
    }

    private static void m13146a(Object obj, Context context) {
        ((GroupCommercePaymentAwarenessFooterView) obj).f12807a = (SecureContextHelper) DefaultSecureContextHelper.a(FbInjector.get(context));
    }

    public GroupCommercePaymentAwarenessFooterView(Context context) {
        super(context);
        m13143a();
    }

    public GroupCommercePaymentAwarenessFooterView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m13143a();
    }

    public GroupCommercePaymentAwarenessFooterView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13143a();
    }

    @Inject
    private void m13144a(SecureContextHelper secureContextHelper) {
        this.f12807a = secureContextHelper;
    }

    private void m13143a() {
        m13145a(GroupCommercePaymentAwarenessFooterView.class, (View) this);
        setContentView(2130904646);
        ((BetterTextView) a(2131562644)).setOnClickListener(new C14391(this));
    }
}
