public class Weather {
    private String date;
    private String[] timesOfDay={"Ночь", "Утро", "День", "Вечер"};
    private String[] weatherItem = new String[4];
    private int [] temperature = new int[4];
    private int [] wind = new int[4];
    private double [] precipitation = new double[4];


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimesOfDay() {
        StringBuilder builder= new StringBuilder();
        for (int i = 0; i < timesOfDay.length; i++) {
            builder.append(timesOfDay[i]);
            builder.append("\t\t");
        }
        builder.append("\n");
        return builder.toString();
    }

    public String getPrecipitation() {
        StringBuilder builder= new StringBuilder();
        for (int i = 0; i < precipitation.length; i++) {
            builder.append(precipitation[i]);
            builder.append("\t\t");
        }
        builder.append("\n");
        return builder.toString();
    }

    public void setPrecipitation(int index,double precipitation) {
        this.precipitation[index] = precipitation;
    }

    public String getWind() {
        StringBuilder builder= new StringBuilder();
        for (int i = 0; i < wind.length; i++) {
            builder.append(wind[i]+" м/с");
            builder.append("\t\t");
        }
        builder.append("\n");
        return builder.toString();
    }

    public void setWind(int index,int wind) {
        this.wind[index] = wind;
    }

    public String getTemperature() {
        StringBuilder builder= new StringBuilder();
        for (int i = 0; i < temperature.length; i++) {
            builder.append(temperature[i]);
            builder.append("\t\t");
        }
        builder.append("\n");
        return builder.toString();
    }

    public void setTemperature(int index,int temperature ) {
        this.temperature[index] = temperature;
    }

    public String getWeatherItem() {
        StringBuilder builder= new StringBuilder();
        for (int i = 0; i < weatherItem.length; i++) {
            builder.append(weatherItem[i]);
            builder.append("\t\t");
        }
        builder.append("\n");
        return builder.toString();
    }

    public void setWeatherItem(int index, String weatherItem) {
        this.weatherItem[index] = weatherItem;
    }
    private String getWeatherCharacter(){
        return "\n";
    }

    @Override
    public String toString() {
        StringBuilder val = new StringBuilder();
        val.append(getDate()+"\n");
        val.append(getTimesOfDay());
        val.append(getWeatherItem());
        val.append(getTemperature());
        val.append(getWind());
        val.append(getPrecipitation());

        return val.toString();
    }
}
