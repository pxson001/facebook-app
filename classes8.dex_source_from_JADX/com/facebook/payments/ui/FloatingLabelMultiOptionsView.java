package com.facebook.payments.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.concurrent.Immutable;

/* compiled from: substring */
public class FloatingLabelMultiOptionsView extends PaymentsComponentLinearLayout {
    private BetterTextView f1960a;
    public FloatingLabelTextView f1961b;
    public Listener f1962c;

    /* compiled from: substring */
    class C02231 implements OnClickListener {
        final /* synthetic */ FloatingLabelMultiOptionsView f1957a;

        C02231(FloatingLabelMultiOptionsView floatingLabelMultiOptionsView) {
            this.f1957a = floatingLabelMultiOptionsView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -25583417);
            this.f1957a.f1962c.m2188a();
            Logger.a(2, EntryType.UI_INPUT_END, 906269801, a);
        }
    }

    /* compiled from: substring */
    class C02242 implements OnClickListener {
        final /* synthetic */ FloatingLabelMultiOptionsView f1958a;

        C02242(FloatingLabelMultiOptionsView floatingLabelMultiOptionsView) {
            this.f1958a = floatingLabelMultiOptionsView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1984141119);
            this.f1958a.f1962c.m2189b();
            Logger.a(2, EntryType.UI_INPUT_END, -1554420110, a);
        }
    }

    /* compiled from: substring */
    public interface Listener {
        void m2188a();

        void m2189b();
    }

    @Immutable
    /* compiled from: substring */
    public enum Mode {
        ACTION_TEXT,
        FLOATING_LABEL_TEXT
    }

    public FloatingLabelMultiOptionsView(Context context) {
        super(context);
        m2192b();
    }

    public FloatingLabelMultiOptionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2192b();
    }

    public FloatingLabelMultiOptionsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2192b();
    }

    private void m2192b() {
        setContentView(2130904380);
        m2194c();
        this.f1960a = (BetterTextView) a(2131562081);
        this.f1961b = (FloatingLabelTextView) a(2131562082);
    }

    private void m2194c() {
        setGravity(16);
        setOrientation(1);
    }

    public FloatingLabelTextView getSelectedItemView() {
        return this.f1961b;
    }

    public final void m2196a() {
        CustomViewUtils.b(this, getResources().getDrawable(2130842568));
    }

    public void setListener(Listener listener) {
        this.f1962c = listener;
    }

    public void setViewParams(FloatingLabelMultiOptionsViewParams floatingLabelMultiOptionsViewParams) {
        m2195d();
        switch (floatingLabelMultiOptionsViewParams.f1963a) {
            case ACTION_TEXT:
                m2191a(floatingLabelMultiOptionsViewParams);
                return;
            case FLOATING_LABEL_TEXT:
                m2193b(floatingLabelMultiOptionsViewParams);
                return;
            default:
                throw new IllegalArgumentException("Unknown mode seen: " + floatingLabelMultiOptionsViewParams.f1963a);
        }
    }

    private void m2191a(FloatingLabelMultiOptionsViewParams floatingLabelMultiOptionsViewParams) {
        this.f1960a.setText(floatingLabelMultiOptionsViewParams.f1966d);
        this.f1960a.setOnClickListener(new C02231(this));
        this.f1960a.setVisibility(0);
    }

    private void m2193b(FloatingLabelMultiOptionsViewParams floatingLabelMultiOptionsViewParams) {
        this.f1961b.setHint(floatingLabelMultiOptionsViewParams.f1964b);
        if (floatingLabelMultiOptionsViewParams.f1965c == null) {
            this.f1961b.m2208a();
            this.f1961b.setOnClickListener(null);
        } else {
            this.f1961b.m2209b();
            this.f1961b.setText(floatingLabelMultiOptionsViewParams.f1965c);
            this.f1961b.setOnClickListener(new C02242(this));
        }
        this.f1961b.setVisibility(0);
    }

    private void m2195d() {
        this.f1960a.setVisibility(8);
        this.f1961b.setVisibility(8);
    }
}
