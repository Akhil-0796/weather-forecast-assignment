package dice.example.weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item{
    public String date;
    public Date dateWithTimezone;
    public double freshSnow;
    public Object snowHeight;
    public Weather weather;
    public Prec prec;
    public int sunHours;
    public Object rainHours;
    public Temperature temperature;
    public Wind wind;
    public Windchill windchill;
    public SnowLine snowLine;
    public Astronomy astronomy;
    public double pressure;
    public double relativeHumidity;
}
