package com.facebook.ipc.pages;

import com.google.common.collect.ImmutableList;
import java.util.BitSet;
import java.util.List;

/* compiled from: place_report_claimed_closed */
public class ProfilePermissions {
    public static final List<Permission> f6187a = ImmutableList.copyOf(Permission.values());
    private BitSet f6188b;

    /* compiled from: place_report_claimed_closed */
    public enum Permission {
        ADMINISTER(0),
        EDIT_PROFILE(1),
        CREATE_CONTENT(2),
        MODERATE_CONTENT(3),
        CREATE_ADS(4),
        BASIC_ADMIN(5);
        
        private int mPermissionBit;

        private Permission(int i) {
            this.mPermissionBit = i;
        }

        public final int getBit() {
            return this.mPermissionBit;
        }
    }

    public ProfilePermissions() {
        this.f6188b = new BitSet(Permission.values().length);
    }

    public ProfilePermissions(List<String> list) {
        this();
        for (String valueOf : list) {
            try {
                this.f6188b.set(Permission.valueOf(valueOf).getBit());
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public final boolean m8063a(Permission permission) {
        return this.f6188b.get(permission.getBit());
    }

    public static boolean m8061a(ImmutableList<String> immutableList) {
        return new ProfilePermissions(immutableList).m8063a(Permission.BASIC_ADMIN);
    }

    public static boolean m8062b(ImmutableList<String> immutableList) {
        return new ProfilePermissions(immutableList).m8063a(Permission.CREATE_CONTENT);
    }
}
