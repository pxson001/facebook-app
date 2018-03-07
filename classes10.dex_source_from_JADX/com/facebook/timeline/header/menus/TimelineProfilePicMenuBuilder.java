package com.facebook.timeline.header.menus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.ipc.profile.TimelineContext.TimelineType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_attending_activity */
public class TimelineProfilePicMenuBuilder {
    private static TimelineProfilePicMenuBuilder f11935c;
    private static final Object f11936d = new Object();
    private final QeAccessor f11937a;
    public final ProfileControllerDelegate f11938b;

    /* compiled from: fetch_attending_activity */
    public class C17161 implements OnMenuItemClickListener {
        final /* synthetic */ TimelineProfilePicMenuBuilder f11929a;

        public C17161(TimelineProfilePicMenuBuilder timelineProfilePicMenuBuilder) {
            this.f11929a = timelineProfilePicMenuBuilder;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f11929a.f11938b.mo473l().mo549c();
            return true;
        }
    }

    /* compiled from: fetch_attending_activity */
    class C17183 implements OnMenuItemClickListener {
        final /* synthetic */ TimelineProfilePicMenuBuilder f11932a;

        C17183(TimelineProfilePicMenuBuilder timelineProfilePicMenuBuilder) {
            this.f11932a = timelineProfilePicMenuBuilder;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f11932a.f11938b.mo473l().mo548b();
            return true;
        }
    }

    /* compiled from: fetch_attending_activity */
    class C17194 implements OnMenuItemClickListener {
        final /* synthetic */ TimelineProfilePicMenuBuilder f11933a;

        C17194(TimelineProfilePicMenuBuilder timelineProfilePicMenuBuilder) {
            this.f11933a = timelineProfilePicMenuBuilder;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f11933a.f11938b.mo473l().mo546a();
            return true;
        }
    }

    /* compiled from: fetch_attending_activity */
    class C17205 implements OnMenuItemClickListener {
        final /* synthetic */ TimelineProfilePicMenuBuilder f11934a;

        C17205(TimelineProfilePicMenuBuilder timelineProfilePicMenuBuilder) {
            this.f11934a = timelineProfilePicMenuBuilder;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f11934a.f11938b.mo473l().mo550d();
            return true;
        }
    }

    private static TimelineProfilePicMenuBuilder m11977b(InjectorLike injectorLike) {
        return new TimelineProfilePicMenuBuilder(ProfileControllerDelegate.m10751a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public TimelineProfilePicMenuBuilder(ProfileControllerDelegate profileControllerDelegate, QeAccessor qeAccessor) {
        this.f11938b = profileControllerDelegate;
        this.f11937a = qeAccessor;
    }

    public final PopoverMenuWindow m11979a(Context context, TimelineContext timelineContext, boolean z, boolean z2, boolean z3, OnMenuItemClickListener onMenuItemClickListener) {
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(context);
        PopoverMenu c = figPopoverMenuWindow.c();
        boolean a = this.f11937a.a(ExperimentsForTimelineAbTestModule.aK, false);
        boolean a2 = this.f11937a.a(ExperimentsForTimelineAbTestModule.aI, false);
        if (a) {
            c.a(2131234992).setOnMenuItemClickListener(new C17161(this));
        }
        if (a || !a2) {
            m11976a(c, a, a2);
        }
        if (timelineContext != null && timelineContext.e == TimelineType.USER) {
            m11974a(c, a2);
        }
        if (z) {
            m11975a(c, z2, onMenuItemClickListener);
        }
        if (!this.f11937a.a(ExperimentsForTimelineAbTestModule.aK, false) && this.f11937a.a(ExperimentsForTimelineAbTestModule.aS, false)) {
            m11973a(context, c);
        }
        if (z3) {
            m11978b(c);
        }
        return figPopoverMenuWindow;
    }

    public static TimelineProfilePicMenuBuilder m11972a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineProfilePicMenuBuilder b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11936d) {
                TimelineProfilePicMenuBuilder timelineProfilePicMenuBuilder;
                if (a2 != null) {
                    timelineProfilePicMenuBuilder = (TimelineProfilePicMenuBuilder) a2.a(f11936d);
                } else {
                    timelineProfilePicMenuBuilder = f11935c;
                }
                if (timelineProfilePicMenuBuilder == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11977b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11936d, b3);
                        } else {
                            f11935c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineProfilePicMenuBuilder;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private void m11973a(final Context context, PopoverMenu popoverMenu) {
        popoverMenu.a(2131234993).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ TimelineProfilePicMenuBuilder f11931b;

            public boolean onMenuItemClick(MenuItem menuItem) {
                new FbAlertDialogBuilder(context).b(LayoutInflater.from(context).inflate(2130906483, null)).a(context.getString(2131230726), null).a().show();
                return true;
            }
        });
    }

    private void m11976a(PopoverMenu popoverMenu, boolean z, boolean z2) {
        int i = z2 ? 2131234985 : 2131234986;
        if (!z) {
            i = 2131234984;
        }
        popoverMenu.a(i).setOnMenuItemClickListener(new C17183(this));
    }

    private void m11974a(PopoverMenu popoverMenu, boolean z) {
        popoverMenu.a(z ? 2131234989 : 2131234988).setOnMenuItemClickListener(new C17194(this));
    }

    private void m11978b(PopoverMenu popoverMenu) {
        popoverMenu.a(2131235059).setOnMenuItemClickListener(new C17205(this));
    }

    private void m11975a(PopoverMenu popoverMenu, boolean z, OnMenuItemClickListener onMenuItemClickListener) {
        int i = (this.f11937a.a(ExperimentsForTimelineAbTestModule.aS, false) && z) ? 2131234976 : 2131234974;
        popoverMenu.a(i).setOnMenuItemClickListener(onMenuItemClickListener);
    }
}
