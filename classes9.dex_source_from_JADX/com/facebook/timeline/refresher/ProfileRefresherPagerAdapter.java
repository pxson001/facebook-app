package com.facebook.timeline.refresher;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.facebook.graphql.enums.GraphQLProfileWizardStepType;
import com.google.common.base.Preconditions;
import java.util.List;
import java.util.Map;

/* compiled from: unseen_assets_count */
public class ProfileRefresherPagerAdapter extends FragmentPagerAdapter {
    public final FragmentManager f1025a;
    public final List<Fragment> f1026b;
    private final Map<GraphQLProfileWizardStepType, Fragment> f1027c;
    private final Map<GraphQLProfileWizardStepType, Integer> f1028d;

    public ProfileRefresherPagerAdapter(FragmentManager fragmentManager, List<Fragment> list, Map<GraphQLProfileWizardStepType, Fragment> map, Map<GraphQLProfileWizardStepType, Integer> map2) {
        super(fragmentManager);
        this.f1025a = fragmentManager;
        this.f1026b = list;
        this.f1027c = map;
        this.f1028d = map2;
    }

    public final int m1037b() {
        return this.f1026b.size();
    }

    public final Fragment m1036a(int i) {
        return (Fragment) this.f1026b.get(i);
    }

    public final int m1035a(GraphQLProfileWizardStepType graphQLProfileWizardStepType) {
        return ((Integer) this.f1028d.get(graphQLProfileWizardStepType)).intValue();
    }

    public final Fragment m1038b(GraphQLProfileWizardStepType graphQLProfileWizardStepType) {
        Preconditions.checkArgument(m1039c(graphQLProfileWizardStepType));
        return (Fragment) this.f1027c.get(graphQLProfileWizardStepType);
    }

    public final boolean m1039c(GraphQLProfileWizardStepType graphQLProfileWizardStepType) {
        return this.f1027c.get(graphQLProfileWizardStepType) != null;
    }
}
