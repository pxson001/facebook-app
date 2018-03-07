package com.facebook.instantshopping.view.widget;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.graphql.enums.GraphQLInstantShoppingDocumentPresentationStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.instantshopping.InstantShoppingPrefKeys;
import com.facebook.instantshopping.logging.InstantShoppingAnalyticsLogger;
import com.facebook.instantshopping.logging.InstantShoppingLoggingUtils;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.ScrollValueChangedEventSubscriber;
import com.facebook.richdocument.event.RichDocumentEvents.ScrollValueChangedEvent;
import com.facebook.richdocument.view.widget.RichDocumentActivityTransitioner;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.facebook.widget.PhotoToggleButton;
import com.facebook.widget.PhotoToggleButton.OnCheckedChangeListener;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import javax.inject.Inject;

@ContextScoped
/* compiled from: SHARE_OVERFLOW */
public class InstantShoppingPageNavBar extends ScrollValueChangedEventSubscriber {
    private static InstantShoppingPageNavBar f23899t;
    private static final Object f23900u = new Object();
    @Inject
    InstantShoppingAnalyticsLogger f23901a;
    @Inject
    public TipSeenTracker f23902b;
    @Inject
    InstantShoppingLoggingUtils f23903c;
    @Inject
    FbSharedPreferences f23904d;
    @Inject
    public Context f23905e;
    @Inject
    RichDocumentEventBus f23906f;
    public View f23907g;
    public View f23908h;
    private FrameLayout f23909i;
    private View f23910j;
    public String f23911k;
    public int f23912l;
    private RichDocumentActivityTransitioner f23913m;
    public ImmutableList<GraphQLInstantShoppingDocumentPresentationStyle> f23914n;
    private boolean f23915o;
    public int f23916p;
    public int f23917q;
    private boolean f23918r;
    public boolean f23919s;

    /* compiled from: SHARE_OVERFLOW */
    class C34292 implements OnClickListener {
        final /* synthetic */ InstantShoppingPageNavBar f23897a;

