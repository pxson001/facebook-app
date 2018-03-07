package com.facebook.messaging.composershortcuts;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.facebook.common.time.Clock;
import com.facebook.common.util.ContextUtils;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.composershortcuts.ComposerButton.ComposerButtonStateObserver;
import com.facebook.messaging.composershortcuts.ComposerButton.OnFlingUpListener;
import com.facebook.messaging.composershortcuts.ComposerShortcutsContainer.ComposerShortcutState;
import com.facebook.messaging.composershortcuts.ComposerShortcutsManager.ShortcutsList;
import com.facebook.orca.compose.TwoLineComposerView.13;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.qe.api.QeAccessor;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: messenger_ads_link_click */
public class ComposerShortcutsContainerLogic {
    private final BuiltinComposerShortcuts f10024a;
    public final ComposerShortcutsAnalyticsLogger f10025b;
    private final ComposerShortcutsManager f10026c;
    private final Clock f10027d;
    public final Context f10028e;
    private final FbSharedPreferences f10029f;
    public final OverflowComposerShortcutsAdapter f10030g;
    private final Provider<Boolean> f10031h;
    public final Provider<BottomSheetDialog> f10032i;
    private final QeAccessor f10033j;
    public final Map<String, ComposerButton> f10034k = new HashMap();
    public final Map<String, ComposerButton> f10035l = new HashMap();
    public View f10036m;
    public ImmutableList<ComposerShortcutItem> f10037n;
    public boolean f10038o;
    public ComposerShortcutItem f10039p;
    public Map<String, ComposerShortcutState> f10040q;
    @Nullable
    private ComposerButton f10041r;
    public ImmutableList<ComposerShortcutItem> f10042s;
    @Nullable
    public ComposerButtonStateObserver f10043t;
    @Nullable
    public BottomSheetDialog f10044u;
    @Nullable
    private ComposerShortcutItem f10045v;
    public 13 f10046w;
    public int f10047x;
    private ComposerShortcutsFilter f10048y = ComposerShortcutsFilter.UNFILTERED;

    /* compiled from: messenger_ads_link_click */
    public class C11621 {
        public final /* synthetic */ ComposerShortcutsContainerLogic f10016a;

        C11621(ComposerShortcutsContainerLogic composerShortcutsContainerLogic) {
            this.f10016a = composerShortcutsContainerLogic;
        }
    }

    /* compiled from: messenger_ads_link_click */
    public class C11665 implements OnDismissListener {
        final /* synthetic */ ComposerShortcutsContainerLogic f10023a;

        public C11665(ComposerShortcutsContainerLogic composerShortcutsContainerLogic) {
            this.f10023a = composerShortcutsContainerLogic;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.f10023a.f10044u = null;
            ComposerShortcutsContainerLogic.m10543l(this.f10023a);
        }
    }

    @Inject
    public ComposerShortcutsContainerLogic(QeAccessor qeAccessor, BuiltinComposerShortcuts builtinComposerShortcuts, ComposerShortcutsAnalyticsLogger composerShortcutsAnalyticsLogger, ComposerShortcutsManager composerShortcutsManager, Clock clock, Context context, FbSharedPreferences fbSharedPreferences, OverflowComposerShortcutsAdapter overflowComposerShortcutsAdapter, Provider<Boolean> provider, Provider<BottomSheetDialog> provider2) {
        this.f10033j = qeAccessor;
        this.f10024a = builtinComposerShortcuts;
        this.f10025b = composerShortcutsAnalyticsLogger;
        this.f10026c = composerShortcutsManager;
        this.f10027d = clock;
        this.f10028e = context;
        this.f10029f = fbSharedPreferences;
        this.f10030g = overflowComposerShortcutsAdapter;
        this.f10031h = provider;
        this.f10032i = provider2;
    }

    public final void m10545a(View view) {
        this.f10036m = view;
        m10536a(ImmutableList.of(this.f10024a.m10493a("like"), this.f10024a.m10493a("send"), this.f10024a.m10493a("emoji"), this.f10024a.m10493a("message_cap")));
        m10541h();
        this.f10039p = this.f10024a.m10493a("overflow");
    }

    public final synchronized void m10546a(ComposerShortcutsFilter composerShortcutsFilter) {
        if (this.f10048y != composerShortcutsFilter) {
            this.f10048y = composerShortcutsFilter;
            m10553d();
        }
    }

    public final void m10553d() {
        m10541h();
        m10542i();
    }

    private void m10541h() {
        ShortcutsList a = this.f10026c.mo406a(this.f10048y);
        this.f10037n = a.f10053a;
        this.f10038o = a.f10054b;
        m10536a(this.f10037n);
    }

    private void m10536a(Iterable<ComposerShortcutItem> iterable) {
        if (this.f10040q == null) {
            this.f10040q = Maps.c();
        }
        for (ComposerShortcutItem composerShortcutItem : iterable) {
            ComposerShortcutState composerShortcutState = (ComposerShortcutState) this.f10040q.get(composerShortcutItem.f9973b);
            if (composerShortcutState != null) {
                composerShortcutState.f10012a = composerShortcutItem;
            } else {
                this.f10040q.put(composerShortcutItem.f9973b, new ComposerShortcutState(composerShortcutItem));
            }
        }
    }

