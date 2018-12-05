package com.example.google.androidalertdialogboxes;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;

public class Utils {



    public static void darkenStatusBar(Activity activity, int color){

        // Just to change the statusBar color programmatically
        activity.getWindow().setStatusBarColor(darkenColor(ContextCompat.getColor(activity,color)));


    }


    public static int darkenColor(int color){
        // this method only returns the darken color of int color

        float[] hsv = new float[3];
        Color.colorToHSV(color,hsv);
        hsv[2] *= 0.8f;
        return Color.HSVToColor(hsv);
    }




}
