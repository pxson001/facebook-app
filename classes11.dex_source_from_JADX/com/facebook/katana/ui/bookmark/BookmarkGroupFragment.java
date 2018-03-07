package com.facebook.katana.ui.bookmark;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.facebook.apptab.state.TabBarStateManager;
import com.facebook.bookmark.FetchBookmarksResult;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.bookmark.ui.BaseBookmarkMenuFragment;
import com.facebook.bookmark.ui.BookmarkAdapter.RowType;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: words */
public class BookmarkGroupFragment extends BaseBookmarkMenuFragment {
    @Inject
    public FB4AViewItemFactory ar;
    @Inject
    @ForUiThread
    public Executor as;
    @Inject
    public TabBarStateManager at;
    public BookmarksGroup au;
    private boolean av;

    /* compiled from: words */
    public class C00141 implements FutureCallback<Collection<Bookmark>> {
        final /* synthetic */ BookmarkGroupFragment f129a;

        public C00141(BookmarkGroupFragment bookmarkGroupFragment) {
            this.f129a = bookmarkGroupFragment;
        }

        public void onSuccess(Object obj) {
            this.f129a.au.a((Collection) obj);
            this.f129a.aq();
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: words */
    public enum ViewItemType implements RowType {
        Bookmark
    }

    public static void m113a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        BookmarkGroupFragment bookmarkGroupFragment = (BookmarkGroupFragment) obj;
        FB4AViewItemFactory b = FB4AViewItemFactory.m166b(fbInjector);
        Executor executor = (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector);
        TabBarStateManager a = TabBarStateManager.a(fbInjector);
        bookmarkGroupFragment.ar = b;
        bookmarkGroupFragment.as = executor;
        bookmarkGroupFragment.at = a;
    }

    public BookmarkGroupFragment() {
        super(2130903424, 2131559962);
    }

    public final void m115c(Bundle bundle) {
        super.c(bundle);
        Class cls = BookmarkGroupFragment.class;
        m113a((Object) this, getContext());
        this.ao = 2130903424;
        if (this.au != null) {
            return;
        }
        if (bundle != null) {
            this.au = (BookmarksGroup) bundle.getParcelable("bookmarks_group");
            return;
        }
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            this.au = (BookmarksGroup) bundle2.getParcelable("bookmarks_group");
        }
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1903152013);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            if (this.au == null || Strings.isNullOrEmpty(this.au.name)) {
                hasTitleBar.y_(2131236555);
            } else {
                hasTitleBar.a_(this.au.name);
            }
        }
        LogUtils.f(901200936, a);
    }

    public final void m118e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("bookmarks_group", this.au);
    }

    public final void m116d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -102712988);
        super.d(bundle);
        if (this.au.h()) {
            ListenableFuture a2 = this.g.a(this.au.id);
            if (a2 != null) {
                Futures.a(a2, new C00141(this), this.as);
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1470418338, a);
    }

    protected final int m117e() {
        return ViewItemType.values().length;
    }

    protected final void aq() {
        List a = Lists.a();
        List d = this.au.d();
        for (int i = 0; i < d.size(); i++) {
            Bookmark bookmark = (Bookmark) d.get(i);
            if (!b(bookmark)) {
                a.add(this.ar.b(ViewItemType.Bookmark, bookmark));
            }
        }
        a(a);
    }

    public final void m114a(FetchBookmarksResult fetchBookmarksResult, boolean z) {
        if (z) {
            ImmutableList immutableList = fetchBookmarksResult.a;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                BookmarksGroup bookmarksGroup = (BookmarksGroup) immutableList.get(i);
                if (bookmarksGroup.id.equals(this.au.id) && bookmarksGroup.name.equals(this.au.name)) {
                    this.au = bookmarksGroup;
                    aq();
                    return;
                }
            }
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        this.av = true;
    }
}