        C34292(InstantShoppingPageNavBar instantShoppingPageNavBar) {
            this.f23897a = instantShoppingPageNavBar;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1550224609);
            InstantShoppingPageNavBar.m25182d(this.f23897a);
            Logger.a(2, EntryType.UI_INPUT_END, -1381491592, a);
        }
    }

    /* compiled from: SHARE_OVERFLOW */
    class AudioToggleSelectedChangedListener implements OnCheckedChangeListener {
        final /* synthetic */ InstantShoppingPageNavBar f23898a;

        public AudioToggleSelectedChangedListener(InstantShoppingPageNavBar instantShoppingPageNavBar) {
            this.f23898a = instantShoppingPageNavBar;
        }

        public final void m25176a(boolean z) {
            this.f23898a.f23904d.edit().putBoolean((PrefKey) InstantShoppingPrefKeys.f23464f.a(this.f23898a.f23911k), z).commit();
            InstantShoppingPageNavBar.m25179a(this.f23898a, "instant_shopping_audio_button_click", String.valueOf(z));
        }
    }

    private static InstantShoppingPageNavBar m25180b(InjectorLike injectorLike) {
        InstantShoppingPageNavBar instantShoppingPageNavBar = new InstantShoppingPageNavBar();
        instantShoppingPageNavBar.m25178a(InstantShoppingAnalyticsLogger.m24853a(injectorLike), TipSeenTracker.b(injectorLike), InstantShoppingLoggingUtils.m24879a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Context) injectorLike.getInstance(Context.class), RichDocumentEventBus.a(injectorLike));
        return instantShoppingPageNavBar;
    }

    private void m25178a(InstantShoppingAnalyticsLogger instantShoppingAnalyticsLogger, TipSeenTracker tipSeenTracker, InstantShoppingLoggingUtils instantShoppingLoggingUtils, FbSharedPreferences fbSharedPreferences, Context context, RichDocumentEventBus richDocumentEventBus) {
        this.f23901a = instantShoppingAnalyticsLogger;
        this.f23902b = tipSeenTracker;
        this.f23903c = instantShoppingLoggingUtils;
        this.f23904d = fbSharedPreferences;
        this.f23905e = context;
        this.f23906f = richDocumentEventBus;
    }

    public final void m25186b(FbEvent fbEvent) {
        ScrollValueChangedEvent scrollValueChangedEvent = (ScrollValueChangedEvent) fbEvent;
        if (this.f23918r) {
            this.f23916p += scrollValueChangedEvent.b;
            this.f23916p = Math.min(this.f23917q, this.f23916p);
            this.f23916p = Math.max(0, this.f23916p);
            if (!this.f23919s && this.f23916p == this.f23917q) {
                this.f23919s = true;
                this.f23916p = this.f23917q;
                this.f23907g.animate().y((float) (-this.f23917q)).setDuration(300).alpha(0.0f).start();
                this.f23908h.setVisibility(0);
            }
            if (this.f23919s && scrollValueChangedEvent.b < 0) {
                m25182d(this);
            }
        }
    }

    public static InstantShoppingPageNavBar m25177a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstantShoppingPageNavBar b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23900u) {
                InstantShoppingPageNavBar instantShoppingPageNavBar;
                if (a2 != null) {
                    instantShoppingPageNavBar = (InstantShoppingPageNavBar) a2.a(f23900u);
                } else {
                    instantShoppingPageNavBar = f23899t;
                }
                if (instantShoppingPageNavBar == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25180b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23900u, b3);
                        } else {
                            f23899t = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = instantShoppingPageNavBar;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m25184a(View view, String str, int i, RichDocumentActivityTransitioner richDocumentActivityTransitioner, ImmutableList<GraphQLInstantShoppingDocumentPresentationStyle> immutableList, boolean z) {
        this.f23910j = view;
        this.f23911k = str;
        this.f23912l = i;
        this.f23913m = richDocumentActivityTransitioner;
        this.f23914n = immutableList;
        this.f23915o = z;
        this.f23907g = this.f23910j.findViewById(2131563299);
        this.f23908h = this.f23910j.findViewById(2131563308);
        this.f23902b.a(InstantShoppingPrefKeys.f23463e);
        this.f23906f.a(this);
        this.f23917q = (int) this.f23905e.getResources().getDimension(2131432849);
        this.f23918r = false;
        this.f23919s = false;
    }

    public final void m25183a(OnClickListener onClickListener) {
        this.f23909i = (FrameLayout) this.f23910j.findViewById(this.f23915o ? 2131563300 : 2131563304);
        this.f23909i.setOnClickListener(onClickListener);
        this.f23909i.setVisibility(0);
    }

    public final void m25185b() {
        boolean z = true;
        FrameLayout frameLayout = (FrameLayout) this.f23910j.findViewById(this.f23915o ? 2131563302 : 2131563306);
        final PhotoToggleButton photoToggleButton = (PhotoToggleButton) this.f23910j.findViewById(this.f23915o ? 2131563303 : 2131563307);
        frameLayout.setVisibility(0);
        photoToggleButton.setClickable(true);
        photoToggleButton.e = new AudioToggleSelectedChangedListener(this);
        frameLayout.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ InstantShoppingPageNavBar f23896b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1776957816);
                InstantShoppingPageNavBar.m25181b(photoToggleButton);
                Logger.a(2, EntryType.UI_INPUT_END, -175433833, a);
            }
        });
        if (this.f23914n.contains(GraphQLInstantShoppingDocumentPresentationStyle.AUDIO_MUTED)) {
            z = false;
        }
        boolean a = this.f23904d.a((PrefKey) InstantShoppingPrefKeys.f23464f.a(this.f23911k), false);
        if (a) {
            z = a;
        }
        m25179a(this, "instant_shopping_audio_button_on_enter", String.valueOf(z));
        photoToggleButton.setChecked(z);
        if (this.f23902b.c() && this.f23914n.contains(GraphQLInstantShoppingDocumentPresentationStyle.AUDIO_CONTROL_FLOATING)) {
            CharSequence string = this.f23905e.getString(2131239262);
            CharSequence string2 = this.f23905e.getString(2131239263);
            Tooltip tooltip = new Tooltip(this.f23905e, 2);
            tooltip.a(string);
            tooltip.b(string2);
            tooltip.z = SizeUtil.a(this.f23905e, 3.0f);
            tooltip.y = SizeUtil.a(this.f23905e, 3.0f);
            tooltip.a(Position.BELOW);
            tooltip.a(photoToggleButton);
            tooltip.t = 5000;
            tooltip.d();
            this.f23902b.a();
        }
    }

    public final void m25187c() {
        this.f23918r = true;
        this.f23908h.setOnClickListener(new C34292(this));
    }

    public static void m25182d(InstantShoppingPageNavBar instantShoppingPageNavBar) {
        instantShoppingPageNavBar.f23919s = false;
        instantShoppingPageNavBar.f23916p = 0;
        instantShoppingPageNavBar.f23907g.animate().y(0.0f).setDuration(300).alpha(1.0f).start();
        instantShoppingPageNavBar.f23908h.setVisibility(4);
    }

    public static void m25181b(PhotoToggleButton photoToggleButton) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long uptimeMillis2 = SystemClock.uptimeMillis() + 100;
        photoToggleButton.dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis2, 0, 0.0f, 0.0f, 0));
        photoToggleButton.dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis2, 1, 0.0f, 0.0f, 0));
    }

    public static void m25179a(InstantShoppingPageNavBar instantShoppingPageNavBar, String str, final String str2) {
        instantShoppingPageNavBar.f23901a.m24859a(str, new HashMap<String, Object>() {
        });
    }
}
