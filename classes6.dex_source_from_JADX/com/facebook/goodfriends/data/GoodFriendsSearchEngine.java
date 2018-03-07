package com.facebook.goodfriends.data;

import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: mSmallPictureSize */
public class GoodFriendsSearchEngine {
    private AllCapsTransformationMethod f10926a;

    public static GoodFriendsSearchEngine m17458b(InjectorLike injectorLike) {
        return new GoodFriendsSearchEngine(AllCapsTransformationMethod.b(injectorLike));
    }

    @Inject
    public GoodFriendsSearchEngine(AllCapsTransformationMethod allCapsTransformationMethod) {
        this.f10926a = allCapsTransformationMethod;
    }

    public final ImmutableList<FriendData> m17459a(ImmutableList<FriendData> immutableList, String str) {
        Builder builder = new Builder();
        if (Strings.isNullOrEmpty(str)) {
            return immutableList;
        }
        CharSequence a = m17457a(str);
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            FriendData friendData = (FriendData) immutableList.get(i);
            if (m17457a(friendData.f10889b).contains(a) || m17457a(friendData.f10892e).contains(a)) {
                builder.c(friendData);
            }
        }
        return builder.b();
    }

    private String m17457a(String str) {
        return this.f10926a.getTransformation(str, null).toString();
    }
}
