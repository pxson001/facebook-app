package com.facebook.ui.titlebar.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.suggestions.nullstate.ContentDiscoveryNullStateSupplier;
import com.facebook.search.suggestions.nullstate.ContentDiscoveryNullStateSupplier.NewNullStateModuleSuggestionsListener;
import com.facebook.search.titlebar.GraphSearchTitleSearchBox;
import com.facebook.search.titlebar.GraphSearchTitleSearchBox.SearchBoxType;
import com.facebook.search.titlebar.TitleBarAnimators;
import com.facebook.ui.titlebar.Fb4aExpandingTitleBar;
import com.facebook.ui.titlebar.Fb4aTitleBar.TitleBarState;
import com.facebook.widget.titlebar.CanAnimateButtonSpecs;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: rewritten_uri */
public class Fb4aSearchTitleBar extends Fb4aExpandingTitleBar implements NewNullStateModuleSuggestionsListener, CanAnimateButtonSpecs {
    @Inject
    TitleBarAnimators f6590m;
    @Inject
    RTLUtil f6591n;
    @Inject
    Lazy<ContentDiscoveryNullStateSupplier> f6592o;
    @Inject
    QeAccessor f6593p;
    public GraphSearchTitleSearchBox f6594q;

    /* compiled from: rewritten_uri */
    /* synthetic */ class C03133 {
        static final /* synthetic */ int[] f7431a = new int[TitleBarState.values().length];

        static {
            try {
                f7431a[TitleBarState.SEARCH_TITLES_APP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    private static <T extends View> void m11426a(Class<T> cls, T t) {
        m11427a((Object) t, t.getContext());
    }

    private static void m11427a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((Fb4aSearchTitleBar) obj).m11425a(TitleBarAnimators.m11539b(injectorLike), RTLUtil.m6553a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3388), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public Fb4aSearchTitleBar(Context context) {
        this(context, null);
    }

    public Fb4aSearchTitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Fb4aSearchTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11426a(Fb4aSearchTitleBar.class, (View) this);
    }

    private boolean m11430k() {
        return this.f6594q != null;
    }

    public GraphSearchTitleSearchBox getSearchBox() {
        return this.f6594q;
    }

    public final void mo1610f() {
        if (m11431l()) {
            ((ContentDiscoveryNullStateSupplier) this.f6592o.get()).f19628n = this;
        }
    }

    public final void mo1243g() {
        if (m11431l()) {
            ((ContentDiscoveryNullStateSupplier) this.f6592o.get()).f19628n = this;
        }
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1973231424);
        this.f6590m.m11540a();
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1534341469, a);
    }

    public void setButtonSpecsWithAnimation(List<TitleBarButtonSpec> list) {
        if (m11428a((List) list)) {
            this.f6590m.m11542a((View) this, getButtonWidths());
            return;
        }
        setButtonSpecs(list);
        this.f6590m.m11542a((View) this, getButtonWidths());
    }

    private static boolean m11428a(@Nullable List<TitleBarButtonSpec> list) {
        return list == null || (!list.isEmpty() && list.get(0) == TitleBarButtonSpec.f7575b);
    }

    protected void setTitleBarState(TitleBarState titleBarState) {
        if (titleBarState != this.f6606i && this.f6606i != TitleBarState.SEARCH_TITLES_APP) {
            if (m11430k()) {
                this.f6594q.setVisibility(8);
            }
            super.setTitleBarState(titleBarState);
            switch (C03133.f7431a[titleBarState.ordinal()]) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    if (!m11430k()) {
                        ViewStub viewStub = (ViewStub) findViewById(2131567989);
                        viewStub.setLayoutResource(2130904624);
                        this.f6594q = (GraphSearchTitleSearchBox) viewStub.inflate();
                    }
                    this.f6594q.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public final void m11433b(float f) {
        if (this.f6594q != null) {
            this.f6594q.m12025a(f);
        }
    }

    public final void m11434b(boolean z) {
        if (z) {
            this.f6590m.m11543a(this, getButtonWidths(), new 1(this));
            return;
        }
        mo1617a(null);
        this.f6590m.m11545b(this, getButtonWidths(), new 2(this));
    }

    private void m11425a(TitleBarAnimators titleBarAnimators, RTLUtil rTLUtil, Lazy<ContentDiscoveryNullStateSupplier> lazy, QeAccessor qeAccessor) {
        this.f6590m = titleBarAnimators;
        this.f6591n = rTLUtil;
        this.f6592o = lazy;
        this.f6593p = qeAccessor;
    }

    public final void m11432a(SearchBoxType searchBoxType) {
        setTitleBarState(TitleBarState.SEARCH_TITLES_APP);
        this.f6594q.f7436e.setFocusable(false);
        this.f6594q.m12026a(this.f6607j);
        this.f6594q.f7436e.setLongClickable(false);
        this.f6594q.setContentDescription(getResources().getString(17039372));
        this.f6594q.setSearchBoxType(searchBoxType);
    }

    public final void mo1611h() {
        this.f6594q.m12034e();
    }

    public final void m11439i() {
        this.f6594q.m12032c();
    }

    public final void m11440j() {
        this.f6594q.m12033d();
    }

    public final void m11435c(boolean z) {
        int i;
        int i2 = 0;
        GraphSearchTitleSearchBox graphSearchTitleSearchBox = this.f6594q;
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        graphSearchTitleSearchBox.setVisibility(i);
        TextView textView = this.f6602e;
        if (!z) {
            i2 = 8;
        }
        textView.setVisibility(i2);
    }

    public final void G_(int i) {
        if (this.f6594q != null) {
            this.f6594q.setNullStateBadge(i);
        }
    }

    private boolean m11431l() {
        return this.f6593p.mo596a(ExperimentsForSearchAbTestModule.aV, false);
    }
}
