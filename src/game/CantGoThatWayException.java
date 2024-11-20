package game;

public class CantGoThatWayException extends RuntimeException{

    public CantGoThatWayException(String error){
        super(error);
    }
}/* to throw exception: 
    throw new CantGoThatWayException("wrong way" ) */
    /* you can catch and handle exceptions using a try-catch block
     * try {
     *    code that may trigger exception
     * }
     * catch(CantGoThatWayException ex){
     *     code that deals with exception
     * }
     */
    // This was put here in case it needs to be implemented later