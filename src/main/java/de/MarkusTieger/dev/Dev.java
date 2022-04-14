package de.MarkusTieger.dev;

import de.MarkusTieger.Tigxa.*;
import de.MarkusTieger.Tigxa.api.IAPI;
import de.MarkusTieger.Tigxa.extension.IExtension;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Dev {

    public static void main(String[] args) throws Throwable {

        Class<?> clazz = Class.forName(args[0]);
        Constructor<?> constructor = clazz.getDeclaredConstructor(IAPI.class);

        Browser.setInjectedExtension((api) -> {

            try {
                Object obj = constructor.newInstance(api);
                return (IExtension) obj;
            } catch (Throwable e) {
                e.printStackTrace();
            }

            return null;

        });



        Bootstrap.main(new String[0]);

    }

}
