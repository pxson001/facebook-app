package com.facebook.orca.contacts.divebar;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.contacts.picker.DivebarNearbyFriendsParams;
import com.facebook.contacts.picker.DivebarNearbyFriendsParams.Mode;
import com.facebook.messaging.ui.name.ThreadNameView;
import com.facebook.messaging.ui.name.ThreadNameViewData;
import com.facebook.user.model.User;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;

/* compiled from: onResume */
public class DivebarNearbyFriendsRowView extends CustomRelativeLayout {
    public ThreadNameView f5864a = ((ThreadNameView) a(2131564842));
    private DivebarNearbyFriendsParams f5865b;

    /* compiled from: onResume */
    class C08621 implements Function<User, String> {
        final /* synthetic */ DivebarNearbyFriendsRowView f5862a;

        C08621(DivebarNearbyFriendsRowView divebarNearbyFriendsRowView) {
            this.f5862a = divebarNearbyFriendsRowView;
        }

        public Object apply(Object obj) {
            return ((User) obj).h();
        }
    }

    /* compiled from: onResume */
    /* synthetic */ class C08632 {
        static final /* synthetic */ int[] f5863a = new int[Mode.values().length];

        static {
            try {
                f5863a[Mode.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5863a[Mode.NUX.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5863a[Mode.UPSELL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5863a[Mode.LOCATION_DISABLED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5863a[Mode.CHAT_CONTEXT_DISABLED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f5863a[Mode.LIST.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public DivebarNearbyFriendsRowView(Context context) {
        super(context, null, 2130772985);
        setContentView(2130905685);
        ((ImageView) a(2131564839)).setImageResource(2130842127);
        ((TextView) a(2131564841)).setText(2131231010);
    }

    public final DivebarNearbyFriendsRowView m5535a(DivebarNearbyFriendsParams divebarNearbyFriendsParams) {
        this.f5865b = divebarNearbyFriendsParams;
        m5534b();
        return this;
    }

    private void m5534b() {
        this.f5864a.setData(getSubtitleData());
    }

    private ThreadNameViewData getSubtitleData() {
        Resources resources = getResources();
        switch (C08632.f5863a[this.f5865b.a.ordinal()]) {
            case 1:
                return new ThreadNameViewData(true, "", null);
            case 2:
            case 3:
            case 4:
            case 5:
                return new ThreadNameViewData(true, resources.getString(2131231011), null);
            case 6:
                Preconditions.checkNotNull(this.f5865b.b);
                if (this.f5865b.b.isEmpty()) {
                    return new ThreadNameViewData(true, resources.getString(2131231011), null);
                }
                return new ThreadNameViewData(false, null, ImmutableList.copyOf(Collections2.a(this.f5865b.b, new C08621(this))));
            default:
                throw new IllegalStateException();
        }
    }
}
