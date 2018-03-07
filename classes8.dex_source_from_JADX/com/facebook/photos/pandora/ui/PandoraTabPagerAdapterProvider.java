package com.facebook.photos.pandora.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.photos.simplepicker.module.SimplePickerFragmentFactoryMethodAutoProvider;

/* compiled from: com.facebook.groups.groupstab.ui.GroupsTabFragment */
public class PandoraTabPagerAdapterProvider extends AbstractAssistedProvider<PandoraTabPagerAdapter> {
    public final PandoraTabPagerAdapter m21678a(String str, String str2, Bundle bundle, FragmentManager fragmentManager, CallerContext callerContext, String str3) {
        return new PandoraTabPagerAdapter(String_LoggedInUserIdMethodAutoProvider.b(this), IdBasedSingletonScopeProvider.b(this, 30), IdBasedProvider.a(this, 3595), PandoraSyncTabUtils.m21656b(this), str, str2, bundle, fragmentManager, callerContext, str3, (DialtoneController) DialtoneControllerImpl.a(this), SimplePickerFragmentFactoryMethodAutoProvider.m3168a(this));
    }
}
