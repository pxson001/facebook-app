package com.facebook.orca.contacts.favorites;

import android.content.Context;
import android.view.View;
import com.facebook.contacts.picker.ContactPickerSectionHeaderRow;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.ui.header.ActionableSectionHeaderView;
import com.facebook.messaging.ui.name.MessengerThreadNameViewData;
import com.facebook.orca.contacts.favorites.AddFavoriteContactItemView.C08721;
import com.facebook.orca.contacts.favorites.AddFavoriteGroupItemView.C08731;
import com.facebook.orca.contacts.favorites.FavoriteContactItemView.C08911;
import com.facebook.orca.contacts.favorites.FavoriteGroupItemView.C08921;
import com.facebook.user.model.User;
import javax.inject.Inject;

/* compiled from: onFragmentCreate */
public class DivebarEditFavoritesRowViewFactory {
    protected Context f5957a;

    @Inject
    public DivebarEditFavoritesRowViewFactory(Context context) {
        this.f5957a = context;
    }

    public final View m5618a(FavoriteContactRow favoriteContactRow, View view) {
        view = (FavoriteContactItemView) view;
        if (view == null || !view.f5314a) {
            view = new FavoriteContactItemView(this.f5957a);
        }
        view.f5976d = favoriteContactRow;
        User user = view.f5976d.f5981a;
        view.f5980h.setParams(view.f5974b.a(user));
        view.f5977e.setText(user.j());
        if (user.ao()) {
            view.f5978f.setText(((PhoneContactUiHelper) view.f5975c.get()).m5650a(user));
            view.f5978f.setVisibility(0);
        } else {
            view.f5978f.setVisibility(8);
        }
        view.f5979g.setOnClickListener(new C08911(view));
        return view;
    }

    public final View m5616a(AddFavoriteContactRow addFavoriteContactRow, View view) {
        view = (AddFavoriteContactItemView) view;
        if (view == null) {
            view = new AddFavoriteContactItemView(this.f5957a);
        }
        view.f5910g = addFavoriteContactRow;
        User user = view.f5910g.f5911a;
        view.f5909f.setParams(view.f5904a.a(user));
        view.f5906c.setText(user.j());
        if (user.ao()) {
            view.f5907d.setText(((PhoneContactUiHelper) view.f5905b.get()).m5650a(user));
            view.f5907d.setVisibility(0);
        } else {
            view.f5907d.setVisibility(8);
        }
        view.f5908e.setOnClickListener(new C08721(view));
        return view;
    }

    public final View m5615a(ContactPickerSectionHeaderRow contactPickerSectionHeaderRow, View view) {
        view = (ActionableSectionHeaderView) view;
        if (view == null) {
            view = new ActionableSectionHeaderView(this.f5957a);
        }
        view.setText(contactPickerSectionHeaderRow.a);
        return view;
    }

    public final View m5619a(FavoriteGroupRow favoriteGroupRow, View view) {
        view = (FavoriteGroupItemView) view;
        if (view == null || !view.f5314a) {
            view = new FavoriteGroupItemView(this.f5957a);
        }
        view.f5984b = favoriteGroupRow;
        ThreadSummary threadSummary = view.f5984b.f5991a;
        view.f5988f.setThreadTileViewData(view.f5990h.a(threadSummary));
        MessengerThreadNameViewData a = view.f5989g.a(threadSummary);
        view.f5985c.setData(a);
        view.f5986d.setData(a);
        view.f5987e.setOnClickListener(new C08921(view));
        return view;
    }

    public final View m5617a(AddFavoriteGroupRow addFavoriteGroupRow, View view) {
        view = (AddFavoriteGroupItemView) view;
        if (view == null) {
            view = new AddFavoriteGroupItemView(this.f5957a);
        }
        view.f5920g = addFavoriteGroupRow;
        ThreadSummary threadSummary = view.f5920g.f5921a;
        view.f5917d.setThreadTileViewData(view.f5919f.a(threadSummary));
        MessengerThreadNameViewData a = view.f5918e.a(threadSummary);
        view.f5914a.setData(a);
        view.f5915b.setData(a);
        view.f5916c.setOnClickListener(new C08731(view));
        return view;
    }

    public final View m5614a(View view) {
        return view != null ? view : new NoFavoriteContactsItemView(this.f5957a);
    }

    public final View m5620b(View view) {
        FavoriteSectionSplitterView favoriteSectionSplitterView = (FavoriteSectionSplitterView) view;
        if (favoriteSectionSplitterView == null) {
            return new FavoriteSectionSplitterView(this.f5957a);
        }
        return favoriteSectionSplitterView;
    }

    public final View m5613a() {
        throw new UnsupportedOperationException("Old divebar doesn't implement Favorites Sticky Top Row");
    }
}
