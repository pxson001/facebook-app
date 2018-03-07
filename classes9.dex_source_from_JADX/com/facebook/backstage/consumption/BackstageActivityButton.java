package com.facebook.backstage.consumption;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.common.locale.Locales;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import java.text.NumberFormat;
import javax.inject.Inject;

/* compiled from: scrolled_offset */
public class BackstageActivityButton extends LinearLayout {
    @Inject
    public Locales f4484a;
    private final FbTextView f4485b;

    private static <T extends View> void m4455a(Class<T> cls, T t) {
        m4456a((Object) t, t.getContext());
    }

    private static void m4456a(Object obj, Context context) {
        ((BackstageActivityButton) obj).f4484a = Locales.a(FbInjector.get(context));
    }

    public BackstageActivityButton(Context context) {
        this(context, null);
    }

    public BackstageActivityButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BackstageActivityButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4455a(BackstageActivityButton.class, (View) this);
        View.inflate(context, 2130903352, this);
        this.f4485b = (FbTextView) findViewById(2131559841);
    }

    public void setBadgeCounter(int i) {
        if (i == 0) {
            this.f4485b.setVisibility(8);
            return;
        }
        this.f4485b.setVisibility(0);
        this.f4485b.setText(NumberFormat.getInstance(this.f4484a.a()).format((long) i));
    }

    public final void m4457a() {
        setBadgeCounter(0);
    }

    private void m4454a(Locales locales) {
        this.f4484a = locales;
    }
}
