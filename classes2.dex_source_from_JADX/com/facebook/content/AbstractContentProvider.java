package com.facebook.content;

import android.annotation.TargetApi;
import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.TraceConfig;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

/* compiled from: ӹ־ת״ۿݿ๿₯℺﷿﻿ￜ */
public abstract class AbstractContentProvider extends ContentProvider implements InjectableComponentWithContext {
    private final AtomicBoolean f21a = new AtomicBoolean();

    protected abstract int mo4a(Uri uri, ContentValues contentValues, String str, String[] strArr);

    protected abstract int mo5a(Uri uri, String str, String[] strArr);

    protected abstract Cursor mo6a(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    protected abstract Uri mo7a(Uri uri, ContentValues contentValues);

    protected abstract String mo8a(Uri uri);

    AbstractContentProvider() {
    }

    protected ContentProviderResult[] mo43a(ArrayList<ContentProviderOperation> arrayList) {
        return super.applyBatch(arrayList);
    }

    protected int mo42a(Uri uri, ContentValues[] contentValuesArr) {
        return super.bulkInsert(uri, contentValuesArr);
    }

    private static Bundle mo58d() {
        return null;
    }

    private static String[] m41e() {
        return null;
    }

    protected AssetFileDescriptor m48a(Uri uri, String str) {
        return super.openAssetFile(uri, str);
    }

    protected ParcelFileDescriptor m55b(Uri uri, String str) {
        return super.openFile(uri, str);
    }

    protected AssetFileDescriptor m54b(Uri uri) {
        return null;
    }

    @TargetApi(16)
    private Cursor mo56b(Uri uri, String[] strArr, @Nullable String str, String[] strArr2, @Nullable String str2) {
        return mo6a(uri, strArr, str, strArr2, str2);
    }

    private boolean m42f() {
        return super.isTemporary();
    }

    protected void mo10a() {
    }

    public boolean mo9b() {
        return false;
    }

    protected final void m57c() {
        synchronized (this.f21a) {
            if (!this.f21a.get()) {
                mo10a();
                this.f21a.set(true);
            }
        }
    }

    private void m43h() {
        m57c();
        if (!mo9b()) {
            PermissionChecks.a();
        }
    }

    public final boolean onCreate() {
        m38a("onCreate");
        m44i();
        return true;
    }

    public final int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        m38a("bulkInsert");
        try {
            m43h();
            int a = mo42a(uri, contentValuesArr);
            return a;
        } finally {
            m44i();
        }
    }

    public final Bundle call(String str, String str2, Bundle bundle) {
        m38a("call");
        try {
            m43h();
            Bundle d = mo58d();
            return d;
        } finally {
            m44i();
        }
    }

    public final int delete(Uri uri, @Nullable String str, String[] strArr) {
        m38a("delete");
        try {
            m43h();
            int a = mo5a(uri, str, strArr);
            return a;
        } finally {
            m44i();
        }
    }

    public final ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) {
        m38a("applyBatch");
        try {
            m43h();
            ContentProviderResult[] a = mo43a((ArrayList) arrayList);
            return a;
        } finally {
            m44i();
        }
    }

    public final String[] getStreamTypes(Uri uri, String str) {
        m38a("getStreamTypes");
        try {
            m43h();
            String[] e = m41e();
            return e;
        } finally {
            m44i();
        }
    }

    public final String getType(Uri uri) {
        m38a("getType");
        try {
            m43h();
            String a = mo8a(uri);
            return a;
        } finally {
            m44i();
        }
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        m38a("insert");
        try {
            m43h();
            Uri a = mo7a(uri, contentValues);
            return a;
        } finally {
            m44i();
        }
    }

    public final AssetFileDescriptor openAssetFile(Uri uri, String str) {
        m38a("openAssetFile");
        try {
            m43h();
            AssetFileDescriptor a = m48a(uri, str);
            return a;
        } finally {
            m44i();
        }
    }

    public final ParcelFileDescriptor openFile(Uri uri, String str) {
        m38a("openFile");
        try {
            m43h();
            ParcelFileDescriptor b = m55b(uri, str);
            return b;
        } finally {
            m44i();
        }
    }

    public final AssetFileDescriptor openTypedAssetFile(Uri uri, String str, Bundle bundle) {
        m38a("openTypedAssetFile");
        try {
            m43h();
            AssetFileDescriptor b = m54b(uri);
            return b;
        } finally {
            m44i();
        }
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        m38a("query");
        try {
            m43h();
            Cursor a = mo6a(uri, strArr, str, strArr2, str2);
            return a;
        } finally {
            m44i();
        }
    }

    @TargetApi(16)
    public final Cursor query(Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2, @Nullable CancellationSignal cancellationSignal) {
        m38a("query");
        try {
            m43h();
            Cursor b = mo56b(uri, strArr, str, strArr2, str2);
            return b;
        } finally {
            m44i();
        }
    }

    public final int update(Uri uri, ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        m38a("update");
        try {
            m43h();
            int a = mo4a(uri, contentValues, str, strArr);
            return a;
        } finally {
            m44i();
        }
    }

    protected final boolean isTemporary() {
        m38a("isTemporary");
        try {
            m43h();
            boolean f = m42f();
            return f;
        } finally {
            m44i();
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        m38a("onConfigurationChanged");
        try {
            if (this.f21a.get()) {
                m43h();
                super.onConfigurationChanged(configuration);
                m44i();
            }
        } finally {
            m44i();
        }
    }

    public final void shutdown() {
        m38a("shutdown");
        try {
            if (this.f21a.get()) {
                m43h();
                m44i();
            }
        } finally {
            m44i();
        }
    }

    @TargetApi(14)
    public final void onTrimMemory(int i) {
        m38a("onTrimMemory");
        try {
            if (this.f21a.get()) {
                m43h();
                super.onTrimMemory(i);
                m44i();
            }
        } finally {
            m44i();
        }
    }

    public final void onLowMemory() {
        m38a("onLowMemory");
        try {
            if (this.f21a.get()) {
                m43h();
                super.onLowMemory();
                m44i();
            }
        } finally {
            m44i();
        }
    }

    private void m38a(String str) {
        if (TraceConfig.a(512)) {
            Systrace.a(512, getClass().getSimpleName() + "." + str);
        }
    }

    private static void m44i() {
        Systrace.a(512);
    }
}
