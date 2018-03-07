package android.os;

/* compiled from: fragment */
public interface IDeviceIdleController extends IInterface {

    /* compiled from: fragment */
    public abstract class Stub extends Binder implements IDeviceIdleController {
        public static IDeviceIdleController m31579a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.os.IDeviceIdleController");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IDeviceIdleController)) {
                return new Proxy(iBinder);
            }
            return (IDeviceIdleController) queryLocalInterface;
        }
    }

    long m31580a(String str, int i, String str2);

    void m31581a(String str);

    void m31582a(String str, long j, int i, String str2);

    String[] m31583a();

    long m31584b(String str, int i, String str2);

    void m31585b(String str);

    String[] m31586b();

    boolean m31587c(String str);

    String[] m31588c();

    boolean m31589d(String str);

    String[] m31590d();

    void m31591e(String str);

    int[] m31592e();

    int[] m31593f();

    int[] m31594g();
}
