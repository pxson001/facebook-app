package com.facebook.timeline.header;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.nux.interstitial.SeeFirstPromptNuxController;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.qe.api.QeAccessor;
import com.facebook.resources.ui.FbTextView;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.actionbar.TimelineActionBar;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.header.SeeFirstInterstitialHelper.C16401;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.header.ui.CaspianTimelineStandardHeader;
import com.facebook.timeline.prefs.TimelinePreferencesKeys;
import com.facebook.timeline.refresher.launcher.ProfileRefresherConfiguration;
import com.facebook.timeline.refresher.launcher.ProfileRefresherConfiguration.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: friend_list_opened */
public class TimelineHeaderTopAdapter extends TimelineHeaderAbstractAdapter {
    private final Lazy<ProfileNuxEntryViewBinder> f11430e;
    private final ManageInterstitialHelper f11431f;
    private final SeeFirstInterstitialHelper f11432g;
    public final FbSharedPreferences f11433h;
    private final boolean f11434i;
    @Nullable
    public CaspianTimelineStandardHeader f11435j;

    /* compiled from: friend_list_opened */
    public enum Part {
        NUX,
        COVER_PHOTO,
        ACTION_BAR;
        
        private static Part[] mValues;

        public static Part[] cachedValues() {
            if (mValues == null) {
                mValues = values();
            }
            return mValues;
        }
    }

    @Inject
    public TimelineHeaderTopAdapter(@Assisted Context context, @Assisted TimelineUserContext timelineUserContext, @Assisted TimelineHeaderUserData timelineHeaderUserData, @Assisted boolean z, QeAccessor qeAccessor, Lazy<ProfileNuxEntryViewBinder> lazy, ManageInterstitialHelper manageInterstitialHelper, SeeFirstInterstitialHelper seeFirstInterstitialHelper, FbSharedPreferences fbSharedPreferences) {
        super(context, qeAccessor, timelineUserContext, timelineHeaderUserData);
        this.f11430e = lazy;
        this.f11431f = manageInterstitialHelper;
        this.f11432g = seeFirstInterstitialHelper;
        this.f11433h = fbSharedPreferences;
        this.f11434i = z;
    }

    public final View m11478a(int i, ViewGroup viewGroup) {
        Part part = Part.cachedValues()[i];
        part.toString();
        switch (part) {
            case NUX:
                return new ProfileNuxEntryView(this.f11327a);
            case COVER_PHOTO:
                if (this.f11328b.a(ExperimentsForTimelineAbTestModule.ah, false)) {
                    this.f11435j = new CaspianTimelineStandardHeader(new ContextThemeWrapper(this.f11327a, 2131624517));
                } else {
                    this.f11435j = new CaspianTimelineStandardHeader(this.f11327a);
                }
                this.f11435j.f11958G = this.f11434i;
                return this.f11435j;
            case ACTION_BAR:
                return LayoutInflater.from(viewGroup.getContext()).inflate(2130907630, viewGroup, false);
            default:
                return TimelineHeaderAbstractAdapter.m11411b(i);
        }
    }

    public final boolean mo523a(View view, int i) {
        Part part = Part.cachedValues()[i];
        part.toString();
        if (part == Part.NUX && (view instanceof ProfileNuxEntryView)) {
            View a = ((ProfileNuxEntryView) view).a(2131566362);
            ((ProfileNuxEntryViewBinder) this.f11430e.get()).m11398a(m11476c(), String.valueOf(this.f11329c.g()), ((ProfileNuxEntryView) view).f11294a, ((ProfileNuxEntryView) view).f11295b, (FbTextView) a.findViewById(2131566364), (FbTextView) a.findViewById(2131566365), this.f11330d.l.c().a(), this.f11330d.l.a().a(), a, null);
            return false;
        } else if (part == Part.COVER_PHOTO && (view instanceof CaspianTimelineStandardHeader)) {
            return ((CaspianTimelineStandardHeader) view).m12022a(this.f11329c, this.f11330d);
        } else {
            if (part != Part.ACTION_BAR || !(view instanceof TimelineActionBar)) {
                return TimelineHeaderAbstractAdapter.m11412c(i);
            }
            TimelineActionBar timelineActionBar = (TimelineActionBar) view;
            timelineActionBar.m10349a(this.f11330d, this.f11329c);
            m11475a(timelineActionBar, this.f11330d);
            return true;
        }
    }

    protected final int mo520a() {
        return Part.cachedValues().length;
    }

    protected final void mo522a(boolean[] zArr) {
        boolean z;
        int ordinal = Part.NUX.ordinal();
        if (!this.f11434i) {
            boolean z2 = true;
            if (this.f11330d.l == null || !this.f11330d.l.b() || !this.f11433h.a(TimelinePreferencesKeys.b, true) || this.f11328b.a(ExperimentsForTimelineAbTestModule.aC, false)) {
                z2 = false;
            }
            if (z2) {
                z = true;
                zArr[ordinal] = z;
                zArr[Part.COVER_PHOTO.ordinal()] = true;
                zArr[Part.ACTION_BAR.ordinal()] = true;
            }
        }
        z = false;
        zArr[ordinal] = z;
        zArr[Part.COVER_PHOTO.ordinal()] = true;
        zArr[Part.ACTION_BAR.ordinal()] = true;
    }

    protected final Object mo521a(int i) {
        return Part.cachedValues()[i];
    }

    public int getViewTypeCount() {
        return Part.cachedValues().length;
    }

    public int getItemViewType(int i) {
        return ((Part) getItem(i)).ordinal();
    }

    private ProfileRefresherConfiguration m11476c() {
        String str = (this.f11330d.K() == null || this.f11330d.K().b() == null) ? null : this.f11330d.K().b().toString();
        Builder builder = new Builder();
        builder.a = this.f11330d.N();
        builder = builder;
        builder.b = String.valueOf(this.f11329c.b);
        builder = builder;
        builder.c = str;
        Builder builder2 = builder;
        builder2.d = this.f11330d.R();
        builder2 = builder2;
        builder2.e = false;
        builder2 = builder2;
        builder2.f = this.f11330d.U();
        return builder2.a();
    }

    private void m11475a(TimelineActionBar timelineActionBar, TimelineHeaderUserData timelineHeaderUserData) {
        Object obj;
        if (timelineHeaderUserData.d == null || !timelineHeaderUserData.d.b()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            this.f11431f.m11396a(timelineActionBar, timelineHeaderUserData);
        } else if (!timelineHeaderUserData.j() && !timelineHeaderUserData.r()) {
            SeeFirstInterstitialHelper seeFirstInterstitialHelper = this.f11432g;
            boolean z = timelineHeaderUserData.k;
            if (!(timelineActionBar == null || seeFirstInterstitialHelper.f11319c)) {
                SeeFirstPromptNuxController seeFirstPromptNuxController = (SeeFirstPromptNuxController) seeFirstInterstitialHelper.f11317a.a(new InterstitialTrigger(Action.TIMELINE), SeeFirstPromptNuxController.class);
                if (seeFirstPromptNuxController != null && z) {
                    timelineActionBar.post(new C16401(seeFirstInterstitialHelper, timelineActionBar, seeFirstPromptNuxController));
                }
            }
        }
    }
}
