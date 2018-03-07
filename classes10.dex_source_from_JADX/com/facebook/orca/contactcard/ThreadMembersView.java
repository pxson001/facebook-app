package com.facebook.orca.contactcard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.contacts.picker.ContactPickerListFilter;
import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.contacts.picker.ContactPickerUserRow.PushableType;
import com.facebook.contacts.picker.ContactPickerUserRow.RowStyle;
import com.facebook.contacts.picker.ContactPickerUserRowBuilder;
import com.facebook.contacts.picker.UserComparatorByName;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.annotations.ForDefaultPicker;
import com.facebook.messaging.annotations.ForDivebarList;
import com.facebook.messaging.contacts.picker.ContactPickerListItem;
import com.facebook.messaging.contacts.picker.ContactPickerViewListAdapter;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.users.MessengerUserCheckHelper;
import com.facebook.orca.contacts.picker.DivebarContactPickerViewFactory;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.listview.BetterListView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: onion_tor_disabled */
public class ThreadMembersView extends CustomViewGroup {
    @Inject
    @ForDivebarList
    Provider<ContactPickerListFilter> f5780a;
    @Inject
    MessengerUserCheckHelper f5781b;
    @Inject
    @LoggedInUserId
    Provider<String> f5782c;
    @Inject
    @ForDefaultPicker
    DivebarContactPickerViewFactory f5783d;
    @Inject
    UserCache f5784e;
    private final UserComparatorByName f5785f;
    private final Button f5786g;
    private ThreadSummary f5787h;
    public Listener f5788i;
    public boolean f5789j;
    public boolean f5790k;
    private Set<User> f5791l;
    private ContactPickerViewListAdapter f5792m;

    /* compiled from: onion_tor_disabled */
    public interface Listener {
        void mo215a();

        void mo216a(User user);
    }

    /* compiled from: onion_tor_disabled */
    class C08391 implements OnItemClickListener {
        final /* synthetic */ ThreadMembersView f5778a;

        C08391(ThreadMembersView threadMembersView) {
            this.f5778a = threadMembersView;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            User user = ((ContactPickerListItem) view).f1855F.a;
            ThreadMembersView.m5474b(this.f5778a, user);
            if (this.f5778a.f5788i != null) {
                this.f5778a.f5788i.mo216a(user);
            }
            this.f5778a.f5788i;
        }
    }

    /* compiled from: onion_tor_disabled */
    class C08402 implements OnClickListener {
        final /* synthetic */ ThreadMembersView f5779a;

        C08402(ThreadMembersView threadMembersView) {
            this.f5779a = threadMembersView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 300849159);
            if (this.f5779a.f5788i != null) {
                this.f5779a.f5788i.mo215a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -209880625, a);
        }
    }

    public ThreadMembersView(Context context) {
        this(context, null);
    }

    public ThreadMembersView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadMembersView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5785f = new UserComparatorByName();
        FbInjector.a(ThreadMembersView.class, this);
        setContentView(2130905701);
        BetterListView betterListView = (BetterListView) getView(2131564865);
        this.f5786g = (Button) getView(2131564866);
        betterListView.setOnItemClickListener(new C08391(this));
        this.f5786g.setOnClickListener(new C08402(this));
        this.f5791l = Sets.a();
        this.f5792m = new ContactPickerViewListAdapter(this.f5783d, this.f5780a);
        betterListView.setAdapter(this.f5792m);
    }

    public void setThreadSummary(ThreadSummary threadSummary) {
        this.f5787h = threadSummary;
        this.f5788i;
    }

    public void setListener(Listener listener) {
        this.f5788i = listener;
    }

    public void setActionButtonEnabled(boolean z) {
        this.f5786g.setEnabled(z);
    }

    public void setActionCaption(String str) {
        this.f5786g.setText(str);
        this.f5786g.setContentDescription(str);
    }

    public final void m5476a(boolean z) {
        this.f5789j = z;
    }

    public void setExcludeLoggedInUser(boolean z) {
        this.f5790k = z;
    }

    public ImmutableList<User> getSelectedUsers() {
        return ImmutableList.copyOf(this.f5791l);
    }

    public static void m5471a(ThreadMembersView threadMembersView) {
        List<User> a = Lists.a(threadMembersView.f5787h.h.size());
        ImmutableList immutableList = threadMembersView.f5787h.h;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            User a2 = threadMembersView.f5784e.a(((ThreadParticipant) immutableList.get(i)).b());
            if (!(a2 == null || threadMembersView.m5475c(a2))) {
                a.add(a2);
            }
        }
        Collections.sort(a, threadMembersView.f5785f);
        Builder builder = ImmutableList.builder();
        for (User a22 : a) {
            builder.c(threadMembersView.m5469a(a22));
        }
        threadMembersView.f5792m.a(builder.b());
        AdapterDetour.b(threadMembersView.f5792m, -1869937212);
        if (threadMembersView.f5787h.w) {
            threadMembersView.f5786g.setVisibility(0);
        } else {
            threadMembersView.f5786g.setVisibility(8);
        }
    }

    private ContactPickerUserRow m5469a(User user) {
        PushableType pushableType;
        boolean a = this.f5781b.a(user);
        boolean z = this.f5788i != null ? this.f5789j && this.f5791l.contains(user) : false;
        ContactPickerUserRowBuilder contactPickerUserRowBuilder = new ContactPickerUserRowBuilder();
        contactPickerUserRowBuilder.a = user;
        contactPickerUserRowBuilder = contactPickerUserRowBuilder;
        contactPickerUserRowBuilder.b = RowStyle.NEUE_PICKER;
        contactPickerUserRowBuilder = contactPickerUserRowBuilder;
        if (a) {
            pushableType = PushableType.ON_MESSENGER;
        } else {
            pushableType = PushableType.ON_FACEBOOK;
        }
        contactPickerUserRowBuilder.l = pushableType;
        ContactPickerUserRowBuilder contactPickerUserRowBuilder2 = contactPickerUserRowBuilder;
        contactPickerUserRowBuilder2.h = false;
        ContactPickerUserRowBuilder contactPickerUserRowBuilder3 = contactPickerUserRowBuilder2;
        contactPickerUserRowBuilder3.z = this.f5789j;
        contactPickerUserRowBuilder3 = contactPickerUserRowBuilder3;
        contactPickerUserRowBuilder3.j = z;
        return contactPickerUserRowBuilder3.a();
    }

    public static void m5474b(ThreadMembersView threadMembersView, User user) {
        if (!threadMembersView.f5791l.remove(user)) {
            threadMembersView.f5791l.add(user);
        }
    }

    private boolean m5475c(User user) {
        if (this.f5790k) {
            return user.a.equals(this.f5782c.get());
        }
        return false;
    }
}
