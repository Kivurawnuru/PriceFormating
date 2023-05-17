import java.io.BufferedReader;
import java.io.FileReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

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
        return -1;
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

    static String decimalFormat;
    public static String correctDecimalFormat(String shortcutOfCountryName) throws Exception {
        decimalFormat = "#";
        PriceFormator pf = new PriceFormator();

        if (pf.getCountriesMoneyFormat().get(pf.getIndexOfCountry(shortcutOfCountryName)).getDecimals() >= 1) {
            int wantedIndex = pf.getIndexOfCountry(shortcutOfCountryName);
            for (int i = 0; i < pf.countriesMoneyFormat.get(wantedIndex).getDecimals(); i++) {
                if(i == 0){
                    decimalFormat = decimalFormat + ".";
                }
                decimalFormat = decimalFormat + "#";
            }
            return decimalFormat;
        } else {
            return decimalFormat;
        }

    }

    public static String formatForCountry(double price, String shortcutOfCountryName) throws Exception {
        PriceFormator pf = new PriceFormator();

        decimalFormat = correctDecimalFormat(shortcutOfCountryName);
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat(decimalFormat,symbols);
        symbols.setGroupingSeparator(' ');
        df.setDecimalFormatSymbols(symbols);
        df.setGroupingSize(3);
        df.setGroupingUsed(true);

        int wantedIndex = pf.getIndexOfCountry(shortcutOfCountryName);

        if(price < 0){
            if (pf.getCountriesMoneyFormat().get(wantedIndex).getPosition() >= 1) {
                price = price * -1;
                String finalString = "-"+pf.getCountriesMoneyFormat().get(wantedIndex).getMoneySymbol() + df.format(price);
                return finalString;
            }
            if (pf.getCountriesMoneyFormat().get(wantedIndex).getPosition() == 0) {
                df.setRoundingMode(RoundingMode.DOWN);
                String finalString = df.format(price) +" "+ pf.getCountriesMoneyFormat().get(wantedIndex).getMoneySymbol();
                return finalString;
            }
        }

        if (pf.getCountriesMoneyFormat().get(wantedIndex).getPosition() >= 1) {
            String finalString = pf.getCountriesMoneyFormat().get(wantedIndex).getMoneySymbol() + df.format(price);
            return finalString;
        }
        if (pf.getCountriesMoneyFormat().get(wantedIndex).getPosition() == 0) {
            df.setRoundingMode(RoundingMode.DOWN);
            String finalString = df.format(price) +" "+ pf.getCountriesMoneyFormat().get(wantedIndex).getMoneySymbol();
            return finalString;
        }

//    public int getIndexVArrayL(int Id){
//
//    }
        return null;
    }


}
