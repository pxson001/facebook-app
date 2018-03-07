package com.facebook.vault.ui;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import com.facebook.common.async.AsyncTaskVersionHelper;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.inject.Assisted;
import com.facebook.photos.base.photos.VaultPhoto;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import javax.inject.Inject;

/* compiled from: text/x-ttml */
public class VaultDraweeGridAdapter extends BaseAdapter implements VaultAdapter {
    public static final String f1977b = VaultDraweeGridAdapter.class.getSimpleName();
    public static final CallerContext f1978c = CallerContext.a(VaultDraweeGridAdapter.class, "photo_vault");
    protected String f1979a = "";
    private final Context f1980d;
    private final GridView f1981e;
    public DataLoaderState f1982f;
    public List<VaultPhoto> f1983g = Lists.a();
    private HashMap<Uri, VaultGridItemController> f1984h;
    private HashSet<Uri> f1985i;
    public AbstractSingleMethodRunner f1986j;

    /* compiled from: text/x-ttml */
    public class C01851 implements Comparator<VaultPhoto> {
        final /* synthetic */ VaultDraweeGridAdapter f1973a;

        public C01851(VaultDraweeGridAdapter vaultDraweeGridAdapter) {
            this.f1973a = vaultDraweeGridAdapter;
        }

        public int compare(Object obj, Object obj2) {
            VaultPhoto vaultPhoto = (VaultPhoto) obj2;
            long b = ((VaultPhoto) obj).b();
            long b2 = vaultPhoto.b();
            if (b == b2) {
                return 0;
            }
            return b2 > b ? 1 : -1;
        }
    }

    /* compiled from: text/x-ttml */
    enum DataLoaderState {
        IDLE,
        FETCHING,
        FETCHED_ALL
    }

    /* compiled from: text/x-ttml */
    public class LoadPhotos extends FbAsyncTask<String, Void, Result> {
        final /* synthetic */ VaultDraweeGridAdapter f1974a;

