package com.facebook.saved2.ui.contextmenu;

import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.analytics.CurationMechanism;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.saved2.model.Saved2ItemTable_Queries.BaseQueryDAO;
import com.facebook.video.abtest.ExperimentsForVideoAbTestModule;
import com.facebook.video.downloadmanager.DownloadManager;
import com.facebook.video.events.VideoDownloadStatus.DownloadStatus;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: instant_article_scroll_perf */
public class Saved2ContextMenuFactory {
    public final SaveAnalyticsLogger f9529a;
    private final Saved2ArchiveMenuItem f9530b;
    private final Saved2DeleteMenuItem f9531c;
    private final Saved2DeleteDownloadedVideoMenuItem f9532d;
    private final Saved2DownloadVideoMenuItem f9533e;
    private final Saved2PauseResumeDownloadVideoMenuItem f9534f;
    private final Saved2ShareMenuItemProvider f9535g;
    private final Saved2UnarchiveMenuItem f9536h;
    private final Saved2ViewPostMenuItemProvider f9537i;

    /* compiled from: instant_article_scroll_perf */
    public class Saved2MenuItemClickListener implements OnMenuItemClickListener {
        private int f9525a;
        private BaseQueryDAO f9526b;
        private Saved2ContextMenuItem f9527c;
        public SaveAnalyticsLogger f9528d;

        public Saved2MenuItemClickListener(Saved2ContextMenuItem saved2ContextMenuItem, BaseQueryDAO baseQueryDAO, SaveAnalyticsLogger saveAnalyticsLogger) {
            this.f9527c = saved2ContextMenuItem;
            this.f9526b = baseQueryDAO;
            this.f9525a = baseQueryDAO.b();
            this.f9528d = saveAnalyticsLogger;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            if (this.f9526b == null) {
                throw new IllegalStateException("DAOItem is null");
            } else if (this.f9526b.a(this.f9525a)) {
                Saved2ContextMenuItem saved2ContextMenuItem = this.f9527c;
                this.f9528d.a("saved_dashboard", this.f9526b.w(), saved2ContextMenuItem.mo448c());
                return this.f9527c.mo447b(this.f9526b);
            } else {
                throw new IllegalStateException("Can't move dao to position: " + this.f9525a);
            }
        }
    }

