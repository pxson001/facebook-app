package com.facebook.groups.editsettings.adapter;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.i18n.BasicDateTimeFormat;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.groups.editsettings.GroupEditSettingsController;
import com.facebook.groups.editsettings.GroupEditSettingsIntentBuilder;
import com.facebook.groups.editsettings.fragment.GroupEditSettingsFragment.C31001;
import com.facebook.groups.editsettings.util.GroupPrivacyDescriptionUtil;
import com.facebook.groups.editsettings.view.DefaultEditSettingsViewManager;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;

/* compiled from: Unexpected state %s advancing from %s to %s for keyboard %s */
public class GroupEditSettingsAdapterProvider extends AbstractAssistedProvider<GroupEditSettingsAdapter> {
    public final GroupEditSettingsAdapter m22585a(C31001 c31001) {
        return new GroupEditSettingsAdapter(c31001, GroupEditSettingsController.m22535b((InjectorLike) this), ResourcesMethodAutoProvider.a(this), GroupEditSettingsIntentBuilder.m22546b((InjectorLike) this), (SecureContextHelper) DefaultSecureContextHelper.a(this), (UriIntentMapper) Fb4aUriIntentMapper.a(this), BasicDateTimeFormat.a(this), GroupPrivacyDescriptionUtil.m22873b((InjectorLike) this), IdBasedProvider.a(this, 685), DefaultEditSettingsViewManager.m22884b(this));
    }
}
