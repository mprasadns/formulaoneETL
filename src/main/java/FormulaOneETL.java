import com.formulaone.formulaonedriveretl.FormulaOneDriverETL;

public class FormulaOneETL {

    public static void main(String[] args) {
        FormulaOneDriverETL formulaOneETL = new FormulaOneDriverETL();
        String fileLocation = "";
        int amountOfDriversToLoad = 0;
        if(args != null && args.length > 0) {
            fileLocation = args[0];
            if(args.length >= 2)
                amountOfDriversToLoad = Integer.parseInt(args[1]);
        }
        if(!formulaOneETL.loadFastestLapDrivers(fileLocation, amountOfDriversToLoad)) {
            System.out.println("Sorry unable to load file");
        }
        else {
            System.out.println("Thank you, file load complete");
        }
    }
}
