package android.os;

/* compiled from: best_effort_time_taken */
class IDeviceIdleController$Stub$Proxy implements IDeviceIdleController {
    private IBinder f7980a;

    IDeviceIdleController$Stub$Proxy(IBinder iBinder) {
        this.f7980a = iBinder;
    }

    public IBinder asBinder() {
        return this.f7980a;
    }

    public final void m14099a(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.os.IDeviceIdleController");
            obtain.writeString(str);
            this.f7980a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void m14103b(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.os.IDeviceIdleController");
            obtain.writeString(str);
            this.f7980a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final String[] m14101a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.os.IDeviceIdleController");
            this.f7980a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            String[] createStringArray = obtain2.createStringArray();
            return createStringArray;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final String[] m14104b() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.os.IDeviceIdleController");
            this.f7980a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            String[] createStringArray = obtain2.createStringArray();
            return createStringArray;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final String[] m14106c() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.os.IDeviceIdleController");
            this.f7980a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            String[] createStringArray = obtain2.createStringArray();
            return createStringArray;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final String[] m14108d() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.os.IDeviceIdleController");
            this.f7980a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
            String[] createStringArray = obtain2.createStringArray();
            return createStringArray;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final int[] m14110e() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.os.IDeviceIdleController");
            this.f7980a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            int[] createIntArray = obtain2.createIntArray();
            return createIntArray;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final int[] m14111f() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.os.IDeviceIdleController");
            this.f7980a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
            int[] createIntArray = obtain2.createIntArray();
            return createIntArray;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final int[] m14112g() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.os.IDeviceIdleController");
            this.f7980a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
            int[] createIntArray = obtain2.createIntArray();
            return createIntArray;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean m14105c(String str) {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.os.IDeviceIdleController");
            obtain.writeString(str);
            this.f7980a.transact(10, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean m14107d(String str) {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.os.IDeviceIdleController");
            obtain.writeString(str);
            this.f7980a.transact(11, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void m14100a(String str, long j, int i, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.os.IDeviceIdleController");
            obtain.writeString(str);
            obtain.writeLong(j);
            obtain.writeInt(i);
            obtain.writeString(str2);
            this.f7980a.transact(12, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final long m14098a(String str, int i, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.os.IDeviceIdleController");
            obtain.writeString(str);
            obtain.writeInt(i);
            obtain.writeString(str2);
            this.f7980a.transact(13, obtain, obtain2, 0);
            obtain2.readException();
            long readLong = obtain2.readLong();
            return readLong;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final long m14102b(String str, int i, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.os.IDeviceIdleController");
            obtain.writeString(str);
            obtain.writeInt(i);
            obtain.writeString(str2);
            this.f7980a.transact(14, obtain, obtain2, 0);
            obtain2.readException();
            long readLong = obtain2.readLong();
            return readLong;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void m14109e(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.os.IDeviceIdleController");
            obtain.writeString(str);
            this.f7980a.transact(15, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
