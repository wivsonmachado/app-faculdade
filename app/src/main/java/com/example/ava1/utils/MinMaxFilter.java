package com.example.ava1.utils;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;

public class MinMaxFilter implements InputFilter {
    private double mIntMin, mIntMax;

    public MinMaxFilter(double minValue, double maxValue) {
        this.mIntMin = minValue;
        this.mIntMax = maxValue;
    }

    public MinMaxFilter(String minValue, String maxValue) {
        this.mIntMin = Double.valueOf(minValue);
        this.mIntMax = Double.valueOf(maxValue);
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            String replacement = source.subSequence(start, end).toString();
            String newVal = dest.subSequence(0, dstart).toString() + replacement
                    + dest.subSequence(dend, dest.length()).toString();

            // check if there are leading zeros
            if (newVal.matches("0\\d+.*"))
                if (TextUtils.isEmpty(source))
                    return dest.subSequence(dstart, dend);
                else
                    return "";

            // check range
            double input = Double.parseDouble(newVal);
            if (!isInRange(mIntMin, mIntMax, input))
                if (TextUtils.isEmpty(source))
                    return dest.subSequence(dstart, dend);
                else
                    return "";

            return null;
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        return "";
    }

    private boolean isInRange(double a, double b, double c) {
        return b > a ? c >= a && c <= b : c >= b && c <= a;
    }
}
