package com.facebook.groups.info;

import android.content.ComponentName;
import android.content.Intent;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: ThreadItemView.onAttachedToWindow */
public class GroupInfoIntentBuilder {
    public final Provider<Boolean> f22711a;
    public final QeAccessor f22712b;
    private final Provider<ComponentName> f22713c;
    public final Provider<ComponentName> f22714d;

    public static GroupInfoIntentBuilder m23667b(InjectorLike injectorLike) {
        return new GroupInfoIntentBuilder(IdBasedProvider.a(injectorLike, 12), IdBasedProvider.a(injectorLike, 12), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3967));
    }

    @Inject
    public GroupInfoIntentBuilder(@FragmentChromeActivity Provider<ComponentName> provider, @FragmentChromeActivity Provider<ComponentName> provider2, QeAccessor qeAccessor, Provider<Boolean> provider3) {
        this.f22713c = provider;
        this.f22714d = provider2;
        this.f22711a = provider3;
        this.f22712b = qeAccessor;
    }

    public final Intent m23669a(String str) {
        Intent a = m23665a();
        a.putExtra("target_fragment", ContentFragmentType.GROUP_CREATE_SIDE_CONVERSATION_FRAGMENT.ordinal());
        a.putExtra("group_feed_id", str);
        return a;
    }

    public static GroupInfoIntentBuilder m23666a(InjectorLike injectorLike) {
        return m23667b(injectorLike);
    }

    public final Intent m23673b(String str) {
        Intent a = m23665a();
        a.putExtra("group_feed_id", str);
        a.putExtra("target_fragment", ContentFragmentType.GROUP_EVENTS_FRAGMENT.ordinal());
        return a;
    }

    public final Intent m23670a(String str, String str2) {
        Intent a = m23665a();
        a.putExtra("group_feed_id", str);
        a.putExtra("target_fragment", ContentFragmentType.GROUP_PHOTOS_FRAGMENT.ordinal());
        a.putExtra("group_name", str2);
        return a;
    }

    public final Intent m23668a(FetchGroupInformationModel fetchGroupInformationModel) {
        Intent a = m23665a();
        a.putExtra("target_fragment", ContentFragmentType.GROUPS_FOR_SALE_POSTS_FRAGMENT.ordinal());
        FlatBufferModelHelper.a(a, "group_feed_model", fetchGroupInformationModel);
        a.putExtra("group_feed_id", fetchGroupInformationModel.gW_());
        return a;
    }

    public final Intent m23671a(String str, boolean z) {
        Intent a = m23665a();
        a.putExtra("target_fragment", ContentFragmentType.GROUP_PENDING_POSTS_FRAGMENT.ordinal());
        a.putExtra("group_is_viewer_admin", z);
        a.putExtra("group_feed_id", str);
        return a;
    }

    public final Intent m23674c(String str) {
        Intent a = m23665a();
        a.putExtra("target_fragment", ContentFragmentType.GROUP_EDIT_SETTINGS_FRAGMENT.ordinal());
        a.putExtra("group_feed_id", str);
        return a;
    }

    public final Intent m23675d(String str) {
        Intent a = m23665a();
        a.putExtra("group_feed_id", str);
        a.putExtra("target_fragment", ContentFragmentType.GROUP_MEMBERSHIP_FRAGMENT.ordinal());
        return a;
    }

    public final Intent m23676e(String str) {
        Intent a = m23665a();
        a.putExtra("group_feed_id", str);
        a.putExtra("target_fragment", ContentFragmentType.WORK_GROUPS_COMPANIES_FRAGMENT.ordinal());
        return a;
    }

    public final Intent m23677f(String str) {
        Intent a = m23665a();
        a.putExtra("target_fragment", ContentFragmentType.GROUP_SUBSCRIPTION_FRAGMENT.ordinal());
        a.putExtra("group_feed_id", str);
        return a;
    }

    public final Intent m23672b(FetchGroupInformationModel fetchGroupInformationModel) {
        Intent component = new Intent().setComponent((ComponentName) this.f22713c.get());
        component.putExtra("group_feed_id", fetchGroupInformationModel.gW_());
        component.putExtra("target_fragment", ContentFragmentType.GROUP_INFO_FRAGMENT.ordinal());
        FlatBufferModelHelper.a(component, "group_feed_model", fetchGroupInformationModel);
        return component;
    }

    public final Intent m23678g(String str) {
        Intent a = m23665a();
        a.putExtra("target_fragment", ContentFragmentType.GROUP_MEMBER_REQUESTS_FRAGMENT.ordinal());
        a.putExtra("group_feed_id", str);
        a.putExtra("group_request_member_header_visible", false);
        return a;
    }

    private Intent m23665a() {
        return new Intent().setComponent((ComponentName) this.f22713c.get());
    }
}
