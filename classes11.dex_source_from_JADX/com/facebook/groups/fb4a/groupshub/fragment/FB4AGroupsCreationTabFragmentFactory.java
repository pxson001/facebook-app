package com.facebook.groups.fb4a.groupshub.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.groups.fb4a.createrpanel.FB4AGroupsCreateTabFragment;
import com.facebook.groups.fb4a.groupsections.fragment.FB4AGroupsHubFragment;
import com.facebook.groups.fb4a.groupshub.abtest.FB4AGroupsHubExperiments;
import javax.inject.Inject;

/* compiled from: _launch_failed */
public class FB4AGroupsCreationTabFragmentFactory implements IFragmentFactory {
    private final FB4AGroupsHubExperiments f10204a;

    @Inject
    public FB4AGroupsCreationTabFragmentFactory(FB4AGroupsHubExperiments fB4AGroupsHubExperiments) {
        this.f10204a = fB4AGroupsHubExperiments;
    }

    public final Fragment m10547a(Intent intent) {
        if (this.f10204a.c()) {
            FB4AGroupsHubFragment fB4AGroupsHubFragment = new FB4AGroupsHubFragment();
            fB4AGroupsHubFragment.g(intent.getExtras());
            return fB4AGroupsHubFragment;
        }
        Fragment fB4AGroupsCreateTabFragment = new FB4AGroupsCreateTabFragment();
        fB4AGroupsCreateTabFragment.g(intent.getExtras());
        return fB4AGroupsCreateTabFragment;
    }
}
