package com.facebook.katana.app.module;

import android.content.Context;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.ForAppContext;
import com.facebook.katana.ringtone.RingtoneUtils;

/* compiled from: mUploadTimePeriodSec */
public class RingtoneUtilsMethodAutoProvider extends AbstractProvider<RingtoneUtils> {
    public Object get() {
        return MainProcessModule.a((Context) getInstance(Context.class, ForAppContext.class), MoreFileUtils.a(this));
    }
}
