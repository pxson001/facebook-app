package com.facebook.feedplugins.instagram;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: creation_time_ms */
public class InstagramPhotosFromFriendsHeaderView extends CustomLinearLayout {
    public static final ViewType f7912a = new C09991();
    private final TextView f7913b = ((TextView) findViewById(2131562912));

    /* compiled from: creation_time_ms */
    final class C09991 extends ViewType {
        C09991() {
        }

        public final View m9005a(Context context) {
            return new InstagramPhotosFromFriendsHeaderView(context);
        }
    }

    public InstagramPhotosFromFriendsHeaderView(Context context) {
        super(context);
        setContentView(2130904932);
        setOrientation(1);
    }

    public void setTitle(String str) {
        this.f7913b.setText(str);
    }
}
