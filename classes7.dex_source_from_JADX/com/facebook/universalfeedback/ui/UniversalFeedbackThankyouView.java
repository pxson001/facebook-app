package com.facebook.universalfeedback.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: edit_gallery_bitmap_height */
public class UniversalFeedbackThankyouView extends UniversalFeedbackPageView {

    /* compiled from: edit_gallery_bitmap_height */
    class C11631 implements OnClickListener {
        final /* synthetic */ UniversalFeedbackThankyouView f15392a;

        C11631(UniversalFeedbackThankyouView universalFeedbackThankyouView) {
            this.f15392a = universalFeedbackThankyouView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2125770911);
            this.f15392a.m19391b();
            Logger.a(2, EntryType.UI_INPUT_END, 911060388, a);
        }
    }

    public UniversalFeedbackThankyouView(Context context) {
        super(context);
        m19419a(context);
    }

    public UniversalFeedbackThankyouView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m19419a(context);
    }

    public UniversalFeedbackThankyouView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19419a(context);
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private void m19419a(Context context) {
        Resources resources = getResources();
        View.inflate(context, 2130907595, this);
        FbButton fbButton = (FbButton) findViewById(2131568164);
        FbButton fbButton2 = (FbButton) findViewById(2131568165);
        fbButton2.setText(resources.getString(2131237760));
        fbButton2.setOnClickListener(new C11631(this));
        fbButton.setVisibility(8);
    }

    protected void onMeasure(int i, int i2) {
        BetterTextView betterTextView = (BetterTextView) findViewById(2131568171);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            betterTextView.setMaxWidth((int) (((float) displayMetrics.widthPixels) * 0.5f));
        } else {
            betterTextView.setMaxWidth((int) (((float) displayMetrics.widthPixels) * 0.7f));
        }
        super.onMeasure(i, i2);
    }
}
