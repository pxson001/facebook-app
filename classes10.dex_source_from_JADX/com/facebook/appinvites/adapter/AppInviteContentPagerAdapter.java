package com.facebook.appinvites.adapter;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.appinvites.data.AppInvitesDataCluster;
import com.facebook.appinvites.ui.AppInviteContentView;
import com.facebook.appinvites.ui.AppInvitesViewController;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.recyclablepager.PagerViewType;
import com.facebook.ui.recyclablepager.RecyclablePagerAdapter;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import javax.inject.Inject;

/* compiled from: element_dwell_time */
public class AppInviteContentPagerAdapter extends RecyclablePagerAdapter {
    public final AppInvitesDataCluster f14543a;
    public final AppInvitesViewController f14544b;

    /* compiled from: element_dwell_time */
    class C20281 implements PagerViewType {
        final /* synthetic */ AppInviteContentPagerAdapter f14540a;

        C20281(AppInviteContentPagerAdapter appInviteContentPagerAdapter) {
            this.f14540a = appInviteContentPagerAdapter;
        }

        public final Class m14717a() {
            return AppInviteContentView.class;
        }

        public final View m14716a(Context context) {
            return new AppInviteContentView(context);
        }
    }

    @Inject
    public AppInviteContentPagerAdapter(RecyclableViewPoolManager recyclableViewPoolManager, AppInvitesViewController appInvitesViewController, @Assisted AppInvitesDataCluster appInvitesDataCluster) {
        super(recyclableViewPoolManager);
        this.f14543a = appInvitesDataCluster;
        this.f14544b = appInvitesViewController;
    }

    protected final PagerViewType m14718a(int i) {
        return new C20281(this);
    }

    protected final void m14719a(View view, Object obj, final int i) {
        AppInviteContentView appInviteContentView = (AppInviteContentView) view;
        this.f14544b.m15107a(appInviteContentView, this.f14543a, i);
        appInviteContentView.setMessageOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AppInviteContentPagerAdapter f14542b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -546521397);
                this.f14542b.f14544b.m15105a(view.getContext(), this.f14542b.f14543a, i);
                Logger.a(2, EntryType.UI_INPUT_END, 149977948, a);
            }
        });
    }

    protected final Object m14721b(int i) {
        return this.f14543a.m14747b(i);
    }

    public final int m14720b() {
        return this.f14543a.m14746b();
    }
}
