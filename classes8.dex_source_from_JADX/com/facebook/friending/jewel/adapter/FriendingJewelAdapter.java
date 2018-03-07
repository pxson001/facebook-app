package com.facebook.friending.jewel.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.friending.center.constants.FriendsCenterSource;
import com.facebook.friending.center.constants.FriendsCenterTabType;
import com.facebook.friending.common.list.FriendListItemView;
import com.facebook.friending.common.list.FriendRequestItemView;
import com.facebook.friending.jewel.ContactsSectionView;
import com.facebook.friending.jewel.FriendRequestView;
import com.facebook.friending.jewel.FriendRequestView.OnResponseListener;
import com.facebook.friending.jewel.FriendRequestView.OnSuggestionResponseListener;
import com.facebook.friending.jewel.FriendRequestsActionController;
import com.facebook.friending.jewel.FriendRequestsActionControllerProvider;
import com.facebook.friending.jewel.FriendingPossibilitiesList;
import com.facebook.friending.jewel.model.ContactsSectionModel;
import com.facebook.friends.constants.FriendRequestResponse;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.model.FriendRequest;
import com.facebook.friends.model.FriendRequestState;
import com.facebook.friends.model.PersonYouMayKnow;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.inject.Assisted;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.listview.StickyHeader.StickyHeaderAdapter;
import com.facebook.widget.text.CustomFontHelper;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: filters_enabled */
public class FriendingJewelAdapter extends FbBaseAdapter implements FriendingPossibilitiesList, FriendRequestsAdapter, StickyHeaderAdapter {
    public final FbUriIntentHandler f13242a;
    public final FriendingPYMKBinder f13243b;
    public final FriendRequestsActionController f13244c;
    public final OnResponseListener f13245d;
    public final OnSuggestionResponseListener f13246e;
    public final Set<String> f13247f;
    public final Set<Long> f13248g;
    public final List<FriendRequest> f13249h;
    public final List<PersonYouMayKnow> f13250i;
    public final ContactsSectionModel f13251j;
    public List<FriendingJewelRow> f13252k;
    public FriendingLocation f13253l = FriendingLocation.JEWEL;
    public boolean f13254m = true;
    public boolean f13255n = true;
    public boolean f13256o = false;
    public boolean f13257p = false;
    private int f13258q;
    private int f13259r;

    /* compiled from: filters_enabled */
    class C13901 implements OnResponseListener {
        final /* synthetic */ FriendingJewelAdapter f13233a;

        C13901(FriendingJewelAdapter friendingJewelAdapter) {
            this.f13233a = friendingJewelAdapter;
        }

        public final void mo820a(FriendRequest friendRequest, FriendRequestResponse friendRequestResponse) {
            this.f13233a.f13244c.m14822a(friendRequest, friendRequestResponse);
        }
    }

    /* compiled from: filters_enabled */
    class C13912 implements OnSuggestionResponseListener {
        final /* synthetic */ FriendingJewelAdapter f13234a;

        C13912(FriendingJewelAdapter friendingJewelAdapter) {
            this.f13234a = friendingJewelAdapter;
        }

        public final void mo821a(FriendRequest friendRequest) {
            this.f13234a.f13244c.m14821a(friendRequest);
        }

        public final void mo822b(FriendRequest friendRequest) {
            this.f13234a.f13244c.m14823b(friendRequest);
        }
    }

    /* compiled from: filters_enabled */
    class C13923 implements FriendingPYMKBinder.OnResponseListener {
        final /* synthetic */ FriendingJewelAdapter f13235a;

        C13923(FriendingJewelAdapter friendingJewelAdapter) {
            this.f13235a = friendingJewelAdapter;
        }

        public final void mo823a(long j) {
            if (this.f13235a.m14917d(j)) {
                FriendingJewelAdapter.m14901l(this.f13235a);
                AdapterDetour.a(this.f13235a, -847567774);
            }
        }

        public final void mo824b(long j) {
            this.f13235a.m14915c(j);
        }

