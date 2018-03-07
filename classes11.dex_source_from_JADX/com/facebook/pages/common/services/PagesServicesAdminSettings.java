package com.facebook.pages.common.services;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.graphql.enums.GraphQLPagePresenceTabType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.eventbus.PageEvents.PagesSurfaceDeleteTabEvent;
import com.facebook.pages.common.services.PagesServicesFragment.C02975;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.SwitchCompat;
import javax.annotation.Nullable;

/* compiled from: rollout_token */
public class PagesServicesAdminSettings extends CustomViewGroup {
    public Context f2350a;
    public FbTextView f2351b = ((FbTextView) getView(2131565741));
    private SwitchCompat f2352c = ((SwitchCompat) getView(2131565742));
    private FbTextView f2353d = ((FbTextView) getView(2131565743));

    public PagesServicesAdminSettings(Context context) {
        super(context);
        this.f2350a = context;
        setContentView(2130906124);
    }

    public final void m3306a(boolean z, boolean z2, final OnCheckedChangeListener onCheckedChangeListener, @Nullable final C02975 c02975) {
        if (z2) {
            this.f2352c.setVisibility(0);
            this.f2353d.setVisibility(0);
            this.f2352c.setChecked(z);
            setVisibilitySwitchText(this, z);
            this.f2352c.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
                final /* synthetic */ PagesServicesAdminSettings f2346b;

                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    PagesServicesAdminSettings.setVisibilitySwitchText(this.f2346b, z);
                    onCheckedChangeListener.onCheckedChanged(compoundButton, z);
                }
            });
        } else {
            this.f2352c.setVisibility(8);
            this.f2353d.setVisibility(8);
        }
        if (c02975 != null) {
            this.f2351b.setVisibility(0);
            this.f2351b.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ PagesServicesAdminSettings f2349b;

                /* compiled from: rollout_token */
                class C02911 implements OnMenuItemClickListener {
                    final /* synthetic */ C02922 f2347a;

                    C02911(C02922 c02922) {
                        this.f2347a = c02922;
                    }

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        c02975.f2360a.ao.a(new PagesSurfaceDeleteTabEvent(GraphQLPagePresenceTabType.SERVICES));
                        return true;
                    }
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -207305394);
                    PopoverMenuWindow popoverMenuWindow = new PopoverMenuWindow(this.f2349b.f2350a);
                    PopoverMenu c = popoverMenuWindow.c();
                    if (c == null) {
                        Logger.a(2, EntryType.UI_INPUT_END, 1658164010, a);
                        return;
                    }
                    c.a(2131235471).setOnMenuItemClickListener(new C02911(this));
                    popoverMenuWindow.a(c);
                    popoverMenuWindow.c(true);
                    popoverMenuWindow.c(this.f2349b.f2351b);
                    popoverMenuWindow.d();
                    LogUtils.a(-920288236, a);
                }
            });
            return;
        }
        this.f2351b.setVisibility(8);
    }

    public static void setVisibilitySwitchText(PagesServicesAdminSettings pagesServicesAdminSettings, boolean z) {
        pagesServicesAdminSettings.f2353d.setText(z ? 2131235469 : 2131235470);
    }
}
