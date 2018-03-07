package com.facebook.timeline.header.menus;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnCancelListener;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.profile.TimelineFriendParams;
import com.facebook.timeline.event.TimelineFriendingEvents.CancelFriendRequestClickedEvent;
import com.facebook.timeline.event.TimelineFriendingEvents.SubscribeStatusChangeClickedEvent;
import com.facebook.timeline.event.TimelineFriendingEvents.SubscribeStatusChangedEvent;
import com.facebook.timeline.event.TimelineFriendingEvents.SubscribeStatusChangedEventSubscriber;
import com.facebook.timeline.event.TimelineFriendingEvents.UnfriendClickedEvent;
import com.facebook.timeline.event.TimelineHeaderEventBus;
import javax.inject.Inject;

/* compiled from: fetch_expiration_information */
public class TimelineFriendPopoverHelper {
    public final Context f11863a;
    public final IFeedIntentBuilder f11864b;
    public final TimelineHeaderEventBus f11865c;
    private final SecureContextHelper f11866d;
    public final Activity f11867e;
    public final OnDismissListener f11868f = new C16931(this);
    public final OnCancelListener f11869g = new C16942(this);
    public TimelineFriendParams f11870h;
    public PopoverMenuWindow f11871i;
    public MenuItem f11872j;
    public FbEventSubscriberListManager f11873k;

    /* compiled from: fetch_expiration_information */
    class C16931 implements OnDismissListener {
        final /* synthetic */ TimelineFriendPopoverHelper f11855a;

        C16931(TimelineFriendPopoverHelper timelineFriendPopoverHelper) {
            this.f11855a = timelineFriendPopoverHelper;
        }

        public final boolean m11945a(PopoverWindow popoverWindow) {
            TimelineFriendPopoverHelper.m11948b(this.f11855a);
            return false;
        }
    }

    /* compiled from: fetch_expiration_information */
    class C16942 implements OnCancelListener {
        final /* synthetic */ TimelineFriendPopoverHelper f11856a;

        C16942(TimelineFriendPopoverHelper timelineFriendPopoverHelper) {
            this.f11856a = timelineFriendPopoverHelper;
        }

        public final boolean m11946a() {
            TimelineFriendPopoverHelper.m11948b(this.f11856a);
            return false;
        }
    }

    /* compiled from: fetch_expiration_information */
    public class C16953 implements OnMenuItemClickListener {
        final /* synthetic */ TimelineFriendPopoverHelper f11857a;

        public C16953(TimelineFriendPopoverHelper timelineFriendPopoverHelper) {
            this.f11857a = timelineFriendPopoverHelper;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f11857a.f11865c.a(new SubscribeStatusChangeClickedEvent(this.f11857a.f11863a.getString(2131234903).equals(menuItem.getTitle()), false));
            TimelineFriendPopoverHelper.m11949e(this.f11857a);
            return true;
        }
    }

    /* compiled from: fetch_expiration_information */
    public class C16964 implements OnMenuItemClickListener {
        final /* synthetic */ TimelineFriendPopoverHelper f11858a;

        public C16964(TimelineFriendPopoverHelper timelineFriendPopoverHelper) {
            this.f11858a = timelineFriendPopoverHelper;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            TimelineFriendPopoverHelper timelineFriendPopoverHelper = this.f11858a;
            new Builder(timelineFriendPopoverHelper.f11863a).b(StringLocaleUtil.a(timelineFriendPopoverHelper.f11863a.getString(2131233233), new Object[]{timelineFriendPopoverHelper.f11870h.c})).a(2131230729, new C17008(timelineFriendPopoverHelper)).b(2131230727, null).b();
            return true;
        }
    }

    /* compiled from: fetch_expiration_information */
    public class C16975 implements OnMenuItemClickListener {
        final /* synthetic */ TimelineFriendPopoverHelper f11859a;

        public C16975(TimelineFriendPopoverHelper timelineFriendPopoverHelper) {
            this.f11859a = timelineFriendPopoverHelper;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            TimelineFriendPopoverHelper timelineFriendPopoverHelper = this.f11859a;
            timelineFriendPopoverHelper.f11865c.a(new CancelFriendRequestClickedEvent(timelineFriendPopoverHelper.f11870h.a));
            timelineFriendPopoverHelper.f11871i.l();
            return true;
        }
    }

    /* compiled from: fetch_expiration_information */
    public class C16986 implements OnMenuItemClickListener {
        final /* synthetic */ TimelineFriendPopoverHelper f11860a;

        public C16986(TimelineFriendPopoverHelper timelineFriendPopoverHelper) {
            this.f11860a = timelineFriendPopoverHelper;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f11860a.f11864b.a(this.f11860a.f11863a, StringFormatUtil.formatStrLocaleSafe(FBLinks.bh, Long.valueOf(this.f11860a.f11870h.a)));
            return true;
        }
    }

    /* compiled from: fetch_expiration_information */
    public class C16997 extends SubscribeStatusChangedEventSubscriber {
        final /* synthetic */ TimelineFriendPopoverHelper f11861a;

        public C16997(TimelineFriendPopoverHelper timelineFriendPopoverHelper) {
            this.f11861a = timelineFriendPopoverHelper;
        }

        public final void m11947b(FbEvent fbEvent) {
            SubscribeStatusChangedEvent subscribeStatusChangedEvent = (SubscribeStatusChangedEvent) fbEvent;
            TimelineFriendPopoverHelper timelineFriendPopoverHelper = this.f11861a;
            TimelineFriendParams timelineFriendParams = subscribeStatusChangedEvent.a;
            if (timelineFriendPopoverHelper.f11871i.r) {
                timelineFriendPopoverHelper.f11870h = timelineFriendParams;
                TimelineFriendPopoverHelper.m11949e(timelineFriendPopoverHelper);
            }
        }
    }

    /* compiled from: fetch_expiration_information */
    public class C17008 implements OnClickListener {
        final /* synthetic */ TimelineFriendPopoverHelper f11862a;

        public C17008(TimelineFriendPopoverHelper timelineFriendPopoverHelper) {
            this.f11862a = timelineFriendPopoverHelper;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f11862a.f11871i.l();
            this.f11862a.f11865c.a(new UnfriendClickedEvent(this.f11862a.f11870h.a));
        }
    }

    @Inject
    public TimelineFriendPopoverHelper(Context context, IFeedIntentBuilder iFeedIntentBuilder, TimelineHeaderEventBus timelineHeaderEventBus, SecureContextHelper secureContextHelper, Activity activity) {
        this.f11863a = context;
        this.f11864b = iFeedIntentBuilder;
        this.f11866d = secureContextHelper;
        this.f11865c = timelineHeaderEventBus;
        this.f11867e = activity;
    }

    public static void m11948b(TimelineFriendPopoverHelper timelineFriendPopoverHelper) {
        timelineFriendPopoverHelper.f11873k.b(timelineFriendPopoverHelper.f11865c);
    }

    public static void m11949e(TimelineFriendPopoverHelper timelineFriendPopoverHelper) {
        Object obj;
        int i;
        if (timelineFriendPopoverHelper.f11870h.d == GraphQLSubscribeStatus.IS_SUBSCRIBED) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            i = 2131234904;
        } else {
            i = 2131234903;
        }
        timelineFriendPopoverHelper.f11872j.setTitle(i);
    }
}
