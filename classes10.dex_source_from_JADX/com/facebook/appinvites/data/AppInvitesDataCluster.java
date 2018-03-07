package com.facebook.appinvites.data;

import com.facebook.appinvites.protocol.FetchAppInvitesListQueryInterfaces.AppInviteFields;
import com.facebook.appinvites.protocol.FetchAppInvitesListQueryModels.AppInviteFieldsModel;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: edit_messaging_favorites */
public class AppInvitesDataCluster implements Iterable<AppInviteFields> {
    public int f14574a = 0;
    public final ArrayList<AppInviteFields> f14575b = Lists.a();

    /* compiled from: edit_messaging_favorites */
    class C20411 implements Iterator<AppInviteFields> {
        final /* synthetic */ AppInvitesDataCluster f14572a;
        private int f14573b = -1;

        C20411(AppInvitesDataCluster appInvitesDataCluster) {
            this.f14572a = appInvitesDataCluster;
        }

        public boolean hasNext() {
            return this.f14573b + 1 < this.f14572a.f14575b.size();
        }

        public Object next() {
            this.f14573b++;
            return (AppInviteFieldsModel) this.f14572a.f14575b.get(this.f14573b);
        }

        public void remove() {
            AppInvitesDataCluster appInvitesDataCluster = this.f14572a;
            appInvitesDataCluster.f14575b.remove((AppInviteFieldsModel) this.f14572a.f14575b.get(this.f14573b));
            if (appInvitesDataCluster.f14574a >= appInvitesDataCluster.f14575b.size()) {
                appInvitesDataCluster.f14574a = appInvitesDataCluster.f14575b.size() - 1;
            }
            this.f14573b--;
        }
    }

    public final int m14745a() {
        return this.f14574a;
    }

    public final AppInviteFieldsModel m14747b(int i) {
        return (AppInviteFieldsModel) this.f14575b.get(i);
    }

    public final int m14746b() {
        return this.f14575b.size();
    }

    public Iterator<AppInviteFields> iterator() {
        return new C20411(this);
    }
}
