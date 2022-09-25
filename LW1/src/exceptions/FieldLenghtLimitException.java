package exceptions;

public class FieldLenghtLimitException extends Exception{
    public FieldLenghtLimitException(){

    }

    public FieldLenghtLimitException(String msg){
        super(msg);
    }
}
