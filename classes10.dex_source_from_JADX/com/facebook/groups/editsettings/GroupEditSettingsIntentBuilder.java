package com.facebook.groups.editsettings;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.groups.editsettings.protocol.FetchGroupSettingsModels.FetchGroupSettingsModel;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Unknown AccessToken serialization format. */
public class GroupEditSettingsIntentBuilder {
    private final Provider<ComponentName> f21532a;

    public static GroupEditSettingsIntentBuilder m22546b(InjectorLike injectorLike) {
        return new GroupEditSettingsIntentBuilder(IdBasedProvider.a(injectorLike, 12));
    }

    @Inject
    public GroupEditSettingsIntentBuilder(@FragmentChromeActivity Provider<ComponentName> provider) {
        this.f21532a = provider;
    }

    private Intent m22545a() {
        return new Intent().setComponent((ComponentName) this.f21532a.get());
    }

    public final Intent m22547a(FetchGroupSettingsModel fetchGroupSettingsModel) {
        Bundle bundle = new Bundle();
        FlatBufferModelHelper.a(bundle, "group_edit_name_description_data", fetchGroupSettingsModel);
        Intent a = m22545a();
        a.putExtras(bundle);
        a.putExtra("target_fragment", ContentFragmentType.GROUP_EDIT_NAME_DESC_FRAGMENT.ordinal());
        return a;
    }

    public final Intent m22548b(FetchGroupSettingsModel fetchGroupSettingsModel) {
        Bundle bundle = new Bundle();
        FlatBufferModelHelper.a(bundle, "group_edit_name_description_data", fetchGroupSettingsModel);
        Intent a = m22545a();
        a.putExtras(bundle);
        a.putExtra("target_fragment", ContentFragmentType.GROUP_EDIT_PURPOSE_FRAGMENT.ordinal());
        return a;
    }

    public final Intent m22549c(FetchGroupSettingsModel fetchGroupSettingsModel) {
        Bundle bundle = new Bundle();
        FlatBufferModelHelper.a(bundle, "group_edit_privacy_data", fetchGroupSettingsModel);
        Intent a = m22545a();
        a.putExtras(bundle);
        a.putExtra("target_fragment", ContentFragmentType.GROUP_EDIT_PRIVACY_FRAGMENT.ordinal());
        return a;
    }
}
