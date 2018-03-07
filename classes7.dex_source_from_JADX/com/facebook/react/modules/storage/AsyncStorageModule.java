package com.facebook.react.modules.storage;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;

/* compiled from: friends_megaphone_dismissed */
public final class AsyncStorageModule extends ReactContextBaseJavaModule {
    public ReactDatabaseSupplier f11696a;
    private boolean f11697b = false;

    public AsyncStorageModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.f11696a = ReactDatabaseSupplier.m13767a(reactApplicationContext);
    }

    public final String getName() {
        return "AsyncSQLiteDBStorage";
    }

    public final void m13765c() {
        super.c();
        this.f11697b = false;
    }

    public final void m13766e() {
        this.f11697b = true;
    }

    @ReactMethod
    public final void multiGet(final ReadableArray readableArray, final Callback callback) {
        if (readableArray == null) {
            callback.mo642a(AsyncStorageErrorUtil.m13751a(null), null);
            return;
        }
        new GuardedAsyncTask<Void, Void>(this, this.f1100a) {
            final /* synthetic */ AsyncStorageModule f11682c;

            protected final /* bridge */ /* synthetic */ void mo731a(Object[] objArr) {
                m13755a();
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private void m13755a() {
                /*
                r15 = this;
                r14 = 2;
                r13 = 1;
                r9 = 0;
                r5 = 0;
                r0 = r15.f11682c;
                r0 = com.facebook.react.modules.storage.AsyncStorageModule.m13764r(r0);
                if (r0 != 0) goto L_0x001c;
            L_0x000c:
                r0 = r7;
                r1 = new java.lang.Object[r14];
                r2 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13754c(r5);
                r1[r9] = r2;
                r1[r13] = r5;
                r0.mo642a(r1);
            L_0x001b:
                return;
            L_0x001c:
                r2 = new java.lang.String[r14];
                r0 = "key";
                r2[r9] = r0;
                r0 = "value";
                r2[r13] = r0;
                r10 = com.facebook.react.common.SetBuilder.m13611a();
                r11 = com.facebook.react.bridge.Arguments.m13384a();
                r8 = r9;
            L_0x002f:
                r0 = r6;
                r0 = r0.size();
                if (r8 >= r0) goto L_0x00fe;
            L_0x0037:
                r0 = r6;
                r0 = r0.size();
                r0 = r0 - r8;
                r1 = 999; // 0x3e7 float:1.4E-42 double:4.936E-321;
                r12 = java.lang.Math.min(r0, r1);
                r0 = r15.f11682c;
                r0 = r0.f11696a;
                r0 = r0.m13771b();
                r1 = "catalystLocalStorage";
                r3 = com.facebook.react.modules.storage.AsyncLocalStorageUtil.m13745a(r12);
                r4 = r6;
                r4 = com.facebook.react.modules.storage.AsyncLocalStorageUtil.m13749a(r4, r8, r12);
                r6 = r5;
                r7 = r5;
                r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);
                r10.clear();
                r0 = r1.getCount();	 Catch:{ Exception -> 0x00ca }
                r3 = r6;	 Catch:{ Exception -> 0x00ca }
                r3 = r3.size();	 Catch:{ Exception -> 0x00ca }
                if (r0 == r3) goto L_0x007e;
            L_0x006d:
                r0 = r8;
            L_0x006e:
                r3 = r8 + r12;
                if (r0 >= r3) goto L_0x007e;
            L_0x0072:
                r3 = r6;	 Catch:{ Exception -> 0x00ca }
                r3 = r3.getString(r0);	 Catch:{ Exception -> 0x00ca }
                r10.add(r3);	 Catch:{ Exception -> 0x00ca }
                r0 = r0 + 1;
                goto L_0x006e;
            L_0x007e:
                r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x00ca }
                if (r0 == 0) goto L_0x00a9;
            L_0x0084:
                r0 = com.facebook.react.bridge.Arguments.m13384a();	 Catch:{ Exception -> 0x00ca }
                r3 = 0;
                r3 = r1.getString(r3);	 Catch:{ Exception -> 0x00ca }
                r0.pushString(r3);	 Catch:{ Exception -> 0x00ca }
                r3 = 1;
                r3 = r1.getString(r3);	 Catch:{ Exception -> 0x00ca }
                r0.pushString(r3);	 Catch:{ Exception -> 0x00ca }
                r11.mo688a(r0);	 Catch:{ Exception -> 0x00ca }
                r0 = 0;
                r0 = r1.getString(r0);	 Catch:{ Exception -> 0x00ca }
                r10.remove(r0);	 Catch:{ Exception -> 0x00ca }
                r0 = r1.moveToNext();	 Catch:{ Exception -> 0x00ca }
                if (r0 != 0) goto L_0x0084;
            L_0x00a9:
                r1.close();
                r1 = r10.iterator();
            L_0x00b0:
                r0 = r1.hasNext();
                if (r0 == 0) goto L_0x00f6;
            L_0x00b6:
                r0 = r1.next();
                r0 = (java.lang.String) r0;
                r3 = com.facebook.react.bridge.Arguments.m13384a();
                r3.pushString(r0);
                r3.pushNull();
                r11.mo688a(r3);
                goto L_0x00b0;
            L_0x00ca:
                r0 = move-exception;
                r2 = "React";
                r3 = r0.getMessage();	 Catch:{ all -> 0x00f1 }
                com.facebook.common.logging.FLog.a(r2, r3, r0);	 Catch:{ all -> 0x00f1 }
                r2 = r7;	 Catch:{ all -> 0x00f1 }
                r3 = 2;
                r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x00f1 }
                r4 = 0;
                r5 = 0;
                r0 = r0.getMessage();	 Catch:{ all -> 0x00f1 }
                r0 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13752a(r5, r0);	 Catch:{ all -> 0x00f1 }
                r3[r4] = r0;	 Catch:{ all -> 0x00f1 }
                r0 = 1;
                r4 = 0;
                r3[r0] = r4;	 Catch:{ all -> 0x00f1 }
                r2.mo642a(r3);	 Catch:{ all -> 0x00f1 }
                r1.close();
                goto L_0x001b;
            L_0x00f1:
                r0 = move-exception;
                r1.close();
                throw r0;
            L_0x00f6:
                r10.clear();
                r0 = r8 + 999;
                r8 = r0;
                goto L_0x002f;
            L_0x00fe:
                r0 = r7;
                r1 = new java.lang.Object[r14];
                r1[r9] = r5;
                r1[r13] = r11;
                r0.mo642a(r1);
                goto L_0x001b;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.storage.AsyncStorageModule.1.a():void");
            }
        }.execute(new Void[0]);
    }

    @ReactMethod
    public final void multiSet(final ReadableArray readableArray, final Callback callback) {
        if (readableArray.size() == 0) {
            callback.mo642a(AsyncStorageErrorUtil.m13751a(null));
            return;
        }
        new GuardedAsyncTask<Void, Void>(this, this.f1100a) {
            final /* synthetic */ AsyncStorageModule f11685c;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            protected final void mo731a(java.lang.Object[] r10) {
                /*
                r9 = this;
                r8 = 2;
                r7 = 1;
                r3 = 0;
                r2 = 0;
                r0 = r9.f11685c;
                r0 = com.facebook.react.modules.storage.AsyncStorageModule.m13764r(r0);
                if (r0 != 0) goto L_0x001a;
            L_0x000c:
                r0 = r6;
                r1 = new java.lang.Object[r7];
                r2 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13754c(r2);
                r1[r3] = r2;
                r0.mo642a(r1);
            L_0x0019:
                return;
            L_0x001a:
                r0 = "INSERT OR REPLACE INTO catalystLocalStorage VALUES (?, ?);";
                r1 = r9.f11685c;
                r1 = r1.f11696a;
                r1 = r1.m13771b();
                r1 = r1.compileStatement(r0);
                r0 = r9.f11685c;	 Catch:{ Exception -> 0x014e }
                r0 = r0.f11696a;	 Catch:{ Exception -> 0x014e }
                r0 = r0.m13771b();	 Catch:{ Exception -> 0x014e }
                r4 = 1644346402; // 0x6202bc22 float:6.029083E20 double:8.12415067E-315;
                com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r0, r4);	 Catch:{ Exception -> 0x014e }
                r0 = r3;
            L_0x0037:
                r4 = r5;	 Catch:{ Exception -> 0x014e }
                r4 = r4.size();	 Catch:{ Exception -> 0x014e }
                if (r0 >= r4) goto L_0x0114;
            L_0x003f:
                r4 = r5;	 Catch:{ Exception -> 0x014e }
                r4 = r4.mo668a(r0);	 Catch:{ Exception -> 0x014e }
                r4 = r4.size();	 Catch:{ Exception -> 0x014e }
                if (r4 == r8) goto L_0x0073;
            L_0x004b:
                r0 = 0;
                r1 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13753b(r0);	 Catch:{ Exception -> 0x014e }
                r0 = r9.f11685c;	 Catch:{ Exception -> 0x005f }
                r0 = r0.f11696a;	 Catch:{ Exception -> 0x005f }
                r0 = r0.m13771b();	 Catch:{ Exception -> 0x005f }
                r3 = 1174830101; // 0x46067c15 float:8607.0205 double:5.804431926E-315;
                com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r0, r3);	 Catch:{ Exception -> 0x005f }
                goto L_0x0019;
            L_0x005f:
                r0 = move-exception;
                r3 = "React";
                r4 = r0.getMessage();
                com.facebook.common.logging.FLog.a(r3, r4, r0);
                if (r1 != 0) goto L_0x0019;
            L_0x006b:
                r0 = r0.getMessage();
                com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13752a(r2, r0);
                goto L_0x0019;
            L_0x0073:
                r4 = r5;	 Catch:{  }
                r4 = r4.mo668a(r0);	 Catch:{  }
                r5 = 0;
                r4 = r4.getString(r5);	 Catch:{  }
                if (r4 != 0) goto L_0x00a9;
            L_0x0080:
                r0 = 0;
                r1 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13751a(r0);	 Catch:{  }
                r0 = r9.f11685c;	 Catch:{ Exception -> 0x0094 }
                r0 = r0.f11696a;	 Catch:{ Exception -> 0x0094 }
                r0 = r0.m13771b();	 Catch:{ Exception -> 0x0094 }
                r3 = 172634651; // 0xa4a321b float:9.73537E-33 double:8.52928503E-316;
                com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r0, r3);	 Catch:{ Exception -> 0x0094 }
                goto L_0x0019;
            L_0x0094:
                r0 = move-exception;
                r3 = "React";
                r4 = r0.getMessage();
                com.facebook.common.logging.FLog.a(r3, r4, r0);
                if (r1 != 0) goto L_0x0019;
            L_0x00a0:
                r0 = r0.getMessage();
                com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13752a(r2, r0);
                goto L_0x0019;
            L_0x00a9:
                r4 = r5;	 Catch:{  }
                r4 = r4.mo668a(r0);	 Catch:{  }
                r5 = 1;
                r4 = r4.getString(r5);	 Catch:{  }
                if (r4 != 0) goto L_0x00e0;
            L_0x00b6:
                r0 = 0;
                r1 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13753b(r0);	 Catch:{  }
                r0 = r9.f11685c;	 Catch:{ Exception -> 0x00cb }
                r0 = r0.f11696a;	 Catch:{ Exception -> 0x00cb }
                r0 = r0.m13771b();	 Catch:{ Exception -> 0x00cb }
                r3 = -176703083; // 0xfffffffff577b995 float:-3.1402866E32 double:NaN;
                com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r0, r3);	 Catch:{ Exception -> 0x00cb }
                goto L_0x0019;
            L_0x00cb:
                r0 = move-exception;
                r3 = "React";
                r4 = r0.getMessage();
                com.facebook.common.logging.FLog.a(r3, r4, r0);
                if (r1 != 0) goto L_0x0019;
            L_0x00d7:
                r0 = r0.getMessage();
                com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13752a(r2, r0);
                goto L_0x0019;
            L_0x00e0:
                r1.clearBindings();	 Catch:{  }
                r4 = 1;
                r5 = r5;	 Catch:{  }
                r5 = r5.mo668a(r0);	 Catch:{  }
                r6 = 0;
                r5 = r5.getString(r6);	 Catch:{  }
                r1.bindString(r4, r5);	 Catch:{  }
                r4 = 2;
                r5 = r5;	 Catch:{  }
                r5 = r5.mo668a(r0);	 Catch:{  }
                r6 = 1;
                r5 = r5.getString(r6);	 Catch:{  }
                r1.bindString(r4, r5);	 Catch:{  }
                r4 = -1332102977; // 0xffffffffb099b8bf float:-1.1184723E-9 double:NaN;
                com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r4);	 Catch:{  }
                r1.execute();	 Catch:{  }
                r4 = -535921087; // 0xffffffffe00e7e41 float:-4.1070863E19 double:NaN;
                com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r4);	 Catch:{  }
                r0 = r0 + 1;
                goto L_0x0037;
            L_0x0114:
                r0 = r9.f11685c;	 Catch:{  }
                r0 = r0.f11696a;	 Catch:{  }
                r0 = r0.m13771b();	 Catch:{  }
                r0.setTransactionSuccessful();	 Catch:{  }
                r0 = r9.f11685c;	 Catch:{ Exception -> 0x013b }
                r0 = r0.f11696a;	 Catch:{ Exception -> 0x013b }
                r0 = r0.m13771b();	 Catch:{ Exception -> 0x013b }
                r1 = -1359797904; // 0xffffffffaef32170 float:-1.10563E-10 double:NaN;
                com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r0, r1);	 Catch:{ Exception -> 0x013b }
                r0 = r2;
            L_0x012e:
                if (r0 == 0) goto L_0x01a7;
            L_0x0130:
                r1 = r6;
                r2 = new java.lang.Object[r7];
                r2[r3] = r0;
                r1.mo642a(r2);
                goto L_0x0019;
            L_0x013b:
                r0 = move-exception;
                r1 = "React";
                r4 = r0.getMessage();
                com.facebook.common.logging.FLog.a(r1, r4, r0);
                r0 = r0.getMessage();
                r0 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13752a(r2, r0);
                goto L_0x012e;
            L_0x014e:
                r0 = move-exception;
                r1 = "React";
                r4 = r0.getMessage();	 Catch:{ all -> 0x0185 }
                com.facebook.common.logging.FLog.a(r1, r4, r0);	 Catch:{ all -> 0x0185 }
                r1 = 0;
                r0 = r0.getMessage();	 Catch:{ all -> 0x0185 }
                r0 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13752a(r1, r0);	 Catch:{ all -> 0x0185 }
                r1 = r9.f11685c;	 Catch:{ Exception -> 0x0170 }
                r1 = r1.f11696a;	 Catch:{ Exception -> 0x0170 }
                r1 = r1.m13771b();	 Catch:{ Exception -> 0x0170 }
                r4 = 1351242749; // 0x508a53fd float:1.85660805E10 double:6.676026215E-315;
                com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r1, r4);	 Catch:{ Exception -> 0x0170 }
                goto L_0x012e;
            L_0x0170:
                r1 = move-exception;
                r4 = "React";
                r5 = r1.getMessage();
                com.facebook.common.logging.FLog.a(r4, r5, r1);
                if (r0 != 0) goto L_0x012e;
            L_0x017c:
                r0 = r1.getMessage();
                r0 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13752a(r2, r0);
                goto L_0x012e;
            L_0x0185:
                r0 = move-exception;
                r1 = r9.f11685c;	 Catch:{ Exception -> 0x0195 }
                r1 = r1.f11696a;	 Catch:{ Exception -> 0x0195 }
                r1 = r1.m13771b();	 Catch:{ Exception -> 0x0195 }
                r3 = -42255881; // 0xfffffffffd7b39f7 float:-2.0871075E37 double:NaN;
                com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r1, r3);	 Catch:{ Exception -> 0x0195 }
            L_0x0194:
                throw r0;
            L_0x0195:
                r1 = move-exception;
                r3 = "React";
                r4 = r1.getMessage();
                com.facebook.common.logging.FLog.a(r3, r4, r1);
                r1 = r1.getMessage();
                com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13752a(r2, r1);
                goto L_0x0194;
            L_0x01a7:
                r0 = r6;
                r1 = new java.lang.Object[r3];
                r0.mo642a(r1);
                goto L_0x0019;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.storage.AsyncStorageModule.2.a(java.lang.Object[]):void");
            }
        }.execute(new Void[0]);
    }

    @ReactMethod
    public final void multiRemove(final ReadableArray readableArray, final Callback callback) {
        if (readableArray.size() == 0) {
            callback.mo642a(AsyncStorageErrorUtil.m13751a(null));
            return;
        }
        new GuardedAsyncTask<Void, Void>(this, this.f1100a) {
            final /* synthetic */ AsyncStorageModule f11688c;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            protected final void mo731a(java.lang.Object[] r10) {
                /*
                r9 = this;
                r8 = 1;
                r3 = 0;
                r2 = 0;
                r0 = r9.f11688c;
                r0 = com.facebook.react.modules.storage.AsyncStorageModule.m13764r(r0);
                if (r0 != 0) goto L_0x0019;
            L_0x000b:
                r0 = r6;
                r1 = new java.lang.Object[r8];
                r2 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13754c(r2);
                r1[r3] = r2;
                r0.mo642a(r1);
            L_0x0018:
                return;
            L_0x0019:
                r0 = r9.f11688c;	 Catch:{ Exception -> 0x0090 }
                r0 = r0.f11696a;	 Catch:{ Exception -> 0x0090 }
                r0 = r0.m13771b();	 Catch:{ Exception -> 0x0090 }
                r1 = -1690585889; // 0xffffffff9b3bb4df float:-1.552672E-22 double:NaN;
                com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r0, r1);	 Catch:{ Exception -> 0x0090 }
                r0 = r3;
            L_0x0028:
                r1 = r5;	 Catch:{ Exception -> 0x0090 }
                r1 = r1.size();	 Catch:{ Exception -> 0x0090 }
                if (r0 >= r1) goto L_0x0057;
            L_0x0030:
                r1 = r5;	 Catch:{ Exception -> 0x0090 }
                r1 = r1.size();	 Catch:{ Exception -> 0x0090 }
                r1 = r1 - r0;
                r4 = 999; // 0x3e7 float:1.4E-42 double:4.936E-321;
                r1 = java.lang.Math.min(r1, r4);	 Catch:{ Exception -> 0x0090 }
                r4 = r9.f11688c;	 Catch:{ Exception -> 0x0090 }
                r4 = r4.f11696a;	 Catch:{ Exception -> 0x0090 }
                r4 = r4.m13771b();	 Catch:{ Exception -> 0x0090 }
                r5 = "catalystLocalStorage";
                r6 = com.facebook.react.modules.storage.AsyncLocalStorageUtil.m13745a(r1);	 Catch:{ Exception -> 0x0090 }
                r7 = r5;	 Catch:{ Exception -> 0x0090 }
                r1 = com.facebook.react.modules.storage.AsyncLocalStorageUtil.m13749a(r7, r0, r1);	 Catch:{ Exception -> 0x0090 }
                r4.delete(r5, r6, r1);	 Catch:{ Exception -> 0x0090 }
                r0 = r0 + 999;
                goto L_0x0028;
            L_0x0057:
                r0 = r9.f11688c;	 Catch:{ Exception -> 0x0090 }
                r0 = r0.f11696a;	 Catch:{ Exception -> 0x0090 }
                r0 = r0.m13771b();	 Catch:{ Exception -> 0x0090 }
                r0.setTransactionSuccessful();	 Catch:{ Exception -> 0x0090 }
                r0 = r9.f11688c;	 Catch:{ Exception -> 0x007d }
                r0 = r0.f11696a;	 Catch:{ Exception -> 0x007d }
                r0 = r0.m13771b();	 Catch:{ Exception -> 0x007d }
                r1 = -1901485439; // 0xffffffff8ea9a281 float:-4.1818202E-30 double:NaN;
                com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r0, r1);	 Catch:{ Exception -> 0x007d }
                r0 = r2;
            L_0x0071:
                if (r0 == 0) goto L_0x00e9;
            L_0x0073:
                r1 = r6;
                r2 = new java.lang.Object[r8];
                r2[r3] = r0;
                r1.mo642a(r2);
                goto L_0x0018;
            L_0x007d:
                r0 = move-exception;
                r1 = "React";
                r4 = r0.getMessage();
                com.facebook.common.logging.FLog.a(r1, r4, r0);
                r0 = r0.getMessage();
                r0 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13752a(r2, r0);
                goto L_0x0071;
            L_0x0090:
                r0 = move-exception;
                r1 = "React";
                r4 = r0.getMessage();	 Catch:{ all -> 0x00c7 }
                com.facebook.common.logging.FLog.a(r1, r4, r0);	 Catch:{ all -> 0x00c7 }
                r1 = 0;
                r0 = r0.getMessage();	 Catch:{ all -> 0x00c7 }
                r0 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13752a(r1, r0);	 Catch:{ all -> 0x00c7 }
                r1 = r9.f11688c;	 Catch:{ Exception -> 0x00b2 }
                r1 = r1.f11696a;	 Catch:{ Exception -> 0x00b2 }
                r1 = r1.m13771b();	 Catch:{ Exception -> 0x00b2 }
                r4 = 2023674964; // 0x789ed454 float:2.5771545E34 double:9.99828278E-315;
                com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r1, r4);	 Catch:{ Exception -> 0x00b2 }
                goto L_0x0071;
            L_0x00b2:
                r1 = move-exception;
                r4 = "React";
                r5 = r1.getMessage();
                com.facebook.common.logging.FLog.a(r4, r5, r1);
                if (r0 != 0) goto L_0x0071;
            L_0x00be:
                r0 = r1.getMessage();
                r0 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13752a(r2, r0);
                goto L_0x0071;
            L_0x00c7:
                r0 = move-exception;
                r1 = r9.f11688c;	 Catch:{ Exception -> 0x00d7 }
                r1 = r1.f11696a;	 Catch:{ Exception -> 0x00d7 }
                r1 = r1.m13771b();	 Catch:{ Exception -> 0x00d7 }
                r3 = 1638593163; // 0x61aaf28b float:3.9417794E20 double:8.095725893E-315;
                com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r1, r3);	 Catch:{ Exception -> 0x00d7 }
            L_0x00d6:
                throw r0;
            L_0x00d7:
                r1 = move-exception;
                r3 = "React";
                r4 = r1.getMessage();
                com.facebook.common.logging.FLog.a(r3, r4, r1);
                r1 = r1.getMessage();
                com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13752a(r2, r1);
                goto L_0x00d6;
            L_0x00e9:
                r0 = r6;
                r1 = new java.lang.Object[r3];
                r0.mo642a(r1);
                goto L_0x0018;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.storage.AsyncStorageModule.3.a(java.lang.Object[]):void");
            }
        }.execute(new Void[0]);
    }

    @ReactMethod
    public final void multiMerge(final ReadableArray readableArray, final Callback callback) {
        new GuardedAsyncTask<Void, Void>(this, this.f1100a) {
            final /* synthetic */ AsyncStorageModule f11691c;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            protected final void mo731a(java.lang.Object[] r9) {
                /*
                r8 = this;
                r7 = 1;
                r3 = 0;
                r2 = 0;
                r0 = r8.f11691c;
                r0 = com.facebook.react.modules.storage.AsyncStorageModule.m13764r(r0);
                if (r0 != 0) goto L_0x0019;
            L_0x000b:
                r0 = r5;
                r1 = new java.lang.Object[r7];
                r2 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13754c(r2);
                r1[r3] = r2;
                r0.mo642a(r1);
            L_0x0018:
                return;
            L_0x0019:
                r0 = r8.f11691c;	 Catch:{ Exception -> 0x015e }
                r0 = r0.f11696a;	 Catch:{ Exception -> 0x015e }
                r0 = r0.m13771b();	 Catch:{ Exception -> 0x015e }
                r1 = 1043634419; // 0x3e3498f3 float:0.1763647 double:5.15623913E-315;
                com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r0, r1);	 Catch:{ Exception -> 0x015e }
                r0 = r3;
            L_0x0028:
                r1 = r4;	 Catch:{ Exception -> 0x015e }
                r1 = r1.size();	 Catch:{ Exception -> 0x015e }
                if (r0 >= r1) goto L_0x0124;
            L_0x0030:
                r1 = r4;	 Catch:{ Exception -> 0x015e }
                r1 = r1.mo668a(r0);	 Catch:{ Exception -> 0x015e }
                r1 = r1.size();	 Catch:{ Exception -> 0x015e }
                r4 = 2;
                if (r1 == r4) goto L_0x0065;
            L_0x003d:
                r0 = 0;
                r1 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13753b(r0);	 Catch:{ Exception -> 0x015e }
                r0 = r8.f11691c;	 Catch:{ Exception -> 0x0051 }
                r0 = r0.f11696a;	 Catch:{ Exception -> 0x0051 }
                r0 = r0.m13771b();	 Catch:{ Exception -> 0x0051 }
                r3 = 318457266; // 0x12fb45b2 float:1.5857508E-27 double:1.57338795E-315;
                com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r0, r3);	 Catch:{ Exception -> 0x0051 }
                goto L_0x0018;
            L_0x0051:
                r0 = move-exception;
                r3 = "React";
                r4 = r0.getMessage();
                com.facebook.common.logging.FLog.a(r3, r4, r0);
                if (r1 != 0) goto L_0x0018;
            L_0x005d:
                r0 = r0.getMessage();
                com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13752a(r2, r0);
                goto L_0x0018;
            L_0x0065:
                r1 = r4;	 Catch:{  }
                r1 = r1.mo668a(r0);	 Catch:{  }
                r4 = 0;
                r1 = r1.getString(r4);	 Catch:{  }
                if (r1 != 0) goto L_0x009b;
            L_0x0072:
                r0 = 0;
                r1 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13751a(r0);	 Catch:{  }
                r0 = r8.f11691c;	 Catch:{ Exception -> 0x0086 }
                r0 = r0.f11696a;	 Catch:{ Exception -> 0x0086 }
                r0 = r0.m13771b();	 Catch:{ Exception -> 0x0086 }
                r3 = 520283090; // 0x1f02e3d2 float:2.771702E-20 double:2.57054001E-315;
                com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r0, r3);	 Catch:{ Exception -> 0x0086 }
                goto L_0x0018;
            L_0x0086:
                r0 = move-exception;
                r3 = "React";
                r4 = r0.getMessage();
                com.facebook.common.logging.FLog.a(r3, r4, r0);
                if (r1 != 0) goto L_0x0018;
            L_0x0092:
                r0 = r0.getMessage();
                com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13752a(r2, r0);
                goto L_0x0018;
            L_0x009b:
                r1 = r4;	 Catch:{  }
                r1 = r1.mo668a(r0);	 Catch:{  }
                r4 = 1;
                r1 = r1.getString(r4);	 Catch:{  }
                if (r1 != 0) goto L_0x00d2;
            L_0x00a8:
                r0 = 0;
                r1 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13753b(r0);	 Catch:{  }
                r0 = r8.f11691c;	 Catch:{ Exception -> 0x00bd }
                r0 = r0.f11696a;	 Catch:{ Exception -> 0x00bd }
                r0 = r0.m13771b();	 Catch:{ Exception -> 0x00bd }
                r3 = 977170485; // 0x3a3e7035 float:7.264645E-4 double:4.82786367E-315;
                com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r0, r3);	 Catch:{ Exception -> 0x00bd }
                goto L_0x0018;
            L_0x00bd:
                r0 = move-exception;
                r3 = "React";
                r4 = r0.getMessage();
                com.facebook.common.logging.FLog.a(r3, r4, r0);
                if (r1 != 0) goto L_0x0018;
            L_0x00c9:
                r0 = r0.getMessage();
                com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13752a(r2, r0);
                goto L_0x0018;
            L_0x00d2:
                r1 = r8.f11691c;	 Catch:{  }
                r1 = r1.f11696a;	 Catch:{  }
                r1 = r1.m13771b();	 Catch:{  }
                r4 = r4;	 Catch:{  }
                r4 = r4.mo668a(r0);	 Catch:{  }
                r5 = 0;
                r4 = r4.getString(r5);	 Catch:{  }
                r5 = r4;	 Catch:{  }
                r5 = r5.mo668a(r0);	 Catch:{  }
                r6 = 1;
                r5 = r5.getString(r6);	 Catch:{  }
                r1 = com.facebook.react.modules.storage.AsyncLocalStorageUtil.m13748a(r1, r4, r5);	 Catch:{  }
                if (r1 != 0) goto L_0x0120;
            L_0x00f6:
                r0 = 0;
                r1 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13754c(r0);	 Catch:{  }
                r0 = r8.f11691c;	 Catch:{ Exception -> 0x010b }
                r0 = r0.f11696a;	 Catch:{ Exception -> 0x010b }
                r0 = r0.m13771b();	 Catch:{ Exception -> 0x010b }
                r3 = -1214288982; // 0xffffffffb79f6baa float:-1.9004412E-5 double:NaN;
                com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r0, r3);	 Catch:{ Exception -> 0x010b }
                goto L_0x0018;
            L_0x010b:
                r0 = move-exception;
                r3 = "React";
                r4 = r0.getMessage();
                com.facebook.common.logging.FLog.a(r3, r4, r0);
                if (r1 != 0) goto L_0x0018;
            L_0x0117:
                r0 = r0.getMessage();
                com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13752a(r2, r0);
                goto L_0x0018;
            L_0x0120:
                r0 = r0 + 1;
                goto L_0x0028;
            L_0x0124:
                r0 = r8.f11691c;	 Catch:{  }
                r0 = r0.f11696a;	 Catch:{  }
                r0 = r0.m13771b();	 Catch:{  }
                r0.setTransactionSuccessful();	 Catch:{  }
                r0 = r8.f11691c;	 Catch:{ Exception -> 0x014b }
                r0 = r0.f11696a;	 Catch:{ Exception -> 0x014b }
                r0 = r0.m13771b();	 Catch:{ Exception -> 0x014b }
                r1 = -738840615; // 0xffffffffd3f62fd9 float:-2.11472941E12 double:NaN;
                com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r0, r1);	 Catch:{ Exception -> 0x014b }
                r0 = r2;
            L_0x013e:
                if (r0 == 0) goto L_0x01b7;
            L_0x0140:
                r1 = r5;
                r2 = new java.lang.Object[r7];
                r2[r3] = r0;
                r1.mo642a(r2);
                goto L_0x0018;
            L_0x014b:
                r0 = move-exception;
                r1 = "React";
                r4 = r0.getMessage();
                com.facebook.common.logging.FLog.a(r1, r4, r0);
                r0 = r0.getMessage();
                r0 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13752a(r2, r0);
                goto L_0x013e;
            L_0x015e:
                r0 = move-exception;
                r1 = "React";
                r4 = r0.getMessage();	 Catch:{ all -> 0x0195 }
                com.facebook.common.logging.FLog.a(r1, r4, r0);	 Catch:{ all -> 0x0195 }
                r1 = 0;
                r0 = r0.getMessage();	 Catch:{ all -> 0x0195 }
                r0 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13752a(r1, r0);	 Catch:{ all -> 0x0195 }
                r1 = r8.f11691c;	 Catch:{ Exception -> 0x0180 }
                r1 = r1.f11696a;	 Catch:{ Exception -> 0x0180 }
                r1 = r1.m13771b();	 Catch:{ Exception -> 0x0180 }
                r4 = 922692237; // 0x36ff2a8d float:7.6045458E-6 double:4.55870536E-315;
                com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r1, r4);	 Catch:{ Exception -> 0x0180 }
                goto L_0x013e;
            L_0x0180:
                r1 = move-exception;
                r4 = "React";
                r5 = r1.getMessage();
                com.facebook.common.logging.FLog.a(r4, r5, r1);
                if (r0 != 0) goto L_0x013e;
            L_0x018c:
                r0 = r1.getMessage();
                r0 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13752a(r2, r0);
                goto L_0x013e;
            L_0x0195:
                r0 = move-exception;
                r1 = r8.f11691c;	 Catch:{ Exception -> 0x01a5 }
                r1 = r1.f11696a;	 Catch:{ Exception -> 0x01a5 }
                r1 = r1.m13771b();	 Catch:{ Exception -> 0x01a5 }
                r3 = 1782066959; // 0x6a382f0f float:5.5666145E25 double:8.80458063E-315;
                com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r1, r3);	 Catch:{ Exception -> 0x01a5 }
            L_0x01a4:
                throw r0;
            L_0x01a5:
                r1 = move-exception;
                r3 = "React";
                r4 = r1.getMessage();
                com.facebook.common.logging.FLog.a(r3, r4, r1);
                r1 = r1.getMessage();
                com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13752a(r2, r1);
                goto L_0x01a4;
            L_0x01b7:
                r0 = r5;
                r1 = new java.lang.Object[r3];
                r0.mo642a(r1);
                goto L_0x0018;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.storage.AsyncStorageModule.4.a(java.lang.Object[]):void");
            }
        }.execute(new Void[0]);
    }

    @ReactMethod
    public final void clear(final Callback callback) {
        new GuardedAsyncTask<Void, Void>(this, this.f1100a) {
            final /* synthetic */ AsyncStorageModule f11693b;

            protected final void mo731a(Object[] objArr) {
                if (this.f11693b.f11696a.m13770a()) {
                    try {
                        this.f11693b.f11696a.m13773d();
                        callback.mo642a(new Object[0]);
                        return;
                    } catch (Throwable e) {
                        FLog.a("React", e.getMessage(), e);
                        callback.mo642a(AsyncStorageErrorUtil.m13752a(null, e.getMessage()));
                        return;
                    }
                }
                callback.mo642a(AsyncStorageErrorUtil.m13754c(null));
            }
        }.execute(new Void[0]);
    }

    @ReactMethod
    public final void getAllKeys(final Callback callback) {
        new GuardedAsyncTask<Void, Void>(this, this.f1100a) {
            final /* synthetic */ AsyncStorageModule f11695b;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            protected final void mo731a(java.lang.Object[] r13) {
                /*
                r12 = this;
                r11 = 2;
                r10 = 1;
                r9 = 0;
                r3 = 0;
                r0 = r12.f11695b;
                r0 = com.facebook.react.modules.storage.AsyncStorageModule.m13764r(r0);
                if (r0 != 0) goto L_0x001c;
            L_0x000c:
                r0 = r4;
                r1 = new java.lang.Object[r11];
                r2 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13754c(r3);
                r1[r9] = r2;
                r1[r10] = r3;
                r0.mo642a(r1);
            L_0x001b:
                return;
            L_0x001c:
                r8 = com.facebook.react.bridge.Arguments.m13384a();
                r2 = new java.lang.String[r10];
                r0 = "key";
                r2[r9] = r0;
                r0 = r12.f11695b;
                r0 = r0.f11696a;
                r0 = r0.m13771b();
                r1 = "catalystLocalStorage";
                r4 = r3;
                r5 = r3;
                r6 = r3;
                r7 = r3;
                r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);
                r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x005b }
                if (r0 == 0) goto L_0x004c;
            L_0x003e:
                r0 = 0;
                r0 = r1.getString(r0);	 Catch:{ Exception -> 0x005b }
                r8.pushString(r0);	 Catch:{ Exception -> 0x005b }
                r0 = r1.moveToNext();	 Catch:{ Exception -> 0x005b }
                if (r0 != 0) goto L_0x003e;
            L_0x004c:
                r1.close();
                r0 = r4;
                r1 = new java.lang.Object[r11];
                r1[r9] = r3;
                r1[r10] = r8;
                r0.mo642a(r1);
                goto L_0x001b;
            L_0x005b:
                r0 = move-exception;
                r2 = "React";
                r3 = r0.getMessage();	 Catch:{ all -> 0x0081 }
                com.facebook.common.logging.FLog.a(r2, r3, r0);	 Catch:{ all -> 0x0081 }
                r2 = r4;	 Catch:{ all -> 0x0081 }
                r3 = 2;
                r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0081 }
                r4 = 0;
                r5 = 0;
                r0 = r0.getMessage();	 Catch:{ all -> 0x0081 }
                r0 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.m13752a(r5, r0);	 Catch:{ all -> 0x0081 }
                r3[r4] = r0;	 Catch:{ all -> 0x0081 }
                r0 = 1;
                r4 = 0;
                r3[r0] = r4;	 Catch:{ all -> 0x0081 }
                r2.mo642a(r3);	 Catch:{ all -> 0x0081 }
                r1.close();
                goto L_0x001b;
            L_0x0081:
                r0 = move-exception;
                r1.close();
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.storage.AsyncStorageModule.6.a(java.lang.Object[]):void");
            }
        }.execute(new Void[0]);
    }

    public static boolean m13764r(AsyncStorageModule asyncStorageModule) {
        return !asyncStorageModule.f11697b && asyncStorageModule.f11696a.m13770a();
    }
}
