package com.facebook.orca.threadview;

import android.content.Context;
import android.widget.TextView;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.customthreads.ThreadViewTheme.Listener;
import com.facebook.messaging.threadview.rows.RowTimestampDividerItem;
import com.facebook.messaging.util.date.MessagingDateUtil;
import com.facebook.widget.CustomViewGroup;
import javax.inject.Inject;

/* compiled from: maybeShowPromotionHeader */
public class TimestampDividerItemView extends CustomViewGroup {
    @Inject
    public MessagingDateUtil f8129a;
    public final Listener f8130b = new C12211(this);
    public final TextView f8131c;
    public RowTimestampDividerItem f8132d;
    public DefaultThreadViewTheme f8133e;

    /* compiled from: maybeShowPromotionHeader */
    class C12211 implements Listener {
        final /* synthetic */ TimestampDividerItemView f8128a;

        C12211(TimestampDividerItemView timestampDividerItemView) {
            this.f8128a = timestampDividerItemView;
        }

        public final void m8056a() {
            TimestampDividerItemView.m8057a(this.f8128a);
        }
    }

    public static void m8058a(Object obj, Context context) {
        ((TimestampDividerItemView) obj).f8129a = MessagingDateUtil.a(FbInjector.get(context));
    }

    public TimestampDividerItemView(Context context) {
        super(context);
        Class cls = TimestampDividerItemView.class;
        m8058a(this, getContext());
        setContentView(2130905724);
        this.f8131c = (TextView) getView(2131564906);
    }

    public static void m8057a(TimestampDividerItemView timestampDividerItemView) {
        timestampDividerItemView.f8131c.setTextColor(timestampDividerItemView.f8133e.d());
    }
}
