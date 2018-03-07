package com.facebook.photos.simplepicker.module;

import android.os.Bundle;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration;
import com.facebook.photos.simplepicker.DraweeSimplePickerFragment;
import com.facebook.photos.simplepicker.LegacySimplePickerFragment;
import com.facebook.photos.simplepicker.SimplePickerFragment;
import com.facebook.photos.simplepicker.abtest.ExperimentsForSimplePickerModule;
import com.facebook.qe.api.QeAccessor;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: sfps */
public class SimplePickerModule extends AbstractLibraryModule {

    /* compiled from: sfps */
    public final class C04091 {
        final /* synthetic */ QeAccessor f3188a;

        C04091(QeAccessor qeAccessor) {
            this.f3188a = qeAccessor;
        }

        public final SimplePickerFragment m3170a(Bundle bundle, SimplePickerLauncherConfiguration simplePickerLauncherConfiguration, String str) {
            if (this.f3188a.a(ExperimentsForSimplePickerModule.f2919c, false)) {
                return DraweeSimplePickerFragment.m2912a(bundle, simplePickerLauncherConfiguration, str);
            }
            return LegacySimplePickerFragment.m2922a(bundle, simplePickerLauncherConfiguration, str);
        }
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static C04091 m3171a(QeAccessor qeAccessor) {
        return new C04091(qeAccessor);
    }
}
