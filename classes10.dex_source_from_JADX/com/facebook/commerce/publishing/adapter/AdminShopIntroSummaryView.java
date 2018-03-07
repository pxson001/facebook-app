package com.facebook.commerce.publishing.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.commerce.publishing.util.AdminShopTextUtil;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterEditTextView;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

/* compiled from: data_savings_mode_settings/?source=bar */
public class AdminShopIntroSummaryView extends CustomLinearLayout {
    @Inject
    public AdminShopTextUtil f15486a;
    private GlyphView f15487b;
    private BetterEditTextView f15488c;
    private BetterTextView f15489d;
    public IntroSummaryTextChangedListener f15490e;
    private final OnClickListener f15491f;
    private final TextWatcher f15492g;

    /* compiled from: data_savings_mode_settings/?source=bar */
    public interface IntroSummaryTextChangedListener {
        void mo759a(String str);
    }

    /* compiled from: data_savings_mode_settings/?source=bar */
    class C21361 implements OnClickListener {
        final /* synthetic */ AdminShopIntroSummaryView f15484a;

        C21361(AdminShopIntroSummaryView adminShopIntroSummaryView) {
            this.f15484a = adminShopIntroSummaryView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2138070989);
            new Builder(this.f15484a.getContext()).b(2131239298).b();
            Logger.a(2, EntryType.UI_INPUT_END, -820043259, a);
        }
    }

    /* compiled from: data_savings_mode_settings/?source=bar */
    class C21372 implements TextWatcher {
        final /* synthetic */ AdminShopIntroSummaryView f15485a;

        C21372(AdminShopIntroSummaryView adminShopIntroSummaryView) {
            this.f15485a = adminShopIntroSummaryView;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            AdminShopIntroSummaryView.m16011c(this.f15485a, editable.length());
            if (this.f15485a.f15490e != null) {
                this.f15485a.f15490e.mo759a(editable.toString());
            }
        }
    }

    private static <T extends View> void m16009a(Class<T> cls, T t) {
        m16010a((Object) t, t.getContext());
    }

    private static void m16010a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((AdminShopIntroSummaryView) obj).f15486a = new AdminShopTextUtil(GlyphColorizer.a(fbInjector), ResourcesMethodAutoProvider.a(fbInjector));
    }

    public AdminShopIntroSummaryView(Context context) {
        this(context, null);
    }

    public AdminShopIntroSummaryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected AdminShopIntroSummaryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15491f = new C21361(this);
        this.f15492g = new C21372(this);
        m16009a(AdminShopIntroSummaryView.class, (View) this);
        setContentView(2130903190);
        setOrientation(1);
        this.f15487b = (GlyphView) a(2131559442);
        this.f15488c = (BetterEditTextView) a(2131559443);
        this.f15489d = (BetterTextView) a(2131559444);
        this.f15488c.addTextChangedListener(this.f15492g);
        this.f15487b.setOnClickListener(this.f15491f);
    }

    private void m16008a(AdminShopTextUtil adminShopTextUtil) {
        this.f15486a = adminShopTextUtil;
    }

    public final void m16012a(String str) {
        this.f15488c.setHint(getContext().getResources().getString(2131239290, new Object[]{str}));
    }

    public final void m16013b(String str) {
        this.f15488c.setText(str);
    }

    public void setIntroSummaryTextChangedListener(IntroSummaryTextChangedListener introSummaryTextChangedListener) {
        this.f15490e = introSummaryTextChangedListener;
    }

    public static void m16011c(AdminShopIntroSummaryView adminShopIntroSummaryView, int i) {
        int integer = adminShopIntroSummaryView.getResources().getInteger(2131492950);
        adminShopIntroSummaryView.f15489d.setText(StringFormatUtil.a("%d/%d", new Object[]{Integer.valueOf(i), Integer.valueOf(integer)}));
        adminShopIntroSummaryView.f15489d.setVisibility(i > 0 ? 0 : 4);
    }
}
