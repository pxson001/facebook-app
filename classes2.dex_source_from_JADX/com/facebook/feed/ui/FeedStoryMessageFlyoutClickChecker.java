package com.facebook.feed.ui;

import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.facebook.fbui.widget.text.TextLayoutView;
import javax.annotation.Nullable;

/* compiled from: group_feed_owner_authored_sold_for_sale_type */
public class FeedStoryMessageFlyoutClickChecker {
    public static final ClickableSpan f21746a = new C08671();
    private final Path f21747b = new Path();
    private final Region f21748c = new Region();
    private final Path f21749d = new Path();
    private final Region f21750e = new Region();
    private final Region f21751f = new Region();

    /* compiled from: group_feed_owner_authored_sold_for_sale_type */
    final class C08671 extends ClickableSpan {
        C08671() {
        }

        public final void onClick(View view) {
        }
    }

    @Nullable
    public final ClickableSpan m29437a(View view, float f, float f2, float f3) {
        SpannableString valueOf;
        Layout layout;
        ClickableSpan clickableSpan = null;
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (textView.hasSelection()) {
                return f21746a;
            }
            if (textView.getMovementMethod() == null) {
                return null;
            }
        }
        if (view instanceof TextView) {
            TextView textView2 = (TextView) view;
            valueOf = SpannableString.valueOf(textView2.getText());
            layout = textView2.getLayout();
        } else if (!(view instanceof TextLayoutView)) {
            return null;
        } else {
            TextLayoutView textLayoutView = (TextLayoutView) view;
            valueOf = SpannableString.valueOf(textLayoutView.getText());
            layout = textLayoutView.getLayout();
        }
        if (layout == null) {
            return null;
        }
        this.f21751f.set(0, 0, layout.getWidth(), layout.getHeight());
        this.f21749d.reset();
        this.f21749d.addCircle(f, f2, f3, Direction.CW);
        this.f21750e.setPath(this.f21749d, this.f21751f);
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) valueOf.getSpans(0, valueOf.length(), ClickableSpan.class);
        int length = clickableSpanArr.length;
        int i = 0;
        while (i < length) {
            ClickableSpan clickableSpan2 = clickableSpanArr[i];
            if (!m29436a(clickableSpan2, valueOf, layout, this.f21750e, this.f21751f)) {
                clickableSpan2 = clickableSpan;
            } else if (clickableSpan != null) {
                return f21746a;
            }
            i++;
            clickableSpan = clickableSpan2;
        }
        return clickableSpan;
    }

    private boolean m29436a(ClickableSpan clickableSpan, SpannableString spannableString, Layout layout, Region region, Region region2) {
        layout.getSelectionPath(spannableString.getSpanStart(clickableSpan), spannableString.getSpanEnd(clickableSpan), this.f21747b);
        this.f21748c.setPath(this.f21747b, region2);
        return this.f21748c.op(region, Op.INTERSECT);
    }
}
