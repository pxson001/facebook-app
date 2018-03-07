package com.facebook.pages.identity.cards.actionbar;

import android.content.Context;
import android.os.ParcelUuid;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.fbui.widget.inlineactionbar.InlineActionBar;
import com.facebook.fbui.widget.inlineactionbar.InlineActionBar.InlineActionBarActionItemsSelectedHandler;
import com.facebook.fbui.widget.inlineactionbar.InlineActionBar.InlineActionBarMenuHandler;
import com.facebook.feed.seefirst.seefirstnux.SeeFirstNuxManager;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageHeaderCardView;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.identity.cards.actionbar.PagesActionBarItemFactory.PageActionType;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.IViewAttachAware;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: privacy_checkup_write_request_sent */
public class PagesActionBar extends InlineActionBar implements PageHeaderCardView, IViewAttachAware {
    @Inject
    PagesActionBarController f3175a;
    @Inject
    PagesActionBarItemFactory f3176b;
    @Inject
    SeeFirstInterstitialHelper f3177c;
    public boolean f3178d;
    public boolean f3179e = false;
    private PageHeaderData f3180f;
    private final ActionMenuItemHandler f3181g = new ActionMenuItemHandler(this);

    /* compiled from: privacy_checkup_write_request_sent */
    class ActionMenuItemHandler implements InlineActionBarMenuHandler {
        final /* synthetic */ PagesActionBar f3174a;

        public ActionMenuItemHandler(PagesActionBar pagesActionBar) {
            this.f3174a = pagesActionBar;
        }

        public final boolean m4247a(MenuItem menuItem) {
            this.f3174a.f3179e = true;
            this.f3174a.f3175a.m4358a(menuItem);
            return true;
        }
    }

    private static <T extends View> void m4249a(Class<T> cls, T t) {
        m4250a((Object) t, t.getContext());
    }

    private static void m4250a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PagesActionBar) obj).m4248a(PagesActionBarController.m4301b(injectorLike), PagesActionBarItemFactory.m4371b(injectorLike), new SeeFirstInterstitialHelper(InterstitialManager.a(injectorLike), SeeFirstNuxManager.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), DefaultAppChoreographer.a(injectorLike)));
    }

    public PagesActionBar(Context context) {
        super(context);
        m4253c();
    }

    public PagesActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4253c();
    }

    public PagesActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4253c();
    }

    private void m4253c() {
        m4249a(PagesActionBar.class, (View) this);
        setMaxNumOfVisibleButtons(4);
        this.b = this.f3181g;
        this.f3175a.m4356a(getContext(), this);
        a(false, true, 0);
        m4254e();
    }

    public void setHasBeenAttached(boolean z) {
        this.f3178d = z;
    }

    public final boolean m4256a() {
        return this.f3178d;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 230784450);
        super.onAttachedToWindow();
        this.f3178d = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1322543332, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 287878427);
        super.onDetachedFromWindow();
        this.f3178d = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1552825384, a);
    }

    public void setParentFragment(FbFragment fbFragment) {
    }

    public final void mo29a(PageHeaderData pageHeaderData) {
        TracerDetour.a("PageActionBar.bindModel", -1149859838);
        try {
            m4252b(pageHeaderData);
        } finally {
            TracerDetour.a(-704937424);
        }
    }

    public void setLoggingUuid(ParcelUuid parcelUuid) {
        this.f3175a.f3232O = parcelUuid;
    }

    private void m4252b(PageHeaderData pageHeaderData) {
        getLayoutParams().height = getResources().getDimensionPixelOffset(2131430141);
        if (pageHeaderData == null) {
            clear();
        }
        this.f3180f = (PageHeaderData) Preconditions.checkNotNull(pageHeaderData);
        this.f3175a.m4359a(this.f3180f);
        b();
        clear();
        this.f3176b.m4396a(pageHeaderData);
        final Map hashMap = new HashMap();
        ImmutableList a = this.f3176b.m4395a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            PagesActionBarItem pagesActionBarItem = (PagesActionBarItem) a.get(i);
            if (pagesActionBarItem.f3270f) {
                a(0, pagesActionBarItem.f3265a, 0, pagesActionBarItem.f3266b).setShowAsActionFlags(pagesActionBarItem.f3269e).setEnabled(pagesActionBarItem.f3270f).setCheckable(pagesActionBarItem.f3271g).setChecked(pagesActionBarItem.f3272h).setIcon(pagesActionBarItem.f3268d);
                if (pagesActionBarItem.m4368h() != 0) {
                    hashMap.put(Integer.valueOf(pagesActionBarItem.f3265a), pagesActionBarItem);
                }
            }
        }
        if (!hashMap.isEmpty()) {
            setInlineActionBarActionItemsSelected(new InlineActionBarActionItemsSelectedHandler(this) {
                final /* synthetic */ PagesActionBar f3172b;
                private boolean f3173c = false;

                public final void m4246a(MenuBuilder menuBuilder) {
                    if (!this.f3173c) {
                        this.f3173c = true;
                        ArrayList m = menuBuilder.m();
                        int size = m.size();
                        for (int i = 0; i < size; i++) {
                            MenuItemImpl menuItemImpl = (MenuItemImpl) m.get(i);
                            if (!menuItemImpl.j()) {
                                PagesActionBarItem pagesActionBarItem = (PagesActionBarItem) hashMap.get(Integer.valueOf(menuItemImpl.getItemId()));
                                if (pagesActionBarItem != null) {
                                    menuItemImpl.setIcon(pagesActionBarItem.m4368h());
                                }
                            }
                        }
                    }
                }
            });
        }
        if (!(findItem(PageActionType.FOLLOW.ordinal()) == null || this.f3179e)) {
            this.f3177c.m4451a(this, this.f3180f.a);
        }
        d();
    }

    private void m4254e() {
        a(this.f3175a.m4355a());
    }

    private void m4248a(PagesActionBarController pagesActionBarController, PagesActionBarItemFactory pagesActionBarItemFactory, SeeFirstInterstitialHelper seeFirstInterstitialHelper) {
        this.f3175a = pagesActionBarController;
        this.f3176b = pagesActionBarItemFactory;
        this.f3177c = seeFirstInterstitialHelper;
    }
}
