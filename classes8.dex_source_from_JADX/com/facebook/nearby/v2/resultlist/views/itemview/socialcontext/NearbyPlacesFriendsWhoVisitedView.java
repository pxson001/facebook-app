package com.facebook.nearby.v2.resultlist.views.itemview.socialcontext;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import com.facebook.common.util.StringUtil;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPlacesFriendsWhoVisitedFragmentModel.FriendsWhoVisitedModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPlacesFriendsWhoVisitedFragmentModel.FriendsWhoVisitedModel.EdgesModel;
import com.facebook.resources.ui.FbTextView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: customized_res */
public class NearbyPlacesFriendsWhoVisitedView extends FbTextView {
    public NearbyPlacesFriendsWhoVisitedView(Context context) {
        this(context, null);
    }

    public NearbyPlacesFriendsWhoVisitedView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NearbyPlacesFriendsWhoVisitedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void m18821a(FriendsWhoVisitedModel friendsWhoVisitedModel, String str) {
        boolean z;
        boolean z2 = true;
        if (friendsWhoVisitedModel == null || friendsWhoVisitedModel.m17964a() <= 0) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (StringUtil.a(str)) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        setText(m18820b(friendsWhoVisitedModel, str));
    }

    private static String m18819a(EdgesModel edgesModel) {
        if (edgesModel == null || edgesModel.m17945a() == null) {
            return "";
        }
        return edgesModel.m17945a().m17939c();
    }

    private SpannableString m18820b(FriendsWhoVisitedModel friendsWhoVisitedModel, String str) {
        if (friendsWhoVisitedModel == null) {
            return null;
        }
        ImmutableList b = friendsWhoVisitedModel.m17968b();
        if (b == null || b.isEmpty()) {
            return null;
        }
        Resources resources = getContext().getResources();
        int a = friendsWhoVisitedModel.m17964a();
        String a2;
        if (a == 1) {
            a2 = m18819a((EdgesModel) b.get(0));
            return m18818a(resources.getString(2131236697, new Object[]{a2, str}), a2);
        } else if (a == 2) {
            String a3 = m18819a((EdgesModel) b.get(0));
            a2 = m18819a((EdgesModel) b.get(1));
            return m18818a(resources.getString(2131236698, new Object[]{a3, a2, str}), a3, a2);
        } else if (a < 3) {
            return null;
        } else {
            String a4 = m18819a((EdgesModel) b.get(0));
            a2 = m18819a((EdgesModel) b.get(1));
            String quantityString = resources.getQuantityString(2131689658, a - 2, new Object[]{Integer.valueOf(a - 2)});
            return m18818a(resources.getString(2131236709, new Object[]{a4, a2, quantityString, str}), a4, a2, quantityString);
        }
    }

    private static SpannableString m18818a(String str, String... strArr) {
        boolean z;
        int i = 0;
        if (str == null || strArr == null) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        SpannableString spannableString = new SpannableString(str);
        while (i < strArr.length) {
            String str2 = strArr[i];
            int indexOf = str.indexOf(str2);
            if (indexOf >= 0) {
                spannableString.setSpan(new StyleSpan(1), indexOf, str2.length() + indexOf, 33);
            }
            i++;
        }
        return spannableString;
    }
}
