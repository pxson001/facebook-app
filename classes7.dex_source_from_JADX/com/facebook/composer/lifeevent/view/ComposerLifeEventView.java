package com.facebook.composer.lifeevent.view;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.contentview.ContentView.LayoutParams;
import com.facebook.fbui.widget.contentview.ContentView.LayoutParams.UseViewAs;
import com.facebook.resources.ui.FbEditText;

/* compiled from: context_item_type */
public class ComposerLifeEventView extends ContentView implements ComposerLifeEventEditor {
    private FbEditText f16812h;

    public ComposerLifeEventView(Context context) {
        super(context);
        m20813f();
    }

    public ComposerLifeEventView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20813f();
    }

    public ComposerLifeEventView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20813f();
    }

    private void m20813f() {
        this.f16812h = new FbEditText(getContext());
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.e = UseViewAs.TITLE;
        addView(this.f16812h, 0, layoutParams);
        setThumbnailGravity(17);
        setPadding(getContext().getResources().getDimensionPixelSize(2131429331), 0, 0, 0);
        setGravity(17);
    }

    public final void hr_() {
        this.f16812h.requestFocus();
        this.f16812h.setSelection(this.f16812h.getText().length());
    }

    public void setIsTitleEditable(boolean z) {
        this.f16812h.setEnabled(z);
    }

    public final boolean hs_() {
        return this.f16812h.isEnabled();
    }

    public void setTitle(String str) {
        setTitleText(str);
    }

    public final void mo1293a(TextWatcher textWatcher) {
        this.f16812h.addTextChangedListener(textWatcher);
    }

    public void setIconUri(String str) {
        setThumbnailUri(str);
    }

    public void setIconSize(int i) {
        setThumbnailSize(i);
    }
}
