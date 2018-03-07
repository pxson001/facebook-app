package com.facebook.zero.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.inject.FbInjector;
import com.facebook.zero.debug.ZeroDebugPricingUtil;
import com.facebook.zero.rewrite.ZeroDebugHttpFilter;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ्उ */
public class ZeroUrlDebugActivity extends FbFragmentActivity {
    @Inject
    public ZeroDebugHttpFilter f58p;

    private static <T extends Context> void m58a(Class<T> cls, T t) {
        m59a((Object) t, (Context) t);
    }

    public static void m59a(Object obj, Context context) {
        ((ZeroUrlDebugActivity) obj).f58p = ZeroDebugHttpFilter.a(FbInjector.get(context));
    }

    protected final void m60b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = ZeroUrlDebugActivity.class;
        m59a((Object) this, (Context) this);
        setContentView(2130907802);
        TextView textView = (TextView) a(2131568051);
        String str = "";
        for (String str2 : this.f58p.b) {
            str = str + str2 + "\n";
        }
        textView.setText(str, BufferType.SPANNABLE);
        m56a(textView, str);
    }

    private void m56a(TextView textView, String str) {
        Spannable spannable = (Spannable) textView.getText();
        for (String str2 : this.f58p.b) {
            if (ZeroDebugPricingUtil.m97a(str2)) {
                int indexOf = str.indexOf(str2);
                while (indexOf >= 0) {
                    spannable.setSpan(new ForegroundColorSpan(Color.argb(255, 87, 25, 159)), indexOf, str2.length() + indexOf, 33);
                    indexOf = str.indexOf(str2, indexOf + 1);
                }
            }
        }
        textView.setText(spannable);
    }

    private void m57a(ZeroDebugHttpFilter zeroDebugHttpFilter) {
        this.f58p = zeroDebugHttpFilter;
    }
}
