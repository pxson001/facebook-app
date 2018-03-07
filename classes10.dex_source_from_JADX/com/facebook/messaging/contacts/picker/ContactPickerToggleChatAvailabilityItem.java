package com.facebook.messaging.contacts.picker;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.photos.tiles.UserTileViewParamsFactory;
import com.facebook.messaging.presence.PresenceIndicatorView;
import com.facebook.messaging.presence.PresenceType;
import com.facebook.user.tiles.UserTileView;
import com.facebook.widget.BetterSwitch;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.SimpleVariableTextLayoutView;
import javax.inject.Inject;

/* compiled from: tap_friendlist_item */
public class ContactPickerToggleChatAvailabilityItem extends CustomRelativeLayout {
    @Inject
    public UserTileViewParamsFactory f2007a;
    public SimpleVariableTextLayoutView f2008b;
    public UserTileView f2009c;
    public PresenceIndicatorView f2010d;
    public ContactPickerToggleChatAvailabilityRow f2011e;
    public BetterSwitch f2012f;

    /* compiled from: tap_friendlist_item */
    class C03371 implements OnCheckedChangeListener {
        final /* synthetic */ ContactPickerToggleChatAvailabilityItem f2006a;

        C03371(ContactPickerToggleChatAvailabilityItem contactPickerToggleChatAvailabilityItem) {
            this.f2006a = contactPickerToggleChatAvailabilityItem;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        }
    }

    public static void m1836a(Object obj, Context context) {
        ((ContactPickerToggleChatAvailabilityItem) obj).f2007a = UserTileViewParamsFactory.a(FbInjector.get(context));
    }

    public ContactPickerToggleChatAvailabilityItem(Context context) {
        this(context, null);
    }

    private ContactPickerToggleChatAvailabilityItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130772985);
    }

    private ContactPickerToggleChatAvailabilityItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = ContactPickerToggleChatAvailabilityItem.class;
        m1836a(this, getContext());
        setContentView(2130905677);
        this.f2008b = (SimpleVariableTextLayoutView) a(2131564424);
        this.f2009c = (UserTileView) a(2131564423);
        this.f2010d = (PresenceIndicatorView) a(2131564756);
        this.f2012f = (BetterSwitch) a(2131564809);
        this.f2012f.setOnCheckedChangeListener(new C03371(this));
        this.f2010d.setTextColor(getResources().getColor(2131362396));
        this.f2010d.setStatus(PresenceType.AVAILABLE_ON_MOBILE);
    }
}
