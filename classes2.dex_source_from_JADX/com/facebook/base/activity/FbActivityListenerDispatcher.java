package com.facebook.base.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.activitylistener.ActivityListener;
import com.facebook.common.activitylistener.CollectiveLifetimeActivityListener;
import com.facebook.common.activitylistener.CollectiveLifetimeActivityListenerImpl;
import com.facebook.common.activitylistener.FbActivityListener;
import com.facebook.common.activitylistener.STATICDI_MULTIBIND_PROVIDER$FbActivityListener;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: survey_requested */
public class FbActivityListenerDispatcher {
    boolean f3741a = false;
    public final Set<ActivityListener> f3742b;
    private final Set<FbActivityListener> f3743c;
    private final Set<FbActivityOverrider> f3744d;
    private Activity f3745e;
    private FbActivitySuper f3746f;
    @GuardedBy("this")
    private int f3747g = 0;
    @GuardedBy("this")
    private List<ActivityListener> f3748h;
    @GuardedBy("this")
    private List<ActivityListener> f3749i;

    public static FbActivityListenerDispatcher m6140b(InjectorLike injectorLike) {
        return new FbActivityListenerDispatcher(new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$FbActivityListener(injectorLike)), CollectiveLifetimeActivityListenerImpl.m6402b(injectorLike));
    }

    @Inject
    public FbActivityListenerDispatcher(Set<FbActivityListener> set, CollectiveLifetimeActivityListener collectiveLifetimeActivityListener) {
        int size = set.size() + 1;
        this.f3743c = new HashSet(size);
        this.f3744d = new HashSet();
        this.f3742b = new HashSet(size);
        synchronized (this) {
            m6141c((ActivityListener) collectiveLifetimeActivityListener);
            for (ActivityListener c : set) {
                m6141c(c);
            }
        }
    }

    final void m6153a(Activity activity, FbActivitySuper fbActivitySuper) {
        this.f3745e = activity;
        this.f3746f = fbActivitySuper;
    }

    public final synchronized void m6158a(ActivityListener activityListener) {
        m6141c(activityListener);
    }

    private void m6141c(ActivityListener activityListener) {
        if (this.f3747g == 0) {
            m6142d(activityListener);
            return;
        }
        if (this.f3749i == null) {
            this.f3749i = Lists.m1305b(1);
        }
        this.f3749i.add(activityListener);
    }

    private void m6142d(ActivityListener activityListener) {
        this.f3742b.add(activityListener);
        if (activityListener instanceof FbActivityListener) {
            this.f3743c.add((FbActivityListener) activityListener);
        }
        if (activityListener instanceof AbstractFbActivityOverrider) {
            AbstractFbActivityOverrider abstractFbActivityOverrider = (AbstractFbActivityOverrider) activityListener;
            abstractFbActivityOverrider.m6428a(this.f3745e, this.f3746f);
            this.f3744d.add(abstractFbActivityOverrider);
        }
    }

    public final synchronized void m6169b(ActivityListener activityListener) {
        if (this.f3747g == 0) {
            m6143e(activityListener);
        } else {
            if (this.f3748h == null) {
                this.f3748h = Lists.m1297a(1);
            }
            this.f3748h.add(activityListener);
        }
    }

    private synchronized void m6144p() {
        this.f3747g++;
    }

    private synchronized void m6145q() {
        Preconditions.checkState(this.f3747g > 0);
        int i = this.f3747g - 1;
        this.f3747g = i;
        if (i <= 0) {
            if (this.f3748h != null) {
                for (ActivityListener e : this.f3748h) {
                    m6143e(e);
                }
                this.f3748h = null;
            }
            if (this.f3749i != null) {
                for (ActivityListener e2 : this.f3749i) {
                    m6142d(e2);
                }
                this.f3749i = null;
            }
        }
    }

    private void m6143e(ActivityListener activityListener) {
        this.f3744d.remove(activityListener);
        this.f3743c.remove(activityListener);
        this.f3742b.remove(activityListener);
    }

    final boolean m6170b() {
        m6144p();
        TracerDetour.a("FbActivityListeners.overrideInvalidateOptionsMenu", 1318560);
        try {
            for (AbstractFbActivityOverrider a : this.f3744d) {
                if (a.m6431a(this.f3746f)) {
                    return true;
                }
            }
            TracerDetour.a(1194138155);
            m6145q();
            return false;
        } finally {
            TracerDetour.a(-1316084434);
            m6145q();
        }
    }

    final Optional<View> m6147a(int i) {
        m6144p();
        TracerDetour.a("FbActivityListeners.overrideOnCreatePanelView", 601826886);
        try {
            for (AbstractFbActivityOverrider d : this.f3744d) {
                Optional<View> d2 = d.m6435d();
                if (d2 != null) {
                    return d2;
                }
            }
            TracerDetour.a(-1969736559);
            m6145q();
            return null;
        } finally {
            TracerDetour.a(287817478);
            m6145q();
        }
    }

    final Optional<Boolean> m6149a(int i, Menu menu) {
        m6144p();
        TracerDetour.a("FbActivityListeners.overrideOnCreatePanelMenu", 2056130526);
        try {
            for (AbstractFbActivityOverrider e : this.f3744d) {
                Optional<Boolean> e2 = e.m6436e();
                if (e2.isPresent()) {
                    return e2;
                }
            }
            TracerDetour.a(-210762064);
            m6145q();
            return Absent.withType();
        } finally {
            TracerDetour.a(-1121523012);
            m6145q();
        }
    }

    final Optional<Boolean> m6151a(int i, View view, Menu menu) {
        m6144p();
        TracerDetour.a("FbActivityListeners.overrideOnPreparePanel", -1412791135);
        try {
            for (AbstractFbActivityOverrider f : this.f3744d) {
                Optional<Boolean> f2 = f.m6437f();
                if (f2.isPresent()) {
                    return f2;
                }
            }
            TracerDetour.a(980657336);
            m6145q();
            return Absent.withType();
        } finally {
            TracerDetour.a(-1178348496);
            m6145q();
        }
    }

    final Optional<Boolean> m6150a(int i, MenuItem menuItem) {
        m6144p();
        TracerDetour.a("FbActivityListeners.overrideOnMenuItemSelected", 779936753);
        try {
            for (AbstractFbActivityOverrider a : this.f3744d) {
                Optional<Boolean> a2 = a.m6427a(this.f3745e, this.f3746f, i, menuItem);
                if (a2.isPresent()) {
                    return a2;
                }
            }
            TracerDetour.a(-1555973225);
            m6145q();
            return Absent.withType();
        } finally {
            TracerDetour.a(-1558855631);
            m6145q();
        }
    }

    final MenuInflater m6175c() {
        m6144p();
        TracerDetour.a("FbActivityListeners.overrideGetMenuInflater", 1025444552);
        try {
            for (AbstractFbActivityOverrider c : this.f3744d) {
                MenuInflater c2 = c.m6434c();
                if (c2 != null) {
                    return c2;
                }
            }
            TracerDetour.a(-653230654);
            m6145q();
            return null;
        } finally {
            TracerDetour.a(2113013255);
            m6145q();
        }
    }

    final boolean m6171b(int i) {
        m6144p();
        TracerDetour.a("FbActivityListeners.overrideSetContentView", -697704996);
        try {
            for (AbstractFbActivityOverrider b : this.f3744d) {
                if (b.m6432b(i)) {
                    return true;
                }
            }
            TracerDetour.a(1690007799);
            m6145q();
            return false;
        } finally {
            TracerDetour.a(-548947684);
            m6145q();
        }
    }

    final boolean m6164a(View view) {
        m6144p();
        TracerDetour.a("FbActivityListeners.overrideSetContentView", 1031162163);
        try {
            for (AbstractFbActivityOverrider a : this.f3744d) {
                if (a.m6429a(view)) {
                    return true;
                }
            }
            TracerDetour.a(-1873770064);
            m6145q();
            return false;
        } finally {
            TracerDetour.a(-830349261);
            m6145q();
        }
    }

    final boolean m6165a(View view, LayoutParams layoutParams) {
        m6144p();
        TracerDetour.a("FbActivityListeners.overrideSetContentView", 2029661473);
        try {
            for (AbstractFbActivityOverrider a : this.f3744d) {
                if (a.m6430a(view, layoutParams)) {
                    return true;
                }
            }
            TracerDetour.a(945545714);
            m6145q();
            return false;
        } finally {
            TracerDetour.a(957734305);
            m6145q();
        }
    }

    final boolean m6173b(View view, LayoutParams layoutParams) {
        m6144p();
        TracerDetour.a("FbActivityListeners.addContentView", -1911319068);
        try {
            for (AbstractFbActivityOverrider b : this.f3744d) {
                if (b.m6433b(view, layoutParams)) {
                    return true;
                }
            }
            TracerDetour.a(1240241264);
            m6145q();
            return false;
        } finally {
            TracerDetour.a(-1178319566);
            m6145q();
        }
    }

    final boolean m6162a(@Nullable Bundle bundle) {
        if (this.f3746f == null) {
            throw new NullPointerException("Call setActivitySuper() before activity callbacks");
        }
        m6146r();
        m6144p();
        TracerDetour.a("FbActivityListeners.onBeforeSuperOnCreate", 823374683);
        try {
            for (FbActivityListener a : this.f3743c) {
                a.mo249a(this.f3745e, bundle);
                if (this.f3745e.isFinishing()) {
                    return true;
                }
            }
            TracerDetour.a(-1084125077);
            m6145q();
            return false;
        } finally {
            TracerDetour.a(-1199927729);
            m6145q();
        }
    }

    final boolean m6172b(@Nullable Bundle bundle) {
        m6146r();
        m6144p();
        TracerDetour.a("FbActivityListeners.onBeforeActivityCreate", 1745674735);
        try {
            Iterator it = this.f3743c.iterator();
            while (it.hasNext()) {
                FbActivityListener fbActivityListener = (FbActivityListener) it.next();
                if (this.f3745e.isFinishing()) {
                    return true;
                }
                TracerDetour.a(fbActivityListener.getClass().getName(), 354397780);
                try {
                    fbActivityListener.mo255b(this.f3745e, bundle);
                    TracerDetour.a(fbActivityListener);
                } finally {
                    int i = -301663138;
                    TracerDetour.a(-301663138);
                }
            }
            TracerDetour.a(162431495);
            m6145q();
            return this.f3745e.isFinishing();
        } finally {
            TracerDetour.a(-1710678434);
            m6145q();
        }
    }

    final void m6177d() {
        m6144p();
        TracerDetour.a("FbActivityListeners.onActivityCreate", -1490131782);
        try {
            Iterator it = this.f3742b.iterator();
            while (it.hasNext()) {
                ActivityListener activityListener = (ActivityListener) it.next();
                if (!this.f3745e.isFinishing()) {
                    TracerDetour.a(activityListener.getClass().getName(), -368965836);
                    try {
                        activityListener.mo261a(this.f3745e);
                        TracerDetour.a(activityListener);
                    } finally {
                        int i = -741485139;
                        TracerDetour.a(-741485139);
                    }
                } else {
                    return;
                }
            }
            TracerDetour.a(-551060310);
            m6145q();
        } finally {
            TracerDetour.a(425209418);
            m6145q();
        }
    }

    final void m6176c(Bundle bundle) {
        m6144p();
        TracerDetour.a("FbActivityListeners.onSaveInstanceState", -537580678);
        try {
            for (FbActivityListener b : this.f3743c) {
                b.mo256b(bundle);
            }
        } finally {
            TracerDetour.a(-616643847);
            m6145q();
        }
    }

    final void m6179d(@Nullable Bundle bundle) {
        m6144p();
        TracerDetour.a("FbActivityListeners.onPostCreate", -1537007441);
        try {
            for (FbActivityListener a : this.f3743c) {
                a.mo251a(bundle);
            }
        } finally {
            TracerDetour.a(-1751831682);
            m6145q();
        }
    }

    final void m6180e() {
        m6146r();
        m6144p();
        TracerDetour.a("FbActivityListeners.onStart", -31554435);
        try {
            Iterator it = this.f3742b.iterator();
            while (it.hasNext()) {
                ActivityListener activityListener = (ActivityListener) it.next();
                TracerDetour.a(activityListener.getClass().getName(), 1254224912);
                try {
                    activityListener.mo262b(this.f3745e);
                    TracerDetour.a(activityListener);
                } finally {
                    int i = 1283630524;
                    TracerDetour.a(1283630524);
                }
            }
        } finally {
            TracerDetour.a(-192568119);
            m6145q();
        }
    }

    final void m6154a(Intent intent) {
        m6146r();
        m6144p();
        TracerDetour.a("FbActivityListeners.onNewIntent", -1627367807);
        try {
            for (FbActivityListener a : this.f3743c) {
                a.mo247a(this.f3745e, intent);
            }
        } finally {
            TracerDetour.a(1519403155);
            m6145q();
        }
    }

    final void m6181f() {
        m6144p();
        TracerDetour.a("FbActivityListeners.onStop", 1552892959);
        try {
            for (ActivityListener e : this.f3742b) {
                e.mo264e(this.f3745e);
            }
        } finally {
            TracerDetour.a(-781311731);
            m6145q();
        }
    }

    final void m6182g() {
        this.f3741a = false;
        m6144p();
        TracerDetour.a("FbActivityListeners.onPause", -498395143);
        try {
            for (ActivityListener d : this.f3742b) {
                d.mo242d(this.f3745e);
            }
        } finally {
            TracerDetour.a(-223417005);
            m6145q();
        }
    }

    final void m6183h() {
        m6146r();
        m6144p();
        TracerDetour.a("FbActivityListeners.onResume", -2017871193);
        try {
            Iterator it = this.f3742b.iterator();
            while (it.hasNext()) {
                ActivityListener activityListener = (ActivityListener) it.next();
                TracerDetour.a(activityListener.getClass().getName(), 1212224750);
                try {
                    activityListener.mo263c(this.f3745e);
                    TracerDetour.a(activityListener);
                } finally {
                    int i = 179365913;
                    TracerDetour.a(179365913);
                }
            }
        } finally {
            TracerDetour.a(82520664);
            m6145q();
        }
    }

    final void m6184i() {
        m6144p();
        TracerDetour.a("FbActivityListeners.onResumeFragments", 27138216);
        try {
            Iterator it = this.f3743c.iterator();
            while (it.hasNext()) {
                it.next();
            }
        } finally {
            TracerDetour.a(-1738320561);
            m6145q();
        }
    }

    final void m6185j() {
        m6144p();
        TracerDetour.a("FbActivityListeners.onDestroy", 616308016);
        try {
            for (FbActivityListener f : this.f3743c) {
                f.mo265f(this.f3745e);
            }
        } finally {
            TracerDetour.a(-186406746);
            m6145q();
        }
    }

    final void m6186k() {
        m6144p();
        TracerDetour.a("FbActivityListeners.onUserInteraction", -1764298469);
        try {
            for (FbActivityListener h : this.f3743c) {
                h.mo259h(this.f3745e);
            }
        } finally {
            TracerDetour.a(-1763314711);
            m6145q();
        }
    }

    final boolean m6166a(Throwable th) {
        m6144p();
        TracerDetour.a("FbActivityListeners.handleServiceException", -1058640876);
        try {
            for (FbActivityListener a : this.f3743c) {
                if (a.mo253a(this.f3745e, th)) {
                    return true;
                }
            }
            TracerDetour.a(-604380646);
            m6145q();
            return false;
        } finally {
            TracerDetour.a(-1185339341);
            m6145q();
        }
    }

    final Optional<Boolean> m6187l() {
        m6144p();
        TracerDetour.a("FbActivityListeners.onSearchRequest", 403552780);
        try {
            for (FbActivityListener a : this.f3743c) {
                Optional<Boolean> a2 = a.mo244a();
                if (a2.isPresent()) {
                    return a2;
                }
            }
            TracerDetour.a(1120274272);
            m6145q();
            return Absent.withType();
        } finally {
            TracerDetour.a(6015306);
            m6145q();
        }
    }

    final Optional<Boolean> m6148a(int i, KeyEvent keyEvent) {
        m6144p();
        TracerDetour.a("FbActivityListeners.onKeyDown", -1567947330);
        try {
            for (FbActivityListener a : this.f3743c) {
                Optional<Boolean> a2 = a.mo245a(this.f3745e, i, keyEvent);
                if (a2.isPresent()) {
                    return a2;
                }
            }
            TracerDetour.a(1181275041);
            m6145q();
            return Absent.withType();
        } finally {
            TracerDetour.a(-880433875);
            m6145q();
        }
    }

    final Optional<Boolean> m6167b(int i, KeyEvent keyEvent) {
        m6144p();
        TracerDetour.a("FbActivityListeners.onKeyUp", -207701531);
        try {
            for (FbActivityListener b : this.f3743c) {
                Optional<Boolean> b2 = b.mo254b(this.f3745e, i, keyEvent);
                if (b2.isPresent()) {
                    return b2;
                }
            }
            TracerDetour.a(5152869);
            m6145q();
            return Absent.withType();
        } finally {
            TracerDetour.a(-1803191943);
            m6145q();
        }
    }

    final void m6188m() {
        m6144p();
        TracerDetour.a("FbActivityListeners.finish", -280541786);
        try {
            for (FbActivityListener g : this.f3743c) {
                g.mo258g(this.f3745e);
            }
        } finally {
            TracerDetour.a(-2036062952);
            m6145q();
        }
    }

    final void m6189n() {
        m6144p();
        TracerDetour.a("FbActivityListeners.onContentCreated", -613798612);
        try {
            Iterator it = this.f3743c.iterator();
            while (it.hasNext()) {
                it.next();
            }
        } finally {
            TracerDetour.a(793095106);
            m6145q();
        }
    }

    final void m6160a(boolean z) {
        m6144p();
        TracerDetour.a("FbActivityListeners.onWindowFocusChanged", 136529153);
        try {
            Iterator it = this.f3743c.iterator();
            while (it.hasNext()) {
                it.next();
            }
        } finally {
            TracerDetour.a(1834476569);
            m6145q();
        }
    }

    final Dialog m6174c(int i) {
        m6144p();
        TracerDetour.a("FbActivityListeners.onCreateDialog", 1492285008);
        try {
            for (FbActivityListener a : this.f3743c) {
                Dialog a2 = a.mo243a(i);
                if (a2 != null) {
                    return a2;
                }
            }
            TracerDetour.a(571105069);
            m6145q();
            return null;
        } finally {
            TracerDetour.a(2136746429);
            m6145q();
        }
    }

    final boolean m6161a(int i, Dialog dialog) {
        m6144p();
        TracerDetour.a("FbActivityListeners.onPrepareDialog", 687284057);
        try {
            for (FbActivityListener a : this.f3743c) {
                if (a.mo252a(i, dialog)) {
                    return true;
                }
            }
            TracerDetour.a(-1874991970);
            m6145q();
            return false;
        } finally {
            TracerDetour.a(374384280);
            m6145q();
        }
    }

    final boolean m6190o() {
        m6144p();
        TracerDetour.a("FbActivityListeners.onBackPressed", -397774479);
        try {
            for (FbActivityListener i : this.f3743c) {
                if (i.mo260i(this.f3745e)) {
                    return true;
                }
            }
            TracerDetour.a(-1300432862);
            m6145q();
            return false;
        } finally {
            TracerDetour.a(790959011);
            m6145q();
        }
    }

    final void m6155a(Configuration configuration) {
        m6144p();
        TracerDetour.a("FbActivityListeners.onConfigurationChanged", 1137321572);
        try {
            for (FbActivityListener a : this.f3743c) {
                a.mo248a(this.f3745e, configuration);
            }
        } finally {
            TracerDetour.a(-1017783488);
            m6145q();
        }
    }

    final void m6157a(Menu menu) {
        m6144p();
        TracerDetour.a("FbActivityListeners.onCreateOptionsMenu", -200224186);
        try {
            Iterator it = this.f3743c.iterator();
            while (it.hasNext()) {
                it.next();
            }
        } finally {
            TracerDetour.a(-1149111797);
            m6145q();
        }
    }

    final void m6168b(Menu menu) {
        m6144p();
        TracerDetour.a("FbActivityListeners.onPrepareOptionsMenu", -1186039755);
        try {
            Iterator it = this.f3743c.iterator();
            while (it.hasNext()) {
                it.next();
            }
        } finally {
            TracerDetour.a(596647941);
            m6145q();
        }
    }

    final boolean m6163a(MenuItem menuItem) {
        m6144p();
        TracerDetour.a("FbActivityListeners.onOptionsItemSelected", 1623552787);
        try {
            for (FbActivityListener b : this.f3743c) {
                if (b.mo257b()) {
                    return true;
                }
            }
            TracerDetour.a(-903211423);
            m6145q();
            return false;
        } finally {
            TracerDetour.a(-1062563265);
            m6145q();
        }
    }

    final void m6152a(int i, int i2, Intent intent) {
        m6144p();
        TracerDetour.a("FbActivityListeners.onActivityResult", -1955364585);
        try {
            for (FbActivityListener a : this.f3743c) {
                a.mo246a(this.f3745e, i, i2, intent);
            }
        } finally {
            TracerDetour.a(-2118536266);
            m6145q();
        }
    }

    final void m6178d(int i) {
        m6144p();
        TracerDetour.a("FbActivityListeners.onTrimMemory", 1933100203);
        try {
            Iterator it = this.f3743c.iterator();
            while (it.hasNext()) {
                it.next();
            }
        } finally {
            TracerDetour.a(1255634127);
            m6145q();
        }
    }

    final void m6156a(Fragment fragment) {
        m6144p();
        TracerDetour.a("FbActivityListeners.onAttachFragment", -661046804);
        try {
            for (FbActivityListener a : this.f3743c) {
                a.mo250a(this.f3745e, fragment);
            }
        } finally {
            TracerDetour.a(828774584);
            m6145q();
        }
    }

    final void m6159a(CharSequence charSequence, int i) {
        m6144p();
        TracerDetour.a("FbActivityListeners.onTitleChanged", 1469503793);
        try {
            Iterator it = this.f3743c.iterator();
            while (it.hasNext()) {
                it.next();
            }
        } finally {
            TracerDetour.a(394197727);
            m6145q();
        }
    }

    private void m6146r() {
        if (!this.f3741a) {
            this.f3741a = true;
            m6144p();
            TracerDetour.a("FbActivityListeners.activate", -1793612652);
            try {
                Iterator it = this.f3743c.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            } finally {
                TracerDetour.a(649230325);
                m6145q();
            }
        }
    }
}
