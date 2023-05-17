import org.w3c.dom.ls.LSOutput;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {

    private static final DecimalFormat df = new DecimalFormat("###,###.##");

    public static void main(String[] args) throws Exception {

        PriceFormator countriesMoneyFormat = new PriceFormator();

        double number = 52123.1458;




        df.setRoundingMode(RoundingMode.UP);
        System.out.println(df.format(number));





//        for(int i  = 0; i < countriesMoneyFormat.getCountriesMoneyFormat().get(); i++){
//            Word = Word + "0";
//        }
//        return decForm;

    }




}