    public static Saved2ContextMenuFactory m9800b(InjectorLike injectorLike) {
        return new Saved2ContextMenuFactory(SaveAnalyticsLogger.a(injectorLike), Saved2ArchiveMenuItem.m9793b(injectorLike), Saved2DeleteMenuItem.m9808b(injectorLike), new Saved2DeleteDownloadedVideoMenuItem(DownloadManager.a(injectorLike), IdBasedLazy.a(injectorLike, 3588), IdBasedSingletonScopeProvider.b(injectorLike, 3834)), Saved2DownloadVideoMenuItem.m9813b(injectorLike), (Saved2ShareMenuItemProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(Saved2ShareMenuItemProvider.class), Saved2UnarchiveMenuItem.m9830b(injectorLike), (Saved2ViewPostMenuItemProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(Saved2ViewPostMenuItemProvider.class), Saved2PauseResumeDownloadVideoMenuItem.m9818b(injectorLike));
    }

    @Inject
    public Saved2ContextMenuFactory(SaveAnalyticsLogger saveAnalyticsLogger, Saved2ArchiveMenuItem saved2ArchiveMenuItem, Saved2DeleteMenuItem saved2DeleteMenuItem, Saved2DeleteDownloadedVideoMenuItem saved2DeleteDownloadedVideoMenuItem, Saved2DownloadVideoMenuItem saved2DownloadVideoMenuItem, Saved2ShareMenuItemProvider saved2ShareMenuItemProvider, Saved2UnarchiveMenuItem saved2UnarchiveMenuItem, Saved2ViewPostMenuItemProvider saved2ViewPostMenuItemProvider, Saved2PauseResumeDownloadVideoMenuItem saved2PauseResumeDownloadVideoMenuItem) {
        this.f9529a = saveAnalyticsLogger;
        this.f9530b = saved2ArchiveMenuItem;
        this.f9531c = saved2DeleteMenuItem;
        this.f9532d = saved2DeleteDownloadedVideoMenuItem;
        this.f9533e = saved2DownloadVideoMenuItem;
        this.f9535g = saved2ShareMenuItemProvider;
        this.f9536h = saved2UnarchiveMenuItem;
        this.f9537i = saved2ViewPostMenuItemProvider;
        this.f9534f = saved2PauseResumeDownloadVideoMenuItem;
    }

    public final PopoverMenuWindow m9801a(FragmentActivity fragmentActivity, View view, BaseQueryDAO baseQueryDAO, CurationMechanism curationMechanism) {
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(view.getContext());
        PopoverMenu c = figPopoverMenuWindow.c();
        ArrayList a = m9798a(fragmentActivity, baseQueryDAO);
        if (!a.isEmpty()) {
            for (int i = 0; i < a.size(); i++) {
                Saved2ContextMenuItem saved2ContextMenuItem = (Saved2ContextMenuItem) a.get(i);
                MenuItemImpl a2 = c.a(saved2ContextMenuItem.mo445a());
                a2.setIcon(saved2ContextMenuItem.mo446b());
                a2.setOnMenuItemClickListener(new Saved2MenuItemClickListener(saved2ContextMenuItem, baseQueryDAO, this.f9529a));
            }
            figPopoverMenuWindow.a(view);
            m9799a(baseQueryDAO.w(), a, curationMechanism);
        }
        return figPopoverMenuWindow;
    }

    private ArrayList<Saved2ContextMenuItem> m9798a(FragmentActivity fragmentActivity, BaseQueryDAO baseQueryDAO) {
        Object obj;
        ArrayList<Saved2ContextMenuItem> arrayList = new ArrayList(5);
        if (Saved2ShareMenuItem.m9823c(baseQueryDAO) != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            arrayList.add(new Saved2ShareMenuItem(fragmentActivity, IdBasedSingletonScopeProvider.b(this.f9535g, 849)));
        }
        if (baseQueryDAO.r()) {
            Saved2ViewPostMenuItemProvider saved2ViewPostMenuItemProvider = this.f9537i;
            arrayList.add(new Saved2ViewPostMenuItem(fragmentActivity, IdBasedSingletonScopeProvider.b(saved2ViewPostMenuItemProvider, 2374), IdBasedSingletonScopeProvider.b(saved2ViewPostMenuItemProvider, 968)));
        }
        if (baseQueryDAO.v() && GraphQLSavedState.SAVED.toString().equals(baseQueryDAO.m())) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            arrayList.add(this.f9530b);
        }
        if (baseQueryDAO.v() && GraphQLSavedState.ARCHIVED.toString().equals(baseQueryDAO.m())) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            arrayList.add(this.f9536h);
        }
        String m = baseQueryDAO.m();
        if (baseQueryDAO.v() && (GraphQLSavedState.SAVED.toString().equals(m) || GraphQLSavedState.ARCHIVED.toString().equals(m))) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            arrayList.add(this.f9531c);
        }
        Saved2PauseResumeDownloadVideoMenuItem saved2PauseResumeDownloadVideoMenuItem = this.f9534f;
        boolean z = false;
        if (baseQueryDAO.t() && GraphQLSavedState.SAVED.toString().equals(baseQueryDAO.m()) && saved2PauseResumeDownloadVideoMenuItem.f9565d.a(ExperimentsForVideoAbTestModule.cW, false) && saved2PauseResumeDownloadVideoMenuItem.f9565d.a(ExperimentsForVideoAbTestModule.cY, false)) {
            saved2PauseResumeDownloadVideoMenuItem.f9566e = saved2PauseResumeDownloadVideoMenuItem.f9562a.d(baseQueryDAO.w()).c;
            if (saved2PauseResumeDownloadVideoMenuItem.f9566e == DownloadStatus.DOWNLOAD_IN_PROGRESS || saved2PauseResumeDownloadVideoMenuItem.f9566e == DownloadStatus.DOWNLOAD_FAILED || saved2PauseResumeDownloadVideoMenuItem.f9566e == DownloadStatus.DOWNLOAD_PAUSED) {
                z = true;
            }
        }
        if (z) {
            arrayList.add(this.f9534f);
        }
        Saved2DeleteDownloadedVideoMenuItem saved2DeleteDownloadedVideoMenuItem = this.f9532d;
        obj = null;
        if (baseQueryDAO.t()) {
            saved2DeleteDownloadedVideoMenuItem.f9542d = saved2DeleteDownloadedVideoMenuItem.f9539a.d(baseQueryDAO.w()).c;
            if (saved2DeleteDownloadedVideoMenuItem.f9542d == DownloadStatus.DOWNLOAD_IN_PROGRESS || saved2DeleteDownloadedVideoMenuItem.f9542d == DownloadStatus.DOWNLOAD_COMPLETED || saved2DeleteDownloadedVideoMenuItem.f9542d == DownloadStatus.DOWNLOAD_PAUSED) {
                obj = 1;
            }
        }
        if (obj != null) {
            arrayList.add(this.f9532d);
        }
        Saved2DownloadVideoMenuItem saved2DownloadVideoMenuItem = this.f9533e;
        z = false;
        if (baseQueryDAO.t() && GraphQLSavedState.SAVED.toString().equals(baseQueryDAO.m()) && saved2DownloadVideoMenuItem.f9559d.a(ExperimentsForVideoAbTestModule.cW, false) && saved2DownloadVideoMenuItem.f9559d.a(ExperimentsForVideoAbTestModule.cY, false) && baseQueryDAO.Q() != 0) {
            DownloadStatus downloadStatus = saved2DownloadVideoMenuItem.f9556a.d(baseQueryDAO.w()).c;
            if (downloadStatus == DownloadStatus.DOWNLOAD_NOT_REQUESTED || downloadStatus == DownloadStatus.DOWNLOAD_ABORTED || downloadStatus == DownloadStatus.DOWNLOAD_FAILED) {
                z = true;
            }
        }
        if (z) {
            arrayList.add(this.f9533e);
        }
        return arrayList;
    }

    private void m9799a(String str, ArrayList<Saved2ContextMenuItem> arrayList, CurationMechanism curationMechanism) {
        SaveAnalyticsLogger saveAnalyticsLogger = this.f9529a;
        String str2 = "saved_dashboard";
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList2.add(((Saved2ContextMenuItem) arrayList.get(i)).mo448c());
        }
        saveAnalyticsLogger.a(str2, str, arrayList2, curationMechanism);
    }
}
