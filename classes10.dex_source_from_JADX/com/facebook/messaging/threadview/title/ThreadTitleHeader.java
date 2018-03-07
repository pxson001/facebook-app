package com.facebook.messaging.threadview.title;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.ui.name.MessengerThreadNameViewData;
import com.facebook.messaging.ui.name.ThreadNameView;
import com.facebook.messaging.users.CanonicalThreadPresenceHelper;
import com.facebook.messaging.users.CanonicalThreadPresenceHelper.Listener;
import com.facebook.presence.Availability;
import com.facebook.presence.PresenceState;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: platform_share_failed_publish */
public class ThreadTitleHeader extends CustomFrameLayout {
    @Inject
    public CanonicalThreadPresenceHelper f4785a;
    public final ImageView f4786b;
    private final ThreadNameView f4787c;
    public PresenceState f4788d;

    /* compiled from: platform_share_failed_publish */
    class C06561 extends Listener {
        final /* synthetic */ ThreadTitleHeader f4784a;

        C06561(ThreadTitleHeader threadTitleHeader) {
            this.f4784a = threadTitleHeader;
        }

        public final void m4343a(PresenceState presenceState) {
            ThreadTitleHeader.m4344a(this.f4784a, presenceState);
        }
    }

    public static void m4345a(Object obj, Context context) {
        ((ThreadTitleHeader) obj).f4785a = CanonicalThreadPresenceHelper.b(FbInjector.get(context));
    }

    public ThreadTitleHeader(Context context) {
        this(context, null);
    }

    private ThreadTitleHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private ThreadTitleHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4788d = PresenceState.a;
        Class cls = ThreadTitleHeader.class;
        m4345a((Object) this, getContext());
        setContentView(2130905888);
        this.f4787c = (ThreadNameView) c(2131565210);
        this.f4786b = (ImageView) c(2131565209);
        this.f4785a.s = new C06561(this);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1662347081);
        super.onAttachedToWindow();
        this.f4785a.a(true);
        m4346b(this.f4785a.r);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1130559021, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1782583927);
        super.onDetachedFromWindow();
        this.f4785a.a(false);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1174276829, a);
    }

    public void setThreadNameViewData(MessengerThreadNameViewData messengerThreadNameViewData) {
        this.f4787c.setData(messengerThreadNameViewData);
        this.f4785a.a(messengerThreadNameViewData);
        m4346b(this.f4785a.r);
        setContentDescription(this.f4787c.getContentDescription());
    }

    public static void m4344a(ThreadTitleHeader threadTitleHeader, PresenceState presenceState) {
        if (threadTitleHeader.f4788d != presenceState) {
            threadTitleHeader.m4346b(presenceState);
        }
    }

    private void m4346b(PresenceState presenceState) {
        this.f4788d = presenceState;
        if (this.f4788d.b == Availability.AVAILABLE) {
            this.f4786b.setImageResource(2130842237);
            this.f4786b.setVisibility(0);
        } else if (this.f4788d.c) {
            this.f4786b.setImageResource(2130842122);
            this.f4786b.setVisibility(0);
        } else {
            this.f4786b.setVisibility(8);
        }
    }
}
