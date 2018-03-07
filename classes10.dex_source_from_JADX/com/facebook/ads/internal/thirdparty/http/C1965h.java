package com.facebook.ads.internal.thirdparty.http;

import android.os.AsyncTask;

public class C1965h extends AsyncTask<C1966l, Void, C1971n> implements C1962c {
    private C1961a f14281a;
    private C1950b f14282b;
    private Exception f14283c;

    public C1965h(C1961a c1961a, C1950b c1950b) {
        this.f14281a = c1961a;
        this.f14282b = c1950b;
    }

    public final void mo741a(C1966l c1966l) {
        super.execute(new C1966l[]{c1966l});
    }

    protected Object doInBackground(Object[] objArr) {
        C1966l[] c1966lArr = (C1966l[]) objArr;
        if (c1966lArr != null) {
            try {
                if (c1966lArr.length > 0) {
                    return this.f14281a.m14414a(c1966lArr[0]);
                }
            } catch (Exception e) {
                this.f14283c = e;
                cancel(true);
                return null;
            }
        }
        throw new IllegalArgumentException("DoHttpRequestTask takes exactly one argument of type HttpRequest");
    }

    protected void onCancelled() {
        this.f14282b.mo740a(this.f14283c);
    }

    protected void onPostExecute(Object obj) {
        this.f14282b.mo739a((C1971n) obj);
    }
}
