package com.facebook.backgroundlocation.upsell;

import android.net.Uri;
import android.support.v4.content.ContextCompat;
import com.facebook.backgroundlocation.upsell.graphql.BackgroundLocationUpsellGraphQLInterfaces.BackgroundLocationUpsellProfile;
import com.facebook.backgroundlocation.upsell.graphql.BackgroundLocationUpsellGraphQLModels.BackgroundLocationUpsellProfileModel;
import com.facebook.fbui.facepile.Face;
import com.facebook.fbui.facepile.FacepileView;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: deviceIdHash */
public class BackgroundLocationUpsellFacepileUtil {
    public static void m15556a(FacepileView facepileView, ImmutableList<? extends BackgroundLocationUpsellProfile> immutableList) {
        if (immutableList.size() > 11) {
            immutableList = immutableList.subList(0, 11);
        }
        List arrayList = new ArrayList(immutableList.size());
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new Face(Uri.parse(((BackgroundLocationUpsellProfileModel) immutableList.get(i)).m15589c().m15579a())));
        }
        facepileView.setFaces(arrayList);
    }

    public static void m15557b(FacepileView facepileView, ImmutableList<? extends BackgroundLocationUpsellProfile> immutableList) {
        if (immutableList.size() > 5) {
            immutableList = immutableList.subList(0, 5);
        }
        Collection arrayList = new ArrayList(immutableList.size());
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            BackgroundLocationUpsellProfileModel backgroundLocationUpsellProfileModel = (BackgroundLocationUpsellProfileModel) immutableList.get(i);
            if (backgroundLocationUpsellProfileModel != null) {
                arrayList.add(new Face(Uri.parse(backgroundLocationUpsellProfileModel.m15589c().m15579a()), ContextCompat.a(facepileView.getContext(), 2130841549)));
            }
        }
        facepileView.setFaces(ImmutableList.copyOf(arrayList));
    }

    private BackgroundLocationUpsellFacepileUtil() {
    }
}
