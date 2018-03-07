package com.facebook.feedplugins.instagram;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: curr_selected_donation_amount_index */
public class InstagramPhotosFromFriendsFooterView extends CustomLinearLayout {
    public static final ViewType f7891a = new C09961();
    private final TextView f7892b = ((TextView) findViewById(2131562912));

    /* compiled from: curr_selected_donation_amount_index */
    final class C09961 extends ViewType {
        C09961() {
        }

        public final View m8989a(Context context) {
            return new InstagramPhotosFromFriendsFooterView(context);
        }
    }

    public InstagramPhotosFromFriendsFooterView(Context context) {
        super(context);
        setContentView(2130904931);
        setOrientation(1);
    }

    public void setTitle(String str) {
        this.f7892b.setText(str);
    }
}
