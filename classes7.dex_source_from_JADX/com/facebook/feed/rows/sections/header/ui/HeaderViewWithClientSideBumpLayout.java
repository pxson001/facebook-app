package com.facebook.feed.rows.sections.header.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.feed.rerank.ClientRerankIndicatorManager;
import com.facebook.multirow.api.ViewType;
import javax.annotation.Nullable;

/* compiled from: Underlying map has already been built */
public class HeaderViewWithClientSideBumpLayout extends HeaderViewWithTextLayout implements ClientSideIconIndicator {
    public static final ViewType f21413j = new C18011();
    private final ImageView f21414l;
    private final TextView f21415m;

    /* compiled from: Underlying map has already been built */
    final class C18011 extends ViewType {
        C18011() {
        }

        public final View m24127a(Context context) {
            return new HeaderViewWithClientSideBumpLayout(context);
        }
    }

    public HeaderViewWithClientSideBumpLayout(Context context) {
        this(context, null);
    }

    private HeaderViewWithClientSideBumpLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 2130904761);
        this.f21414l = (ImageView) getView(2131562869);
        this.f21415m = (TextView) getView(2131562870);
    }

    public final void mo1500a(String str, String str2, String str3) {
        this.f21414l.setVisibility(0);
        if (ClientRerankIndicatorManager.a(str)) {
            this.f21414l.setImageResource(2130838087);
        } else if (ClientRerankIndicatorManager.b(str)) {
            this.f21414l.setImageResource(2130838086);
        } else if (ClientRerankIndicatorManager.c(str)) {
            this.f21414l.setImageResource(2130838088);
        } else {
            this.f21414l.setVisibility(8);
        }
        if (ClientRerankIndicatorManager.d(str2)) {
            this.f21414l.setBackground(new ColorDrawable(-65536));
        } else if (ClientRerankIndicatorManager.e(str2)) {
            this.f21414l.setBackground(new ColorDrawable(-16711936));
        }
        this.f21415m.setText(str3);
    }

    public final void mo1501a(boolean z, String str, String str2) {
        this.f21414l.setImageResource(0);
        int i = -16711936;
        if (ClientRerankIndicatorManager.d(str)) {
            i = -65536;
        }
        StringBuilder append = new StringBuilder().append(str2);
        if (z) {
            append.append(" C");
        } else {
            append.append(" N");
        }
        this.f21415m.setTextColor(i);
        this.f21415m.setText(append.toString());
    }
}
