# Price Formating Program

## Description

This program is able to formate different formats of prices for
different countries. It just load them from text file named 
"countries.txt". In this file you can add your own country, just
add order number, shortcuted name of country, money symbol, number
for  money symbol position(1 if it is before number or 0 if it is
after it) and count of numbers after decimal point.

| ORDER | NAME OF COUNTRY | SHORTCUT | Position | Decimals |     VAT |
|------:|----------------:|---------:|---------:|---------:|--------:|
|     1 |  Czech Republic |       CZ |        0 |        0 |     21% |
|     2 |        Slovakia |       SK |        0 |        2 |     20% |
|     3 |   United States |       US |        1 |        2 |      6% |
|     4 |        Hungaria |       HU |        0 |        3 |     27% |

Another function is calculation of VAT of specific country.

Example:

| Country shortcut | VAT | Price with VAT | Height of VAT | Price without VAT |
|-----------------:|----:|---------------:|--------------:|------------------:|
|               CZ | 21% |        2000 Kč |        420 Kč |           1580 Kč |
|               SK | 20% |         2000 € |         400 € |            1600 € |
|               US |  6% |          $2000 |          $120 |             $1880 |
|               HU | 27% |        2000 Ft |        540 Ft |           1462 Ft |

## Resources
Round up/down : https://www.educative.io/answers/how-to-use-the-java-mathround-method

https://mkyong.com/java/how-to-round-double-float-value-to-2-decimal-points-in-java/

Decimal separators : https://stackoverflow.com/questions/5323502/how-to-set-thousands-separator-in-java


