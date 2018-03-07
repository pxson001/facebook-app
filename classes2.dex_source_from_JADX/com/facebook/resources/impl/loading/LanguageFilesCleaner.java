package com.facebook.resources.impl.loading;

import android.content.Context;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Predicate;
import java.io.File;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: thread_handler_factory */
public class LanguageFilesCleaner {
    private final MoreFileUtils f3042a;
    public final LanguageFileResolver f3043b;
    public final AppVersionInfo f3044c;
    public final Context f3045d;

    public static LanguageFilesCleaner m5040b(InjectorLike injectorLike) {
        return new LanguageFilesCleaner(AppVersionInfoMethodAutoProvider.m2629a(injectorLike), MoreFileUtils.m5023a(injectorLike), LanguageFileResolver.m5018a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public LanguageFilesCleaner(AppVersionInfo appVersionInfo, MoreFileUtils moreFileUtils, LanguageFileResolver languageFileResolver, Context context) {
        this.f3044c = appVersionInfo;
        this.f3042a = moreFileUtils;
        this.f3043b = languageFileResolver;
        this.f3045d = context;
    }

    public final void m5041a() {
        int i = 0;
        File[] listFiles = this.f3043b.m5020a(this.f3045d).listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i2 = 0;
            while (i2 < length) {
                int max = Math.max(i, LanguageFileResolver.m5017a(listFiles[i2].getName()));
                i2++;
                i = max;
            }
        }
        final int i3 = i;
        this.f3042a.m5036a(this.f3043b.m5020a(this.f3045d), new Predicate<String>(this) {
            final /* synthetic */ LanguageFilesCleaner f3064b;

            public boolean apply(@Nullable Object obj) {
                String str = (String) obj;
                if (str == null) {
                    return false;
                }
                int a = LanguageFileResolver.m5017a(str);
                if (a == 0 || a == this.f3064b.f3044c.mo368b() || a == i3) {
                    return false;
                }
                return true;
            }
        });
    }
}
