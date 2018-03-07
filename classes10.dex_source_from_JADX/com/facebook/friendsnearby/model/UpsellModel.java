package com.facebook.friendsnearby.model;

import com.facebook.backgroundlocation.privacypicker.graphql.BackgroundLocationPrivacyPickerGraphQLInterfaces.BackgroundLocationPrivacyPickerOptionEdge;
import com.facebook.backgroundlocation.upsell.graphql.BackgroundLocationUpsellGraphQLInterfaces.BackgroundLocationUpsellProfile;
import com.facebook.backgroundlocation.upsell.graphql.BackgroundLocationUpsellGraphQLModels.BackgroundLocationUpsellProfileModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyLocationSharingFieldsModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyLocationSharingFieldsModel.FriendsSharingModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyLocationSharingFieldsModel.UpsellModel.FriendsSharingLocationConnectionModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyLocationSharingQueryModel.PrivacySettingsModel;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: __dispatchEvent */
public class UpsellModel {
    private List<UserKey> f20584a;
    public ImmutableList<? extends BackgroundLocationUpsellProfile> f20585b;
    public int f20586c;
    private int f20587d;
    @Nullable
    public ImmutableList<? extends BackgroundLocationPrivacyPickerOptionEdge> f20588e;

    public UpsellModel(FriendsNearbyDataUtil friendsNearbyDataUtil, FriendsNearbyLocationSharingFieldsModel friendsNearbyLocationSharingFieldsModel, @Nullable PrivacySettingsModel privacySettingsModel) {
        ImmutableList immutableList;
        FriendsSharingLocationConnectionModel b;
        FriendsSharingModel a;
        FriendsSharingModel.FriendsSharingLocationConnectionModel a2;
        if (friendsNearbyLocationSharingFieldsModel == null) {
            immutableList = RegularImmutableList.a;
        } else {
            com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyLocationSharingFieldsModel.UpsellModel j = friendsNearbyLocationSharingFieldsModel.m21324j();
            if (j == null) {
                immutableList = RegularImmutableList.a;
            } else {
                FriendsSharingLocationConnectionModel b2 = j.m21310b();
                if (b2 == null) {
                    immutableList = RegularImmutableList.a;
                } else {
                    immutableList = b2.m21303b();
                    Builder builder = ImmutableList.builder();
                    int size = immutableList.size();
                    for (int i = 0; i < size; i++) {
                        builder.c(UserKey.b(((BackgroundLocationUpsellProfileModel) immutableList.get(i)).m15588b()));
                    }
                    immutableList = builder.b();
                }
            }
        }
        this.f20584a = immutableList;
        ImmutableList immutableList2 = null;
        com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyLocationSharingFieldsModel.UpsellModel n = FriendsNearbyDataUtil.m20827n(friendsNearbyLocationSharingFieldsModel);
        if (n != null) {
            b = n.m21310b();
            if (b != null) {
                immutableList2 = b.m21303b();
            }
        }
        immutableList = immutableList2;
        if (immutableList == null) {
            immutableList2 = null;
            if (friendsNearbyLocationSharingFieldsModel != null) {
                a = friendsNearbyLocationSharingFieldsModel.m21317a();
                if (a != null) {
                    a2 = a.m21261a();
                    if (a2 != null) {
                        immutableList2 = a2.m21257b();
                    }
                }
            }
            immutableList = immutableList2;
            if (immutableList == null) {
                immutableList = RegularImmutableList.a;
            }
        }
        this.f20585b = immutableList;
        int i2 = -1;
        n = FriendsNearbyDataUtil.m20827n(friendsNearbyLocationSharingFieldsModel);
        if (n != null) {
            b = n.m21310b();
            if (b != null) {
                i2 = b.m21299a();
            }
        }
        int i3 = i2;
        if (i3 < 0) {
            i2 = -1;
            if (friendsNearbyLocationSharingFieldsModel != null) {
                a = friendsNearbyLocationSharingFieldsModel.m21317a();
                if (a != null) {
                    a2 = a.m21261a();
                    if (a2 != null) {
                        i2 = a2.m21253a();
                    }
                }
            }
            i3 = i2;
            if (i3 < 0) {
                i3 = 0;
            }
        }
        this.f20586c = i3;
        this.f20587d = friendsNearbyDataUtil.m20828f(friendsNearbyLocationSharingFieldsModel);
        immutableList = null;
        if (!(privacySettingsModel == null || privacySettingsModel.m21330a() == null)) {
            immutableList = privacySettingsModel.m21330a().m15321a();
        }
        this.f20588e = immutableList;
    }
}
