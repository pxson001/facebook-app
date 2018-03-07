package com.facebook.events.tickets.modal.views;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import com.facebook.R;
import com.facebook.common.util.ContextUtils;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbEditText;
import com.facebook.resources.ui.FbTextView;
import com.facebook.resources.utils.ResourceUtils;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.keyboard.KeyboardUtils;
import javax.annotation.Nullable;

/* compiled from: applications_with_application_requests */
public class EventBuyTicketTextField extends ImageBlockLayout {
    public Activity f19346h;
    public FbEditText f19347i;
    public FbTextView f19348j;

    /* compiled from: applications_with_application_requests */
    class C27431 implements OnClickListener {
        final /* synthetic */ EventBuyTicketTextField f19344a;

        C27431(EventBuyTicketTextField eventBuyTicketTextField) {
            this.f19344a = eventBuyTicketTextField;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1410461781);
            if (this.f19344a.f19347i.hasFocus()) {
                this.f19344a.f19347i.clearFocus();
            } else {
                this.f19344a.f19347i.requestFocus();
                this.f19344a.f19347i.setSelection(this.f19344a.f19347i.getText().length());
            }
            LogUtils.a(462929994, a);
        }
    }

    /* compiled from: applications_with_application_requests */
    class C27442 implements OnFocusChangeListener {
        final /* synthetic */ EventBuyTicketTextField f19345a;

        C27442(EventBuyTicketTextField eventBuyTicketTextField) {
            this.f19345a = eventBuyTicketTextField;
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                this.f19345a.f19348j.setText(2131241939);
                KeyboardUtils.b(this.f19345a.f19346h, this.f19345a.f19347i);
                return;
            }
            this.f19345a.f19348j.setText(2131241938);
            KeyboardUtils.a(this.f19345a.f19346h);
        }
    }

    public EventBuyTicketTextField(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19497b(attributeSet);
    }

    public EventBuyTicketTextField(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19497b(attributeSet);
    }

    private void m19497b(AttributeSet attributeSet) {
        setContentView(2130903996);
        this.f19346h = (Activity) ContextUtils.a(getContext(), Activity.class);
        this.f19348j = (FbTextView) getView(2131561211);
        this.f19347i = (FbEditText) getView(2131561210);
        this.f19348j.setOnClickListener(new C27431(this));
        this.f19347i.setOnFocusChangeListener(new C27442(this));
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.EventBuyTicketTextField);
        this.f19347i.setHint(ResourceUtils.a(getContext(), obtainStyledAttributes, 0));
        this.f19347i.setHintTextColor(obtainStyledAttributes.getColor(1, this.f19347i.getCurrentTextColor()));
        obtainStyledAttributes.recycle();
    }

    public String getText() {
        return this.f19347i.getText().toString();
    }

    public void setError(@Nullable String str) {
        this.f19347i.setError(str, null);
    }

    public void setTextColorResId(int i) {
        this.f19347i.setTextColor(getResources().getColor(i));
    }

    public void setText(String str) {
        this.f19347i.setText(str);
    }

    public final void m19499a(TextWatcher textWatcher) {
        this.f19347i.addTextChangedListener(textWatcher);
    }
}
