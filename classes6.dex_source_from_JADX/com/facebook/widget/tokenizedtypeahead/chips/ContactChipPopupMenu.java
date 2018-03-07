package com.facebook.widget.tokenizedtypeahead.chips;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListPopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.facebook.orca.contacts.picker.UserTokenFactory.1;
import com.facebook.user.tiles.UserTileDrawableController;
import com.google.common.collect.ImmutableList;

/* compiled from: com.facebook.push.mqtt.ipc.MqttChannelStateListener */
public class ContactChipPopupMenu {
    private final Context f20061a;
    public final ContactChipToken f20062b;
    public final boolean f20063c;
    private final UserTileDrawableController f20064d;
    private final ContactChipUserStringUtil f20065e;
    public 1 f20066f;
    private ContactChipListPopupWindow f20067g;
    public Integer f20068h;

    /* compiled from: com.facebook.push.mqtt.ipc.MqttChannelStateListener */
    public class ContactChipListPopupWindow extends ListPopupWindow {
        final /* synthetic */ ContactChipPopupMenu f20058a;
        public Context f20059b;
        public ImmutableList<ContactChipMenuItem> f20060c;

        /* compiled from: com.facebook.push.mqtt.ipc.MqttChannelStateListener */
        class C15071 implements OnDismissListener {
            final /* synthetic */ ContactChipListPopupWindow f20055a;

            C15071(ContactChipListPopupWindow contactChipListPopupWindow) {
                this.f20055a = contactChipListPopupWindow;
            }

            public void onDismiss() {
                if (this.f20055a.f20058a.f20066f != null) {
                    1 1 = this.f20055a.f20058a.f20066f;
                    this.f20055a.f20058a.f20062b.f15077c = false;
                    1.a.m28738c();
                }
            }
        }

        /* compiled from: com.facebook.push.mqtt.ipc.MqttChannelStateListener */
        class C15082 implements OnItemClickListener {
            final /* synthetic */ ContactChipListPopupWindow f20056a;

            C15082(ContactChipListPopupWindow contactChipListPopupWindow) {
                this.f20056a = contactChipListPopupWindow;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.f20056a.f20058a.f20066f != null) {
                    if (((ContactChipPopupMenuItemView) view).f20077g) {
                        1 1 = this.f20056a.f20058a.f20066f;
                        1.a.m28733a(this.f20056a.f20058a.f20062b, false);
                    } else {
                        this.f20056a.f20060c.get(i);
                    }
                }
                this.f20056a.dismiss();
            }
        }

        /* compiled from: com.facebook.push.mqtt.ipc.MqttChannelStateListener */
        public class ContactChipPopupMenuAdapter extends BaseAdapter implements ListAdapter {
            final /* synthetic */ ContactChipListPopupWindow f20057a;

            public ContactChipPopupMenuAdapter(ContactChipListPopupWindow contactChipListPopupWindow) {
                this.f20057a = contactChipListPopupWindow;
            }

            public int getCount() {
                return this.f20057a.f20060c.size();
            }

            public Object getItem(int i) {
                return this.f20057a.f20060c.get(i);
            }

            public long getItemId(int i) {
                return (long) i;
            }

            public View getView(int i, View view, ViewGroup viewGroup) {
                boolean z;
                ContactChipMenuItem contactChipMenuItem = (ContactChipMenuItem) getItem(i);
                if (view == null || !(view instanceof ContactChipPopupMenuItemView)) {
                    ContactChipPopupMenuItemView contactChipPopupMenuItemView = (ContactChipPopupMenuItemView) LayoutInflater.from(this.f20057a.f20059b).inflate(2130903759, viewGroup, false);
                    if (this.f20057a.f20058a.f20068h != null) {
                        contactChipPopupMenuItemView.setBackgroundResource(this.f20057a.f20058a.f20068h.intValue());
                        view = contactChipPopupMenuItemView;
                    } else {
                        view = contactChipPopupMenuItemView;
                    }
                } else {
                    ContactChipPopupMenuItemView contactChipPopupMenuItemView2 = (ContactChipPopupMenuItemView) view;
                }
                if (i == 0) {
                    z = true;
                } else {
                    z = false;
                }
                view.m28746a(contactChipMenuItem, z, this.f20057a.f20058a.f20063c);
                return view;
            }
        }

        public ContactChipListPopupWindow(ContactChipPopupMenu contactChipPopupMenu, Context context, ImmutableList<ContactChipMenuItem> immutableList) {
            this.f20058a = contactChipPopupMenu;
            super(context);
            this.f20059b = context;
            this.f20060c = immutableList;
        }

