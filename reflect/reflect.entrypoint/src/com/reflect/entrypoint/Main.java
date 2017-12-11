package com.reflect.entrypoint;

import com.reflect.normal.Machine;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by hakan on 30/11/2017
 */
public class Main {

    public static void main(String[] args) throws Exception {

        // reflect.normal

        Field field = Machine.class.getField("name");
        Machine newInstance = Machine.class.getDeclaredConstructor().newInstance();
        field.set(newInstance, "Machine 9876");

        String value = (String) field.get(newInstance);
        System.out.println(value);

        Method declaredMethod = Machine.class.getDeclaredMethod("start");
        boolean result = (boolean) declaredMethod.invoke(newInstance);

        System.out.println(result);

        //reflect.deep

        Field model = Class.forName("com.reflect.deep.Gear").getDeclaredField("model");
        Object newInstanceOfGear = Class.forName("com.reflect.deep.Gear").getDeclaredConstructor().newInstance();

        model.trySetAccessible();
        model.set(newInstanceOfGear, 2017);
        System.out.println(model.get(newInstanceOfGear));

    }
}
