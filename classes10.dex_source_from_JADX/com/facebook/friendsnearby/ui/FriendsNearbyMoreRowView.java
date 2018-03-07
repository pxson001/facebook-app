package com.facebook.friendsnearby.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.friendsnearby.model.FriendsNearbySection;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: Wearable.API */
public class FriendsNearbyMoreRowView extends CustomFrameLayout {
    public View f20988a = c(2131562386);
    public View f20989b = c(2131562385);
    public FriendsNearbySection f20990c;
    public FriendsNearbyFragment f20991d;

    /* compiled from: Wearable.API */
    public class C29831 implements OnClickListener {
        final /* synthetic */ FriendsNearbyMoreRowView f20987a;

        public C29831(FriendsNearbyMoreRowView friendsNearbyMoreRowView) {
            this.f20987a = friendsNearbyMoreRowView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2113458102);
            this.f20987a.f20991d.m21876a(this.f20987a.f20990c, this.f20987a);
            Logger.a(2, EntryType.UI_INPUT_END, 630112511, a);
        }
    }

    public FriendsNearbyMoreRowView(Context context) {
        super(context);
        setContentView(2130904534);
        setBackgroundResource(2130839798);
        setOnClickListener(new C29831(this));
    }

    public final void m21976a() {
        this.f20989b.setVisibility(8);
        this.f20988a.setVisibility(0);
    }

    public final void m21977b() {
        this.f20989b.setVisibility(0);
        this.f20988a.setVisibility(8);
    }
}
