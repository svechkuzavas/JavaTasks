package task2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class BeanUtils {

    /**
     * Scans object [from] for all getters. If object [to]
     * contains correspondent setter, it will invoke it
     * to set property value for [to] which equals to the property
     * of [from]
     *
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Campatible means that parameter type in setter should be the
     * same or be superclass of the return type of the getter
     *
     * The method takes care only about public methods
     *
     * @param to Object which properties will be set
     * @param from Object which properties will be used to get values
     */
    public static void assign(Object to, Object from) {
        // получение публичных методов полученных объектов
        Method[] fromPublicMethods = from.getClass().getMethods();
        Method[] toPublicMethods = to.getClass().getMethods();

        // создание списков геттеров и сеттеров
        List<Method> getterList = new ArrayList<>();
        List<Method> setterList = new ArrayList<>();

        // поиск геттеров у объекта from, которые что-то возвращают и не имеют входных параметров
        for (Method method : fromPublicMethods) {
            if ((method.getName().startsWith("get")) && (method.getParameterTypes().length == 0) && (!void.class.equals(method.getReturnType()))) {
                getterList.add(method);
            }
        }

        // поиск сеттеров у объекта to, которые принимают на вход строго 1 аргумент
        for (Method method : toPublicMethods) {
            if ((method.getName().startsWith("set")) && (method.getParameterTypes().length == 1)) {
                setterList.add(method);
            }
        }

        for (Method method : getterList) {
            String fieldName = method.getName().substring(3); // извлекаем имя метода геттера без префикса get
            for (Method method1 : setterList) {
                // ищем подходящий сеттер
                if (method1.getName().substring(3).equals(fieldName)) {
                    try {
                        // пытаемся вызвать сеттер
                        method1.invoke(to, method.invoke(from));
                    } catch (IllegalAccessException e) { // обработка ошибок
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
