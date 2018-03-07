package com.facebook.react.devsupport;

import android.content.Context;
import javax.annotation.Nullable;

/* compiled from: fundraiser */
public class DevSupportManagerFactory {
    public static DevSupportManager m13685a(Context context, ReactInstanceDevCommandsHandler reactInstanceDevCommandsHandler, @Nullable String str, boolean z) {
        if (!z) {
            return new DisabledDevSupportManager();
        }
        try {
            return (DevSupportManager) Class.forName("com.facebook.react.devsupport." + "DevSupportManagerImpl").getConstructor(new Class[]{Context.class, ReactInstanceDevCommandsHandler.class, String.class, Boolean.TYPE}).newInstance(new Object[]{context, reactInstanceDevCommandsHandler, str, Boolean.valueOf(true)});
        } catch (Throwable e) {
            throw new RuntimeException("Requested enabled DevSupportManager, but DevSupportManagerImpl class was not found or could not be created", e);
        }
    }
}