    public final int m10554e() {
        return this.f10041r != null ? this.f10041r.getId() : -1;
    }

    public final ComposerButton m10548b(String str) {
        Preconditions.checkArgument(!str.equals("overflow"), "use getComposerButtonForOverflow to get a button for the overflow");
        ComposerButton f = m10539f(str);
        m10534a(f, (ComposerShortcutState) this.f10040q.get(str));
        this.f10035l.put(str, f);
        return f;
    }

    private void m10534a(ComposerButton composerButton, ComposerShortcutState composerShortcutState) {
        m10538c(composerButton);
        ComposerShortcutItem composerShortcutItem = composerShortcutState.f10012a;
        if (composerShortcutItem.f9973b.equals("like") && this.f10045v != null) {
            composerShortcutItem = this.f10045v;
        }
        composerButton.setComposerShortcut(composerShortcutItem);
        composerButton.setEnabled(composerShortcutState.f10014c);
        composerButton.setSelected(composerShortcutState.f10015d);
        composerButton.setSelectedColorFilterColorOverride(this.f10047x);
        if (composerShortcutItem.f9974c != 0) {
            composerButton.setId(composerShortcutItem.f9974c);
        }
        composerButton.f9954l = this.f10043t;
    }

    public final ComposerButton m10544a(ImmutableList<ComposerShortcutItem> immutableList) {
        ComposerButton f = m10539f("overflow");
        this.f10041r = f;
        this.f10042s = immutableList;
        m10537b(this.f10041r);
        return f;
    }

    private void m10537b(ComposerButton composerButton) {
        this.f10030g.f10144s = new C11621(this);
        m10538c(composerButton);
        composerButton.setComposerShortcut(this.f10039p);
        composerButton.setId(this.f10039p.f9974c);
        composerButton.f9954l = this.f10043t;
        composerButton.setSelectedColorFilterColorOverride(this.f10047x);
        m10542i();
    }

    private void m10542i() {
        boolean z = true;
        if (this.f10041r != null) {
            boolean z2;
            long a = this.f10029f.a(MessengerComposerShortcutsManager.f10071c, 0);
            Boolean valueOf = Boolean.valueOf(a > this.f10029f.a(MessengerComposerShortcutsManager.f10072d, 0));
            if (this.f10027d.a() < a + 432000000) {
                z2 = true;
            } else {
                z2 = false;
            }
            Boolean valueOf2 = Boolean.valueOf(z2);
            if (!(((Boolean) this.f10031h.get()).booleanValue() && valueOf.booleanValue() && valueOf2.booleanValue())) {
                z = false;
            }
            if (Boolean.valueOf(z).booleanValue()) {
                this.f10041r.m10507a();
            } else {
                this.f10041r.m10508b();
            }
        }
    }

    private static void m10538c(ComposerButton composerButton) {
        composerButton.setId(0);
        composerButton.setEnabled(true);
        composerButton.setSelected(false);
    }

