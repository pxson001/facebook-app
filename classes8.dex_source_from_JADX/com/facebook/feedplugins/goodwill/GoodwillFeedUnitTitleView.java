package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.util.SizeUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: graph_search_query */
public class GoodwillFeedUnitTitleView extends CustomLinearLayout {
    public static final ViewType f12301a = new C13031();
    @Inject
    public GlyphColorizer f12302b;
    private final int f12303c;
    private final int f12304d;
    private final int f12305e;
    private final TextView f12306f = ((TextView) a(2131562582));
    private final TextView f12307g = ((TextView) a(2131562583));
    private final TextView f12308h = ((TextView) a(2131562584));

    /* compiled from: graph_search_query */
    final class C13031 extends ViewType {
        C13031() {
        }

        public final View m14259a(Context context) {
            return new GoodwillFeedUnitTitleView(context);
        }
    }

    public static void m14260a(Object obj, Context context) {
        ((GoodwillFeedUnitTitleView) obj).f12302b = GlyphColorizer.a(FbInjector.get(context));
    }

    public GoodwillFeedUnitTitleView(Context context) {
        super(context);
        Class cls = GoodwillFeedUnitTitleView.class;
        m14260a(this, getContext());
        setContentView(2130904611);
        int c = SizeUtil.c(context.getResources(), 2131427400);
        this.f12304d = c;
        this.f12305e = c;
        this.f12303c = SizeUtil.c(context.getResources(), 2131427404);
        setOrientation(1);
    }

    public void setTitle(String str) {
        this.f12306f.setText(str);
        this.f12306f.setTextSize((float) this.f12303c);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f12307g.setText(charSequence);
        this.f12307g.setTextSize((float) this.f12304d);
    }

    public void setPrivacyNotice(String str) {
        this.f12308h.setText(str);
        this.f12308h.setTextSize((float) this.f12305e);
    }

    public void setPrivacyIcon(int i) {
        this.f12308h.setCompoundDrawablesWithIntrinsicBounds(this.f12302b.a(i, -7235677), null, null, null);
    }
}
