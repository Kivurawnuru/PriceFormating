import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PriceFormatorTest {

    @Test
    void PriceFormatForCountryCZ(){
        assertEquals("200 Kč",PriceFormator.formatForCountry(200,"CZ"));
    }
    @Test
    void PriceFormatForCountrySK(){
        assertEquals("200 €",PriceFormator.formatForCountry(200,"SK"));
    }
    @Test
    void PriceFormatForCountryUS(){
        assertEquals("$200",PriceFormator.formatForCountry(200,"US"));
    }

    @Test
    void PriceFormatForCountryCZDec(){
        assertEquals("200 Kč",PriceFormator.formatForCountry(200.1234,"CZ"));
    }
    @Test
    void PriceFormatForCountrySKDec(){
        assertEquals("200.12 €",PriceFormator.formatForCountry(200.1234,"SK"));
    }
    @Test
    void PriceFormatForCountryUSDec(){
        assertEquals("$200.12",PriceFormator.formatForCountry(200.1234,"US"));
    }
    @Test
    void PriceFormatForCountryCZDecNeg(){
        assertEquals("-200 Kč",PriceFormator.formatForCountry(-200.1234,"CZ"));
    }
    @Test
    void PriceFormatForCountrySKDecNeg(){
        assertEquals("-200.12 €",PriceFormator.formatForCountry(-200.1234,"SK"));
    }
    @Test
    void PriceFormatForCountryUSDecNeg(){
        assertEquals("-$200.12",PriceFormator.formatForCountry(-200.1234,"US"));
    }
    @Test
    void PriceFormatForCountryCZDecThousands(){
        assertEquals("200 000 Kč",PriceFormator.formatForCountry(200000.1234,"CZ"));
    }
    @Test
    void PriceFormatForCountrySKDecThousands(){
        assertEquals("200 000.12 €",PriceFormator.formatForCountry(200000.1234,"SK"));
    }
    @Test
    void PriceFormatForCountryUSDecThousands(){
        assertEquals("$200 000.12",PriceFormator.formatForCountry(200000.1234,"US"));
    }
    @Test
    void PriceFormatForCountryCZDecThousandsNeg(){
        assertEquals("-200 000 Kč",PriceFormator.formatForCountry(-200000.1234,"CZ"));
    }
    @Test
    void PriceFormatForCountrySKDecThousandsNeg(){
        assertEquals("-200 000.12 €",PriceFormator.formatForCountry(-200000.1234,"SK"));
    }
    @Test
    void PriceFormatForCountryUSDecThousandsNeg(){
        assertEquals("-$200 000.12",PriceFormator.formatForCountry(-200000.1234,"US"));
    }
    @Test
     void InvalidCountryShortCut(){
        Throwable exception = assertThrows(java.lang.Exception.class, () -> PriceFormator.formatForCountry(-200000.1234,"XX"));
        assertEquals("message e", exception.getMessage());
    }
}
