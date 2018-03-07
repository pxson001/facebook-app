package com.facebook.messaging.inbox2.morefooter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

/* compiled from: send_report */
public class InboxMoreItemView extends CustomFrameLayout {
    private View f2846a;
    private ImageView f2847b;
    private TextView f2848c;
    private ProgressBar f2849d;

    public InboxMoreItemView(Context context) {
        super(context);
        m2804a();
    }

    public InboxMoreItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m2804a();
    }

    public InboxMoreItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2804a();
    }

    private void m2804a() {
        setContentView(2130904867);
        this.f2846a = c(2131563091);
        this.f2847b = (ImageView) c(2131563092);
        this.f2848c = (TextView) c(2131563093);
        this.f2849d = (ProgressBar) c(2131563094);
    }

    public void setMoreItem(InboxMoreItem inboxMoreItem) {
        switch (inboxMoreItem.mo82m()) {
            case INVISIBLE:
                this.f2846a.setVisibility(4);
                this.f2849d.setVisibility(8);
                break;
            case LOADING:
                this.f2846a.setVisibility(4);
                this.f2849d.setVisibility(0);
                break;
            case LOAD_MORE:
                this.f2846a.setVisibility(0);
                this.f2849d.setVisibility(8);
                break;
        }
        this.f2847b.setImageResource(inboxMoreItem.mo84o());
        this.f2848c.setText(inboxMoreItem.mo83n());
    }
}
