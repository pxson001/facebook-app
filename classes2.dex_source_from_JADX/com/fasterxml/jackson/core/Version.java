package com.fasterxml.jackson.core;

import java.io.Serializable;

/* compiled from: square_profile_pic_size_small */
public class Version implements Serializable, Comparable<Version> {
    public static final Version f4188a = new Version(0, 0, 0, null, null, null);
    private static final long serialVersionUID = 1;
    protected final String _artifactId;
    protected final String _groupId;
    protected final int _majorVersion;
    protected final int _minorVersion;
    protected final int _patchLevel;
    protected final String _snapshotInfo;

    public int compareTo(Object obj) {
        Version version = (Version) obj;
        if (version == this) {
            return 0;
        }
        int compareTo = this._groupId.compareTo(version._groupId);
        if (compareTo != 0) {
            return compareTo;
        }
        compareTo = this._artifactId.compareTo(version._artifactId);
        if (compareTo != 0) {
            return compareTo;
        }
        compareTo = this._majorVersion - version._majorVersion;
        if (compareTo != 0) {
            return compareTo;
        }
        compareTo = this._minorVersion - version._minorVersion;
        if (compareTo == 0) {
            return this._patchLevel - version._patchLevel;
        }
        return compareTo;
    }

    public Version(int i, int i2, int i3, String str, String str2, String str3) {
        this._majorVersion = i;
        this._minorVersion = i2;
        this._patchLevel = i3;
        this._snapshotInfo = str;
        if (str2 == null) {
            str2 = "";
        }
        this._groupId = str2;
        if (str3 == null) {
            str3 = "";
        }
        this._artifactId = str3;
    }

    public static Version m7747a() {
        return f4188a;
    }

    private boolean m7748b() {
        return this._snapshotInfo != null && this._snapshotInfo.length() > 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this._majorVersion).append('.');
        stringBuilder.append(this._minorVersion).append('.');
        stringBuilder.append(this._patchLevel);
        if (m7748b()) {
            stringBuilder.append('-').append(this._snapshotInfo);
        }
        return stringBuilder.toString();
    }

    public int hashCode() {
        return this._artifactId.hashCode() ^ (((this._groupId.hashCode() + this._majorVersion) - this._minorVersion) + this._patchLevel);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Version version = (Version) obj;
        if (version._majorVersion == this._majorVersion && version._minorVersion == this._minorVersion && version._patchLevel == this._patchLevel && version._artifactId.equals(this._artifactId) && version._groupId.equals(this._groupId)) {
            return true;
        }
        return false;
    }
}
