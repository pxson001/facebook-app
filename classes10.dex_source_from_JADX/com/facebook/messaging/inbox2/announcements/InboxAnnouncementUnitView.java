package com.facebook.messaging.inbox2.announcements;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.orca.threadlist.ThreadListAdapter.AnonymousClass11;
import com.facebook.orca.threadlist.ThreadListFragment.AnonymousClass18;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: set_photo */
public class InboxAnnouncementUnitView extends CustomLinearLayout {
    private static final CallerContext f2668a = CallerContext.a(InboxAnnouncementUnitView.class);
    private FbDraweeView f2669b;
    private TextView f2670c;
    private TextView f2671d;
    private TextView f2672e;
    @Nullable
    public AnonymousClass11 f2673f;

    /* compiled from: set_photo */
    class C04421 implements OnClickListener {
        final /* synthetic */ InboxAnnouncementUnitView f2667a;

        C04421(InboxAnnouncementUnitView inboxAnnouncementUnitView) {
            this.f2667a = inboxAnnouncementUnitView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1186319120);
            if (this.f2667a.f2673f != null) {
                AnonymousClass11 anonymousClass11 = this.f2667a.f2673f;
                AnonymousClass18 anonymousClass18 = anonymousClass11.f6544b.f6573j;
                anonymousClass18.f6606a.bA.m2718a(anonymousClass11.f6543a.f2666f.f2661a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1404436341, a);
        }
    }

    public InboxAnnouncementUnitView(Context context) {
        super(context);
        m2636a();
    }

    public InboxAnnouncementUnitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2636a();
    }

    public InboxAnnouncementUnitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2636a();
    }

    private void m2636a() {
        setContentView(2130904855);
        this.f2669b = (FbDraweeView) a(2131563081);
        this.f2670c = (TextView) a(2131563082);
        this.f2671d = (TextView) a(2131563083);
        this.f2672e = (TextView) a(2131563084);
        this.f2672e.setOnClickListener(new C04421(this));
    }

    public void setData(InboxAnnouncementData inboxAnnouncementData) {
        this.f2669b.a(inboxAnnouncementData.f2665e == null ? null : Uri.parse(inboxAnnouncementData.f2665e), f2668a);
        this.f2670c.setText(inboxAnnouncementData.f2662b);
        this.f2671d.setText(inboxAnnouncementData.f2663c);
        this.f2672e.setText(inboxAnnouncementData.f2664d);
    }
}
