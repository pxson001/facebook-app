package com.facebook.timeline.actionbar;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.internal.view.SupportMenuItem;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.auth.annotations.IsMeUserAWorkUser;
import com.facebook.common.util.TriState;
import com.facebook.fbui.widget.inlineactionbar.InlineActionBar;
import com.facebook.fbui.widget.inlineactionbar.InlineActionBar.InlineActionBarMenuHandler;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.annotations.IsAddToGroupsMenuItemEnabled;
import com.facebook.timeline.data.NeedsFragmentCleanup;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.widget.actionbar.PersonActionBarItemConsumer;
import com.facebook.timeline.widget.actionbar.PersonActionBarItems;
import com.facebook.timeline.widget.actionbar.PersonActionBarItemsAnalytics;
import com.facebook.timeline.widget.actionbar.TimelineActionBarItemFactory;
import com.facebook.timeline.widget.actionbar.protocol.TimelineHeaderActionFieldsGraphQLInterfaces.TimelineHeaderActionFields;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.IViewAttachAware;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: groups_optimistic_post_failed */
public class TimelineActionBar extends InlineActionBar implements NeedsFragmentCleanup, PersonActionBarItemConsumer, IViewAttachAware {
    @Inject
    ProfileControllerDelegate f10245a;
    @Inject
    QeAccessor f10246b;
    @Inject
    @IsAddToGroupsMenuItemEnabled
    Provider<TriState> f10247c;
    @Inject
    @IsMeUserAWorkUser
    Provider<TriState> f10248d;
    @Inject
    TimelineActionBarItemFactory f10249e;
    private TimelineHeaderUserData f10250f;
    private int f10251g = 0;
    public boolean f10252h;
    private final ActionMenuItemHandler f10253i = new ActionMenuItemHandler(this);
    private final Lazy<OnClickListener> f10254j = new C15131(this);

    /* compiled from: groups_optimistic_post_failed */
    class C15131 implements Lazy<OnClickListener> {
        final /* synthetic */ TimelineActionBar f10243a;

        /* compiled from: groups_optimistic_post_failed */
        class C15121 implements OnClickListener {
            final /* synthetic */ C15131 f10242a;

            C15121(C15131 c15131) {
                this.f10242a = c15131;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1339289918);
                this.f10242a.f10243a.f10245a.mo474m().mo486a();
                Logger.a(2, EntryType.UI_INPUT_END, 1926132353, a);
            }
        }

        C15131(TimelineActionBar timelineActionBar) {
            this.f10243a = timelineActionBar;
        }

