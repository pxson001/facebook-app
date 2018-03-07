package com.facebook.groups.photos.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.groups.navigation.GroupsNavigationHandler;
import com.facebook.groups.photos.annotation.GroupPhotosNavigationHandler;
import com.facebook.groups.photos.intent.GroupsPhotosIntentBuilder;
import com.facebook.groups.photos.navigation.GroupsDefaultPhotosNavigationHandler;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.pandora.ui.PandoraAlbumMediaSetFragment;
import javax.inject.Inject;

/* compiled from: TOXICLE_PUBLIC_GOING_SELECTED */
public class GroupAlbumPandoraFragment extends FbFragment {
    @Inject
    public Resources f22999a;
    @Inject
    public GroupsPhotosIntentBuilder f23000b;
    @Inject
    @GroupPhotosNavigationHandler
    public GroupsNavigationHandler f23001c;
    @Inject
    public ComposerPublishServiceHelper f23002d;

    public static void m24217a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        GroupAlbumPandoraFragment groupAlbumPandoraFragment = (GroupAlbumPandoraFragment) obj;
        Resources a = ResourcesMethodAutoProvider.a(fbInjector);
        GroupsPhotosIntentBuilder b = GroupsPhotosIntentBuilder.m24253b(fbInjector);
        GroupsNavigationHandler groupsNavigationHandler = (GroupsNavigationHandler) GroupsDefaultPhotosNavigationHandler.m24266a(fbInjector);
        ComposerPublishServiceHelper b2 = ComposerPublishServiceHelper.b(fbInjector);
        groupAlbumPandoraFragment.f22999a = a;
        groupAlbumPandoraFragment.f23000b = b;
        groupAlbumPandoraFragment.f23001c = groupsNavigationHandler;
        groupAlbumPandoraFragment.f23002d = b2;
    }

    public final View m24218a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 429075672);
        View inflate = layoutInflater.inflate(2130904637, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -714336617, a);
        return inflate;
    }

    public final void m24221c(Bundle bundle) {
        super.c(bundle);
        Class cls = GroupAlbumPandoraFragment.class;
        m24217a((Object) this, getContext());
    }

    public final void m24219a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i2 == -1 && i == 1756) {
            this.f23002d.c(intent);
        }
    }

    public final void m24220a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f23001c.a(this, this.f22999a.getString(2131242203), null);
        if (o() != null) {
            o().setRequestedOrientation(1);
        }
        PandoraAlbumMediaSetFragment pandoraAlbumMediaSetFragment = new PandoraAlbumMediaSetFragment();
        Bundle bundle2 = this.s;
        pandoraAlbumMediaSetFragment.g(this.f23000b.m24254a(bundle2.getString("extra_album_id"), bundle2.getString("group_feed_id"), bundle2.getString("group_name")).getExtras());
        FragmentTransaction a = s().a();
        a.b(2131558429, pandoraAlbumMediaSetFragment, "AlbumMediaSetFragment");
        a.c();
    }
}
