package com.facebook.orca.contacts.picker;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.contacts.picker.AbstractContactPickerListFilter;
import com.facebook.contacts.picker.ContactPickerFilterResult;
import com.facebook.contacts.picker.ContactPickerFilterResult.RowResult;
import com.facebook.contacts.picker.ContactPickerRow;
import com.facebook.debug.log.BLog;
import com.facebook.debug.tracer.Tracer;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.service.model.SearchUserParams;
import com.facebook.messaging.service.model.SearchUserResult;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.user.model.User;
import com.facebook.user.model.UserFbidIdentifier;
import com.facebook.user.model.UserKey;
import com.facebook.widget.filter.CustomFilter.FilterResults;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: number_of_friends_user_saw */
public class ContactPickerNonFriendUsersFilter extends AbstractContactPickerListFilter {
    private static final CallerContext f6059c = CallerContext.b(ContactPickerNonFriendUsersFilter.class, "contact_picker_non_friend_filter");
    private static final ImmutableSet<Integer> f6060d = ImmutableSet.of(Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(3));
    private final Resources f6061e;
    private final SearchUsersFetcher f6062f;
    private final boolean f6063g;

    public static ContactPickerNonFriendUsersFilter m5782b(InjectorLike injectorLike) {
        return new ContactPickerNonFriendUsersFilter(FbHandlerThreadFactory.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), SearchUsersFetcher.m5807a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ContactPickerNonFriendUsersFilter(FbHandlerThreadFactory fbHandlerThreadFactory, Resources resources, SearchUsersFetcher searchUsersFetcher, Boolean bool) {
        super(fbHandlerThreadFactory);
        this.f6061e = resources;
        this.f6062f = searchUsersFetcher;
        this.f6063g = bool.booleanValue();
    }

    protected final FilterResults m5783b(@Nullable CharSequence charSequence) {
        String trim;
        FilterResults filterResults = new FilterResults();
        TracerDetour.a("ContactPickerNonFriendUsersFilter.Filtering", 1874158684);
        if (charSequence != null) {
            try {
                trim = charSequence.toString().trim();
            } catch (Throwable e) {
                BLog.a("orca:ContactPickerNonFriendUsersFilter", "Exception during filtering", e);
                filterResults.a = ContactPickerFilterResult.b(charSequence);
                filterResults.b = 0;
            } finally {
                TracerDetour.a(756631125);
                filterResults = "orca:ContactPickerNonFriendUsersFilter";
                Tracer.c(filterResults);
            }
        } else {
            trim = "";
        }
        if (trim.length() != 0) {
            Builder builder = ImmutableList.builder();
            Builder builder2 = ImmutableList.builder();
            Builder builder3 = ImmutableList.builder();
            m5781a(trim, builder, builder2, builder3);
            Builder builder4 = ImmutableList.builder();
            if (this.f6063g) {
                trim = null;
            } else {
                trim = this.f6061e.getString(2131231205);
            }
            builder4.c(new RowResult(builder2.b(), trim));
            builder.b(builder3.b());
            builder4.c(new RowResult(builder.b(), this.f6061e.getString(2131231196)));
            ContactPickerFilterResult b = ContactPickerFilterResult.b(charSequence, builder4.b());
            filterResults.a = b;
            filterResults.b = b.c();
        } else {
            filterResults.a = ContactPickerFilterResult.a(charSequence);
            filterResults.b = -1;
        }
        TracerDetour.a(-1572062957);
        Tracer.c("orca:ContactPickerNonFriendUsersFilter");
        return filterResults;
    }

    private void m5781a(String str, Builder<ContactPickerRow> builder, Builder<ContactPickerRow> builder2, Builder<ContactPickerRow> builder3) {
        try {
            Set a = Sets.a();
            SearchUserResult searchUserResult = (SearchUserResult) FutureDetour.a(this.f6062f.m5811a(new SearchUserParams(str, f6060d)), -1663616847);
            m5780a(searchUserResult.b(), a, builder2);
            m5780a(searchUserResult.a(), a, builder);
            m5780a(searchUserResult.c(), a, builder3);
        } catch (Exception e) {
        }
    }

    private void m5780a(ImmutableList<User> immutableList, Set<UserKey> set, Builder<ContactPickerRow> builder) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            User user = (User) immutableList.get(i);
            if (!set.contains(user.T)) {
                UserFbidIdentifier n = user.n();
                if (!(n == null || a(n))) {
                    builder.c(this.b.a(user));
                    set.add(user.T);
                }
            }
        }
    }
}
