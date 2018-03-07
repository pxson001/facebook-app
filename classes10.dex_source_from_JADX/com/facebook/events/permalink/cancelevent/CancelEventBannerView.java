package com.facebook.events.permalink.cancelevent;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.MetricAffectingSpan;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventViewerCapability;
import com.facebook.events.permalink.actionbar.ActionItemDelete;
import com.facebook.events.permalink.actionbar.EventActionsHandlerUtil;
import com.facebook.events.permalink.actionbar.EventActionsHandlerUtilProvider;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

/* compiled from: button0Title */
public class CancelEventBannerView extends CustomLinearLayout {
    @Inject
    ActionItemDelete f18304a;
    @Inject
    EventActionsHandlerUtilProvider f18305b;
    private MetricAffectingSpan f18306c;
    private MetricAffectingSpan f18307d;
    private Resources f18308e;
    public GlyphView f18309f;
    public Event f18310g;
    public EventActionsHandlerUtil f18311h;

    /* compiled from: button0Title */
    class C25961 implements OnClickListener {
        final /* synthetic */ CancelEventBannerView f18303a;

        /* compiled from: button0Title */
        class C25921 implements OnMenuItemClickListener {
            final /* synthetic */ C25961 f18299a;

            C25921(C25961 c25961) {
                this.f18299a = c25961;
            }

            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f18299a.f18303a.f18304a.m18343a(ActionMechanism.PERMALINK_ACTION_BAR);
                return true;
            }
        }

        /* compiled from: button0Title */
        class C25932 implements OnMenuItemClickListener {
            final /* synthetic */ C25961 f18300a;

            C25932(C25961 c25961) {
                this.f18300a = c25961;
            }

            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f18300a.f18303a.f18311h.m18422a(null, null);
                return true;
            }
        }

        /* compiled from: button0Title */
        class C25943 implements OnMenuItemClickListener {
            final /* synthetic */ C25961 f18301a;

            C25943(C25961 c25961) {
                this.f18301a = c25961;
            }

            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f18301a.f18303a.f18311h.m18421a();
                return true;
            }
        }

        /* compiled from: button0Title */
        class C25954 implements OnMenuItemClickListener {
            final /* synthetic */ C25961 f18302a;

            C25954(C25961 c25961) {
                this.f18302a = c25961;
            }

            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f18302a.f18303a.f18311h.m18424c();
                return true;
            }
        }

        C25961(CancelEventBannerView cancelEventBannerView) {
            this.f18303a = cancelEventBannerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1971775482);
            FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(this.f18303a.getContext());
            PopoverMenu c = figPopoverMenuWindow.c();
            if (this.f18303a.f18310g.a(EventViewerCapability.ADMIN)) {
                c.a(2131237052).setOnMenuItemClickListener(new C25921(this));
                c.a(2131237049).setOnMenuItemClickListener(new C25932(this));
            } else {
                c.a(2131237046).setOnMenuItemClickListener(new C25943(this));
                c.a(2131237048).setOnMenuItemClickListener(new C25954(this));
            }
            figPopoverMenuWindow.f(this.f18303a.f18309f);
            LogUtils.a(-185239794, a);
        }
    }

    private static <T extends View> void m18647a(Class<T> cls, T t) {
        m18648a((Object) t, t.getContext());
    }

    private static void m18648a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((CancelEventBannerView) obj).m18646a(ActionItemDelete.m18341b(fbInjector), (EventActionsHandlerUtilProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(EventActionsHandlerUtilProvider.class));
    }

    public CancelEventBannerView(Context context) {
        super(context);
        m18645a();
    }

    public CancelEventBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18645a();
    }

    public CancelEventBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18645a();
    }

    private void m18645a() {
        m18647a(CancelEventBannerView.class, (View) this);
        setContentView(2130904059);
        this.f18308e = getResources();
        setOrientation(0);
        setLayoutParams(new LayoutParams(-1, -2));
        setBackgroundResource(2131361934);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131431322);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.f18306c = new TextAppearanceSpan(getContext(), 2131625301);
        this.f18307d = new TextAppearanceSpan(getContext(), 2131625302);
        ((BetterTextView) a(2131561346)).setText(getBannerText());
        this.f18309f = (GlyphView) a(2131561347);
        this.f18309f.setOnClickListener(m18649b());
    }

    public final void m18652a(Event event, EventAnalyticsParams eventAnalyticsParams) {
        this.f18310g = event;
        this.f18311h = this.f18305b.m18426a(event, eventAnalyticsParams);
        this.f18304a.m18344a(event, eventAnalyticsParams);
    }

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    private SpannableStringBuilder getBannerText() {
        String string = this.f18308e.getString(2131237253);
        Object obj = string + "\n" + this.f18308e.getString(2131237254);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        spannableStringBuilder.setSpan(this.f18306c, 0, string.length(), 17);
        spannableStringBuilder.setSpan(this.f18307d, string.length() + 1, obj.length(), 17);
        return spannableStringBuilder;
    }

    private OnClickListener m18649b() {
        return new C25961(this);
    }

    private void m18646a(ActionItemDelete actionItemDelete, EventActionsHandlerUtilProvider eventActionsHandlerUtilProvider) {
        this.f18304a = actionItemDelete;
        this.f18305b = eventActionsHandlerUtilProvider;
    }
}
