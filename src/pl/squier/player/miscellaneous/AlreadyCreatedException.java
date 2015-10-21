package pl.squier.player.miscellaneous;

/**
 * Created by SQUIER
 * on 2015-10-21.
 */
public class AlreadyCreatedException extends Exception {

    public AlreadyCreatedException() {
        System.out.println("Object of this class was already created, you cannot initialize another one of this type!");
    }

}
