package com.facebook.feed.rows.sections.text;

import android.content.Intent;
import android.view.View;
import com.facebook.common.util.StringUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.ui.clickwithpositionlistener.ClickWithPositionListener;
import javax.inject.Inject;

/* compiled from: UNFOCUSED */
public class InstantArticleClickWithPositionListener implements ClickWithPositionListener {
    private final SecureContextHelper f21573a;
    public String f21574b;
    public String f21575c;

    @Inject
    public InstantArticleClickWithPositionListener(SecureContextHelper secureContextHelper) {
        this.f21573a = secureContextHelper;
    }

    public final void m24203a(View view, float f, float f2) {
        if (!StringUtil.a(this.f21574b)) {
            Intent intent = new Intent();
            intent.putExtra("extra_instant_articles_id", this.f21574b);
            if (this.f21575c != null) {
                intent.putExtra("extra_instant_articles_referrer", this.f21575c);
            }
            this.f21573a.b(intent, view.getContext());
        }
    }
}
