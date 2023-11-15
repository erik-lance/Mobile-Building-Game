package com.mobdeve.s13.tiongquico.erik.exercise4processmanagement;

public class StructureHelper {

    public static Structures getEnumAt(int position) {
        return Structures.values()[position];
    }

    /**
     * Returns the appropriate House drawable
     * based on the passed Structures parameter.
     * @param structure
     * @return
     */
    public static Integer getHouse(Structures structure) {
        switch (structure) {
            case PIGMAN:
                return getPigmanHouse();
            case MERMAN:
                return getMermanHouse();
            case MUSHROOM:
                return getMushroomMuseum();
            case DAPPER:
                return getDapperHouse();
            case TOTALLY_NORMAL:
                return getTotallyNormalHouse();
            default:
                return null;
        }
    }

    /**
     * Returns the appropriate House description (a.k.a its name)
     * based on the passed Structures parameter.
     * @param structure
     * @return
     */
    public static String getDescription(Structures structure) {
        switch (structure) {
            case PIGMAN:
                return "x1 Pigman House";
            case MERMAN:
                return "x1 Merman House";
            case MUSHROOM:
                return "x1 Mushroom Museum";
            case DAPPER:
                return "x1 Dapper House";
            case TOTALLY_NORMAL:
                return "x1 Totally Normal House";
            default:
                return "";
        }
    }



    /* * * * * * * * * * * * * * * * * * *
     *  EVERYTHING BELOW ARE STUFF YOU   *
     *  DON'T HAVE TO BE CONCERNED WITH! *
     * * * * * * * * * * * * * * * * * * */

    public static Integer getColor(Structures structure) {
        switch (structure) {
            case PIGMAN:
                return getPigmanPink();
            case MERMAN:
                return getMermanGreen();
            case MUSHROOM:
                return getMushroomRed();
            case DAPPER:
                return getDapperYellow();
            case TOTALLY_NORMAL:
                return getTotallyNormalOrange();
            default:
                return null;
        }
    }

    public static Integer getProgressColor(Structures structure) {
        switch (structure) {
            case PIGMAN:
                return getProgressPigmanPink();
            case MERMAN:
                return getProgressMermanGreen();
            case MUSHROOM:
                return getProgressMushroomRed();
            case DAPPER:
                return getProgressDapperYellow();
            case TOTALLY_NORMAL:
                return getProgressTotallyNormalOrange();
            default:
                return null;
        }
    }

    public static Integer getBackground(Structures structure) {
        switch (structure) {
            case PIGMAN:
                return getRoundedPigmanPink();
            case MERMAN:
                return getRoundedMermanGreen();
            case MUSHROOM:
                return getRoundedMushroomRed();
            case DAPPER:
                return getRoundedDapperYellow();
            case TOTALLY_NORMAL:
                return getRoundedTotallyNormalOrange();
            default:
                return null;
        }
    }

    public static Integer getBackgroundTint(Structures structure) {
        switch (structure) {
            case PIGMAN:
                return getUltraTransPigmanPink();
            case MERMAN:
                return getUltraTransMermanGreen();
            case MUSHROOM:
                return getUltraTransMushroomRed();
            case DAPPER:
                return getUltraTransDapperYellow();
            case TOTALLY_NORMAL:
                return getUltraTransTotallyNormalOrange();
            default:
                return null;
        }
    }

    private static int getPigmanHouse() {
        return R.drawable.klei___pigman_house;
    }

    private static int getMermanHouse() {
        return R.drawable.klei___merman_house;
    }

    private static int getMushroomMuseum() {
        return R.drawable.klei___mushroom_museum;
    }

    private static int getDapperHouse() {
        return R.drawable.klei___dapper_house;
    }

    private static int getTotallyNormalHouse() {
        return R.drawable.klei___totally_normal_house;
    }


    private static int getPigmanPink() {
        return R.color.pigman_pink;
    }

    private static int getMermanGreen() {
        return R.color.merman_green;
    }

    private static int getMushroomRed() {
        return R.color.mushroom_red;
    }

    private static int getDapperYellow() {
        return R.color.dapper_yellow;
    }

    private static int getTotallyNormalOrange() {
        return R.color.totally_normal_orange;
    }


    private static int getTransPigmanPink() {
        return R.color.trans_pigman_pink;
    }

    private static int getTransMermanGreen() {
        return R.color.trans_merman_green;
    }

    private static int getTransMushroomRed() {
        return R.color.trans_mushroom_red;
    }

    private static int getTransDapperYellow() {
        return R.color.trans_dapper_yellow;
    }

    private static int getTransTotallyNormalOrange() { return R.color.trans_totally_normal_orange; }


    private static int getUltraTransPigmanPink() {
        return R.color.ultra_trans_pigman_pink;
    }

    private static int getUltraTransMermanGreen() {
        return R.color.ultra_trans_merman_green;
    }

    private static int getUltraTransMushroomRed() {
        return R.color.ultra_trans_mushroom_red;
    }

    private static int getUltraTransDapperYellow() {
        return R.color.ultra_trans_dapper_yellow;
    }

    private static int getUltraTransTotallyNormalOrange() { return R.color.ultra_trans_totally_normal_orange; }


    private static int getProgressPigmanPink() {
        return R.color.progress_pigman_pink;
    }

    private static int getProgressMermanGreen() {
        return R.color.progress_merman_green;
    }

    private static int getProgressMushroomRed() {
        return R.color.progress_mushroom_red;
    }

    private static int getProgressDapperYellow() {
        return R.color.progress_dapper_yellow;
    }

    private static int getProgressTotallyNormalOrange() { return R.color.progress_totally_normal_orange; }


    private static int getRoundedPigmanPink() {
        return R.drawable.rounded_pigman_pink;
    }

    private static int getRoundedMermanGreen() {
        return R.drawable.rounded_merman_green;
    }

    private static int getRoundedMushroomRed() {
        return R.drawable.rounded_mushroom_red;
    }

    private static int getRoundedDapperYellow() {
        return R.drawable.rounded_dapper_yellow;
    }

    private static int getRoundedTotallyNormalOrange() { return R.drawable.rounded_totally_normal_orange; }
}

