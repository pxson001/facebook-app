package com.facebook.notifications.widget;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.FbInjector;
import com.facebook.tablet.abtest.TabletColumnLayoutManager;
import com.facebook.tablet.abtest.TabletExperimentConfiguration;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ListViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.refreshableview.RefreshableViewContainerLike;
import javax.inject.Inject;

/* compiled from: exception_type */
public class DefaultNotificationsView extends CustomLinearLayout implements NotificationsView {
    @Inject
    public TabletExperimentConfiguration f12715a;
    @Inject
    public TabletColumnLayoutManager f12716b;
    @Inject
    public AbstractFbErrorReporter f12717c;
    private ListViewProxy f12718d;
    private LoadingIndicatorView f12719e;
    private FbSwipeRefreshLayout f12720f;
    private RetryClickedListener f12721g;

    private static <T extends View> void m13521a(Class<T> cls, T t) {
        m13522a((Object) t, t.getContext());
    }

    private static void m13522a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        DefaultNotificationsView defaultNotificationsView = (DefaultNotificationsView) obj;
        TabletExperimentConfiguration a = TabletExperimentConfiguration.a(fbInjector);
        TabletColumnLayoutManager a2 = TabletColumnLayoutManager.a(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        defaultNotificationsView.f12715a = a;
        defaultNotificationsView.f12716b = a2;
        defaultNotificationsView.f12717c = abstractFbErrorReporter;
    }

    public DefaultNotificationsView(Context context) {
        super(context);
        m13523b();
    }

    private void m13523b() {
        m13521a(DefaultNotificationsView.class, (View) this);
        setContentView(2130905501);
        this.f12720f = (FbSwipeRefreshLayout) a(2131561342);
        setOrientation(1);
        try {
            this.f12718d = new ListViewProxy((BetterListView) a(16908298));
            this.f12719e = (LoadingIndicatorView) a(2131560407);
            TypedValue typedValue = new TypedValue();
            getContext().getTheme().resolveAttribute(2130772382, typedValue, true);
            this.f12718d.m13611k();
            this.f12719e.setBackgroundResource(typedValue.resourceId);
            this.f12720f.setBackgroundResource(typedValue.resourceId);
            m13524c();
        } catch (Throwable e) {
            View a = a(16908298);
            ClassLoader classLoader = a.getClass().getClassLoader();
            ClassLoader classLoader2 = BetterListView.class.getClassLoader();
            ClassLoader classLoader3 = NotificationsListView.class.getClassLoader();
            StringBuilder stringBuilder = new StringBuilder();
            this.f12717c.b("CLASSCAST_ERROR", StringFormatUtil.formatStrLocaleSafe("The view itself is of class %s\nand its loader tree is:\n %s\n>><<\nThe loader tree for BetterListView is:\n %s\n>><<The loader tree for NotificationsListView is:\n%s\n>><<", a.getClass().getCanonicalName(), m13520a(classLoader, stringBuilder), m13520a(classLoader2, stringBuilder), m13520a(classLoader3, stringBuilder)), e);
            throw e;
        }
    }

    private String m13520a(ClassLoader classLoader, StringBuilder stringBuilder) {
        stringBuilder.append(StringFormatUtil.formatStrLocaleSafe("%s ^^\n Hashcode %d <<>>\n", classLoader.toString(), Integer.valueOf(classLoader.hashCode())));
        if (classLoader.getParent() != null && !classLoader.getParent().equals(classLoader)) {
            return m13520a(classLoader.getParent(), stringBuilder);
        }
        String stringBuilder2 = stringBuilder.toString();
        stringBuilder.setLength(0);
        return stringBuilder2;
    }

    public final void mo916a() {
        m13524c();
    }

    public RefreshableViewContainerLike getRefreshableContainerLike() {
        return null;
    }

    public FbSwipeRefreshLayout getSwipeRefreshLayout() {
        return this.f12720f;
    }

    public final void mo918a(boolean z) {
        this.f12719e.setVisibility(z ? 0 : 8);
    }

    public final void mo919b(boolean z) {
        if (z) {
            this.f12719e.a();
        } else {
            this.f12719e.b();
        }
    }

    public final void mo920c(boolean z) {
        if (z) {
            this.f12719e.a(getResources().getString(2131230811), this.f12721g);
        } else {
            this.f12719e.b();
        }
    }

    public BetterListView getListView() {
        return this.f12718d.m13593d();
    }

    public ScrollingViewProxy getScrollingViewProxy() {
        return this.f12718d;
    }

    public final void mo917a(OnClickListener onClickListener, RetryClickedListener retryClickedListener) {
        this.f12721g = retryClickedListener;
        a(2131564285).setOnClickListener(onClickListener);
    }

    private void m13524c() {
        if (this.f12715a.a()) {
            this.f12716b.a(ContentFragmentType.NOTIFICATIONS_FRAGMENT, getContext(), this.f12720f, 2130772382);
        }
    }
}
