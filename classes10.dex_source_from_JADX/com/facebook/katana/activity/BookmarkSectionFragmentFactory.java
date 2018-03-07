package com.facebook.katana.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.katana.ui.bookmark.BookmarkGroupFragment;

/* compiled from: SEARCH_RADIUS_5 */
public class BookmarkSectionFragmentFactory implements IFragmentFactory {
    public final Fragment m25499a(Intent intent) {
        BookmarksGroup bookmarksGroup = (BookmarksGroup) intent.getParcelableExtra(FBLinks.bx);
        BookmarkGroupFragment bookmarkGroupFragment = new BookmarkGroupFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("bookmarks_group", bookmarksGroup);
        bookmarkGroupFragment.g(bundle);
        return bookmarkGroupFragment;
    }
}
