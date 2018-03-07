package com.facebook.groups.editsettings.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.locale.Locales;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.groups.editsettings.GroupEditSettingsController;
import com.facebook.groups.editsettings.adapter.GroupEditPrivacyAdapter;
import com.facebook.groups.editsettings.adapter.GroupEditPrivacyAdapterProvider;
import com.facebook.groups.editsettings.annotation.EditGroupPrivacyNavigationHandler;
import com.facebook.groups.editsettings.protocol.FetchGroupSettingsModels.FetchGroupSettingsModel;
import com.facebook.groups.editsettings.util.GroupPrivacyDescriptionUtil;
import com.facebook.groups.navigation.DefaultGroupsNavigationHandler;
import com.facebook.groups.navigation.GroupsNavigationHandler;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.listview.BetterListView;
import javax.inject.Inject;

/* compiled from: Unexpected null view from getView() */
public class GroupEditPrivacyFragment extends FbFragment {
    @Inject
    public GroupEditPrivacyAdapterProvider f21634a;
    @Inject
    public Resources f21635b;
    @EditGroupPrivacyNavigationHandler
    @Inject
    public GroupsNavigationHandler f21636c;
    private GroupEditPrivacyAdapter f21637d;
    private BetterListView f21638e;
    private FetchGroupSettingsModel f21639f;
    private final C30951 f21640g = new C30951(this);

    /* compiled from: Unexpected null view from getView() */
    public class C30951 {
        final /* synthetic */ GroupEditPrivacyFragment f21633a;

        C30951(GroupEditPrivacyFragment groupEditPrivacyFragment) {
            this.f21633a = groupEditPrivacyFragment;
        }

        public final void m22603a() {
            if (this.f21633a.y) {
                this.f21633a.o().onBackPressed();
            }
        }
    }

    public static void m22604a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        GroupEditPrivacyFragment groupEditPrivacyFragment = (GroupEditPrivacyFragment) obj;
        GroupEditPrivacyAdapterProvider groupEditPrivacyAdapterProvider = (GroupEditPrivacyAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupEditPrivacyAdapterProvider.class);
        Resources a = ResourcesMethodAutoProvider.a(fbInjector);
        GroupsNavigationHandler groupsNavigationHandler = (GroupsNavigationHandler) DefaultGroupsNavigationHandler.a(fbInjector);
        groupEditPrivacyFragment.f21634a = groupEditPrivacyAdapterProvider;
        groupEditPrivacyFragment.f21635b = a;
        groupEditPrivacyFragment.f21636c = groupsNavigationHandler;
    }

    public final void m22607c(Bundle bundle) {
        Class cls = GroupEditPrivacyFragment.class;
        m22604a((Object) this, getContext());
        super.c(bundle);
        this.f21639f = (FetchGroupSettingsModel) FlatBufferModelHelper.a(this.s, "group_edit_privacy_data");
    }

    public final View m22605a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -748863161);
        View inflate = layoutInflater.inflate(2130904652, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1497694831, a);
        return inflate;
    }

    public final void m22606a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f21636c.a(this, this.f21635b.getString(2131242161), null);
        this.f21638e = (BetterListView) view.findViewById(2131562661);
        InjectorLike injectorLike = this.f21634a;
        FragmentManager kO_ = kO_();
        this.f21637d = new GroupEditPrivacyAdapter(kO_, this.f21640g, GroupPrivacyDescriptionUtil.m22873b(injectorLike), GroupEditSettingsController.m22535b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), Locales.a(injectorLike));
        GroupEditPrivacyAdapter groupEditPrivacyAdapter = this.f21637d;
        FetchGroupSettingsModel fetchGroupSettingsModel = this.f21639f;
        if (!(fetchGroupSettingsModel == null || fetchGroupSettingsModel.m22792C() == null)) {
            groupEditPrivacyAdapter.f21549i = fetchGroupSettingsModel;
            groupEditPrivacyAdapter.f21548h = fetchGroupSettingsModel.m22792C().name();
            GroupEditPrivacyAdapter.m22552b(groupEditPrivacyAdapter);
        }
        this.f21638e.setAdapter(this.f21637d);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1889213600);
        super.mY_();
        this.f21637d.f21541a.f21530k = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1422462284, a);
    }
}
