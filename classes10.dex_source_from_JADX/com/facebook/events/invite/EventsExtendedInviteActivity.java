package com.facebook.events.invite;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.events.invite.EventsExtendedInviteFragment.C24915;
import com.facebook.events.invite.InviteSubSession.InviteSubSessionTypes;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.prefs.EventsPrefKeys;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.growth.prefs.GrowthPrefKeys;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.facebook.widget.friendselector.FriendSelectorResultBar;
import com.facebook.widget.friendselector.FriendSelectorResultBar.AddNoteButtonListener;
import com.facebook.widget.friendselector.FriendSelectorResultBar.Listener;
import com.facebook.widget.friendselector.FriendSelectorReviewListAdapter;
import com.facebook.widget.text.watcher.BaseTextWatcher;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView.ClearButtonMode;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: collapse_video */
public class EventsExtendedInviteActivity extends FbFragmentActivity {
    @Inject
    private EventEventLogger f17511A;
    @Inject
    private FbSharedPreferences f17512B;
    @Inject
    private GatekeeperStoreImpl f17513C;
    @Inject
    private InputMethodManager f17514D;
    @Inject
    public InterstitialManager f17515E;
    @Inject
    private InvitePickerPerformanceLogger f17516F;
    @Inject
    private InviteSessionLogger f17517G;
    @Inject
    @LoggedInUserId
    private Provider<String> f17518H;
    @Inject
    private QeAccessor f17519I;
    @Inject
    public SecureContextHelper f17520J;
    @Inject
    public TipSeenTracker f17521K;
    private final C24752 f17522L = new C24752(this);
    public final List<SimpleUserToken> f17523p = new LinkedList();
    private final OnScrollListener f17524q = new C24741(this);
    public boolean f17525r;
    public FriendSelectorReviewListAdapter f17526s;
    private PrefKey f17527t;
    public String f17528u = "";
    public AlertDialog f17529v;
    public EventsExtendedInviteFragment f17530w;
    public FriendSelectorResultBar f17531x;
    private ListView f17532y;
    public TokenizedAutoCompleteTextView f17533z;

    /* compiled from: collapse_video */
    class C24741 extends OnScrollListener {
        final /* synthetic */ EventsExtendedInviteActivity f17501a;

        C24741(EventsExtendedInviteActivity eventsExtendedInviteActivity) {
            this.f17501a = eventsExtendedInviteActivity;
        }

        public final void m17868a(RecyclerView recyclerView, int i) {
            switch (i) {
                case 1:
                    this.f17501a.m17886b((View) recyclerView);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: collapse_video */
    public class C24752 {
        final /* synthetic */ EventsExtendedInviteActivity f17502a;

        C24752(EventsExtendedInviteActivity eventsExtendedInviteActivity) {
            this.f17502a = eventsExtendedInviteActivity;
        }

        public final void m17869a(SimpleUserToken simpleUserToken, boolean z, boolean z2) {
            if (z) {
                this.f17502a.f17523p.add(simpleUserToken);
                this.f17502a.f17531x.a(simpleUserToken);
                if (z2) {
                    this.f17502a.f17533z.selectAll();
                    this.f17502a.m17875a((View) this.f17502a.f17533z);
                    return;
                }
                return;
            }
            this.f17502a.f17523p.remove(simpleUserToken);
            this.f17502a.f17531x.a(simpleUserToken, true);
        }
    }

    /* compiled from: collapse_video */
    class C24763 implements OnClickListener {
        final /* synthetic */ EventsExtendedInviteActivity f17503a;

        C24763(EventsExtendedInviteActivity eventsExtendedInviteActivity) {
            this.f17503a = eventsExtendedInviteActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1811092245);
            this.f17503a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 1949234624, a);
        }
    }

    /* compiled from: collapse_video */
    class C24774 implements OnClickListener {
        final /* synthetic */ EventsExtendedInviteActivity f17504a;

        C24774(EventsExtendedInviteActivity eventsExtendedInviteActivity) {
            this.f17504a = eventsExtendedInviteActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 65946143);
            this.f17504a.f17533z.requestFocus();
            this.f17504a.m17875a((View) this.f17504a.f17533z);
            Logger.a(2, EntryType.UI_INPUT_END, 786582676, a);
        }
    }

    /* compiled from: collapse_video */
    class C24785 implements OnFocusChangeListener {
        final /* synthetic */ EventsExtendedInviteActivity f17505a;

