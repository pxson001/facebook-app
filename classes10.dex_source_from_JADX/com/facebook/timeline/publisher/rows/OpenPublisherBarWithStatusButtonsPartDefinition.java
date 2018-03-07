package com.facebook.timeline.publisher.rows;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import com.facebook.common.locale.Locales;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.inlinecomposer.InlineComposerView;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.environment.TimelineEnvironment;
import com.facebook.timeline.publisher.TimelinePublisherBarModel;
import com.facebook.timeline.publisher.utils.OpenPublisherListenerHelper;
import com.facebook.user.model.User;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: failed to get privacy options */
public class OpenPublisherBarWithStatusButtonsPartDefinition extends MultiRowSinglePartDefinition<TimelinePublisherBarModel, State, TimelineEnvironment, InlineComposerView> {
    public static final ViewType<InlineComposerView> f12436a = new C17551();
    private static OpenPublisherBarWithStatusButtonsPartDefinition f12437g;
    private static final Object f12438h = new Object();
    private final Provider<User> f12439b;
    private final OpenPublisherListenerHelper f12440c;
    private final ClickListenerPartDefinition f12441d;
    private final Locales f12442e;
    private final QeAccessor f12443f;

    /* compiled from: failed to get privacy options */
    final class C17551 extends ViewType<InlineComposerView> {
        C17551() {
        }

        public final View m12469a(Context context) {
            return new InlineComposerView(context);
        }
    }

    /* compiled from: failed to get privacy options */
    public class State {
        public final Uri f12429a;
        public final int f12430b;
        public final int f12431c;
        public final int f12432d;
        public final int f12433e;
        public final boolean f12434f;
        public final String f12435g;

        public State(Uri uri, int i, int i2, int i3, int i4, boolean z, String str) {
            this.f12429a = uri;
            this.f12430b = i;
            this.f12431c = i2;
            this.f12432d = i3;
            this.f12433e = i4;
            this.f12434f = z;
            this.f12435g = str;
        }
    }

    private static OpenPublisherBarWithStatusButtonsPartDefinition m12474b(InjectorLike injectorLike) {
        return new OpenPublisherBarWithStatusButtonsPartDefinition(IdBasedProvider.a(injectorLike, 3595), OpenPublisherListenerHelper.m12486a(injectorLike), ClickListenerPartDefinition.a(injectorLike), Locales.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m12476a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        int i;
        TimelineEnvironment timelineEnvironment = (TimelineEnvironment) anyEnvironment;
        boolean z = timelineEnvironment.c().a() == FeedListName.MY_TIMELINE;
        subParts.a(2131561925, this.f12441d, this.f12440c.m12488a());
        subParts.a(2131561926, this.f12441d, this.f12440c.m12489a(((User) this.f12439b.get()).a));
        subParts.a(2131561933, this.f12441d, this.f12440c.m12488a());
        subParts.a(2131561934, this.f12441d, this.f12440c.m12490b());
        if (z) {
            subParts.a(2131561935, this.f12441d, this.f12440c.m12491c());
        }
        int i2 = z ? 2131234528 : 2131234538;
        int i3 = z ? 2131234879 : 2131234876;
        int i4 = z ? 2131234840 : 2131234842;
        if (z) {
            i = 2131234881;
        } else {
            i = 0;
        }
        return new State(Uri.parse(((User) this.f12439b.get()).x()), i2, i3, i4, i, z, timelineEnvironment.mo519l());
    }

    public final /* bridge */ /* synthetic */ void m12477a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1883716512);
        m12473a((State) obj2, (InlineComposerView) view);
        Logger.a(8, EntryType.MARK_POP, -131428154, a);
    }

    public static OpenPublisherBarWithStatusButtonsPartDefinition m12470a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OpenPublisherBarWithStatusButtonsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12438h) {
                OpenPublisherBarWithStatusButtonsPartDefinition openPublisherBarWithStatusButtonsPartDefinition;
                if (a2 != null) {
                    openPublisherBarWithStatusButtonsPartDefinition = (OpenPublisherBarWithStatusButtonsPartDefinition) a2.a(f12438h);
                } else {
                    openPublisherBarWithStatusButtonsPartDefinition = f12437g;
                }
                if (openPublisherBarWithStatusButtonsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12474b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12438h, b3);
                        } else {
                            f12437g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = openPublisherBarWithStatusButtonsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public OpenPublisherBarWithStatusButtonsPartDefinition(Provider<User> provider, OpenPublisherListenerHelper openPublisherListenerHelper, ClickListenerPartDefinition clickListenerPartDefinition, Locales locales, QeAccessor qeAccessor) {
        this.f12439b = provider;
        this.f12440c = openPublisherListenerHelper;
        this.f12441d = clickListenerPartDefinition;
        this.f12442e = locales;
        this.f12443f = qeAccessor;
    }

    public final ViewType<InlineComposerView> m12475a() {
        return f12436a;
    }

    public final boolean m12478a(Object obj) {
        return true;
    }

    private void m12473a(State state, InlineComposerView inlineComposerView) {
        int dimensionPixelSize = inlineComposerView.getResources().getDimensionPixelSize(2131429916);
        inlineComposerView.setBackgroundResource(2130841781);
        inlineComposerView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        inlineComposerView.f.a(state.f12429a, InlineComposerView.a);
        inlineComposerView.g.setText(m12472a(inlineComposerView.getContext().getResources().getString(state.f12430b), state.f12435g, state.f12434f));
        inlineComposerView.b.setText(m12471a(inlineComposerView.getContext().getResources(), state.f12431c));
        inlineComposerView.c.setText(m12471a(inlineComposerView.getContext().getResources(), state.f12432d));
        if (state.f12434f) {
            inlineComposerView.d.setText(m12471a(inlineComposerView.getContext().getResources(), state.f12433e));
            inlineComposerView.setCheckInButtonVisibility(0);
            inlineComposerView.d.setImageResource(2130841040);
            return;
        }
        inlineComposerView.setCheckInButtonVisibility(8);
    }

    private String m12471a(Resources resources, int i) {
        return resources.getString(i).toUpperCase(this.f12442e.a());
    }

    private String m12472a(String str, String str2, boolean z) {
        if (StringUtil.a(str2)) {
            return str;
        }
        Object a;
        if (z) {
            if (!this.f12443f.a(ExperimentsForTimelineAbTestModule.c, false)) {
                return str;
            }
            a = this.f12443f.a(ExperimentsForTimelineAbTestModule.d, null);
            if (StringUtil.a(a)) {
                return str;
            }
            return a.replace("{name}", str2);
        } else if (!this.f12443f.a(ExperimentsForTimelineAbTestModule.S, false)) {
            return str;
        } else {
            a = this.f12443f.a(ExperimentsForTimelineAbTestModule.T, null);
            return !StringUtil.a(a) ? a.replace("{name}", str2) : str;
        }
    }
}
