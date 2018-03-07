package com.facebook.crowdsourcing.suggestedits.view;

import android.content.Context;
import android.net.Uri;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: clearable/ */
public class SuggestEditsPageHeaderView extends CustomLinearLayout {
    private static final CallerContext f17718a = CallerContext.a(SuggestEditsPageHeaderView.class);
    private GlyphView f17719b;
    private TextView f17720c;
    public TextView f17721d;
    private View f17722e;
    public EditText f17723f;
    private FbDraweeView f17724g;
    private FrameLayout f17725h;
    private CompositeOnFocusChangeListener f17726i;
    private TextWatcher f17727j;

    /* compiled from: clearable/ */
    class C14851 implements OnClickListener {
        final /* synthetic */ SuggestEditsPageHeaderView f17715a;

        C14851(SuggestEditsPageHeaderView suggestEditsPageHeaderView) {
            this.f17715a = suggestEditsPageHeaderView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 928619943);
            this.f17715a.f17723f.requestFocus();
            Logger.a(2, EntryType.UI_INPUT_END, -1162082931, a);
        }
    }

    /* compiled from: clearable/ */
    class C14862 implements OnFocusChangeListener {
        final /* synthetic */ SuggestEditsPageHeaderView f17716a;

        C14862(SuggestEditsPageHeaderView suggestEditsPageHeaderView) {
            this.f17716a = suggestEditsPageHeaderView;
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                this.f17716a.f17721d.setVisibility(8);
                SuggestEditsPageHeaderView.m21585e(this.f17716a);
                this.f17716a.f17723f.setSingleLine(true);
                this.f17716a.f17723f.setSelection(this.f17716a.f17723f.getText().length());
                this.f17716a.m21583d();
                KeyboardUtils.b(this.f17716a.getContext(), view);
                return;
            }
            this.f17716a.f17721d.setVisibility(0);
            SuggestEditsPageHeaderView.m21585e(this.f17716a);
            this.f17716a.f17723f.setSingleLine(false);
            this.f17716a.f17723f.setMaxLines(3);
            this.f17716a.m21583d();
            KeyboardUtils.a(this.f17716a.getContext(), view);
        }
    }

    /* compiled from: clearable/ */
    class CompositeOnFocusChangeListener implements OnFocusChangeListener {
        private final List<OnFocusChangeListener> f17717a;

        public CompositeOnFocusChangeListener() {
            this.f17717a = Lists.a();
        }

        public final void m21578a(OnFocusChangeListener onFocusChangeListener) {
            this.f17717a.add(onFocusChangeListener);
        }

        public final void m21577a() {
            this.f17717a.clear();
        }

        public void onFocusChange(View view, boolean z) {
            for (OnFocusChangeListener onFocusChange : this.f17717a) {
                onFocusChange.onFocusChange(view, z);
            }
        }
    }

    public SuggestEditsPageHeaderView(Context context) {
        super(context);
        m21581c();
    }

    public SuggestEditsPageHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21581c();
    }

    public SuggestEditsPageHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21581c();
    }

    private void m21581c() {
        setContentView(2130907297);
        this.f17719b = (GlyphView) a(2131567746);
        this.f17720c = (TextView) a(2131567743);
        this.f17721d = (TextView) a(2131567749);
        this.f17722e = a(2131567748);
        this.f17723f = (EditText) a(2131567747);
        this.f17724g = (FbDraweeView) a(2131567744);
        this.f17725h = (FrameLayout) a(2131567745);
        this.f17726i = new CompositeOnFocusChangeListener();
        this.f17723f.setOnFocusChangeListener(this.f17726i);
    }

    public final void m21587a(@Nullable Spanned spanned, OnClickListener onClickListener) {
        if (spanned == null) {
            this.f17720c.setVisibility(8);
            return;
        }
        this.f17720c.setText(spanned);
        this.f17720c.setVisibility(0);
        this.f17720c.setOnClickListener(onClickListener);
    }

    public void setAddPhotoImageResource(int i) {
        this.f17719b.setImageResource(i);
    }

    public String getPageName() {
        return this.f17723f.getText().toString();
    }

    public void setPageName(@Nullable String str) {
        this.f17723f.setText(Strings.nullToEmpty(str));
    }

    public void setPageNameEditable(boolean z) {
        this.f17721d.setVisibility(z ? 0 : 8);
        if (z) {
            this.f17723f.setFocusableInTouchMode(true);
            this.f17722e.requestFocus();
            this.f17721d.setOnClickListener(new C14851(this));
            m21589a(new C14862(this));
            return;
        }
        this.f17723f.setFocusable(false);
    }

    public void setPhoto(@Nullable String str) {
        this.f17724g.a(str == null ? null : Uri.parse(str), f17718a);
    }

    public void setPhotoEditable(boolean z) {
        this.f17719b.setVisibility(z ? 0 : 8);
    }

    public void setPhotoGradientVisibility(int i) {
        this.f17725h.setVisibility(i);
    }

    public void setCameraButtonOnClickListener(OnClickListener onClickListener) {
        this.f17719b.setOnClickListener(onClickListener);
    }

    public final void m21589a(OnFocusChangeListener onFocusChangeListener) {
        this.f17726i.m21578a(onFocusChangeListener);
    }

    public final void m21588a(TextWatcher textWatcher) {
        this.f17727j = textWatcher;
        m21583d();
    }

    public final void m21586a() {
        m21585e(this);
        this.f17727j = null;
    }

    private void m21583d() {
        if (this.f17727j != null) {
            this.f17723f.addTextChangedListener(this.f17727j);
        }
    }

    public static void m21585e(SuggestEditsPageHeaderView suggestEditsPageHeaderView) {
        if (suggestEditsPageHeaderView.f17727j != null) {
            suggestEditsPageHeaderView.f17723f.removeTextChangedListener(suggestEditsPageHeaderView.f17727j);
        }
    }

    public final void m21590b() {
        this.f17726i.m21577a();
    }
}
