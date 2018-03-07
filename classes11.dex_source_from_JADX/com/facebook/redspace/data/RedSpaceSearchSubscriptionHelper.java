package com.facebook.redspace.data;

import com.facebook.inject.Assisted;
import com.facebook.redspace.data.RedSpaceMutationsExecutor.SimpleFriendChangedSubscriber;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ultralight.Inject;
import com.facebook.widget.listview.MultiAdapterListAdapter;

/* compiled from: Prefetch download failed */
public class RedSpaceSearchSubscriptionHelper extends SimpleFriendChangedSubscriber {
    public final RedSpaceMutationsExecutor f11864a;
    private final MultiAdapterListAdapter f11865b;
    private final RedSpaceFriendsSearchCollection f11866c;

    @Inject
    public RedSpaceSearchSubscriptionHelper(RedSpaceMutationsExecutor redSpaceMutationsExecutor, @Assisted RedSpaceFriendsSearchCollection redSpaceFriendsSearchCollection, @Assisted MultiAdapterListAdapter multiAdapterListAdapter) {
        this.f11866c = redSpaceFriendsSearchCollection;
        this.f11865b = multiAdapterListAdapter;
        this.f11864a = redSpaceMutationsExecutor;
        this.f11864a.m12288a((SimpleFriendChangedSubscriber) this);
    }

    public final void mo336a(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, RedSpaceFriendsSection redSpaceFriendsSection) {
        if (redSpaceFriendsSection.isTop()) {
            this.f11866c.m12240d(redSpaceFeedProfileFragmentModel);
            if (redSpaceFriendsSection.isOverflow()) {
                this.f11866c.f11806e.add(redSpaceFeedProfileFragmentModel.k());
            } else {
                this.f11866c.f11806e.remove(redSpaceFeedProfileFragmentModel.k());
            }
            AdapterDetour.a(this.f11865b, -571097961);
        }
    }

    public final void mo337b(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, RedSpaceFriendsSection redSpaceFriendsSection) {
        if (redSpaceFriendsSection.isTop()) {
            this.f11866c.f11805d.remove(redSpaceFeedProfileFragmentModel.k());
            AdapterDetour.a(this.f11865b, -680139929);
        }
    }

    public final void mo338b(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
        this.f11866c.m12242h(redSpaceFeedProfileFragmentModel);
        AdapterDetour.a(this.f11865b, -779146059);
    }
}
