package proxychallenge;

public interface BaseInterface {
    public void method_1();
    
    @Intercept(InterceptValues.BEFORE)
    public void method_2();
    
    @Intercept(InterceptValues.AFTER)
    public void method_3();
    
    @Intercept(InterceptValues.INSTEAD_OF)
    public void method_4();
    
    @Intercept(InterceptValues.NONE)
    public void method_5();
}