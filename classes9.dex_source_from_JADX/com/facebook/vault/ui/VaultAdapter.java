package com.facebook.vault.ui;

import android.net.Uri;
import android.widget.ListAdapter;
import com.facebook.photos.base.photos.VaultPhoto;
import java.util.List;

/* compiled from: text/xml */
public interface VaultAdapter extends ListAdapter {
    void mo60a(int i, int i2);

    void mo61a(Uri uri);

    void mo62a(Uri uri, int i);

    void mo63a(VaultPhoto vaultPhoto);

    void mo64a(List<VaultPhoto> list);

    void mo65b(Uri uri);
}
