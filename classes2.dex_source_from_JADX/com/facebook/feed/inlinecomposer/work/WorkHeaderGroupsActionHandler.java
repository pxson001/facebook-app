package com.facebook.feed.inlinecomposer.work;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fragmentconstants.FragmentConstants$ContentFragmentType;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.katana.app.module.common.ComponentName_FragmentChromeActivityMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: n/a */
public class WorkHeaderGroupsActionHandler {
    private final SecureContextHelper f13060a;
    private final ComponentName f13061b;
    public final ComposerLauncher f13062c;

    public static WorkHeaderGroupsActionHandler m19209b(InjectorLike injectorLike) {
        return new WorkHeaderGroupsActionHandler(DefaultSecureContextHelper.m4636a(injectorLike), ComponentName_FragmentChromeActivityMethodAutoProvider.m19211b(injectorLike), ComposerLauncherImpl.m14892a(injectorLike));
    }

    @Inject
    public WorkHeaderGroupsActionHandler(SecureContextHelper secureContextHelper, @FragmentChromeActivity ComponentName componentName, ComposerLauncher composerLauncher) {
        this.f13060a = secureContextHelper;
        this.f13061b = componentName;
        this.f13062c = composerLauncher;
    }

    public final void m19210a(Context context) {
        Intent component = new Intent().setComponent(this.f13061b);
        component.putExtra("target_fragment", FragmentConstants$ContentFragmentType.GROUPS_GRID_FRAGMENT.ordinal());
        this.f13060a.mo662a(component, context);
    }
}
