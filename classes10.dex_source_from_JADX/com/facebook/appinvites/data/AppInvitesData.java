package com.facebook.appinvites.data;

import com.facebook.appinvites.protocol.FetchAppInvitesListQueryInterfaces.AppInviteFields;
import com.facebook.appinvites.protocol.FetchAppInvitesListQueryModels.AppInviteFieldsModel;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: edit_progress_dialog */
public class AppInvitesData {
    public ArrayList<AppInvitesDataCluster> f14571a = Lists.a();

    /* compiled from: edit_progress_dialog */
    public class C20371 implements Predicate<AppInviteFields> {
        final /* synthetic */ String f14564a;
        final /* synthetic */ AppInvitesData f14565b;

        public C20371(AppInvitesData appInvitesData, String str) {
            this.f14565b = appInvitesData;
            this.f14564a = str;
        }

        public boolean apply(Object obj) {
            return ((AppInviteFieldsModel) obj).nf_().m15002b().equals(this.f14564a);
        }
    }

    /* compiled from: edit_progress_dialog */
    public class C20393 implements Predicate<AppInvitesDataCluster> {
        final /* synthetic */ AppInvitesData f14568a;

        public C20393(AppInvitesData appInvitesData) {
            this.f14568a = appInvitesData;
        }

        public boolean apply(Object obj) {
            return ((AppInvitesDataCluster) obj).m14746b() == 0;
        }
    }

    public final int m14740a() {
        return this.f14571a.size();
    }

    public final void m14743b() {
        this.f14571a.clear();
    }

    public final void m14741a(AppInviteFieldsModel appInviteFieldsModel) {
        Iterable iterable = this.f14571a;
        final String d = appInviteFieldsModel.m15017c().m14991d();
        AppInvitesDataCluster appInvitesDataCluster = (AppInvitesDataCluster) Iterables.a(iterable, new Predicate<AppInvitesDataCluster>(this) {
            final /* synthetic */ AppInvitesData f14567b;

            public boolean apply(Object obj) {
                return ((AppInvitesDataCluster) obj).m14747b(0).m15017c().m14991d().equals(d);
            }
        }, null);
        if (appInvitesDataCluster == null) {
            appInvitesDataCluster = new AppInvitesDataCluster();
            this.f14571a.add(appInvitesDataCluster);
        }
        appInvitesDataCluster.f14575b.add(appInviteFieldsModel);
    }

    public final void m14742a(String str) {
        int size = this.f14571a.size();
        for (int i = 0; i < size; i++) {
            AppInvitesDataCluster appInvitesDataCluster = (AppInvitesDataCluster) this.f14571a.get(i);
            if (appInvitesDataCluster.m14747b(0).m15017c().m14991d().equals(str)) {
                appInvitesDataCluster.f14575b.clear();
            }
        }
    }

    public final int m14744c(final String str) {
        try {
            return this.f14571a.indexOf((AppInvitesDataCluster) Iterables.f(this.f14571a, new Predicate<AppInvitesDataCluster>(this) {
                final /* synthetic */ AppInvitesData f14570b;

                public boolean apply(Object obj) {
                    Iterator it = ((AppInvitesDataCluster) obj).iterator();
                    while (it.hasNext()) {
                        if (((AppInviteFieldsModel) it.next()).ne_().equals(str)) {
                            return true;
                        }
                    }
                    return false;
                }
            }));
        } catch (NoSuchElementException e) {
            return 0;
        }
    }

    public static boolean m14739b(AppInviteFieldsModel appInviteFieldsModel) {
        return (appInviteFieldsModel.nf_() == null || appInviteFieldsModel.m15017c() == null || appInviteFieldsModel.m15017c().m14989b() == null || appInviteFieldsModel.m15017c().m14989b().m14972a() == null) ? false : true;
    }
}
