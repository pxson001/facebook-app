package com.facebook.config.background;

import com.facebook.auth.component.LoginComponent;
import com.facebook.http.protocol.BatchComponent;

/* compiled from: sms_is_default_app_for_tracking */
public abstract class AbstractConfigurationAndLoginComponent implements LoginComponent, ConfigurationComponent {
    public abstract BatchComponent mo149c();

    public final BatchComponent mo101b() {
        return mo149c();
    }

    public final BatchComponent mo143a() {
        return mo149c();
    }

    public long co_() {
        return 604800000;
    }
}
