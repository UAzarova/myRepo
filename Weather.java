package lesson8;

public class Weather {
    private String date;
    private Double temperatureMin;
    private Double temperatureMax;
    private String forecastDay;
    private String forecastNight;
    private String city;

    public Weather(String date, Double temperatureMin, Double temperatureMax, String forecastDay, String forecastNight) {
        this.date = date;
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
        this.forecastDay = forecastDay;
        this.forecastNight = forecastNight;
    }

    public String getDate() {
        return date;
    }

    public Double getTemperatureMin() {
        return temperatureMin;
    }

    public Double getTemperatureMax() {
        return temperatureMax;
    }

    public String getForecastDay() {
        return forecastDay;
    }

    public String getForecastNight() {
        return forecastNight;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) { this.city = city; }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTemperatureMin(Double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public void setTemperatureMax(Double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public void setForecastDay(String forecastDay) {
        this.forecastDay = forecastDay;
    }

    public void setForecastNight(String forecastNight) {
        this.forecastNight = forecastNight;
    }

    public Double getAverageTemperature(double temperatureMin, double temperatureMax) { return (temperatureMin + temperatureMax)/2; }

    @Override
    public String toString() {
        return "date = " + date + "\n" +
                "Min temperature = " + temperatureMin + "\n" +
                "Max temperature = " + temperatureMax + "\n" +
                "forecast for day = " + forecastDay + "\n" +
                "forecast for night = " + forecastNight + "\n\n";
    }
}
