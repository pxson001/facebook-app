package com.facebook.events.invite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.events.prefs.EventsPrefKeys;
import com.facebook.inject.FbInjector;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbEditText;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: cold_start */
public class EventsExtendedInviteAddNoteActivity extends FbFragmentActivity {
    private boolean f17539p;
    public View f17540q;
    private ViewStub f17541r;
    public FbEditText f17542s;
    @Inject
    private InterstitialManager f17543t;
    @Inject
    public TipSeenTracker f17544u;

    /* compiled from: cold_start */
    class C24831 implements OnClickListener {
        final /* synthetic */ EventsExtendedInviteAddNoteActivity f17535a;

        C24831(EventsExtendedInviteAddNoteActivity eventsExtendedInviteAddNoteActivity) {
            this.f17535a = eventsExtendedInviteAddNoteActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1689799843);
            this.f17535a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 1666036958, a);
        }
    }

    /* compiled from: cold_start */
    class C24842 extends OnToolbarButtonListener {
        final /* synthetic */ EventsExtendedInviteAddNoteActivity f17536a;

        C24842(EventsExtendedInviteAddNoteActivity eventsExtendedInviteAddNoteActivity) {
            this.f17536a = eventsExtendedInviteAddNoteActivity;
        }

        public final void m17909a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            Intent intent = new Intent();
            intent.putExtra("extra_events_note_text", this.f17536a.f17542s.getText().toString().trim());
            this.f17536a.setResult(-1, intent);
            this.f17536a.finish();
        }
    }

    /* compiled from: cold_start */
    class C24853 implements OnClickListener {
        final /* synthetic */ EventsExtendedInviteAddNoteActivity f17537a;

        C24853(EventsExtendedInviteAddNoteActivity eventsExtendedInviteAddNoteActivity) {
            this.f17537a = eventsExtendedInviteAddNoteActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2012382984);
            KeyboardUtils.b(this.f17537a, this.f17537a.f17542s);
            Logger.a(2, EntryType.UI_INPUT_END, 1522309511, a);
        }
    }

    /* compiled from: cold_start */
    class C24864 implements OnClickListener {
        final /* synthetic */ EventsExtendedInviteAddNoteActivity f17538a;

        C24864(EventsExtendedInviteAddNoteActivity eventsExtendedInviteAddNoteActivity) {
            this.f17538a = eventsExtendedInviteAddNoteActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1205536236);
            this.f17538a.f17540q.setVisibility(8);
            this.f17538a.f17544u.b();
            Logger.a(2, EntryType.UI_INPUT_END, -1645574905, a);
        }
    }

    private static <T extends Context> void m17912a(Class<T> cls, T t) {
        m17913a((Object) t, (Context) t);
    }

    public static void m17913a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventsExtendedInviteAddNoteActivity) obj).m17911a(InterstitialManager.a(fbInjector), TipSeenTracker.b(fbInjector));
    }

    protected final void m17919b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = EventsExtendedInviteAddNoteActivity.class;
        m17913a((Object) this, (Context) this);
        setContentView(2130904154);
        m17916i();
        m17917j();
        this.f17541r = (ViewStub) a(2131561551);
    }

    private void m17916i() {
        FbTitleBarUtil.b(this);
        FbTitleBar fbTitleBar = (FbTitleBar) a(2131558563);
        fbTitleBar.a(new C24831(this));
        Builder a = TitleBarButtonSpec.a();
        a.a = 1;
        a = a;
        a.g = getString(2131236981);
        a = a;
        a.h = -2;
        fbTitleBar.setButtonSpecs(ImmutableList.of(a.a()));
        fbTitleBar.setOnToolbarButtonListener(new C24842(this));
    }

    private void m17911a(InterstitialManager interstitialManager, TipSeenTracker tipSeenTracker) {
        this.f17543t = interstitialManager;
        this.f17544u = tipSeenTracker;
    }

    private void m17917j() {
        this.f17542s = (FbEditText) a(2131561550);
        if (getIntent().hasExtra("extra_events_note_text")) {
            this.f17542s.setText(getIntent().getStringExtra("extra_events_note_text"));
        }
        this.f17542s.setOnClickListener(new C24853(this));
        this.f17542s.requestFocus();
        KeyboardUtils.b(this, this.f17542s);
    }

    public void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -991592696);
        super.onPause();
        KeyboardUtils.a(this);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1926168294, a);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f17544u.b = 2;
        this.f17544u.a(EventsPrefKeys.f19014h);
        if (this.f17544u.c() && m17918k() && !this.f17539p) {
            if (this.f17540q == null) {
                this.f17541r.setLayoutResource(2130904160);
                this.f17540q = this.f17541r.inflate();
                this.f17540q.findViewById(2131561563).setOnClickListener(new C24864(this));
            }
            this.f17540q.setVisibility(0);
            this.f17539p = true;
            this.f17544u.a();
            this.f17543t.a().a("4159");
        } else if (this.f17540q != null) {
            this.f17540q.setVisibility(8);
        }
    }

    private boolean m17918k() {
        EventsExtendedInviteNoteInterstitialController eventsExtendedInviteNoteInterstitialController = (EventsExtendedInviteNoteInterstitialController) this.f17543t.a(EventsExtendedInviteNoteInterstitialController.a, EventsExtendedInviteNoteInterstitialController.class);
        return eventsExtendedInviteNoteInterstitialController != null && Objects.equal(eventsExtendedInviteNoteInterstitialController.b(), "4159");
    }
}
