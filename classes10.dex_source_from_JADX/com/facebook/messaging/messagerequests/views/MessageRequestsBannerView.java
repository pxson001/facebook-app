package com.facebook.messaging.messagerequests.views;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;
import com.facebook.fbui.badges.BadgeIconView;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.messagerequests.experiment.MessageRequestsExperimentController;
import com.facebook.messaging.messagerequests.snippet.MessageRequestsSnippet;
import com.facebook.messaging.messagerequests.snippet.MessageRequestsSnippetDisplayUtil;
import com.facebook.messaging.ui.threaditem.ThreadItemDividerDrawer;
import com.facebook.messaging.util.BadgeCountUtil;
import com.facebook.widget.CustomRelativeLayout;
import javax.inject.Inject;

/* compiled from: save_nux_seen_count */
public class MessageRequestsBannerView extends CustomRelativeLayout {
    @Inject
    public BadgeCountUtil f3274a;
    @Inject
    public MessageRequestsSnippetDisplayUtil f3275b;
    @Inject
    public MessageRequestsExperimentController f3276c;
    @Inject
    public ThreadItemDividerDrawer f3277d;
    public BadgeIconView f3278e;
    public TextView f3279f;

    public static void m3199a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        MessageRequestsBannerView messageRequestsBannerView = (MessageRequestsBannerView) obj;
        BadgeCountUtil b = BadgeCountUtil.b(fbInjector);
        MessageRequestsSnippetDisplayUtil messageRequestsSnippetDisplayUtil = new MessageRequestsSnippetDisplayUtil((Context) fbInjector.getInstance(Context.class));
        MessageRequestsExperimentController b2 = MessageRequestsExperimentController.m3149b(fbInjector);
        ThreadItemDividerDrawer a = ThreadItemDividerDrawer.m4412a(fbInjector);
        messageRequestsBannerView.f3274a = b;
        messageRequestsBannerView.f3275b = messageRequestsSnippetDisplayUtil;
        messageRequestsBannerView.f3276c = b2;
        messageRequestsBannerView.f3277d = a;
    }

    public MessageRequestsBannerView(Context context) {
        super(context, null, 2130773031);
        Class cls = MessageRequestsBannerView.class;
        m3199a((Object) this, getContext());
        setContentView(2130905763);
        this.f3277d.m4413a(context, null, 2130773031);
        setWillNotDraw(!this.f3277d.m4415a());
        this.f3278e = (BadgeIconView) a(2131564942);
        this.f3279f = (TextView) a(2131564944);
    }

    public final void m3201a(MessageRequestsSnippet messageRequestsSnippet) {
        this.f3278e.setBadgeText(this.f3274a.a(messageRequestsSnippet.f3257a));
        m3200a(messageRequestsSnippet.f3258b, messageRequestsSnippet.f3257a);
    }

    private void m3200a(String str, int i) {
        TextView textView = this.f3279f;
        if (str == null) {
            str = this.f3275b.f3259a.getResources().getQuantityString(2131689498, i, new Object[]{Integer.valueOf(i)});
        }
        textView.setText(str);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f3277d.m4414a(canvas, getWidth(), getHeight());
    }
}
