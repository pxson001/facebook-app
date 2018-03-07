package com.facebook.messaging.inbox2.recents;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.content.event.FbEvent;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.inbox2.recents.InboxRecentItemVideoView.InboxRecentItemVideoViewEnvironment;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.RichVideoPlayerPluginWithEnv;

/* compiled from: sendBatchInviteParams */
class InboxRecentItemVideoCollapseVideoPlugin extends RichVideoPlayerPluginWithEnv<InboxRecentItemVideoEnvironment> {
    public View f2878a;

    /* compiled from: sendBatchInviteParams */
    class C04701 implements OnClickListener {
        final /* synthetic */ InboxRecentItemVideoCollapseVideoPlugin f2876a;

        C04701(InboxRecentItemVideoCollapseVideoPlugin inboxRecentItemVideoCollapseVideoPlugin) {
            this.f2876a = inboxRecentItemVideoCollapseVideoPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1498924298);
            if (this.f2876a.c != null) {
                ((InboxRecentItemVideoViewEnvironment) this.f2876a.c).m2854b();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1888396704, a);
        }
    }

    /* compiled from: sendBatchInviteParams */
    class C04712 extends RichVideoPlayerEventSubscriber<InboxRecentItemVideoExpandStateChangeEvent> {
        final /* synthetic */ InboxRecentItemVideoCollapseVideoPlugin f2877a;

        C04712(InboxRecentItemVideoCollapseVideoPlugin inboxRecentItemVideoCollapseVideoPlugin) {
            this.f2877a = inboxRecentItemVideoCollapseVideoPlugin;
        }

        public final void m2839b(FbEvent fbEvent) {
            this.f2877a.f2878a.setVisibility(((InboxRecentItemVideoExpandStateChangeEvent) fbEvent).f2885a ? 0 : 8);
        }

        public final Class<InboxRecentItemVideoExpandStateChangeEvent> m2838a() {
            return InboxRecentItemVideoExpandStateChangeEvent.class;
        }
    }

    public InboxRecentItemVideoCollapseVideoPlugin(Context context) {
        super(context);
        m2843d();
    }

    public InboxRecentItemVideoCollapseVideoPlugin(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2843d();
    }

    public InboxRecentItemVideoCollapseVideoPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2843d();
    }

    private void m2843d() {
        setContentView(2130904883);
        this.f2878a = a(2131563112);
        this.f2878a.setOnClickListener(new C04701(this));
        this.f2878a.setVisibility(8);
        this.f.add(new C04712(this));
    }
}
