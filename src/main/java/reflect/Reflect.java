package reflect;

import java.lang.reflect.Field;

/**
 * Created by wangminghui on 2017/3/7.
 */
public class Reflect {
    public static void main(String[] args) throws Exception {
        Model model = new Model();
        model.print();
        Class<?> clazz = Class.forName("reflect.Model");
        Field field = clazz.getDeclaredField("secret1");
        field.setAccessible(true);
        field.set(model,"newhaha");
        model.print();
        String name = clazz.getClassLoader().getClass().getName();
        System.out.println(name);
    }
}

class Model{
    private String secret = "haha";
    public void print() {
        System.out.println(secret);
    }
}
