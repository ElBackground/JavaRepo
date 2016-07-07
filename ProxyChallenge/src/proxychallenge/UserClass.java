package proxychallenge;

import java.net.InterfaceAddress;

public class UserClass {

    public static void main(String[] args) {

        /*
        Задание: пройтись по всем методам класса и в зависимости от значения аннотации что-то сделать:      
        */
        BaseInterface base = (BaseInterface) BaseProxy.newInstance(new BaseClass(), BaseInterface.class);
        
        System.out.println("User ->");
        base.method_1();
        System.out.println("\n");
        
        System.out.println("User ->");
        base.method_2();
        System.out.println("\n");
        
        System.out.println("User ->");
        base.method_3();
        System.out.println("\n");
        
        System.out.println("User ->");
        base.method_4();
        System.out.println("\n");
        
        System.out.println("User ->");
        base.method_5();
        System.out.println("\n");
        
    }

}
