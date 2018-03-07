package com.facebook.universalfeedback.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.widget.text.BetterEditTextView;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: edit_gallery_launch_configuration */
public class UniversalFeedbackExplanationRequestView extends UniversalFeedbackPageView {
    public ExplanationListener f15373a;
    private FbButton f15374b;
    private BetterTextView f15375c;
    private String f15376d;
    private String f15377e;
    private BetterEditTextView f15378f;
    private ImageView f15379g;
    public String f15380h;

    /* compiled from: edit_gallery_launch_configuration */
    class C11561 implements OnClickListener {
        final /* synthetic */ UniversalFeedbackExplanationRequestView f15369a;

        C11561(UniversalFeedbackExplanationRequestView universalFeedbackExplanationRequestView) {
            this.f15369a = universalFeedbackExplanationRequestView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1836875590);
            if (this.f15369a.f15373a != null) {
                this.f15369a.f15373a.mo1193a(this.f15369a.f15380h);
            }
            UniversalFeedbackExplanationRequestView.m19399e(this.f15369a);
            this.f15369a.m19391b();
            Logger.a(2, EntryType.UI_INPUT_END, 157020587, a);
        }
    }

    /* compiled from: edit_gallery_launch_configuration */
    class C11572 implements OnClickListener {
        final /* synthetic */ UniversalFeedbackExplanationRequestView f15370a;

        C11572(UniversalFeedbackExplanationRequestView universalFeedbackExplanationRequestView) {
            this.f15370a = universalFeedbackExplanationRequestView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 855654570);
            UniversalFeedbackExplanationRequestView.m19399e(this.f15370a);
            this.f15370a.m19392c();
            Logger.a(2, EntryType.UI_INPUT_END, -635319637, a);
        }
    }

    /* compiled from: edit_gallery_launch_configuration */
    class C11583 implements TextWatcher {
        final /* synthetic */ UniversalFeedbackExplanationRequestView f15371a;

        C11583(UniversalFeedbackExplanationRequestView universalFeedbackExplanationRequestView) {
            this.f15371a = universalFeedbackExplanationRequestView;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.f15371a.f15380h = editable.toString();
        }
    }

    /* compiled from: edit_gallery_launch_configuration */
    public interface ExplanationListener {
        void mo1193a(String str);
    }

    public UniversalFeedbackExplanationRequestView(Context context) {
        super(context);
        m19395a(context);
    }

    public UniversalFeedbackExplanationRequestView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m19395a(context);
    }

    public UniversalFeedbackExplanationRequestView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19395a(context);
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private void m19395a(Context context) {
        Resources resources = getResources();
        View.inflate(context, 2130907593, this);
        FbButton fbButton = (FbButton) findViewById(2131568164);
        this.f15374b = (FbButton) findViewById(2131568165);
        this.f15379g = (ImageView) findViewById(2131568167);
        this.f15375c = (BetterTextView) findViewById(2131568168);
        this.f15378f = (BetterEditTextView) findViewById(2131568169);
        this.f15374b.setText(resources.getString(2131237761));
        this.f15374b.setOnClickListener(new C11561(this));
        fbButton.setText(resources.getString(2131237759));
        fbButton.setOnClickListener(new C11572(this));
        this.f15376d = resources.getString(2131237767);
        this.f15377e = resources.getString(2131237768);
    }

    public void setExplanationListener(ExplanationListener explanationListener) {
        this.f15373a = explanationListener;
    }

    public final void m19400a() {
        this.f15378f.addTextChangedListener(new C11583(this));
        setRating(0);
    }

    public void setRating(int i) {
        if (i < 3) {
            this.f15375c.setText(this.f15376d);
        } else {
            this.f15375c.setText(this.f15377e);
        }
        TypedArray obtainTypedArray = getResources().obtainTypedArray(2131755076);
        int resourceId = obtainTypedArray.getResourceId(i, 0);
        if (resourceId > 0) {
            this.f15379g.setImageResource(resourceId);
        }
        obtainTypedArray.recycle();
    }

    private void m19398d() {
        ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this.f15378f, 0);
    }

    public static void m19399e(UniversalFeedbackExplanationRequestView universalFeedbackExplanationRequestView) {
        ((InputMethodManager) universalFeedbackExplanationRequestView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(universalFeedbackExplanationRequestView.getWindowToken(), 0);
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this && i == 0) {
            this.f15378f.requestFocus();
            m19398d();
        }
    }
}
