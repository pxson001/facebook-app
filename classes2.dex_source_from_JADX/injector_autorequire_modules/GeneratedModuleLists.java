package injector_autorequire_modules;

import com.facebook.inject.LibraryModule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: with */
public class GeneratedModuleLists {
    public final List<Class<? extends LibraryModule>> m1443a(String str) {
        try {
            if (!str.equals("")) {
                return Collections.emptyList();
            }
            List arrayList = new ArrayList();
            arrayList.add(Class.forName("com.facebook.config.application.FbAppTypeModule"));
            arrayList.add(Class.forName("com.facebook.auth.userscope.UserScopeModule"));
            return Collections.unmodifiableList(arrayList);
        } catch (Throwable e) {
            throw new IllegalArgumentException("Failed to load module class", e);
        }
    }
}
