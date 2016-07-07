package proxychallenge;

public enum InterceptValues {
    /** Написать "before" и после выполнить метод */    
    BEFORE, 
    /** Выполнить метод и после написать "after" */     
    AFTER,
    /** Написать "instead of" и не выполнять метод */   
    INSTEAD_OF,
    /** Выполнить метод */                              
    NONE,
}