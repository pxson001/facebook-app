package com.android.debug.hv;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import com.facebook.tools.dextr.runtime.detour.ThreadInitDetour;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: treehouse_discover_suggestion */
public class ViewServer implements Runnable {
    private static ViewServer f1655j;
    private ServerSocket f1656a;
    private final int f1657b;
    private Thread f1658c;
    private ExecutorService f1659d;
    private final List<WindowListener> f1660e;
    public final HashMap<View, String> f1661f;
    public final ReentrantReadWriteLock f1662g;
    public View f1663h;
    public final ReentrantReadWriteLock f1664i;

    /* compiled from: treehouse_discover_suggestion */
    class NoopViewServer extends ViewServer {
        public final boolean mo466a() {
            return false;
        }

        public final boolean mo469b() {
            return false;
        }

        public final void mo463a(Activity activity) {
        }

        public final void mo467b(Activity activity) {
        }

        public final void mo465a(View view, String str) {
        }

        public final void mo464a(View view) {
        }

        public final void mo470c(Activity activity) {
        }

        public final void mo468b(View view) {
        }

        public void run() {
        }
    }

    /* compiled from: treehouse_discover_suggestion */
    class UncloseableOuputStream extends OutputStream {
        private final OutputStream f1665a;

        UncloseableOuputStream(OutputStream outputStream) {
            this.f1665a = outputStream;
        }

        public void close() {
        }

        public boolean equals(Object obj) {
            return this.f1665a.equals(obj);
        }

        public void flush() {
            this.f1665a.flush();
        }

        public int hashCode() {
            return this.f1665a.hashCode();
        }

        public String toString() {
            return this.f1665a.toString();
        }

        public void write(byte[] bArr, int i, int i2) {
            this.f1665a.write(bArr, i, i2);
        }

        public void write(byte[] bArr) {
            this.f1665a.write(bArr);
        }

        public void write(int i) {
            this.f1665a.write(i);
        }
    }

    /* compiled from: treehouse_discover_suggestion */
    public class ViewServerWorker implements Runnable {
        final /* synthetic */ ViewServer f1666a;
        private Socket f1667b;
        private boolean f1668c;
        private boolean f1669d;
        private final Object[] f1670e = new Object[0];

