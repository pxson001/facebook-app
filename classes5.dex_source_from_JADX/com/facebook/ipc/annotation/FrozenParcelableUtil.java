package com.facebook.ipc.annotation;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Constructor;

/* compiled from: TOO_SHORT_AFTER_IDD */
public class FrozenParcelableUtil {
    public static void m23288a(Parcel parcel, int i, FrozenParcelable frozenParcelable) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(0);
        frozenParcelable.m23286a(parcel, i);
        int dataPosition2 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition2 - dataPosition);
        parcel.setDataPosition(dataPosition2);
    }

    public static <T extends Parcelable> T m23287a(Parcel parcel, Class<T> cls) {
        int dataPosition = parcel.dataPosition();
        int readInt = parcel.readInt();
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[]{Parcel.class});
            declaredConstructor.setAccessible(true);
            try {
                Parcelable parcelable = (Parcelable) declaredConstructor.newInstance(new Object[]{parcel});
                int dataPosition2 = parcel.dataPosition();
                if (dataPosition2 > dataPosition + readInt) {
                    throw new BadParcelableException(cls.getName() + " constructor read too far in Parcel, Parcel corrupted.");
                }
                if (dataPosition2 < dataPosition + readInt) {
                    parcel.setDataPosition(dataPosition + readInt);
                }
                return parcelable;
            } catch (Exception e) {
                throw new BadParcelableException(e);
            } catch (Exception e2) {
                throw new BadParcelableException(e2);
            } catch (Exception e22) {
                throw new BadParcelableException(e22);
            }
        } catch (Exception e222) {
            throw new BadParcelableException(e222);
        }
    }
}