        C24785(EventsExtendedInviteActivity eventsExtendedInviteActivity) {
            this.f17505a = eventsExtendedInviteActivity;
        }

        public void onFocusChange(View view, boolean z) {
            if (!z) {
                this.f17505a.m17886b(view);
            }
        }
    }

    /* compiled from: collapse_video */
    class C24796 extends BaseTextWatcher {
        final /* synthetic */ EventsExtendedInviteActivity f17506a;

        C24796(EventsExtendedInviteActivity eventsExtendedInviteActivity) {
            this.f17506a = eventsExtendedInviteActivity;
        }

        public void afterTextChanged(Editable editable) {
            this.f17506a.f17530w.m17941a(this.f17506a.f17533z.getUserEnteredPlainText());
        }
    }

    /* compiled from: collapse_video */
    class C24818 implements AddNoteButtonListener {
        final /* synthetic */ EventsExtendedInviteActivity f17509a;

        C24818(EventsExtendedInviteActivity eventsExtendedInviteActivity) {
            this.f17509a = eventsExtendedInviteActivity;
        }

        public final void m17873a() {
            Intent intent = new Intent(this.f17509a, EventsExtendedInviteAddNoteActivity.class);
            intent.putExtra("extra_events_note_text", this.f17509a.f17528u);
            this.f17509a.f17520J.a(intent, 130, this.f17509a);
        }
    }

    /* compiled from: collapse_video */
    class C24829 implements DialogInterface.OnClickListener {
        final /* synthetic */ EventsExtendedInviteActivity f17510a;

