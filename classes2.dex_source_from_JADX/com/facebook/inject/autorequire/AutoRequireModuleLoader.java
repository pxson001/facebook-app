package com.facebook.inject.autorequire;

import com.facebook.common.process.PrivateProcessName;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.LibraryModule;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Throwables;
import injector_autorequire_modules.GeneratedModuleLists;
import java.util.List;

@VisibleForTesting
/* compiled from: withWorkingRanges should only be called once. */
public class AutoRequireModuleLoader {
    public static void m1442a(PrivateProcessName privateProcessName, BinderImpl binderImpl) {
        try {
            String a = privateProcessName.a();
            if (a == null) {
                throw new IllegalArgumentException("Unacceptable ProcessName with null private name");
            }
            if (!a.equals("")) {
                a = ":" + a;
            }
            for (Class h : m1441a(r0)) {
                binderImpl.m1361h(h);
            }
        } catch (Throwable e) {
            throw Throwables.propagate(e);
        }
    }

    @VisibleForTesting
    private static List<Class<? extends LibraryModule>> m1441a(String str) {
        return ((GeneratedModuleLists) Class.forName("injector_autorequire_modules.GeneratedModuleLists").newInstance()).m1443a(str);
    }
}
