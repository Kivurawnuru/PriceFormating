import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class PriceFormator {

    public static String formatForCountry(double price, String shortcutOfCountryName) throws Exception {
        CountryLoader countryLoader = new CountryLoader();

        DefinitionOfCountry wantedCountry = countryLoader.getCountry(shortcutOfCountryName);

        DecimalFormat df = getDecimalFormat(wantedCountry);

        boolean isNegative = price < 0;
        price = Math.abs(price);
        String finalString = "";

        if (wantedCountry.getPosition() >= 1) {
            finalString = wantedCountry.getMoneySymbol() + df.format(price);
        }
        if (wantedCountry.getPosition() == 0) {
            finalString = df.format(price) + " " + wantedCountry.getMoneySymbol();
        }

        if(isNegative){
            return "-" + finalString;
        }
        else {
            return finalString;
        }
    }

    private static DecimalFormat getDecimalFormat(DefinitionOfCountry wantedCountry) throws Exception {
        String decimalFormat = getDecimalPattern(wantedCountry);
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat(decimalFormat, symbols);
        symbols.setGroupingSeparator(' ');
        df.setDecimalFormatSymbols(symbols);
        df.setGroupingSize(3);
        df.setRoundingMode(RoundingMode.DOWN);
        df.setGroupingUsed(true);
        return df;
    }


    private static String getDecimalPattern(DefinitionOfCountry wantedCountry) throws Exception {
        String decimalFormat = "#";

        if (wantedCountry.getDecimals() >= 1) {
            for (int i = 0; i < wantedCountry.getDecimals(); i++) {
                if (i == 0) {
                    decimalFormat = decimalFormat + ".";
                }
                decimalFormat = decimalFormat + "#";
            }
            return decimalFormat;
        } else {
            return decimalFormat;
        }

    }


}
