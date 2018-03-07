package com.facebook.pages.common.surface.calltoaction.ui;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.common.util.StringUtil;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil.PageCallToActionErrorState;
import com.facebook.widget.CustomRelativeLayout;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: cover */
public class PageCallToActionGroupView extends CustomRelativeLayout implements PageCallToActionInput {
    private LinearLayout f16807a;
    private TextView f16808b;
    private final ArrayMap<String, PageCallToActionInput> f16809c = new ArrayMap();
    private final ArrayMap<String, PageCallToActionInput> f16810d = new ArrayMap();

    public PageCallToActionGroupView(Context context) {
        super(context);
        m20053f();
    }

    public PageCallToActionGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20053f();
    }

    public PageCallToActionGroupView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20053f();
    }

    public View getView() {
        return this;
    }

    public final boolean mo1032a() {
        return false;
    }

    public String getValue() {
        return null;
    }

    public final PageCallToActionErrorState mo1033b() {
        for (Entry entry : this.f16809c.entrySet()) {
            PageCallToActionErrorState b = ((PageCallToActionInput) entry.getValue()).mo1033b();
            if (b != PageCallToActionErrorState.NONE || StringUtil.a(((PageCallToActionInput) entry.getValue()).getValue())) {
                ((PageCallToActionInput) entry.getValue()).mo1035d();
                this.f16808b.setText(getResources().getString(2131239567));
                return b;
            }
            ((PageCallToActionInput) entry.getValue()).mo1036e();
        }
        if (!this.f16810d.isEmpty()) {
            Object obj = null;
            for (Entry entry2 : this.f16810d.entrySet()) {
                Object obj2;
                if (StringUtil.a(((PageCallToActionInput) entry2.getValue()).getValue())) {
                    obj2 = obj;
                } else {
                    PageCallToActionErrorState b2 = ((PageCallToActionInput) entry2.getValue()).mo1033b();
                    if (b2 == PageCallToActionErrorState.NONE) {
                        obj2 = 1;
                    } else {
                        ((PageCallToActionInput) entry2.getValue()).mo1035d();
                        this.f16808b.setText(getResources().getString(2131239574));
                        return b2;
                    }
                }
                ((PageCallToActionInput) entry2.getValue()).mo1036e();
                obj = obj2;
            }
            if (obj == null) {
                for (Entry entry22 : this.f16810d.entrySet()) {
                    ((PageCallToActionInput) entry22.getValue()).mo1035d();
                }
                this.f16808b.setText(getResources().getString(2131239568));
                return PageCallToActionErrorState.EMPTY;
            }
        }
        return PageCallToActionErrorState.NONE;
    }

    public final void mo1034c() {
        this.f16808b.setVisibility(0);
    }

    public final void mo1035d() {
    }

    public final void mo1036e() {
        this.f16808b.setVisibility(8);
    }

    public final void m20054a(String str, @Nullable PageCallToActionInput pageCallToActionInput, boolean z) {
        if (pageCallToActionInput != null) {
            this.f16807a.addView(pageCallToActionInput.getView());
            if (z) {
                this.f16810d.put(str, pageCallToActionInput);
            } else {
                this.f16809c.put(str, pageCallToActionInput);
            }
        }
    }

    public Map<String, String> getChildInputValues() {
        ArrayMap arrayMap = new ArrayMap();
        for (Entry entry : this.f16809c.entrySet()) {
            arrayMap.put(entry.getKey(), ((PageCallToActionInput) entry.getValue()).getValue());
        }
        for (Entry entry2 : this.f16810d.entrySet()) {
            if (!(StringUtil.a((CharSequence) entry2.getKey()) || entry2.getValue() == null || StringUtil.a(((PageCallToActionInput) entry2.getValue()).getValue()))) {
                arrayMap.put(entry2.getKey(), ((PageCallToActionInput) entry2.getValue()).getValue());
            }
        }
        return arrayMap;
    }

    private void m20053f() {
        setContentView(2130905975);
        this.f16807a = (LinearLayout) a(2131565384);
        this.f16808b = (TextView) findViewById(2131565380);
    }
}
