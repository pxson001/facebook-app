package com.facebook.orca.contacts.picker;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import com.facebook.contacts.picker.ContactPickerGroupRow;
import com.facebook.contacts.picker.ContactPickerInviteFriendsRow;
import com.facebook.contacts.picker.ContactPickerMontageRow;
import com.facebook.contacts.picker.ContactPickerPaymentEligibleFooterRow;
import com.facebook.contacts.picker.ContactPickerPhoneContactRow;
import com.facebook.contacts.picker.ContactPickerSectionHeaderRow;
import com.facebook.contacts.picker.ContactPickerTincanRow;
import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.contacts.picker.ContactPickerViewMoreRow;
import com.facebook.contacts.picker.DivebarNearbyFriendsRow;
import com.facebook.contacts.picker.FavoritesSectionHeaderRow;
import com.facebook.contacts.picker.PickablePhoneContactRow;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.contacts.picker.ContactPickerInviteFriendsView;
import com.facebook.messaging.contacts.picker.ContactPickerListGroupItem;
import com.facebook.messaging.contacts.picker.ContactPickerListItem;
import com.facebook.messaging.contacts.picker.ContactPickerListMontageItem;
import com.facebook.messaging.contacts.picker.ContactPickerListPhoneContactItem;
import com.facebook.messaging.contacts.picker.ContactPickerListTincanView;
import com.facebook.messaging.contacts.picker.ContactPickerLoadingMoreView;
import com.facebook.messaging.contacts.picker.ContactPickerPaymentEligibleFooterView;
import com.facebook.messaging.contacts.picker.ContactPickerSectionSplitterView;
import com.facebook.messaging.contacts.picker.ContactPickerViewMoreRowView;
import com.facebook.messaging.contacts.picker.PickablePhoneContactItem;
import com.facebook.messaging.contacts.picker.PickablePhoneContactItem.C03441;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.photos.tiles.MessengerThreadTileViewDataFactory;
import com.facebook.messaging.ui.header.ActionableSectionHeaderView;
import com.facebook.messaging.ui.name.MessengerThreadNameViewDataFactory;
import com.facebook.orca.contacts.divebar.DivebarNearbyFriendsRowView;
import com.facebook.user.model.User;
import com.facebook.user.model.UserPhoneNumber;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.text.SimpleVariableTextLayoutView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: num_tests */
public class DivebarContactPickerViewFactory {
    private final Context f6088a;

