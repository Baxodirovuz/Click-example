package idea.DataBase.injection;

import java.util.Random;

/**
 * @author Jaloliddin Baxodirov
 * @Time 2022-06-6/8/2022-7:24 PM-58
 * @Project Lombok-Example
 */
public interface PlasticNumberRandom {
    Long returnNuber(long aStart, long aEnd, Random aRandom);
    Long generalReflector();
}
