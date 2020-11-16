import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class SitePage {
    private Element weather;
    private Element date;
    private Element timesOfDay;
    private Element weatherItem;
    private Element temperatureByDay;
    private Element windSpeed;
    private Element precipitation;

    public SitePage(int city) throws IOException {
        this.weather=getPage(city).selectFirst("div.forecast_wrap");
        this.date=weather.selectFirst("div.clearfix");
        this.timesOfDay= weather.selectFirst("div[class=_line timeline nil clearfix]");
        this.weatherItem= weather.selectFirst("div[class=_line iconline clearfix]");
        this.temperatureByDay =weather.selectFirst("div[class=_line templine clearfix]");
        this.windSpeed=weather.selectFirst("div[class=_line windline js_wind clearfix]");
        this.precipitation= weather.selectFirst("div[class=widget__row widget__row_precipitation]");
    }
    private Document getPage(int city) throws IOException {
        String url;
        switch (city){
            case 1:
                url = "https://www.gismeteo.ru/weather-novokuznetsk-4721/3-days/#1-3-days";
                break;
            case 2:
                url = "https://www.gismeteo.ru/weather-kemerovo-4693/3-days/";
                break;
            case 3:
                url = "https://www.gismeteo.ru/weather-tomsk-4652/3-days/";
                break;
            case 4:
                url = "https://www.gismeteo.ru/weather-novosibirsk-4690/3-days/";

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + city);
        }
        Document page = Jsoup.connect(url)
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("http://www.google.com")
                .get();
        return page;

    }

    public Element getPrecipitation() {
        return precipitation;
    }

    public Element getWindSpeed() {
        return windSpeed;
    }

    public Element getTemperatureByDay() {
        return temperatureByDay;
    }

    public Element getWeatherItem() {
        return weatherItem;
    }

    public Element getTimesOfDay() {
        return timesOfDay;
    }

    public Element getDate() {
        return date;
    }

}

