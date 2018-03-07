package com.facebook.vault.service;

import android.content.Context;
import android.content.Intent;
import com.facebook.vault.provider.VaultImageProviderRow;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: text_only */
public class VaultSyncJobGenerator {
    private static final Class<?> f1926a = VaultSyncJobGenerator.class;
    private final Context f1927b;
    private final VaultTable f1928c;
    private final VaultHelpers f1929d;
    private final VaultNotificationManager f1930e;

    @Inject
    public VaultSyncJobGenerator(Context context, VaultTable vaultTable, VaultHelpers vaultHelpers, VaultNotificationManager vaultNotificationManager) {
        this.f1927b = context;
        this.f1928c = vaultTable;
        this.f1929d = vaultHelpers;
        this.f1930e = vaultNotificationManager;
    }

    public final int m1986a(Set<String> set, int i) {
        this.f1929d.c();
        List a = this.f1928c.a(set);
        m1983a(a, i, 1);
        return a.size();
    }

    public final int m1985a(int i, int i2) {
        VaultTable$SyncableRows a = this.f1928c.a(i, this.f1929d.c());
        Integer.valueOf(a.f1970a.size());
        Integer.valueOf(a.f1971b.size());
        m1983a(a.f1970a, i2, 1);
        m1983a(a.f1971b, i2, 2);
        return a.f1971b.size() + a.f1970a.size();
    }

    public final int m1984a(int i) {
        return m1982a(i, false);
    }

    public final int m1987b(int i) {
        return m1982a(i, true);
    }

    private int m1982a(int i, boolean z) {
        List a = this.f1928c.a(i, this.f1929d.c(), z);
        Integer.valueOf(a.size());
        m1983a(a, 3, 2);
        return a.size();
    }

    private void m1983a(List<VaultImageProviderRow> list, int i, int i2) {
        if (list.size() > 0) {
            Intent intent = new Intent(this.f1927b, VaultSyncJobProcessor.class);
            ArrayList a = Lists.a();
            this.f1930e.a(list);
            for (VaultImageProviderRow vaultImageProviderRow : list) {
                this.f1928c.a(vaultImageProviderRow);
                a.add(vaultImageProviderRow);
                String str;
                if (i2 == 2) {
                    str = vaultImageProviderRow.f1874a;
                } else {
                    str = vaultImageProviderRow.f1874a;
                }
            }
            intent.putExtra("queuing_type", i2);
            intent.putParcelableArrayListExtra("queuing_objects", a);
            intent.putExtra("sync_reason", i);
            this.f1927b.startService(intent);
        }
    }
}
