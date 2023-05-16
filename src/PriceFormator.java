import java.io.BufferedReader;
import java.io.FileReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class PriceFormator {

    ArrayList<DefinitionOfCountry> countriesMoneyFormat = new ArrayList<>();

    public PriceFormator() throws Exception {
        countriesMoneyFormat = PriceFormator.load("countries.txt");
    }

    public ArrayList<DefinitionOfCountry> getCountriesMoneyFormat() {
        return countriesMoneyFormat;
    }


    public int getIndexOfCountry(String shortcutOfCountryName) throws Exception {
        for (int i = 0; i < countriesMoneyFormat.size(); i++) {
            if ((countriesMoneyFormat.get(i).getName()).matches(shortcutOfCountryName)) {
                return i;
            }
        }
        return 0;
    }

    public static ArrayList<DefinitionOfCountry> load(String nameOfFile) throws Exception {
        ArrayList<DefinitionOfCountry> result = new ArrayList<DefinitionOfCountry>();
        try (BufferedReader br = new BufferedReader(new FileReader(nameOfFile))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                DefinitionOfCountry dofc = DefinitionOfCountry.zCsv(line);
                result.add(dofc);
            }
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    String decimalFormat = "0.";
    public String correctDecimalFormat(String shortcutOfCountryName) throws Exception {
        PriceFormator pf = new PriceFormator();
        int wantedIndex = pf.getIndexOfCountry(shortcutOfCountryName);
        for(int i = 0; i < countriesMoneyFormat.get(wantedIndex).getDecimals(); i++){
            decimalFormat = decimalFormat + "0";
        }
        return decimalFormat;
    }
    private static final DecimalFormat df = new DecimalFormat();

    public static String formatForCountry(double price, String shortcutOfCountryName,DecimalFormat ) throws Exception {
        PriceFormator pf = new PriceFormator();
        DecimalFormat df = new DecimalFormat(decimalFormat);

        df.setRoundingMode(RoundingMode.UP);
        System.out.println(df.format(number));

        int wantedIndex = pf.getIndexOfCountry(shortcutOfCountryName);
        if (pf.getCountriesMoneyFormat().get(wantedIndex).getPosition() == 1) {
            String finalString = pf.getCountriesMoneyFormat().get(wantedIndex).getMoneySymbol() + price;
            return finalString;
        }
        if(pf.getCountriesMoneyFormat().get(wantedIndex).getPosition() == 0){
            String finalString = price + pf.getCountriesMoneyFormat().get(wantedIndex).getMoneySymbol();
            return finalString;
        }

//    public int getIndexVArrayL(int Id){
//
//    }
        return null;
    }


}
