package com.facebook.feed.rows.sections.header.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.feed.rerank.ClientRerankIndicatorManager;
import com.facebook.multirow.api.ViewType;

/* compiled from: Uncaught sync exception on %s queue!!! - %s */
public class TextWithClientRankingBumpAndMenuButtonView extends TextWithMenuButtonView implements ClientSideIconIndicator {
    public static final ViewType f21419a = new C18031();
    private final ImageView f21420c = ((ImageView) a(2131560877));
    private final ImageView f21421d = ((ImageView) a(2131562869));
    private final TextView f21422e = ((TextView) a(2131562870));

    /* compiled from: Uncaught sync exception on %s queue!!! - %s */
    final class C18031 extends ViewType {
        C18031() {
        }

        public final View m24131a(Context context) {
            return new TextWithClientRankingBumpAndMenuButtonView(context);
        }
    }

    public TextWithClientRankingBumpAndMenuButtonView(Context context) {
        super(context, 2130907380);
    }

    public void setMenuButtonActive(boolean z) {
        this.f21420c.setVisibility(z ? 0 : 8);
    }

    public final void mo1500a(String str, String str2, String str3) {
        this.f21421d.setVisibility(0);
        if (ClientRerankIndicatorManager.a(str)) {
            this.f21421d.setImageResource(2130838087);
        } else if (ClientRerankIndicatorManager.b(str)) {
            this.f21421d.setImageResource(2130838086);
        } else if (ClientRerankIndicatorManager.c(str)) {
            this.f21421d.setImageResource(2130838088);
        } else {
            this.f21421d.setVisibility(8);
        }
        if (ClientRerankIndicatorManager.d(str2)) {
            this.f21421d.setBackground(new ColorDrawable(-65536));
        } else if (ClientRerankIndicatorManager.e(str2)) {
            this.f21421d.setBackground(new ColorDrawable(-16711936));
        }
        this.f21422e.setText(str3);
    }

    public final void mo1501a(boolean z, String str, String str2) {
        this.f21421d.setImageResource(0);
        StringBuilder append = new StringBuilder().append(str2);
        int i = -16711936;
        if (ClientRerankIndicatorManager.d(str)) {
            i = -65536;
        }
        if (z) {
            append.append(" C");
        } else {
            append.append(" N");
        }
        this.f21422e.setTextColor(i);
        this.f21422e.setText(append.toString());
    }
}
