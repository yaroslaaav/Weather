
import org.jsoup.nodes.Element;
import java.util.ArrayList;
import java.util.Scanner;


public class Parser {

    public static void addElements(ArrayList<Weather> weathers, Element characterWeather, String css, String attrWeather){
        int k=0;
        for (Element element:characterWeather.select(css)){
            if(k==32)
                break;
            String val=element.attr(attrWeather);
            val = val.substring(val.indexOf(">")+1, val.lastIndexOf("<"));
            //System.out.println(k+" "+k/4+" "+k%4);
            weathers.get(k/4).setWeatherItem(k%4,val);
            k++;
        }
    }

    public static void addElements(ArrayList<Weather> weathers, Element characterWeather, String css, int parameter){
        int k=0;
        for (Element element:characterWeather.select(css)){
            if(k==32)
                break;
            switch (parameter) {
                case 0:
                    weathers.get(k / 4).setTemperature(k%4, Integer.parseInt(element.text()));
                    break;
                case 1:
                    weathers.get(k / 4).setWind(k%4, Integer.parseInt(element.text()));
                    break;
                case 2:
                    String val =element.text();
                    if(val.equals("н/д"))
                        val="0,0";
                    weathers.get(k / 4).setPrecipitation(k%4, Double.parseDouble(val.replace(',','.')));
                    break;
            }
            k++;
        }
    }
    public static int chooseCity() {
        System.out.println("Выберите город:");
        System.out.println("1. Новокузнецк");
        System.out.println("2. Кемерово");
        System.out.println("3. Томск");
        System.out.println("4. Новосибирск");
        Scanner scanner=new Scanner(System.in);
        int choosenCity = 0;
        if (scanner.hasNextInt())
            choosenCity = scanner.nextInt();
        else {
            System.out.println("Вы ввели недоступный город!");
            System.exit(0);
        }
        if(choosenCity<1 || choosenCity>4) {
            System.out.println("Вы ввели недоступный город!");
            System.exit(0);
        }
        return choosenCity;
    }

    public static void main(String[] args) throws Exception {

        SitePage gismeteo=new SitePage(chooseCity());
        ArrayList<Weather> forecastWeather = new ArrayList<>();

        for (Element element : gismeteo.getDate().select("a[class=link blue]")) {
            Weather val= new Weather();
            val.setDate(element.text());
            forecastWeather.add(val);

        }

        addElements(forecastWeather, gismeteo.getWeatherItem(), "span[class=tooltip]","data-text");
        addElements(forecastWeather,gismeteo.getTemperatureByDay(),"span[class=unit unit_temperature_c]",0);
        addElements(forecastWeather,gismeteo.getWindSpeed(),"span[class=unit unit_wind_m_s]",1);
        addElements(forecastWeather,gismeteo.getPrecipitation(),"div[class=w_prec__value]",2);

        for (Weather val:forecastWeather){
            System.out.println(val.toString());
        }

    }
}