import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

public class PriceFormator {

    public static String formatForCountry(double price, String shortcutOfCountryName) throws Exception {
        CountryLoader countryLoader = new CountryLoader();

        DefinitionOfCountry wantedCountry = CountryLoader.getCountry(shortcutOfCountryName, countryLoader.countriesMoneyFormat);

        decimalFormat = correctDecimalFormat(wantedCountry);
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat(decimalFormat, symbols);
        symbols.setGroupingSeparator(' ');
        df.setDecimalFormatSymbols(symbols);
        df.setGroupingSize(3);
        df.setGroupingUsed(true);

        if (price < 0) {
            if (wantedCountry.getPosition() >= 1) {
                price = price * -1;
                String finalString = "-" + wantedCountry.getMoneySymbol() + df.format(price);
                return finalString;
            }
            if (wantedCountry.getPosition() == 0) {
                df.setRoundingMode(RoundingMode.DOWN);
                String finalString = df.format(price) + " " + wantedCountry.getMoneySymbol();
                return finalString;
            }
        }

        if (wantedCountry.getPosition() >= 1) {
            String finalString = wantedCountry.getMoneySymbol() + df.format(price);
            return finalString;
        }
        if (wantedCountry.getPosition() == 0) {
            df.setRoundingMode(RoundingMode.DOWN);
            String finalString = df.format(price) + " " + wantedCountry.getMoneySymbol();
            return finalString;
        }

        return null;
    }



    static String decimalFormat;

    private static String correctDecimalFormat(DefinitionOfCountry wantedCountry) throws Exception {
        decimalFormat = "#";

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