    private ComposerButton m10539f(String str) {
        ComposerButton composerButton = (ComposerButton) this.f10034k.remove(str);
        if (composerButton != null) {
            return composerButton;
        }
        composerButton = new ComposerButton(this.f10028e);
        composerButton.setBackgroundResource(ContextUtils.b(this.f10028e, 16843534, 2130842164));
        composerButton.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ComposerShortcutsContainerLogic f10018b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 322210561);
                ComposerShortcutsContainerLogic composerShortcutsContainerLogic = this.f10018b;
                ComposerButton composerButton = composerButton;
                ComposerShortcutState composerShortcutState = (ComposerShortcutState) composerShortcutsContainerLogic.f10040q.get(composerButton.getComposerShortcutId());
                if ("overflow".equals(composerButton.getComposerShortcutId())) {
                    if (composerShortcutsContainerLogic.f10044u == null) {
                        composerShortcutsContainerLogic.f10044u = (BottomSheetDialog) composerShortcutsContainerLogic.f10032i.get();
                        composerShortcutsContainerLogic.f10030g.m10607a(composerShortcutsContainerLogic.f10042s);
                        composerShortcutsContainerLogic.f10044u.a(composerShortcutsContainerLogic.f10030g);
                        composerShortcutsContainerLogic.f10044u.c();
                        composerShortcutsContainerLogic.f10044u.show();
                        composerShortcutsContainerLogic.f10044u.setOnDismissListener(new C11665(composerShortcutsContainerLogic));
                        ComposerShortcutsAnalyticsLogger composerShortcutsAnalyticsLogger = composerShortcutsContainerLogic.f10025b;
                        composerShortcutsAnalyticsLogger.f10011a.a(ComposerShortcutsAnalyticsLogger.m10531e("open_more_tab"));
                    }
                } else if (composerShortcutState != null) {
                    ComposerShortcutsContainerLogic.m10535a(composerShortcutsContainerLogic, composerShortcutState.f10012a);
                    ComposerShortcutsAnalyticsLogger composerShortcutsAnalyticsLogger2 = composerShortcutsContainerLogic.f10025b;
                    composerShortcutsAnalyticsLogger2.f10011a.a(ComposerShortcutsAnalyticsLogger.m10531e("select_composer_shortcut_from_composer").b("shortcut_id", composerShortcutState.f10012a.f9973b));
                }
                Logger.a(2, EntryType.UI_INPUT_END, -1688998699, a);
            }
        });
        composerButton.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ ComposerShortcutsContainerLogic f10020b;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                ComposerShortcutsContainerLogic composerShortcutsContainerLogic = this.f10020b;
                View view2 = composerButton;
                ComposerShortcutState composerShortcutState = (ComposerShortcutState) composerShortcutsContainerLogic.f10040q.get(view2.getComposerShortcutId());
                if (composerShortcutState == null || composerShortcutsContainerLogic.f10046w == null) {
                    z = false;
                } else {
                    z = composerShortcutsContainerLogic.f10046w.a(composerShortcutState.f10012a, view2, motionEvent);
                }
                return z;
            }
        });
        composerButton.f9950h = new OnFlingUpListener(this) {
            final /* synthetic */ ComposerShortcutsContainerLogic f10022b;

            public final void mo405a() {
                ComposerShortcutsContainerLogic composerShortcutsContainerLogic = this.f10022b;
                ComposerShortcutState composerShortcutState = (ComposerShortcutState) composerShortcutsContainerLogic.f10040q.get(composerButton.getComposerShortcutId());
                if (composerShortcutState != null && composerShortcutsContainerLogic.f10046w != null) {
                    composerShortcutsContainerLogic.f10046w.b(composerShortcutState.f10012a);
                }
            }
        };
        return composerButton;
    }

    public static void m10535a(ComposerShortcutsContainerLogic composerShortcutsContainerLogic, ComposerShortcutItem composerShortcutItem) {
        if (composerShortcutsContainerLogic.f10046w != null) {
            composerShortcutsContainerLogic.f10046w.a(composerShortcutItem);
        }
        composerShortcutsContainerLogic.f10026c.mo408a(composerShortcutItem);
    }

    public final void m10547a(String str, boolean z) {
        ComposerShortcutState composerShortcutState = (ComposerShortcutState) this.f10040q.get(str);
        if (composerShortcutState != null && composerShortcutState.f10015d != z) {
            composerShortcutState.f10015d = z;
            m10540g(str);
        }
    }

    public final boolean m10552c(String str) {
        ComposerShortcutState composerShortcutState = (ComposerShortcutState) this.f10040q.get(str);
        if (composerShortcutState != null) {
            return composerShortcutState.f10015d;
        }
        return false;
    }

    public final void m10550b(String str, boolean z) {
        for (String str2 : ImmutableList.of(str)) {
            ComposerShortcutState composerShortcutState = (ComposerShortcutState) this.f10040q.get(str2);
            if (!(composerShortcutState == null || composerShortcutState.f10013b == z)) {
                composerShortcutState.f10013b = z;
            }
        }
        this.f10036m.requestLayout();
    }

    public final void m10551c(String str, boolean z) {
        ComposerShortcutState composerShortcutState = (ComposerShortcutState) this.f10040q.get(str);
        if (composerShortcutState != null && composerShortcutState.f10014c != z) {
            composerShortcutState.f10014c = z;
            m10540g(str);
        }
    }

    public final void m10549b(int i) {
        if (i == 0) {
            if (this.f10045v != null) {
                this.f10045v = null;
                m10540g("like");
            }
        } else if (this.f10045v == null || i != this.f10045v.f9975d) {
            ComposerShortcutItemBuilder a = new ComposerShortcutItemBuilder().m10520a(this.f10024a.m10493a("like"));
            a.f9996f = null;
            a = a;
            a.f9995e = null;
            a = a;
            a.f9994d = i;
            a = a;
            a.f10005o = false;
            this.f10045v = a.m10528s();
            m10540g("like");
        }
    }

    private void m10540g(String str) {
        ComposerButton composerButton = (ComposerButton) this.f10035l.get(str);
        if (composerButton != null) {
            m10534a(composerButton, (ComposerShortcutState) this.f10040q.get(str));
        }
    }

    public final void m10555g() {
        if (this.f10044u != null) {
            m10543l(this);
            this.f10044u.dismiss();
        }
    }

    public static void m10543l(ComposerShortcutsContainerLogic composerShortcutsContainerLogic) {
        composerShortcutsContainerLogic.f10029f.edit().a(MessengerComposerShortcutsManager.f10072d, composerShortcutsContainerLogic.f10027d.a()).commit();
        composerShortcutsContainerLogic.m10542i();
    }
}