        public final void m28743a() {
            setModal(true);
            setInputMethodMode(2);
            ContactChipPopupMenuAdapter contactChipPopupMenuAdapter = new ContactChipPopupMenuAdapter(this);
            setAdapter(contactChipPopupMenuAdapter);
            int i = 0;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int count = contactChipPopupMenuAdapter.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                View view = contactChipPopupMenuAdapter.getView(i2, null, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                if (view.getMeasuredWidth() > i) {
                    i = view.getMeasuredWidth();
                }
            }
            setContentWidth(m28742a(i, this.f20059b.getResources().getDimensionPixelSize(2131427807), this.f20059b.getResources().getDisplayMetrics().widthPixels - (this.f20059b.getResources().getDimensionPixelSize(2131427808) * 2)));
            setOnDismissListener(new C15071(this));
            setOnItemClickListener(new C15082(this));
        }

        public static int m28742a(int i, int i2, int i3) {
            if (i > i3) {
                return i3;
            }
            if (i < i2) {
                return i2;
            }
            return i;
        }
    }

    public ContactChipPopupMenu(Context context, ContactChipToken contactChipToken, boolean z, UserTileDrawableController userTileDrawableController, ContactChipUserStringUtil contactChipUserStringUtil) {
        this.f20061a = context;
        this.f20062b = contactChipToken;
        this.f20063c = z;
        this.f20064d = userTileDrawableController;
        this.f20065e = contactChipUserStringUtil;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m28744a(android.view.View r10, int r11, int r12) {
        /*
        r9 = this;
        r0 = r9.f20067g;
        if (r0 != 0) goto L_0x0050;
    L_0x0004:
        r0 = r9.f20062b;
        r0 = r0.mo1523c();
        r1 = new com.google.common.collect.ImmutableList$Builder;
        r1.<init>();
        r2 = new com.facebook.widget.tokenizedtypeahead.chips.ContactChipMenuItem;
        r3 = r0.j();
        r4 = r9.f20065e;
        r6 = com.facebook.widget.tokenizedtypeahead.chips.ContactChipUserStringUtil.C15101.f20112a;
        r8 = r0.b;
        r7 = r8;
        r7 = r7.ordinal();
        r6 = r6[r7];
        switch(r6) {
            case 1: goto L_0x0056;
            case 2: goto L_0x0056;
            case 3: goto L_0x006c;
            case 4: goto L_0x006c;
            case 5: goto L_0x0089;
            default: goto L_0x0025;
        };
    L_0x0025:
        r6 = 0;
    L_0x0026:
        r4 = r6;
        r5 = r9.f20064d;
        r2.<init>(r0, r3, r4, r5);
        r1.c(r2);
        r0 = new com.facebook.widget.tokenizedtypeahead.chips.ContactChipPopupMenu$ContactChipListPopupWindow;
        r2 = r9.f20061a;
        r1 = r1.b();
        r0.<init>(r9, r2, r1);
        r9.f20067g = r0;
        r0 = r9.f20067g;
        r0.m28743a();
        r0 = r9.f20067g;
        r0.setAnchorView(r10);
        r0 = r9.f20067g;
        r0.setHorizontalOffset(r11);
        r0 = r9.f20067g;
        r0.setVerticalOffset(r12);
    L_0x0050:
        r0 = r9.f20067g;
        r0.show();
        return;
    L_0x0056:
        r8 = r0.t;
        r6 = r8;
        if (r6 == 0) goto L_0x0062;
    L_0x005b:
        r6 = r4.f20114b;
        r6 = com.facebook.messaging.appspecific.AppNameResolver.m387a(r6);
        goto L_0x0026;
    L_0x0062:
        r6 = r4.f20114b;
        r7 = 2131230931; // 0x7f0800d3 float:1.8077929E38 double:1.0529679864E-314;
        r6 = r6.getString(r7);
        goto L_0x0026;
    L_0x006c:
        r8 = r0.l;
        r8 = com.facebook.common.util.StringUtil.a(r8);
        if (r8 != 0) goto L_0x0091;
    L_0x0074:
        r8 = 1;
    L_0x0075:
        r6 = r8;
        if (r6 == 0) goto L_0x0025;
    L_0x0078:
        r6 = r0.w();
        com.google.common.base.Preconditions.checkNotNull(r6);
        r7 = r4.f20113a;
        r8 = r6.b;
        r6 = r8;
        r6 = r7.b(r6);
        goto L_0x0026;
    L_0x0089:
        r6 = r0.u();
        goto L_0x0026;
    L_0x0091:
        r8 = 0;
        goto L_0x0075;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.widget.tokenizedtypeahead.chips.ContactChipPopupMenu.a(android.view.View, int, int):void");
    }
}
