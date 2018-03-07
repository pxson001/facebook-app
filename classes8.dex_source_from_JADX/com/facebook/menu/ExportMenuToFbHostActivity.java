package com.facebook.menu;

import java.util.List;
import javax.annotation.Nullable;

/* compiled from: trending_awareness_unit_type */
public interface ExportMenuToFbHostActivity {

    /* compiled from: trending_awareness_unit_type */
    public class CustomFbHostMenuItem {
        public int f1421a;
        public int f1422b;
        public int f1423c;
        public boolean f1424d;
        @Nullable
        public String f1425e;

        public CustomFbHostMenuItem(int i, int i2, int i3, boolean z, @Nullable String str) {
            this.f1421a = i;
            this.f1422b = i2;
            this.f1423c = i3;
            this.f1424d = z;
            this.f1425e = str;
        }
    }

    void B_(int i);

    List<CustomFbHostMenuItem> m1578d();
}
