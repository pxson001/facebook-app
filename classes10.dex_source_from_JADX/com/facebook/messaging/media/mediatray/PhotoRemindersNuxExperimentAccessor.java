package com.facebook.messaging.media.mediatray;

import android.content.res.Resources;
import com.facebook.common.i18n.I18nJoiner;
import com.facebook.qe.api.QeAccessor;
import com.facebook.user.model.User;
import com.facebook.user.module.UserNameUtil;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: search_typeahead_results */
public class PhotoRemindersNuxExperimentAccessor {
    public final I18nJoiner f3160a;
    public final QeAccessor f3161b;
    private final Resources f3162c;
    public final UserNameUtil f3163d;

    @Inject
    public PhotoRemindersNuxExperimentAccessor(I18nJoiner i18nJoiner, QeAccessor qeAccessor, Resources resources, UserNameUtil userNameUtil) {
        this.f3160a = i18nJoiner;
        this.f3161b = qeAccessor;
        this.f3162c = resources;
        this.f3163d = userNameUtil;
    }

    public final String m3125a(List<User> list) {
        int i;
        String str;
        Resources resources = this.f3162c;
        switch (this.f3161b.a(ExperimentsForMediaTrayModule.f3027d, 0)) {
            case 0:
                i = 2131240901;
                break;
            case 1:
                i = 2131240902;
                break;
            case 2:
                if (!list.isEmpty()) {
                    i = 2131240904;
                    break;
                }
                i = 2131240903;
                break;
            default:
                i = 2131240901;
                break;
        }
        int i2 = i;
        Object[] objArr = new Object[1];
        int min = Math.min(list.size(), 2);
        if (min == 0) {
            str = null;
        } else {
            List arrayList = new ArrayList(min);
            for (int i3 = 0; i3 < min; i3++) {
                arrayList.add(this.f3163d.a((User) list.get(i3)));
            }
            str = this.f3160a.a(arrayList);
        }
        objArr[0] = str;
        return resources.getString(i2, objArr);
    }
}
