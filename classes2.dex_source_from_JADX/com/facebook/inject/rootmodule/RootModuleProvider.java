package com.facebook.inject.rootmodule;

import com.facebook.common.process.PrivateProcessName;
import com.facebook.common.process.ProcessName;
import com.facebook.inject.AbstractLibraryModule;

/* compiled from: zero_initial_app_bytes_written */
public class RootModuleProvider {
    private static AbstractLibraryModule m1075a(PrivateProcessName privateProcessName) {
        Throwable e;
        try {
            return (AbstractLibraryModule) Class.forName("generated_rootmodule." + privateProcessName.c() + "ProcessRootModule").newInstance();
        } catch (InstantiationException e2) {
            e = e2;
            throw new IllegalArgumentException("Invalid process name for getting root module: " + privateProcessName, e);
        } catch (ClassNotFoundException e3) {
            e = e3;
            throw new IllegalArgumentException("Invalid process name for getting root module: " + privateProcessName, e);
        } catch (IllegalAccessException e4) {
            e = e4;
            throw new IllegalArgumentException("Invalid process name for getting root module: " + privateProcessName, e);
        }
    }

    public static AbstractLibraryModule m1076a(ProcessName processName) {
        PrivateProcessName privateProcessName = processName.c;
        if (privateProcessName != null) {
            return m1075a(privateProcessName);
        }
        throw new IllegalStateException("processName has null PrivateProcessName - cannot infer root module");
    }
}
