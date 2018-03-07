package com.facebook.compactdiskmodule;

import android.content.Context;
import android.os.Environment;
import com.facebook.common.init.INeedInit;
import com.facebook.common.util.TriState;
import com.facebook.compactdisk.DiskSizeCalculator;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: max_num_mutation_retries */
public class DiskSizeCalculatorInit implements INeedInit {
    private final Context f8190a;
    private final Provider<TriState> f8191b;
    private final DiskSizeCalculator f8192c;

    public static DiskSizeCalculatorInit m8491b(InjectorLike injectorLike) {
        return new DiskSizeCalculatorInit((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 651), DiskSizeCalculatorMethodAutoProvider.m8465a(injectorLike));
    }

    @Inject
    public DiskSizeCalculatorInit(Context context, Provider<TriState> provider, DiskSizeCalculator diskSizeCalculator) {
        this.f8190a = context;
        this.f8191b = provider;
        this.f8192c = diskSizeCalculator;
    }

    public void init() {
        if (this.f8191b.get() == TriState.YES) {
            this.f8192c.setAnalytics(true);
            this.f8192c.m8451a(this.f8190a.getApplicationContext().getFilesDir().getPath());
            this.f8192c.m8451a(this.f8190a.getApplicationContext().getCacheDir().getPath());
            if (Environment.getExternalStorageState().equals("mounted")) {
                this.f8192c.m8451a(Environment.getExternalStorageDirectory().getPath());
            }
            this.f8192c.m8450a();
        }
    }
}
