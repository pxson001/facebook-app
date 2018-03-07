package com.facebook.redspace.data;

import com.facebook.inject.Assisted;
import com.facebook.redspace.data.RedSpaceMutationsExecutor.SimpleFriendChangedSubscriber;
import com.facebook.redspace.event.OverflowPicturesUpdateEvent;
import com.facebook.redspace.event.RedSpaceEventBus;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsOverflowCountQueryModel.RedspaceModel.OverflowFriendsModel.NodesModel.Builder;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ultralight.Inject;
import com.facebook.widget.listview.MultiAdapterListAdapter;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: PreparsingStringRef */
public class RedSpaceOverflowSubscriptionHelper extends SimpleFriendChangedSubscriber {
    @Inject
    public RedSpaceEventBus f11849a;
    public final RedSpaceMutationsExecutor f11850b;
    private final MultiAdapterListAdapter f11851c;
    private final RedSpaceFriendsCollection f11852d;
    private final RedSpaceFriendsSection f11853e;
    public SimpleFriendChangedSubscriber f11854f;

    @Inject
    public RedSpaceOverflowSubscriptionHelper(RedSpaceMutationsExecutor redSpaceMutationsExecutor, @Assisted RedSpaceFriendsCollection redSpaceFriendsCollection, @Assisted MultiAdapterListAdapter multiAdapterListAdapter, @Assisted RedSpaceFriendsSection redSpaceFriendsSection) {
        this.f11852d = redSpaceFriendsCollection;
        this.f11853e = redSpaceFriendsSection;
        this.f11851c = multiAdapterListAdapter;
        this.f11850b = redSpaceMutationsExecutor;
        this.f11850b.m12288a((SimpleFriendChangedSubscriber) this);
    }

    public final void mo336a(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, RedSpaceFriendsSection redSpaceFriendsSection) {
        if (this.f11853e == redSpaceFriendsSection) {
            this.f11852d.m12216a(false, redSpaceFeedProfileFragmentModel);
            m12307c();
            if (this.f11854f != null) {
                this.f11854f.mo336a(redSpaceFeedProfileFragmentModel, redSpaceFriendsSection);
            }
        }
    }

    public final void mo337b(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, RedSpaceFriendsSection redSpaceFriendsSection) {
        if (this.f11853e == redSpaceFriendsSection) {
            this.f11852d.m12220b(redSpaceFeedProfileFragmentModel);
            m12307c();
            if (this.f11854f != null) {
                this.f11854f.mo337b(redSpaceFeedProfileFragmentModel, redSpaceFriendsSection);
            }
        }
    }

    private void m12307c() {
        AdapterDetour.a(this.f11851c, 1591007899);
        m12309b();
    }

    public final void m12309b() {
        if (this.f11852d.m12222d() != 0 || !this.f11852d.m12218a()) {
            Collection arrayList = new ArrayList();
            int i = 0;
            while (i < 3 && i < this.f11852d.m12222d()) {
                Builder builder = new Builder();
                builder.a = this.f11852d.m12213a(i).l();
                arrayList.add(builder.a());
                i++;
            }
            this.f11849a.a(new OverflowPicturesUpdateEvent(this.f11853e, ImmutableList.copyOf(arrayList)));
        }
    }
}