    public static DivebarContactPickerViewFactory m5790b(InjectorLike injectorLike) {
        return new DivebarContactPickerViewFactory((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public DivebarContactPickerViewFactory(Context context) {
        this.f6088a = context;
    }

    public final View m5791a(View view) {
        ContactPickerLoadingMoreView contactPickerLoadingMoreView = (ContactPickerLoadingMoreView) view;
        if (contactPickerLoadingMoreView == null) {
            return new ContactPickerLoadingMoreView(this.f6088a);
        }
        return contactPickerLoadingMoreView;
    }

    public final View m5799a(ContactPickerUserRow contactPickerUserRow, View view) {
        view = (ContactPickerListItem) view;
        if (view == null) {
            view = new ContactPickerListItem(this.f6088a);
        }
        view.setContactRow(contactPickerUserRow);
        return view;
    }

    public final View m5793a(ContactPickerGroupRow contactPickerGroupRow, View view) {
        view = (ContactPickerListGroupItem) view;
        if (view == null) {
            view = new ContactPickerListGroupItem(this.f6088a);
        }
        view.f1836w = contactPickerGroupRow;
        ContactPickerListGroupItem.m1741a(view);
        return view;
    }

    public final View m5802a(FavoritesSectionHeaderRow favoritesSectionHeaderRow, View view) {
        view = (ActionableSectionHeaderView) view;
        if (view == null) {
            view = new ActionableSectionHeaderView(this.f6088a);
        }
        view.setText(favoritesSectionHeaderRow.a);
        view.setActionButtonText(favoritesSectionHeaderRow.b);
        view.f4855c = favoritesSectionHeaderRow.c;
        return view;
    }

    public final View m5800a(ContactPickerViewMoreRow contactPickerViewMoreRow, View view) {
        view = (ContactPickerViewMoreRowView) view;
        if (view == null) {
            view = new ContactPickerViewMoreRowView(this.f6088a);
        }
        view.f2046a.setText(contactPickerViewMoreRow.a);
        return view;
    }

    public final View m5801a(DivebarNearbyFriendsRow divebarNearbyFriendsRow, View view) {
        view = (DivebarNearbyFriendsRowView) view;
        if (view == null) {
            view = new DivebarNearbyFriendsRowView(this.f6088a);
        }
        view.setOnClickListener(divebarNearbyFriendsRow.b);
        view.m5535a(divebarNearbyFriendsRow.a);
        return view;
    }

    public final View m5797a(ContactPickerSectionHeaderRow contactPickerSectionHeaderRow, View view) {
        view = (ActionableSectionHeaderView) view;
        if (view == null) {
            view = new ActionableSectionHeaderView(this.f6088a);
        }
        view.setText(contactPickerSectionHeaderRow.a);
        return view;
    }

    public final View m5804b(View view) {
        ContactPickerSectionSplitterView contactPickerSectionSplitterView = (ContactPickerSectionSplitterView) view;
        if (contactPickerSectionSplitterView == null) {
            return new ContactPickerSectionSplitterView(this.f6088a);
        }
        return contactPickerSectionSplitterView;
    }

    public final View m5792a(View view, ContactPickerInviteFriendsRow contactPickerInviteFriendsRow) {
        view = (ContactPickerInviteFriendsView) view;
        if (view == null) {
            view = new ContactPickerInviteFriendsView(this.f6088a);
        }
        view.f1805b = contactPickerInviteFriendsRow.a;
        return view;
    }

    public final View m5796a(ContactPickerPhoneContactRow contactPickerPhoneContactRow, View view) {
        view = (ContactPickerListPhoneContactItem) view;
        if (view == null) {
            view = new ContactPickerListPhoneContactItem(this.f6088a);
        }
        view.f1888d = contactPickerPhoneContactRow;
        User user = view.f1888d.a;
        view.f1885a.setText(user.k());
        ImmutableList r = user.r();
        int size = r.size();
        for (int i = 0; i < size; i++) {
            UserPhoneNumber userPhoneNumber = (UserPhoneNumber) r.get(i);
            if (userPhoneNumber.d == 2) {
                String str = userPhoneNumber.a;
                view.f1886b.setText(str != null ? str : userPhoneNumber.toString());
                view.f1887c.setParams(UserTileViewParams.b(user));
                return view;
            }
        }
        view.f1887c.setParams(UserTileViewParams.b(user));
        return view;
    }

    public final View m5803a(PickablePhoneContactRow pickablePhoneContactRow, View view) {
        view = (PickablePhoneContactItem) view;
        if (view == null) {
            view = new PickablePhoneContactItem(this.f6088a);
        }
        view.f2060f = pickablePhoneContactRow;
        User user = view.f2060f.a;
        view.f2055a.setText(user.k());
        UserPhoneNumber w = user.w();
        if (w != null) {
            String str = w.a;
            SimpleVariableTextLayoutView simpleVariableTextLayoutView = view.f2056b;
            if (str == null) {
                str = w.toString();
            }
            simpleVariableTextLayoutView.setText(str);
            view.f2056b.setVisibility(0);
        } else {
            view.f2056b.setVisibility(8);
        }
        if (view.f2060f.d || !view.f2060f.c) {
            view.f2058d.setVisibility(8);
        } else {
            view.f2058d.setVisibility(0);
            view.f2058d.setChecked(view.f2060f.d());
        }
        if (view.f2060f.e && view.f2060f.d()) {
            view.f2055a.setTextColor(view.getResources().getColor(2131362241));
            view.f2056b.setTextColor(view.getResources().getColor(2131362241));
        } else {
            view.f2055a.setTextColor(-16777216);
            view.f2056b.setTextColor(view.getResources().getColor(2131362527));
        }
        boolean z = false;
        if (view.f2060f.d) {
            view.f2059e.setVisibility(0);
            boolean d = view.f2060f.d();
            Button button = view.f2059e;
            if (!d) {
                z = true;
            }
            button.setEnabled(z);
            view.f2059e.setText(d ? view.getResources().getString(2131231928) : view.getResources().getString(2131231102));
            view.f2059e.setOnClickListener(new C03441(view, view));
        } else {
            view.f2059e.setVisibility(8);
        }
        view.f2057c.setParams(UserTileViewParams.b(user));
        return view;
    }

    public final View m5795a(ContactPickerPaymentEligibleFooterRow contactPickerPaymentEligibleFooterRow, View view) {
        view = (ContactPickerPaymentEligibleFooterView) view;
        if (view == null) {
            view = new ContactPickerPaymentEligibleFooterView(this.f6088a);
        }
        view.f1900a.setText(contactPickerPaymentEligibleFooterRow.a);
        return view;
    }

    public final View m5794a(ContactPickerMontageRow contactPickerMontageRow, View view) {
        view = (ContactPickerListMontageItem) view;
        if (view == null) {
            view = new ContactPickerListMontageItem(this.f6088a);
        }
        view.f1884d = contactPickerMontageRow;
        if (view.f1884d.c) {
            view.f1881a.setVisibility(0);
            view.f1881a.setChecked(view.f1884d.d());
        } else {
            view.f1881a.setVisibility(8);
        }
        if (view.f1884d.d()) {
            view.f1882b.setTextColor(ContextCompat.b(view.getContext(), 2131362241));
        } else {
            view.f1882b.setTextColor(view.f1883c);
        }
        return view;
    }

    public final View m5798a(ContactPickerTincanRow contactPickerTincanRow, View view) {
        view = (ContactPickerListTincanView) view;
        if (view == null) {
            view = new ContactPickerListTincanView(this.f6088a);
        }
        view.f1891c = contactPickerTincanRow;
        ThreadSummary threadSummary = view.f1891c.a;
        view.f1893e.setData(((MessengerThreadNameViewDataFactory) view.f1889a.get()).a(threadSummary));
        view.f1892d.setThreadTileViewData(((MessengerThreadTileViewDataFactory) view.f1890b.get()).a(threadSummary));
        return view;
    }
}
