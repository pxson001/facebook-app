package com.facebook.phonenumbers;

import java.io.Serializable;

/* compiled from: datetaken */
public final class Phonenumber {

    /* compiled from: datetaken */
    public class PhoneNumber implements Serializable {
        public CountryCodeSource countryCodeSource_ = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
        public int countryCode_ = 0;
        public String extension_ = "";
        public boolean hasCountryCode;
        public boolean hasCountryCodeSource;
        public boolean hasExtension;
        public boolean hasItalianLeadingZero;
        public boolean hasNationalNumber;
        public boolean hasNumberOfLeadingZeros;
        public boolean hasPreferredDomesticCarrierCode;
        public boolean hasRawInput;
        public boolean italianLeadingZero_ = false;
        public long nationalNumber_ = 0;
        public int numberOfLeadingZeros_ = 1;
        public String preferredDomesticCarrierCode_ = "";
        public String rawInput_ = "";

        /* compiled from: datetaken */
        public enum CountryCodeSource {
            FROM_NUMBER_WITH_PLUS_SIGN,
            FROM_NUMBER_WITH_IDD,
            FROM_NUMBER_WITHOUT_PLUS_SIGN,
            FROM_DEFAULT_COUNTRY
        }

        public int getCountryCode() {
            return this.countryCode_;
        }

        public PhoneNumber setCountryCode(int i) {
            this.hasCountryCode = true;
            this.countryCode_ = i;
            return this;
        }

        public long getNationalNumber() {
            return this.nationalNumber_;
        }

        public PhoneNumber setNationalNumber(long j) {
            this.hasNationalNumber = true;
            this.nationalNumber_ = j;
            return this;
        }

        public PhoneNumber setExtension(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.hasExtension = true;
            this.extension_ = str;
            return this;
        }

        public PhoneNumber setItalianLeadingZero(boolean z) {
            this.hasItalianLeadingZero = true;
            this.italianLeadingZero_ = z;
            return this;
        }

        public PhoneNumber setNumberOfLeadingZeros(int i) {
            this.hasNumberOfLeadingZeros = true;
            this.numberOfLeadingZeros_ = i;
            return this;
        }

        public PhoneNumber setRawInput(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.hasRawInput = true;
            this.rawInput_ = str;
            return this;
        }

        public PhoneNumber setCountryCodeSource(CountryCodeSource countryCodeSource) {
            if (countryCodeSource == null) {
                throw new NullPointerException();
            }
            this.hasCountryCodeSource = true;
            this.countryCodeSource_ = countryCodeSource;
            return this;
        }

        public PhoneNumber clearCountryCodeSource() {
            this.hasCountryCodeSource = false;
            this.countryCodeSource_ = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
            return this;
        }

        public PhoneNumber setPreferredDomesticCarrierCode(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.hasPreferredDomesticCarrierCode = true;
            this.preferredDomesticCarrierCode_ = str;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj instanceof PhoneNumber) {
                PhoneNumber phoneNumber = (PhoneNumber) obj;
                Object obj2 = null;
                if (phoneNumber != null) {
                    int i;
                    if (this == phoneNumber) {
                        i = 1;
                    } else if (this.countryCode_ == phoneNumber.countryCode_ && this.nationalNumber_ == phoneNumber.nationalNumber_ && this.extension_.equals(phoneNumber.extension_) && this.italianLeadingZero_ == phoneNumber.italianLeadingZero_ && this.numberOfLeadingZeros_ == phoneNumber.numberOfLeadingZeros_ && this.rawInput_.equals(phoneNumber.rawInput_) && this.countryCodeSource_ == phoneNumber.countryCodeSource_ && this.preferredDomesticCarrierCode_.equals(phoneNumber.preferredDomesticCarrierCode_) && this.hasPreferredDomesticCarrierCode == phoneNumber.hasPreferredDomesticCarrierCode) {
                        i = 1;
                    }
                }
                if (obj2 != null) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2 = 1231;
            int hashCode = (((((this.countryCode_ + 2173) * 53) + Long.valueOf(this.nationalNumber_).hashCode()) * 53) + this.extension_.hashCode()) * 53;
            if (this.italianLeadingZero_) {
                i = 1231;
            } else {
                i = 1237;
            }
            i = (((((((((i + hashCode) * 53) + this.numberOfLeadingZeros_) * 53) + this.rawInput_.hashCode()) * 53) + this.countryCodeSource_.hashCode()) * 53) + this.preferredDomesticCarrierCode_.hashCode()) * 53;
            if (!this.hasPreferredDomesticCarrierCode) {
                i2 = 1237;
            }
            return i + i2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Country Code: ").append(this.countryCode_);
            stringBuilder.append(" National Number: ").append(this.nationalNumber_);
            if (this.hasItalianLeadingZero && this.italianLeadingZero_) {
                stringBuilder.append(" Leading Zero(s): true");
            }
            if (this.hasNumberOfLeadingZeros) {
                stringBuilder.append(" Number of leading zeros: ").append(this.numberOfLeadingZeros_);
            }
            if (this.hasExtension) {
                stringBuilder.append(" Extension: ").append(this.extension_);
            }
            if (this.hasCountryCodeSource) {
                stringBuilder.append(" Country Code Source: ").append(this.countryCodeSource_);
            }
            if (this.hasPreferredDomesticCarrierCode) {
                stringBuilder.append(" Preferred Domestic Carrier Code: ").append(this.preferredDomesticCarrierCode_);
            }
            return stringBuilder.toString();
        }
    }

    private Phonenumber() {
    }
}
