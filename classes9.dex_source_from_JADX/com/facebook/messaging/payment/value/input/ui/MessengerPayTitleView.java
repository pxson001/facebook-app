package com.facebook.messaging.payment.value.input.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

/* compiled from: edit_card */
public class MessengerPayTitleView extends CustomFrameLayout {
    private TextView f15854a;
    private TextView f15855b;

    private static <T extends View> void m16049a(Class<T> cls, T t) {
        FbInjector.get(t.getContext());
    }

    private static void m16050a(Object obj, Context context) {
        FbInjector.get(context);
    }

    public MessengerPayTitleView(Context context) {
        super(context);
        m16048a();
    }

    public MessengerPayTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16048a();
    }

    public MessengerPayTitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16048a();
    }

    private void m16048a() {
        m16049a(MessengerPayTitleView.class, (View) this);
        setContentView(2130905262);
        this.f15854a = (TextView) c(2131563860);
        this.f15855b = (TextView) c(2131563861);
    }

    public void setTitle(String str) {
        this.f15854a.setText(str);
    }

    public void setTitle(int i) {
        this.f15854a.setText(i);
    }

    public void setUserName(@Nullable String str) {
        if (StringUtil.a(str)) {
            this.f15855b.setVisibility(8);
            return;
        }
        this.f15855b.setVisibility(0);
        this.f15855b.setText(str);
    }
}
