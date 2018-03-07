package com.facebook.friending.center.tabs.requests;

import com.facebook.friending.center.tabs.requests.items.FriendRequestItem;
import com.facebook.friending.center.tabs.requests.items.FriendRequestsHeaderItem;
import com.facebook.friending.center.tabs.requests.items.NoFriendRequestsItem;
import com.facebook.friending.center.tabs.requests.items.PeopleYouMayKnowHeaderItem;
import com.facebook.friending.center.tabs.requests.items.PeopleYouMayKnowItem;
import com.facebook.friending.center.tabs.requests.items.RequestsListHeader;
import com.facebook.friending.center.tabs.requests.items.RequestsListItem;
import com.facebook.inject.InjectorLike;
import java.util.ArrayList;
import java.util.List;

/* compiled from: admin_shop_adapter_data_provider_state_root */
public class FriendsCenterRequestsItemsFactory {
    private static final RequestsListItem f20088a = new NoFriendRequestsItem();
    private static final RequestsListHeader f20089b = new FriendRequestsHeaderItem();
    private static final RequestsListHeader f20090c = new PeopleYouMayKnowHeaderItem();

    public static FriendsCenterRequestsItemsFactory m20391a(InjectorLike injectorLike) {
        return new FriendsCenterRequestsItemsFactory();
    }

    public static List<RequestsListItem> m20392a(List<FriendRequestItem> list, List<PeopleYouMayKnowItem> list2, boolean z) {
        List<RequestsListItem> arrayList = new ArrayList();
        boolean isEmpty = list.isEmpty();
        boolean isEmpty2 = list2.isEmpty();
        if (!isEmpty) {
            arrayList.add(f20089b);
            arrayList.addAll(list);
        } else if (!isEmpty2 || z) {
            arrayList.add(f20088a);
        }
        if (!isEmpty2) {
            arrayList.add(f20090c);
            arrayList.addAll(list2);
        }
        return arrayList;
    }
}
