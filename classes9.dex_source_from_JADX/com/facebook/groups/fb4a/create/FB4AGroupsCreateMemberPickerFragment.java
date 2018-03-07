package com.facebook.groups.fb4a.create;

import android.content.Context;
import android.os.Bundle;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.groups.memberpicker.MemberPickerToken;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.user.model.User;
import com.facebook.userfilter.TypeaheadUserSearchFilterProvider;
import com.facebook.widget.friendselector.GenericFriendsSelectorFragment;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadAdapter;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadMatcherFilterProvider;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: payments_flow */
public class FB4AGroupsCreateMemberPickerFragment extends GenericFriendsSelectorFragment {
    @Inject
    public FB4AGroupsCreateMemberPickerAdapter au;

    private static <T extends InjectableComponentWithContext> void m7151a(Class<T> cls, T t) {
        m7152a((Object) t, t.getContext());
    }

    private static void m7152a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FB4AGroupsCreateMemberPickerFragment) obj).au = new FB4AGroupsCreateMemberPickerAdapter(InputMethodManagerMethodAutoProvider.b(fbInjector), (Context) fbInjector.getInstance(Context.class), (TypeaheadMatcherFilterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(TypeaheadMatcherFilterProvider.class), (TypeaheadUserSearchFilterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(TypeaheadUserSearchFilterProvider.class), (FB4AGroupsCreateFilterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FB4AGroupsCreateFilterProvider.class), Boolean_IsWorkBuildMethodAutoProvider.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    public final ImmutableList<String> m7154b() {
        return ax();
    }

    public final boolean m7158e() {
        if (m7154b() == null || m7154b().isEmpty()) {
            return false;
        }
        for (BaseToken baseToken : this.ar) {
            if (baseToken instanceof MemberPickerToken) {
                if (!((MemberPickerToken) baseToken).f) {
                }
            }
            return true;
        }
        return false;
    }

    public final void m7155c(Bundle bundle) {
        super.c(bundle);
        m7151a(FB4AGroupsCreateMemberPickerFragment.class, (InjectableComponentWithContext) this);
    }

    public final void m7156d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 553306097);
        super.d(bundle);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1387430059, a);
    }

    public final void m7157e(String str) {
        this.ap = GenericFriendsSelectorFragment.d(str);
    }

    protected final TypeaheadAdapter aq() {
        return this.au;
    }

    protected final SimpleUserToken m7153a(User user, String str) {
        MemberPickerToken memberPickerToken = new MemberPickerToken(user);
        memberPickerToken.i = a(memberPickerToken.g.b());
        return memberPickerToken;
    }

    private void m7150a(FB4AGroupsCreateMemberPickerAdapter fB4AGroupsCreateMemberPickerAdapter) {
        this.au = fB4AGroupsCreateMemberPickerAdapter;
    }
}
