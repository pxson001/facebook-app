package com.facebook.content;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.proguard.annotations.DoNotStrip;
import javax.annotation.Nullable;

@DoNotStrip
/* compiled from: tokenHash */
public interface SecureContextHelper {
    void mo660a(Intent intent, int i, Activity activity);

    void mo661a(Intent intent, int i, Fragment fragment);

    void mo662a(Intent intent, Context context);

    void mo663b(Intent intent, int i, Activity activity);

    void mo664b(Intent intent, int i, Fragment fragment);

    void mo665b(Intent intent, Context context);

    @Nullable
    ComponentName mo666c(Intent intent, Context context);
}
