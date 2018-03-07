package com.facebook.fbservice.results;

import com.facebook.common.util.TriState;
import com.facebook.fbservice.results.DataFetchDisposition.DataSource;

/* compiled from: result_decoration */
public class DataFetchDispositionBuilder {
    public DataSource f3042a;
    public TriState f3043b = TriState.UNSET;
    public TriState f3044c = TriState.UNSET;
    public TriState f3045d = TriState.UNSET;
    public TriState f3046e = TriState.UNSET;
    public TriState f3047f = TriState.UNSET;
    public TriState f3048g = TriState.UNSET;

    DataFetchDispositionBuilder() {
    }

    public final DataFetchDispositionBuilder m4196a(DataFetchDisposition dataFetchDisposition) {
        this.f3042a = dataFetchDisposition.f3035m;
        this.f3043b = dataFetchDisposition.f3036n;
        this.f3044c = dataFetchDisposition.f3037o;
        this.f3045d = dataFetchDisposition.f3038p;
        this.f3046e = dataFetchDisposition.f3039q;
        this.f3047f = dataFetchDisposition.f3040r;
        this.f3048g = dataFetchDisposition.f3041s;
        return this;
    }

    public final DataFetchDispositionBuilder m4195a(DataSource dataSource) {
        this.f3042a = dataSource;
        return this;
    }

    public final DataFetchDispositionBuilder m4194a(TriState triState) {
        this.f3043b = triState;
        return this;
    }

    public final DataFetchDispositionBuilder m4197b(TriState triState) {
        this.f3044c = triState;
        return this;
    }

    public final DataFetchDispositionBuilder m4198e(TriState triState) {
        this.f3047f = triState;
        return this;
    }

    public final DataFetchDispositionBuilder m4199f(TriState triState) {
        this.f3048g = triState;
        return this;
    }

    public final DataFetchDisposition m4200h() {
        return new DataFetchDisposition(this);
    }
}
