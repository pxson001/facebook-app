package android.support.v7.widget;

import android.support.v7.widget.AdapterHelper.UpdateOp;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.List;

/* compiled from: num_players= */
class OpReorderer {
    final Callback f11957a;

    /* compiled from: num_players= */
    interface Callback {
        UpdateOp mo2260a(int i, int i2, int i3, Object obj);

        void mo2261a(UpdateOp updateOp);
    }

    public OpReorderer(Callback callback) {
        this.f11957a = callback;
    }

    private void m17600a(List<UpdateOp> list, int i, int i2) {
        UpdateOp updateOp = (UpdateOp) list.get(i);
        UpdateOp updateOp2 = (UpdateOp) list.get(i2);
        switch (updateOp2.f18985a) {
            case 0:
                int i3 = 0;
                if (updateOp.f18988d < updateOp2.f18986b) {
                    i3 = -1;
                }
                if (updateOp.f18986b < updateOp2.f18986b) {
                    i3++;
                }
                if (updateOp2.f18986b <= updateOp.f18986b) {
                    updateOp.f18986b += updateOp2.f18988d;
                }
                if (updateOp2.f18986b <= updateOp.f18988d) {
                    updateOp.f18988d += updateOp2.f18988d;
                }
                updateOp2.f18986b = i3 + updateOp2.f18986b;
                list.set(i, updateOp2);
                list.set(i2, updateOp);
                return;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                m17601a(list, i, updateOp, i2, updateOp2);
                return;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                m17602c(list, i, updateOp, i2, updateOp2);
                return;
            default:
                return;
        }
    }

    private void m17601a(List<UpdateOp> list, int i, UpdateOp updateOp, int i2, UpdateOp updateOp2) {
        int i3;
        UpdateOp updateOp3;
        int i4 = 0;
        if (updateOp.f18986b < updateOp.f18988d) {
            i3 = (updateOp2.f18986b == updateOp.f18986b && updateOp2.f18988d == updateOp.f18988d - updateOp.f18986b) ? 1 : 0;
        } else if (updateOp2.f18986b == updateOp.f18988d + 1 && updateOp2.f18988d == updateOp.f18986b - updateOp.f18988d) {
            i4 = 1;
            i3 = 1;
        } else {
            i3 = 0;
            i4 = 1;
        }
        if (updateOp.f18988d < updateOp2.f18986b) {
            updateOp2.f18986b--;
        } else if (updateOp.f18988d < updateOp2.f18986b + updateOp2.f18988d) {
            updateOp2.f18988d--;
            updateOp.f18985a = 1;
            updateOp.f18988d = 1;
            if (updateOp2.f18988d == 0) {
                list.remove(i2);
                this.f11957a.mo2261a(updateOp2);
                return;
            }
            return;
        }
        if (updateOp.f18986b <= updateOp2.f18986b) {
            updateOp2.f18986b++;
            updateOp3 = null;
        } else if (updateOp.f18986b < updateOp2.f18986b + updateOp2.f18988d) {
            updateOp3 = this.f11957a.mo2260a(1, updateOp.f18986b + 1, (updateOp2.f18986b + updateOp2.f18988d) - updateOp.f18986b, null);
            updateOp2.f18988d = updateOp.f18986b - updateOp2.f18986b;
        } else {
            updateOp3 = null;
        }
        if (i3 != 0) {
            list.set(i, updateOp2);
            list.remove(i2);
            this.f11957a.mo2261a(updateOp);
            return;
        }
        if (i4 != 0) {
            if (updateOp3 != null) {
                if (updateOp.f18986b > updateOp3.f18986b) {
                    updateOp.f18986b -= updateOp3.f18988d;
                }
                if (updateOp.f18988d > updateOp3.f18986b) {
                    updateOp.f18988d -= updateOp3.f18988d;
                }
            }
            if (updateOp.f18986b > updateOp2.f18986b) {
                updateOp.f18986b -= updateOp2.f18988d;
            }
            if (updateOp.f18988d > updateOp2.f18986b) {
                updateOp.f18988d -= updateOp2.f18988d;
            }
        } else {
            if (updateOp3 != null) {
                if (updateOp.f18986b >= updateOp3.f18986b) {
                    updateOp.f18986b -= updateOp3.f18988d;
                }
                if (updateOp.f18988d >= updateOp3.f18986b) {
                    updateOp.f18988d -= updateOp3.f18988d;
                }
            }
            if (updateOp.f18986b >= updateOp2.f18986b) {
                updateOp.f18986b -= updateOp2.f18988d;
            }
            if (updateOp.f18988d >= updateOp2.f18986b) {
                updateOp.f18988d -= updateOp2.f18988d;
            }
        }
        list.set(i, updateOp2);
        if (updateOp.f18986b != updateOp.f18988d) {
            list.set(i2, updateOp);
        } else {
            list.remove(i2);
        }
        if (updateOp3 != null) {
            list.add(i, updateOp3);
        }
    }

    private void m17602c(List<UpdateOp> list, int i, UpdateOp updateOp, int i2, UpdateOp updateOp2) {
        Object obj;
        Object obj2 = null;
        if (updateOp.f18988d < updateOp2.f18986b) {
            updateOp2.f18986b--;
            obj = null;
        } else if (updateOp.f18988d < updateOp2.f18986b + updateOp2.f18988d) {
            updateOp2.f18988d--;
            obj = this.f11957a.mo2260a(2, updateOp.f18986b, 1, updateOp2.f18987c);
        } else {
            obj = null;
        }
        if (updateOp.f18986b <= updateOp2.f18986b) {
            updateOp2.f18986b++;
        } else if (updateOp.f18986b < updateOp2.f18986b + updateOp2.f18988d) {
            int i3 = (updateOp2.f18986b + updateOp2.f18988d) - updateOp.f18986b;
            obj2 = this.f11957a.mo2260a(2, updateOp.f18986b + 1, i3, updateOp2.f18987c);
            updateOp2.f18988d -= i3;
        }
        list.set(i2, updateOp);
        if (updateOp2.f18988d > 0) {
            list.set(i, updateOp2);
        } else {
            list.remove(i);
            this.f11957a.mo2261a(updateOp2);
        }
        if (obj != null) {
            list.add(i, obj);
        }
        if (obj2 != null) {
            list.add(i, obj2);
        }
    }

    final void m17603a(List<UpdateOp> list) {
        while (true) {
            int i;
            Object obj = null;
            int size = list.size() - 1;
            while (size >= 0) {
                Object obj2;
                if (((UpdateOp) list.get(size)).f18985a != 3) {
                    obj2 = 1;
                } else if (obj != null) {
                    i = size;
                    break;
                } else {
                    obj2 = obj;
                }
                size--;
                obj = obj2;
            }
            i = -1;
            int i2 = i;
            if (i2 != -1) {
                m17600a(list, i2, i2 + 1);
            } else {
                return;
            }
        }
    }
}
