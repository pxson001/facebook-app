package com.facebook.loom.config.coldstart;

import android.util.SparseArray;
import com.facebook.loom.config.Config.RootControllerConfig;
import com.facebook.loom.config.ControllerConfig;
import com.facebook.loom.config.QPLControllerConfig;
import com.facebook.loom.config.QPLTraceControlConfiguration;
import javax.annotation.Nullable;

/* compiled from: thrift serialize failed */
public final class InitFileRootControllerConfig implements RootControllerConfig {
    private final int f1440a;
    private final int f1441b;
    private final SparseArray<ControllerConfig> f1442c;

    InitFileRootControllerConfig(InitFileConfigProvider$InitFileConfigData[] initFileConfigProvider$InitFileConfigDataArr) {
        int i = 0;
        SparseArray sparseArray = new SparseArray(1);
        int length = initFileConfigProvider$InitFileConfigDataArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            InitFileConfigProvider$InitFileConfigData initFileConfigProvider$InitFileConfigData = initFileConfigProvider$InitFileConfigDataArr[i];
            i3 = Math.max(i3, initFileConfigProvider$InitFileConfigData.f1435b);
            i2 = Math.max(i2, initFileConfigProvider$InitFileConfigData.f1436c);
            switch (initFileConfigProvider$InitFileConfigData.f1434a) {
                case 1:
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(initFileConfigProvider$InitFileConfigData.f1439f, new QPLTraceControlConfiguration(initFileConfigProvider$InitFileConfigData.f1437d, initFileConfigProvider$InitFileConfigData.f1438e));
                    sparseArray.put(initFileConfigProvider$InitFileConfigData.f1434a, new QPLControllerConfig(sparseArray2));
                    break;
                case 8:
                    sparseArray.put(initFileConfigProvider$InitFileConfigData.f1434a, new ColdStartControllerConfig(initFileConfigProvider$InitFileConfigData.f1437d, initFileConfigProvider$InitFileConfigData.f1438e, initFileConfigProvider$InitFileConfigData.f1439f));
                    break;
                default:
                    break;
            }
            i++;
        }
        this.f1442c = sparseArray;
        this.f1440a = i3;
        this.f1441b = i2;
    }

    @Nullable
    public final ControllerConfig m1435a(int i) {
        return (ControllerConfig) this.f1442c.get(i);
    }

    public final int m1436b() {
        return this.f1440a;
    }

    public final int m1437c() {
        return this.f1441b;
    }
}