        public Object get() {
            return new C15121(this);
        }
    }

    /* compiled from: groups_optimistic_post_failed */
    class ActionMenuItemHandler implements InlineActionBarMenuHandler {
        final /* synthetic */ TimelineActionBar f10244a;

        public ActionMenuItemHandler(TimelineActionBar timelineActionBar) {
            this.f10244a = timelineActionBar;
        }

        public final boolean m10335a(MenuItem menuItem) {
            if (menuItem.isEnabled()) {
                TimelineActionBar.m10343e(this.f10244a, menuItem.getItemId());
            }
            return true;
        }
    }

    private static <T extends View> void m10338a(Class<T> cls, T t) {
        m10339a((Object) t, t.getContext());
    }

    private static void m10339a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((TimelineActionBar) obj).m10337a(ProfileControllerDelegate.m10751a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 779), IdBasedProvider.a(injectorLike, 639), TimelineActionBarItemFactory.a(injectorLike));
    }

    private void m10337a(ProfileControllerDelegate profileControllerDelegate, QeAccessor qeAccessor, Provider<TriState> provider, Provider<TriState> provider2, TimelineActionBarItemFactory timelineActionBarItemFactory) {
        this.f10245a = profileControllerDelegate;
        this.f10246b = qeAccessor;
        this.f10247c = provider;
        this.f10248d = provider2;
        this.f10249e = timelineActionBarItemFactory;
    }

    public TimelineActionBar(Context context) {
        super(context);
        m10342e();
    }

    public TimelineActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10342e();
    }

    public TimelineActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10342e();
    }

    private void m10342e() {
        m10338a(TimelineActionBar.class, (View) this);
        m10344f();
    }

    private void m10344f() {
        int i = 0;
        boolean a = this.f10246b.a(ExperimentsForTimelineAbTestModule.ah, false);
        if (a) {
            i = getResources().getDimensionPixelSize(2131429931);
        }
        a(a, true, i);
    }

    public void setHasBeenAttached(boolean z) {
        this.f10252h = z;
    }

    public final boolean m10348a() {
        return this.f10252h;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -2040586959);
        super.onAttachedToWindow();
        this.f10252h = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -408096677, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -860087123);
        super.onDetachedFromWindow();
        this.f10252h = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1459780387, a);
    }

    public final boolean m10349a(TimelineHeaderUserData timelineHeaderUserData, TimelineContext timelineContext) {
        TracerDetour.a("TimelineActionBar.bindModel", -213445599);
        try {
            boolean b = m10341b(timelineHeaderUserData, timelineContext);
            return b;
        } finally {
            TracerDetour.a(1866959981);
        }
    }

    private boolean m10341b(TimelineHeaderUserData timelineHeaderUserData, TimelineContext timelineContext) {
        boolean z;
        boolean z2 = false;
        boolean z3 = timelineContext != null && timelineContext.i();
        if (this.f10248d.get() == TriState.YES) {
            z = true;
        } else {
            z = false;
        }
        if ((timelineHeaderUserData == null || timelineHeaderUserData.d == null || timelineContext == null) && !z3) {
            m10345g();
            return false;
        } else if (this.f10250f != null && this.f10251g >= this.f10250f.d) {
            return false;
        } else {
            this.f10250f = (TimelineHeaderUserData) Preconditions.checkNotNull(timelineHeaderUserData);
            setVisibility(0);
            b();
            clear();
            setMaxNumOfVisibleButtons(4);
            this.b = this.f10253i;
            setBackgroundDrawable(null);
            if (z3) {
                TimelineActionBarItemFactory.a(z, this);
            } else if (timelineHeaderUserData.d == 1) {
                setBackgroundDrawable(new ColorDrawable(-1));
            } else {
                TimelineActionBarItemFactory timelineActionBarItemFactory = this.f10249e;
                TimelineHeaderActionFields timelineHeaderActionFields = timelineHeaderUserData.d;
                boolean z4 = this.f10248d.get() == TriState.YES;
                if (this.f10247c.get() == TriState.YES) {
                    z2 = true;
                }
                timelineActionBarItemFactory.a(timelineHeaderActionFields, z4, z2, this);
            }
            d();
            forceLayout();
            this.f10251g = this.f10250f.d;
            return true;
        }
    }

    public final void m10346a(int i, @StringRes int i2, @DrawableRes int i3, int i4, boolean z, boolean z2) {
        m10347a(i, i2, i3, i4, z, z2, false, false);
    }

    public final void m10347a(@PersonActionBarItems int i, @StringRes int i2, @DrawableRes int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4) {
        SupportMenuItem b = m10340b(i, i2, i3, i4, z, z2, z3, z4);
        if (b != null && i == 9 && this.f10250f.m != null && this.f10250f.m.a() != null && this.f10250f.m.a().a() > 0) {
            TimelineActionBarWithBadgeView timelineActionBarWithBadgeView = new TimelineActionBarWithBadgeView(getContext());
            timelineActionBarWithBadgeView.setCount(this.f10250f.m.a().a());
            timelineActionBarWithBadgeView.setClickListener((OnClickListener) this.f10254j.get());
            b.setActionView(timelineActionBarWithBadgeView);
        }
    }

    @Nullable
    private SupportMenuItem m10340b(@PersonActionBarItems int i, @StringRes int i2, @DrawableRes int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4) {
        if (!z2) {
            return null;
        }
        SupportMenuItem a = a(0, i, 0, i2);
        a.setShowAsActionFlags(i4).setEnabled(z).setCheckable(z3).setChecked(z4);
        a.setIcon(i3);
        return a;
    }

    public final void m10350c() {
        this.b = null;
        this.f10250f = null;
        this.f10251g = 0;
    }

    private void m10345g() {
        clear();
        setVisibility(8);
    }

    public static void m10343e(@PersonActionBarItems TimelineActionBar timelineActionBar, int i) {
        TimelineActionBarController m = timelineActionBar.f10245a.mo474m();
        String a = PersonActionBarItemsAnalytics.a(i);
        switch (i) {
            case 0:
                m.mo487a(a);
                return;
            case 1:
                m.mo488a(a, timelineActionBar.findViewById(i));
                return;
            case 2:
                m.mo489a(a, "timeline_message_button");
                return;
            case 3:
                m.mo491b(a, "timeline_manage_button");
                return;
            case 4:
                m.mo492c(a);
                return;
            case 5:
                m.mo494d(a);
                return;
            case 6:
                m.mo495e(a);
                return;
            case 7:
                m.mo497g(a);
                return;
            case 8:
                m.mo498h(a);
                return;
            case 9:
                m.mo490b(a);
                return;
            case 10:
                m.mo499i(a);
                return;
            case 11:
                m.mo500j(a);
                return;
            case 12:
                m.mo501k(a);
                return;
            case 13:
                m.mo493c(a, "tap_activity_log_action_item");
                return;
            case 14:
                m.mo496f(a);
                return;
            default:
                throw new UnsupportedOperationException("Unknown item type for TimelineActionBar.getEvent " + i);
        }
    }
}
