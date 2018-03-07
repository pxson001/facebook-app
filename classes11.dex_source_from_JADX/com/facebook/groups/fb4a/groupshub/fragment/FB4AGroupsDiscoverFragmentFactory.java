package com.facebook.groups.fb4a.groupshub.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.groups.fb4a.discover.FB4AGroupsDiscoverFragment;
import com.facebook.groups.fb4a.groupsections.fragment.FB4AGroupsHubFragment;
import com.facebook.groups.fb4a.groupshub.abtest.FB4AGroupsHubExperiments;
import javax.inject.Inject;

/* compiled from: _italic */
public class FB4AGroupsDiscoverFragmentFactory implements IFragmentFactory {
    private final FB4AGroupsHubExperiments f10205a;

    @Inject
    public FB4AGroupsDiscoverFragmentFactory(FB4AGroupsHubExperiments fB4AGroupsHubExperiments) {
        this.f10205a = fB4AGroupsHubExperiments;
    }

    public final Fragment m10548a(Intent intent) {
        if (this.f10205a.b()) {
            FB4AGroupsHubFragment fB4AGroupsHubFragment = new FB4AGroupsHubFragment();
            Bundle bundle = intent.getExtras() == null ? new Bundle() : intent.getExtras();
            bundle.putString("groups_hub_tab", "groups_hub_discover");
            fB4AGroupsHubFragment.g(bundle);
            return fB4AGroupsHubFragment;
        }
        Fragment fB4AGroupsDiscoverFragment = new FB4AGroupsDiscoverFragment();
        fB4AGroupsDiscoverFragment.g(intent.getExtras());
        return fB4AGroupsDiscoverFragment;
    }
}
