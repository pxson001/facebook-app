package com.facebook.events.invite;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.events.prefs.EventsPrefKeys;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.inject.FbInjector;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.SwitchCompat;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: checkoutParams */
public class EventsInviteFriendsFooterView extends CustomLinearLayout {
    @Inject
    InterstitialManager f17690a;
    @Inject
    TipSeenTracker f17691b;
    @Inject
    @IsWorkBuild
    Boolean f17692c;
    private SwitchCompat f17693d;
    private Context f17694e;
    private Tooltip f17695f;
    private boolean f17696g;

    private static <T extends View> void m18019a(Class<T> cls, T t) {
        m18020a((Object) t, t.getContext());
    }

    private static void m18020a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventsInviteFriendsFooterView) obj).m18018a(InterstitialManager.a(fbInjector), TipSeenTracker.b(fbInjector), Boolean_IsWorkBuildMethodAutoProvider.a(fbInjector));
    }

    public EventsInviteFriendsFooterView(Context context) {
        super(context);
        m18017a(context);
    }

    public EventsInviteFriendsFooterView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m18017a(context);
    }

    protected EventsInviteFriendsFooterView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18017a(context);
    }

    private void m18017a(Context context) {
        m18019a(EventsInviteFriendsFooterView.class, (View) this);
        setContentView(2130904044);
        this.f17694e = context;
        this.f17693d = (SwitchCompat) a(2131561314);
        if (this.f17692c.booleanValue()) {
            FbTextView fbTextView = (FbTextView) a(2131561313);
            ((GlyphView) a(2131561312)).setImageResource(2130839692);
            fbTextView.setText(2131237246);
        }
    }

    private void m18018a(InterstitialManager interstitialManager, TipSeenTracker tipSeenTracker, Boolean bool) {
        this.f17690a = interstitialManager;
        this.f17691b = tipSeenTracker;
        this.f17692c = bool;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2073855990);
        super.onAttachedToWindow();
        this.f17691b.a(EventsPrefKeys.f19011e);
        this.f17691b.b = 2;
        if (this.f17691b.c() && m18021c() && !this.f17696g && getVisibility() == 0) {
            this.f17695f = new Tooltip(this.f17694e, 2);
            this.f17695f.b(getResources().getString(2131237244));
            this.f17695f.t = -1;
            this.f17695f.f(this);
            this.f17696g = true;
            this.f17691b.a();
            this.f17690a.a().a("3936");
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -57236032, a);
    }

    private boolean m18021c() {
        EventsInviteThroughMessengerInterstitialController eventsInviteThroughMessengerInterstitialController = (EventsInviteThroughMessengerInterstitialController) this.f17690a.a(EventsInviteThroughMessengerInterstitialController.a, EventsInviteThroughMessengerInterstitialController.class);
        return eventsInviteThroughMessengerInterstitialController != null && Objects.equal(eventsInviteThroughMessengerInterstitialController.b(), "3936");
    }

    public boolean getIsInvitingThroughMessenger() {
        return this.f17693d.isEnabled() && this.f17693d.isChecked();
    }

    public final void m18022a() {
        this.f17693d.setEnabled(true);
    }

    public final void m18023b() {
        this.f17693d.setEnabled(false);
    }
}