        private boolean m2259b(java.net.Socket r7) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:17:0x0074 in {19, 21, 27, 29, 30, 33, 34, 40, 42, 44, 46, 47, 48, 49, 50, 52, 53} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r6 = this;
            r2 = 0;
            r1 = 1;
            r0 = 0;
            r4 = r7.getOutputStream();	 Catch:{ Exception -> 0x00a9, all -> 0x00a5 }
            r3 = new java.io.BufferedWriter;	 Catch:{ Exception -> 0x00a9, all -> 0x00a5 }
            r5 = new java.io.OutputStreamWriter;	 Catch:{ Exception -> 0x00a9, all -> 0x00a5 }
            r5.<init>(r4);	 Catch:{ Exception -> 0x00a9, all -> 0x00a5 }
            r4 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;	 Catch:{ Exception -> 0x00a9, all -> 0x00a5 }
            r3.<init>(r5, r4);	 Catch:{ Exception -> 0x00a9, all -> 0x00a5 }
            r0 = r6.f1666a;	 Catch:{ Exception -> 0x0080, all -> 0x0096 }
            r0 = r0.f1664i;	 Catch:{ Exception -> 0x0080, all -> 0x0096 }
            r0 = r0.readLock();	 Catch:{ Exception -> 0x0080, all -> 0x0096 }
            r0.lock();	 Catch:{ Exception -> 0x0080, all -> 0x0096 }
            r0 = r6.f1666a;	 Catch:{ all -> 0x0073 }
            r4 = r0.f1663h;	 Catch:{ all -> 0x0073 }
            r0 = r6.f1666a;
            r0 = r0.f1664i;
            r0 = r0.readLock();
            r0.unlock();
            if (r4 == 0) goto L_0x0066;	 Catch:{  }
        L_0x002f:
            r0 = r6.f1666a;	 Catch:{  }
            r0 = r0.f1662g;	 Catch:{  }
            r0 = r0.readLock();	 Catch:{  }
            r0.lock();	 Catch:{  }
            r0 = r6.f1666a;	 Catch:{ all -> 0x0089 }
            r0 = r0.f1661f;	 Catch:{ all -> 0x0089 }
            r5 = r6.f1666a;	 Catch:{ all -> 0x0089 }
            r5 = r5.f1663h;	 Catch:{ all -> 0x0089 }
            r0 = r0.get(r5);	 Catch:{ all -> 0x0089 }
            r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0089 }
            r5 = r6.f1666a;
            r5 = r5.f1662g;
            r5 = r5.readLock();
            r5.unlock();
            r4 = java.lang.System.identityHashCode(r4);	 Catch:{  }
            r4 = java.lang.Integer.toHexString(r4);	 Catch:{  }
            r3.write(r4);	 Catch:{  }
            r4 = 32;	 Catch:{  }
            r3.write(r4);	 Catch:{  }
            r3.append(r0);	 Catch:{  }
        L_0x0066:
            r0 = 10;	 Catch:{  }
            r3.write(r0);	 Catch:{  }
            r3.flush();	 Catch:{  }
            r3.close();	 Catch:{ IOException -> 0x009d }
            r0 = r1;
        L_0x0072:
            return r0;
        L_0x0073:
            r0 = move-exception;
            r1 = r6.f1666a;	 Catch:{ all -> 0x0073 }
            r1 = r1.f1664i;	 Catch:{ all -> 0x0073 }
            r1 = r1.readLock();	 Catch:{ all -> 0x0073 }
            r1.unlock();	 Catch:{ all -> 0x0073 }
            throw r0;	 Catch:{ all -> 0x0073 }
        L_0x0080:
            r0 = move-exception;
            r0 = r3;
        L_0x0082:
            if (r0 == 0) goto L_0x00ab;
        L_0x0084:
            r0.close();	 Catch:{ IOException -> 0x00a0 }
            r0 = r2;
            goto L_0x0072;
        L_0x0089:
            r0 = move-exception;
            r1 = r6.f1666a;	 Catch:{ all -> 0x0089 }
            r1 = r1.f1662g;	 Catch:{ all -> 0x0089 }
            r1 = r1.readLock();	 Catch:{ all -> 0x0089 }
            r1.unlock();	 Catch:{ all -> 0x0089 }
            throw r0;	 Catch:{ all -> 0x0089 }
        L_0x0096:
            r0 = move-exception;
        L_0x0097:
            if (r3 == 0) goto L_0x009c;
        L_0x0099:
            r3.close();	 Catch:{ IOException -> 0x00a3 }
        L_0x009c:
            throw r0;
        L_0x009d:
            r0 = move-exception;
            r0 = r2;
            goto L_0x0072;
        L_0x00a0:
            r0 = move-exception;
            r0 = r2;
            goto L_0x0072;
        L_0x00a3:
            r1 = move-exception;
            goto L_0x009c;
        L_0x00a5:
            r1 = move-exception;
            r3 = r0;
            r0 = r1;
            goto L_0x0097;
        L_0x00a9:
            r1 = move-exception;
            goto L_0x0082;
        L_0x00ab:
            r0 = r2;
            goto L_0x0072;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.debug.hv.ViewServer.ViewServerWorker.b(java.net.Socket):boolean");
        }

        public ViewServerWorker(ViewServer viewServer, Socket socket) {
            this.f1666a = viewServer;
            this.f1667b = socket;
            this.f1668c = false;
            this.f1669d = false;
        }

        public void run() {
            Throwable e;
            BufferedReader bufferedReader;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(this.f1667b.getInputStream()), 1024);
                try {
                    String str;
                    boolean b;
                    String readLine = bufferedReader.readLine();
                    int indexOf = readLine.indexOf(32);
                    if (indexOf == -1) {
                        str = "";
                    } else {
                        String substring = readLine.substring(0, indexOf);
                        str = readLine.substring(indexOf + 1);
                        readLine = substring;
                    }
                    if ("PROTOCOL".equalsIgnoreCase(readLine)) {
                        b = ViewServer.m2237b(this.f1667b, "4");
                    } else if ("SERVER".equalsIgnoreCase(readLine)) {
                        b = ViewServer.m2237b(this.f1667b, "4");
                    } else if ("LIST".equalsIgnoreCase(readLine)) {
                        b = m2257a(this.f1667b);
                    } else if ("GET_FOCUS".equalsIgnoreCase(readLine)) {
                        b = m2259b(this.f1667b);
                    } else if ("AUTOLIST".equalsIgnoreCase(readLine)) {
                        b = m2260c();
                    } else {
                        b = m2258a(this.f1667b, readLine, str);
                    }
                    if (!b) {
                        Log.w("ViewServer", "An error occurred with the command: " + readLine);
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    if (this.f1667b != null) {
                        try {
                            this.f1667b.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        Log.w("ViewServer", "Connection error: ", e);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                        if (this.f1667b != null) {
                            try {
                                this.f1667b.close();
                            } catch (IOException e2222) {
                                e2222.printStackTrace();
                            }
                        }
                    } catch (Throwable th) {
                        e = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (this.f1667b != null) {
                            try {
                                this.f1667b.close();
                            } catch (IOException e42) {
                                e42.printStackTrace();
                            }
                        }
                        throw e;
                    }
                }
            } catch (IOException e5) {
                e = e5;
                bufferedReader = null;
                Log.w("ViewServer", "Connection error: ", e);
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (this.f1667b != null) {
                    this.f1667b.close();
                }
            } catch (Throwable th2) {
                e = th2;
                bufferedReader = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (this.f1667b != null) {
                    this.f1667b.close();
                }
                throw e;
            }
        }

        private boolean m2258a(Socket socket, String str, String str2) {
            Throwable e;
            boolean z = true;
            BufferedWriter bufferedWriter = null;
            try {
                int indexOf = str2.indexOf(32);
                if (indexOf == -1) {
                    indexOf = str2.length();
                }
                int parseLong = (int) Long.parseLong(str2.substring(0, indexOf), 16);
                if (indexOf < str2.length()) {
                    str2 = str2.substring(indexOf + 1);
                } else {
                    str2 = "";
                }
                if (m2256a(parseLong) == null) {
                    return false;
                }
                BufferedWriter bufferedWriter2;
                Method declaredMethod = ViewDebug.class.getDeclaredMethod("dispatchCommand", new Class[]{View.class, String.class, String.class, OutputStream.class});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, new Object[]{r3, str, str2, new UncloseableOuputStream(socket.getOutputStream())});
                if (socket.isOutputShutdown()) {
                    bufferedWriter2 = null;
                } else {
                    bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    try {
                        bufferedWriter2.write("DONE\n");
                        bufferedWriter2.flush();
                    } catch (Exception e2) {
                        e = e2;
                        bufferedWriter = bufferedWriter2;
                        try {
                            Log.w("ViewServer", "Could not send command " + str + " with parameters " + str2, e);
                            if (bufferedWriter == null) {
                                try {
                                    bufferedWriter.close();
                                    z = false;
                                } catch (IOException e3) {
                                    z = false;
                                }
                            } else {
                                z = false;
                            }
                            return z;
                        } catch (Throwable th) {
                            e = th;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e4) {
                                }
                            }
                            throw e;
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            bufferedWriter.close();
                        }
                        throw e;
                    }
                }
                if (bufferedWriter2 != null) {
                    try {
                        bufferedWriter2.close();
                    } catch (IOException e5) {
                        z = false;
                    }
                }
                return z;
            } catch (Exception e6) {
                e = e6;
                Log.w("ViewServer", "Could not send command " + str + " with parameters " + str2, e);
                if (bufferedWriter == null) {
                    z = false;
                } else {
                    bufferedWriter.close();
                    z = false;
                }
                return z;
            }
        }

        private View m2256a(int i) {
            View view;
            if (i == -1) {
                this.f1666a.f1662g.readLock().lock();
                try {
                    view = this.f1666a.f1663h;
                    return view;
                } finally {
                    this.f1666a.f1662g.readLock().unlock();
                }
            } else {
                this.f1666a.f1662g.readLock().lock();
                try {
                    for (Entry entry : this.f1666a.f1661f.entrySet()) {
                        if (System.identityHashCode(entry.getKey()) == i) {
                            view = (View) entry.getKey();
                            return view;
                        }
                    }
                    this.f1666a.f1662g.readLock().unlock();
                    return null;
                } finally {
                    this.f1666a.f1662g.readLock().unlock();
                }
            }
        }

        private boolean m2257a(Socket socket) {
            BufferedWriter bufferedWriter;
            Throwable th;
            BufferedWriter bufferedWriter2 = null;
            try {
                this.f1666a.f1662g.readLock().lock();
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()), 8192);
                try {
                    for (Entry entry : this.f1666a.f1661f.entrySet()) {
                        bufferedWriter.write(Integer.toHexString(System.identityHashCode(entry.getKey())));
                        bufferedWriter.write(32);
                        bufferedWriter.append((CharSequence) entry.getValue());
                        bufferedWriter.write(10);
                    }
                    bufferedWriter.write("DONE.\n");
                    bufferedWriter.flush();
                    this.f1666a.f1662g.readLock().unlock();
                    try {
                        bufferedWriter.close();
                        return true;
                    } catch (IOException e) {
                        return false;
                    }
                } catch (Exception e2) {
                    bufferedWriter2 = bufferedWriter;
                    this.f1666a.f1662g.readLock().unlock();
                    if (bufferedWriter2 != null) {
                        return false;
                    }
                    try {
                        bufferedWriter2.close();
                        return false;
                    } catch (IOException e3) {
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    this.f1666a.f1662g.readLock().unlock();
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                this.f1666a.f1662g.readLock().unlock();
                if (bufferedWriter2 != null) {
                    return false;
                }
                bufferedWriter2.close();
                return false;
            } catch (Throwable th3) {
                bufferedWriter = null;
                th = th3;
                this.f1666a.f1662g.readLock().unlock();
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                throw th;
            }
        }

        public final void m2261a() {
            synchronized (this.f1670e) {
                this.f1668c = true;
                ObjectDetour.c(this.f1670e, -1988905348);
            }
        }

        public final void m2262b() {
            synchronized (this.f1670e) {
                this.f1669d = true;
                ObjectDetour.c(this.f1670e, -1419533675);
            }
        }

        private boolean m2260c() {
            Throwable e;
            ViewServer.m2235a(this.f1666a, this);
            BufferedWriter bufferedWriter;
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.f1667b.getOutputStream()));
                while (!Thread.interrupted()) {
                    try {
                        boolean z;
                        boolean z2;
                        synchronized (this.f1670e) {
                            while (!this.f1668c && !this.f1669d) {
                                ObjectDetour.a(this.f1670e, -694984168);
                            }
                            if (this.f1668c) {
                                this.f1668c = false;
                                z = true;
                            } else {
                                z = false;
                            }
                            if (this.f1669d) {
                                this.f1669d = false;
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                        }
                        if (z) {
                            bufferedWriter.write("LIST UPDATE\n");
                            bufferedWriter.flush();
                        }
                        if (z2) {
                            bufferedWriter.write("FOCUS UPDATE\n");
                            bufferedWriter.flush();
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                try {
                    bufferedWriter.close();
                } catch (IOException e3) {
                }
                ViewServer.m2236b(this.f1666a, this);
            } catch (Exception e4) {
                e = e4;
                bufferedWriter = null;
                try {
                    Log.w("ViewServer", "Connection error: ", e);
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e5) {
                        }
                    }
                    ViewServer.m2236b(this.f1666a, this);
                    return true;
                } catch (Throwable th) {
                    e = th;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e6) {
                        }
                    }
                    ViewServer.m2236b(this.f1666a, this);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                bufferedWriter = null;
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                ViewServer.m2236b(this.f1666a, this);
                throw e;
            }
            return true;
        }
    }

    public static ViewServer m2234a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (!"user".equals(Build.TYPE) || (applicationInfo.flags & 2) == 0) {
            f1655j = new NoopViewServer();
        } else {
            if (f1655j == null) {
                f1655j = new ViewServer(4939);
            }
            if (!f1655j.mo469b()) {
                try {
                    f1655j.mo466a();
                } catch (Throwable e) {
                    Log.d("ViewServer", "Error:", e);
                }
            }
        }
        return f1655j;
    }

    public ViewServer() {
        this.f1660e = new CopyOnWriteArrayList();
        this.f1661f = new HashMap();
        this.f1662g = new ReentrantReadWriteLock();
        this.f1664i = new ReentrantReadWriteLock();
        this.f1657b = -1;
    }

    private ViewServer(int i) {
        this.f1660e = new CopyOnWriteArrayList();
        this.f1661f = new HashMap();
        this.f1662g = new ReentrantReadWriteLock();
        this.f1664i = new ReentrantReadWriteLock();
        this.f1657b = i;
    }

    public boolean mo466a() {
        if (this.f1658c != null) {
            return false;
        }
        this.f1658c = ThreadInitDetour.a(this, "Local View Server [port=" + this.f1657b + "]", 520776172);
        this.f1659d = Executors.newFixedThreadPool(10);
        this.f1658c.start();
        return true;
    }

    public boolean mo469b() {
        return this.f1658c != null && this.f1658c.isAlive();
    }

    public void mo463a(Activity activity) {
        String str;
        Object charSequence = activity.getTitle().toString();
        if (TextUtils.isEmpty(charSequence)) {
            str = activity.getClass().getCanonicalName() + "/0x" + System.identityHashCode(activity);
        } else {
            str = charSequence + "(" + activity.getClass().getCanonicalName() + ")";
        }
        mo465a(activity.getWindow().getDecorView(), str);
    }

    public void mo467b(Activity activity) {
        mo464a(activity.getWindow().getDecorView());
    }

    public void mo465a(View view, String str) {
        this.f1662g.writeLock().lock();
        try {
            this.f1661f.put(view.getRootView(), str);
            m2238c();
        } finally {
            this.f1662g.writeLock().unlock();
        }
    }

    public void mo464a(View view) {
        this.f1662g.writeLock().lock();
        try {
            this.f1661f.remove(view.getRootView());
            m2238c();
        } finally {
            this.f1662g.writeLock().unlock();
        }
    }

    public void mo470c(Activity activity) {
        mo468b(activity.getWindow().getDecorView());
    }

    public void mo468b(View view) {
        this.f1664i.writeLock().lock();
        try {
            this.f1663h = view == null ? null : view.getRootView();
            m2239d();
        } finally {
            this.f1664i.writeLock().unlock();
        }
    }

    public void run() {
        try {
            this.f1656a = new ServerSocket(this.f1657b, 10, InetAddress.getLocalHost());
        } catch (Throwable e) {
            Log.w("ViewServer", "Starting ServerSocket error: ", e);
        }
        while (this.f1656a != null && Thread.currentThread() == this.f1658c) {
            try {
                Socket accept = this.f1656a.accept();
                if (this.f1659d != null) {
                    ExecutorDetour.a(this.f1659d, new ViewServerWorker(this, accept), -1311835567);
                } else {
                    try {
                        accept.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Throwable e3) {
                Log.w("ViewServer", "Connection error: ", e3);
            }
        }
    }

    public static boolean m2237b(Socket socket, String str) {
        BufferedWriter bufferedWriter;
        Throwable th;
        BufferedWriter bufferedWriter2 = null;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()), 8192);
            try {
                bufferedWriter.write(str);
                bufferedWriter.write("\n");
                bufferedWriter.flush();
                try {
                    bufferedWriter.close();
                    return true;
                } catch (IOException e) {
                    return false;
                }
            } catch (Exception e2) {
                bufferedWriter2 = bufferedWriter;
                if (bufferedWriter2 != null) {
                    return false;
                }
                try {
                    bufferedWriter2.close();
                    return false;
                } catch (IOException e3) {
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            if (bufferedWriter2 != null) {
                return false;
            }
            bufferedWriter2.close();
            return false;
        } catch (Throwable th3) {
            bufferedWriter = null;
            th = th3;
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            throw th;
        }
    }

    private void m2238c() {
        for (ViewServerWorker a : this.f1660e) {
            a.m2261a();
        }
    }

    private void m2239d() {
        for (ViewServerWorker b : this.f1660e) {
            b.m2262b();
        }
    }

    public static void m2235a(ViewServer viewServer, ViewServerWorker viewServerWorker) {
        if (!viewServer.f1660e.contains(viewServerWorker)) {
            viewServer.f1660e.add(viewServerWorker);
        }
    }

    public static void m2236b(ViewServer viewServer, ViewServerWorker viewServerWorker) {
        viewServer.f1660e.remove(viewServerWorker);
    }
}
