import com.github.difflib.algorithm.DiffAlgorithmFactory;
import com.github.difflib.algorithm.myers.MeyersDiff;

public class Api1 {

    public static DiffAlgorithmFactory test() {
        try {
            Class.forName("Api1Impl");
            System.out.println("OK");
        } catch (Exception ex) {
            System.err.println(ex);
        }
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("OK");
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return MeyersDiff.factory();
    }
}
