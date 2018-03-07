package com.facebook.ads.internal.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

public class C1988m {

    final class C19871 implements C1887l {
        final /* synthetic */ int[] f14345a;
        final /* synthetic */ C1887l f14346b;

        C19871(int[] iArr, C1887l c1887l) {
            this.f14345a = iArr;
            this.f14346b = c1887l;
        }

        public final void mo703a() {
            int[] iArr = this.f14345a;
            iArr[0] = iArr[0] - 1;
            if (this.f14345a[0] == 0 && this.f14346b != null) {
                this.f14346b.mo703a();
            }
        }
    }

    static Bitmap m14475a(Context context, String str) {
        return BitmapFactory.decodeFile(new File(context.getCacheDir(), String.format("%d.png", new Object[]{Integer.valueOf(str.hashCode())})).getAbsolutePath());
    }

    static void m14476a(Context context, String str, Bitmap bitmap) {
        try {
            OutputStream fileOutputStream = new FileOutputStream(new File(context.getCacheDir(), String.format("%d.png", new Object[]{Integer.valueOf(str.hashCode())})));
            bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
        }
    }

    public static void m14477a(Context context, List<String> list, C1887l c1887l) {
        int[] iArr = new int[]{list.size()};
        if (iArr[0] != 0) {
            for (String str : list) {
                C1986k c1986k = new C1986k(context);
                c1986k.f14344e = new C19871(iArr, c1887l);
                c1986k.execute(new String[]{str});
            }
        } else if (c1887l != null) {
            c1887l.mo703a();
        }
    }
}