        C24829(EventsExtendedInviteActivity eventsExtendedInviteActivity) {
            this.f17510a = eventsExtendedInviteActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    private static <T extends Context> void m17881a(Class<T> cls, T t) {
        m17882a((Object) t, (Context) t);
    }

    public static void m17882a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EventsExtendedInviteActivity) obj).m17879a(EventEventLogger.m18119b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), InputMethodManagerMethodAutoProvider.b(injectorLike), InterstitialManager.a(injectorLike), InvitePickerPerformanceLogger.m18041a(injectorLike), InviteSessionLogger.m18047a(injectorLike), IdBasedProvider.a(injectorLike, 4442), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), TipSeenTracker.b(injectorLike));
    }

    private void m17879a(EventEventLogger eventEventLogger, FbSharedPreferences fbSharedPreferences, GatekeeperStore gatekeeperStore, InputMethodManager inputMethodManager, InterstitialManager interstitialManager, InvitePickerPerformanceLogger invitePickerPerformanceLogger, InviteSessionLogger inviteSessionLogger, Provider<String> provider, QeAccessor qeAccessor, SecureContextHelper secureContextHelper, TipSeenTracker tipSeenTracker) {
        this.f17511A = eventEventLogger;
        this.f17512B = fbSharedPreferences;
        this.f17513C = gatekeeperStore;
        this.f17514D = inputMethodManager;
        this.f17515E = interstitialManager;
        this.f17516F = invitePickerPerformanceLogger;
        this.f17517G = inviteSessionLogger;
        this.f17518H = provider;
        this.f17519I = qeAccessor;
        this.f17520J = secureContextHelper;
        this.f17521K = tipSeenTracker;
    }

    protected final void m17905b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = EventsExtendedInviteActivity.class;
        m17882a((Object) this, (Context) this);
        this.f17516F.m18043a();
        this.f17527t = GrowthPrefKeys.a((String) this.f17518H.get());
        if (bundle != null) {
            this.f17528u = bundle.getString("NOTE_TEXT_KEY", "");
        }
        setContentView(2130904153);
        m17895i();
        m17897j();
        m17898k();
        m17901l();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("NOTE_TEXT_KEY", this.f17528u);
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1872885689);
        super.onResume();
        boolean a2 = this.f17512B.a(this.f17527t, false);
        if (this.f17533z != null) {
            int i;
            if (this.f17513C.a(707, false)) {
                i = 2131236969;
            } else if (!a2) {
                i = 2131236967;
            } else if (this.f17513C.a(708, false)) {
                i = 2131236969;
            } else {
                i = 2131236968;
            }
            this.f17533z.setHint(i);
        }
        LogUtils.c(-1047102720, a);
    }

    public void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1482606028);
        super.onPause();
        m17886b(this.f17533z);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1706718850, a);
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -75823904);
        if (!(this.f17517G == null || this.f17511A == null)) {
            this.f17517G.m18057c(InviteSubSessionTypes.ALL_CANDIDATES_ALPHABETICAL);
            this.f17517G.m18057c(InviteSubSessionTypes.ALL_CANDIDATES_SUGGESTED);
            this.f17517G.m18057c(InviteSubSessionTypes.CONTACTS);
            this.f17511A.m18135a(getIntent().getStringExtra("event_id"), this.f17517G.m18051a());
            this.f17517G.m18054b();
        }
        super.onDestroy();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -2134217145, a);
    }

    private void m17895i() {
        FbTitleBarUtil.b(this);
        ((FbTitleBar) a(2131558563)).a(new C24763(this));
    }

    private void m17897j() {
        View a = a(2131561546);
        this.f17533z = (TokenizedAutoCompleteTextView) a(2131561547);
        this.f17533z.setClearButtonMode(ClearButtonMode.WHILE_EDITING);
        a.setOnClickListener(new C24774(this));
        this.f17533z.setEnabled(true);
        this.f17533z.setOnFocusChangeListener(new C24785(this));
        this.f17533z.addTextChangedListener(new C24796(this));
    }

    private void m17875a(View view) {
        this.f17514D.showSoftInput(view, 0);
    }

    private void m17886b(View view) {
        this.f17514D.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void m17898k() {
        Fragment a = kO_().a("EVENTS_EXTENDED_INVITE_FRAGMENT_TAG");
        if (a == null) {
            this.f17530w = new EventsExtendedInviteFragment();
            this.f17530w.g(getIntent().getExtras());
            kO_().a().a(2131558429, this.f17530w, "EVENTS_EXTENDED_INVITE_FRAGMENT_TAG").b();
        } else {
            this.f17530w = (EventsExtendedInviteFragment) a;
        }
        this.f17530w.f17561c = this.f17522L;
        this.f17530w.f17567i = this.f17524q;
    }

    private void m17901l() {
        this.f17531x = (FriendSelectorResultBar) a(2131561549);
        final boolean a = this.f17519I.a(ExperimentsForEventsGatingModule.G, false);
        this.f17531x.f = new Listener(this) {
            final /* synthetic */ EventsExtendedInviteActivity f17508b;

            public final void m17870a() {
                EventsExtendedInviteFragment eventsExtendedInviteFragment = this.f17508b.f17530w;
                Object obj = this.f17508b.f17528u;
                Intent intent = new Intent();
                intent.putExtra("extra_enable_extended_invite", true);
                intent.putExtra("profiles", (String[]) eventsExtendedInviteFragment.f17559a.toArray(new String[eventsExtendedInviteFragment.f17559a.size()]));
                if (!StringUtil.a(obj)) {
                    intent.putExtra("extra_events_note_text", obj);
                }
                intent.putExtra("event_id", eventsExtendedInviteFragment.am);
                intent.putExtra("extra_invite_action_mechanism", eventsExtendedInviteFragment.s.getString("extra_invite_action_mechanism"));
                eventsExtendedInviteFragment.o().setResult(-1, intent);
                eventsExtendedInviteFragment.o().finish();
            }

            public final void m17871a(BaseToken baseToken) {
                this.f17508b.m17880a(baseToken);
            }

            public final void m17872a(boolean z) {
                int i;
                int i2 = 0;
                if (z) {
                    i = 0;
                } else {
                    i = this.f17508b.f17531x.getMeasuredHeight();
                }
                if (z) {
                    i2 = this.f17508b.f17531x.getMeasuredHeight();
                }
                EventsExtendedInviteFragment eventsExtendedInviteFragment = this.f17508b.f17530w;
                View view = eventsExtendedInviteFragment.T;
                if (view != null) {
                    ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
                    ofInt.setDuration((long) 200);
                    ofInt.addUpdateListener(new C24915(eventsExtendedInviteFragment, view));
                    ofInt.start();
                }
                if (a && z) {
                    this.f17508b.f17521K.b = 2;
                    this.f17508b.f17521K.a(EventsPrefKeys.f19013g);
                    if (this.f17508b.f17521K.c() && this.f17508b.f17529v && !this.f17508b.f17525r) {
                        Tooltip tooltip = new Tooltip(this.f17508b, 2);
                        tooltip.a(2131236976);
                        tooltip.b(2131236977);
                        tooltip.a(Position.ABOVE);
                        tooltip.t = -1;
                        tooltip.f(this.f17508b.f17531x.c);
                        this.f17508b.f17525r = true;
                        this.f17508b.f17521K.a();
                        this.f17508b.f17515E.a().a("4158");
                    }
                }
            }
        };
        if (a) {
            this.f17531x.a(new C24818(this));
            FriendSelectorResultBar friendSelectorResultBar = this.f17531x;
            if (StringUtil.a(this.f17528u)) {
                a = false;
            } else {
                a = true;
            }
            friendSelectorResultBar.a(a);
        }
    }

    public static boolean m17903m(EventsExtendedInviteActivity eventsExtendedInviteActivity) {
        EventsExtendedInviteAddNoteButtonInterstitialController eventsExtendedInviteAddNoteButtonInterstitialController = (EventsExtendedInviteAddNoteButtonInterstitialController) eventsExtendedInviteActivity.f17515E.a(EventsExtendedInviteAddNoteButtonInterstitialController.a, EventsExtendedInviteAddNoteButtonInterstitialController.class);
        return eventsExtendedInviteAddNoteButtonInterstitialController != null && Objects.equal(eventsExtendedInviteAddNoteButtonInterstitialController.b(), "4158");
    }

    public void onBackPressed() {
        if (this.f17523p.isEmpty()) {
            super.onBackPressed();
        } else {
            m17904n();
        }
    }

    private void m17904n() {
        new Builder(this).a(2131232660).b(2131232661).b(2131232662, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ EventsExtendedInviteActivity f17497a;

            {
                this.f17497a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                super.onBackPressed();
            }
        }).a(2131232663, new C24829(this)).a(false).a().show();
    }

    private void m17880a(BaseToken baseToken) {
        if (this.f17529v == null) {
            this.f17526s = new FriendSelectorReviewListAdapter(ImmutableList.copyOf(this.f17523p));
            this.f17532y = (ListView) LayoutInflater.from(this).inflate(2130904495, (ViewGroup) this.f17530w.T, false);
            this.f17532y.setAdapter(this.f17526s);
            DialogInterface.OnClickListener anonymousClass11 = new DialogInterface.OnClickListener(this) {
                final /* synthetic */ EventsExtendedInviteActivity f17498a;

                {
                    this.f17498a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            };
            this.f17529v = new Builder(this).a(getResources().getString(2131232665, new Object[]{Integer.valueOf(this.f17526s.getCount())})).b(this.f17532y).b(2131232663, anonymousClass11).a(2131232664, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ EventsExtendedInviteActivity f17499a;

                {
                    this.f17499a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f17499a.m17883a(this.f17499a.f17526s.a());
                }
            }).a(false).a();
            this.f17532y.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ EventsExtendedInviteActivity f17500a;

                {
                    this.f17500a = r1;
                }

                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.f17500a.f17526s.a(i);
                    this.f17500a.f17529v.setTitle(this.f17500a.getResources().getString(2131232665, new Object[]{Integer.valueOf(this.f17500a.f17526s.b())}));
                }
            });
        } else {
            this.f17526s.a(ImmutableList.copyOf(this.f17523p));
            this.f17529v.setTitle(getResources().getString(2131232665, new Object[]{Integer.valueOf(this.f17526s.getCount())}));
        }
        this.f17532y.setSelection(this.f17526s.a(baseToken));
        this.f17529v.show();
    }

    private void m17883a(Set<SimpleUserToken> set) {
        if (!set.isEmpty()) {
            this.f17523p.removeAll(set);
            for (SimpleUserToken simpleUserToken : set) {
                EventsExtendedInviteFragment eventsExtendedInviteFragment = this.f17530w;
                eventsExtendedInviteFragment.f17559a.remove(simpleUserToken.p());
                this.f17531x.a(simpleUserToken, false);
            }
            EventsExtendedInviteFragment eventsExtendedInviteFragment2 = this.f17530w;
            eventsExtendedInviteFragment2.f17564f.m18002e();
            if (eventsExtendedInviteFragment2.f17563e != null) {
                eventsExtendedInviteFragment2.f17563e.notifyDataSetChanged();
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        Preconditions.checkArgument(i == 130);
        if (i2 == -1 && intent.hasExtra("extra_events_note_text")) {
            this.f17528u = intent.getStringExtra("extra_events_note_text");
            FriendSelectorResultBar friendSelectorResultBar = this.f17531x;
            if (StringUtil.a(this.f17528u)) {
                z = false;
            }
            friendSelectorResultBar.a(z);
        }
    }
}