        public LoadPhotos(VaultDraweeGridAdapter vaultDraweeGridAdapter) {
            this.f1974a = vaultDraweeGridAdapter;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected final java.lang.Object m2020a(java.lang.Object[] r13) {
            /*
            r12 = this;
            r13 = (java.lang.String[]) r13;
            r4 = 0;
            r3 = 40;
            r8 = 0;
            r1 = r13[r4];
            r9 = com.google.common.collect.Lists.a(r3);
            r2 = new java.util.ArrayList;
            r2.<init>(r3);
            r10 = new com.facebook.vault.ui.VaultDraweeGridAdapter$Result;
            r10.<init>();
            r2 = r12.f1974a;	 Catch:{ Exception -> 0x0074 }
            r2 = r2.f1986j;	 Catch:{ Exception -> 0x0074 }
            r3 = new com.facebook.vault.protocol.VaultAllImagesGetMethod;	 Catch:{ Exception -> 0x0074 }
            r3.<init>();	 Catch:{ Exception -> 0x0074 }
            r4 = new com.facebook.vault.protocol.VaultAllImagesGetParams;	 Catch:{ Exception -> 0x0074 }
            r5 = 40;
            r4.<init>(r5, r1);	 Catch:{ Exception -> 0x0074 }
            r1 = com.facebook.vault.ui.VaultDraweeGridAdapter.f1978c;	 Catch:{ Exception -> 0x0074 }
            r1 = r2.a(r3, r4, r1);	 Catch:{ Exception -> 0x0074 }
            r0 = r1;
            r0 = (com.facebook.vault.protocol.VaultAllImagesGetResult) r0;	 Catch:{ Exception -> 0x0074 }
            r7 = r0;
            r1 = r7.data;	 Catch:{ Exception -> 0x0074 }
            r1 = r1.isEmpty();	 Catch:{ Exception -> 0x0074 }
            if (r1 != 0) goto L_0x00a2;
        L_0x0038:
            r1 = r7.data;	 Catch:{ Exception -> 0x0074 }
            r11 = r1.iterator();	 Catch:{ Exception -> 0x0074 }
        L_0x003e:
            r1 = r11.hasNext();	 Catch:{ Exception -> 0x0074 }
            if (r1 == 0) goto L_0x0081;
        L_0x0044:
            r1 = r11.next();	 Catch:{ Exception -> 0x0074 }
            r0 = r1;
            r0 = (com.facebook.vault.protocol.VaultImageResultObject) r0;	 Catch:{ Exception -> 0x0074 }
            r4 = r0;
            r1 = r4.dateTaken;	 Catch:{ Exception -> 0x0074 }
            r2 = "T";
            r3 = "";
            r1 = r1.replace(r2, r3);	 Catch:{ Exception -> 0x0074 }
            r2 = new java.text.SimpleDateFormat;	 Catch:{ Exception -> 0x0074 }
            r3 = "yyyy-MM-ddHH:mm:ssZ";
            r5 = java.util.Locale.US;	 Catch:{ Exception -> 0x0074 }
            r2.<init>(r3, r5);	 Catch:{ Exception -> 0x0074 }
            r5 = r2.parse(r1);	 Catch:{ Exception -> 0x0074 }
            r1 = new com.facebook.photos.base.photos.VaultRemotePhoto;	 Catch:{ Exception -> 0x0074 }
            r2 = r4.fbid;	 Catch:{ Exception -> 0x0074 }
            r4 = r4.uri;	 Catch:{ Exception -> 0x0074 }
            r5 = r5.getTime();	 Catch:{ Exception -> 0x0074 }
            r1.<init>(r2, r4, r5);	 Catch:{ Exception -> 0x0074 }
            r9.add(r1);	 Catch:{ Exception -> 0x0074 }
            goto L_0x003e;
        L_0x0074:
            r1 = move-exception;
            r2 = com.facebook.vault.ui.VaultDraweeGridAdapter.f1977b;	 Catch:{ all -> 0x009c }
            r3 = "Exception from graph API call /me/vaultimages";
            com.facebook.debug.log.BLog.b(r2, r3, r1);	 Catch:{ all -> 0x009c }
            r10.f1975a = r9;
            r10.f1976b = r8;
        L_0x0080:
            return r10;
        L_0x0081:
            r1 = r7.paging;	 Catch:{  }
            if (r1 != 0) goto L_0x0097;
        L_0x0085:
            r1 = r8;
        L_0x0086:
            if (r1 == 0) goto L_0x00a2;
        L_0x0088:
            r1 = android.net.Uri.parse(r1);	 Catch:{  }
            r2 = "after";
            r1 = r1.getQueryParameter(r2);	 Catch:{  }
        L_0x0092:
            r10.f1975a = r9;
            r10.f1976b = r1;
            goto L_0x0080;
        L_0x0097:
            r1 = r7.paging;	 Catch:{  }
            r1 = r1.next;	 Catch:{  }
            goto L_0x0086;
        L_0x009c:
            r1 = move-exception;
            r10.f1975a = r9;
            r10.f1976b = r8;
            throw r1;
        L_0x00a2:
            r1 = r8;
            goto L_0x0092;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.vault.ui.VaultDraweeGridAdapter.LoadPhotos.a(java.lang.Object[]):java.lang.Object");
        }

        protected void onPostExecute(Object obj) {
            Result result = (Result) obj;
            if (result.f1975a.isEmpty()) {
                this.f1974a.f1982f = DataLoaderState.FETCHED_ALL;
            } else {
                this.f1974a.mo64a(result.f1975a);
                if (result.f1976b != null) {
                    this.f1974a.f1979a = result.f1976b;
                } else {
                    this.f1974a.f1982f = DataLoaderState.FETCHED_ALL;
                }
            }
            if (this.f1974a.f1982f != DataLoaderState.FETCHED_ALL) {
                this.f1974a.f1982f = DataLoaderState.IDLE;
            }
        }
    }

    /* compiled from: text/x-ttml */
    class Result {
        public List<VaultPhoto> f1975a;
        public String f1976b;
    }

    @Inject
    public VaultDraweeGridAdapter(AbstractSingleMethodRunner abstractSingleMethodRunner, Context context, @Assisted GridView gridView) {
        this.f1986j = abstractSingleMethodRunner;
        this.f1984h = Maps.c();
        this.f1985i = Sets.a();
        this.f1979a = "";
        this.f1982f = DataLoaderState.IDLE;
        this.f1980d = context;
        this.f1981e = gridView;
    }

    private VaultGridItemController m2021c(Uri uri) {
        int i = 0;
        Preconditions.checkState(uri != null, "Photo URI cannot be null");
        if (this.f1984h.containsKey(uri)) {
            int firstVisiblePosition = this.f1981e.getFirstVisiblePosition();
            while (i < this.f1981e.getChildCount()) {
                if (((VaultPhoto) this.f1983g.get(firstVisiblePosition + i)).c().equals(uri)) {
                    VaultGridItemController vaultGridItemController = (VaultGridItemController) this.f1984h.get(uri);
                    vaultGridItemController.m2035a(this.f1981e.getChildAt(i));
                    this.f1981e.getChildAt(i).setTag(uri);
                    return vaultGridItemController;
                }
                i++;
            }
        }
        return null;
    }

    public int getCount() {
        return this.f1983g.size();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public Object getItem(int i) {
        return (VaultPhoto) this.f1983g.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        VaultGridItemController vaultGridItemController;
        if (view == null) {
            view = LayoutInflater.from(this.f1980d).inflate(2130907641, null);
        }
        VaultPhoto vaultPhoto = (VaultPhoto) this.f1983g.get(i);
        Uri c = vaultPhoto.c();
        if (this.f1984h.containsKey(c)) {
            vaultGridItemController = (VaultGridItemController) this.f1984h.get(c);
        } else {
            VaultGridItemController vaultGridItemController2 = new VaultGridItemController(this.f1980d, vaultPhoto);
            this.f1984h.put(c, vaultGridItemController2);
            vaultGridItemController = vaultGridItemController2;
        }
        vaultGridItemController.m2035a(view);
        vaultGridItemController.f1997a.a(c, f1978c);
        vaultGridItemController.f1997a.setAlpha(255);
        vaultGridItemController.f1998b.setVisibility(8);
        vaultGridItemController.f1999c.setVisibility(8);
        vaultGridItemController.f2000d.setVisibility(8);
        vaultGridItemController.m2034a();
        return view;
    }

    public final void mo61a(Uri uri) {
        VaultGridItemController c = m2021c(uri);
        if (c != null) {
            if (c.f2000d.getVisibility() == 0) {
                c.f2000d.setVisibility(8);
            }
            c.f1999c.setVisibility(0);
            c.f1999c.setIndeterminate(true);
            c.f1998b.setVisibility(8);
        }
    }

    public final void mo62a(Uri uri, int i) {
        VaultGridItemController c = m2021c(uri);
        if (c != null) {
            if (c.f2000d.getVisibility() == 0) {
                c.f2000d.setVisibility(8);
            }
            c.f1999c.setVisibility(8);
            c.f1998b.setVisibility(0);
            c.f1998b.setProgress(i);
        }
    }

    public final void mo65b(Uri uri) {
        VaultGridItemController c = m2021c(uri);
        if (c != null) {
            c.m2034a();
        }
    }

    public final synchronized void mo60a(int i, int i2) {
        if (getCount() <= (i + i2) + 40 && this.f1982f == DataLoaderState.IDLE) {
            this.f1982f = DataLoaderState.FETCHING;
            AsyncTaskVersionHelper.a(new LoadPhotos(this), new String[]{this.f1979a});
        }
    }

    public final void mo64a(List<VaultPhoto> list) {
        for (VaultPhoto vaultPhoto : list) {
            if (!this.f1985i.contains(vaultPhoto.c())) {
                this.f1985i.add(vaultPhoto.c());
                this.f1983g.add(vaultPhoto);
            }
        }
        Collections.sort(this.f1983g, new C01851(this));
        AdapterDetour.a(this, -2086998007);
    }

    public final void mo63a(VaultPhoto vaultPhoto) {
        this.f1984h.remove(vaultPhoto.c());
        this.f1985i.remove(vaultPhoto.c());
        this.f1983g.remove(vaultPhoto);
        AdapterDetour.a(this, -700594051);
    }
}
