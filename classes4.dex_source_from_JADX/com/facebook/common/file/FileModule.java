package com.facebook.common.file;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorModule;

@InjectorModule
/* compiled from: url_map_file_name */
public class FileModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    public static MoreFileUtils getInstanceForTest_FileUtil(FbInjector fbInjector) {
        return MoreFileUtils.a(fbInjector);
    }
}
