package com.facebook.groups.fb4a.groupshub.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.groups.fb4a.groupsections.fragment.FB4AGroupGridFragment;
import com.facebook.groups.fb4a.groupsections.fragment.FB4AGroupsHubFragment;
import com.facebook.groups.fb4a.groupshub.abtest.FB4AGroupsHubExperiments;
import javax.inject.Inject;

/* compiled from: _id = ' */
public class FB4AGroupsGridFragmentFactory implements IFragmentFactory {
    private final FB4AGroupsHubExperiments f10206a;

    @Inject
    public FB4AGroupsGridFragmentFactory(FB4AGroupsHubExperiments fB4AGroupsHubExperiments) {
        this.f10206a = fB4AGroupsHubExperiments;
    }

    public final Fragment m10549a(Intent intent) {
        Object obj;
        FB4AGroupsHubExperiments fB4AGroupsHubExperiments = this.f10206a;
        if (fB4AGroupsHubExperiments.b() || fB4AGroupsHubExperiments.c()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            return new FB4AGroupsHubFragment();
        }
        Fragment fB4AGroupGridFragment = new FB4AGroupGridFragment();
        fB4AGroupGridFragment.g(intent.getExtras());
        return fB4AGroupGridFragment;
    }
}