        public final void mo825c(long j) {
            if (this.f13235a.m14917d(j)) {
                FriendingJewelAdapter.m14901l(this.f13235a);
                AdapterDetour.a(this.f13235a, -224351012);
            }
        }
    }

    /* compiled from: filters_enabled */
    public class C13934 implements OnClickListener {
        final /* synthetic */ FriendingJewelAdapter f13236a;

        public C13934(FriendingJewelAdapter friendingJewelAdapter) {
            this.f13236a = friendingJewelAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1745777504);
            this.f13236a.f13242a.a(view.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.cd, FriendsCenterSource.FRIENDS_TAB_SEE_ALL_PYMK.name(), FriendsCenterTabType.SUGGESTIONS.name()));
            Logger.a(2, EntryType.UI_INPUT_END, -76915667, a);
        }
    }

    /* compiled from: filters_enabled */
    public class C13945 implements OnClickListener {
        final /* synthetic */ FriendingJewelAdapter f13237a;

        public C13945(FriendingJewelAdapter friendingJewelAdapter) {
            this.f13237a = friendingJewelAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1621578778);
            this.f13237a.f13242a.a(view.getContext(), StringFormatUtil.a(FBLinks.dP, new Object[]{CIFlow.FRIEND_REQUEST_TAB.value}));
            Logger.a(2, EntryType.UI_INPUT_END, 482033095, a);
        }
    }

    /* compiled from: filters_enabled */
    public class FriendingJewelRow {
        public final RowType f13239a;
        public final Object f13240b;
        public final boolean f13241c;

        public FriendingJewelRow(RowType rowType) {
            this(rowType, null);
        }

        public FriendingJewelRow(RowType rowType, Object obj) {
            this.f13239a = rowType;
            this.f13240b = obj;
            boolean z = rowType == RowType.FRIEND_REQUEST || rowType == RowType.PERSON_YOU_MAY_KNOW || rowType == RowType.RESPONDED_PERSON_YOU_MAY_KNOW;
            this.f13241c = z;
        }
    }

    /* compiled from: filters_enabled */
    public enum RowType {
        FRIEND_REQUESTS_HEADER,
        NO_REQUESTS,
        FRIEND_REQUEST,
        PYMK_HEADER,
        PERSON_YOU_MAY_KNOW,
        RESPONDED_PERSON_YOU_MAY_KNOW,
        SEE_ALL_PYMK,
        CONTACTS_SECTION_HEADER,
        CONTACTS_SECTION
    }

    @Inject
    public FriendingJewelAdapter(FbUriIntentHandler fbUriIntentHandler, FriendingPYMKBinder friendingPYMKBinder, FriendRequestsActionControllerProvider friendRequestsActionControllerProvider, @Assisted Context context, @Assisted TasksManager tasksManager) {
        this.f13242a = fbUriIntentHandler;
        this.f13243b = friendingPYMKBinder;
        this.f13244c = friendRequestsActionControllerProvider.m14824a(context, this.f13253l, this, tasksManager);
        this.f13243b.f13286j = this.f13253l;
        this.f13245d = new C13901(this);
        this.f13246e = new C13912(this);
        this.f13243b.f13287k = new C13923(this);
        this.f13249h = new ArrayList();
        this.f13247f = new LinkedHashSet();
        this.f13250i = new ArrayList();
        this.f13248g = new LinkedHashSet();
        this.f13251j = new ContactsSectionModel();
        this.f13252k = new ArrayList();
        Resources resources = context.getResources();
        this.f13258q = resources.getDimensionPixelSize(2131428706);
        this.f13259r = resources.getColor(2131361920);
    }

    public int getCount() {
        return this.f13252k.size();
    }

    public Object getItem(int i) {
        return ((FriendingJewelRow) this.f13252k.get(i)).f13240b;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public final View m14902a(int i, ViewGroup viewGroup) {
        switch (RowType.values()[i]) {
            case NO_REQUESTS:
                return LayoutInflater.from(viewGroup.getContext()).inflate(2130905459, viewGroup, false);
            case FRIEND_REQUESTS_HEADER:
                return m14897a(viewGroup, 2131233203);
            case FRIEND_REQUEST:
                FriendRequestView friendRequestView = (FriendRequestView) LayoutInflater.from(viewGroup.getContext()).inflate(2130904484, viewGroup, false);
                friendRequestView.f13141s = this.f13245d;
                friendRequestView.f13142t = this.f13246e;
                return friendRequestView;
            case PYMK_HEADER:
                return m14897a(viewGroup, 2131233210);
            case PERSON_YOU_MAY_KNOW:
                FriendRequestItemView friendRequestItemView = (FriendRequestItemView) LayoutInflater.from(viewGroup.getContext()).inflate(2130906529, viewGroup, false);
                friendRequestItemView.setId(2131558783);
                return friendRequestItemView;
            case RESPONDED_PERSON_YOU_MAY_KNOW:
                FriendListItemView friendListItemView = (FriendListItemView) LayoutInflater.from(viewGroup.getContext()).inflate(2130906838, viewGroup, false);
                friendListItemView.setId(2131558783);
                return friendListItemView;
            case SEE_ALL_PYMK:
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130907041, viewGroup, false);
                inflate.setOnClickListener(new C13934(this));
                return inflate;
            case CONTACTS_SECTION_HEADER:
                return m14897a(viewGroup, 2131233246);
            case CONTACTS_SECTION:
                ContactsSectionView contactsSectionView = (ContactsSectionView) LayoutInflater.from(viewGroup.getContext()).inflate(2130904485, viewGroup, false);
                contactsSectionView.setActionButtonOnClickListener(new C13945(this));
                return contactsSectionView;
            default:
                throw new IllegalStateException("Unexpected type");
        }
    }

    public final void m14905a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        Preconditions.checkNotNull(view);
        switch (RowType.values()[i2]) {
            case FRIEND_REQUEST:
                ((FriendRequestView) view).m14808a((FriendRequest) obj);
                return;
            case PERSON_YOU_MAY_KNOW:
            case RESPONDED_PERSON_YOU_MAY_KNOW:
                this.f13243b.m14941a((ContentView) view, (PersonYouMayKnow) obj);
                return;
            case CONTACTS_SECTION:
                String string;
                ContactsSectionView contactsSectionView = (ContactsSectionView) view;
                contactsSectionView.setFaceUrls(ImmutableList.copyOf(this.f13251j.f13328a));
                ContactsSectionModel contactsSectionModel = this.f13251j;
                Resources resources = contactsSectionView.getResources();
                if (contactsSectionModel.f13330c == 2) {
                    string = resources.getString(2131233247, new Object[]{contactsSectionModel.f13329b.get(0), contactsSectionModel.f13329b.get(1)});
                } else if (contactsSectionModel.f13330c == 3) {
                    string = resources.getString(2131233248, new Object[]{contactsSectionModel.f13329b.get(0), contactsSectionModel.f13329b.get(1), contactsSectionModel.f13329b.get(2)});
                } else {
                    string = resources.getString(2131233249, new Object[]{contactsSectionModel.f13329b.get(0), contactsSectionModel.f13329b.get(1), Integer.valueOf(contactsSectionModel.f13330c - 2)});
                }
                contactsSectionView.setText(string);
                return;
            default:
                return;
        }
    }

    public boolean isEnabled(int i) {
        return !this.f13257p && ((FriendingJewelRow) this.f13252k.get(i)).f13241c;
    }

    public int getItemViewType(int i) {
        return ((FriendingJewelRow) this.f13252k.get(i)).f13239a.ordinal();
    }

    public int getViewTypeCount() {
        return RowType.values().length;
    }

    public final View m14910b(int i, View view, ViewGroup viewGroup) {
        int i2;
        switch (((FriendingJewelRow) this.f13252k.get(i)).f13239a) {
            case NO_REQUESTS:
            case FRIEND_REQUESTS_HEADER:
            case FRIEND_REQUEST:
                if (this.f13256o) {
                    i2 = 2131233203;
                    break;
                }
                return null;
            case PYMK_HEADER:
            case PERSON_YOU_MAY_KNOW:
            case RESPONDED_PERSON_YOU_MAY_KNOW:
                i2 = 2131233210;
                break;
            case CONTACTS_SECTION_HEADER:
            case CONTACTS_SECTION:
                i2 = 2131233246;
                break;
            default:
                return null;
        }
        if (view == null) {
            view = m14897a(viewGroup, i2);
            CustomViewUtils.a(view, view.getResources().getDrawable(2130840459));
            return view;
        }
        ((TextView) view).setText(i2);
        return view;
    }

    public final int o_(int i) {
        return 0;
    }

    public final int m14918e(int i) {
        return this.f13258q;
    }

    public final int m14916d() {
        return this.f13259r;
    }

    public final boolean m14920f(int i) {
        switch (RowType.values()[getItemViewType(i)]) {
            case FRIEND_REQUESTS_HEADER:
            case PYMK_HEADER:
            case CONTACTS_SECTION_HEADER:
                return true;
            default:
                return false;
        }
    }

    public final ImmutableList<String> mo827a() {
        Builder builder = ImmutableList.builder();
        for (FriendRequest friendRequest : this.f13249h) {
            builder.c(friendRequest.b);
        }
        return builder.b();
    }

    public final FriendRequest mo826a(int i) {
        return (FriendRequest) this.f13249h.get(i);
    }

    public final ImmutableList<String> mo831b() {
        Builder builder = ImmutableList.builder();
        for (PersonYouMayKnow a : this.f13250i) {
            builder.c(String.valueOf(a.a()));
        }
        return builder.b();
    }

    public final PersonYouMayKnow mo830b(int i) {
        return (PersonYouMayKnow) this.f13250i.get(i);
    }

    public final void mo828a(String str) {
        if (this.f13247f.contains(str)) {
            int b = m14898b(str);
            if (b != -1) {
                this.f13249h.remove(b);
                this.f13247f.remove(str);
                m14901l(this);
                AdapterDetour.a(this, 1992954898);
            }
        }
    }

    public final boolean m14909a(long j) {
        return this.f13247f.contains(String.valueOf(j));
    }

    public final boolean m14914b(long j) {
        if (!m14909a(j)) {
            return false;
        }
        int b = m14898b(String.valueOf(j));
        if (b == -1) {
            return false;
        }
        FriendRequest friendRequest = (FriendRequest) this.f13249h.get(b);
        return friendRequest != null && friendRequest.l();
    }

    public final void mo829a(String str, FriendRequestState friendRequestState, boolean z) {
        int b = m14898b(str);
        if (b != -1) {
            ((FriendRequest) this.f13249h.get(b)).j = friendRequestState;
            if (z) {
                AdapterDetour.a(this, 842988410);
            }
        }
    }

    public final void m14913b(List<PersonYouMayKnow> list) {
        for (PersonYouMayKnow personYouMayKnow : list) {
            if (!(personYouMayKnow == null || this.f13248g.contains(Long.valueOf(personYouMayKnow.a())))) {
                this.f13250i.add(personYouMayKnow);
                this.f13248g.add(Long.valueOf(personYouMayKnow.a()));
            }
        }
        m14901l(this);
        AdapterDetour.a(this, -148189533);
    }

    public final void m14915c(long j) {
        if (this.f13248g.contains(Long.valueOf(j))) {
            int g = m14900g(j);
            if (g != -1) {
                this.f13250i.remove(g);
                this.f13248g.remove(Long.valueOf(j));
                m14901l(this);
                AdapterDetour.a(this, -977843016);
            }
        }
    }

    public final void m14919e() {
        this.f13250i.clear();
        this.f13248g.clear();
    }

    public final boolean m14917d(long j) {
        return this.f13248g.contains(Long.valueOf(j));
    }

    public final void m14906a(long j, GraphQLFriendshipStatus graphQLFriendshipStatus) {
        int g = m14900g(j);
        if (g != -1) {
            PersonYouMayKnow personYouMayKnow = (PersonYouMayKnow) this.f13250i.get(g);
            GraphQLFriendshipStatus f = personYouMayKnow.f();
            if (!f.equals(graphQLFriendshipStatus)) {
                personYouMayKnow.f = f;
                personYouMayKnow.b(graphQLFriendshipStatus);
                m14901l(this);
                AdapterDetour.a(this, 1051808537);
            }
        }
    }

    public final boolean m14921g() {
        return this.f13251j.m14978b();
    }

    public final int m14922i() {
        return this.f13250i.size();
    }

    public static void m14901l(FriendingJewelAdapter friendingJewelAdapter) {
        friendingJewelAdapter.f13252k.clear();
        if (!friendingJewelAdapter.f13249h.isEmpty() || !friendingJewelAdapter.f13250i.isEmpty() || friendingJewelAdapter.f13251j.m14978b()) {
            if (friendingJewelAdapter.f13256o && (!friendingJewelAdapter.f13249h.isEmpty() || friendingJewelAdapter.f13255n)) {
                friendingJewelAdapter.f13252k.add(new FriendingJewelRow(RowType.FRIEND_REQUESTS_HEADER));
            }
            if (friendingJewelAdapter.f13255n && friendingJewelAdapter.f13249h.isEmpty()) {
                friendingJewelAdapter.f13252k.add(new FriendingJewelRow(RowType.NO_REQUESTS));
            }
            for (FriendRequest friendingJewelRow : friendingJewelAdapter.f13249h) {
                friendingJewelAdapter.f13252k.add(new FriendingJewelRow(RowType.FRIEND_REQUEST, friendingJewelRow));
            }
            if (!friendingJewelAdapter.f13250i.isEmpty()) {
                friendingJewelAdapter.f13252k.add(new FriendingJewelRow(RowType.PYMK_HEADER));
                for (PersonYouMayKnow personYouMayKnow : friendingJewelAdapter.f13250i) {
                    if (GraphQLFriendshipStatus.CAN_REQUEST.equals(personYouMayKnow.f()) || GraphQLFriendshipStatus.INCOMING_REQUEST.equals(personYouMayKnow.f())) {
                        friendingJewelAdapter.f13252k.add(new FriendingJewelRow(RowType.PERSON_YOU_MAY_KNOW, personYouMayKnow));
                    } else {
                        friendingJewelAdapter.f13252k.add(new FriendingJewelRow(RowType.RESPONDED_PERSON_YOU_MAY_KNOW, personYouMayKnow));
                    }
                }
            }
            if (friendingJewelAdapter.f13254m && friendingJewelAdapter.f13251j.m14978b()) {
                friendingJewelAdapter.f13252k.add(new FriendingJewelRow(RowType.SEE_ALL_PYMK));
                friendingJewelAdapter.f13252k.add(new FriendingJewelRow(RowType.CONTACTS_SECTION_HEADER));
                friendingJewelAdapter.f13252k.add(new FriendingJewelRow(RowType.CONTACTS_SECTION));
            }
        }
    }

    public static View m14897a(ViewGroup viewGroup, int i) {
        View b = m14899b(viewGroup, i);
        CustomFontHelper.a(b, FontFamily.ROBOTO, FontWeight.MEDIUM, b.getTypeface());
        return b;
    }

    @VisibleForTesting
    private static TextView m14899b(ViewGroup viewGroup, int i) {
        TextView textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(2130904507, viewGroup, false);
        textView.setText(i);
        return textView;
    }

    public final void m14923j() {
        this.f13243b.m14940a();
    }

    private int m14898b(String str) {
        if (str == null) {
            return -1;
        }
        for (int i = 0; i < this.f13249h.size(); i++) {
            if (str.equals(((FriendRequest) this.f13249h.get(i)).b)) {
                return i;
            }
        }
        return -1;
    }

    private int m14900g(long j) {
        for (int i = 0; i < this.f13250i.size(); i++) {
            if (((PersonYouMayKnow) this.f13250i.get(i)).a() == j) {
                return i;
            }
        }
        return -1;
    }
}
